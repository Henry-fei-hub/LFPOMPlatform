package com.pomplatform.client.attachmentapprovalupcoming.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.attachmentapprovalupcoming.datasource.CDAttachmentApprovalUpcoming;

public class AttachmentApprovalUpcomingSearchForm extends SearchForm
{


	private final TextItem processTypeItem;
	private final TextItem employeeIdItem;
	private final TextItem budgetManagementIdItem;
	private final TextItem attachmentNameItem;
	private final TextItem uploadEmployeeIdItem;
	private final DateTimeItem uploadTimeItem;
	private final TextItem uploadRemarkItem;
	private final ComboBoxItem projectIdItem;
	private final SelectItem bddTypeItem;
	private final TextItem isApprovalItem;
	private final IPickTreeItem departmentIdItem;

	public AttachmentApprovalUpcomingSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDAttachmentApprovalUpcoming.getInstance());
		processTypeItem = new TextItem("processType", "流程类型");
		processTypeItem.hide();
		
		employeeIdItem = new TextItem("employeeId", "创建人");
		employeeIdItem.hide();
		
		budgetManagementIdItem = new TextItem("budgetManagementId", "预算管理id");
		budgetManagementIdItem.hide();
		
		
		attachmentNameItem = new TextItem("attachmentName", "附件名称");
		attachmentNameItem.setWidth("*");
		
		uploadEmployeeIdItem = new TextItem("uploadEmployeeId", "上传人员");
		uploadEmployeeIdItem.setWidth("*");
		uploadEmployeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		
		uploadTimeItem = new DateTimeItem("uploadTime", "上传时间");
		uploadTimeItem.hide();
		uploadTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, uploadTimeItem);
			}
		});
		uploadRemarkItem = new TextItem("uploadRemark", "附件备注");
		uploadRemarkItem.hide();
		
		projectIdItem = new ComboBoxItem("projectId", "项目名称");
		projectIdItem.setWidth("*");
		projectIdItem.setChangeOnKeypress(false);
		KeyValueManager.loadValueMap("projects",projectIdItem);
		
		
		bddTypeItem = new SelectItem("bddType", "预算类别");
		bddTypeItem.setWidth("*");
		bddTypeItem.setValueMap(KeyValueManager.getValueMap("budget_detail_type"));
		
		
		isApprovalItem = new TextItem("isApproval", "是否审批 0.未审批 1.审批进行中,2.已审批");
		isApprovalItem.hide();
		
		departmentIdItem = new IPickTreeItem("departmentId", "归属部门");
		departmentIdItem.setHidden(true);
		departmentIdItem.setWidth("*");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));

		setItems(processTypeItem,  employeeIdItem, budgetManagementIdItem, attachmentNameItem, uploadEmployeeIdItem, uploadTimeItem, uploadRemarkItem, projectIdItem, bddTypeItem, isApprovalItem, departmentIdItem);

		setNumCols(12);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
