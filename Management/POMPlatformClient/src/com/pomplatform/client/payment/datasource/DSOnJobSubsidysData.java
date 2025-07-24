package com.pomplatform.client.payment.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;

public class DSOnJobSubsidysData extends DBDataSource
{


	public static DSOnJobSubsidysData instance = null;

	public static DSOnJobSubsidysData getInstance() {
		if(instance == null) {
			instance = new DSOnJobSubsidysData("DSOnJobSubsidysData");
		}
		return instance;
	}

	private final DataSourceIntegerField salaryJobSubsidyIdField;
	private final DataSourceTextField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceTextField companyIdField;
	private final DataSourceTextField plateIdField;
	private final DataSourceTextField departmentIdField;
	private final DataSourceDateField recordDateField;
	private final DataSourceFloatField mileageSubsidyField;
	private final DataSourceFloatField attentionSubsidyField;
	private final DataSourceFloatField salarySubsidyField;
	private final DataSourceFloatField leaveSubsidyField;
	private final DataSourceFloatField performanceSubsidyField;
	private final DataSourceFloatField workSiteSubsidyField;
	private final DataSourceFloatField positiveAccountField;
	private final DataSourceFloatField totalAmountField;
	private final DataSourceBooleanField isSendedField;

	public DSOnJobSubsidysData(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnJobSubsidysData");


		salaryJobSubsidyIdField = new DataSourceIntegerField("salaryJobSubsidyId", "主键编码");
		salaryJobSubsidyIdField.setLength(11);
		salaryJobSubsidyIdField.setPrimaryKey(true);
		salaryJobSubsidyIdField.setRequired(true);
		salaryJobSubsidyIdField.setHidden(true);


		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setLength(64);
		employeeNoField.setHidden(false);
		employeeNoField.setCanEdit(false);

		
		employeeIdField = new DataSourceTextField("employeeId", "员工姓名");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(true);
		employeeIdField.setHidden(false);
		ComboBoxItem employeeIdItem = new ComboBoxItem("employeeId");
		employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		employeeIdItem.setChangeOnKeypress(false);
		employeeIdField.setEditorProperties(employeeIdItem);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setLength(64);
		employeeNameField.setHidden(true);

		companyIdField = new DataSourceTextField("companyId", "归属公司");
		companyIdField.setLength(11);
		companyIdField.setHidden(false);
		companyIdField.setCanEdit(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("company_records"));


		plateIdField = new DataSourceTextField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setHidden(false);
		plateIdField.setCanEdit(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		departmentIdField = new DataSourceTextField("departmentId", "归属部门");
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);
		departmentIdField.setCanEdit(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		recordDateField = new DataSourceDateField("recordDate", "日期");
		recordDateField.setHidden(false);
		recordDateField.setCanEdit(true);
		recordDateField.setRequired(true);


		mileageSubsidyField = new DataSourceFloatField("mileageSubsidy", "里程补贴");
		mileageSubsidyField.setLength(18);
		mileageSubsidyField.setDecimalPad(2);
		mileageSubsidyField.setFormat("#,###,###,###,###,##0.00");
		mileageSubsidyField.setRequired(true);
		mileageSubsidyField.setHidden(false);


		attentionSubsidyField = new DataSourceFloatField("attentionSubsidy", "考勤补发/扣");
		attentionSubsidyField.setLength(18);
		attentionSubsidyField.setDecimalPad(2);
		attentionSubsidyField.setFormat("#,###,###,###,###,##0.00");
		attentionSubsidyField.setRequired(true);
		attentionSubsidyField.setHidden(false);


		salarySubsidyField = new DataSourceFloatField("salarySubsidy", "工资补发/扣");
		salarySubsidyField.setLength(18);
		salarySubsidyField.setDecimalPad(2);
		salarySubsidyField.setFormat("#,###,###,###,###,##0.00");
		salarySubsidyField.setRequired(true);
		salarySubsidyField.setHidden(false);


		leaveSubsidyField = new DataSourceFloatField("leaveSubsidy", "离职工资结算");
		leaveSubsidyField.setLength(18);
		leaveSubsidyField.setDecimalPad(2);
		leaveSubsidyField.setFormat("#,###,###,###,###,##0.00");
		leaveSubsidyField.setRequired(true);
		leaveSubsidyField.setHidden(false);

		performanceSubsidyField = new DataSourceFloatField("performanceSubsidy", "绩效补发/扣");
		performanceSubsidyField.setLength(18);
		performanceSubsidyField.setDecimalPad(2);
		performanceSubsidyField.setFormat("#,###,###,###,###,##0.00");
		performanceSubsidyField.setRequired(true);
		performanceSubsidyField.setHidden(false);
		
		workSiteSubsidyField = new DataSourceFloatField("workSiteSubsidy", "工地补助");
		workSiteSubsidyField.setLength(18);
		workSiteSubsidyField.setDecimalPad(2);
		workSiteSubsidyField.setFormat("#,###,###,###,###,##0.00");
		workSiteSubsidyField.setRequired(true);
		workSiteSubsidyField.setHidden(false);
		
		positiveAccountField = new DataSourceFloatField("positiveAccount", "转正核算");
		positiveAccountField.setLength(18);
		positiveAccountField.setDecimalPad(2);
		positiveAccountField.setFormat("#,###,###,###,###,##0.00");
		positiveAccountField.setRequired(true);
		positiveAccountField.setHidden(false);
		
		totalAmountField = new DataSourceFloatField("totalAmount", "合计");
		totalAmountField.setLength(18);
		totalAmountField.setDecimalPad(2);
		totalAmountField.setFormat("#,###,###,###,###,##0.00");
		totalAmountField.setHidden(false);
		totalAmountField.setCanEdit(false);


		isSendedField = new DataSourceBooleanField("isSended", "是否发放");
		isSendedField.setRequired(false);
		isSendedField.setHidden(false);
		isSendedField.setCanEdit(false);

		
		setFields(salaryJobSubsidyIdField, employeeNoField, employeeIdField, employeeNameField, companyIdField, plateIdField, departmentIdField, recordDateField, mileageSubsidyField, attentionSubsidyField, salarySubsidyField, leaveSubsidyField,performanceSubsidyField,workSiteSubsidyField,positiveAccountField,totalAmountField, isSendedField);
	}


}

