package com.pomplatform.client.getbudgetuplodanews.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSGetBudgetUplodaNews extends DBDataSource
{


	public static DSGetBudgetUplodaNews instance = null;

	public static DSGetBudgetUplodaNews getInstance() {
		if(instance == null) {
			instance = new DSGetBudgetUplodaNews("DSGetBudgetUplodaNews");
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
	private final DataSourceTextField bdRemarkField;
	private final DataSourceIntegerField inputTaxInvoiceIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceTextField costBearingField;
	private final DataSourceIntegerField outSourceTypeField;
	private final DataSourceIntegerField fileIdField;
	private final DataSourceTextField bdAttachmentNameField;
	private final DataSourceTextField bdUploadRemarkField;
	private final DataSourceLinkField fileUrlField;
	private final DataSourceDateTimeField createTimeField;

	public DSGetBudgetUplodaNews(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("GetBudgetUplodaNews");


		budgetManagementIdField = new DataSourceIntegerField("budgetManagementId", "主键id");
		budgetManagementIdField.setLength(11);
		budgetManagementIdField.setPrimaryKey(true);
		budgetManagementIdField.setRequired(true);
		budgetManagementIdField.setHidden(false);


		bdCodeField = new DataSourceTextField("bdCode", "预算编号");
		bdCodeField.setLength(1024);
		bdCodeField.setRequired(false);
		bdCodeField.setHidden(false);


		bdTypeField = new DataSourceIntegerField("bdType", "预算类型");
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


		bdApplyEmployeeIdField = new DataSourceIntegerField("bdApplyEmployeeId", "申请人id");
		bdApplyEmployeeIdField.setLength(11);
		bdApplyEmployeeIdField.setRequired(false);
		bdApplyEmployeeIdField.setHidden(false);


		bdApplyTimeField = new DataSourceDateTimeField("bdApplyTime", "申请时间");
		bdApplyTimeField.setRequired(false);
		bdApplyTimeField.setHidden(false);


		bdEstimatecloseTimeField = new DataSourceDateTimeField("bdEstimatecloseTime", "预期关闭时间");
		bdEstimatecloseTimeField.setRequired(false);
		bdEstimatecloseTimeField.setHidden(false);


		bdStatusField = new DataSourceIntegerField("bdStatus", "预算单状态1,已立项，2立项进行中");
		bdStatusField.setLength(11);
		bdStatusField.setRequired(false);
		bdStatusField.setHidden(false);


		projectIdField = new DataSourceIntegerField("projectId", "项目编码");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(false);


		bdRemarkField = new DataSourceTextField("bdRemark", "预算备注");
		bdRemarkField.setLength(2048);
		bdRemarkField.setRequired(false);
		bdRemarkField.setHidden(false);


		inputTaxInvoiceIdField = new DataSourceIntegerField("inputTaxInvoiceId", "发票编码");
		inputTaxInvoiceIdField.setLength(11);
		inputTaxInvoiceIdField.setRequired(false);
		inputTaxInvoiceIdField.setHidden(false);


		departmentIdField = new DataSourceIntegerField("departmentId", "承接部门 system_dictionary_1");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);


		companyIdField = new DataSourceIntegerField("companyId", "申请人归属公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(false);


		costBearingField = new DataSourceTextField("costBearing", "费用承担");
		costBearingField.setLength(512);
		costBearingField.setRequired(false);
		costBearingField.setHidden(true);


		outSourceTypeField = new DataSourceIntegerField("outSourceType", "外包类型");
		outSourceTypeField.setLength(11);
		outSourceTypeField.setRequired(false);
		outSourceTypeField.setHidden(true);


		fileIdField = new DataSourceIntegerField("fileId", "附件编码");
		fileIdField.setLength(11);
		fileIdField.setRequired(false);
		fileIdField.setHidden(true);


		bdAttachmentNameField = new DataSourceTextField("bdAttachmentName", "附件名称");
		bdAttachmentNameField.setLength(255);
		bdAttachmentNameField.setRequired(false);
		bdAttachmentNameField.setHidden(true);


		bdUploadRemarkField = new DataSourceTextField("bdUploadRemark", "预算上传备注");
		bdUploadRemarkField.setLength(1024);
		bdUploadRemarkField.setRequired(false);
		bdUploadRemarkField.setHidden(true);


		fileUrlField = new DataSourceLinkField("fileUrl", "文件路径");
		fileUrlField.setLength(1024);
		fileUrlField.setRequired(false);
		fileUrlField.setHidden(false); 
		
		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);


		setFields(budgetManagementIdField, bdCodeField, bdTypeField, bdTotalAmountField, bdUseAmountField, bdRestAmountField, bdApplyEmployeeIdField, bdApplyTimeField, bdEstimatecloseTimeField, bdStatusField, projectIdField, bdRemarkField, inputTaxInvoiceIdField, departmentIdField, companyIdField, costBearingField, outSourceTypeField, fileIdField, bdAttachmentNameField, bdUploadRemarkField, fileUrlField,createTimeField);
	}


}

