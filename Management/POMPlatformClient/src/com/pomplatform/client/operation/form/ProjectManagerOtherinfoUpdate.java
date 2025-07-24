package com.pomplatform.client.operation.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.operation.datasource.DSProjectManager;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.IPickTreeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class ProjectManagerOtherinfoUpdate extends AbstractWizadPage {

	private final DateItem planStartDateItem;
	private final DateItem planEndDateItem;
	private final DateItem startDateItem;
	private final DateItem endDateItem;
	private final IPickTreeItem departmentIdItem;
	private final TextItem projectSizeItem;
	private final TextItem projectDescriptionItem;
	private final TextItem remarkItem;
	private final TextItem auditReasonItem;

	public ProjectManagerOtherinfoUpdate() {
		DSProjectManager ds = DSProjectManager.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		planStartDateItem = new DateItem("planStartDate", "项目计划开始日期");
		planStartDateItem.setUseTextField(true);
		__formItems.add(planStartDateItem);
		planEndDateItem = new DateItem("planEndDate", "项目计划结束日期");
		planEndDateItem.setUseTextField(true);
		__formItems.add(planEndDateItem);
		startDateItem = new DateItem("startDate", "项目开始日期");
		startDateItem.hide();
		__formItems.add(startDateItem);
		endDateItem = new DateItem("endDate", "项目结束日期");
		endDateItem.hide();
		__formItems.add(endDateItem);
		departmentIdItem = new IPickTreeItem("departmentId", "归属部门");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setWidth("*");
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));
		__formItems.add(departmentIdItem);
		projectSizeItem = new TextItem("projectSize", "项目大小");
		projectSizeItem.setWidth("*");
		__formItems.add(projectSizeItem);
		projectDescriptionItem = new TextItem("projectDescription", "项目描述");
		projectDescriptionItem.setWidth("*");
		projectDescriptionItem.setColSpan(3);
		projectDescriptionItem.setRowSpan(4);
		__formItems.add(projectDescriptionItem);
		remarkItem = new TextItem("remark", "备注");
		remarkItem.setWidth("*");
		__formItems.add(remarkItem);
		auditReasonItem = new TextItem("auditReason", "审核意见");
		auditReasonItem.hide();
		__formItems.add(auditReasonItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(2);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		setPageMode(PAGE_MODE_UPDATE);
		setName("附加信息");
		addMember(__form);
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSProjectManager.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public void startEdit() {
		if (getRecord() != null)
			__form.editRecord(getRecord());
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}
}
