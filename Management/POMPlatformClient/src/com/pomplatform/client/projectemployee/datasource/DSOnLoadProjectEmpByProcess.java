package com.pomplatform.client.projectemployee.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSOnLoadProjectEmpByProcess extends DBDataSource
{


	public static DSOnLoadProjectEmpByProcess instance = null;

	public static DSOnLoadProjectEmpByProcess getInstance() {
		if(instance == null) {
			instance = new DSOnLoadProjectEmpByProcess("DSOnLoadProjectEmpByProcess");
		}
		return instance;
	}

	private final DataSourceIntegerField projectEmployeeIdField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField designPhaseField;
	private final DataSourceIntegerField planWorkHoursField;
	private final DataSourceIntegerField realWorkHoursField;
	private final DataSourceFloatField planIntegralField;
	private final DataSourceFloatField realIntegralField;
	private final DataSourceDateField planStartDateField;
	private final DataSourceDateField planEndDateField;
	private final DataSourceDateTimeField startDateField;
	private final DataSourceDateTimeField endDateField;
	private final DataSourceTextField workContentField;
	private final DataSourceTextField alternateField1Field;
	private final DataSourceTextField alternateField2Field;
	private final DataSourceTextField alternateField3Field;
	private final DataSourceFloatField costField;
	private final DataSourceFloatField settlementField;
	private final DataSourceFloatField employeeAchieveIntegralReturnField;
	private final DataSourceIntegerField stageIdField;
	private final DataSourceIntegerField flagField;
	private final DataSourceIntegerField businessIdField;
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
	private final DataSourceTextField photoField;
	private final DataSourceIntegerField genderField;
	private final DataSourceTextField autographField;
	private final DataSourceIntegerField ageField;
	private final DataSourceDateField birthField;
	private final DataSourceTextField cardField;
	private final DataSourceTextField addressField;
	private final DataSourceBooleanField lockedField;
	
	public DSOnLoadProjectEmpByProcess(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnLoadProjectEmpByProcess");


		projectEmployeeIdField = new DataSourceIntegerField("projectEmployeeId", "项目组建编码");
		projectEmployeeIdField.setLength(11);
		projectEmployeeIdField.setPrimaryKey(true);
		projectEmployeeIdField.setRequired(true);
		projectEmployeeIdField.setHidden(true);


		projectIdField = new DataSourceIntegerField("projectId", "项目主键");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(true);


		employeeIdField = new DataSourceIntegerField("employeeId", "创建人");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(true);


		designPhaseField = new DataSourceIntegerField("designPhase", "设计阶段");
		designPhaseField.setLength(11);
		designPhaseField.setRequired(false);
		designPhaseField.setHidden(true);


		planWorkHoursField = new DataSourceIntegerField("planWorkHours", "预估工时");
		planWorkHoursField.setLength(11);
		planWorkHoursField.setRequired(false);
		planWorkHoursField.setHidden(true);


		realWorkHoursField = new DataSourceIntegerField("realWorkHours", "实际工时");
		realWorkHoursField.setLength(11);
		realWorkHoursField.setRequired(false);
		realWorkHoursField.setHidden(true);


		planIntegralField = new DataSourceFloatField("planIntegral", "预分配积分");
		planIntegralField.setLength(0);
		planIntegralField.setDecimalPad(0);
		planIntegralField.setFormat("");
		planIntegralField.setRequired(false);
		planIntegralField.setHidden(true);


		realIntegralField = new DataSourceFloatField("realIntegral", "实际获得积分");
		realIntegralField.setLength(0);
		realIntegralField.setDecimalPad(0);
		realIntegralField.setFormat("");
		realIntegralField.setRequired(false);
		realIntegralField.setHidden(true);


		planStartDateField = new DataSourceDateField("planStartDate", "计划开始日期");
		planStartDateField.setRequired(false);
		planStartDateField.setHidden(true);


		planEndDateField = new DataSourceDateField("planEndDate", "计划结束日期");
		planEndDateField.setRequired(false);
		planEndDateField.setHidden(true);


		startDateField = new DataSourceDateTimeField("startDate", "开始日期");
		startDateField.setRequired(false);
		startDateField.setHidden(true);


		endDateField = new DataSourceDateTimeField("endDate", "截止日期");
		endDateField.setRequired(false);
		endDateField.setHidden(true);


		workContentField = new DataSourceTextField("workContent", "工作内容");
		workContentField.setLength(1024);
		workContentField.setRequired(false);
		workContentField.setHidden(true);


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


		costField = new DataSourceFloatField("cost", "费用");
		costField.setLength(13);
		costField.setDecimalPad(2);
		costField.setFormat("##,###,##0.00");
		costField.setRequired(false);
		costField.setHidden(true);


		settlementField = new DataSourceFloatField("settlement", "结算积分");
		settlementField.setLength(13);
		settlementField.setDecimalPad(2);
		settlementField.setFormat("##,###,##0.00");
		settlementField.setRequired(false);
		settlementField.setHidden(true);


		employeeAchieveIntegralReturnField = new DataSourceFloatField("employeeAchieveIntegralReturn", "积分回流");
		employeeAchieveIntegralReturnField.setLength(13);
		employeeAchieveIntegralReturnField.setDecimalPad(5);
		employeeAchieveIntegralReturnField.setFormat("##,###,##0.00000");
		employeeAchieveIntegralReturnField.setRequired(false);
		employeeAchieveIntegralReturnField.setHidden(true);


		stageIdField = new DataSourceIntegerField("stageId", "阶段id");
		stageIdField.setLength(11);
		stageIdField.setRequired(false);
		stageIdField.setHidden(true);


		flagField = new DataSourceIntegerField("flag", "状态（1草稿保存，2确认保存）");
		flagField.setLength(11);
		flagField.setRequired(false);
		flagField.setHidden(true);


		businessIdField = new DataSourceIntegerField("businessId", "业务编码");
		businessIdField.setLength(11);
		businessIdField.setRequired(false);
		businessIdField.setHidden(true);


		 employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
	        employeeNoField.setLength(11);
	        employeeNoField.setRequired(true);
	        employeeNoField.setHidden(false);

	        employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
	        employeeNameField.setLength(64);
	        employeeNameField.setRequired(true);
	        employeeNameField.setHidden(false);

	        departmentIdField = new DataSourceIntegerField("departmentId", "部门名称");
	        departmentIdField.setLength(11);
	        departmentIdField.setRequired(false);
	        departmentIdField.setHidden(false);
	        departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));

	        roleIdField = new DataSourceIntegerField("roleId", "角色名称");
	        roleIdField.setLength(11);
	        roleIdField.setRequired(false);
	        roleIdField.setHidden(true);
