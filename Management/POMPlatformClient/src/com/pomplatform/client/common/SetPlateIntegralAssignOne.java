package com.pomplatform.client.common;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.data.RoleDefinition;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.DateItemSelectorFormat;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.IPickTreeItem;
import com.smartgwt.client.widgets.form.fields.SpinnerItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Logger;

public class SetPlateIntegralAssignOne extends HLayout implements HasHandlers {

    private Window parentWindow;
    private static Logger __logger = Logger.getLogger("");
    private ComboBoxItem plateIdItem;
    private IPickTreeItem departmentIdItem;
    private ComboBoxItem employeeIdItem;
    private TextItem reserveIntegralItem;
    private SpinnerItem assignIntegralItem;
    private TextAreaItem remarkItem;
    private DateItem assignDateItem;

    public void initComponents() {
        setWidth100();
        setHeight100();
        setPadding(10);
        setMembersMargin(5);

        VLayout formLayout = new VLayout();
        formLayout.setHeight100();
        formLayout.setMembersMargin(5);
        formLayout.setWidth("100%");
        formLayout.setAlign(Alignment.CENTER);
        addMember(formLayout);

        HLayout messageLayout = new HLayout();
        messageLayout.setWidth100();
        messageLayout.setHeight("80%");
        messageLayout.setAlign(Alignment.CENTER);

        final DynamicForm form = new DynamicForm();
        form.setNumCols(4);
        form.setAlign(Alignment.CENTER);
        form.setWidth100();
        form.setHeight100();
        
        plateIdItem = new ComboBoxItem("plateId", "积分提取部门");
        plateIdItem.setWidth("*");
        plateIdItem.setCanEdit(false);
        //设置默认为当前操作人的业务部门
        plateIdItem.setDefaultValue(ClientUtil.getPlateId());
        plateIdItem.setChangeOnKeypress(false);
        plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));

        reserveIntegralItem = new TextItem("reserveIntegral", "价值积分");
        reserveIntegralItem.setCanEdit(false);
        reserveIntegralItem.setDefaultValue(0);
        reserveIntegralItem.setWidth("*");
        
         
        departmentIdItem = new IPickTreeItem("departmentId", "发放人员归属部门");
        departmentIdItem.setWidth("*");
        departmentIdItem.setCanSelectParentItems(true);
        departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));
        
        employeeIdItem = new ComboBoxItem("employeeId", "发放人员");
        employeeIdItem.setWidth("*");
        employeeIdItem.setChangeOnKeypress(false);
        employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
        RoleDefinition.setPlageEmployeeItemValueMap(employeeIdItem, ClientUtil.getPlateId());

        //选择了 发放人员归属部门 加载出对应的人员
        departmentIdItem.addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent event) {
                String[] deptIdObject=BaseHelpUtils.getString(departmentIdItem._getValue()).split("/");
                int deptId=BaseHelpUtils.getIntValue(deptIdObject[2]);
                RoleDefinition.setPlageDeptIdEmployeeItemValueMap(employeeIdItem, deptId);
            }
        });
        
        assignDateItem = new DateItem("assignDate","发放日期");
        assignDateItem.setWidth("*");
        assignDateItem.setDefaultValue(new Date());
        assignDateItem.setShowIcons(false);
        assignDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
        
        assignIntegralItem = new SpinnerItem("assignIntegral", "发放积分");
        assignIntegralItem.setMin(0);  
        assignIntegralItem.setStep(500f);  
        assignIntegralItem.setWriteStackedIcons(false);
        assignIntegralItem.setDefaultValue(0);
        assignIntegralItem.setWidth("*");
        assignIntegralItem.addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent event) {
                double reserveIntegral = ClientUtil.checkAndGetDoubleValue(reserveIntegralItem.getValue());
                if(reserveIntegral <= 0){
                    SC.say("提示","该部门没有可发放的积分");
                    assignIntegralItem.setValue(0);
                    return;
                }
                //获取新输入的积分值
                double newValue = ClientUtil.checkAndGetDoubleValue(event.getValue());
                //获取改变前的值
                double oldValue = ClientUtil.checkAndGetDoubleValue(event.getOldValue());
                //获取改变后与改变前的差值
                double finalValue = newValue - oldValue;
                //更新价值积分
                reserveIntegralItem.setValue(ClientUtil.checkAndGetDoubleValue(reserveIntegralItem.getValue())-finalValue);
            }
        });

        remarkItem = new TextAreaItem("remark", "备注");
        remarkItem.setColSpan(4);
        remarkItem.setRowSpan(3);
        remarkItem.setWidth("*");

        form.setItems(plateIdItem,reserveIntegralItem,departmentIdItem,employeeIdItem,assignDateItem,assignIntegralItem, remarkItem);
        ClientUtil.DynamicFormProcessAccordingToDevice(form);
        messageLayout.addMember(form);
        formLayout.addMember(messageLayout);
        HLayout btnLayout = new HLayout();
        btnLayout.setWidth100();
        btnLayout.setHeight(70);
        btnLayout.setMembersMargin(10);
        btnLayout.setAlign(Alignment.CENTER);

        IButton okBtn = new IButton("提交");
        okBtn.setIcon("[SKIN]/actions/save.png");
        okBtn.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                if (!form.validate()) {
                    return;
                }
                //获取提取积分的部门
                int plateId = ClientUtil.getPlateId();
                if(plateId <= 0){
                    SC.say("提示", "未获取到当前操作人的部门");
                    return;
                }
                //获取发放的成员
                int employeeId = ClientUtil.checkAndGetIntValue(employeeIdItem.getValue());
                if(employeeId <= 0){
                    SC.say("提示","请选择一个发放的成员");
                    return;
                }
                //获取发放的积分
                double assignIntegral = ClientUtil.checkAndGetDoubleValue(assignIntegralItem.getValue());
                if(assignIntegral <= 0){
                    SC.say("提示","请输入您要发放的积分");
                    return;
                }
                //获取当前板块负责人的ID
                int plateEmployeeId = ClientUtil.getEmployeeId();
                //获取结算日期
                Date assignDate = assignDateItem.getValueAsDate();
                //获取备注
                String remark = (String) remarkItem.getValue();
                LinkedHashMap params = new LinkedHashMap();
                params.put("plateId", plateId);
                params.put("employeeId", employeeId);
                params.put("assignIntegral", assignIntegral);
                params.put("plateEmployeeId", plateEmployeeId);
                params.put("assignDate", assignDate);
                params.put("remark", remark);
                params.put("opt_type", "oneEmployeeAssign");
                DBDataSource.callOperation("EP_OnPlateReserveIntegralAssign", params, new DSCallback() {
                    @Override
                    public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                        if (dsResponse.getStatus() >= 0) {
                            SC.say("操作成功");
                            if (getParentWindow() == null) {
                                return;
                            }
                            getParentWindow().destroy();
                            DataEditEvent dee = new DataEditEvent();
                            fireEvent(dee);
                        } else {
                            SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
                        }
                    }
                });
            }
        });
        IButton cleanBtn = new IButton("关闭");
        cleanBtn.setIcon("[SKIN]/actions/close.png");
        cleanBtn.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                if (getParentWindow() == null) {
                    return;
                }
                getParentWindow().destroy();
            }
        });
        btnLayout.addMember(okBtn);
        btnLayout.addMember(cleanBtn);
        formLayout.addMember(btnLayout);
        //加载页面是加载数据，获取当前操作人的部门的价值积分
        int plateId = ClientUtil.getPlateId();
        getReserveInteralByProjectId(plateId);
    }
    
    /**
     * 根据选择下拉的获取业务部门价值积分
     * @param plateId
     */
    protected void getReserveInteralByProjectId(int plateId) {
        LinkedHashMap map = new LinkedHashMap();
        map.put("plateId", plateId);
        DBDataSource.callOperation("EP_OnGetPlateReserveIntegral", map, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                    Record result = dsResponse.getData()[0];
                    //获取该业务部门价值积分
                    double achieveIntegral = ClientUtil.checkAndGetDoubleValue(result.getAttribute("achieveIntegral"));
                    reserveIntegralItem.setValue(achieveIntegral);
                    //根据目标部门的价值积分，设置可转移的最大积分为该目标部门的价值积分
                    assignIntegralItem.setMax(achieveIntegral);
                } else {
                    SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
                }
            }
        });
    };

    protected final HandlerManager handlerManager = new HandlerManager(this);
    protected final List<DataEditedHandler> __dataEditedHandler = new ArrayList<>();

    @Override
    public void fireEvent(GwtEvent<?> event) {
        handlerManager.fireEvent(event);
    }

    public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
        return handlerManager.addHandler(DataEditEvent.TYPE, handler);
    }

    public Window getParentWindow() {
        return parentWindow;
    }

    public void setParentWindow(Window parentWindow) {
        this.parentWindow = parentWindow;
    }

}
