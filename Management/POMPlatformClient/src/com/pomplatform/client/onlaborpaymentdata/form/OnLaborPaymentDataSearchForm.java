package com.pomplatform.client.onlaborpaymentdata.form;

import java.util.Date;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.onlaborpaymentdata.datasource.CDOnLaborPaymentData;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.IPickTreeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class OnLaborPaymentDataSearchForm extends SearchForm
{


	private final TextItem employeeNoItem;
	private final TextItem employeeNameItem;
	private final SelectItem yearItem;
	private final SelectItem monthItem;
	private final IPickTreeItem departmentIdItem;
	private final ComboBoxItem plateIdItem;
	private final ComboBoxItem companyIdItem;

	@SuppressWarnings("deprecation")
	public OnLaborPaymentDataSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLaborPaymentData.getInstance());
		employeeNoItem = new TextItem("employeeNo", "员工编号");
		employeeNoItem.setWidth("*");
		
		employeeNameItem = new TextItem("employeeName", "员工姓名");
		employeeNameItem.setWidth("*");
		
		Date currentDate = new Date();
		yearItem = new SelectItem("year", "年份");
		yearItem.setWidth("*");
		yearItem.setDefaultValue(currentDate.getYear()+1900);
		yearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
		
		monthItem = new SelectItem("month", "月份");
		monthItem.setWidth("*");
		monthItem.setDefaultValue(currentDate.getMonth()+1);
		monthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));
		
		departmentIdItem = new IPickTreeItem("departmentId", "归属部门");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setWidth("*");
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));
		
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));
		
		companyIdItem = new ComboBoxItem("companyId", "归属公司");
		companyIdItem.setWidth("*");
		companyIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		companyIdItem.setValueMap(KeyValueManager.getValueMap("company_records"));

		setItems(employeeNoItem, employeeNameItem, yearItem, monthItem, departmentIdItem, plateIdItem, companyIdItem);

		setNumCols(9);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
