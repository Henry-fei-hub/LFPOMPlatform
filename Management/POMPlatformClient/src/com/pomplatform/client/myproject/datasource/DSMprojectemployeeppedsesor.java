package com.pomplatform.client.myproject.datasource;

import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;

public class DSMprojectemployeeppedsesor extends DBDataSource {

    public static DSMprojectemployeeppedsesor instance = null;

    public static DSMprojectemployeeppedsesor getInstance() {
        if (instance == null) {
            instance = new DSMprojectemployeeppedsesor("DSMprojectemployeeppedsesor");
        }
        return instance;
    }

    private final DataSourceIntegerField projectEmployeeIdField;
    private final DataSourceIntegerField projectIdField;
    private final DataSourceIntegerField employeeIdField;
    private final DataSourceIntegerField designPhaseField;
    private final DataSourceTextField planWorkHoursField;
    private final DataSourceTextField realWorkHoursField;
    private final DataSourceTextField planIntegralField;
    private final DataSourceTextField realIntegralField;
    private final DataSourceDateField startDateField;
    private final DataSourceDateField endDateField;
    private final DataSourceIntegerField statusField;
    private final DataSourceTextField contractCodeField;
    private final DataSourceTextField contractNameField;
    private final DataSourceTextField customerNameField;
    private final DataSourceTextField workHoursField;
    private final DataSourceIntegerField departmentIdField;
    private final DataSourceIntegerField projectTypeField;
    private final DataSourceTextField projectCodeField;
    private final DataSourceTextField projectNameField;
    private final DataSourceDateField planStartDateField;
    private final DataSourceDateField planEndDateField;
    private final DataSourceTextField projectProgressField;
    private final DataSourceIntegerField projectManageIdField;
    private final DataSourceTextField projectManageNameField;
    private final DataSourceTextField projectSizeField;
    private final DataSourceTextField projectIntegralField;
    private final DataSourceTextField projectDescriptionField;
    private final DataSourceTextField budgetField;
    private final DataSourceTextField auditReasonField;
    private final DataSourceIntegerField projectLevelField;

    public DSMprojectemployeeppedsesor(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_QUERY);
        setActionName("Mprojectemployeeppedsesor");

        projectEmployeeIdField = new DataSourceIntegerField("projectEmployeeId", "项目组建编码");
        projectEmployeeIdField.setLength(11);
        projectEmployeeIdField.setPrimaryKey(true);
        projectEmployeeIdField.setRequired(true);
        projectEmployeeIdField.setHidden(false);

        projectIdField = new DataSourceIntegerField("projectId", "项目编码");
        projectIdField.setLength(11);
        projectIdField.setRequired(false);
        projectIdField.setHidden(false);

        employeeIdField = new DataSourceIntegerField("employeeId", "设计师");
        employeeIdField.setLength(11);
        employeeIdField.setRequired(false);
        employeeIdField.setHidden(false);
//        employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));
        KeyValueManager.loadValueMap("employees",employeeIdField);
        designPhaseField = new DataSourceIntegerField("designPhase", "设计阶段");
        designPhaseField.setLength(11);
        designPhaseField.setRequired(false);
        designPhaseField.setHidden(false);

        planWorkHoursField = new DataSourceTextField("planWorkHours", "预估工时");
        planWorkHoursField.setLength(64);
        planWorkHoursField.setRequired(false);
        planWorkHoursField.setHidden(false);

        realWorkHoursField = new DataSourceTextField("realWorkHours", "实际工时");
        realWorkHoursField.setLength(11);
        realWorkHoursField.setRequired(false);
        realWorkHoursField.setHidden(false);

        planIntegralField = new DataSourceTextField("planIntegral", "预分配积分");
        planIntegralField.setLength(64);
        planIntegralField.setRequired(false);
        planIntegralField.setHidden(false);

        realIntegralField = new DataSourceTextField("realIntegral", "实际获得积分");
        realIntegralField.setLength(11);
        realIntegralField.setRequired(false);
        realIntegralField.setHidden(false);

        startDateField = new DataSourceDateField("startDate", "开始日期");
        startDateField.setRequired(false);
        startDateField.setHidden(false);

        endDateField = new DataSourceDateField("endDate", "结束日期");
        endDateField.setRequired(false);
        endDateField.setHidden(false);

        statusField = new DataSourceIntegerField("status", "状态");
        statusField.setLength(11);
        statusField.setRequired(false);
        statusField.setHidden(false);

        contractCodeField = new DataSourceTextField("contractCode", "合同编号");
        contractCodeField.setLength(64);
        contractCodeField.setRequired(false);
        contractCodeField.setHidden(false);

        contractNameField = new DataSourceTextField("contractName", "合同名称");
        contractNameField.setLength(512);
        contractNameField.setRequired(false);
        contractNameField.setHidden(false);

        customerNameField = new DataSourceTextField("customerName", "客户名称");
        customerNameField.setLength(512);
        customerNameField.setRequired(false);
        customerNameField.setHidden(false);

        workHoursField = new DataSourceTextField("workHours", "预估工时");
        workHoursField.setLength(64);
        workHoursField.setRequired(false);
        workHoursField.setHidden(false);

        departmentIdField = new DataSourceIntegerField("departmentId", "归属部门");
        departmentIdField.setLength(11);
        departmentIdField.setRequired(false);
        departmentIdField.setHidden(true);

        projectTypeField = new DataSourceIntegerField("projectType", "项目类型");
        projectTypeField.setLength(11);
        projectTypeField.setRequired(false);
        projectTypeField.setHidden(true);

        projectCodeField = new DataSourceTextField("projectCode", "项目编号");
        projectCodeField.setLength(64);
        projectCodeField.setRequired(false);
        projectCodeField.setHidden(true);

        projectNameField = new DataSourceTextField("projectName", "项目名称");
        projectNameField.setLength(512);
        projectNameField.setRequired(false);
        projectNameField.setHidden(true);

        planStartDateField = new DataSourceDateField("planStartDate", "项目计划开始日期");
        planStartDateField.setRequired(false);
        planStartDateField.setHidden(true);

        planEndDateField = new DataSourceDateField("planEndDate", "项目计划结束日期");
        planEndDateField.setRequired(false);
        planEndDateField.setHidden(true);

        projectProgressField = new DataSourceTextField("projectProgress", "项目进度");
        projectProgressField.setLength(64);
        projectProgressField.setRequired(false);
        projectProgressField.setHidden(true);

        projectManageIdField = new DataSourceIntegerField("projectManageId", "项目负责人");
        projectManageIdField.setLength(11);
        projectManageIdField.setRequired(false);
        projectManageIdField.setHidden(true);
//        projectManageIdField.setValueMap(KeyValueManager.getValueMap("employees"));
        KeyValueManager.loadValueMap("employees",projectManageIdField);

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
        projectIntegralField.setHidden(true);

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

        setFields(projectEmployeeIdField, projectIdField, employeeIdField, designPhaseField, planWorkHoursField, realWorkHoursField, planIntegralField, realIntegralField, startDateField, endDateField, statusField, contractCodeField, contractNameField, customerNameField, workHoursField, departmentIdField, projectTypeField, projectCodeField, projectNameField, planStartDateField, planEndDateField, projectProgressField, projectManageIdField, projectManageNameField, projectSizeField, projectIntegralField, projectDescriptionField, budgetField, auditReasonField, projectLevelField);
    }

}
