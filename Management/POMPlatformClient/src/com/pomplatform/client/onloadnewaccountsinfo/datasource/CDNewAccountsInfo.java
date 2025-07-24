package com.pomplatform.client.onloadnewaccountsinfo.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDNewAccountsInfo extends DataSource
{


	public static CDNewAccountsInfo instance = null;

	public static CDNewAccountsInfo getInstance() {
		if(instance == null) {
			instance = new CDNewAccountsInfo("CDNewAccountsInfo");
		}
		return instance;
	}

	private final DataSourceIntegerField accountTypeField;
	private final DataSourceTextField accountCodeField;
	private final DataSourceTextField accountNameField;
	private final DataSourceIntegerField ownerIdField;
	private final DataSourceIntegerField statusField;
	private final DataSourceFloatField balanceField;
	private final DataSourceFloatField freezingBalanceField;
	private final DataSourceIntegerField operatorField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceIntegerField levelField;
	private final DataSourceTextField orderIdField;

	public CDNewAccountsInfo(String dataSourceID) {

		setID(dataSourceID);
		accountTypeField = new DataSourceIntegerField("accountType", "账户类型(1个人 ,2项目组，3部门，4公司，5供应商)");
		accountTypeField.setRequired(false);
		accountTypeField.setLength(11);
		accountTypeField.setHidden(false);

		accountCodeField = new DataSourceTextField("accountCode", "账户编号（唯一）");
		accountCodeField.setRequired(true);
		accountCodeField.setLength(255);
		accountCodeField.setHidden(false);

		accountNameField = new DataSourceTextField("accountName", "账户名称");
		accountNameField.setRequired(false);
		accountNameField.setLength(255);
		accountNameField.setHidden(false);

		ownerIdField = new DataSourceIntegerField("ownerId", "拥有者编码");
		ownerIdField.setRequired(false);
		ownerIdField.setLength(11);
		ownerIdField.setHidden(false);

		statusField = new DataSourceIntegerField("status", "状态（1活动，2冻结，3关户）");
		statusField.setRequired(false);
		statusField.setLength(11);
		statusField.setHidden(false);

		balanceField = new DataSourceFloatField("balance", "余额");
		balanceField.setRequired(true);
		balanceField.setLength(32);
		balanceField.setHidden(false);

		freezingBalanceField = new DataSourceFloatField("freezingBalance", "冻结余额");
		freezingBalanceField.setRequired(true);
		freezingBalanceField.setLength(32);
		freezingBalanceField.setHidden(false);

		operatorField = new DataSourceIntegerField("operator", "operator");
		operatorField.setRequired(false);
		operatorField.setLength(11);
		operatorField.setHidden(false);

		createTimeField = new DataSourceDateTimeField("createTime", "开户人活着操作人");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);

		levelField = new DataSourceIntegerField("level", "账户的登记（1.一级账户2.二级账户）");
		levelField.setRequired(false);
		levelField.setLength(11);
		levelField.setHidden(false);

		orderIdField = new DataSourceTextField("orderId", "订单编码");
		orderIdField.setRequired(false);
		orderIdField.setLength(32);
		orderIdField.setHidden(false);

		DataSourceIntegerField currentPageField
			= new DataSourceIntegerField("currentPage", "当前页");
		currentPageField.setRequired(true);
		currentPageField.setLength(10);
		currentPageField.setHidden(true);

		DataSourceIntegerField pageLinesField
			= new DataSourceIntegerField("pageLines", "每页行数");
		pageLinesField.setRequired(true);
		pageLinesField.setLength(10);
		pageLinesField.setHidden(true);


		setFields(accountTypeField, accountCodeField, accountNameField, ownerIdField, statusField, balanceField, freezingBalanceField, operatorField, createTimeField, levelField, orderIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

