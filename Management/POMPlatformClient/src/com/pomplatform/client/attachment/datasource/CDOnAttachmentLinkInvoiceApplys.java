package com.pomplatform.client.attachment.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnAttachmentLinkInvoiceApplys extends DataSource
{


	public static CDOnAttachmentLinkInvoiceApplys instance = null;

	public static CDOnAttachmentLinkInvoiceApplys getInstance() {
		if(instance == null) {
			instance = new CDOnAttachmentLinkInvoiceApplys("CDOnAttachmentLinkInvoiceApplys");
		}
		return instance;
	}

	private final DataSourceIntegerField personnelBusinessIdField;
	private final DataSourceIntegerField contractIdField;

	public CDOnAttachmentLinkInvoiceApplys(String dataSourceID) {

		setID(dataSourceID);
		personnelBusinessIdField = new DataSourceIntegerField("personnelBusinessId", "流程主表编码");
		personnelBusinessIdField.setRequired(false);
		personnelBusinessIdField.setLength(11);
		personnelBusinessIdField.setHidden(false);

		contractIdField = new DataSourceIntegerField("contractId", "主订单编码");
		contractIdField.setRequired(true);
		contractIdField.setLength(11);
		contractIdField.setPrimaryKey(true);
		contractIdField.setHidden(true);

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


		setFields(personnelBusinessIdField, contractIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

