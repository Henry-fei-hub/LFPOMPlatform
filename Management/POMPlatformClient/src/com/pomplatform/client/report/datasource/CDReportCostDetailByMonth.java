package com.pomplatform.client.report.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDReportCostDetailByMonth extends DataSource
{


	public static CDReportCostDetailByMonth instance = null;

	public static CDReportCostDetailByMonth getInstance() {
		if(instance == null) {
			instance = new CDReportCostDetailByMonth("CDReportCostDetailByMonth");
		}
		return instance;
	}

	private final DataSourceDateTimeField yearField;
	private final DataSourceDateTimeField monthField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField feeTypeField;
	private final DataSourceTextField bearFeeCodeField;
	private final DataSourceTextField bearFeeNameField;
	private final DataSourceTextField codeField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField processStatusField;

	public CDReportCostDetailByMonth(String dataSourceID) {

		setID(dataSourceID);
		yearField = new DataSourceDateTimeField("year", "年份");
		yearField.setRequired(false);
		yearField.setHidden(false);

		monthField = new DataSourceDateTimeField("month", "月份");
		monthField.setRequired(false);
		monthField.setHidden(false);

		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setRequired(false);
		processTypeField.setLength(11);
		processTypeField.setHidden(false);
		processTypeField.setValueMap(KeyValueManager.getValueMap("system_process_types"));

		feeTypeField = new DataSourceIntegerField("feeType", "费用类型");
		feeTypeField.setRequired(false);
		feeTypeField.setLength(11);
		feeTypeField.setHidden(false);
		feeTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		bearFeeCodeField = new DataSourceTextField("bearFeeCode", "编号");
		bearFeeCodeField.setRequired(true);
		bearFeeCodeField.setLength(0);
		bearFeeCodeField.setHidden(false);

		bearFeeNameField = new DataSourceTextField("bearFeeName", "费用承担主体");
		bearFeeNameField.setRequired(true);
		bearFeeNameField.setLength(0);
		bearFeeNameField.setHidden(false);

		codeField = new DataSourceTextField("code", "报销编号");
		codeField.setRequired(false);
		codeField.setLength(64);
		codeField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "申请人");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		processStatusField = new DataSourceIntegerField("processStatus", "流程状态");
		processStatusField.setRequired(true);
		processStatusField.setLength(11);
		processStatusField.setHidden(false);
		processStatusField.setValueMap(new java.util.HashMap());

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


		setFields(yearField, monthField, processTypeField, feeTypeField, bearFeeCodeField, bearFeeNameField, codeField, employeeIdField, plateIdField, processStatusField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

