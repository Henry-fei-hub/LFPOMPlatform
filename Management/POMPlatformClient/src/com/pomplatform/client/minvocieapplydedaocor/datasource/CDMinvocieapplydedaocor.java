package com.pomplatform.client.minvocieapplydedaocor.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMinvocieapplydedaocor extends DataSource
{


	public static CDMinvocieapplydedaocor instance = null;

	public static CDMinvocieapplydedaocor getInstance() {
		if(instance == null) {
			instance = new CDMinvocieapplydedaocor("CDMinvocieapplydedaocor");
		}
		return instance;
	}

	private final DataSourceDateTimeField minOperatorTimeField;
	private final DataSourceDateTimeField maxOperatorTimeField;
	private final DataSourceDateTimeField minApplyTimeField;
	private final DataSourceDateTimeField maxApplyTimeField;
	private final DataSourceIntegerField invoiceApplyIdField;
	private final DataSourceIntegerField applicantDeparmentIdField;
	private final DataSourceTextField applicantNameField;
	private final DataSourceTextField operatorNameField;
	private final DataSourceIntegerField applicantIdField;
	private final DataSourceIntegerField operatorIdField;
	private final DataSourceTextField departmentNameField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField bankNameField;
	private final DataSourceTextField bankAccountField;
	private final DataSourceIntegerField invoiceTypeField;
	private final DataSourceIntegerField invoiceApplyStatusField;
	private final DataSourceTextField dutyParagraphField;
	private final DataSourceTextField applyRemarkField;
	private final DataSourceTextField operatorRemarkField;
	private final DataSourceTextField companyNameField;

	public CDMinvocieapplydedaocor(String dataSourceID) {

		setID(dataSourceID);
		minOperatorTimeField = new DataSourceDateTimeField("minOperatorTime", "最早操作时间");
		minOperatorTimeField.setRequired(false);
		minOperatorTimeField.setHidden(false);

		maxOperatorTimeField = new DataSourceDateTimeField("maxOperatorTime", "最晚操作时间");
		maxOperatorTimeField.setRequired(false);
		maxOperatorTimeField.setHidden(false);

		minApplyTimeField = new DataSourceDateTimeField("minApplyTime", "最早申请时间");
		minApplyTimeField.setRequired(false);
		minApplyTimeField.setHidden(false);

		maxApplyTimeField = new DataSourceDateTimeField("maxApplyTime", "最晚申请时间");
		maxApplyTimeField.setRequired(false);
		maxApplyTimeField.setHidden(false);

		invoiceApplyIdField = new DataSourceIntegerField("invoiceApplyId", "主键");
		invoiceApplyIdField.setRequired(true);
		invoiceApplyIdField.setLength(11);
		invoiceApplyIdField.setPrimaryKey(true);
		invoiceApplyIdField.setHidden(true);

		applicantDeparmentIdField = new DataSourceIntegerField("applicantDeparmentId", "申请人部门");
		applicantDeparmentIdField.setRequired(false);
		applicantDeparmentIdField.setLength(11);
		applicantDeparmentIdField.setHidden(false);

		applicantNameField = new DataSourceTextField("applicantName", "申请人");
		applicantNameField.setRequired(true);
		applicantNameField.setLength(64);
		applicantNameField.setHidden(false);

		operatorNameField = new DataSourceTextField("operatorName", "操作人");
		operatorNameField.setRequired(true);
		operatorNameField.setLength(64);
		operatorNameField.setHidden(false);

		applicantIdField = new DataSourceIntegerField("applicantId", "申请人主键");
		applicantIdField.setRequired(true);
		applicantIdField.setLength(11);
		applicantIdField.setHidden(false);

		operatorIdField = new DataSourceIntegerField("operatorId", "操作人主键");
		operatorIdField.setRequired(false);
		operatorIdField.setLength(11);
		operatorIdField.setHidden(false);

		departmentNameField = new DataSourceTextField("departmentName", "部门名称");
		departmentNameField.setRequired(true);
		departmentNameField.setLength(64);
		departmentNameField.setHidden(false);

		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(64);
		contractCodeField.setHidden(false);

		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setRequired(false);
		contractNameField.setLength(512);
		contractNameField.setHidden(false);

		contractIdField = new DataSourceIntegerField("contractId", "合同编码");
		contractIdField.setRequired(true);
		contractIdField.setLength(11);
		contractIdField.setPrimaryKey(true);
		contractIdField.setHidden(true);

		bankNameField = new DataSourceTextField("bankName", "开户银行");
		bankNameField.setRequired(false);
		bankNameField.setLength(255);
		bankNameField.setHidden(false);

		bankAccountField = new DataSourceTextField("bankAccount", "银行账号");
		bankAccountField.setRequired(false);
		bankAccountField.setLength(255);
		bankAccountField.setHidden(false);

		invoiceTypeField = new DataSourceIntegerField("invoiceType", "发票类型");
		invoiceTypeField.setRequired(false);
		invoiceTypeField.setLength(11);
		invoiceTypeField.setHidden(false);

		invoiceApplyStatusField = new DataSourceIntegerField("invoiceApplyStatus", "申请状态 ");
		invoiceApplyStatusField.setRequired(false);
		invoiceApplyStatusField.setLength(11);
		invoiceApplyStatusField.setHidden(false);

		dutyParagraphField = new DataSourceTextField("dutyParagraph", "税号");
		dutyParagraphField.setRequired(false);
		dutyParagraphField.setLength(255);
		dutyParagraphField.setHidden(false);

		applyRemarkField = new DataSourceTextField("applyRemark", "申请备注");
		applyRemarkField.setRequired(false);
		applyRemarkField.setLength(255);
		applyRemarkField.setHidden(false);

		operatorRemarkField = new DataSourceTextField("operatorRemark", "操作人备注");
		operatorRemarkField.setRequired(false);
		operatorRemarkField.setLength(255);
		operatorRemarkField.setHidden(false);

		companyNameField = new DataSourceTextField("companyName", "单位全称");
		companyNameField.setRequired(false);
		companyNameField.setLength(255);
		companyNameField.setHidden(false);

		DataSourceIntegerField currentPageField
			= new DataSourceIntegerField("currentPage", "当前页");
		currentPageField.setRequired(true);
		currentPageField.setLength(10);
		currentPageField.setHidden(true);

		DataSourceIntegerField pageLinesField
			= new DataSourceIntegerField("pageLines", "每页行数");
		pageLinesField.setRequired(true);
		pageLinesField.setLength(10);
		pageLinesField.setHidden(true);


		setFields(minOperatorTimeField, maxOperatorTimeField, minApplyTimeField, maxApplyTimeField, invoiceApplyIdField, applicantDeparmentIdField, applicantNameField, operatorNameField, applicantIdField, operatorIdField, departmentNameField, contractCodeField, contractNameField, contractIdField, bankNameField, bankAccountField, invoiceTypeField, invoiceApplyStatusField, dutyParagraphField, applyRemarkField, operatorRemarkField, companyNameField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

