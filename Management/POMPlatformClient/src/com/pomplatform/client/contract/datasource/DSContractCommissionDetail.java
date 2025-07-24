package com.pomplatform.client.contract.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSContractCommissionDetail extends DBDataSource
{


	public static DSContractCommissionDetail instance = null;

	public static DSContractCommissionDetail getInstance() {
		if(instance == null) {
			instance = new DSContractCommissionDetail("DSContractCommissionDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField contractCommissionDetailIdField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;
	private final DataSourceFloatField rateField;
	private final DataSourceTextField contractNameField;
	private final DataSourceTextField billingRatioField;
	private final DataSourceFloatField amountField;
	private final DataSourceBooleanField isOriginalField;
	private final DataSourceBooleanField isSubProjectField;
	private final DataSourceTextField plateNameField;

	public DSContractCommissionDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ContractCommissionDetail");


		contractCommissionDetailIdField = new DataSourceIntegerField("contractCommissionDetailId", "合同提成表主键");
		contractCommissionDetailIdField.setLength(11);
		contractCommissionDetailIdField.setPrimaryKey(true);
		contractCommissionDetailIdField.setRequired(true);
		contractCommissionDetailIdField.setHidden(true);


		contractIdField = new DataSourceIntegerField("contractId", "合同编码");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(true);


		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setLength(128);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(true);


		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setLength(11);
		yearField.setRequired(false);
		yearField.setHidden(false);


		monthField = new DataSourceIntegerField("month", "月份");
		monthField.setLength(11);
		monthField.setRequired(false);
		monthField.setHidden(false);


		rateField = new DataSourceFloatField("rate", "项目进度(%)-18年之后的进度");
		rateField.setLength(32);
		rateField.setDecimalPad(2);
		rateField.setFormat("###,###,###,###,###,###,###,###,###,##0.00");
		rateField.setRequired(false);
		rateField.setHidden(false);


		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setLength(512);
		contractNameField.setRequired(false);
		contractNameField.setHidden(false);


		billingRatioField = new DataSourceTextField("billingRatio", "各个订单的结算比例");
		billingRatioField.setLength(1024);
		billingRatioField.setRequired(false);
		billingRatioField.setHidden(true);


		amountField = new DataSourceFloatField("amount", "积分");
		amountField.setLength(64);
		amountField.setDecimalPad(2);
		amountField.setFormat("##,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,##0.00");
		amountField.setRequired(false);
		amountField.setHidden(false);


		isOriginalField = new DataSourceBooleanField("isOriginal", "是否原创");
		isOriginalField.setRequired(false);
		isOriginalField.setHidden(false);


		isSubProjectField = new DataSourceBooleanField("isSubProject", "是否建筑院分包");
		isSubProjectField.setRequired(false);
		isSubProjectField.setHidden(false);


		plateNameField = new DataSourceTextField("plateName", "业务部门名称");
		plateNameField.setLength(64);
		plateNameField.setRequired(false);
		plateNameField.setHidden(false);


		setFields(contractCommissionDetailIdField, contractIdField, contractCodeField , contractNameField , plateIdField , plateNameField ,  yearField, monthField, rateField, billingRatioField, amountField, isOriginalField, isSubProjectField);
	}


}

