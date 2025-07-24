package com.pomplatform.client.shift.form;

import java.util.*;

import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.GenericViewWindow;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.pomplatform.client.shift.datasource.DSSEmployeeDayCheck;
import com.pomplatform.client.shift.panel.MyAttendanceDetailPanel;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

import java.util.logging.Logger;

import org.moxieapps.gwt.highcharts.client.Chart;
import org.moxieapps.gwt.highcharts.client.Credits;
import org.moxieapps.gwt.highcharts.client.Legend;
import org.moxieapps.gwt.highcharts.client.Series;

public class MyAttendanceDesign extends AbstractWizadPage {

    private final Logger __logger = Logger.getLogger("");
    private DynamicForm SearchForm;
    private DelicacyListGrid grid;
    
    private VLayout allLayout;
    private HLayout searchLayout;
    private HLayout contentLayout;
    private HLayout searchLeftLayout;
    private HLayout searchRightLayout;
    private HLayout gridLayout;
    private VLayout basicLayout;
    private VLayout basicTopLayout;
    private VLayout basicChartLayout;

    private final TextItem employeeNoItem;
    private final TextItem departmentItem;
    private final TextItem employeeIdItem;
    private final TextItem employeeStatusItem;
    
    private final TextItem checkinItem;
    private final TextItem checkoutItem;
    private final TextItem statusItem;
    
    private final SelectItem yearItem;
    private final SelectItem monthItem;
    
    private Chart chart;
    
