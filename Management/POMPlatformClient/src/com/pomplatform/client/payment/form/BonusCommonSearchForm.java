package com.pomplatform.client.payment.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.payment.datasource.CDBonusCommon;

public class BonusCommonSearchForm extends SearchForm
{


	private final TextItem companyIdItem;
	private final TextItem yearItem;
	private final TextItem monthItem;
	private final TextItem personnelBusinessIdItem;
	private final TextItem salaryTypeItem;
	private final TextItem fundraisingProjectTypeItem;

	public BonusCommonSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDBonusCommon.getInstance());
		companyIdItem = new TextItem("companyId", "所属公司");
		yearItem = new TextItem("year", "undefined");
		monthItem = new TextItem("month", "undefined");
		personnelBusinessIdItem = new TextItem("personnelBusinessId", "流程业务表Id");
		salaryTypeItem = new TextItem("salaryType", "类型（1.募投项目 2.研发项目）");
		fundraisingProjectTypeItem = new TextItem("fundraisingProjectType", "募投项目类型");

		setItems(companyIdItem, yearItem, monthItem, personnelBusinessIdItem, salaryTypeItem, fundraisingProjectTypeItem);

		setNumCols(12);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
