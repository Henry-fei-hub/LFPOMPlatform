package com.pomplatform.client.project.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.project.datasource.DSTalentsMinimumArrangement;

public class TalentsMinimumArrangementNewForm extends AbstractWizadPage
{


	private final SelectItem plateIdItem;
	private final TextItem highDesignerItem;
	private final TextItem middleDesignerItem;
	private final TextItem initialDesignerItem;
	private final SelectItem projectLevelItem;
	private final TextItem operateEmployeeIdItem;
	private final DateTimeItem operateTimeItem;
	private final TextItem remarkItem;

	public TalentsMinimumArrangementNewForm() {
		DSTalentsMinimumArrangement ds = DSTalentsMinimumArrangement.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		plateIdItem = new SelectItem("plateId", "业务部门");
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		__formItems.add(plateIdItem);
		highDesignerItem = new TextItem("highDesigner", "高级设计师");
		__formItems.add(highDesignerItem);
		middleDesignerItem = new TextItem("middleDesigner", "中级设计师");
		__formItems.add(middleDesignerItem);
		initialDesignerItem = new TextItem("initialDesigner", "初级设计师");
		__formItems.add(initialDesignerItem);
		projectLevelItem = new SelectItem("projectLevel", "项目级别");
		projectLevelItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_2"));
		__formItems.add(projectLevelItem);
		operateEmployeeIdItem = new TextItem("operateEmployeeId", "操作人");
		__formItems.add(operateEmployeeIdItem);
		operateTimeItem = new DateTimeItem("operateTime", "操作时间");
		__formItems.add(operateTimeItem);
		remarkItem = new TextItem("remark", "备注");
		__formItems.add(remarkItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
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
		manager.setDataSource(DSTalentsMinimumArrangement.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
