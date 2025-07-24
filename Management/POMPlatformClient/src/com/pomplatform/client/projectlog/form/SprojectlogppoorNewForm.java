package com.pomplatform.client.projectlog.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.projectlog.datasource.DSSprojectlogppoor;

public class SprojectlogppoorNewForm extends AbstractWizadPage
{


	private final TextItem projectIdItem;
	private final TextItem operateIdItem;
	private final TextItem departmentIdItem;
	private final TextItem managerIdItem;
	private final TextItem designPhaseItem;
	private final DateTimeItem operateTimeItem;
	private final TextItem logTypeItem;
	private final TextItem logContentItem;
	private final TextItem alternateField1Item;
	private final TextItem alternateField2Item;
	private final TextItem alternateField3Item;
	private final TextItem statusItem;

	public SprojectlogppoorNewForm() {
		__form = new DynamicForm();
		DSSprojectlogppoor ds = DSSprojectlogppoor.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		projectIdItem = new TextItem("projectId", "项目");
		projectIdItem.setWidth("*");
		operateIdItem = new TextItem("operateId", "操作人");
		operateIdItem.setWidth("*");
		departmentIdItem = new TextItem("departmentId", "归属部门");
		departmentIdItem.setWidth("*");
		managerIdItem = new TextItem("managerId", "板块负责人");
		managerIdItem.setWidth("*");
		designPhaseItem = new TextItem("designPhase", "设计阶段");
		designPhaseItem.setWidth("*");
		operateTimeItem = new DateTimeItem("operateTime", "操作时间");
		logTypeItem = new TextItem("logType", "日志类型");
		logTypeItem.setWidth("*");
		logContentItem = new TextItem("logContent", "日志内容");
		logContentItem.setWidth("*");
		alternateField1Item = new TextItem("alternateField1", "备用字段1");
		alternateField1Item.setWidth("*");
		alternateField2Item = new TextItem("alternateField2", "备用字段2");
		alternateField2Item.setWidth("*");
		alternateField3Item = new TextItem("alternateField3", "备用字段3");
		alternateField3Item.setWidth("*");
		statusItem = new TextItem("status", "状态");
		statusItem.setWidth("*");

		__form.setItems(projectIdItem, operateIdItem, departmentIdItem, managerIdItem, designPhaseItem, operateTimeItem, logTypeItem, logContentItem, alternateField1Item, alternateField2Item, alternateField3Item, statusItem);

		__form.setDataSource(ds);
		__form.setNumCols(4);
		addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
		else __form.editNewRecord();
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSSprojectlogppoor.getInstance());
		manager.addMember(__form);
	}

	@Override
	public Map<String, FormItem> getItems() {
		Map<String, FormItem> res = new HashMap<String, FormItem>();
		res.put("projectId", projectIdItem);
		res.put("operateId", operateIdItem);
		res.put("departmentId", departmentIdItem);
		res.put("managerId", managerIdItem);
		res.put("designPhase", designPhaseItem);
		res.put("operateTime", operateTimeItem);
		res.put("logType", logTypeItem);
		res.put("logContent", logContentItem);
		res.put("alternateField1", alternateField1Item);
		res.put("alternateField2", alternateField2Item);
		res.put("alternateField3", alternateField3Item);
		res.put("status", statusItem);
		return res;
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}

	private DynamicForm __form;

}
