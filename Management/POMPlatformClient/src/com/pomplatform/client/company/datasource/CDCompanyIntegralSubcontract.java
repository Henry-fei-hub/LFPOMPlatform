package com.pomplatform.client.company.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDCompanyIntegralSubcontract extends DataSource
{


	public static CDCompanyIntegralSubcontract instance = null;

	public static CDCompanyIntegralSubcontract getInstance() {
		if(instance == null) {
			instance = new CDCompanyIntegralSubcontract("CDCompanyIntegralSubcontract");
		}
		return instance;
	}

	private final DataSourceDateField startDateField;
	private final DataSourceDateField endDateField;
	private final DataSourceIntegerField businessTypeField;
	private final DataSourceIntegerField projectTypeField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceTextField subContractCodeField;
	private final DataSourceTextField subContractNameField;

	public CDCompanyIntegralSubcontract(String dataSourceID) {

		setID(dataSourceID);
		startDateField = new DataSourceDateField("startDate", "开始日期");
		startDateField.setRequired(false);
		startDateField.setHidden(false);

		endDateField = new DataSourceDateField("endDate", "截止日期");
		endDateField.setRequired(false);
		endDateField.setHidden(false);

		businessTypeField = new DataSourceIntegerField("businessType", "业务类别");
		businessTypeField.setRequired(false);
		businessTypeField.setLength(11);
		businessTypeField.setHidden(false);
		businessTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		projectTypeField = new DataSourceIntegerField("projectType", "项目类别");
		projectTypeField.setRequired(false);
		projectTypeField.setLength(11);
		projectTypeField.setHidden(false);
		projectTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		departmentIdField = new DataSourceIntegerField("departmentId", "承接部门");
		departmentIdField.setRequired(false);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));

		subContractCodeField = new DataSourceTextField("subContractCode", "订单编号");
		subContractCodeField.setRequired(false);
		subContractCodeField.setLength(64);
		subContractCodeField.setHidden(false);

		subContractNameField = new DataSourceTextField("subContractName", "订单名称");
		subContractNameField.setRequired(false);
		subContractNameField.setLength(64);
		subContractNameField.setHidden(false);

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


		setFields(startDateField, endDateField, businessTypeField, projectTypeField, departmentIdField, subContractCodeField, subContractNameField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

