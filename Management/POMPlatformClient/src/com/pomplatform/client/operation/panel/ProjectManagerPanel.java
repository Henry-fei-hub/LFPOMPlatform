package com.pomplatform.client.operation.panel;

import java.math.BigDecimal;
import java.util.*;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractExpansionRelatedPage;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.NewProcessWindow;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.storage.client.Storage;
import com.google.gwt.user.client.Cookies;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.common.SetProjectAppendIntegral;
import com.pomplatform.client.operation.datasource.DSProjectManager;
import com.pomplatform.client.operation.form.NewProjectManagerForm;
import com.pomplatform.client.operation.form.ProjectManagerSearchForm;
import com.pomplatform.client.operation.form.ProjectManagerViewer;
import com.pomplatform.client.operation.form.UpdateProjectManagerForm;
import com.pomplatform.client.operation.form.UpdateProjectManagerForm123;
import com.pomplatform.client.project.panel.OnProjectTrunPlatePanel;
import com.pomplatform.client.projecttransitions.panel.OnLoadProjectTransitionRecordPanel;
import com.pomplatform.client.stage.datasource.DSProjectStage;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class ProjectManagerPanel extends AbstractExpansionRelatedPage {

    private static final Logger __logger = Logger.getLogger("");

    public static class Factory implements PanelFactory {
        private String id;

        @Override
        public Canvas create() {
            ProjectManagerPanel cm = new ProjectManagerPanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "ProjectManager";
        }

    }

    @Override
    protected String getCustomCellCSSText(ListGridRecord record, int rowNum, int colNum) {
        BigDecimal projectFinishPercent = BaseHelpUtils.getBigDecimalValue(record.getAttribute("projectFinishPercent"));
        BigDecimal totalFinishPercent = BaseHelpUtils.getBigDecimalValue(record.getAttribute("totalFinishPercent"));
        BigDecimal progressPercentage = BaseHelpUtils.getBigDecimalValue(record.getAttribute("progressPercentage"));
        BigDecimal leftSureIntegral = BaseHelpUtils.getBigDecimalValue(record.getAttribute("leftSureIntegral"));
        BigDecimal leftPlateSureIntegral = BaseHelpUtils.getBigDecimalValue(record.getAttribute("leftPlateSureIntegral"));
        BigDecimal hun = new BigDecimal(100);
        if (projectFinishPercent.compareTo(hun) > 0) {
            record.setAttribute("projectFinishPercent", 100);
        }
        if (totalFinishPercent.compareTo(hun) > 0) {
            record.setAttribute("totalFinishPercent", 100);
        }
        if (progressPercentage.compareTo(hun) > 0) {
            record.setAttribute("progressPercentage", 100);
        }
        if (leftSureIntegral.compareTo(BigDecimal.ZERO) < 0) {
            record.setAttribute("leftSureIntegral", 0);
        }
        if (leftPlateSureIntegral.compareTo(BigDecimal.ZERO) < 0) {
            record.setAttribute("leftPlateSureIntegral", 0);
        }
        //获取项目状态，如果项目暂停，则该行的字体颜色为红色，如果项目已结束，则该行的字体颜色为绿色
        int status = ClientUtil.checkAndGetIntValue(record.getAttribute("status"));
        if (status == ClientStaticUtils.PROJECT_STATUS_11) {  //项目已结束,标绿色
            return "color:#00B736;";
        } else if (status == ClientStaticUtils.PROJECT_STATUS_10) {  //项目暂停,标红色
            return "color:#F01813;";
        } else if (status == ClientStaticUtils.PROJECT_STATUS_5) {
            return "color:#DAA520;"; //项目无进度变为橘黄色
        } else {
            return null;
        }
    }

    @Override
    public void initComponents() {
        resultGrid.setShowRowNumbers(true);
        IButton refreshButton = new IButton("刷新");
        controlLayout.addMember(refreshButton);
        refreshButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                commonQuery();
            }
        });

        resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
            @Override
            public void onDoubleClick(DoubleClickEvent event) {
                showDetail();
            }
        });
        IButton operation1Button = new IButton("查看详情");
        controlLayout.addMember(operation1Button);
        operation1Button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                showDetail();
            }
        });
        IButton operation2Button = PermissionControl.createPermissionButton("项目立项",
                ERPPermissionStatic.OPERATE_MANAGE_PROJECT_PROJECT_BUTTON);
