package com.pomplatform.client.activitympcor.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.activitympcor.datasource.CDSactivityMpcor;
import com.pomplatform.client.activitympcor.datasource.DSSactivityMpcor;

public class SactivityMpcorSearchForm extends SearchForm
{


	private final DateTimeItem meetTimeItem;
	private final TextItem projectNameItem;
	private final TextItem contactNameItem;
	private final TextItem customerNameItem;
	private final ComboBoxItem meetTypeItem;
	private final TextItem meetTitleItem;
	private final DateTimeItem startDateItem;
	private final DateTimeItem endDateItem;
	private final ComboBoxItem departmentIdItem;
	private final ComboBoxItem provinceItem;
	private final ComboBoxItem cityItem;
	public SactivityMpcorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSactivityMpcor.getInstance());
		meetTimeItem = new DateTimeItem("meetTime", "会议时间");
		meetTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, meetTimeItem);
			}
		});
		meetTimeItem.setWidth("*");
		meetTimeItem.setHidden(true);
		
		projectNameItem = new TextItem("projectName", "项目名称");
		projectNameItem.setWidth("*");
		
		contactNameItem = new TextItem("contactName", "联系人");
		contactNameItem.setWidth("*");
		
		customerNameItem = new TextItem("customerName", "客户名称");
		customerNameItem.setWidth("*");
		
		meetTypeItem = new ComboBoxItem("meetType", "会议类型");
		meetTypeItem.setWidth("*");
		meetTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_150"));
		
		meetTitleItem = new TextItem("meetTitle", "会议主题");
		meetTitleItem.setWidth("*");
		
//		meetTimeItem=new DateTimeItem("meetTime","会议时间");
//		meetTimeItem.setWidth("*");
		startDateItem=new DateTimeItem("startDate","会议开始时间");
		startDateItem.setWidth("*");
		
		endDateItem=new DateTimeItem("endDate","会议结束时间");
		endDateItem.setWidth("*");
		
		departmentIdItem= new ComboBoxItem("departmentId", "营销团队");
		departmentIdItem.setWidth("*");
//		departmentIdItem.setValueMap(KeyValueManager.getValueMap("marketing_departments"));
		KeyValueManager.loadValueMap("marketing_departments",departmentIdItem);
		
		provinceItem=new ComboBoxItem("province","省");
		provinceItem.setWidth("*");
		provinceItem.setValueMap(KeyValueManager.getValueMap("provinces_names"));
		provinceItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Map<String,Object> provinceMap = new HashMap<>();
				provinceMap.put("optType", "getCityNames");
				provinceMap.put("province", provinceItem.getValue());
				DBDataSource.callOperation("EP_PreProjectProcess", provinceMap, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0){
							Record[] cityRecords = dsResponse.getData();
							LinkedHashMap<String, String> cityMap = new LinkedHashMap<>();
							for(Record e : cityRecords){
								cityMap.put(e.getAttribute("allName"), e.getAttribute("allName"));
							}
							cityItem.setValueMap(cityMap);
						}
					}
				});
			}
		});
		provinceItem.setChangeOnKeypress(true);

		cityItem=new ComboBoxItem("city","市");
		cityItem.setWidth("*");
		cityItem.setChangeOnKeypress(true);


		setItems(meetTimeItem, projectNameItem, contactNameItem,customerNameItem, provinceItem,cityItem,meetTypeItem,meetTitleItem,startDateItem,endDateItem,departmentIdItem);

		setNumCols(10);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
