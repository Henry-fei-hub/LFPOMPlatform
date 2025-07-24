package com.pomplatform.client.receivables.form;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.receivables.panel.EmployeeSelectPanel;
import com.pomplatform.client.receivables.panel.InvoiceReportPanel;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class InvoiceReportDetailForm extends VLayout {

    private static final Logger __logger = Logger.getLogger("");
    private final DynamicForm searchForm = new DynamicForm();
//    private final IButton searchButton = new IButton("更改项目经理");
    private final IButton saveButton = new IButton("保存数据");
    private final IButton exportButton = new IButton("导出数据");
    private final IButton searchButton = new IButton("搜索");
    private final IButton changeButton = new IButton("更改项目经理");
    private static  final long MONTHTIME = 30 * 24 * 60 * 60 * 1000l;
    private final DelicacyListGrid invoiceGrid = new DelicacyListGrid() {
        @Override
        protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
            //获取本次确认积分
            int isCapital = BaseHelpUtils.getIntValue(record.getAttribute("isCapital"));
            if (isCapital == 2) {
                return "color: blue;";
            }
            else if (isCapital == 1){
                return "color: green;";
            }
            else if (isCapital == 3){
                return "color: red;";
            }
            else {
                return super.getCellCSSText(record, rowNum, colNum);
            }
        }
    };//发票grid

    public InvoiceReportPanel getParentPanel() {
        return parentPanel;
    }

    public void setParentPanel(InvoiceReportPanel parentPanel) {
        this.parentPanel = parentPanel;
    }

    private InvoiceReportPanel parentPanel;

    //主面板
    private VLayout mainLayout;
    //顶层面板
    private HLayout tupperLayerLayout;
    //底层面板
    private HLayout LowerLevelLayout;
    //更换项目经理的输入框
    private ComboBoxItem projectManagerIdItem;
    //临时保存invoiceId
    private TextItem temporaryItem;
    //搜索输入框的面板
    private HLayout searchLayout;
    //左边的数据栏
    private HLayout leftLayout;
    //右边的操作栏
    private VLayout rightLayout;

    private ListGridField contractCodeField;//合同编码
    private ListGridField contractNameField;//合同名称
    private ListGridField contractAmountField;//合同金额
    private ListGridField invoiceIdField;//发票的主键
    private ListGridField invoiceCodeField;//发票代码
    private ListGridField invoiceNumberField;//发票号码
    private ListGridField customerNameField;//客户名称
    private ListGridField reimbursementField;//开票金额
    private ListGridField invoiceTimeField;//开票时间
    private ListGridField repaidField;//已回款金额
    private ListGridField arrearsField;//欠款
    private ListGridField overduePaymentField;//超期欠款

    public void initComponents(Map<String, Object> params){
        SC.debugger();
        setWidth100();
        setHeight100();
        //主面板
        mainLayout = new VLayout();
        mainLayout.setWidth("100%");
        mainLayout.setHeight("100%");
        addMember(mainLayout);
        //顶层面板
        tupperLayerLayout = new HLayout();
        tupperLayerLayout.setLayoutTopMargin(20);
        tupperLayerLayout.setWidth("35%");
        tupperLayerLayout.setHeight("10%");
        mainLayout.addMember(tupperLayerLayout);
        //底层面板
        LowerLevelLayout = new HLayout();
        LowerLevelLayout.setWidth("100%");
        LowerLevelLayout.setHeight("90%");
        LowerLevelLayout.setLayoutMargin(25);
        mainLayout.addMember(LowerLevelLayout);

        leftLayout = new HLayout();
        leftLayout.setWidth("94%");
        leftLayout.setHeight("100%");
        LowerLevelLayout.addMember(leftLayout);

        rightLayout = new VLayout();
        rightLayout.setWidth("6%");
        rightLayout.setHeight("100%");
        rightLayout.setLayoutMargin(10);
        LowerLevelLayout.addMember(rightLayout);

        //搜索输入的面板
        searchLayout = new HLayout();
        searchLayout.setWidth("80%");
        tupperLayerLayout.addMember(searchLayout);

        projectManagerIdItem = new ComboBoxItem("projectManagerId","项目经理");
        projectManagerIdItem.setWidth("*");
        projectManagerIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
        projectManagerIdItem.setValue(BaseHelpUtils.getIntValue(params.get("projectManagerId")));
        projectManagerIdItem.setHidden(false);

        temporaryItem = new TextItem("temporary" , "");
        temporaryItem.setWidth("1");
        temporaryItem.setHidden(true);

        searchForm.setWidth("30%");
        searchForm.setItems(projectManagerIdItem,temporaryItem);
        searchLayout.addMember(searchForm);

        invoiceIdField = new ListGridField("x", "发票主键");
        invoiceIdField.setWidth("*");
        invoiceIdField.setHidden(true);

        contractCodeField = new ListGridField("contractCode", "合同编号");
        contractCodeField.setWidth("*");
        contractCodeField.setHidden(false);

        contractNameField = new ListGridField("contractName", "合同名称");
        contractNameField.setWidth("*");
        contractNameField.setHidden(false);

        invoiceCodeField = new ListGridField("invoiceCode", "发票代码");
        invoiceCodeField.setWidth("*");
        invoiceCodeField.setHidden(false);

        invoiceNumberField = new ListGridField("invoiceNumber", "发票号码");
        invoiceNumberField.setWidth("*");
        invoiceNumberField.setHidden(false);

        customerNameField = new ListGridField("customerId", "客户名称");
        customerNameField.setWidth("*");
        customerNameField.setHidden(false);
		KeyValueManager.loadValueMap("customers", customerNameField);

        contractAmountField = new ListGridField("signingMoneySum", "合同金额");
        contractAmountField.setWidth("*");
        contractAmountField.setHidden(false);

        reimbursementField = new ListGridField("invoiceAmount", "开票金额");
        reimbursementField.setWidth("*");
        reimbursementField.setType(ListGridFieldType.FLOAT);
        reimbursementField.setFormat("###,###,###,###,###,###,###,###,###,##0.00");
        reimbursementField.setHidden(false);

        invoiceTimeField = new ListGridField("invoiceDate", "开票时间");
        invoiceTimeField.setWidth("*");
        invoiceTimeField.setHidden(false);

        repaidField = new ListGridField("capitalAmount", "已回款金额");
        repaidField.setWidth("*");
        repaidField.setType(ListGridFieldType.FLOAT);
        repaidField.setFormat("###,###,###,###,###,###,###,###,###,##0.00");
        repaidField.setHidden(false);

        arrearsField = new ListGridField("arrears", "未回款金额");
        arrearsField.setWidth("*");
        arrearsField.setType(ListGridFieldType.FLOAT);
        arrearsField.setFormat("###,###,###,###,###,###,###,###,###,##0.00");
        arrearsField.setHidden(false);

        overduePaymentField = new ListGridField("overduePayment" , "是否逾期");
        overduePaymentField.setWidth("*");
        overduePaymentField.setHidden(false);
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
        map.put(1,"是");
        map.put(0,"否");
        overduePaymentField.setValueMap(map);
        //设置girld
        invoiceGrid.setFields(invoiceNumberField,invoiceTimeField,invoiceIdField,contractCodeField,contractNameField,contractAmountField,customerNameField,reimbursementField,repaidField,arrearsField,overduePaymentField);
        leftLayout.addMember(invoiceGrid);

        invoiceGrid.setAutoFitFieldWidths(true);
        invoiceGrid.setShowGridSummary(true);
        invoiceGrid.setAutoFitFieldWidths(true);

        //搜索的按钮
        searchButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
               initData();
            }
        });
        searchLayout.addMember(searchButton);
        //改变项目经理
        changeButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                ListGridRecord record = invoiceGrid.getSelectedRecord();
                if (null == record){
                    SC.say("Please select a piece of data!");
                }else{
                    int invoiceId = BaseHelpUtils.getIntValue(record.getAttribute("invoiceId"));
                    temporaryItem.clearValue();
                    temporaryItem.setValue(invoiceId);
                    PopupWindow window = new PopupWindow();
                    window.setWidth("20%");
                    window.setHeight("15%");
                    window.centerInPage();
                    window.setTitle("修改项目经理");
                    EmployeeSelectPanel formEmployeesSelect = new EmployeeSelectPanel();
                    formEmployeesSelect.setRecord(record);
                    formEmployeesSelect.addDataEditedHandler(new DataEditedHandler() {
                        @Override
                        public void onDataEdited(DataEditEvent event) {
                            initData();
                        }
                    });
                    formEmployeesSelect.setParaentWindow((window));
                    window.addMember(formEmployeesSelect);
                    window.show();
                }
            }
        });
        rightLayout.addMember(changeButton);
        rightLayout.addMember(exportButton);
        //添加到出的功能
        exportButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                Map<String, Object> condition = new HashMap<>();
                condition.put("projectManagerId", BaseHelpUtils.getIntValue(projectManagerIdItem.getValue()));
                DBDataSource.downloadFile("DW_InvoiceReportDetail", condition);
            }
        });
        //初始化数据
        initData();

        //添加双击事件展示会回款对应发票的详细的界面
        invoiceGrid.addDoubleClickHandler(new DoubleClickHandler() {
            @Override
            public void onDoubleClick(DoubleClickEvent doubleClickEvent) {
                PopupWindow pWindow = new PopupWindow();
                pWindow.setTitle("回款与发票");
                pWindow.setWidth("60%");
                pWindow.setHeight("60%");
                pWindow.centerInPage();
                PaybackAndInvoiceForm vLaout = new PaybackAndInvoiceForm();
                Record record = invoiceGrid.getSelectedRecord();
                if (!BaseHelpUtils.isNullOrEmpty(record)) {
                    vLaout.initComponents(record.toMap());
                }
                pWindow.addItem(vLaout);
                pWindow.show();
            }
        });
    }

    public void initData(){
        //取出项目经理
        SC.debugger();
        int projectManagerId = BaseHelpUtils.getIntValue(projectManagerIdItem.getValue());
        HashMap<Object, Object> params = new HashMap<>();
        params.put("projectManagerId",projectManagerId);
        //查询发票的数据
        DBDataSource.callOperation("NQ_InvoiceReportDetail", params, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0){
                    //取出当前的时间
                    long currentTime = System.currentTimeMillis();
                    Record[] returnValue = dsResponse.getData();
                    RecordList resultList = new RecordList();
                    if (null != returnValue && returnValue.length != 0){
                        //循环遍历所有的数据，计算欠款金额以及超期欠款纪额
                        for (Record record : returnValue){
                            //开票的金额
                            BigDecimal invoiceAmount = BaseHelpUtils.getBigDecimalValue(record.getAttribute("invoiceAmount"));
                            //已回款的金额
                            BigDecimal capitalAmount = BaseHelpUtils.getBigDecimalValue(record.getAttribute("capitalAmount"));
                            //发票的开票时间
                            Date invoiceDate = record.getAttributeAsDate("invoiceDate");
                            if (null != invoiceDate){
                                long time = invoiceDate.getTime();
                                //间隔的时间
                                long intervals = currentTime - time;
                                //开票的时间间隔大于30天的
                                if (intervals > MONTHTIME){
                                    //设置逾期的状态
                                    record.setAttribute("overduePayment",1);
                                }else{
                                    //设置没有逾期的状态
                                    record.setAttribute("overduePayment",0);
                                }
                            }
                            //计算未回款的金额
                            BigDecimal arrears = invoiceAmount.subtract(capitalAmount);
                            record.setAttribute("arrears" , arrears);
                            resultList.add(record);
                        }
                    }
                    invoiceGrid.setData(resultList);
                    invoiceGrid.redraw();
                }else{
                    SC.say("发票数据加载失败!");
                }
            }
        });
    }
}
