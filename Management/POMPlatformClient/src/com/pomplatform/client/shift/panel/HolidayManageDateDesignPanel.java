package com.pomplatform.client.shift.panel;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractWizadPage;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.pomplatform.client.company.datasource.DSCompanyReportIntegralDataSource;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceSequenceField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.calendar.Calendar;
import com.smartgwt.client.widgets.calendar.events.CalendarEventAdded;
import com.smartgwt.client.widgets.calendar.events.CalendarEventChangedEvent;
import com.smartgwt.client.widgets.calendar.events.DateChangedEvent;
import com.smartgwt.client.widgets.calendar.events.DateChangedHandler;
import com.smartgwt.client.widgets.calendar.events.EventAddedHandler;
import com.smartgwt.client.widgets.calendar.events.EventChangedHandler;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.layout.HLayout;

public class HolidayManageDateDesignPanel extends AbstractWizadPage {
    private final Logger logger = Logger.getLogger("");
  	private HLayout mainLayout;
  	private DataSource eventDS;
  	private Calendar calendar;
    
    public HolidayManageDateDesignPanel() {
    	mainLayout = new HLayout(10);
    	mainLayout.setWidth100();
    	mainLayout.setHeight100();
    	
    	eventDS = new DataSource();  
        DataSourceSequenceField eventIdField = new DataSourceSequenceField("holidayManageId");  
        eventIdField.setPrimaryKey(true);  
  
        DataSourceTextField nameField = new DataSourceTextField("name");  
        DataSourceTextField descField = new DataSourceTextField("description");  
        DataSourceDateTimeField startDateField = new DataSourceDateTimeField("startTime");  
        DataSourceDateTimeField endDateField = new DataSourceDateTimeField("endTime");  
  
        eventDS.setFields(eventIdField, nameField, descField, startDateField,endDateField);  
        eventDS.setClientOnly(true);  
        calendar = new Calendar();
        calendar.setAutoFetchData(true);  
        calendar.setShowWeekView(false);
        calendar.setShowDayView(false);
        calendar.setEventNameFieldTitle("节日名称");
        calendar.setRemoveButtonTitle("移除");
        calendar.setSaveButtonTitle("保存");
        calendar.setDataSource(eventDS);
        calendar.setStartDateField("startTime");
        calendar.setEndDateField("endTime");
        calendar.setCanRemoveEvents(false);
        //隐藏头部时间选择导航
//        calendar.setShowControlsBar(false);
        calendar.addDateChangedHandler(new DateChangedHandler() {
			
			@Override
			public void onDateChanged(DateChangedEvent event) {
				getRecords();
			}
		});
        
        calendar.addEventAddedHandler(new EventAddedHandler() {
			@Override
			public void onEventAdded(CalendarEventAdded event) {
				Record record = event.getEvent();
				Date chosenDate = calendar.getChosenDate();
				DateTimeFormat dfYear = DateTimeFormat.getFormat("yyyy");
				String year = dfYear.format(chosenDate);
				DateTimeFormat dfMonth = DateTimeFormat.getFormat("MM");
				String month = dfMonth.format(chosenDate);
				Map<Object,Object> param = new HashMap<>();
		    	param.put("year",year);
		    	param.put("month",month);
		    	param.put("recordDate",chosenDate);
		    	param.put("operateEmployeeId",ClientUtil.getEmployeeId());
		    	param.put("operateTime",new Date());
		    	param.putAll(record.toMap());
		    	DBDataSource.callOperation("ST_HolidayManage", "save", param, new DSCallback() {
		            @Override
		            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
		                if (dsResponse.getStatus() >= 0) {
		                	Record[] records = dsResponse.getData();
		                	if(records.length > 0){
		                		SC.say("提示","保存成功");
		                		getRecords();
		                	}
		                } else {
		                    SC.say(dsResponse.getErrors().get("errorMsg").toString());
		                }
		            }
		        });
			}
		});
//        calendar.addEventRemoveClickHandler(new EventRemoveClickHandler() {
//			@Override
//			public void onEventRemoveClick(CalendarEventRemoveClick event) {
//				Record record = event.getEvent();
//				Map<Object,Object> param = new HashMap<>();
//		    	param.putAll(record.toMap());
//		    	DBDataSource.callOperation("ST_HolidayManage", "delete", param, new DSCallback() {
//		            @Override
//		            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//		                if (dsResponse.getStatus() >= 0) {
//		                	Record[] records = dsResponse.getData();
//		                	if(records.length > 0){
//		                		SC.say("提示","删除成功");
//		                	}
//		                } else {
//		                    SC.say(dsResponse.getErrors().get("errorMsg").toString());
//		                }
//		            }
//		        });
//			}
//		});
        
        calendar.addEventChangedHandler(new EventChangedHandler() {
			@Override
			public void onEventChanged(CalendarEventChangedEvent event) {
				Record record = event.getEvent();
				Date chosenDate = calendar.getChosenDate();
				DateTimeFormat dfYear = DateTimeFormat.getFormat("yyyy");
				String year = dfYear.format(chosenDate);
				DateTimeFormat dfMonth = DateTimeFormat.getFormat("MM");
				String month = dfMonth.format(chosenDate);
				Map<Object,Object> param = new HashMap<>();
		    	param.put("year",year);
		    	param.put("month",month);
		    	param.put("recordDate",chosenDate);
		    	param.put("operateEmployeeId",ClientUtil.getEmployeeId());
		    	param.put("operateTime",new Date());
		    	param.putAll(record.toMap());
		    	DBDataSource.callOperation("ST_HolidayManage", "update", param, new DSCallback() {
		            @Override
		            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
		                if (dsResponse.getStatus() >= 0) {
		                	Record[] records = dsResponse.getData();
		                	if(records.length > 0){
		                		SC.say("提示","更新成功");
		                	}
		                } else {
		                    SC.say(dsResponse.getErrors().get("errorMsg").toString());
		                }
		            }
		        });
			}
		});
        
        mainLayout.addMember(calendar);
        addMember(mainLayout);
    }

    @Override
    public void startEdit() {
    	
    }
    
    public void getRecords(){
    	//获取选择日期的年月份
		Date chosenDate = calendar.getChosenDate();
		DateTimeFormat dfYear = DateTimeFormat.getFormat("yyyy");
		String year = dfYear.format(chosenDate);
		DateTimeFormat dfMonth = DateTimeFormat.getFormat("MM");
		String month = dfMonth.format(chosenDate);
    	Map<Object,Object> param = new HashMap<>();
    	param.put("year",year);
    	param.put("month",month);
    	DBDataSource.callOperation("ST_HolidayManage", "find", param, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                	Record[] records = dsResponse.getData();
                	if(records.length > 0){
                		eventDS.setTestData(records);
                		calendar.setData(records);
                		calendar.redraw();
                	}
                } else {
                    SC.say(dsResponse.getErrors().get("errorMsg").toString());
                }
            }
        });
    }
    

    @Override
    public void setValueManage(ValuesManager manager) {
        manager.setDataSource(DSCompanyReportIntegralDataSource.getInstance());
        manager.addMember(__form);
    }

    @Override
    public boolean checkData() {
        return true;
    }

    @Override
    public java.util.Map getValuesAsMap() {
        Map values = __form.getValues();
        return values;
    }

    public String getActionName() {
        // 需要根据实际业务修改
        return "ST_HolidayManage";
    }
    
}
