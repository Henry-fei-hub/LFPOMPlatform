package com.pomplatform.client.minvocieapplydedaocor.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSMcontracticcccsprfiiibaadicrbbior extends DBDataSource
{


	public static DSMcontracticcccsprfiiibaadicrbbior instance = null;

	public static DSMcontracticcccsprfiiibaadicrbbior getInstance() {
		if(instance == null) {
			instance = new DSMcontracticcccsprfiiibaadicrbbior("DSMcontracticcccsprfiiibaadicrbbior");
		}
		return instance;
	}

	private final DataSourceIntegerField contractIdField;
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
	private final DataSourceTextField serialNumberField;
	private final DataSourceTextField projectTypeField;
	private final DataSourceFloatField coveredAreaField;
	private final DataSourceTextField professionalCooperationField;
	private final DataSourceTextField provinceField;
	private final DataSourceTextField cityField;
	private final DataSourceTextField detailAddressField;
	private final DataSourceTextField customerAddressField;
	private final DataSourceTextField serviceSuggestBookField;
	private final DataSourceDateField projectApprovalTimeField;
	private final DataSourceIntegerField orderNoField;
	private final DataSourceIntegerField parentIdField;
	private final DataSourceTextField infoCodeField;
	private final DataSourceIntegerField contractStatusField;
	private final DataSourceTextField clientContractIdField;
	private final DataSourceBooleanField isFinishField;
	private final DataSourceBooleanField isSystemAddField;
	private final DataSourceIntegerField operatorField;
	private final DataSourceTextField attachmentRemarkField;
	private final DataSourceTextField qqField;
	private final DataSourceTextField emailField;
	private final DataSourceTextField landlineField;
	private final DataSourceTextField faxField;

	public DSMcontracticcccsprfiiibaadicrbbior(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Mcontracticcccsprfiiibaadicrbbior");


		contractIdField = new DataSourceIntegerField("contractId", "主订单编码");
		contractIdField.setLength(11);
		contractIdField.setPrimaryKey(true);
		contractIdField.setRequired(true);
		contractIdField.setHidden(true);
		contractIdField.setRootValue("root");
		contractIdField.setForeignKey("DSMcontracticcccsprfiiibaadicrbbior.contractId");


		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);


		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setLength(512);
		contractNameField.setRequired(false);
		contractNameField.setHidden(false);


		customerNameField = new DataSourceTextField("customerName", "客户名称");
		customerNameField.setLength(512);
		customerNameField.setRequired(false);
		customerNameField.setHidden(false);


		startDateField = new DataSourceDateField("startDate", "开始日期");
		startDateField.setRequired(false);
		startDateField.setHidden(true);


		endDateField = new DataSourceDateField("endDate", "结束日期");
		endDateField.setRequired(false);
		endDateField.setHidden(true);


		statusField = new DataSourceIntegerField("status", "结算状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(true);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_39"));


		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(64);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(false);


		contractTypeField = new DataSourceIntegerField("contractType", "合同类别");
		contractTypeField.setLength(11);
		contractTypeField.setRequired(false);
		contractTypeField.setHidden(true);


		projectLevelField = new DataSourceIntegerField("projectLevel", "项目等级");
		projectLevelField.setLength(11);
		projectLevelField.setRequired(false);
		projectLevelField.setHidden(true);


		totalProjectTimeField = new DataSourceIntegerField("totalProjectTime", "项目总工期");
		totalProjectTimeField.setLength(11);
		totalProjectTimeField.setRequired(false);
		totalProjectTimeField.setHidden(true);


		signingMoneySumField = new DataSourceFloatField("signingMoneySum", "签约总金额");
		signingMoneySumField.setLength(16);
		signingMoneySumField.setDecimalPad(2);
		signingMoneySumField.setFormat("##,###,###,###,##0.00");
		signingMoneySumField.setRequired(false);
		signingMoneySumField.setHidden(false);


		designAreasField = new DataSourceFloatField("designAreas", "总设计面积");
		designAreasField.setLength(16);
		designAreasField.setDecimalPad(2);
		designAreasField.setFormat("##,###,###,###,##0.00");
		designAreasField.setRequired(false);
		designAreasField.setHidden(true);


		contractPriceField = new DataSourceFloatField("contractPrice", "合同单价");
		contractPriceField.setLength(16);
		contractPriceField.setDecimalPad(2);
		contractPriceField.setFormat("##,###,###,###,##0.00");
		contractPriceField.setRequired(false);
		contractPriceField.setHidden(false);


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


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(true);


		updateTimeField = new DataSourceDateTimeField("updateTime", "修改时间");
		updateTimeField.setRequired(false);
		updateTimeField.setHidden(true);


		businessTypeField = new DataSourceTextField("businessType", "业务类别");
		businessTypeField.setLength(120);
		businessTypeField.setRequired(false);
		businessTypeField.setHidden(true);


		flowStatusField = new DataSourceIntegerField("flowStatus", "流转状态，默认为0表示可以提交到运营管理修改承接部门1表示可以提交到运营管理运营价格2表示可以提交到运营管理运营价格审核3表示审核完成");
		flowStatusField.setLength(11);
		flowStatusField.setRequired(false);
		flowStatusField.setHidden(true);


		serialNumberField = new DataSourceTextField("serialNumber", "流水号");
		serialNumberField.setLength(6);
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


		projectApprovalTimeField = new DataSourceDateField("projectApprovalTime", "立单时间 提交了立单时间会将保存下来，只是点击保存不会将当前时间保存下来，单每次都会显示当前的时间，提交了下次显示的就是提交时的立单时间");
		projectApprovalTimeField.setRequired(false);
		projectApprovalTimeField.setHidden(true);


		orderNoField = new DataSourceIntegerField("orderNo", "标记补充协议字段；除0之外，其他都表示第n个补充协议");
		orderNoField.setLength(11);
		orderNoField.setRequired(false);
		orderNoField.setHidden(true);


		parentIdField = new DataSourceIntegerField("parentId", "tree结构表示");
		parentIdField.setLength(11);
		parentIdField.setRequired(false);
		parentIdField.setHidden(true);
