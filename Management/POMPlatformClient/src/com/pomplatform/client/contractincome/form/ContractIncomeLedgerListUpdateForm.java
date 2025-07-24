package com.pomplatform.client.contractincome.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.contractincome.datasource.DSContractIncomeLedgerList;

public class ContractIncomeLedgerListUpdateForm extends AbstractWizadPage
{


	private final TextItem contractIncomeLedgerIdItem;
	private final SelectItem contractIdItem;
	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;
	private final ComboBoxItem companyIdItem;
	private final ComboBoxItem clientIdItem;
	private final ComboBoxItem projectManagerItem;
	private final ComboBoxItem plateManagerItem;
	private final DoubleItem signingMoneySumItem;
	private final DoubleItem receiveContractAmountItem;
	private final DoubleItem unreceivedContractAmountItem;
	private final TextItem invoiceDateItem;
	private final TextItem invoiceNumberItem;
	private final TextItem invoiceStageItem;
	private final DoubleItem invoiceAmountItem;
	private final DoubleItem currentReceiveAmountItem;
	private final TextItem currentReceiveDateItem;
	private final TextItem currentReceiveRemarkItem;
	private final TextItem projectStatusItem;
	private final TextItem remarkItem;
	private final TextItem contactsItem;
	private final TextItem ledgerYearItem;
	private final TextItem ledgerMonthItem;
	private final DateTimeItem createTimeItem;
	private final DateTimeItem updateTimeItem;
	private final CheckboxItem isLockedItem;
	private final TextItem incomeLedgerNumberItem;

	public ContractIncomeLedgerListUpdateForm() {
		DSContractIncomeLedgerList ds = DSContractIncomeLedgerList.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		contractIncomeLedgerIdItem = new TextItem("contractIncomeLedgerId", "主键编码");
		contractIncomeLedgerIdItem.setDisabled(true);
		contractIncomeLedgerIdItem.setRequired(true);
		IsIntegerValidator contractIncomeLedgerIdValidator = new IsIntegerValidator();
		contractIncomeLedgerIdItem.setValidators(contractIncomeLedgerIdValidator);
		contractIncomeLedgerIdItem.setHidden(true);
		__formItems.add(contractIncomeLedgerIdItem);
		
		contractIdItem = new SelectItem("contractId", "合同编码");
		contractIdItem.setHidden(true);
		__formItems.add(contractIdItem);
		
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		__formItems.add(contractCodeItem);
		
		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setWidth("*");
		__formItems.add(contractNameItem);
		
		companyIdItem = new ComboBoxItem("companyId", "合同签约公司");
		companyIdItem.setWidth("*");
		KeyValueManager.loadValueMap("system_dictionary_26", companyIdItem);
		__formItems.add(companyIdItem);
		
		clientIdItem = new ComboBoxItem("clientId", "客户");
		clientIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		KeyValueManager.loadValueMap("customers", clientIdItem);
		clientIdItem.setWidth("*");
		__formItems.add(clientIdItem);
		
		
		projectManagerItem = new ComboBoxItem("projectManager", "项目经理");
		projectManagerItem.setWidth("*");
		KeyValueManager.loadValueMap("employee_names", projectManagerItem);
		__formItems.add(projectManagerItem);
		
		
		plateManagerItem = new ComboBoxItem("plateManager", "项目负责人");
		plateManagerItem.setWidth("*");
		KeyValueManager.loadValueMap("employee_names", plateManagerItem);
		__formItems.add(plateManagerItem);
		
		
		
		signingMoneySumItem = new DoubleItem("signingMoneySum", "合同签约金额");
		signingMoneySumItem.setWidth("*");
		signingMoneySumItem.setFormat("##,###,###,###,##0.00");
		__formItems.add(signingMoneySumItem);
		
		
		
		receiveContractAmountItem = new DoubleItem("receiveContractAmount", "累计收款");
		receiveContractAmountItem.setWidth("*");
		receiveContractAmountItem.setFormat("##,###,###,###,##0.00");
		__formItems.add(receiveContractAmountItem);
		
		
		unreceivedContractAmountItem = new DoubleItem("unreceivedContractAmount", "未收款");
		unreceivedContractAmountItem.setWidth("*");
		unreceivedContractAmountItem.setFormat("##,###,###,###,##0.00");
		__formItems.add(unreceivedContractAmountItem);
		
		
		
		invoiceDateItem = new TextItem("invoiceDate", "开票日期");
		invoiceDateItem.setWidth("*");
		__formItems.add(invoiceDateItem);
		
		
		
		
		invoiceNumberItem = new TextItem("invoiceNumber", "发票号码");
		invoiceNumberItem.setWidth("*");
		__formItems.add(invoiceNumberItem);
		
		
		invoiceStageItem = new TextItem("invoiceStage", "开票阶段");
		invoiceStageItem.setWidth("*");
		__formItems.add(invoiceStageItem);
		
		
		invoiceAmountItem = new DoubleItem("invoiceAmount", "开票金额");
		invoiceStageItem.setWidth("*");
		invoiceAmountItem.setFormat("##,###,###,###,##0.00");
		__formItems.add(invoiceAmountItem);
		
		
		
		currentReceiveAmountItem = new DoubleItem("currentReceiveAmount", "当月收款金额");
		currentReceiveAmountItem.setWidth("*");
		currentReceiveAmountItem.setFormat("##,###,###,###,##0.00");
		__formItems.add(currentReceiveAmountItem);
		
		
		currentReceiveDateItem = new TextItem("currentReceiveDate", "当月收款日期");
		currentReceiveDateItem.setWidth("*");
		__formItems.add(currentReceiveDateItem);
		
		
		currentReceiveRemarkItem = new TextItem("currentReceiveRemark", "当月收款备注");
		currentReceiveRemarkItem.setWidth("*");
		__formItems.add(currentReceiveRemarkItem);
		
		
		
		projectStatusItem = new TextItem("projectStatus", "项目状态");
		projectStatusItem.setWidth("*");
		__formItems.add(projectStatusItem);
		
		
		remarkItem = new TextItem("remark", "备注");
		remarkItem.setWidth("*");
		__formItems.add(remarkItem);
		
		
		
		contactsItem = new TextItem("contacts", "联系人");
		contactsItem.setWidth("*");
		__formItems.add(contactsItem);
		
		
		ledgerYearItem = new TextItem("ledgerYear", "台账年份");
		ledgerYearItem.setWidth("*");
		__formItems.add(ledgerYearItem);
		
		
		ledgerMonthItem = new TextItem("ledgerMonth", "台账月份");
		ledgerMonthItem.setWidth("*");
		__formItems.add(ledgerMonthItem);
		
		
		createTimeItem = new DateTimeItem("createTime", "创建时间");
		createTimeItem.setWidth("*");
		__formItems.add(createTimeItem);
		
		updateTimeItem = new DateTimeItem("updateTime", "修改时间");
		updateTimeItem.setWidth("*");
		__formItems.add(updateTimeItem);
		
		
		isLockedItem = new CheckboxItem("isLocked", "是否锁定");
		isLockedItem.setWidth("*");
		__formItems.add(isLockedItem);
		
		incomeLedgerNumberItem = new TextItem("incomeLedgerNumber", "收入台账序号");
		incomeLedgerNumberItem.setWidth("*");
		__formItems.add(incomeLedgerNumberItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(8);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		setPageMode(PAGE_MODE_UPDATE);
		addMember(__form);
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSContractIncomeLedgerList.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
