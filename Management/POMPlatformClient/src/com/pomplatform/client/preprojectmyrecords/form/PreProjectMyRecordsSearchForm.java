package com.pomplatform.client.preprojectmyrecords.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.preprojectmyrecords.datasource.CDPreProjectMyRecords;

public class PreProjectMyRecordsSearchForm extends SearchForm
{


	private final TextItem applyEmployeeIdItem;
	private final SelectItem departmentIdItem;
	private final SelectItem statusItem;
	private final SelectItem  projectStatusItem;
	private final SelectItem projectBaseOnItem;
	private final TextItem relevantEmployeesItem;
	private final DateTimeItem startDateItem;
	private final DateTimeItem endDateItem;
	public PreProjectMyRecordsSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDPreProjectMyRecords.getInstance());
		applyEmployeeIdItem = new TextItem("applyEmployeeId", "报备人");
		applyEmployeeIdItem.setWidth("*");
		applyEmployeeIdItem.setHidden(true);
		
		departmentIdItem = new SelectItem("departmentId", "营销团队");
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		departmentIdItem.setWidth("*");
		departmentIdItem.setHidden(true);
		
		statusItem = new SelectItem("status", "立项/关闭的流程状态");
		statusItem.setMultiple(true);
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_161"));
		statusItem.setWidth("*");
		statusItem.setHidden(false);
		
		projectStatusItem = new SelectItem("projectStatus", "项目状态");
		projectStatusItem.setMultiple(true);
		projectStatusItem.setValueMap("前期跟踪","竣工总结","不立项","持续跟进","重点跟进","已完成","设计中","暂停");
		projectStatusItem.setWidth("*");
		
		projectBaseOnItem = new SelectItem("projectBaseOn", "立项依据");
		projectBaseOnItem.setMultiple(true);
		projectBaseOnItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_28"));
		projectBaseOnItem.setWidth("*");
		projectBaseOnItem.setHidden(false);
		
		startDateItem=new DateTimeItem("startDate","登记开始时间"); 
		startDateItem.setUseTextField(true);   
		startDateItem.setWidth("*");

		endDateItem=new DateTimeItem("endDate","登记结束时间");
		endDateItem.setWidth("*");
		
		
		relevantEmployeesItem = new TextItem("relevantEmployees", "项目秘书");
		relevantEmployeesItem.setWidth("*");
		relevantEmployeesItem.setHidden(true);
		setItems(applyEmployeeIdItem, departmentIdItem, statusItem, projectStatusItem, projectBaseOnItem, relevantEmployeesItem,startDateItem,endDateItem);

		setNumCols(10);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