//		controlLayout.addMember(operation2Button);
        operation2Button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                GWT.runAsync(new RunAsyncCallback() {
                    @Override
                    public void onFailure(Throwable reason) {
                        SC.say("failure to download");
                    }

                    @Override
                    public void onSuccess() {
                        // 获取当前项目的部门经理板块id
                        int plateId = ClientUtil
                                .checkAndGetIntValue(Cookies.getCookie(ClientUtil.OPRERATOR_PLATEID_COOKIE));
                        if (plateId == 0) {// 当前立项的运行管理员没有设置板块，不可进行立项操作
                            SC.say("提示", "当前立项的运行管理员没有设置板块，不可进行立项操作,请先设置板块");
                            return;
                        }
                        NewProjectManagerForm detailForm = new NewProjectManagerForm();
                        detailForm.setTitle("项目立项");
                        detailForm.addDataEditedHandler(new DataEditedHandler() {
                            @Override
                            public void onDataEdited(DataEditEvent event) {
                                RecordList list = resultGrid.getDataAsRecordList();
                                RecordList newList = new RecordList();
                                newList.addList(list.getRange(0, list.getLength()));
                                newList.add(event.getData());
                                resultGrid.setData(newList);
                                resultGrid.selectSingleRecord(newList.getLength() - 1);
                            }
                        });
                        detailForm.setSearchForm(searchForm);
                        detailForm.initComponents();
                        detailForm.startEdit();
                        detailForm.setWidth100();
                        detailForm.setHeight100();
                        detailForm.centerInPage();
                        detailForm.show();
                    }
                });
            }
        });
        IButton operation3Button = PermissionControl.createPermissionButton("修改项目",
                ERPPermissionStatic.OPERATE_MANAGE_PROJECT_UPDATE_BUTTON);
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
                        if (!resultGrid.anySelected()) {
                            SC.say("请选择一条数据修改");
                            return;
                        }
                        final ListGridRecord selected1 = resultGrid.getSelectedRecord();
                        //获取项目类别,如果是项目管理费，则不可进行修改
                        int projectType = BaseHelpUtils.getIntValue(selected1.getAttribute("projectType"));
                        Boolean isAuto = BaseHelpUtils.getBoolean(selected1.getAttribute("isAuto"));
                        if (projectType == 16 && isAuto) {
                            SC.say("提示", "该项目为项目管理费，不可进行修改操作");
                            return;
                        }
                        if (projectType == 30 && isAuto) {
                            SC.say("提示", "该项目为采买成本，不可进行修改操作");
                            return;
                        }
                        if (projectType == 88) {
                            SC.say("提示", "该项目为部门预留，不可进行修改操作");
                            return;
                        }
                        Map<String, Object> param = new LinkedHashMap<>();
                        param.put("projectId", BaseHelpUtils.getIntValue(selected1.getAttribute("projectId")));
                        DBDataSource.callOperation("NQ_GetCountProjectSettlementCountByProjectId", "find", param, new DSCallback() {
                            @Override
                            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                                if (dsResponse.getStatus() >= 0 && dsResponse.getData().length <= 0) {
                                    int projectFlag = BaseHelpUtils.getIntValue(selected1.getAttribute("projectFlag"));
                                    if (projectFlag == 1 || projectFlag == 4) {

									/*UpdateProjectManagerForm detailForm = new UpdateProjectManagerForm();
									detailForm.setTitle("项目修改");
									detailForm.addDataEditedHandler(new DataEditedHandler() {
										@Override
										public void onDataEdited(DataEditEvent event) {
											commonQuery();
										}
									});
									detailForm.setShowCloseButton(false);
									detailForm.setSearchForm(searchForm);
									detailForm.setRecord(selected1);
									detailForm.initComponents();
									detailForm.startEdit();
									detailForm.setWidth100();
									//detailForm.setHeight100();
									detailForm.show();*/

                                        //判断当前操作人所属部门是否是属于方案设计部
                                        //boolean isOrNot = false;
                                        //获取当前登录人Id
                                        int employeeId = ClientUtil.getEmployeeId();
                                        //加载该职员信息
                                        Map<String, Object> params = new HashMap<>();
                                        params.put("employeeId", employeeId);
                                        DBDataSource.callOperation("ST_Employee", "find", params, new DSCallback() {
                                            @Override
                                            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                                                if (dsResponse.getStatus() >= 0) {
                                                    Record record = dsResponse.getData()[0];
                                                    String departmentid = record.getAttribute("departmentId");

                                                    Map<String, Object> paramsDep = new HashMap<>();
                                                    //paramsDep.put("departmentId", 7);
                                                    //paramsDep.put("childId",departmentid);
                                                    paramsDep.put("departmentId", departmentid);
                                                    paramsDep.put("optType", "isDesignDepartment");
                                                    //ST_DepartmentId
                                                    DBDataSource.callOperation("EP_DepartmentEmployee", paramsDep, new DSCallback() {
                                                        @Override
                                                        public void execute(DSResponse dsResponseDep, Object dataDep, DSRequest dsRequestDep) {
                                                            if (dsResponseDep.getStatus() >= 0 && dsResponseDep.getData().length >= 0) {//发起人属于方案设计部
                                                                //判断当前选中数据是否正在流程审批状态中
                                                                int projectId = BaseHelpUtils.getIntValue(selected1.getAttribute("projectId"));
                                                                String projectCode = selected1.getAttribute("projectCode");
                                                                String projectName = selected1.getAttribute("projectName");
                                                                //int contractId = BaseHelpUtils.getIntValue(selected1.getAttribute("contractId"));
                                                                String contractCode = selected1.getAttribute("contractCode");
                                                                Map<String, Object> paramsDmps = new HashMap<>();
                                                                paramsDmps.put("projectId", projectId);
                                                                paramsDmps.put("projectCode", projectCode);
                                                                paramsDmps.put("projectName", projectName);
                                                                paramsDmps.put("contractCode", contractCode);
                                                                DBDataSource.callOperation("NQ_DepartmentManagerProjectStatus", "find", paramsDmps, new DSCallback() {
                                                                    @Override
                                                                    public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                                                                        if (dsResponse.getStatus() >= 0 && dsResponse.getData().length > 0) {
                                                                            SC.say("提示", "当前项目修改是待审批状态,请不要重复修改");
                                                                            return;
                                                                        } else {
                                                                            //获取流程process_id
                                                                            String processId = "";
                                                                            Storage sta = Storage.getLocalStorageIfSupported();
                                                                            String str = sta.getItem(PomPlatformClientUtil.PROCESS_ID_COOKIE);
                                                                            if (!PomPlatformClientUtil.isNullOrEmpty(str)) {
                                                                                String[] arr = str.split(",");
                                                                                for (String tempStr : arr) {
                                                                                    String[] tempArr = tempStr.split(":");
                                                                                    //获取父级ID
                                                                                    if (tempArr[0].replaceAll("\"", "").equals("Professional_Approval_Application")) {
                                                                                        processId = tempArr[1];
                                                                                    }
                                                                                }
                                                                            }
                                                                            NewProcessWindow panel = new NewProcessWindow();
                                                                            panel.setTitle("专业负责人审批");
                                                                            panel.setProcessId(ClientUtil.checkAndGetIntValue(processId));
                                                                            panel.setLayoutMode(0);
                                                                            panel.addDataEditedHandler(new DataEditedHandler() {
                                                                                @Override
                                                                                public void onDataEdited(DataEditEvent event) {
                                                                                    commonQuery();
                                                                                }
                                                                            });
                                                                            panel.setData(selected1);
                                                                            panel.initComponents();
                                                                            panel.setWidth100();
                                                                            panel.setHeight100();
                                                                            panel.centerInPage();
                                                                            panel.show();
                                                                        }
                                                                    }
                                                                });
                                                            } else {
                                                                //发起人不属于方案设计部
                                                                UpdateProjectManagerForm detailForm = new UpdateProjectManagerForm();
                                                                detailForm.setTitle("项目修改");
                                                                detailForm.addDataEditedHandler(new DataEditedHandler() {
                                                                    @Override
                                                                    public void onDataEdited(DataEditEvent event) {
                                                                        commonQuery();
                                                                    }
                                                                });
                                                                detailForm.setShowCloseButton(false);
                                                                detailForm.setSearchForm(searchForm);
                                                                detailForm.setRecord(selected1);
                                                                detailForm.initComponents();
                                                                detailForm.startEdit();
                                                                detailForm.setWidth100();
                                                                //detailForm.setHeight100();
                                                                detailForm.show();
                                                            }
                                                        }
                                                    });
                                                } else {
                                                    SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
                                                }
                                            }
                                        });
                                    } else {
                                        SC.say("提示", "非设计项目和投标项目不可进行修改，不可进行修改操作");
                                        return;
                                    }
                                } else {
                                    SC.say("提示", "已有经费结算流程审批中，请勿申请");
                                    return;
                                }
                            }
                        });
                    }
                });
            }
        });


