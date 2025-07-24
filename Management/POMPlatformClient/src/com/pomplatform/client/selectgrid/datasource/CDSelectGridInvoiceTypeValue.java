package com.pomplatform.client.selectgrid.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSelectGridInvoiceTypeValue extends DataSource
{


	public static CDSelectGridInvoiceTypeValue instance = null;

	public static CDSelectGridInvoiceTypeValue getInstance() {
		if(instance == null) {
			instance = new CDSelectGridInvoiceTypeValue("CDSelectGridInvoiceTypeValue");
		}
		return instance;
	}

	private final DataSourceTextField typeNameField;
	private final DataSourceTextField subtractRemarkField;
	private final DataSourceIntegerField invoiceTypeIdField;

	public CDSelectGridInvoiceTypeValue(String dataSourceID) {

		setID(dataSourceID);
		typeNameField = new DataSourceTextField("typeName", "类型名称");
		typeNameField.setRequired(false);
		typeNameField.setLength(255);
		typeNameField.setHidden(false);

		subtractRemarkField = new DataSourceTextField("subtractRemark", "扣除");
		subtractRemarkField.setRequired(false);
		subtractRemarkField.setLength(255);
		subtractRemarkField.setHidden(false);

		invoiceTypeIdField = new DataSourceIntegerField("invoiceTypeId", "主键");
		invoiceTypeIdField.setRequired(true);
		invoiceTypeIdField.setLength(11);
		invoiceTypeIdField.setPrimaryKey(true);
		invoiceTypeIdField.setHidden(true);

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


		setFields(typeNameField, subtractRemarkField, invoiceTypeIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

