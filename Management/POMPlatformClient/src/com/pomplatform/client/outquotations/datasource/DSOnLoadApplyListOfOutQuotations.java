package com.pomplatform.client.outquotations.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSOnLoadApplyListOfOutQuotations extends DBDataSource
{


	public static DSOnLoadApplyListOfOutQuotations instance = null;

	public static DSOnLoadApplyListOfOutQuotations getInstance() {
		if(instance == null) {
			instance = new DSOnLoadApplyListOfOutQuotations("DSOnLoadApplyListOfOutQuotations");
		}
		return instance;
	}

	private final DataSourceIntegerField processInstanceIdField;
	private final DataSourceIntegerField businessIdField;
	private final DataSourceTextField businessNameField;
	private final DataSourceIntegerField processIdField;
	private final DataSourceIntegerField processInstanceActivityIdField;
	private final DataSourceIntegerField processStatusField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceDateTimeField completeTimeField;
	private final DataSourceIntegerField outQuotationIdField;
	private final DataSourceTextField quotationNumberField;
	private final DataSourceTextField quotationNameField;
	private final DataSourceFloatField moneySumField;
	private final DataSourceDateTimeField startTimeField;
	private final DataSourceTextField infoCodeField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceIntegerField businessTypeField;
	private final DataSourceIntegerField projectTypeField;
	private final DataSourceTextField quotationFilesField;
	private final DataSourceTextField newCreateQuotationNameField;
	private final DataSourceIntegerField quotationStatusField;
	private final DataSourceIntegerField disableTypeField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceDateTimeField updateTimeField;

	public DSOnLoadApplyListOfOutQuotations(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnLoadApplyListOfOutQuotations");


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
		
		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setLength(11);
		processTypeField.setRequired(false);
		processTypeField.setHidden(true);


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


		outQuotationIdField = new DataSourceIntegerField("outQuotationId", "报价单标题");
		outQuotationIdField.setLength(11);
		outQuotationIdField.setPrimaryKey(true);
		outQuotationIdField.setRequired(true);
		outQuotationIdField.setHidden(true);
		outQuotationIdField.setValueMap(KeyValueManager.getValueMap("out_design_considerations"));
		

		newCreateQuotationNameField = new DataSourceTextField("newCreateQuotationName", "报价单标题");
		newCreateQuotationNameField.setLength(512);
		newCreateQuotationNameField.setRequired(false);
		newCreateQuotationNameField.setHidden(false);


		quotationNumberField = new DataSourceTextField("quotationNumber", "报价单编号");
		quotationNumberField.setLength(32);
		quotationNumberField.setRequired(false);
		quotationNumberField.setHidden(false);


		quotationNameField = new DataSourceTextField("quotationName", "报价单名称");
		quotationNameField.setLength(512);
		quotationNameField.setRequired(false);
		quotationNameField.setHidden(false);


		moneySumField = new DataSourceFloatField("moneySum", "报价单总金额");
		moneySumField.setLength(16);
		moneySumField.setDecimalPad(2);
		moneySumField.setFormat("##,###,###,###,##0.00");
		moneySumField.setRequired(false);
		moneySumField.setHidden(true);


		startTimeField = new DataSourceDateTimeField("startTime", "起草时间");
		startTimeField.setRequired(true);
		startTimeField.setHidden(false);


		infoCodeField = new DataSourceTextField("infoCode", "信息编号");
		infoCodeField.setLength(32);
		infoCodeField.setRequired(false);
		infoCodeField.setHidden(false);


		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(64);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(false);

		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setLength(255);
		projectNameField.setCanEdit(false);
		KeyValueManager.loadValueMap("contracts", projectNameField);


		businessTypeField = new DataSourceIntegerField("businessType", "业务类型");
		businessTypeField.setLength(11);
		businessTypeField.setRequired(false);
		businessTypeField.setHidden(true);


		projectTypeField = new DataSourceIntegerField("projectType", "项目类型");
		projectTypeField.setLength(11);
		projectTypeField.setRequired(false);
		projectTypeField.setHidden(true);


		quotationFilesField = new DataSourceTextField("quotationFiles", "报价单(原附件)");
		quotationFilesField.setLength(512);
		quotationFilesField.setRequired(false);
		quotationFilesField.setHidden(true);


		quotationStatusField = new DataSourceIntegerField("quotationStatus", "报价单的状态");
		quotationStatusField.setLength(11);
		quotationStatusField.setRequired(false);
		quotationStatusField.setHidden(false);
		java.util.Map<String,String> quotationStatusValues = new java.util.HashMap<String,String>();
		quotationStatusValues.put("1", "成功");
		quotationStatusValues.put("2", "历史版本");
		quotationStatusValues.put("3", "报价中");
		quotationStatusField.setValueMap(quotationStatusValues);


		disableTypeField = new DataSourceIntegerField("disableType", "可操作状态 0可操作,1禁止操作");
		disableTypeField.setLength(11);
		disableTypeField.setRequired(false);
		disableTypeField.setHidden(true);


		employeeIdField = new DataSourceIntegerField("employeeId", "创建人");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		contractIdField = new DataSourceIntegerField("contractId", "contract_id");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(true);


		updateTimeField = new DataSourceDateTimeField("updateTime", "修改时间");
		updateTimeField.setRequired(false);
		updateTimeField.setHidden(true);
		



		setFields(processInstanceIdField,processTypeField, outQuotationIdField,newCreateQuotationNameField, businessIdField, businessNameField, processIdField, processInstanceActivityIdField, processStatusField, completeTimeField, quotationNumberField, quotationNameField, moneySumField,  infoCodeField, projectCodeField,projectNameField, businessTypeField, projectTypeField, quotationFilesField, quotationStatusField, disableTypeField, employeeIdField, contractIdField, updateTimeField,createTimeField, startTimeField);
	}


}

