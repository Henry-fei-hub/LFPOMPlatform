package com.pomplatform.client.contractincome.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.contractincome.datasource.DSContractIncomeLedgerList;

public class ContractIncomeLedgerListNewForm extends AbstractWizadPage
{


	private final SelectItem contractIdItem;
	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;
	private final SelectItem companyIdItem;
	private final SelectItem clientIdItem;
	private final TextItem customerNameItem;
	private final TextItem projectManagerItem;
	private final TextItem plateManagerItem;
	private final TextItem signingMoneySumItem;
	private final TextItem receiveContractAmountItem;
	private final TextItem unreceivedContractAmountItem;
	private final TextItem invoiceDateItem;
	private final TextItem invoiceNumberItem;
	private final TextItem invoiceStageItem;
	private final TextItem invoiceAmountItem;
	private final TextItem currentReceiveAmountItem;
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

	public ContractIncomeLedgerListNewForm() {
		DSContractIncomeLedgerList ds = DSContractIncomeLedgerList.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		contractIdItem = new SelectItem("contractId", "合同编码");
		contractIdItem.setValueMap(KeyValueManager.getValueMap("contracts"));
		__formItems.add(contractIdItem);
		contractCodeItem = new TextItem("contractCode", "合同编号");
		__formItems.add(contractCodeItem);
		contractNameItem = new TextItem("contractName", "合同名称");
		__formItems.add(contractNameItem);
		companyIdItem = new SelectItem("companyId", "合同签约公司");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		__formItems.add(companyIdItem);
		clientIdItem = new SelectItem("clientId", "客户");
		clientIdItem.setValueMap(KeyValueManager.getValueMap("customers"));
		__formItems.add(clientIdItem);
		customerNameItem = new TextItem("customerName", "客户名称");
		__formItems.add(customerNameItem);
		projectManagerItem = new TextItem("projectManager", "项目经理");
		__formItems.add(projectManagerItem);
		plateManagerItem = new TextItem("plateManager", "项目负责人");
		__formItems.add(plateManagerItem);
		signingMoneySumItem = new TextItem("signingMoneySum", "合同签约金额");
		__formItems.add(signingMoneySumItem);
		receiveContractAmountItem = new TextItem("receiveContractAmount", "累计收款");
		__formItems.add(receiveContractAmountItem);
		unreceivedContractAmountItem = new TextItem("unreceivedContractAmount", "未收款");
		__formItems.add(unreceivedContractAmountItem);
		invoiceDateItem = new TextItem("invoiceDate", "开票日期");
		__formItems.add(invoiceDateItem);
		invoiceNumberItem = new TextItem("invoiceNumber", "发票号码");
		__formItems.add(invoiceNumberItem);
		invoiceStageItem = new TextItem("invoiceStage", "开票阶段");
		__formItems.add(invoiceStageItem);
		invoiceAmountItem = new TextItem("invoiceAmount", "开票金额");
		__formItems.add(invoiceAmountItem);
		currentReceiveAmountItem = new TextItem("currentReceiveAmount", "当月收款金额");
		__formItems.add(currentReceiveAmountItem);
		currentReceiveDateItem = new TextItem("currentReceiveDate", "当月收款日期");
		__formItems.add(currentReceiveDateItem);
		currentReceiveRemarkItem = new TextItem("currentReceiveRemark", "当月收款备注");
		__formItems.add(currentReceiveRemarkItem);
		projectStatusItem = new TextItem("projectStatus", "项目状态");
		__formItems.add(projectStatusItem);
		remarkItem = new TextItem("remark", "备注");
		__formItems.add(remarkItem);
		contactsItem = new TextItem("contacts", "联系人");
		__formItems.add(contactsItem);
		ledgerYearItem = new TextItem("ledgerYear", "台账年份");
		__formItems.add(ledgerYearItem);
		ledgerMonthItem = new TextItem("ledgerMonth", "台账月份");
		__formItems.add(ledgerMonthItem);
		createTimeItem = new DateTimeItem("createTime", "创建时间");
		__formItems.add(createTimeItem);
		updateTimeItem = new DateTimeItem("updateTime", "修改时间");
		__formItems.add(updateTimeItem);
		isLockedItem = new CheckboxItem("isLocked", "是否锁定");
		__formItems.add(isLockedItem);
		incomeLedgerNumberItem = new TextItem("incomeLedgerNumber", "收入台账序号");
		__formItems.add(incomeLedgerNumberItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
		else __form.editNewRecord();
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSContractIncomeLedgerList.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
