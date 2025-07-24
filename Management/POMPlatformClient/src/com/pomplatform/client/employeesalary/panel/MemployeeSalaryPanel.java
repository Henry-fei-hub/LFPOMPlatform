package com.pomplatform.client.employeesalary.panel;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.UploadEmpSalary;
import com.pomplatform.client.employeesalary.datasource.DSMemployeeSalary;
import com.pomplatform.client.employeesalary.form.MemployeeSalarySearchForm;
import com.pomplatform.client.employeesalary.form.MemployeeSalaryViewer;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.util.ValueCallback;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class MemployeeSalaryPanel extends AbstractSearchPanel {

    private static final Logger __logger = Logger.getLogger("");
    private DynamicForm __infoForm;
    private TextItem totalItem;

    public static class Factory implements PanelFactory {

        private String id;

        @Override
        public Canvas create() {
            MemployeeSalaryPanel cm = new MemployeeSalaryPanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "MemployeeSalary";
        }
    }

    private String keyValue;

    /**
     * @return the keyValue
     */
    public String getKeyValue() {
        return keyValue;
    }

    /**
     * @param keyValue the keyValue to set
     */
    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }

    @Override
    public void initComponents() {
        commonQuery();
        resultGrid.setShowRowNumbers(true);
        resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
            @Override
            public void onDoubleClick(DoubleClickEvent event) {
                showDetail();
            }
        });
        IButton operation1Button = new IButton("查看详情");
        operation1Button.hide();
        controlLayout.addMember(operation1Button);
        operation1Button.setIcon("[SKIN]/actions/view.png");
        operation1Button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                showDetail();
            }
        });

        IButton operation2Button = PermissionControl.createPermissionButton("下载模板", ERPPermissionStatic.SALARY_DOWNLOAD_BUTTON);
        controlLayout.addMember(operation2Button);
        operation2Button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                DownloadFileByUrl.download("/files/empSalary.xls");
            }
        });

        IButton operation3Button = PermissionControl.createPermissionButton("导入成本", ERPPermissionStatic.SALARY_IMPORT_BUTTON);
        controlLayout.addMember(operation3Button);
        operation3Button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                GWT.runAsync(new RunAsyncCallback() {
                    @Override
                    public void onFailure(Throwable reason) {
                        SC.say("failure to download code");
                    }

                    @Override
                    public void onSuccess() {
                        UploadEmpSalary uploadXls = new UploadEmpSalary();
                        uploadXls.addDataEditedHandler(new DataEditedHandler() {
                            @Override
                            public void onDataEdited(DataEditEvent event) {
                                //上传附件确认函成功
//                                SC.say("提示", "操作成功");
                                commonQuery();
                            }
                        });
                        uploadXls.show();
                    }
                });
            }
        });

        IButton operation6Button = PermissionControl.createPermissionButton("导出成本", ERPPermissionStatic.SALARY_EXPORT_BUTTON);
        controlLayout.addMember(operation6Button);
        operation6Button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                Map condition = generateCriteria();
                ClientUtil.departmentParameterProcess(condition);
                condition.put("keyValue", getKeyValue());
                DBDataSource.downloadFile("DW_MemployeeSalaryNew", condition);
            }
        });

        IButton operation4Button = PermissionControl.createPermissionButton("秘钥重置", ERPPermissionStatic.SALARY_RESET_PWD_BUTTON);
        controlLayout.addMember(operation4Button);
        operation4Button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {


                PopupWindow pWindow = new PopupWindow();
                pWindow.setTitle("秘钥重置");
                pWindow.setWidth("20%");
                pWindow.setHeight("20%");
                pWindow.centerInPage();
                ResetPasswordPanel panel = new ResetPasswordPanel();
                panel.setParentWindow(pWindow);
                panel.addDataEditedHandler(new DataEditedHandler() {
                    @Override
                    public void onDataEdited(DataEditEvent event) {
                        Record record1 = event.getData();
                        String value = BaseHelpUtils.getString(record1.getAttribute("password"));
                        String password1 = BaseHelpUtils.getString(record1.getAttribute("password1"));
                        String password2 = BaseHelpUtils.getString(record1.getAttribute("password2"));
                        if(!password1.equals(password2)){
                            SC.say("提示", "您两次输入的新秘钥不一致!!");
                        }
                        if (!value.isEmpty()) {
                            Map param = new LinkedHashMap();
                            param.put("oldKeyValue", value);
                            String message = MapUtils.toJSON(param);
                            //项目暂缓方法
                            DBDataSource.callOperation("EP_CheckKeyValue", "update", message, new DSCallback() {
                                @Override
                                public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                                    if (dsResponse.getStatus() == 0) {
                                        if (!password1.isEmpty()) {
                                            Map param = new LinkedHashMap();
                                            param.put("keyValue", password1);
                                            String message = MapUtils.toJSON(param);
                                            //项目暂缓方法
                                            DBDataSource.callOperation("EP_ResetKeyValue", "update", message, new DSCallback() {
                                                @Override
                                                public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                                                    if (dsResponse.getStatus() >= 0) {
                                                        SC.say("操作成功");
                                                        commonQuery();
                                                    } else {
                                                        Map errors = dsResponse.getErrors();
                                                        SC.say("操作失败" + errors);
                                                    }
                                                }
                                            });
                                        }
                                    } else if (dsResponse.getStatus() == -1) {
                                        SC.say("提示", "您输入的旧秘钥不匹配");
                                    } else {
                                        Map errors = dsResponse.getErrors();
                                        SC.say("操作失败" + errors);
                                    }
                                }
                            });
                        }else{
                            SC.say("提示","请输入您的旧秘钥");
                        }

                    }

                });
                pWindow.addItem(panel);
                pWindow.show();
