package com.pomplatform.client.revenue.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDRevenueStatisticalOfRevenue extends DataSource
{


	public static CDRevenueStatisticalOfRevenue instance = null;

	public static CDRevenueStatisticalOfRevenue getInstance() {
		if(instance == null) {
			instance = new CDRevenueStatisticalOfRevenue("CDRevenueStatisticalOfRevenue");
		}
		return instance;
	}

	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField plateManagerIdField;
	private final DataSourceIntegerField departmentManagerIdField;
	private final DataSourceIntegerField projectManageIdField;
	private final DataSourceTextField sheetNameField;
	private final DataSourceTextField sheetCodeField;

	public CDRevenueStatisticalOfRevenue(String dataSourceID) {

		setID(dataSourceID);
		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setRequired(false);
		yearField.setLength(11);
		yearField.setHidden(false);

		monthField = new DataSourceIntegerField("month", "月份");
		monthField.setRequired(false);
		monthField.setLength(11);
		monthField.setHidden(false);

		projectIdField = new DataSourceIntegerField("projectId", "项目ID");
		projectIdField.setRequired(true);
		projectIdField.setLength(11);
		projectIdField.setPrimaryKey(true);
		projectIdField.setHidden(true);
		KeyValueManager.loadValueMap("projects",projectIdField);

		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		plateManagerIdField = new DataSourceIntegerField("plateManagerId", "事业部负责人");
		plateManagerIdField.setRequired(false);
		plateManagerIdField.setLength(11);
		plateManagerIdField.setHidden(true);

		departmentManagerIdField = new DataSourceIntegerField("departmentManagerId", "部门经理");
		departmentManagerIdField.setRequired(false);
		departmentManagerIdField.setLength(11);
		departmentManagerIdField.setHidden(false);

		projectManageIdField = new DataSourceIntegerField("projectManageId", "专业负责人");
		projectManageIdField.setRequired(false);
		projectManageIdField.setLength(11);
		projectManageIdField.setHidden(false);
		projectManageIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		sheetNameField = new DataSourceTextField("sheetName", "订单名称");
		sheetNameField.setRequired(false);
		sheetNameField.setLength(512);
		sheetNameField.setHidden(false);

		sheetCodeField = new DataSourceTextField("sheetCode", "订单编号");
		sheetCodeField.setRequired(false);
		sheetCodeField.setLength(64);
		sheetCodeField.setHidden(false);
//		sheetCodeField.setValueMap(KeyValueManager.getValueMap("contracts"));
		KeyValueManager.loadValueMap("contracts",sheetCodeField);

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


		setFields(yearField, monthField, projectIdField, plateIdField, plateManagerIdField, departmentManagerIdField, projectManageIdField, sheetNameField, sheetCodeField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

