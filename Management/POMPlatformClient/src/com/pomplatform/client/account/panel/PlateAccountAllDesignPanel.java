package com.pomplatform.client.account.panel;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.moxieapps.gwt.highcharts.client.Chart;
import org.moxieapps.gwt.highcharts.client.Legend;
import org.moxieapps.gwt.highcharts.client.Series;
import org.moxieapps.gwt.highcharts.client.ToolTip;
import org.moxieapps.gwt.highcharts.client.ToolTipData;
import org.moxieapps.gwt.highcharts.client.ToolTipFormatter;
import org.moxieapps.gwt.highcharts.client.events.ChartClickEvent;
import org.moxieapps.gwt.highcharts.client.events.ChartClickEventHandler;
import org.moxieapps.gwt.highcharts.client.plotOptions.ColumnPlotOptions;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.google.gwt.event.shared.HasHandlers;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.DateItemSelectorFormat;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PlateAccountAllDesignPanel extends HLayout implements HasHandlers {
	private static Logger __logger = Logger.getLogger("");
	private VLayout mainLayout;
	private HLayout chartLayout;
	private Chart chart;
	private DateItem startDateItem;
	private DateItem endDateItem;
	public void initComponents() {
		mainLayout = new VLayout();
		mainLayout.setBackgroundColor("#FFF");
		mainLayout.setBorder("2px solid #e2e2e2;border-radius:5px");
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		
		HLayout topVLayout = new HLayout();
        topVLayout.setWidth100();
        topVLayout.setHeight("5%");
        topVLayout.setBackgroundColor("#e2e2e2");
        
        HLayout topLeftHLayout = new HLayout();
        topLeftHLayout.setWidth("25%");
		
        startDateItem = new DateItem("startDate", "开始年月份");
		startDateItem.setWidth("*");
		startDateItem.setShowIcons(false);
		startDateItem.setDefaultValue(new Date());
		startDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
		
		endDateItem = new DateItem("endDate", "结束年月份");
		endDateItem.setWidth("*");
		endDateItem.setShowIcons(false);
		endDateItem.setDefaultValue(new Date());
		endDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
        
        DynamicForm dateForm = new DynamicForm();
        dateForm.setWidth("70%");
        dateForm.setHeight100();
        dateForm.setNumCols(5);
        dateForm.setMargin(10);
        dateForm.setItems(startDateItem,endDateItem);
        
        IButton calculateButton = new IButton("账户统计");
        
        VLayout topRightHLayout = new VLayout();
        topRightHLayout.setBackgroundColor("#e2e2e2");
        topRightHLayout.setHeight100();
        topRightHLayout.setWidth("5%");
        topRightHLayout.setLayoutTopMargin(10);
        topRightHLayout.setLayoutLeftMargin(5);
        topRightHLayout.setLayoutRightMargin(5);
        topRightHLayout.setMembersMargin(10);
        
        topRightHLayout.addMember(calculateButton);
        
        topVLayout.addMember(topLeftHLayout);
        topVLayout.addMember(dateForm);
        topVLayout.addMember(topRightHLayout);
        mainLayout.addMember(topVLayout);
        
		chart = new Chart();
		chart.setClickEventHandler(new ChartClickEventHandler() {
			@Override
			public boolean onClick(ChartClickEvent chartClickEvent) {
				chartSet();
				return true;
			}
		});
		
		chartSet();
		addMember(mainLayout);
		
		//统计按钮点击事件
		calculateButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				loadData();
			}
		});
		
	}
	
	public void chartSet(){
		mainLayout.removeMember(chartLayout);
		if(boo){
			chart.setType(Series.Type.AREA);
			boo = false;
		}else{
			chart.setType(Series.Type.COLUMN);
			boo = true;
		}
		chart.setChartTitleText("Department of account data analysis").setChartSubtitleText("Source:project manage")
		.setColumnPlotOptions(new ColumnPlotOptions().setPointPadding(0.2).setBorderWidth(0))
		.setLegend(new Legend().setLayout(Legend.Layout.VERTICAL).setAlign(Legend.Align.LEFT)
		.setVerticalAlign(Legend.VerticalAlign.TOP).setX(100).setY(70).setFloating(true)
		.setBackgroundColor("#f2f2f2").setShadow(true))
		.setToolTip(new ToolTip().setFormatter(new ToolTipFormatter() {
			public String format(ToolTipData toolTipData) {
				return toolTipData.getXAsString()+"（" +toolTipData.getSeriesName()+ "）: " + toolTipData.getYAsDouble() + " 万";
			}
		}));
		//设置Y轴显示
		chart.getYAxis().setAxisTitleText("积分(万)").setMin(0);
		chart.setWidth100();
		chart.setHeight100();
		chart.setBackgroundColor("#FFF");
		chart.setBorderColor("#e2e2e2");
		chartLayout = new HLayout();
		chartLayout.setWidth100();
		chartLayout.setHeight("95%");
		chartLayout.addMember(chart);
		mainLayout.addMember(chartLayout);
		loadData();
	}

	//加载数据集
	public void loadData(){
		Map<Object,Object> param = new HashMap<>();
		//获取开始年月的值
		Date startDate = startDateItem.getValueAsDate();
		//获取结束年月的值
		Date endDate = endDateItem.getValueAsDate();
		param.put("optType","onLoadPlateAccountData");
		param.put("startDate",startDate);
		param.put("endDate",endDate);
		DBDataSource.callOperation("EP_AccountManageProcess", param, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record[] records = dsResponse.getData();
					int len = records.length;
					//title字符串数组
					String[] titleArr = new String[len];
					//结余的数组
					Double[] achieveIntegralArr = new Double[len];
					//收入的数组
					Double[] comeIntegralArr = new Double[len];
					//支出的数组
					Double[] toIntegralArr = new Double[len];
					if(!BaseHelpUtils.isNullOrEmpty(records) && records.length > 0 ){
						int i = 0;
						for(Record e : records){
							//获取业务部门ID
							int plateId = BaseHelpUtils.getIntValue(e.getAttribute("plateId"));
							titleArr[i] = BaseHelpUtils.getString(KeyValueManager.getValue("system_dictionary_1",plateId+""));
							BigDecimal achieveIntegral = BaseHelpUtils.getBigDecimalValue(e.getAttribute("achieveIntegral")).divide(BigDecimal.valueOf(10000));
							achieveIntegralArr[i] = BaseHelpUtils.format(achieveIntegral,2).doubleValue();
							//获取收入(项目结算)
							BigDecimal projectSettlement = BaseHelpUtils.getBigDecimalValue(e.getAttribute("projectSettlement"));
							//获取收入(公司补贴)
							BigDecimal companySubsidy = BaseHelpUtils.getBigDecimalValue(e.getAttribute("companySubsidy"));
							//获取收入(积分回收)
							BigDecimal employeeAchieveIntegralReturn = BaseHelpUtils.getBigDecimalValue(e.getAttribute("employeeAchieveIntegralReturn"));
							//获取收入(积分还款)
							BigDecimal salaryReturn = BaseHelpUtils.getBigDecimalValue(e.getAttribute("salaryReturn"));
							BigDecimal comeIntegral = projectSettlement.add(companySubsidy).add(employeeAchieveIntegralReturn).add(salaryReturn).divide(BigDecimal.valueOf(10000));
							comeIntegralArr[i] = BaseHelpUtils.format(comeIntegral,2).doubleValue();
							//获取支出(积分借款)
							BigDecimal salaryAdvance = BaseHelpUtils.getBigDecimalValue(e.getAttribute("salaryAdvance"));
							//获取支出(奖金补贴)
							BigDecimal managerProjectIntegral = BaseHelpUtils.getBigDecimalValue(e.getAttribute("managerProjectIntegral"));
							//获取支出(运营成本)
							BigDecimal plateCost = BaseHelpUtils.getBigDecimalValue(e.getAttribute("plateCost"));
							//获取支出(项目补贴)
							BigDecimal projectAdvance = BaseHelpUtils.getBigDecimalValue(e.getAttribute("projectAdvance"));
							BigDecimal toIntegral = salaryAdvance.add(managerProjectIntegral).add(plateCost).add(projectAdvance).divide(BigDecimal.valueOf(10000));
							toIntegralArr[i] = BaseHelpUtils.format(toIntegral,2).doubleValue();
							i++;
						}
					}
					chart.removeAllSeries();
					//设置X轴title显示
					chart.getXAxis().setCategories(titleArr);
					//设置X轴数据
					chart.addSeries(chart.createSeries().setName("结余").setPoints(achieveIntegralArr));
					chart.addSeries(chart.createSeries().setName("收入").setPoints(comeIntegralArr));
					chart.addSeries(chart.createSeries().setName("支出").setPoints(toIntegralArr));
				}
			}
		});
	}
	
	private Boolean boo = false;
	
	public Boolean getBoo() {
		return boo;
	}

	public void setBoo(Boolean boo) {
		this.boo = boo;
	}
	
}