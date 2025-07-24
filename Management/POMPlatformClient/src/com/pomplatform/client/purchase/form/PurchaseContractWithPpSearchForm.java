package com.pomplatform.client.purchase.form;

import java.util.Date;

import com.delicacy.client.data.ClientUtil;
import com.pomplatform.client.purchase.datasource.CDPurchaseContractWithPp;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;

public class PurchaseContractWithPpSearchForm extends SearchForm {

	private final DateItem minContractDateItem;
	private final DateItem maxContractDateItem;
	private final TextItem purchaseContractIdItem;
	private final TextItem supplierIdItem;
	private final TextItem purchasePersonItem;
	private final TextItem mainProjectIdItem;
	private final TextItem afterSaleRequirementsItem;
	private final TextItem personnelBusinessIdItem;
	private final TextItem contractNameItem;
	private final TextItem contractCodeItem;
	private final TextItem qualityAssuranceItem;
	private final TextItem termOfPaymentItem;
	private final TextItem projectNameItem;
	private final TextItem projectCodeItem;
	private final TextItem supplierNameItem;
	private final TextItem majorContactPersonItem;

	public PurchaseContractWithPpSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDPurchaseContractWithPp.getInstance());
		minContractDateItem = new DateItem("minContractDate", "最早合同签订日期");
		minContractDateItem.setWidth("*");
		minContractDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, minContractDateItem);
			}
		});
		maxContractDateItem = new DateItem("maxContractDate", "最晚合同签订日期");
		maxContractDateItem.setWidth("*");
		maxContractDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, maxContractDateItem);
			}
		});
		purchaseContractIdItem = new TextItem("purchaseContractId", "主键");
		purchaseContractIdItem.hide();
		supplierIdItem = new TextItem("supplierId", "供应商编码");
		supplierIdItem.hide();
		purchasePersonItem = new TextItem("purchasePerson", "订购人");
		purchasePersonItem.hide();
		mainProjectIdItem = new TextItem("mainProjectId", "项目");
		mainProjectIdItem.hide();
		afterSaleRequirementsItem = new TextItem("afterSaleRequirements", "售后要求");
		afterSaleRequirementsItem.hide();
		personnelBusinessIdItem = new TextItem("personnelBusinessId", "流程业务表主键");
		personnelBusinessIdItem.hide();
		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.hide();
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");

		qualityAssuranceItem = new TextItem("qualityAssurance", "质保");
		qualityAssuranceItem.hide();

		termOfPaymentItem = new TextItem("termOfPayment", "付款条件");
		termOfPaymentItem.setWidth("*");

		projectNameItem = new TextItem("projectName", "项目名称");
		projectNameItem.setWidth("*");

		projectCodeItem = new TextItem("projectCode", "项目编号");
		projectCodeItem.setWidth("*");
		supplierNameItem = new TextItem("supplierName", "供应商名称");
		supplierNameItem.setWidth("*");
		majorContactPersonItem = new TextItem("majorContactPerson", "主要联系人");
		majorContactPersonItem.hide();

		setItems(minContractDateItem, maxContractDateItem, purchaseContractIdItem, supplierIdItem, purchasePersonItem,
				mainProjectIdItem, afterSaleRequirementsItem, personnelBusinessIdItem, contractNameItem,
				contractCodeItem, qualityAssuranceItem, termOfPaymentItem, projectNameItem, projectCodeItem,
				supplierNameItem, majorContactPersonItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
