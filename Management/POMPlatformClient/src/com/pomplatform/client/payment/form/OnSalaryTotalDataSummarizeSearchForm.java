package com.pomplatform.client.payment.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.pomplatform.client.payment.datasource.CDOnSalaryTotalDataSummarize;

public class OnSalaryTotalDataSummarizeSearchForm extends SearchForm
{


	private final SelectItem startyearItem;
	private final SelectItem endyearItem;
	private final SelectItem startmonthItem;
	private final SelectItem endmonthItem;
	private final SelectItem employeeIdItem;
	private final TextItem employeeNoItem;
	private final TextItem employeeNameItem;
	private final ComboBoxItem companyIdItem;
	private final IPickTreeItem departmentIdItem;
	private final ComboBoxItem plateIdItem;

	public OnSalaryTotalDataSummarizeSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnSalaryTotalDataSummarize.getInstance());
		Date date = new Date();
		DateTimeFormat yearDf = DateTimeFormat.getFormat("yyyy");
		int year = BaseHelpUtils.getIntValue(yearDf.format(date));
		DateTimeFormat monthDf = DateTimeFormat.getFormat("MM");
		int month = BaseHelpUtils.getIntValue(monthDf.format(date));
		
		startyearItem = new SelectItem("startyear", "开始年份");
		startyearItem.setWidth("*");
		startyearItem.setValue(year);
		startyearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
		endyearItem = new SelectItem("endyear", "结束年份");
		endyearItem.hide();
		endyearItem.setWidth("*");
		endyearItem.setValue(year);
		endyearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
		startmonthItem = new SelectItem("startmonth", "开始月份");
		startmonthItem.hide();
		startmonthItem.setWidth("*");
		startmonthItem.setValue(month);
		startmonthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));
		endmonthItem = new SelectItem("endmonth", "结束月份");
		endmonthItem.hide();
		endmonthItem.setWidth("*");
		endmonthItem.setValue(month);
		endmonthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));
		employeeIdItem = new SelectItem("employeeId", "员工id");
		employeeIdItem.hide();
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeNoItem = new TextItem("employeeNo", "员工编号");
		employeeNoItem.setWidth("*");
		employeeNameItem = new TextItem("employeeName", "员工姓名");
		employeeNameItem.setWidth("*");
		companyIdItem = new ComboBoxItem("companyId", "归属公司");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("company_records"));
		companyIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		companyIdItem.setWidth("*");
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setWidth("*");
		departmentIdItem = new IPickTreeItem("departmentId", "归属部门");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setWidth("*");
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));

		setItems(startyearItem, endyearItem, startmonthItem, endmonthItem, employeeIdItem, employeeNoItem, employeeNameItem, companyIdItem, departmentIdItem, plateIdItem);

		setNumCols(20);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
