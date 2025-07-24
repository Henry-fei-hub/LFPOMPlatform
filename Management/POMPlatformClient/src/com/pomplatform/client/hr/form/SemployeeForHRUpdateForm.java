package com.pomplatform.client.hr.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.hr.datasource.DSSemployeeForHR;

public class SemployeeForHRUpdateForm extends AbstractWizadPage {

    private final TextItem employeeNoItem;
    private final TextItem employeeNameItem;
    private final SelectItem departmentIdItem;
    private final SelectItem roleIdItem;
    private final SelectItem gradeIdItem;
    private final TextItem mobileItem;
    private final TextItem phoneItem;
    private final TextItem qqItem;
    private final TextItem emailItem;
    private final SelectItem statusItem;
    private final CheckboxItem isDepartmentItem;
    private final TextItem photoItem;
    private final SelectItem genderItem;
    private final TextItem autographItem;
    private final TextItem ageItem;
    private final DateItem birthItem;
    private final TextItem cardItem;
    private final TextItem addressItem;
    
    
    private final SelectItem plateIdItem;
    private final SelectItem dutyIdItem;
    private final TextItem userAcctItem;
    private final TextItem employeeNameEnItem;
    private final TextItem educationItem;
    private final TextItem degreeItem;
    private final TextItem nationalityItem;
    private final TextItem marriedStatusItem;
    private final TextItem healthItem;
    private final TextItem workAddressItem;
    private final TextItem registeredAddressItem;

    public SemployeeForHRUpdateForm() {
        DSSemployeeForHR ds = DSSemployeeForHR.getInstance();
        __form.setWidth100();
        __form.setHeight100();
        
        employeeNoItem = new TextItem("employeeNo", "员工编号");
        employeeNoItem.setWidth("*");
        employeeNoItem.setRequired(true);
        IsStringValidator employeeNoValidator = new IsStringValidator();
        LengthRangeValidator employeeNoLengthValidator = new LengthRangeValidator();
        employeeNoLengthValidator.setMax(64);
        employeeNoItem.setValidators(employeeNoValidator, employeeNoLengthValidator);
        __formItems.add(employeeNoItem);
        employeeNameItem = new TextItem("employeeName", "员工姓名");
        employeeNameItem.setWidth("*");
        employeeNameItem.setRequired(true);
        IsStringValidator employeeNameValidator = new IsStringValidator();
        LengthRangeValidator employeeNameLengthValidator = new LengthRangeValidator();
        employeeNameLengthValidator.setMax(64);
        employeeNameItem.setValidators(employeeNameValidator, employeeNameLengthValidator);
        __formItems.add(employeeNameItem);
        departmentIdItem = new SelectItem("departmentId", "角色编码");
        departmentIdItem.setValueMap((LinkedHashMap) ds.getField("departmentId").getValueMap());
        __formItems.add(departmentIdItem);
        roleIdItem = new SelectItem("roleId", "部门编码");
        roleIdItem.setValueMap((LinkedHashMap) ds.getField("roleId").getValueMap());
        __formItems.add(roleIdItem);
        gradeIdItem = new SelectItem("gradeId", "等级");
        gradeIdItem.setValueMap((LinkedHashMap) ds.getField("gradeId").getValueMap());
        __formItems.add(gradeIdItem);
        
        mobileItem = new TextItem("mobile", "手机");
        mobileItem.setWidth("*");
        __formItems.add(mobileItem);
        phoneItem = new TextItem("phone", "电话");
        phoneItem.setWidth("*");
        __formItems.add(phoneItem);
        qqItem = new TextItem("qq", "QQ");
        qqItem.setWidth("*");
        __formItems.add(qqItem);
        emailItem = new TextItem("email", "邮箱");
        emailItem.setWidth("*");
        __formItems.add(emailItem);
        
        statusItem = new SelectItem("status", "状态");
        statusItem.setValueMap((LinkedHashMap) ds.getField("status").getValueMap());
        __formItems.add(statusItem);
        
        isDepartmentItem = new CheckboxItem("isDepartment", "是否为部门负责人");
        __formItems.add(isDepartmentItem);
        photoItem = new TextItem("photo", "头像");
        photoItem.setWidth("*");
        __formItems.add(photoItem);
        genderItem = new SelectItem("gender", "性别");
        genderItem.setValueMap((LinkedHashMap) ds.getField("gender").getValueMap());
        __formItems.add(genderItem);
        autographItem = new TextItem("autograph", "我的签名");
        autographItem.setWidth("*");
        __formItems.add(autographItem);
        ageItem = new TextItem("age", "age");
        ageItem.setWidth("*");
        __formItems.add(ageItem);
        birthItem = new DateItem("birth", "出生日期");
        __formItems.add(birthItem);
        cardItem = new TextItem("card", "身份证号");
        cardItem.setWidth("*");
        __formItems.add(cardItem);
        addressItem = new TextItem("address", "家庭地址");
        addressItem.setWidth("*");
        __formItems.add(addressItem);
        
        plateIdItem = new SelectItem("plateId", "板块");
        plateIdItem.setValueMap((LinkedHashMap) ds.getField("plateId").getValueMap());
        __formItems.add(plateIdItem);
        dutyIdItem = new SelectItem("dutyId", "职位名称");
        dutyIdItem.setValueMap((LinkedHashMap) ds.getField("dutyId").getValueMap());
        __formItems.add(dutyIdItem);
        userAcctItem = new TextItem("userAcct", "上级领导");
        userAcctItem.setWidth("*");
        __formItems.add(userAcctItem);
        employeeNameEnItem = new TextItem("employeeNameEn", "英文名");
        employeeNameEnItem.setWidth("*");
        __formItems.add(employeeNameEnItem);
        educationItem = new TextItem("education", "学历");
        educationItem.setWidth("*");
        __formItems.add(educationItem);
        degreeItem = new TextItem("degree", "学位");
        degreeItem.setWidth("*");
        __formItems.add(degreeItem);
        nationalityItem = new TextItem("nationality", "名族");
        nationalityItem.setWidth("*");
        __formItems.add(nationalityItem);
        marriedStatusItem = new TextItem("marriedStatus", "婚姻状况");
        marriedStatusItem.setWidth("*");
        __formItems.add(marriedStatusItem);
        healthItem = new TextItem("health", "身体状况");
        healthItem.setWidth("*");
        __formItems.add(healthItem);
        workAddressItem = new TextItem("workAddress", "工作地");
        workAddressItem.setWidth("*");
        __formItems.add(workAddressItem);
        registeredAddressItem = new TextItem("registeredAddress", "注册地");
        registeredAddressItem.setWidth("*");
        __formItems.add(registeredAddressItem);

        __form.setItems(getFormItemArray());
        __form.setDataSource(ds);
        __form.setNumCols(4);
        ClientUtil.DynamicFormProcessAccordingToDevice(__form);
        setPageMode(PAGE_MODE_UPDATE);
        addMember(__form);
    }

    @Override
    public void startEdit() {
        if (getRecord() != null) {
            __form.editRecord(getRecord());
        }
    }

    @Override
    public void setValueManage(ValuesManager manager) {
        manager.setDataSource(DSSemployeeForHR.getInstance());
        manager.addMember(__form);
    }

    @Override
    public boolean checkData() {
        return true;
    }

    @Override
    public java.util.Map getValuesAsMap() {
        return __form.getValues();
    }

}