//
//                GWT.runAsync(new RunAsyncCallback() {
//                    @Override
//                    public void onFailure(Throwable reason) {
//                        SC.say("failure to download code");
//                    }
//
//                    @Override
//                    public void onSuccess() {
//                        SC.askforValue("提示", "请输入您的旧秘钥", new ValueCallback() {
//                            @Override
//                            public void execute(String value) {
//                                if (!value.isEmpty()) {
//                                    Map param = new LinkedHashMap();
//                                    param.put("oldKeyValue", value);
//                                    String message = MapUtils.toJSON(param);
//                                    //项目暂缓方法
//                                    DBDataSource.callOperation("EP_CheckKeyValue", "update", message, new DSCallback() {
//                                        @Override
//                                        public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//                                            if (dsResponse.getStatus() == 0) {
//                                                SC.askforValue("提示", "请输入您的新秘钥", new ValueCallback() {
//                                                    @Override
//                                                    public void execute(String value) {
//                                                        if (!value.isEmpty()) {
//                                                            Map param = new LinkedHashMap();
//                                                            param.put("keyValue", value);
//                                                            String message = MapUtils.toJSON(param);
//                                                            //项目暂缓方法
//                                                            DBDataSource.callOperation("EP_ResetKeyValue", "update", message, new DSCallback() {
//                                                                @Override
//                                                                public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//                                                                    if (dsResponse.getStatus() >= 0) {
//                                                                        SC.say("操作成功");
//                                                                        commonQuery();
//                                                                    } else {
//                                                                        Map errors = dsResponse.getErrors();
//                                                                        SC.say("操作失败" + errors);
//                                                                    }
//                                                                }
//                                                            });
//                                                        }
//                                                    }
//                                                });
//                                            }else if(dsResponse.getStatus() == -1){
//                                                SC.say("提示","您输入的旧秘钥不匹配");
//                                            }else {
//                                                Map errors = dsResponse.getErrors();
//                                                SC.say("操作失败" + errors);
//                                            }
//                                        }
//                                    });
//                                }else{
//                                    SC.say("提示","请输入您的旧秘钥");
//                                }
//                            }
//
//                        });
//
//                    }
//                });
            }
        });

        IButton operation5Button = PermissionControl.createPermissionButton("解密搜索", ERPPermissionStatic.SALARY_DECRYPTION_SERACH_BUTTON);
        controlLayout.addMember(operation5Button);
        operation5Button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                PopupWindow pWindow = new PopupWindow();
                pWindow.setTitle("查看秘钥");
                pWindow.setWidth("20%");
                pWindow.setHeight("13%");
                pWindow.centerInPage();
                PasswordPanel panel = new PasswordPanel();
                panel.setParentWindow(pWindow);
                panel.addDataEditedHandler(new DataEditedHandler() {
                    @Override
                    public void onDataEdited(DataEditEvent event) {
                        Record record1 = event.getData();
                        String value = BaseHelpUtils.getString(record1.getAttribute("password"));
                        if (!value.isEmpty()) {
                            Map param = new LinkedHashMap();
                            param.put("oldKeyValue", value);
                            String message = MapUtils.toJSON(param);
                            //项目暂缓方法
                            DBDataSource.callOperation("EP_CheckKeyValue", "update", message, new DSCallback() {
                                @Override
                                public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                                    if (dsResponse.getStatus() == 0) {
                                        setKeyValue(value);
                                        commonQuery();
                                    } else if (dsResponse.getStatus() == -1) {
                                        SC.say("提示", "您输入的秘钥不匹配");
                                    } else {
                                        Map errors = dsResponse.getErrors();
                                        SC.say("操作失败" + errors);
                                    }
                                }
                            });
                        }
                    }

                });
                pWindow.addItem(panel);
                pWindow.show();
