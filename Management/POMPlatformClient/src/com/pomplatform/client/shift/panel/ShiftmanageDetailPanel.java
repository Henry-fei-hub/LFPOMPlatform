package com.pomplatform.client.shift.panel;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.DelicacyListGrid;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.shift.datasource.DSShiftmanageDetail;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.DateItemSelectorFormat;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.ChangeEvent;
import com.smartgwt.client.widgets.grid.events.ChangeHandler;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.grid.events.RemoveRecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RemoveRecordClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class ShiftmanageDetailPanel extends HLayout implements HasHandlers 
{


	private static final Logger __logger = Logger.getLogger("");
	private DynamicForm form;
	private DelicacyListGrid grid;
	private Window parentWindow;
	private TextItem shiftNameItem;
	private TextAreaItem remarkItem;
	Map<String,Object> dayMap = new HashMap<>();
	
	public void initComponents(int shiftManageId) {
		grid = new DelicacyListGrid();
		grid.setAutoFitFieldWidths(false);
		setWidth("98%");
		setHeight100();
		setPadding(10);
		setMembersMargin(5);
		VLayout formLayout = new VLayout();
		formLayout.setHeight("98%");
		formLayout.setMembersMargin(5);
		formLayout.setWidth100();
		formLayout.setAlign(Alignment.CENTER);
		addMember(formLayout);

		HLayout messageLayout = new HLayout();
		messageLayout.setWidth100();
		messageLayout.setHeight("26%");
		messageLayout.setAlign(Alignment.CENTER);

		form = new DynamicForm();
		form.setNumCols(6);
		form.setAlign(Alignment.CENTER);
		form.setWidth("95%");
		form.setHeight100();

		shiftNameItem = new TextItem("shiftName","班次名称");
		shiftNameItem.setWidth("*");
		
		DateItem startDateItem = new DateItem("startDate", "起用日期");
		startDateItem.setWidth("*");
		startDateItem.setUseTextField(true);
		startDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);

		DateItem endDateItem = new DateItem("endDate", "结束日期");
		endDateItem.setWidth("*");
		endDateItem.setUseTextField(true);
		endDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
        
        remarkItem = new TextAreaItem("remark", "备注");
        remarkItem.setColSpan(6);
        remarkItem.setRowSpan(3);
        remarkItem.setWidth("*");
		
		form.setItems(shiftNameItem,startDateItem,endDateItem,remarkItem);
		ClientUtil.DynamicFormProcessAccordingToDevice(form);
		messageLayout.addMember(form);
		formLayout.addMember(messageLayout);
		
		ListGridField shiftTimeManageIdField = new ListGridField("shiftTimeManageId", "时段名称");
//		shiftTimeManageIdField.setValueMap(KeyValueManager.getValueMap("shift_time_name"));
		KeyValueManager.loadValueMap("shift_time_name",shiftTimeManageIdField);
		ListGridField signInTimeField = new ListGridField("signInTime", "上班时间"); 
        signInTimeField.setCanEdit(false); 
        ListGridField signOffTimeField = new ListGridField("signOffTime", "下班时间"); 
        signOffTimeField.setCanEdit(false);
       
        shiftTimeManageIdField.addChangeHandler(new ChangeHandler() {
			
			@Override
			public void onChange(ChangeEvent event) {
				int shiftTimeManageId = BaseHelpUtils.getIntValue(event.getValue());
				int recordNum = event.getRowNum();
				Record record = grid.getRecord(recordNum);
				Map<String,Object> params = new HashMap<>();
				params.put("shiftTimeManageId", shiftTimeManageId);
				DBDataSource.callOperation("ST_ShiftTimeManage", "find", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() >= 0) {
							Record[] records = dsResponse.getData();
							record.setAttribute("signInTime",records[0].getAttribute("signInTime"));
							record.setAttribute("signOffTime",records[0].getAttribute("signOffTime"));
							grid.redraw();
						}
					}
				});				
			}
		});
        
        ListGridField mondayField = new ListGridField("monday", "星期一");  
        ListGridField tuesdayField = new ListGridField("tuesday", "星期二");  
        ListGridField wednesdayField = new ListGridField("wednesday", "星期三"); 
        ListGridField thursdayField = new ListGridField("thursday", "星期四"); 
        ListGridField fridayField = new ListGridField("friday", "星期五"); 
        ListGridField saturdayField = new ListGridField("saturday", "星期六"); 
        ListGridField sundayField = new ListGridField("sunday", "星期日"); 
        grid.setFields(shiftTimeManageIdField, signInTimeField,signOffTimeField, mondayField, tuesdayField, wednesdayField,thursdayField,fridayField,saturdayField,sundayField);  
