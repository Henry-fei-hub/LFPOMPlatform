package com.pomplatform.client.workflow.form;




import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.workflow.datasource.CDApplicationInForFilingListOf;

public class ApplicationInForFilingListOfSearchForm extends SearchForm
{


	private final TextItem employeeIdItem;
	private final TextItem employeeNameItem;
	private final TextItem employeeNoItem;
	private final TextItem statusItem;

	public ApplicationInForFilingListOfSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDApplicationInForFilingListOf.getInstance());
		employeeIdItem = new TextItem("employeeId", "姓名");
		employeeIdItem.hide();

		employeeNameItem = new TextItem("employeeName", "申请人员工姓名");
		employeeNameItem.setWidth("*");
		employeeNoItem = new TextItem("employeeNo", "申请人员工编号");
		employeeNoItem.setWidth("*");

		statusItem = new TextItem("status", "状态");
		statusItem.hide();

		setItems(employeeIdItem, employeeNameItem, employeeNoItem, statusItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}