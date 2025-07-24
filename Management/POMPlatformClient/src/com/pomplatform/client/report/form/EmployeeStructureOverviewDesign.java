package com.pomplatform.client.report.form;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.pomplatform.client.ja.ht.panel.CustomAddQuotationMainPanel;
import com.pomplatform.client.report.datasource.DSEmployeeStructureOverview;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import org.moxieapps.gwt.highcharts.client.*;
import org.moxieapps.gwt.highcharts.client.labels.DataLabels;
import org.moxieapps.gwt.highcharts.client.labels.DataLabelsFormatter;
import org.moxieapps.gwt.highcharts.client.labels.PieDataLabels;
import org.moxieapps.gwt.highcharts.client.plotOptions.ColumnPlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.LinePlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.PiePlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.PlotOptions;
import org.moxieapps.gwt.highcharts.client.Series.Type;
import org.moxieapps.gwt.highcharts.client.plotOptions.PlotOptions.Cursor;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class EmployeeStructureOverviewDesign extends AbstractWizadPage implements EntryPoint {

    private final Logger __logger = Logger.getLogger("");
    private DynamicForm SearchForm;
    private DelicacyListGrid grid;

    private VLayout allLayout;
    private HLayout contentLayout;
    private HLayout chart1Layout;
    private HLayout chart2Layout;
    private HLayout chart3Layout;
    private HLayout chart4Layout;
    private VLayout basicLayout;
    private VLayout gridLayout;
    private VLayout basicChartLayout;
    private HLayout searchLayout;
    private HLayout searchLeftLayout;
    private HLayout searchRightLayout;

    private final SelectItem startYearItem;
    private final SelectItem endYearItem;

    private Chart chart;//性别
    private Chart chart1;//政治面貌
    private Chart chart2;//年龄
    private Chart chart3;//工龄
    private Chart chart4;//司龄
    private Chart chart5;//学历
    private Chart chart6;//职级
    private Chart chart7;//应届生比例

    private String total;


    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public void onModuleLoad() {
        SC.debugger();
        chart = new Chart()
                .setType(Series.Type.PIE)
                .setChartTitleText("性别总览")
                .setCredits(new Credits().setEnabled(false))//去除链接属性
                .setPlotBackgroundColor((String) null)
                .setPlotBorderWidth(null)
                .setPlotShadow(false)
                .setPiePlotOptions(new PiePlotOptions()
                        .setAllowPointSelect(true)
                        .setCursor(Cursor.POINTER)
                        .setPieDataLabels(new PieDataLabels()
                                .setEnabled(false)
                        )
                        .setShowInLegend(true)
                )
                .setToolTip(new ToolTip()
                        .setFormatter(new ToolTipFormatter() {
                            @Override
                            public String format(ToolTipData toolTipData) {
                                return "<b>" + toolTipData.getPointName() + "</b>: " + toolTipData.getYAsDouble() + " %";
                            }
                        })
                );
        chart.setWidth100();
        chart.setHeight100();
        chart.setBackgroundColor("#FFF");
        chart.setBorderColor("#e2e2e2");

        chart1 = new Chart()
                .setType(Series.Type.PIE)
                .setChartTitleText("政治面貌总览")
                .setCredits(new Credits().setEnabled(false))//去除链接属性
                .setPlotBackgroundColor((String) null)
                .setPlotBorderWidth(null)
                .setPlotShadow(false)
                .setPiePlotOptions(new PiePlotOptions()
                        .setAllowPointSelect(true)
                        .setCursor(Cursor.POINTER)
                        .setPieDataLabels(new PieDataLabels()
                                .setEnabled(false)
                        )
                        .setShowInLegend(true)
                )
                .setToolTip(new ToolTip()
                        .setFormatter(new ToolTipFormatter() {
                            @Override
                            public String format(ToolTipData toolTipData) {
                                return "<b>" + toolTipData.getPointName() + "</b>: " + toolTipData.getYAsDouble() + " %";
                            }
                        })
                );
        chart1.setWidth100();
        chart1.setHeight100();
        chart1.setBackgroundColor("#FFF");
        chart1.setBorderColor("#e2e2e2");

        chart2 = new Chart()
                .setType(Series.Type.PIE)
                .setChartTitleText("年龄总览")
                .setCredits(new Credits().setEnabled(false))//去除链接属性
                .setPlotBackgroundColor((String) null)
                .setPlotBorderWidth(null)
                .setPlotShadow(false)
                .setPiePlotOptions(new PiePlotOptions()
                        .setAllowPointSelect(true)
                        .setCursor(Cursor.POINTER)
                        .setPieDataLabels(new PieDataLabels()
                                .setEnabled(false)
                        )
                        .setShowInLegend(true)
                )
                .setToolTip(new ToolTip()
                        .setFormatter(new ToolTipFormatter() {
                            @Override
                            public String format(ToolTipData toolTipData) {
                                return "<b>" + toolTipData.getPointName() + "</b>: " + toolTipData.getYAsDouble() + " %";
                            }
                        })
                );
        chart2.setWidth100();
        chart2.setHeight100();
        chart2.setBackgroundColor("#FFF");
        chart2.setBorderColor("#e2e2e2");

        chart3 = new Chart()
                .setType(Series.Type.PIE)
                .setChartTitleText("工龄总览")
                .setCredits(new Credits().setEnabled(false))//去除链接属性
                .setPlotBackgroundColor((String) null)
                .setPlotBorderWidth(null)
                .setPlotShadow(false)
                .setPiePlotOptions(new PiePlotOptions()
                        .setAllowPointSelect(true)
                        .setCursor(Cursor.POINTER)
                        .setPieDataLabels(new PieDataLabels()
                                .setEnabled(false)
                        )
                        .setShowInLegend(true)
                )
                .setToolTip(new ToolTip()
                        .setFormatter(new ToolTipFormatter() {
                            @Override
                            public String format(ToolTipData toolTipData) {
                                return "<b>" + toolTipData.getPointName() + "</b>: " + toolTipData.getYAsDouble() + " %";
                            }
                        })
                );
        chart3.setWidth100();
        chart3.setHeight100();
        chart3.setBackgroundColor("#FFF");
        chart3.setBorderColor("#e2e2e2");

        chart4 = new Chart()
                .setType(Series.Type.PIE)
                .setChartTitleText("司龄总览")
                .setCredits(new Credits().setEnabled(false))//去除链接属性
                .setPlotBackgroundColor((String) null)
                .setPlotBorderWidth(null)
                .setPlotShadow(false)
                .setPiePlotOptions(new PiePlotOptions()
                        .setAllowPointSelect(true)
                        .setCursor(Cursor.POINTER)
                        .setPieDataLabels(new PieDataLabels()
                                .setEnabled(false)
                        )
                        .setShowInLegend(true)
                )
                .setToolTip(new ToolTip()
                        .setFormatter(new ToolTipFormatter() {
                            @Override
                            public String format(ToolTipData toolTipData) {
                                return "<b>" + toolTipData.getPointName() + "</b>: " + toolTipData.getYAsDouble() + " %";
                            }
                        })
                );
        chart4.setWidth100();
        chart4.setHeight100();
        chart4.setBackgroundColor("#FFF");
        chart4.setBorderColor("#e2e2e2");

        chart5 = new Chart()
                .setType(Series.Type.PIE)
                .setChartTitleText("学历总览")
                .setCredits(new Credits().setEnabled(false))//去除链接属性
                .setPlotBackgroundColor((String) null)
                .setPlotBorderWidth(null)
                .setPlotShadow(false)
                .setPiePlotOptions(new PiePlotOptions()
                        .setAllowPointSelect(true)
                        .setCursor(Cursor.POINTER)
                        .setPieDataLabels(new PieDataLabels()
                                .setEnabled(false)
                        )
                        .setShowInLegend(true)
                )
                .setToolTip(new ToolTip()
                        .setFormatter(new ToolTipFormatter() {
                            @Override
                            public String format(ToolTipData toolTipData) {
                                return "<b>" + toolTipData.getPointName() + "</b>: " + toolTipData.getYAsDouble() + " %";
                            }
                        })
                );
        chart5.setWidth100();
        chart5.setHeight100();
        chart5.setBackgroundColor("#FFF");
        chart5.setBorderColor("#e2e2e2");

        chart6 = new Chart()
                .setType(Type.COLUMN)
                .setChartTitleText("职级总览")
                .setCredits(new Credits().setEnabled(false))//去除链接属性
//                .setChartSubtitleText("Source: Wikipedia.org")
                .setColumnPlotOptions(new ColumnPlotOptions()
                        .setDataLabels(new DataLabels()
                                .setEnabled(true)
                        )
                )
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
        chart6.setWidth100();
        chart6.setHeight100();
        chart6.setBackgroundColor("#FFF");
        chart6.setBorderColor("#e2e2e2");

        chart7 = new Chart()
                .setType(Type.LINE)
                .setCredits(new Credits().setEnabled(false))//去除链接属性
                .setChartTitleText("应届生占比");
        chart7.setLinePlotOptions(new LinePlotOptions()
                .setEnableMouseTracking(true)
                .setDataLabels(new DataLabels()
                        .setEnabled(true)
                )
        );

        chart7.setWidth100();
        chart7.setHeight100();
        chart7.setBackgroundColor("#FFF");
        chart7.setBorderColor("#e2e2e2");

        RootPanel.get().add(chart);
        RootPanel.get().add(chart1);
        RootPanel.get().add(chart2);
        RootPanel.get().add(chart3);
        RootPanel.get().add(chart4);
        RootPanel.get().add(chart5);
        RootPanel.get().add(chart6);
        RootPanel.get().add(chart7);
    }

    public EmployeeStructureOverviewDesign() {
        __form.setGroupTitle("员工总览");
        __form.setIsGroup(true);
        __form.setHeight100();
        allLayout = new VLayout(10);


        contentLayout = new HLayout(10);
        contentLayout.setWidth100();
        contentLayout.setHeight100();

        basicLayout = new VLayout(10);
        basicLayout.setHeight100();
        basicLayout.setWidth("15%");

        basicChartLayout = new VLayout(10);
        basicChartLayout.setHeight100();
        basicChartLayout.setWidth("85%");

        searchLayout = new HLayout(10);
        searchLayout.setHeight("5%");
        searchLayout.setWidth100();
        searchLayout.setBackgroundColor("#e2e2e2");

        searchLeftLayout = new HLayout(10);
        searchLeftLayout.setHeight100();
        searchLeftLayout.setWidth("50%");

        searchRightLayout = new HLayout(10);
        searchRightLayout.setHeight100();
        searchRightLayout.setWidth("50%");

        startYearItem = new SelectItem("startYear", "开始年份");
        startYearItem.setWidth("*");
        startYearItem.setDefaultValue(2016);
        Map<String,Object> map = new HashMap<>();
        map.put("2010","2010");
        map.put("2011","2011");
        map.put("2012","2012");
        map.put("2013","2013");
        map.put("2014","2014");
        map.put("2015","2015");
        map.put("2016","2016");
        map.put("2017","2017");
        map.put("2018","2018");
        map.put("2019","2019");
        map.put("2020","2020");
        map.put("2021","2021");
        startYearItem.setValueMap(map);

        endYearItem = new SelectItem("endYear", "截止年份");
        endYearItem.setWidth("*");
        endYearItem.setDefaultValue(2021);
        endYearItem.setValueMap(map);

        SearchForm = new DynamicForm();
        SearchForm.setHeight100();
        SearchForm.setWidth100();
        SearchForm.setNumCols(4);
//        SearchForm.setMargin(10);
        SearchForm.setItems(startYearItem, endYearItem);
//        searchLeftLayout.addMember(SearchForm);

        IButton searchButton = new IButton("搜索");
        searchButton.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                chartSet1();
            }
        });
        searchRightLayout.setLayoutTopMargin(12);
        searchRightLayout.addMember(SearchForm);
        searchRightLayout.addMember(searchButton);

        searchLayout.addMember(searchLeftLayout);
        searchLayout.addMember(searchRightLayout);

        grid = new DelicacyListGrid();
        grid.setWidth100();
        int index = 0;
        ListGridField[] fields = new ListGridField[3];
        fields[index] = new ListGridField("a", "维度");
        fields[index].setWidth("40%");
        index++;
        fields[index] = new ListGridField("a1", "人数");
        fields[index].setWidth("30%");
        fields[index].setAlign(Alignment.LEFT);
        index++;
        fields[index] = new ListGridField("round", "比例");
        fields[index].setWidth("30%");

        grid.setAutoFitFieldWidths(false);
        grid.setFields(fields);
        grid.setDataSource(DSEmployeeStructureOverview.getInstance());


        gridLayout = new VLayout(10);
        gridLayout.setHeight100();
