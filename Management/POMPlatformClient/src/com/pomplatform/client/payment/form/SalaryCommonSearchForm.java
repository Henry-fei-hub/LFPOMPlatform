package com.pomplatform.client.payment.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.payment.datasource.CDSalaryCommon;

public class SalaryCommonSearchForm extends SearchForm
{


	private final TextItem employeeIdItem;
	private final TextItem plateIdItem;
	private final TextItem companyIdItem;
	private final TextItem salaryTypeItem;
	private final TextItem fundraisingProjectTypeItem;
	private final TextItem yearItem;
	private final TextItem monthItem;

	public SalaryCommonSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSalaryCommon.getInstance());
		employeeIdItem = new TextItem("employeeId", "员工id");
		plateIdItem = new TextItem("plateId", "业务部门");
		companyIdItem = new TextItem("companyId", "归属公司");
		salaryTypeItem = new TextItem("salaryType", "类型（1.募投项目 2.研发项目,0正常薪资发放）");
		fundraisingProjectTypeItem = new TextItem("fundraisingProjectType", "募投项目类型");
		yearItem = new TextItem("year", "年份");
		monthItem = new TextItem("month", "月份");

		setItems(employeeIdItem, plateIdItem, companyIdItem, salaryTypeItem, fundraisingProjectTypeItem, yearItem, monthItem);

		setNumCols(14);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
