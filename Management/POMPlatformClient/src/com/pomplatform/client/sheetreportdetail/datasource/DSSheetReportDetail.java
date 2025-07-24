package com.pomplatform.client.sheetreportdetail.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSheetReportDetail extends DBDataSource
{


	public static DSSheetReportDetail instance = null;

	public static DSSheetReportDetail getInstance() {
		if(instance == null) {
			instance = new DSSheetReportDetail("DSSheetReportDetail");
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

	public DSSheetReportDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("SheetReportDetail");


		subContractCodeField = new DataSourceTextField("subContractCode", "子合同编号");
		subContractCodeField.setLength(64);
		subContractCodeField.setRequired(false);
		subContractCodeField.setHidden(false);


		subContractNameField = new DataSourceTextField("subContractName", "子合同名称  充当了区域");
		subContractNameField.setLength(64);
		subContractNameField.setRequired(false);
		subContractNameField.setHidden(false);


		businessTypeField = new DataSourceIntegerField("businessType", "业务类型");
		businessTypeField.setLength(11);
		businessTypeField.setRequired(false);
		businessTypeField.setHidden(false);


		projectTypeField = new DataSourceIntegerField("projectType", "项目类型");
		projectTypeField.setLength(11);
		projectTypeField.setRequired(false);
		projectTypeField.setHidden(false);
//		projectTypeField.setValueMap(KeyValueManager.getValueMap("project_types"));
		KeyValueManager.loadValueMap("project_types", projectTypeField);


		departmentIdField = new DataSourceIntegerField("departmentId", "承接部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		sheetTotalIntegralField = new DataSourceFloatField("sheetTotalIntegral", "sheet_total_integral");
		sheetTotalIntegralField.setLength(18);
		sheetTotalIntegralField.setDecimalPad(2);
		sheetTotalIntegralField.setFormat("#,###,###,###,###,##0.00");
		sheetTotalIntegralField.setRequired(false);
		sheetTotalIntegralField.setHidden(false);


		complaintPercentageField = new DataSourceFloatField("complaintPercentage", "投诉保证金比例");
		complaintPercentageField.setLength(8);
		complaintPercentageField.setDecimalPad(2);
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


		moneySumField = new DataSourceFloatField("moneySum", "小计 子订单总金额");
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


		agreeDateField = new DataSourceDateField("agreeDate", "价格审核同意的时间");
		agreeDateField.setRequired(false);
		agreeDateField.setHidden(false);


		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(64);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(false);


		setFields(subContractCodeField, subContractNameField, businessTypeField, projectTypeField, departmentIdField, sheetTotalIntegralField, complaintPercentageField, complaintIntegralField, sheetIntegralField, moneySumField, commonAreaField, logisticsAreaField, designAreaField, agreeDateField, projectCodeField);
	}


}

