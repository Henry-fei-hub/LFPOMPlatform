package com.pomplatform.client.systeminitloglstor.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.systeminitloglstor.datasource.CDSsysteminitloglstor;

public class SsysteminitloglstorSearchForm extends SearchForm
{


	private final TextItem logMsgItem;
	private final TextItem systemInitLogIdItem;
	private final TextItem typeItem;
	private final TextItem flagItem;

	public SsysteminitloglstorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSsysteminitloglstor.getInstance());
		logMsgItem = new TextItem("logMsg", "日志信息");
		systemInitLogIdItem = new TextItem("systemInitLogId", "主键ID");
		systemInitLogIdItem.hide();
		typeItem = new TextItem("type", "导入类型 ");
		typeItem.hide();
		flagItem = new TextItem("flag", "是否成功");
		flagItem.hide();

		setItems(logMsgItem, systemInitLogIdItem, typeItem, flagItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
