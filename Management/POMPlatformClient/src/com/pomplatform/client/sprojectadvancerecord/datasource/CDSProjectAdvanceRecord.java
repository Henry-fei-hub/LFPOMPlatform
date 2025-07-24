package com.pomplatform.client.sprojectadvancerecord.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSProjectAdvanceRecord extends DataSource
{


	public static CDSProjectAdvanceRecord instance = null;

	public static CDSProjectAdvanceRecord getInstance() {
		if(instance == null) {
			instance = new CDSProjectAdvanceRecord("CDSProjectAdvanceRecord");
		}
		return instance;
	}

	private final DataSourceIntegerField plateIdField;
	private final DataSourceDateField advanceYearField;
	private final DataSourceDateField advanceMonthField;

	public CDSProjectAdvanceRecord(String dataSourceID) {

		setID(dataSourceID);
		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		advanceYearField = new DataSourceDateField("advanceYear", "年份");
		advanceYearField.setRequired(false);
		advanceYearField.setHidden(false);

		advanceMonthField = new DataSourceDateField("advanceMonth", "月份");
		advanceMonthField.setRequired(false);
		advanceMonthField.setHidden(false);

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


		setFields(plateIdField, advanceYearField, advanceMonthField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

