package com.pomplatform.client.attachment.form;

import java.util.Date;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.attachment.datasource.CDMcontractcacccccaaaraabbifiior;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;

public class McontractcacccccaaaraabbifiiorSearchForm extends SearchForm {

	private final TextItem contractIdItem;
	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;
	//private final TextItem contractStatusItem;
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
	private final ComboBoxItem employeeIdItem;
	private final CheckboxItem checkAmountItem;
	private final CheckboxItem haveAttachmentItem;
	private final CheckboxItem contractInfoAuditedItem;
	private final DateItem searchDateItem;
	private final DateItem minHappenDateItem;
	private final DateItem maxHappenDateItem;
	private final SelectItem contractStatusItem;

	public McontractcacccccaaaraabbifiiorSearchForm() {
		setWidth("97%");
		setHeight100();
		setDataSource(CDMcontractcacccccaaaraabbifiior.getInstance());
		contractIdItem = new TextItem("contractId", "合同编码");
		contractIdItem.hide();
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setWidth("*");
//		contractStatusItem = new TextItem("contractStatus", "合同状态  0未启动、1待签署、2已签署、3未签搁置、4解除");
//		contractStatusItem.hide();
		contractTypeItem = new TextItem("contractType", "合同类别");
		contractTypeItem.hide();
		attachmentAddressItem = new TextItem("attachmentAddress", "附件路径");
		attachmentAddressItem.hide();
		attachmentCodeItem = new TextItem("attachmentCode", "确认函编号编号");
		attachmentCodeItem.hide();
		attachmentManageIdItem = new TextItem("attachmentManageId", "主键编码");
		attachmentManageIdItem.hide();
		returnAmountItem = new TextItem("returnAmount", "回款金额");
		returnAmountItem.hide();
		amountItem = new TextItem("amount", "金额");
		amountItem.hide();
		attachmentNameItem = new TextItem("attachmentName", "附件名称");
		attachmentNameItem.setWidth("*");
		borrowMoneyItem = new TextItem("borrowMoney", "回款金额");
		borrowMoneyItem.setWidth("*");
		businessTypeItem = new TextItem("businessType", "业务类别");
		businessTypeItem.hide();
		infoCodeItem = new TextItem("infoCode", "信息编号");
		infoCodeItem.setWidth("*");
		infoCodeItem.setHidden(true);
		flowStatusItem = new TextItem("flowStatus",
				"流转状态，默认为0表示可以提交到运营管理修改承接部门1表示可以提交到运营管理运营价格2表示可以提交到运营管理运营价格审核3表示审核完成");
		flowStatusItem.hide();
		isFinishItem = new CheckboxItem("isFinish", "合同是否完成");
		isFinishItem.hide();
		isSystemAddItem = new CheckboxItem("isSystemAdd", "是否为erp系统添加  true 为系统添加  false 为数据导入");
		isSystemAddItem.hide();
		
		employeeIdItem = new ComboBoxItem("employeeId", "项目经理");
		employeeIdItem.setChangeOnKeypress(false);
		employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		employeeIdItem.setWidth("*");
		
		checkAmountItem = new CheckboxItem("checkAmount", "回款是否相等");
		checkAmountItem.setWidth("*");
		
		haveAttachmentItem = new CheckboxItem("haveAttachment", "是否有确认函");
		haveAttachmentItem.setWidth("*");
		
		contractInfoAuditedItem = new CheckboxItem("contractInfoAudited", "合同信息无误");
		contractInfoAuditedItem.setWidth("*");
		
		searchDateItem = new DateItem("searchDate", "查询日期(按月统计)");
		searchDateItem.setWidth("*");
		searchDateItem.setDefaultValue(new Date());
		searchDateItem.hide();
		searchDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, searchDateItem);
			}
		});
		
		contractStatusItem=new SelectItem("contractStatusM","合同状态");
		contractStatusItem.setMultiple(true);
		contractStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_35"));
		contractStatusItem.setWidth("*");
		
		minHappenDateItem = new DateItem("minHappenDate", "当期（开始日期）");
		minHappenDateItem.setWidth("*");
		minHappenDateItem.setUseMask(true);
		minHappenDateItem.setUseTextField(true);
		
		maxHappenDateItem = new DateItem("maxHappenDate", "当期（结束日期）");
		maxHappenDateItem.setWidth("*");
		maxHappenDateItem.setUseMask(true);
		maxHappenDateItem.setUseTextField(true);
		
		setItems(contractIdItem, contractCodeItem, contractNameItem, contractStatusItem, contractTypeItem,
				attachmentAddressItem, attachmentCodeItem, attachmentManageIdItem, returnAmountItem, amountItem,
				attachmentNameItem, borrowMoneyItem, businessTypeItem, infoCodeItem, flowStatusItem, isFinishItem,
				isSystemAddItem, employeeIdItem, checkAmountItem, haveAttachmentItem, searchDateItem,
				minHappenDateItem, maxHappenDateItem, contractInfoAuditedItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
