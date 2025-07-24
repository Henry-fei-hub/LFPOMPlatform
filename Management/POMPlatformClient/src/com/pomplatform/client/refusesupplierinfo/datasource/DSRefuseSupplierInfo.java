package com.pomplatform.client.refusesupplierinfo.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSRefuseSupplierInfo extends DBDataSource
{


	public static DSRefuseSupplierInfo instance = null;

	public static DSRefuseSupplierInfo getInstance() {
		if(instance == null) {
			instance = new DSRefuseSupplierInfo("DSRefuseSupplierInfo");
		}
		return instance;
	}

	private final DataSourceIntegerField processInstanceIdField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField businessIdField;
	private final DataSourceTextField businessNameField;
	private final DataSourceIntegerField processIdField;
	private final DataSourceIntegerField processInstanceActivityIdField;
	private final DataSourceIntegerField processStatusField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceDateTimeField completeTimeField;
	private final DataSourceIntegerField employeeIdField;
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
	private final DataSourceTextField fileNameField;
	private final DataSourceLinkField fileUrlField;

	public DSRefuseSupplierInfo(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("RefuseSupplierInfo");


		processInstanceIdField = new DataSourceIntegerField("processInstanceId", "主键编码");
		processInstanceIdField.setLength(11);
		processInstanceIdField.setPrimaryKey(true);
		processInstanceIdField.setRequired(true);
		processInstanceIdField.setHidden(false);


		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setLength(11);
		processTypeField.setRequired(false);
		processTypeField.setHidden(false);


		businessIdField = new DataSourceIntegerField("businessId", "业务编码");
		businessIdField.setLength(11);
		businessIdField.setRequired(false);
		businessIdField.setHidden(false);


		businessNameField = new DataSourceTextField("businessName", "业务名称");
		businessNameField.setLength(128);
		businessNameField.setRequired(false);
		businessNameField.setHidden(false);


		processIdField = new DataSourceIntegerField("processId", "流程编码");
		processIdField.setLength(11);
		processIdField.setRequired(false);
		processIdField.setHidden(false);


		processInstanceActivityIdField = new DataSourceIntegerField("processInstanceActivityId", "活动实列编码");
		processInstanceActivityIdField.setLength(11);
		processInstanceActivityIdField.setRequired(false);
		processInstanceActivityIdField.setHidden(false);


		processStatusField = new DataSourceIntegerField("processStatus", "流程状态 0 发起中  1");
		processStatusField.setLength(11);
		processStatusField.setRequired(false);
		processStatusField.setHidden(false);


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);


		completeTimeField = new DataSourceDateTimeField("completeTime", "完成时间");
		completeTimeField.setRequired(false);
		completeTimeField.setHidden(false);


		employeeIdField = new DataSourceIntegerField("employeeId", "创建人");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);


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
		supplierContactField.setLength(128);
		supplierContactField.setRequired(false);
		supplierContactField.setHidden(false);


		supplierPhoneField = new DataSourceTextField("supplierPhone", "供应商电话");
		supplierPhoneField.setLength(128);
		supplierPhoneField.setRequired(false);
		supplierPhoneField.setHidden(false);


		supplierEmailField = new DataSourceTextField("supplierEmail", "供应商邮箱");
		supplierEmailField.setLength(128);
		supplierEmailField.setRequired(false);
		supplierEmailField.setHidden(false);


		supplierTypeField = new DataSourceIntegerField("supplierType", "供应商类型");
		supplierTypeField.setLength(11);
		supplierTypeField.setRequired(false);
		supplierTypeField.setHidden(true);


		supplierMainBusinessTypeField = new DataSourceIntegerField("supplierMainBusinessType", "供应商主营业务类型");
		supplierMainBusinessTypeField.setLength(11);
		supplierMainBusinessTypeField.setRequired(false);
		supplierMainBusinessTypeField.setHidden(true);


		supplierScopeSupplyField = new DataSourceTextField("supplierScopeSupply", "供货范围");
		supplierScopeSupplyField.setLength(128);
		supplierScopeSupplyField.setRequired(false);
		supplierScopeSupplyField.setHidden(true);


		socialCreditCodeField = new DataSourceTextField("socialCreditCode", "社会信用代码");
		socialCreditCodeField.setLength(128);
		socialCreditCodeField.setRequired(false);
		socialCreditCodeField.setHidden(true);


		supplier_provinceField = new DataSourceIntegerField("supplier_province", "供应商所在(省)");
		supplier_provinceField.setLength(11);
		supplier_provinceField.setRequired(false);
		supplier_provinceField.setHidden(true);


		supplier_cityField = new DataSourceIntegerField("supplier_city", "供应商所在(市)");
		supplier_cityField.setLength(11);
		supplier_cityField.setRequired(false);
		supplier_cityField.setHidden(true);


		supplierBankAddressField = new DataSourceTextField("supplierBankAddress", "供应商开户行详细地址");
		supplierBankAddressField.setLength(128);
		supplierBankAddressField.setRequired(false);
		supplierBankAddressField.setHidden(true);


		supplierAddressField = new DataSourceTextField("supplierAddress", "供应商税务登记地址");
		supplierAddressField.setLength(128);
		supplierAddressField.setRequired(false);
		supplierAddressField.setHidden(true);


		productionCycleField = new DataSourceIntegerField("productionCycle", "生产周期");
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


		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(true);


		supplierOriginField = new DataSourceTextField("supplierOrigin", "供应商来源");
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


		receiveUnitManageIdField = new DataSourceIntegerField("receiveUnitManageId", "收款单位主键编码");
		receiveUnitManageIdField.setLength(11);
		receiveUnitManageIdField.setRequired(false);
		receiveUnitManageIdField.setHidden(true);


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


		fileIdField = new DataSourceIntegerField("fileId", "附件编码");
		fileIdField.setLength(11);
		fileIdField.setRequired(false);
		fileIdField.setHidden(true);


		teamSizeField = new DataSourceIntegerField("teamSize", "团队规模");
		teamSizeField.setLength(11);
		teamSizeField.setRequired(false);
		teamSizeField.setHidden(true);


		areasExpertiseField = new DataSourceIntegerField("areasExpertise", "擅长领域");
		areasExpertiseField.setLength(11);
		areasExpertiseField.setRequired(false);
		areasExpertiseField.setHidden(true);


		fileNameField = new DataSourceTextField("fileName", "文件名");
		fileNameField.setLength(512);
		fileNameField.setRequired(false);
		fileNameField.setHidden(true);


		fileUrlField = new DataSourceLinkField("fileUrl", "文件路径");
		fileUrlField.setLength(1024);
		fileUrlField.setRequired(false);
		fileUrlField.setHidden(true);


		setFields(processInstanceIdField, supplierIdField, processTypeField, businessIdField, businessNameField, processIdField, processInstanceActivityIdField, processStatusField, createTimeField, completeTimeField, employeeIdField, supplierNameField, supplierContactField, supplierPhoneField, supplierEmailField, supplierTypeField, supplierMainBusinessTypeField, supplierScopeSupplyField, socialCreditCodeField, supplier_provinceField, supplier_cityField, supplierBankAddressField, supplierAddressField, productionCycleField, logisticsCycleField, supplierBossField, contractSigningTimeField, contractScopeTimeField, contractScopeTimeStartField, contractScopeTimeEndField, operateEmployeeIdField, operateTimeField, supplierOriginField, supplierStatusField, isUseField, receiveUnitManageIdField, agreementTypeField, agreementSignTimeField, agreementSignAddressField, fileIdField, teamSizeField, areasExpertiseField, fileNameField, fileUrlField);
	}


}

