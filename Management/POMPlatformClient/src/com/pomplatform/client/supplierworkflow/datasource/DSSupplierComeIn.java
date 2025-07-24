package com.pomplatform.client.supplierworkflow.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.common.SyncDataUtil;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.delicacy.client.data.DBDataSource;

public class DSSupplierComeIn extends DBDataSource
{


	public static DSSupplierComeIn instance = null;

	public static DSSupplierComeIn getInstance() {
		if(instance == null) {
			instance = new DSSupplierComeIn("DSSupplierComeIn");
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
	private final DataSourceField detailSupplierDetail;
	private final DataSourceField detailSupplierCooperation;
	private final DataSourceLinkField attachmentField;

	public DSSupplierComeIn(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("SupplierComeIn");


		supplierIdField = new DataSourceIntegerField("supplierId", "供应商编码");
		supplierIdField.setLength(11);
		supplierIdField.setPrimaryKey(true);
		supplierIdField.setRequired(true);
		supplierIdField.setHidden(true);


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

		Map<String,Object> map=new HashMap<>();
		map.put("optType", "supplieTypeInfo");
		LinkedHashMap<Integer, String> userData =SyncDataUtil.getValues("EP_GetSupplierInfo", "find", map);
		supplierTypeField = new DataSourceIntegerField("supplierType", "供应商类型");
		supplierTypeField.setLength(11);
		supplierTypeField.setRequired(false);
		supplierTypeField.setHidden(false);
		supplierTypeField.setValueMap(userData);


		supplierMainBusinessTypeField = new DataSourceIntegerField("supplierMainBusinessType", "供应商主营业务类型");
		supplierMainBusinessTypeField.setLength(11);
		supplierMainBusinessTypeField.setRequired(false);
		supplierMainBusinessTypeField.setHidden(true);


		supplierScopeSupplyField = new DataSourceTextField("supplierScopeSupply", "供货范围");
		supplierScopeSupplyField.setLength(128);
		supplierScopeSupplyField.setRequired(false);
		supplierScopeSupplyField.setHidden(true);


		socialCreditCodeField = new DataSourceTextField("socialCreditCode", "社会信用代码");
		socialCreditCodeField.setLength(255);
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
		supplierBankAddressField.setLength(255);
		supplierBankAddressField.setRequired(false);
		supplierBankAddressField.setHidden(true);


		supplierAddressField = new DataSourceTextField("supplierAddress", "供应商税务登记地址");
		supplierAddressField.setLength(255);
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
		operateTimeField.setHidden(false);


		supplierOriginField = new DataSourceTextField("supplierOrigin", "供应商来源");
		supplierOriginField.setLength(0);
		supplierOriginField.setRequired(false);
		supplierOriginField.setHidden(true);


		supplierStatusField = new DataSourceIntegerField("supplierStatus", "供应商状态");
		supplierStatusField.setLength(11);
		supplierStatusField.setRequired(false);
		supplierStatusField.setHidden(true);


		LinkedHashMap<Integer, String> linkMap=new LinkedHashMap<>();
		linkMap.put(0, "无效");
		linkMap.put(1, "有效");
		isUseField = new DataSourceIntegerField("isUse", "供应商是否有效");
		isUseField.setLength(11);
		isUseField.setValueMap(linkMap);
		isUseField.setRequired(false);
		isUseField.setHidden(false);

		receiveUnitManageIdField = new DataSourceIntegerField("receiveUnitManageId", "主键编码");
		receiveUnitManageIdField.setLength(11);
		receiveUnitManageIdField.setPrimaryKey(true);
		receiveUnitManageIdField.setRequired(true);
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
		teamSizeField.setHidden(false);


		areasExpertiseField = new DataSourceIntegerField("areasExpertise", "擅长领域");
		areasExpertiseField.setLength(11);
		KeyValueManager.loadValueMap("system_dictionary_213", areasExpertiseField);
		areasExpertiseField.setRequired(false);
		areasExpertiseField.setHidden(false);

		detailSupplierDetail = new DataSourceField("detailSupplierDetail", FieldType.ANY);
		detailSupplierDetail.setChildrenProperty(true);
		detailSupplierDetail.setChildTagName("SupplierDetail");
		detailSupplierDetail.setRequired(false);
		detailSupplierDetail.setHidden(true);
		detailSupplierCooperation = new DataSourceField("detailSupplierCooperation", FieldType.ANY);
		detailSupplierCooperation.setChildrenProperty(true);
		detailSupplierCooperation.setChildTagName("SupplierCooperation");
		detailSupplierCooperation.setRequired(false);
		detailSupplierCooperation.setHidden(true);
		
		
		attachmentField = new DataSourceLinkField("attachment", "附件");
		attachmentField.setLength(512);
		attachmentField.setRequired(false);
		attachmentField.setHidden(false);

		setFields(supplierIdField, receiveUnitManageIdField, supplierNameField, supplierContactField, supplierPhoneField, supplierEmailField, supplierTypeField, supplierMainBusinessTypeField, supplierScopeSupplyField, socialCreditCodeField, supplier_provinceField, supplier_cityField, supplierBankAddressField, supplierAddressField, productionCycleField, logisticsCycleField, supplierBossField, contractSigningTimeField, contractScopeTimeField, contractScopeTimeStartField, contractScopeTimeEndField, operateEmployeeIdField, operateTimeField, supplierOriginField, supplierStatusField, isUseField, agreementTypeField, agreementSignTimeField, agreementSignAddressField, fileIdField, teamSizeField, areasExpertiseField, detailSupplierDetail, detailSupplierCooperation,attachmentField);
	}


}

