package com.pomplatform.client.employeeaccountrecordeeppccmmpebor.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMemployeeaccountrecordeeppccmmpebor extends DataSource
{


	public static CDMemployeeaccountrecordeeppccmmpebor instance = null;

	public static CDMemployeeaccountrecordeeppccmmpebor getInstance() {
		if(instance == null) {
			instance = new CDMemployeeaccountrecordeeppccmmpebor("CDMemployeeaccountrecordeeppccmmpebor");
		}
		return instance;
	}

	private final DataSourceDateTimeField minRecordDateField;
	private final DataSourceDateTimeField maxRecordDateField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField businessTypeIdField;

	public CDMemployeeaccountrecordeeppccmmpebor(String dataSourceID) {

		setID(dataSourceID);
		minRecordDateField = new DataSourceDateTimeField("minRecordDate", "开始日期");
		minRecordDateField.setRequired(true);
		minRecordDateField.setHidden(false);

		maxRecordDateField = new DataSourceDateTimeField("maxRecordDate", "结束日期");
		maxRecordDateField.setRequired(true);
		maxRecordDateField.setHidden(false);

		plateIdField = new DataSourceIntegerField("plateId", "业务部门ID");
		plateIdField.setRequired(true);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "undefined");
		employeeIdField.setRequired(true);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		businessTypeIdField = new DataSourceIntegerField("businessTypeId", "undefined");
		businessTypeIdField.setRequired(true);
		businessTypeIdField.setLength(11);
		businessTypeIdField.setHidden(false);

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


		setFields(minRecordDateField, maxRecordDateField, plateIdField, employeeIdField, businessTypeIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

