package com.pomplatform.client.payment.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDBonusCommon extends DataSource
{


	public static CDBonusCommon instance = null;

	public static CDBonusCommon getInstance() {
		if(instance == null) {
			instance = new CDBonusCommon("CDBonusCommon");
		}
		return instance;
	}

	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;
	private final DataSourceIntegerField personnelBusinessIdField;
	private final DataSourceIntegerField salaryTypeField;
	private final DataSourceIntegerField fundraisingProjectTypeField;

	public CDBonusCommon(String dataSourceID) {

		setID(dataSourceID);
		companyIdField = new DataSourceIntegerField("companyId", "所属公司");
		companyIdField.setRequired(false);
		companyIdField.setLength(11);
		companyIdField.setHidden(false);

		yearField = new DataSourceIntegerField("year", "undefined");
		yearField.setRequired(true);
		yearField.setLength(11);
		yearField.setHidden(false);

		monthField = new DataSourceIntegerField("month", "undefined");
		monthField.setRequired(true);
		monthField.setLength(11);
		monthField.setHidden(false);

		personnelBusinessIdField = new DataSourceIntegerField("personnelBusinessId", "流程业务表Id");
		personnelBusinessIdField.setRequired(false);
		personnelBusinessIdField.setLength(11);
		personnelBusinessIdField.setHidden(false);

		salaryTypeField = new DataSourceIntegerField("salaryType", "类型（1.募投项目 2.研发项目）");
		salaryTypeField.setRequired(false);
		salaryTypeField.setLength(11);
		salaryTypeField.setHidden(false);

		fundraisingProjectTypeField = new DataSourceIntegerField("fundraisingProjectType", "募投项目类型");
		fundraisingProjectTypeField.setRequired(false);
		fundraisingProjectTypeField.setLength(11);
		fundraisingProjectTypeField.setHidden(false);

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


		setFields(companyIdField, yearField, monthField, personnelBusinessIdField, salaryTypeField, fundraisingProjectTypeField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

