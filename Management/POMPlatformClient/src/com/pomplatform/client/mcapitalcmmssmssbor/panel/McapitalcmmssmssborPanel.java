package com.pomplatform.client.mcapitalcmmssmssbor.panel;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.mcapitalcmmssmssbor.datasource.DSMcapitalcmmssmssbor;
import com.pomplatform.client.mcapitalcmmssmssbor.form.McapitalcmmssmssborSearchForm;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.GroupStartOpen;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridField;

public class McapitalcmmssmssborPanel extends AbstractSearchPanel {

	private static final Logger __LOGGER = Logger.getLogger("");

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			McapitalcmmssmssborPanel cm = new McapitalcmmssmssborPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Mcapitalcmmssmssbor";
		}

	}

	@Override
	public void init() {
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
	}

	@Override
	public void initComponents() {
		ListGridField selfNameField = new ListGridField("selfName");
		selfNameField.setShowGroupSummary(false);  
		selfNameField.setShowGridSummary(false);
		
		ListGridField bankAddressField = new ListGridField("bankAddress");
		bankAddressField.setShowGroupSummary(false);  
		bankAddressField.setShowGridSummary(false);
		
		ListGridField selfBankAccountField = new ListGridField("selfBankAccount");
		selfBankAccountField.setShowGroupSummary(false);  
		selfBankAccountField.setShowGridSummary(false);
		
		ListGridField beforeMoneyField = new ListGridField("beforeMoney");
		beforeMoneyField.setShowGroupSummary(true);  
		beforeMoneyField.setShowGridSummary(true);
		
		ListGridField borrowMoneyField = new ListGridField("borrowMoney");
		borrowMoneyField.setShowGroupSummary(true);  
		borrowMoneyField.setShowGridSummary(true);
		
		ListGridField loanMoneyField = new ListGridField("loanMoney");
		loanMoneyField.setShowGroupSummary(true);  
		loanMoneyField.setShowGridSummary(true);
		
		ListGridField balanceField = new ListGridField("balance");
		balanceField.setShowGroupSummary(true);  
		balanceField.setShowGridSummary(true);
		
		ListGridField currencyTypeField = new ListGridField("currencyType");
		currencyTypeField.setShowGroupSummary(false);  
		currencyTypeField.setShowGridSummary(false);
		
		resultGrid.setShowRowNumbers(true);
		resultGrid.setShowGridSummary(true);  
		resultGrid.setGroupByField("currencyType");		
		resultGrid.setGroupStartOpen(GroupStartOpen.ALL);  
		resultGrid.setShowAllRecords(true);
		resultGrid.setShowGroupSummary(true); 
//        resultGrid.setShowGroupSummaryInHeader(true);
        resultGrid.setFields(selfNameField, bankAddressField, selfBankAccountField, beforeMoneyField, borrowMoneyField, loanMoneyField, balanceField, currencyTypeField);
		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				showDetail();
			}
		});
		final IButton button = new IButton("分组设置");  
        button.addClickHandler(new ClickHandler() {  
                public void onClick(ClickEvent event) {  
                	resultGrid.configureGrouping();  
                }  
            });  
        controlLayout.addMember(button);
		IButton operation1Button = new IButton("查看详情");
		controlLayout.addMember(operation1Button);
		// operation1Button.setIcon("[SKIN]/actions/view.png");
		operation1Button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
	}

	@Override
	public void commonQuery() {

		Object minDate = searchForm.getValue("minHappenDate");
		Object maxDate = searchForm.getValue("maxHappenDate");
		if (minDate == null || maxDate == null) {
			SC.say("请选择最早与最晚发生日期");
			return;
		}
		super.commonQuery();
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
				Record selectRecord = resultGrid.getSelectedRecord();
				PopupWindow window = new PopupWindow();
				window.setWidth100();
				window.setHeight100();
				window.centerInPage();
				window.setTitle("账单详细");
				ScapitalssmorPanel panel = new ScapitalssmorPanel();
				Record record = searchForm.getValuesAsRecord();
				record.setAttribute("selfBankAccount", selectRecord.getAttribute("selfBankAccount"));
				record.setAttribute("beforeMoney", null == selectRecord.getAttribute("beforeMoney") ? BigDecimal.ZERO : new BigDecimal(selectRecord.getAttribute("beforeMoney")));
				panel.initData(record);
				window.addItem(panel);
				panel.commonQuery();
				window.show();
			}
		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new McapitalcmmssmssborSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSMcapitalcmmssmssbor.getInstance();
	}

}
