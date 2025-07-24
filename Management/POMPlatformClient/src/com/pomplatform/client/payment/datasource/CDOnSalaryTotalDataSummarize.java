package com.pomplatform.client.payment.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnSalaryTotalDataSummarize extends DataSource
{


	public static CDOnSalaryTotalDataSummarize instance = null;

	public static CDOnSalaryTotalDataSummarize getInstance() {
		if(instance == null) {
			instance = new CDOnSalaryTotalDataSummarize("CDOnSalaryTotalDataSummarize");
		}
		return instance;
	}

	private final DataSourceIntegerField startyearField;
	private final DataSourceIntegerField endyearField;
	private final DataSourceIntegerField startmonthField;
	private final DataSourceIntegerField endmonthField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField plateIdField;

	public CDOnSalaryTotalDataSummarize(String dataSourceID) {

		setID(dataSourceID);
		startyearField = new DataSourceIntegerField("startyear", "开始年份");
		startyearField.setRequired(false);
		startyearField.setLength(11);
		startyearField.setHidden(false);

		endyearField = new DataSourceIntegerField("endyear", "结束年份");
		endyearField.setRequired(false);
		endyearField.setLength(11);
		endyearField.setHidden(false);

		startmonthField = new DataSourceIntegerField("startmonth", "开始月份");
		startmonthField.setRequired(false);
		startmonthField.setLength(11);
		startmonthField.setHidden(false);

		endmonthField = new DataSourceIntegerField("endmonth", "结束月份");
		endmonthField.setRequired(false);
		endmonthField.setLength(11);
		endmonthField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "员工id");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);

		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setRequired(false);
		employeeNoField.setLength(64);
		employeeNoField.setHidden(false);

		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setRequired(false);
		employeeNameField.setLength(64);
		employeeNameField.setHidden(false);

		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setRequired(false);
		companyIdField.setLength(11);
		companyIdField.setHidden(false);

		departmentIdField = new DataSourceIntegerField("departmentId", "归属部门");
		departmentIdField.setRequired(false);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);

		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);

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


		setFields(startyearField, endyearField, startmonthField, endmonthField, employeeIdField, employeeNoField, employeeNameField, companyIdField, departmentIdField, plateIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

