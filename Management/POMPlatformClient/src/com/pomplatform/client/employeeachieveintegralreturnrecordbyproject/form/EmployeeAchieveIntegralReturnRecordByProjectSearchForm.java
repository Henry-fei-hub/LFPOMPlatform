package com.pomplatform.client.employeeachieveintegralreturnrecordbyproject.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.employeeachieveintegralreturnrecordbyproject.datasource.CDEmployeeAchieveIntegralReturnRecordByProject;

public class EmployeeAchieveIntegralReturnRecordByProjectSearchForm extends SearchForm
{


	private final ComboBoxItem plateIdItem;
	private final TextItem recordYearItem;
	private final TextItem recordMonthItem;
	private final SelectItem employeeIdItem;

	public EmployeeAchieveIntegralReturnRecordByProjectSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDEmployeeAchieveIntegralReturnRecordByProject.getInstance());
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));	
		
		recordYearItem = new TextItem("recordYear", "年份");
		recordMonthItem = new TextItem("recordMonth", "月份");
		employeeIdItem = new SelectItem("employeeId", "员工");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));

		setItems(plateIdItem, recordYearItem, recordMonthItem, employeeIdItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
