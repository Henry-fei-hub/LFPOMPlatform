package com.pomplatform.client.purchase.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.purchase.datasource.CDOnLoadProductInquirySupplierDetail;

public class OnLoadProductInquirySupplierDetailSearchForm extends SearchForm
{


	private final TextItem priorityLevelItem;
	private final TextItem remarkItem;
	private final TextItem supplierContactIdItem;
	private final TextItem productInquirySupplierDetailIdItem;
	private final TextItem supplierIdItem;
	private final TextItem productInquiryDetailIdItem;
	private final TextItem operatorIdItem;

	public OnLoadProductInquirySupplierDetailSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLoadProductInquirySupplierDetail.getInstance());
		priorityLevelItem = new TextItem("priorityLevel", "优先级别");
		remarkItem = new TextItem("remark", "备注");
		supplierContactIdItem = new TextItem("supplierContactId", "供应商联系人主键");
		productInquirySupplierDetailIdItem = new TextItem("productInquirySupplierDetailId", "主键");
		supplierIdItem = new TextItem("supplierId", "供应商主键");
		productInquiryDetailIdItem = new TextItem("productInquiryDetailId", "询价详情表主键");
		operatorIdItem = new TextItem("operatorId", "操作人");

		setItems(priorityLevelItem, remarkItem, supplierContactIdItem, productInquirySupplierDetailIdItem, supplierIdItem, productInquiryDetailIdItem, operatorIdItem);

		setNumCols(14);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
