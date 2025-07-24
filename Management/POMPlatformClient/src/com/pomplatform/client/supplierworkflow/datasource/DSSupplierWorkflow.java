package com.pomplatform.client.supplierworkflow.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSupplierWorkflow extends DBDataSource
{


	public static DSSupplierWorkflow instance = null;

	public static DSSupplierWorkflow getInstance() {
		if(instance == null) {
			instance = new DSSupplierWorkflow("DSSupplierWorkflow");
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
	private final DataSourceIntegerField receiveUnitTypeField;
	private final DataSourceTextField companyIdField;
	private final DataSourceIntegerField salaryTypeField;
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
	private final DataSourceIntegerField isUseField;
	private final DataSourceField detailSupplier;

	public DSSupplierWorkflow(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("SupplierWorkflow");


		receiveUnitManageIdField = new DataSourceIntegerField("receiveUnitManageId", "主键编码");
		receiveUnitManageIdField.setLength(11);
		receiveUnitManageIdField.setPrimaryKey(true);
		receiveUnitManageIdField.setRequired(true);
		receiveUnitManageIdField.setHidden(false);


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


		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "操作人");
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setRequired(false);
		operateEmployeeIdField.setHidden(false);


		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(false);


		originField = new DataSourceIntegerField("origin", "来源");
		originField.setLength(11);
		originField.setRequired(false);
		originField.setHidden(false);


		receiveUnitTypeField = new DataSourceIntegerField("receiveUnitType", "收款单位类型 1 人资发起薪资流程报销使用");
		receiveUnitTypeField.setLength(11);
		receiveUnitTypeField.setRequired(false);
		receiveUnitTypeField.setHidden(false);


		companyIdField = new DataSourceTextField("companyId", "归属公司 逗号拼接");
		companyIdField.setLength(32);
		companyIdField.setRequired(false);
		companyIdField.setHidden(false);


		salaryTypeField = new DataSourceIntegerField("salaryType", "薪资发放类型  1实付工资 2个人社保 3个人公积金 4个税");
		salaryTypeField.setLength(11);
		salaryTypeField.setRequired(false);
		salaryTypeField.setHidden(false);


		provinceField = new DataSourceIntegerField("province", "省");
		provinceField.setLength(11);
		provinceField.setRequired(false);
		provinceField.setHidden(false);


		cityField = new DataSourceIntegerField("city", "市");
		cityField.setLength(11);
		cityField.setRequired(false);
		cityField.setHidden(false);


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


		isUseField = new DataSourceIntegerField("isUse", "收款单位是否有效(0无效，1有效)");
		isUseField.setLength(11);
		isUseField.setRequired(false);
		isUseField.setHidden(true);

		detailSupplier = new DataSourceField("detailSupplier", FieldType.ANY);
		detailSupplier.setChildrenProperty(true);
		detailSupplier.setChildTagName("Supplier");
		detailSupplier.setRequired(false);
		detailSupplier.setHidden(true);

		setFields(receiveUnitManageIdField, receiveUnitField, bankAccountField, bankNameField, receiveUnitAddressField, operateEmployeeIdField, operateTimeField, originField, receiveUnitTypeField, companyIdField, salaryTypeField, provinceField, cityField, bankAddressField, receiveUnitPhoneField, swiftCodeField, countryIdField, countryCodeField, passportField, bankIdField, accountTypeField, isUseField, detailSupplier);
	}


}

