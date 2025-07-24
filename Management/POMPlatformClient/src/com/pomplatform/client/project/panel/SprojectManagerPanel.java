package com.pomplatform.client.project.panel;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
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
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyListGrid;
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
import com.pomplatform.client.common.SyncDataUtil;
import com.pomplatform.client.platereportrecorddetail.panel.ProjectEmployeeAdvancePanel;
import com.pomplatform.client.project.datasource.DSSprojectccpor;
import com.pomplatform.client.project.form.NewSprojectccporForm;
import com.pomplatform.client.project.form.ProjectPerformanceSettlementPanel;
import com.pomplatform.client.project.form.SprojectManagerSearchForm;
import com.pomplatform.client.project.form.UpdateProjectManagerForm;
import com.pomplatform.client.projectview.form.SprojectViewViewer;
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
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class SprojectManagerPanel extends AbstractSearchPanel {
    private static final Logger __logger = Logger.getLogger("");
    public static class Factory implements PanelFactory {

        private String id;

        @Override
        public Canvas create() {
            SprojectManagerPanel cm = new SprojectManagerPanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "Sprojectccpor";
        }

    }

    @Override
    public void initComponents() {
        //默认执行一次查询
        commonQuery();
        resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
            @Override
            public void onDoubleClick(DoubleClickEvent event) {
                showDetail();
            }
        });
        final IButton operation1Button = new IButton("查看详情");
        controlLayout.addMember(operation1Button);
        operation1Button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                showDetail();
            }
        });
        final IButton operation2Button = new IButton("项目立项");
        operation2Button.hide();
        controlLayout.addMember(operation2Button);
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
                        NewSprojectccporForm detailForm = new NewSprojectccporForm();
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
        final IButton operation3Button = PermissionControl.createPermissionButton("阶段策划", ERPPermissionStatic.CONFIRMABLE_PHASES_LIST_ALLOT_BUTTON);