    public MyAttendanceDesign() {
        __form.setGroupTitle("今日考勤");
        __form.setIsGroup(true);
        __form.setHeight100();
        allLayout = new VLayout(10);
        
        searchLayout = new HLayout(10);
        searchLayout.setHeight("5%");
        searchLayout.setWidth100();
        searchLayout.setBackgroundColor("#e2e2e2");
        
        searchLeftLayout = new HLayout(10);
        searchLeftLayout.setHeight100();
        searchLeftLayout.setWidth("50%");
        
        Date date = new Date();
		DateTimeFormat yearDf = DateTimeFormat.getFormat("yyyy");
		int year = BaseHelpUtils.getIntValue(yearDf.format(date));
		DateTimeFormat monthDf = DateTimeFormat.getFormat("MM");
		int month = BaseHelpUtils.getIntValue(monthDf.format(date));
        
        yearItem = new SelectItem("year","年份");
        yearItem.setWidth("*");
        yearItem.setDefaultValue(year);
		yearItem.setDisabled(true);
        yearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
        
        monthItem = new SelectItem("month","月份");
        monthItem.setWidth("*");
		monthItem.setValue(month);
		monthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));
		
        SearchForm = new DynamicForm();
        SearchForm.setHeight100();
        SearchForm.setWidth100();
        SearchForm.setNumCols(4);
        SearchForm.setMargin(10);
        SearchForm.setItems(yearItem,monthItem);
        searchLeftLayout.addMember(SearchForm);
        searchLayout.addMember(searchLeftLayout);
        
        searchRightLayout = new HLayout(10);
        searchRightLayout.setHeight100();
        searchRightLayout.setWidth("50%");
        
        IButton searchButton = new IButton("搜索");
        searchButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				startEdit();
			}
		});
        searchRightLayout.setLayoutTopMargin(12);
        searchRightLayout.addMember(searchButton);
        
        IButton lockButton = new IButton("确认考勤");
        lockButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				SC.confirm("已确认考勤数据无误？", new BooleanCallback() {
					
					@Override
					public void execute(Boolean value) {
						if(value){
							Map<String,Object> map = new HashMap<>();
							int year = BaseHelpUtils.getIntValue(SearchForm.getItem("year").getValue());
							int month = BaseHelpUtils.getIntValue(SearchForm.getItem("month").getValue());
							map.put("year", year);
							map.put("month", month);
							map.put("employeeId", ClientUtil.getEmployeeId());
							map.put("optType", "lockSingleCheckData");
							DBDataSource.callOperation("EP_OnShiftManageProcess", map, new DSCallback() {
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									SC.say("考勤确认成功");
									startEdit();
								}
							});
						}
					}
				});
			}
		});
        searchRightLayout.addMember(lockButton);
        searchLayout.addMember(searchRightLayout);
        
        employeeNoItem = new TextItem("employeeNo","员工编号");
        employeeNoItem.setWidth("*");
        employeeNoItem.setCellHeight(40);
        
        departmentItem = new TextItem("departmentId","归属部门");
        departmentItem.setWidth("*");
        departmentItem.setCellHeight(40);
        departmentItem.setValueMap(KeyValueManager.getValueMap("departments"));
        
        employeeIdItem = new TextItem("employeeId","员工姓名");
        employeeIdItem.setWidth("*");
        employeeIdItem.setCellHeight(40);
        employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
        
        employeeStatusItem = new TextItem("employeeStatus","员工状态");
        employeeStatusItem.setWidth("*");
        employeeStatusItem.setCellHeight(40);
        employeeStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_11"));
        
        checkinItem = new TextItem("checkin","今日上班时间");
        checkinItem.setWidth("*");
        checkinItem.setCellHeight(50);
        checkinItem.setTextBoxStyle("customInputTextStyle");
        checkinItem.setFormat("HH:mm:ss");
        
        checkoutItem = new TextItem("checkout","今日下班时间");
        checkoutItem.setWidth("*");
        checkoutItem.setCellHeight(50);
        checkoutItem.setTextBoxStyle("customInputTextStyle");
        
        statusItem = new TextItem("status","考勤状态");
        statusItem.setWidth("*");
        statusItem.setCellHeight(50);
        statusItem.setTextBoxStyle("customInputTextStyle");
        statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_91"));
        
        __form.setNumCols(4);
        __form.setCanEdit(false);
        checkinItem.setColSpan(4);
        checkoutItem.setColSpan(4);
        statusItem.setColSpan(4);
        __form.setItems(employeeNoItem,departmentItem,employeeIdItem,employeeStatusItem,checkinItem,checkoutItem);
        
        contentLayout = new HLayout(10);
        contentLayout.setWidth100();
        contentLayout.setHeight("98%");
        
        basicLayout = new VLayout(10);
        basicLayout.setHeight100();
        basicLayout.setWidth("30%");
        contentLayout.addMember(basicLayout);
        
        basicTopLayout = new VLayout(10);
        basicTopLayout.setHeight("35%");
        basicTopLayout.addMember(__form);
        basicLayout.addMember(basicTopLayout);
        
        basicChartLayout = new VLayout(10);
        basicChartLayout.setHeight("65%");
        basicChartLayout.setWidth100();
        
        chartSet();
        basicChartLayout.addMember(chart);
        basicLayout.addMember(basicChartLayout);
        
        
        grid = new DelicacyListGrid();
        int index = 0;
        ListGridField [] fields = new ListGridField[17];
		fields[index] = new ListGridField("recordDate", "考勤日期");
		fields[index].setShowGridSummary(false);
		index++;
		fields[index] = new ListGridField("shiftManageId", "班次");
		fields[index].setShowGridSummary(false);
