package com.pomplatform.client.employee.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSEmployeeInfoOfNoSalaryAdjustment extends DBDataSource
{


	public static DSEmployeeInfoOfNoSalaryAdjustment instance = null;

	public static DSEmployeeInfoOfNoSalaryAdjustment getInstance() {
		if(instance == null) {
			instance = new DSEmployeeInfoOfNoSalaryAdjustment("DSEmployeeInfoOfNoSalaryAdjustment");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceDateField onboardDateField;
	private final DataSourceDateField changeDateField;
	private final DataSourceIntegerField typeField;
	private final DataSourceTextField originalPayField;
	private final DataSourceTextField changePayField;
	private final DataSourceTextField monthPayField;
	private final DataSourceFloatField percentField;
	private final DataSourceFloatField feeField;
	private final DataSourceTextField remarkField;
	
	public DSEmployeeInfoOfNoSalaryAdjustment(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("EmployeeInfoOfNoSalaryAdjustment");


		employeeIdField = new DataSourceIntegerField("employeeId", "员工编码");
		employeeIdField.setLength(11);
		employeeIdField.setPrimaryKey(true);
		employeeIdField.setRequired(true);
		employeeIdField.setHidden(true);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		employeeNameField = new DataSourceTextField("employeeName", "姓名");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(true);
		employeeNameField.setHidden(false);
		employeeNameField.setValueMap(KeyValueManager.getValueMap("employees"));


		employeeNoField = new DataSourceTextField("employeeNo", "工号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(true);
		employeeNoField.setHidden(false);


		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(true);
		companyIdField.setValueMap(KeyValueManager.getValueMap("company_records"));
		
		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		departmentIdField = new DataSourceIntegerField("departmentId", "所属部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		onboardDateField = new DataSourceDateField("onboardDate", "入职日期");
		onboardDateField.setRequired(false);
		onboardDateField.setHidden(false);


		changeDateField = new DataSourceDateField("changeDate", "调薪日期");
		changeDateField.setRequired(false);
		changeDateField.setHidden(false);

		
		typeField = new DataSourceIntegerField("type", "调薪类型");
		typeField.setLength(11);
		typeField.setRequired(false);
		typeField.setHidden(false);
		typeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_95"));
		
		
		originalPayField = new DataSourceTextField("originalPay", "现薪资");
		originalPayField.setLength(64);
		originalPayField.setFormat("#,###,###,###,###,##0.00");
		originalPayField.setRequired(false);
		originalPayField.setHidden(false);


		changePayField = new DataSourceTextField("changePay", "调薪金额");
		changePayField.setLength(64);
		changePayField.setFormat("#,###,###,###,###,##0.00");
		changePayField.setRequired(false);
		changePayField.setHidden(false);


		monthPayField = new DataSourceTextField("monthPay", "调整后薪资总额");
		monthPayField.setLength(64);
		monthPayField.setFormat("#,###,###,###,###,##0.00");
		monthPayField.setRequired(false);
		monthPayField.setHidden(false);


		percentField = new DataSourceFloatField("percent", "调薪比例（%）");
		percentField.setLength(18);
		percentField.setDecimalPad(2);
		percentField.setFormat("#,###,###,###,###,##0.00");
		percentField.setRequired(false);
		percentField.setHidden(false);


		feeField = new DataSourceFloatField("fee", "个人效益指数");
		feeField.setLength(18);
		feeField.setDecimalPad(2);
		feeField.setFormat("#,###,###,###,###,##0.00");
		feeField.setRequired(false);
		feeField.setHidden(false);
		
		
		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(256);
		remarkField.setRequired(false);
		remarkField.setHidden(false);
		
		
		setFields(employeeIdField, employeeNameField, employeeNoField, companyIdField, plateIdField, departmentIdField, onboardDateField, changeDateField, typeField, originalPayField, changePayField, monthPayField, percentField, feeField, remarkField);
	}


}

