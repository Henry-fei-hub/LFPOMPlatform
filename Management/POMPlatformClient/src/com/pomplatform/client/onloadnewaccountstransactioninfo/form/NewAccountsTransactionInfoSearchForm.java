package com.pomplatform.client.onloadnewaccountstransactioninfo.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.onloadnewaccountstransactioninfo.datasource.CDNewAccountsTransactionInfo;

public class NewAccountsTransactionInfoSearchForm extends SearchForm
{


	private final TextItem accountTransactionItem;
	private final TextItem accountIdItem;
	private final TextItem originalCurrencyBorrowItem;
	private final TextItem originalCurrencyLoanItem;
	private final TextItem exchangeRateItem;
	private final TextItem standardMoneyBorrowItem;
	private final TextItem standardMoneyLoanItem;
	private final TextItem itemCategoryItem;
	private final TextItem itemItem;
	private final TextItem mainProjectIdItem;
	private final TextItem contractIdItem;
	private final TextItem departmentIdItem;
	private final TextItem plateIdItem;
	private final TextItem employeeIdItem;
	private final DateTimeItem recordDateItem;
	private final DateTimeItem affiliationDateItem;
	private final TextItem remarkItem;

	public NewAccountsTransactionInfoSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDNewAccountsTransactionInfo.getInstance());
		accountTransactionItem = new TextItem("accountTransaction", "主键");
		accountTransactionItem.setHidden(true);
		accountIdItem = new TextItem("accountId", "账户编码");
		accountIdItem.setWidth("*");
		accountIdItem.setHidden(false);
		originalCurrencyBorrowItem = new TextItem("originalCurrencyBorrow", "原币借");
		originalCurrencyBorrowItem.setWidth("*");
		originalCurrencyBorrowItem.setHidden(true);
		originalCurrencyLoanItem = new TextItem("originalCurrencyLoan", "原币借");
		originalCurrencyLoanItem.setWidth("*");
		originalCurrencyLoanItem.setHidden(true);
		exchangeRateItem = new TextItem("exchangeRate", "汇率");
		exchangeRateItem.setWidth("*");
		exchangeRateItem.setHidden(true);
		standardMoneyBorrowItem = new TextItem("standardMoneyBorrow", "本位币");
		standardMoneyBorrowItem.setWidth("*");
		standardMoneyBorrowItem.setHidden(true);
		standardMoneyLoanItem = new TextItem("standardMoneyLoan", "本位贷");
		standardMoneyLoanItem.setWidth("*");
		standardMoneyLoanItem.setHidden(true);
		itemCategoryItem = new TextItem("itemCategory", "事项类别");
		itemCategoryItem.setWidth("*");
		itemCategoryItem.setHidden(true);
		itemItem = new TextItem("item", "事项");
		itemItem.setHidden(true);
		mainProjectIdItem = new TextItem("mainProjectId", "大项目");
		mainProjectIdItem.setHidden(true);
		contractIdItem = new TextItem("contractId", "合同编号");
		contractIdItem.setWidth("*");
		contractIdItem.setHidden(true);
		departmentIdItem = new TextItem("departmentId", "部门");
		departmentIdItem.setWidth("*");
		plateIdItem = new TextItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		employeeIdItem = new TextItem("employeeId", "员工姓名");
		employeeIdItem.setWidth("*");
		recordDateItem = new DateTimeItem("recordDate", "记录时间");
		recordDateItem.setWidth("*");
		recordDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, recordDateItem);
			}
		});
		affiliationDateItem = new DateTimeItem("affiliationDate", "归属时间");
		affiliationDateItem.setWidth("*");
		affiliationDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, affiliationDateItem);
			}
		});
		remarkItem = new TextItem("remark", "备注");
		remarkItem.setHidden(true);

		setItems(accountTransactionItem, accountIdItem, originalCurrencyBorrowItem, originalCurrencyLoanItem, exchangeRateItem, standardMoneyBorrowItem, standardMoneyLoanItem, itemCategoryItem, itemItem, mainProjectIdItem, contractIdItem, departmentIdItem, plateIdItem, employeeIdItem, recordDateItem, affiliationDateItem, remarkItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
