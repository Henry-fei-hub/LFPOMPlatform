package com.pomplatform.client.account.panel;

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
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.account.datasource.DSQualityFundAccountMonthSource;
import com.pomplatform.client.account.datasource.DSQualityFundAccountSource;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.DateItemSelectorFormat;
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

public class AccountDesignPanel extends HLayout implements HasHandlers {
	private static Logger __logger = Logger.getLogger("");
	// 定义面板样式
	private final String layoutGroupStyle = "2px solid #555555;border-top-width:22px;border-radius:5px;";
	public final static String BORDER_STYLE = "2px solid #f2f2f2;border-radius:8px;";
	// 定义整个面板的layout,整个面板分头部面板和中心面板
	private VLayout mainLayout;
	// 定义头部面板，包括左右两个面板
	private HLayout topVLayout;
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
	private DateItem startDateItem;
	private DateItem endDateItem;
	private DelicacyListGrid achieveGrid;
	private DelicacyListGrid payGrid;
	private HLayout middleTopLayout;
	private HLayout middleBottomLayout;
	private DelicacyListGrid monthReportGrid;

	@SuppressWarnings("deprecation")
	public void initComponents() {
		mainLayout = new VLayout();
		mainLayout.setBackgroundColor("#FFF");
		mainLayout.setBorder("2px solid #e2e2e2;border-radius:5px");
		mainLayout.setWidth100();
		mainLayout.setHeight100();

		topVLayout = new HLayout();
		topVLayout.setWidth100();
		topVLayout.setHeight("5%");
		topVLayout.setBackgroundColor("#e2e2e2");

		startDateItem = new DateItem("startDate", "开始年月份");
		startDateItem.setWidth("*");
		startDateItem.setShowIcons(false);
		if(startDate != null){
			startDateItem.setDefaultValue(startDate);
		}else{
			startDateItem.setDefaultValue(new Date("2016-01-01"));
		}
		startDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);

