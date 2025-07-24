package com.pomplatform.client.preprojectanalysisdata.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.preprojectanalysisdata.datasource.CDPreProjectAnalysisData;

public class PreProjectAnalysisDataSearchForm extends SearchForm
{


	private final SelectItem businessTypeItem;
	private final SelectItem statusItem;
	private final DateTimeItem startDateItem;
	private final DateTimeItem endDateItem;

	public PreProjectAnalysisDataSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDPreProjectAnalysisData.getInstance());
		businessTypeItem = new SelectItem("businessType", "业务类别");
//		businessTypeItem.setValueMap(KeyValueManager.getValueMap("pre_business_type_detail"));
		KeyValueManager.loadValueMap("pre_business_type_detail",businessTypeItem);
		businessTypeItem.setWidth("*");
		businessTypeItem.setHidden(false);
		
		statusItem = new SelectItem("status", "立项/关闭的流程状态");
		statusItem.setMultiple(true);
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_161"));
		statusItem.setWidth("*");
		statusItem.setHidden(false);
		
		startDateItem=new DateTimeItem("startDate","立项开始时间"); 
		startDateItem.setUseTextField(true);   
		startDateItem.setWidth("*");

		endDateItem=new DateTimeItem("endDate","立项结束时间");
		endDateItem.setWidth("*");
		

		setItems(businessTypeItem, statusItem,startDateItem,endDateItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
