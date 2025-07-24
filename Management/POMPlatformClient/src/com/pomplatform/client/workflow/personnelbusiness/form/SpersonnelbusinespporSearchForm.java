package com.pomplatform.client.workflow.personnelbusiness.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.workflow.personnelbusiness.datasource.CDSpersonnelbusinesppor;

public class SpersonnelbusinespporSearchForm extends SearchForm
{


	private final TextItem personnelBusinessIdItem;
	private final TextItem processTypeItem;

	public SpersonnelbusinespporSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSpersonnelbusinesppor.getInstance());
		personnelBusinessIdItem = new TextItem("personnelBusinessId", "人事业务编码");
		processTypeItem = new TextItem("processType", "类型 12请假  13出差  14打卡  15外出  16加班");

		setItems(personnelBusinessIdItem, processTypeItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
