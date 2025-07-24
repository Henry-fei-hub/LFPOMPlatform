package com.pomplatform.client.departmentdirector.datasource;

import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.types.SummaryFunctionType;

public class DSMDepartmentDirector extends DBDataSource {

    public static DSMDepartmentDirector instance = null;

    public static DSMDepartmentDirector getInstance() {
        if (instance == null) {
            instance = new DSMDepartmentDirector("DSMDepartmentDirector");
        }
        return instance;
    }

    private final DataSourceTextField projectCodeField;
    private final DataSourceTextField projectNameField;
    private final DataSourceIntegerField plateManagerIdField;
    private final DataSourceIntegerField departmentManagerIdField;
    private final DataSourceIntegerField projectManageIdField;
    private final DataSourceIntegerField projectTypeField;
    private final DataSourceTextField contractCodeField;
    private final DataSourceTextField contractNameField;
    private final DataSourceTextField customerNameField;
    private final DataSourceTextField projectIntegralField;
    private final DataSourceTextField workHoursField;
    private final DataSourceTextField projectSizeField;
    private final DataSourceDateField planStartDateField;
    private final DataSourceDateField planEndDateField;
    private final DataSourceIntegerField projectIdField;
    private final DataSourceIntegerField statusField;
    private final DataSourceIntegerField departmentIdField;
    private final DataSourceTextField budgetField;
    private final DataSourceTextField commonAreaField;
    private final DataSourceTextField logisticsAreaField;
    private final DataSourceTextField percentageField;
    private final DataSourceTextField totalIntegralField;
    private final DataSourceTextField reserveIntegralField;
    private final DataSourceTextField projectFinishPercentField;
    private final DataSourceIntegerField parentIdField;
    private final DataSourceTextField totalFinishPercentField;
    private final DataSourceTextField lastPercentField;
    private final DataSourceIntegerField projectGradeTypeField;
    private final DataSourceFloatField complaintIntegralField;
    private final DataSourceTextField projectFlagField;
    private final DataSourceFloatField sureIntegralField;
    private final DataSourceFloatField leftSureIntegralField;
    private final DataSourceFloatField progressPercentageField;
    private final DataSourceFloatField projectFinishPercentHavetimeField;
    private final DataSourceFloatField plateSureIntegralField;
    private final DataSourceFloatField leftPlateSureIntegralField;
    
    public DSMDepartmentDirector(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_QUERY);
        setActionName("MDepartmentDirector");

        projectCodeField = new DataSourceTextField("projectCode", "项目编号");
        projectCodeField.setLength(64);
        projectCodeField.setRequired(false);
        projectCodeField.setHidden(true);

        projectNameField = new DataSourceTextField("projectName", "项目名称");
        projectNameField.setLength(512);
        projectNameField.setRequired(false);
        projectNameField.setHidden(false);

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

