package com.pomplatform.client.employeenew.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.employeenew.datasource.DSSemployeeNew;

public class SemployeeNewNewForm extends AbstractWizadPage {

	private final TextItem employeeNoItem;
	private final TextItem employeeNameItem;
	private final IPickTreeItem departmentIdItem;
	private final SelectItem roleIdItem;
	private final SelectItem gradeIdItem;
	private final TextItem mobileItem;
	private final TextItem phoneItem;
	private final TextItem qqItem;
	private final TextItem emailItem;
	private final CheckboxItem isDepartmentItem;
	private final SelectItem genderItem;
	private final TextItem autographItem;
	private final TextItem addressItem;
	private final SelectItem plateIdItem;

	private final IPickTreeItem dutyIdItem;
	private final TextItem employeeNameEnItem;
	private final TextItem educationItem;
	private final TextItem degreeItem;
	private final TextItem nationalityItem;
	private final TextItem marriedStatusItem;
	private final TextItem healthItem;
	private final TextItem workAddressItem;
	private final TextItem registeredAddressItem;

	public SemployeeNewNewForm() {
		DSSemployeeNew ds = DSSemployeeNew.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		employeeNoItem = new TextItem("employeeNo", "登陆名");
		employeeNoItem.setWidth("*");
		employeeNoItem.setRequired(true);
		__formItems.add(employeeNoItem);

		IsStringValidator employeeNoValidator = new IsStringValidator();
		LengthRangeValidator employeeNoLengthValidator = new LengthRangeValidator();
		employeeNoLengthValidator.setMax(64);
		employeeNoItem.setValidators(employeeNoValidator, employeeNoLengthValidator);
		employeeNameItem = new TextItem("employeeName", "员工姓名");
		employeeNameItem.setWidth("*");
		employeeNameItem.setRequired(true);
		IsStringValidator employeeNameValidator = new IsStringValidator();
		LengthRangeValidator employeeNameLengthValidator = new LengthRangeValidator();
		employeeNameLengthValidator.setMax(64);
		employeeNameItem.setValidators(employeeNameValidator, employeeNameLengthValidator);
		__formItems.add(employeeNameItem);

		departmentIdItem = new IPickTreeItem("departmentId", "部门");
		departmentIdItem.setWidth("*");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));
		__formItems.add(departmentIdItem);

		roleIdItem = new SelectItem("roleId", "角色类型");
		roleIdItem.setWidth("*");
		roleIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_10"));
		__formItems.add(roleIdItem);

		gradeIdItem = new SelectItem("gradeId", "等级");
		gradeIdItem.setWidth("*");
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

		isDepartmentItem = new CheckboxItem("isDepartment", "是否为部门负责人");
		__formItems.add(isDepartmentItem);

		genderItem = new SelectItem("gender", "性别");
		genderItem.setWidth("*");
		genderItem.setValueMap((LinkedHashMap) ds.getField("gender").getValueMap());
		__formItems.add(genderItem);

		autographItem = new TextItem("autograph", "我的签名");
		autographItem.setWidth("*");
		__formItems.add(autographItem);

		addressItem = new TextItem("address", "家庭地址");
		addressItem.setWidth("*");
		__formItems.add(addressItem);

		plateIdItem = new SelectItem("plateId", "归属板块");
		plateIdItem.setWidth("*");
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		__formItems.add(plateIdItem);

		dutyIdItem = new IPickTreeItem("dutyId", "职务");
		dutyIdItem.setWidth("*");
		dutyIdItem.setCanSelectParentItems(true);
		dutyIdItem.setValueTree(KeyValueManager.getTree("duties"));
		__formItems.add(dutyIdItem);

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

		marriedStatusItem = new TextItem("marriedStatus", "婚姻状态");
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
		addMember(__form);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public void startEdit() {
		if (getRecord() != null) {
			__form.editRecord(getRecord());
		} else {
			__form.editNewRecord();
		}
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSSemployeeNew.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		Map values = __form.getValues();
		ClientUtil.departmentParameterProcess(values);
		return values;
	}
}
