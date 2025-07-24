package com.pomplatform.client.plateintegraldetail.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMplateIntegralDetail extends DataSource
{


	public static CDMplateIntegralDetail instance = null;

	public static CDMplateIntegralDetail getInstance() {
		if(instance == null) {
			instance = new CDMplateIntegralDetail("CDMplateIntegralDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField plateIdField;

	public CDMplateIntegralDetail(String dataSourceID) {

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

