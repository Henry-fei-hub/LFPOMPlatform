package com.pomplatform.client.payment.form;

import java.util.*;

import com.delicacy.client.BasicPermissionStatic;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.payment.datasource.CDFiveInsuranceOneGolds;

public class FiveInsuranceOneGoldsSearchForm extends SearchForm
{


	private final ComboBoxItem employeeIdItem;
	private final TextItem employeeNoItem;
	private final ComboBoxItem ownedCompanyItem;
	private final SelectItem yearsItem;
    private final SelectItem startMonthItem;
    private final SelectItem endMonthItem;

	public FiveInsuranceOneGoldsSearchForm() {
		setWidth100();
		setHeight100();
		employeeIdItem = new ComboBoxItem("employeeId", "职员姓名");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		employeeIdItem.setWidth("*");
		
		employeeNoItem = new TextItem("employeeNo", "职员编号");
		employeeNoItem.setWidth("*");
		
		ownedCompanyItem = new ComboBoxItem("companyId", "所属公司");
		ownedCompanyItem.setValueMap(KeyValueManager.getValueMap("company_records"));
		ownedCompanyItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		ownedCompanyItem.setWidth("*");
		//控制只有查看自己员工的权限
		if (ClientUtil.checkIsHavePermission(BasicPermissionStatic.EMPLOYEE_CHECK_OWN_COMPANY_DATA)) {
			int companyId = ClientUtil.getCompanyId();
			ownedCompanyItem.setDefaultValue(companyId);
			ownedCompanyItem.setCanEdit(false);
		}

		Date today = new Date();
        yearsItem = new SelectItem("year", "年份");
        yearsItem.setValue(2017);
        yearsItem.setWidth("*");
        yearsItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
        
        startMonthItem = new SelectItem("startMonth", "开始月份");
        startMonthItem.setWidth("*");
        startMonthItem.setValue(today.getMonth() + 1);
        startMonthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));
        
        endMonthItem = new SelectItem("endMonth", "截止月份");
        endMonthItem.setWidth("*");
        endMonthItem.setValue(today.getMonth() + 2);
        endMonthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));
		
		setItems(employeeIdItem, employeeNoItem, ownedCompanyItem,yearsItem,startMonthItem,endMonthItem);

		setNumCols(12);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
