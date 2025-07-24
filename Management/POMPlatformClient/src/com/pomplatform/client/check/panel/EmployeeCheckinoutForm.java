package com.pomplatform.client.check.panel;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.moxieapps.gwt.highcharts.client.Chart;
import org.moxieapps.gwt.highcharts.client.Credits;
import org.moxieapps.gwt.highcharts.client.Legend;
import org.moxieapps.gwt.highcharts.client.Point;
import org.moxieapps.gwt.highcharts.client.Series;
import org.moxieapps.gwt.highcharts.client.ToolTip;
import org.moxieapps.gwt.highcharts.client.ToolTipData;
import org.moxieapps.gwt.highcharts.client.ToolTipFormatter;
import org.moxieapps.gwt.highcharts.client.labels.PieDataLabels;
import org.moxieapps.gwt.highcharts.client.plotOptions.ColumnPlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.PiePlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.PlotOptions;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.LoadingWindow;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.check.datasource.DSMemployeecheckinouteeseor;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.DateItemSelectorFormat;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.IPickTreeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class EmployeeCheckinoutForm extends AbstractWizadPage {
    private final Logger __logger = Logger.getLogger("");
    private final String layoutGroupStyle = "2px solid #555555;border-top-width:22px;border-radius:5px;";
	public final static String BORDER_STYLE = "2px solid #f2f2f2;border-radius:8px;";
    private DynamicForm dateForm;
    private DelicacyListGrid resultGrid;
    
    private DateItem startDateItem;
    private DateItem endDateItem;
    private SelectItem statusItem;
    private ComboBoxItem employeeIdItem;
    private IPickTreeItem departmentIdItem;
    
    private final IButton searchButton;
    private final IButton refreshButton;
    private final IButton exportButton;
    private final IButton analysisButton;
  
	private Chart chartOne;
	private Chart chartTwo;
	
	private HLayout totalLayout;
	private VLayout leftLayout;
	private VLayout rightLayout;
	private HLayout leftTopLayout;
	private HLayout leftContextLayout;
	private VLayout contextLeftLayout;
	private VLayout contextRightLayout;
	private HLayout chartoneLayout;
	private HLayout charttwoLayout;
	private HLayout lastUpdateTimeLayout;
	
    @SuppressWarnings("deprecation")
	public EmployeeCheckinoutForm() {
    	
    	totalLayout = new HLayout(10);
    	totalLayout.setWidth100();
    	totalLayout.setHeight100();
    	
    	leftLayout = new VLayout(10);
    	leftLayout.setHeight("98%");
    	leftLayout.setWidth("93%");
    	totalLayout.addMember(leftLayout);	
    	
    	leftTopLayout = new HLayout(10);
    	leftTopLayout.setHeight("5%");
    	leftTopLayout.setWidth100();
    	leftTopLayout.setBackgroundColor("#e2e2e2");
    	leftLayout.addMember(leftTopLayout);
    	
    	startDateItem = new DateItem("startDate", "开始日期");
		startDateItem.setWidth("*");
		startDateItem.setUseTextField(true);
		startDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
		startDateItem.setDefaultValue(new Date());
        
		endDateItem = new DateItem("endDate", "结束日期");
		endDateItem.setWidth("*");
		endDateItem.setUseTextField(true);
		endDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
		endDateItem.setDefaultValue(new Date());
        
        departmentIdItem = new IPickTreeItem("departmentId", "部门");
		departmentIdItem.setWidth("*");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));
		//控制，页面刚加载时，如果员工没有查看全部部门的权限，则只加载自己所在部门的人员考勤信息
		if (!ClientUtil.checkIsHavePermission(ERPPermissionStatic.CHECK_ALL_DEPARTMENT_CHECKINOUT)) {
			String departmentIds = ClientUtil.getRoleDepartmentId();
			String departmentId = ClientUtil.getDepartmentId() + "";
			final String[] ids = departmentIds.split(",");
			boolean status = false;
			if(BaseHelpUtils.isNullOrEmpty(departmentIds)){
				departmentIdItem.setDefaultValue(departmentId);
			}else{
				for (String str : ids) {
					if (str.equals(departmentId)) {
						status = true;
					}
				}
				if (status) {
					departmentIdItem.setDefaultValue(departmentId);
				} else {
					departmentIdItem.setDefaultValue(ids[0]);
				}
			}
			departmentIdItem.addChangeHandler(new ChangeHandler() {
				
				@Override
				public void onChange(ChangeEvent event) {
					if (null != event.getValue()) {
						String[] arr = event.getValue().toString().split("/");
						String value = arr[arr.length - 1];
						boolean status = false;
						for (String str : ids) {
							if (str.equals(value)) {
								status = true;
							}
						}
						if (!status) {
							SC.say("对不起，您没有查看这个部门数据的权限");
							event.cancel();
						}
					}						
				}
			});
		}
				
		employeeIdItem = new ComboBoxItem("employeeId", "员工姓名");
        employeeIdItem.setChangeOnKeypress(false);
        employeeIdItem.setWidth("*");
        employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
