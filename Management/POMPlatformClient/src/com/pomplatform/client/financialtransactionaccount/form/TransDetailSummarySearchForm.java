package com.pomplatform.client.financialtransactionaccount.form;

import java.util.Date;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.financialtransactionaccount.datasource.CDTransDetailSummary;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.DateUtil;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;

public class TransDetailSummarySearchForm extends SearchForm
{


	private final DateItem startDateItem;
	private final TextItem deleteFlagItem;
	private final DateItem endDateItem;
	private final SelectItem accountTypeItem;
	private final TextItem financeNoItem;
	private final TextItem accountNameItem;
	private final SelectItem accountStatusItem;
	private final ComboBoxItem companyIdItem;

	public TransDetailSummarySearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDTransDetailSummary.getInstance());
		Date date = new Date();
		Date start = DateUtil.getFiscalStartDate(date);
		Date endDate = DateUtil.parseInput(DateUtil.getDisplayYear(date) + "-12-31");
		startDateItem = new DateItem("startDate", "开始日期");
		startDateItem.setWidth("*");
		startDateItem.setDefaultValue(start);
		startDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, startDateItem);
			}
		});
		
		deleteFlagItem = new TextItem("deleteFlag", "往来明细删除状态");
		deleteFlagItem.hide();
		
		endDateItem = new DateItem("endDate", "截止日期");
		endDateItem.setWidth("*");
		endDateItem.setDefaultValue(endDate);
		endDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, endDateItem);
			}
		});
		
		accountTypeItem = new SelectItem("accountType", "账户类型");
		accountTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_230"));
		accountTypeItem.setWidth("*");
		if(!ClientUtil.checkIsHavePermission(ERPPermissionStatic.TRANS_DETAIL_SUMMARY_VIEW_ALL)) {
			accountTypeItem.setDefaultValue(1);
			accountTypeItem.setCanEdit(false);
		}
		
		financeNoItem = new TextItem("financeNo", "财务编号");
		financeNoItem.setWidth("*");
		
		accountNameItem = new TextItem("accountName", "名称");
		accountNameItem.setWidth("*");
		if(!ClientUtil.checkIsHavePermission(ERPPermissionStatic.TRANS_DETAIL_SUMMARY_VIEW_ALL) && !ClientUtil.checkIsHavePermission(ERPPermissionStatic.TRANS_DETAIL_SUMMARY_VIEW_DEPARTMENT) 
				&& ClientUtil.checkIsHavePermission(ERPPermissionStatic.TRANS_DETAIL_SUMMARY_VIEW_MYSELF)) {
			//只有查看自己数据的权限
			accountNameItem.setDefaultValue(ClientUtil.getUserName());
			accountNameItem.setCanEdit(false);
		}
		
		accountStatusItem = new SelectItem("accountStatus", "账户状态");
		accountStatusItem.setWidth("*");
		accountStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_217"));

		companyIdItem = new ComboBoxItem("companyId", "归属公司");
		companyIdItem.setWidth("*");
		companyIdItem.setChangeOnKeypress(false);
		companyIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		companyIdItem.setValueMap(KeyValueManager.getValueMap("company_records"));
		
		setItems(financeNoItem, accountNameItem, accountTypeItem, accountStatusItem, startDateItem, deleteFlagItem, endDateItem, companyIdItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