//        controlLayout.addMember(operation3Button);
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
                        Record selected = resultGrid.getSelectedRecords()[0];
                        Map map = selected.toMap();
                        
                        UpdateProjectManagerForm detailForm = new UpdateProjectManagerForm();
                    	detailForm.setTitle("阶段分配");
                    	detailForm.addDataEditedHandler(new DataEditedHandler() {
                    		@Override
                    		public void onDataEdited(DataEditEvent event) {
                    			commonQuery();
                    		}
                    	});
                    	detailForm.setSearchForm(searchForm);
                    	detailForm.setRecord(selected);
                    	detailForm.setCurrentPage(getCurrentPage());
                    	detailForm.initComponents();
                    	detailForm.startEdit();
                    	detailForm.setWidth("80%");
                    	detailForm.setHeight("80%");
                    	detailForm.centerInPage();
                    	detailForm.show();
                        

                    }
                });
            }
        });
        
        final IButton operation5Button = PermissionControl.createPermissionButton("团队组建", ERPPermissionStatic.INTEGRAL_MANAGE_PROJECT_TEAM_BUTTON);
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
                        Record selected = resultGrid.getSelectedRecords()[0];
                        //获取项目类型，如果是项目管理费，则无需进行手动结算
                        int businessType = BaseHelpUtils.getIntValue(selected.getAttribute("projectType"));
                        if(businessType == 16){//说明是项目管理费，则无需进行积分的结算
                        	SC.say("提示","该项目为项目管理费项目,无需手动组建团队");
                        	return;
                        }
                        if(businessType == 33){//说明是条线管理订单，无需手动组建团队
                        	SC.say("提示","该项目为条线管理项目,无需手动组建团队");
                        	return;
                        }
                        if(businessType == 88){//说明是部门预留，无需进行团队组建
                        	SC.say("提示","该项目为部门预留,无需进行团队组建");
                        	return;
                        }
                        int status = ClientUtil.checkAndGetIntValue(selected.getAttribute("status"));
                        if(status == ClientStaticUtils.PROJECT_STATUS_10){
                        	SC.say("提示","该项目已暂停，无法进行团队组建");
                        	return;
                        }else if(status == ClientStaticUtils.PROJECT_STATUS_11){
                        	SC.say("提示", "该项目已结项，无法进行团队组建");
                        	return;
                        }else if(status == ClientStaticUtils.PROJECT_STATUS_4) {
                        	SC.say("提示", "该项目未启动，无法进行团队组建");
                        	return;
                        }
                        
                        Map<String,Object> param = new LinkedHashMap<>();
                        param.put("projectId", BaseHelpUtils.getIntValue(selected.getAttribute("projectId")));
                        DBDataSource.callOperation("NQ_OnCheckProjectEmployeesProcess", "find", param, new DSCallback() {
                        	@Override
                        	public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                        		if (dsResponse.getStatus() >= 0) {
                        			if(dsResponse.getData().length<=0) {
                        				//获取流程process_id
                        				String processId = "";
                        				Storage sta = Storage.getLocalStorageIfSupported();
							String str = sta.getItem(PomPlatformClientUtil.PROCESS_ID_COOKIE);
                        				if(!PomPlatformClientUtil.isNullOrEmpty(str)){
                        					String[] arr = str.split(",");
                        					for(String tempStr : arr){
                        						String[] tempArr = tempStr.split(":");
                        						//获取父级ID
                        						if(tempArr[0].replaceAll("\"", "").equals("Project_Employee_Process_Application")){
                        							processId = tempArr[1];
                        						}
                        					}
                        				}
                                        NewProcessWindow panel = new NewProcessWindow();
                        				panel.setTitle("团队组建");
                        				panel.setProcessId(ClientUtil.checkAndGetIntValue(processId));
                        				panel.setLayoutMode(0);
                        				panel.addDataEditedHandler(new DataEditedHandler() {
                        					@Override
                        					public void onDataEdited(DataEditEvent event) {
                        						commonQuery();
                        					}
                        				});
                        				panel.setData(selected);
                        				panel.initComponents();
                        				panel.setWidth100();
                        				panel.setHeight100();
                        				panel.centerInPage();
                        				panel.show();
                        			}else {
                        				SC.say("该订单的团队组建流程进行中，请勿重复提交");
                        			}
                        		} else {
                        			@SuppressWarnings("rawtypes")
									Map errors = dsResponse.getErrors();
                        			SC.say("delete failure" + errors);
                        		}
                        	}
                        });
                        
                        

        			
                        
