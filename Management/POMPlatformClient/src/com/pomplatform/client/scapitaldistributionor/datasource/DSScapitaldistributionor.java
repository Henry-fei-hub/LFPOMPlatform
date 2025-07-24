package com.pomplatform.client.scapitaldistributionor.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSScapitaldistributionor extends DBDataSource
{


	public static DSScapitaldistributionor instance = null;

	public static DSScapitaldistributionor getInstance() {
		if(instance == null) {
			instance = new DSScapitaldistributionor("DSScapitaldistributionor");
		}
		return instance;
	}

	private final DataSourceIntegerField capitalDistributionIdField;
	private final DataSourceTextField codeField;
	private final DataSourceIntegerField processInstanceIdField;
	private final DataSourceIntegerField applyEmployeeIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceTextField titleField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceIntegerField capitalIdField;
	private final DataSourceDateTimeField applyTimeField;
	private final DataSourceDateTimeField completeTimeField;
	private final DataSourceTextField remarkField;
	private final DataSourceBooleanField isCompletedField;
	private final DataSourceIntegerField mainProfessionalField;
	private final DataSourceFloatField contractChangeAmountField;
	private final DataSourceField detailCapitalDistributionLinkDepartment;
	private final DataSourceField detailCapitalDistributionLinkSubContract;

	public DSScapitaldistributionor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Scapitaldistributionor");


		capitalDistributionIdField = new DataSourceIntegerField("capitalDistributionId", "主键");
		capitalDistributionIdField.setLength(11);
		capitalDistributionIdField.setPrimaryKey(true);
		capitalDistributionIdField.setRequired(true);
		capitalDistributionIdField.setHidden(false);


		codeField = new DataSourceTextField("code", "报销编号");
		codeField.setLength(64);
		codeField.setRequired(false);
		codeField.setHidden(false);


		processInstanceIdField = new DataSourceIntegerField("processInstanceId", "流程编码");
		processInstanceIdField.setLength(11);
		processInstanceIdField.setRequired(false);
		processInstanceIdField.setHidden(true);


		applyEmployeeIdField = new DataSourceIntegerField("applyEmployeeId", "起草人");
		applyEmployeeIdField.setLength(11);
		applyEmployeeIdField.setRequired(false);
		applyEmployeeIdField.setHidden(false);
		applyEmployeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		employeeIdField = new DataSourceIntegerField("employeeId", "报销人");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(true);


		departmentIdField = new DataSourceIntegerField("departmentId", "报销部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(true);


		titleField = new DataSourceTextField("title", "主题");
		titleField.setLength(255);
		titleField.setRequired(false);
		titleField.setHidden(false);


		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(true);


		contractIdField = new DataSourceIntegerField("contractId", "合同");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(false);
//		contractIdField.setValueMap(KeyValueManager.getValueMap("contracts_1"));
		KeyValueManager.loadValueMap("contracts_1", contractIdField);

		capitalIdField = new DataSourceIntegerField("capitalId", "回款编码");
		capitalIdField.setLength(11);
		capitalIdField.setRequired(false);
		capitalIdField.setHidden(false);


		applyTimeField = new DataSourceDateTimeField("applyTime", "申请时间");
		applyTimeField.setRequired(false);
		applyTimeField.setHidden(false);


		completeTimeField = new DataSourceDateTimeField("completeTime", "完成时间");
		completeTimeField.setRequired(false);
		completeTimeField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(60000);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		isCompletedField = new DataSourceBooleanField("isCompleted", "是否完成");
		isCompletedField.setRequired(false);
		isCompletedField.setHidden(true);


		mainProfessionalField = new DataSourceIntegerField("mainProfessional", "主专业");
		mainProfessionalField.setLength(11);
		mainProfessionalField.setRequired(false);
		mainProfessionalField.setHidden(false);
		mainProfessionalField.setValueMap(KeyValueManager.getValueMap("plate_records"));


		contractChangeAmountField = new DataSourceFloatField("contractChangeAmount", "合同变更金额");
		contractChangeAmountField.setLength(16);
		contractChangeAmountField.setDecimalPad(2);
		contractChangeAmountField.setFormat("##,###,###,###,##0.00");
		contractChangeAmountField.setRequired(false);
		contractChangeAmountField.setHidden(true);

		detailCapitalDistributionLinkDepartment = new DataSourceField("detailCapitalDistributionLinkDepartment", FieldType.ANY);
		detailCapitalDistributionLinkDepartment.setChildrenProperty(true);
		detailCapitalDistributionLinkDepartment.setChildTagName("CapitalDistributionLinkDepartment");
		detailCapitalDistributionLinkDepartment.setRequired(false);
		detailCapitalDistributionLinkDepartment.setHidden(true);
		detailCapitalDistributionLinkSubContract = new DataSourceField("detailCapitalDistributionLinkSubContract", FieldType.ANY);
		detailCapitalDistributionLinkSubContract.setChildrenProperty(true);
		detailCapitalDistributionLinkSubContract.setChildTagName("CapitalDistributionLinkSubContract");
		detailCapitalDistributionLinkSubContract.setRequired(false);
		detailCapitalDistributionLinkSubContract.setHidden(true);

		setFields(capitalDistributionIdField, codeField, processInstanceIdField, applyEmployeeIdField, employeeIdField, departmentIdField, titleField, companyIdField, contractIdField, capitalIdField, applyTimeField, completeTimeField, remarkField, isCompletedField, mainProfessionalField, contractChangeAmountField, detailCapitalDistributionLinkDepartment, detailCapitalDistributionLinkSubContract);
	}


}

