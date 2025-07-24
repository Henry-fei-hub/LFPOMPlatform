package com.pomplatform.client.hr.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSEmployeeContractAttachment extends DBDataSource
{


	public static DSEmployeeContractAttachment instance = null;

	public static DSEmployeeContractAttachment getInstance() {
		if(instance == null) {
			instance = new DSEmployeeContractAttachment("DSEmployeeContractAttachment");
		}
		return instance;
	}

	private final DataSourceTextField employeeContractAttachmentIdField;
	private final DataSourceTextField attachmentNameField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceDateField onboardDateField;
	private final DataSourceIntegerField statusField;
	private final DataSourceTextField attachmentUrlField;
	private final DataSourceIntegerField contractTypeField;
	private final DataSourceIntegerField signTypeField;
	private final DataSourceDateField startDateField;
	private final DataSourceDateField endDateField;
	private final DataSourceIntegerField willEndField;
	private final DataSourceIntegerField attachmentIdField;

	public DSEmployeeContractAttachment(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("EmployeeContractAttachment");

		employeeContractAttachmentIdField = new DataSourceTextField("employeeContractAttachmentId","主键id");
		employeeContractAttachmentIdField.setHidden(true);
		
		attachmentNameField = new DataSourceTextField("attachmentName","附件名称");
		attachmentNameField.setHidden(true);
		
		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setLength(64);
		employeeNoField.setHidden(false);


		employeeIdField = new DataSourceIntegerField("employeeId", "员工id");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(true);
//		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));
		KeyValueManager.loadValueMap("employees",employeeIdField);


		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setLength(64);
		employeeNameField.setHidden(false);


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));


		departmentIdField = new DataSourceIntegerField("departmentId", "所属部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		onboardDateField = new DataSourceDateField("onboardDate", "入职日期");
		onboardDateField.setRequired(false);
		onboardDateField.setHidden(false);


		statusField = new DataSourceIntegerField("status", "职员状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_11"));


		attachmentUrlField = new DataSourceTextField("attachmentUrl", "合同附件");
		attachmentUrlField.setLength(128);
		attachmentUrlField.setRequired(false);
		attachmentUrlField.setHidden(false);

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


		willEndField = new DataSourceIntegerField("willEnd", "合同状态");
		willEndField.setRequired(false);
		willEndField.setHidden(false);
		willEndField.setValueMap(KeyValueManager.getValueMap("system_dictionary_113"));
		
		
		attachmentIdField = new DataSourceIntegerField("attachmentId", "合同文件ID");
		attachmentIdField.setRequired(false);
		attachmentIdField.setHidden(true);


		setFields(employeeContractAttachmentIdField,attachmentNameField,employeeNoField, employeeIdField, employeeNameField, plateIdField, departmentIdField, onboardDateField, statusField, contractTypeField, signTypeField, startDateField, endDateField, attachmentUrlField, willEndField, attachmentIdField);
	}


}

