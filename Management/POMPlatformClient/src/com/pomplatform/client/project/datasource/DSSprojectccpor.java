package com.pomplatform.client.project.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.SummaryFunctionType;

public class DSSprojectccpor extends DBDataSource {

    public static DSSprojectccpor instance = null;

    public static DSSprojectccpor getInstance() {
        if (instance == null) {
            instance = new DSSprojectccpor("DSSprojectccpor");
        }
        return instance;
    }

    private final DataSourceIntegerField projectIdField;
    private final DataSourceTextField contractCodeField;
    private final DataSourceTextField contractNameField;
    private final DataSourceTextField customerNameField;
    private final DataSourceTextField workHoursField;
    private final DataSourceIntegerField departmentIdField;
    private final DataSourceIntegerField designPhaseField;
    private final DataSourceIntegerField electromechanicalTypeField;
    private final DataSourceIntegerField officeTypeField;
    private final DataSourceFloatField totalAmountField;
    private final DataSourceIntegerField projectTypeField;
    private final DataSourceTextField projectCodeField;
    private final DataSourceTextField projectNameField;
    private final DataSourceDateField planStartDateField;
    private final DataSourceDateField planEndDateField;
    private final DataSourceDateField startDateField;
    private final DataSourceDateField endDateField;
    private final DataSourceIntegerField statusField;
    private final DataSourceIntegerField oldProjectDiscountField;
    private final DataSourceTextField projectProgressField;
    private final DataSourceIntegerField projectManageIdField;
    private final DataSourceIntegerField departmentManagerIdField;
    private final DataSourceIntegerField plateManagerIdField;
    private final DataSourceTextField projectSizeField;
    private final DataSourceFloatField projectIntegralField;
    private final DataSourceTextField projectDescriptionField;
    private final DataSourceTextField budgetField;
    private final DataSourceTextField auditReasonField;
    private final DataSourceIntegerField projectLevelField;
    private final DataSourceIntegerField plateIdField;
    private final DataSourceTextField projectFinishPercentField;
    private final DataSourceIntegerField parentIdField;
    private final DataSourceTextField totalFinishPercentField;
    private final DataSourceTextField lastPercentField;
    private final DataSourceIntegerField projectGradeTypeField;
    private final DataSourceIntegerField projectFlagField;
    private final DataSourceBooleanField isEcmcProjectField;
    private final DataSourceFloatField moneySumField;
    private final DataSourceBooleanField isLockField;
    private final DataSourceFloatField sureIntegralField;
    private final DataSourceFloatField leftSureIntegralField;
    private final DataSourceFloatField progressPercentageField;
    private final DataSourceFloatField projectFinishPercentHavetimeField;
    private final DataSourceFloatField plateSureIntegralField;
    private final DataSourceFloatField leftPlateSureIntegralField;
	private final DataSourceIntegerField msgCountField;
	private final DataSourceIntegerField msgStatusField;
    private final DataSourceTextField employeeNameTostringField;
	private final DataSourceIntegerField preProjectTypeField;
	private final DataSourceFloatField percentSumField;

    public DSSprojectccpor(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_QUERY);
        setActionName("Sprojectccpor");

        projectIdField = new DataSourceIntegerField("projectId", "项目编码");
        projectIdField.setLength(11);
        projectIdField.setPrimaryKey(true);
        projectIdField.setRequired(true);
        projectIdField.setHidden(true);
        projectIdField.setSummaryFunction(SummaryFunctionType.TITLE);
        projectIdField.setSummaryValueTitle("合计");

        contractCodeField = new DataSourceTextField("contractCode", "订单编号");
        contractCodeField.setLength(64);
        contractCodeField.setRequired(false);
        contractCodeField.setHidden(false);

        contractNameField = new DataSourceTextField("contractId", "合同名称");
//        contractNameField.setValueMap(KeyValueManager.getValueMap("sub_contract_id"));
//        KeyValueManager.loadValueMap("sub_contract_id",contractNameField);
        contractNameField.setLength(512);
        contractNameField.setRequired(false);
        contractNameField.setHidden(true);

        customerNameField = new DataSourceTextField("customerName", "客户名称");
        customerNameField.setLength(512);
        customerNameField.setRequired(false);
        customerNameField.setHidden(true);
        
        officeTypeField = new DataSourceIntegerField("officeType", "办公类型");
        officeTypeField.setLength(512);
        officeTypeField.setRequired(false);
        officeTypeField.setHidden(true);
        officeTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_16"));
        
