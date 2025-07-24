package com.pomplatform.client.mcapitalemployeeecceedor.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSMcapitalemployeeecceedor extends DBDataSource
{


	public static DSMcapitalemployeeecceedor instance = null;

	public static DSMcapitalemployeeecceedor getInstance() {
		if(instance == null) {
			instance = new DSMcapitalemployeeecceedor("DSMcapitalemployeeecceedor");
		}
		return instance;
	}

	private final DataSourceIntegerField capitalEmployeeIdField;
	private final DataSourceIntegerField capitalIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceTextField employeeNameEnField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceFloatField moneyField;
	private final DataSourceIntegerField operatorIdField;
	private final DataSourceDateTimeField creatTimeField;

	public DSMcapitalemployeeecceedor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Mcapitalemployeeecceedor");


		capitalEmployeeIdField = new DataSourceIntegerField("capitalEmployeeId", "主键");
		capitalEmployeeIdField.setLength(11);
		capitalEmployeeIdField.setPrimaryKey(true);
		capitalEmployeeIdField.setRequired(true);
		capitalEmployeeIdField.setHidden(true);


		capitalIdField = new DataSourceIntegerField("capitalId", "回款编码");
		capitalIdField.setLength(11);
		capitalIdField.setRequired(false);
		capitalIdField.setHidden(true);
		capitalIdField.setCanEdit(false);


		employeeIdField = new DataSourceIntegerField("employeeId", "员工主键");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(true);
		employeeIdField.setCanEdit(false);


		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(true);
		employeeNameField.setHidden(false);
		employeeNameField.setCanEdit(false);


		employeeNameEnField = new DataSourceTextField("employeeNameEn", "英文名");
		employeeNameEnField.setLength(64);
		employeeNameEnField.setRequired(false);
		employeeNameEnField.setHidden(true);
		employeeNameEnField.setCanEdit(false);


		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(true);
		employeeNoField.setHidden(false);
		employeeNoField.setCanEdit(false);


		departmentIdField = new DataSourceIntegerField("departmentId", "部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
        departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));
        departmentIdField.setCanEdit(false);
        

		moneyField = new DataSourceFloatField("money", "金额");
		moneyField.setLength(16);
		moneyField.setDecimalPad(2);
		moneyField.setFormat("##,###,###,###,##0.00");
		moneyField.setRequired(false);
		moneyField.setHidden(false);


		operatorIdField = new DataSourceIntegerField("operatorId", "操作人");
		operatorIdField.setLength(11);
		operatorIdField.setRequired(false);
		operatorIdField.setHidden(true);


		creatTimeField = new DataSourceDateTimeField("creatTime", "创建时间");
		creatTimeField.setRequired(false);
		creatTimeField.setHidden(true);


		setFields(capitalEmployeeIdField, capitalIdField, employeeIdField, employeeNameField, employeeNameEnField, employeeNoField, departmentIdField, moneyField, operatorIdField, creatTimeField);
	}


}

