package com.pomplatform.client.shift.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.shift.datasource.DSSshiftmanagesor;

public class SshiftmanagesorUpdateForm extends AbstractWizadPage
{


	private final TextItem shiftManageIdItem;
	private final TextItem shiftNameItem;
	private final DateItem startDateItem;
	private final DateItem endDateItem;
	private final CheckboxItem isEnableItem;
	private final TextItem operateEmployeeIdItem;
	private final DateTimeItem operateTimeItem;
	private final TextItem remarkItem;

	public SshiftmanagesorUpdateForm() {
		DSSshiftmanagesor ds = DSSshiftmanagesor.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		shiftManageIdItem = new TextItem("shiftManageId", "主键编码");
		shiftManageIdItem.setDisabled(true);
		shiftManageIdItem.setRequired(true);
		IsIntegerValidator shiftManageIdValidator = new IsIntegerValidator();
		shiftManageIdItem.setValidators(shiftManageIdValidator);
		__formItems.add(shiftManageIdItem);
		shiftNameItem = new TextItem("shiftName", "班次名称");
		__formItems.add(shiftNameItem);
		startDateItem = new DateItem("startDate", "起用日期");
		__formItems.add(startDateItem);
		endDateItem = new DateItem("endDate", "结束日期");
		__formItems.add(endDateItem);
		isEnableItem = new CheckboxItem("isEnable", "是否启用");
		__formItems.add(isEnableItem);
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
		setPageMode(PAGE_MODE_UPDATE);
		addMember(__form);
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSSshiftmanagesor.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
