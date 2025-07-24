package com.pomplatform.client.projectperformance.panel;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractExpansionRelatedPage;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.projectperformance.datasource.DSContractProjectPerformance;
import com.pomplatform.client.projectperformance.datasource.DSFindProjectInfoByContractId;
import com.pomplatform.client.projectperformance.form.ContractProjectPerformanceSearchForm;
import com.pomplatform.client.projectperformance.form.ContractProjectPerformanceViewer;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;

public class ContractProjectPerformancePanel extends AbstractExpansionRelatedPage
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ContractProjectPerformancePanel cm = new ContractProjectPerformancePanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ContractProjectPerformance";
		}

	}

//	@Override
//	public void init(){
//		super.init();
//		__controlPosition = LayoutConstant.RIGHT;
//	}

	@Override
	public void initComponents() {
		resultGrid.setAutoFitFieldWidths(false);
		resultGrid.setShowRowNumbers(true);
		resultGrid.setShowGridSummary(true);
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
		
		IButton viewButton = new IButton("查看详细");
		viewButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		controlLayout.addMember(viewButton);
		
		IButton awardButton = PermissionControl.createPermissionButton("绩效奖励", ERPPermissionStatic.CONTRACT_PERFORMANCE_AWARD_BUTTON);
		awardButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				if(!resultGrid.anySelected()){
					SC.say("请选择一条记录");
				}else{
					Record record = new Record();
					String[] properties = {"contractId","projectManageIntegral","projectManageSureIntegral","deductIntegral","awardIntegral","projectManageId"};
					record.copyAttributesInto(record, resultGrid.getSelectedRecords()[0], properties);
					Map<String, Object> params = new HashMap<>();
					params.put("contractId", record.getAttribute("contractId"));
					params.put("employeeId", record.getAttribute("projectManageId"));
					params.put("businessType", 1);
					params.put("performanceFlag", 2);
					params.put("optType", "hasADraft");
					DBDataSource.callOperation("EP_ProjectPerformanceProcess", params, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if(dsResponse.getStatus() >= 0){
								Record dataRecord = dsResponse.getData()[0];
								record.setAttribute("projectPerformanceId", dataRecord.getAttribute("projectPerformanceId"));
								record.setAttribute("percent", dataRecord.getAttribute("percent"));
								record.setAttribute("performanceIntegral", dataRecord.getAttribute("performanceIntegral"));
								record.setAttribute("recordDate", dataRecord.getAttributeAsDate("recordDate"));
								record.setAttribute("reason", dataRecord.getAttribute("reason"));
								record.setAttribute("remark", dataRecord.getAttribute("remark"));
							}
							PopupWindow window = new PopupWindow("绩效奖励");
							window.setWidth100();
							window.setHeight100();
							ContractPerformanceDetailNewPanel panel = new ContractPerformanceDetailNewPanel();
							panel.addDataEditedHandler(new DataEditedHandler() {
								@Override
								public void onDataEdited(DataEditEvent event) {
									commonQuery();									
								}
							});
							panel.setPerformanceFlag(2);
							panel.setRecord(record);
							panel.initData();
							window.addMember(panel);
							window.centerInPage();
							window.show();
						}
					});
				}
			}
		});
		controlLayout.addMember(awardButton);
		
		IButton deductButton = PermissionControl.createPermissionButton("绩效扣除", ERPPermissionStatic.CONTRACT_PERFORMANCE_DEDUCT_BUTTON);
		deductButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				if(!resultGrid.anySelected()){
					SC.say("请选择一条记录");
				}else{
					Record record = new Record();
					String[] properties = {"contractId","projectManageIntegral","projectManageSureIntegral","deductIntegral","awardIntegral","projectManageId"};
					record.copyAttributesInto(record, resultGrid.getSelectedRecords()[0], properties);
					Map<String, Object> params = new HashMap<>();
					params.put("contractId", record.getAttribute("contractId"));
					params.put("employeeId", record.getAttribute("projectManageId"));
					params.put("businessType", 1);
					params.put("performanceFlag", 1);
					params.put("optType", "hasADraft");
					DBDataSource.callOperation("EP_ProjectPerformanceProcess", params, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if(dsResponse.getStatus() >= 0){
								Record dataRecord = dsResponse.getData()[0];
								record.setAttribute("projectPerformanceId", dataRecord.getAttribute("projectPerformanceId"));
								record.setAttribute("percent", dataRecord.getAttribute("percent"));
								record.setAttribute("performanceIntegral", dataRecord.getAttribute("performanceIntegral"));
								record.setAttribute("recordDate", dataRecord.getAttributeAsDate("recordDate"));
								record.setAttribute("reason", dataRecord.getAttribute("reason"));
								record.setAttribute("remark", dataRecord.getAttribute("remark"));
							}
							PopupWindow window = new PopupWindow("绩效扣除");
							window.setWidth100();
							window.setHeight100();
							ContractPerformanceDetailNewPanel panel = new ContractPerformanceDetailNewPanel();
							panel.addDataEditedHandler(new DataEditedHandler() {
								@Override
								public void onDataEdited(DataEditEvent event) {
									commonQuery();									
								}
							});
							panel.setPerformanceFlag(1);
							panel.setRecord(record);
							panel.initData();
							window.addMember(panel);
							window.centerInPage();
							window.show();
						}
					});
				}
			}
		});
		controlLayout.addMember(deductButton);
		
		IButton sheetButton = new IButton("订单绩效管理");
		sheetButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				PopupWindow window = new PopupWindow();
				window.setTitle("订单绩效管理");
				window.setWidth100();
				window.setHeight100();
				SheetPerformancePanel panel = new SheetPerformancePanel();
				panel.commonQuery();
				window.addMember(panel);
				window.centerInPage();
				window.show();
			}
		});
		controlLayout.addMember(sheetButton);
		
		IButton detailButton = new IButton("历史考核明细");
		detailButton.hide();
		detailButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(resultGrid.anySelected()){
					Record record = resultGrid.getSelectedRecords()[0];
					PopupWindow window = new PopupWindow();
					window.setTitle("历史考核明细");
					window.setWidth100();
					window.setHeight100();
					ProjectPerformanceDetailPanel panel = new ProjectPerformanceDetailPanel();
					panel.setContractId(record.getAttribute("contractId"));
					panel.setEmployeeId(record.getAttribute("projectManageId"));
					panel.setBusinessType(1);
					panel.reDrawResultGrid();
					panel.commonQuery();
					window.addMember(panel);
					window.centerInPage();
					window.show();
				}else{
					SC.say("请先选择您要查看的项目");
				}		
			}
		});
		controlLayout.addMember(detailButton);
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
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("合同项目绩效"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				ContractProjectPerformanceViewer detailForm = new ContractProjectPerformanceViewer();
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
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new ContractProjectPerformanceSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSContractProjectPerformance.getInstance();
	}

	@Override
	public DataSource getChildDataSource() {
		return DSFindProjectInfoByContractId.getInstance();
	}
	
	@Override
	public void setChildGridOption(ListGrid resultChildGrid) {
		resultChildGrid.setShowGridSummary(true);
		ListGridField [] fields = new ListGridField[16];
		int index = 0;
		fields[index] = new ListGridField("plateId");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("sheetCode");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("sheetName");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("sheetAmount");
		index ++;
		fields[index] = new ListGridField("totalIntegral");
		fields[index].setHidden(true);
		index ++;
		fields[index] = new ListGridField("projectIntegral");
		fields[index].setHidden(true);
		index ++;
		fields[index] = new ListGridField("reserveIntegral");
		fields[index].setHidden(true);
		index ++;
		fields[index] = new ListGridField("complaintIntegral");
		index ++;
		fields[index] = new ListGridField("sureIntegral");
		fields[index].setHidden(true);
		index ++;
		fields[index] = new ListGridField("projectCost");
		fields[index].setHidden(true);
		index ++;
		fields[index] = new ListGridField("deductIntegral");
		index ++;
		fields[index] = new ListGridField("awardIntegral");
		index ++;
		fields[index] = new ListGridField("finishPercent");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("totalRevenue");
		index ++;
		fields[index] = new ListGridField("leftIntegral");
		index ++;
		fields[index] = new ListGridField("projectManageId");
		fields[index].setShowGridSummary(false);
		resultChildGrid.setFields(fields);
	}

	@Override
	public Canvas[] getChildGridOptionCanvas() {
		resultChildGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				if(resultChildGrid.anySelected()){
					Record record = resultChildGrid.getSelectedRecords()[0];
					PopupWindow window = new PopupWindow();
					window.setTitle("历史考核明细");
					window.setWidth100();
					window.setHeight100();
					ProjectPerformanceDetailPanel panel = new ProjectPerformanceDetailPanel();
					panel.setContractId(record.getAttribute("contractId"));
					panel.setProjectId(record.getAttribute("projectId"));
					panel.setBusinessType(2);
					panel.reDrawResultGrid();
					panel.commonQuery();
					window.addMember(panel);
					window.centerInPage();
					window.show();	
				}else{
					SC.say("请先选择您要查看的订单");
				}	
			}
		});
		
		Canvas [] canvas = new Canvas[2];
		IButton awardButton = PermissionControl.createPermissionButton("绩效奖励", ERPPermissionStatic.PROJECT_PERFORMANCE_AWARD_BUTTON);
		awardButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(resultChildGrid.anySelected()){
					if(resultChildGrid.anySelected()){
						Record selected = resultChildGrid.getSelectedRecords()[0];
						if(ClientUtil.checkAndGetIntValue(selected.getAttribute("status")) == ClientStaticUtils.PROJECT_STATUS_11){
							SC.say("该项目已结项，无法进行此操作");
							return;
						}
						Record record = new Record();
						String[] properties = {"contractId","projectId", "plateId", "complaintIntegral", "sureIntegral", "deductIntegral", "awardIntegral","leftIntegral"};
						record.copyAttributesInto(record, selected, properties);
						Map<String, Object> params = new HashMap<>();
						params.put("contractId", record.getAttribute("contractId"));
						params.put("projectId", record.getAttribute("projectId"));
						params.put("businessType", 2);
						params.put("performanceFlag", 2);
						params.put("optType", "hasADraft");
						DBDataSource.callOperation("EP_ProjectPerformanceProcess", params, new DSCallback() {
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								if(dsResponse.getStatus() >= 0){
									Record dataRecord = dsResponse.getData()[0];
									record.setAttribute("projectPerformanceId", dataRecord.getAttribute("projectPerformanceId"));
									record.setAttribute("percent", dataRecord.getAttribute("percent"));
									record.setAttribute("performanceIntegral", dataRecord.getAttribute("performanceIntegral"));
									record.setAttribute("recordDate", dataRecord.getAttributeAsDate("recordDate"));
									record.setAttribute("reason", dataRecord.getAttribute("reason"));
									record.setAttribute("remark", dataRecord.getAttribute("remark"));
								}
								PopupWindow window = new PopupWindow("绩效扣除");
								window.setWidth100();
								window.setHeight100();
								ProjectPerformanceDetailNewPanel panel = new ProjectPerformanceDetailNewPanel();
								panel.addDataEditedHandler(new DataEditedHandler() {
									@Override
									public void onDataEdited(DataEditEvent event) {
										resultChildGrid.refreshData();							
									}
								});
								panel.setPerformanceFlag(2);
								panel.setRecord(record);
								panel.initData();
								window.addMember(panel);
								window.centerInPage();
								window.show();
							}
						});
					}else{
						SC.say("请选择一条订单记录再进行绩效扣除操作");
					}
				}else{
					SC.say("请选择一条订单记录再进行绩效奖励操作");
				}
				
			}
		});
		IButton deductButton = PermissionControl.createPermissionButton("绩效扣除", ERPPermissionStatic.PROJECT_PERFORMANCE_DEDUCT_BUTTON);
		deductButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(resultChildGrid.anySelected()){
					Record selected = resultChildGrid.getSelectedRecords()[0];
					if(ClientUtil.checkAndGetIntValue(selected.getAttribute("status")) == ClientStaticUtils.PROJECT_STATUS_11){
						SC.say("该项目已结项，无法进行此操作");
						return;
					}
					Record record = new Record();
					String[] properties = {"contractId","projectId", "plateId", "complaintIntegral", "sureIntegral", "deductIntegral", "awardIntegral","leftIntegral"};
					record.copyAttributesInto(record, selected, properties);
					Map<String, Object> params = new HashMap<>();
					params.put("contractId", record.getAttribute("contractId"));
					params.put("projectId", record.getAttribute("projectId"));
					params.put("businessType", 2);
					params.put("performanceFlag", 1);
					params.put("optType", "hasADraft");
					DBDataSource.callOperation("EP_ProjectPerformanceProcess", params, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if(dsResponse.getStatus() >= 0){
								Record dataRecord = dsResponse.getData()[0];
								record.setAttribute("projectPerformanceId", dataRecord.getAttribute("projectPerformanceId"));
								record.setAttribute("percent", dataRecord.getAttribute("percent"));
								record.setAttribute("performanceIntegral", dataRecord.getAttribute("performanceIntegral"));
								record.setAttribute("recordDate", dataRecord.getAttributeAsDate("recordDate"));
								record.setAttribute("reason", dataRecord.getAttribute("reason"));
								record.setAttribute("remark", dataRecord.getAttribute("remark"));
							}
							PopupWindow window = new PopupWindow("绩效扣除");
							window.setWidth100();
							window.setHeight100();
							ProjectPerformanceDetailNewPanel panel = new ProjectPerformanceDetailNewPanel();
							panel.addDataEditedHandler(new DataEditedHandler() {
								@Override
								public void onDataEdited(DataEditEvent event) {
//									commonQuery();		
									resultChildGrid.refreshData();							
								}
							});
							panel.setPerformanceFlag(1);
							panel.setRecord(record);
							panel.initData();
							window.addMember(panel);
							window.centerInPage();
							window.show();
						}
					});
				}else{
					SC.say("请选择一条订单记录再进行绩效扣除操作");
				}
			}
		});
		IButton detailButton = new IButton("历史考核明细");
		detailButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(resultChildGrid.anySelected()){
					Record record = resultChildGrid.getSelectedRecords()[0];
					PopupWindow window = new PopupWindow();
					window.setTitle("历史考核明细");
					window.setWidth100();
					window.setHeight100();
					ProjectPerformanceDetailPanel panel = new ProjectPerformanceDetailPanel();
					panel.setContractId(record.getAttribute("contractId"));
					panel.setProjectId(record.getAttribute("projectId"));
					panel.setBusinessType(2);
					panel.reDrawResultGrid();
					panel.commonQuery();
					window.addMember(panel);
					window.centerInPage();
					window.show();	
				}else{
					SC.say("请先选择您要查看的订单");
				}		
			}
		});
		canvas[0] = awardButton;
		canvas[1] = deductButton;
//		canvas[2] = detailButton;
		return canvas;
	}

}

