package com.pomplatform.client.common;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.google.gwt.user.client.Cookies;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SpinnerItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Logger;

public class SetProjectIntegralChange extends HLayout implements HasHandlers {

    private Window parentWindow;
    private static Logger __logger = Logger.getLogger("");
    private TextItem projectNameItem;
    private TextItem projectIntegralItem;
    private TextItem reserveIntegralItem;
    private SpinnerItem transferIntegralItem;
    private TextAreaItem remarkItem;

    /**
     * @param projectName
     * @param projectId
     * @param projectIntegral
     * @param reserveIntegral
     */
    public void initComponents(final String projectName, final int projectId, final double projectIntegral, final double reserveIntegral) {
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
        form.setNumCols(2);
        form.setAlign(Alignment.CENTER);
        form.setWidth100();
        form.setHeight100();

        projectNameItem = new TextItem("projectName", "项目名称");
        projectNameItem.setCanEdit(false);
        projectNameItem.setDefaultValue(projectName);
        projectNameItem.setWidth("*");
        
        projectIntegralItem = new TextItem("projectIntegral", "项目积分");
        projectIntegralItem.setCanEdit(false);
        projectIntegralItem.setDefaultValue(projectIntegral);
        projectIntegralItem.setWidth("*");
        
        reserveIntegralItem = new TextItem("reserveIntegral", "预留积分");
        reserveIntegralItem.setCanEdit(false);
        reserveIntegralItem.setDefaultValue(reserveIntegral);
        reserveIntegralItem.setWidth("*");

        transferIntegralItem = new SpinnerItem("appendIntegral", "调整积分");
        transferIntegralItem.setMax(reserveIntegral);
        transferIntegralItem.setMin(0);  
        transferIntegralItem.setStep(500f);  
        transferIntegralItem.setWriteStackedIcons(false);
        transferIntegralItem.setDefaultValue(0);
        transferIntegralItem.setWidth("*");
        transferIntegralItem.addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent event) {
                if(reserveIntegral <= 0){
                    SC.say("提示","该项目没有可调整的预留积分");
                    transferIntegralItem.setValue(0);
                    return;
                }
                //获取新输入的积分值
                double newValue = ClientUtil.checkAndGetDoubleValue(event.getValue());
                //获取改变前的值
                double oldValue = ClientUtil.checkAndGetDoubleValue(event.getOldValue());
                //获取改变后与改变前的差值
                double finalValue = newValue - oldValue;
                //更新项目积分
                projectIntegralItem.setValue(ClientUtil.checkAndGetDoubleValue(projectIntegralItem.getValue())+finalValue);
                //更新项目预留积分
                reserveIntegralItem.setValue(ClientUtil.checkAndGetDoubleValue(reserveIntegralItem.getValue())-finalValue);
            }
        });

        remarkItem = new TextAreaItem("remark", "备注");
        remarkItem.setColSpan(2);
        remarkItem.setRowSpan(3);
        remarkItem.setWidth("*");

        form.setItems(projectNameItem, projectIntegralItem,reserveIntegralItem,transferIntegralItem, remarkItem);
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
                //获取调整后的项目积分
                double afterProjectIntegral = ClientUtil.checkAndGetDoubleValue(projectIntegralItem.getValue());
                //获取调整后的预留积分
                double afterReserveIntegral = ClientUtil.checkAndGetDoubleValue(reserveIntegralItem.getValue());
                //获取转移的积分
                double transferIntegral = ClientUtil.checkAndGetDoubleValue(transferIntegralItem.getValue());
                if(transferIntegral <= 0){
                    SC.say("提示","请输入您要调整的积分");
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
                map.put("beforeProjectIntegral", projectIntegral);
                map.put("afterProjectIntegral", afterProjectIntegral);
                map.put("beforeReserveIntegral", reserveIntegral);
                map.put("afterReserveIntegral", afterReserveIntegral);
                map.put("transferIntegral", transferIntegral);
                map.put("plateEmployeeId", plateEmployeeId);
                map.put("plateId", plateId);
                map.put("remark", remark);
                DBDataSource.callOperation("EP_OnSetProjectIntegralChange", map, new DSCallback() {
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
