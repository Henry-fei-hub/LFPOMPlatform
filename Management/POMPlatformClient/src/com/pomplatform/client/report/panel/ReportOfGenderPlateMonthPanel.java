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
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class ReportOfGenderPlateMonthPanel extends AbstractWizadPage {
    private final Logger logger = Logger.getLogger("");
  	
    //定义面板样式
    private final String layoutGroupStyle = "2px solid #555555;border-top-width:22px;border-radius:5px;";
    public final static String BORDER_STYLE = "2px solid #f2f2f2;border-radius:8px;";
    //定义主面板
    private VLayout mainLayout;
    //定义top层，搜索栏
    private HLayout topLayout;
    //定义模型图层
    private HLayout chartLayout;
    //内容展示grid
    private HLayout contentLayout;
    
    private Chart chartOne = new Chart();
    private DelicacyListGrid summaryGrid;
    
    private DynamicForm __infoForm; 
    private SelectItem yearItem;
    private SelectItem monthItem;
    private IButton searchIbutton;
    private IButton resetIbutton;
    
	public ReportOfGenderPlateMonthPanel() {
    	mainLayout = new VLayout(10);
    	mainLayout.setBackgroundColor("#FFF");
    	mainLayout.setHeight100();
    	mainLayout.setWidth100();
    	mainLayout.setMembersMargin(0);
    	
    	topLayout = new HLayout(10);
    	topLayout.setWidth100();
    	topLayout.setHeight("10%");
    	topLayout.setBorder(BORDER_STYLE);
    	topLayout.setLayoutTopMargin(10);
    	topLayout.setBackgroundColor("#f2f2f2");
    	
    	Date currentDate = new Date();
    	yearItem = new SelectItem("year","年份");
    	yearItem.setWidth(280);
    	yearItem.setHeight(26);
    	yearItem.setDefaultValue(currentDate.getYear()+1900);
    	yearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
    	
    	monthItem = new SelectItem("month","开始月份");
    	monthItem.setWidth(280);
    	monthItem.setHeight(26);
    	monthItem.setDefaultValue(currentDate.getMonth()+1);
    	monthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));
    	
    	__infoForm = new DynamicForm();
    	__infoForm.setItems(yearItem,monthItem);
    	__infoForm.setNumCols(4);
    	__infoForm.setWidth("40%");
    	__infoForm.setHeight100();
    	ClientUtil.DynamicFormProcessAccordingToDevice(__infoForm);
    	topLayout.addMember(__infoForm);
    	
    	searchIbutton = new IButton("搜索");
    	searchIbutton.setHeight(26);
    	HLayout vbtn=new HLayout(10);
    	vbtn.setLayoutTopMargin(20);
        vbtn.addMember(searchIbutton);
    	searchIbutton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				startEdit();
			}
		});
    	
    	resetIbutton = new IButton("重置");
    	resetIbutton.setHeight(26);
    	vbtn.addMember(resetIbutton);
    	topLayout.addMember(vbtn);
    	resetIbutton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				__infoForm.editNewRecord();
			}
		});
    	
    	chartLayout = new HLayout(10);
    	chartLayout.setWidth100();
    	chartLayout.setHeight("40%");
    	
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
    	
    	summaryGrid.setShowGridSummary(true);
    	mainLayout.addMember(topLayout);
    	mainLayout.addMember(chartLayout);
    	mainLayout.addMember(contentLayout);
    	addMember(mainLayout);
    	
    	summaryGrid.addDoubleClickHandler(new DoubleClickHandler() {
			
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				Record record = summaryGrid.getSelectedRecord();
				int plateId = BaseHelpUtils.getIntValue(record.getAttribute("plateId"));
				String plateName = KeyValueManager.getValue("plate_records", plateId+"");
				String title = yearItem.getValue()+"年"+monthItem.getValue()+"月("+plateName+")性别分析图";
				record.setAttribute("title", title);
				PopupWindow pw = new PopupWindow();
				ReportOfGenderEveryPlatePanel panel = new ReportOfGenderEveryPlatePanel();
				pw.addItem(panel);
				panel.loadData(record);
				pw.setTitle(title);
				pw.setWidth("40%");
				pw.setHeight("70%");
				pw.centerInPage();
				pw.show();
			}
		});
    }

    @Override
    public void startEdit() {
    	loadGridData();
    }
    
    public void loadGridData(){
    	Map<String,Object> params = new HashMap<>();
    	params.put("optType", "onLoadPlateGenderData");
    	params.put("year", yearItem.getValue());
    	params.put("month", monthItem.getValue());
    	if(plateType > 0){
    		params.put("plateType", plateType);
    	}
    	DBDataSource.callOperation("EP_OnReportProcess", params, new DSCallback() {
			
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					Record[] records = dsResponse.getData();
					int len = records.length;
					summaryGrid.setData(records);
					
					// title字符串数组
					String[] titleArr = new String[len];
					Number[] maleArr = new Number[len];
					Number[] femaleArr = new Number[len];
					if (!BaseHelpUtils.isNullOrEmpty(records) && records.length > 0) {
						int i = 0;
						for(Record e : records){
							int plateId = BaseHelpUtils.getIntValue(e.getAttribute("plateId"));
							String plateName = KeyValueManager.getValue("plate_records", plateId + "");
							e.setAttribute("plateName", plateName);
							titleArr[i] = plateName;
							BigDecimal maleNum = BaseHelpUtils.getBigDecimalValue(e.getAttribute("malePer"));
							maleArr[i] = maleNum;
							BigDecimal femaleNum = BaseHelpUtils.getBigDecimalValue(e.getAttribute("femalePer"));
							femaleArr[i] = femaleNum;
							i++;
						}
					}
					chartOne.removeAllSeries();
					// 设置X轴title显示
					chartOne.getXAxis().setCategories(titleArr);
					chartOne.getYAxis().setMin(0).setAxisTitleText("员工性别分析图"); 
					// 设置X轴数据
					chartOne.addSeries(chartOne.createSeries().setName("男性").setPoints(maleArr));
					chartOne.addSeries(chartOne.createSeries().setName("女性").setPoints(femaleArr)); 
				}
			}
		});
    }
    
    
    public void chartSet() {
    	chartOne.setType(Series.Type.COLUMN);
    	chartOne.setChartTitleText("员工性别分析图").setChartSubtitleText("")
				.setCredits(new Credits().setEnabled(false))//去除链接属性
				.setColumnPlotOptions(new ColumnPlotOptions()  
		                .setStacking(Stacking.PERCENT)
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
    
    private int plateType = 0;

	public int getPlateType() {
		return plateType;
	}

	public void setPlateType(int plateType) {
		this.plateType = plateType;
	}
    
    
}