		endDateItem = new DateItem("endDate", "结束年月份");
		endDateItem.setWidth("*");
		endDateItem.setShowIcons(false);
		if(endDate != null){
			endDateItem.setDefaultValue(endDate);
		}else{
			Date date = new Date();
			date.setMonth(11);
			endDateItem.setDefaultValue(date);
		}
		endDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);

		DynamicForm dateForm = new DynamicForm();
		dateForm.setWidth100();
		dateForm.setHeight100();
		dateForm.setNumCols(7);
		dateForm.setMargin(10);
		dateForm.setItems(startDateItem, endDateItem);

		IButton calculateButton = new IButton("账户统计");

		HLayout topLeftHLayout = new HLayout();
        topLeftHLayout.setWidth("25%");
        
        HLayout topMiddleHLayout = new HLayout();
        topMiddleHLayout.setWidth("70%");
        topMiddleHLayout.setLayoutLeftMargin(5);
        topMiddleHLayout.setLayoutRightMargin(5);
        topMiddleHLayout.setMembersMargin(10);
        topMiddleHLayout.addMember(dateForm);
		
		HLayout topRightHLayout = new HLayout();
		topRightHLayout.setBackgroundColor("#e2e2e2");
		topRightHLayout.setHeight100();
		topRightHLayout.setWidth("5%");
		topRightHLayout.setLayoutTopMargin(10);
		topRightHLayout.setLayoutLeftMargin(5);
		topRightHLayout.setLayoutRightMargin(5);
		topRightHLayout.setMembersMargin(10);
		topRightHLayout.addMember(calculateButton);

		topVLayout.addMember(topLeftHLayout);
		topVLayout.addMember(topMiddleHLayout);
		topVLayout.addMember(topRightHLayout);
		mainLayout.addMember(topVLayout);

		centerLayout = new HLayout(10);
		centerLayout.setHeight("95%");
		centerLayout.setWidth100();
		centerLayout.setMembersMargin(10);
		centerLayout.setLayoutTopMargin(10);
		mainLayout.addMember(centerLayout);
		
		HLayout centerLeft = new HLayout(10);
		centerLeft.setHeight100();
		centerLeft.setWidth("95%");
		centerLeft.setMembersMargin(10);
		centerLayout.addMember(centerLeft);
		
		VLayout centerRight= new VLayout(10);
		centerRight.setHeight100();
		centerRight.setWidth("5%");
		centerRight.setLayoutTopMargin(10);
		centerRight.setBackgroundColor("#e2e2e2");
		centerRight.setMembersMargin(10);
		centerRight.setLayoutLeftMargin(5);
		centerRight.setLayoutRightMargin(5);
		centerLayout.addMember(centerRight);
		
		centerLeftLayout = new VLayout(20);
		centerLeftLayout.setIsGroup(true);
		centerLeftLayout.setGroupBorderCSS(layoutGroupStyle);
		centerLeftLayout.setGroupLabelBackgroundColor("#555555");
		centerLeftLayout.setGroupTitle("数据模型图");
		centerLeftLayout.setGroupLabelStyleName("layoutGroupTitleStyle");
		centerLeftLayout.setHeight100();
		centerLeftLayout.setWidth("25%");
		centerLeftLayout.setMembersMargin(20);

		centerLeft.addMember(centerLeftLayout);

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
		centerLeft.addMember(centerMiddleLayout);

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
		achieveGrid.setDataSource(DSQualityFundAccountSource.getInstance());
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
		payGrid.setDataSource(DSQualityFundAccountSource.getInstance());
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
		centerLeft.addMember(centerRightLayout);
		
		chartOneSet();
		chartOneLayout.addMember(chartOne);
		chartTwo = new Chart();
		chartTwoSet();
		chartTwoLayout.addMember(chartTwo);

		addMember(mainLayout);
		
		monthReportGrid = new DelicacyListGrid();
		monthReportGrid.setAutoFitFieldWidths(false);
		monthReportGrid.setDataSource(DSQualityFundAccountMonthSource.getInstance());
		monthReportGrid.setShowGridSummary(true);
		ListGridField[] fields = new ListGridField[7];
		int idx = 0;
		fields[idx] = new ListGridField("accountTypeId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("accountId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("businessTypeId");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("year");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("month");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("achieveIntegral");
		idx++;
		fields[idx] = new ListGridField("payIntegral");
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
				//获取账户类型ID
				int accountTypeId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("accountTypeId"));
				//获取账户ID
				int accountId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("accountId"));
				//获取业务类型ID
				int businessTypeId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("businessTypeId"));
				//获取年份
				int year = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("year"));
				//获取月份
				int month = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("month"));
				PopupWindow pw = new PopupWindow();
				OnLoadAccountDetailDataPanel panel = new OnLoadAccountDetailDataPanel();
				pw.addItem(panel);
				panel.setAccountTypeId(accountTypeId);
				panel.setAccountId(accountId);
				panel.setBusinessTypeId(businessTypeId);
				panel.setYear(year);
				panel.setMonth(month);
				panel.commonQuery();
				pw.setTitle("汇总明细");
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
		.setChartTitleText("<font style=\"color:rgb(255, 0, 102);font-size:18px;font:bold 16px;\">实时余额("+leftIntegral+")</font>")
		.setCredits(new Credits().setEnabled(false))//去除链接属性
		.setPlotBackgroundColor((String) null).setPlotBorderWidth(null).setPlotShadow(true)
		.setPiePlotOptions(new PiePlotOptions().setAllowPointSelect(true).setCursor(PlotOptions.Cursor.POINTER)
		.setPieDataLabels(new PieDataLabels().setEnabled(false)).setShowInLegend(true))
		.setToolTip(new ToolTip().setFormatter(new ToolTipFormatter() {
			public String format(ToolTipData toolTipData) {
				return "<b>" + toolTipData.getPointName() + "</b>: " + toolTipData.getYAsDouble() + " 万";
			}
		}));
		chartOne.getXAxis().setCategories("积分收支分析");  
		chartOne.setWidth100();
		chartOne.setHeight100();
		chartOne.setBackgroundColor("#FFF");
		chartOne.setBorderColor("#e2e2e2");
	}

	public void chartTwoSet() {
		chartTwo.setType(Series.Type.COLUMN);
		chartTwo.setChartTitleText("收入支出项").setChartSubtitleText("")
				.setColumnPlotOptions(new ColumnPlotOptions().setPointPadding(0.2).setBorderWidth(0))
				.setLegend(new Legend().setLayout(Legend.Layout.VERTICAL).setAlign(Legend.Align.LEFT)
						.setVerticalAlign(Legend.VerticalAlign.TOP).setX(100).setY(70).setFloating(true)
						.setBackgroundColor("#f2f2f2").setShadow(true))
				.setToolTip(new ToolTip().setFormatter(new ToolTipFormatter() {
					public String format(ToolTipData toolTipData) {
						return toolTipData.getXAsString() + "（" + toolTipData.getSeriesName() + "）: "
								+ toolTipData.getYAsDouble() + " 万";
					}
				}));
		// 设置Y轴显示
		chartTwo.getYAxis().setAxisTitleText("积分(万)").setMin(0);
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
		param.put("startDate", startDate);
		param.put("endDate", endDate);
		param.put("accountTypeId", accountTypeId);
		param.put("accountId",accountId);
		param.put("businessTypeId", businessTypeId);
		DBDataSource.callOperation("NQ_OnLoadMonthDataOfAccount", param, new DSCallback() {
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
	
	// 加载数据集
	public void loadData() {
		Map<Object, Object> param = new HashMap<>();
		// 获取开始年月的值
		Date startDate = startDateItem.getValueAsDate();
		// 获取结束年月的值
		Date endDate = endDateItem.getValueAsDate();
		param.put("startDate", startDate);
		param.put("endDate", endDate);
		param.put("accountTypeId",accountTypeId);
		param.put("accountId",accountId);
		DBDataSource.callOperation("NQ_OnLoadBusinessTypeDataOfAccount", param, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					middleTopLayout.removeMember(achieveGrid);
					middleBottomLayout.removeMember(payGrid);
					Record[] records = dsResponse.getData();
					int len = records.length;
					// title字符串数组
					String[] titleArr = new String[len];
					// 结余的数组
					Double[] integralArr = new Double[len];
					//定义结余
					BigDecimal leftIntegral = BigDecimal.ZERO;
					//定义收入
					BigDecimal achieveIntegral = BigDecimal.ZERO;
					//定义支出
					BigDecimal payIntegral = BigDecimal.ZERO;
					if (!BaseHelpUtils.isNullOrEmpty(records) && records.length > 0) {
						int i = 0;
						int count = 0;//记录支出项的数目
						for (Record e : records) {
							String name = BaseHelpUtils.getString(e.getAttribute("businessTypeName"));
							//获取收入积分
							BigDecimal ahieve = BaseHelpUtils.getBigDecimalValue(e.getAttribute("achieveIntegral"));
							BigDecimal pay = BaseHelpUtils.getBigDecimalValue(e.getAttribute("payIntegral"));
							e.setAttribute("name", name);
							titleArr[i] = name;
							BigDecimal integral = ahieve.compareTo(BigDecimal.ZERO)==0?pay:ahieve;
							e.setAttribute("integral", integral);
							integralArr[i] = BaseHelpUtils.format(integral.divide(BigDecimal.valueOf(10000)), 2).doubleValue();
							if(ahieve.compareTo(BigDecimal.ZERO) > 0){//说明是收入项
								achieveIntegral = achieveIntegral.add(integral);
							}else{//说明是支出项
								payIntegral = payIntegral.add(integral);
								count++;
							}
							i++;
						}
						Record[] achieveRecords = new Record[len-count];
						Record[] payRecords = new Record[count];
						int achieveI = 0;
						int payI = 0;
						for (Record e : records) {
							//获取收入积分
							BigDecimal ahieve = BaseHelpUtils.getBigDecimalValue(e.getAttribute("achieveIntegral"));
							if(ahieve.compareTo(BigDecimal.ZERO) > 0){//说明是收入项
								achieveRecords[achieveI] = e;
								achieveI++;
							}else{//说明是支出项
								payRecords[payI] = e;
								payI++;
							}
						}
						achieveGrid.setData(achieveRecords);
						payGrid.setData(payRecords);
						middleTopLayout.addMember(achieveGrid);
						middleBottomLayout.addMember(payGrid);
						middleTopLayout.redraw();
						middleBottomLayout.redraw();
						
					}
					//设置价值积分
					setValueOfIntegral(achieveIntegral.subtract(payIntegral));
					achieveIntegral = BaseHelpUtils.format(achieveIntegral.divide(BigDecimal.valueOf(10000)), 2);
					payIntegral = BaseHelpUtils.format(payIntegral.divide(BigDecimal.valueOf(10000)), 2);
					leftIntegral = achieveIntegral.subtract(payIntegral);
					chartOne.removeAllSeries();
					chartOne.addSeries(chartOne.createSeries().setName("积分结余("+valueOfIntegral+")")
							.setPoints(new Point[] {new Point("积分结余",leftIntegral)}));
					chartOne.addSeries(chartOne.createSeries().setName("积分收入")
							.setPoints(new Point[] {new Point("积分收入",achieveIntegral)}));
					chartOne.addSeries(chartOne.createSeries().setName("积分支出")
							.setPoints(new Point[] {new Point("积分支出",payIntegral)}));
					
					chartTwo.removeAllSeries();
					// 设置X轴title显示
					chartTwo.getXAxis().setCategories(titleArr);
					// 设置X轴数据
					chartTwo.addSeries(chartTwo.createSeries().setName("积分").setPoints(integralArr));
				}
			}
		});
	}
	

	private Date startDate;
	private Date endDate;
	private BigDecimal valueOfIntegral;
	private BigDecimal leftIntegral;
	private int accountTypeId;
	private int accountId;
	
	public int getAccountTypeId() {
		return accountTypeId;
	}

	public void setAccountTypeId(int accountTypeId) {
		this.accountTypeId = accountTypeId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
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

	public BigDecimal getValueOfIntegral() {
		return valueOfIntegral;
	}

	public void setValueOfIntegral(BigDecimal valueOfIntegral) {
		this.valueOfIntegral = valueOfIntegral;
	}

	public BigDecimal getLeftIntegral() {
		return leftIntegral;
	}

	public void setLeftIntegral(BigDecimal leftIntegral) {
		this.leftIntegral = leftIntegral;
	}
	

}