//        employeeIdItem.setValueMap(KeyValueManager.getValueMap("employee_list"));
		KeyValueManager.loadValueMap("employee_list",employeeIdItem);
		
		statusItem = new SelectItem("status", "考勤状态");
		statusItem.setWidth("*");
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_91"));
		
        dateForm = new DynamicForm();
        dateForm.setWidth("95%");
        dateForm.setHeight100();
        dateForm.setNumCols(10);
        dateForm.setMargin(10);
        dateForm.setItems(departmentIdItem,employeeIdItem,statusItem,startDateItem,endDateItem);
        leftTopLayout.addMember(dateForm);
    	
        leftContextLayout = new HLayout(10);
        leftContextLayout.setHeight("95%");
        leftContextLayout.setWidth100();
        leftLayout.addMember(leftContextLayout);
        
        contextLeftLayout = new VLayout(10);
        contextLeftLayout.setWidth("30%");
        contextLeftLayout.setHeight100();
        contextLeftLayout.setIsGroup(true);
	    contextLeftLayout.setGroupTitle("数据模型图");
	    contextLeftLayout.setOverflow(Overflow.HIDDEN);
	    contextLeftLayout.setGroupBorderCSS(layoutGroupStyle);
	    contextLeftLayout.setGroupLabelBackgroundColor("#555555");
	    contextLeftLayout.setGroupLabelStyleName("layoutGroupTitleStyle");
	    contextLeftLayout.setMembersMargin(10);
	    
	    
        lastUpdateTimeLayout = new HLayout(10);
        lastUpdateTimeLayout.setWidth100();
        lastUpdateTimeLayout.setHeight("2%");
        lastUpdateTimeLayout.setLayoutTopMargin(10);
        lastUpdateTimeLayout.setLayoutLeftMargin(10);
        contextLeftLayout.addMember(lastUpdateTimeLayout);
        
        chartoneLayout = new HLayout(10);
        chartoneLayout.setWidth("100%");
        chartoneLayout.setHeight("49%");
        
        charttwoLayout = new HLayout(10);
        charttwoLayout.setWidth("100%");
        charttwoLayout.setHeight("49%");
        
        chartOneSet();
        chartoneLayout.addMember(chartOne);
        contextLeftLayout.addMember(chartoneLayout);
        chartTwo = new Chart();
		chartTwoSet();
		charttwoLayout.addMember(chartTwo);
		contextLeftLayout.addMember(charttwoLayout);
		leftContextLayout.addMember(contextLeftLayout);
		
		contextRightLayout = new VLayout(10);
		contextRightLayout.setHeight100();
		contextRightLayout.setWidth("70%");
		contextRightLayout.setIsGroup(true);
		contextRightLayout.setGroupTitle("考勤数据");
		contextRightLayout.setGroupBorderCSS(layoutGroupStyle);
		contextRightLayout.setGroupLabelBackgroundColor("#555555");
		contextRightLayout.setGroupLabelStyleName("layoutGroupTitleStyle");
		leftContextLayout.addMember(contextRightLayout);
		
		resultGrid = new DelicacyListGrid();
        resultGrid.setShowRowNumbers(true);
         
        ListGridField departmentIdField = new ListGridField("departmentId", "部门");
        departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));
        ListGridField employeeNoField = new ListGridField("employeeNo", "编号");  
        ListGridField employeeNameField = new ListGridField("employeeId", "姓名");
        employeeNameField.setValueMap(KeyValueManager.getValueMap("employees"));
        ListGridField checkDateField = new ListGridField("recordDate", "日期");  
        ListGridField checkInField = new ListGridField("checkin", "签到时间");  
        ListGridField checkOutField = new ListGridField("checkout", "签退时间");  
        ListGridField statusField = new ListGridField("status", "考勤状态");
        statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_91"));
        ListGridField commentsField = new ListGridField("remark", "备注");  
         
        resultGrid.setFields(departmentIdField,employeeNoField,employeeNameField,checkDateField,checkInField,checkOutField,statusField,commentsField);
        resultGrid.setAutoFitFieldWidths(false);    	
        contextRightLayout.addMember(resultGrid);
        
    	searchButton = new IButton("搜索");
        refreshButton = new IButton("重置");
        exportButton = new IButton("导出");
        analysisButton = new IButton("考勤分析");
        
    	rightLayout = new VLayout();
    	rightLayout.setBackgroundColor("#e2e2e2");
    	rightLayout.setHeight100();
    	rightLayout.setWidth("7%");
    	rightLayout.setLayoutTopMargin(10);
    	rightLayout.setMembersMargin(10);
    	rightLayout.setLayoutLeftMargin(5);
    	rightLayout.setLayoutRightMargin(5);
    	
    	rightLayout.addMember(searchButton);
    	rightLayout.addMember(refreshButton);
    	rightLayout.addMember(exportButton);
    	rightLayout.addMember(analysisButton);
    	totalLayout.addMember(rightLayout);
    	
    	addMember(totalLayout);
    	
    	//搜索按钮
        searchButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				startEdit();
			}
		});
        
        //重置按钮
        refreshButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				dateForm.editNewRecord();
			}
		});
        
        //导出按钮
        exportButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Map<String,Object> params = dateForm.getValues();
				DBDataSource.downloadFile("DW_OnDownloadCheckinout", params);
			}
		});
        
        analysisButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				final PopupWindow popupWindow = new PopupWindow("考勤分析");
				popupWindow.setWidth("70%");
				popupWindow.setHeight("80%");
				popupWindow.centerInPage();
				OnAttendanceAnalysisPanel assignIntegral = new OnAttendanceAnalysisPanel();
				popupWindow.addItem(assignIntegral);
				popupWindow.addCloseClickHandler(new CloseClickHandler() {
					@Override
					public void onCloseClick(CloseClickEvent event) {
						popupWindow.destroy();
					}
				});
				popupWindow.addChild(assignIntegral);
				popupWindow.centerInPage();
				popupWindow.show();
			}
		});
        
    }
    
    public void loadData(){
    	Map<String,Object> params = new HashMap<>();
		params.put("departmentId", departmentIdItem.getValue());
		params.put("status", statusItem.getValue());
    	params.put("employeeId", employeeIdItem.getValue());
    	params.put("optType", "onLoadEmployeeCheckinout");
    	params.put("startDate", startDateItem.getValue());
    	params.put("endDate", endDateItem.getValue());
    	final LoadingWindow loading = new LoadingWindow();
		DBDataSource.callOperation("EP_EmployeeCheckinout", params, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				loading.destroy();
				if(dsResponse.getStatus() >= 0){
					resultGrid.setData(dsResponse.getData());
					resultGrid.redraw();
				}
			}
		});
    }
    
    
    //加载应出勤和实际出勤人数
    public void loadEmployeeShouldAndFactCheckNum(){
    	Map<String,Object> params = new HashMap<>();
    	params.put("departmentId", departmentIdItem.getValue());
    	params.put("startDate", startDateItem.getValue());
    	params.put("endDate", endDateItem.getValue());
    	params.put("optType", "EmployeeShouldAndFactCheckNum");
    	DBDataSource.callOperation("EP_EmployeeCheckinout", params, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					Record record = dsResponse.getData()[0];
					if(!BaseHelpUtils.isNullOrEmpty(record)){
						shouldCheckinPerson = BaseHelpUtils.getBigDecimalValue(record.getAttribute("shouldDays"));
						checkinPerson = BaseHelpUtils.getBigDecimalValue(record.getAttribute("factDays"));
						chartoneSetData();
					}
				}
				
			}
		});
    }
    
    //考勤状态柱状图
    public void loadEmployeeStatusCount(){
    	Map<String,Object> params = new HashMap<>();
    	params.put("departmentId", departmentIdItem.getValue());
    	params.put("startDate", startDateItem.getValue());
    	params.put("endDate", endDateItem.getValue());
    	params.put("optType", "EmployeeStatusCount");
    	DBDataSource.callOperation("EP_EmployeeCheckinout", params, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					Record[] records = dsResponse.getData();
					int len = records.length;
					// title字符串数组
					String[] titleArr = new String[len];
					Number[] personArr = new Number[len];
					if (!BaseHelpUtils.isNullOrEmpty(records) && records.length > 0) {
						int i = 0;
						for(Record e : records){
							int status = BaseHelpUtils.getIntValue(e.getAttribute("status"));
							String name = KeyValueManager.getValue("system_dictionary_91", status + "");
							e.setAttribute("name", name);
							titleArr[i] = name;
							int num = BaseHelpUtils.getIntValue(e.getAttribute("num"));
							personArr[i] = num;
							i++;
						}
					}
					chartTwo.removeAllSeries();
					// 设置X轴title显示
					chartTwo.getXAxis().setCategories(titleArr);
					// 设置X轴数据
					chartTwo.addSeries(chartTwo.createSeries().setName("人数").setPoints(personArr));
				}
				
			}
		});
    }
   
    //设置考勤率饼状图数据
    public void chartoneSetData(){
    	BigDecimal check = BigDecimal.ZERO;
    	if(shouldCheckinPerson.compareTo(BigDecimal.ZERO) != 0){
    		check = checkinPerson.divide(shouldCheckinPerson,2,BigDecimal.ROUND_DOWN);
    	}
		chartOne.removeAllSeries();
		chartOne.addSeries(chartOne.createSeries()  
	            .setName("Browser share")  
	            .setPoints(new Point[]{  
	                new Point("已出勤",check.multiply(BigDecimal.valueOf(100)))
	                .setColor("lightgreen"),  
	                new Point("未出勤", BigDecimal.ONE.subtract(check).multiply(BigDecimal.valueOf(100)))  
	                .setColor("red")
	            	})
				); 
    }
    
    public void chartOneSet() {
		chartOne = new Chart().setType(Series.Type.PIE)
		.setChartTitleText("出勤率分析")
		.setCredits(new Credits().setEnabled(false))//去除链接属性
		.setPlotBackgroundColor((String) null).setPlotBorderWidth(null).setPlotShadow(true)
		.setPiePlotOptions(new PiePlotOptions().setAllowPointSelect(true).setCursor(PlotOptions.Cursor.POINTER)
		.setPieDataLabels(new PieDataLabels().setEnabled(false)).setShowInLegend(true))
		.setToolTip(new ToolTip().setFormatter(new ToolTipFormatter() {
			public String format(ToolTipData toolTipData) {
				return "<b>" + toolTipData.getPointName() + "</b>: " + toolTipData.getYAsDouble() + " %";
			}
		}));
		chartOne.setWidth100();
		chartOne.setHeight100();
		chartOne.setBackgroundColor("#FFF");
		chartOne.setBorderColor("#e2e2e2");
	}

	public void chartTwoSet() {
		chartTwo.setType(Series.Type.COLUMN);
		chartTwo.setChartTitleText("考勤状态汇总").setChartSubtitleText("")
				.setCredits(new Credits().setEnabled(false))//去除链接属性
				.setColumnPlotOptions(new ColumnPlotOptions().setPointPadding(0.2).setBorderWidth(0))
				.setLegend(new Legend().setLayout(Legend.Layout.VERTICAL).setAlign(Legend.Align.LEFT)
						.setVerticalAlign(Legend.VerticalAlign.TOP).setX(100).setY(70).setFloating(true)
						.setBackgroundColor("#f2f2f2").setShadow(true))
				.setToolTip(new ToolTip().setFormatter(new ToolTipFormatter() {
					public String format(ToolTipData toolTipData) {
						return toolTipData.getXAsString() + "（" + toolTipData.getSeriesName() + "）: "
								+ toolTipData.getYAsDouble() + " 人";
					}
				}));
		// 设置Y轴显示
		chartTwo.getYAxis().setAxisTitleText("人数").setMin(0);
		chartTwo.setWidth100();
		chartTwo.setHeight100();
		chartTwo.setBackgroundColor("#FFF");
		chartTwo.setBorderColor("#e2e2e2");
	}
    
	//实际签到人数
	private BigDecimal checkinPerson = BigDecimal.ZERO;
	//应签到人数
	private BigDecimal shouldCheckinPerson = BigDecimal.ZERO;
	
	
    @Override
    public void startEdit() {
    	loadEmployeeShouldAndFactCheckNum();
    	loadEmployeeStatusCount();
    	loadData();
    }
    

    @Override
    public void setValueManage(ValuesManager manager) {
        manager.setDataSource(DSMemployeecheckinouteeseor.getInstance());
        manager.addMember(__form);
    }

    @Override
    public boolean checkData() {
        return true;
    }

    @Override
    public Map getValuesAsMap() {
        Map values = __form.getValues();
        return values;
    }

	public BigDecimal getCheckinPerson() {
		return checkinPerson;
	}

	public void setCheckinPerson(BigDecimal checkinPerson) {
		this.checkinPerson = checkinPerson;
	}

	public BigDecimal getShouldCheckinPerson() {
		return shouldCheckinPerson;
	}

	public void setShouldCheckinPerson(BigDecimal shouldCheckinPerson) {
		this.shouldCheckinPerson = shouldCheckinPerson;
	}

    
}
