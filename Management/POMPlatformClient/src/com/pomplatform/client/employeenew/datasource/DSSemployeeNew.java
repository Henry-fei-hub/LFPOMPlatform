package com.pomplatform.client.employeenew.datasource;

import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSemployeeNew extends DBDataSource {

    public static DSSemployeeNew instance = null;

    public static DSSemployeeNew getInstance() {
        if (instance == null) {
            instance = new DSSemployeeNew("DSSemployeeNew");
        }
        return instance;
    }

    private final DataSourceIntegerField employeeIdField;
    private final DataSourceTextField employeeNoField;
    private final DataSourceTextField employeeNameField;
    private final DataSourceIntegerField departmentIdField;
    private final DataSourceIntegerField roleIdField;
    private final DataSourceIntegerField gradeIdField;
    private final DataSourceTextField employeePasswordField;
    private final DataSourceTextField mobileField;
    private final DataSourceTextField phoneField;
    private final DataSourceTextField qqField;
    private final DataSourceTextField emailField;
    private final DataSourceDateField onboardDateField;
    private final DataSourceDateField resignationDateField;
    private final DataSourceIntegerField statusField;
    private final DataSourceBooleanField usableStatusField;
    private final DataSourceBooleanField isDepartmentField;
    private final DataSourceImageField photoField;
    private final DataSourceIntegerField genderField;
    private final DataSourceTextField autographField;
    private final DataSourceIntegerField ageField;
    private final DataSourceDateField birthField;
    private final DataSourceTextField cardField;
    private final DataSourceTextField addressField;
    private final DataSourceTextField alternateField1Field;
    private final DataSourceTextField alternateField2Field;
    private final DataSourceTextField alternateField3Field;
    private final DataSourceBooleanField lockedField;
    private final DataSourceIntegerField plateIdField;
    private final DataSourceIntegerField dutyIdField;
    private final DataSourceTextField userAcctField;
    private final DataSourceTextField employeeNameEnField;
    private final DataSourceTextField educationField;
    private final DataSourceTextField degreeField;
    private final DataSourceTextField nationalityField;
    private final DataSourceTextField marriedStatusField;
    private final DataSourceTextField healthField;
    private final DataSourceTextField workAddressField;
    private final DataSourceTextField registeredAddressField;
    private final DataSourceIntegerField directLeaderField;

    public DSSemployeeNew(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_QUERY);
        setActionName("SemployeeForHR");
        
        employeeIdField = new DataSourceIntegerField("employeeId", "员工编码");
        employeeIdField.setLength(11);
        employeeIdField.setPrimaryKey(true);
        employeeIdField.setRequired(true);
        employeeIdField.setHidden(true);
        employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

        employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
        employeeNoField.setLength(64);
        employeeNoField.setRequired(true);
        employeeNoField.setHidden(false);

        employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
        employeeNameField.setLength(64);
        employeeNameField.setRequired(true);
        employeeNameField.setHidden(false);

        departmentIdField = new DataSourceIntegerField("departmentId", "部门");
        departmentIdField.setLength(11);
        departmentIdField.setRequired(false);
        departmentIdField.setHidden(false);
        departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));

        roleIdField = new DataSourceIntegerField("roleId", "角色");
        roleIdField.setLength(11);
        roleIdField.setRequired(false);
        roleIdField.setHidden(false);
