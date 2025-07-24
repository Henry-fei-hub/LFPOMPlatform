package com.pomplatform.client.signatory.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.signatory.datasource.DSMainProjectMajorEmployee;

public class MainProjectMajorEmployeeNewForm extends AbstractWizadPage
{


	private final TextItem mainProjectIdItem;
	private final TextItem employeeIdItem;
	private final TextItem specialtyIdItem;
	private final TextItem relationItem;
	private final TextItem operatorIdItem;
	private final DateTimeItem createTimeItem;
	private final TextItem stampHolderItem;

	public MainProjectMajorEmployeeNewForm() {
		DSMainProjectMajorEmployee ds = DSMainProjectMajorEmployee.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		mainProjectIdItem = new TextItem("mainProjectId", "大项目主键");
		__formItems.add(mainProjectIdItem);
		employeeIdItem = new TextItem("employeeId", "人员编码");
		__formItems.add(employeeIdItem);
		specialtyIdItem = new TextItem("specialtyId", "专业");
		__formItems.add(specialtyIdItem);
		relationItem = new TextItem("relation", "1专业负责人 2设计人 3制图人 4校对人 5质量管理员 6审核人 7审定人");
		__formItems.add(relationItem);
		operatorIdItem = new TextItem("operatorId", "操作人");
		__formItems.add(operatorIdItem);
		createTimeItem = new DateTimeItem("createTime", "创建时间");
		__formItems.add(createTimeItem);
		stampHolderItem = new TextItem("stampHolder", "印章持有人(盖章人)");
		__formItems.add(stampHolderItem);

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
		manager.setDataSource(DSMainProjectMajorEmployee.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
