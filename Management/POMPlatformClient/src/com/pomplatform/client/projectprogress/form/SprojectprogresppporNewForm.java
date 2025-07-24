package com.pomplatform.client.projectprogress.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.projectprogress.datasource.DSSprojectprogrespppor;

public class SprojectprogresppporNewForm extends AbstractWizadPage
{


	private final TextItem projectIdItem;
	private final TextItem projectManageIdItem;
	private final TextItem designPhaseItem;
	private final DateItem finishDateItem;
	private final TextItem alternateField1Item;
	private final TextItem alternateField2Item;
	private final TextItem alternateField3Item;
	private final TextItem statusItem;

	public SprojectprogresppporNewForm() {
		__form = new DynamicForm();
		DSSprojectprogrespppor ds = DSSprojectprogrespppor.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		projectIdItem = new TextItem("projectId", "项目编码");
		projectIdItem.setWidth("*");
		projectManageIdItem = new TextItem("projectManageId", "项目负责人编码");
		projectManageIdItem.setWidth("*");
		designPhaseItem = new TextItem("designPhase", "设计阶段");
		designPhaseItem.setWidth("*");
		finishDateItem = new DateItem("finishDate", "完成日期");
		alternateField1Item = new TextItem("alternateField1", "备用字段1");
		alternateField1Item.setWidth("*");
		alternateField2Item = new TextItem("alternateField2", "备用字段2");
		alternateField2Item.setWidth("*");
		alternateField3Item = new TextItem("alternateField3", "备用字段3");
		alternateField3Item.setWidth("*");
		statusItem = new TextItem("status", "status");
		statusItem.setWidth("*");

		__form.setItems(projectIdItem, projectManageIdItem, designPhaseItem, finishDateItem, alternateField1Item, alternateField2Item, alternateField3Item, statusItem);

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
		manager.setDataSource(DSSprojectprogrespppor.getInstance());
		manager.addMember(__form);
	}

	@Override
	public Map<String, FormItem> getItems() {
		Map<String, FormItem> res = new HashMap<String, FormItem>();
		res.put("projectId", projectIdItem);
		res.put("projectManageId", projectManageIdItem);
		res.put("designPhase", designPhaseItem);
		res.put("finishDate", finishDateItem);
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