//        roleIdField.setValueMap(KeyValueManager.getValueMap("roles"));“
        KeyValueManager.loadValueMap("roles",roleIdField);

        gradeIdField = new DataSourceIntegerField("gradeId", "等级");
        gradeIdField.setLength(11);
        gradeIdField.setRequired(false);
        gradeIdField.setHidden(false);
        gradeIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_3"));

        employeePasswordField = new DataSourceTextField("employeePassword", "密码");
        employeePasswordField.setLength(64);
        employeePasswordField.setRequired(false);
        employeePasswordField.setHidden(true);

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

        onboardDateField = new DataSourceDateField("onboardDate", "入职日期");
        onboardDateField.setRequired(false);
        onboardDateField.setHidden(false);

        resignationDateField = new DataSourceDateField("resignationDate", "离职日期");
        resignationDateField.setRequired(false);
        resignationDateField.setHidden(true);

        statusField = new DataSourceIntegerField("status", "状态");
        statusField.setLength(11);
        statusField.setRequired(false);
        statusField.setHidden(false);
        statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_11"));

        usableStatusField = new DataSourceBooleanField("usableStatus", "是否可用");
        usableStatusField.setRequired(false);
        usableStatusField.setHidden(true);

        isDepartmentField = new DataSourceBooleanField("isDepartment", "是否为部门负责人");
        isDepartmentField.setRequired(false);
        isDepartmentField.setHidden(true);

        photoField = new DataSourceImageField("photo", "头像");
        photoField.setLength(512);
        photoField.setRequired(false);
        photoField.setHidden(false);
        photoField.setImageHeight(60);
        photoField.setImageWidth(60);

        genderField = new DataSourceIntegerField("gender", "性别");
        genderField.setLength(11);
        genderField.setRequired(false);
        genderField.setHidden(true);
        genderField.setValueMap(KeyValueManager.getValueMap("system_dictionary_12"));

        autographField = new DataSourceTextField("autograph", "我的签名");
        autographField.setLength(512);
        autographField.setRequired(false);
        autographField.setHidden(true);

        ageField = new DataSourceIntegerField("age", "age");
        ageField.setLength(11);
        ageField.setRequired(false);
        ageField.setHidden(true);

        birthField = new DataSourceDateField("birth", "出生日期");
        birthField.setRequired(false);
        birthField.setLength(2);
        birthField.setHidden(true);

        cardField = new DataSourceTextField("card", "身份证号");
        cardField.setLength(64);
        cardField.setRequired(false);
        cardField.setHidden(true);

        addressField = new DataSourceTextField("address", "家庭地址");
        addressField.setLength(512);
        addressField.setRequired(false);
        addressField.setHidden(true);

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

        lockedField = new DataSourceBooleanField("locked", "是否锁定");
        lockedField.setRequired(false);
        lockedField.setHidden(true);

        plateIdField = new DataSourceIntegerField("plateId", "板块");
        plateIdField.setLength(11);
        plateIdField.setRequired(false);
        plateIdField.setHidden(true);
        plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));

        dutyIdField = new DataSourceIntegerField("dutyId", "职位名称");
        dutyIdField.setLength(11);
        dutyIdField.setRequired(false);
        dutyIdField.setHidden(true);
        dutyIdField.setValueMap(KeyValueManager.getValueMap("duties"));

        userAcctField = new DataSourceTextField("userAcct", "上级领导");
        userAcctField.setLength(64);
        userAcctField.setRequired(false);
        userAcctField.setHidden(true);

        employeeNameEnField = new DataSourceTextField("employeeNameEn", "英文名");
        employeeNameEnField.setLength(64);
        employeeNameEnField.setRequired(false);
        employeeNameEnField.setHidden(true);

        educationField = new DataSourceTextField("education", "学历");
        educationField.setLength(64);
        educationField.setRequired(false);
        educationField.setHidden(true);

        degreeField = new DataSourceTextField("degree", "学位");
        degreeField.setLength(64);
        degreeField.setRequired(false);
        degreeField.setHidden(true);

        nationalityField = new DataSourceTextField("nationality", "名族");
        nationalityField.setLength(64);
        nationalityField.setRequired(false);
        nationalityField.setHidden(true);

        marriedStatusField = new DataSourceTextField("marriedStatus", "婚姻状况");
        marriedStatusField.setLength(64);
        marriedStatusField.setRequired(false);
        marriedStatusField.setHidden(true);

        healthField = new DataSourceTextField("health", "身体状况");
        healthField.setLength(64);
        healthField.setRequired(false);
        healthField.setHidden(true);

        workAddressField = new DataSourceTextField("workAddress", "工作地");
        workAddressField.setLength(128);
        workAddressField.setRequired(false);
        workAddressField.setHidden(true);

        registeredAddressField = new DataSourceTextField("registeredAddress", "注册地");
        registeredAddressField.setLength(128);
        registeredAddressField.setRequired(false);
        registeredAddressField.setHidden(true);
        
        directLeaderField = new DataSourceIntegerField("directLeader", "直属上级");
        directLeaderField.setLength(11);
        directLeaderField.setRequired(true);
        directLeaderField.setHidden(false);
        directLeaderField.setValueMap(KeyValueManager.getValueMap("employees"));

        setFields(photoField, employeeIdField, employeeNoField, employeeNameField, departmentIdField, roleIdField,directLeaderField, gradeIdField, employeePasswordField, mobileField, phoneField, qqField, emailField, onboardDateField, resignationDateField, statusField, usableStatusField, isDepartmentField, genderField, autographField, ageField, birthField, cardField, addressField, alternateField1Field, alternateField2Field, alternateField3Field, lockedField, plateIdField, dutyIdField, userAcctField, employeeNameEnField, educationField, degreeField, nationalityField, marriedStatusField, healthField, workAddressField, registeredAddressField);
    }

}
