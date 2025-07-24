package com.pomplatform.client.bonuspayment.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDbonusSummary extends DataSource
{


	public static CDbonusSummary instance = null;

	public static CDbonusSummary getInstance() {
		if(instance == null) {
			instance = new CDbonusSummary("CDbonusSummary");
		}
		return instance;
	}

	private final DataSourceDateField firstStartField;
	private final DataSourceDateField firstEndField;
	private final DataSourceDateField secondStartField;
	private final DataSourceDateField secondEndField;
	private final DataSourceDateField thirdStartField;
	private final DataSourceDateField thirdEndField;
	private final DataSourceDateField fourthStartField;
	private final DataSourceDateField fourthEndField;
	private final DataSourceIntegerField plateIdField;

	public CDbonusSummary(String dataSourceID) {

		setID(dataSourceID);
		firstStartField = new DataSourceDateField("firstStart", "第一季度开始时间");
		firstStartField.setRequired(false);
		firstStartField.setHidden(false);

		firstEndField = new DataSourceDateField("firstEnd", "第一季度结束");
		firstEndField.setRequired(false);
		firstEndField.setHidden(false);

		secondStartField = new DataSourceDateField("secondStart", "第二季度开始");
		secondStartField.setRequired(false);
		secondStartField.setHidden(false);

		secondEndField = new DataSourceDateField("secondEnd", "第二季度结束");
		secondEndField.setRequired(false);
		secondEndField.setHidden(false);

		thirdStartField = new DataSourceDateField("thirdStart", "第三季度开始");
		thirdStartField.setRequired(false);
		thirdStartField.setHidden(false);

		thirdEndField = new DataSourceDateField("thirdEnd", "第三季度结束");
		thirdEndField.setRequired(false);
		thirdEndField.setHidden(false);

		fourthStartField = new DataSourceDateField("fourthStart", "第四季度开始");
		fourthStartField.setRequired(false);
		fourthStartField.setHidden(false);

		fourthEndField = new DataSourceDateField("fourthEnd", "第四季度结束");
		fourthEndField.setRequired(false);
		fourthEndField.setHidden(false);

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


		setFields(firstStartField, firstEndField, secondStartField, secondEndField, thirdStartField, thirdEndField, fourthStartField, fourthEndField, plateIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

