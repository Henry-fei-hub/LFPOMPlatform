package com.pomplatform.client.account.panel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.moxieapps.gwt.highcharts.client.Chart;
import org.moxieapps.gwt.highcharts.client.Credits;
import org.moxieapps.gwt.highcharts.client.Point;
import org.moxieapps.gwt.highcharts.client.Series;
import org.moxieapps.gwt.highcharts.client.ToolTip;
import org.moxieapps.gwt.highcharts.client.ToolTipData;
import org.moxieapps.gwt.highcharts.client.ToolTipFormatter;
import org.moxieapps.gwt.highcharts.client.labels.DataLabels;
import org.moxieapps.gwt.highcharts.client.labels.PieDataLabels;
import org.moxieapps.gwt.highcharts.client.plotOptions.LinePlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.PiePlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.PlotOptions;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.event.shared.HasHandlers;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.pomplatform.client.account.datasource.DSEmpAccountMonthReportSource;
import com.pomplatform.client.account.datasource.DSEmployeeAccountSource;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class EmployeeAccountDesignPanel extends HLayout implements HasHandlers {
	private static Logger __logger = Logger.getLogger("");
	// 定义面板样式
	private final String layoutGroupStyle = "2px solid #555555;border-top-width:22px;border-radius:5px;";
	public final static String BORDER_STYLE = "2px solid #f2f2f2;border-radius:8px;";
	//**************************定义个人账户的业务功能类型*************     此数据严禁修改               此数据严禁删除                 
	public static final int EMP_BT_SURE_INTEGRAL = 1;//确认积分(收入)
    public static final int EMP_BT_BONUS_SUBSIDY = 2;//奖金补贴(收入)
    public static final int EMP_BT_INTEGRAL_ADVANCE = 3;//积分借款(收入)
    public static final int EMP_BT_PROJECT_SUBSIDY = 4;//项目补贴(收入)
    public static final int EMP_BT_SALAEY_REFUND = 5;//积分还款(支出)
    public static final int EMP_BT_EMPLOYEE_COST = 6;//人工成本(支出)
    public static final int EMP_BT_PROJECT_COST = 7;//项目成本(支出)
    public static final int EMP_BT_BONUS_SEND = 8;//奖金发放(支出)
    public static final int EMP_BT_INTEGRAL_RECYCLE = 9;//积分回收(支出)
    public static final int EMP_BT_PERFORMANCE_BONUS = 10;//绩效奖金(收入)
    public static final int EMP_BT_VIOLATION_CHARGES = 11;//资源绩效(支出)
    public static final int EMP_BT_ATTENDANCE_DEDUCT = 12;//考勤扣款(支出)
    public static final int EMP_BT_PM_PERFORMANCE_AWARD = 13;//项目经理绩效奖励(收入)
    public static final int EMP_BT_PM_PERFORMANCE_DEDUCT = 14;//项目经理绩效扣除(支出)
    public static final int EMP_BT_PROJECT_PERFORMANCE = 15;//项目绩效(收入)
    public static final int EMP_BT_CONTRACT_CHANGE = 16;//合同变更(支出)
    public static final int EMP_BT_PLATE_CHANGE_ACHIEVE = 17;//转岗结算收入(收入)
    public static final int EMP_BT_PLATE_CHANGE_PAY = 18;//转岗结算支出(支出)
    public static final int EMP_BT_PROJECT_PERFORMANCE_PAY = 19;//项目绩效支出(支出)
    public static final int EMP_BT_CONTRACT_DISTRIBUTION_INCOME = 20;//提成收入
    public static final int EMP_BT_CONTRACT_DISTRIBUTION_EXPENDITURE = 21;//提成支出
	// 定义整个面板的layout,整个面板分头部面板和中心面板
	private VLayout mainLayout;
	// 定义头部面板，包括左右两个面板
	private HLayout topHLayout;
	private HLayout topLeftHLayout;
    private VLayout topRightHLayout;
    private DynamicForm dateForm;
	// 定义中心面板，包括左、中、右三个主面板
	private HLayout centerLayout;
	// 定义中心面板的左面板，包括上、下连个面板
	private VLayout centerLeftLayout;
	// 定义中心面板的中面板，包括上、下连个面板
	private VLayout centerMiddleLayout;
	// 定义中心面板的右面板
	private VLayout centerRightLayout;
	private HLayout chartOneLayout;
	private HLayout chartTwoLayout;
	private Chart chartOne;
	private Chart chartTwo;
	private IButton calculateButton;
	private DateItem startDateItem;
	private DateItem endDateItem;
	private DelicacyListGrid achieveGrid;
	private DelicacyListGrid payGrid;
	private HLayout middleTopLayout;
	private HLayout middleBottomLayout;
	private DelicacyListGrid monthReportGrid;

	public void initComponents() {
		mainLayout = new VLayout();
		mainLayout.setBackgroundColor("#FFF");
		mainLayout.setBorder("2px solid #e2e2e2;border-radius:5px");
		mainLayout.setWidth100();
		mainLayout.setHeight100();

		topHLayout = new HLayout();
		topHLayout.setWidth100();
		topHLayout.setHeight("5%");
		topHLayout.setBackgroundColor("#e2e2e2");

		topLeftHLayout = new HLayout();
        topLeftHLayout.setWidth("25%");
        
        startDateItem = new DateItem("startDate", "开始日期");
        startDateItem.setDefaultValue(startDate);
        startDateItem.setWidth("*");
//        startDateItem.setShowIcons(false);
        startDateItem.setUseTextField(true);  
        
        endDateItem = new DateItem("endDate", "结束日期");
        endDateItem.setDefaultValue(endDate);
        endDateItem.setWidth("*");
//        endDateItem.setShowIcons(false);
        endDateItem.setUseTextField(true);  
        
        dateForm = new DynamicForm();
        dateForm.setWidth("70%");
        dateForm.setHeight100();
        dateForm.setNumCols(5);
        dateForm.setMargin(10);
        dateForm.setItems(startDateItem,endDateItem);
        
        calculateButton = new IButton("账户统计");
        
        topRightHLayout = new VLayout();
        topRightHLayout.setBackgroundColor("#e2e2e2");
        topRightHLayout.setHeight100();
        topRightHLayout.setWidth("5%");
        topRightHLayout.setLayoutTopMargin(10);
        topRightHLayout.setLayoutLeftMargin(5);
        topRightHLayout.setLayoutRightMargin(5);
        topRightHLayout.setMembersMargin(10);
        
        topRightHLayout.addMember(calculateButton);
        
        topHLayout = new HLayout();
        topHLayout.setWidth100();
        topHLayout.setHeight("5%");
        topHLayout.setBackgroundColor("#e2e2e2");
        topHLayout.addMember(topLeftHLayout);
        topHLayout.addMember(dateForm);
        topHLayout.addMember(topRightHLayout);

		mainLayout.addMember(topHLayout);

		centerLayout = new HLayout(10);
		centerLayout.setHeight("95%");
		centerLayout.setWidth100();
		centerLayout.setMembersMargin(10);
		mainLayout.addMember(centerLayout);

		centerLeftLayout = new VLayout(20);
		centerLeftLayout.setIsGroup(true);
		centerLeftLayout.setGroupBorderCSS(layoutGroupStyle);
		centerLeftLayout.setGroupLabelBackgroundColor("#555555");
		centerLeftLayout.setGroupTitle("数据模型图");
		centerLeftLayout.setGroupLabelStyleName("layoutGroupTitleStyle");
		centerLeftLayout.setHeight100();
		centerLeftLayout.setWidth("25%");
		centerLeftLayout.setMembersMargin(20);

		centerLayout.addMember(centerLeftLayout);

		chartOneLayout = new HLayout();
		chartOneLayout.setWidth100();
		chartOneLayout.setHeight("50%");

		centerLeftLayout.addMember(chartOneLayout);

		chartTwoLayout = new HLayout();
		chartTwoLayout.setWidth100();
		chartTwoLayout.setHeight("50%");

		centerLeftLayout.addMember(chartTwoLayout);

		centerMiddleLayout = new VLayout();
		centerMiddleLayout.setHeight("98%");
		centerMiddleLayout.setWidth("25%");
		centerMiddleLayout.setMembersMargin(10);
		centerLayout.addMember(centerMiddleLayout);

		middleTopLayout = new HLayout();
		middleTopLayout.setWidth100();
		middleTopLayout.setHeight("50%");
		middleTopLayout.setIsGroup(true);
		middleTopLayout.setGroupBorderCSS(layoutGroupStyle);
		middleTopLayout.setGroupLabelBackgroundColor("#555555");
		middleTopLayout.setGroupTitle("收入栏");
		middleTopLayout.setGroupLabelStyleName("layoutGroupTitleStyle");
		centerMiddleLayout.addMember(middleTopLayout);
		
		achieveGrid = new DelicacyListGrid();
		achieveGrid.setAutoFitFieldWidths(false);
		achieveGrid.setDataSource(DSEmployeeAccountSource.getInstance());
		achieveGrid.setShowGridSummary(true);
		ListGridField[] achieveFields = new ListGridField[2];
		int achieveIdx = 0;
		achieveFields[achieveIdx] = new ListGridField("businessTypeId");
		achieveFields[achieveIdx].setShowGridSummary(false);
		achieveIdx++;
		achieveFields[achieveIdx] = new ListGridField("integral");
		achieveIdx++;
		achieveGrid.setFields(achieveFields);
		middleTopLayout.addMember(achieveGrid);

		middleBottomLayout = new HLayout();
		middleBottomLayout.setWidth100();
		middleBottomLayout.setHeight("50%");
		middleBottomLayout.setIsGroup(true);
		middleBottomLayout.setGroupBorderCSS(layoutGroupStyle);
		middleBottomLayout.setGroupLabelBackgroundColor("#555555");
		middleBottomLayout.setGroupTitle("支出栏");
		middleBottomLayout.setGroupLabelStyleName("layoutGroupTitleStyle");
		centerMiddleLayout.addMember(middleBottomLayout);
		
		
		payGrid = new DelicacyListGrid();
		payGrid.setAutoFitFieldWidths(false);
		payGrid.setDataSource(DSEmployeeAccountSource.getInstance());
		payGrid.setShowGridSummary(true);
		ListGridField[] payFields = new ListGridField[2];
		int payIdx = 0;
		payFields[payIdx] = new ListGridField("businessTypeId");
		payFields[payIdx].setShowGridSummary(false);
		payIdx++;
		payFields[payIdx] = new ListGridField("integral");
		payIdx++;
		payGrid.setFields(payFields);
		middleBottomLayout.addMember(payGrid);

		centerRightLayout = new VLayout(20);
		centerRightLayout.setIsGroup(true);
		centerRightLayout.setGroupBorderCSS(layoutGroupStyle);
		centerRightLayout.setGroupLabelBackgroundColor("#555555");
		centerRightLayout.setGroupTitle("明细栏");
		centerRightLayout.setGroupLabelStyleName("layoutGroupTitleStyle");
		centerRightLayout.setHeight("98%");
		centerRightLayout.setWidth("50%");
		centerRightLayout.setMembersMargin(10);
		centerLayout.addMember(centerRightLayout);
		
		chartOneSet();
		chartOneLayout.addMember(chartOne);
		chartTwo = new Chart();
		chartTwoSet();
		chartTwoLayout.addMember(chartTwo);

		addMember(mainLayout);
		
		monthReportGrid = new DelicacyListGrid();
		monthReportGrid.setAutoFitFieldWidths(false);
		monthReportGrid.setDataSource(DSEmpAccountMonthReportSource.getInstance());
		monthReportGrid.setShowGridSummary(true);
		ListGridField[] fields = new ListGridField[6];
		int idx = 0;
		fields[idx] = new ListGridField("businessTypeId");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("employeeNo");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("employeeName");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("year");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("month");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("integral");
		idx++;
		monthReportGrid.setFields(fields);
		
		loadData();
		//收入支出双击事件
		achieveGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				ListGridRecord[] selected = achieveGrid.getSelectedRecords();
				// 业务功能类型
				int businessTypeId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("businessTypeId"));
				onLoadMonthReportData(businessTypeId);
			}
		});
		payGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				ListGridRecord[] selected = payGrid.getSelectedRecords();
				// 业务功能类型
				int businessTypeId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("businessTypeId"));
				onLoadMonthReportData(businessTypeId);
			}
		});
		//月统计双击事件
		monthReportGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				if (!monthReportGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				ListGridRecord[] selected = monthReportGrid.getSelectedRecords();
				//获取业务类型ID
				int businessTypeId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("businessTypeId"));
				//获取年份
				int year = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("year"));
				//获取月份
				int month = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("month"));
				// 获取职员名称
				String employeeName = selected[0].getAttribute("employeeName");
				PopupWindow pw = new PopupWindow();
				//确认积分和项目成本的明细面板
				if(businessTypeId == EMP_BT_SURE_INTEGRAL || businessTypeId == EMP_BT_PROJECT_COST){
					SureIntegralAndProjectCostDetailPanel panel = new SureIntegralAndProjectCostDetailPanel();
					pw.addItem(panel);
					panel.setBusinessTypeId(businessTypeId);
					panel.setPlateId(plateId);
					panel.setEmployeeId(employeeId);
					panel.setYear(year);
					panel.setMonth(month);
					panel.commonQuery();
				//奖金补贴明细
				}else if(businessTypeId == EMP_BT_BONUS_SUBSIDY){
					BonusSubsidyDetailPanel panel  = new BonusSubsidyDetailPanel();
					pw.addItem(panel);
					panel.setBusinessTypeId(businessTypeId);
					panel.setPlateId(plateId);
					panel.setEmployeeId(employeeId);
					panel.setYear(year);
					panel.setMonth(month);
					panel.commonQuery();
				//项目补贴明细
				}else if(businessTypeId == EMP_BT_PROJECT_SUBSIDY){
					ProjectSubsidyDetailPanel panel  = new ProjectSubsidyDetailPanel();
					pw.addItem(panel);
					panel.setBusinessTypeId(businessTypeId);
					panel.setPlateId(plateId);
					panel.setEmployeeId(employeeId);
					panel.setYear(year);
					panel.setMonth(month);
					panel.commonQuery();
				//项目经理绩效奖励、项目经理绩效扣除
				}else if(businessTypeId == EMP_BT_PM_PERFORMANCE_AWARD || businessTypeId == EMP_BT_PM_PERFORMANCE_DEDUCT){
					OnLoadPerformanceIntegralOfEmployeePanel panel  = new OnLoadPerformanceIntegralOfEmployeePanel();
					pw.addItem(panel);
					panel.setBusinessTypeId(businessTypeId);
					panel.setPlateId(plateId);
					panel.setEmployeeId(employeeId);
					panel.setYear(year);
					panel.setMonth(month);
					panel.commonQuery();
				//积分借款、积分还款、人工成本、奖金发放、积分回收、项目违约金、绩效奖金明细、考勤扣款
				}else{
					AllOtherDetailPanel panel = new AllOtherDetailPanel();
					pw.addItem(panel);
					panel.setBusinessTypeId(businessTypeId);
					panel.setPlateId(plateId);
					panel.setEmployeeId(employeeId);
					panel.setYear(year);
					panel.setMonth(month);
					panel.commonQuery();
				}
				pw.setTitle("职员(" + employeeName + ")的汇总明细");
				pw.setWidth100();
				pw.setHeight100();
				pw.centerInPage();
				pw.show();
			}
		});
		// 统计按钮点击事件
		calculateButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				loadData();
			}
		});
		
	}
	
	public void chartOneSet() {
		chartOne = new Chart().setType(Series.Type.COLUMN)
		.setCredits(new Credits().setEnabled(false))//去除链接属性
		.setPlotBackgroundColor((String) null).setPlotBorderWidth(null).setPlotShadow(true)
		.setPiePlotOptions(new PiePlotOptions().setAllowPointSelect(true).setCursor(PlotOptions.Cursor.POINTER)
		.setPieDataLabels(new PieDataLabels().setEnabled(false)).setShowInLegend(true))
		.setToolTip(new ToolTip().setFormatter(new ToolTipFormatter() {
			public String format(ToolTipData toolTipData) {
				return "<b>" + toolTipData.getPointName() + "</b>: " + toolTipData.getYAsDouble() + " 万";
			}
		}));
		chartOne.getXAxis().setCategories("积分收支分析", "积分负值分析");  
		chartOne.setWidth100();
		chartOne.setHeight100();
		chartOne.setBackgroundColor("#FFF");
		chartOne.setBorderColor("#e2e2e2");
	}

	public void chartTwoSet() {
		@SuppressWarnings("unused")
		Date date = new Date();
		DateTimeFormat df = DateTimeFormat.getFormat("yyyy");
		String year = df.format(endDate);
		chartTwo.setType(Series.Type.LINE); 
		chartTwo.setChartTitleText("<font style=\"color:rgb(255, 0, 102);font-size:18px;font:bold 16px;\">"+year+"年度个人效益指数("+benefits+")</font>");
		chartTwo.setToolTip(new ToolTip().setEnabled(false));  
		chartTwo.getXAxis().setCategories("Jan", "Feb", "Mar", "Apr", "May", "Jun","Jul", "Aug", "Sep", "Oct", "Nov", "Dec" );  
		chartTwo.getYAxis().setAxisTitleText("效益指数");  
		chartTwo.setLinePlotOptions(new LinePlotOptions()  
        .setEnableMouseTracking(true)  
        .setDataLabels(new DataLabels()  
        .setEnabled(true)));  
		chartTwo.setWidth100();
		chartTwo.setHeight100();
		chartTwo.setBackgroundColor("#FFF");
		chartTwo.setBorderColor("#e2e2e2");
	}
	
	/**
	 * 加载月统计明细数据
	 * @param businessTypeId
	 */
	public void onLoadMonthReportData(int businessTypeId){
		// 获取开始年月的值
		Date startDate = startDateItem.getValueAsDate();
		// 获取结束年月的值
		Date endDate = endDateItem.getValueAsDate();
		Map<Object, Object> param = new HashMap<>();
		param.put("optType", "onLoadMonthReportData");
		param.put("plateId", plateId);
		param.put("employeeId", employeeId);
		param.put("startDate", startDate);
		param.put("endDate", endDate);
		param.put("businessTypeId", businessTypeId);
		DBDataSource.callOperation("EP_AccountManageProcess", param, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record[] records = dsResponse.getData();
					centerRightLayout.removeMember(centerRightLayout.getMember(0));
					monthReportGrid.setData(records);
					centerRightLayout.addMember(monthReportGrid);
					centerRightLayout.redraw();
				}
			}
		});
	}

	/**
	 * 加载数据集,当plateId>0时说明是查看该部门下所有成员的信息
	 * 当plateId>0 并且employeeId为当前登录人的ID时说明是查看自己的信息
	 * 当plateId>=0并且employeeId>0时说明是查看自己的信息
	 * @param plateId
	 * @param employeeId
	 */
	public void loadData() {
		//获取当前登录人的id
		int currentLoginId = ClientUtil.getEmployeeId();
		if(currentLoginId == employeeId){
			plateId = 0;
		}
		Map<Object, Object> param = new HashMap<>();
		// 获取开始年月的值
		Date startDate = startDateItem.getValueAsDate();
		// 获取结束年月的值
		Date endDate = endDateItem.getValueAsDate();
		DateTimeFormat df = DateTimeFormat.getFormat("yyyy");
		String year = df.format(endDate);
		param.put("optType", "onLoadEmployeeAccountData");
		param.put("startDate", startDate);
		param.put("endDate", endDate);
		param.put("plateId", plateId);
		param.put("employeeId", employeeId);
		param.put("status", -1);//不区别在职和离职
		List<Map<String, String>> keyvalues = new ArrayList<>();
		Map<String, String> kv = new HashMap<>();
		kv.put("key", "and b.plate_id =");
		kv.put("value", "and "+plateId+"=");
		keyvalues.add(kv);
		param.put("keyValues", keyvalues);
		if(employeeId <= 0){
			SC.say("提示","无效的人员");
			return;
		}
		//加载个人效益指数
		LoadBenefitsData(employeeId,year);
		DBDataSource.callOperation("EP_AccountManageProcess", param, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					middleTopLayout.removeMember(achieveGrid);
					middleBottomLayout.removeMember(payGrid);
					Record[] records = dsResponse.getData();
					//定义结余
					BigDecimal leftIntegral = BigDecimal.ZERO;
					//定义收入
					BigDecimal achieveIntegral = BigDecimal.ZERO;
					//定义支出
					BigDecimal payIntegral = BigDecimal.ZERO;
					//定义积分借款
					BigDecimal integralAdvance = BigDecimal.ZERO;
					//定义积分还款
					BigDecimal salaeyRefund = BigDecimal.ZERO;
					//定义map存放收入项的数据集
					Map<Integer,Record> achieveMap = new HashMap<>();
					//定义map存放支出项的数据集
					Map<Integer,Record> payMap = new HashMap<>();
					if (!BaseHelpUtils.isNullOrEmpty(records) && records.length > 0) {
						for (Record e : records) {
							//获取业务类型ID
							int businessTypeId = BaseHelpUtils.getIntValue(e.getAttribute("businessTypeId"));
							//获取金额
	                		BigDecimal integral = BaseHelpUtils.getBigDecimalValue(e.getAttribute("integral"));
	                		switch (businessTypeId) {
							case EMP_BT_SURE_INTEGRAL:
								putRecordToMap(achieveMap, businessTypeId, e, integral);
								break;
							case EMP_BT_BONUS_SUBSIDY:
								putRecordToMap(achieveMap, businessTypeId, e, integral);
								break;
							case EMP_BT_INTEGRAL_ADVANCE:
								integralAdvance = integralAdvance.add(integral);
								putRecordToMap(achieveMap, businessTypeId, e, integral);
								break;
							case EMP_BT_PROJECT_SUBSIDY:
								putRecordToMap(achieveMap, businessTypeId, e, integral);
								break;
							case EMP_BT_PERFORMANCE_BONUS:
								putRecordToMap(achieveMap, businessTypeId, e, integral);
								break;
							case EMP_BT_PM_PERFORMANCE_AWARD:
								putRecordToMap(achieveMap, businessTypeId, e, integral);
								break;
							case EMP_BT_PROJECT_PERFORMANCE:
								putRecordToMap(achieveMap, businessTypeId, e, integral);
								break;
							case EMP_BT_PLATE_CHANGE_ACHIEVE:
								putRecordToMap(achieveMap, businessTypeId, e, integral);
								break;
							case EMP_BT_CONTRACT_DISTRIBUTION_INCOME:
								putRecordToMap(achieveMap, businessTypeId, e, integral);
								break;
							case EMP_BT_SALAEY_REFUND:
								salaeyRefund = salaeyRefund.add(integral);
								putRecordToMap(payMap, businessTypeId, e, integral);
								break;
							case EMP_BT_EMPLOYEE_COST:
								putRecordToMap(payMap, businessTypeId, e, integral);
								break;
							case EMP_BT_PROJECT_COST:
								putRecordToMap(payMap, businessTypeId, e, integral);
								break;
							case EMP_BT_BONUS_SEND:
								putRecordToMap(payMap, businessTypeId, e, integral);
								break;
							case EMP_BT_INTEGRAL_RECYCLE:
								putRecordToMap(payMap, businessTypeId, e, integral);
								break;
							case EMP_BT_VIOLATION_CHARGES:
								putRecordToMap(payMap, businessTypeId, e, integral);
								break;
							case EMP_BT_ATTENDANCE_DEDUCT:
								putRecordToMap(payMap, businessTypeId, e, integral);
								break;
							case EMP_BT_PM_PERFORMANCE_DEDUCT:
								putRecordToMap(payMap, businessTypeId, e, integral);
								break;
							case EMP_BT_CONTRACT_CHANGE:
								putRecordToMap(payMap, businessTypeId, e, integral);
								break;
							case EMP_BT_PLATE_CHANGE_PAY:
								putRecordToMap(payMap, businessTypeId, e, integral);
								break;
							case EMP_BT_PROJECT_PERFORMANCE_PAY:
								putRecordToMap(payMap, businessTypeId, e, integral);
								break;
							case EMP_BT_CONTRACT_DISTRIBUTION_EXPENDITURE:
								putRecordToMap(payMap, businessTypeId, e, integral);
								break;
							default:
								break;
							}
							
						}
						Record[] achieveRecords = new Record[achieveMap.size()];
						Record[] payRecords = new Record[payMap.size()];
						int achieveI = 0;
						int payI = 0;
						for (Integer id : achieveMap.keySet()) {
							Record e = achieveMap.get(id);
							achieveIntegral = achieveIntegral.add(BaseHelpUtils.getBigDecimalValue(e.getAttribute("integral")));
							achieveRecords[achieveI] = e;
							achieveI++;
						}
						for (Integer id : payMap.keySet()) {
							Record e = payMap.get(id);
							payIntegral = payIntegral.add(BaseHelpUtils.getBigDecimalValue(e.getAttribute("integral")));
							payRecords[payI] = e;
							payI++;
						}
						achieveGrid.setData(achieveRecords);
						payGrid.setData(payRecords);
						middleTopLayout.addMember(achieveGrid);
						middleBottomLayout.addMember(payGrid);
						middleTopLayout.redraw();
						middleBottomLayout.redraw();
						
						
					}
					achieveIntegral = BaseHelpUtils.format(achieveIntegral.divide(BigDecimal.valueOf(10000)), 2);
					payIntegral = BaseHelpUtils.format(payIntegral.divide(BigDecimal.valueOf(10000)), 2);
					payIntegral = payIntegral.multiply(new BigDecimal(-1));
					leftIntegral = achieveIntegral.add(payIntegral);
					//积分负载值，即积分还款-借款借款
					integralAdvance = BaseHelpUtils.format(integralAdvance.divide(BigDecimal.valueOf(10000)), 2);
					salaeyRefund = BaseHelpUtils.format(salaeyRefund.divide(BigDecimal.valueOf(10000)), 2);
					BigDecimal left = salaeyRefund.subtract(integralAdvance);
					chartOne.removeFromParent();
					chartOne.setWidth(chartOneLayout.getWidth());
					chartOne.setHeight100();
					chartOne.removeAllSeries();
					chartOne.addSeries(chartOne.createSeries().setName("结余项")
							.setPoints(new Point[] {new Point("积分结余",leftIntegral), new Point("积分负值",left)}));
					chartOne.addSeries(chartOne.createSeries().setName("收入项")
							.setPoints(new Point[] {new Point("积分收入",achieveIntegral)}));
					chartOne.addSeries(chartOne.createSeries().setName("支出项")
							.setPoints(new Point[] {new Point("积分支出",payIntegral)}));
					chartOne.setChartTitleText("<font style=\"color:rgb(255, 0, 102);font-size:18px;font:bold 16px;\">实时余额("+getLeftIntegral()+")</font><br/><font>积分结余("+leftIntegral+"万)</font>");
					chartOneLayout.addMember(chartOne);
				}
			}
		});
	}
	
	/**
	 * 加载年度效益指数
	 * @param employeeId
	 * @param year
	 */
	public void LoadBenefitsData(int employeeId,String year){
		Map<Object, Object> param = new HashMap<>();
		param.put("optType", "onLoadBenefitsData");
		param.put("employeeId", employeeId);
		param.put("year", year);
		DBDataSource.callOperation("EP_AccountManageProcess", param, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record[] records = dsResponse.getData();
					// 结余的数组
					Double[] integralArr = new Double[12];
					if (!BaseHelpUtils.isNullOrEmpty(records) && records.length > 0) {
						//定义一个map存放每月的个人效益收入和支出积分
						Map<Integer,Record> map = new HashMap<>();
						for(int i=1;i<=12;i++){
							Record re = new Record();
							re.setAttribute("achieveIntegral",BigDecimal.ZERO);
							re.setAttribute("payIntegral",BigDecimal.ZERO);
							map.put(i, re);
						}
						for(Record e : records){
							//获取业务类型id
							int businessTypeId = BaseHelpUtils.getIntValue(e.getAttribute("businessTypeId"));
							//获取月份
							int month = BaseHelpUtils.getIntValue(e.getAttribute("month"));
							//获取积分
							BigDecimal integral = BaseHelpUtils.getBigDecimalValue(e.getAttribute("integral"));
							//根据月份去map检索
							Record record = map.get(month);
							if(BaseHelpUtils.isNullOrEmpty(record)){
								record = new Record();
							}
							//个人效益指数收入项(确认积分+项目补贴-项目成本)
							if(businessTypeId == EMP_BT_SURE_INTEGRAL || businessTypeId == EMP_BT_PROJECT_SUBSIDY || businessTypeId == EMP_BT_PROJECT_COST){
								BigDecimal achieveIntegral = BaseHelpUtils.getBigDecimalValue(record.getAttribute("achieveIntegral"));
								if(businessTypeId == EMP_BT_PROJECT_COST){
									integral = integral.multiply(new BigDecimal(-1));
								}
								record.setAttribute("achieveIntegral",achieveIntegral.add(integral));
							}else if(businessTypeId == EMP_BT_EMPLOYEE_COST){
								BigDecimal payIntegral = BaseHelpUtils.getBigDecimalValue(record.getAttribute("payIntegral"));
								record.setAttribute("payIntegral",payIntegral.add(integral));
							}
							map.put(month, record);
						}
						int i = 0;
						for(Integer m : map.keySet()){
							Record record = map.get(m);
							//获取效益指数的收入(确认积分+项目补贴-项目成本)
							BigDecimal achieveIntegral = BaseHelpUtils.getBigDecimalValue(record.getAttribute("achieveIntegral"));
							//获取效益指数的支出(人工成本)
							BigDecimal payIntegral = BaseHelpUtils.getBigDecimalValue(record.getAttribute("payIntegral"));
							//获取效益指数值(效益指数的收入/效益指数的支出)
							BigDecimal benefits = BigDecimal.ZERO;
							if(payIntegral.compareTo(BigDecimal.ZERO)!=0){
								benefits = achieveIntegral.divide(payIntegral,2,BigDecimal.ROUND_DOWN);
							}
							integralArr[i] = benefits.doubleValue();
							i++;
						}
					}
					chartTwo.removeAllSeries();
					// 设置X轴数据
					chartTwo.addSeries(chartTwo.createSeries().setName(year+"年度每月效益指数").setPoints(integralArr));
					chartTwo.redraw();
				}
			}
		});
	}
	
	public void putRecordToMap(Map<Integer,Record> map,int businessTypeId,Record e,BigDecimal integral){
		//根据employeeId去map中检索，看是否有数据，有则对应更新，没有则插入
		Record record = map.get(businessTypeId);
		if(BaseHelpUtils.isNullOrEmpty(record)){//为空，则赋予职员编号，名称等值
			record = new Record();
			record.setAttribute("businessTypeId",businessTypeId);
			record.setAttribute("businessTypeName",e.getAttribute("businessTypeName"));
		}
		record.setAttribute("integral",BaseHelpUtils.getBigDecimalValue(record.getAttribute("integral")).add(integral));
		map.put(businessTypeId, record);
	}
	
	 /**
     * 
     * @Title: getEmpIsAchieve 
     * @Description: 据业务ID获取  员工数据操作是支出还是收入
     * @param @param businessTypeId
     * @param @return   
     * @return Boolean   
     * @throws
     */
    public static Boolean getEmpIsAchieve(int businessTypeId){
    	Boolean flag = null ;
    	switch (businessTypeId) {
		case EMP_BT_SURE_INTEGRAL:
			flag = true;
			break;
		case EMP_BT_BONUS_SUBSIDY:
			flag = true;
			break;
		case EMP_BT_INTEGRAL_ADVANCE:
			flag = true;
			break;
		case EMP_BT_PROJECT_SUBSIDY:
			flag = true;
			break;
		case EMP_BT_SALAEY_REFUND:
			flag = false;
			break;
		case EMP_BT_EMPLOYEE_COST:
			flag = false;
			break;
		case EMP_BT_PROJECT_COST:
			flag = false;
			break;
		case EMP_BT_BONUS_SEND:
			flag = false;
			break;
		case EMP_BT_INTEGRAL_RECYCLE:
			flag = false;
			break;
		case EMP_BT_PERFORMANCE_BONUS:
			flag = true;
			break;
		case EMP_BT_VIOLATION_CHARGES:
			flag = false;
			break;
		case EMP_BT_ATTENDANCE_DEDUCT:
			flag = false;
			break;
		case EMP_BT_PM_PERFORMANCE_AWARD:
			flag = true;
			break;
		case EMP_BT_PM_PERFORMANCE_DEDUCT:
			flag = false;
			break;
		case EMP_BT_PROJECT_PERFORMANCE:
			flag = true;
			break;
		case EMP_BT_CONTRACT_CHANGE:
			flag = false;
			break;
		case EMP_BT_PLATE_CHANGE_ACHIEVE:
			flag = true;
			break;
		case EMP_BT_PLATE_CHANGE_PAY:
			flag = false;
			break;
		case EMP_BT_CONTRACT_DISTRIBUTION_INCOME:
			flag = true;
			break;
		case EMP_BT_CONTRACT_DISTRIBUTION_EXPENDITURE:
			flag = false;
			break;
		default:
			break;
		}
    	return flag;
    }

	private Boolean boo = false;
	private Integer plateId ;
	private Integer employeeId;
	private Date startDate;
	private Date endDate;
	private BigDecimal leftIntegral;
	private BigDecimal benefits;
	private BigDecimal theLeftIntegral;

	public BigDecimal getTheLeftIntegral() {
		return theLeftIntegral;
	}

	public void setTheLeftIntegral(BigDecimal theLeftIntegral) {
		this.theLeftIntegral = theLeftIntegral;
	}

	public Boolean getBoo() {
		return boo;
	}

	public void setBoo(Boolean boo) {
		this.boo = boo;
	}

	public Integer getPlateId() {
		return plateId;
	}

	public void setPlateId(Integer plateId) {
		this.plateId = plateId;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public BigDecimal getLeftIntegral() {
		return leftIntegral;
	}

	public void setLeftIntegral(BigDecimal leftIntegral) {
		this.leftIntegral = leftIntegral;
	}

	public BigDecimal getBenefits() {
		return benefits;
	}

	public void setBenefits(BigDecimal benefits) {
		this.benefits = benefits;
	}
	

}