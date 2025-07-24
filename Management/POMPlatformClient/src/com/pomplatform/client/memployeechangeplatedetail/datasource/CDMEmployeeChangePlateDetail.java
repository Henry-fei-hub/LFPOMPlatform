package com.pomplatform.client.memployeechangeplatedetail.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMEmployeeChangePlateDetail extends DataSource
{


	public static CDMEmployeeChangePlateDetail instance = null;

	public static CDMEmployeeChangePlateDetail getInstance() {
		if(instance == null) {
			instance = new CDMEmployeeChangePlateDetail("CDMEmployeeChangePlateDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField startMonthField;
	private final DataSourceIntegerField endMonthField;
	private final DataSourceIntegerField inPlateIdField;
	private final DataSourceIntegerField outPlateIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceIntegerField employeeIdField;

	public CDMEmployeeChangePlateDetail(String dataSourceID) {

		setID(dataSourceID);
		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setRequired(false);
		yearField.setLength(11);
		yearField.setHidden(false);
		yearField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		startMonthField = new DataSourceIntegerField("startMonth", "开始月份");
		startMonthField.setRequired(false);
		startMonthField.setLength(11);
		startMonthField.setHidden(false);
		startMonthField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		endMonthField = new DataSourceIntegerField("endMonth", "截止月份");
		endMonthField.setRequired(false);
		endMonthField.setLength(11);
		endMonthField.setHidden(false);
		endMonthField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		inPlateIdField = new DataSourceIntegerField("inPlateId", "转入业务部门");
		inPlateIdField.setRequired(false);
		inPlateIdField.setLength(11);
		inPlateIdField.setHidden(false);
		inPlateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		outPlateIdField = new DataSourceIntegerField("outPlateId", "转出业务部门");
		outPlateIdField.setRequired(false);
		outPlateIdField.setLength(11);
		outPlateIdField.setHidden(false);
		outPlateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		employeeNoField = new DataSourceTextField("employeeNo", "工号");
		employeeNoField.setRequired(true);
		employeeNoField.setLength(64);
		employeeNoField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "姓名");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

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


		setFields(yearField, startMonthField, endMonthField, inPlateIdField, outPlateIdField, employeeNoField, employeeIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

