package com.pomplatform.client.preprojectrecord.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSpreProjectRecordRrtor extends DataSource
{


	public static CDSpreProjectRecordRrtor instance = null;

	public static CDSpreProjectRecordRrtor getInstance() {
		if(instance == null) {
			instance = new CDSpreProjectRecordRrtor("CDSpreProjectRecordRrtor");
		}
		return instance;
	}

	private final DataSourceTextField relevantEmployeesField;
	private final DataSourceTextField remarkField;
	private final DataSourceTextField trackCodeField;
	private final DataSourceIntegerField preProjectRecordIdField;
	private final DataSourceDateField trackDateField;
	private final DataSourceIntegerField informationTypeField;
	private final DataSourceIntegerField registerEmployeeField;
	private final DataSourceDateField registerDateField;
	private final DataSourceIntegerField mainProjectIdField;

	public CDSpreProjectRecordRrtor(String dataSourceID) {

		setID(dataSourceID);
		relevantEmployeesField = new DataSourceTextField("relevantEmployees", "相关人员");
		relevantEmployeesField.setRequired(false);
		relevantEmployeesField.setLength(1024);
		relevantEmployeesField.setHidden(false);

		remarkField = new DataSourceTextField("remark", "情况描述");
		remarkField.setRequired(true);
		remarkField.setLength(1024);
		remarkField.setHidden(false);

		trackCodeField = new DataSourceTextField("trackCode", "跟踪编号");
		trackCodeField.setRequired(false);
		trackCodeField.setLength(255);
		trackCodeField.setHidden(false);

		preProjectRecordIdField = new DataSourceIntegerField("preProjectRecordId", "主键id");
		preProjectRecordIdField.setRequired(true);
		preProjectRecordIdField.setLength(11);
		preProjectRecordIdField.setPrimaryKey(true);
		preProjectRecordIdField.setHidden(true);

		trackDateField = new DataSourceDateField("trackDate", "跟踪时间");
		trackDateField.setRequired(false);
		trackDateField.setHidden(false);

		informationTypeField = new DataSourceIntegerField("informationType", "信息类型");
		informationTypeField.setRequired(false);
		informationTypeField.setLength(11);
		informationTypeField.setHidden(false);

		registerEmployeeField = new DataSourceIntegerField("registerEmployee", "登记人");
		registerEmployeeField.setRequired(false);
		registerEmployeeField.setLength(11);
		registerEmployeeField.setHidden(false);

		registerDateField = new DataSourceDateField("registerDate", "登记时间");
		registerDateField.setRequired(false);
		registerDateField.setHidden(false);

		mainProjectIdField = new DataSourceIntegerField("mainProjectId", "项目id");
		mainProjectIdField.setRequired(false);
		mainProjectIdField.setLength(11);
		mainProjectIdField.setHidden(false);

		DataSourceIntegerField currentPageField
			= new DataSourceIntegerField("currentPage", "当前页");
		currentPageField.setRequired(true);
		currentPageField.setLength(10);
		currentPageField.setHidden(true);

		DataSourceIntegerField pageLinesField
			= new DataSourceIntegerField("pageLines", "每页行数");
		pageLinesField.setRequired(true);
		pageLinesField.setLength(10);
		pageLinesField.setHidden(true);


		setFields(relevantEmployeesField, remarkField, trackCodeField, preProjectRecordIdField, trackDateField, informationTypeField, registerEmployeeField, registerDateField, mainProjectIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

