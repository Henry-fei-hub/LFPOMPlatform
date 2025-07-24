package com.pomplatform.client.report.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSalaryBonusAnalysisByDepartment extends DataSource
{


	public static CDSalaryBonusAnalysisByDepartment instance = null;

	public static CDSalaryBonusAnalysisByDepartment getInstance() {
		if(instance == null) {
			instance = new CDSalaryBonusAnalysisByDepartment("CDSalaryBonusAnalysisByDepartment");
		}
		return instance;
	}

	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField yearField;
	private final DataSourceDateField firstStartField;
	private final DataSourceDateField firstEndField;
	private final DataSourceDateField secondStartField;
	private final DataSourceDateField secondEndField;
	private final DataSourceDateField thirdStartField;
	private final DataSourceDateField thirdEndField;
	private final DataSourceDateField fourthStartField;
	private final DataSourceDateField fourthEndField;

	public CDSalaryBonusAnalysisByDepartment(String dataSourceID) {

		setID(dataSourceID);
		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setRequired(false);
		companyIdField.setLength(11);
		companyIdField.setHidden(false);

		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(true);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);

		departmentIdField = new DataSourceIntegerField("departmentId", "归属部门");
		departmentIdField.setRequired(true);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);

		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setRequired(true);
		yearField.setLength(11);
		yearField.setHidden(false);

		firstStartField = new DataSourceDateField("firstStart", "第一季度开始时间");
		firstStartField.setRequired(false);
		firstStartField.setHidden(false);

		firstEndField = new DataSourceDateField("firstEnd", "第一季结束时间");
		firstEndField.setRequired(false);
		firstEndField.setHidden(false);

		secondStartField = new DataSourceDateField("secondStart", "第二季开始时间");
		secondStartField.setRequired(false);
		secondStartField.setHidden(false);

		secondEndField = new DataSourceDateField("secondEnd", "第二季结束时间");
		secondEndField.setRequired(false);
		secondEndField.setHidden(false);

		thirdStartField = new DataSourceDateField("thirdStart", "第三季开始时间");
		thirdStartField.setRequired(false);
		thirdStartField.setHidden(false);

		thirdEndField = new DataSourceDateField("thirdEnd", "第三季结束时间");
		thirdEndField.setRequired(false);
		thirdEndField.setHidden(false);

		fourthStartField = new DataSourceDateField("fourthStart", "第四季开始时间");
		fourthStartField.setRequired(false);
		fourthStartField.setHidden(false);

		fourthEndField = new DataSourceDateField("fourthEnd", "第四季结束时间");
		fourthEndField.setRequired(false);
		fourthEndField.setHidden(false);

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


		setFields(companyIdField, plateIdField, departmentIdField, yearField, firstStartField, firstEndField, secondStartField, secondEndField, thirdStartField, thirdEndField, fourthStartField, fourthEndField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

