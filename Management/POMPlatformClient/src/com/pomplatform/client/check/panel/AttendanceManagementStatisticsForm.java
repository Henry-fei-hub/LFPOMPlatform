package com.pomplatform.client.check.panel;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.moxieapps.gwt.highcharts.client.Chart;
import org.moxieapps.gwt.highcharts.client.Credits;
import org.moxieapps.gwt.highcharts.client.Legend;
import org.moxieapps.gwt.highcharts.client.Series;
import org.moxieapps.gwt.highcharts.client.ToolTip;
import org.moxieapps.gwt.highcharts.client.ToolTipData;
import org.moxieapps.gwt.highcharts.client.ToolTipFormatter;
import org.moxieapps.gwt.highcharts.client.plotOptions.ColumnPlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.ColumnRangePlotOptions;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.LoadingWindow;
import com.delicacy.client.ui.PopupWindow;
import com.delicacy.client.ui.ViewProcessWindow;
import com.delicacy.client.ui.WorkflowProcessor;
import com.delicacy.client.ui.Workflows;
import com.pomplatform.client.check.datasource.DSAttendanceManagementStatistics;
import com.pomplatform.client.shift.panel.ShiftmanageDetailPanel;
import com.pomplatform.client.workflow.personnel.panel.OnLoadAttentionListOfPersonnelPanel;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.DateItemSelectorFormat;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.IPickTreeItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class AttendanceManagementStatisticsForm extends AbstractWizadPage {
    private final Logger __logger = Logger.getLogger("");
    private final String layoutGroupStyle = "2px solid #555555;border-top-width:22px;border-radius:5px;";
	public final static String BORDER_STYLE = "2px solid #f2f2f2;border-radius:8px;";
    private DynamicForm dateForm;
    private DelicacyListGrid resultGrid;
    private DynamicForm detailForm;
    
    private DateItem searchDateItem;
    private TextItem employeeNoItem;
    private ComboBoxItem employeeIdItem;
    private IPickTreeItem departmentIdItem;
    
    private final IButton searchButton;
    private final IButton refreshButton;
  
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
	
	private TextItem totalPersonItem;
	private TextItem outPersonItem;
	private TextItem travelPersonItem;
	private TextItem leavePersonItem;
	private TextItem stationedPersonItem;
	private TextItem factPersonItem;
	
	private String __executeName;
	
	public AttendanceManagementStatisticsForm() {
    	
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
    	
        departmentIdItem = new IPickTreeItem("departmentId", "部门");
		departmentIdItem.setWidth("*");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));
        
		employeeIdItem = new ComboBoxItem("employeeId", "员工姓名");
        employeeIdItem.setChangeOnKeypress(false);
        employeeIdItem.setWidth("*");
        employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
        employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		
        employeeNoItem = new TextItem("employeeNo","员工编号");
        employeeNoItem.setWidth("*");
        
        searchDateItem = new DateItem("today","日期");
        searchDateItem.setWidth("*");
        searchDateItem.setUseTextField(true);
        searchDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
        searchDateItem.setDefaultValue(new Date());
		
        dateForm = new DynamicForm();
        dateForm.setWidth("95%");
        dateForm.setHeight100();
        dateForm.setNumCols(8);
        dateForm.setMargin(10);
        dateForm.setItems(departmentIdItem,employeeIdItem,employeeNoItem,searchDateItem);
        leftTopLayout.addMember(dateForm);
    	
        leftContextLayout = new HLayout(10);
        leftContextLayout.setHeight100();
        leftContextLayout.setWidth100();
        leftLayout.addMember(leftContextLayout);
        
        contextLeftLayout = new VLayout(10);
        contextLeftLayout.setWidth("30%");
        contextLeftLayout.setHeight100();
	    contextLeftLayout.setMembersMargin(30);
	    
        chartoneLayout = new HLayout(10);
        chartoneLayout.setWidth("100%");
        chartoneLayout.setHeight("40%");
        
        charttwoLayout = new HLayout(10);
        charttwoLayout.setWidth("100%");
        charttwoLayout.setHeight("60%");
        
        totalPersonItem = new TextItem("totalPerson","总人数");
        totalPersonItem.setWidth("*");
        totalPersonItem.setTextBoxStyle("customInputTextStyle");
        totalPersonItem.setCellHeight(50);
        
        outPersonItem = new TextItem("outPerson","已外出人数");
        outPersonItem.setWidth("*");
        outPersonItem.setTextBoxStyle("customInputTextStyle");
        outPersonItem.setCellHeight(50);
        
    	travelPersonItem = new TextItem("travelPerson","已出差人数");
    	travelPersonItem.setWidth("*");
    	travelPersonItem.setTextBoxStyle("customInputTextStyle");
    	travelPersonItem.setCellHeight(50);
    	 
    	leavePersonItem = new TextItem("leavePerson","已请假人数");
    	leavePersonItem.setWidth("*");
    	leavePersonItem.setTextBoxStyle("customInputTextStyle");
    	leavePersonItem.setCellHeight(50);
    	 
    	stationedPersonItem = new TextItem("stationedPerson","已派驻人数");
    	stationedPersonItem.setWidth("*");
    	stationedPersonItem.setTextBoxStyle("customInputTextStyle");
    	stationedPersonItem.setCellHeight(50);
    	
    	factPersonItem = new TextItem("factPerson","到勤人数");
    	factPersonItem.setWidth("*");
    	factPersonItem.setTextBoxStyle("customInputTextStyle");
    	factPersonItem.setCellHeight(50);
    	 
    	detailForm = new DynamicForm();
    	detailForm.setWidth("95%");
    	detailForm.setHeight100();
    	detailForm.setNumCols(2);
    	detailForm.setCanEdit(false);
    	detailForm.setItems(totalPersonItem,outPersonItem,travelPersonItem,leavePersonItem,stationedPersonItem,factPersonItem);
    	
        chartoneLayout.addMember(detailForm);
        chartoneLayout.setIsGroup(true);
        chartoneLayout.setGroupTitle("人数统计");
        chartoneLayout.setGroupBorderCSS(layoutGroupStyle);
        chartoneLayout.setGroupLabelBackgroundColor("#555555");
        chartoneLayout.setGroupLabelStyleName("layoutGroupTitleStyle");
        contextLeftLayout.addMember(chartoneLayout);
        
        chartTwo = new Chart();
		chartTwoSet();
		charttwoLayout.addMember(chartTwo);
		charttwoLayout.setIsGroup(true);
		charttwoLayout.setGroupTitle("数据模型图");
		charttwoLayout.setGroupBorderCSS(layoutGroupStyle);
		charttwoLayout.setGroupLabelBackgroundColor("#555555");
		charttwoLayout.setGroupLabelStyleName("layoutGroupTitleStyle");
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
        resultGrid.setShowRowNumbers(false);
         
        ListGridField departmentIdField = new ListGridField("departmentId", "部门");
        departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));
        ListGridField employeeNoField = new ListGridField("employeeNo", "编号");  
        ListGridField employeeNameField = new ListGridField("employeeId", "姓名");
        employeeNameField.setValueMap(KeyValueManager.getValueMap("employees"));
        ListGridField createTimeField = new ListGridField("createTime", "申请时间");  
        ListGridField processTypeField = new ListGridField("processType", "类型");  
        processTypeField.setValueMap(KeyValueManager.getValueMap("system_process_types"));
        
        resultGrid.setFields(departmentIdField,employeeNoField,employeeNameField,createTimeField,processTypeField);
        resultGrid.setAutoFitFieldWidths(false);    	
        contextRightLayout.addMember(resultGrid);
        
        resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				if (!resultGrid.anySelected()) {
                    SC.say("please select a record to edit");
                    return;
                }
				Record selected = resultGrid.getSelectedRecord();
				ViewProcessWindow popupWindow = new ViewProcessWindow();
				popupWindow.setWidth("80%");
				popupWindow.setHeight("80%");
				String businessId = selected.getAttribute("personnelBusinessId");
				String sprocessType = selected.getAttribute("processType");
				Map<String,Object> params = new HashMap<>();
				params.put("businessId", businessId);
				params.put("processType", sprocessType);
				
				DBDataSource.callOperation("NQ_GetPersonnelProcessId", params, new DSCallback() {
					
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0){
							Record record = dsResponse.getData()[0];
							
							Record __instanceData = new Record();
							__instanceData.setAttribute("processId", record.getAttribute("processId"));
							__instanceData.setAttribute("processType", sprocessType);
							__instanceData.setAttribute("processInstanceId", record.getAttribute("processInstanceId"));
							popupWindow.setInstanceData(__instanceData);
							popupWindow.initComponents();
							popupWindow.setTitle(ClientUtil.getProcessTypeName(selected));
							popupWindow.centerInPage();
							popupWindow.show();
						}
					}
				});
			}
		});
        
    	searchButton = new IButton("搜索");
        refreshButton = new IButton("重置");
        
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
        
        
    }
    
    public void loadData(){
    	Map<String,Object> params = new HashMap<>();
		params.put("departmentId", departmentIdItem.getValue());
    	params.put("employeeId", employeeIdItem.getValue());
    	params.put("employeeNo", employeeNoItem.getValue());
    	params.put("today", searchDateItem.getValue());
    	final LoadingWindow loading = new LoadingWindow();
		DBDataSource.callOperation("NQ_AttendanceManagementStatistics", params, new DSCallback(){
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
    
    
    //加载总人数和应出勤人数
    public void loadEmployeeAllNum(){
    	Map<String,Object> params = new HashMap<>();
    	if(!BaseHelpUtils.isNullOrEmpty(departmentIdItem.getValue())){
    		params.put("departmentId", departmentIdItem.getValue());
    	}
    	DBDataSource.callOperation("NQ_AttendanceManagementPersonNum", params, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					Record record = dsResponse.getData()[0];
					if(!BaseHelpUtils.isNullOrEmpty(record)){
						totalPersonItem.setValue(record.getAttribute("all"));
					}
				}
				
			}
		});
    }
    
    public void loadEmployeeFactDay(){
    	Map<String,Object> params = new HashMap<>();
    	if(!BaseHelpUtils.isNullOrEmpty(departmentIdItem.getValue())){
    		params.put("departmentId", departmentIdItem.getValue());
    	}
    	params.put("startDate",searchDateItem.getValue());
    	DBDataSource.callOperation("NQ_EmployeeShouldAndFactCheck", params, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					Record record = dsResponse.getData()[0];
					if(!BaseHelpUtils.isNullOrEmpty(record)){
						factPersonItem.setValue(record.getAttribute("factDays"));
					}
				}
				
			}
		});
    }
    
    //考勤状态柱状图
    public void loadEmployeeStatusCount(){
    	Map<String,Object> params = new HashMap<>();
    	if(!BaseHelpUtils.isNullOrEmpty(departmentIdItem.getValue())){
    		params.put("departmentId", departmentIdItem.getValue());
    	}
    	params.put("today", searchDateItem.getValue());
    	DBDataSource.callOperation("NQ_AttendanceManagementStatisticsStatus", params, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					Record[] records = dsResponse.getData();
					String titleArr[] = {"外出","出差","请假","派驻"};
					Number[] personArr = new Number[]{0,0,0,0};
					if (!BaseHelpUtils.isNullOrEmpty(records) && records.length > 0) {
						int travelPersonNum = 0,stationedPersonNum = 0,leavePersonNum = 0,outPersonNum = 0;
						int travelPersonDoneNum = 0,stationedPersonDoneNum = 0,leavePersonDoneNum = 0,outPersonDoneNum = 0;
						for(Record e : records){
							int status = BaseHelpUtils.getIntValue(e.getAttribute("processType"));
							int num = BaseHelpUtils.getIntValue(e.getAttribute("typeNum"));
							boolean isCompleted = BaseHelpUtils.getBoolean(e.getAttribute("isCompleted"));
							if(status == 16){//外出
								if(isCompleted){//是否审批通过
									outPersonDoneNum += num;
								}else{
									outPersonNum += num;
								}
							}else if(status == 14 || status == 18 || status == 19){//出差(非项目出差申请，项目出差申请，出差延期申请)
								if(isCompleted){
									travelPersonDoneNum += num;
								}else{
									travelPersonNum += num;
								}
							}else if(status == 13){//请假
								if(isCompleted){
									leavePersonDoneNum += num;
								}else{
									leavePersonNum += num;
								}
							}else if(status == 21 || status == 22){//派驻(项目派驻申请,项目派驻延期申请)
								if(isCompleted){
									stationedPersonDoneNum += num;
								}else{
									stationedPersonNum += num;
								}
							}
						}
						personArr = new Number[]{outPersonNum,travelPersonNum,leavePersonNum,stationedPersonNum};
						
						outPersonItem.setValue(outPersonDoneNum);
						travelPersonItem.setValue(travelPersonDoneNum);
						leavePersonItem.setValue(leavePersonDoneNum);
						stationedPersonItem.setValue(stationedPersonDoneNum);
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
    
	public void chartTwoSet() {
		chartTwo.setType(Series.Type.COLUMN);
		chartTwo.setChartTitleText("预计考勤统计").setChartSubtitleText("")
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
	
    @Override
    public void startEdit() {
    	loadEmployeeAllNum();
    	loadEmployeeFactDay();
    	loadEmployeeStatusCount();
    	loadData();
    }
    

    @Override
    public void setValueManage(ValuesManager manager) {
        manager.setDataSource(DSAttendanceManagementStatistics.getInstance());
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

}
