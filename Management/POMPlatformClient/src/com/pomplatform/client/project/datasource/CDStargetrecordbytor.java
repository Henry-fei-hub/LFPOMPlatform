package com.pomplatform.client.project.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDStargetrecordbytor extends DataSource
{


	public static CDStargetrecordbytor instance = null;

	public static CDStargetrecordbytor getInstance() {
		if(instance == null) {
			instance = new CDStargetrecordbytor("CDStargetrecordbytor");
		}
		return instance;
	}

	private final DataSourceIntegerField businessLineField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField typeField;

	public CDStargetrecordbytor(String dataSourceID) {

		setID(dataSourceID);
		businessLineField = new DataSourceIntegerField("businessLine", "条线类型");
		businessLineField.setRequired(false);
		businessLineField.setLength(11);
		businessLineField.setHidden(false);

		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setRequired(false);
		yearField.setLength(11);
		yearField.setHidden(false);

		typeField = new DataSourceIntegerField("type", "指标类型");
		typeField.setRequired(false);
		typeField.setLength(11);
		typeField.setHidden(false);

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


		setFields(businessLineField, yearField, typeField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

