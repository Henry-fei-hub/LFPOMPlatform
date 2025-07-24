package com.pomplatform.client.receivables.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.delicacy.client.data.KeyValueManager;

import java.util.LinkedHashMap;

import com.delicacy.client.data.DBDataSource;

public class DSMinvoicecseccor extends DBDataSource
{


	public static DSMinvoicecseccor instance = null;

	public static DSMinvoicecseccor getInstance() {
		if(instance == null) {
			instance = new DSMinvoicecseccor("DSMinvoicecseccor");
		}
		return instance;
	}

	private final DataSourceIntegerField invoiceIdField;
	private final DataSourceIntegerField ticketingCompanyField;
	private final DataSourceIntegerField invoiceTypeField;
	private final DataSourceTextField invoiceCodeField;
	private final DataSourceTextField invoiceNumberField;
	private final DataSourceDateTimeField inStockDateField;
	private final DataSourceTextField invalidRemarkField;
	private final DataSourceIntegerField isInvalidOperatorField;
	private final DataSourceIntegerField storageOperatorField;
	private final DataSourceTextField infoCodeField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceFloatField signingMoneySumField;
	private final DataSourceIntegerField customerIdField;
	private final DataSourceFloatField invoiceAmountField;
	private final DataSourceIntegerField billingOperationField;
	private final DataSourceDateTimeField invoiceDateField;
	private final DataSourceDateTimeField registrationDateField;
	private final DataSourceIntegerField signField;
	private final DataSourceIntegerField contractReceivableIdField;
	private final DataSourceIntegerField acknowledgeLetterIdField;
	private final DataSourceBooleanField haveVoucherField;
	private final DataSourceIntegerField isCapitalField;
	private final DataSourceFloatField capitalAmountField;
	private final DataSourceIntegerField projectManagerIdField;
	private final DataSourceFloatField arrearsField;
	private final DataSourceIntegerField overduePaymentField;

	public DSMinvoicecseccor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Minvoicecseccor");


		invoiceIdField = new DataSourceIntegerField("invoiceId", "开发票 编码");
		invoiceIdField.setLength(11);
		invoiceIdField.setPrimaryKey(true);
		invoiceIdField.setRequired(true);
		invoiceIdField.setHidden(true);


		ticketingCompanyField = new DataSourceIntegerField("ticketingCompany", "购票公司");
		ticketingCompanyField.setLength(11);
		ticketingCompanyField.setRequired(false);
		ticketingCompanyField.setHidden(true);


		invoiceTypeField = new DataSourceIntegerField("invoiceType", "发票类型 1专票，2普票 ，3代开");
		invoiceTypeField.setLength(11);
		invoiceTypeField.setRequired(false);
		invoiceTypeField.setHidden(true);


		invoiceCodeField = new DataSourceTextField("invoiceCode", "发票代码");
		invoiceCodeField.setLength(64);
		invoiceCodeField.setRequired(false);
		invoiceCodeField.setHidden(true);


		invoiceNumberField = new DataSourceTextField("invoiceNumber", "发票号码");
		invoiceNumberField.setLength(64);
		invoiceNumberField.setRequired(false);
		invoiceNumberField.setHidden(false);


		inStockDateField = new DataSourceDateTimeField("inStockDate", "发票入库日期");
		inStockDateField.setRequired(false);
		inStockDateField.setHidden(true);


		invalidRemarkField = new DataSourceTextField("invalidRemark", "发票空白作废备注");
		invalidRemarkField.setLength(512);
		invalidRemarkField.setRequired(false);
		invalidRemarkField.setHidden(true);


		isInvalidOperatorField = new DataSourceIntegerField("isInvalidOperator", "发票空白作废操作人");
		isInvalidOperatorField.setLength(11);
		isInvalidOperatorField.setRequired(false);
		isInvalidOperatorField.setHidden(true);


		storageOperatorField = new DataSourceIntegerField("storageOperator", "发票入库操作人");
		storageOperatorField.setLength(11);
		storageOperatorField.setRequired(false);
		storageOperatorField.setHidden(true);


		infoCodeField = new DataSourceTextField("infoCode", "信息编号");
		infoCodeField.setLength(64);
		infoCodeField.setRequired(false);
		infoCodeField.setHidden(true);


		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(64);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(true);


