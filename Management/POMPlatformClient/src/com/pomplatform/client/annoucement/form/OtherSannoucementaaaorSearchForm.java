package com.pomplatform.client.annoucement.form;

import java.util.Date;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.annoucement.datasource.CDSannoucementaaaor;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;

public class OtherSannoucementaaaorSearchForm extends SearchForm
{


	private final TextItem operateEmployeeIdItem;
	private final DateTimeItem annoucementTimeItem;
	private final TextItem annoucementTitleItem;
	private final TextItem annoucementContentItem;
	private final SelectItem statusItem;

	public OtherSannoucementaaaorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSannoucementaaaor.getInstance());
		operateEmployeeIdItem = new TextItem("operateEmployeeId", "发起人");
		operateEmployeeIdItem.setWidth("*");
		operateEmployeeIdItem.setHidden(true);
		annoucementTimeItem = new DateTimeItem("annoucementTime", "公告时间");
		annoucementTimeItem.setWidth("*");
		annoucementTimeItem.setHidden(true);
		annoucementTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, annoucementTimeItem);
			}
		});
		annoucementTitleItem = new TextItem("annoucementTitle", "公告主题");
		annoucementTitleItem.setWidth("*");
		annoucementContentItem = new TextItem("annoucementContent", "公告内容");
		annoucementContentItem.setWidth("*");
		annoucementContentItem.setHidden(true);
		
		statusItem = new SelectItem("status", "公告状态");
		statusItem.setWidth("*");
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_160"));
		statusItem.setHidden(true);
		setItems(operateEmployeeIdItem, annoucementTimeItem, annoucementTitleItem, annoucementContentItem,statusItem);
		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