        projectTypeField = new DataSourceIntegerField("projectType", "业务部门");
        projectTypeField.setLength(11);
        projectTypeField.setRequired(false);
        projectTypeField.setHidden(false);
        projectTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));

        contractCodeField = new DataSourceTextField("contractCode", "订单编号");
        contractCodeField.setLength(64);
        contractCodeField.setRequired(false);
        contractCodeField.setHidden(false);

        contractNameField = new DataSourceTextField("contractName", "合同名称");
        contractNameField.setLength(512);
        contractNameField.setRequired(false);
        contractNameField.setHidden(true);

        customerNameField = new DataSourceTextField("customerName", "客户名称");
        customerNameField.setLength(512);
        customerNameField.setRequired(false);
        customerNameField.setHidden(true);
        
        totalIntegralField = new DataSourceTextField("totalIntegral", "项目总积分");
        totalIntegralField.setLength(64);
        totalIntegralField.setRequired(false);
        totalIntegralField.setHidden(false);
        totalIntegralField.setSummaryFunction(SummaryFunctionType.SUM);
        
        reserveIntegralField = new DataSourceTextField("reserveIntegral", "预留积分");
        reserveIntegralField.setLength(64);
        reserveIntegralField.setRequired(false);
        reserveIntegralField.setHidden(false);
        reserveIntegralField.setSummaryFunction(SummaryFunctionType.SUM);
        
        complaintIntegralField = new DataSourceFloatField("complaintIntegral", "投诉保证金");
        complaintIntegralField.setLength(18);
        complaintIntegralField.setDecimalPad(2);
        complaintIntegralField.setFormat("#,###,###,###,###,##0.00");
        complaintIntegralField.setRequired(false);
        complaintIntegralField.setHidden(false);
		
        projectIntegralField = new DataSourceTextField("projectIntegral", "项目积分");
        projectIntegralField.setLength(64);
        projectIntegralField.setRequired(false);
        projectIntegralField.setHidden(false);
        projectIntegralField.setSummaryFunction(SummaryFunctionType.SUM);
        
        budgetField = new DataSourceTextField("budget", "预算");
        budgetField.setLength(64);
        budgetField.setRequired(false);
        budgetField.setHidden(true);

        workHoursField = new DataSourceTextField("workHours", "预估工时");
        workHoursField.setLength(64);
        workHoursField.setRequired(false);
        workHoursField.setHidden(true);

        projectSizeField = new DataSourceTextField("projectSize", "项目大小");
        projectSizeField.setLength(64);
        projectSizeField.setRequired(false);
        projectSizeField.setHidden(true);

        planStartDateField = new DataSourceDateField("planStartDate", "计划开始日期");
        planStartDateField.setRequired(false);
        planStartDateField.setHidden(true);

        planEndDateField = new DataSourceDateField("planEndDate", "计划结束日期");
        planEndDateField.setRequired(false);
        planEndDateField.setHidden(true);

        projectIdField = new DataSourceIntegerField("projectId", "项目编码");
        projectIdField.setLength(11);
        projectIdField.setPrimaryKey(true);
        projectIdField.setRequired(true);
        projectIdField.setHidden(true);

        statusField = new DataSourceIntegerField("status", "项目状态");
        statusField.setLength(11);
        statusField.setRequired(false);
        statusField.setHidden(false);
        statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_4"));

        departmentIdField = new DataSourceIntegerField("departmentId", "归属部门");
        departmentIdField.setLength(11);
        departmentIdField.setRequired(false);
        departmentIdField.setHidden(true);
        
        commonAreaField = new DataSourceTextField("commonArea", "公区面积");
        commonAreaField.setLength(64);
        commonAreaField.setRequired(false);
        commonAreaField.setHidden(true);
        commonAreaField.setSummaryFunction(SummaryFunctionType.SUM);
        
        logisticsAreaField = new DataSourceTextField("logisticsArea", "后勤面积");
        logisticsAreaField.setLength(64);
        logisticsAreaField.setRequired(false);
        logisticsAreaField.setHidden(true);
        logisticsAreaField.setSummaryFunction(SummaryFunctionType.SUM);
        
        percentageField = new DataSourceTextField("percentage", "核算比例");
        percentageField.setLength(64);
        percentageField.setRequired(false);
        percentageField.setHidden(false);
        
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
        totalFinishPercentField.setHidden(false);
        
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
        
        
        projectFlagField = new DataSourceTextField("projectFlag", "项目类型标识");
		projectFlagField.setLength(32);
		projectFlagField.setRequired(false);
		projectFlagField.setHidden(false);
		projectFlagField.setValueMap(KeyValueManager.getValueMap("system_dictionary_71"));
		
		
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
		plateSureIntegralField.setHidden(false);
		
		leftPlateSureIntegralField = new DataSourceFloatField("leftPlateSureIntegral","部门剩余确认积分");
		leftPlateSureIntegralField.setLength(18);
		leftPlateSureIntegralField.setDecimalPad(2);
		leftPlateSureIntegralField.setFormat("#,###,###,###,###,##0.00");
		leftPlateSureIntegralField.setRequired(true);
		leftPlateSureIntegralField.setHidden(false);

        setFields(projectIdField, projectCodeField, projectNameField,parentIdField,plateManagerIdField,departmentManagerIdField, projectManageIdField, projectTypeField, contractCodeField, contractNameField, customerNameField,commonAreaField,logisticsAreaField,percentageField,totalIntegralField,reserveIntegralField,complaintIntegralField, projectIntegralField,lastPercentField,projectFinishPercentField,totalFinishPercentField,budgetField, workHoursField, projectSizeField, planStartDateField, planEndDateField,sureIntegralField,leftSureIntegralField,progressPercentageField,projectFinishPercentHavetimeField,plateSureIntegralField,leftPlateSureIntegralField, statusField, departmentIdField,projectGradeTypeField,projectFlagField);
    }

}
