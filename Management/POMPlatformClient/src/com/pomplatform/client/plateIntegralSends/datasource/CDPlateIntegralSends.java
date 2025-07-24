package com.pomplatform.client.plateIntegralSends.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDPlateIntegralSends extends DataSource
{


	public static CDPlateIntegralSends instance = null;

	public static CDPlateIntegralSends getInstance() {
		if(instance == null) {
			instance = new CDPlateIntegralSends("CDPlateIntegralSends");
		}
		return instance;
	}

	private final DataSourceIntegerField plateIntegralSendIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceDateField startDateField;
	private final DataSourceDateField endDateField;

	public CDPlateIntegralSends(String dataSourceID) {

		setID(dataSourceID);
		plateIntegralSendIdField = new DataSourceIntegerField("plateIntegralSendId", "主键编码");
		plateIntegralSendIdField.setRequired(true);
		plateIntegralSendIdField.setLength(11);
		plateIntegralSendIdField.setPrimaryKey(true);
		plateIntegralSendIdField.setHidden(true);

		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "操作人");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);

		startDateField = new DataSourceDateField("startDate", "补贴日期");
		startDateField.setRequired(false);
		startDateField.setHidden(false);

		endDateField = new DataSourceDateField("endDate", "补贴日期");
		endDateField.setRequired(false);
		endDateField.setHidden(false);

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


		setFields(plateIntegralSendIdField, plateIdField, employeeIdField, startDateField, endDateField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

