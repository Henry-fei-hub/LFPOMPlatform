package com.pomplatform.client.workflow.form;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.common.SyncDataUtil;
import com.pomplatform.client.workflow.personnel.form.ApplicationForFilingUpdateForm;
import com.pomplatform.client.workflow.personnel.form.ApplicationInForFilingViewer;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileDetailsForm extends VLayout {

    private VLayout mainLayout; //主面板
    private HLayout tupperLayerLayout; //顶层面板

    private VLayout invoiceLayout;//调档信息面板
    private VLayout operatingLayout;//右边的操作栏


    private ListGridField employeeIdField;//员工ID
    private ListGridField employeeNoField;//员工编号
    private ListGridField employeeNameField;//员工姓名
    private ListGridField onboardDateField;//员工入职时间
    private ListGridField statusField;//员工状态
    private ListGridField departmentIdField;//所属部门
    private ListGridField birthField;//出生日期
    private ListGridField ageField;//年龄
    private ListGridField startWorkDateField;//参加工作时间

    private VLayout buttonLayout;//调档查看详情的面板

    private final IButton viewButton = new IButton("查看档案信息");

    private final DelicacyListGrid paybackGrid = new DelicacyListGrid();//调档信息grid

    public void initComponents() {
        setWidth100();
        setHeight100();
        //主面板
        mainLayout = new VLayout();
        mainLayout.setWidth100();
        mainLayout.setHeight100();
        addMember(mainLayout);

        tupperLayerLayout = new HLayout();
        tupperLayerLayout.setLayoutTopMargin(20);
        tupperLayerLayout.setWidth("100%");
        tupperLayerLayout.setHeight("100%");
        mainLayout.addMember(tupperLayerLayout);





        employeeIdField = new ListGridField("employeeId", "员工编码");
        employeeIdField.setWidth("*");
        employeeIdField.setHidden(true);
        KeyValueManager.loadValueMap("employees", employeeIdField);

        employeeNoField = new ListGridField("employeeNo", "员工编号");
        employeeNoField.setWidth("*");
        employeeNoField.setHidden(false);


        employeeNameField = new ListGridField("employeeName", "员工姓名");
        employeeNameField.setWidth("*");
        employeeNameField.setHidden(false);


        departmentIdField = new ListGridField("departmentId", "部门");
        departmentIdField.setWidth("*");
        departmentIdField.setHidden(false);
        departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));

        onboardDateField = new ListGridField("onboardDate", "入职日期");
        onboardDateField.setWidth("*");
        onboardDateField.setHidden(false);

        birthField = new ListGridField("birth", "出生日期");
        birthField.setWidth("*");
        birthField.setHidden(false);


        ageField = new ListGridField("age", "年龄");
        ageField.setWidth("*");
        ageField.setHidden(false);

        startWorkDateField = new ListGridField("startWorkDate", "参加工作时间");
        startWorkDateField.setWidth("*");
        startWorkDateField.setHidden(false);


        statusField = new ListGridField("status", "状态");
        statusField.setHidden(false);
        statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_11"));

        paybackGrid.setFields(employeeIdField, employeeNoField, employeeNameField, departmentIdField, onboardDateField, statusField,birthField,ageField,startWorkDateField);




        invoiceLayout = new VLayout();
        invoiceLayout.setWidth("90%");
        invoiceLayout.setHeight("100%");
        tupperLayerLayout.addMember(invoiceLayout);
        invoiceLayout.addMember(paybackGrid);


        //设置行号
        paybackGrid.setShowGridSummary(true);
        paybackGrid.setCanSelectText(true);
        paybackGrid.setAutoFitFieldWidths(false);


        buttonLayout = new VLayout();
        buttonLayout.setWidth("10%");
        buttonLayout.setLayoutLeftMargin(15);
        tupperLayerLayout.addMember(buttonLayout);


        buttonLayout.addMember(viewButton);


        viewButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                showDetail();
            }
        });

        paybackGrid.addDoubleClickHandler(new DoubleClickHandler() {
            @Override
            public void onDoubleClick(DoubleClickEvent event) {
                showDetail();
            }
        });

    }

    public void showDetail() {
        GWT.runAsync(new RunAsyncCallback() {
            @Override
            public void onFailure(Throwable reason) {
                SC.say("failure to download code");
            }
            @Override
            public void onSuccess() {
                HashMap<String, Object> params = new HashMap<>();
                ListGridRecord selected1 = paybackGrid.getSelectedRecord();
                if(!paybackGrid.anySelected()){ SC.say("请选择一条数据"); return;}
                PopupWindow popupWindow = new PopupWindow();
                ApplicationForFilingUpdateForm detailForm = new ApplicationForFilingUpdateForm();
                popupWindow.setTitle("查看员工档案明细");
                popupWindow.addMember(detailForm);
                popupWindow.setWidth("80%");
                popupWindow.setHeight("80%");
                popupWindow.centerInPage();
                detailForm.reloadData(selected1.getAttributeAsInt("employeeId"));
                popupWindow.show();
            }
        });
    }

    /**
     * 初始化差查询的数据
     */
    public void initGrid(int employeeId) {

        HashMap<Object, Object> params = new HashMap<>();
        params.put("optType","FileDetails");
        params.put("employeeId", employeeId);
        DBDataSource.callOperation("EP_FileDetailsProcess","find", params, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                    Record[] data = dsResponse.getData();
                    SC.debugger();
                    paybackGrid.setData(dsResponse.getData());
                } else {
                    SC.say("调档数据加载失败!");
                }
            }
        });
    }
}