package com.pomplatform.client.payment.form;

import java.util.*;

import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.DateUtil;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.payment.datasource.CDFiveInsuranceOneGoldsPaymentBase;

public class FiveInsuranceOneGoldsPaymentBaseSearchForm extends SearchForm
{


	private final TextItem employeeNoItem;
	private final ComboBoxItem employeeIdItem;
	private final ComboBoxItem companyIdItem;
	private final TextItem yearItem;
	private final TextItem startMonthItem;
	private final TextItem endMonthItem;

	public FiveInsuranceOneGoldsPaymentBaseSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDFiveInsuranceOneGoldsPaymentBase.getInstance());

		employeeNoItem = new TextItem("employeeNo", "员工编号");
		employeeNoItem.setWidth("*");

		employeeIdItem = new ComboBoxItem("employeeId", "姓名");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.setWidth("*");
		employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		employeeIdItem.setChangeOnKeypress(false);

		companyIdItem = new ComboBoxItem("companyId", "归属公司");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("company_records"));
		companyIdItem.setWidth("*");
		companyIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		companyIdItem.setChangeOnKeypress(false);

		yearItem = new TextItem("year", "年份");
		yearItem.setWidth("*");
		yearItem.setDefaultValue(DateUtil.getDisplayYear(new Date()));

		startMonthItem = new TextItem("startMonth", "起始月份");
		startMonthItem.setWidth("*");

		endMonthItem = new TextItem("endMonth", "截止月份");
		endMonthItem.setWidth("*");

		setItems(employeeNoItem, employeeIdItem, companyIdItem, yearItem, startMonthItem, endMonthItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