//		IButton operation3ButtonUpdate = PermissionControl.createPermissionButton("修改项目审批列表",
//				ERPPermissionStatic.OPERATE_MANAGE_PROJECT_UPDATE_BUTTON);
//		controlLayout.addMember(operation3ButtonUpdate);
//		operation3ButtonUpdate.addClickHandler(new ClickHandler() {
//			
//			@Override
//			public void onClick(ClickEvent event) {
//				// TODO Auto-generated method stub
//				PopupWindow popupWindow = new PopupWindow("项目审核");
//				popupWindow.setWidth100();
//				popupWindow.setHeight100();
//				popupWindow.centerInPage();
//				OnLoadProjectTransitionRecordPanel panel =new OnLoadProjectTransitionRecordPanel();
////				panel.initComponents();
//				popupWindow.addItem(panel);
//				popupWindow.show();
//			}
//		});
//		IButton removeButton = PermissionControl.createPermissionButton("项目移除",
//				ERPPermissionStatic.OPERATE_MANAGE_PROJECT_DELETE_BUTTON);
//		controlLayout.addMember(removeButton);
//		removeButton.addClickHandler(new ClickHandler() {
//			@Override
//			public void onClick(ClickEvent event) {
//				GWT.runAsync(new RunAsyncCallback() {
//					@Override
//					public void onFailure(Throwable reason) {
//						SC.say("failure to download code");
//					}
//
//					@Override
//					public void onSuccess() {
//						if (!resultGrid.anySelected()) {
//							SC.say("提示", "请选择一条数据修改");
//							return;
//						}
//						SC.confirm("提示", "您确定要删除该项目吗？", new BooleanCallback() {
//							@Override
//							public void execute(Boolean value) {
//								if (value) {
//									ListGridRecord[] selected = resultGrid.getSelectedRecords();
//									String projectId = selected[0].getAttribute("projectId");
//									Map param = new LinkedHashMap();
//									param.put("projectId", projectId);
//									String message = MapUtils.toJSON(param);
//									// 删除方法
//									DBDataSource.callOperation("EP_ProjectDelete", "delete", message, new DSCallback() {
//										@Override
//										public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//											if (dsResponse.getStatus() >= 0) {
//												// SC.say("操作成功");
//												// 执行成功后重新执行查询，刷新表格数据
//												commonQuery();
//											} else {
//												Map errors = dsResponse.getErrors();
//												SC.say("删除失败" + errors);
//											}
//										}
//									});
//								}
//							}
//						});
//					}
//				});
//			}
//		});

        IButton operation6Button = PermissionControl.createPermissionButton("追加积分",
                ERPPermissionStatic.OPERATE_MANAGE_PROJECT_ADDITIONAL_INTEGRATION_BUTTON);
        controlLayout.addMember(operation6Button);
        operation6Button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                GWT.runAsync(new RunAsyncCallback() {
                    @Override
                    public void onFailure(Throwable reason) {
                        SC.say("failure to download code");
                    }

                    @Override
                    public void onSuccess() {
                        if (!resultGrid.anySelected()) {
                            SC.say("请选择一条数据修改");
                            return;
                        }
                        ListGridRecord[] selected = resultGrid.getSelectedRecords();
                        if (selected[0].getAttribute("projectFlag").equals("1")) {
                            int projectId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("projectId"));
                            double totalIntegral = ClientUtil
                                    .checkAndGetDoubleValue(selected[0].getAttribute("totalIntegral"));// 项目总积分
                            double projectIntegral = ClientUtil
                                    .checkAndGetDoubleValue(selected[0].getAttribute("projectIntegral"));// 项目积分
                            double reserveIntegral = ClientUtil
                                    .checkAndGetDoubleValue(selected[0].getAttribute("reserveIntegral"));// 预留积分
                            double appendTotalIntegral = ClientUtil
                                    .checkAndGetDoubleValue(selected[0].getAttribute("appendTotalIntegral"));// 追加总积分
                            int appendIntegral = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("appendIntegral"));// 追加积分
                            if (appendIntegral <= 0) {
                                SC.say("该项目没有追加的积分，不可继续追加");
                                return;
                            }
                            String remark = selected[0].getAttribute("remark");// 备注
                            String projectName = selected[0].getAttribute("projectName");// 备注
                            PopupWindow popupWindow = new PopupWindow("项目审核");
                            popupWindow.setWidth("50%");
                            popupWindow.setHeight("60%");
                            popupWindow.centerInPage();
                            SetProjectAppendIntegral audit = new SetProjectAppendIntegral();
                            audit.addDataEditedHandler(new DataEditedHandler() {
                                @Override
                                public void onDataEdited(DataEditEvent event) {
                                    commonQuery();
                                }
                            });
                            audit.initComponents(Boolean.TRUE, projectName, projectId, totalIntegral, projectIntegral,
                                    reserveIntegral, appendTotalIntegral, appendIntegral, remark);
                            popupWindow.addItem(audit);
                            audit.setParentWindow(popupWindow);
                            popupWindow.show();
                        } else {
                            SC.say("提示", "非设计项目不可进行修改，不可进行操作");
                            return;
                        }
                    }
                });
            }
        });
        IButton updateButton = PermissionControl.createPermissionButton("点我修改", ERPPermissionStatic.OPERATE_MANAGE_PROJECT_ME_UPDATE_BUTTON);
        updateButton.hide();
        controlLayout.addMember(updateButton);
        updateButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                GWT.runAsync(new RunAsyncCallback() {
                    @Override
                    public void onFailure(Throwable reason) {
                        SC.say("failure to download code");
                    }

                    @Override
                    public void onSuccess() {
                        if (!resultGrid.anySelected()) {
                            SC.say("请选择一条数据修改");
                            return;
                        }
                        ListGridRecord[] selected = resultGrid.getSelectedRecords();
                        if (selected[0].getAttribute("projectFlag").equals("1")) {
                            UpdateProjectManagerForm123 detailForm = new UpdateProjectManagerForm123();
                            detailForm.setTitle("修改合同编码");
                            detailForm.addDataEditedHandler(new DataEditedHandler() {
                                @SuppressWarnings({"rawtypes", "unchecked"})
                                @Override
                                public void onDataEdited(DataEditEvent event) {
                                    RecordList list = resultGrid.getDataAsRecordList();
                                    Map params = new HashMap();
                                    params.put("projectId", event.getData().getAttribute("projectId"));
                                    int index = list.findIndex(params);
                                    if (index != -1) {
                                        RecordList newList = new RecordList();
                                        if (index > 0) {
                                            newList.addList(list.getRange(0, index));
                                        }
                                        newList.add(event.getData());
                                        if (index < list.getLength() - 1) {
                                            newList.addList(list.getRange(index + 1, list.getLength()));
                                        }
                                        resultGrid.setData(newList);
                                        resultGrid.selectSingleRecord(index);
                                    }
                                }
                            });
                            detailForm.setSearchForm(searchForm);
                            detailForm.setRecord(selected[0]);
                            detailForm.initComponents();
                            detailForm.startEdit();
                            detailForm.centerInPage();
                            detailForm.setWidth100();
                            detailForm.setHeight100();
                            detailForm.show();
                        }
                    }
                });
            }
        });

        IButton runButton = new IButton("订单运行");
        controlLayout.addMember(runButton);
        runButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                GWT.runAsync(new RunAsyncCallback() {
                    @Override
                    public void onFailure(Throwable reason) {
                        SC.say(ClientStaticUtils.WARNING);
                    }

                    @Override
                    public void onSuccess() {
                        if (!resultGrid.anySelected()) {
                            SC.say("请选择一条数据再执行本操作");
                            return;
                        }
                        runButton.setDisabled(true);
                        Record selected = resultGrid.getSelectedRecord();
                        String projectId = selected.getAttribute("projectId");
                        int status = ClientUtil.checkAndGetIntValue(selected.getAttribute("status"));
                        switch (status) {
                            case ClientStaticUtils.PROJECT_STATUS_2:
                                SC.say("该订单已处于订单运行状态，无需再次操作");
                                runButton.setDisabled(false);
                                return;
                            case ClientStaticUtils.PROJECT_STATUS_11:
                                SC.say("该订单已结项，不可进行订单运行操作");
                                runButton.setDisabled(false);
                                return;
                            case ClientStaticUtils.PROJECT_STATUS_14:
                                SC.say("该订单正在终止结算中，不可以进行订单运行操作");
                                runButton.setDisabled(false);
                                return;
                            case ClientStaticUtils.PROJECT_STATUS_15:
                                SC.say("该订单已终止，不可以进行订单运行操作");
                                runButton.setDisabled(false);
                                return;
                            default:
                                SC.confirm("提示", "您确定要使该订单重新处于运行状态吗?", new BooleanCallback() {
                                    @Override
                                    public void execute(Boolean value) {
                                        if (BaseHelpUtils.getBoolean(value)) {
                                            Map<String, Object> params = new HashMap<>();
                                            params.put("optType", "changeProjectStatus");
                                            params.put("projectId", projectId);
                                            params.put("status", ClientStaticUtils.PROJECT_STATUS_2);
                                            DBDataSource.callOperation("EP_ProjectProcessor", params, new DSCallback() {

                                                @Override
                                                public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                                                    if (dsResponse.getStatus() >= 0) {
                                                        SC.say("操作成功");
                                                        commonQuery();
                                                    } else {
                                                        ClientUtil.displayErrorMessage(dsResponse);
                                                    }
                                                    runButton.setDisabled(false);
                                                }
                                            });
                                        } else {
                                            runButton.setDisabled(false);
                                        }
                                    }
                                });
                        }
                    }
                });
            }
        });

        IButton trunButton = new IButton("转单");
        controlLayout.addMember(trunButton);
        trunButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                GWT.runAsync(new RunAsyncCallback() {
                    @Override
                    public void onSuccess() {
                        if (!resultGrid.anySelected()) {
                            SC.say("请选择一条数据修改");
                            return;
                        }
                        Record selected = resultGrid.getSelectedRecords()[0];
                        //获取项目标示，如果是研发项目的话不允许修改
                        int projetFlag = BaseHelpUtils.getIntValue(selected.getAttribute("projectFlag"));
                        if (projetFlag > 1) {//说明不是设计项目,不允许修改
                            SC.say("提示", "非设计项目不可进行转单操作");
                            return;
                        }
                        //获取项目类型，如果是项目管理费，则无需进行阶段策划
                        int businessType = BaseHelpUtils.getIntValue(selected.getAttribute("projectType"));
                        if (businessType == 16) {//说明是项目管理费，无需进行阶段策划
                            SC.say("提示", "该项目为项目管理费项目,无需进行转单");
                            return;
                        }
                        if (businessType == 33) {//说明是条线管理订单，无需进行阶段策划
                            SC.say("提示", "该项目为条线管理项目,无需进行转单");
                            return;
                        }
                        if (businessType == 30) {//说明是采买成本，无需进行阶段策划
                            SC.say("提示", "该项目为采买成本,无需进行转单");
                            return;
                        }
                        if (businessType == 88) {//说明是部门预留，无需进行阶段策划
                            SC.say("提示", "该项目为部门预留,无需进行转单");
                            return;
                        }

                        final PopupWindow popupWindow = new PopupWindow("订单转单");
                        popupWindow.setWidth("50%");
                        popupWindow.setHeight("60%");
                        popupWindow.centerInPage();
                        OnProjectTrunPlatePanel panel = new OnProjectTrunPlatePanel();
                        panel.setRecord(selected);
                        panel.initComponents();
                        popupWindow.addItem(panel);
                        panel.addDataEditedHandler(new DataEditedHandler() {
                            @Override
                            public void onDataEdited(DataEditEvent event) {
                                commonQuery();
                            }
                        });
                        popupWindow.addCloseClickHandler(new CloseClickHandler() {
                            @Override
                            public void onCloseClick(CloseClickEvent event) {
                                popupWindow.destroy();
                            }
                        });
                        panel.setParentWindow(popupWindow);
                        popupWindow.centerInPage();
                        popupWindow.show();
                    }

                    @Override
                    public void onFailure(Throwable reason) {
                        SC.say(ClientStaticUtils.WARNING);
                    }
                });

            }
        });

