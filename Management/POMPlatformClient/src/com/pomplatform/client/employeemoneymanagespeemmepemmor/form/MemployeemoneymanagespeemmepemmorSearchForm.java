package com.pomplatform.client.employeemoneymanagespeemmepemmor.form;

import java.util.Date;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.employeemoneymanagespeemmepemmor.datasource.CDMemployeemoneymanagespeemmepemmor;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;

public class MemployeemoneymanagespeemmepemmorSearchForm extends SearchForm
{


	private final ComboBoxItem employeeIdItem;
	private final TextItem equivalentNumberItem;
	private final DateTimeItem minCompleteTimeItem;
	private final DateTimeItem maxCompleteTimeItem;
	private final TextItem processStatusItem;

	public MemployeemoneymanagespeemmepemmorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMemployeemoneymanagespeemmepemmor.getInstance());
		employeeIdItem = new ComboBoxItem("employeeId", "职员编码");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.setHidden(true);
		
		equivalentNumberItem = new TextItem("equivalentNumber", "对冲编号");
		equivalentNumberItem.hide();
		minCompleteTimeItem = new DateTimeItem("minCompleteTime", "最早完成时间");
		minCompleteTimeItem.setWidth("*");
		minCompleteTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, minCompleteTimeItem);
			}
		});
		maxCompleteTimeItem = new DateTimeItem("maxCompleteTime", "最晚完成时间");
		maxCompleteTimeItem.setWidth("*");
		maxCompleteTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, maxCompleteTimeItem);
			}
		});
		processStatusItem = new TextItem("processStatus", "流程状态");
		processStatusItem.hide();

		setItems(employeeIdItem, equivalentNumberItem, minCompleteTimeItem, maxCompleteTimeItem, processStatusItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
