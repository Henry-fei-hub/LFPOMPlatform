package com.pomplatform.client.report.panel;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.moxieapps.gwt.highcharts.client.Chart;
import org.moxieapps.gwt.highcharts.client.Credits;
import org.moxieapps.gwt.highcharts.client.Legend;
import org.moxieapps.gwt.highcharts.client.Series;
import org.moxieapps.gwt.highcharts.client.ToolTip;
import org.moxieapps.gwt.highcharts.client.ToolTipData;
import org.moxieapps.gwt.highcharts.client.ToolTipFormatter;
import org.moxieapps.gwt.highcharts.client.plotOptions.ColumnPlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.PlotOptions.Stacking;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.report.datasource.DSReportMonthEmpWorkYears;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class ReportOfWorkYearsEveryPlatePanel extends AbstractWizadPage {
    //定义面板样式
    public final static String BORDER_STYLE = "2px solid #f2f2f2;border-radius:8px;";
    //定义主面板
    private VLayout mainLayout;
    //定义模型图层
    private HLayout chartLayout;
    //内容展示grid
    private HLayout contentLayout;
    
    private Chart chartOne = new Chart();
    private DelicacyListGrid summaryGrid;
    
	public ReportOfWorkYearsEveryPlatePanel() {
    	mainLayout = new VLayout(10);
    	mainLayout.setBackgroundColor("#FFF");
    	mainLayout.setHeight100();
    	mainLayout.setWidth100();
    	mainLayout.setMembersMargin(0);
    	
    	chartLayout = new HLayout(10);
    	chartLayout.setWidth100();
    	chartLayout.setHeight("50%");
    	
    	chartSet();
    	chartLayout.addMember(chartOne);
    	
    	contentLayout = new HLayout(10);
    	contentLayout.setWidth100();
    	contentLayout.setLayoutTopMargin(20);
    	contentLayout.setHeight("50%");
    	
    	summaryGrid = new DelicacyListGrid(){
    		@Override
    		protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
    			Integer[] arr = {1,3,5,7,9,11};
				List<Integer> list = Arrays.asList(arr);
				if (list.contains(colNum)) {
					return "color: red;";
				} else {
					return super.getCellCSSText(record, rowNum, colNum);
				}
    		}
    	};
    	summaryGrid.setWidth100();
    	summaryGrid.setHeight100();
    	summaryGrid.setAutoFitFieldWidths(false);
    	summaryGrid.setDataSource(DSReportMonthEmpWorkYears.getInstance());
    	summaryGrid.setCanEdit(false);
    	contentLayout.addMember(summaryGrid);
    	
    	summaryGrid.setShowGridSummary(true);
    	mainLayout.addMember(chartLayout);
    	mainLayout.addMember(contentLayout);
    	addMember(mainLayout);
    }

    @Override
    public void startEdit() {
    	
    }
    
    public void loadData(Record record){
    	RecordList list = new RecordList();
    	list.add(record);
    	summaryGrid.setData(list);
    	int oneInner = BaseHelpUtils.getIntValue(record.getAttribute("oneInner"));
    	int threeInner = BaseHelpUtils.getIntValue(record.getAttribute("threeInner"));
    	int fiveInner = BaseHelpUtils.getIntValue(record.getAttribute("fiveInner"));
    	int tenInner = BaseHelpUtils.getIntValue(record.getAttribute("tenInner"));
    	int tenAdd = BaseHelpUtils.getIntValue(record.getAttribute("tenAdd"));
    	// title字符串数组
    	String[] titleArr = {"1年以下人数","1~3年人数","3~5年人数","5~10年人数","10年及以上人数"};
    	Number[] valueArr = {oneInner,threeInner,fiveInner,tenInner,tenAdd};
    	chartOne.removeAllSeries();
		// 设置X轴title显示
		chartOne.getXAxis().setCategories(titleArr);
		// 设置X轴数据
		chartOne.addSeries(chartOne.createSeries().setName("司龄人数").setPoints(valueArr));
    }
    
    
    public void chartSet() {
    	chartOne.setType(Series.Type.COLUMN);
    	chartOne.setChartTitleText("员工性别分析图").setChartSubtitleText("")
		.setCredits(new Credits().setEnabled(false))//去除链接属性
		.setColumnPlotOptions(new ColumnPlotOptions()  
        .setStacking(Stacking.NORMAL))
		.setLegend(new Legend().setLayout(Legend.Layout.VERTICAL).setAlign(Legend.Align.LEFT)
		.setVerticalAlign(Legend.VerticalAlign.TOP).setX(100).setY(70).setFloating(true)
		.setBackgroundColor("#f2f2f2").setShadow(true))
		.setToolTip(new ToolTip().setFormatter(new ToolTipFormatter() {
			public String format(ToolTipData toolTipData) {
				return toolTipData.getXAsString() + "（" + toolTipData.getYAsDouble() + "）";
			}
		}));
		// 设置Y轴显示
    	chartOne.getYAxis().setAxisTitleText("人数").setMin(0);
    	chartOne.setWidth100();
    	chartOne.setHeight100();
    	chartOne.setBackgroundColor("#FFF");
    	chartOne.setBorderColor("#e2e2e2");
	}
    
    
    @Override
    public boolean checkData() {
        return true;
    }

    @SuppressWarnings("rawtypes")
	@Override
    public java.util.Map getValuesAsMap() {
        Map values = __form.getValues();
        return values;
    }

    public String getActionName() {
        // 需要根据实际业务修改
        return "";
    }
    
}
