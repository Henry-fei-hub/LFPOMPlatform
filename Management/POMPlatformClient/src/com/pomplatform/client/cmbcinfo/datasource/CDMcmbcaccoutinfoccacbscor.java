package com.pomplatform.client.cmbcinfo.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMcmbcaccoutinfoccacbscor extends DataSource
{


	public static CDMcmbcaccoutinfoccacbscor instance = null;

	public static CDMcmbcaccoutinfoccacbscor getInstance() {
		if(instance == null) {
			instance = new CDMcmbcaccoutinfoccacbscor("CDMcmbcaccoutinfoccacbscor");
		}
		return instance;
	}

	private final DataSourceIntegerField companyRecordIdField;
	private final DataSourceTextField accnbrField;
	private final DataSourceIntegerField cmbcAccoutInfoIdField;
	private final DataSourceTextField bbknbrField;
	private final DataSourceTextField stscodField;
	private final DataSourceTextField ccynbrField;

	public CDMcmbcaccoutinfoccacbscor(String dataSourceID) {

		setID(dataSourceID);
		companyRecordIdField = new DataSourceIntegerField("companyRecordId", "主键编码");
		companyRecordIdField.setRequired(true);
		companyRecordIdField.setLength(11);
		companyRecordIdField.setPrimaryKey(true);
		companyRecordIdField.setHidden(true);

		accnbrField = new DataSourceTextField("accnbr", "账号");
		accnbrField.setRequired(false);
		accnbrField.setLength(255);
		accnbrField.setHidden(false);

		cmbcAccoutInfoIdField = new DataSourceIntegerField("cmbcAccoutInfoId", "主键");
		cmbcAccoutInfoIdField.setRequired(true);
		cmbcAccoutInfoIdField.setLength(11);
		cmbcAccoutInfoIdField.setPrimaryKey(true);
		cmbcAccoutInfoIdField.setHidden(true);

		bbknbrField = new DataSourceTextField("bbknbr", "分行号");
		bbknbrField.setRequired(false);
		bbknbrField.setLength(255);
		bbknbrField.setHidden(false);

		stscodField = new DataSourceTextField("stscod", "状态 A活动 B冻结 C关户");
		stscodField.setRequired(false);
		stscodField.setLength(1);
		stscodField.setHidden(false);

		ccynbrField = new DataSourceTextField("ccynbr", "币种(对应cmbc_codes的cmbc_curreny)");
		ccynbrField.setRequired(false);
		ccynbrField.setLength(8);
		ccynbrField.setHidden(false);

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


		setFields(companyRecordIdField, accnbrField, cmbcAccoutInfoIdField, bbknbrField, stscodField, ccynbrField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

