package com.pomplatform.client.payment.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.payment.datasource.CDOnSalaryAnnualBonusByDepartment;

public class OnSalaryAnnualBonusByDepartmentSearchForm extends SearchForm
{


	private final TextItem companyIdItem;
	private final TextItem plateIdItem;
	private final TextItem departmentIdItem;
	private final TextItem yearItem;

	public OnSalaryAnnualBonusByDepartmentSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnSalaryAnnualBonusByDepartment.getInstance());
		companyIdItem = new TextItem("companyId", "所属公司");
		plateIdItem = new TextItem("plateId", "业务部门");
		departmentIdItem = new TextItem("departmentId", "所属部门");
		yearItem = new TextItem("year", "年份");

		setItems(companyIdItem, plateIdItem, departmentIdItem, yearItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
