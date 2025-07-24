package com.pomplatform.client.capitaldistribution.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDCapitalDistributionOfDepartment extends DataSource
{


	public static CDCapitalDistributionOfDepartment instance = null;

	public static CDCapitalDistributionOfDepartment getInstance() {
		if(instance == null) {
			instance = new CDCapitalDistributionOfDepartment("CDCapitalDistributionOfDepartment");
		}
		return instance;
	}

	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceIntegerField idField;
	private final DataSourceDateTimeField startDateField;
	private final DataSourceDateTimeField endDateField;

	public CDCapitalDistributionOfDepartment(String dataSourceID) {

		setID(dataSourceID);
		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(64);
		contractCodeField.setHidden(false);

		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setRequired(false);
		contractNameField.setLength(512);
		contractNameField.setHidden(false);

		idField = new DataSourceIntegerField("id", "业务部门");
		idField.setRequired(false);
		idField.setLength(11);
		idField.setHidden(false);
		idField.setValueMap(KeyValueManager.getValueMap("plate_records"));

		startDateField = new DataSourceDateTimeField("startDate", "发生日期");
		startDateField.setRequired(false);
		startDateField.setHidden(false);

		endDateField = new DataSourceDateTimeField("endDate", "发生日期");
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


		setFields(contractCodeField, contractNameField, idField, startDateField, endDateField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

