package com.pomplatform.client.projectteambuild.datasource;

import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;

public class DSProjectEmployee extends DBDataSource {

    public static DSProjectEmployee instance = null;

    public static DSProjectEmployee getInstance() {
        if (instance == null) {
            instance = new DSProjectEmployee("DSProjectEmployee");
        }
        return instance;
    }

    private final DataSourceIntegerField projectEmployeeIdField;
    private final DataSourceIntegerField projectIdField;
    private final DataSourceIntegerField employeeIdField;
    private final DataSourceIntegerField designPhaseField;
    private final DataSourceTextField planWorkHoursField;
    private final DataSourceTextField factWorkHoursField;
    private final DataSourceFloatField planIntegralField;
    private final DataSourceFloatField settlementField;
    private final DataSourceFloatField costField;
    private final DataSourceTextField realIntegralField;
    private final DataSourceDateField startDateField;
    private final DataSourceDateField endDateField;
    private final DataSourceDateField planStartDateField;
    private final DataSourceDateField planEndDateField;
    private final DataSourceTextField workContentField;
    private final DataSourceIntegerField statusField;
    private final DataSourceTextField gradeIdField;
    private final DataSourceIntegerField stageIdField;
    
    
    public DSProjectEmployee(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_TABLE);
		setActionName("ProjectEmployee");

        projectEmployeeIdField = new DataSourceIntegerField("projectEmployeeId", "项目组建编码");
        projectEmployeeIdField.setLength(11);
        projectEmployeeIdField.setPrimaryKey(true);
        projectEmployeeIdField.setRequired(true);
        projectEmployeeIdField.setHidden(true);

        projectIdField = new DataSourceIntegerField("projectId", "项目名称");
        projectIdField.setLength(11);
        projectIdField.setRequired(false);
        projectIdField.setHidden(true);
        projectIdField.setCanEdit(false);
        KeyValueManager.loadValueMap("projects",projectIdField);

        employeeIdField = new DataSourceIntegerField("employeeId", "设计师");
        employeeIdField.setLength(11);
        employeeIdField.setRequired(false);
        employeeIdField.setHidden(false);
        employeeIdField.setCanEdit(false);
        employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

        designPhaseField = new DataSourceIntegerField("designPhase", "设计阶段");
        designPhaseField.setLength(11);
        designPhaseField.setRequired(false);
        designPhaseField.setHidden(true);
        designPhaseField.setValueMap(KeyValueManager.getValueMap("system_dictionary_7"));

        planWorkHoursField = new DataSourceTextField("planWorkHours", "预估工时");
        planWorkHoursField.setLength(64);
        planWorkHoursField.setRequired(false);
        planWorkHoursField.setHidden(true);

        factWorkHoursField = new DataSourceTextField("factWorkHours", "实际工时");
        factWorkHoursField.setLength(64);
        factWorkHoursField.setRequired(false);
        factWorkHoursField.setHidden(true);

        planIntegralField = new DataSourceFloatField("planIntegral", "预分配积分");
        planIntegralField.setLength(18);
        planIntegralField.setDecimalPad(2);
        planIntegralField.setFormat("#,###,###,###,###,##0.00");
        planIntegralField.setRequired(false);
        planIntegralField.setHidden(false);

        settlementField = new DataSourceFloatField("settlement", "结算积分");
        settlementField.setCanEdit(false);
        settlementField.setLength(18);
        settlementField.setDecimalPad(2);
        settlementField.setFormat("#,###,###,###,###,##0.00");
        settlementField.setRequired(false);
        settlementField.setHidden(false);
        
        costField = new DataSourceFloatField("cost", "项目成本");
        costField.setCanEdit(false);
        costField.setLength(18);
        costField.setDecimalPad(2);
        costField.setFormat("#,###,###,###,###,##0.00");
        costField.setRequired(false);
        costField.setHidden(false);
        
        realIntegralField = new DataSourceTextField("realIntegral", "实际获得积分");
        realIntegralField.setCanEdit(false);
        realIntegralField.setLength(64);
        realIntegralField.setRequired(false);
        realIntegralField.setHidden(true);

        startDateField = new DataSourceDateField("startDate", "开始日期");
        startDateField.setRequired(false);
        startDateField.setHidden(true);

        endDateField = new DataSourceDateField("endDate", "结束日期");
        endDateField.setRequired(false);
        endDateField.setHidden(true);
        
        planStartDateField = new DataSourceDateField("planStartDate", "开始日期");
        planStartDateField.setRequired(false);
        planStartDateField.setHidden(false);

        planEndDateField = new DataSourceDateField("planEndDate", "结束日期");
        planEndDateField.setRequired(false);
        planEndDateField.setHidden(false);
        
        workContentField = new DataSourceTextField("workContent", "工作内容");
        workContentField.setLength(64);
        workContentField.setRequired(false);
        workContentField.setHidden(false);

        statusField = new DataSourceIntegerField("status", "状态");
        statusField.setLength(11);
        statusField.setRequired(false);
        statusField.setHidden(false);
        statusField.setCanEdit(false);
        statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_5"));
        
        gradeIdField = new DataSourceTextField("gradeId", "职级");
        gradeIdField.setLength(11);
        gradeIdField.setRequired(false);
        gradeIdField.setHidden(false);
        gradeIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_3"));
        gradeIdField.setCanEdit(false);

        stageIdField = new DataSourceIntegerField("stageId","阶段id");
        stageIdField.setLength(11);
        stageIdField.setRequired(false);
        stageIdField.setHidden(false);
        stageIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_7"));
        
        setFields(projectEmployeeIdField, projectIdField, employeeIdField, designPhaseField, planWorkHoursField, factWorkHoursField, planIntegralField,settlementField,costField, realIntegralField, startDateField, endDateField,planStartDateField,planEndDateField,gradeIdField, statusField,workContentField);
    }

}