//                        int projectId = BaseHelpUtils.getIntValue(selected.getAttribute("projectId"));
//                        //检索该项目是否设定阶段，如果没有设定阶段，则不可进行团队
//                        Map<String,Object> param = new LinkedHashMap<>();
//                        param.put("projectId", projectId);
//                        DBDataSource.callOperation("ST_ProjectStage", "find", param, new DSCallback() {
//                        	@Override
//                        	public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//                        		if (dsResponse.getStatus() >= 0) {
//                        			if(dsResponse.getData().length > 0){//说明有设定阶段
//                        				UpdateSprojectteambuildForm detailForm = new UpdateSprojectteambuildForm();
//                        				detailForm.setTitle("团队组建");
//                        				detailForm.setSearchForm(searchForm);
//                        				detailForm.setRecord(selected);
//                        				detailForm.setCurrentPage(getCurrentPage());
//                        				detailForm.initComponents();
//                        				detailForm.startEdit();
//                        				detailForm.setWidth100();
//                        				detailForm.setHeight100();
//                        				detailForm.centerInPage();
//                        				detailForm.show();
//                        				detailForm.setShowMinimizeButton(false);
//                        				setCurrentPage(detailForm.getCurrentPage());
//                        			}else{
//                        				SC.say("提示", "该项目未设定阶段，无法进行团队组建");
//                                    	return;
//                        			}
//                        		} else {
//                        			@SuppressWarnings("rawtypes")
//									Map errors = dsResponse.getErrors();
//                        			SC.say("delete failure" + errors);
//                        		}
//                        	}
//                        });
                    }
                });
            }
        });
        
        IButton accountButton = new IButton("经费结算");
        controlLayout.addMember(accountButton);
        accountButton.addClickHandler(new ClickHandler() {
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

                        Record selected = resultGrid.getSelectedRecords()[0];

                        //获取项目类型，如果是项目管理费，则无需进行手动结算
                        int businessType = BaseHelpUtils.getIntValue(selected.getAttribute("projectType"));
                        if(businessType == 16){//说明是项目管理费，则无需进行积分的结算
                        	SC.say("提示","该项目为项目管理费项目,无需手动进行积分的结算");
                        	return;
                        }
                        if(businessType == 33){//说明是条线管理订单，无需手动进行积分的结算
                        	SC.say("提示","该项目为条线管理项目,无需手动进行积分的结算");
                        	return;
                        }
                        if(businessType == 30){//说明是采买成本，无需进行积分的结算
                        	SC.say("提示","该项目为采买成本,无需进行积分的结算");
                        	return;
                        }
                        if(businessType == 88){//说明是部门预留，无需进行积分的结算
                        	SC.say("提示","该项目为部门预留,无需进行积分的结算");
                        	return;
                        }
                        int projectPerformanceId = BaseHelpUtils.getIntValue(selected.getAttribute("projectPerformanceId"));
                        if(projectPerformanceId > 0){//说明该订单没有可计算的绩效积分
                        	SC.say("提示","该项目还有未结算的绩效积分");
                        	return;
                        }
                        int status = ClientUtil.checkAndGetIntValue(selected.getAttribute("status"));
                        if(status == ClientStaticUtils.PROJECT_STATUS_4) {
                        	SC.say("提示", "该项目未启动，无法进行经费结算");
                        	return;
                        }
                        if(status == ClientStaticUtils.PROJECT_STATUS_5) {
                        	SC.say("提示", "该项目无进度，无法进行经费结算");
                        	return;
                        }
                        boolean isLock = selected.getAttributeAsBoolean("isLock");
                        if(!isLock){
	                        int projectId = ClientUtil.checkAndGetIntValue(selected.getAttribute("projectId"));
	                        if(projectId == 0){
	                        	SC.say("无法获取项目代码");
	                        	return;
	                        }
	                        
	                        int contractId = ClientUtil.checkAndGetIntValue(selected.getAttribute("contractId"));
	                        if(contractId == 0){
	                        	SC.say("无法获取合同代码");
	                        	return;
	                        }
	                        
	                        int projectStatus = ClientUtil.checkAndGetIntValue(selected.getAttribute("status"));
	                        if(projectStatus == ClientStaticUtils.PROJECT_STATUS_11){
	                        	SC.say("该项目已结项，无法进行经费结算");
	                        	return;
	                        }
	                        //获取项目标示，如果是研发项目的话不允许修改
	                        int projetFlag = BaseHelpUtils.getIntValue(selected.getAttribute("projectFlag"));
                            //获取项目名称
//                        	String projectName = KeyValueManager.getValue("projects",String.valueOf(projectId));
                            String projectName = SyncDataUtil.getProjectName(projectId);
//                            SettlementPanel sp = new SettlementPanel();
//                            sp.setTitle("项目("+projectName+")的积分结算");
//                            sp.initComponents();
//                            sp.setProjectId(projectId);
//                            sp.setContractId(contractId);
//                            sp.setProjectFlag(projetFlag);
//                            sp.setProjectStatus(projectStatus);
//                            sp.load();
//                            sp.setWidth100();
//                            sp.setHeight100();
//                            sp.centerInPage();
//                            sp.show();
                            
                            Map<String,Object> param = new LinkedHashMap<>();
                            param.put("projectId", BaseHelpUtils.getIntValue(selected.getAttribute("projectId")));
                            DBDataSource.callOperation("NQ_GetCountProjectSettlementCountByProjectId", "find", param, new DSCallback() {
                            	@Override
                            	public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                            		if (dsResponse.getStatus() >= 0&&dsResponse.getData().length<=0) {
                            			//获取流程process_id
                        				String processId = "";
                        				Storage sta = Storage.getLocalStorageIfSupported();
							String str = sta.getItem(PomPlatformClientUtil.PROCESS_ID_COOKIE);
                        				if(!PomPlatformClientUtil.isNullOrEmpty(str)){
                        					String[] arr = str.split(",");
                        					for(String tempStr : arr){
                        						String[] tempArr = tempStr.split(":");
                        						//获取父级ID
                        						if(tempArr[0].replaceAll("\"", "").equals("Project_Settlement_Process_Application")){
                        							processId = tempArr[1];
                        						}
                        					}
                        				}
                                        NewProcessWindow panel = new NewProcessWindow();
                        				panel.setTitle("经费结算");
                        				panel.setProcessId(ClientUtil.checkAndGetIntValue(processId));
                        				panel.setLayoutMode(0);
                        				panel.addDataEditedHandler(new DataEditedHandler() {
                        					@Override
                        					public void onDataEdited(DataEditEvent event) {
                        						commonQuery();
                        					}
                        				});
                        				panel.setData(selected);
                        				panel.initComponents();
                        				panel.setWidth100();
                        				panel.setHeight100();
                        				panel.centerInPage();
                        				panel.show();
                            		}else {
                            			SC.say("提示","已有经费结算流程审批中，请勿重复申请");
                            			return;
                            		}
                            	}
                            });
	                    }else{
	                    	SC.say("该订单信息有变更，已被锁定，目前暂无法进行经费结算");
	                    }
                    }
                });
            }
        });
        
        IButton goBtn = new IButton("成员补贴");
        controlLayout.addMember(goBtn);
		goBtn.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
            	//获取当前积分管理归属业务部门
            	int plateId = ClientUtil.getPlateId();
                PopupWindow popupWindow = new PopupWindow("成员补贴");
                popupWindow.setWidth("70%");
                popupWindow.setHeight("90%");
                popupWindow.centerInPage();
                ProjectEmployeeAdvancePanel assignIntegral = new ProjectEmployeeAdvancePanel();
                assignIntegral.initComponents(2,plateId,0,BigDecimal.ZERO,BigDecimal.ZERO);
                assignIntegral.load(0);
                popupWindow.addItem(assignIntegral);
                assignIntegral.setParentWindow(popupWindow);
                popupWindow.centerInPage();
                popupWindow.show();
            }
        });
		
		IButton projectChangeBtn = new IButton("合同变更");
        controlLayout.addMember(projectChangeBtn);
        projectChangeBtn.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                PopupWindow popupWindow = new PopupWindow("合同变更积分分配");
                popupWindow.setWidth("70%");
                popupWindow.setHeight("90%");
                popupWindow.centerInPage();
                ProjectChangeIntegralAssignPanel assignIntegral = new ProjectChangeIntegralAssignPanel();
                assignIntegral.initComponents();
                popupWindow.addItem(assignIntegral);
                assignIntegral.setParentWindow(popupWindow);
                popupWindow.centerInPage();
                popupWindow.show();
            }
        });
        
        IButton performanceButton = new IButton("绩效管理");
        controlLayout.addMember(performanceButton);
        performanceButton.addClickHandler(new ClickHandler() {
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
                        int projectPerformanceId = BaseHelpUtils.getIntValue(selected[0].getAttribute("projectPerformanceId"));
                        if(projectPerformanceId == 0){//说明该订单没有可计算的绩效积分
                        	SC.say("提示","该项目没有可计算的绩效积分");
                        	return;
                        }
                        boolean isLock = selected[0].getAttributeAsBoolean("isLock");
                        if(!isLock){
	                        int projectId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("projectId"));
	                        //获取点单编号
	                        String contractCode = BaseHelpUtils.getString(selected[0].getAttribute("contractCode"));
	                        //获取项目名称
//	                        String projectName = KeyValueManager.getValue("projects",String.valueOf(projectId));
                            String projectName = SyncDataUtil.getProjectName(projectId);
                            if(projectId == 0){
	                            SC.say("无法获取项目代码");
	                            return;
	                        }
	                        ProjectPerformanceSettlementPanel sp = new ProjectPerformanceSettlementPanel();
	                        sp.setTitle("项目("+projectName+")的项目绩效结算");
	                        sp.setProjectId(projectId);
	                        sp.setSheetCodeValue(contractCode);
	                        sp.setSheetNameValue(projectName);
	                        sp.setProjectPerformanceId(projectPerformanceId);
	                        sp.initComponents();
	                        sp.load();
	                        sp.setWidth100();
	                        sp.setHeight100();
	                        sp.centerInPage();
	                        sp.show();
	                    }else{
	                    	SC.say("该订单信息有变更，已被锁定，目前暂无法进行经费结算");
	                    }
                    }
                });
            }
        });

