package com.pomplatform.client.bonuspayment.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDBonusPaymentDetail extends DataSource
{


	public static CDBonusPaymentDetail instance = null;

	public static CDBonusPaymentDetail getInstance() {
		if(instance == null) {
			instance = new CDBonusPaymentDetail("CDBonusPaymentDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField bonusPaymentRecordIdField;

	public CDBonusPaymentDetail(String dataSourceID) {

		setID(dataSourceID);
		bonusPaymentRecordIdField = new DataSourceIntegerField("bonusPaymentRecordId", "奖金发放记录编码");
		bonusPaymentRecordIdField.setRequired(false);
		bonusPaymentRecordIdField.setLength(11);
		bonusPaymentRecordIdField.setHidden(false);

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


		setFields(bonusPaymentRecordIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

