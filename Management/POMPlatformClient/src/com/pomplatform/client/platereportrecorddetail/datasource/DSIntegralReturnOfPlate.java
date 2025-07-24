package com.pomplatform.client.platereportrecorddetail.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSIntegralReturnOfPlate extends DBDataSource
{


	public static DSIntegralReturnOfPlate instance = null;

	public static DSIntegralReturnOfPlate getInstance() {
		if(instance == null) {
			instance = new DSIntegralReturnOfPlate("DSIntegralReturnOfPlate");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField gradeIdField;
	private final DataSourceFloatField achieveintegralField;
	private final DataSourceIntegerField searchPlateIdField;
	private final DataSourceFloatField integralreturnofplateField;

	public DSIntegralReturnOfPlate(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("IntegralReturnOfPlate");


		employeeIdField = new DataSourceIntegerField("employeeId", "员工编码");
		employeeIdField.setLength(11);
		employeeIdField.setPrimaryKey(true);
		employeeIdField.setRequired(true);
		employeeIdField.setHidden(true);
		//employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		achieveintegralField = new DataSourceFloatField("achieveintegral", "价值积分");
		achieveintegralField.setLength(18);
		achieveintegralField.setDecimalPad(2);
		achieveintegralField.setFormat("#,###,###,###,###,##0.00");
		achieveintegralField.setRequired(true);
		achieveintegralField.setHidden(false);

		integralreturnofplateField = new DataSourceFloatField("integralreturnofplate", "欠款积分");
		integralreturnofplateField.setLength(18);
		integralreturnofplateField.setDecimalPad(2);
		integralreturnofplateField.setFormat("#,###,###,###,###,##0.00");
		integralreturnofplateField.setRequired(true);
		integralreturnofplateField.setHidden(false);
		
		
		employeeNoField = new DataSourceTextField("employeeNo", "工号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(true);
		employeeNoField.setHidden(false);


		employeeNameField = new DataSourceTextField("employeeName", "姓名");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(true);
		employeeNameField.setHidden(false);
		

		searchPlateIdField = new DataSourceIntegerField("searchPlateId", "搜索的业务部门");
		searchPlateIdField.setLength(11);
		searchPlateIdField.setRequired(true);
		searchPlateIdField.setHidden(true);


		statusField = new DataSourceIntegerField("status", "状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_11"));


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));

		gradeIdField = new DataSourceIntegerField("gradeId", "职级");
		gradeIdField.setLength(64);
		gradeIdField.setRequired(false);
		gradeIdField.setHidden(false);
		gradeIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_3"));
		
		setFields(employeeIdField, achieveintegralField, integralreturnofplateField, employeeNoField, employeeNameField, plateIdField, searchPlateIdField,gradeIdField, statusField);
	}


}

