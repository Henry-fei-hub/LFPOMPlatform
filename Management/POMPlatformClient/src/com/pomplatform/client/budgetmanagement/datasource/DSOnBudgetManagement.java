package com.pomplatform.client.budgetmanagement.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceImageField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSOnBudgetManagement extends DBDataSource
{


	public static DSOnBudgetManagement instance = null;

	public static DSOnBudgetManagement getInstance() {
		if(instance == null) {
			instance = new DSOnBudgetManagement("DSOnBudgetManagement");
		}
		return instance;
	}

	private final DataSourceIntegerField budgetManagementIdField;
	private final DataSourceTextField bdCodeField;
	private final DataSourceIntegerField bdTypeField;
	private final DataSourceFloatField bdTotalAmountField;
	private final DataSourceFloatField bdUseAmountField;
	private final DataSourceFloatField bdRestAmountField;
	private final DataSourceIntegerField bdApplyEmployeeIdField;
	private final DataSourceDateTimeField bdApplyTimeField;
	private final DataSourceDateTimeField bdEstimatecloseTimeField;
	private final DataSourceIntegerField bdStatusField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceTextField projectNameField;
	private final DataSourceTextField bdRemarkField;
	private final DataSourceIntegerField processStatusField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceTextField costBearingField;
	private final DataSourceIntegerField processInstanceIdField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField processIdField;
	private final DataSourceImageField warnImgField;
	private final DataSourceIntegerField outSourceTypeField;
	private final DataSourceTextField bdSupplierPersonField;
	private final DataSourceTextField bdSupplierCompanyField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	

	public DSOnBudgetManagement(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnBudgetManagement");

		
		warnImgField = new DataSourceImageField("warnImg", "警示");
		warnImgField.setLength(512);
		warnImgField.setRequired(false);
		warnImgField.setHidden(false);
		warnImgField.setImageHeight(16);
		warnImgField.setImageWidth(16);

		budgetManagementIdField = new DataSourceIntegerField("budgetManagementId", "主键id");
		budgetManagementIdField.setLength(11);
		budgetManagementIdField.setPrimaryKey(true);
		budgetManagementIdField.setRequired(true);
		budgetManagementIdField.setHidden(true);


		bdCodeField = new DataSourceTextField("bdCode", "预算编号");
		bdCodeField.setLength(1024);
		bdCodeField.setRequired(false);
		bdCodeField.setHidden(false);


		bdTypeField = new DataSourceIntegerField("bdType", "预算类型");
		bdTypeField .setValueMap(KeyValueManager.getValueMap("system_dictionary_191"));
		bdTypeField.setLength(11);
		bdTypeField.setRequired(false);
		bdTypeField.setHidden(false);


		bdTotalAmountField = new DataSourceFloatField("bdTotalAmount", "预算总金额");
		bdTotalAmountField.setLength(18);
		bdTotalAmountField.setDecimalPad(2);
		bdTotalAmountField.setFormat("#,###,###,###,###,##0.00");
		bdTotalAmountField.setRequired(false);
		bdTotalAmountField.setHidden(false);

		bdUseAmountField = new DataSourceFloatField("bdUseAmount", "预算已用金额");
		bdUseAmountField.setLength(18);
		bdUseAmountField.setDecimalPad(2);
		bdUseAmountField.setFormat("#,###,###,###,###,##0.00");
		bdUseAmountField.setRequired(false);
		bdUseAmountField.setHidden(false);


		bdRestAmountField = new DataSourceFloatField("bdRestAmount", "预算剩余金额");
		bdRestAmountField.setLength(18);
		bdRestAmountField.setDecimalPad(2);
		bdRestAmountField.setFormat("#,###,###,###,###,##0.00");
		bdRestAmountField.setRequired(false);
		bdRestAmountField.setHidden(false);

		bdApplyEmployeeIdField = new DataSourceIntegerField("bdApplyEmployeeId", "申请人");
		bdApplyEmployeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));
		bdApplyEmployeeIdField.setLength(11);
		bdApplyEmployeeIdField.setRequired(false);
		bdApplyEmployeeIdField.setHidden(false);


		bdApplyTimeField = new DataSourceDateTimeField("bdApplyTime", "申请时间");
		bdApplyTimeField.setRequired(false);
		bdApplyTimeField.setHidden(false);


		bdEstimatecloseTimeField = new DataSourceDateTimeField("bdEstimatecloseTime", "预期关闭时间");
		bdEstimatecloseTimeField.setRequired(false);
		bdEstimatecloseTimeField.setHidden(false);


		bdStatusField = new DataSourceIntegerField("bdStatus", "预算单状态");
		bdStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_195"));
		bdStatusField.setLength(11);
		bdStatusField.setRequired(false);
		bdStatusField.setHidden(false);


		projectIdField = new DataSourceIntegerField("projectId", "项目名称");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(true);


		bdRemarkField = new DataSourceTextField("bdRemark", "预算备注");
		bdRemarkField.setLength(2048);
		bdRemarkField.setRequired(false);
		bdRemarkField.setHidden(false);


		processStatusField = new DataSourceIntegerField("processStatus", "立项流程状态");
		processStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_120"));
		processStatusField.setLength(11);
		processStatusField.setRequired(false);
		processStatusField.setHidden(false);
		
		departmentIdField= new DataSourceIntegerField("departmentId", "承接部门");
		departmentIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		
		costBearingField=new DataSourceTextField("costBearing","费用承担");
		costBearingField.setLength(2048);
		costBearingField.setRequired(false);
		costBearingField.setHidden(false);
		
		projectNameField=new DataSourceTextField("projectName","项目名称");
		projectNameField.setLength(2048);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);
		
		processInstanceIdField=new DataSourceIntegerField("processInstanceId","流程实例");
		processInstanceIdField.setLength(30);
		processInstanceIdField.setHidden(true);
		
		processTypeField=new DataSourceIntegerField("processType","流程类型");
		processTypeField.setLength(30);
		processTypeField.setHidden(true);
		
		processIdField=new DataSourceIntegerField("processId","流程id");
		processIdField.setLength(30);
		processIdField.setHidden(true);
		
		outSourceTypeField=new DataSourceIntegerField("outSourceType","外包类型");
		outSourceTypeField.setLength(30);
		outSourceTypeField.setHidden(true);
		
		bdSupplierCompanyField=new DataSourceTextField("bdSupplierCompany","拟外协供应商(公司)");
		bdSupplierCompanyField.setLength(128);
		bdSupplierCompanyField.setHidden(true);
		
		
		bdSupplierPersonField=new DataSourceTextField("bdSupplierPerson","拟外协供应商(个人)");
		bdSupplierPersonField.setLength(128);
		bdSupplierPersonField.setHidden(true);
		
		projectCodeField = new DataSourceTextField("projectCode", "订单编号");
		projectCodeField.setLength(64);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(false);


		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);


		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setLength(512);
		contractNameField.setRequired(false);
		contractNameField.setHidden(false);
		

		setFields(warnImgField,budgetManagementIdField, bdCodeField, bdTypeField, bdTotalAmountField, bdUseAmountField, bdRestAmountField, bdApplyEmployeeIdField, bdApplyTimeField, bdEstimatecloseTimeField, bdStatusField, projectIdField,projectNameField,departmentIdField,costBearingField,bdRemarkField, processStatusField,processInstanceIdField,processTypeField,processIdField,outSourceTypeField,bdSupplierCompanyField,bdSupplierPersonField, projectCodeField, contractCodeField, contractNameField);
	}


}

