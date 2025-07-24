package com.pomplatform.client.bonuspaymentbymonth.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.bonuspaymentbymonth.datasource.CDBonusPaymentByMonth;

public class BonusPaymentByMonthSearchForm extends SearchForm
{


	private final SelectItem employeeIdItem;

	public BonusPaymentByMonthSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDBonusPaymentByMonth.getInstance());
		employeeIdItem = new SelectItem("employeeId", "员工编码");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));

		setItems(employeeIdItem);

		setNumCols(2);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
