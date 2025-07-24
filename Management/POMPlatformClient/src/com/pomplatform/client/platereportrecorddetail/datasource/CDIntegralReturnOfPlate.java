package com.pomplatform.client.platereportrecorddetail.datasource;

import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceIntegerField;

public class CDIntegralReturnOfPlate extends DataSource
{


	public static CDIntegralReturnOfPlate instance = null;

	public static CDIntegralReturnOfPlate getInstance() {
		if(instance == null) {
			instance = new CDIntegralReturnOfPlate("CDIntegralReturnOfPlate");
		}
		return instance;
	}

	private final DataSourceIntegerField plateIdField;

	public CDIntegralReturnOfPlate(String dataSourceID) {

		setID(dataSourceID);
		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(true);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

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


		setFields(plateIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