//        final IButton operation4Button = new IButton("项目移除");
//        operation4Button.hide();
//        controlLayout.addMember(operation4Button);
//        operation4Button.addClickHandler(new ClickHandler() {
//            @Override
//            public void onClick(ClickEvent event) {
//                GWT.runAsync(new RunAsyncCallback() {
//                    @Override
//                    public void onFailure(Throwable reason) {
//                        SC.say("failure to download code");
//                    }
//
//                    @Override
//                    public void onSuccess() {
//                        if (!resultGrid.anySelected()) {
//                            SC.say("请选择一条数据修改");
//                            return;
//                        }
//                        ListGridRecord[] selected = resultGrid.getSelectedRecords();
//                        String projectId = selected[0].getAttribute("projectId");
//                        Map<String,Object> param = new LinkedHashMap<>();
//                        param.put("projectId", projectId);
//                        String message = MapUtils.toJSON(param);
//                        //删除方法
//                        DBDataSource.callOperation("EP_ProjectDelete", "delete", message, new DSCallback() {
//                            @Override
//                            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//                                if (dsResponse.getStatus() >= 0) {
//                                    SC.say("操作成功");
//                                    //执行成功后重新执行查询，刷新表格数据
//                                    commonQuery();
//                                } else {
//                                    Map errors = dsResponse.getErrors();
//                                    SC.say("delete failure" + errors);
//                                }
//                            }
//                        });
//                    }
//                });
//            }
//        });


