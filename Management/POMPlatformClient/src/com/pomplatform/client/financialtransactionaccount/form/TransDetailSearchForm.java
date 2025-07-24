package com.pomplatform.client.financialtransactionaccount.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.DateUtil;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.financialtransactionaccount.datasource.CDTransDetail;

public class TransDetailSearchForm extends SearchForm
{


	private final SelectItem accountTypeItem;
	private final TextItem financeNoItem;
	private final TextItem accountNameItem;
	private final SelectItem accountStatusItem;
	private final TextItem financialTransactionAccountIdItem;
	private final TextItem initDeleteFlagItem;
	private final DateItem initEndDateItem;
	private final TextItem detailDeleteFlagItem;
	private final DateItem startDateItem;
	private final DateItem endDateItem;
	private final ComboBoxItem companyIdItem;

	public TransDetailSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDTransDetail.getInstance());
		
		financialTransactionAccountIdItem = new TextItem("financialTransactionAccountId", "主键编码");
		financialTransactionAccountIdItem.hide();
		
		accountTypeItem = new SelectItem("accountType", "账户类型");
		accountTypeItem.setWidth("*");
		accountTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_230"));
		accountTypeItem.hide();
		
		financeNoItem = new TextItem("financeNo", "财务编号");
		financeNoItem.setWidth("*");
		financeNoItem.hide();
		financeNoItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				financialTransactionAccountIdItem.clearValue();
			}
		});
		
		accountNameItem = new TextItem("accountName", "名称");
		accountNameItem.setWidth("*");
		accountNameItem.setCanEdit(false);
		accountNameItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				financialTransactionAccountIdItem.clearValue();
			}
		});
		
		accountStatusItem = new SelectItem("accountStatus", "账户状态");
		accountStatusItem.setWidth("*");
		accountStatusItem.hide();
		accountStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_217"));
		
		initDeleteFlagItem = new TextItem("initDeleteFlag", "期初表的删除状态");
		initDeleteFlagItem.setDefaultValue(ClientStaticUtils.NO_DELETE);
		initDeleteFlagItem.hide();
		
		initEndDateItem = new DateItem("initEndDate", "期初截止日期");
		initEndDateItem.hide();
		initEndDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, initEndDateItem);
			}
		});
		
		detailDeleteFlagItem = new TextItem("detailDeleteFlag", "明细表的删除状态");
		detailDeleteFlagItem.setDefaultValue(ClientStaticUtils.NO_DELETE);
		detailDeleteFlagItem.hide();
		
		startDateItem = new DateItem("startDate", "开始日期");
		startDateItem.setWidth("*");
//		startDateItem.setDefaultValue(DateUtil.createLogicalDate(2016, 0, 1));
		startDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, startDateItem);
			}
		});
		
		endDateItem = new DateItem("endDate", "截止日期");
		endDateItem.setWidth("*");
		endDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, endDateItem);
			}
		});

		companyIdItem = new ComboBoxItem("companyId", "归属公司");
		companyIdItem.setWidth("*");
		companyIdItem.setChangeOnKeypress(false);
		companyIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		companyIdItem.setValueMap(KeyValueManager.getValueMap("company_records"));

		setItems(financeNoItem, accountNameItem, accountTypeItem, companyIdItem, startDateItem, endDateItem, accountStatusItem, financialTransactionAccountIdItem, initDeleteFlagItem, initEndDateItem, detailDeleteFlagItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
