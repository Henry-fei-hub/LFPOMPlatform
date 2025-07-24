package com.pomplatform.client.attachmentmanagemeeting.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.attachmentmanagemeeting.datasource.CDAttachmentManageMeetingTor;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class AttachmentManageMeetingTorSearchForm extends SearchForm
{


	private final ComboBoxItem projectManageIdItem;
	private final TextItem contractIdItem;
	private final TextItem attachmentNameItem;
	private final TextItem contractNameItem;
	private final TextItem contractCodeItem;
	private final TextItem remarkItem;
	private final TextItem mettingStatusItem;
	private final TextItem operatorStatusItem;
	private final TextItem yearItem;
	private final TextItem workNumItem;

	public AttachmentManageMeetingTorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDAttachmentManageMeetingTor.getInstance());
		projectManageIdItem = new ComboBoxItem("projectManageId", "项目负责人");
		projectManageIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		projectManageIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		projectManageIdItem.setChangeOnKeypress(false);
		
		projectManageIdItem.setWidth("*");
		contractIdItem = new TextItem("contractId", "合同编码");
		contractIdItem.hide();
		attachmentNameItem = new TextItem("attachmentName", "附件名称");
		attachmentNameItem.hide();
		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setWidth("*");
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		
		remarkItem = new TextItem("remark", "备注");
		remarkItem.setWidth("*");
		mettingStatusItem = new TextItem("mettingStatus", "1新建 2发布 3定稿");
		mettingStatusItem.hide();
		operatorStatusItem = new ComboBoxItem("operatorStatus", "操作状态");//1 待提交 2已提交  3未答复
		operatorStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_142"));
		operatorStatusItem.setChangeOnKeypress(false);
		operatorStatusItem.setWidth("*");
		
		//operatorStatusItem.hide();
		yearItem = new TextItem("year", "年份");
		yearItem.hide();
		workNumItem = new TextItem("workNum", "第几周");
		workNumItem.hide();

		setItems(projectManageIdItem, contractIdItem, attachmentNameItem, contractNameItem, contractCodeItem, remarkItem, mettingStatusItem, operatorStatusItem, yearItem, workNumItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
