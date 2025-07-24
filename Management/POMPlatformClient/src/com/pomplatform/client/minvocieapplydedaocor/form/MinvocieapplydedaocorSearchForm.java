package com.pomplatform.client.minvocieapplydedaocor.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.minvocieapplydedaocor.datasource.CDMinvocieapplydedaocor;

public class MinvocieapplydedaocorSearchForm extends SearchForm
{


	private final DateTimeItem minOperatorTimeItem;
	private final DateTimeItem maxOperatorTimeItem;
	private final DateTimeItem minApplyTimeItem;
	private final DateTimeItem maxApplyTimeItem;
	private final TextItem invoiceApplyIdItem;
	private final TextItem applicantDeparmentIdItem;
	private final TextItem applicantNameItem;
	private final TextItem operatorNameItem;
	private final ComboBoxItem applicantIdItem;
	private final ComboBoxItem operatorIdItem;
	private final TextItem departmentNameItem;
	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;
	private final TextItem contractIdItem;
	private final TextItem bankNameItem;
	private final TextItem bankAccountItem;
	private final SelectItem invoiceTypeItem;
	private final SelectItem invoiceApplyStatusItem;
	private final TextItem dutyParagraphItem;
	private final TextItem applyRemarkItem;
	private final TextItem operatorRemarkItem;
	private final TextItem companyNameItem;

	public MinvocieapplydedaocorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMinvocieapplydedaocor.getInstance());
		minOperatorTimeItem = new DateTimeItem("minOperatorTime", "最早操作时间");
		minOperatorTimeItem.setWidth("*");
		minOperatorTimeItem.setHidden(true);
		minOperatorTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, minOperatorTimeItem);
			}
		});
		maxOperatorTimeItem = new DateTimeItem("maxOperatorTime", "最晚操作时间");
		maxOperatorTimeItem.setWidth("*");
		maxOperatorTimeItem.setHidden(true);
		maxOperatorTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, maxOperatorTimeItem);
			}
		});
		minApplyTimeItem = new DateTimeItem("minApplyTime", "最早申请时间");
		minApplyTimeItem.setWidth("*");
		minApplyTimeItem.setHidden(true);
		minApplyTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, minApplyTimeItem);
			}
		});
		maxApplyTimeItem = new DateTimeItem("maxApplyTime", "最晚申请时间");
		maxApplyTimeItem.setWidth("*");
		maxApplyTimeItem.setHidden(true);
		maxApplyTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, maxApplyTimeItem);
			}
		});
		invoiceApplyIdItem = new TextItem("invoiceApplyId", "主键");
		invoiceApplyIdItem.setWidth("*");
		invoiceApplyIdItem.setHidden(true);
		applicantDeparmentIdItem = new TextItem("applicantDeparmentId", "申请人部门");
		applicantDeparmentIdItem.setWidth("*");
		applicantDeparmentIdItem.setHidden(true);
		applicantNameItem = new TextItem("applicantName", "申请人");
		applicantNameItem.setWidth("*");
		applicantNameItem.setHidden(true);
		
		operatorNameItem = new TextItem("operatorName", "操作人");
		operatorNameItem.setWidth("*");
		operatorNameItem.setHidden(true);
		
		applicantIdItem = new ComboBoxItem("applicantId", "申请人");
		applicantIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		applicantIdItem.setWidth("*");
		
		operatorIdItem = new ComboBoxItem("operatorId", "操作人");
		operatorIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		operatorIdItem.setWidth("*");
		
		
		departmentNameItem = new TextItem("departmentName", "部门名称");
		departmentNameItem.setWidth("*");
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setWidth("*");
		contractIdItem = new TextItem("contractId", "合同编码");
		contractIdItem.setHidden(true);
		bankNameItem = new TextItem("bankName", "开户银行");
		bankNameItem.setWidth("*");
		bankAccountItem = new TextItem("bankAccount", "银行账号");
		bankAccountItem.setWidth("*");
		invoiceTypeItem = new SelectItem("invoiceType", "发票类型");
		invoiceTypeItem.setWidth("*");
		invoiceTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_52"));
		invoiceApplyStatusItem = new SelectItem("invoiceApplyStatus", "申请状态 ");
		invoiceApplyStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_61"));
		invoiceApplyStatusItem.setWidth("*");
		dutyParagraphItem = new TextItem("dutyParagraph", "税号");
		dutyParagraphItem.setWidth("*");
		applyRemarkItem = new TextItem("applyRemark", "申请备注");
		applyRemarkItem.setWidth("*");
		operatorRemarkItem = new TextItem("operatorRemark", "操作人备注");
		operatorRemarkItem.setWidth("*");
		operatorRemarkItem.setHidden(true);
		companyNameItem = new TextItem("companyName", "单位全称");
		companyNameItem.setWidth("*");

		setItems(minOperatorTimeItem, maxOperatorTimeItem, minApplyTimeItem, maxApplyTimeItem, invoiceApplyIdItem, applicantDeparmentIdItem, applicantNameItem, operatorNameItem, applicantIdItem, operatorIdItem, departmentNameItem, contractCodeItem, contractNameItem, contractIdItem, bankNameItem, bankAccountItem, invoiceTypeItem, invoiceApplyStatusItem, dutyParagraphItem, applyRemarkItem, operatorRemarkItem, companyNameItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
