package com.pomplatform.client.projectview.datasource;

import com.delicacy.client.data.ClientUtil;
import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.data.RoleDefinition;
import com.smartgwt.client.types.SummaryFunctionType;

public class DSSprojectView extends DBDataSource {

    public static DSSprojectView instance = null;

    public static DSSprojectView getInstance() {
        if (instance == null) {
            instance = new DSSprojectView("DSSprojectView");
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
    private final DataSourceIntegerField plateManagerIdField;
    private final DataSourceIntegerField plateIdField;
    private final DataSourceField detailProjectEmployee;
    private final DataSourceField detailProjectCost;
    private final DataSourceTextField commonAreaField;
    private final DataSourceTextField logisticsAreaField;
    private final DataSourceTextField percentageField;
    private final DataSourceTextField totalIntegralField;
    private final DataSourceTextField reserveIntegralField;
    private final DataSourceFloatField complaintIntegralField;

    public DSSprojectView(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_QUERY);
        setActionName("SprojectView");

        projectIdField = new DataSourceIntegerField("projectId", "项目编码");
        projectIdField.setLength(11);
        projectIdField.setPrimaryKey(true);
        projectIdField.setRequired(true);
        projectIdField.setHidden(true);

        contractCodeField = new DataSourceTextField("contractCode", "合同编号");
        contractCodeField.setLength(64);
        contractCodeField.setRequired(false);
        contractCodeField.setHidden(false);
//        contractCodeField.setValueMap(KeyValueManager.getValueMap("contracts"));

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
        departmentIdField.setHidden(false);
        departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));

        designPhaseField = new DataSourceIntegerField("designPhase", "设计阶段");
        designPhaseField.setLength(11);
        designPhaseField.setRequired(false);
        designPhaseField.setHidden(false);
        designPhaseField.setValueMap(KeyValueManager.getValueMap("system_dictionary_7"));

