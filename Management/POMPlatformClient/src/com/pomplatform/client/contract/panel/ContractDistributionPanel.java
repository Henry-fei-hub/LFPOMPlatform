package com.pomplatform.client.contract.panel;

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
import com.pomplatform.client.contract.datasource.DSContractDistribution;
import com.pomplatform.client.contract.form.ContractDistributionSearchForm;
import com.pomplatform.client.contract.form.ContractDistributionViewer;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;

public class ContractDistributionPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ContractDistributionPanel cm = new ContractDistributionPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ContractDistribution";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid.setAutoFitFieldWidths(false);
//		ListGridField[] fields = new ListGridField[6];
//		int idx = 0;
//		fields[idx] = new ListGridField("contractCode");
//		fields[idx++].setMaxWidth(150);
//		fields[idx] = new ListGridField("contractName");
//		fields[idx++].setMaxWidth(360);
//		fields[idx] = new ListGridField("signingMoneySum");
//		fields[idx++].setMaxWidth(150);
//		fields[idx] = new ListGridField("contractDate");
////		fields[idx].setMaxWidth(140);
////		fields[idx++].setMinWidth(110);
//		idx++;
//		fields[idx] = new ListGridField("businessType");
//		fields[idx++].setMaxWidth(360);
//		fields[idx] = new ListGridField("team");
//		resultGrid.setFields(fields);
//		resultGrid.setHeight100();
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

		IButton distributeButton = new IButton("分配团队");
		controlLayout.addMember(distributeButton);
		distributeButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){
							SC.say("请选择一个合同");
							return;
						}
						Record record = resultGrid.getSelectedRecords()[0];
						Record newRecord = new Record();
						newRecord.setAttribute("contractId", record.getAttributeAsObject("contractId"));
						newRecord.setAttribute("contractId2", record.getAttributeAsObject("contractId"));
						newRecord.setAttribute("businessType", record.getAttributeAsObject("businessType"));
						newRecord.setAttribute("signingMoneySum", record.getAttributeAsObject("signingMoneySum"));
						if(BaseHelpUtils.isNullOrEmpty(record.getAttributeAsObject("actualMoney"))){
							newRecord.setAttribute("actualMoney", record.getAttributeAsObject("signingMoneySum"));
						}else{
							newRecord.setAttribute("actualMoney", record.getAttributeAsObject("actualMoney"));
						}
						newRecord.setAttribute("contractDate", record.getAttributeAsDate("contractDate"));
						newRecord.setAttribute("operator", ClientUtil.getUserId());
						PopupWindow window = new PopupWindow("分配团队");
						window.setWidth("80%");
						window.setHeight("60%");
						PlateContractDistribution panel = new PlateContractDistribution();
						panel.initComponents();
						panel.setRecord(newRecord);
						panel.startEdit();
						panel.addDataEditedHandler(new DataEditedHandler() {
							
							@Override
							public void onDataEdited(DataEditEvent event) {
								commonQuery();
							}
						});
						window.addMember(panel);
						panel.setParent(window);
						window.centerInPage();
						window.show();
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				});
			}
		});
		
		IButton downloadButton = new IButton("导出");
		controlLayout.addMember(downloadButton);
		downloadButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				DBDataSource.downloadFile("DW_ContractDistribution", generateCriteria());
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
				detail.setTitle("提成分配"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				ContractDistributionViewer detailForm = new ContractDistributionViewer();
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
		List<Map> keyvalues = new ArrayList<>();
		if(BaseHelpUtils.isNullOrEmpty(criteria.get("year"))){
			Map<String, Object> kv = new HashMap<>();
		    kv.put("key", "extract(year from c.contract_date) =");
		    kv.put("value", "1 =");
		    keyvalues.add(kv);
		}
		if(BaseHelpUtils.isNullOrEmpty(criteria.get("month"))){
			Map<String, Object> kv = new HashMap<>();
		    kv.put("key", "extract(month from c.contract_date) =");
		    kv.put("value", "1 =");
		    keyvalues.add(kv);
		}
		criteria.put("keyValues", keyvalues);
		criteria.put("contractSigningStatus", 2);
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new ContractDistributionSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSContractDistribution.getInstance();
	}


}

