package com.pomplatform.client.workflow.personnelbusiness.form;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.employee.datasource.DSSelectEmployee;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSCarApply;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.DoubleItem;
import com.smartgwt.client.widgets.form.fields.PickTreeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGridField;

public class CarApplyUpdateForm extends AbstractWizadPage {

    private final TextItem employeeIdItem;
    private final TextItem employeeNoItem;
    private final TextItem departmentIdItem;
    private final TextItem companyIdItem;
    private final SelectItem typeItem;
    private final DateTimeItem startDateItem;
    private final SelectItem startDateDetailItem;
    private final DateTimeItem endDateItem;
    private final PickTreeItem endDateDetailItem;
    private final TextItem reasonItem;
    private final TextAreaItem remarkItem;
    private final SelectItem addressItem;
    private final TextAreaItem planItem;
    private final TextItem livingExpensesItem;
    private final TextItem feeItem;
    private final TextItem transportationItem;
    private final TextItem subTypeStrItem;
    private final TextItem unitItem;
    private final ComboBoxItem contactPersonItem;
    private final ComboBoxItem nextAuditorItem;
    private final SelectItem subTypeItem;
    private final SelectItem targetProvinceItem;
    private final TextItem projectNameItem;
    private final TextItem projectCodeItem;
    private final TextItem cardItem;
    private String processName;
    private String processName_1 = "行政专员";
    private String processName_2 = "司机班职能经理";

    private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
    private PersonnelBusinesDetailCarCostAllocation panel;

    public CarApplyUpdateForm() {
        DSCarApply ds = DSCarApply.getInstance();
        __form.setWidth100();
        __form.setHeight100();

        employeeIdItem = new TextItem("employeeId", "申请人");
        employeeIdItem.setWidth("*");
        employeeIdItem.setDisabled(true);
        __formItems.add(employeeIdItem);

        companyIdItem = new TextItem("companyId", "归属公司");
        companyIdItem.setWidth("*");
        companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
        companyIdItem.setDisabled(true);
        __formItems.add(companyIdItem);

        employeeNoItem = new TextItem("employeeNo", "工号");
        employeeNoItem.setWidth("*");
        employeeNoItem.setDisabled(true);
        __formItems.add(employeeNoItem);

        departmentIdItem = new TextItem("departmentId", "所在部门");
        departmentIdItem.setWidth("*");
        departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
        departmentIdItem.setDisabled(true);
        __formItems.add(departmentIdItem);

        cardItem = new TextItem("card", shouldNotBeNull + "手机号码");
        cardItem.setWidth("*");
        __formItems.add(cardItem);

        unitItem = new TextItem("unit", shouldNotBeNull + "同行人数");
        unitItem.setWidth("*");
        __formItems.add(unitItem);

        startDateItem = new DateTimeItem("startDate", shouldNotBeNull + "用车开始时间");
        startDateItem.setWidth("*");
        startDateItem.setUseMask(true);
        startDateItem.setUseTextField(true);
        __formItems.add(startDateItem);

        endDateItem = new DateTimeItem("endDate", shouldNotBeNull + "预计结束时间");
        endDateItem.setWidth("*");
        endDateItem.setUseMask(true);
        endDateItem.setUseTextField(true);
        __formItems.add(endDateItem);

        startDateDetailItem = new SelectItem("startDateDetail", shouldNotBeNull + "用车类型");
        startDateDetailItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_119"));
        startDateDetailItem.setWidth("*");
        startDateDetailItem.setDefaultValue(ClientStaticUtils.DEPARTMENT_USE_CAR);
        startDateDetailItem.addChangedHandler(new ChangedHandler() {

            @Override
            public void onChanged(ChangedEvent event) {
                if (null != panel) {
                    int value = ClientUtil.checkAndGetIntValue(event.getValue());
                    panel.setCorrectDataSrouce(value);
                    if (value == ClientStaticUtils.PRE_PROJECT_USE_CAR) {
                        nextAuditorItem.show();
                    } else {
                        nextAuditorItem.hide();
                    }
                }
            }
        });
        __formItems.add(startDateDetailItem);

        typeItem = new SelectItem("type", shouldNotBeNull + "用车范围");
        typeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_104"));
        typeItem.setWidth("*");
        __formItems.add(typeItem);

        addressItem = new SelectItem("address", shouldNotBeNull + "申请用车车型");
        addressItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_122"));
        addressItem.setWidth("*");
        addressItem.addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent event) {
                if (null != event.getValue()) {
                    Map<String, Object> params = new LinkedHashMap<>();
                    params.put("optType", "onGetUseCarPrice");
                    if (BaseHelpUtils.getIntValue(endDateDetailItem.getValue()) > 0) {
                        params.put("useCarPriceId", endDateDetailItem.getValue());
                    }
                    if (BaseHelpUtils.getIntValue(addressItem.getValue()) > 0) {
                        params.put("carType", addressItem.getValue());
                    }
                    DBDataSource.callOperation("EP_OnProjectWithStageCommon", params, new DSCallback() {
                        @Override
                        public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                            if (dsResponse.getStatus() >= 0) {
                                Record[] data2 = dsResponse.getData();
                                if (data2.length > 0) {
                                    livingExpensesItem.setValue(data2[0].getAttribute("price"));
                                    feeItem.setValue(data2[0].getAttribute("price"));
                                    panel.setCost(new BigDecimal(livingExpensesItem.getValue().toString()));
                                } else {
                                    livingExpensesItem.setValue(0);
                                    feeItem.setValue(0);
                                    panel.setCost(BigDecimal.ZERO);
                                }
                            } else {
                                SC.say(dsResponse.getErrors().get("errorMsg").toString());
                            }
                        }
                    });

                    livingExpensesItem.setValue(0);
                    feeItem.setValue(0);
                    panel.setCost(BigDecimal.ZERO);

                } else {
                    livingExpensesItem.setValue(0);
                    feeItem.setValue(0);
                    panel.setCost(BigDecimal.ZERO);
                }
            }
        });
        __formItems.add(addressItem);

        projectNameItem = new TextItem("projectName", shouldNotBeNull + "出发地");
        projectNameItem.setWidth("*");
        __formItems.add(projectNameItem);
