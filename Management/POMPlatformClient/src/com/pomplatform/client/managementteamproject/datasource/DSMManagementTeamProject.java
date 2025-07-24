package com.pomplatform.client.managementteamproject.datasource;

import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.types.SummaryFunctionType;

public class DSMManagementTeamProject extends DBDataSource {

    public static DSMManagementTeamProject instance = null;

    public static DSMManagementTeamProject getInstance() {
        if (instance == null) {
            instance = new DSMManagementTeamProject("DSMManagementTeamProject");
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
    private final DataSourceTextField commonAreaField;
    private final DataSourceTextField logisticsAreaField;
    private final DataSourceTextField percentageField;
    private final DataSourceTextField totalIntegralField;
    private final DataSourceTextField reserveIntegralField;
    private final DataSourceTextField budgetField;
    private final DataSourceTextField projectFinishPercentField;
    private final DataSourceIntegerField parentIdField;
    private final DataSourceTextField totalFinishPercentField;
    private final DataSourceTextField lastPercentField;
    private final DataSourceIntegerField projectGradeTypeField;

    public DSMManagementTeamProject(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_QUERY);
        setActionName("MManagementTeamProject");

        projectCodeField = new DataSourceTextField("projectCode", "项目编号");
        projectCodeField.setLength(64);
        projectCodeField.setRequired(false);
        projectCodeField.setHidden(false);

        projectNameField = new DataSourceTextField("projectName", "项目名称");
        projectNameField.setLength(64);
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

        contractCodeField = new DataSourceTextField("contractCode", "合同编号");
        contractCodeField.setLength(64);
        contractCodeField.setRequired(false);
        contractCodeField.setHidden(false);

        contractNameField = new DataSourceTextField("contractName", "合同名称");
        contractNameField.setLength(64);
        contractNameField.setRequired(false);
        contractNameField.setHidden(false);

        customerNameField = new DataSourceTextField("customerName", "客户名称");
        customerNameField.setLength(64);
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

        projectIntegralField = new DataSourceTextField("projectIntegral", "项目积分");
        projectIntegralField.setLength(64);
        projectIntegralField.setRequired(false);
        projectIntegralField.setHidden(false);
        projectIntegralField.setSummaryFunction(SummaryFunctionType.SUM);
        
        budgetField = new DataSourceTextField("budget", "预算");
        budgetField.setLength(64);
        budgetField.setRequired(false);
        budgetField.setHidden(true);
        budgetField.setSummaryFunction(SummaryFunctionType.SUM);

        workHoursField = new DataSourceTextField("workHours", "预估工时");
        workHoursField.setLength(64);
        workHoursField.setRequired(false);
        workHoursField.setHidden(false);

        projectSizeField = new DataSourceTextField("projectSize", "项目大小");
        projectSizeField.setLength(64);
        projectSizeField.setRequired(false);
        projectSizeField.setHidden(false);

        planStartDateField = new DataSourceDateField("planStartDate", "计划开始日期");
        planStartDateField.setRequired(false);
        planStartDateField.setHidden(false);

        planEndDateField = new DataSourceDateField("planEndDate", "计划结束日期");
        planEndDateField.setRequired(false);
        planEndDateField.setHidden(false);

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
        departmentIdField.setHidden(false);
        departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));
        
        commonAreaField = new DataSourceTextField("commonArea", "公区面积");
        commonAreaField.setLength(64);
        commonAreaField.setRequired(false);
        commonAreaField.setHidden(false);
        commonAreaField.setSummaryFunction(SummaryFunctionType.SUM);
        
        logisticsAreaField = new DataSourceTextField("logisticsArea", "后勤面积");
        logisticsAreaField.setLength(64);
        logisticsAreaField.setRequired(false);
        logisticsAreaField.setHidden(false);
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
        projectFinishPercentField.setHidden(false);
        
        parentIdField = new DataSourceIntegerField("parentId", "父级项目");
        parentIdField.setLength(64);
        parentIdField.setRequired(false);
        parentIdField.setHidden(true);
//        parentIdField.setValueMap(KeyValueManager.getValueMap("projects"));
        KeyValueManager.loadValueMap("projects", parentIdField);
        
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
        lastPercentField.setHidden(false);
        
        projectGradeTypeField = new DataSourceIntegerField("projectGradeType", "项目级别类型");
        projectGradeTypeField.setLength(64);
        projectGradeTypeField.setRequired(false);
        projectGradeTypeField.setHidden(false);
        projectGradeTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_25"));

        setFields(projectIdField, projectCodeField, projectNameField,contractCodeField, contractNameField, parentIdField, plateManagerIdField, departmentManagerIdField, projectManageIdField, projectTypeField, customerNameField,commonAreaField,logisticsAreaField,percentageField,totalIntegralField,reserveIntegralField, projectIntegralField,lastPercentField,projectFinishPercentField,totalFinishPercentField,budgetField, workHoursField, projectSizeField, planStartDateField, planEndDateField, statusField, departmentIdField,projectGradeTypeField);
    }

}
