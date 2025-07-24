package com.pomplatform.client.onloadnewaccountsinfo.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSNewAccountsInfo extends DBDataSource
{


	public static DSNewAccountsInfo instance = null;

	public static DSNewAccountsInfo getInstance() {
		if(instance == null) {
			instance = new DSNewAccountsInfo("DSNewAccountsInfo");
		}
		return instance;
	}

	private final DataSourceIntegerField accountIdField;
	private final DataSourceIntegerField accountTypeField;
	private final DataSourceTextField accountCodeField;
	private final DataSourceTextField accountNameField;
	private final DataSourceIntegerField ownerIdField;
	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField balanceField;
	private final DataSourceIntegerField freezingBalanceField;
	private final DataSourceIntegerField operatorField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceIntegerField levelField;
	private final DataSourceTextField orderIdField;

	public DSNewAccountsInfo(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("NewAccountsInfo");


		accountIdField = new DataSourceIntegerField("accountId", "账户表主键");
		accountIdField.setLength(11);
		accountIdField.setPrimaryKey(true);
		accountIdField.setRequired(true);
		accountIdField.setHidden(true);


		accountTypeField = new DataSourceIntegerField("accountType", "账户类型");
		accountTypeField.setLength(11);
		accountTypeField.setRequired(false);
		accountTypeField.setHidden(false);


		accountCodeField = new DataSourceTextField("accountCode", "账户账号");
		accountCodeField.setLength(135);
		accountCodeField.setRequired(true);
		accountCodeField.setHidden(false);


		accountNameField = new DataSourceTextField("accountName", "账户名称");
		accountNameField.setLength(100);
		accountNameField.setRequired(false);
		accountNameField.setHidden(false);


		ownerIdField = new DataSourceIntegerField("ownerId", "拥有者编码");
		ownerIdField.setLength(11);
		ownerIdField.setRequired(false);
		ownerIdField.setHidden(true);


		statusField = new DataSourceIntegerField("status", "账户状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(false);


		balanceField = new DataSourceIntegerField("balance", "账户余额");
		balanceField.setLength(32);
		balanceField.setRequired(true);
		balanceField.setHidden(false);


		freezingBalanceField = new DataSourceIntegerField("freezingBalance", "账户冻结金额");
		freezingBalanceField.setLength(32);
		freezingBalanceField.setRequired(true);
		freezingBalanceField.setHidden(false);


		operatorField = new DataSourceIntegerField("operator", "开户人");
		operatorField.setLength(11);
		operatorField.setRequired(false);
		operatorField.setHidden(false);


		createTimeField = new DataSourceDateTimeField("createTime", "开户时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);


		levelField = new DataSourceIntegerField("level", "账户等级");
		levelField.setLength(11);
		levelField.setRequired(false);
		levelField.setHidden(true);


		orderIdField = new DataSourceTextField("orderId", "订单编码");
		orderIdField.setLength(32);
		orderIdField.setRequired(false);
		orderIdField.setHidden(false);


		setFields(accountIdField, accountTypeField, accountCodeField, accountNameField, ownerIdField, statusField, balanceField, freezingBalanceField, operatorField, createTimeField, levelField, orderIdField);
	}


}