//        projectNameItem.addChangedHandler(new ChangedHandler() {
//
//            @Override
//            public void onChanged(ChangedEvent event) {
//                if (null != event.getValue()) {
//                    if (event.getValue().toString().contains("公司") || event.getValue().toString().contains("科兴科学园")) {
//
//                        Map<String, Object> params = new LinkedHashMap<>();
//                        params.put("optType", "onGetUseCarPrice");
//                        if (BaseHelpUtils.getIntValue(endDateDetailItem.getValue()) > 0) {
//                            params.put("useCarPriceId", endDateDetailItem.getValue());
//                        }
//                        if (BaseHelpUtils.getIntValue(addressItem.getValue()) > 0) {
//                            params.put("carType", addressItem.getValue());
//                        }
//                        DBDataSource.callOperation("EP_OnProjectWithStageCommon", params, new DSCallback() {
//                            @Override
//                            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//                                if (dsResponse.getStatus() >= 0) {
//                                    Record[] data2 = dsResponse.getData();
//                                    if (data2.length > 0) {
//                                        livingExpensesItem.setValue(data2[0].getAttribute("price"));
//                                        feeItem.setValue(data2[0].getAttribute("price"));
//                                        panel.setCost(new BigDecimal(livingExpensesItem.getValue().toString()));
//                                    } else {
//                                        livingExpensesItem.setValue(0);
//                                        feeItem.setValue(0);
//                                        panel.setCost(BigDecimal.ZERO);
//                                    }
//                                } else {
//                                    SC.say(dsResponse.getErrors().get("errorMsg").toString());
//                                }
//                            }
//                        });
//                    } else {
//                        livingExpensesItem.setValue(0);
//                        feeItem.setValue(0);
//                        panel.setCost(BigDecimal.ZERO);
//                    }
//                } else {
//                    livingExpensesItem.setValue(0);
//                    feeItem.setValue(0);
//                    panel.setCost(BigDecimal.ZERO);
//                }
//            }
//        });

        endDateDetailItem = new PickTreeItem("endDateDetail", shouldNotBeNull + "目的地所在区域");
        endDateDetailItem.setValueTree(KeyValueManager.getTree("use_car_to_area"));
        endDateDetailItem.setCanSelectParentItems(false);
        endDateDetailItem.setValueField("treeId");
        endDateDetailItem.setWidth("*");
        __formItems.add(endDateDetailItem);
        endDateDetailItem.addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent event) {
                if (null != event.getValue()) {
                    if (projectNameItem.getValue().toString().contains("公司") || projectNameItem.getValue().toString().contains("科兴科学园")) {
                        Map<String, Object> params = new LinkedHashMap<>();
                        params.put("optType", "onGetUseCarPrice");
                        if (BaseHelpUtils.getIntValue(event.getValue().toString()) > 0) {
                            params.put("useCarPriceId", event.getValue().toString());
                        }
                        if (BaseHelpUtils.getIntValue(addressItem.getValue()) > 0) {
                            params.put("carType", addressItem.getValue());
                        }
                        DBDataSource.callOperation("EP_OnProjectWithStageCommon", params, new DSCallback() {
                            @Override
                            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                                if (dsResponse.getStatus() >= 0) {
                                    Record[] data2 = dsResponse.getData();
                                    if (data2.length > 0) {
                                        livingExpensesItem.setValue(data2[0].getAttribute("price"));
                                        feeItem.setValue(data2[0].getAttribute("price"));
                                        panel.setCost(new BigDecimal(livingExpensesItem.getValue().toString()));
                                    } else {
                                        livingExpensesItem.setValue(0);
                                        feeItem.setValue(0);
                                        panel.setCost(BigDecimal.ZERO);
                                    }
                                } else {
                                    SC.say(dsResponse.getErrors().get("errorMsg").toString());
                                }
                            }
                        });
                    } else {
                        livingExpensesItem.setValue(0);
                        feeItem.setValue(0);
                        panel.setCost(BigDecimal.ZERO);
                    }
                } else {
                    livingExpensesItem.setValue(0);
                    feeItem.setValue(0);
                    panel.setCost(BigDecimal.ZERO);
                }
            }
        });

        projectCodeItem = new TextItem("projectCode", shouldNotBeNull + "目的地详细地址");
        projectCodeItem.setWidth("*");
        __formItems.add(projectCodeItem);


        livingExpensesItem = new TextItem("livingExpenses", "预计用车费用");
        livingExpensesItem.setWidth("*");
        __formItems.add(livingExpensesItem);
        livingExpensesItem.addChangedHandler(new ChangedHandler() {

            @Override
            public void onChanged(ChangedEvent event) {
                if (null != event.getValue()) {

                    livingExpensesItem.setValue(new BigDecimal(event.getValue().toString()).setScale(2, BigDecimal.ROUND_DOWN));

                    panel.setCost(new BigDecimal(livingExpensesItem.getValue().toString()));

                } else {
                    livingExpensesItem.setValue(0);
                    panel.setCost(BigDecimal.ZERO);
                }
            }
        });

        transportationItem = new TextItem("transportation", "实际公里数");
        transportationItem.setWidth("*");
        transportationItem.hide();
        __formItems.add(transportationItem);

        feeItem = new DoubleItem("fee", "实际用车费用");
        feeItem.setWidth("*");
        feeItem.setLength(18);
        feeItem.setDecimalPad(2);
        feeItem.setFormat("#,###,###,###,###,##0.00");
        feeItem.setDisabled(true);
        feeItem.hide();
        __formItems.add(feeItem);
        feeItem.addChangedHandler(new ChangedHandler() {

            @Override
            public void onChanged(ChangedEvent event) {
                if (null != event.getValue()) {
                    BigDecimal fee = new BigDecimal(event.getValue().toString()).setScale(2, BigDecimal.ROUND_DOWN);
                    feeItem.setValue(fee);
                    livingExpensesItem.setValue(fee);
                    panel.setCost(fee);
                } else {
                    feeItem.setValue(0);
                    livingExpensesItem.setValue(0);
                    panel.setCost(BigDecimal.ZERO);
                }
            }
        });

        subTypeStrItem = new TextItem("subTypeStr", "修改用车成本的原因");
        subTypeStrItem.setWidth("*");
        subTypeStrItem.hide();
        __formItems.add(subTypeStrItem);

        reasonItem = new TextItem("reason", shouldNotBeNull + "用车目的");
        reasonItem.setWidth("*");
        __formItems.add(reasonItem);

        Criteria c = new Criteria();
        c.addCriteria("status", 0);
        c.addCriteria("plateId", ClientUtil.getPlateId());
        ListGridField employeeNoPreField = new ListGridField("employeeNo");
        ListGridField employeeNamePreField = new ListGridField("employeeName");
        nextAuditorItem = new ComboBoxItem("nextAuditor", shouldNotBeNull + "项目经理");
        nextAuditorItem.setRequired(true);
        nextAuditorItem.setWidth("*");
        nextAuditorItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
        nextAuditorItem.setChangeOnKeypress(false);
        nextAuditorItem.setValueField("employeeId");
        nextAuditorItem.setDisplayField("employeeName");
        nextAuditorItem.hide();
        nextAuditorItem.setOptionDataSource(DSSelectEmployee.getInstance());
        nextAuditorItem.setPickListFields(employeeNoPreField, employeeNamePreField);
        nextAuditorItem.setPickListCriteria(c);
        __formItems.add(nextAuditorItem);

        subTypeItem = new SelectItem("subType", shouldNotBeNull + "内部派车/外部专车");
        subTypeItem.setWidth("*");
        subTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_105"));
        subTypeItem.hide();
        __formItems.add(subTypeItem);
        subTypeItem.addChangedHandler(new ChangedHandler() {

            @Override
            public void onChanged(ChangedEvent event) {
                if (null != event.getValue()) {
                    if (ClientUtil.checkAndGetIntValue(event.getValue()) == 0) {
                        targetProvinceItem.show();
                        contactPersonItem.show();
                    } else {
                        targetProvinceItem.clearValue();
                        contactPersonItem.clearValue();
                        targetProvinceItem.hide();
                        contactPersonItem.hide();
                    }
                }
            }
        });

        targetProvinceItem = new SelectItem("targetProvince", shouldNotBeNull + "车辆信息");
        targetProvinceItem.setWidth("*");
        targetProvinceItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_106"));
        targetProvinceItem.hide();
        __formItems.add(targetProvinceItem);

        Criteria ct = new Criteria();
        ct.addCriteria("status", 0);
        ct.addCriteria("dutyId", 31);//司机

        ListGridField employeeNoField = new ListGridField("employeeNo");
        ListGridField employeeNameField = new ListGridField("employeeName");
        ListGridField departmentField = new ListGridField("departmentId");

        contactPersonItem = new ComboBoxItem("contactPerson", shouldNotBeNull + "司机");
        contactPersonItem.setRequired(true);
        contactPersonItem.setWidth("*");
        contactPersonItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
        contactPersonItem.setChangeOnKeypress(false);
        contactPersonItem.setValueField("employeeId");
        contactPersonItem.setDisplayField("employeeName");
        contactPersonItem.hide();
        contactPersonItem.setOptionDataSource(DSSelectEmployee.getInstance());
        contactPersonItem.setPickListFields(employeeNoField, employeeNameField, departmentField);
        contactPersonItem.setPickListCriteria(ct);
        __formItems.add(contactPersonItem);

        planItem = new TextAreaItem("plan", "行程安排");
        planItem.setWidth("*");
        planItem.setColSpan(4);
        planItem.setRowSpan(3);
        __formItems.add(planItem);

        remarkItem = new TextAreaItem("remark", "备注");
        remarkItem.setWidth("*");
        remarkItem.setColSpan(4);
        remarkItem.setRowSpan(3);
        __formItems.add(remarkItem);


        __form.setItems(getFormItemArray());
        __form.setDataSource(ds);
        __form.setNumCols(4);
        ClientUtil.DynamicFormProcessAccordingToDevice(__form);

        setPageMode(PAGE_MODE_UPDATE);

        addMember(__form);

    }

    @Override
    public void startEdit() {
        Record record = getRecord();
        if (record != null) {
            __form.editRecord(record);
            if (null != record.getAttribute("startDateDetail")) {
                panel.setCorrectDataSrouce(ClientUtil.checkAndGetIntValue(record.getAttribute("startDateDetail")));
            }
            if (null != record.getAttribute("fee")) {
                panel.setCost(new BigDecimal(record.getAttribute("fee")));
            }
            //如果流程名称不为null，并且审批节点为行政文员或者司机班主管的话则显示相应的必填项
            if (null != processName) {
                if (processName.equals(processName_1) || processName.equals(processName_2)) {
                    //行政文员同意用车申请的情况下，需要填几个必填项
                    subTypeItem.show();
                    feeItem.show();
                    transportationItem.show();
                    subTypeStrItem.show();
                    livingExpensesItem.setDisabled(false);
                    feeItem.setDisabled(false);
                }
            }
        }
    }

    @Override
    public void setValueManage(ValuesManager manager) {
        manager.setDataSource(DSCarApply.getInstance());
        manager.addMember(__form);
    }

    @Override
    public boolean checkData() {
        if (null == employeeIdItem.getValue()) {
            SC.say("请重新登录之后再申请本流程");
            return false;
        }
        if (null == cardItem.getValue()) {
            SC.say("请填写手机号码");
            return false;
        }
        if (null == typeItem.getValue()) {
            SC.say("请选择用车范围");
            return false;
        }
        if (null == unitItem.getValue()) {
            SC.say("请填写同行人数");
            return false;
        }
        if (null == addressItem.getValue()) {
            SC.say("请填写申请用车车型");
            return false;
        }
        if (null == startDateItem.getValue()) {
            SC.say("请填写用车开始时间");
            return false;
        }
        if (null == endDateItem.getValue()) {
            SC.say("请填写用车结束时间");
            return false;
        }
        if (startDateItem.getValueAsDate().getTime() >= endDateItem.getValueAsDate().getTime()) {
            SC.say("用车结束时间必须晚于用车开始时间");
            return false;
        }
        if (null == projectNameItem.getValue()) {
            SC.say("请填写出发地");
            return false;
        }
        if (null == endDateDetailItem.getValue()) {
            SC.say("请选择目的地所在区域");
            return false;
        }
        if (null == projectCodeItem.getValue()) {
            SC.say("请填写目的地");
            return false;
        }
        if (null == reasonItem.getValue()) {
            SC.say("请填写用车目的");
            return false;
        }
        if (ClientUtil.checkAndGetIntValue(typeItem.getValue()) == ClientStaticUtils.PRE_PROJECT_USE_CAR && null == nextAuditorItem.getValue()) {
            SC.say("请选择前期项目的项目经理");
            return false;
        }

        if (null != processName) {
            if (processName.equals(processName_1) || processName.equals(processName_2)) {
                //行政文员或司机班管理员同意用车申请的情况下，需要填几个必填项

                if (null == subTypeItem.getValue()) {
                    SC.say("请选择内部派车/外部专车");
                    return false;
                }

                if (ClientUtil.checkAndGetIntValue(subTypeItem.getValue()) == 0) {
                    //内部派车，需要选择车子信息和司机
                    if (null == targetProvinceItem.getValue() || null == contactPersonItem.getValue()) {
                        SC.say("请选择车辆信息和司机");
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override
    public java.util.Map getValuesAsMap() {

        Map map = __form.getValues();
        if (null == processName || !processName.equals(processName_1) || !processName.equals(processName_2)) {
            if (map.containsKey("livingExpenses")) {
                map.put("fee", map.get("livingExpenses"));
            }
        }
        return map;
    }

    public PersonnelBusinesDetailCarCostAllocation getPanel() {
        return panel;
    }

    public void setPanel(PersonnelBusinesDetailCarCostAllocation panel) {
        this.panel = panel;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

}
