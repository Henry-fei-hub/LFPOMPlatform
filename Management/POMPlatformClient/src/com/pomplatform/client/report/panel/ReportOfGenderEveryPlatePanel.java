package com.pomplatform.client.report.panel;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.moxieapps.gwt.highcharts.client.Chart;
import org.moxieapps.gwt.highcharts.client.Credits;
import org.moxieapps.gwt.highcharts.client.Legend;
import org.moxieapps.gwt.highcharts.client.Series;
import org.moxieapps.gwt.highcharts.client.ToolTip;
import org.moxieapps.gwt.highcharts.client.ToolTipData;
import org.moxieapps.gwt.highcharts.client.ToolTipFormatter;
import org.moxieapps.gwt.highcharts.client.labels.DataLabels;
import org.moxieapps.gwt.highcharts.client.plotOptions.ColumnPlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.PlotOptions.Stacking;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.report.datasource.DSReportOfGenderPlateMonth;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class ReportOfGenderEveryPlatePanel extends AbstractWizadPage {
    private final Logger logger = Logger.getLogger("");
  	
    //定义面板样式
    private final String layoutGroupStyle = "2px solid #555555;border-top-width:22px;border-radius:5px;";
    public final static String BORDER_STYLE = "2px solid #f2f2f2;border-radius:8px;";
    //定义主面板
    private VLayout mainLayout;
    //定义模型图层
    private HLayout chartLayout;
    //内容展示grid
    private HLayout contentLayout;
    
    private Chart chartOne = new Chart();
    private DelicacyListGrid summaryGrid;
    
	public ReportOfGenderEveryPlatePanel() {
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
    	
    	summaryGrid = new DelicacyListGrid();
    	summaryGrid.setWidth100();
    	summaryGrid.setHeight100();
    	summaryGrid.setAutoFitFieldWidths(false);
    	summaryGrid.setDataSource(DSReportOfGenderPlateMonth.getInstance());
    	summaryGrid.setCanEdit(false);
    	contentLayout.addMember(summaryGrid);
    	
    	ListGridField[] fields = new ListGridField[14];
		int idx = 0;
		fields[idx] = new ListGridField("type","类别");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("male","男");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("female","女");
		fields[idx].setShowGridSummary(false);
    	
		summaryGrid.setFields(fields);
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
    	Record oneRecord = new Record();
    	Record twoRecord = new Record();
    	BigDecimal maleProportion = BaseHelpUtils.isNullOrEmpty(record.getAttribute("maleProportion")) ? BigDecimal.ZERO : BaseHelpUtils.getBigDecimalValue(record.getAttribute("maleProportion"));
    	BigDecimal femaleProportion = BaseHelpUtils.isNullOrEmpty(record.getAttribute("femaleProportion")) ? BigDecimal.ZERO : BaseHelpUtils.getBigDecimalValue(record.getAttribute("femaleProportion"));
    	oneRecord.setAttribute("type", "理想比例");
    	oneRecord.setAttribute("male", maleProportion+"%");
    	oneRecord.setAttribute("female", femaleProportion+"%");
    	twoRecord.setAttribute("type", "现有比例");
    	twoRecord.setAttribute("male", record.getAttribute("malePer")+"%");
    	twoRecord.setAttribute("female", record.getAttribute("femalePer")+"%");

    	list.add(oneRecord);
    	list.add(twoRecord);
    	
    	summaryGrid.setData(list);
    	String[] titleArr = {"男","女"};
    	Number[] wantArr = {maleProportion,femaleProportion};
    	Number[] nowArr = {BaseHelpUtils.getBigDecimalValue(record.getAttribute("malePer")),BaseHelpUtils.getBigDecimalValue(record.getAttribute("femalePer"))};
    	chartOne.removeAllSeries();
		// 设置X轴title显示
		chartOne.getXAxis().setCategories(titleArr);
		chartOne.getYAxis().setMin(0).setAxisTitleText(record.getAttribute("title")); 
		// 设置X轴数据
		chartOne.addSeries(chartOne.createSeries().setName("理想比例").setPoints(wantArr));
		chartOne.addSeries(chartOne.createSeries().setName("现有比例").setPoints(nowArr));
    }
    
    
    public void chartSet() {
    	chartOne.setType(Series.Type.COLUMN);
    	chartOne.setChartTitleText("员工性别分析图").setChartSubtitleText("")
				.setCredits(new Credits().setEnabled(false))//去除链接属性
				.setColumnPlotOptions(new ColumnPlotOptions()  
		                .setStacking(Stacking.NORMAL)
		                .setDataLabels(new DataLabels()  
		                        .setEnabled(true)  
		                        .setColor("#FFFFFF")  
	                    ))
				.setLegend(new Legend().setLayout(Legend.Layout.VERTICAL).setAlign(Legend.Align.LEFT)
						.setVerticalAlign(Legend.VerticalAlign.TOP).setX(100).setY(70).setFloating(true)
						.setBackgroundColor("#f2f2f2").setShadow(true))
				.setToolTip(new ToolTip().setFormatter(new ToolTipFormatter() {
					public String format(ToolTipData toolTipData) {
						return toolTipData.getXAsString() + "（" + toolTipData.getSeriesName() + "）: "
								+ toolTipData.getYAsDouble() + " %";
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
