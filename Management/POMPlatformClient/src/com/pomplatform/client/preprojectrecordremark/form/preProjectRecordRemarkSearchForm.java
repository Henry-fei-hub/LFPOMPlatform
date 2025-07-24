package com.pomplatform.client.preprojectrecordremark.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.preprojectrecordremark.datasource.CDpreProjectRecordRemark;

public class preProjectRecordRemarkSearchForm extends SearchForm
{


	private final TextItem projectSalesTeamItem;
	private final SelectItem statusItem;
	private final SelectItem projectStatusItem;
	private final SelectItem projectBaseOnItem;
	private final DateTimeItem startDateItem;
	private final DateTimeItem endDateItem;

	public preProjectRecordRemarkSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDpreProjectRecordRemark.getInstance());
		projectSalesTeamItem = new TextItem("projectSalesTeam", "营销团队");
		projectSalesTeamItem.setHidden(true);
		statusItem = new SelectItem("status", "项目流程状态");
		statusItem.setMultiple(true);
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_161"));
		statusItem.setWidth("*");

		projectStatusItem = new SelectItem("projectStatus", "项目状态");
		projectStatusItem.setMultiple(true);
		projectStatusItem.setValueMap("前期跟踪","竣工总结","不立项","持续跟进","重点跟进","已完成","设计中","暂停");
		projectStatusItem.setWidth("*");

		projectBaseOnItem = new SelectItem("projectBaseOn", "立项依据");
		projectBaseOnItem.setMultiple(true);
		projectBaseOnItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_28"));
		projectBaseOnItem.setWidth("*");

		startDateItem=new DateTimeItem("startDate","开始时间"); 
		startDateItem.setUseTextField(true);   
		startDateItem.setWidth("*");

		endDateItem=new DateTimeItem("endDate","结束时间");
		endDateItem.setWidth("*");

		setItems(projectSalesTeamItem, statusItem, projectStatusItem, projectBaseOnItem,startDateItem,endDateItem);

		setNumCols(10);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
