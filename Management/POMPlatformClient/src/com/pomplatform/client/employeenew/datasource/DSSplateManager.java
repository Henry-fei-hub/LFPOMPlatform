package com.pomplatform.client.employeenew.datasource;

import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSplateManager extends DBDataSource {

    public static DSSplateManager instance = null;

    public static DSSplateManager getInstance() {
        if (instance == null) {
            instance = new DSSplateManager("DSSemployeeNew");
        }
        return instance;
    }

    private final DataSourceIntegerField employeeIdField;
    private final DataSourceTextField employeeNoField;
    private final DataSourceTextField employeeNameField;
    private final DataSourceIntegerField roleIdField;
    private final DataSourceIntegerField gradeIdField;
    private final DataSourceTextField mobileField;
    private final DataSourceTextField phoneField;
    private final DataSourceTextField qqField;
    private final DataSourceTextField emailField;
    private final DataSourceImageField photoField;
    private final DataSourceIntegerField genderField;
    private final DataSourceTextField autographField;
    private final DataSourceIntegerField dutyIdField;
    private final DataSourceTextField employeeNameEnField;
    private final DataSourceBooleanField usableStatusField;
    private final DataSourceIntegerField statusField;

    public DSSplateManager(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_QUERY);
        setActionName("SemployeeNew");

        employeeIdField = new DataSourceIntegerField("employeeId", "员工编码");
        employeeIdField.setLength(11);
        employeeIdField.setPrimaryKey(true);
        employeeIdField.setRequired(true);
        employeeIdField.setHidden(true);
        
        statusField = new DataSourceIntegerField("status", "状态");
        statusField.setLength(11);
        statusField.setRequired(false);
        statusField.setHidden(false);
        statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_11"));

        employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
        employeeNoField.setLength(64);
        employeeNoField.setRequired(true);
        employeeNoField.setHidden(false);

        employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
        employeeNameField.setLength(64);
        employeeNameField.setRequired(true);
        employeeNameField.setHidden(false);

        roleIdField = new DataSourceIntegerField("roleId", "角色类型");
        roleIdField.setLength(11);
        roleIdField.setRequired(false);
        roleIdField.setHidden(false);
        roleIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_10"));

        gradeIdField = new DataSourceIntegerField("gradeId", "等级");
        gradeIdField.setLength(11);
        gradeIdField.setRequired(false);
        gradeIdField.setHidden(false);
        gradeIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_3"));

        mobileField = new DataSourceTextField("mobile", "手机");
        mobileField.setLength(64);
        mobileField.setRequired(false);
        mobileField.setHidden(false);

        phoneField = new DataSourceTextField("phone", "电话");
        phoneField.setLength(64);
        phoneField.setRequired(false);
        phoneField.setHidden(false);

        qqField = new DataSourceTextField("qq", "QQ");
        qqField.setLength(64);
        qqField.setRequired(false);
        qqField.setHidden(false);

        emailField = new DataSourceTextField("email", "邮箱");
        emailField.setLength(64);
        emailField.setRequired(false);
        emailField.setHidden(false);

        photoField = new DataSourceImageField("photo", "头像");
//        photoField.setImageURLPrefix("/images/photos/");  
        photoField.setImageWidth(60);
        photoField.setImageHeight(60);
        photoField.setLength(64);
        photoField.setRequired(false);
        photoField.setHidden(false);

        genderField = new DataSourceIntegerField("gender", "性别");
        genderField.setLength(11);
        genderField.setRequired(false);
        genderField.setHidden(false);
        genderField.setValueMap(KeyValueManager.getValueMap("system_dictionary_12"));

        autographField = new DataSourceTextField("autograph", "我的签名");
        autographField.setLength(512);
        autographField.setRequired(false);
        autographField.setHidden(false);

        dutyIdField = new DataSourceIntegerField("dutyId", "职务名称");
        dutyIdField.setLength(11);
        dutyIdField.setHidden(false);
        dutyIdField.setValueMap(KeyValueManager.getValueMap("duties"));
        
        employeeNameEnField = new DataSourceTextField("employeeNameEn", "英文名称");
        employeeNameEnField.setLength(11);
        employeeNameEnField.setHidden(false);
        
        usableStatusField = new DataSourceBooleanField("usableStatus", "工作是否饱和");
        usableStatusField.setRequired(false);
        usableStatusField.setHidden(false);
        
        setFields(photoField, employeeIdField, employeeNoField, employeeNameField,employeeNameEnField, roleIdField,dutyIdField, gradeIdField, mobileField, phoneField, qqField, emailField, genderField,usableStatusField, statusField,autographField);
    }

}
