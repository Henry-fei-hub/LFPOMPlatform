package com.pomplatform.client.attachment.form;

import java.util.Date;

import com.delicacy.client.data.ClientUtil;
import com.pomplatform.client.attachment.datasource.CDMcontractAttachmentCapitalCount;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;

public class McontractAttachmentCapitalCountSearchForm extends SearchForm {

	private final DateTimeItem minHappenDateItem;
	private final DateTimeItem maxHappenDateItem;
	private final DateItem beforeSettlementDateItem;
	private final DateItem afterSettlementDateItem;
	private final TextItem contractIdItem;
	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;
	private final TextItem contractStatusItem;
	private final TextItem contractTypeItem;
	private final TextItem attachmentAddressItem;
	private final TextItem attachmentCodeItem;
	private final TextItem attachmentManageIdItem;
	private final TextItem returnAmountItem;
	private final TextItem amountItem;
	private final TextItem attachmentNameItem;
	private final TextItem borrowMoneyItem;
	private final TextItem businessTypeItem;
	private final TextItem infoCodeItem;
	private final TextItem flowStatusItem;
	private final CheckboxItem isFinishItem;
	private final CheckboxItem isSystemAddItem;

	private final DateItem searchDateItem;

	public McontractAttachmentCapitalCountSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMcontractAttachmentCapitalCount.getInstance());
		minHappenDateItem = new DateTimeItem("minHappenDate", "最早发生日期");
		minHappenDateItem.hide();
		minHappenDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, minHappenDateItem);
			}
		});
		maxHappenDateItem = new DateTimeItem("maxHappenDate", "最晚发生日期");
		maxHappenDateItem.hide();
		maxHappenDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, maxHappenDateItem);
			}
		});
		beforeSettlementDateItem = new DateItem("beforeSettlementDate", "结算日期");
		beforeSettlementDateItem.hide();
		beforeSettlementDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, beforeSettlementDateItem);
			}
		});
		afterSettlementDateItem = new DateItem("afterSettlementDate", "结算日期");
		afterSettlementDateItem.hide();
		afterSettlementDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, afterSettlementDateItem);
			}
		});
		contractIdItem = new TextItem("contractId", "主订单编码");
		contractIdItem.hide();
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setWidth("*");
		contractStatusItem = new TextItem("contractStatus", "合同状态  0未启动、1待签署、2已签署、3未签搁置、4解除");
		contractStatusItem.hide();
		contractTypeItem = new TextItem("contractType", "合同类别");
		contractTypeItem.hide();
		attachmentAddressItem = new TextItem("attachmentAddress", "附件路径");
		attachmentAddressItem.hide();
		attachmentCodeItem = new TextItem("attachmentCode", "编号");
		attachmentCodeItem.hide();
		attachmentManageIdItem = new TextItem("attachmentManageId", "主键编码");
		attachmentManageIdItem.hide();
		returnAmountItem = new TextItem("returnAmount", "回款金额");
		returnAmountItem.hide();
		amountItem = new TextItem("amount", "金额");
		amountItem.hide();
		attachmentNameItem = new TextItem("attachmentName", "确认函名称");
		attachmentNameItem.setWidth("*");
		borrowMoneyItem = new TextItem("borrowMoney", "");
		borrowMoneyItem.hide();
		businessTypeItem = new TextItem("businessType", "业务类别");
		businessTypeItem.hide();
		infoCodeItem = new TextItem("infoCode", "信息编号");
		infoCodeItem.hide();
		flowStatusItem = new TextItem("flowStatus",
				"流转状态，默认为0表示可以提交到运营管理修改承接部门1表示可以提交到运营管理运营价格2表示可以提交到运营管理运营价格审核3表示审核完成");
		flowStatusItem.hide();
		isFinishItem = new CheckboxItem("isFinish", "合同是否完成");
		isFinishItem.hide();
		isSystemAddItem = new CheckboxItem("isSystemAdd", "是否为erp系统添加  true 为系统添加  false 为数据导入");
		isSystemAddItem.hide();

		searchDateItem = new DateItem("searchDate", "查询日期(按月统计)");
		searchDateItem.setWidth("*");
		searchDateItem.setDefaultValue(new Date());
		searchDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, searchDateItem);
			}
		});
		setItems(minHappenDateItem, maxHappenDateItem, beforeSettlementDateItem, afterSettlementDateItem,
				contractIdItem, contractCodeItem, contractNameItem, contractStatusItem, contractTypeItem,
				attachmentAddressItem, attachmentCodeItem, attachmentManageIdItem, returnAmountItem, amountItem,
				attachmentNameItem, borrowMoneyItem, businessTypeItem, infoCodeItem, flowStatusItem, isFinishItem,
				isSystemAddItem, searchDateItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
