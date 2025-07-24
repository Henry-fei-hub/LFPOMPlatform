package com.pomplatform.client.personnel.form;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.common.SyncDataUtil;
import com.pomplatform.client.personnel.datasource.CDOnLoadFlowRefuseListOfCostAllocationBuisnessData;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;

public class OnLoadFlowRefuseListOfCostAllocationBuisnessDataSearchForm extends SearchForm
{


	private final ComboBoxItem employeeIdItem;
	private final TextItem customerNameItem;
	private final TextItem projectNameItem;
	private final ComboBoxItem businessTypeItem;
	private final TextItem customerAddressItem;
	private final ComboBoxItem transferEmployeeIdItem;
	private final DateTimeItem operateTimeStartItem;
	private final DateTimeItem operateTimeEndItem;
	private final ComboBoxItem provinceItem;
	private final ComboBoxItem cityItem;

	public OnLoadFlowRefuseListOfCostAllocationBuisnessDataSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLoadFlowRefuseListOfCostAllocationBuisnessData.getInstance());
		
		customerNameItem = new TextItem("customerName", "客户名称");
		customerNameItem.setWidth("*");
		
		projectNameItem = new TextItem("projectName", "项目名称");
		projectNameItem.setWidth("*");
		
		
		employeeIdItem = new ComboBoxItem("oldEmployeeId", "原报备人");
		employeeIdItem.setWidth("*");
		KeyValueManager.loadValueMap("employees", employeeIdItem);
		
		
		LinkedHashMap<String, String> busLinkMap=new LinkedHashMap<>();
		Map<String,Object> bMap=new HashMap<>();
		bMap.put("addtionalCondition", "parent_id>0");
		Record[] brecord=SyncDataUtil.getValueByTableNames("ST_BusinessCategory", "find", bMap);
		for (Record record : brecord) {
			busLinkMap.put(record.getAttributeAsString("businessCategoryName"), record.getAttributeAsString("businessCategoryName"));
		}
		businessTypeItem = new ComboBoxItem("businessType", "业务类别");
		businessTypeItem.setWidth("*");
		businessTypeItem.setValueMap(busLinkMap);
		
		customerAddressItem = new TextItem("customerAddress", "项目地址");
		customerAddressItem.setWidth("*");
		
		transferEmployeeIdItem = new ComboBoxItem("transferEmployeeId", "转交人");
		transferEmployeeIdItem.setWidth("*");
		KeyValueManager.loadValueMap("employees", transferEmployeeIdItem);
		
		operateTimeStartItem = new DateTimeItem("operateTimeStart", "创建开始时间");
		operateTimeStartItem.setWidth("*");
		operateTimeStartItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, operateTimeStartItem);
			}
		});
		operateTimeEndItem = new DateTimeItem("operateTimeEnd", "创建结束时间");
		operateTimeEndItem.setWidth("*");
		operateTimeEndItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, operateTimeEndItem);
			}
		});
		
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

		setItems(customerNameItem,projectNameItem,businessTypeItem,provinceItem,cityItem,customerAddressItem,employeeIdItem,transferEmployeeIdItem,operateTimeStartItem,operateTimeEndItem);
		setNumCols(12);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
