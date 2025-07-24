package com.pomplatform.client.supplierworkflow.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSupplierComeIn extends DataSource
{


	public static CDSupplierComeIn instance = null;

	public static CDSupplierComeIn getInstance() {
		if(instance == null) {
			instance = new CDSupplierComeIn("CDSupplierComeIn");
		}
		return instance;
	}

	private final DataSourceIntegerField supplierIdField;
	private final DataSourceTextField supplierNameField;
	private final DataSourceTextField supplierContactField;
	private final DataSourceTextField supplierPhoneField;
	private final DataSourceTextField supplierEmailField;
	private final DataSourceIntegerField supplierTypeField;
	private final DataSourceIntegerField supplierMainBusinessTypeField;
	private final DataSourceTextField supplierScopeSupplyField;
	private final DataSourceTextField socialCreditCodeField;
	private final DataSourceIntegerField supplier_provinceField;
	private final DataSourceIntegerField supplier_cityField;
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
	private final DataSourceIntegerField receiveUnitManageIdField;
	private final DataSourceIntegerField agreementTypeField;
	private final DataSourceDateTimeField agreementSignTimeField;
	private final DataSourceTextField agreementSignAddressField;
	private final DataSourceIntegerField fileIdField;
	private final DataSourceIntegerField teamSizeField;
	private final DataSourceIntegerField areasExpertiseField;

	public CDSupplierComeIn(String dataSourceID) {

		setID(dataSourceID);
		supplierIdField = new DataSourceIntegerField("supplierId", "供应商编码");
		supplierIdField.setRequired(true);
		supplierIdField.setLength(11);
		supplierIdField.setPrimaryKey(true);
		supplierIdField.setHidden(true);

		supplierNameField = new DataSourceTextField("supplierName", "供应商名称");
		supplierNameField.setRequired(false);
		supplierNameField.setLength(128);
		supplierNameField.setHidden(false);

		supplierContactField = new DataSourceTextField("supplierContact", "供应商联系人");
		supplierContactField.setRequired(false);
		supplierContactField.setLength(255);
		supplierContactField.setHidden(false);

		supplierPhoneField = new DataSourceTextField("supplierPhone", "供应商电话");
		supplierPhoneField.setRequired(false);
		supplierPhoneField.setLength(255);
		supplierPhoneField.setHidden(false);

		supplierEmailField = new DataSourceTextField("supplierEmail", "供应商邮箱");
		supplierEmailField.setRequired(false);
		supplierEmailField.setLength(255);
		supplierEmailField.setHidden(false);

		supplierTypeField = new DataSourceIntegerField("supplierType", "供应商类型");
		supplierTypeField.setRequired(false);
		supplierTypeField.setLength(11);
		supplierTypeField.setHidden(false);

		supplierMainBusinessTypeField = new DataSourceIntegerField("supplierMainBusinessType", "供应商主营业务类型");
		supplierMainBusinessTypeField.setRequired(false);
		supplierMainBusinessTypeField.setLength(11);
		supplierMainBusinessTypeField.setHidden(false);

		supplierScopeSupplyField = new DataSourceTextField("supplierScopeSupply", "供货范围");
		supplierScopeSupplyField.setRequired(false);
		supplierScopeSupplyField.setLength(128);
		supplierScopeSupplyField.setHidden(false);

		socialCreditCodeField = new DataSourceTextField("socialCreditCode", "社会信用代码");
		socialCreditCodeField.setRequired(false);
		socialCreditCodeField.setLength(255);
		socialCreditCodeField.setHidden(false);

		supplier_provinceField = new DataSourceIntegerField("supplier_province", "供应商所在(省)");
		supplier_provinceField.setRequired(false);
		supplier_provinceField.setLength(11);
		supplier_provinceField.setHidden(false);

		supplier_cityField = new DataSourceIntegerField("supplier_city", "供应商所在(市)");
		supplier_cityField.setRequired(false);
		supplier_cityField.setLength(11);
		supplier_cityField.setHidden(false);

		supplierBankAddressField = new DataSourceTextField("supplierBankAddress", "供应商开户行详细地址");
		supplierBankAddressField.setRequired(false);
		supplierBankAddressField.setLength(255);
		supplierBankAddressField.setHidden(false);

		supplierAddressField = new DataSourceTextField("supplierAddress", "供应商税务登记地址");
		supplierAddressField.setRequired(false);
		supplierAddressField.setLength(255);
		supplierAddressField.setHidden(false);

		productionCycleField = new DataSourceIntegerField("productionCycle", "生产周期");
		productionCycleField.setRequired(false);
		productionCycleField.setLength(11);
		productionCycleField.setHidden(false);

		logisticsCycleField = new DataSourceIntegerField("logisticsCycle", "物流周期");
		logisticsCycleField.setRequired(false);
		logisticsCycleField.setLength(11);
		logisticsCycleField.setHidden(false);

		supplierBossField = new DataSourceTextField("supplierBoss", "供应商法定代表人");
		supplierBossField.setRequired(false);
		supplierBossField.setLength(128);
		supplierBossField.setHidden(false);

		contractSigningTimeField = new DataSourceDateTimeField("contractSigningTime", "合同签订日期");
		contractSigningTimeField.setRequired(false);
		contractSigningTimeField.setHidden(false);

		contractScopeTimeField = new DataSourceTextField("contractScopeTime", "合同周期");
		contractScopeTimeField.setRequired(false);
		contractScopeTimeField.setLength(128);
		contractScopeTimeField.setHidden(false);

		contractScopeTimeStartField = new DataSourceDateTimeField("contractScopeTimeStart", "合同周期开始时间");
		contractScopeTimeStartField.setRequired(false);
		contractScopeTimeStartField.setHidden(false);

		contractScopeTimeEndField = new DataSourceDateTimeField("contractScopeTimeEnd", "合同周期结束时间");
		contractScopeTimeEndField.setRequired(false);
		contractScopeTimeEndField.setHidden(false);

		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "操作人");
		operateEmployeeIdField.setRequired(false);
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setHidden(false);

		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(false);

		supplierOriginField = new DataSourceTextField("supplierOrigin", "供应商来源");
		supplierOriginField.setRequired(false);
		supplierOriginField.setLength(0);
		supplierOriginField.setHidden(false);

		supplierStatusField = new DataSourceIntegerField("supplierStatus", "供应商状态");
		supplierStatusField.setRequired(false);
		supplierStatusField.setLength(11);
		supplierStatusField.setHidden(false);

		isUseField = new DataSourceIntegerField("isUse", "收款单位是否有效(0无效，1有效)");
		isUseField.setRequired(false);
		isUseField.setLength(11);
		isUseField.setHidden(false);

		receiveUnitManageIdField = new DataSourceIntegerField("receiveUnitManageId", "收款单位主键编码");
		receiveUnitManageIdField.setRequired(false);
		receiveUnitManageIdField.setLength(11);
		receiveUnitManageIdField.setHidden(false);

		agreementTypeField = new DataSourceIntegerField("agreementType", "协议类别");
		agreementTypeField.setRequired(false);
		agreementTypeField.setLength(11);
		agreementTypeField.setHidden(false);

		agreementSignTimeField = new DataSourceDateTimeField("agreementSignTime", "协议签订时间");
		agreementSignTimeField.setRequired(false);
		agreementSignTimeField.setHidden(false);

		agreementSignAddressField = new DataSourceTextField("agreementSignAddress", "协议签订地点");
		agreementSignAddressField.setRequired(false);
		agreementSignAddressField.setLength(0);
		agreementSignAddressField.setHidden(false);

		fileIdField = new DataSourceIntegerField("fileId", "附件编码");
		fileIdField.setRequired(false);
		fileIdField.setLength(11);
		fileIdField.setHidden(false);

		teamSizeField = new DataSourceIntegerField("teamSize", "团队规模");
		teamSizeField.setRequired(false);
		teamSizeField.setLength(11);
		teamSizeField.setHidden(false);

		areasExpertiseField = new DataSourceIntegerField("areasExpertise", "擅长领域");
		areasExpertiseField.setRequired(false);
		areasExpertiseField.setLength(11);
		areasExpertiseField.setHidden(false);

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


		setFields(supplierIdField, supplierNameField, supplierContactField, supplierPhoneField, supplierEmailField, supplierTypeField, supplierMainBusinessTypeField, supplierScopeSupplyField, socialCreditCodeField, supplier_provinceField, supplier_cityField, supplierBankAddressField, supplierAddressField, productionCycleField, logisticsCycleField, supplierBossField, contractSigningTimeField, contractScopeTimeField, contractScopeTimeStartField, contractScopeTimeEndField, operateEmployeeIdField, operateTimeField, supplierOriginField, supplierStatusField, isUseField, receiveUnitManageIdField, agreementTypeField, agreementSignTimeField, agreementSignAddressField, fileIdField, teamSizeField, areasExpertiseField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

