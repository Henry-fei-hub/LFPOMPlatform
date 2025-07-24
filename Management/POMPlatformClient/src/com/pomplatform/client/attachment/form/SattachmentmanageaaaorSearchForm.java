package com.pomplatform.client.attachment.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.attachment.datasource.CDSattachmentmanageaaaor;

public class SattachmentmanageaaaorSearchForm extends SearchForm
{


	private final TextItem attachmentCodeItem;
	private final TextItem attachmentNameItem;
	private final TextItem attachmentAddressItem;
	private final TextItem perfessionRemarkItem;
	private final TextItem attachmentManageIdItem;
	private final TextItem contractIdItem;
	private final TextItem serialNumberItem;

	public SattachmentmanageaaaorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSattachmentmanageaaaor.getInstance());
		attachmentCodeItem = new TextItem("attachmentCode", "编号");
		attachmentNameItem = new TextItem("attachmentName", "附件名称");
		attachmentAddressItem = new TextItem("attachmentAddress", "附件路径");
		perfessionRemarkItem = new TextItem("perfessionRemark", "专业备注");
		attachmentManageIdItem = new TextItem("attachmentManageId", "主键编码");
		contractIdItem = new TextItem("contractId", "合同编码");
		serialNumberItem = new TextItem("serialNumber", "序列号(生成编号的序号)");

		setItems(attachmentCodeItem, attachmentNameItem, attachmentAddressItem, perfessionRemarkItem, attachmentManageIdItem, contractIdItem, serialNumberItem);

		setNumCols(14);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
