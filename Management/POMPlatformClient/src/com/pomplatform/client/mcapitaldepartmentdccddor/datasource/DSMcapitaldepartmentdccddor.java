package com.pomplatform.client.mcapitaldepartmentdccddor.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSMcapitaldepartmentdccddor extends DBDataSource
{


	public static DSMcapitaldepartmentdccddor instance = null;

	public static DSMcapitaldepartmentdccddor getInstance() {
		if(instance == null) {
			instance = new DSMcapitaldepartmentdccddor("DSMcapitaldepartmentdccddor");
		}
		return instance;
	}

	private final DataSourceIntegerField capitalDepartmentIdField;
	private final DataSourceIntegerField capitalIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceFloatField moneyField;
	private final DataSourceIntegerField operatorIdField;
	private final DataSourceDateTimeField creatTimeField;
	private final DataSourceTextField departmentNameField;

	public DSMcapitaldepartmentdccddor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Mcapitaldepartmentdccddor");


		capitalDepartmentIdField = new DataSourceIntegerField("capitalDepartmentId", "主键");
		capitalDepartmentIdField.setLength(11);
		capitalDepartmentIdField.setPrimaryKey(true);
		capitalDepartmentIdField.setRequired(true);
		capitalDepartmentIdField.setHidden(true);


		capitalIdField = new DataSourceIntegerField("capitalId", "回款编码");
		capitalIdField.setLength(11);
		capitalIdField.setRequired(false);
		capitalIdField.setHidden(true);


		departmentIdField = new DataSourceIntegerField("departmentId", "部门编码");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(true);


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


		departmentNameField = new DataSourceTextField("departmentName", "部门名称");
		departmentNameField.setLength(64);
		departmentNameField.setRequired(true);
		departmentNameField.setHidden(false);
		departmentNameField.setCanEdit(false);


		setFields(capitalDepartmentIdField, capitalIdField, departmentIdField, departmentNameField, moneyField, operatorIdField, creatTimeField);
	}


}