        projectTypeField = new DataSourceIntegerField("projectType", "业务部门");
        projectTypeField.setLength(11);
        projectTypeField.setRequired(false);
        projectTypeField.setHidden(true);
        projectTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));

        projectCodeField = new DataSourceTextField("projectCode", "项目编号");
        projectCodeField.setLength(64);
        projectCodeField.setRequired(false);
        projectCodeField.setHidden(false);

        projectNameField = new DataSourceTextField("projectName", "项目名称");
        projectNameField.setLength(512);
        projectNameField.setRequired(false);
        projectNameField.setHidden(false);

        planStartDateField = new DataSourceDateField("planStartDate", "计划开始日期");
        planStartDateField.setRequired(false);
        planStartDateField.setHidden(false);

        planEndDateField = new DataSourceDateField("planEndDate", "计划结束日期");
        planEndDateField.setRequired(false);
        planEndDateField.setHidden(false);

        startDateField = new DataSourceDateField("startDate", "实际开始日期");
        startDateField.setRequired(false);
        startDateField.setHidden(false);

        endDateField = new DataSourceDateField("endDate", "实际结束日期");
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

        projectManageIdField = new DataSourceIntegerField("projectManageId", "专业负责人");
        projectManageIdField.setLength(11);
        projectManageIdField.setRequired(false);
        projectManageIdField.setHidden(false);
        projectManageIdField.setValueMap(KeyValueManager.getValueMap("employees"));

        projectManageNameField = new DataSourceTextField("projectManageName", "专业负责人");
        projectManageNameField.setLength(64);
        projectManageNameField.setRequired(false);
        projectManageNameField.setHidden(true);

        projectSizeField = new DataSourceTextField("projectSize", "项目大小");
        projectSizeField.setLength(64);
        projectSizeField.setRequired(false);
        projectSizeField.setHidden(true);
        
        totalIntegralField = new DataSourceTextField("totalIntegral", "项目总积分");
        totalIntegralField.setLength(64);
        totalIntegralField.setRequired(false);
        totalIntegralField.setHidden(true);
        totalIntegralField.setSummaryFunction(SummaryFunctionType.SUM);
        
        reserveIntegralField = new DataSourceTextField("reserveIntegral", "预留积分");
        reserveIntegralField.setLength(64);
        reserveIntegralField.setRequired(false);
        reserveIntegralField.setHidden(true);
        reserveIntegralField.setSummaryFunction(SummaryFunctionType.SUM);

        projectIntegralField = new DataSourceTextField("projectIntegral", "项目积分");
        projectIntegralField.setLength(64);
        projectIntegralField.setRequired(false);
        projectIntegralField.setHidden(true);

        projectDescriptionField = new DataSourceTextField("projectDescription", "项目描述");
        projectDescriptionField.setLength(512);
        projectDescriptionField.setRequired(false);
        projectDescriptionField.setHidden(false);

        budgetField = new DataSourceTextField("budget", "预算");
        budgetField.setLength(64);
        budgetField.setRequired(false);
        budgetField.setHidden(true);

        auditReasonField = new DataSourceTextField("auditReason", "审核意见");
        auditReasonField.setLength(1024);
        auditReasonField.setRequired(false);
        auditReasonField.setHidden(true);

        projectLevelField = new DataSourceIntegerField("projectLevel", "项目等级");
        projectLevelField.setLength(11);
        projectLevelField.setRequired(false);
        projectLevelField.setHidden(false);
        projectLevelField.setValueMap(KeyValueManager.getValueMap("system_dictionary_2"));

        departmentManagerIdField = new DataSourceIntegerField("departmentManagerId", "部门经理");
        departmentManagerIdField.setLength(11);
        departmentManagerIdField.setRequired(false);
        departmentManagerIdField.setHidden(false);
        departmentManagerIdField.setValueMap(KeyValueManager.getValueMap("employees"));
        
        plateManagerIdField = new DataSourceIntegerField("plateManagerId", "事业部负责人");
        plateManagerIdField.setLength(11);
        plateManagerIdField.setRequired(false);
        plateManagerIdField.setHidden(true);
        plateManagerIdField.setValueMap(KeyValueManager.getValueMap("employees"));

        plateIdField = new DataSourceIntegerField("plateId", "业务部门");
        plateIdField.setLength(11);
        plateIdField.setRequired(false);
        plateIdField.setHidden(false);
        plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
        

        detailProjectEmployee = new DataSourceField("detailProjectEmployee", FieldType.ANY);
        detailProjectEmployee.setChildrenProperty(true);
        detailProjectEmployee.setChildTagName("ProjectEmployee");
        detailProjectEmployee.setRequired(false);
        detailProjectEmployee.setHidden(true);
        
        detailProjectCost = new DataSourceField("detailProjectCost", FieldType.ANY);
        detailProjectCost.setChildrenProperty(true);
        detailProjectCost.setChildTagName("ProjectCost");
        detailProjectCost.setRequired(false);
        detailProjectCost.setHidden(true);
        
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
        percentageField.setHidden(true);
        
        //通过权限控制显示的数据内容；如果拥有查看项目所有信息，则开放所有的内容
        if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.PROJECT_ALL_INFO_DATA)){
            totalIntegralField.setHidden(false);
            projectIntegralField.setHidden(false);
            reserveIntegralField.setHidden(false);
            percentageField.setHidden(false);
            budgetField.setHidden(false);
        }else if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.PROJECT_MASTER_INFO_DATA)){//只查看项目重要的信息
            projectIntegralField.setHidden(false);
        }
        
        complaintIntegralField = new DataSourceFloatField("complaintIntegral", "投诉保证金");
        complaintIntegralField.setLength(18);
        complaintIntegralField.setDecimalPad(2);
        complaintIntegralField.setFormat("#,###,###,###,###,##0.00");
        complaintIntegralField.setRequired(false);
        complaintIntegralField.setHidden(false);

        setFields(projectIdField, contractCodeField, contractNameField, customerNameField, workHoursField, departmentIdField, designPhaseField, projectTypeField, projectCodeField, projectNameField, planStartDateField, planEndDateField, startDateField, endDateField, statusField, projectProgressField,  projectManageNameField, projectSizeField, commonAreaField,logisticsAreaField,percentageField,totalIntegralField,complaintIntegralField,reserveIntegralField,projectIntegralField,budgetField, projectDescriptionField, auditReasonField, projectLevelField,projectManageIdField, departmentManagerIdField,plateManagerIdField, plateIdField, detailProjectEmployee, detailProjectCost);
    }

}
