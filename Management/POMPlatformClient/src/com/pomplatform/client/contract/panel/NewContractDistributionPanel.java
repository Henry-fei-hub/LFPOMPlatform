package com.pomplatform.client.contract.panel;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.*;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.contract.datasource.DSNewContractDistribution;
import com.pomplatform.client.contract.form.NewContractDistributionSearchForm;
import com.pomplatform.client.contract.form.NewContractDistributionViewer;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class NewContractDistributionPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			NewContractDistributionPanel cm = new NewContractDistributionPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "NewContractDistribution";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
	}

	@Override
	public void initComponents() {
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.setIcon("[SKIN]/actions/refresh.png");
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
						SC.debugger();
						Record newRecord = new Record();
						newRecord.setAttribute("contractId", record.getAttributeAsObject("contractId"));
						newRecord.setAttribute("contractId2", record.getAttributeAsObject("contractId"));
						newRecord.setAttribute("businessType", record.getAttributeAsObject("businessType"));
						newRecord.setAttribute("signingMoneySum", record.getAttributeAsObject("signingMoneySum"));
						newRecord.setAttribute("isOriginal", record.getAttributeAsObject("isOriginal"));
						newRecord.setAttribute("isSubProject", record.getAttributeAsObject("isSubProject"));
						newRecord.setAttribute("contractDate", record.getAttributeAsDate("contractDate"));
						newRecord.setAttribute("contractCode", record.getAttributeAsDate("contractCode"));
						newRecord.setAttribute("operator", ClientUtil.getUserId());
						PopupWindow window = new PopupWindow("分配团队");
						window.setWidth("60%");
						window.setHeight("40%");
						NewPlateContractDistribution panel = new NewPlateContractDistribution();
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

		//导出所有的数据
		IButton exportButton = new IButton("导出");
		controlLayout.addMember(exportButton);
		exportButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent clickEvent) {
				DBDataSource.downloadFile("DW_ContractDistribution",generateCriteria());
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
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("员工积分"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				NewContractDistributionViewer detailForm = new NewContractDistributionViewer();
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
		if(BaseHelpUtils.isNullOrEmpty(criteria.get("selectYear"))){
			Map<String, Object> kv = new HashMap<>();
		    kv.put("key", "EXTRACT (YEAR FROM C .contract_date) =");
		    kv.put("value", "1 =");
		    keyvalues.add(kv);
		}
		if(BaseHelpUtils.isNullOrEmpty(criteria.get("selectMonth"))){
			Map<String, Object> kv = new HashMap<>();
		    kv.put("key", "EXTRACT (MONTH FROM C .contract_date)");
		    kv.put("value", "1");
		    keyvalues.add(kv);
		}
		criteria.put("keyValues", keyvalues);
		criteria.put("contractSigningStatus", 2);
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new NewContractDistributionSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSNewContractDistribution.getInstance();
	}



}