        totalAmountField = new DataSourceFloatField("totalAmount", "项目总金额");
        totalAmountField.setLength(512);
        totalAmountField.setRequired(false);
        totalAmountField.setHidden(true);
        totalAmountField.setSummaryFunction(SummaryFunctionType.SUM);

        workHoursField = new DataSourceTextField("workHours", "预估总工时");
        workHoursField.setLength(64);
        workHoursField.setRequired(false);
        workHoursField.setHidden(true);
		workHoursField.setSummaryFunction(SummaryFunctionType.SUM);

        departmentIdField = new DataSourceIntegerField("departmentId", "归属部门");
        departmentIdField.setLength(11);
        departmentIdField.setRequired(false);
        departmentIdField.setHidden(true);
        departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));
        
        electromechanicalTypeField = new DataSourceIntegerField("electromechanicalType", "机电类型");
        electromechanicalTypeField.setLength(11);
        electromechanicalTypeField.setRequired(false);
        electromechanicalTypeField.setHidden(true);
        electromechanicalTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_15"));

        designPhaseField = new DataSourceIntegerField("designPhase", "设计阶段");
        designPhaseField.setLength(11);
        designPhaseField.setRequired(false);
        designPhaseField.setHidden(true);
        designPhaseField.setValueMap(KeyValueManager.getValueMap("system_dictionary_7"));

        oldProjectDiscountField = new DataSourceIntegerField("oldProjectDiscount", "遗留项目折算(%)");
        oldProjectDiscountField.setLength(11);
        oldProjectDiscountField.setRequired(false);
        oldProjectDiscountField.setHidden(true);
        
        projectTypeField = new DataSourceIntegerField("projectType", "项目类型");
        projectTypeField.setLength(11);
        projectTypeField.setRequired(false);
        projectTypeField.setHidden(false);
        projectTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_32"));

        projectCodeField = new DataSourceTextField("projectCode", "项目编号");
        projectCodeField.setLength(64);
        projectCodeField.setRequired(false);
        projectCodeField.setHidden(true);

        projectNameField = new DataSourceTextField("projectName", "项目名称");
        projectNameField.setLength(512);
        projectNameField.setRequired(false);
        projectNameField.setHidden(false);

        planStartDateField = new DataSourceDateField("planStartDate", "计划开始日期");
        planStartDateField.setRequired(false);
        planStartDateField.setHidden(true);

        planEndDateField = new DataSourceDateField("planEndDate", "计划结束日期");
        planEndDateField.setRequired(false);
        planEndDateField.setHidden(true);

        startDateField = new DataSourceDateField("startDate", "实际开始日期");
        startDateField.setRequired(false);
        startDateField.setHidden(true);

        endDateField = new DataSourceDateField("endDate", "实际结束日期");
        endDateField.setRequired(false);
        endDateField.setHidden(true);

        statusField = new DataSourceIntegerField("status", "项目状态");
        statusField.setLength(11);
        statusField.setRequired(false);
        statusField.setHidden(false);
        statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_4"));

        projectProgressField = new DataSourceTextField("projectProgress", "项目进度");
        projectProgressField.setLength(64);
        projectProgressField.setRequired(false);
        projectProgressField.setHidden(true);

        plateManagerIdField = new DataSourceIntegerField("plateManagerId", "事业部负责人");
        plateManagerIdField.setLength(11);
        plateManagerIdField.setRequired(false);
        plateManagerIdField.setHidden(true);
        plateManagerIdField.setValueMap(KeyValueManager.getValueMap("employees"));

        departmentManagerIdField = new DataSourceIntegerField("departmentManagerId", "部门经理");
        departmentManagerIdField.setLength(11);
        departmentManagerIdField.setRequired(false);
        departmentManagerIdField.setHidden(false);
        departmentManagerIdField.setValueMap(KeyValueManager.getValueMap("employees"));

        projectManageIdField = new DataSourceIntegerField("projectManageId", "专业负责人");
        projectManageIdField.setLength(11);
        projectManageIdField.setRequired(false);
        projectManageIdField.setHidden(false);
        projectManageIdField.setValueMap(KeyValueManager.getValueMap("employees"));

        projectSizeField = new DataSourceTextField("projectSize", "项目大小");
        projectSizeField.setLength(64);
        projectSizeField.setRequired(false);
        projectSizeField.setHidden(true);

        projectIntegralField = new DataSourceFloatField("projectIntegral", "项目积分");
        projectIntegralField.setLength(16);
        projectIntegralField.setDecimalPad(2);
        projectIntegralField.setFormat("##,###,###,###,##0.00");
        projectIntegralField.setRequired(false);
        projectIntegralField.setHidden(false);
        projectIntegralField.setSummaryFunction(SummaryFunctionType.SUM);

        projectDescriptionField = new DataSourceTextField("projectDescription", "项目描述");
        projectDescriptionField.setLength(512);
        projectDescriptionField.setRequired(false);
        projectDescriptionField.setHidden(true);

        budgetField = new DataSourceTextField("budget", "项目预算");
        budgetField.setLength(50);
        budgetField.setRequired(false);
        budgetField.setHidden(true);
        budgetField.setSummaryFunction(SummaryFunctionType.SUM);

        auditReasonField = new DataSourceTextField("auditReason", "审核意见");
        auditReasonField.setLength(50);
        auditReasonField.setRequired(false);
        auditReasonField.setHidden(true);

        projectLevelField = new DataSourceIntegerField("projectLevel", "项目等级");
        projectLevelField.setLength(11);
        projectLevelField.setRequired(false);
        projectLevelField.setHidden(false);
        projectLevelField.setValueMap(KeyValueManager.getValueMap("system_dictionary_2"));
        
        plateIdField = new DataSourceIntegerField("plateId", "业务部门");
        plateIdField.setLength(11);
        plateIdField.setRequired(false);
        plateIdField.setHidden(false);
        plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
        
        projectFinishPercentField = new DataSourceTextField("projectFinishPercent", "项目完成百分比(%)");
        projectFinishPercentField.setLength(18);
        projectFinishPercentField.setDecimalPad(2);
        projectFinishPercentField.setFormat("#,###,###,###,###,##0.00");
        projectFinishPercentField.setRequired(false);
        projectFinishPercentField.setHidden(true);
        
        parentIdField = new DataSourceIntegerField("parentId", "父级项目");
        parentIdField.setLength(64);
        parentIdField.setRequired(false);
        parentIdField.setHidden(true);