//        gridLayout.setWidth("20%");
        gridLayout.addMember(grid);
        IButton exportOutDeCon=new IButton("导出");
        exportOutDeCon.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                Map<String, Object> condition = new HashMap<>();
                DBDataSource.downloadFile("DW_EmployeeStructureOverview", condition);
            }
        });
        gridLayout.addMember(exportOutDeCon);


        chart1Layout = new HLayout(10);
        chart1Layout.setHeight("100%");
        chart1Layout.setWidth("100%");

        chart2Layout = new HLayout(10);
        chart2Layout.setHeight("100%");
        chart2Layout.setWidth("100%");

        chart3Layout = new HLayout(10);
        chart3Layout.setHeight("100%");
        chart3Layout.setWidth("100%");

        chart4Layout = new HLayout(10);
        chart4Layout.setHeight("100%");
        chart4Layout.setWidth("100%");
        onModuleLoad();

        basicLayout.addMember(gridLayout);
        chart1Layout.addMember(chart);
        chart1Layout.addMember(chart1);
        chart1Layout.addMember(chart2);
        chart2Layout.addMember(chart3);
        chart2Layout.addMember(chart4);
        chart2Layout.addMember(chart5);
        chart3Layout.addMember(chart6);
        chart4Layout.addMember(chart7);
        basicChartLayout.addMember(searchLayout);
        basicChartLayout.addMember(chart4Layout);
        basicChartLayout.addMember(chart1Layout);
        basicChartLayout.addMember(chart2Layout);
        basicChartLayout.addMember(chart3Layout);
        contentLayout.addMember(basicLayout);
        contentLayout.addMember(basicChartLayout);
        allLayout.addMember(contentLayout);
        addMember(allLayout);
    }

    @Override
    public void startEdit() {
        SC.debugger();
        //加载grid数据
        Map<String, Object> params = new HashMap<>();
        DBDataSource.callOperation("NQ_EmployeeStructureOverview", params, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                    Record[] record = dsResponse.getData();
                    if (!BaseHelpUtils.isNullOrEmpty(record)) {
                        total = record[0].getAttribute("a1");
                        loadChartData(record);
                        chartSet();
                        chartSet1();
                        for (Record e : record) {
                            String f = BaseHelpUtils.getString(e.getAttributeAsDouble("round") * 100);
                            BigDecimal b = new BigDecimal(f);
                            String s = BaseHelpUtils.getString(b.setScale(2, BigDecimal.ROUND_HALF_UP)) + "%";
                            e.setAttribute("round", s);
                        }
                        grid.setData(record);
                        params.put("recordDate", new Date());
                    }
                }
            }
        });
    }


    //加载月考勤汇总饼状图数据
    private void loadChartData(Record[] record) {
        SC.debugger();
        chart.removeAllSeries();
        chart.addSeries(chart.createSeries()
                .setName("性别")
                .setPoints(new Point[]{
                        new Point("男:" + record[1].getAttribute("a1") + "人", new BigDecimal(BaseHelpUtils.getDoubleValue(record[1].getAttribute("round")) * 100).setScale(2, BigDecimal.ROUND_HALF_UP)),
                        new Point("女:" + record[2].getAttribute("a1") + "人", new BigDecimal(BaseHelpUtils.getDoubleValue(record[2].getAttribute("round")) * 100).setScale(2, BigDecimal.ROUND_HALF_UP)),
                })
        );
        chart1.removeAllSeries();
        chart1.addSeries(chart1.createSeries()
                .setName("政治面貌")
                .setPoints(new Point[]{
                        new Point("中共党员:" + record[3].getAttribute("a1") + "人", new BigDecimal(BaseHelpUtils.getDoubleValue(record[3].getAttribute("round")) * 100).setScale(2, BigDecimal.ROUND_HALF_UP)),
                        new Point("团员:" + record[4].getAttribute("a1") + "人", new BigDecimal(BaseHelpUtils.getDoubleValue(record[4].getAttribute("round")) * 100).setScale(2, BigDecimal.ROUND_HALF_UP)),
                        new Point("群众:" + record[5].getAttribute("a1") + "人", new BigDecimal(BaseHelpUtils.getDoubleValue(record[5].getAttribute("round")) * 100).setScale(2, BigDecimal.ROUND_HALF_UP)),
                        new Point("其他:" + record[6].getAttribute("a1") + "人", new BigDecimal(BaseHelpUtils.getDoubleValue(record[6].getAttribute("round")) * 100).setScale(2, BigDecimal.ROUND_HALF_UP)),
                })
        );
        chart2.removeAllSeries();
        chart2.addSeries(chart2.createSeries()
                .setName("年龄")
                .setPoints(new Point[]{
                        new Point("0-25岁:" + record[7].getAttribute("a1") + "人", new BigDecimal(BaseHelpUtils.getDoubleValue(record[7].getAttribute("round")) * 100).setScale(2, BigDecimal.ROUND_HALF_UP)),
                        new Point("26-30岁:" + record[8].getAttribute("a1") + "人", new BigDecimal(BaseHelpUtils.getDoubleValue(record[8].getAttribute("round")) * 100).setScale(2, BigDecimal.ROUND_HALF_UP)),
                        new Point("31-40岁:" + record[9].getAttribute("a1") + "人", new BigDecimal(BaseHelpUtils.getDoubleValue(record[9].getAttribute("round")) * 100).setScale(2, BigDecimal.ROUND_HALF_UP)),
                        new Point("51-60岁:" + record[10].getAttribute("a1") + "人", new BigDecimal(BaseHelpUtils.getDoubleValue(record[10].getAttribute("round")) * 100).setScale(2, BigDecimal.ROUND_HALF_UP)),
                        new Point(">60岁:" + record[11].getAttribute("a1") + "人", new BigDecimal(BaseHelpUtils.getDoubleValue(record[11].getAttribute("round")) * 100).setScale(2, BigDecimal.ROUND_HALF_UP)),
                })
        );
        chart3.removeAllSeries();
        chart3.addSeries(chart3.createSeries()
                .setName("工龄")
                .setPoints(new Point[]{
                        new Point("工龄0-4年:" + record[12].getAttribute("a1") + "人", new BigDecimal(BaseHelpUtils.getDoubleValue(record[12].getAttribute("round")) * 100).setScale(2, BigDecimal.ROUND_HALF_UP)),
                        new Point("工龄5-10年:" + record[13].getAttribute("a1") + "人", new BigDecimal(BaseHelpUtils.getDoubleValue(record[13].getAttribute("round")) * 100).setScale(2, BigDecimal.ROUND_HALF_UP)),
                        new Point("工龄11年以上:" + record[14].getAttribute("a1") + "人", new BigDecimal(BaseHelpUtils.getDoubleValue(record[14].getAttribute("round")) * 100).setScale(2, BigDecimal.ROUND_HALF_UP)),
                })
        );
        chart4.removeAllSeries();
        chart4.addSeries(chart4.createSeries()
                .setName("司龄")
                .setPoints(new Point[]{
                        new Point("司龄0-4年:" + record[15].getAttribute("a1") + "人", new BigDecimal(BaseHelpUtils.getDoubleValue(record[15].getAttribute("round")) * 100).setScale(2, BigDecimal.ROUND_HALF_UP)),
                        new Point("司龄5-10年:" + record[16].getAttribute("a1") + "人", new BigDecimal(BaseHelpUtils.getDoubleValue(record[16].getAttribute("round")) * 100).setScale(2, BigDecimal.ROUND_HALF_UP)),
                        new Point("司龄11年以上:" + record[17].getAttribute("a1") + "人", new BigDecimal(BaseHelpUtils.getDoubleValue(record[17].getAttribute("round")) * 100).setScale(2, BigDecimal.ROUND_HALF_UP)),
                })
        );
        chart5.removeAllSeries();
        chart5.addSeries(chart5.createSeries()
                .setName("学历")
                .setPoints(new Point[]{
                        new Point("博士:" + record[18].getAttribute("a1") + "人", new BigDecimal(BaseHelpUtils.getDoubleValue(record[18].getAttribute("round")) * 100).setScale(2, BigDecimal.ROUND_HALF_UP)),
                        new Point("硕士:" + record[19].getAttribute("a1") + "人", new BigDecimal(BaseHelpUtils.getDoubleValue(record[19].getAttribute("round")) * 100).setScale(2, BigDecimal.ROUND_HALF_UP)),
                        new Point("本科:" + record[20].getAttribute("a1") + "人", new BigDecimal(BaseHelpUtils.getDoubleValue(record[20].getAttribute("round")) * 100).setScale(2, BigDecimal.ROUND_HALF_UP)),
                        new Point("大专及其它:" + record[21].getAttribute("a1") + "人", new BigDecimal(BaseHelpUtils.getDoubleValue(record[21].getAttribute("round")) * 100).setScale(2, BigDecimal.ROUND_HALF_UP)),
                })
        );
    }

    public void loadCheckTime() {


    }

    public void chartSet1() {
        SC.debugger();
        Map<String, Object> params = new HashMap<>();
        params.put("startYear", startYearItem.getValue());
        params.put("endYear", endYearItem.getValue());
        DBDataSource.callOperation("NQ_EmployeeStructureOverview2", "find", params, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                    SC.debugger();
                    Record[] record = dsResponse.getData();
                    String[] strings = new String[record.length];
                    Number[] numbers = new Number[record.length];
                    int i = 0;
                    for (Record e : record) {
                        strings[i] = e.getAttribute("year")+"年 占比"+e.getAttribute("percent")+"%";
                        numbers[i] = BaseHelpUtils.getIntValue(e.getAttribute("empNum"));
                        i++;
                    }
                    XAxis xAxis = chart7.getXAxis();
                    xAxis.setCategories(strings);
                    YAxis yAxis = chart7.getYAxis();
                    yAxis.setAxisTitleText("人数");
                    yAxis.createPlotLine()
                            .setValue(0)
                            .setWidth(1)
                            .setColor("#808080");
//                    chart7.setToolTip(new ToolTip()
//                            .setValueSuffix("人数")
//                            .setFormatter(new ToolTipFormatter() {
//                                @Override
//                                public String format(ToolTipData toolTipData) {
//                                    String percentage = new BigDecimal(toolTipData.getYAsDouble()).divide(new BigDecimal(total)).setScale(2).toString();
//                                    return toolTipData.getXAsString() + ": " + toolTipData.getYAsDouble() + " 人 " + percentage + " % ";
//                                }
//                            }));
                    chart7.removeAllSeries();
                    chart7.addSeries(chart7.createSeries()
                            .setName("应届生")
                            .setPoints(numbers)
                    );
                }
            }
        });
    }

    public void chartSet() {
        Map<String, Object> params = new HashMap<>();
        DBDataSource.callOperation("NQ_EmployeeStructureOverview1", "find", params, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                    Record[] record = dsResponse.getData();
                    String[] strings = new String[record.length];
                    Number[] numbers = new Number[record.length];
                    int i = 0;
                    SC.debugger();
                    for (Record e : record) {
                        if (!BaseHelpUtils.isNullOrEmpty(e.getAttribute("a"))) {
                            strings[i] = e.getAttribute("b");
                            numbers[i] = BaseHelpUtils.getDoubleValue(e.getAttribute("a1"));
                            i++;
                        }
                    }
                    chart6.getXAxis()
                            .setCategories(strings);
                    chart6.getYAxis()
                            .setAxisTitle(new AxisTitle()
                                    .setText("人数")
                                    .setAlign(AxisTitle.Align.HIGH)
                            );
//                    chart6.setToolTip(new ToolTip()
//                            .setFormatter(new ToolTipFormatter() {
//                                @Override
//                                public String format(ToolTipData toolTipData) {
//                                    SC.debugger();
//                                    String percentage = new BigDecimal(toolTipData.getYAsDouble()).divide(new BigDecimal(total)).setScale(2).toString();
//                                    return toolTipData.getXAsString() + ": " + toolTipData.getYAsDouble() + " 人 " + percentage + " % ";
//                                }
//                            }));
                    chart6.addSeries(chart6.createSeries()
                            .setName("各职级人数")
                            .setPoints(numbers)
                    );
                }
            }
        });
    }

    @Override
    public void setValueManage(ValuesManager manager) {
        manager.setDataSource(DSEmployeeStructureOverview.getInstance());
        manager.addMember(__form);
    }

    @Override
    public boolean checkData() {
        return true;
    }

    @Override
    public Map getValuesAsMap() {
        return null;
    }


}
