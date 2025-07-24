package com.pomplatform.client.departmentmanagerproject.datasource;

import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.types.SummaryFunctionType;

public class DSMDepartmentManagerProject extends DBDataSource {

    public static DSMDepartmentManagerProject instance = null;

    public static DSMDepartmentManagerProject getInstance() {
        if (instance == null) {
            instance = new DSMDepartmentManagerProject("DSMDepartmentManagerProject");
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
    private final DataSourceIntegerField projectTypeField;
    private final DataSourceTextField projectCodeField;
    private final DataSourceTextField projectNameField;
    private final DataSourceDateField planStartDateField;
    private final DataSourceDateField planEndDateField;
    private final DataSourceDateField startDateField;
    private final DataSourceDateField endDateField;
    private final DataSourceIntegerField statusField;
    private final DataSourceTextField projectProgressField;
    private final DataSourceIntegerField projectManageIdField;
    private final DataSourceTextField projectManageNameField;
    private final DataSourceTextField projectSizeField;
    private final DataSourceTextField projectIntegralField;
    private final DataSourceTextField projectDescriptionField;
    private final DataSourceTextField budgetField;
    private final DataSourceTextField auditReasonField;
    private final DataSourceIntegerField projectLevelField;
    private final DataSourceIntegerField departmentManagerIdField;
    private final DataSourceIntegerField plateIdField;
    private final DataSourceFloatField commonAreaField;
    private final DataSourceFloatField logisticsAreaField;
    private final DataSourceTextField percentageField;
    private final DataSourceIntegerField oldProjectDiscountField;
    private final DataSourceTextField totalIntegralField;
    private final DataSourceTextField reserveIntegralField;
    private final DataSourceIntegerField electromechanicalTypeField;
    private final DataSourceFloatField totalAmountField;
    private final DataSourceIntegerField officeTypeField;

    public DSMDepartmentManagerProject(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_QUERY);
        setActionName("MDepartmentManagerProject");

        projectIdField = new DataSourceIntegerField("projectId", "项目编码");
        projectIdField.setLength(11);
        projectIdField.setPrimaryKey(true);
        projectIdField.setRequired(true);
        projectIdField.setHidden(true);

        projectNameField = new DataSourceTextField("projectName", "项目名称");
        projectNameField.setLength(512);
        projectNameField.setRequired(false);
        projectNameField.setHidden(false);

        oldProjectDiscountField = new DataSourceIntegerField("oldProjectDiscount", "遗留项目折算");
        oldProjectDiscountField.setLength(11);
        oldProjectDiscountField.setRequired(false);
        oldProjectDiscountField.setHidden(true);

        contractCodeField = new DataSourceTextField("contractCode", "合同");
        contractCodeField.setLength(64);
        contractCodeField.setRequired(false);
        contractCodeField.setHidden(false);
//        contractCodeField.setValueMap(KeyValueManager.getValueMap("contracts"));
        KeyValueManager.loadValueMap("contracts",contractCodeField);

        contractNameField = new DataSourceTextField("contractName", "合同名称");
        contractNameField.setLength(512);
        contractNameField.setRequired(false);
        contractNameField.setHidden(true);

        customerNameField = new DataSourceTextField("customerName", "客户名称");
        customerNameField.setLength(512);
        customerNameField.setRequired(false);
        customerNameField.setHidden(true);

        workHoursField = new DataSourceTextField("workHours", "预估工时");
        workHoursField.setLength(64);
        workHoursField.setRequired(false);
        workHoursField.setHidden(true);
        workHoursField.setSummaryFunction(SummaryFunctionType.SUM);

        departmentIdField = new DataSourceIntegerField("departmentId", "归属部门");
        departmentIdField.setLength(11);
        departmentIdField.setRequired(false);
        departmentIdField.setHidden(false);
        departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));

        designPhaseField = new DataSourceIntegerField("designPhase", "设计阶段");
        designPhaseField.setLength(11);
        designPhaseField.setRequired(false);
        designPhaseField.setHidden(false);
        designPhaseField.setValueMap(KeyValueManager.getValueMap("system_dictionary_7"));

