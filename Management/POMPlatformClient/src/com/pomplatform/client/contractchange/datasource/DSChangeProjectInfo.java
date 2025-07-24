package com.pomplatform.client.contractchange.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSChangeProjectInfo extends DBDataSource
{


	public static DSChangeProjectInfo instance = null;

	public static DSChangeProjectInfo getInstance() {
		if(instance == null) {
			instance = new DSChangeProjectInfo("DSChangeProjectInfo");
		}
		return instance;
	}

	private final DataSourceIntegerField projectChangeIdField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceFloatField sheetAmountField;
	private final DataSourceFloatField sheetChangeAmountField;
	private final DataSourceFloatField sheetFinalAmountField;
	private final DataSourceTextField sheetChangeViewField;
	private final DataSourceFloatField totalIntegralField;
	private final DataSourceFloatField totalChangeIntegralField;
	private final DataSourceFloatField totalFinalIntegralField;
	private final DataSourceTextField totalChangeViewField;
	private final DataSourceFloatField commonAreaField;
	private final DataSourceFloatField logisticsAreaField;
	private final DataSourceFloatField designAreaField;
	private final DataSourceFloatField complaintPercentageField;
	private final DataSourceFloatField complaintIntegralField;
	private final DataSourceIntegerField flagField;
	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceDateTimeField operateTimeField;
	private final DataSourceTextField remarkField;

	public DSChangeProjectInfo(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ChangeProjectInfo");


		projectChangeIdField = new DataSourceIntegerField("projectChangeId", "主键编码");
		projectChangeIdField.setLength(11);
		projectChangeIdField.setPrimaryKey(true);
		projectChangeIdField.setRequired(true);
		projectChangeIdField.setHidden(true);


		projectIdField = new DataSourceIntegerField("projectId", "项目编码");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(false);
//		KeyValueManager.loadValueMap("projects",projectIdField);
		KeyValueManager.loadValueMap("projects",projectIdField);

		sheetAmountField = new DataSourceFloatField("sheetAmount", "订单合同金额");
		sheetAmountField.setLength(18);
		sheetAmountField.setDecimalPad(2);
		sheetAmountField.setFormat("#,###,###,###,###,##0.00");
		sheetAmountField.setRequired(false);
		sheetAmountField.setHidden(false);


		sheetChangeAmountField = new DataSourceFloatField("sheetChangeAmount", "订单合同变更金额");
		sheetChangeAmountField.setLength(18);
		sheetChangeAmountField.setDecimalPad(2);
		sheetChangeAmountField.setFormat("#,###,###,###,###,##0.00");
		sheetChangeAmountField.setRequired(false);
		sheetChangeAmountField.setHidden(false);


		sheetFinalAmountField = new DataSourceFloatField("sheetFinalAmount", "订单合同变更后金额");
		sheetFinalAmountField.setLength(18);
		sheetFinalAmountField.setDecimalPad(2);
		sheetFinalAmountField.setFormat("#,###,###,###,###,##0.00");
		sheetFinalAmountField.setRequired(false);
		sheetFinalAmountField.setHidden(false);


		sheetChangeViewField = new DataSourceTextField("sheetChangeView", "订单合同金额变更显示");
		sheetChangeViewField.setLength(128);
		sheetChangeViewField.setRequired(false);
		sheetChangeViewField.setHidden(false);


		totalIntegralField = new DataSourceFloatField("totalIntegral", "订单总积分");
		totalIntegralField.setLength(18);
		totalIntegralField.setDecimalPad(2);
		totalIntegralField.setFormat("#,###,###,###,###,##0.00");
		totalIntegralField.setRequired(false);
		totalIntegralField.setHidden(false);


		totalChangeIntegralField = new DataSourceFloatField("totalChangeIntegral", "订单变更积分");
		totalChangeIntegralField.setLength(18);
		totalChangeIntegralField.setDecimalPad(2);
		totalChangeIntegralField.setFormat("#,###,###,###,###,##0.00");
		totalChangeIntegralField.setRequired(false);
		totalChangeIntegralField.setHidden(false);


		totalFinalIntegralField = new DataSourceFloatField("totalFinalIntegral", "订单变更后总积分");
		totalFinalIntegralField.setLength(18);
		totalFinalIntegralField.setDecimalPad(2);
		totalFinalIntegralField.setFormat("#,###,###,###,###,##0.00");
		totalFinalIntegralField.setRequired(false);
		totalFinalIntegralField.setHidden(false);


		totalChangeViewField = new DataSourceTextField("totalChangeView", "订单总积分变更显示");
		totalChangeViewField.setLength(128);
		totalChangeViewField.setRequired(false);
		totalChangeViewField.setHidden(false);


		commonAreaField = new DataSourceFloatField("commonArea", "公区面积");
		commonAreaField.setLength(18);
		commonAreaField.setDecimalPad(2);
		commonAreaField.setFormat("#,###,###,###,###,##0.00");
		commonAreaField.setRequired(false);
		commonAreaField.setHidden(false);


		logisticsAreaField = new DataSourceFloatField("logisticsArea", "后勤面积");
		logisticsAreaField.setLength(18);
		logisticsAreaField.setDecimalPad(2);
		logisticsAreaField.setFormat("#,###,###,###,###,##0.00");
		logisticsAreaField.setRequired(false);
		logisticsAreaField.setHidden(false);


		designAreaField = new DataSourceFloatField("designArea", "设计面积");
		designAreaField.setLength(18);
		designAreaField.setDecimalPad(2);
		designAreaField.setFormat("#,###,###,###,###,##0.00");
		designAreaField.setRequired(false);
		designAreaField.setHidden(false);


		complaintPercentageField = new DataSourceFloatField("complaintPercentage", "投诉保证金比例");
		complaintPercentageField.setLength(18);
		complaintPercentageField.setDecimalPad(2);
		complaintPercentageField.setFormat("#,###,###,###,###,##0.00");
		complaintPercentageField.setRequired(false);
		complaintPercentageField.setHidden(false);


		complaintIntegralField = new DataSourceFloatField("complaintIntegral", "投诉保证金");
		complaintIntegralField.setLength(18);
		complaintIntegralField.setDecimalPad(2);
		complaintIntegralField.setFormat("#,###,###,###,###,##0.00");
		complaintIntegralField.setRequired(false);
		complaintIntegralField.setHidden(false);


		flagField = new DataSourceIntegerField("flag", "状态");
		flagField.setLength(11);
		flagField.setRequired(false);
		flagField.setHidden(false);


		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "操作人");
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setRequired(false);
		operateEmployeeIdField.setHidden(true);


		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(true);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(true);


		setFields(projectChangeIdField, projectIdField, sheetAmountField, sheetChangeAmountField, sheetFinalAmountField, sheetChangeViewField, totalIntegralField, totalChangeIntegralField, totalFinalIntegralField, totalChangeViewField, commonAreaField, logisticsAreaField, designAreaField, complaintPercentageField, complaintIntegralField, flagField, operateEmployeeIdField, operateTimeField, remarkField);
	}


}

