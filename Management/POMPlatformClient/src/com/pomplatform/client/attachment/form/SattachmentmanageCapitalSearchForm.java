package com.pomplatform.client.attachment.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.attachment.datasource.CDSattachmentmanageCapital;

public class SattachmentmanageCapitalSearchForm extends SearchForm
{


	private final TextItem attachmentCodeItem;
	private final TextItem attachmentNameItem;
	private final TextItem attachmentAddressItem;
	private final TextItem perfessionRemarkItem;
	private final TextItem remarkItem;
	private final CheckboxItem paymentSureItem;
	private final TextItem operateEmployeeIdItem;
	private final TextItem deleteFlagItem;
	private final TextItem attachmentManageIdItem;
	private final TextItem contractIdItem;
	private final TextItem projectManageIdItem;
	private final SelectItem departmentIdItem;
	private final TextItem superProjectManageIdItem;

	public SattachmentmanageCapitalSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSattachmentmanageCapital.getInstance());
		attachmentCodeItem = new TextItem("attachmentCode", "编号");
		attachmentNameItem = new TextItem("attachmentName", "附件名称");
		attachmentAddressItem = new TextItem("attachmentAddress", "附件路径");
		perfessionRemarkItem = new TextItem("perfessionRemark", "专业备注");
		remarkItem = new TextItem("remark", "备注");
		paymentSureItem = new CheckboxItem("paymentSure", "收款确认");
		operateEmployeeIdItem = new TextItem("operateEmployeeId", "操作人");
		deleteFlagItem = new TextItem("deleteFlag", "0/1 是/否删除");
		attachmentManageIdItem = new TextItem("attachmentManageId", "主键编码");
		contractIdItem = new TextItem("contractId", "合同编码");
		projectManageIdItem = new TextItem("projectManageId", "项目负责人");
		departmentIdItem = new SelectItem("departmentId", "负责部门");
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		superProjectManageIdItem = new TextItem("superProjectManageId", "大项目负责人");

		setItems(attachmentCodeItem, attachmentNameItem, attachmentAddressItem, perfessionRemarkItem, remarkItem, paymentSureItem, operateEmployeeIdItem, deleteFlagItem, attachmentManageIdItem, contractIdItem, projectManageIdItem, departmentIdItem, superProjectManageIdItem);

		setNumCols(26);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