//                GWT.runAsync(new RunAsyncCallback() {
//                    @Override
//                    public void onFailure(Throwable reason) {
//                        SC.say("failure to download code");
//                    }
//
//                    @Override
//                    public void onSuccess() {
//                        SC.askforValue("提示", "请输入您的查看秘钥", new ValueCallback() {
//                            @Override
//                            public void execute(final String value) {
//                                if (!value.isEmpty()) {
//                                    Map param = new LinkedHashMap();
//                                    param.put("oldKeyValue", value);
//                                    String message = MapUtils.toJSON(param);
//                                    //项目暂缓方法
//                                    DBDataSource.callOperation("EP_CheckKeyValue", "update", message, new DSCallback() {
//                                        @Override
//                                        public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//                                            if (dsResponse.getStatus() == 0) {
//                                                setKeyValue(value);
//                                                commonQuery();
//                                            }else if(dsResponse.getStatus() == -1){
//                                                SC.say("提示","您输入的秘钥不匹配");
//                                            }else {
//                                                Map errors = dsResponse.getErrors();
//                                                SC.say("操作失败" + errors);
//                                            }
//                                        }
//                                    });
//                                }
//                            }
//                        });
//                    }
//                });
            }
        });
        
        IButton totalButton = new IButton("汇总");
		controlLayout.addMember(totalButton);
		totalButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				ListGridRecord[] recordList = resultGrid.getRecords();
				if (null != recordList && recordList.length > 0) {
					int length = recordList.length;
					if ("汇总".equals(recordList[length - 1].getAttribute("employeeName"))) {// 如果已经存在汇总，则不可再进行汇总
						return;
					}
					BigDecimal basicSalary = BigDecimal.ZERO;
					Record[] records = new Record[length + 1];
					for (int i = 0; i < length; i++) {
						records[i] = recordList[i];
						basicSalary = basicSalary.add(BigDecimal.valueOf(ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("basicSalary"))));
					}
					Record record = new Record();
					record.setAttribute("employeeName", "汇总");
					record.setAttribute("basicSalary", basicSalary);
					records[length] = record;
					resultGrid.setData(records);
					resultGrid.redraw();
					resultGrid.setCanEdit(false);
				}
			}
		});

    }

    public void showDetail() {
        GWT.runAsync(new RunAsyncCallback() {
            @Override
            public void onFailure(Throwable reason) {
                SC.say("failure to download code");
            }

            @Override
            public void onSuccess() {
                if (!resultGrid.anySelected()) {
                    SC.say("请选择一条数据");
                    return;
                }
                GenericViewWindow detail = new GenericViewWindow();
                detail.setTitle("人工成本");
                detail.setWidth100();
                detail.setHeight100();
                MemployeeSalaryViewer detailForm = new MemployeeSalaryViewer();
                detailForm.setParentSearchForm(searchForm);
                detailForm.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_TAB);
                detailForm.initComponents();
                detailForm.viewSelectedData(resultGrid);
                detail.setContent(detailForm);
                detail.centerInPage();
                detail.show();
            }
        });
    }

    @Override
    public boolean checkSearchCriteria(Map criteria) {
        criteria.put("keyValue", keyValue);
        return true;
    }

    @Override
    public SearchForm generateSearchForm() {
        return new MemployeeSalarySearchForm();
    }

    @Override
    public DataSource getDataSource() {
        return DSMemployeeSalary.getInstance();
    }

    @Override
    public int getSearchFormHeight() {
        return 126;
    }

}
