package com.pomplatform.client.projectreportrecorddetail.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSProjectReportRecordDetail extends DBDataSource
{


	public static DSProjectReportRecordDetail instance = null;

	public static DSProjectReportRecordDetail getInstance() {
		if(instance == null) {
			instance = new DSProjectReportRecordDetail("DSProjectReportRecordDetail");
		}
		return instance;
	}

	private final DataSourceTextField plateIdField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceFloatField totalIntegralField;
	private final DataSourceFloatField complaintIntegralField;
	private final DataSourceFloatField projectIntegralField;
	private final DataSourceFloatField reserveIntegralField;
	private final DataSourceFloatField sureIntegralField;
	private final DataSourceFloatField projectCostField;
	private final DataSourceFloatField subtractComplaintIntegralField;
	private final DataSourceIntegerField projectManageIdField;
	private final DataSourceIntegerField projectLevelField;
	private final DataSourceTextField projectFlagField;
	private final DataSourceIntegerField statusField;
	private final DataSourceFloatField progressPercentageField;
	private final DataSourceFloatField sheetAmountField;
	private final DataSourceIntegerField plateManagerIdField;
	private final DataSourceIntegerField departmentManagerIdField;
	private final DataSourceIntegerField msgCountField;
	private final DataSourceIntegerField msgStatusField;
	private final DataSourceTextField employeeNameTostring3Field;
	private final DataSourceTextField employeeNameTostring5Field;
	private final DataSourceIntegerField projectTypeField;
	private final DataSourceIntegerField mainProjectStageIdField;
	private final DataSourceFloatField signingMoneySumField;
	private final DataSourceFloatField cumulativeTotalAmountProportionField;
	private final DataSourceFloatField yearTotalAmountProportionField;
	private final DataSourceFloatField yearTotalAmountField;
	private final DataSourceFloatField surplusYearTotalAmountField;
	private final DataSourceFloatField surplusYearTotalAmountProportionField;
	private final DataSourceFloatField borrowMoneyField;
	
	public DSProjectReportRecordDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ProjectReportRecordDetail");


		plateIdField = new DataSourceTextField("plateId", "业务部门");
		plateIdField.setLength(32);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		projectIdField = new DataSourceIntegerField("projectId", "项目");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(true);
		KeyValueManager.loadValueMap("projects",projectIdField);


		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(64);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(false);
		

		contractCodeField = new DataSourceTextField("contractCode", "订单编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);


		projectNameField = new DataSourceTextField("projectName", "订单名称");
		projectNameField.setLength(512);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);

		projectLevelField=new DataSourceIntegerField("projectLevel", "项目等级");
		projectLevelField.setValueMap(KeyValueManager.getValueMap("system_dictionary_2"));
		
		projectManageIdField=new DataSourceIntegerField("projectManageId", "专业负责人");
		projectManageIdField.setValueMap(KeyValueManager.getValueMap("employees"));
		
		plateManagerIdField = new DataSourceIntegerField("plateManagerId", "事业部负责人");
		plateManagerIdField.setLength(11);
		plateManagerIdField.setRequired(false);
		plateManagerIdField.setHidden(true);
		KeyValueManager.loadValueMap("employees", plateManagerIdField);
		
		departmentManagerIdField = new DataSourceIntegerField("departmentManagerId", "部门经理");
		departmentManagerIdField.setLength(11);
		departmentManagerIdField.setRequired(false);
		departmentManagerIdField.setHidden(false);
		KeyValueManager.loadValueMap("employees", departmentManagerIdField);
		

		totalIntegralField = new DataSourceFloatField("totalIntegral", "项目总积分");
		totalIntegralField.setLength(18);
		totalIntegralField.setDecimalPad(2);
		totalIntegralField.setFormat("#,###,###,###,###,##0.00");
		totalIntegralField.setRequired(false);
		totalIntegralField.setHidden(false);


		complaintIntegralField = new DataSourceFloatField("complaintIntegral", "投诉保证金");
		complaintIntegralField.setLength(18);
		complaintIntegralField.setDecimalPad(2);
		complaintIntegralField.setFormat("#,###,###,###,###,##0.00");
		complaintIntegralField.setRequired(false);
		complaintIntegralField.setHidden(false);


		projectIntegralField = new DataSourceFloatField("projectIntegral", "项目积分");
		projectIntegralField.setLength(18);
		projectIntegralField.setDecimalPad(2);
		projectIntegralField.setFormat("#,###,###,###,###,##0.00");
		projectIntegralField.setRequired(false);
		projectIntegralField.setHidden(false);


		reserveIntegralField = new DataSourceFloatField("reserveIntegral", "预留积分");
		reserveIntegralField.setLength(18);
		reserveIntegralField.setDecimalPad(2);
		reserveIntegralField.setFormat("#,###,###,###,###,##0.00");
		reserveIntegralField.setRequired(false);
		reserveIntegralField.setHidden(false);


		sureIntegralField = new DataSourceFloatField("sureIntegral", "确认积分");
		sureIntegralField.setLength(18);
		sureIntegralField.setDecimalPad(2);
		sureIntegralField.setFormat("#,###,###,###,###,##0.00");
		sureIntegralField.setRequired(false);
		sureIntegralField.setHidden(false);


		projectCostField = new DataSourceFloatField("projectCost", "项目成本");
		projectCostField.setLength(18);
		projectCostField.setDecimalPad(2);
		projectCostField.setFormat("#,###,###,###,###,##0.00");
		projectCostField.setRequired(false);
		projectCostField.setHidden(false);


		subtractComplaintIntegralField = new DataSourceFloatField("subtractComplaintIntegral", "扣除的投诉保证金");
		subtractComplaintIntegralField.setLength(18);
		subtractComplaintIntegralField.setDecimalPad(2);
		subtractComplaintIntegralField.setFormat("#,###,###,###,###,##0.00");
		subtractComplaintIntegralField.setRequired(false);
		subtractComplaintIntegralField.setHidden(false);

		projectFlagField = new DataSourceTextField("projectFlag", "项目类型标识");
		projectFlagField.setLength(32);
		projectFlagField.setRequired(false);
		projectFlagField.setHidden(false);
		projectFlagField.setValueMap(KeyValueManager.getValueMap("system_dictionary_71"));
		
		statusField = new DataSourceIntegerField("status", "项目状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_4"));
		
		progressPercentageField = new DataSourceFloatField("progressPercentage","项目进度百分比(%)");
		progressPercentageField.setDecimalPad(2);
		progressPercentageField.setFormat("#,###,###,###,###,##0.00");
		progressPercentageField.setRequired(true);
		progressPercentageField.setHidden(false);
		
		
		sheetAmountField = new DataSourceFloatField("sheetAmount","合同订单金额");
		sheetAmountField.setDecimalPad(2);
		sheetAmountField.setFormat("#,###,###,###,###,##0.00");
		sheetAmountField.setRequired(true);
		sheetAmountField.setHidden(false);
		
		msgCountField = new DataSourceIntegerField("msgCount", "消息推送次数");
		msgCountField.setLength(11);
		msgCountField.setRequired(false);
		msgCountField.setHidden(false);

		msgStatusField = new DataSourceIntegerField("msgStatus", "消息状态 ");
		msgStatusField.setLength(11);
		msgStatusField.setRequired(false);
		msgStatusField.setHidden(false);
		msgStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_243"));
      

		employeeNameTostring3Field = new DataSourceTextField("employeeNameTostring3", "项目经理");
		employeeNameTostring3Field.setLength(32);
		employeeNameTostring3Field.setRequired(true);
		employeeNameTostring3Field.setHidden(false);
		
		employeeNameTostring5Field = new DataSourceTextField("employeeNameTostring5", "项目负责人");
		employeeNameTostring5Field.setLength(32);
		employeeNameTostring5Field.setRequired(true);
		employeeNameTostring5Field.setHidden(false);


		projectTypeField = new DataSourceIntegerField("projectType", "项目类别");
		projectTypeField.setLength(11);
		projectTypeField.setRequired(false);
		projectTypeField.setHidden(false);
		projectTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_244"));

		mainProjectStageIdField = new DataSourceIntegerField("mainProjectStageId", "立项类型");
		mainProjectStageIdField.setLength(11);
		mainProjectStageIdField.setRequired(false);
		mainProjectStageIdField.setHidden(false);
		mainProjectStageIdField.setValueMap(KeyValueManager.getValueMap("main_project_stages"));

		signingMoneySumField = new DataSourceFloatField("signingMoneySum", "合同额");
		signingMoneySumField.setLength(16);
		signingMoneySumField.setDecimalPad(2);
		signingMoneySumField.setFormat("##,###,###,###,##0.00");
		signingMoneySumField.setRequired(false);
		signingMoneySumField.setHidden(false);


		cumulativeTotalAmountProportionField = new DataSourceFloatField("cumulativeTotalAmountProportion", "项目累计结算比例(%)");
		cumulativeTotalAmountProportionField.setLength(18);
		cumulativeTotalAmountProportionField.setDecimalPad(2);
		cumulativeTotalAmountProportionField.setFormat("#,###,###,###,###,##0.00");
		cumulativeTotalAmountProportionField.setRequired(true);
		cumulativeTotalAmountProportionField.setHidden(false);


		yearTotalAmountProportionField = new DataSourceFloatField("yearTotalAmountProportion", "本年度结算比例(%)");
		yearTotalAmountProportionField.setLength(18);
		yearTotalAmountProportionField.setDecimalPad(2);
		yearTotalAmountProportionField.setFormat("#,###,###,###,###,##0.00");
		yearTotalAmountProportionField.setRequired(true);
		yearTotalAmountProportionField.setHidden(false);


		yearTotalAmountField = new DataSourceFloatField("yearTotalAmount", "本年度结算产值");
		yearTotalAmountField.setLength(18);
		yearTotalAmountField.setDecimalPad(2);
		yearTotalAmountField.setFormat("#,###,###,###,###,##0.00");
		yearTotalAmountField.setRequired(true);
		yearTotalAmountField.setHidden(false);


		surplusYearTotalAmountField = new DataSourceFloatField("surplusYearTotalAmount", "本年度结算后剩余产值");
		surplusYearTotalAmountField.setLength(18);
		surplusYearTotalAmountField.setDecimalPad(2);
		surplusYearTotalAmountField.setFormat("#,###,###,###,###,##0.00");
		surplusYearTotalAmountField.setRequired(true);
		surplusYearTotalAmountField.setHidden(false);


		surplusYearTotalAmountProportionField = new DataSourceFloatField("surplusYearTotalAmountProportion", "本年度结算后剩余比例(%)");
		surplusYearTotalAmountProportionField.setLength(18);
		surplusYearTotalAmountProportionField.setDecimalPad(2);
		surplusYearTotalAmountProportionField.setFormat("#,###,###,###,###,##0.00");
		surplusYearTotalAmountProportionField.setRequired(true);
		surplusYearTotalAmountProportionField.setHidden(false);


		borrowMoneyField = new DataSourceFloatField("borrowMoney", "回款率(%)");
		borrowMoneyField.setLength(16);
		borrowMoneyField.setDecimalPad(2);
		borrowMoneyField.setFormat("##,###,###,###,##0.00");
		borrowMoneyField.setRequired(false);
		borrowMoneyField.setHidden(false);

		setFields(plateIdField, projectIdField, projectCodeField, contractCodeField, projectNameField,projectTypeField,mainProjectStageIdField,projectLevelField,statusField,projectManageIdField, departmentManagerIdField, plateManagerIdField,employeeNameTostring3Field,employeeNameTostring5Field, totalIntegralField, complaintIntegralField, projectIntegralField, reserveIntegralField, sureIntegralField,progressPercentageField, projectCostField, subtractComplaintIntegralField,projectFlagField,sheetAmountField,msgCountField,msgStatusField,    cumulativeTotalAmountProportionField, yearTotalAmountProportionField, yearTotalAmountField, surplusYearTotalAmountField, surplusYearTotalAmountProportionField,signingMoneySumField, borrowMoneyField);
	}


}