//	        roleIdField.setValueMap(KeyValueManager.getValueMap("roles"));
	        KeyValueManager.loadValueMap("roles",roleIdField);

	        gradeIdField = new DataSourceIntegerField("gradeId", "职级");
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
	        mobileField.setHidden(true);

	        phoneField = new DataSourceTextField("phone", "电话");
	        phoneField.setLength(64);
	        phoneField.setRequired(false);
	        phoneField.setHidden(true);

	        qqField = new DataSourceTextField("qq", "QQ");
	        qqField.setLength(64);
	        qqField.setRequired(false);
	        qqField.setHidden(true);

	        emailField = new DataSourceTextField("email", "邮箱");
	        emailField.setLength(64);
	        emailField.setRequired(false);
	        emailField.setHidden(true);

	        onboardDateField = new DataSourceDateField("onboardDate", "入职日期");
	        onboardDateField.setRequired(false);
	        onboardDateField.setHidden(true);

	        resignationDateField = new DataSourceDateField("resignationDate", "离职日期");
	        resignationDateField.setRequired(false);
	        resignationDateField.setHidden(true);

	        statusField = new DataSourceIntegerField("status", "在职状态");
	        statusField.setLength(11);
	        statusField.setRequired(false);
	        statusField.setHidden(true);
	        statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_11"));

	        usableStatusField = new DataSourceBooleanField("usableStatus", "是否可用");
	        usableStatusField.setRequired(false);
	        usableStatusField.setHidden(true);

	        isDepartmentField = new DataSourceBooleanField("isDepartment", "是否为部门负责人");
	        isDepartmentField.setRequired(false);
	        isDepartmentField.setHidden(true);

	        photoField = new DataSourceTextField("photo", "头像");
	        photoField.setLength(512);
	        photoField.setRequired(false);
	        photoField.setHidden(true);

	        genderField = new DataSourceIntegerField("gender", "性别");
	        genderField.setLength(11);
	        genderField.setRequired(false);
	        genderField.setHidden(true);

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
	        birthField.setHidden(true);

	        cardField = new DataSourceTextField("card", "身份证号");
	        cardField.setLength(64);
	        cardField.setRequired(false);
	        cardField.setHidden(true);

	        addressField = new DataSourceTextField("address", "家庭地址");
	        addressField.setLength(512);
	        addressField.setRequired(false);
	        addressField.setHidden(true);

	        lockedField = new DataSourceBooleanField("locked", "是否锁定");
	        lockedField.setRequired(false);
	        lockedField.setHidden(true);


		setFields(projectEmployeeIdField, projectIdField, employeeIdField, designPhaseField, planWorkHoursField, realWorkHoursField, planIntegralField, realIntegralField, planStartDateField, planEndDateField, startDateField, endDateField, workContentField, alternateField1Field, alternateField2Field, alternateField3Field, costField, settlementField, employeeAchieveIntegralReturnField, stageIdField, flagField, businessIdField, employeeNoField, employeeNameField, departmentIdField, roleIdField, gradeIdField, employeePasswordField, mobileField, phoneField, qqField, emailField, onboardDateField, resignationDateField, statusField, usableStatusField, isDepartmentField, photoField, genderField, autographField, ageField, birthField, cardField, addressField, lockedField);
	}


}

