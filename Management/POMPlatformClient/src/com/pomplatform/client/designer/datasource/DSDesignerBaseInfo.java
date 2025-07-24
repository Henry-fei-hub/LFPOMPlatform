package com.pomplatform.client.designer.datasource;

import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSDesignerBaseInfo extends DBDataSource {

    public static DSDesignerBaseInfo instance = null;

    public static DSDesignerBaseInfo getInstance() {
        if (instance == null) {
            instance = new DSDesignerBaseInfo("DSSemployeeNew");
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

    public DSDesignerBaseInfo(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_QUERY);
        setActionName("SemployeeNew");

        employeeIdField = new DataSourceIntegerField("employeeId", "员工编码");
        employeeIdField.setLength(11);
        employeeIdField.setPrimaryKey(true);
        employeeIdField.setRequired(true);
        employeeIdField.setHidden(true);

        employeeNoField = new DataSourceTextField("employeeNo", "我的登录名");
        employeeNoField.setLength(64);
        employeeNoField.setRequired(true);
        employeeNoField.setHidden(false);

        employeeNameField = new DataSourceTextField("employeeName", "我的姓名");
        employeeNameField.setLength(64);
        employeeNameField.setRequired(true);
        employeeNameField.setHidden(false);

        departmentIdField = new DataSourceIntegerField("departmentId", "我的部门");
        departmentIdField.setLength(11);
        departmentIdField.setRequired(false);
        departmentIdField.setHidden(false);
        departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));

        roleIdField = new DataSourceIntegerField("roleId", "我的角色");
        roleIdField.setLength(11);
        roleIdField.setRequired(false);
        roleIdField.setHidden(false);
        roleIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_10"));

        gradeIdField = new DataSourceIntegerField("gradeId", "我的等级");
        gradeIdField.setLength(11);
        gradeIdField.setRequired(false);
        gradeIdField.setHidden(false);
        gradeIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_3"));

        employeePasswordField = new DataSourceTextField("employeePassword", "密码");
        employeePasswordField.setLength(64);
        employeePasswordField.setRequired(false);
        employeePasswordField.setHidden(true);

        mobileField = new DataSourceTextField("mobile", "我的手机");
        mobileField.setLength(64);
        mobileField.setRequired(false);
        mobileField.setHidden(false);

        phoneField = new DataSourceTextField("phone", "我的电话");
        phoneField.setLength(64);
        phoneField.setRequired(false);
        phoneField.setHidden(false);

        qqField = new DataSourceTextField("qq", "我的QQ");
        qqField.setLength(64);
        qqField.setRequired(false);
        qqField.setHidden(false);

        emailField = new DataSourceTextField("email", "我的邮箱");
        emailField.setLength(64);
        emailField.setRequired(false);
        emailField.setHidden(false);

        onboardDateField = new DataSourceDateField("onboardDate", "入职日期");
        onboardDateField.setRequired(false);
        onboardDateField.setHidden(true);

        resignationDateField = new DataSourceDateField("resignationDate", "离职日期");
        resignationDateField.setRequired(false);
        resignationDateField.setHidden(true);

        statusField = new DataSourceIntegerField("status", "状态");
        statusField.setLength(11);
        statusField.setRequired(false);
        statusField.setHidden(true);
        statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_11"));

        usableStatusField = new DataSourceBooleanField("usableStatus", "工作是否饱和");
        usableStatusField.setRequired(false);
        usableStatusField.setHidden(false);

        isDepartmentField = new DataSourceBooleanField("isDepartment", "是否为部门负责人");
        isDepartmentField.setRequired(false);
        isDepartmentField.setHidden(true);

        photoField = new DataSourceImageField("photo", "我的头像");
        photoField.setImageURLPrefix("\\photos\\");
        photoField.setImageWidth(60);
        photoField.setImageHeight(60);
        photoField.setLength(64);
        photoField.setRequired(false);
        photoField.setHidden(false);

        genderField = new DataSourceIntegerField("gender", "性别");
        genderField.setLength(11);
        genderField.setRequired(false);
        genderField.setHidden(true);
        genderField.setValueMap(KeyValueManager.getValueMap("system_dictionary_12"));

        autographField = new DataSourceTextField("autograph", "我的签名");
        autographField.setLength(512);
        autographField.setRequired(false);
        autographField.setHidden(false);

        ageField = new DataSourceIntegerField("age", "age");
        ageField.setLength(11);
        ageField.setRequired(false);
        ageField.setHidden(true);

        birthField = new DataSourceDateField("birth", "出生日期");
        birthField.setRequired(false);
        birthField.setHidden(false);

        cardField = new DataSourceTextField("card", "身份证号");
        cardField.setLength(64);
        cardField.setRequired(false);
        cardField.setHidden(false);

        addressField = new DataSourceTextField("address", "家庭地址");
        addressField.setLength(64);
        addressField.setRequired(false);
        addressField.setHidden(false);

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

        plateIdField = new DataSourceIntegerField("plateId", "归属板块");
        plateIdField.setLength(11);
        plateIdField.setRequired(false);
        plateIdField.setHidden(false);
        plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));

        setFields(photoField, employeeIdField, employeeNoField, employeeNameField, departmentIdField, roleIdField,plateIdField, gradeIdField, employeePasswordField, mobileField, phoneField, qqField, emailField,cardField, birthField, onboardDateField, resignationDateField, statusField, usableStatusField, isDepartmentField, genderField, autographField, ageField,  addressField, alternateField1Field, alternateField2Field, alternateField3Field, lockedField);
    }

}
