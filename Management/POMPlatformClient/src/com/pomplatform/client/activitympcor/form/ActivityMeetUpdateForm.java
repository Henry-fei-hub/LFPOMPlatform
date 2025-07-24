package com.pomplatform.client.activitympcor.form;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.activitympcor.datasource.DSSactivityMpcor;
import com.pomplatform.client.selectgridemployeevalue.datasource.DSSelectGridEmployeeValue;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.DateItemSelectorFormat;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class ActivityMeetUpdateForm extends AbstractWizadPage {

	private static final Logger __logger = Logger.getLogger("");
	private final TextItem meetTitleItem;
	private final SelectItem meetTypeItem;
	private final TextItem customerNameItem;
	private final TextItem projectNameItem;
	private final TextItem meetAddressItem;
	private final TextItem contactNameItem;
	private final TextItem theirEmployeesItem;
	private final SelectItem ourEmployeesItem;
	private final DateTimeItem meetTimeItem;
	private final TextAreaItem theirRequireItem;
	private final TextAreaItem meetTargetItem;
	private final TextAreaItem remarkItem;
	private SelectItem provinceItem;
	private SelectItem cityItem;
	private DateTimeItem outTimeStartItem;
	private DateTimeItem outTimeEndItem;
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";

	public ActivityMeetUpdateForm() {
		DSSactivityMpcor ds = DSSactivityMpcor.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		
		meetTitleItem = new TextItem("meetTitle",shouldNotBeNull+"会议主题");
		meetTitleItem.setWidth("*");
		meetTitleItem.setRequired(true);
		__formItems.add(meetTitleItem);
		
		meetTypeItem = new SelectItem("meetType",shouldNotBeNull+"会议类型");
		meetTypeItem.setWidth("*");
		meetTypeItem.setRequired(true);
		meetTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_150"));
		__formItems.add(meetTypeItem);
		
		customerNameItem = new TextItem("customerName",shouldNotBeNull+"客户名称");
		customerNameItem.setCanEdit(true);
		customerNameItem.setRequired(true);
		customerNameItem.setWidth("*");
		__formItems.add(customerNameItem);
		
		projectNameItem = new TextItem("projectName","项目名称");
		projectNameItem.setCanEdit(true);
		projectNameItem.setWidth("*");
		__formItems.add(projectNameItem);
	
		contactNameItem = new TextItem("contactName",shouldNotBeNull+"联系人");
		contactNameItem.setWidth("*");
		contactNameItem.setRequired(true);
		__formItems.add(contactNameItem);
		
		meetTimeItem = new DateTimeItem("meetTime",shouldNotBeNull+"会议时间");
		meetTimeItem.setWidth("*");
		meetTimeItem.setUseTextField(true);
		meetTimeItem.setRequired(true);
		meetTimeItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH_DAY);
		__formItems.add(meetTimeItem);
		
		theirEmployeesItem = new TextItem("theirEmployees",shouldNotBeNull+"甲方出席人员");
		theirEmployeesItem.setWidth("*");
		theirEmployeesItem.setRequired(true);
		__formItems.add(theirEmployeesItem);
		
		ListGridField eNoField = new ListGridField("employeeNo");
		ListGridField eNameField = new ListGridField("employeeName");
		ListGridField departmentIdField = new ListGridField("departmentId");
		eNameField.setCanFilter(true);
		Criteria c = new Criteria();
		c.addCriteria("status", 0);
		ourEmployeesItem = new SelectItem("ourEmployees",shouldNotBeNull+"我方出席人员");
		ourEmployeesItem.setWidth("*");
		ourEmployeesItem.setMultiple(true);
		ourEmployeesItem.setRequired(true);
		ourEmployeesItem.setChangeOnKeypress(false);
		ourEmployeesItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		ourEmployeesItem.setOptionDataSource(DSSelectGridEmployeeValue.getInstance());
		ourEmployeesItem.setDefaultToFirstOption(true);
		ourEmployeesItem.setOptionCriteria(c);
		ourEmployeesItem.setValueField("employeeName");
		ourEmployeesItem.setDisplayField("employeeName");
		ourEmployeesItem.setUseClientFiltering(true);
		ourEmployeesItem.setPickListFields(eNoField, eNameField, departmentIdField);
		ourEmployeesItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		__formItems.add(ourEmployeesItem);
		
		outTimeStartItem=new DateTimeItem("outTimeStart",shouldNotBeNull+"外出开始时间");
		outTimeStartItem.setWidth("*");
		outTimeStartItem.setRequired(true);
		__formItems.add(outTimeStartItem);
		
		outTimeEndItem=new DateTimeItem("outTimeEnd",shouldNotBeNull+"外出结束时间");
		outTimeEndItem.setWidth("*");
		outTimeEndItem.setRequired(true);
		__formItems.add(outTimeEndItem);
		

		
		provinceItem = new SelectItem("province",shouldNotBeNull+"会议地址（省）");
		provinceItem.setWidth("*");
		provinceItem.setValueMap(KeyValueManager.getValueMap("provinces_names"));
		provinceItem.setRequired(true);
		provinceItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				String province=BaseHelpUtils.getString(event.getValue());
				if(province.length()<=0) {return ;}
				Map<String,Object> provinceMap = new HashMap<>();
				provinceMap.put("optType", "getCityNames");
				provinceMap.put("province",province);
				DBDataSource.callOperation("EP_PreProjectProcess", provinceMap, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						cityItem.clearValue();
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
		__formItems.add(provinceItem);
		
		cityItem = new SelectItem("city",shouldNotBeNull+"会议地址（市）");
		cityItem.setWidth("*");
		cityItem.setRequired(true);
		__formItems.add(cityItem);
		
		meetAddressItem = new TextItem("meetAddress",shouldNotBeNull+"会议详细地址");
		meetAddressItem.setWidth("*");
		meetAddressItem.setRequired(true);
		__formItems.add(meetAddressItem);
		
		theirRequireItem = new TextAreaItem("theirRequire","甲方要求");
		theirRequireItem.setWidth("*");
		theirRequireItem.hide();
		__formItems.add(theirRequireItem);
		
		meetTargetItem = new TextAreaItem("meetTarget","会议目标");
		meetTargetItem.setWidth("*");
		meetTargetItem.hide();
		__formItems.add(meetTargetItem);
		
		remarkItem = new TextAreaItem("remark","备注信息");
		remarkItem.setWidth("*");
		__formItems.add(remarkItem);
		
		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		addMember(__form);
		//meetTitleItem.setColSpan(4);
		//meetTypeItem.setColSpan(4);
		//customerNameItem.setColSpan(4);
		//projectNameItem.setColSpan(4);
		//contactNameItem.setColSpan(4);
		//theirEmployeesItem.setColSpan(4);
		//ourEmployeesItem.setColSpan(4);
		//meetTimeItem.setColSpan(4);
		meetAddressItem.setColSpan(4);
		theirRequireItem.setColSpan(4);
		meetTargetItem.setColSpan(4);
		remarkItem.setColSpan(4);
		
	}

	@Override
	public Map getValuesAsMap() {
		Map params = __form.getValues();
		/*ListGridRecord[] reRecords = ourEmployeesItem.getSelectedRecords();
		if(!BaseHelpUtils.isNullOrEmpty(reRecords)){
			String ourEmployees = "";
			for (int i = 0; i < reRecords.length; i++) {
				if(i != 0){
					ourEmployees += ",";
				}
				ourEmployees += reRecords[i].getAttribute("employeeName");
			}
			params.put("ourEmployees", ourEmployees);
		}*/
		params.put("ourEmployees", ourEmployeesItem.getDisplayValue());
		params.put("operateTime", new Date());
		params.put("operateEmployeeId", ClientUtil.getEmployeeId());
		return params;
	}

	@Override
	public boolean checkData() {
		if(!__form.validate()){
			SC.say("请按系统提示修改信息");
			return false;
		}
		return true;
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) {
			Record record = getRecord();
			String idStr = record.getAttribute("ourEmployees");
			if(!BaseHelpUtils.isNullOrEmpty(idStr)){
				String [] strArra = idStr.split(",");
				record.setAttribute("ourEmployees", strArra);
			}
			__form.editRecord(record);
			String province=BaseHelpUtils.getString(provinceItem.getValue());
			if(BaseHelpUtils.isNullOrEmpty(province)&&province.length()<=0) {return;}
			Map<String,Object> provinceMap = new HashMap<>();
			provinceMap.put("optType", "getCityNames");
			provinceMap.put("province", province);
			DBDataSource.callOperation("EP_PreProjectProcess", provinceMap, new DSCallback() {
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					//cityItem.clearValue();
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
		}else{
			__form.editNewRecord();
		}
		
	}

}
