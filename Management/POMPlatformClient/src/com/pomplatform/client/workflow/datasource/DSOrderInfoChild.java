package com.pomplatform.client.workflow.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSOrderInfoChild extends DBDataSource
{


	public static DSOrderInfoChild instance = null;

	public static DSOrderInfoChild getInstance() {
		if(instance == null) {
			instance = new DSOrderInfoChild("DSOrderInfoChild");
		}
		return instance;
	}

	private final DataSourceIntegerField orderInfoChildIdField;
	private final DataSourceIntegerField subContractIdField;
	private final DataSourceIntegerField parentIdField;
	private final DataSourceTextField subContractCodeField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceIntegerField businessTypeField;
	private final DataSourceIntegerField projectTypeField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceFloatField commonAreaField;
	private final DataSourceFloatField logisticsAreaField;
	private final DataSourceFloatField moneySumField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceTextField subContractNameField;
	private final DataSourceDateTimeField updateTimeField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceFloatField sheetTotalIntegralField;
	private final DataSourceFloatField designAreaField;
	private final DataSourceFloatField complaintPercentageField;
	private final DataSourceFloatField complaintIntegralField;
	private final DataSourceFloatField sheetIntegralField;
	private final DataSourceFloatField percentageField;
	private final DataSourceIntegerField orderInfoIdField;
	private final DataSourceIntegerField projectManageIdField;
	private final DataSourceFloatField htPercentageField;
	private final DataSourceFloatField ddPercentageField;
	public DSOrderInfoChild(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("OrderInfoChild");


		orderInfoChildIdField = new DataSourceIntegerField("orderInfoChildId", "订单信息子表编码");
		orderInfoChildIdField.setLength(11);
		orderInfoChildIdField.setPrimaryKey(true);
		orderInfoChildIdField.setRequired(true);
		orderInfoChildIdField.setHidden(true);


		subContractIdField = new DataSourceIntegerField("subContractId", "子合同编码");
		subContractIdField.setLength(11);
		subContractIdField.setRequired(false);
		subContractIdField.setHidden(true);


		parentIdField = new DataSourceIntegerField("parentId", "主合同编码");
		parentIdField.setLength(11);
		parentIdField.setRequired(false);
		parentIdField.setHidden(true);


		subContractCodeField = new DataSourceTextField("subContractCode", "订单编号");
		subContractCodeField.setLength(64);
		subContractCodeField.setRequired(false);
		subContractCodeField.setHidden(false);


		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(64);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(true);


		businessTypeField = new DataSourceIntegerField("businessType", "业务类型");
		businessTypeField.setLength(11);
		businessTypeField.setRequired(false);
		businessTypeField.setHidden(true);


		projectTypeField = new DataSourceIntegerField("projectType", "项目类型");
		projectTypeField.setLength(11);
		projectTypeField.setRequired(false);
		projectTypeField.setHidden(true);


		departmentIdField = new DataSourceIntegerField("departmentId", "承接部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));

		commonAreaField = new DataSourceFloatField("commonArea", "公区面积");
		commonAreaField.setLength(16);
		commonAreaField.setDecimalPad(2);
		commonAreaField.setFormat("##,###,###,###,##0.00");
		commonAreaField.setRequired(false);
		commonAreaField.setHidden(true);


		logisticsAreaField = new DataSourceFloatField("logisticsArea", "后勤面积");
		logisticsAreaField.setLength(16);
		logisticsAreaField.setDecimalPad(2);
		logisticsAreaField.setFormat("##,###,###,###,##0.00");
		logisticsAreaField.setRequired(false);
		logisticsAreaField.setHidden(true);


		moneySumField = new DataSourceFloatField("moneySum", "总金额");
		moneySumField.setLength(16);
		moneySumField.setDecimalPad(2);
		moneySumField.setFormat("##,###,###,###,##0.00");
		moneySumField.setRequired(false);
		moneySumField.setHidden(false);


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(true);


		subContractNameField = new DataSourceTextField("subContractName", "订单名称");
		subContractNameField.setLength(16);
		subContractNameField.setRequired(false);
		subContractNameField.setHidden(false);


		updateTimeField = new DataSourceDateTimeField("updateTime", "修改时间");
		updateTimeField.setRequired(false);
		updateTimeField.setHidden(true);


		projectIdField = new DataSourceIntegerField("projectId", "项目编码");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(true);


		sheetTotalIntegralField = new DataSourceFloatField("sheetTotalIntegral", "订单总积分");
		sheetTotalIntegralField.setLength(16);
		sheetTotalIntegralField.setDecimalPad(2);
		sheetTotalIntegralField.setFormat("##,###,###,###,##0.00");
		sheetTotalIntegralField.setRequired(false);
		sheetTotalIntegralField.setHidden(false);


		designAreaField = new DataSourceFloatField("designArea", "设计面积");
		designAreaField.setLength(18);
		designAreaField.setDecimalPad(2);
		designAreaField.setFormat("#,###,###,###,###,##0.00");
		designAreaField.setRequired(false);
		designAreaField.setHidden(true);


		complaintPercentageField = new DataSourceFloatField("complaintPercentage", "投诉保证金比例");
		complaintPercentageField.setLength(16);
		complaintPercentageField.setDecimalPad(2);
		complaintPercentageField.setFormat("##,###,###,###,##0.00");
		complaintPercentageField.setRequired(false);
		complaintPercentageField.setHidden(true);


		complaintIntegralField = new DataSourceFloatField("complaintIntegral", "投诉保证金");
		complaintIntegralField.setLength(16);
		complaintIntegralField.setDecimalPad(2);
		complaintIntegralField.setFormat("##,###,###,###,##0.00");
		complaintIntegralField.setRequired(false);
		complaintIntegralField.setHidden(true);
		complaintIntegralField.setCanEdit(false);


		sheetIntegralField = new DataSourceFloatField("sheetIntegral", "订单积分");
		sheetIntegralField.setLength(16);
		sheetIntegralField.setDecimalPad(2);
		sheetIntegralField.setFormat("##,###,###,###,##0.00");
		sheetIntegralField.setRequired(false);
		sheetIntegralField.setHidden(true);
		sheetIntegralField.setCanEdit(false);

		htPercentageField = new DataSourceFloatField("ht_percentage", "合同金额占比");
		htPercentageField.setFormat("##,###,###,###,##0.00");

		ddPercentageField = new DataSourceFloatField("dd_percentage", "订单金额占比");
		ddPercentageField.setFormat("##,###,###,###,##0.00");


		percentageField = new DataSourceFloatField("percentage", "占比");
		percentageField.setLength(18);
		percentageField.setDecimalPad(2);
		percentageField.setFormat("#,###,###,###,###,##0.00");
		percentageField.setRequired(false);
		percentageField.setHidden(true);


		orderInfoIdField = new DataSourceIntegerField("orderInfoId", "订单信息主表编码");
		orderInfoIdField.setLength(11);
		orderInfoIdField.setRequired(false);
		orderInfoIdField.setHidden(true);

		projectManageIdField = new DataSourceIntegerField("projectManageId", "负责人");
		projectManageIdField.setLength(11);
		projectManageIdField.setRequired(false);
		projectManageIdField.setHidden(false);
		projectManageIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		setFields(orderInfoChildIdField, subContractIdField, parentIdField, subContractCodeField, projectCodeField, businessTypeField, projectTypeField, departmentIdField, commonAreaField, logisticsAreaField, moneySumField,htPercentageField, createTimeField, subContractNameField, updateTimeField, projectIdField, sheetTotalIntegralField, designAreaField, complaintPercentageField, complaintIntegralField, sheetIntegralField,ddPercentageField, percentageField, orderInfoIdField,projectManageIdField);
	}


}

