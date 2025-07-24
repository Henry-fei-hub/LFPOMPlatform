package com.pomplatform.client.sprojectemployeeadvancerecorddetail.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.sprojectemployeeadvancerecorddetail.datasource.CDSProjectEmployeeAdvanceRecordDetail;

public class SProjectEmployeeAdvanceRecordDetailSearchForm extends SearchForm
{


	private final SelectItem employeeIdItem;
	private final SelectItem advanceYearItem;
	private final SelectItem advanceMonthItem;

	public SProjectEmployeeAdvanceRecordDetailSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSProjectEmployeeAdvanceRecordDetail.getInstance());
		employeeIdItem = new SelectItem("employeeId", "补贴成员");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		advanceYearItem = new SelectItem("advanceYear", "年份");
		advanceYearItem.setValueMap(KeyValueManager.getValueMap("employees"));
		advanceMonthItem = new SelectItem("advanceMonth", "月份");
		advanceMonthItem.setValueMap(KeyValueManager.getValueMap("employees"));

		setItems(employeeIdItem, advanceYearItem, advanceMonthItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
