package com.pomplatform.client.company.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSCompanyAccountGetSheetTotal extends DBDataSource
{


	public static DSCompanyAccountGetSheetTotal instance = null;

	public static DSCompanyAccountGetSheetTotal getInstance() {
		if(instance == null) {
			instance = new DSCompanyAccountGetSheetTotal("DSCompanyAccountGetSheetTotal");
		}
		return instance;
	}

	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceFloatField signingMoneySumField;
	private final DataSourceFloatField sheetTotalIntegralField;

	public DSCompanyAccountGetSheetTotal(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("CompanyAccountGetSheetTotal");


		contractIdField = new DataSourceIntegerField("contractId", "主订单编码");
		contractIdField.setLength(11);
		contractIdField.setPrimaryKey(true);
		contractIdField.setRequired(true);
		contractIdField.setHidden(true);
//		contractIdField.setValueMap(KeyValueManager.getValueMap("contracts"));
		KeyValueManager.loadValueMap("contracts", contractIdField);


		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);


		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setLength(512);
		contractNameField.setRequired(false);
		contractNameField.setHidden(false);


		signingMoneySumField = new DataSourceFloatField("signingMoneySum", "合同总额");
		signingMoneySumField.setLength(16);
		signingMoneySumField.setDecimalPad(2);
		signingMoneySumField.setFormat("##,###,###,###,##0.00");
		signingMoneySumField.setRequired(false);
		signingMoneySumField.setHidden(false);


		sheetTotalIntegralField = new DataSourceFloatField("sheetTotalIntegral", "订单总积分");
		sheetTotalIntegralField.setLength(18);
		sheetTotalIntegralField.setDecimalPad(2);
		sheetTotalIntegralField.setFormat("#,###,###,###,###,##0.00");
		sheetTotalIntegralField.setRequired(true);
		sheetTotalIntegralField.setHidden(false);


		setFields(contractIdField, contractCodeField, contractNameField, signingMoneySumField, sheetTotalIntegralField);
	}


}

