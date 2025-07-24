package com.pomplatform.client.employeemoneymanagespeemmepemmor.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMemployeemoneymanagespeemmepemmor extends DataSource
{


	public static CDMemployeemoneymanagespeemmepemmor instance = null;

	public static CDMemployeemoneymanagespeemmepemmor getInstance() {
		if(instance == null) {
			instance = new CDMemployeemoneymanagespeemmepemmor("CDMemployeemoneymanagespeemmepemmor");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField equivalentNumberField;
	private final DataSourceDateTimeField minCompleteTimeField;
	private final DataSourceDateTimeField maxCompleteTimeField;
	private final DataSourceIntegerField processStatusField;

	public CDMemployeemoneymanagespeemmepemmor(String dataSourceID) {

		setID(dataSourceID);
		employeeIdField = new DataSourceIntegerField("employeeId", "职员编码");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);

		equivalentNumberField = new DataSourceTextField("equivalentNumber", "对冲编号");
		equivalentNumberField.setRequired(false);
		equivalentNumberField.setLength(64);
		equivalentNumberField.setHidden(false);

		minCompleteTimeField = new DataSourceDateTimeField("minCompleteTime", "最早完成时间");
		minCompleteTimeField.setRequired(false);
		minCompleteTimeField.setHidden(false);

		maxCompleteTimeField = new DataSourceDateTimeField("maxCompleteTime", "最晚完成时间");
		maxCompleteTimeField.setRequired(false);
		maxCompleteTimeField.setHidden(false);

		processStatusField = new DataSourceIntegerField("processStatus", "流程状态");
		processStatusField.setRequired(false);
		processStatusField.setLength(11);
		processStatusField.setHidden(false);

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


		setFields(employeeIdField, equivalentNumberField, minCompleteTimeField, maxCompleteTimeField, processStatusField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

