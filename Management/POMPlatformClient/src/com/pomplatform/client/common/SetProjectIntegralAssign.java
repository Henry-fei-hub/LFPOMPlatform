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
import com.google.gwt.user.client.Cookies;
import com.pomplatform.client.data.RoleDefinition;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Logger;

public class SetProjectIntegralAssign extends HLayout implements HasHandlers {

    private Window parentWindow;
    private static Logger __logger = Logger.getLogger("");
    private ComboBoxItem projectIdItem;
    
     private IPickTreeItem departmentIdItem;
    
    private ComboBoxItem employeeIdItem;
    private TextItem reserveIntegralItem;
    private SpinnerItem assignIntegralItem;
    private TextAreaItem remarkItem;

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
        
        projectIdItem = new ComboBoxItem("projectId", "积分提取项目");
        projectIdItem.setWidth("*");
        projectIdItem.setChangeOnKeypress(false);
//        KeyValueManager.loadValueMap("projects",projectIdItem);
        KeyValueManager.loadValueMap("projects",projectIdItem);
        RoleDefinition.setProjectItemValueMap(projectIdItem, ClientUtil.getPlateId());
        projectIdItem.addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent event) {
                int projectId = ClientUtil.checkAndGetIntValue(event.getValue());
                if(projectId > 0){
                    getReserveInteralByProjectId(projectId);
                }
            }
        });

        reserveIntegralItem = new TextItem("reserveIntegral", "预留积分");
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
        
        assignIntegralItem = new SpinnerItem("assignIntegral", "发放积分");
        assignIntegralItem.setMin(0);  
        assignIntegralItem.setStep(500f);  
        assignIntegralItem.setWriteStackedIcons(false);
        assignIntegralItem.setDefaultValue(0);
        assignIntegralItem.setWidth("*");
        assignIntegralItem.addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent event) {
                if(reserveIntegral <= 0){
                    SC.say("提示","该项目没有可发放的预留积分");
                    assignIntegralItem.setValue(0);
                    return;
                }
                //获取新输入的积分值
                double newValue = ClientUtil.checkAndGetDoubleValue(event.getValue());
                //获取改变前的值
                double oldValue = ClientUtil.checkAndGetDoubleValue(event.getOldValue());
                //获取改变后与改变前的差值
                double finalValue = newValue - oldValue;
                //更新项目预留积分
                reserveIntegralItem.setValue(ClientUtil.checkAndGetDoubleValue(reserveIntegralItem.getValue())-finalValue);
            }
        });

        remarkItem = new TextAreaItem("remark", "备注");
        remarkItem.setColSpan(4);
        remarkItem.setRowSpan(3);
        remarkItem.setWidth("*");

        form.setItems(projectIdItem,reserveIntegralItem,departmentIdItem,employeeIdItem,assignIntegralItem, remarkItem);
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
                //获取提取积分的项目
                int projectId = ClientUtil.checkAndGetIntValue(projectIdItem.getValue());
                if(projectId <= 0){
                    SC.say("提示","请选择一个积分提取项目");
                    return;
                }
                //获取发放的成员
                int employeeId = ClientUtil.checkAndGetIntValue(employeeIdItem.getValue());
                if(employeeId <= 0){
                    SC.say("提示","请选择一个发放的成员");
                    return;
                }
                //获取发放后的预留积分
                double afterReserveIntegral = ClientUtil.checkAndGetDoubleValue(reserveIntegralItem.getValue());
                //获取发放的积分
                double assignIntegral = ClientUtil.checkAndGetDoubleValue(assignIntegralItem.getValue());
                if(assignIntegral <= 0){
                    SC.say("提示","请输入您要发放的积分");
                    return;
                }
                //获取当前板块负责人的ID
                int plateEmployeeId = ClientUtil.checkAndGetIntValue(Cookies.getCookie(ClientUtil.OPRERATORID_COOKIE));
                //获取当前板块负责人的板块ID
                int plateId = ClientUtil.checkAndGetIntValue(Cookies.getCookie(ClientUtil.OPRERATOR_PLATEID_COOKIE));
                //获取备注
                String remark = (String) remarkItem.getValue();
                
                LinkedHashMap map = new LinkedHashMap();
                map.put("projectId", projectId);
                map.put("employeeId", employeeId);
//                map.put("beforeReserveIntegral", reserveIntegral);
//                map.put("afterReserveIntegral", afterReserveIntegral);
                map.put("assignIntegral", assignIntegral);
                map.put("plateEmployeeId", plateEmployeeId);
                map.put("plateId", plateId);
                map.put("remark", remark);
                DBDataSource.callOperation("EP_OnSetProjectIntegralAssign", map, new DSCallback() {
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

    }
    
    /**
     * 根据选择下拉的项目获取其预留的项目积分
     * @param projectId
     */
    protected void getReserveInteralByProjectId(int projectId){
        LinkedHashMap map = new LinkedHashMap();
        map.put("projectId", projectId);
        DBDataSource.callOperation("EP_OnGetProjectReserveIntegral", map, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                    Record result = dsResponse.getData()[0];
                    //获取该项目的预留积分
                    double reserveIntegral = ClientUtil.checkAndGetDoubleValue(result.getAttribute("integral"));
                    reserveIntegralItem.setValue(reserveIntegral);
                    //初始化所选择项目的预留积分
                    setReserveIntegral(reserveIntegral);
                    //根据目标项目的预留积分，设置可发放的最大积分为该目标项目的预留积分
                    assignIntegralItem.setMax(reserveIntegral);
                } else {
                    SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
                }
            }
        });
    };

    protected final HandlerManager handlerManager = new HandlerManager(this);
    protected final List<DataEditedHandler> __dataEditedHandler = new ArrayList<>();
    private double reserveIntegral;

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

    /**
     * @return the reserveIntegral
     */
    public double getReserveIntegral() {
        return reserveIntegral;
    }

    /**
     * @param reserveIntegral the reserveIntegral to set
     */
    public void setReserveIntegral(double reserveIntegral) {
        this.reserveIntegral = reserveIntegral;
    }

}