//        final IButton submitButton = PermissionControl.createPermissionButton("提交审核", ERPPermissionStatic.INTEGRAL_MANAGE_PROJECT_FORMATION_BUTTON);
//        controlLayout.addMember(submitButton);
//        submitButton.setIcon("[SKIN]/actions/approve.png");
//        submitButton.addClickHandler(new ClickHandler() {
//            @Override
//            public void onClick(ClickEvent event) {
//                GWT.runAsync(new RunAsyncCallback() {
//                    @Override
//                    public void onFailure(Throwable reason) {
//                        SC.say("failure to download code");
//                    }
//
//                    @Override
//                    public void onSuccess() {
//                        if (!resultGrid.anySelected()) {
//                            SC.say("请选择一条数据修改");
//                            return;
//                        }
//                        SC.confirm("提示", "您确认要对该项目进行审核吗?", new BooleanCallback() {
//                            @Override
//                            public void execute(Boolean value) {
//                                if(value){
//                                    ListGridRecord[] selected = resultGrid.getSelectedRecords();
//                                    String projectId = selected[0].getAttribute("projectId");
//                                    int status = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("status"));
//                                    if (status > 0) {
//                                        SC.say("该项目不可再进行提交审核操作");
//                                    } else {
//                                        Map param = new LinkedHashMap();
//                                        param.put("projectId", projectId);
//                                        param.put("status", 1);//项目待审核为：1
//                                        final String message = MapUtils.toJSON(param);
//                                        //检索项目是否可以提交审核（只有邀请的所有成员都接受邀请后，方可提交审核）
//                                        DBDataSource.callOperation("EP_ProjectInviteCheck", "check", message, new DSCallback() {
//                                            @Override
//                                            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//                                                switch (dsResponse.getStatus()) {
//                                                    case 1:
//                                                        //表示有未接受邀请的成员
//                                                        SC.say("该项目还有未接受邀请的成员，不可提交审核");
//                                                        break;
//                                                    case 2:
//                                                        //表示有拒绝邀请的成员
//                                                        SC.say("该项目中已有成员谢绝邀请，请重新组建成员");
//                                                        break;
//                                                    case 0:
//                                                        //项目暂缓方法
//                                                        DBDataSource.callOperation("EP_ProjectSubmitAudit", "update", message, new DSCallback() {
//                                                            @Override
//                                                            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//                                                                if (dsResponse.getStatus() >= 0) {
//                                                                    SC.say("操作成功");
//                                                                    //执行成功后重新执行查询，刷新表格数据
//                                                                    commonQuery();
//                                                                } else {
//                                                                    SC.say("操作失败");
//                                                                }
//                                                            }
//                                                        });
//                                                        break;
//                                                    default:
//                                                        break;
//                                                }
//                                            }
//                                        });
//                                    }
//                                }
//                            }
//                        });
//                    }
//                });
//            }
//        });

