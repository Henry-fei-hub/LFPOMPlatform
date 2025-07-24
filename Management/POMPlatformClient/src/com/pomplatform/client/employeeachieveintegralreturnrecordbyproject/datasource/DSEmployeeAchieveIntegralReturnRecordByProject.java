package com.pomplatform.client.employeeachieveintegralreturnrecordbyproject.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSEmployeeAchieveIntegralReturnRecordByProject extends DBDataSource
{


	public static DSEmployeeAchieveIntegralReturnRecordByProject instance = null;

	public static DSEmployeeAchieveIntegralReturnRecordByProject getInstance() {
		if(instance == null) {
			instance = new DSEmployeeAchieveIntegralReturnRecordByProject("DSEmployeeAchieveIntegralReturnRecordByProject");
		}
		return instance;
	}

	private final DataSourceTextField plateIdField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceFloatField achieveIntegralField;

	public DSEmployeeAchieveIntegralReturnRecordByProject(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("EmployeeAchieveIntegralReturnRecordByProject");


		plateIdField = new DataSourceTextField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		projectIdField = new DataSourceIntegerField("projectId", "项目名称");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(false);
//		KeyValueManager.loadValueMap("projects",projectIdField);
		KeyValueManager.loadValueMap("projects", projectIdField);


		achieveIntegralField = new DataSourceFloatField("achieveIntegral", "回流积分");
		achieveIntegralField.setLength(18);
		achieveIntegralField.setDecimalPad(2);
		achieveIntegralField.setFormat("#,###,###,###,###,##0.00");
		achieveIntegralField.setRequired(false);
		achieveIntegralField.setHidden(false);


		setFields(plateIdField, projectIdField, achieveIntegralField);
	}


}

