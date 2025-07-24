package com.pomplatform.client.designer.datasource;

import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSMprojectemployeepor extends DBDataSource {

    public static DSMprojectemployeepor instance = null;

    public static DSMprojectemployeepor getInstance() {
        if (instance == null) {
            instance = new DSMprojectemployeepor("DSMprojectemployeepor");
        }
        return instance;
    }

    private final DataSourceIntegerField projectManageIdField;
    private final DataSourceTextField projectNameField;
    private final DataSourceTextField workContentField;
    private final DataSourceDateField startDateField;
    private final DataSourceDateField endDateField;
    private final DataSourceFloatField integralField;
    private final DataSourceFloatField planIntegralField;
    private final DataSourceFloatField realIntegralField;
    private final DataSourceFloatField costField;
    private final DataSourceIntegerField projectIdField;
    private final DataSourceIntegerField projectEmployeeIdField;
    private final DataSourceIntegerField employeeIdField;

    public DSMprojectemployeepor(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_QUERY);
        setActionName("Mprojectemployeepor");

        projectManageIdField = new DataSourceIntegerField("projectManageId", "项目负责人");
        projectManageIdField.setLength(11);
        projectManageIdField.setRequired(false);
        projectManageIdField.setHidden(false);
        projectManageIdField.setValueMap(KeyValueManager.getValueMap("employees"));

        projectNameField = new DataSourceTextField("projectName", "项目名称");
        projectNameField.setLength(512);
        projectNameField.setRequired(false);
        projectNameField.setHidden(false);

        workContentField = new DataSourceTextField("workContent", "工作内容");
        workContentField.setLength(1024);
        workContentField.setRequired(false);
        workContentField.setHidden(false);

        startDateField = new DataSourceDateField("startDate", "开始日期");
        startDateField.setRequired(false);
        startDateField.setHidden(false);

        endDateField = new DataSourceDateField("endDate", "结束日期");
        endDateField.setRequired(false);
        endDateField.setHidden(false);

        planIntegralField = new DataSourceFloatField("planIntegral", "计划积分");
        planIntegralField.setLength(18);
        planIntegralField.setDecimalPad(2);
        planIntegralField.setFormat("#,###,###,###,###,##0.00");
        planIntegralField.setRequired(true);
        planIntegralField.setHidden(false);

        realIntegralField = new DataSourceFloatField("realIntegral", "实际积分");
        realIntegralField.setLength(18);
        realIntegralField.setDecimalPad(2);
        realIntegralField.setFormat("#,###,###,###,###,##0.00");
        realIntegralField.setRequired(true);
        realIntegralField.setHidden(false);

        costField = new DataSourceFloatField("cost", "分摊费用");
        costField.setLength(18);
        costField.setDecimalPad(2);
        costField.setFormat("#,###,###,###,###,##0.00");
        costField.setRequired(true);
        costField.setHidden(false);

        integralField = new DataSourceFloatField("settlement", "项目积分");
        integralField.setLength(18);
        integralField.setDecimalPad(2);
        integralField.setFormat("#,###,###,###,###,##0.00");
        integralField.setRequired(true);
        integralField.setHidden(false);

        projectIdField = new DataSourceIntegerField("projectId", "项目编码");
        projectIdField.setLength(11);
        projectIdField.setRequired(false);
        projectIdField.setHidden(true);
//        projectIdField.setValueMap(KeyValueManager.getValueMap("project_contract_codes"));
        KeyValueManager.loadValueMap("project_contract_codes", projectIdField);

        projectEmployeeIdField = new DataSourceIntegerField("projectEmployeeId", "项目组建编码");
        projectEmployeeIdField.setLength(11);
        projectEmployeeIdField.setPrimaryKey(true);
        projectEmployeeIdField.setRequired(true);
        projectEmployeeIdField.setHidden(true);

        employeeIdField = new DataSourceIntegerField("employeeId", "员工编码");
        employeeIdField.setLength(11);
        employeeIdField.setRequired(false);
        employeeIdField.setHidden(true);

        setFields(projectEmployeeIdField, projectManageIdField, projectNameField, workContentField, startDateField, endDateField, planIntegralField, realIntegralField, costField, integralField, projectIdField, employeeIdField);
    }

}
