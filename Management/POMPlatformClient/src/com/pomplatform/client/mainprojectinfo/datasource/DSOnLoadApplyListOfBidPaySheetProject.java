package com.pomplatform.client.mainprojectinfo.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSOnLoadApplyListOfBidPaySheetProject extends DBDataSource
{


	public static DSOnLoadApplyListOfBidPaySheetProject instance = null;

	public static DSOnLoadApplyListOfBidPaySheetProject getInstance() {
		if(instance == null) {
			instance = new DSOnLoadApplyListOfBidPaySheetProject("DSOnLoadApplyListOfBidPaySheetProject");
		}
		return instance;
	}

	private final DataSourceIntegerField processInstanceIdField;
	private final DataSourceIntegerField businessIdField;
	private final DataSourceTextField businessNameField;
	private final DataSourceIntegerField processIdField;
	private final DataSourceIntegerField processInstanceActivityIdField;
	private final DataSourceIntegerField processStatusField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceDateTimeField completeTimeField;
	private final DataSourceIntegerField personnelBusinessIdField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceDateTimeField startDateField;
	private final DataSourceIntegerField startDateDetailField;
	private final DataSourceIntegerField endDateDetailField;
	private final DataSourceTextField reasonField;
	private final DataSourceTextField remarkField;
	private final DataSourceTextField addressField;
	private final DataSourceTextField planField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceTextField projectNameField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceBooleanField provideAccommodationField;
	private final DataSourceFloatField livingExpensesField;
	private final DataSourceFloatField housingFinanceField;
	private final DataSourceIntegerField dutyIdField;
	private final DataSourceIntegerField linkIdField;
	private final DataSourceFloatField severanceField;
	private final DataSourceIntegerField attachmentIdField;
	private final DataSourceLinkField attachmentNameField;

	public DSOnLoadApplyListOfBidPaySheetProject(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnLoadApplyListOfBidPaySheetProject");


		processInstanceIdField = new DataSourceIntegerField("processInstanceId", "主键编码");
		processInstanceIdField.setLength(11);
		processInstanceIdField.setPrimaryKey(true);
		processInstanceIdField.setRequired(true);
		processInstanceIdField.setHidden(true);


		businessIdField = new DataSourceIntegerField("businessId", "业务编码");
		businessIdField.setLength(11);
		businessIdField.setRequired(false);
		businessIdField.setHidden(true);


		businessNameField = new DataSourceTextField("businessName", "业务名称");
		businessNameField.setLength(256);
		businessNameField.setRequired(false);
		businessNameField.setHidden(true);


		processIdField = new DataSourceIntegerField("processId", "流程编码");
		processIdField.setLength(11);
		processIdField.setRequired(false);
		processIdField.setHidden(true);


		processInstanceActivityIdField = new DataSourceIntegerField("processInstanceActivityId", "活动实列编码");
		processInstanceActivityIdField.setLength(11);
		processInstanceActivityIdField.setRequired(false);
		processInstanceActivityIdField.setHidden(true);


		processStatusField = new DataSourceIntegerField("processStatus", "流程状态");
		processStatusField.setLength(11);
		processStatusField.setRequired(false);
		processStatusField.setHidden(false);
		processStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_120"));


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);


		completeTimeField = new DataSourceDateTimeField("completeTime", "完成时间");
		completeTimeField.setRequired(false);
		completeTimeField.setHidden(true);


		personnelBusinessIdField = new DataSourceIntegerField("personnelBusinessId", "人事业务编码");
		personnelBusinessIdField.setLength(11);
		personnelBusinessIdField.setPrimaryKey(true);
		personnelBusinessIdField.setRequired(true);
		personnelBusinessIdField.setHidden(true);


		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setLength(11);
		processTypeField.setRequired(false);
		processTypeField.setHidden(true);


		employeeIdField = new DataSourceIntegerField("employeeId", "申请人");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		employeeNoField = new DataSourceTextField("employeeNo", "合同编号");
		employeeNoField.setLength(32);
		employeeNoField.setRequired(false);
		employeeNoField.setHidden(true);


		startDateField = new DataSourceDateTimeField("startDate", "投标日期");
		startDateField.setRequired(false);
		startDateField.setHidden(false);


		startDateDetailField = new DataSourceIntegerField("startDateDetail", "投标类型");
		startDateDetailField.setLength(11);
		startDateDetailField.setRequired(false);
		startDateDetailField.setHidden(false);
		startDateDetailField.setValueMap(KeyValueManager.getValueMap("system_dictionary_129"));


		endDateDetailField = new DataSourceIntegerField("endDateDetail", "投标单位总数");
		endDateDetailField.setLength(11);
		endDateDetailField.setRequired(false);
		endDateDetailField.setHidden(false);


		reasonField = new DataSourceTextField("reason", "落标原因");
		reasonField.setLength(1024);
		reasonField.setRequired(false);
		reasonField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		addressField = new DataSourceTextField("address", "我方排名");
		addressField.setLength(255);
		addressField.setRequired(false);
		addressField.setHidden(false);


		planField = new DataSourceTextField("plan", "合同名称");
		planField.setLength(1024);
		planField.setRequired(false);
		planField.setHidden(false);


		projectIdField = new DataSourceIntegerField("projectId", "项目主键");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(true);


		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setLength(255);
		projectNameField.setRequired(false);
		projectNameField.setHidden(true);


		projectCodeField = new DataSourceTextField("projectCode", "订单编号");
		projectCodeField.setLength(255);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(false);





		provideAccommodationField = new DataSourceBooleanField("provideAccommodation", "是否收到落标补偿");
		provideAccommodationField.setRequired(false);
		provideAccommodationField.setHidden(true);


		livingExpensesField = new DataSourceFloatField("livingExpenses", "投标金额");
		livingExpensesField.setLength(18);
		livingExpensesField.setDecimalPad(2);
		livingExpensesField.setFormat("#,###,###,###,###,##0.00");
		livingExpensesField.setRequired(false);
		livingExpensesField.setHidden(false);


		housingFinanceField = new DataSourceFloatField("housingFinance", "落标补偿金");
		housingFinanceField.setLength(18);
		housingFinanceField.setDecimalPad(2);
		housingFinanceField.setFormat("#,###,###,###,###,##0.00");
		housingFinanceField.setRequired(false);
		housingFinanceField.setHidden(true);


		dutyIdField = new DataSourceIntegerField("dutyId", "mainProjectId");
		dutyIdField.setLength(11);
		dutyIdField.setRequired(false);
		dutyIdField.setHidden(true);


		linkIdField = new DataSourceIntegerField("linkId", "contractId");
		linkIdField.setLength(11);
		linkIdField.setRequired(false);
		linkIdField.setHidden(true);


		severanceField = new DataSourceFloatField("severance", "甲方补偿金额");
		severanceField.setLength(18);
		severanceField.setDecimalPad(2);
		severanceField.setFormat("#,###,###,###,###,##0.00");
		severanceField.setRequired(false);
		severanceField.setHidden(false);


		attachmentIdField = new DataSourceIntegerField("attachmentId", "附件编码");
		attachmentIdField.setLength(11);
		attachmentIdField.setRequired(false);
		attachmentIdField.setHidden(true);


		attachmentNameField = new DataSourceLinkField("attachmentName", "附件名称");
		attachmentNameField.setLength(255);
		attachmentNameField.setRequired(false);
		attachmentNameField.setHidden(false);
		setFields(processInstanceIdField, personnelBusinessIdField, businessIdField, businessNameField, processIdField, processInstanceActivityIdField, processStatusField, createTimeField, completeTimeField, processTypeField, employeeIdField, employeeNoField,planField ,projectIdField,linkIdField,dutyIdField,projectCodeField,projectNameField,livingExpensesField,startDateField, startDateDetailField ,endDateDetailField,addressField,housingFinanceField,provideAccommodationField, severanceField, reasonField ,remarkField,    attachmentIdField, attachmentNameField);
	}


}

