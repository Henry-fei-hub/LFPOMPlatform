package com.pomplatform.client.payseqaddinfo.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDPaySeqAddInfo extends DataSource
{


	public static CDPaySeqAddInfo instance = null;

	public static CDPaySeqAddInfo getInstance() {
		if(instance == null) {
			instance = new CDPaySeqAddInfo("CDPaySeqAddInfo");
		}
		return instance;
	}

	private final DataSourceIntegerField budgetManagementIdField;
	private final DataSourceIntegerField budgetAttachmentIdField;
	private final DataSourceFloatField payAmountField;
	private final DataSourceDateTimeField payDateField;
	private final DataSourceIntegerField payStatusField;
	private final DataSourceTextField psRemarkField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;
	private final DataSourceIntegerField receiveUnitManageIdField;
	private final DataSourceIntegerField processBillListIdField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField bindStatusField;
	private final DataSourceIntegerField payTypeField;
	private final DataSourceBooleanField isLockField;
	private final DataSourceFloatField reimbursementAmountField;
	private final DataSourceFloatField reverseAmountField;
	private final DataSourceDateTimeField applyPayDateField;
	private final DataSourceFloatField returnAmountField;

	public CDPaySeqAddInfo(String dataSourceID) {

		setID(dataSourceID);
		budgetManagementIdField = new DataSourceIntegerField("budgetManagementId", "预算管理id");
		budgetManagementIdField.setRequired(false);
		budgetManagementIdField.setLength(11);
		budgetManagementIdField.setHidden(false);

		budgetAttachmentIdField = new DataSourceIntegerField("budgetAttachmentId", "预算附件id");
		budgetAttachmentIdField.setRequired(false);
		budgetAttachmentIdField.setLength(11);
		budgetAttachmentIdField.setHidden(false);

		payAmountField = new DataSourceFloatField("payAmount", "付款金额");
		payAmountField.setRequired(true);
		payAmountField.setLength(18);
		payAmountField.setHidden(false);

		payDateField = new DataSourceDateTimeField("payDate", "付款日期");
		payDateField.setRequired(false);
		payDateField.setHidden(false);

		payStatusField = new DataSourceIntegerField("payStatus", "付款状态(1未付款,2已付款,3付款申请中)");
		payStatusField.setRequired(false);
		payStatusField.setLength(11);
		payStatusField.setHidden(false);

		psRemarkField = new DataSourceTextField("psRemark", "付款序列备注");
		psRemarkField.setRequired(false);
		psRemarkField.setLength(2048);
		psRemarkField.setHidden(false);

		yearField = new DataSourceIntegerField("year", "年");
		yearField.setRequired(false);
		yearField.setLength(11);
		yearField.setHidden(false);

		monthField = new DataSourceIntegerField("month", "月");
		monthField.setRequired(false);
		monthField.setLength(11);
		monthField.setHidden(false);

		receiveUnitManageIdField = new DataSourceIntegerField("receiveUnitManageId", "收款单位编码");
		receiveUnitManageIdField.setRequired(false);
		receiveUnitManageIdField.setLength(11);
		receiveUnitManageIdField.setHidden(false);

		processBillListIdField = new DataSourceIntegerField("processBillListId", "流水编码");
		processBillListIdField.setRequired(false);
		processBillListIdField.setLength(11);
		processBillListIdField.setHidden(false);

		projectIdField = new DataSourceIntegerField("projectId", "项目id");
		projectIdField.setRequired(false);
		projectIdField.setLength(11);
		projectIdField.setHidden(false);

		bindStatusField = new DataSourceIntegerField("bindStatus", "绑定状态 0.未绑定，1.已绑定");
		bindStatusField.setRequired(false);
		bindStatusField.setLength(11);
		bindStatusField.setHidden(false);

		payTypeField = new DataSourceIntegerField("payType", "付款类型");
		payTypeField.setRequired(false);
		payTypeField.setLength(11);
		payTypeField.setHidden(false);

		isLockField = new DataSourceBooleanField("isLock", "是否加锁");
		isLockField.setRequired(false);
		isLockField.setHidden(false);

		reimbursementAmountField = new DataSourceFloatField("reimbursementAmount", "报销金额");
		reimbursementAmountField.setRequired(true);
		reimbursementAmountField.setLength(18);
		reimbursementAmountField.setHidden(false);

		reverseAmountField = new DataSourceFloatField("reverseAmount", "冲账金额");
		reverseAmountField.setRequired(true);
		reverseAmountField.setLength(18);
		reverseAmountField.setHidden(false);

		applyPayDateField = new DataSourceDateTimeField("applyPayDate", "付款申请日期");
		applyPayDateField.setRequired(false);
		applyPayDateField.setHidden(false);

		returnAmountField = new DataSourceFloatField("returnAmount", "还款金额");
		returnAmountField.setRequired(true);
		returnAmountField.setLength(18);
		returnAmountField.setHidden(false);

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


		setFields(budgetManagementIdField, budgetAttachmentIdField, payAmountField, payDateField, payStatusField, psRemarkField, yearField, monthField, receiveUnitManageIdField, processBillListIdField, projectIdField, bindStatusField, payTypeField, isLockField, reimbursementAmountField, reverseAmountField, applyPayDateField, returnAmountField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

