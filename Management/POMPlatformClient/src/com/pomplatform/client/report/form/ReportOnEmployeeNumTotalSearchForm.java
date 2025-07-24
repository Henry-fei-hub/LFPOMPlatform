package com.pomplatform.client.report.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.data.RoleDefinition;
import com.pomplatform.client.report.datasource.CDReportOnEmployeeNumTotal;

public class ReportOnEmployeeNumTotalSearchForm extends SearchForm
{


	private final SelectItem yearItem;
	private final SelectItem plateIdItem;

	public ReportOnEmployeeNumTotalSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDReportOnEmployeeNumTotal.getInstance());
		
		yearItem = new SelectItem("year", "年份");
		yearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
		yearItem.setWidth("*");
		Date currentDate = new Date();
		yearItem.setDefaultValue(currentDate.getYear()+1900);
		
/*		plateIdItem = new SelectItem("plateId", "业务部门");
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));
		plateIdItem.setWidth("*");
		//如果没有加载全部业务部门的权限，只能选择自己的部门
		if (!ClientUtil.checkIsHavePermission(ERPPermissionStatic.REPORT_ON_EMPLOYEE_NUM_TOTAL_ALL)) {
			int plateId=ClientUtil.getPlateId();
			plateIdItem.setDefaultValue(plateId);;
			plateIdItem.addChangeHandler(new ChangeHandler() {
				@Override
				public void onChange(ChangeEvent event) {
					int value=BaseHelpUtils.getIntValue(event.getValue());
					if(plateId!=value) {
						SC.say("您没有查看这个业务部门的权限");
						event.cancel();
					}
				}
			});
		}*/
		
		plateIdItem = new SelectItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		//如果拥有查查所有部门的权限
		if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.REPORT_ON_EMPLOYEE_NUM_TOTAL_ALL)) {
			plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		}else if(!ClientUtil.checkIsHavePermission(ERPPermissionStatic.REPORT_ON_EMPLOYEE_NUM_TOTAL_ALL)&&ClientUtil.checkIsHavePermission(ERPPermissionStatic.REPORT_ON_EMPLOYEE_NUM_TOTAL_OUR)){
			String plateIds = PomPlatformClientUtil.getRolePlateId();
			String[] arr = plateIds.split(",");
			if(arr.length > 0){
				plateIdItem.setDefaultValue(arr[0]);
			}
			RoleDefinition.setPlateItemValueMap(plateIdItem,plateIds);
		}

		setItems(yearItem, plateIdItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
