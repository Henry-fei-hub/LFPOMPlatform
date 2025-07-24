package com.pomplatform.client.supplierworkflow.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSupplier extends DBDataSource
{


	public static DSSupplier instance = null;

	public static DSSupplier getInstance() {
		if(instance == null) {
			instance = new DSSupplier("DSSupplier");
		}
		return instance;
	}

	private final DataSourceIntegerField supplierIdField;
	private final DataSourceTextField supplierNameField;
	private final DataSourceTextField supplierContactField;
	private final DataSourceTextField supplierPhoneField;
	private final DataSourceTextField supplierEmailField;
	private final DataSourceTextField supplierBankAccountField;
	private final DataSourceTextField supplierBankNameField;
	private final DataSourceIntegerField supplierTypeField;
	private final DataSourceIntegerField supplierMainBusinessTypeField;
	private final DataSourceTextField supplierScopeSupplyField;
	private final DataSourceTextField socialCreditCodeField;
	private final DataSourceIntegerField supplierBankProvinceField;
	private final DataSourceIntegerField supplierBankCityField;
	private final DataSourceTextField supplierBankAddressField;
	private final DataSourceTextField supplierAddressField;
	private final DataSourceIntegerField productionCycleField;
	private final DataSourceIntegerField logisticsCycleField;
	private final DataSourceTextField supplierBossField;
	private final DataSourceDateTimeField contractSigningTimeField;
	private final DataSourceTextField contractScopeTimeField;
	private final DataSourceDateTimeField contractScopeTimeStartField;
	private final DataSourceDateTimeField contractScopeTimeEndField;
	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceDateTimeField operateTimeField;
	private final DataSourceTextField supplierOriginField;
	private final DataSourceIntegerField supplierStatusField;
	private final DataSourceIntegerField isUseField;
	private final DataSourceIntegerField bankIdField;
	private final DataSourceIntegerField budgetAttachmentIdField;
	private final DataSourceIntegerField receiveUnitManageIdField;
	private final DataSourceIntegerField accountTypeField;
	private final DataSourceIntegerField agreementTypeField;
	private final DataSourceDateTimeField agreementSignTimeField;
	private final DataSourceTextField agreementSignAddressField;

	public DSSupplier(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("Supplier");


		supplierIdField = new DataSourceIntegerField("supplierId", "供应商编码");
		supplierIdField.setLength(11);
		supplierIdField.setPrimaryKey(true);
		supplierIdField.setRequired(true);
		supplierIdField.setHidden(false);


		supplierNameField = new DataSourceTextField("supplierName", "供应商名称");
		supplierNameField.setLength(128);
		supplierNameField.setRequired(false);
		supplierNameField.setHidden(false);


		supplierContactField = new DataSourceTextField("supplierContact", "供应商联系人");
		supplierContactField.setLength(255);
		supplierContactField.setRequired(false);
		supplierContactField.setHidden(false);


		supplierPhoneField = new DataSourceTextField("supplierPhone", "供应商电话");
		supplierPhoneField.setLength(255);
		supplierPhoneField.setRequired(false);
		supplierPhoneField.setHidden(false);


		supplierEmailField = new DataSourceTextField("supplierEmail", "供应商邮箱");
		supplierEmailField.setLength(255);
		supplierEmailField.setRequired(false);
		supplierEmailField.setHidden(false);


		supplierBankAccountField = new DataSourceTextField("supplierBankAccount", "供应商银行账号");
		supplierBankAccountField.setLength(255);
		supplierBankAccountField.setRequired(false);
		supplierBankAccountField.setHidden(false);


		supplierBankNameField = new DataSourceTextField("supplierBankName", "供应商开户行");
		supplierBankNameField.setLength(255);
		supplierBankNameField.setRequired(false);
		supplierBankNameField.setHidden(false);


		supplierTypeField = new DataSourceIntegerField("supplierType", "");
		supplierTypeField.setLength(11);
		supplierTypeField.setRequired(false);
		supplierTypeField.setHidden(false);


		supplierMainBusinessTypeField = new DataSourceIntegerField("supplierMainBusinessType", "供应商主营业务类型");
		supplierMainBusinessTypeField.setLength(11);
		supplierMainBusinessTypeField.setRequired(false);
		supplierMainBusinessTypeField.setHidden(false);


		supplierScopeSupplyField = new DataSourceTextField("supplierScopeSupply", "供货范围");
		supplierScopeSupplyField.setLength(128);
		supplierScopeSupplyField.setRequired(false);
		supplierScopeSupplyField.setHidden(false);


		socialCreditCodeField = new DataSourceTextField("socialCreditCode", "社会信用代码");
		socialCreditCodeField.setLength(255);
		socialCreditCodeField.setRequired(false);
		socialCreditCodeField.setHidden(false);


		supplierBankProvinceField = new DataSourceIntegerField("supplierBankProvince", "供应商开户行(省)");
		supplierBankProvinceField.setLength(11);
		supplierBankProvinceField.setRequired(false);
		supplierBankProvinceField.setHidden(false);


		supplierBankCityField = new DataSourceIntegerField("supplierBankCity", "供应商开户行(市)");
		supplierBankCityField.setLength(11);
		supplierBankCityField.setRequired(false);
		supplierBankCityField.setHidden(false);


		supplierBankAddressField = new DataSourceTextField("supplierBankAddress", "供应商开户行详细地址");
		supplierBankAddressField.setLength(255);
		supplierBankAddressField.setRequired(false);
		supplierBankAddressField.setHidden(false);


		supplierAddressField = new DataSourceTextField("supplierAddress", "供应商税务登记地址");
		supplierAddressField.setLength(255);
		supplierAddressField.setRequired(false);
		supplierAddressField.setHidden(false);


		productionCycleField = new DataSourceIntegerField("productionCycle", "");
		productionCycleField.setLength(11);
		productionCycleField.setRequired(false);
		productionCycleField.setHidden(true);


		logisticsCycleField = new DataSourceIntegerField("logisticsCycle", "物流周期");
		logisticsCycleField.setLength(11);
		logisticsCycleField.setRequired(false);
		logisticsCycleField.setHidden(true);


		supplierBossField = new DataSourceTextField("supplierBoss", "供应商法定代表人");
		supplierBossField.setLength(128);
		supplierBossField.setRequired(false);
		supplierBossField.setHidden(true);


		contractSigningTimeField = new DataSourceDateTimeField("contractSigningTime", "合同签订日期");
		contractSigningTimeField.setRequired(false);
		contractSigningTimeField.setHidden(true);


		contractScopeTimeField = new DataSourceTextField("contractScopeTime", "合同周期");
		contractScopeTimeField.setLength(128);
		contractScopeTimeField.setRequired(false);
		contractScopeTimeField.setHidden(true);


		contractScopeTimeStartField = new DataSourceDateTimeField("contractScopeTimeStart", "合同周期开始时间");
		contractScopeTimeStartField.setRequired(false);
		contractScopeTimeStartField.setHidden(true);


		contractScopeTimeEndField = new DataSourceDateTimeField("contractScopeTimeEnd", "合同周期结束时间");
		contractScopeTimeEndField.setRequired(false);
		contractScopeTimeEndField.setHidden(true);


		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "操作人");
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setRequired(false);
		operateEmployeeIdField.setHidden(true);


		operateTimeField = new DataSourceDateTimeField("operateTime", "供应商来源");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(true);


		supplierOriginField = new DataSourceTextField("supplierOrigin", "");
		supplierOriginField.setLength(0);
		supplierOriginField.setRequired(false);
		supplierOriginField.setHidden(true);


		supplierStatusField = new DataSourceIntegerField("supplierStatus", "供应商状态");
		supplierStatusField.setLength(11);
		supplierStatusField.setRequired(false);
		supplierStatusField.setHidden(true);


		isUseField = new DataSourceIntegerField("isUse", "供应商是否有效");
		isUseField.setLength(11);
		isUseField.setRequired(false);
		isUseField.setHidden(true);


		bankIdField = new DataSourceIntegerField("bankId", "银行编码");
		bankIdField.setLength(11);
		bankIdField.setRequired(false);
		bankIdField.setHidden(true);


		budgetAttachmentIdField = new DataSourceIntegerField("budgetAttachmentId", "预算附件主键编码");
		budgetAttachmentIdField.setLength(11);
		budgetAttachmentIdField.setRequired(false);
		budgetAttachmentIdField.setHidden(true);


		receiveUnitManageIdField = new DataSourceIntegerField("receiveUnitManageId", "收款单位主键编码");
		receiveUnitManageIdField.setLength(11);
		receiveUnitManageIdField.setRequired(false);
		receiveUnitManageIdField.setHidden(true);


		accountTypeField = new DataSourceIntegerField("accountType", "收款方银行类型 1境内收款方 2境外收款方");
		accountTypeField.setLength(11);
		accountTypeField.setRequired(false);
		accountTypeField.setHidden(true);


		agreementTypeField = new DataSourceIntegerField("agreementType", "协议类别");
		agreementTypeField.setLength(11);
		agreementTypeField.setRequired(false);
		agreementTypeField.setHidden(true);


		agreementSignTimeField = new DataSourceDateTimeField("agreementSignTime", "协议签订时间");
		agreementSignTimeField.setRequired(false);
		agreementSignTimeField.setHidden(true);


		agreementSignAddressField = new DataSourceTextField("agreementSignAddress", "协议签订地点");
		agreementSignAddressField.setLength(0);
		agreementSignAddressField.setRequired(false);
		agreementSignAddressField.setHidden(true);


		setFields(supplierIdField, supplierNameField, supplierContactField, supplierPhoneField, supplierEmailField, supplierBankAccountField, supplierBankNameField, supplierTypeField, supplierMainBusinessTypeField, supplierScopeSupplyField, socialCreditCodeField, supplierBankProvinceField, supplierBankCityField, supplierBankAddressField, supplierAddressField, productionCycleField, logisticsCycleField, supplierBossField, contractSigningTimeField, contractScopeTimeField, contractScopeTimeStartField, contractScopeTimeEndField, operateEmployeeIdField, operateTimeField, supplierOriginField, supplierStatusField, isUseField, bankIdField, budgetAttachmentIdField, receiveUnitManageIdField, accountTypeField, agreementTypeField, agreementSignTimeField, agreementSignAddressField);
	}


}

