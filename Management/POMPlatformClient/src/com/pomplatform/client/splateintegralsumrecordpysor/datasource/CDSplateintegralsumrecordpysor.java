package com.pomplatform.client.splateintegralsumrecordpysor.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSplateintegralsumrecordpysor extends DataSource
{


	public static CDSplateintegralsumrecordpysor instance = null;

	public static CDSplateintegralsumrecordpysor getInstance() {
		if(instance == null) {
			instance = new CDSplateintegralsumrecordpysor("CDSplateintegralsumrecordpysor");
		}
		return instance;
	}

	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField startMonthField;
	private final DataSourceIntegerField endMonthField;

	public CDSplateintegralsumrecordpysor(String dataSourceID) {

		setID(dataSourceID);
		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setRequired(false);
		yearField.setLength(11);
		yearField.setHidden(false);
		yearField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		startMonthField = new DataSourceIntegerField("startMonth", "开始月份");
		startMonthField.setRequired(false);
		startMonthField.setLength(11);
		startMonthField.setHidden(false);
		startMonthField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		endMonthField = new DataSourceIntegerField("endMonth", "截止月份");
		endMonthField.setRequired(false);
		endMonthField.setLength(11);
		endMonthField.setHidden(false);
		endMonthField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

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


		setFields(plateIdField, yearField, startMonthField, endMonthField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

