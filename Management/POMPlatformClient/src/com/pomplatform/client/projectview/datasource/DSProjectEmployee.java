package com.pomplatform.client.projectview.datasource;

import com.delicacy.client.data.ClientUtil;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.ERPPermissionStatic;

public class DSProjectEmployee extends DBDataSource {

    public static DSProjectEmployee instance = null;

    public static DSProjectEmployee getInstance() {
        if (instance == null) {
            instance = new DSProjectEmployee("DSProjectEmployee");
        }
        return instance;
    }

    private final DataSourceIntegerField projectIdField;
    private final DataSourceIntegerField employeeIdField;
    private final DataSourceIntegerField designPhaseField;
    private final DataSourceIntegerField planWorkHoursField;
    private final DataSourceIntegerField realWorkHoursField;
    private final DataSourceFloatField planIntegralField;
    private final DataSourceFloatField realIntegralField;
    private final DataSourceFloatField costField;
    private final DataSourceFloatField settlementField;
    private final DataSourceDateField planStartDateField;
    private final DataSourceDateField planEndDateField;
    private final DataSourceDateField startDateField;
    private final DataSourceDateField endDateField;
    private final DataSourceTextField workContentField;
    private final DataSourceTextField alternateField1Field;
    private final DataSourceTextField alternateField2Field;
    private final DataSourceTextField alternateField3Field;
    private final DataSourceIntegerField statusField;
    private final DataSourceFloatField planIntegralPercentField;
    private final DataSourceFloatField realIntegralPercentField;
    private final DataSourceFloatField costPercentField;
    private final DataSourceFloatField advancedIntegralField;

    public DSProjectEmployee(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_QUERY);
        setActionName("MprojectemployeeForQuery");

        projectIdField = new DataSourceIntegerField("projectId", "项目名称");
        projectIdField.setLength(128);
        projectIdField.setRequired(false);
        projectIdField.setHidden(true);
//        KeyValueManager.loadValueMap("projects",projectIdField);
        KeyValueManager.loadValueMap("projects", projectIdField);

        employeeIdField = new DataSourceIntegerField("employeeId", "成员姓名");
        employeeIdField.setLength(64);
        employeeIdField.setRequired(false);
        employeeIdField.setHidden(false);
        employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

        designPhaseField = new DataSourceIntegerField("designPhase", "设计阶段");
        designPhaseField.setLength(64);
        designPhaseField.setRequired(false);
        designPhaseField.setHidden(false);
        designPhaseField.setValueMap(KeyValueManager.getValueMap("system_dictionary_7"));

        planWorkHoursField = new DataSourceIntegerField("planWorkHours", "预估工时");
        planWorkHoursField.setLength(11);
        planWorkHoursField.setRequired(false);
        planWorkHoursField.setHidden(true);

        realWorkHoursField = new DataSourceIntegerField("realWorkHours", "实际工时");
        realWorkHoursField.setLength(11);
        realWorkHoursField.setRequired(false);
        realWorkHoursField.setHidden(true);

        planIntegralField = new DataSourceFloatField("planIntegral", "预分配积分");
        planIntegralField.setLength(15);
        planIntegralField.setDecimalPad(2);
        planIntegralField.setFormat("#,###,###,###,##0.00");
        planIntegralField.setRequired(false);
        planIntegralField.setHidden(false);

        realIntegralField = new DataSourceFloatField("realIntegral", "确认积分");
        realIntegralField.setLength(15);
        realIntegralField.setDecimalPad(2);
        realIntegralField.setFormat("#,###,###,###,##0.00");
        realIntegralField.setRequired(false);
        realIntegralField.setHidden(false);

        costField = new DataSourceFloatField("cost", "项目成本");
        costField.setLength(15);
        costField.setDecimalPad(2);
        costField.setFormat("#,###,###,###,##0.00");
        costField.setRequired(false);
        costField.setHidden(false);

