package com.pomplatform.client.bonuspayment.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDbonusSummaryDetail extends DataSource
{


	public static CDbonusSummaryDetail instance = null;

	public static CDbonusSummaryDetail getInstance() {
		if(instance == null) {
			instance = new CDbonusSummaryDetail("CDbonusSummaryDetail");
		}
		return instance;
	}

	private final DataSourceDateField firststartField;
	private final DataSourceDateField firstendField;
	private final DataSourceDateField secondstartField;
	private final DataSourceDateField secondendField;
	private final DataSourceDateField thirdstartField;
	private final DataSourceDateField thirdendField;
	private final DataSourceDateField fourthstartField;
	private final DataSourceDateField fourthendField;
	private final DataSourceIntegerField plateIdField;

	public CDbonusSummaryDetail(String dataSourceID) {

		setID(dataSourceID);
		firststartField = new DataSourceDateField("firststart", "发放年月");
		firststartField.setRequired(false);
		firststartField.setHidden(false);

		firstendField = new DataSourceDateField("firstend", "发放年月");
		firstendField.setRequired(false);
		firstendField.setHidden(false);

		secondstartField = new DataSourceDateField("secondstart", "发放年月");
		secondstartField.setRequired(false);
		secondstartField.setHidden(false);

		secondendField = new DataSourceDateField("secondend", "发放年月");
		secondendField.setRequired(false);
		secondendField.setHidden(false);

		thirdstartField = new DataSourceDateField("thirdstart", "发放年月");
		thirdstartField.setRequired(false);
		thirdstartField.setHidden(false);

		thirdendField = new DataSourceDateField("thirdend", "发放年月");
		thirdendField.setRequired(false);
		thirdendField.setHidden(false);

		fourthstartField = new DataSourceDateField("fourthstart", "发放年月");
		fourthstartField.setRequired(false);
		fourthstartField.setHidden(false);

		fourthendField = new DataSourceDateField("fourthend", "发放年月");
		fourthendField.setRequired(false);
		fourthendField.setHidden(false);

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


		setFields(firststartField, firstendField, secondstartField, secondendField, thirdstartField, thirdendField, fourthstartField, fourthendField, plateIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

