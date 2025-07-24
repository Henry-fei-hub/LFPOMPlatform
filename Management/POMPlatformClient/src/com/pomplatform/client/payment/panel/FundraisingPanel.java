package com.pomplatform.client.payment.panel;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.payment.datasource.DSEmployeeSalaryType;
import com.pomplatform.client.payment.datasource.DSOnboardEmployee;
import com.pomplatform.client.payment.form.FundraisingSearchForm;
import com.smartgwt.client.data.*;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.TransferImgButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @Author: liubin
 * @Description: 募投项目页面
 * @Date: 12:18 2019/4/18
 */
public class FundraisingPanel extends VLayout {

    private static final Logger __logger = Logger.getLogger("");
    private final DelicacyListGrid employeeGrid = new DelicacyListGrid();
    private final DelicacyListGrid fundraisingGrid = new DelicacyListGrid();
    private final FundraisingSearchForm __searchForm = new FundraisingSearchForm();

    private final IButton searchButton = new IButton("搜索");
    private final IButton resetButton = new IButton("重置");
    private final IButton saveButton = new IButton("保存");

    private VLayout mainLayout;
    private HLayout topLayout;
    private HLayout centerLayout;
    private VLayout bttomLayout;

    private VLayout employeeGridLayout;
    private VLayout controlLayout;
    private VLayout fundraisingFridLayout;

    private HLayout searchFormLayout;
    private HLayout buttonLayout;

    private ListGridField employeeIdField;
    private ListGridField employeeNameField;
    private ListGridField employeeNoField;
    private ListGridField plateNameField;
    private ListGridField yearField;
    private ListGridField monthField;
    private ListGridField fundraisingProjectTypeField;
    private ListGridField fundraisingProjectRateField;

