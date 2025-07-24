package com.pomplatform.client.invoiceexpresitssccmisiior.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.invoiceexpresitssccmisiior.datasource.CDMinvoiceexpresitssccmisiior;

public class MinvoiceexpresitssccmisiiorSearchForm extends SearchForm {

	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;
	private final TextItem contractIdItem;
	private final TextItem clientNameItem;
	private final SelectItem courierTypeItem;
	private final DateTimeItem minCourierDateItem;
	private final DateTimeItem maxCourierDateItem;
	private final DateTimeItem minSignDateItem;
	private final DateTimeItem maxSignDateItem;
	private final TextItem telItem;
	private final SelectItem signStatusItem;
	private final TextItem signNameItem;
	private final TextItem courierNumberItem;
	private final TextItem mailingAddressItem;
	private final SelectItem invoiceTypeItem;
	private final SelectItem signItem;
	private final TextItem invoiceCodeItem;
	private final TextItem invoiceNumberItem;
	private final TextItem contactIdItem;
	private final BooleanItem showOrHideItem;

	public MinvoiceexpresitssccmisiiorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMinvoiceexpresitssccmisiior.getInstance());
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		contractNameItem = new TextItem("contractName", "主订单名称");
		contractNameItem.hide();
		contractIdItem = new TextItem("contractId", "主订单编码");
		contractIdItem.hide();
		clientNameItem = new TextItem("clientName", "联系人姓名");
		clientNameItem.hide();
		courierTypeItem = new SelectItem("courierType", "快递类型");
		courierTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_56"));
		courierTypeItem.hide();
		minCourierDateItem = new DateTimeItem("minCourierDate", "最早快递日期");
		minCourierDateItem.hide();
		minCourierDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, minCourierDateItem);
			}
		});
		maxCourierDateItem = new DateTimeItem("maxCourierDate", "最晚快递日期");
		maxCourierDateItem.hide();
		maxCourierDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, maxCourierDateItem);
			}
		});
		minSignDateItem = new DateTimeItem("minSignDate", "最早签收日期");
		minSignDateItem.hide();
		minSignDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, minSignDateItem);
			}
		});
		maxSignDateItem = new DateTimeItem("maxSignDate", "最晚签收日期");
		maxSignDateItem.hide();
		maxSignDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, maxSignDateItem);
			}
		});
		telItem = new TextItem("tel", "电话");
		telItem.hide();
		signStatusItem = new SelectItem("signStatus", "快递状态");
		signStatusItem.setValueMap("system_dictionary_57");
		signStatusItem.setWidth("*");
		signStatusItem.hide();
		signNameItem = new TextItem("signName", "签收签名");
		signNameItem.setWidth("*");
		signNameItem.hide();
		courierNumberItem = new TextItem("courierNumber", "快递单号");
		courierNumberItem.setWidth("*");
		mailingAddressItem = new TextItem("mailingAddress", "寄件地址");
		mailingAddressItem.setWidth("*");
		invoiceTypeItem = new SelectItem("invoiceType", "发票类型");
		invoiceTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_52"));
		invoiceTypeItem.setWidth("*");
		signItem = new SelectItem("sign", "发票状态");
		signItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_53"));
		signItem.setWidth("*");
		invoiceCodeItem = new TextItem("invoiceCode", "发票代码");
		invoiceCodeItem.setWidth("*");
		invoiceNumberItem = new TextItem("invoiceNumber", "发票号码");
		invoiceNumberItem.setWidth("*");
		contactIdItem = new TextItem("contactId", "联系人主键   对应  client 表 主键");
		contactIdItem.hide();

		showOrHideItem = new BooleanItem("showOrHide", "屏蔽发出快递14天以上且已经签收快递数据");
		showOrHideItem.setDefaultValue(true);
		showOrHideItem.setWidth("*");

		setItems(contractCodeItem, contractNameItem, contractIdItem, clientNameItem, courierTypeItem,
				minCourierDateItem, maxCourierDateItem, minSignDateItem, maxSignDateItem, telItem, signStatusItem,
				signNameItem, courierNumberItem, mailingAddressItem, invoiceTypeItem, signItem, invoiceCodeItem,
				invoiceNumberItem, contactIdItem, showOrHideItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
