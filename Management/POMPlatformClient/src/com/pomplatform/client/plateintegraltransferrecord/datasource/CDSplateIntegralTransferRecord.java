package com.pomplatform.client.plateintegraltransferrecord.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSplateIntegralTransferRecord extends DataSource
{


	public static CDSplateIntegralTransferRecord instance = null;

	public static CDSplateIntegralTransferRecord getInstance() {
		if(instance == null) {
			instance = new CDSplateIntegralTransferRecord("CDSplateIntegralTransferRecord");
		}
		return instance;
	}

	private final DataSourceIntegerField plateIdField;

	public CDSplateIntegralTransferRecord(String dataSourceID) {

		setID(dataSourceID);
		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(false);
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

