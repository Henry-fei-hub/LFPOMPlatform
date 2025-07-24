package com.pomplatform.client.applyfunctions.form;

import java.math.BigDecimal;
import java.util.*;
import java.util.logging.Logger;

import com.pomplatform.client.applyfunctions.panel.MyPremissionApplyPanel;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.applyfunctions.datasource.DSApplyFunctions;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class ApplyFunctionsNewForm extends AbstractWizadPage {
    private final TextItem employeeIdItem;
    private final TextItem employeeNoItem;
    private final TextItem departmentIdItem;
    private final TextItem companyIdItem;
    private final DateItem startDateItem;
    private final DateItem endDateItem;
    private final IntegerItem daysItem;
    private final TextAreaItem reasonItem;
    private final SelectItem parentIdItem;
    private SelectItem isForeverItem;

    private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
    private static Logger __logger = Logger.getLogger("");


    MyPremissionApplyPanel premissionApplyPanel = new MyPremissionApplyPanel();

    public ApplyFunctionsNewForm() {

        VLayout mainLayout = new VLayout();

        DSApplyFunctions ds = DSApplyFunctions.getInstance();
        __form.setWidth100();
        __form.setHeight100();
        employeeIdItem = new TextItem("employeeId", "申请人");
        employeeIdItem.setWidth("*");
        employeeIdItem.setDisabled(true);
        employeeIdItem.setTextBoxStyle("customInputTextStyle");
        KeyValueManager.loadValueMap("employees", employeeIdItem);
        __formItems.add(employeeIdItem);


        employeeNoItem = new TextItem("employeeNo", "工号");
        employeeNoItem.setWidth("*");
        employeeNoItem.setDisabled(true);
        employeeNoItem.setTextBoxStyle("customInputTextStyle");
        __formItems.add(employeeNoItem);


        departmentIdItem = new TextItem("departmentId", "部门");
        departmentIdItem.setWidth("*");
        departmentIdItem.setDisabled(true);
        departmentIdItem.setTextBoxStyle("customInputTextStyle");
        KeyValueManager.loadValueMap("departments", departmentIdItem);
        __formItems.add(departmentIdItem);


        Map checkMap = new HashMap<Integer, String>();
        checkMap.put(0, "是");
        checkMap.put(1, "否");
        isForeverItem = new SelectItem("isForever", "是否永久有效");
        isForeverItem.setWidth("*");
        isForeverItem.setDefaultValue(0);
        isForeverItem.setValueMap(checkMap);
        isForeverItem.addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent changedEvent) {
                Integer value = BaseHelpUtils.getIntValue(changedEvent.getValue());
                if (value == 0) {
                    endDateItem.hide();
                    daysItem.hide();
                    endDateItem.clearValue();
                    daysItem.clearValue();
                } else {
                    endDateItem.show();
                    daysItem.show();
                }
            }
        });
        __formItems.add(isForeverItem);

        companyIdItem = new TextItem("companyId", "归属公司");
        companyIdItem.setWidth("*");
        companyIdItem.setDisabled(true);
        companyIdItem.setTextBoxStyle("customInputTextStyle");
        KeyValueManager.loadValueMap("company_records", companyIdItem);
        __formItems.add(companyIdItem);

        startDateItem = new DateItem("startDate", "申请日期");
        startDateItem.setWidth("*");
        startDateItem.setDisabled(true);
        startDateItem.setUseTextField(true);
        startDateItem.setDefaultValue(new Date());
        startDateItem.setUseMask(true);
        startDateItem.setTextBoxStyle("customInputTextStyle");
        __formItems.add(startDateItem);

        endDateItem = new DateItem("endDate", shouldNotBeNull + "结束时间");
        endDateItem.setWidth("*");
        endDateItem.setUseTextField(true);
        endDateItem.setUseMask(true);
        endDateItem.setTextBoxStyle("customInputTextStyle");
        endDateItem.setRequired(true);
        endDateItem.setHidden(true);
        endDateItem.addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent event) {
                if (null != event.getValue() && null != startDateItem.getValue()) {
                    Map<String, Object> params = getValuesAsMap();
                    params.put("optType", "calculaDate");
                    params.put("endDate", event.getValue());
                    params.put("startDate", startDateItem.getValue());
                    DBDataSource.callOperation("EP_ReckonRevenueCapitals", params, new DSCallback() {

                        @Override
                        public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                            if (dsResponse.getStatus() >= 0) {
                                Record records = dsResponse.getData()[0];
                                BigDecimal days = BaseHelpUtils.getBigDecimalValue(records.getAttribute("days"));
                                daysItem.setValue(days);
                            } else {
                                ClientUtil.displayErrorMessage(dsResponse);
                            }

                        }
                    });
                }
            }
        });
        __formItems.add(endDateItem);


        daysItem = new IntegerItem("days", shouldNotBeNull + "使用天数");
        daysItem.setWidth("*");
        daysItem.setRequired(true);
        daysItem.setValidateOnExit(true);
        daysItem.setTextBoxStyle("customInputTextStyle");
        daysItem.setStartRow(false);
        daysItem.setHidden(true);
        daysItem.addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent event) {
                if (null != event.getValue() && null != startDateItem.getValue()) {
                    int days = BaseHelpUtils.getIntValue(event.getValue());
                    Map<String, Object> params = getValuesAsMap();
                    params.put("optType", "DayByDate");
                    params.put("days", days);
                    params.put("startDate", startDateItem.getValue());
                    DBDataSource.callOperation("EP_ReckonRevenueCapitals", params, new DSCallback() {

                        @Override
                        public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                            if (dsResponse.getStatus() >= 0) {
                                Record records = dsResponse.getData()[0];
                                Date endDate = records.getAttributeAsDate("endDate");
                                endDateItem.setValue(endDate);
                            } else {
                                ClientUtil.displayErrorMessage(dsResponse);
                            }

                        }
                    });
                }
            }
        });

        __formItems.add(daysItem);

        LinkedHashMap<Integer, String> linkMap = new LinkedHashMap<>();
        linkMap.put(1, "Erp权限");
        linkMap.put(2, "cwd权限");

        parentIdItem = new SelectItem("parentId", "权限类型");
        parentIdItem.setWidth("*");
        parentIdItem.setRequired(true);
        parentIdItem.setValueMap(linkMap);
        parentIdItem.setDefaultValue(1);
        parentIdItem.setDisabled(true);
        parentIdItem.setTextBoxStyle("customInputTextStyle");
        __formItems.add(parentIdItem);

        reasonItem = new TextAreaItem("reason", shouldNotBeNull + "申请权限模块描述");
        reasonItem.setWidth("*");
        reasonItem.setRequired(true);
        __formItems.add(reasonItem);

        __form.setItems(getFormItemArray());
        __form.setDataSource(ds);
        __form.setNumCols(4);
        ClientUtil.DynamicFormProcessAccordingToDevice(__form);
        reasonItem.setColSpan(4);

        HLayout bottomLayout = new HLayout();
        bottomLayout.addMembers(premissionApplyPanel);

        bottomLayout.setWidth100();
        bottomLayout.setHeight100();
        mainLayout.addMembers(__form, bottomLayout);
        addMember(mainLayout);
    }

    @Override
    public boolean checkData() {
        //判断是否是永久权限
        if (!__form.validate()) {
            SC.say("请按系统提示，填入信息");
            return false;
        }
        Map map = premissionApplyPanel.getValuesAsMap();
        int originalLength = (int) map.get("originalLength");
        if (originalLength == 0) {
            SC.say("申请的权限不能为空");
            return false;
        }
        return true;
    }

    @Override
    public void startEdit() {

        if (getRecord() != null) {
            int employeeId = BaseHelpUtils.getIntValue(getRecord().getAttribute("employeeId"));
            Map<String, Object> params = new HashMap<>();
            params.put("employeeId", employeeId);
            DBDataSource.callOperation("ST_Employee", "find", params, new DSCallback() {
                @Override
                public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                    if (dsResponse.getStatus() >= 0) {
                        __form.editRecord(dsResponse.getData()[0]);
                    }
                }
            });
            __form.editRecord(getRecord());
        }

        premissionApplyPanel.startEdit();

    }

    @Override
    public void setValueManage(ValuesManager manager) {
        manager.setDataSource(DSApplyFunctions.getInstance());
        manager.addMember(__form);
    }

    @Override
    public java.util.Map getValuesAsMap() {
        Map dataMap = premissionApplyPanel.getValuesAsMap();
        Integer isForver = (Integer) isForeverItem.getValue();

        //判断是否是永久权限
        if (isForver == 0) {
            dataMap.put("isRemoteCity", true);
        } else {
            dataMap.put("isRemoteCity", false);
        }
        dataMap.putAll(__form.getValues());
        return dataMap;
    }

    private Record record;

    @Override
    public Record getRecord() {
        return record;
    }

    @Override
    public void setRecord(Record record) {
        this.record = record;
    }

}
