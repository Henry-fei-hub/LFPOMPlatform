package com.pomplatform.client.projectperformance.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDProjectPerformanceDetail extends DataSource
{


	public static CDProjectPerformanceDetail instance = null;

	public static CDProjectPerformanceDetail getInstance() {
		if(instance == null) {
			instance = new CDProjectPerformanceDetail("CDProjectPerformanceDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField performanceFlagField;
	private final DataSourceIntegerField businessTypeField;

	public CDProjectPerformanceDetail(String dataSourceID) {

		setID(dataSourceID);
		employeeIdField = new DataSourceIntegerField("employeeId", "职员");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);
//		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));
		KeyValueManager.loadValueMap("employees",employeeIdField);
		contractIdField = new DataSourceIntegerField("contractId", "合同编码");
		contractIdField.setRequired(false);
		contractIdField.setLength(11);
		contractIdField.setHidden(false);
//		contractIdField.setValueMap(KeyValueManager.getValueMap("contracts"));
		KeyValueManager.loadValueMap("contracts",contractIdField);

		projectIdField = new DataSourceIntegerField("projectId", "项目编码");
		projectIdField.setRequired(false);
		projectIdField.setLength(11);
		projectIdField.setHidden(false);
		KeyValueManager.loadValueMap("projects",projectIdField);

		performanceFlagField = new DataSourceIntegerField("performanceFlag", "绩效类型");
		performanceFlagField.setRequired(false);
		performanceFlagField.setLength(11);
		performanceFlagField.setHidden(false);

		businessTypeField = new DataSourceIntegerField("businessType", "业务类型");
		businessTypeField.setRequired(false);
		businessTypeField.setLength(11);
		businessTypeField.setHidden(false);
		businessTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

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


		setFields(employeeIdField, contractIdField, projectIdField, performanceFlagField, businessTypeField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

