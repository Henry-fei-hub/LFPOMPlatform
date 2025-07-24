package com.pomplatform.client.ssubcontractsspor.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSsubcontractsspor extends DBDataSource
{


	public static DSSsubcontractsspor instance = null;

	public static DSSsubcontractsspor getInstance() {
		if(instance == null) {
			instance = new DSSsubcontractsspor("DSSsubcontractsspor");
		}
		return instance;
	}

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
	private final DataSourceFloatField designAreaField;
	private final DataSourceIntegerField orderNoField;
	private final DataSourceFloatField sheetTotalIntegralField;
	private final DataSourceFloatField complaintIntegralField;
	private final DataSourceFloatField sheetIntegralField;
	private final DataSourceFloatField complaintPercentageField;
	private final DataSourceDateField agreeDateField;
	private final DataSourceTextField infoCodeField;
	private final DataSourceIntegerField businessStateRecordIdField;
	private final DataSourceTextField remarkField;

	public DSSsubcontractsspor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Ssubcontractsspor");


		subContractIdField = new DataSourceIntegerField("subContractId", "子合同编码");
		subContractIdField.setLength(11);
		subContractIdField.setPrimaryKey(true);
		subContractIdField.setRequired(true);
		subContractIdField.setHidden(true);


		parentIdField = new DataSourceIntegerField("parentId", "主合同编码");
		parentIdField.setLength(11);
		parentIdField.setRequired(false);
		parentIdField.setHidden(true);
//		parentIdField.setValueMap(KeyValueManager.getValueMap("project_types"));
		KeyValueManager.loadValueMap("project_types", parentIdField);


		subContractCodeField = new DataSourceTextField("subContractCode", "订单编号");
		subContractCodeField.setLength(64);
		subContractCodeField.setRequired(false);
		subContractCodeField.setHidden(false);


		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(64);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(false);


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
		departmentIdField.setHidden(true);


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


		moneySumField = new DataSourceFloatField("moneySum", "小计 子订单总金额");
		moneySumField.setLength(16);
		moneySumField.setDecimalPad(2);
		moneySumField.setFormat("##,###,###,###,##0.00");
		moneySumField.setRequired(false);
		moneySumField.setHidden(false);


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(true);


		subContractNameField = new DataSourceTextField("subContractName", "子合同名称");
		subContractNameField.setLength(64);
		subContractNameField.setRequired(false);
		subContractNameField.setHidden(false);


		updateTimeField = new DataSourceDateTimeField("updateTime", "修改时间");
		updateTimeField.setRequired(false);
		updateTimeField.setHidden(true);


		designAreaField = new DataSourceFloatField("designArea", "设计面积");
		designAreaField.setLength(16);
		designAreaField.setDecimalPad(2);
		designAreaField.setFormat("##,###,###,###,##0.00");
		designAreaField.setRequired(false);
		designAreaField.setHidden(true);


		orderNoField = new DataSourceIntegerField("orderNo", "标记补充协议字段；除0之外，其他都表示第n个补充协议");
		orderNoField.setLength(11);
		orderNoField.setRequired(false);
		orderNoField.setHidden(true);


		sheetTotalIntegralField = new DataSourceFloatField("sheetTotalIntegral", "项目总积分");
		sheetTotalIntegralField.setLength(18);
		sheetTotalIntegralField.setDecimalPad(2);
		sheetTotalIntegralField.setFormat("#,###,###,###,###,##0.00");
		sheetTotalIntegralField.setRequired(false);
		sheetTotalIntegralField.setHidden(true);


		complaintIntegralField = new DataSourceFloatField("complaintIntegral", "投诉保证金");
		complaintIntegralField.setLength(18);
		complaintIntegralField.setDecimalPad(2);
		complaintIntegralField.setFormat("#,###,###,###,###,##0.00");
		complaintIntegralField.setRequired(false);
		complaintIntegralField.setHidden(true);


		sheetIntegralField = new DataSourceFloatField("sheetIntegral", "订单积分");
		sheetIntegralField.setLength(18);
		sheetIntegralField.setDecimalPad(2);
		sheetIntegralField.setFormat("#,###,###,###,###,##0.00");
		sheetIntegralField.setRequired(false);
		sheetIntegralField.setHidden(true);


		complaintPercentageField = new DataSourceFloatField("complaintPercentage", "投诉保证金比例");
		complaintPercentageField.setLength(8);
		complaintPercentageField.setDecimalPad(2);
		complaintPercentageField.setFormat("##0.00");
		complaintPercentageField.setRequired(false);
		complaintPercentageField.setHidden(true);


		agreeDateField = new DataSourceDateField("agreeDate", "价格审核同意的时间");
		agreeDateField.setRequired(false);
		agreeDateField.setHidden(true);


		infoCodeField = new DataSourceTextField("infoCode", "信息编号");
		infoCodeField.setLength(32);
		infoCodeField.setRequired(false);
		infoCodeField.setHidden(true);


		businessStateRecordIdField = new DataSourceIntegerField("businessStateRecordId", "业态编码");
		businessStateRecordIdField.setLength(11);
		businessStateRecordIdField.setRequired(false);
		businessStateRecordIdField.setHidden(true);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(512);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		setFields(subContractIdField, parentIdField, subContractCodeField, projectCodeField, businessTypeField, projectTypeField, departmentIdField, commonAreaField, logisticsAreaField, moneySumField, createTimeField, subContractNameField, updateTimeField, designAreaField, orderNoField, sheetTotalIntegralField, complaintIntegralField, sheetIntegralField, complaintPercentageField, agreeDateField, infoCodeField, businessStateRecordIdField, remarkField);
	}


}

