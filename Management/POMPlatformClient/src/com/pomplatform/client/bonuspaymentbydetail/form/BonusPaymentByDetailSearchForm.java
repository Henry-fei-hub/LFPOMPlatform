package com.pomplatform.client.bonuspaymentbydetail.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.bonuspaymentbydetail.datasource.CDBonusPaymentByDetail;

public class BonusPaymentByDetailSearchForm extends SearchForm
{


	private final SelectItem employeeIdItem;
	private final TextItem yearItem;
	private final TextItem monthItem;

	public BonusPaymentByDetailSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDBonusPaymentByDetail.getInstance());
		employeeIdItem = new SelectItem("employeeId", "员工编码");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		yearItem = new TextItem("year", "年份");
		monthItem = new TextItem("month", "月份");

		setItems(employeeIdItem, yearItem, monthItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
