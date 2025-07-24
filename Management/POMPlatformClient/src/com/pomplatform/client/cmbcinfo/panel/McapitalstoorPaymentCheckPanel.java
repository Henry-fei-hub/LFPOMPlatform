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
import com.pomplatform.client.cmbcinfo.datasource.DSMcapitalbccoccmsssoooblpommmmlor;
import com.pomplatform.client.cmbcinfo.form.McapitalbccoccmsssoooblpommmmlorSearchForm;
import com.pomplatform.client.cmbcinfo.form.McapitalbccoccmsssoooblpommmmlorViewer;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class McapitalstoorPaymentCheckPanel extends AbstractSearchPanel {

	private static final Logger __LOGGER = Logger.getLogger("");

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			McapitalstoorPaymentCheckPanel cm = new McapitalstoorPaymentCheckPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Mcapitalbccoccmsssoooblpommmmlor";
		}

	}

	@Override
	public void init() {
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		__needControl = false;
	}

	@Override
	public void initComponents() {
		int index = 0;
		ListGridField [] fields = new ListGridField[10];
		fields[index] = new ListGridField("selfName", "内部公司(付款方)");
		index ++;
		fields[index] = new ListGridField("selfBankAccount", "银行账号(付款方)");
		index ++;
		fields[index] = new ListGridField("otherName", "收款方");
		index ++;
		fields[index] = new ListGridField("otherBankName", "银行名称(收款方)");
		index ++;
		fields[index] = new ListGridField("otherBankAccount", "银行账号(收款方)");
		index ++;
		fields[index] = new ListGridField("loanMoney", "贷(减少)");
		index ++;
		fields[index] = new ListGridField("happenDate");
		resultGrid.setFields(fields);
		
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
					pw.setHeight("80%");
					pw.setHeight("80%");
					pw.setTitle("绑定详情");
					int businessId = selectedRecord.getAttributeAsInt("capitalId");
					ViewReceiveBindDetailPanel panel = new ViewReceiveBindDetailPanel(2);
					panel.loadData(businessId, 2, 2);
					panel.setFatherWindow(pw);
					panel.addDataEditedHandler(new DataEditedHandler() {
						
						@Override
						public void onDataEdited(DataEditEvent event) {
							commonQuery();
							
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
					McapitalbccoccmsssoooblpommmmlorViewer detailForm = new McapitalbccoccmsssoooblpommmmlorViewer();
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
		criteria.put("addtionalCondition", "order by capital_id");
		criteria.put("capitalType", 2);
		criteria.put("linkType", 2);
		if (null != criteria.get("isLink")) {
			boolean isLink = (boolean) criteria.get("isLink");
			if (isLink) {
				criteria.put("linkNum", 0);
			} else {
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
		McapitalbccoccmsssoooblpommmmlorSearchForm form = new McapitalbccoccmsssoooblpommmmlorSearchForm();
		form.getItem("otherName").setTitle("收款方");
		form.getItem("otherBankName").setTitle("银行名称(收款方)");
		form.getItem("otherBankAccount").setTitle("银行账号(收款方)");
		return form;
	}

	@Override
	public DataSource getDataSource() {
		return DSMcapitalbccoccmsssoooblpommmmlor.getInstance();
	}

	public boolean checkSelectData() {
		return resultGrid.anySelected();
	}

	public String getSelectIds() {
		String ids = "";
		Record[] records = resultGrid.getSelectedRecords();
		for (int i = 0; i < records.length; i++) {
			if (i != 0) {
				ids += ",";
			}
			ids += records[i].getAttribute("capitalId");
		}
		return ids;
	}
}