        settlementField = new DataSourceFloatField("settlement", "结算积分");
        settlementField.setLength(15);
        settlementField.setDecimalPad(2);
        settlementField.setFormat("#,###,###,###,##0.00");
        settlementField.setRequired(false);
        settlementField.setHidden(false);

        planStartDateField = new DataSourceDateField("planStartDate", "计划开始日期");
        planStartDateField.setRequired(false);
        planStartDateField.setHidden(true);

        planEndDateField = new DataSourceDateField("planEndDate", "计划结束日期");
        planEndDateField.setRequired(false);
        planEndDateField.setHidden(true);

        startDateField = new DataSourceDateField("startDate", "实际开始日期");
        startDateField.setRequired(false);
        startDateField.setHidden(false);

        endDateField = new DataSourceDateField("endDate", "实际结束日期");
        endDateField.setRequired(false);
        endDateField.setHidden(false);

        workContentField = new DataSourceTextField("workContent", "工作内容");
        workContentField.setLength(1024);
        workContentField.setRequired(false);
        workContentField.setHidden(false);

        alternateField1Field = new DataSourceTextField("alternateField1", "备用字段1");
        alternateField1Field.setLength(512);
        alternateField1Field.setRequired(false);
        alternateField1Field.setHidden(true);

        alternateField2Field = new DataSourceTextField("alternateField2", "备用字段2");
        alternateField2Field.setLength(512);
        alternateField2Field.setRequired(false);
        alternateField2Field.setHidden(true);

        alternateField3Field = new DataSourceTextField("alternateField3", "备用字段3");
        alternateField3Field.setLength(512);
        alternateField3Field.setRequired(false);
        alternateField3Field.setHidden(true);

        statusField = new DataSourceIntegerField("status", "状态");
        statusField.setLength(64);
        statusField.setRequired(false);
        statusField.setHidden(true);
        statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_11"));
        
        planIntegralPercentField = new DataSourceFloatField("planIntegralPercent","预分配积分占比(%)");
        planIntegralPercentField.setLength(18);
        planIntegralPercentField.setFormat("#,###,###,###,###,##0.00");
        planIntegralPercentField.setRequired(true);
        planIntegralPercentField.setHidden(false);
		
        realIntegralPercentField = new DataSourceFloatField("realIntegralPercent","确认积分占比(%)");
        realIntegralPercentField.setLength(18);
        realIntegralPercentField.setFormat("#,###,###,###,###,##0.00");
        realIntegralPercentField.setRequired(true);
        realIntegralPercentField.setHidden(false);
		
        costPercentField = new DataSourceFloatField("costPercent","项目成本占比(%)");
        costPercentField.setLength(18);
		costPercentField.setFormat("#,###,###,###,###,##0.00");
		costPercentField.setRequired(true);
		costPercentField.setHidden(false);
		
        //通过权限控制显示的数据内容；如果拥有查看项目所有信息或者查看项目重要信息的权限，则开放所有的内容
        if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.PROJECT_ALL_INFO_DATA) || ClientUtil.checkIsHavePermission(ERPPermissionStatic.PROJECT_MASTER_INFO_DATA)){
            planIntegralField.setHidden(false);
            realIntegralField.setHidden(false);
            costField.setHidden(false);
            settlementField.setHidden(false);
        }
        
        advancedIntegralField = new DataSourceFloatField("advancedIntegral", "项目补贴积分");
		advancedIntegralField.setLength(10);
		advancedIntegralField.setDecimalPad(2);
		advancedIntegralField.setFormat("##,###,##0.00");
		advancedIntegralField.setRequired(false);
		advancedIntegralField.setHidden(false);

        setFields(projectIdField, employeeIdField, designPhaseField, planWorkHoursField, realWorkHoursField, planIntegralField, realIntegralField, costField, settlementField, advancedIntegralField,planStartDateField, planEndDateField, startDateField, endDateField, workContentField, alternateField1Field, alternateField2Field, alternateField3Field, statusField,planIntegralPercentField,realIntegralPercentField,costPercentField);
    }

}