        projectTypeField = new DataSourceIntegerField("projectType", "项目类型");
        projectTypeField.setLength(11);
        projectTypeField.setRequired(false);
        projectTypeField.setHidden(false);
        projectTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));

        projectCodeField = new DataSourceTextField("projectCode", "项目编号");
        projectCodeField.setLength(64);
        projectCodeField.setRequired(false);
        projectCodeField.setHidden(false);

        planStartDateField = new DataSourceDateField("planStartDate", "项目计划开始日期");
        planStartDateField.setRequired(false);
        planStartDateField.setHidden(false);

        planEndDateField = new DataSourceDateField("planEndDate", "项目计划结束日期");
        planEndDateField.setRequired(false);
        planEndDateField.setHidden(false);

        startDateField = new DataSourceDateField("startDate", "项目开始日期");
        startDateField.setRequired(false);
        startDateField.setHidden(false);

        endDateField = new DataSourceDateField("endDate", "项目结束日期");
        endDateField.setRequired(false);
        endDateField.setHidden(false);

        statusField = new DataSourceIntegerField("status", "项目状态");
        statusField.setLength(11);
        statusField.setRequired(false);
        statusField.setHidden(false);
        statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_4"));

        projectProgressField = new DataSourceTextField("projectProgress", "项目进度");
        projectProgressField.setLength(64);
        projectProgressField.setRequired(false);
        projectProgressField.setHidden(true);

        projectManageIdField = new DataSourceIntegerField("projectManageId", "项目经理");
        projectManageIdField.setLength(11);
        projectManageIdField.setRequired(false);
        projectManageIdField.setHidden(true);
        projectManageIdField.setValueMap(KeyValueManager.getValueMap("employees"));

        projectManageNameField = new DataSourceTextField("projectManageName", "项目负责人姓名");
        projectManageNameField.setLength(64);
        projectManageNameField.setRequired(false);
        projectManageNameField.setHidden(true);

        projectSizeField = new DataSourceTextField("projectSize", "项目大小");
        projectSizeField.setLength(64);
        projectSizeField.setRequired(false);
        projectSizeField.setHidden(true);

        projectIntegralField = new DataSourceTextField("projectIntegral", "项目积分");
        projectIntegralField.setLength(64);
        projectIntegralField.setRequired(false);
        projectIntegralField.setHidden(false);
        projectIntegralField.setSummaryFunction(SummaryFunctionType.SUM);

        projectDescriptionField = new DataSourceTextField("projectDescription", "项目描述");
        projectDescriptionField.setLength(512);
        projectDescriptionField.setRequired(false);
        projectDescriptionField.setHidden(true);

        budgetField = new DataSourceTextField("budget", "预算");
        budgetField.setLength(50);
        budgetField.setRequired(false);
        budgetField.setHidden(true);

        auditReasonField = new DataSourceTextField("auditReason", "审核意见");
        auditReasonField.setLength(1024);
        auditReasonField.setRequired(false);
        auditReasonField.setHidden(true);

        projectLevelField = new DataSourceIntegerField("projectLevel", "项目等级");
        projectLevelField.setLength(11);
        projectLevelField.setRequired(false);
        projectLevelField.setHidden(true);
        projectLevelField.setValueMap(KeyValueManager.getValueMap("system_dictionary_2"));

        departmentManagerIdField = new DataSourceIntegerField("departmentManagerId", "板块负责人");
        departmentManagerIdField.setLength(11);
        departmentManagerIdField.setRequired(false);
        departmentManagerIdField.setHidden(true);

        plateIdField = new DataSourceIntegerField("plateId", "板块");
        plateIdField.setLength(11);
        plateIdField.setRequired(false);
        plateIdField.setHidden(true);

        commonAreaField = new DataSourceFloatField("commonArea", "公区面积");
        commonAreaField.setLength(10);
        commonAreaField.setDecimalPad(2);
        commonAreaField.setFormat("##,###,##0.00");
        commonAreaField.setRequired(false);
        commonAreaField.setHidden(true);

        logisticsAreaField = new DataSourceFloatField("logisticsArea", "后勤面积");
        logisticsAreaField.setLength(10);
        logisticsAreaField.setDecimalPad(2);
        logisticsAreaField.setFormat("##,###,##0.00");
        logisticsAreaField.setRequired(false);
        logisticsAreaField.setHidden(true);

        percentageField = new DataSourceTextField("percentage", "核算比例");
        percentageField.setLength(64);
        percentageField.setRequired(true);
        percentageField.setHidden(true);

        totalIntegralField = new DataSourceTextField("totalIntegral", "项目总积分");
        totalIntegralField.setLength(64);
        totalIntegralField.setRequired(true);
        totalIntegralField.setHidden(false);
        totalIntegralField.setSummaryFunction(SummaryFunctionType.SUM);

        reserveIntegralField = new DataSourceTextField("reserveIntegral", "预留积分");
        reserveIntegralField.setLength(64);
        reserveIntegralField.setRequired(true);
        reserveIntegralField.setHidden(false);
        reserveIntegralField.setSummaryFunction(SummaryFunctionType.SUM);

        electromechanicalTypeField = new DataSourceIntegerField("electromechanicalType", "机电类型");
        electromechanicalTypeField.setLength(11);
        electromechanicalTypeField.setRequired(false);
        electromechanicalTypeField.setHidden(true);
        electromechanicalTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_15"));

        totalAmountField = new DataSourceFloatField("totalAmount", "项目总金额");
        totalAmountField.setLength(0);
        totalAmountField.setDecimalPad(0);
        totalAmountField.setFormat("");
        totalAmountField.setRequired(false);
        totalAmountField.setHidden(true);

        officeTypeField = new DataSourceIntegerField("officeType", "办公类型");
        officeTypeField.setLength(11);
        officeTypeField.setRequired(false);
        officeTypeField.setHidden(true);
        officeTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_16"));

        setFields(projectCodeField, projectNameField, projectTypeField, projectManageIdField, totalIntegralField, reserveIntegralField, projectIntegralField, planStartDateField, planEndDateField, statusField, departmentIdField, workHoursField, designPhaseField, projectProgressField, projectManageNameField, projectSizeField, projectDescriptionField, budgetField, auditReasonField, projectLevelField, departmentManagerIdField, plateIdField, commonAreaField, logisticsAreaField, percentageField, electromechanicalTypeField, totalAmountField, officeTypeField, contractNameField, projectIdField, contractCodeField, customerNameField, startDateField, endDateField, oldProjectDiscountField);
    }

}
