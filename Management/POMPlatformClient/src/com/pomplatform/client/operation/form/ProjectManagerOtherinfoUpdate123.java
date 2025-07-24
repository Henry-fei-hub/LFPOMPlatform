package com.pomplatform.client.operation.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.operation.datasource.DSProjectManager;

public class ProjectManagerOtherinfoUpdate123 extends AbstractWizadPage
{


	private final DateItem planStartDateItem;
	private final DateItem planEndDateItem;
	private final SelectItem departmentIdItem;
	private final TextItem projectSizeItem;
	private final TextItem budgetItem;
	private final TextAreaItem projectDescriptionItem;

	public ProjectManagerOtherinfoUpdate123() {
		DSProjectManager ds = DSProjectManager.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		planStartDateItem = new DateItem("planStartDate", "项目计划开始日期");
		planStartDateItem.setUseTextField(true);
                planStartDateItem.setDisabled(true);
		__formItems.add(planStartDateItem);
		
		planEndDateItem = new DateItem("planEndDate", "项目计划结束日期");
		planEndDateItem.setUseTextField(true);
                planEndDateItem.setDisabled(true);
		__formItems.add(planEndDateItem);
		
		departmentIdItem = new SelectItem("departmentId", "归属部门");
                departmentIdItem.setWidth("*");
                departmentIdItem.setDisabled(true);
		departmentIdItem.setValueMap((LinkedHashMap) ds.getField("departmentId").getValueMap());
		__formItems.add(departmentIdItem);
		
		projectSizeItem = new TextItem("projectSize", "项目大小");
		projectSizeItem.setWidth("*");
                projectSizeItem.setDisabled(true);
		__formItems.add(projectSizeItem);
		
		budgetItem = new TextItem("budget", "预算");
                budgetItem.hide();
		budgetItem.setWidth("*");
                budgetItem.setDisabled(true);
		__formItems.add(budgetItem);
		
		projectDescriptionItem = new TextAreaItem("projectDescription", "项目描述");
		projectDescriptionItem.setWidth("*");
		projectDescriptionItem.setColSpan(3);
		projectDescriptionItem.setRowSpan(4);
                projectDescriptionItem.setDisabled(true);
		__formItems.add(projectDescriptionItem);
		
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
		if(getRecord() != null) __form.editRecord(getRecord());
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}
}
