package com.pomplatform.client.workflow.personnelbusiness.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceLinkField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSBusinessTripApply extends DBDataSource
{


	public static DSBusinessTripApply instance = null;

	public static DSBusinessTripApply getInstance() {
		if(instance == null) {
			instance = new DSBusinessTripApply("DSBusinessTripApply");
		}
		return instance;
	}

	private final DataSourceIntegerField personnelBusinessIdField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField typeField;
	private final DataSourceDateField startDateField;
	private final DataSourceIntegerField startDateDetailField;
	private final DataSourceDateField endDateField;
	private final DataSourceIntegerField endDateDetailField;
	private final DataSourceFloatField daysField;
	private final DataSourceTextField reasonField;
	private final DataSourceTextField remarkField;
	private final DataSourceTextField addressField;
	private final DataSourceTextField planField;
	private final DataSourceTextField transportationField;
	private final DataSourceFloatField feeField;
	private final DataSourceTextField unitField;
	private final DataSourceTextField contactPersonField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceIntegerField deleteFlagField;
	private final DataSourceTextField projectNameField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceIntegerField drafterField;
	private final DataSourceLinkField attachmentField;
	private final DataSourceIntegerField attachmentIdField;
	private final DataSourceTextField attachmentNameField;

	public DSBusinessTripApply(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("BusinessTripApply");


		personnelBusinessIdField = new DataSourceIntegerField("personnelBusinessId", "人事业务编码");
		personnelBusinessIdField.setLength(11);
		personnelBusinessIdField.setPrimaryKey(true);
		personnelBusinessIdField.setRequired(true);
		personnelBusinessIdField.setHidden(true);


		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setLength(11);
		processTypeField.setRequired(false);
		processTypeField.setHidden(false);
		processTypeField.setValueMap(KeyValueManager.getValueMap("system_process_types"));


		employeeIdField = new DataSourceIntegerField("employeeId", "申请人");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		employeeNoField = new DataSourceTextField("employeeNo", "工号");
		employeeNoField.setLength(32);
		employeeNoField.setRequired(false);
		employeeNoField.setHidden(false);


		departmentIdField = new DataSourceIntegerField("departmentId", "部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));


		typeField = new DataSourceIntegerField("type", "假期类型");
		typeField.setLength(11);
		typeField.setRequired(false);
		typeField.setHidden(true);


		startDateField = new DataSourceDateField("startDate", "开始日期");
		startDateField.setRequired(false);
		startDateField.setHidden(false);


		startDateDetailField = new DataSourceIntegerField("startDateDetail", "开始时段");
		startDateDetailField.setLength(11);
		startDateDetailField.setRequired(false);
		startDateDetailField.setHidden(false);
		startDateDetailField.setValueMap(KeyValueManager.getValueMap("system_dictionary_73"));


		endDateField = new DataSourceDateField("endDate", "结束日期");
		endDateField.setRequired(false);
		endDateField.setHidden(false);


		endDateDetailField = new DataSourceIntegerField("endDateDetail", "结束时段");
		endDateDetailField.setLength(11);
		endDateDetailField.setRequired(false);
		endDateDetailField.setHidden(false);
		endDateDetailField.setValueMap(KeyValueManager.getValueMap("system_dictionary_73"));


		daysField = new DataSourceFloatField("days", "天数");
		daysField.setLength(6);
		daysField.setDecimalPad(2);
		daysField.setFormat("#,##0.00");
		daysField.setRequired(false);
		daysField.setHidden(false);


		reasonField = new DataSourceTextField("reason", "申请缘由");
		reasonField.setLength(1024);
		reasonField.setRequired(false);
		reasonField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		addressField = new DataSourceTextField("address", "出差地址");
		addressField.setLength(255);
		addressField.setRequired(false);
		addressField.setHidden(false);


		planField = new DataSourceTextField("plan", "行程安排");
		planField.setLength(1024);
		planField.setRequired(false);
		planField.setHidden(true);


		transportationField = new DataSourceTextField("transportation", "交通工具");
		transportationField.setLength(255);
		transportationField.setRequired(false);
		transportationField.setHidden(true);


		feeField = new DataSourceFloatField("fee", "预计费用");
		feeField.setLength(18);
		feeField.setDecimalPad(2);
		feeField.setFormat("#,###,###,###,###,##0.00");
		feeField.setRequired(false);
		feeField.setHidden(true);


		unitField = new DataSourceTextField("unit", "外访单位");
		unitField.setLength(255);
		unitField.setRequired(false);
		unitField.setHidden(true);


		contactPersonField = new DataSourceTextField("contactPerson", "联系人");
		contactPersonField.setLength(255);
		contactPersonField.setRequired(false);
		contactPersonField.setHidden(true);


		createTimeField = new DataSourceDateTimeField("createTime", "起草时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);


		deleteFlagField = new DataSourceIntegerField("deleteFlag", "删除状态  0未删除    1已删除");
		deleteFlagField.setLength(11);
		deleteFlagField.setRequired(false);
		deleteFlagField.setHidden(true);
		
		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setLength(255);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);
		
		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(255);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(false);
		
		drafterField = new DataSourceIntegerField("drafter", "起草人");
		drafterField.setLength(11);
		drafterField.setRequired(false);
		drafterField.setHidden(true);

		attachmentField = new DataSourceLinkField("attachment", "附件");
		attachmentField.setLength(255);
		attachmentField.setRequired(false);
		attachmentField.setHidden(false);
		
		
		attachmentIdField = new DataSourceIntegerField("attachmentId", "附件ID");
		attachmentIdField.setLength(11);
		attachmentIdField.setRequired(false);
		attachmentIdField.setHidden(true);


		attachmentNameField = new DataSourceTextField("attachmentName", "附件名称");
		attachmentNameField.setLength(512);
		attachmentNameField.setRequired(false);
		attachmentNameField.setHidden(false);

		setFields(personnelBusinessIdField, processTypeField, employeeIdField, employeeNoField, departmentIdField, companyIdField, typeField, startDateField, startDateDetailField, endDateField, endDateDetailField, daysField, addressField, transportationField, feeField, reasonField, remarkField, planField, unitField, contactPersonField, projectNameField, projectCodeField, createTimeField, deleteFlagField, drafterField, attachmentNameField, attachmentIdField, attachmentField);
	}


}

