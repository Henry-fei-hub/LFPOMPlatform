package com.pomplatform.client.cdcmanage.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSMainProjectEmployeeShow extends DBDataSource
{


	public static DSMainProjectEmployeeShow instance = null;

	public static DSMainProjectEmployeeShow getInstance() {
		if(instance == null) {
			instance = new DSMainProjectEmployeeShow("DSMainProjectEmployee11");
		}
		return instance;
	}

	private final DataSourceIntegerField contractIdField;
	private final DataSourceIntegerField mainProjectIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceIntegerField relationField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField mainProjectEmployeeIdField;

	public DSMainProjectEmployeeShow(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("SearchMainProjectEmployeeData");
		
		
		contractIdField = new DataSourceIntegerField("contractId", "");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(true);


		mainProjectEmployeeIdField = new DataSourceIntegerField("mainProjectEmployeeId", "");
		mainProjectEmployeeIdField.setLength(11);
		mainProjectEmployeeIdField.setRequired(false);
		mainProjectEmployeeIdField.setHidden(true);
		
		
		mainProjectIdField = new DataSourceIntegerField("mainProjectId", "大项目主键");
		mainProjectIdField.setRequired(false);
		mainProjectIdField.setHidden(true);

		

		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(true);
		contractCodeField.setHidden(false);
		
		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setLength(64);
		contractNameField.setRequired(true);
		contractNameField.setHidden(false);

		
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



		setFields(mainProjectEmployeeIdField,contractIdField,relationField,contractCodeField,contractNameField , employeeIdField, mainProjectIdField);
	}


}

