package com.pomplatform.client.employeemoneymanagespeemmepemmor.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.employeemoneymanagespeemmepemmor.datasource.CDMpersonnelbusinessdddemmpor;

public class MpersonnelbusinessdddemmporSearchForm extends SearchForm {

	private final TextItem deleteFlagItem;
	private final ComboBoxItem drafterItem;
	private final PickTreeItem departmentIdItem;
	private final TextItem employeeNoItem;
	private final DateTimeItem minCreateTimeItem;
	private final DateTimeItem maxCreateTimeItem;
	private final SelectItem processStatusItem;

	public MpersonnelbusinessdddemmporSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMpersonnelbusinessdddemmpor.getInstance());
		deleteFlagItem = new TextItem("deleteFlag", "删除状态  0未删除    1已删除");
		deleteFlagItem.hide();
		drafterItem = new ComboBoxItem("drafter", "申请人");
		drafterItem.setChangeOnKeypress(false);
		drafterItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		drafterItem.setWidth("*");
		departmentIdItem = new PickTreeItem("departmentId", "部门");
		departmentIdItem.setWidth("*");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));
		employeeNoItem = new TextItem("employeeNo", "工号");
		employeeNoItem.setWidth("*");
		minCreateTimeItem = new DateTimeItem("minCreateTime", "最早创建时间");
		minCreateTimeItem.hide();
		minCreateTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, minCreateTimeItem);
			}
		});
		maxCreateTimeItem = new DateTimeItem("maxCreateTime", "最晚创建时间");
		maxCreateTimeItem.hide();
		maxCreateTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, maxCreateTimeItem);
			}
		});
		processStatusItem = new SelectItem("processStatus", "流程状态");
		processStatusItem.setWidth("*");
		processStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_120"));

		setItems(deleteFlagItem, drafterItem, departmentIdItem, employeeNoItem, minCreateTimeItem, maxCreateTimeItem,
				processStatusItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
