package com.pomplatform.client.project.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSProjectChangeEmployee extends DBDataSource {

    public static DSProjectChangeEmployee instance = null;

    public static DSProjectChangeEmployee getInstance() {
        if (instance == null) {
            instance = new DSProjectChangeEmployee("DSProjectChangeEmployee");
        }
        return instance;
    }

    private final DataSourceIntegerField projectIdField;
    private final DataSourceIntegerField employeeIdField;
    private final DataSourceTextField employeeNoField;
    private final DataSourceTextField employeeNameField;
    private final DataSourceIntegerField plateIdField;
    private final DataSourceIntegerField gradeIdField;
    private final DataSourceIntegerField statusField;
    private final DataSourceFloatField integralField;
    
    
    public DSProjectChangeEmployee(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_TABLE);
		setActionName("ProjectEmployee");

        projectIdField = new DataSourceIntegerField("projectId", "项目名称");
        projectIdField.setLength(11);
        projectIdField.setRequired(false);
        projectIdField.setHidden(true);
        projectIdField.setCanEdit(false);
//        KeyValueManager.loadValueMap("projects",projectIdField);
        KeyValueManager.loadValueMap("projects",projectIdField);
        employeeIdField = new DataSourceIntegerField("employeeId", "员工ID");
        employeeIdField.setLength(11);
        employeeIdField.setHidden(true);
        employeeIdField.setCanEdit(false);

        employeeNoField = new DataSourceTextField("employeeNo", "职员编号");
        employeeNoField.setLength(11);
        employeeNoField.setRequired(false);
        employeeNoField.setHidden(false);

        employeeNameField = new DataSourceTextField("employeeName", "职员姓名");
        employeeNameField.setLength(64);
        employeeNameField.setRequired(false);
        employeeNameField.setHidden(false);


        plateIdField = new DataSourceIntegerField("plateId", "业务部门");
        plateIdField.setRequired(false);
        plateIdField.setHidden(false);
        plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
        
        statusField = new DataSourceIntegerField("status", "状态");
        statusField.setLength(11);
        statusField.setRequired(false);
        statusField.setHidden(false);
        statusField.setCanEdit(false);
        statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_11"));
        
        gradeIdField = new DataSourceIntegerField("gradeId", "职级");
        gradeIdField.setLength(11);
        gradeIdField.setRequired(false);
        gradeIdField.setHidden(false);
        gradeIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_3"));
        
        integralField = new DataSourceFloatField("integral", "扣减积分");
        integralField.setLength(18);
        integralField.setDecimalPad(2);
        integralField.setFormat("#,###,###,###,###,##0.00");
        integralField.setRequired(false);
//        integralField.setCanEdit(true);
        integralField.setHidden(false);

        setFields(projectIdField, employeeIdField, employeeNoField, employeeNameField, plateIdField, statusField,gradeIdField,integralField);
    }

}
