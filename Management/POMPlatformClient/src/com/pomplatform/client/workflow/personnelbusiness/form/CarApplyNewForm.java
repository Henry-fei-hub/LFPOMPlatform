package com.pomplatform.client.workflow.personnelbusiness.form;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.employee.datasource.DSSelectEmployee;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSCarApply;
import com.smartgwt.client.data.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.VLayout;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class CarApplyNewForm extends AbstractWizadPage {


    private final TextItem employeeIdItem;
    private final TextItem employeeNoItem;
    private final TextItem departmentIdItem;
    private final TextItem companyIdItem;
    private final SelectItem typeItem;
    private final DateTimeItem startDateItem;
    private final DateTimeItem endDateItem;
    private final TextItem reasonItem;
    private final TextAreaItem remarkItem;
    private final SelectItem addressItem;
    private final TextAreaItem planItem;
    private final TextItem unitItem;
    private final TextItem projectNameItem;
    private final TextItem projectCodeItem;
    private final TextItem drafterItem;
    private final TextItem cardItem;
    private final SelectItem startDateDetailItem;
    private final PickTreeItem endDateDetailItem;
    private final ComboBoxItem nextAuditorItem;
    private final TextItem livingExpensesItem;
    private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
    private VLayout mainLayout;
    private PersonnelBusinesDetailCarCostAllocation panel;

    public CarApplyNewForm() {

        DSCarApply ds = DSCarApply.getInstance();
        __form.setWidth100();
        __form.setHeight100();

        mainLayout = new VLayout();

        employeeIdItem = new TextItem("employeeId", "申请人");
        employeeIdItem.setWidth("*");
        employeeIdItem.setDefaultValue(ClientUtil.getUserId());
        employeeIdItem.setDisabled(true);
        __formItems.add(employeeIdItem);

        companyIdItem = new TextItem("companyId", "归属公司");
        companyIdItem.setWidth("*");
        companyIdItem.setDefaultValue(ClientUtil.getCompanyId());
        companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
        companyIdItem.setDisabled(true);
        __formItems.add(companyIdItem);

        employeeNoItem = new TextItem("employeeNo", "工号");
        employeeNoItem.setWidth("*");
        employeeNoItem.setDefaultValue(ClientUtil.getUserNo());
        employeeNoItem.setDisabled(true);
        __formItems.add(employeeNoItem);

        departmentIdItem = new TextItem("departmentId", "所在部门");
        departmentIdItem.setWidth("*");
        departmentIdItem.setDefaultValue(ClientUtil.getDepartmentId());
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
        addressItem.setDefaultValue(ClientStaticUtils.PRE_PROJECT_USE_CAR);
        addressItem.addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent event) {
                if (null != event.getValue()) {
                    if (projectNameItem.getValue().toString().contains("公司") || projectNameItem.getValue().toString().contains("科兴科学园")) {
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
                                        panel.setCost(new BigDecimal(livingExpensesItem.getValue().toString()));
                                    } else {
                                        livingExpensesItem.setValue(0);
                                        panel.setCost(BigDecimal.ZERO);
                                    }
                                } else {
                                    SC.say(dsResponse.getErrors().get("errorMsg").toString());
                                }
                            }
                        });
					/*
						int intValue = BaseHelpUtils.getIntValue(addressItem.getValue());
						if(BaseHelpUtils.getIntValue(addressItem.getValue())==1) {
							livingExpensesItem.setValue(KeyValueManager.getValue("use_car_prices", endDateDetailItem.getValue().toString()));
							panel.setCost(new BigDecimal(livingExpensesItem.getValue().toString()));
						}else if(BaseHelpUtils.getIntValue(addressItem.getValue())==2){
							livingExpensesItem.setValue(KeyValueManager.getValue("use_bigcar_prices", endDateDetailItem.getValue().toString()));
							panel.setCost(new BigDecimal(livingExpensesItem.getValue().toString()));
						}else {
							livingExpensesItem.setValue(0);
							panel.setCost(BigDecimal.ZERO);
						}*/
                    } else {
                        livingExpensesItem.setValue(0);
                        panel.setCost(BigDecimal.ZERO);
                    }
                } else {
                    livingExpensesItem.setValue(0);
                    panel.setCost(BigDecimal.ZERO);
                }
            }
        });
        addressItem.setWidth("*");
        __formItems.add(addressItem);

//		projectNameItem = new TextItem("projectName", shouldNotBeNull + "出发地<font style='color:red'>(如果出发地不是科兴科学园，请自行修改出发地信息)</font>");
        projectNameItem = new TextItem("projectName", shouldNotBeNull + "出发地");
        projectNameItem.setWidth("*");
//		projectNameItem.setCanEdit(false);
//		projectNameItem.setDefaultValue("公司（科兴科学园）");
        __formItems.add(projectNameItem);
        projectNameItem.addChangedHandler(new ChangedHandler() {

            @Override
            public void onChanged(ChangedEvent event) {
                if (null != event.getValue()) {
                    if (event.getValue().toString().contains("公司") || event.getValue().toString().contains("科兴科学园")) {

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
                                        panel.setCost(new BigDecimal(livingExpensesItem.getValue().toString()));
                                    } else {
                                        livingExpensesItem.setValue(0);
                                        panel.setCost(BigDecimal.ZERO);
                                    }
                                } else {
                                    SC.say(dsResponse.getErrors().get("errorMsg").toString());
                                }
                            }
                        });
