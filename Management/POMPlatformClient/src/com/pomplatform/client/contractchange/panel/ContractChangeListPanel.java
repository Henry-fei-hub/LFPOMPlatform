package com.pomplatform.client.contractchange.panel;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
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
import com.pomplatform.client.contractchange.datasource.DSContractChangeList;
import com.pomplatform.client.contractchange.form.ContractChangeListSearchForm;
import com.pomplatform.client.contractchange.form.ContractChangeListViewer;
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

public class ContractChangeListPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ContractChangeListPanel cm = new ContractChangeListPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ContractChangeList";
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
		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				Record record = resultGrid.getSelectedRecords()[0];
				PopupWindow window = new PopupWindow();
				window.setWidth100();
				window.setHeight100();
				window.centerInPage();
				window.setTitle("合同变更");
				ContractChangeInfoViewPanel panel = new ContractChangeInfoViewPanel();
				panel.setContractId(record.getAttribute("contractId"));
				panel.setContractChangeId(record.getAttribute("contractChangeId"));//仅查看数据时才需要传这个参数
				panel.initData();
				window.addMember(panel);
				window.show();
			}
		});
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});

		IButton contractChangeButton = new IButton("合同变更");
		contractChangeButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(resultGrid.anySelected()){
					Record record = resultGrid.getSelectedRecords()[0];
					String contractId = record.getAttribute("contractId");
					Map<String, Object> params = new HashMap<>();
					params.put("contractId", contractId);
					params.put("optType", "isOkToChangeContractInfo");
					DBDataSource.callOperation("EP_ContractChangeProcess", params, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if(dsResponse.getStatus() > 0){
								SC.say("该合同已有待审核的变更记录，暂无法变更信息");
							}else{
								PopupWindow window = new PopupWindow();
								window.setWidth100();
								window.setHeight100();
								window.centerInPage();
								window.setTitle("合同变更");
								ContractChangeInfoPanel panel = new ContractChangeInfoPanel(true);//true为编辑页面，false为审批页面
								panel.setContractId(contractId);
								panel.setContractAmount(record.getAttribute("signingMoneySum"));
								panel.initData();
								panel.addDataEditedHandler(new DataEditedHandler() {
									
									@Override
									public void onDataEdited(DataEditEvent event) {
										commonQuery();
									}
								});
								window.addMember(panel);
								window.show();
							}
						}
					});
				}else{
					SC.say("请选择一条数据");
				}
			}
		});
		controlLayout.addMember(contractChangeButton);
		
		IButton auditButton = new IButton("变更审批");
		auditButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(resultGrid.anySelected()){
					Record record = resultGrid.getSelectedRecords()[0];
					String contractId = record.getAttribute("contractId");
					Map<String, Object> params = new HashMap<>();
					params.put("contractId", contractId);
					params.put("optType", "isOkToChangeContractInfo");
					DBDataSource.callOperation("EP_ContractChangeProcess", params, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if(dsResponse.getStatus() > 0){
								PopupWindow window = new PopupWindow();
								window.setWidth100();
								window.setHeight100();
								window.centerInPage();
								window.setTitle("合同变更");
								ContractChangeInfoPanel panel = new ContractChangeInfoPanel(false);//true为编辑页面，false为审批页面
								panel.setContractId(contractId);
								panel.setContractAmount(record.getAttribute("signingMoneySum"));
								panel.initData();
								panel.addDataEditedHandler(new DataEditedHandler() {
									
									@Override
									public void onDataEdited(DataEditEvent event) {
										commonQuery();
									}
								});
								window.addMember(panel);
								window.show();
							}else{
								SC.say("该合同没有待审批的变更记录，暂无法审批变更信息");
							}
						}
					});
				}else{
					SC.say("请选择一条数据");
				}
			}
		});
		controlLayout.addMember(auditButton);
		
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
				detail.setTitle("运营变更"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				ContractChangeListViewer detailForm = new ContractChangeListViewer();
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
		return new ContractChangeListSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSContractChangeList.getInstance();
	}


}

