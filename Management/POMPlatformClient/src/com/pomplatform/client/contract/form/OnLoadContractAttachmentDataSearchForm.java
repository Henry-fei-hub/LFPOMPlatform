package com.pomplatform.client.contract.form;

import com.delicacy.client.data.ClientUtil;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class OnLoadContractAttachmentDataSearchForm extends SearchForm
{


	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;
	private final TextItem attachmentNameItem;
	private final TextItem attachmentCodeItem;
	private final DateItem startDateItem;
	private final DateItem endDateItem;

	public OnLoadContractAttachmentDataSearchForm() {
		setWidth100();
		setHeight100();
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setWidth("*");
		attachmentCodeItem = new TextItem("attachmentCode", "附件编号");
		attachmentCodeItem.setWidth("*");
		attachmentNameItem = new TextItem("attachmentName", "附件名称");
		attachmentNameItem.setWidth("*");
		startDateItem = new DateItem("startDate", "上传开始日期");
		startDateItem.setWidth("*");
		startDateItem.setUseTextField(true);
		endDateItem = new DateItem("endDate", "上传结束日期");
		endDateItem.setWidth("*");
		endDateItem.setUseTextField(true);

		setItems(contractCodeItem, contractNameItem, attachmentCodeItem, attachmentNameItem, startDateItem, endDateItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
