package com.pomplatform.client.selectgrid.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.selectgrid.datasource.CDSelectGridInvoiceTypeValue;

public class SelectGridInvoiceTypeValueSearchForm extends SearchForm
{


	private final TextItem typeNameItem;
	private final TextItem subtractRemarkItem;
	private final TextItem invoiceTypeIdItem;

	public SelectGridInvoiceTypeValueSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSelectGridInvoiceTypeValue.getInstance());
		typeNameItem = new TextItem("typeName", "类型名称");
		subtractRemarkItem = new TextItem("subtractRemark", "扣除");
		invoiceTypeIdItem = new TextItem("invoiceTypeId", "主键");

		setItems(typeNameItem, subtractRemarkItem, invoiceTypeIdItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