//		parentIdField.setValueMap(KeyValueManager.getValueMap("project_types"));
		KeyValueManager.loadValueMap("project_types", parentIdField);


		infoCodeField = new DataSourceTextField("infoCode", "信息编号");
		infoCodeField.setLength(32);
		infoCodeField.setRequired(false);
		infoCodeField.setHidden(true);


		contractStatusField = new DataSourceIntegerField("contractStatus", "合同状态  0未启动、1待签署、2已签署、3未签搁置、4解除");
		contractStatusField.setLength(11);
		contractStatusField.setRequired(false);
		contractStatusField.setHidden(true);


		clientContractIdField = new DataSourceTextField("clientContractId", "客户合同编号");
		clientContractIdField.setLength(64);
		clientContractIdField.setRequired(false);
		clientContractIdField.setHidden(true);


		isFinishField = new DataSourceBooleanField("isFinish", "合同是否完成");
		isFinishField.setRequired(false);
		isFinishField.setHidden(true);


		isSystemAddField = new DataSourceBooleanField("isSystemAdd", "是否为erp系统添加  true 为系统添加  false 为数据导入");
		isSystemAddField.setRequired(false);
		isSystemAddField.setHidden(true);


		operatorField = new DataSourceIntegerField("operator", "操作人");
		operatorField.setLength(11);
		operatorField.setRequired(false);
		operatorField.setHidden(true);


		attachmentRemarkField = new DataSourceTextField("attachmentRemark", "合同特殊事项备注");
		attachmentRemarkField.setLength(512);
		attachmentRemarkField.setRequired(false);
		attachmentRemarkField.setHidden(false);
		
		qqField = new DataSourceTextField("qq", "QQ");
		qqField.setLength(64);
		qqField.setRequired(false);
		qqField.setHidden(true);

		emailField = new DataSourceTextField("email", "邮箱");
		emailField.setLength(64);
		emailField.setRequired(false);
		emailField.setHidden(true);
		
		landlineField = new DataSourceTextField("landline", "座机");
		landlineField.setLength(64);
		landlineField.setRequired(false);
		landlineField.setHidden(true);
		
		faxField = new DataSourceTextField("fax", "传真");
		faxField.setLength(64);
		faxField.setRequired(false);
		faxField.setHidden(true);

		setFields(contractIdField, contractCodeField, contractNameField, customerNameField, startDateField, endDateField, statusField, projectCodeField, contractTypeField, projectLevelField, totalProjectTimeField, signingMoneySumField, designAreasField, contractPriceField, projectAddressField, contractFollowerField, remarkField, contractDateField, signingCompanyNameField, createTimeField, updateTimeField, businessTypeField, flowStatusField, serialNumberField, projectTypeField, coveredAreaField, professionalCooperationField, provinceField, cityField, detailAddressField, customerAddressField, serviceSuggestBookField, projectApprovalTimeField, orderNoField, parentIdField, infoCodeField, contractStatusField, clientContractIdField, isFinishField, isSystemAddField, operatorField, qqField, emailField, landlineField, faxField, attachmentRemarkField);
	}


}