//        final IButton operation6Button = new IButton("下一阶段");
//        operation6Button.hide();
//        controlLayout.addMember(operation6Button);
//        operation6Button.addClickHandler(new ClickHandler() {
//            @Override
//            public void onClick(ClickEvent event) {
//                GWT.runAsync(new RunAsyncCallback() {
//                    @Override
//                    public void onFailure(Throwable reason) {
//                        SC.say("failure to download code");
//                    }
//
//                    @Override
//                    public void onSuccess() {
//                        if (!resultGrid.anySelected()) {
//                            SC.say("请选择一条数据修改");
//                            return;
//                        }
//                        SC.confirm("提示","您确认要进行下一步操作吗?", new BooleanCallback() {
//                            @Override
//                            public void execute(Boolean value) {
//                                if(value){
//                                    ListGridRecord[] selected = resultGrid.getSelectedRecords();
//                                    String projectId = selected[0].getAttribute("projectId");
//                                    int status = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("status"));
//                                    int designPhase = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("designPhase"));
//                                    int projectManageId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("projectManageId"));
//                                    int departmentId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("departmentId"));
//                                    switch (status) {
//                                        case 0:
//                                            SC.say("该项目未审核，不可进行下一阶段");
//                                            break;
//                                        case -1:
//                                            SC.say("该项目已审核无效，无需进行下一阶段操作");
//                                            break;
//                                        case 2:
//                                            SC.say("该项目已完成，不可进行下一阶段操作");
//                                            break;
//                                        default:
//                                            Map param = new LinkedHashMap();
//                                            param.put("projectId", projectId);
//                                            param.put("designPhase", designPhase);
//                                            param.put("projectManageId", projectManageId);
//                                            param.put("departmentId", departmentId);
//                                            String message = MapUtils.toJSON(param);
//                                            //项目暂缓方法
//                                            DBDataSource.callOperation("EP_ProjectEnterNext", "update", message, new DSCallback() {
//                                                @Override
//                                                public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//                                                    if (dsResponse.getStatus() >= 0) {
//                                                        SC.say("操作成功");
//                                                        //执行成功后重新执行查询，刷新表格数据
//                                                        commonQuery();
//                                                    } else {
//                                                        Map errors = dsResponse.getErrors();
//                                                        SC.say("delete failure" + errors);
//                                                    }
//                                                }
//                                            });
//                                            break;
//                                    }
//                                }
//                            }
//                        });
//                    }
//                });
//            }
//        });

