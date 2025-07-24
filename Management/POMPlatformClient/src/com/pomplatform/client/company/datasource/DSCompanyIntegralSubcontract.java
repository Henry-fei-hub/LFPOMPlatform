package com.pomplatform.client.company.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSCompanyIntegralSubcontract extends DBDataSource {

	public static DSCompanyIntegralSubcontract instance = null;

	public static DSCompanyIntegralSubcontract getInstance() {
		if (instance == null) {
			instance = new DSCompanyIntegralSubcontract("DSCompanyIntegralSubcontract");
		}
		return instance;
	}

	private final DataSourceTextField subContractCodeField;
	private final DataSourceTextField subContractNameField;
	private final DataSourceIntegerField businessTypeField;
	private final DataSourceIntegerField projectTypeField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceFloatField sheetTotalIntegralField;
	private final DataSourceFloatField complaintPercentageField;
	private final DataSourceFloatField complaintIntegralField;
	private final DataSourceFloatField sheetIntegralField;
	private final DataSourceFloatField moneySumField;
	private final DataSourceFloatField commonAreaField;
	private final DataSourceFloatField logisticsAreaField;
	private final DataSourceFloatField designAreaField;
	private final DataSourceDateField agreeDateField;
	private final DataSourceTextField projectCodeField;

	public DSCompanyIntegralSubcontract(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("CompanyIntegralSubcontract");

		subContractCodeField = new DataSourceTextField("subContractCode", "订单编号");
		subContractCodeField.setLength(64);
		subContractCodeField.setRequired(false);
		subContractCodeField.setHidden(false);

		subContractNameField = new DataSourceTextField("subContractName", "订单名称");
		subContractNameField.setLength(64);
		subContractNameField.setRequired(false);
		subContractNameField.setHidden(false);

		businessTypeField = new DataSourceIntegerField("businessType", "业务类别");
		businessTypeField.setLength(11);
		businessTypeField.setRequired(false);
		businessTypeField.setHidden(false);
		businessTypeField.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));

		projectTypeField = new DataSourceIntegerField("projectType", "项目类别");
		projectTypeField.setLength(11);
		projectTypeField.setRequired(false);
		projectTypeField.setHidden(false);
		projectTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_32"));

		departmentIdField = new DataSourceIntegerField("departmentId", "承接部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));

		sheetTotalIntegralField = new DataSourceFloatField("sheetTotalIntegral", "订单总积分");
		sheetTotalIntegralField.setLength(18);
		sheetTotalIntegralField.setDecimalPad(2);
		sheetTotalIntegralField.setFormat("#,###,###,###,###,##0.00");
		sheetTotalIntegralField.setRequired(false);
		sheetTotalIntegralField.setHidden(false);

		complaintPercentageField = new DataSourceFloatField("complaintPercentage", "投诉保证金比例");
		complaintPercentageField.setLength(8);
		complaintPercentageField.setDecimalPad(5);
		complaintPercentageField.setFormat("##0.00");
		complaintPercentageField.setRequired(false);
		complaintPercentageField.setHidden(false);

		complaintIntegralField = new DataSourceFloatField("complaintIntegral", "投诉保证金");
		complaintIntegralField.setLength(18);
		complaintIntegralField.setDecimalPad(2);
		complaintIntegralField.setFormat("#,###,###,###,###,##0.00");
		complaintIntegralField.setRequired(false);
		complaintIntegralField.setHidden(false);

		sheetIntegralField = new DataSourceFloatField("sheetIntegral", "订单积分");
		sheetIntegralField.setLength(18);
		sheetIntegralField.setDecimalPad(2);
		sheetIntegralField.setFormat("#,###,###,###,###,##0.00");
		sheetIntegralField.setRequired(false);
		sheetIntegralField.setHidden(false);

		moneySumField = new DataSourceFloatField("moneySum", "小计");
		moneySumField.setLength(16);
		moneySumField.setDecimalPad(2);
		moneySumField.setFormat("##,###,###,###,##0.00");
		moneySumField.setRequired(false);
		moneySumField.setHidden(false);

		commonAreaField = new DataSourceFloatField("commonArea", "公区面积");
		commonAreaField.setLength(16);
		commonAreaField.setDecimalPad(2);
		commonAreaField.setFormat("##,###,###,###,##0.00");
		commonAreaField.setRequired(false);
		commonAreaField.setHidden(false);

		logisticsAreaField = new DataSourceFloatField("logisticsArea", "后勤面积");
		logisticsAreaField.setLength(16);
		logisticsAreaField.setDecimalPad(2);
		logisticsAreaField.setFormat("##,###,###,###,##0.00");
		logisticsAreaField.setRequired(false);
		logisticsAreaField.setHidden(false);

		designAreaField = new DataSourceFloatField("designArea", "设计面积");
		designAreaField.setLength(16);
		designAreaField.setDecimalPad(2);
		designAreaField.setFormat("##,###,###,###,##0.00");
		designAreaField.setRequired(false);
		designAreaField.setHidden(false);

		agreeDateField = new DataSourceDateField("agreeDate", "日期");
		agreeDateField.setRequired(false);
		agreeDateField.setHidden(false);

		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(64);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(true);
//		projectCodeField.setValueMap(KeyValueManager.getValueMap("main_projects"));
		KeyValueManager.loadValueMap("main_projects",projectCodeField);

		setFields(subContractCodeField, subContractNameField, businessTypeField, projectTypeField, departmentIdField,
				moneySumField, sheetTotalIntegralField, complaintPercentageField, complaintIntegralField,
				sheetIntegralField, commonAreaField, logisticsAreaField, designAreaField, agreeDateField,
				projectCodeField);
	}

}
