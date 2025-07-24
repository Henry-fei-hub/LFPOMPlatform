package com.pomplatform.client.payment.panel;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.LoadingWindow;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @Author: liubin
 * @Description:动态页面加载
 * @Date: 15:32 2019/4/19
 */
public class DynamicPagesPanel extends VLayout {

    private static final Logger __logger = Logger.getLogger("");
    private int counts = 0;
    private int rows = 0;
    private int remainder = 0;
    private List<Integer> list = new ArrayList<>();
    private VLayout mainLayout;
    private String heightRatio = "";
    private String widthRatio = "";
    private Record record;
    protected final HandlerManager handlerManager = new HandlerManager(this);

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    private List<SalaryCommonPanel> panels = new ArrayList<>();

    /**
     * 定义每行放三列的数据
     */
    private int columns = 3;

    public void initComponents() {
        int temp = 0;

        setWidth100();
        setHeight100();
        //主界面
        mainLayout = new VLayout();
        mainLayout.setWidth100();
        mainLayout.setHeight("100%");
        addMember(mainLayout);

        HLayout saveLayout = new HLayout();
        saveLayout.setWidth100();
        saveLayout.setHeight(40);
        saveLayout.setLayoutAlign(Alignment.CENTER);
        saveLayout.setAlign(Alignment.CENTER);
        saveLayout.setLayoutTopMargin(40);
        addMember(saveLayout);

//        ToolStrip btnLayout = new ToolStrip();
//        btnLayout.setLayoutTopMargin(5);
//        btnLayout.setHeight(35);
//        btnLayout.setWidth100();
//        btnLayout.addFill();
//        btnLayout.addSpacer(10);
//        addMember(btnLayout);

        //外层循环(初始化列数)
        for (int i = 0; i < rows; i++) {
            HLayout hLayout = new HLayout();
            hLayout.setWidth("100%");
            if (rows == 1) {
                hLayout.setHeight100();
            } else {
                hLayout.setHeight(heightRatio);
            }
            mainLayout.addMember(hLayout);
            //不是最后一行时每一行创建三个layout
            if (i != rows - 1) {
                for (int j = 0; j < 3; j++) {
                    HashMap<String, Object> map = new HashMap<>();
                    map.put("year", record.getAttribute("year"));
                    map.put("month", record.getAttribute("month"));
                    map.put("companyId", record.getAttribute("companyId"));
                    map.put("personnelBusinessId", record.getAttribute("personnelBusinessId"));
                    map.put("fundraisingProjectType", list.get(temp));
                    VLayout vLayout = new VLayout();
                    vLayout.setWidth("33%");
                    vLayout.setHeight("100%");
                    hLayout.addMember(vLayout);
                    SalaryCommonPanel commonPanel = new SalaryCommonPanel(map);
                    String title =  KeyValueManager.getValue("fundraising_project_types", list.get(temp).toString());
                    if(BaseHelpUtils.isNullOrEmpty(title)){
                        title = "正常资金发放";
                    }
                    commonPanel.setGroupTitle(title);
                    panels.add(commonPanel);
                    commonPanel.commonQuery();
                    vLayout.addMember(commonPanel);
                    temp++;
                }
            }
            //最后一行创建的layout为余数
            else {
                if (remainder == 0) {
                    for (int j = 0; j < 3; j++) {
                        HashMap<String, Object> map = new HashMap<>();
                        map.put("year", record.getAttribute("year"));
                        map.put("month", record.getAttribute("month"));
                        map.put("companyId", record.getAttribute("companyId"));
                        map.put("personnelBusinessId", record.getAttribute("personnelBusinessId"));
                        map.put("fundraisingProjectType", list.get(temp));
                        __logger.info("--------------------------" + list.get(temp));
                        VLayout vLayout = new VLayout();
                        vLayout.setWidth(widthRatio);
                        vLayout.setHeight("100%");
                        hLayout.addMember(vLayout);
                        SalaryCommonPanel commonPanel = new SalaryCommonPanel(map);
                        String title =  KeyValueManager.getValue("fundraising_project_types", list.get(temp).toString());
                        if(BaseHelpUtils.isNullOrEmpty(title)){
                            title = "正常资金发放";
                        }
                        commonPanel.setGroupTitle(title);
                        panels.add(commonPanel);
                        commonPanel.commonQuery();
                        vLayout.addMember(commonPanel);
                        temp++;
                    }
                } else {
                    for (int j = 0; j < remainder; j++) {
                        HashMap<String, Object> map = new HashMap<>();
                        map.put("year", record.getAttribute("year"));
                        map.put("month", record.getAttribute("month"));
                        map.put("companyId", record.getAttribute("companyId"));
                        map.put("personnelBusinessId", record.getAttribute("personnelBusinessId"));
                        map.put("fundraisingProjectType", list.get(temp));
                        VLayout vLayout = new VLayout();
                        vLayout.setWidth(widthRatio);
                        vLayout.setHeight("100%");
                        hLayout.addMember(vLayout);
                        SalaryCommonPanel commonPanel = new SalaryCommonPanel(map);
                        String title =  KeyValueManager.getValue("fundraising_project_types", list.get(temp).toString());
                        if(BaseHelpUtils.isNullOrEmpty(title)){
                            title = "正常资金发放";
                        }
                        commonPanel.setGroupTitle(title);
                        panels.add(commonPanel);
                        vLayout.addMember(commonPanel);
                        commonPanel.commonQuery();
                        temp++;
                    }
                }

            }
        }

        //保存按钮
        IButton saveButton = new IButton("保存");
        saveLayout.addMember(saveButton);
        saveButton.setValign(VerticalAlignment.CENTER);
        saveButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                final LoadingWindow loading = new LoadingWindow();
                if (null != panels) {
                    HashMap<String, Object> params = new HashMap<>();
                    params.put("optType", "saveData");
                    //装载所有页面的数据
                    for (int i = 0; i < panels.size(); i++) {
                        SalaryCommonPanel commonPanel = panels.get(i);
                        List<Map> recordList = commonPanel.getValues();
                        params.put("temp" + i, recordList);
                        params.put("size", panels.size());
                    }
                    DBDataSource.callOperation("EP_EmployeeSalaryType", params, new DSCallback() {
                        @Override
                        public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
                            if (dsResponse.getStatus() >= 0) {
                                SC.say("保存成功");
                                loading.destroy();
                                DataEditEvent dee = new DataEditEvent();
                                fireEvent(dee);
                            }
                        }
                    });
                }
            }
        });

    }

    @Override
    public void fireEvent(GwtEvent<?> event) {
        handlerManager.fireEvent(event);
    }

    public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
        return handlerManager.addHandler(DataEditEvent.TYPE, handler);
    }

    /**
     * @Author: liubin
     * @Description :动态计算layout的高度的占比
     * @Date: 10:16 2019/4/20
     */
    private void caculateHeightRatio() {
        BigDecimal rate;
        if (rows == 0) {
            rate = new BigDecimal(100);
        } else {
            rate = new BigDecimal(100).divide(new BigDecimal(rows), 2, BigDecimal.ROUND_HALF_DOWN);
        }
        if (remainder == 0) {
            widthRatio = "33%";
        } else {
            BigDecimal temp = new BigDecimal(100).divide(new BigDecimal(remainder), 2, BigDecimal.ROUND_HALF_DOWN);
            widthRatio = widthRatio + temp + "%";
        }
        heightRatio = heightRatio + rate + "%";
    }

    /**
     * @Author: liubin
     * @Description :初始化查询结果集
     * @Date: 8:30 2019/4/20
     */
    private void initializationResult() {
        HashMap<String, Object> params = new HashMap<>();
        params.put("opyType", "initializationResult");

        DBDataSource.callOperation("EP_EmployeeSalaryType", params, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                    Record[] data = dsResponse.getData();
                    for (Record record : data) {
                        list.add(BaseHelpUtils.getIntValue(record.getAttribute("fundraisingProjectTypeId")));
                    }
                }
            }
        });
    }

    /**
     * @Author: liubin
     * @Description : 初始化查询募投项目的个数
     * @Date: 15:34 2019/4/19
     */
    public void initializationCalculation() {
        HashMap<String, Object> params = new HashMap<>();
        Record record = getRecord();
        if (null != record.getAttribute("year")) {
            params.put("year", record.getAttribute("year"));
        }
        if (null != record.getAttribute("month")) {
            params.put("month", record.getAttribute("month"));
        }
        if (null != record.getAttribute("companyId")) {
            params.put("companyId", record.getAttribute("companyId"));
        }
        params.put("optType", "inquireFundraisingProjectType");
        DBDataSource.callOperation("EP_EmployeeSalaryType", params, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                    SC.debugger();
                    Record[] data = dsResponse.getData();
                    for (Record record : data) {
                        list.add(BaseHelpUtils.getIntValue(record.getAttribute("fundraisingProjectType")));
                    }
                    counts = BaseHelpUtils.getIntValue(dsResponse.getStatus());
                    //计算行数
                    rows = (counts) / columns;
                    __logger.info("+++++++++++++++++" + "rows" + "===============" + rows);
                    //        //计算余数
                    remainder = (counts) % columns;
                    __logger.info("+++++++++++++++++" + "remainder" + "===============" + remainder);
                    //有余数的话就增加一列
                    if (remainder > 0) {
                        rows = rows + 1;
                    }
                    //计算外层的Layout的高度占比以及最后一行的宽度占比
                    caculateHeightRatio();
                    __logger.info("+++++++++++++++++" + "rows" + "===============" + rows);
                    __logger.info("+++++++++++++++++" + "widthRatio" + "===============" + widthRatio);
                    __logger.info("+++++++++++++++++" + "heightRatio" + "===============" + heightRatio);
                    initComponents();

                }
            }
        });
    }


}