//        final IButton operation7Button = new IButton("项目暂缓");
//        operation7Button.hide();
//        controlLayout.addMember(operation7Button);
//        operation7Button.addClickHandler(new ClickHandler() {
//            @Override
//            public void onClick(ClickEvent event) {
//                GWT.runAsync(new RunAsyncCallback() {
//                    @Override
//                    public void onFailure(Throwable reason) {
//                        SC.say("failure to download code");
//                    }
//
//                    @Override
//                    public void onSuccess() {
//                        if (!resultGrid.anySelected()) {
//                            SC.say("请选择一条数据修改");
//                            return;
//                        }
//                        SC.confirm("提示","您确认要进行项目暂缓操作吗?", new BooleanCallback() {
//                            @Override
//                            public void execute(Boolean value) {
//                                if(value){
//                                    ListGridRecord[] selected = resultGrid.getSelectedRecords();
//                                    String projectId = selected[0].getAttribute("projectId");
//                                    int status = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("status"));
//                                    switch (status) {
//                                        case 0:
//                                            SC.say("该项目未审核，不可进行暂缓操作");
//                                            break;
//                                        case 1:
//                                            SC.say("该项目待审核，不可进行暂缓操作");
//                                            break;
//                                        case 10:
//                                            SC.say("该项目已暂停，不可进行暂缓操作");
//                                            break;
//                                        case 11:
//                                            SC.say("该项目已完成，不可进行暂缓操作");
//                                            break;
//                                        case 3:
//                                            SC.say("该项目已暂缓，无需再次操作");
//                                            break;
//                                        default:
//                                            Map param = new LinkedHashMap();
//                                            param.put("projectId", projectId);
//                                            param.put("status", 3);//项目暂缓状态值为：3
//                                            String message = MapUtils.toJSON(param);
//                                            //项目暂缓方法
//                                            DBDataSource.callOperation("EP_ProjectStatus", "update", message, new DSCallback() {
//                                                @Override
//                                                public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//                                                    if (dsResponse.getStatus() >= 0) {
//                                                        SC.say("操作成功");
//                                                        //执行成功后重新执行查询，刷新表格数据
//                                                        commonQuery();
//                                                    } else {
//                                                        Map errors = dsResponse.getErrors();
//                                                        SC.say("delete failure" + errors);
//                                                    }
//                                                }
//                                            });
//                                            break;
//                                    }
//                                }
//                            }
//                        });
//                    }
//                });
//            }
//        });
        final IButton operation8Button = PermissionControl.createPermissionButton("订单暂停", ERPPermissionStatic.INTEGRAL_MANAGE_MANAGEMENT_PAUSE_BUTTON);
        controlLayout.addMember(operation8Button);
        operation8Button.addClickHandler(new ClickHandler() {
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
                        operation8Button.setDisabled(true);
                        Record selected = resultGrid.getSelectedRecord();
                        String projectId = selected.getAttribute("projectId");
                        int status = ClientUtil.checkAndGetIntValue(selected.getAttribute("status"));
                        switch (status) {
                        case ClientStaticUtils.PROJECT_STATUS_10:
                        	SC.say("该订单已暂停，无需再次操作");
                        	operation8Button.setDisabled(false);
                        	return;
                        case ClientStaticUtils.PROJECT_STATUS_11:
                        	SC.say("该订单已结项，不可进行暂停操作");
                        	operation8Button.setDisabled(false);
                        	return;
                        case ClientStaticUtils.PROJECT_STATUS_14:
                        	SC.say("该订单正在终止结算中，不可以进行暂停操作");
                        	operation8Button.setDisabled(false);
                        	return;
                        case ClientStaticUtils.PROJECT_STATUS_15:
                        	SC.say("该订单已终止，不可以进行暂停操作");
                        	operation8Button.setDisabled(false);
                        	return;
                        default:
                        	SC.confirm("提示","您确定要进行订单暂停操作吗?", new BooleanCallback() {
                                @Override
                                public void execute(Boolean value) {
                                    if(BaseHelpUtils.getBoolean(value)){
                                    	Map<String, Object> params = new HashMap<>();
										params.put("optType", "changeProjectStatus");
										params.put("projectId", projectId);
										params.put("status", ClientStaticUtils.PROJECT_STATUS_10);
										DBDataSource.callOperation("EP_ProjectProcessor", params, new DSCallback() {

											@Override
											public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
												if(dsResponse.getStatus() >= 0){
													SC.say("操作成功");
													selected.setAttribute("status",  ClientStaticUtils.PROJECT_STATUS_10);
			                        				resultGrid.updateData(selected);
												}else {
													ClientUtil.displayErrorMessage(dsResponse);
												}
												operation8Button.setDisabled(false);
											}
										});
                                    }else {
                                    	operation8Button.setDisabled(false);
                                    }
                                }
                            });
                        }
                    }
                });
            }
        });
        
        
        
        final IButton noneButton = PermissionControl.createPermissionButton("项目无进度", ERPPermissionStatic.INTEGRAL_MANAGE_PROJECT_none_BUTTON);
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
									}else {
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
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

        
        IButton totalButton = new IButton("汇总");
		controlLayout.addMember(totalButton);
		totalButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				ListGridRecord[] recordList = resultGrid.getRecords();
				int len = recordList.length;
				Record[] records = new Record[len + 1];
				if (len > 0) {
					double projectIntegral = 0;
					for (int i = 0; i < len; i++) {
						if ("汇总".equals(recordList[i].getAttribute("projectCode"))) {// 如果已经存在汇总，则不可再进行汇总
							return;
						}
						projectIntegral += ClientUtil
								.checkAndGetDoubleValue(recordList[i].getAttribute("projectIntegral"));
						records[i] = recordList[i];
					}
					Record record = new Record();
					record.setAttribute("projectCode", "汇总");
					record.setAttribute("projectIntegral", projectIntegral);
					records[len] = record;
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
                ListGridRecord record = resultGrid.getSelectedRecord();
                if(ClientUtil.checkAndGetIntValue(record.getAttribute("projectId"))>0){
                	GenericViewWindow detail = new GenericViewWindow();
                	detail.setTitle("项目详情");
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
    public boolean checkSearchCriteria(Map criteria) {
        //只检索当前登录的项目经理的项目数据
        criteria.put("projectManageId", Cookies.getCookie(ClientUtil.OPRERATORID_COOKIE));
        return true;
    }
    
    //根据行内某字段的值改变行字体颜色
    @Override
	public Canvas generateHDataCanvas() {
		resultGrid = new DelicacyListGrid() {
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
				//获取项目绩效主键ID，如果大于0,说明是有奖励或扣除积分,则背景色为浅绿色
				int projectPerformanceId = BaseHelpUtils.getIntValue(record.getAttribute("projectPerformanceId"));
				//获取项目状态，如果项目暂停，则该行的字体颜色为红色，如果项目已结束，则该行的字体颜色为绿色
				int status = ClientUtil.checkAndGetIntValue(record.getAttribute("status"));
				StringBuilder sb = new StringBuilder();
				if(projectPerformanceId > 0){
					sb.append("background-color: #c7edcc;");
				}
				if(status == ClientStaticUtils.PROJECT_STATUS_11){
					sb.append("color:#00B736;");
				}else if(status == ClientStaticUtils.PROJECT_STATUS_10){
					sb.append("color:#F01813;");
				}else if(status == ClientStaticUtils.PROJECT_STATUS_5) {
					return "color:#DAA520;"; //项目无进度变为橘黄色
				}
				if(sb.length() > 0){
					return sb.toString();
				}else{
					return super.getCellCSSText(record, rowNum, colNum);
				}
			}
		};
		resultGrid.setDataSource(getDataSource());
		resultGrid.setWidth100();
		resultGrid.setHeight100();
		return resultGrid;
	}

    @Override
    public SearchForm generateSearchForm() {
        return new SprojectManagerSearchForm();
    }

    @Override
    public DataSource getDataSource() {
        return DSSprojectccpor.getInstance();
    }

    @Override
    public int getSearchFormHeight() {
        return 120;
    }

    @Override
    public void afterDataReceived(Record[] data) {
        String noShowSummaryFields = "contractCode,contractName,customerName,officeType,departmentId,electromechanicalType,designPhase,oldProjectDiscount,projectType,projectCode,projectName,planStartDate,planEndDate,startDate,endDate,status,projectProgress,projectManageId,projectManageName,projectSize,projectDescription,auditReason,projectLevel,plateId";
        ClientUtil.setNoShowSummaryFields(resultGrid, noShowSummaryFields);
    }

}
