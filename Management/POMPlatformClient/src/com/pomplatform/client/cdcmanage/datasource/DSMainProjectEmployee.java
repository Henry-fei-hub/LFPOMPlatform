package com.pomplatform.client.cdcmanage.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSMainProjectEmployee extends DBDataSource
{


	public static DSMainProjectEmployee instance = null;

	public static DSMainProjectEmployee getInstance() {
		if(instance == null) {
			instance = new DSMainProjectEmployee("DSMainProjectEmployee11");
		}
		return instance;
	}

	private final DataSourceIntegerField mainProjectEmployeeIdField;
	private final DataSourceIntegerField relationField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField mainProjectIdField;

	public DSMainProjectEmployee(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("SearchMainProjectEmployeeData");


		employeeNoField = new DataSourceTextField("employeeNo", "职员编号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(true);
		employeeNoField.setHidden(false);


		mainProjectEmployeeIdField = new DataSourceIntegerField("mainProjectEmployeeId", "");
		mainProjectEmployeeIdField.setLength(11);
		mainProjectEmployeeIdField.setRequired(false);
		mainProjectEmployeeIdField.setHidden(true);
		
		relationField = new DataSourceIntegerField("relation", "角色");
		relationField.setLength(11);
		relationField.setRequired(false);
		relationField.setHidden(false);
		relationField.setValueMap(KeyValueManager.getValueMap("system_dictionary_158"));


		employeeIdField = new DataSourceIntegerField("employeeId", "职员姓名");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(true);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));
		
		mainProjectIdField = new DataSourceIntegerField("mainProjectId", "大项目主键");
		mainProjectIdField.setRequired(false);
		mainProjectIdField.setHidden(true);
		mainProjectIdField.setForeignKey("DSSmainprojectpppor.mainProjectId");

		setFields(relationField, employeeNoField, employeeIdField, plateIdField, mainProjectIdField);
	}


}