//        grid.setShowRecordComponents(true);          
//        grid.setShowRecordComponentsByCell(true); 
        grid.setCanRemoveRecords(true); 
		grid.setDataSource(DSShiftmanageDetail.getInstance());
		grid.setHeight("60%");
		grid.setWidth100();
		HLayout newTimeLayout = new HLayout();
		newTimeLayout.setWidth100();
		newTimeLayout.setHeight("5%");
		newTimeLayout.setAlign(Alignment.RIGHT);
		
		IButton newTimeBtn = new IButton("新增时间段");
		newTimeBtn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Record record = new Record();
				RecordList list = grid.getRecordList();
				list.add(record);
				grid.setData(list);
				grid.startEditing(list.getLength()-1);
			}
		});
		newTimeLayout.addMember(newTimeBtn);
		formLayout.addMember(newTimeLayout);
		formLayout.addMember(grid);
		grid.addEditCompleteHandler(new EditCompleteHandler() {
			
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				Record record = grid.getRecord(event.getRowNum());
				if(null != record){
					//设置标示字段，默认为true，说明是可以提交，false不可提交
					boolean isCanSubmit = true;
					//获取当前编辑的列号
					int colNum = event.getColNum();
					//获取当前编辑的列的值
					Map valueMap = event.getNewValues();
					if(colNum == 3){//说明是周一
						checkSelected("monday", valueMap, record, isCanSubmit);
					}else if(colNum == 4){//说明是周二
						checkSelected("tuesday", valueMap, record, isCanSubmit);
					}else if(colNum == 5){//说明是周三
						checkSelected("wednesday", valueMap, record, isCanSubmit);
					}else if(colNum == 6){//说明是周四
						checkSelected("thursday", valueMap, record, isCanSubmit);
					}else if(colNum == 7){//说明是周五
						checkSelected("friday", valueMap, record, isCanSubmit);
					}else if(colNum == 8){//说明是周六
						checkSelected("saturday", valueMap, record, isCanSubmit);
					}else if(colNum == 9){//说明是周日
						checkSelected("sunday", valueMap, record, isCanSubmit);
					}
					if(!isCanSubmit){//说明不可提交
						grid.updateData(record);
						grid.redraw();
					}else{
						//如果是新增，则不进行任何操作
						if(flag == 1){//说明是新增
							return;
						}
						Map<Object,Object> params = record.toMap();
						params.put("operateEmployeeId", ClientUtil.getEmployeeId());
						params.put("operateTime", new Date());
						params.put("shiftManageId",shiftManageId);
						DBDataSource.callOperation("ST_TimeOfShiftManage", "saveOrUpdate", params, new DSCallback() {
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								if (dsResponse.getStatus() < 0) {
									ClientUtil.displayErrorMessage(dsResponse);
								}else{
									Record[] records = dsResponse.getData();
									if(null != records && records.length > 0){
										record.setAttribute("timeOfShiftManageId", records[0].getAttribute("timeOfShiftManageId"));
										grid.redraw();
									}
								}
							}
						});
					}
				}
			}
		});
        grid.setCanEdit(true); 
		
		
		HLayout btnLayout = new HLayout();
		btnLayout.setWidth100();
		btnLayout.setHeight("5%");
		btnLayout.setMembersMargin(10);
		btnLayout.setAlign(Alignment.RIGHT);
		
		IButton okBtn = new IButton("确认");
		okBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				Date startDate = (Date) startDateItem.getValue();
				Date endDate = (Date) endDateItem.getValue();
				if(!startDate.before(endDate)){
					SC.say("结束日期不能早于起用日期！");
					return;
				}
				SC.ask("提示", "您确认要保存吗?", new BooleanCallback() {
					@Override
					public void execute(Boolean value) {
						if (value) {
							String shiftName = shiftNameItem.getValueAsString();
							String remark =remarkItem.getValueAsString();
							int operateEmployeeId = ClientUtil.getEmployeeId();
							Map<Object,Object> params = new HashMap<>();
							params.put("shiftManageId", shiftManageId);
							params.put("shiftName", shiftName);
							params.put("startDate", startDate);
							params.put("endDate", endDate);
							params.put("operateEmployeeId", operateEmployeeId);
							params.put("remark", remark);
							params.put("optType", "onUpdateShiftManage");
							MapUtils.convertRecordToMap(grid.getDataSource(), grid.getRecords(), params, "timeOfShiftManages");
							DBDataSource.callOperation("EP_OnShiftManageProcess",params, new DSCallback() {
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if (dsResponse.getStatus() >= 0) {
										okBtn.setDisabled(false);
										SC.say("提示","保存成功");
									} else {
										SC.say("Failure" +dsResponse.getErrors().get("errorMsg"));
									}
								}
							});
						}
					}
				});

			}
		});
		IButton resetBtn = new IButton("重置");
		resetBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				load(shiftManageId);
			}
		});
		IButton cleanBtn = new IButton("关闭");
		cleanBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (getParentWindow() == null) {
					return;
				}
				getParentWindow().destroy();
				DataEditEvent dee = new DataEditEvent();
				fireEvent(dee);
			}
		});
		btnLayout.addMember(okBtn);
		btnLayout.addMember(resetBtn);
		btnLayout.addMember(cleanBtn);
		formLayout.addMember(btnLayout);
		
		
		grid.addRemoveRecordClickHandler(new RemoveRecordClickHandler() {
			@Override
			public void onRemoveRecordClick(RemoveRecordClickEvent event) {
				int rowNum = event.getRowNum();
				ListGridRecord record = grid.getRecord(rowNum);
				int timeOfShiftManageId = BaseHelpUtils.getIntValue(record.getAttribute("timeOfShiftManageId"));
				Map<String,Object> paramMap = new HashMap<>();
				paramMap.put("timeOfShiftManageId", timeOfShiftManageId);
				DBDataSource.callOperation("ST_TimeOfShiftManage", "delete",paramMap, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() < 0) {
							ClientUtil.displayErrorMessage(dsResponse);
						} else {
							grid.removeData(record);
						}
					}
				});
			}
		});
	}
	
	public void checkSelected(String week,Map valueMap,Record record,boolean isCanSubmit){
		Boolean weekValue = BaseHelpUtils.getBoolean(valueMap.get(week));
		if(weekValue){//说明当前操作是选择，那得判断当前周期是否已经被选择，如果已经被选择，则取消本次的选择操作
			if(BaseHelpUtils.getBoolean(map.get(week))){//说明已经被选择过了，则取消本次操作
				isCanSubmit = false;
				record.setAttribute(week,Boolean.FALSE);
			}else{
				map.put(week, Boolean.TRUE);
			}
		}else{//说明是取消，则同步map，也设置为false
			map.put(week, Boolean.FALSE);
		}
	}

	/**
	 * 加载页面时加载该方法
	 * 
	 * @param shiftManageId
	 */
	public void load(int shiftManageId) {
		//加载数据时初始化map的值，从周一到周日的值初始化未选择的状态(即为false)
		map.put("monday",Boolean.FALSE);
		map.put("tuesday",Boolean.FALSE);
		map.put("wednesday",Boolean.FALSE);
		map.put("thursday",Boolean.FALSE);
		map.put("friday",Boolean.FALSE);
		map.put("saturday",Boolean.FALSE);
		map.put("sunday",Boolean.FALSE);
		if (shiftManageId == 0) {
			return;
		}
		Map<String,Object> params = new HashMap<>();
		params.put("shiftManageId", shiftManageId);
		DBDataSource.callOperation("NQ_ShiftmanageDetail", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record[] records = dsResponse.getData();
					if(null != records && records.length > 0){
						form.editRecord(records[0]);
						if(ClientUtil.checkAndGetIntValue(records[0].getAttribute("timeOfShiftManageId")) > 0){
							for(Record record : records){
								if(BaseHelpUtils.getBoolean(record.getAttribute("monday"))){
									map.put("monday",Boolean.TRUE);
								}
								if(BaseHelpUtils.getBoolean(record.getAttribute("tuesday"))){
									map.put("tuesday", Boolean.TRUE);
								}
								if(BaseHelpUtils.getBoolean(record.getAttribute("wednesday"))){
									map.put("wednesday", Boolean.TRUE);
								}
								if(BaseHelpUtils.getBoolean(record.getAttribute("thursday"))){
									map.put("thursday", Boolean.TRUE);
								}
								if(BaseHelpUtils.getBoolean(record.getAttribute("friday"))){
									map.put("friday", Boolean.TRUE);
								}
								if(BaseHelpUtils.getBoolean(record.getAttribute("saturday"))){
									map.put("saturday", Boolean.TRUE);
								}
								if(BaseHelpUtils.getBoolean(record.getAttribute("sunday"))){
									map.put("sunday", Boolean.TRUE);
								}
							}
							grid.setData(records);
						}
					}
				}
			}
		});
	}
	

	protected final HandlerManager handlerManager = new HandlerManager(this);
	protected final List<DataEditedHandler> __dataEditedHandler = new ArrayList<>();

	@Override
	public void fireEvent(GwtEvent<?> event) {
		handlerManager.fireEvent(event);
	}

	public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
		return handlerManager.addHandler(DataEditEvent.TYPE, handler);
	}

	public Window getParentWindow() {
		return parentWindow;
	}

	public void setParentWindow(Window parentWindow) {
		this.parentWindow = parentWindow;
	}
	
	private Map<String,Boolean> map = new HashMap<>();
	
	private int flag;//1:表示新增;2:表示修改

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}
	
}