/*						if(BaseHelpUtils.getIntValue(addressItem.getValue())==1) {
							livingExpensesItem.setValue(KeyValueManager.getValue("use_car_prices", event.getValue().toString()));
							panel.setCost(new BigDecimal(livingExpensesItem.getValue().toString()));
						}else if(BaseHelpUtils.getIntValue(addressItem.getValue())==2){
							livingExpensesItem.setValue(KeyValueManager.getValue("use_bigcar_prices", event.getValue().toString()));
							panel.setCost(new BigDecimal(livingExpensesItem.getValue().toString()));
						}else {
							livingExpensesItem.setValue(0);
							panel.setCost(BigDecimal.ZERO);
						}*/
					
						
						/*livingExpensesItem.setValue(KeyValueManager.getValue("use_car_prices", endDateDetailItem.getValue().toString()));
						panel.setCost(new BigDecimal(livingExpensesItem.getValue().toString()));*/
                    } else {
                        livingExpensesItem.setValue(0);
                        panel.setCost(BigDecimal.ZERO);
                    }
                } else {
                    livingExpensesItem.setValue(0);
                    panel.setCost(BigDecimal.ZERO);
                }
            }
        });

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
                                        panel.setCost(new BigDecimal(livingExpensesItem.getValue().toString()));
                                    } else {
                                        livingExpensesItem.setValue(0);
                                        panel.setCost(BigDecimal.ZERO);
                                    }
                                } else {
                                    SC.say(dsResponse.getErrors().get("errorMsg").toString());
                                }
                            }
                        });
						
/*						if(BaseHelpUtils.getIntValue(addressItem.getValue())==1) {
							livingExpensesItem.setValue(KeyValueManager.getValue("use_car_prices", event.getValue().toString()));
							panel.setCost(new BigDecimal(livingExpensesItem.getValue().toString()));
					}else if(BaseHelpUtils.getIntValue(addressItem.getValue())==2){
							livingExpensesItem.setValue(KeyValueManager.getValue("use_bigcar_prices", event.getValue().toString()));
							panel.setCost(new BigDecimal(livingExpensesItem.getValue().toString()));
						}else {
							livingExpensesItem.setValue(0);
							panel.setCost(BigDecimal.ZERO);
						}*/
                    } else {
                        livingExpensesItem.setValue(0);
                        panel.setCost(BigDecimal.ZERO);
                    }
                } else {
                    livingExpensesItem.setValue(0);
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

        drafterItem = new TextItem("drafter", "起草人");
        drafterItem.setDefaultValue(ClientUtil.getUserId());
        drafterItem.hide();
        __formItems.add(drafterItem);

        reasonItem = new TextItem("reason", shouldNotBeNull + "用车目的");
        reasonItem.setWidth("*");
        __formItems.add(reasonItem);

        Criteria ct = new Criteria();
        ct.addCriteria("status", 0);
        ListGridField departmentIdField = new ListGridField("departmentId");
        ListGridField employeeNoField = new ListGridField("employeeNo");
        ListGridField employeeNameField = new ListGridField("employeeName");
        nextAuditorItem = new ComboBoxItem("nextAuditor", shouldNotBeNull + "项目经理");
        nextAuditorItem.setRequired(true);
        nextAuditorItem.setWidth("*");
        nextAuditorItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
        nextAuditorItem.setChangeOnKeypress(false);
        nextAuditorItem.setValueField("employeeId");
        nextAuditorItem.setDisplayField("employeeName");
        nextAuditorItem.hide();
        nextAuditorItem.setOptionDataSource(DSSelectEmployee.getInstance());
        nextAuditorItem.setPickListFields(employeeNoField, employeeNameField, departmentIdField);
        nextAuditorItem.setPickListCriteria(ct);
        __formItems.add(nextAuditorItem);

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
        mainLayout.addMember(__form);
//		Label label = new Label("<font style='color:#FF7F27;font-weight:bold;font-size:15px;'>温馨提示：出发地不是填写“公司”或“科兴科学园”的，或者目的地所在区域选择的是“其他”的，将由行政部事后根据实际用车费用录入系统</font>");
//		mainLayout.addMember(label);
        addMember(mainLayout);
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
        return true;
    }

    @Override
    public void startEdit() {
        if (getRecord() != null) __form.editRecord(getRecord());
        else __form.editNewRecord();
    }

    @Override
    public void setValueManage(ValuesManager manager) {
        manager.setDataSource(DSCarApply.getInstance());
        manager.addMember(__form);
    }

    @Override
    public java.util.Map getValuesAsMap() {
        Map map = __form.getValues();
        if (map.containsKey("livingExpenses")) {
            map.put("fee", map.get("livingExpenses"));
        }
        map.put("isRemoteCity", false);
        return map;
    }

    public PersonnelBusinesDetailCarCostAllocation getPanel() {
        return panel;
    }

    public void setPanel(PersonnelBusinesDetailCarCostAllocation panel) {
        this.panel = panel;
    }

}
