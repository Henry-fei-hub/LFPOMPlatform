package com.pomplatform.client.purchase.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.purchase.datasource.CDSpurchasepaymentor;

public class SpurchasepaymentorSearchForm extends SearchForm {

	private final DateTimeItem minCreateTimeItem;
	private final DateTimeItem maxCreateTimeItem;
	private final TextItem purchaseContractIdItem;
	private final TextItem purchasePaymentStatusItem;
	private final TextItem personInChargeItem;
	private final TextItem operatorIdItem;
	private final TextItem paymentConditionItem;
	private final TextItem remarkItem;
	private final TextItem paymentNameItem;
	private final DateItem minPaymentDateItem;
	private final DateItem maxPaymentDateItem;
	private final TextItem purchasePaymentIdItem;
	private final TextItem personnelBusinessIdItem;
	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;
	private final TextItem projectNameItem;
	private final TextItem projectCodeItem;
	private final TextItem mainProjectIdItem;
	private final TextItem supplierNameItem;
	private final TextItem supplierIdItem;
	private final TextItem majorContactPersonItem;

	public SpurchasepaymentorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSpurchasepaymentor.getInstance());
		minCreateTimeItem = new DateTimeItem("minCreateTime", "最早创建时间");
		minCreateTimeItem.hide();
		minCreateTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, minCreateTimeItem);
			}
		});
		maxCreateTimeItem = new DateTimeItem("maxCreateTime", "最晚创建时间");
		maxCreateTimeItem.hide();
		maxCreateTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, maxCreateTimeItem);
			}
		});
		purchaseContractIdItem = new TextItem("purchaseContractId", "采购合同表主键");
		purchaseContractIdItem.hide();
		purchasePaymentStatusItem = new TextItem("purchasePaymentStatus", "流程状态 0新建 3通过审批完成");
		purchasePaymentStatusItem.hide();
		personInChargeItem = new TextItem("personInCharge", "负责人");
		personInChargeItem.hide();
		operatorIdItem = new TextItem("operatorId", "操作人");
		operatorIdItem.hide();
		
		paymentConditionItem = new TextItem("paymentCondition", "付款条件");
		paymentConditionItem.setWidth("*");
		
		remarkItem = new TextItem("remark", "备注");
		remarkItem.setWidth("*");
		
		paymentNameItem = new TextItem("paymentName", "款项名称");
		paymentNameItem.setWidth("*");
		
		
		minPaymentDateItem = new DateItem("minPaymentDate", "最早计划付款日期");
		minPaymentDateItem.setWidth("*");
		minPaymentDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, minPaymentDateItem);
			}
		});
		maxPaymentDateItem = new DateItem("maxPaymentDate", "最晚计划付款日期");
		maxPaymentDateItem.setWidth("*");
		maxPaymentDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, maxPaymentDateItem);
			}
		});
		purchasePaymentIdItem = new TextItem("purchasePaymentId", "主键");
		purchasePaymentIdItem.hide();
		personnelBusinessIdItem = new TextItem("personnelBusinessId", "流程表主键");
		personnelBusinessIdItem.hide();
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		
		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.hide();
		
		projectNameItem = new TextItem("projectName", "项目名称");
		projectNameItem.setWidth("*");
		projectCodeItem = new TextItem("projectCode", "项目编号");
		projectCodeItem.setWidth("*");
		
		mainProjectIdItem = new TextItem("mainProjectId", "主键编码");
		mainProjectIdItem.hide();
		
		supplierNameItem = new TextItem("supplierName", "供应商名称");
		supplierNameItem.setWidth("*");
		
		supplierIdItem = new TextItem("supplierId", "主键编码");
		supplierIdItem.hide();
		
		majorContactPersonItem = new TextItem("majorContactPerson", "主要联系人");
		majorContactPersonItem.hide();

		setItems(minCreateTimeItem, maxCreateTimeItem, purchaseContractIdItem, purchasePaymentStatusItem,
				personInChargeItem, operatorIdItem, paymentConditionItem, remarkItem, paymentNameItem,
				minPaymentDateItem, maxPaymentDateItem, purchasePaymentIdItem, personnelBusinessIdItem,
				contractCodeItem, contractNameItem, projectNameItem, projectCodeItem, mainProjectIdItem,
				supplierNameItem, supplierIdItem, majorContactPersonItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
