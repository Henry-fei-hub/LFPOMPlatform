package com.pomplatform.client.shift.form;

import java.util.Date;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.BasicPermissionStatic;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.IPickTreeItem;
import com.smartgwt.client.widgets.form.fields.IntegerItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;

public class EmployeeMonthCheckSearchForm extends SearchForm {
	private final SelectItem yearItem;
	private final SelectItem monthItem;
	private final TextItem employeeNoItem;
	private final TextItem employeeNameItem;
	private final IPickTreeItem departmentIdItem;
	private final IntegerItem companyIdItem;
	public EmployeeMonthCheckSearchForm() {
		setWidth100();
		setHeight100();
		Date date = new Date();
		DateTimeFormat yearDf = DateTimeFormat.getFormat("yyyy");
		int year = BaseHelpUtils.getIntValue(yearDf.format(date));
		DateTimeFormat monthDf = DateTimeFormat.getFormat("MM");
		int month = BaseHelpUtils.getIntValue(monthDf.format(date));
		yearItem = new SelectItem("year", "年份");
		yearItem.setWidth("*");
		yearItem.setValue(year);
		yearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
		
		monthItem = new SelectItem("month", "月份");
		monthItem.setWidth("*");
		monthItem.setValue(month);
		monthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));
		
		employeeNoItem = new TextItem("employeeNo", "员工编号");
		employeeNoItem.setWidth("*");
		
		employeeNameItem = new TextItem("employeeName", "员工姓名");
		employeeNameItem.setWidth("*");
		
		departmentIdItem = new IPickTreeItem("departmentId", "部门");
		departmentIdItem.setWidth("*");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));
		departmentIdItem.setValueField("treeId");
		//控制，页面刚加载时，如果员工有自己所在部门的数据查看权限，则加载该部门数据，否则，加载其所能看到的第一个部门的数据
		if(!ClientUtil.checkIsHavePermission(ERPPermissionStatic.CHECK_TOTAL_ALL_SHOW_DATA) && ClientUtil.checkIsHavePermission(ERPPermissionStatic.CHECK_TOTAL_PLATE_SHOW_DATA)){
			String departmentIds = PomPlatformClientUtil.getRoleDepartmentId();
			String[] ids = departmentIds.split(",");
			String departmentId = ClientUtil.getDepartmentId()+"";
			boolean status = false;
			for(String str : ids){
				if(str.equals(departmentId)){
					status = true;
				}
			}
			if(status){
				departmentIdItem.setDefaultValue(departmentId);
			}else{
				departmentIdItem.setDefaultValue(ids[0]);
			}
			departmentIdItem.addChangeHandler(new ChangeHandler() {
				@Override
				public void onChange(ChangeEvent event) {
					if(null != event.getValue()){
						String[] arr = event.getValue().toString().split("/");
						String value = arr[arr.length - 1];
						boolean status = false;
						for(String str : ids){
							if(str.equals(value)){
								status = true;
							}
						}
						if(!status){
							SC.say("对不起，您没有查看这个部门数据的权限");
							event.cancel();
						}
					}
				}
			});
		}

		companyIdItem = new IntegerItem("companyId" , "归属公司");
		companyIdItem.setHidden(true);
		//控制只有查看自己员工的权限
//		if (ClientUtil.checkIsHavePermission(BasicPermissionStatic.EMPLOYEE_CHECK_OWN_COMPANY_DATA)) {
//			int companyId = ClientUtil.getCompanyId();
//			companyIdItem.setDefaultValue(companyId);
//			companyIdItem.setCanEdit(false);
//		}

		setItems(yearItem, monthItem,employeeNoItem,employeeNameItem,departmentIdItem,companyIdItem);
		setNumCols(11);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
