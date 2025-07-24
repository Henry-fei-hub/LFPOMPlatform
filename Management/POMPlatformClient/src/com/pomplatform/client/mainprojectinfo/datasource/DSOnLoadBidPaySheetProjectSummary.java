package com.pomplatform.client.mainprojectinfo.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSOnLoadBidPaySheetProjectSummary extends DBDataSource
{


	public static DSOnLoadBidPaySheetProjectSummary instance = null;

	public static DSOnLoadBidPaySheetProjectSummary getInstance() {
		if(instance == null) {
			instance = new DSOnLoadBidPaySheetProjectSummary("DSOnLoadBidPaySheetProjectSummary");
		}
		return instance;
	}

	private final DataSourceTextField projectNameField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField infoCodeField;
	private final DataSourceTextField transportationField;
	private final DataSourceTextField projectSalesTeamField;
	private final DataSourceFloatField livingExpensesField;
	private final DataSourceIntegerField startDateDetailField;
	private final DataSourceIntegerField endDateDetailField;
	private final DataSourceTextField addressField;
	private final DataSourceTextField reasonField;
	private final DataSourceTextField remarkField;
	private final DataSourceFloatField severanceField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceTextField codeField;
	private final DataSourceTextField nameField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceFloatField totalAmountField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceDateTimeField completeTimeField;
	private final DataSourceIntegerField processInstanceIdField;
	private final DataSourceIntegerField processStatusField;
	private final DataSourceIntegerField personnelBusinessIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceDateTimeField startDateField;
	private final DataSourceIntegerField dutyIdField;
	private final DataSourceIntegerField linkIdField;
	private final DataSourceIntegerField attachmentIdField;
	private final DataSourceTextField attachmentNameField;

	public DSOnLoadBidPaySheetProjectSummary(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnLoadBidPaySheetProjectSummary");


		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setLength(255);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);


		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(255);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(false);


		infoCodeField = new DataSourceTextField("infoCode", "信息编号");
		infoCodeField.setLength(32);
		infoCodeField.setRequired(false);
		infoCodeField.setHidden(false);


		transportationField = new DataSourceTextField("transportation", "客户名称");
		transportationField.setLength(255);
		transportationField.setRequired(false);
		transportationField.setHidden(false);


		projectSalesTeamField = new DataSourceTextField("projectSalesTeam", "项目营销团队");
		projectSalesTeamField.setLength(32);
		projectSalesTeamField.setRequired(false);
		projectSalesTeamField.setHidden(false);


		livingExpensesField = new DataSourceFloatField("livingExpenses", "投标金额");
		livingExpensesField.setLength(18);
		livingExpensesField.setDecimalPad(2);
		livingExpensesField.setFormat("#,###,###,###,###,##0.00");
		livingExpensesField.setRequired(false);
		livingExpensesField.setHidden(false);


		startDateDetailField = new DataSourceIntegerField("startDateDetail", "投标类型");
		startDateDetailField.setLength(11);
		startDateDetailField.setRequired(false);
		startDateDetailField.setHidden(false);
		startDateDetailField.setValueMap(KeyValueManager.getValueMap("system_dictionary_129"));

		endDateDetailField = new DataSourceIntegerField("endDateDetail", "投标单位总数");
		endDateDetailField.setLength(11);
		endDateDetailField.setRequired(false);
		endDateDetailField.setHidden(false);


		addressField = new DataSourceTextField("address", "我方排名");
		addressField.setLength(255);
		addressField.setRequired(false);
		addressField.setHidden(false);


		reasonField = new DataSourceTextField("reason", "落标原因");
		reasonField.setLength(1024);
		reasonField.setRequired(false);
		reasonField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		severanceField = new DataSourceFloatField("severance", "甲方补偿金额");
		severanceField.setLength(18);
		severanceField.setDecimalPad(2);
		severanceField.setFormat("#,###,###,###,###,##0.00");
		severanceField.setRequired(false);
		severanceField.setHidden(false);


		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(true);


		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setLength(512);
		contractNameField.setRequired(false);
		contractNameField.setHidden(true);


		codeField = new DataSourceTextField("code", "订单编号");
		codeField.setLength(64);
		codeField.setRequired(true);
		codeField.setHidden(false);


		nameField = new DataSourceTextField("name", "订单名称");
		nameField.setLength(512);
		nameField.setRequired(true);
		nameField.setHidden(false);


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));


		totalAmountField = new DataSourceFloatField("totalAmount", "落标补偿金");
		totalAmountField.setLength(18);
		totalAmountField.setDecimalPad(2);
		totalAmountField.setFormat("#,###,###,###,###,##0.00");
		totalAmountField.setRequired(false);
		totalAmountField.setHidden(false);


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(true);


		completeTimeField = new DataSourceDateTimeField("completeTime", "完成时间");
		completeTimeField.setRequired(false);
		completeTimeField.setHidden(true);


		processInstanceIdField = new DataSourceIntegerField("processInstanceId", "主键编码");
		processInstanceIdField.setLength(11);
		processInstanceIdField.setPrimaryKey(true);
		processInstanceIdField.setRequired(true);
		processInstanceIdField.setHidden(true);


		processStatusField = new DataSourceIntegerField("processStatus", "流程状态 0 发起中  1");
		processStatusField.setLength(11);
		processStatusField.setRequired(false);
		processStatusField.setHidden(true);


		personnelBusinessIdField = new DataSourceIntegerField("personnelBusinessId", "人事业务编码");
		personnelBusinessIdField.setLength(11);
		personnelBusinessIdField.setPrimaryKey(true);
		personnelBusinessIdField.setRequired(true);
		personnelBusinessIdField.setHidden(true);


		employeeIdField = new DataSourceIntegerField("employeeId", "申请人");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(true);


		startDateField = new DataSourceDateTimeField("startDate", "投标日期");
		startDateField.setRequired(false);
		startDateField.setHidden(true);


		dutyIdField = new DataSourceIntegerField("dutyId", "职务");
		dutyIdField.setLength(11);
		dutyIdField.setRequired(false);
		dutyIdField.setHidden(true);


		linkIdField = new DataSourceIntegerField("linkId", "关联表编码");
		linkIdField.setLength(11);
		linkIdField.setRequired(false);
		linkIdField.setHidden(true);


		attachmentIdField = new DataSourceIntegerField("attachmentId", "附件编码");
		attachmentIdField.setLength(11);
		attachmentIdField.setRequired(false);
		attachmentIdField.setHidden(true);


		attachmentNameField = new DataSourceTextField("attachmentName", "附件名称");
		attachmentNameField.setLength(255);
		attachmentNameField.setRequired(false);
		attachmentNameField.setHidden(true);


		setFields(processInstanceIdField, personnelBusinessIdField, projectNameField, projectCodeField, infoCodeField, transportationField, projectSalesTeamField, livingExpensesField, startDateDetailField, endDateDetailField, addressField, reasonField, remarkField, severanceField, contractCodeField, contractNameField, codeField, nameField, plateIdField, totalAmountField, createTimeField, completeTimeField, processStatusField, employeeIdField, startDateField, dutyIdField, linkIdField, attachmentIdField, attachmentNameField);
	}


}

