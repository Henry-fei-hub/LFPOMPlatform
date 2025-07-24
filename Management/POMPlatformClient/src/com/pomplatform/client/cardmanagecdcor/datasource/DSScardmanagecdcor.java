package com.pomplatform.client.cardmanagecdcor.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSScardmanagecdcor extends DBDataSource {

	public static DSScardmanagecdcor instance = null;

	public static DSScardmanagecdcor getInstance() {
		if (instance == null) {
			instance = new DSScardmanagecdcor("DSScardmanagecdcor");
		}
		return instance;
	}

	private final DataSourceIntegerField cardManageIdField;
	private final DataSourceIntegerField objectIdField;
	private final DataSourceIntegerField objectTypeField;
	private final DataSourceIntegerField bankIdField;
	private final DataSourceTextField bankAccountField;
	private final DataSourceTextField bankAddressField;
	private final DataSourceIntegerField cardTypeField;
	private final DataSourceBooleanField defaultCardField;
	private final DataSourceBooleanField enabledField;
	private final DataSourceIntegerField currencyTypeField;
	private final DataSourceIntegerField cmbcCodeIdField;
	private final DataSourceBooleanField truePaymentField;

	public DSScardmanagecdcor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Scardmanagecdcor");

		cardManageIdField = new DataSourceIntegerField("cardManageId", "主键编码");
		cardManageIdField.setLength(11);
		cardManageIdField.setPrimaryKey(true);
		cardManageIdField.setRequired(true);
		cardManageIdField.setHidden(true);

		objectIdField = new DataSourceIntegerField("objectId", "公司名称");
		objectIdField.setLength(11);
		objectIdField.setRequired(false);
		objectIdField.setHidden(false);
		objectIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));

		objectTypeField = new DataSourceIntegerField("objectType", "2单位)");
		objectTypeField.setLength(11);
		objectTypeField.setRequired(false);
		objectTypeField.setHidden(true);

		bankIdField = new DataSourceIntegerField("bankId", "开户行");
		bankIdField.setLength(11);
		bankIdField.setRequired(false);
		bankIdField.setHidden(false);
		bankIdField.setValueMap(KeyValueManager.getValueMap("banks"));

		bankAccountField = new DataSourceTextField("bankAccount", "银行账号");
		bankAccountField.setLength(64);
		bankAccountField.setRequired(false);
		bankAccountField.setHidden(false);

		bankAddressField = new DataSourceTextField("bankAddress", "开户行所在地");
		bankAddressField.setLength(128);
		bankAddressField.setRequired(false);
		bankAddressField.setHidden(false);

		cardTypeField = new DataSourceIntegerField("cardType", "2报销卡)");
		cardTypeField.setLength(11);
		cardTypeField.setRequired(false);
		cardTypeField.setHidden(true);

		defaultCardField = new DataSourceBooleanField("defaultCard", "是否为默认卡");
		defaultCardField.setRequired(false);
		defaultCardField.setHidden(false);

		enabledField = new DataSourceBooleanField("enabled", "是否启用");
		enabledField.setRequired(false);
		enabledField.setHidden(false);

		currencyTypeField = new DataSourceIntegerField("currencyType", "货币类型");
		currencyTypeField.setLength(11);
		currencyTypeField.setRequired(false);
		currencyTypeField.setHidden(false);
		currencyTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_40"));

		cmbcCodeIdField = new DataSourceIntegerField("cmbcCodeId", "招商银行分行代码");
		cmbcCodeIdField.setLength(11);
		cmbcCodeIdField.setRequired(false);
		cmbcCodeIdField.setHidden(false);
		cmbcCodeIdField.setValueMap(KeyValueManager.getValueMap("cmbc_branch"));

		truePaymentField = new DataSourceBooleanField("truePayment", "真实收付款");
		truePaymentField.setRequired(false);
		truePaymentField.setHidden(false);

		setFields(cardManageIdField, objectIdField, objectTypeField, bankIdField, bankAccountField, bankAddressField,
				cardTypeField, defaultCardField, enabledField, currencyTypeField, cmbcCodeIdField, truePaymentField);
	}

}
