package com.pomplatform.client.receivables.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSCapitalAndInvoiceOne extends DBDataSource
{


	public static DSCapitalAndInvoiceOne instance = null;

	public static DSCapitalAndInvoiceOne getInstance() {
		if(instance == null) {
			instance = new DSCapitalAndInvoiceOne("DSCapitalAndInvoiceOne");
		}
		return instance;
	}

	private final DataSourceTextField infoCodeField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceFloatField borrowMoneyField;
	private final DataSourceIntegerField operatorField;
	private final DataSourceBooleanField hasInvoicesField;
	private final DataSourceBooleanField hasContractReceivableField;
	private final DataSourceBooleanField hasDistributionCollectionField;
	private final DataSourceIntegerField processStatusField;
	private final DataSourceIntegerField capitalDistributionIdField;
	private final DataSourceDateTimeField happenDateField;

	public DSCapitalAndInvoiceOne(String dataSourceID) {

		super();
		setID(dataSourceID);
//		setActionMode(ACTION_MODE_QUERY);
//		setActionName("CapitalAndInvoiceOne");


		infoCodeField = new DataSourceTextField("infoCode", "信息编号");
		infoCodeField.setLength(64);
		infoCodeField.setRequired(false);
		infoCodeField.setHidden(true);


		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(64);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(true);


		contractIdField = new DataSourceIntegerField("contractId", "合同");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(true);


		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(true);


		borrowMoneyField = new DataSourceFloatField("borrowMoney", "回款金额");
		borrowMoneyField.setLength(16);
		borrowMoneyField.setDecimalPad(2);
		borrowMoneyField.setFormat("##,###,###,###,##0.00");
		borrowMoneyField.setRequired(false);
		borrowMoneyField.setHidden(false);


		operatorField = new DataSourceIntegerField("operator", "操作人");
		operatorField.setLength(11);
		operatorField.setRequired(false);
		operatorField.setHidden(false);


		hasInvoicesField = new DataSourceBooleanField("hasInvoices", "是否绑定了发票");
		hasInvoicesField.setRequired(false);
		hasInvoicesField.setHidden(true);


		hasContractReceivableField = new DataSourceBooleanField("hasContractReceivable", "是否绑定了合同阶段付款");
		hasContractReceivableField.setRequired(false);
		hasContractReceivableField.setHidden(true);


		hasDistributionCollectionField = new DataSourceBooleanField("hasDistributionCollection", "有分配回款");
		hasDistributionCollectionField.setRequired(false);
		hasDistributionCollectionField.setHidden(true);


		processStatusField = new DataSourceIntegerField("processStatus", "流程状态 0 未处于流程  1审批中 2审批完成");
		processStatusField.setLength(11);
		processStatusField.setRequired(false);
		processStatusField.setHidden(true);


		capitalDistributionIdField = new DataSourceIntegerField("capitalDistributionId", "回款分配编码");
		capitalDistributionIdField.setLength(11);
		capitalDistributionIdField.setRequired(false);
		capitalDistributionIdField.setHidden(true);


		happenDateField = new DataSourceDateTimeField("happenDate", "回款时间");
		happenDateField.setLength(128);
		happenDateField.setRequired(false);
		happenDateField.setHidden(false);

		setFields(happenDateField,infoCodeField, projectCodeField, contractIdField, contractCodeField, borrowMoneyField, operatorField, hasInvoicesField, hasContractReceivableField, hasDistributionCollectionField, processStatusField, capitalDistributionIdField);
	}


}

