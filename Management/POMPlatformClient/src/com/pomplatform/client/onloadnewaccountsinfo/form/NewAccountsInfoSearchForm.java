package com.pomplatform.client.onloadnewaccountsinfo.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.onloadnewaccountsinfo.datasource.CDNewAccountsInfo;

public class NewAccountsInfoSearchForm extends SearchForm
{


	private final TextItem accountTypeItem;
	private final TextItem accountCodeItem;
	private final TextItem accountNameItem;
	private final TextItem ownerIdItem;
	private final TextItem statusItem;
	private final TextItem balanceItem;
	private final TextItem freezingBalanceItem;
	private final TextItem operatorItem;
	private final DateTimeItem createTimeItem;
	private final TextItem levelItem;
	private final TextItem orderIdItem;

	public NewAccountsInfoSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDNewAccountsInfo.getInstance());
		accountTypeItem = new TextItem("accountType", "账户类型");
		accountTypeItem.setWidth("*");
		accountCodeItem = new TextItem("accountCode", "账户账号");
		accountCodeItem.setWidth("*");
		accountNameItem = new TextItem("accountName", "账户名称");
		accountNameItem.setWidth("*");
		ownerIdItem = new TextItem("ownerId", "拥有者编码");
		ownerIdItem.setHidden(true);
		statusItem = new TextItem("status", "账户状态");
		statusItem.setHidden(true);
		balanceItem = new TextItem("balance", "账户余额");
		balanceItem.setHidden(true);
		freezingBalanceItem = new TextItem("freezingBalance", "冻结余额");
		freezingBalanceItem.setHidden(true);
		operatorItem = new TextItem("operator", "操作人");
		operatorItem.setHidden(true);

		createTimeItem = new DateTimeItem("createTime", "开户时间");
		createTimeItem.setWidth("*");
		createTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, createTimeItem);
			}
		});
		levelItem = new TextItem("level", "账户的等级");
		levelItem.setWidth("*");
		orderIdItem = new TextItem("orderId", "订单编码");
		orderIdItem.setWidth("*");

		setItems(accountCodeItem,accountTypeItem,accountNameItem, ownerIdItem, statusItem, balanceItem, freezingBalanceItem, operatorItem, createTimeItem, levelItem, orderIdItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
