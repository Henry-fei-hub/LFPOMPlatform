package com.pomplatform.client.plateintegralsendrecord.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDPlateIntegralSendRecord extends DataSource
{


	public static CDPlateIntegralSendRecord instance = null;

	public static CDPlateIntegralSendRecord getInstance() {
		if(instance == null) {
			instance = new CDPlateIntegralSendRecord("CDPlateIntegralSendRecord");
		}
		return instance;
	}

	private final DataSourceIntegerField plateIdField;
	private final DataSourceDateField startdateField;
	private final DataSourceDateField enddateField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;

	public CDPlateIntegralSendRecord(String dataSourceID) {

		setID(dataSourceID);
		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		startdateField = new DataSourceDateField("startdate", "开始时间");
		startdateField.setRequired(false);
		startdateField.setHidden(false);

		enddateField = new DataSourceDateField("enddate", "截止时间");
		enddateField.setRequired(false);
		enddateField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "操作人姓名");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		employeeNoField = new DataSourceTextField("employeeNo", "操作人工号");
		employeeNoField.setRequired(true);
		employeeNoField.setLength(64);
		employeeNoField.setHidden(false);

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


		setFields(plateIdField, startdateField, enddateField, employeeIdField, employeeNoField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

