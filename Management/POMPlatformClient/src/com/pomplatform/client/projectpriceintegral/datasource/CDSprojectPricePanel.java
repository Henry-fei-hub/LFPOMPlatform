package com.pomplatform.client.projectpriceintegral.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSprojectPricePanel extends DataSource
{


	public static CDSprojectPricePanel instance = null;

	public static CDSprojectPricePanel getInstance() {
		if(instance == null) {
			instance = new CDSprojectPricePanel("CDSprojectPricePanel");
		}
		return instance;
	}

	private final DataSourceIntegerField projectUnitPriceIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField areaIdField;
	private final DataSourceIntegerField gradeIdField;
	private final DataSourceIntegerField squareIdField;

	public CDSprojectPricePanel(String dataSourceID) {

		setID(dataSourceID);
		projectUnitPriceIdField = new DataSourceIntegerField("projectUnitPriceId", "项目单价");
		projectUnitPriceIdField.setRequired(true);
		projectUnitPriceIdField.setLength(11);
		projectUnitPriceIdField.setPrimaryKey(true);
		projectUnitPriceIdField.setHidden(true);

		plateIdField = new DataSourceIntegerField("plateId", "板块");
		plateIdField.setRequired(false);
		plateIdField.setLength(64);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));

		areaIdField = new DataSourceIntegerField("areaId", "区域");
		areaIdField.setRequired(false);
		areaIdField.setLength(64);
		areaIdField.setHidden(false);
		areaIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_13"));

		gradeIdField = new DataSourceIntegerField("gradeId", "项目级别");
		gradeIdField.setRequired(false);
		gradeIdField.setLength(64);
		gradeIdField.setHidden(false);
		gradeIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_2"));

		squareIdField = new DataSourceIntegerField("squareId", "面积区间");
		squareIdField.setRequired(false);
		squareIdField.setLength(64);
		squareIdField.setHidden(false);
		squareIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_14"));

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


		setFields(projectUnitPriceIdField, plateIdField, areaIdField, gradeIdField, squareIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

