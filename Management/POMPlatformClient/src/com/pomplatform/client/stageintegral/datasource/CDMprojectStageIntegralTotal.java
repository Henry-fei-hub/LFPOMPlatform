package com.pomplatform.client.stageintegral.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMprojectStageIntegralTotal extends DataSource
{


	public static CDMprojectStageIntegralTotal instance = null;

	public static CDMprojectStageIntegralTotal getInstance() {
		if(instance == null) {
			instance = new CDMprojectStageIntegralTotal("CDMprojectStageIntegralTotal");
		}
		return instance;
	}

	private final DataSourceIntegerField proejctIdField;

	public CDMprojectStageIntegralTotal(String dataSourceID) {

		setID(dataSourceID);
		proejctIdField = new DataSourceIntegerField("proejctId", "项目");
		proejctIdField.setRequired(true);
		proejctIdField.setLength(11);
		proejctIdField.setHidden(false);

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


		setFields(proejctIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