//		fields[index].setValueMap(KeyValueManager.getValueMap("shift_manages"));
		KeyValueManager.loadValueMap("shift_manages",fields[index]);
		fields[index].setShowGridSummary(false);
		index++;
		fields[index] = new ListGridField("checkin", "上班");
		fields[index].setFormat("HH:mm:ss");
		fields[index].setWidth(70);
		fields[index].setShowGridSummary(false);
		fields[index].setEmptyCellValue("");
		index++;
		fields[index] = new ListGridField("checkout", "下班");
		fields[index].setFormat("HH:mm:ss");
		fields[index].setEmptyCellValue("");
		fields[index].setShowGridSummary(false);
		fields[index].setWidth(70);
		index++;
		fields[index] = new ListGridField("status", "考勤状态");

		fields[index] = new ListGridField("numberOfLate", "迟到次数");
		index++;

		fields[index] = new ListGridField("lateForMinutes", "迟到分钟");
		index++;

		fields[index] = new ListGridField("numberOfLeave", "早退次数");
		index++;

		fields[index] = new ListGridField("LeaveForMinutes", "早退分钟");
		index++;

		fields[index] = new ListGridField("lateCharge", "迟到扣款");
		index++;

		index++;
		fields[index] = new ListGridField("thingLeaveDay", "事假天数");
		index++;
		fields[index] = new ListGridField("thingLeavehours", "事假小时");
		index++;
		fields[index] = new ListGridField("illLeaveDays", "病假天数");
		index++;

		fields[index] = new ListGridField("otherLeaveDays", "其他假类天数");
		index++;
//		fields[index] = new ListGridField("nornalOvertimeHours", "平时加班小时");
//		index++;
		fields[index] = new ListGridField("absenceDays", "旷工天数");
		index++;
		fields[index] = new ListGridField("shouldDays", "应到天数");
		index++;
		fields[index] = new ListGridField("factDays", "实到天数");

		fields[index].setShowGridSummary(false);
