package com.pomplatform.client.departmentdirector.panel;

import java.math.BigDecimal;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.common.SetPlateIntegralAssign;
import com.pomplatform.client.common.SetPlateIntegralAssignOne;
import com.pomplatform.client.common.SetPlateIntegralTransfer;
import com.pomplatform.client.common.SetProjectIntegralAssign;
import com.pomplatform.client.common.SetProjectIntegralChange;
import com.pomplatform.client.common.SetProjectIntegralTransfer;
import com.pomplatform.client.departmentdirector.datasource.DSMDepartmentDirector;
import com.pomplatform.client.departmentdirector.form.MDepartmentDirectorSearchForm;
import com.pomplatform.client.myinvite.panel.MprojectAcceptTeamPanel;
import com.pomplatform.client.project.panel.SprojectccporPanelNew;
import com.pomplatform.client.projectlog.panel.SprojectlogppoorPanel;
import com.pomplatform.client.projectview.form.SprojectViewViewer;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class MDepartmentDirectorPanel extends AbstractSearchPanel {
    private static final Logger __logger = Logger.getLogger("");
    private String plateIds;
	private String[] plateIdArr;
    
    public static class Factory implements PanelFactory {
        private String id;
        @Override
        public Canvas create() {
            MDepartmentDirectorPanel cm = new MDepartmentDirectorPanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "MDepartmentDirector";
        }
    }

    @Override
	public void init() {
		super.init();
		resultGrid = new DelicacyListGrid(){
			@Override
			protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
				BigDecimal projectFinishPercent = BaseHelpUtils.getBigDecimalValue(record.getAttribute("projectFinishPercent"));
				BigDecimal totalFinishPercent = BaseHelpUtils.getBigDecimalValue(record.getAttribute("totalFinishPercent"));
				BigDecimal progressPercentage = BaseHelpUtils.getBigDecimalValue(record.getAttribute("progressPercentage"));
				BigDecimal leftSureIntegral = BaseHelpUtils.getBigDecimalValue(record.getAttribute("leftSureIntegral"));
				BigDecimal leftPlateSureIntegral = BaseHelpUtils.getBigDecimalValue(record.getAttribute("leftPlateSureIntegral"));
				BigDecimal hun = new BigDecimal(100);
				if(projectFinishPercent.compareTo(hun) > 0){
					record.setAttribute("projectFinishPercent",100);
				}
				if(totalFinishPercent.compareTo(hun) > 0){
					record.setAttribute("totalFinishPercent",100);
				}
				if(progressPercentage.compareTo(hun) > 0){
					record.setAttribute("progressPercentage",100);
				}
				if(leftSureIntegral.compareTo(BigDecimal.ZERO) < 0){
					record.setAttribute("leftSureIntegral",0);
				}
				if(leftPlateSureIntegral.compareTo(BigDecimal.ZERO) < 0){
					record.setAttribute("leftPlateSureIntegral",0);
				}
				//获取项目状态，如果项目暂停，则该行的字体颜色为红色，如果项目已结束，则该行的字体颜色为绿色
				int status = ClientUtil.checkAndGetIntValue(record.getAttribute("status"));
				if (status == ClientStaticUtils.PROJECT_STATUS_11) {  //项目已结束,标绿色
                    return "color:#00B736;";  
                } else if (status == ClientStaticUtils.PROJECT_STATUS_10) {  //项目暂停,标红色
                    return "color:#F01813;";  
                } else {  
                    return super.getCellCSSText(record, rowNum, colNum);  
                }  
			}
		};
		resultGrid.setDataSource(getDataSource());
    	resultGrid.setShowRowNumbers(true);
	}
    
    @Override
    public void initComponents() {
    	plateIds = PomPlatformClientUtil.getRolePlateId();
		plateIdArr = plateIds.split(",");
        resultGrid.setShowRowNumbers(true);
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
        
        IButton plateIntegralTransferButton = PermissionControl.createPermissionButton("部门积分转移", ERPPermissionStatic.PLATE_MANAGE_PLATE_TRANSFER_BUTTON);
        plateIntegralTransferButton.hide();
        controlLayout.addMember(plateIntegralTransferButton);
        plateIntegralTransferButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                GWT.runAsync(new RunAsyncCallback() {
                    @Override
                    public void onFailure(Throwable reason) {
                        SC.say("failure to download code");
                    }

                    @Override
                    public void onSuccess() {
                        PopupWindow popupWindow = new PopupWindow("部门积分转移");
                        popupWindow.setWidth("50%");
                        popupWindow.setHeight("60%");
                        popupWindow.centerInPage();
                        SetPlateIntegralTransfer translateIntegral = new SetPlateIntegralTransfer();
                        translateIntegral.addDataEditedHandler(new DataEditedHandler() {
                            @Override
                            public void onDataEdited(DataEditEvent event) {
                                SC.say("提示","操作成功");
                            }
                        });
                        translateIntegral.initComponents();
                        popupWindow.addItem(translateIntegral);
                        translateIntegral.setParentWindow(popupWindow);
                        popupWindow.centerInPage();
                        popupWindow.show();
                    }
                });
            }
        });
        
        IButton plateIntegralAssignButton = PermissionControl.createPermissionButton("部门积分发放", ERPPermissionStatic.PLATE_MANAGE_PLATE_ASSIGN_BUTTON);
        plateIntegralAssignButton.hide();
        controlLayout.addMember(plateIntegralAssignButton);
        plateIntegralAssignButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                GWT.runAsync(new RunAsyncCallback() {
                    @Override
                    public void onFailure(Throwable reason) {
                        SC.say("failure to download code");
                    }

                    @Override
                    public void onSuccess() {
                        SC.ask("提示","是否选择多人积分发放?",new BooleanCallback() {
                            @Override
                            public void execute(Boolean value) {
                                if(value){
                                    PopupWindow popupWindow = new PopupWindow("部门积分发放");
                                    popupWindow.setWidth("70%");
                                    popupWindow.setHeight("90%");
                                    popupWindow.centerInPage();
                                    SetPlateIntegralAssign assignIntegral = new SetPlateIntegralAssign();
                                    assignIntegral.addDataEditedHandler(new DataEditedHandler() {
                                        @Override
                                        public void onDataEdited(DataEditEvent event) {
                                            SC.say("提示","操作成功");
                                        }
                                    });
                                    assignIntegral.initComponents();
                                    popupWindow.addItem(assignIntegral);
                                    assignIntegral.setParentWindow(popupWindow);
                                    popupWindow.centerInPage();
                                    popupWindow.show();
                                }else{
                                    PopupWindow popupWindow = new PopupWindow("部门积分发放");
                                    popupWindow.setWidth("50%");
                                    popupWindow.setHeight("60%");
                                    popupWindow.centerInPage();
                                    SetPlateIntegralAssignOne assignIntegral = new SetPlateIntegralAssignOne();
                                    assignIntegral.addDataEditedHandler(new DataEditedHandler() {
                                        @Override
                                        public void onDataEdited(DataEditEvent event) {
                                            SC.say("提示","操作成功");
                                        }
                                    });
                                    assignIntegral.initComponents();
                                    popupWindow.addItem(assignIntegral);
                                    assignIntegral.setParentWindow(popupWindow);
                                    popupWindow.centerInPage();
                                    popupWindow.show();
                                }
                            }
                        });
                        
                    }
                });
            }
        });
        
        IButton operation2Button = PermissionControl.createPermissionButton("积分转移", ERPPermissionStatic.PLATE_MANAGE_PROJECT_ADD_BUTTON);
        operation2Button.hide();
        controlLayout.addMember(operation2Button);
        operation2Button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                GWT.runAsync(new RunAsyncCallback() {
                    @Override
                    public void onFailure(Throwable reason) {
                        SC.say("failure to download code");
                    }

                    @Override
                    public void onSuccess() {
                        PopupWindow popupWindow = new PopupWindow("项目积分转移");
                        popupWindow.setWidth("50%");
                        popupWindow.setHeight("60%");
                        popupWindow.centerInPage();
                        SetProjectIntegralTransfer translateIntegral = new SetProjectIntegralTransfer();
                        translateIntegral.addDataEditedHandler(new DataEditedHandler() {
                            @Override
                            public void onDataEdited(DataEditEvent event) {
                                commonQuery();
                            }
                        });
                        translateIntegral.initComponents();
                        popupWindow.addItem(translateIntegral);
                        translateIntegral.setParentWindow(popupWindow);
                        popupWindow.centerInPage();
                        popupWindow.show();
                    }
                });
            }
        });
        
        IButton operation3Button = PermissionControl.createPermissionButton("积分调整", ERPPermissionStatic.PLATE_MANAGE_PROJECT_TRANSFER_BUTTON);
        operation3Button.hide();
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
                        ListGridRecord[] selected = resultGrid.getSelectedRecords();
                        int projectId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("projectId"));
                        String projectName = selected[0].getAttribute("projectName");
                        double projectIntegral = ClientUtil.checkAndGetDoubleValue(selected[0].getAttribute("projectIntegral"));
                        double reserveIntegral = ClientUtil.checkAndGetDoubleValue(selected[0].getAttribute("reserveIntegral"));
                        PopupWindow popupWindow = new PopupWindow("项目("+projectName+")积分调整");
                        popupWindow.setWidth("50%");
                        popupWindow.setHeight("60%");
                        popupWindow.centerInPage();
                        SetProjectIntegralChange translateIntegral = new SetProjectIntegralChange();
                        translateIntegral.addDataEditedHandler(new DataEditedHandler() {
                            @Override
                            public void onDataEdited(DataEditEvent event) {
                                commonQuery();
                            }
                        });
                        translateIntegral.initComponents(projectName, projectId, projectIntegral, reserveIntegral);
                        popupWindow.addItem(translateIntegral);
                        translateIntegral.setParentWindow(popupWindow);
                        popupWindow.centerInPage();
                        popupWindow.show();
                    }
                });
            }
        });
        
        IButton assignIntegralButton = PermissionControl.createPermissionButton("积分发放", ERPPermissionStatic.PLATE_MANAGE_PROJECT_GRANT_BUTTON);
        assignIntegralButton.hide();
        controlLayout.addMember(assignIntegralButton);
        assignIntegralButton.hide();
        assignIntegralButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                GWT.runAsync(new RunAsyncCallback() {
                    @Override
                    public void onFailure(Throwable reason) {
                        SC.say("failure to download code");
                    }

                    @Override
                    public void onSuccess() {
                        PopupWindow popupWindow = new PopupWindow("积分发放");
                        popupWindow.setWidth("50%");
                        popupWindow.setHeight("60%");
                        popupWindow.centerInPage();
                        SetProjectIntegralAssign aggignIntegral = new SetProjectIntegralAssign();
                        aggignIntegral.addDataEditedHandler(new DataEditedHandler() {
                            @Override
                            public void onDataEdited(DataEditEvent event) {
                                commonQuery();
                            }
                        });
                        aggignIntegral.initComponents();
                        popupWindow.addItem(aggignIntegral);
                        aggignIntegral.setParentWindow(popupWindow);
                        popupWindow.centerInPage();
                        popupWindow.show();
                    }
                });
            }
        });
        
        IButton operation4Button = PermissionControl.createPermissionButton("项目成员", ERPPermissionStatic.PLATE_MANAGE_PROJECT_MEMBER_BUTTON);
        controlLayout.addMember(operation4Button);
        operation4Button.addClickHandler(new ClickHandler() {
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
                        String projectId = selected[0].getAttribute("projectId");
                        String projectName = selected[0].getAttribute("projectName");
                        PopupWindow pw = new PopupWindow();
                        MprojectAcceptTeamPanel myselfProject = new MprojectAcceptTeamPanel();
                        myselfProject.setProjectId(ClientUtil.checkAndGetIntValue(projectId));
                        pw.addItem(myselfProject.getViewPanel());
                        pw.setTitle(projectName+"项目组成员");
                        pw.setWidth100();
                        pw.setHeight100();
                        pw.centerInPage();
                        pw.show();
                        myselfProject.commonQuery();
                    }
                });
            }
        });
        
        final IButton operation5Button = PermissionControl.createPermissionButton("项目时间表", ERPPermissionStatic.PLATE_MANAGE_PROJECT_TIMER_BUTTON);
        controlLayout.addMember(operation5Button);
        operation5Button.addClickHandler(new ClickHandler() {
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
                        String projectId = selected[0].getAttribute("projectId");
                        PopupWindow pw = new PopupWindow();
                        SprojectccporPanelNew myselfProject = new SprojectccporPanelNew();
                        myselfProject.setProjectId(ClientUtil.checkAndGetIntValue(projectId));
                        pw.addItem(myselfProject.getViewPanel());
                        pw.setTitle("项目时间表");
                        pw.setWidth100();
                        pw.setHeight100();
                        pw.centerInPage();
                        pw.show();
                        myselfProject.commonQuery();
                    }
                });
            }
        });
        
        IButton operation6Button = PermissionControl.createPermissionButton("项目日志", ERPPermissionStatic.PLATE_MANAGE_PROJECT_LOGS_BUTTON);
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
                        String projectId = selected[0].getAttribute("projectId");
                        PopupWindow pw = new PopupWindow();
                        SprojectlogppoorPanel projectLog = new SprojectlogppoorPanel();
                        projectLog.setProjectId(ClientUtil.checkAndGetIntValue(projectId));
                        pw.addItem(projectLog.getViewPanel());
                        pw.setTitle("项目日志");
                        pw.setWidth100();
                        pw.setHeight100();
                        pw.centerInPage();
                        pw.show();
                        projectLog.commonQuery();
                    }
                });
            }
        });
        
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
						records[i] = recordList[i];
					}
					Record record = new Record();
					record.setAttribute("projectCode", "汇总");
					record.setAttribute("totalIntegral", totalIntegral);
					record.setAttribute("projectIntegral", projectIntegral);
					record.setAttribute("reserveIntegral", reserveIntegral);
					record.setAttribute("complaintIntegral", complaintIntegral);
					records[len] = record;
					resultGrid.setData(records);
					resultGrid.redraw();
					resultGrid.setCanEdit(false);
				}

			}
		});
        
        //默认执行一次查询
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
                if(ClientUtil.checkAndGetIntValue(record.getAttribute("projectId"))>0){
                	GenericViewWindow detail = new GenericViewWindow();
                    detail.setTitle("事业部负责人项目");
                    detail.setWidth100();
                    detail.setHeight100();
                    SprojectViewViewer detailForm = new SprojectViewViewer();
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
    public int getSearchFormHeight() {
        return 120; 
    }

    @Override
    public boolean checkSearchCriteria(Map criteria) {
    	String selectPlateId = BaseHelpUtils.getString(criteria.get("projectType"));
		if (!BaseHelpUtils.isNullOrEmpty(selectPlateId)) {
			for (String str : plateIdArr) {
				if (selectPlateId.equals(str)) {
					return true;
				}
			}
		}
		return false;
    }
    
    @Override
    public SearchForm generateSearchForm() {
        return new MDepartmentDirectorSearchForm();
    }

    @Override
    public DataSource getDataSource() {
        return DSMDepartmentDirector.getInstance();
    }

}
