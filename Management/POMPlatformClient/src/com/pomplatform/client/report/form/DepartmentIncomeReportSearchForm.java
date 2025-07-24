package com.pomplatform.client.report.form;

import java.util.*;

import com.delicacy.client.BaseHelpUtils;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.data.RoleDefinition;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.report.datasource.CDDepartmentIncomeReport;

public class DepartmentIncomeReportSearchForm extends SearchForm
{


	private final SelectItem yearItem;
	private final ComboBoxItem plateIdItem;

	public DepartmentIncomeReportSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDDepartmentIncomeReport.getInstance());
		yearItem = new SelectItem("year", "年份");
		KeyValueManager.loadValueMap("system_dictionary_18" , yearItem);
		yearItem.setWidth("*");
		yearItem.setDefaultValue(2019);

		plateIdItem = new ComboBoxItem("plateId", "业务部门");
//		KeyValueManager.loadValueMap("system_dictionary_1" , plateIdItem);
		plateIdItem.setWidth("*");
		//如果拥有查查所有部门的权限
		if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.DEPARTMENT_INCOME_REPORT_ALL)) {
			plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		}else {
			String plateIds = PomPlatformClientUtil.getRolePlateId();
			RoleDefinition.setPlateItemValueMap(plateIdItem,plateIds);
		}

		setItems(yearItem, plateIdItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