//		index++;
//		fields[index] = new ListGridField("remark", "备注");
//		fields[index].setShowGridSummary(false);
        
        grid.setShowRowNumbers(false);
        grid.setEmptyCellValue("0");
        grid.setShowGridSummary(true);
        grid.setFields(fields);
        grid.setDataSource(DSSEmployeeDayCheck.getInstance());
        grid.setAutoFitFieldWidths(true);
        
        gridLayout = new HLayout(10);
        gridLayout.setHeight100();
        gridLayout.setWidth("70%");
        gridLayout.addMember(grid);
        contentLayout.addMember(gridLayout);

        grid.addDoubleClickHandler(new DoubleClickHandler() {
			
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				ListGridRecord selected = grid.getSelectedRecord();
				Map<String,Object> map = new HashMap<>();
				int employeeId = BaseHelpUtils.getIntValue(ClientUtil.getUserId());
				map.put("employeeId", employeeId);
				map.put("checkDate", selected.getAttributeAsDate("recordDate"));
				GenericViewWindow detail = new GenericViewWindow();
            	detail.setTitle("打卡明细");
            	detail.setWidth("60%");
            	detail.setHeight("60%");
            	MyAttendanceDetailPanel detailForm = new MyAttendanceDetailPanel();
            	detailForm.initComponents();
            	detailForm.loadGridData(map);
            	detail.setContent(detailForm);
            	detail.centerInPage();
            	detail.show();
				
			}
		});
        
        
        allLayout.addMember(searchLayout);
        allLayout.addMember(contentLayout);
        addMember(allLayout);
    }

    @Override
    public void startEdit() {
    	//加载grid数据
    	int year = ClientUtil.checkAndGetIntValue(yearItem.getValue());
		int month = ClientUtil.checkAndGetIntValue(monthItem.getValue());
		int employeeId = BaseHelpUtils.getIntValue(ClientUtil.getEmployeeId());
		Map<String,Object> params = new HashMap<>();
		params.put("employeeId", employeeId);
		params.put("year", year);
		params.put("month", month);
		params.put("optType", "onEmployeeDayChecks");
		DBDataSource.callOperation("EP_OnShiftManageProcess", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					Record[] record = dsResponse.getData();
					if(!BaseHelpUtils.isNullOrEmpty(record)){
						for(Record e : record){
							if(e.getAttributeAsBoolean("isLocked") == Boolean.TRUE){
								e.setAttribute("enabled", false);
							}
						}
						grid.setData(record);
						params.put("recordDate", new Date());
						loadChartData(params);
					}
				}
			}
		});
    }
    
   
    //加载月考勤汇总饼状图数据
	private void loadChartData(Map<String, Object> params) {
		DBDataSource.callOperation("NQ_OnLoadEmployeeMonthCheck", "find",params, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					Record record = dsResponse.getData()[0];
					int len = 3;
					// title字符串数组
					String[] titleArr = {"实到天数","应到天数","旷工天数"};
					Double[] dayArr = new Double[len];
					if (!BaseHelpUtils.isNullOrEmpty(record)) {
						dayArr[0] = BaseHelpUtils.isNullOrEmpty(record.getAttributeAsDouble("factDays")) ? 0 : record.getAttributeAsDouble("factDays");
						dayArr[1] = BaseHelpUtils.isNullOrEmpty(record.getAttributeAsDouble("shouldDays")) ? 0 : record.getAttributeAsDouble("shouldDays");
						dayArr[2] = BaseHelpUtils.isNullOrEmpty(record.getAttributeAsDouble("absenceDays")) ? 0 : record.getAttributeAsDouble("absenceDays");
						
						employeeNoItem.setValue(record.getAttribute("employeeNo"));
						departmentItem.setValue(record.getAttribute("departmentId"));
						employeeIdItem.setValue(record.getAttribute("employeeId"));
						employeeStatusItem.setValue(record.getAttribute("status"));
					}
					chart.removeAllSeries();
					// 设置X轴title显示
					chart.getXAxis().setCategories(titleArr);
					// 设置X轴数据
					chart.addSeries(chart.createSeries().setName("天数").setPoints(dayArr));
				}
				
			}
		});		
	}

	 public void loadCheckTime() {
	    	//加载上下班时间数据
			int employeeId = BaseHelpUtils.getIntValue(ClientUtil.getUserId());
			Map<String,Object> params = new HashMap<>();
			params.put("employeeId", employeeId);
		 	params.put("optType", "onLoadEmployeeDayCheck");
		  	DBDataSource.callOperation("EP_OnShiftManageProcess", params, new DSCallback() {
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					if(dsResponse.getStatus() >= 0){
						Record record = dsResponse.getData()[0];
						DateTimeFormat tf = DateTimeFormat.getFormat("HH:mm:ss");
						Date checkin = record.getAttributeAsDate("checkin");
						Date checkout = record.getAttributeAsDate("checkout");
						if(!BaseHelpUtils.isNullOrEmpty(checkin)){
							checkinItem.setValue(tf.format(checkin));
						}
						if(!BaseHelpUtils.isNullOrEmpty(checkout)){
							checkoutItem.setValue(tf.format(checkout));
						}
						statusItem.setValue(record.getAttribute("status"));
					}
				}
			});
	    }
    
    public void chartSet() {
		chart = new Chart().setType(Series.Type.BAR)
		.setChartTitleText("月考勤汇总")
		.setCredits(new Credits().setEnabled(false))//去除链接属性
		.setLegend(new Legend()  
                .setLayout(Legend.Layout.VERTICAL)  
                .setAlign(Legend.Align.RIGHT)  
                .setVerticalAlign(Legend.VerticalAlign.TOP)  
                .setX(-100)  
                .setY(100)  
                .setFloating(true)  
                .setBorderWidth(1)  
                .setBackgroundColor("#FFFFFF")  
                .setShadow(true) 
            )  
            .setCredits(new Credits()  
                .setEnabled(false)  
            );  
	     
		chart.setWidth100();
		chart.setHeight100();
		chart.setBackgroundColor("#FFF");
		chart.setBorderColor("#e2e2e2");
	}

    @Override
    public void setValueManage(ValuesManager manager) {
        manager.setDataSource(DSSEmployeeDayCheck.getInstance());
        manager.addMember(__form);
    }

    @Override
    public boolean checkData() {
        return true;
    }

    @Override
    public java.util.Map getValuesAsMap() {
        return null;
    }


}
