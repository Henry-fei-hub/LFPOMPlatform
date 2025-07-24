package com.pomplatform.client.workflow.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSEmployeeContract extends DBDataSource
{


	public static DSEmployeeContract instance = null;

	public static DSEmployeeContract getInstance() {
		if(instance == null) {
			instance = new DSEmployeeContract("DSEmployeeContract");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeContractAttachmentIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField attachmentNameField;
	private final DataSourceTextField attachmentUrlField;
	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceDateTimeField operateTimeField;
	private final DataSourceIntegerField contractTypeField;
	private final DataSourceIntegerField signTypeField;
	private final DataSourceDateField startDateField;
	private final DataSourceDateField endDateField;
	private final DataSourceIntegerField willEndField;
	private final DataSourceIntegerField attachmentIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceDateTimeField onboardDateField;
	private final DataSourceIntegerField employeeStatusField;
	private final DataSourceIntegerField processIdField;
	private final DataSourceIntegerField processStatusField;

	public DSEmployeeContract(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("EmployeeContract");


		employeeContractAttachmentIdField = new DataSourceIntegerField("employeeContractAttachmentId", "主键编码");
		employeeContractAttachmentIdField.setLength(11);
		employeeContractAttachmentIdField.setPrimaryKey(true);
		employeeContractAttachmentIdField.setRequired(true);
		employeeContractAttachmentIdField.setHidden(true);


		employeeIdField = new DataSourceIntegerField("employeeId", "员工姓名");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		attachmentNameField = new DataSourceTextField("attachmentName", "附件名称");
		attachmentNameField.setLength(32);
		attachmentNameField.setRequired(false);
		attachmentNameField.setHidden(true);


		attachmentUrlField = new DataSourceTextField("attachmentUrl", "附件");
		attachmentUrlField.setLength(128);
		attachmentUrlField.setRequired(false);
		attachmentUrlField.setHidden(false);
		attachmentUrlField.setType(FieldType.LINK);


		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "操作人");
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setRequired(false);
		operateEmployeeIdField.setHidden(true);


		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(true);


		contractTypeField = new DataSourceIntegerField("contractType", "合同类型");
		contractTypeField.setLength(11);
		contractTypeField.setRequired(false);
		contractTypeField.setHidden(false);
		contractTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_111"));


		signTypeField = new DataSourceIntegerField("signType", "签订类型");
		signTypeField.setLength(11);
		signTypeField.setRequired(false);
		signTypeField.setHidden(false);
		signTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_112"));


		startDateField = new DataSourceDateField("startDate", "开始日期");
		startDateField.setRequired(false);
		startDateField.setHidden(false);


		endDateField = new DataSourceDateField("endDate", "结束日期");
		endDateField.setRequired(false);
		endDateField.setHidden(false);


		willEndField = new DataSourceIntegerField("willEnd", "一个月到期(0未到期；1即将到期；2已过期)");
		willEndField.setLength(11);
		willEndField.setRequired(false);
		willEndField.setHidden(true);


		attachmentIdField = new DataSourceIntegerField("attachmentId", "附件编码");
		attachmentIdField.setLength(11);
		attachmentIdField.setRequired(false);
		attachmentIdField.setHidden(true);


		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setLength(32);
		employeeNoField.setRequired(false);
		employeeNoField.setHidden(false);


		departmentIdField = new DataSourceIntegerField("departmentId", "归属部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		onboardDateField = new DataSourceDateTimeField("onboardDate", "入职日期");
		onboardDateField.setRequired(false);
		onboardDateField.setHidden(false);


		employeeStatusField = new DataSourceIntegerField("employeeStatus", "职员状态");
		employeeStatusField.setLength(11);
		employeeStatusField.setRequired(false);
		employeeStatusField.setHidden(true);

		processIdField = new DataSourceIntegerField("processId", "流程编码");
		processIdField.setLength(11);
		processIdField.setRequired(false);
		processIdField.setHidden(true);

		processStatusField = new DataSourceIntegerField("processStatus", "流程状态");
		processStatusField.setHidden(true);

		setFields(employeeContractAttachmentIdField, employeeIdField, departmentIdField, plateIdField, operateEmployeeIdField, operateTimeField, contractTypeField, signTypeField, startDateField, endDateField, willEndField, attachmentIdField, employeeNoField,onboardDateField, employeeStatusField , attachmentNameField, attachmentUrlField,processIdField,processStatusField);
	}


}

