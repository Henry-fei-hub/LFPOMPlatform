package com.pomplatform.client.cmbcinfo.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.cmbcinfo.datasource.DSMcmbctransinfolinktattlor;
import com.pomplatform.client.cmbcinfo.form.McmbctransinfolinktattlorSearchForm;
import com.pomplatform.client.cmbcinfo.form.McmbctransinfolinktattlorViewer;
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
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class McmbctransinfopaymentcheckPanel extends AbstractSearchPanel {

	private static final Logger __LOGGER = Logger.getLogger("");
	
	private McapitalstoorPaymentCheckPanel capitalPanel;

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			McmbctransinfopaymentcheckPanel cm = new McmbctransinfopaymentcheckPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Mcmbctransinfolinktattlor";
		}

	}

	@Override
	public void init() {
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
	}

	@Override
	public void initComponents() {
		int index = 0;
		ListGridField [] fields = new ListGridField[10];
		fields[index] = new ListGridField("accnam");
		index ++;
		fields[index] = new ListGridField("bankAccount");
		index ++;
		fields[index] = new ListGridField("trsamtd");
		index ++;
		fields[index] = new ListGridField("transDate");
		index ++;
		fields[index] = new ListGridField("rpynam", "收方名称");
		index ++;
		fields[index] = new ListGridField("rpyacc", "收方账号");
		index ++;
		fields[index] = new ListGridField("rpybnk");
		index ++;
		fields[index] = new ListGridField("rpyadr");
		resultGrid.setFields(fields);
		
		IButton operation1Button = new IButton("查看绑定");
		controlLayout.addMember(operation1Button);
		operation1Button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		
		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				showDetail();
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
				
				ListGridRecord selectedRecord = resultGrid.getSelectedRecord();
				if(null != selectedRecord.getAttribute("linkNum") && selectedRecord.getAttributeAsInt("linkNum") > 0){
					PopupWindow pw = new PopupWindow();
					pw.setWidth("80%");
					pw.setHeight("80%");
					pw.setTitle("绑定详情");
					int businessId = selectedRecord.getAttributeAsInt("cmbcTransInfoId");
					ViewReceiveBindDetailPanel panel = new ViewReceiveBindDetailPanel(2);
					panel.loadData(businessId, 1, 2);
					panel.setFatherWindow(pw);
					panel.addDataEditedHandler(new DataEditedHandler() {
						
						@Override
						public void onDataEdited(DataEditEvent event) {
							commonQuery();
							getCapitalPanel().commonQuery();
							
						}
					});
					pw.addItem(panel);
					pw.centerInPage();
					pw.show();
				}else{
					GenericViewWindow detail = new GenericViewWindow();
					detail.setTitle("详情");
					detail.setWidth100();
					detail.setHeight100();
					McmbctransinfolinktattlorViewer detailForm = new McmbctransinfolinktattlorViewer();
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
		criteria.put("addtionalCondition", "order by cmbc_trans_info_id");
		criteria.put("addtionalCondition", "order by company_record_id");
		criteria.put("transType", 2);
		criteria.put("linkType", 2);
		if(null != criteria.get("isLink")){
			boolean isLink = (boolean)criteria.get("isLink");
			if(isLink){
				criteria.put("linkNum", 0);
			}else{
				List<Map<String, Object>> keyValues = new ArrayList<>();
				Map<String, Object> kv = new HashMap<>();
				kv.put("key", "link_num > ?");
				kv.put("value", "link_num > ? and link_num isnull");
				keyValues.add(kv);
				criteria.put("keyValues", keyValues);
			}
		}
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new McmbctransinfolinktattlorSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSMcmbctransinfolinktattlor.getInstance();
	}

	public boolean checkSelectData(){
		return resultGrid.anySelected();
	}
	
	public String getSelectIds(){
		String ids = "";
		Record [] records = resultGrid.getSelectedRecords();
		for (int i = 0; i < records.length; i++) {
			if(i != 0){
				ids += ",";
			}
			ids += records[i].getAttribute("cmbcTransInfoId");
		}
		return ids;
	}

	public McapitalstoorPaymentCheckPanel getCapitalPanel() {
		return capitalPanel;
	}

	public void setCapitalPanel(McapitalstoorPaymentCheckPanel capitalPanel) {
		this.capitalPanel = capitalPanel;
	}
	
}
