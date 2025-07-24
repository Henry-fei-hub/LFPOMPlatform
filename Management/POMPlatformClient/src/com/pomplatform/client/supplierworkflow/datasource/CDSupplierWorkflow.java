package com.pomplatform.client.supplierworkflow.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSupplierWorkflow extends DataSource
{


	public static CDSupplierWorkflow instance = null;

	public static CDSupplierWorkflow getInstance() {
		if(instance == null) {
			instance = new CDSupplierWorkflow("CDSupplierWorkflow");
		}
		return instance;
	}

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

	public CDSupplierWorkflow(String dataSourceID) {

		setID(dataSourceID);
		receiveUnitField = new DataSourceTextField("receiveUnit", "收款单位");
		receiveUnitField.setRequired(false);
		receiveUnitField.setLength(128);
		receiveUnitField.setHidden(false);

		bankAccountField = new DataSourceTextField("bankAccount", "银行账号");
		bankAccountField.setRequired(false);
		bankAccountField.setLength(64);
		bankAccountField.setHidden(false);

		bankNameField = new DataSourceTextField("bankName", "开户行");
		bankNameField.setRequired(false);
		bankNameField.setLength(128);
		bankNameField.setHidden(false);

		receiveUnitAddressField = new DataSourceTextField("receiveUnitAddress", "收款单位所在地");
		receiveUnitAddressField.setRequired(false);
		receiveUnitAddressField.setLength(128);
		receiveUnitAddressField.setHidden(false);

		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "操作人");
		operateEmployeeIdField.setRequired(false);
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setHidden(false);

		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(false);

		originField = new DataSourceIntegerField("origin", "来源");
		originField.setRequired(false);
		originField.setLength(11);
		originField.setHidden(false);

		receiveUnitTypeField = new DataSourceIntegerField("receiveUnitType", "收款单位类型 1 人资发起薪资流程报销使用");
		receiveUnitTypeField.setRequired(false);
		receiveUnitTypeField.setLength(11);
		receiveUnitTypeField.setHidden(false);

		companyIdField = new DataSourceTextField("companyId", "归属公司 逗号拼接");
		companyIdField.setRequired(false);
		companyIdField.setLength(32);
		companyIdField.setHidden(false);

		salaryTypeField = new DataSourceIntegerField("salaryType", "薪资发放类型  1实付工资 2个人社保 3个人公积金 4个税");
		salaryTypeField.setRequired(false);
		salaryTypeField.setLength(11);
		salaryTypeField.setHidden(false);

		provinceField = new DataSourceIntegerField("province", "省");
		provinceField.setRequired(false);
		provinceField.setLength(11);
		provinceField.setHidden(false);

		cityField = new DataSourceIntegerField("city", "市");
		cityField.setRequired(false);
		cityField.setLength(11);
		cityField.setHidden(false);

		bankAddressField = new DataSourceTextField("bankAddress", "收款人开户行地址");
		bankAddressField.setRequired(false);
		bankAddressField.setLength(255);
		bankAddressField.setHidden(false);

		receiveUnitPhoneField = new DataSourceTextField("receiveUnitPhone", "收款单位电话");
		receiveUnitPhoneField.setRequired(false);
		receiveUnitPhoneField.setLength(255);
		receiveUnitPhoneField.setHidden(false);

		swiftCodeField = new DataSourceTextField("swiftCode", "SWIFT CODE");
		swiftCodeField.setRequired(false);
		swiftCodeField.setLength(255);
		swiftCodeField.setHidden(false);

		countryIdField = new DataSourceIntegerField("countryId", "收款人常驻国家（地区）");
		countryIdField.setRequired(false);
		countryIdField.setLength(11);
		countryIdField.setHidden(false);

		countryCodeField = new DataSourceTextField("countryCode", "收款人常驻国家（地区）代码");
		countryCodeField.setRequired(false);
		countryCodeField.setLength(255);
		countryCodeField.setHidden(false);

		passportField = new DataSourceTextField("passport", "护照");
		passportField.setRequired(false);
		passportField.setLength(255);
		passportField.setHidden(false);

		bankIdField = new DataSourceIntegerField("bankId", "银行");
		bankIdField.setRequired(false);
		bankIdField.setLength(11);
		bankIdField.setHidden(false);

		accountTypeField = new DataSourceIntegerField("accountType", "收款方银行类型 1境内收款方 2境外收款方");
		accountTypeField.setRequired(false);
		accountTypeField.setLength(11);
		accountTypeField.setHidden(false);

		isUseField = new DataSourceIntegerField("isUse", "收款单位是否有效(0无效，1有效)");
		isUseField.setRequired(false);
		isUseField.setLength(11);
		isUseField.setHidden(false);

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


		setFields(receiveUnitField, bankAccountField, bankNameField, receiveUnitAddressField, operateEmployeeIdField, operateTimeField, originField, receiveUnitTypeField, companyIdField, salaryTypeField, provinceField, cityField, bankAddressField, receiveUnitPhoneField, swiftCodeField, countryIdField, countryCodeField, passportField, bankIdField, accountTypeField, isUseField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

