package com.pomplatform.client.preprojecttransferrecordpors.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDForPreproJectTransFerrecordporDate extends DataSource
{


	public static CDForPreproJectTransFerrecordporDate instance = null;

	public static CDForPreproJectTransFerrecordporDate getInstance() {
		if(instance == null) {
			instance = new CDForPreproJectTransFerrecordporDate("CDForPreproJectTransFerrecordporDate");
		}
		return instance;
	}

	private final DataSourceIntegerField preProjectTransferRecordIdField;

	public CDForPreproJectTransFerrecordporDate(String dataSourceID) {

		setID(dataSourceID);
		preProjectTransferRecordIdField = new DataSourceIntegerField("preProjectTransferRecordId", "主键编码");
		preProjectTransferRecordIdField.setRequired(true);
		preProjectTransferRecordIdField.setLength(11);
		preProjectTransferRecordIdField.setPrimaryKey(true);
		preProjectTransferRecordIdField.setHidden(true);

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


		setFields(preProjectTransferRecordIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

