package com.pomplatform.client.financereceivebills.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.selectgridemployeevalue.datasource.DSSelectGridEmployeeValue;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.grid.ListGridField;

public class DSMfinancereceivebillspor extends DBDataSource
{


	public static DSMfinancereceivebillspor instance = null;

	public static DSMfinancereceivebillspor getInstance() {
		if(instance == null) {
			instance = new DSMfinancereceivebillspor("DSMfinancereceivebillspor");
		}
		return instance;
	}

	private final DataSourceIntegerField financeReceiveBillIdField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField applicantField;
	private final DataSourceTextField codeField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField businessIdField;
	private final DataSourceFloatField amountField;
	private final DataSourceIntegerField sendeeField;
	private final DataSourceIntegerField handlePersonField;
	private final DataSourceTextField remarkField;
	private final DataSourceTextField detailRemarkField;
	private final DataSourceIntegerField receiveStatusField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceDateField updateTimeField;
	private final DataSourceIntegerField processStatusField;
	private final DataSourceIntegerField processIdField;
	private final DataSourceIntegerField processInstanceIdField;

	public DSMfinancereceivebillspor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Mfinancereceivebillspor");


		financeReceiveBillIdField = new DataSourceIntegerField("financeReceiveBillId", "主键");
		financeReceiveBillIdField.setLength(11);
		financeReceiveBillIdField.setPrimaryKey(true);
		financeReceiveBillIdField.setRequired(true);
		financeReceiveBillIdField.setHidden(true);


		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));


		departmentIdField = new DataSourceIntegerField("departmentId", "部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		applicantField = new DataSourceIntegerField("applicant", "申请人");
		applicantField.setLength(11);
		applicantField.setRequired(false);
		applicantField.setHidden(false);
		applicantField.setValueMap(KeyValueManager.getValueMap("employees"));


		codeField = new DataSourceTextField("code", "报销编号");
		codeField.setLength(255);
		codeField.setRequired(false);
		codeField.setHidden(false);


		processTypeField = new DataSourceIntegerField("processType", "报销类型");
		processTypeField.setLength(11);
		processTypeField.setRequired(false);
		processTypeField.setHidden(false);
		processTypeField.setValueMap(KeyValueManager.getValueMap("system_process_types"));


		businessIdField = new DataSourceIntegerField("businessId", "业务主键");
		businessIdField.setLength(11);
		businessIdField.setRequired(false);
		businessIdField.setHidden(true);


		amountField = new DataSourceFloatField("amount", "金额");
		amountField.setLength(16);
		amountField.setDecimalPad(2);
		amountField.setFormat("##,###,###,###,##0.00");
		amountField.setRequired(false);
		amountField.setHidden(false);


		sendeeField = new DataSourceIntegerField("sendee", "接收人");
		sendeeField.setLength(11);
		sendeeField.setRequired(false);
		sendeeField.setHidden(false);
		sendeeField.setValueMap(KeyValueManager.getValueMap("employees"));


		handlePersonField = new DataSourceIntegerField("handlePerson", "处理人");
		handlePersonField.setLength(11);
		handlePersonField.setRequired(false);
		handlePersonField.setHidden(false);
		
		ComboBoxItem toEmployeeIdItem = new ComboBoxItem("handlePerson", "接收人");
		ListGridField employeeNoField = new ListGridField("employeeNo");
		ListGridField employeeNameField = new ListGridField("employeeName");
		ListGridField departmentIdField1 = new ListGridField("departmentId");
		toEmployeeIdItem.setDisplayField("employeeName");
		toEmployeeIdItem.setValueField("employeeId");
		toEmployeeIdItem.setPickListFields(employeeNoField, employeeNameField, departmentIdField1);
		toEmployeeIdItem.setOptionDataSource(DSSelectGridEmployeeValue.getInstance());
		toEmployeeIdItem.setChangeOnKeypress(false);
		toEmployeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		handlePersonField.setValueMap(KeyValueManager.getValueMap("employees"));
		
		handlePersonField.setEditorProperties(toEmployeeIdItem);
		
		
//		handlePersonField.setValueMap(KeyValueManager.getValueMap("employees"));
		

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		detailRemarkField = new DataSourceTextField("detailRemark", "流程明细");
		detailRemarkField.setLength(1024);
		detailRemarkField.setRequired(false);
		detailRemarkField.setHidden(false);


		receiveStatusField = new DataSourceIntegerField("receiveStatus", "收单状态");
		receiveStatusField.setLength(11);
		receiveStatusField.setRequired(false);
		receiveStatusField.setHidden(false);
		receiveStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_130"));


		createTimeField = new DataSourceDateTimeField("createTime", "创建日期");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);


		updateTimeField = new DataSourceDateField("updateTime", "操作日期");
		updateTimeField.setRequired(false);
		updateTimeField.setHidden(false);


		processStatusField = new DataSourceIntegerField("processStatus", "流程状态");
		processStatusField.setLength(11);
		processStatusField.setRequired(false);
		processStatusField.setHidden(false);
		processStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_120"));


		processIdField = new DataSourceIntegerField("processId", "流程编码");
		processIdField.setLength(11);
		processIdField.setRequired(false);
		processIdField.setHidden(true);


		processInstanceIdField = new DataSourceIntegerField("processInstanceId", "主键编码");
		processInstanceIdField.setLength(11);
		processInstanceIdField.setPrimaryKey(true);
		processInstanceIdField.setRequired(true);
		processInstanceIdField.setHidden(true);


		setFields(financeReceiveBillIdField, processInstanceIdField, companyIdField, departmentIdField, applicantField, codeField, processTypeField, businessIdField, amountField, sendeeField, handlePersonField, remarkField, detailRemarkField, receiveStatusField, createTimeField, updateTimeField, processStatusField, processIdField);
	}


}

