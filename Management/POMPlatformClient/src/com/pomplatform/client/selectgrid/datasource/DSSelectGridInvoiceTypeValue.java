package com.pomplatform.client.selectgrid.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSelectGridInvoiceTypeValue extends DBDataSource
{


	public static DSSelectGridInvoiceTypeValue instance = null;

	public static DSSelectGridInvoiceTypeValue getInstance() {
		if(instance == null) {
			instance = new DSSelectGridInvoiceTypeValue("DSSelectGridInvoiceTypeValue");
		}
		return instance;
	}

	private final DataSourceIntegerField invoiceTypeIdField;
	private final DataSourceTextField typeNameField;
	private final DataSourceTextField subtractRemarkField;
	private final DataSourceIntegerField taxRateField;
	private final DataSourceIntegerField creatorField;
	private final DataSourceDateTimeField createTimeField;

	public DSSelectGridInvoiceTypeValue(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("SelectGridInvoiceTypeValue");


		invoiceTypeIdField = new DataSourceIntegerField("invoiceTypeId", "主键");
		invoiceTypeIdField.setLength(11);
		invoiceTypeIdField.setPrimaryKey(true);
		invoiceTypeIdField.setRequired(true);
		invoiceTypeIdField.setHidden(false);


		typeNameField = new DataSourceTextField("typeName", "类型名称");
		typeNameField.setLength(255);
		typeNameField.setRequired(false);
		typeNameField.setHidden(false);


		subtractRemarkField = new DataSourceTextField("subtractRemark", "扣除");
		subtractRemarkField.setLength(255);
		subtractRemarkField.setRequired(false);
		subtractRemarkField.setHidden(false);


		taxRateField = new DataSourceIntegerField("taxRate", "税率");
		taxRateField.setLength(11);
		taxRateField.setRequired(false);
		taxRateField.setHidden(false);


		creatorField = new DataSourceIntegerField("creator", "创建人");
		creatorField.setLength(11);
		creatorField.setRequired(false);
		creatorField.setHidden(false);


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);


		setFields(invoiceTypeIdField, typeNameField, subtractRemarkField, taxRateField, creatorField, createTimeField);
	}


}

