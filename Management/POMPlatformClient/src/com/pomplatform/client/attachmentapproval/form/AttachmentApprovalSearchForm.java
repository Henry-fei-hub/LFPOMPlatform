package com.pomplatform.client.attachmentapproval.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.attachmentapproval.datasource.CDAttachmentApproval;

public class AttachmentApprovalSearchForm extends SearchForm
{


	private final TextItem budgetManagementIdItem;
	private final TextItem fileIdItem;
	private final TextItem attachmentNameItem;
	private final TextItem uploadEmployeeIdItem;
	private final TextItem departmentIdItem;
	private final DateTimeItem uploadTimeItem;
	private final TextItem uploadRemarkItem;
	private final TextItem budgetContractAmountItem;
	private final TextItem budgetContractAmountUseItem;
	private final TextItem budgetContractAmountRestItem;
	private final TextItem receiveUnitManageIdItem;
	private final TextItem projectIdItem;
	private final TextItem inputTaxInvoiceIdItem;
	private final TextItem bddTypeItem;
	private final TextItem isApprovalItem;

	public AttachmentApprovalSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDAttachmentApproval.getInstance());
		budgetManagementIdItem = new TextItem("budgetManagementId", "预算管理id");
		fileIdItem = new TextItem("fileId", "附件编码");
		attachmentNameItem = new TextItem("attachmentName", "附件名称");
		uploadEmployeeIdItem = new TextItem("uploadEmployeeId", "上传人员");
		departmentIdItem = new TextItem("departmentId", "上传人员归属部门");
		uploadTimeItem = new DateTimeItem("uploadTime", "上传时间");
		uploadTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, uploadTimeItem);
			}
		});
		uploadRemarkItem = new TextItem("uploadRemark", "附件备注");
		budgetContractAmountItem = new TextItem("budgetContractAmount", "合同金额");
		budgetContractAmountUseItem = new TextItem("budgetContractAmountUse", "合同已付款金额");
		budgetContractAmountRestItem = new TextItem("budgetContractAmountRest", "剩余合同金额");
		receiveUnitManageIdItem = new TextItem("receiveUnitManageId", "供应商");
		projectIdItem = new TextItem("projectId", "项目id");
		inputTaxInvoiceIdItem = new TextItem("inputTaxInvoiceId", "发票编码");
		bddTypeItem = new TextItem("bddType", "预算类别  budget_detail_type");
		isApprovalItem = new TextItem("isApproval", "是否审批 0.未审批 1.已审批");

		setItems(budgetManagementIdItem, fileIdItem, attachmentNameItem, uploadEmployeeIdItem, departmentIdItem, uploadTimeItem, uploadRemarkItem, budgetContractAmountItem, budgetContractAmountUseItem, budgetContractAmountRestItem, receiveUnitManageIdItem, projectIdItem, inputTaxInvoiceIdItem, bddTypeItem, isApprovalItem);

		setNumCols(30);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
