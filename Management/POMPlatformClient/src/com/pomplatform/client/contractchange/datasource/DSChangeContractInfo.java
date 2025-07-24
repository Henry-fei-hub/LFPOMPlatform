package com.pomplatform.client.contractchange.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSChangeContractInfo extends DBDataSource
{


	public static DSChangeContractInfo instance = null;

	public static DSChangeContractInfo getInstance() {
		if(instance == null) {
			instance = new DSChangeContractInfo("DSChangeContractInfo");
		}
		return instance;
	}

	private final DataSourceIntegerField contractChangeIdField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceFloatField contractAmountField;
	private final DataSourceFloatField contractChangeAmountField;
	private final DataSourceFloatField contractFinalAmountField;
	private final DataSourceTextField contractChangeViewField;
	private final DataSourceIntegerField flagField;
	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceDateTimeField operateTimeField;
	private final DataSourceTextField remarkField;

	public DSChangeContractInfo(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ChangeContractInfo");


		contractChangeIdField = new DataSourceIntegerField("contractChangeId", "主键编码");
		contractChangeIdField.setLength(11);
		contractChangeIdField.setPrimaryKey(true);
		contractChangeIdField.setRequired(true);
		contractChangeIdField.setHidden(true);


		contractIdField = new DataSourceIntegerField("contractId", "合同编码");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(false);


		contractAmountField = new DataSourceFloatField("contractAmount", "合同金额");
		contractAmountField.setLength(18);
		contractAmountField.setDecimalPad(2);
		contractAmountField.setFormat("#,###,###,###,###,##0.00");
		contractAmountField.setRequired(false);
		contractAmountField.setHidden(false);


		contractChangeAmountField = new DataSourceFloatField("contractChangeAmount", "合同变更金额");
		contractChangeAmountField.setLength(18);
		contractChangeAmountField.setDecimalPad(2);
		contractChangeAmountField.setFormat("#,###,###,###,###,##0.00");
		contractChangeAmountField.setRequired(false);
		contractChangeAmountField.setHidden(false);


		contractFinalAmountField = new DataSourceFloatField("contractFinalAmount", "合同变更后金额");
		contractFinalAmountField.setLength(18);
		contractFinalAmountField.setDecimalPad(2);
		contractFinalAmountField.setFormat("#,###,###,###,###,##0.00");
		contractFinalAmountField.setRequired(false);
		contractFinalAmountField.setHidden(false);


		contractChangeViewField = new DataSourceTextField("contractChangeView", "金额变更显示");
		contractChangeViewField.setLength(128);
		contractChangeViewField.setRequired(false);
		contractChangeViewField.setHidden(false);


		flagField = new DataSourceIntegerField("flag", "状态");
		flagField.setLength(11);
		flagField.setRequired(false);
		flagField.setHidden(false);


		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "操作人");
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setRequired(false);
		operateEmployeeIdField.setHidden(false);


		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		setFields(contractChangeIdField, contractIdField, contractAmountField, contractChangeAmountField, contractFinalAmountField, contractChangeViewField, flagField, operateEmployeeIdField, operateTimeField, remarkField);
	}


}

