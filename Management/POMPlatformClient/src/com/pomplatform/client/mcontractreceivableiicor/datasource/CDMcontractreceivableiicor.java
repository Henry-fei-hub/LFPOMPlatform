package com.pomplatform.client.mcontractreceivableiicor.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMcontractreceivableiicor extends DataSource
{


	public static CDMcontractreceivableiicor instance = null;

	public static CDMcontractreceivableiicor getInstance() {
		if(instance == null) {
			instance = new CDMcontractreceivableiicor("CDMcontractreceivableiicor");
		}
		return instance;
	}

	private final DataSourceIntegerField invoiceApplyIdField;
	private final DataSourceIntegerField contractIdField;

	public CDMcontractreceivableiicor(String dataSourceID) {

		setID(dataSourceID);
		invoiceApplyIdField = new DataSourceIntegerField("invoiceApplyId", "申请发票表ID");
		invoiceApplyIdField.setRequired(false);
		invoiceApplyIdField.setLength(11);
		invoiceApplyIdField.setHidden(false);

		contractIdField = new DataSourceIntegerField("contractId", "合同id");
		contractIdField.setRequired(false);
		contractIdField.setLength(11);
		contractIdField.setHidden(false);

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


		setFields(invoiceApplyIdField, contractIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

