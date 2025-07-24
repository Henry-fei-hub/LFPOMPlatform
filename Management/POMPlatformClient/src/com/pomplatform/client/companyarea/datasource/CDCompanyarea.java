package com.pomplatform.client.companyarea.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDCompanyarea extends DataSource
{


	public static CDCompanyarea instance = null;

	public static CDCompanyarea getInstance() {
		if(instance == null) {
			instance = new CDCompanyarea("CDCompanyarea");
		}
		return instance;
	}

	private final DataSourceIntegerField areaIdField;
	private final DataSourceIntegerField companyRecordIdField;

	public CDCompanyarea(String dataSourceID) {

		setID(dataSourceID);
		areaIdField = new DataSourceIntegerField("areaId", "区域");
		areaIdField.setRequired(false);
		areaIdField.setLength(11);
		areaIdField.setHidden(false);

		companyRecordIdField = new DataSourceIntegerField("companyRecordId", "主键编码");
		companyRecordIdField.setRequired(true);
		companyRecordIdField.setLength(11);
		companyRecordIdField.setPrimaryKey(true);
		companyRecordIdField.setHidden(true);

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


		setFields(areaIdField, companyRecordIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