    public void initComponents() {
        setWidth100();
        setHeight100();

        //主界面
        mainLayout = new VLayout();
        mainLayout.setWidth100();
        mainLayout.setHeight100();
        addMember(mainLayout);

        //顶层的搜索界面
        topLayout = new HLayout();
        topLayout.setWidth("100%");
        topLayout.setHeight("5%");
        mainLayout.addMember(topLayout);

        //searchForm的界面
        searchFormLayout = new HLayout();
        searchFormLayout.setWidth("50%");
        searchFormLayout.setHeight100();
        topLayout.addMember(searchFormLayout);
        ClientUtil.searchFormProcessAccordingToDevice(__searchForm);
        searchFormLayout.addMember(__searchForm);

        //按钮的界面
        buttonLayout = new HLayout();
        buttonLayout.setWidth("10%");
        buttonLayout.setHeight100();
        buttonLayout.setAlign(Alignment.CENTER);
        buttonLayout.setLayoutTopMargin(20);
        buttonLayout.setLayoutLeftMargin(10);
        topLayout.addMember(buttonLayout);
        buttonLayout.addMember(searchButton);
        buttonLayout.addMember(resetButton);
        resetButton.setLeft(5);
        buttonLayout.setAlign(Alignment.CENTER);

        //中间放grid的界面
        centerLayout = new HLayout();
        centerLayout.setWidth("100%");
        centerLayout.setHeight("85%");
        mainLayout.addMember(centerLayout);

        //底层放按钮的界面
        bttomLayout = new VLayout();
        bttomLayout.setWidth("10%");
        bttomLayout.setHeight("10%");
        bttomLayout.setLayoutLeftMargin(1000);
        mainLayout.addMember(bttomLayout);

        employeeGridLayout = new VLayout();
        employeeGridLayout.setWidth("45%");
        employeeGridLayout.setHeight100();
        centerLayout.addMember(employeeGridLayout);
        employeeGridLayout.addMember(employeeGrid);

        employeeGrid.setSelectionType(SelectionStyle.MULTIPLE);
        employeeGrid.setSelectionType(SelectionStyle.MULTIPLE);
        employeeGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
        employeeGrid.setDataSource(DSOnboardEmployee.getInstance());

        controlLayout = new VLayout();
        controlLayout.setWidth("5%");
        controlLayout.setHeight100();
        controlLayout.setLayoutRightMargin(20);
        centerLayout.addMember(controlLayout);
        TransferImgButton AddToButton = new TransferImgButton(TransferImgButton.RIGHT);
        AddToButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (!employeeGrid.anySelected()) {
                    SC.say("请选择团队成员");
                }
                addSelectdDataToTarget(employeeGrid, fundraisingGrid);
            }
        });
        centerLayout.addMember(AddToButton);

        fundraisingFridLayout = new VLayout();
        fundraisingFridLayout.setWidth("50%");
        fundraisingFridLayout.setHeight100();
        centerLayout.addMember(fundraisingFridLayout);

        employeeIdField = new ListGridField("employeeId" , "员工姓名");
        employeeIdField.setRequired(true);
        employeeIdField.setHidden(false);
        employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

        employeeNameField = new ListGridField("employeeName","员工姓名");
        employeeNameField.setRequired(true);
        employeeNameField.setHidden(true);

        employeeNoField = new ListGridField("employeeNo" , "员工工号");
        employeeNoField.setRequired(true);
        employeeNoField.setHidden(false);

        plateNameField = new ListGridField("plateId" , "业务部门");
        plateNameField.setRequired(true);
        plateNameField.setHidden(false);

        yearField = new ListGridField("year" , "年份");
        yearField.setRequired(true);
        yearField.setHidden(false);
        yearField.setCanEdit(true);

        monthField = new ListGridField("month" , "月份");
        monthField.setRequired(true);
        monthField.setHidden(false);
        monthField.setCanEdit(true);

        fundraisingProjectTypeField = new ListGridField("fundraisingProjectType" , "募投项目类型");
        fundraisingProjectTypeField.setRequired(false);
        fundraisingProjectTypeField.setHidden(false);
        fundraisingProjectTypeField.setCanEdit(true);
        fundraisingProjectTypeField.setValueMap(KeyValueManager.getValueMap("fundraising_project_types"));

        fundraisingProjectRateField = new ListGridField("fundraisingProjectRate", "募投比列");
        fundraisingProjectRateField.setRequired(true);
        fundraisingProjectRateField.setHidden(false);
        fundraisingProjectRateField.setCanEdit(true);

        fundraisingGrid.setCanReorderRecords(true);
        fundraisingGrid.setAutoFitFieldWidths(true);
        fundraisingGrid.setShowGridSummary(false);
        fundraisingGrid.setShowRowNumbers(true);
        fundraisingGrid.setCanRemoveRecords(true);
        fundraisingGrid.setDataSource(DSEmployeeSalaryType.getInstance());
        fundraisingGrid.setFields(employeeIdField , employeeNameField , employeeNoField , plateNameField , yearField , monthField,  fundraisingProjectTypeField , fundraisingProjectRateField);

        fundraisingFridLayout.addMember(fundraisingGrid);

        //搜索按钮
        searchButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                Map values = __searchForm.getValues();
                initEmployees(employeeGrid, values);
            }
        });

        //重置按钮
        resetButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                __searchForm.editNewRecord();
            }
        });

        //保存按钮
        saveButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                ListGridRecord[] records = fundraisingGrid.getRecords();
                List<Map<String, Object>> list = new ArrayList<>();
                HashMap<String, Object> params = new HashMap<>();
                for (ListGridRecord listGridRecord : records) {
                    HashMap<String, Object> map = new HashMap<>();
                    map.put("employeeId", listGridRecord.getAttribute("employeeId"));
                    map.put("employeeName", listGridRecord.getAttribute("employeeName"));
                    map.put("employeeNo", listGridRecord.getAttribute("employeeNo"));
                    map.put("plateId", listGridRecord.getAttribute("plateId"));
                    map.put("year", listGridRecord.getAttribute("year"));
                    map.put("month", listGridRecord.getAttribute("month"));
                    map.put("fundraisingProjectType", listGridRecord.getAttribute("fundraisingProjectType"));
                    map.put("fundraisingProjectRate", listGridRecord.getAttribute("fundraisingProjectType"));
                    list.add(map);
                }
                params.put("optType", "saveEmployeeSalaryTypes");
                params.put("list", list);
                DBDataSource.callOperation("EP_EmployeeSalaryType",params,new DSCallback() {
                    @Override
                    public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
                        if (dsResponse.getStatus() >= 0) {
                            SC.say("保存成功");
                        } else {
                            SC.say("保存失败");
                        }
                    }
                }) ;
            }
        });
        bttomLayout.addMember(saveButton);
        bttomLayout.setAlign(Alignment.CENTER);
        saveButton.setAlign(Alignment.CENTER);

        initEmployees(employeeGrid , null);
    }

    /**
     * @Author: liubin
     * @Description:选中数据到右边的表格
     * @Date: 17:23 2019/4/18
     */
    private void addSelectdDataToTarget(DelicacyListGrid employeeGrid, DelicacyListGrid fundraisingGrid) {
        ListGridRecord[] selectedRecords = employeeGrid.getSelectedRecords();
        RecordList fundraisingList = fundraisingGrid.getDataAsRecordList();
        for (ListGridRecord selectRecod : selectedRecords) {
            HashMap map = new HashMap();
            map.put("employeeId", selectRecod.getAttribute("employeeId"));
            map.put("employeeName", selectRecod.getAttribute("employeeName"));
            map.put("employeeNo", selectRecod.getAttribute("employeeNo"));
            map.put("plateId", selectRecod.getAttribute("plateId"));
            fundraisingList.add(new Record(map));
        }
        fundraisingGrid.setData(fundraisingList);
    }

    /**
     * @Author: liubin
     * @Description:初始化员工的数据
     * @Date: 16:13 2019/4/18
     */
    private void initEmployees(DelicacyListGrid employeeGrid , Map params) {
        SC.debugger();
        if (null !=params){
            if (!BaseHelpUtils.isNullOrEmpty(params.get("employeeId"))) {
                params.put("employeeId", BaseHelpUtils.getIntValue(params.get("employeeId")));
            }
            if (!BaseHelpUtils.isNullOrEmpty(params.get("palteId"))) {
                params.put("plateId", BaseHelpUtils.getIntValue(params.get("plateId")));
            }
            if (!BaseHelpUtils.isNullOrEmpty(params.get("startDate"))) {
                params.put("startDate", params.get("satrtDate"));
            }
            if (!BaseHelpUtils.isNullOrEmpty(params.get("endDate"))) {
                params.put("endDate", params.get("endDate"));
            }
        }else {
            params = new HashMap();
        }
        DBDataSource.callOperation("NQ_OnboardEmployee", "find", params, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                    employeeGrid.setData(dsResponse.getData());
                }
            }
        });
    }


}