		contractIdField = new DataSourceIntegerField("contractId", "合同id");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(true);


		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);


		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setLength(512);
		contractNameField.setRequired(false);
		contractNameField.setHidden(false);


		signingMoneySumField = new DataSourceFloatField("signingMoneySum", "合同金额");
		signingMoneySumField.setLength(16);
		signingMoneySumField.setDecimalPad(2);
		signingMoneySumField.setFormat("##,###,###,###,##0.00");
		signingMoneySumField.setRequired(false);
		signingMoneySumField.setHidden(false);


		customerIdField = new DataSourceIntegerField("customerId","客户名称");
		customerIdField.setLength(11);
		customerIdField.setRequired(false);
		customerIdField.setHidden(false);
		KeyValueManager.loadValueMap("customers", customerIdField);


		invoiceAmountField = new DataSourceFloatField("invoiceAmount", "开票金额");
		invoiceAmountField.setLength(16);
		invoiceAmountField.setDecimalPad(2);
		invoiceAmountField.setFormat("##,###,###,###,##0.00");
		invoiceAmountField.setRequired(false);
		invoiceAmountField.setHidden(false);


		billingOperationField = new DataSourceIntegerField("billingOperation", "开票操作人");
		billingOperationField.setLength(11);
		billingOperationField.setRequired(false);
		billingOperationField.setHidden(true);


		invoiceDateField = new DataSourceDateTimeField("invoiceDate", "开票时间");
		invoiceDateField.setRequired(false);
		invoiceDateField.setHidden(false);


		registrationDateField = new DataSourceDateTimeField("registrationDate", "开发票的登记日期");
		registrationDateField.setRequired(false);
		registrationDateField.setHidden(true);


		signField = new DataSourceIntegerField("sign", "3填开作废。当月发票，当月作废。4.负数作废。做了红字，然后又作废。5.空白作废。尚未开具，就直接作废（往往是不慎污染弄脏了，没法使用）");
		signField.setLength(11);
		signField.setRequired(false);
		signField.setHidden(true);


		contractReceivableIdField = new DataSourceIntegerField("contractReceivableId", "收款阶段id");
		contractReceivableIdField.setLength(11);
		contractReceivableIdField.setRequired(false);
		contractReceivableIdField.setHidden(true);


		acknowledgeLetterIdField = new DataSourceIntegerField("acknowledgeLetterId", "确认函id");
		acknowledgeLetterIdField.setLength(11);
		acknowledgeLetterIdField.setRequired(false);
		acknowledgeLetterIdField.setHidden(true);


		haveVoucherField = new DataSourceBooleanField("haveVoucher", "是否有凭证");
		haveVoucherField.setRequired(false);
		haveVoucherField.setHidden(true);


		isCapitalField = new DataSourceIntegerField("isCapital", "是否对应回款");
		isCapitalField.setLength(11);
		isCapitalField.setRequired(false);
		isCapitalField.setHidden(true);


		capitalAmountField = new DataSourceFloatField("capitalAmount", "已回款金额");
		capitalAmountField.setLength(32);
		capitalAmountField.setDecimalPad(2);
		capitalAmountField.setFormat("###,###,###,###,###,###,###,###,###,##0.00");
		capitalAmountField.setRequired(false);
		capitalAmountField.setHidden(false);


		projectManagerIdField = new DataSourceIntegerField("projectManagerId", "项目经理");
		projectManagerIdField.setLength(11);
		projectManagerIdField.setRequired(false);
		projectManagerIdField.setHidden(false);
		projectManagerIdField.setValueMap(KeyValueManager.getValueMap("employees"));

        arrearsField = new DataSourceFloatField("arrears", "未回款金额");
        arrearsField.setLength(32);
        arrearsField.setDecimalPad(2);
        arrearsField.setFormat("###,###,###,###,###,###,###,###,###,##0.00");
        arrearsField.setRequired(false);
        arrearsField.setHidden(false);

        overduePaymentField = new DataSourceIntegerField("overduePayment" , "是否逾期");
        overduePaymentField.setLength(11);
        overduePaymentField.setRequired(false);
        overduePaymentField.setHidden(true);
        overduePaymentField.setHidden(false);
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
        map.put(1,"是");
        map.put(0,"否");
        overduePaymentField.setValueMap(map);
		
//		setFields(invoiceIdField, ticketingCompanyField, invoiceTypeField, invoiceCodeField, invoiceNumberField, inStockDateField, invalidRemarkField, isInvalidOperatorField, storageOperatorField, infoCodeField, projectCodeField, contractIdField, contractCodeField, contractNameField, signingMoneySumField, clientNameField, invoiceAmountField, billingOperationField, invoiceDateField, registrationDateField, signField, contractReceivableIdField, acknowledgeLetterIdField, haveVoucherField, isCapitalField, capitalAmountField, projectManagerIdField);
		setFields(invoiceNumberField,invoiceDateField,contractCodeField,contractNameField,signingMoneySumField,customerIdField,invoiceAmountField,capitalAmountField,arrearsField,overduePaymentField,projectManagerIdField);
	}


}

