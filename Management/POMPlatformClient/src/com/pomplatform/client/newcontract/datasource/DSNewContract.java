package com.pomplatform.client.newcontract.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSNewContract extends DBDataSource
{


	public static DSNewContract instance = null;

	public static DSNewContract getInstance() {
		if(instance == null) {
			instance = new DSNewContract("DSNewContract");
		}
		return instance;
	}

	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField infoCodeField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceTextField customerNameField;
	private final DataSourceDateField startDateField;
	private final DataSourceDateField endDateField;
	private final DataSourceIntegerField statusField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceIntegerField contractTypeField;
	private final DataSourceIntegerField projectLevelField;
	private final DataSourceIntegerField totalProjectTimeField;
	private final DataSourceFloatField signingMoneySumField;
	private final DataSourceFloatField designAreasField;
	private final DataSourceFloatField contractPriceField;
	private final DataSourceTextField projectAddressField;
	private final DataSourceIntegerField contractFollowerField;
	private final DataSourceTextField remarkField;
	private final DataSourceDateField contractDateField;
	private final DataSourceIntegerField signingCompanyNameField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceDateTimeField updateTimeField;
	private final DataSourceTextField businessTypeField;
	private final DataSourceIntegerField flowStatusField;
	private final DataSourceIntegerField serialNumberField;
	private final DataSourceTextField projectTypeField;
	private final DataSourceFloatField coveredAreaField;
	private final DataSourceTextField professionalCooperationField;
	private final DataSourceTextField provinceField;
	private final DataSourceTextField cityField;
	private final DataSourceTextField detailAddressField;
	private final DataSourceTextField customerAddressField;
	private final DataSourceTextField serviceSuggestBookField;
	private final DataSourceDateField projectApprovalTimeField;

	public DSNewContract(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("NewContract");


		contractIdField = new DataSourceIntegerField("contractId", "主合同编码");
		contractIdField.setLength(11);
		contractIdField.setPrimaryKey(true);
		contractIdField.setRequired(true);
		contractIdField.setHidden(true);

		
		infoCodeField = new DataSourceTextField("infoCode", "信息编号");
		infoCodeField.setLength(64);
		infoCodeField.setRequired(false);
		infoCodeField.setHidden(true);
		
		
		contractCodeField = new DataSourceTextField("contractCode", "主合同编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);

		
		contractNameField = new DataSourceTextField("contractName", "主合同名称");
		contractNameField.setLength(512);
		contractNameField.setRequired(false);
		contractNameField.setHidden(false);


		customerNameField = new DataSourceTextField("customerName", "客户名称");
		customerNameField.setLength(512);
		customerNameField.setRequired(false);
		customerNameField.setHidden(false);


		startDateField = new DataSourceDateField("startDate", "开始日期");
		startDateField.setRequired(false);
		startDateField.setHidden(false);


		endDateField = new DataSourceDateField("endDate", "结束日期");
		endDateField.setRequired(false);
		endDateField.setHidden(false);


		statusField = new DataSourceIntegerField("status", "结算状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_16"));


		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(64);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(false);


		contractTypeField = new DataSourceIntegerField("contractType", "合同类别");
		contractTypeField.setLength(11);
		contractTypeField.setRequired(false);
		contractTypeField.setHidden(false);
		contractTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_27"));


		projectLevelField = new DataSourceIntegerField("projectLevel", "项目等级");
		projectLevelField.setLength(11);
		projectLevelField.setRequired(false);
		projectLevelField.setHidden(false);
		projectLevelField.setValueMap(KeyValueManager.getValueMap("system_dictionary_2"));


		totalProjectTimeField = new DataSourceIntegerField("totalProjectTime", "项目总工期");
		totalProjectTimeField.setLength(11);
		totalProjectTimeField.setRequired(false);
		totalProjectTimeField.setHidden(false);


		signingMoneySumField = new DataSourceFloatField("signingMoneySum", "合同金额");
		signingMoneySumField.setLength(16);
		signingMoneySumField.setDecimalPad(2);
		signingMoneySumField.setFormat("##,###,###,###,##0.00");
		signingMoneySumField.setRequired(false);
		signingMoneySumField.setHidden(false);


		designAreasField = new DataSourceFloatField("designAreas", "设计面积");
		designAreasField.setLength(16);
		designAreasField.setDecimalPad(2);
		designAreasField.setFormat("##,###,###,###,##0.00");
		designAreasField.setRequired(false);
		designAreasField.setHidden(false);


		contractPriceField = new DataSourceFloatField("contractPrice", "合同单价");
		contractPriceField.setLength(16);
		contractPriceField.setDecimalPad(2);
		contractPriceField.setFormat("##,###,###,###,##0.00");
		contractPriceField.setRequired(false);
		contractPriceField.setHidden(true);


		projectAddressField = new DataSourceTextField("projectAddress", "项目地点");
		projectAddressField.setLength(200);
		projectAddressField.setRequired(false);
		projectAddressField.setHidden(true);


		contractFollowerField = new DataSourceIntegerField("contractFollower", "合同跟进人");
		contractFollowerField.setLength(11);
		contractFollowerField.setRequired(false);
		contractFollowerField.setHidden(true);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(512);
		remarkField.setRequired(false);
		remarkField.setHidden(true);


		contractDateField = new DataSourceDateField("contractDate", "合同签订日期");
		contractDateField.setRequired(false);
		contractDateField.setHidden(true);


		signingCompanyNameField = new DataSourceIntegerField("signingCompanyName", "我方签约公司名称");
		signingCompanyNameField.setLength(11);
		signingCompanyNameField.setRequired(false);
		signingCompanyNameField.setHidden(true);
		signingCompanyNameField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(true);


		updateTimeField = new DataSourceDateTimeField("updateTime", "修改时间");
		updateTimeField.setRequired(false);
		updateTimeField.setHidden(true);


		businessTypeField = new DataSourceTextField("businessType", "业务类别");
		businessTypeField.setLength(120);
		businessTypeField.setRequired(false);
		businessTypeField.setHidden(false);


		flowStatusField = new DataSourceIntegerField("flowStatus", "流转状态");
		flowStatusField.setLength(11);
		flowStatusField.setRequired(false);
		flowStatusField.setHidden(true);
		flowStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_33"));


		serialNumberField = new DataSourceIntegerField("serialNumber", "流水号");
		serialNumberField.setLength(11);
		serialNumberField.setRequired(false);
		serialNumberField.setHidden(true);


		projectTypeField = new DataSourceTextField("projectType", "项目类别");
		projectTypeField.setLength(128);
		projectTypeField.setRequired(false);
		projectTypeField.setHidden(true);


		coveredAreaField = new DataSourceFloatField("coveredArea", "建筑面积");
		coveredAreaField.setLength(16);
		coveredAreaField.setDecimalPad(2);
		coveredAreaField.setFormat("##,###,###,###,##0.00");
		coveredAreaField.setRequired(false);
		coveredAreaField.setHidden(true);


		professionalCooperationField = new DataSourceTextField("professionalCooperation", "配合专业");
		professionalCooperationField.setLength(128);
		professionalCooperationField.setRequired(false);
		professionalCooperationField.setHidden(true);


		provinceField = new DataSourceTextField("province", "省份");
		provinceField.setLength(50);
		provinceField.setRequired(false);
		provinceField.setHidden(true);


		cityField = new DataSourceTextField("city", "城市");
		cityField.setLength(50);
		cityField.setRequired(false);
		cityField.setHidden(true);


		detailAddressField = new DataSourceTextField("detailAddress", "详细地址");
		detailAddressField.setLength(50);
		detailAddressField.setRequired(false);
		detailAddressField.setHidden(true);


		customerAddressField = new DataSourceTextField("customerAddress", "客户地址");
		customerAddressField.setLength(512);
		customerAddressField.setRequired(false);
		customerAddressField.setHidden(true);


		serviceSuggestBookField = new DataSourceTextField("serviceSuggestBook", "服务建议书");
		serviceSuggestBookField.setLength(512);
		serviceSuggestBookField.setRequired(false);
		serviceSuggestBookField.setHidden(true);


		projectApprovalTimeField = new DataSourceDateField("projectApprovalTime", "立单时间");
		projectApprovalTimeField.setRequired(false);
		projectApprovalTimeField.setHidden(true);


		setFields(infoCodeField, contractIdField, contractCodeField, contractNameField, customerNameField,businessTypeField,projectLevelField,totalProjectTimeField, signingMoneySumField,designAreasField,statusField,projectCodeField,contractTypeField,startDateField, endDateField, contractPriceField, projectAddressField, contractFollowerField, remarkField, contractDateField, signingCompanyNameField, createTimeField, updateTimeField,  flowStatusField, serialNumberField, projectTypeField, coveredAreaField, professionalCooperationField, provinceField, cityField, detailAddressField, customerAddressField, serviceSuggestBookField, projectApprovalTimeField);
	}


}