//        parentIdField.setValueMap(KeyValueManager.getValueMap("projects"));
        KeyValueManager.loadValueMap("projects",parentIdField);
        
        totalFinishPercentField = new DataSourceTextField("totalFinishPercent", "合同完成百分比(%)");
        totalFinishPercentField.setLength(18);
        totalFinishPercentField.setDecimalPad(2);
        totalFinishPercentField.setFormat("#,###,###,###,###,##0.00");
        totalFinishPercentField.setRequired(false);
        totalFinishPercentField.setHidden(true);
        
        lastPercentField = new DataSourceTextField("lastPercent", "1231完工比(%)");
        lastPercentField.setLength(10);
        lastPercentField.setDecimalPad(2);
        lastPercentField.setFormat("#,###,###,###,###,##0.00");
        lastPercentField.setRequired(false);
        lastPercentField.setHidden(true);
        
        projectGradeTypeField = new DataSourceIntegerField("projectGradeType", "项目级别类型");
        projectGradeTypeField.setLength(64);
        projectGradeTypeField.setRequired(false);
        projectGradeTypeField.setHidden(true);
        projectGradeTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_25"));
        
        
        projectFlagField = new DataSourceIntegerField("projectFlag", "项目标示");
        projectFlagField.setLength(64);
        projectFlagField.setRequired(false);
        projectFlagField.setHidden(false);
        projectFlagField.setValueMap(KeyValueManager.getValueMap("system_dictionary_71"));
        
        isEcmcProjectField = new DataSourceBooleanField("isEcmcProject", "是否是ECMC流转下来的项目");
        isEcmcProjectField.setLength(10);
        isEcmcProjectField.setRequired(false);
        isEcmcProjectField.setHidden(true);
        

        moneySumField = new DataSourceFloatField("moneySum", "合同金额");
        moneySumField.setLength(512);
        moneySumField.setRequired(false);
        moneySumField.setHidden(true);
        
        isLockField = new DataSourceBooleanField("isLock", "项目是否锁定");
        isLockField.setLength(10);
        isLockField.setRequired(false);
        isLockField.setHidden(true);
        
        sureIntegralField = new DataSourceFloatField("sureIntegral", "确认积分");
		sureIntegralField.setLength(18);
		sureIntegralField.setDecimalPad(2);
		sureIntegralField.setFormat("#,###,###,###,###,##0.00");
		sureIntegralField.setRequired(true);
		sureIntegralField.setHidden(false);
		
		leftSureIntegralField = new DataSourceFloatField("leftSureIntegral","剩余确认积分");
		leftSureIntegralField.setLength(18);
		leftSureIntegralField.setDecimalPad(2);
		leftSureIntegralField.setFormat("#,###,###,###,###,##0.00");
		leftSureIntegralField.setRequired(true);
		leftSureIntegralField.setHidden(false);
		
		progressPercentageField = new DataSourceFloatField("progressPercentage","项目进度百分比(%)");
		progressPercentageField.setDecimalPad(2);
		progressPercentageField.setFormat("#,###,###,###,###,##0.00");
		progressPercentageField.setRequired(true);
		progressPercentageField.setHidden(false);
		
		projectFinishPercentHavetimeField = new DataSourceFloatField("projectFinishPercentHavetime", "项目进度比(%)");
		projectFinishPercentHavetimeField.setLength(18);
		projectFinishPercentHavetimeField.setDecimalPad(2);
		projectFinishPercentHavetimeField.setFormat("#,###,###,###,###,##0.00");
		projectFinishPercentHavetimeField.setRequired(false);
		projectFinishPercentHavetimeField.setHidden(false);
		
		plateSureIntegralField = new DataSourceFloatField("plateSureIntegral","部门确认积分");
		plateSureIntegralField.setLength(18);
		plateSureIntegralField.setDecimalPad(2);
		plateSureIntegralField.setFormat("#,###,###,###,###,##0.00");
		plateSureIntegralField.setRequired(true);
		plateSureIntegralField.setHidden(true);
		
		leftPlateSureIntegralField = new DataSourceFloatField("leftPlateSureIntegral","部门剩余确认积分");
		leftPlateSureIntegralField.setLength(18);
		leftPlateSureIntegralField.setDecimalPad(2);
		leftPlateSureIntegralField.setFormat("#,###,###,###,###,##0.00");
		leftPlateSureIntegralField.setRequired(true);
		leftPlateSureIntegralField.setHidden(true);
		
		msgCountField = new DataSourceIntegerField("msgCount", "消息推送次数");
		msgCountField.setLength(11);
		msgCountField.setRequired(false);
		msgCountField.setHidden(false);

		msgStatusField = new DataSourceIntegerField("msgStatus", "消息状态 ");
		msgStatusField.setLength(11);
		msgStatusField.setRequired(false);
		msgStatusField.setHidden(false);
		msgStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_243"));

        employeeNameTostringField = new DataSourceTextField("employeeNameTostring", "项目经理");
        employeeNameTostringField.setLength(32);
        employeeNameTostringField.setRequired(true);
        employeeNameTostringField.setHidden(false);
        
		preProjectTypeField = new DataSourceIntegerField("preProjectType", "立项项目类型");
		preProjectTypeField.setLength(11);
		preProjectTypeField.setRequired(false);
		preProjectTypeField.setHidden(false);
		preProjectTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_244"));

		
		percentSumField = new DataSourceFloatField("percentSum", "阶段比例(%)");
		percentSumField.setLength(18);
		percentSumField.setDecimalPad(2);
		percentSumField.setFormat("#,###,###,###,###,##0.00");
		percentSumField.setRequired(false);
		percentSumField.setHidden(false);
        
        setFields(contractCodeField,contractNameField,projectCodeField,projectNameField,parentIdField,preProjectTypeField,projectTypeField,designPhaseField,statusField,projectIntegralField,budgetField,workHoursField,planStartDateField,planEndDateField,startDateField,endDateField, customerNameField
        ,projectIdField,departmentIdField,electromechanicalTypeField, lastPercentField,projectFinishPercentField,sureIntegralField,leftSureIntegralField,percentSumField,progressPercentageField,projectFinishPercentHavetimeField,plateSureIntegralField,leftPlateSureIntegralField,totalFinishPercentField,oldProjectDiscountField, officeTypeField, totalAmountField,plateManagerIdField,departmentManagerIdField, projectManageIdField,projectSizeField,projectDescriptionField,auditReasonField,projectLevelField,plateIdField,projectGradeTypeField,projectFlagField,isEcmcProjectField,moneySumField,isLockField,msgCountField,msgStatusField,employeeNameTostringField);
    }

}