//        IButton changeIntegralButton = PermissionControl.createPermissionButton("项目积分修改",
//				ERPPermissionStatic.OPERATE_MANAGE_PROJECT_UPDATE_BUTTON);
//		controlLayout.addMember(changeIntegralButton);
//		changeIntegralButton.addClickHandler(new ClickHandler() {
//			@Override
//			public void onClick(ClickEvent event) {
//				GWT.runAsync(new RunAsyncCallback() {
//					@Override
//					public void onFailure(Throwable reason) {
//						SC.say("failure to download code");
//					}
//
//					@Override
//					public void onSuccess() {
//						if (!resultGrid.anySelected()) {
//							SC.say("请选择一条数据修改");
//							return;
//						}
//						final ListGridRecord selected1 = resultGrid.getSelectedRecord();
//						ChangeIntegralUpdateProjectManagerForm detailForm = new ChangeIntegralUpdateProjectManagerForm();
//						detailForm.setTitle("修改项目");
//						detailForm.addDataEditedHandler(new DataEditedHandler() {
//							@Override
//							public void onDataEdited(DataEditEvent event) {
//								DBDataSource.copyRecord(event.getData(), selected1);
//							}
//						});
//						detailForm.setSearchForm(searchForm);
//						detailForm.setRecord(selected1);
//						detailForm.setCurrentPage(getCurrentPage());
//						detailForm.initComponents();
//						detailForm.startEdit();
//						detailForm.setWidth100();
//						detailForm.setHeight100();
//						detailForm.centerInPage();
//						detailForm.show();
//						setCurrentPage(detailForm.getCurrentPage());
//					}
//				});
//			}
//		});

        IButton totalButton = new IButton("汇总");
        controlLayout.addMember(totalButton);
        totalButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                ListGridRecord[] recordList = resultGrid.getRecords();
                int len = recordList.length;
                Record[] records = new Record[len + 1];
                if (len > 0) {
                    double totalIntegral = 0;
                    double projectIntegral = 0;
                    double reserveIntegral = 0;
                    double complaintIntegral = 0;
                    BigDecimal sureIntegral = BigDecimal.ZERO;
                    BigDecimal leftSureIntegral = BigDecimal.ZERO;
                    BigDecimal plateSureIntegral = BigDecimal.ZERO;
                    BigDecimal leftPlateSureIntegral = BigDecimal.ZERO;
                    for (int i = 0; i < len; i++) {
                        if ("汇总".equals(recordList[i].getAttribute("projectCode"))) {// 如果已经存在汇总，则不可再进行汇总
                            return;
                        }
                        totalIntegral += ClientUtil
                                .checkAndGetDoubleValue(recordList[i].getAttribute("totalIntegral"));
                        projectIntegral += ClientUtil
                                .checkAndGetDoubleValue(recordList[i].getAttribute("projectIntegral"));
                        reserveIntegral += ClientUtil
                                .checkAndGetDoubleValue(recordList[i].getAttribute("reserveIntegral"));
                        complaintIntegral += ClientUtil
                                .checkAndGetDoubleValue(recordList[i].getAttribute("complaintIntegral"));
                        sureIntegral = sureIntegral.add(BaseHelpUtils.getBigDecimalValue(recordList[i].getAttribute("sureIntegral")));
                        leftSureIntegral = leftSureIntegral.add(BaseHelpUtils.getBigDecimalValue(recordList[i].getAttribute("leftSureIntegral")));
                        plateSureIntegral = plateSureIntegral.add(BaseHelpUtils.getBigDecimalValue(recordList[i].getAttribute("plateSureIntegral")));
                        leftPlateSureIntegral = leftPlateSureIntegral.add(BaseHelpUtils.getBigDecimalValue(recordList[i].getAttribute("leftPlateSureIntegral")));
                        records[i] = recordList[i];
                    }
                    Record record = new Record();
                    record.setAttribute("projectCode", "汇总");
                    record.setAttribute("totalIntegral", totalIntegral);
                    record.setAttribute("projectIntegral", projectIntegral);
                    record.setAttribute("reserveIntegral", reserveIntegral);
                    record.setAttribute("complaintIntegral", complaintIntegral);
                    record.setAttribute("sureIntegral", sureIntegral);
                    record.setAttribute("leftSureIntegral", leftSureIntegral);
                    record.setAttribute("plateSureIntegral", plateSureIntegral);
                    record.setAttribute("leftPlateSureIntegral", leftPlateSureIntegral);
                    records[len] = record;
                    resultGrid.setData(records);
                    resultGrid.redraw();
                    resultGrid.setCanEdit(false);
                }
            }
        });

        IButton downloadButton = new IButton("导出");
        downloadButton.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                Map params = generateCriteria();
                DBDataSource.downloadFile("DW_ProjectManager", params);
            }
        });
        controlLayout.addMember(downloadButton);

        final IButton noneButton = PermissionControl.createPermissionButton("项目无进度", ERPPermissionStatic.OPERATE_MANAGE_PROJECT_none_BUTTON);
        controlLayout.addMember(noneButton);
        noneButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                GWT.runAsync(new RunAsyncCallback() {

                    @Override
                    public void onSuccess() {
                        if (!resultGrid.anySelected()) {
                            SC.say("请选择需要变为无进度状态的订单");
                            return;
                        }
                        noneButton.setDisabled(true);
                        Record record = resultGrid.getSelectedRecord();
                        String projectId = record.getAttribute("projectId");
                        int status = ClientUtil.checkAndGetIntValue(record.getAttribute("status"));
                        switch (status) {
                            case ClientStaticUtils.PROJECT_STATUS_5:
                                SC.say("该订单已无进度，无需再次操作");
                                noneButton.setDisabled(false);
                                break;
                            case ClientStaticUtils.PROJECT_STATUS_2:
                            case ClientStaticUtils.PROJECT_STATUS_17:
                                SC.confirm("提示", "你确定要使项目变为无进度状态吗", new BooleanCallback() {

                                    @Override
                                    public void execute(Boolean value) {
                                        if (BaseHelpUtils.getBoolean(value)) {
                                            Map<String, Object> param = new HashMap<>();
                                            param.put("projectId", projectId);
                                            param.put("status", ClientStaticUtils.PROJECT_STATUS_5);// 项目无进度值：5
                                            param.put("operateEmployeeId", ClientUtil.getEmployeeId());
                                            String message = MapUtils.toJSON(param);
                                            // 订单暂停方法
                                            DBDataSource.callOperation("EP_ProjectStatus", "update", message, new DSCallback() {
                                                @Override
                                                public void execute(DSResponse dsResponse, Object data,
                                                                    DSRequest dsRequest) {
                                                    if (dsResponse.getStatus() >= 0) {
                                                        SC.say("操作成功");
                                                        // 执行成功后重新执行查询，刷新表格数据
                                                        record.setAttribute("status", ClientStaticUtils.PROJECT_STATUS_5);
                                                        resultGrid.redraw();
                                                    } else {
                                                        ClientUtil.displayErrorMessage(dsResponse);
                                                    }
                                                    noneButton.setDisabled(false);
                                                }
                                            });
                                        } else {
                                            noneButton.setDisabled(false);
                                        }
                                    }
                                });
                                break;
                            default:
                                SC.say("只有处于订单运行或订单收尾的订单，才可以变为无进度状态");
                                noneButton.setDisabled(false);
                                break;
                        }
                    }

                    @Override
                    public void onFailure(Throwable reason) {
                        SC.say(ClientStaticUtils.WARNING);
                    }
                });
            }
        });
        commonQuery();
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
                ListGridRecord record = resultGrid.getSelectedRecord();
                if (ClientUtil.checkAndGetIntValue(record.getAttribute("projectId")) > 0) {
                    GenericViewWindow detail = new GenericViewWindow();
                    detail.setTitle("项目管理");
                    detail.setWidth100();
                    detail.setHeight100();
                    ProjectManagerViewer detailForm = new ProjectManagerViewer();
                    detailForm.setParentSearchForm(searchForm);
                    detailForm.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_TAB);
                    detailForm.initComponents();
                    detailForm.viewSelectedData(resultGrid);
                    detail.setContent(detailForm);
                    detail.centerInPage();
                    detail.show();
                }
            }
        });
    }

    @Override
    public boolean checkSearchCriteria(Map criteria) {
        //获取是否需要查询100%的项目
        boolean projectFinishPercent = BaseHelpUtils.getBoolean(criteria.get("projectFinishPercent"));
        if (!projectFinishPercent) {
            List<Map> keyvalues = new ArrayList<>();
            Map<String, String> kv = new HashMap<>();
            kv.put("key", "2 = 2");
            kv.put("value", "(ps.sure_integral < P.project_integral or ps.sure_integral is null)");
            keyvalues.add(kv);
            criteria.put("keyValues", keyvalues);
        }
        int employeeId = PomPlatformClientUtil.getEmployeeId();
        criteria.put("departmentManagerId", employeeId);
        return true;
    }

    @Override
    public SearchForm generateSearchForm() {
        return new ProjectManagerSearchForm();
    }

    @Override
    public DataSource getDataSource() {
        return DSProjectManager.getInstance();
    }

    @Override
    public int getSearchFormHeight() {
        return 170;
    }

    @Override
    public DataSource getChildDataSource() {
        return DSProjectStage.getInstance();
    }

    @Override
    public void setChildGridOption(ListGrid resultChildGrid) {
        resultChildGrid.setShowGridSummary(true);
    }

}
