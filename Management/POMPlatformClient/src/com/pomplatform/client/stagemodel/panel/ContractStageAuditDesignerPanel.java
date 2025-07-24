package com.pomplatform.client.stagemodel.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.stagemodel.datasource.DSContractStageAuditDesigner;
import com.pomplatform.client.stagemodel.form.ContractStageAuditDesignerSearchForm;
import com.pomplatform.client.stagemodel.form.ContractStageAuditDesignerViewer;
import com.pomplatform.client.stagemodel.form.ContractStageAuditSearchForm;
import com.pomplatform.client.stagemodel.form.UpdateContractStageAuditDesignerForm;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.PrintPreviewCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.PrintCanvas;
import com.smartgwt.client.widgets.PrintWindow;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class ContractStageAuditDesignerPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ContractStageAuditDesignerPanel cm = new ContractStageAuditDesignerPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ContractStageAuditDesigner";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid.setAutoFitFieldWidths(false);
	}

	@Override
	public void initComponents() {
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});

		IButton viewButton = new IButton("查看/打印");
		viewButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
						final ListGridRecord selected1 = resultGrid.getSelectedRecords()[0];
						int contractStageModelId = BaseHelpUtils.getIntValue(selected1.getAttributeAsObject("contractStageModelId"));
						Map<String, Object> params = new HashMap<>();
						params.put("optType", "getPrintHtml");
						params.put("contractStageModelId", contractStageModelId);
						DBDataSource.callOperation("EP_StageModelProcessor", params, new DSCallback() {
							
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								if(dsResponse.getStatus() >= 0){
									Record record = dsResponse.getData()[0];
									if(null != record){
										PopupWindow window = new PopupWindow();
										HTMLPane htmlPane = new HTMLPane();  
								        htmlPane.setWidth100();  
								        htmlPane.setHeight100();  
								        htmlPane.setShowEdges(true);  
								        htmlPane.setBackgroundColor("#fff");
								        htmlPane.setContents(record.getAttribute("value"));  
								        htmlPane.setSelectContentOnSelectAll(true);  
								        htmlPane.draw(); 
								        htmlPane.show();
								        window.addMember(htmlPane);
								        window.setWidth100();
								        window.setHeight100();
								        window.centerInPage();
								        window.show();
								        Object[] arr = new Object[1];
										arr[0] = htmlPane;
										showPrintPreview(arr, null, "查看/打印", new PrintPreviewCallback() {
											@Override
											public void execute(PrintCanvas printCanvas, PrintWindow printWindow) {
												printWindow.addCloseClickHandler(new CloseClickHandler() {
													@Override
													public void onCloseClick(CloseClickEvent event) {
														htmlPane.destroy();
														window.destroy();
													}
												});
											}
										});
									}
								}else{
									ClientUtil.displayErrorMessage(dsResponse);
								}
							}
						});
					}
				});
			}
		});
		controlLayout.addMember(viewButton);
		
		IButton operation1Button = new IButton("审批");
		controlLayout.addMember(operation1Button);
		operation1Button.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download code");
					}
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){ SC.say("请选择一条数据审批"); return;}
						final ListGridRecord selected1 = resultGrid.getSelectedRecord();
						UpdateContractStageAuditDesignerForm detailForm = new UpdateContractStageAuditDesignerForm();
						detailForm.setTitle("审批");
						detailForm.addDataEditedHandler(new DataEditedHandler(){
							@Override
							public void onDataEdited(DataEditEvent event) {
								commonQuery();
							}
						});
						detailForm.setSearchForm(searchForm);
						detailForm.setRecord(selected1);
						detailForm.setCurrentPage(getCurrentPage());
						detailForm.initComponents();
						detailForm.startEdit();
						detailForm.setWidth100();
						detailForm.setHeight100();
						detailForm.centerInPage();
						detailForm.show();
						setCurrentPage(detailForm.getCurrentPage());
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
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("合同小节点设计总监审批"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				ContractStageAuditDesignerViewer detailForm = new ContractStageAuditDesignerViewer();
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
		criteria.put("employeeId", ClientUtil.getUserId());
		criteria.put("addtionalCondition", "order by contract_stage_model_id");
		List<Map<String,Object>> keyvalues = new ArrayList<>();
		if (!BaseHelpUtils.isNullOrEmpty(criteria.get("auditStatus"))) {
			String value = BaseHelpUtils.getString(criteria.get("auditStatus"));
			if(value.equals(ContractStageAuditSearchForm.STATUS_1)){
				Map<String, Object> kv = new HashMap<>();
				kv.put("key", "a.need_manager_audit = true and a.manager_audit_date is not null");
				kv.put("value", "a.design_director_audit_date is null and a.need_manager_audit = true and a.manager_audit_date is not null");
				keyvalues.add(kv);
				Map<String, Object> kv2 = new HashMap<>();
				kv2.put("key", "a.need_manager_audit = false and a.need_design_director_audit = true");
				kv2.put("value", "a.design_director_audit_date is null and a.need_manager_audit = false and a.need_design_director_audit = true");
				keyvalues.add(kv2);
			}else if(value.equals(ContractStageAuditSearchForm.STATUS_2)){
				Map<String, Object> kv = new HashMap<>();
				kv.put("key", "a.need_manager_audit = true and a.manager_audit_date is not null");
				kv.put("value", "a.design_director_audit_date is not null and a.need_manager_audit = true and a.manager_audit_date is not null");
				keyvalues.add(kv);
				Map<String, Object> kv2 = new HashMap<>();
				kv2.put("key", "a.need_manager_audit = false and a.need_design_director_audit = true");
				kv2.put("value", "a.design_director_audit_date is not null and a.need_manager_audit = false and a.need_design_director_audit = true");
				keyvalues.add(kv2);
			}
		}
        if(!BaseHelpUtils.isNullOrEmpty(keyvalues)){
        	criteria.put("keyValues", keyvalues);
        }
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new ContractStageAuditDesignerSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSContractStageAuditDesigner.getInstance();
	}


}

