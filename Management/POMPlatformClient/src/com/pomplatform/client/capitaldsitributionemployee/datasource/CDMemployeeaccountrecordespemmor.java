package com.pomplatform.client.capitaldsitributionemployee.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMemployeeaccountrecordespemmor extends DataSource
{


	public static CDMemployeeaccountrecordespemmor instance = null;

	public static CDMemployeeaccountrecordespemmor getInstance() {
		if(instance == null) {
			instance = new CDMemployeeaccountrecordespemmor("CDMemployeeaccountrecordespemmor");
		}
		return instance;
	}

	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceDateField minRecordDateField;
	private final DataSourceDateField maxRecordDateField;

	public CDMemployeeaccountrecordespemmor(String dataSourceID) {

		setID(dataSourceID);
		plateIdField = new DataSourceIntegerField("plateId", "所在业务部门");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "职员编码");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		minRecordDateField = new DataSourceDateField("minRecordDate", "最早日期");
		minRecordDateField.setRequired(false);
		minRecordDateField.setHidden(false);

		maxRecordDateField = new DataSourceDateField("maxRecordDate", "最晚日期");
		maxRecordDateField.setRequired(false);
		maxRecordDateField.setHidden(false);

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


		setFields(plateIdField, employeeIdField, minRecordDateField, maxRecordDateField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

