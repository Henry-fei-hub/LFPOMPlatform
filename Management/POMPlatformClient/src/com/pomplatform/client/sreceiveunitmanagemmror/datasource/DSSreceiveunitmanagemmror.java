package com.pomplatform.client.sreceiveunitmanagemmror.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSSreceiveunitmanagemmror extends DBDataSource {

	public static DSSreceiveunitmanagemmror instance = null;

	public static DSSreceiveunitmanagemmror getInstance() {
		if (instance == null) {
			instance = new DSSreceiveunitmanagemmror("DSSreceiveunitmanagemmror");
		}
		return instance;
	}

	private final DataSourceIntegerField receiveUnitManageIdField;
	private final DataSourceTextField receiveUnitField;
	private final DataSourceTextField bankAccountField;
	private final DataSourceTextField bankNameField;
	private final DataSourceTextField receiveUnitAddressField;
	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceDateTimeField operateTimeField;
	private final DataSourceIntegerField originField;
	private final DataSourceIntegerField provinceField;
	private final DataSourceIntegerField cityField;
	private final DataSourceTextField bankAddressField;
	private final DataSourceTextField receiveUnitPhoneField;
	private final DataSourceTextField swiftCodeField;
	private final DataSourceIntegerField countryIdField;
	private final DataSourceTextField countryCodeField;
	private final DataSourceTextField passportField;
	private final DataSourceIntegerField bankIdField;
	private final DataSourceIntegerField accountTypeField;
	private final DataSourceIntegerField voucherTypeField;
	private final DataSourceIntegerField supplierTypeField;

	public DSSreceiveunitmanagemmror(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Sreceiveunitmanagemmror");

		receiveUnitManageIdField = new DataSourceIntegerField("receiveUnitManageId", "主键编码");
		receiveUnitManageIdField.setLength(11);
		receiveUnitManageIdField.setPrimaryKey(true);
		receiveUnitManageIdField.setRequired(true);
		receiveUnitManageIdField.setHidden(true);

		receiveUnitField = new DataSourceTextField("receiveUnit", "收款单位");
		receiveUnitField.setLength(128);
		receiveUnitField.setRequired(false);
		receiveUnitField.setHidden(false);

		bankAccountField = new DataSourceTextField("bankAccount", "银行账号");
		bankAccountField.setLength(64);
		bankAccountField.setRequired(false);
		bankAccountField.setHidden(false);

		bankNameField = new DataSourceTextField("bankName", "开户行");
		bankNameField.setLength(128);
		bankNameField.setRequired(false);
		bankNameField.setHidden(false);

		receiveUnitAddressField = new DataSourceTextField("receiveUnitAddress", "收款单位所在地");
		receiveUnitAddressField.setLength(128);
		receiveUnitAddressField.setRequired(false);
		receiveUnitAddressField.setHidden(false);

		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "添加人");
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setRequired(false);
		operateEmployeeIdField.setHidden(false);
		operateEmployeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(false);

		originField = new DataSourceIntegerField("origin", "来源");
		originField.setLength(11);
		originField.setRequired(false);
		originField.setHidden(true);

		provinceField = new DataSourceIntegerField("province", "省");
		provinceField.setLength(11);
		provinceField.setRequired(false);
		provinceField.setHidden(false);
		provinceField.setValueMap(KeyValueManager.getValueMap("areas"));

		cityField = new DataSourceIntegerField("city", "市");
		cityField.setLength(11);
		cityField.setRequired(false);
		cityField.setHidden(false);
		cityField.setValueMap(KeyValueManager.getValueMap("areas"));

		bankAddressField = new DataSourceTextField("bankAddress", "收款人开户行地址");
		bankAddressField.setLength(255);
		bankAddressField.setRequired(false);
		bankAddressField.setHidden(false);

		receiveUnitPhoneField = new DataSourceTextField("receiveUnitPhone", "收款单位电话");
		receiveUnitPhoneField.setLength(255);
		receiveUnitPhoneField.setRequired(false);
		receiveUnitPhoneField.setHidden(false);

		swiftCodeField = new DataSourceTextField("swiftCode", "SWIFT CODE");
		swiftCodeField.setLength(255);
		swiftCodeField.setRequired(false);
		swiftCodeField.setHidden(true);

		countryIdField = new DataSourceIntegerField("countryId", "收款人常驻国家（地区）");
		countryIdField.setLength(11);
		countryIdField.setRequired(false);
		countryIdField.setHidden(true);
		countryIdField.setValueMap(KeyValueManager.getValueMap(""));

		countryCodeField = new DataSourceTextField("countryCode", "收款人常驻国家（地区）代码");
		countryCodeField.setLength(255);
		countryCodeField.setRequired(false);
		countryCodeField.setHidden(true);

		passportField = new DataSourceTextField("passport", "护照");
		passportField.setLength(255);
		passportField.setRequired(false);
		passportField.setHidden(true);

		bankIdField = new DataSourceIntegerField("bankId", "银行");
		bankIdField.setLength(11);
		bankIdField.setRequired(false);
		bankIdField.setHidden(true);

		accountTypeField = new DataSourceIntegerField("accountType", "收款方银行类型 1境内收款方 2境外收款方");
		accountTypeField.setLength(11);
		accountTypeField.setRequired(false);
		accountTypeField.setHidden(true);
		
		voucherTypeField = new DataSourceIntegerField("voucherType", "凭证类型");
		voucherTypeField.setLength(11);
		voucherTypeField.setRequired(false);
		voucherTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_227"));
		
		supplierTypeField = new DataSourceIntegerField("supplierType", "供应商类型");
		supplierTypeField.setLength(11);
		supplierTypeField.setRequired(false);
		supplierTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_237"));

		setFields(receiveUnitManageIdField, receiveUnitField, bankAccountField, bankNameField, receiveUnitAddressField,
				operateEmployeeIdField, operateTimeField, originField, provinceField, cityField, bankAddressField,
				receiveUnitPhoneField, swiftCodeField, countryIdField, countryCodeField, passportField, bankIdField,
				accountTypeField, voucherTypeField, supplierTypeField);
	}

}
