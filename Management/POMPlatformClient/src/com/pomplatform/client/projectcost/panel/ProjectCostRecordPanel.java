package com.pomplatform.client.projectcost.panel;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.ViewProcessWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.projectcost.datasource.DSProjectCostRecord;
import com.pomplatform.client.projectcost.form.ProjectCostRecordSearchForm;
import com.pomplatform.client.projectcost.form.ProjectCostRecordViewer;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
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
public class ProjectCostRecordPanel extends AbstractSearchPanel {
	private static final Logger logger = Logger.getLogger("");
	private String plateIds;
	private String[] plateIdArr;

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			ProjectCostRecordPanel cm = new ProjectCostRecordPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ProjectCostRecord";
		}

	}

	@Override
	public void initComponents() {
		resultGrid.setAutoFitFieldWidths(false);
		plateIds = PomPlatformClientUtil.getRolePlateId();
		plateIdArr = plateIds.split(",");
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

		IButton totalButton = new IButton("汇总");
		controlLayout.addMember(totalButton);
		totalButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				ListGridRecord[] recordList = resultGrid.getRecords();
				int len = recordList.length;
				Record[] records = new Record[len + 1];
				if (len > 0) {
					double amount = 0;
					for (int i = 0; i < len; i++) {
						if ("汇总".equals(recordList[i].getAttribute("plateId"))) {// 如果已经存在汇总，则不可再进行汇总
							return;
						}
						amount += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("amount"));
						records[i] = recordList[i];
					}
					Record record = new Record();
					record.setAttribute("plateId", "汇总");
					record.setAttribute("amount", amount);
					records[len] = record;
					resultGrid.setData(records);
					resultGrid.redraw();
					resultGrid.setCanEdit(false);
				}
			}
		});

		IButton dealButton = new IButton("正负抵消");
		controlLayout.addMember(dealButton);
		dealButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()) {
							SC.say("请选择需要抵消的成本");
							return;
						}
						Record[] records = resultGrid.getSelectedRecords();
						int projectId = BaseHelpUtils.getIntValue(records[0].getAttribute("projectId"));
						StringBuilder sb = new StringBuilder();
						for(Record r : records) {
							if(BaseHelpUtils.getIntValue(r.getAttribute("projectId")) != projectId) {
								SC.say("不是同一个项目，成本无法抵消");
								return;
							}
							if(BaseHelpUtils.getIntValue(r.getAttribute("status")) > 0) {
								SC.say("选中的数据中包含了已结算的成本");
								return;
							}
							if(sb.length() > 0) {
								sb.append(",");
							}
							sb.append(r.getAttribute("projectCostId"));
						}
						Map<String, String> params = new HashMap<>();
						params.put("optType", "settlementProjectCost");
						params.put("ids", sb.toString());
						DBDataSource.callOperation("EP_ProjectProcessor", params, new DSCallback() {
							
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								if(dsResponse.getStatus() >= 0) {
									SC.say("抵消成功");
									commonQuery();
								}else {
									ClientUtil.displayErrorMessage(dsResponse);
								}
							}
						});
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				});
			}
		});
		
		IButton downLoadButton = new IButton("导出");
		controlLayout.addMember(downLoadButton);
		downLoadButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Map condition = generateCriteria();
				ClientUtil.departmentParameterProcess(condition);
				DBDataSource.downloadFile("DW_ProjectCostRecord", condition);
			}
		});
		
		
        final IButton Button = PermissionControl.createPermissionButton("采买项目成本结算", ERPPermissionStatic.PROJECT_COST_30_BUTTON);
		controlLayout.addMember(Button);
		Button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(!resultGrid.anySelected()) {
					SC.say("请选择需要结算的采买项目成本");
					return;
				}
				
				SC.ask("提示", "您确认要对当前选中的项目成本进行结算吗?", new BooleanCallback() {
					@Override
					public void execute(Boolean value) {
						if (value) {
							SC.debugger();
							Record[] records = resultGrid.getSelectedRecords();
							StringBuilder sb = new StringBuilder();
							for(Record r : records) {
								Integer projectType = BaseHelpUtils.getIntValue(r.getAttributeAsInt("projectType"));
								Integer projectCostId = BaseHelpUtils.getIntValue(r.getAttributeAsInt("projectCostId"));
								if(projectType==30&&projectCostId>0) {//采买项目
									if(sb.length() > 0) {
										sb.append(",");
									}
									sb.append(projectCostId);
								}
							}
							
							Map<String, String> params = new HashMap<>();
							params.put("optType", "PurchaseProjectCost");
							params.put("ids", sb.toString());
							DBDataSource.callOperation("EP_ProjectProcessor", params, new DSCallback() {
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if(dsResponse.getStatus() >= 0) {
										SC.say("结算成功");
										commonQuery();
									}else {
										ClientUtil.displayErrorMessage(dsResponse);
									}
								}
							});
						}
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
				Record selected = resultGrid.getSelectedRecords()[0];
				//如果是报销流转过来的数据，则看报销单的内容
				if(ClientUtil.checkAndGetIntValue(selected.getAttribute("processInstanceId")) > 0 && ClientUtil.checkAndGetIntValue(selected.getAttribute("processId")) > 0 && ClientUtil.checkAndGetIntValue(selected.getAttribute("processType")) > 0){
					ViewProcessWindow Reimbursement = new ViewProcessWindow();
	                Reimbursement.setWidth("80%");
	                Reimbursement.setHeight("80%");
	                Reimbursement.setLayoutMode(0);
	                Reimbursement.setInstanceData(selected);
	                Reimbursement.initComponents();
	                Reimbursement.setTitle(ClientUtil.getProcessTypeName(selected));
	                Reimbursement.show();
				}else{
					GenericViewWindow detail = new GenericViewWindow();
					detail.setTitle("项目成本");
					detail.setWidth100();
					detail.setHeight100();
					ProjectCostRecordViewer detailForm = new ProjectCostRecordViewer();
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
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public boolean checkSearchCriteria(Map criteria) {
		// 如果拥有查看所有部门数据和自己管理部门的权限，则只能查看自己参与项目
//		if (!ClientUtil.checkIsHavePermission(ERPPermissionStatic.PROJECT_COST_CHECK_ALL) && !ClientUtil.checkIsHavePermission(ERPPermissionStatic.PROJECT_COST_MY_PLATE)) {
//			int projectManageId = ClientUtil.getEmployeeId();
//			criteria.put("projectManageId",projectManageId);
//		}
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new ProjectCostRecordSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSProjectCostRecord.getInstance();
	}

	@Override
	public int getSearchFormHeight() {
		return 140;
	}

}
