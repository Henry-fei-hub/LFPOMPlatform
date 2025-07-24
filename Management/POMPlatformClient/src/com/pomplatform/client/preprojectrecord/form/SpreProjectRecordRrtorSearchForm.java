package com.pomplatform.client.preprojectrecord.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.preprojectrecord.datasource.CDSpreProjectRecordRrtor;

public class SpreProjectRecordRrtorSearchForm extends SearchForm
{


	private final TextItem relevantEmployeesItem;
	private final TextItem remarkItem;
	private final TextItem trackCodeItem;
	private final TextItem preProjectRecordIdItem;
	private final DateItem trackDateItem;
	private final TextItem informationTypeItem;
	private final TextItem registerEmployeeItem;
	private final DateItem registerDateItem;
	private final TextItem mainProjectIdItem;

	public SpreProjectRecordRrtorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSpreProjectRecordRrtor.getInstance());
		relevantEmployeesItem = new TextItem("relevantEmployees", "相关人员");
		remarkItem = new TextItem("remark", "情况描述");
		trackCodeItem = new TextItem("trackCode", "跟踪编号");
		preProjectRecordIdItem = new TextItem("preProjectRecordId", "主键id");
		trackDateItem = new DateItem("trackDate", "跟踪时间");
		trackDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, trackDateItem);
			}
		});
		informationTypeItem = new TextItem("informationType", "信息类型");
		registerEmployeeItem = new TextItem("registerEmployee", "登记人");
		registerDateItem = new DateItem("registerDate", "登记时间");
		registerDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, registerDateItem);
			}
		});
		mainProjectIdItem = new TextItem("mainProjectId", "项目id");

		setItems(relevantEmployeesItem, remarkItem, trackCodeItem, preProjectRecordIdItem, trackDateItem, informationTypeItem, registerEmployeeItem, registerDateItem, mainProjectIdItem);

		setNumCols(18);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
