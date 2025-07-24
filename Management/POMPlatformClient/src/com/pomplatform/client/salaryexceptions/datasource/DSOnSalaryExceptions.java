package com.pomplatform.client.salaryexceptions.datasource;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.FieldType;

public class DSOnSalaryExceptions extends DBDataSource
{


	public static DSOnSalaryExceptions instance = null;

	public static DSOnSalaryExceptions getInstance() {
		if(instance == null) {
			instance = new DSOnSalaryExceptions("DSOnSalaryExceptions");
		}
		return instance;
	}

	private final DataSourceIntegerField personnelBusinessIdField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceTextField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField departmentIdField;
	private final DataSourceTextField companyIdField;
	private final DataSourceTextField reasonField;
	private final DataSourceTextField remarkField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceField detailSalaryException;

	public DSOnSalaryExceptions(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnSalaryExceptions");


		personnelBusinessIdField = new DataSourceIntegerField("personnelBusinessId", "人事业务编码");
		personnelBusinessIdField.setLength(11);
		personnelBusinessIdField.setPrimaryKey(true);
		personnelBusinessIdField.setRequired(true);
		personnelBusinessIdField.setHidden(true);
		personnelBusinessIdField.setCanEdit(false);
		

		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setLength(11);
		processTypeField.setRequired(true);
		processTypeField.setHidden(true);


		employeeIdField = new DataSourceTextField("employeeId", "申请人");
		employeeIdField.setLength(32);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdField.setCanEdit(false);
		
		employeeNoField = new DataSourceTextField("employeeNo", "工号");
		employeeNoField.setLength(32);
		employeeNoField.setRequired(false);
		employeeNoField.setHidden(false);
		employeeNoField.setCanEdit(false);

		departmentIdField = new DataSourceTextField("departmentId", "部门");
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));
		departmentIdField.setLength(32);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setCanEdit(false);

		companyIdField = new DataSourceTextField("companyId", "归属公司");
		companyIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		companyIdField.setLength(50);
		companyIdField.setRequired(false);
		companyIdField.setHidden(false);


		reasonField = new DataSourceTextField("reason", "申请缘由");
		reasonField.setLength(1024);
		reasonField.setRequired(false);
		reasonField.setHidden(true);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(true);


		createTimeField = new DataSourceDateTimeField("createTime", "起草时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);

		detailSalaryException = new DataSourceField("detailSalaryException", FieldType.ANY);
		detailSalaryException.setChildrenProperty(true);
		detailSalaryException.setChildTagName("SalaryException");
		detailSalaryException.setRequired(false);
		detailSalaryException.setHidden(true);

		setFields(personnelBusinessIdField,processTypeField,employeeIdField, employeeNoField, departmentIdField, companyIdField, reasonField, remarkField, createTimeField, detailSalaryException);
	}


}

