package com.pomplatform.client.minvocieapplydedaocor.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.minvocieapplydedaocor.datasource.CDMcontracticcccsprfiiibaadicrbbior;

public class McontracticcccsprfiiibaadicrbbiorSearchForm extends SearchForm
{


	private final TextItem contractIdItem;
	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;
	private final TextItem customerNameItem;
	private final SelectItem statusItem;
	private final TextItem projectCodeItem;
	private final TextItem remarkItem;
	private final TextItem flowStatusItem;
	private final TextItem infoCodeItem;
	private final CheckboxItem isSystemAddItem;
	private final CheckboxItem isFinishItem;
	private final TextItem businessTypeItem;
	private final TextItem applyRemarkItem;
	private final TextItem applicantIdItem;
	private final TextItem dutyParagraphItem;
	private final TextItem iaCustomerNameItem;
	private final TextItem customerPhoneItem;
	private final TextItem registeredAddressItem;
	private final TextItem bankNameItem;
	private final TextItem bankAccountItem;
	private final TextItem invoiceApplyStatusItem;

	public McontracticcccsprfiiibaadicrbbiorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMcontracticcccsprfiiibaadicrbbior.getInstance());
		contractIdItem = new TextItem("contractId", "主订单编码");
		contractIdItem.hide();
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setWidth("*");
		customerNameItem = new TextItem("customerName", "客户名称");
		customerNameItem.setWidth("*");
		statusItem = new SelectItem("status", "结算状态");
		statusItem.hide();
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_39"));
		projectCodeItem = new TextItem("projectCode", "项目编号");
		projectCodeItem.setWidth("*");
		remarkItem = new TextItem("remark", "备注");
		remarkItem.hide();
		flowStatusItem = new TextItem("flowStatus", "流转状态，默认为0表示可以提交到运营管理修改承接部门1表示可以提交到运营管理运营价格2表示可以提交到运营管理运营价格审核3表示审核完成");
		flowStatusItem.hide();
		infoCodeItem = new TextItem("infoCode", "信息编号");
		infoCodeItem.setWidth("*");
		isSystemAddItem = new CheckboxItem("isSystemAdd", "是否为erp系统添加  true 为系统添加  false 为数据导入");
		isSystemAddItem.hide();
		isFinishItem = new CheckboxItem("isFinish", "合同是否完成");
		isFinishItem.hide();
		businessTypeItem = new TextItem("businessType", "业务类别");
		businessTypeItem.hide();
		applyRemarkItem = new TextItem("applyRemark", "申请备注");
		applyRemarkItem.hide();
		applicantIdItem = new TextItem("applicantId", "申请人");
		applicantIdItem.hide();
		dutyParagraphItem = new TextItem("dutyParagraph", "税号");
		dutyParagraphItem.setWidth("*");
		iaCustomerNameItem = new TextItem("iaCustomerName", "联系人");
		iaCustomerNameItem.setWidth("*");
		customerPhoneItem = new TextItem("customerPhone", "联系电话");
		customerPhoneItem.setWidth("*");
		registeredAddressItem = new TextItem("registeredAddress", "注册地址");
		registeredAddressItem.setWidth("*");
		bankNameItem = new TextItem("bankName", "银行名称");
		bankNameItem.setWidth("*");
		bankAccountItem = new TextItem("bankAccount", "银行账号");
		bankAccountItem.setWidth("*");
		invoiceApplyStatusItem = new TextItem("invoiceApplyStatus", "申请状态  1申请中 2已处理 3已驳回");
		invoiceApplyStatusItem.hide();

		setItems(contractIdItem, contractCodeItem, contractNameItem, customerNameItem, statusItem, projectCodeItem, remarkItem, flowStatusItem, infoCodeItem, isSystemAddItem, isFinishItem, businessTypeItem, applyRemarkItem, applicantIdItem, dutyParagraphItem, iaCustomerNameItem, customerPhoneItem, registeredAddressItem, bankNameItem, bankAccountItem, invoiceApplyStatusItem);

		setNumCols(12);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
