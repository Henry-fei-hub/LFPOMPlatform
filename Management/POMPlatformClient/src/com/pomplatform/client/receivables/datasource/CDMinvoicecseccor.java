package com.pomplatform.client.receivables.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMinvoicecseccor extends DataSource
{


	public static CDMinvoicecseccor instance = null;

	public static CDMinvoicecseccor getInstance() {
		if(instance == null) {
			instance = new CDMinvoicecseccor("CDMinvoicecseccor");
		}
		return instance;
	}

	private final DataSourceIntegerField projectManagerIdField;
	private final DataSourceTextField startDateField;
	private final DataSourceTextField endDateField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;

	public CDMinvoicecseccor(String dataSourceID) {

		setID(dataSourceID);
		projectManagerIdField = new DataSourceIntegerField("projectManagerId", "项目经理");
		projectManagerIdField.setRequired(false);
		projectManagerIdField.setLength(11);
		projectManagerIdField.setHidden(false);

		startDateField = new DataSourceTextField("startDate", "开始时间");
		startDateField.setRequired(true);
		startDateField.setLength(0);
		startDateField.setHidden(false);

		endDateField = new DataSourceTextField("endDate", "结束时间");
		endDateField.setRequired(true);
		endDateField.setLength(0);
		endDateField.setHidden(false);
		
		contractCodeField = new DataSourceTextField("contractCode", "订单编号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(64);
		contractCodeField.setHidden(false);

		contractNameField = new DataSourceTextField("contractName", "订单名称");
		contractNameField.setRequired(false);
		contractNameField.setLength(512);
		contractNameField.setHidden(false);

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


		setFields(projectManagerIdField,startDateField, endDateField, contractCodeField, contractNameField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

