package com.pomplatform.client.common;

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

public class SetProjectIntegralTransfer extends HLayout implements HasHandlers {

    private Window parentWindow;
    private static Logger __logger = Logger.getLogger("");
    private ComboBoxItem fromProjectIdItem;
    private ComboBoxItem toProjectIdItem;
    private TextItem fromIntegralItem;
    private TextItem toIntegralItem;
    private SpinnerItem transferIntegralItem;
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

        fromProjectIdItem = new ComboBoxItem("fromProjectId", "积分提取项目");
        fromProjectIdItem.setWidth("*");
        fromProjectIdItem.setChangeOnKeypress(false);
//        fromProjectIdItem.setValueMap(KeyValueManager.getValueMap("projects"));
        KeyValueManager.loadValueMap("projects",fromProjectIdItem);
        RoleDefinition.setProjectItemValueMap(fromProjectIdItem, ClientUtil.getPlateId());
        fromProjectIdItem.addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent event) {
                int projectId = ClientUtil.checkAndGetIntValue(event.getValue());
                if(projectId > 0){
                    //获取归属项目ID
                    int toProjectId = ClientUtil.checkAndGetIntValue(toProjectIdItem.getValue());
                    if(toProjectId == projectId){
                        SC.say("提示","该项目已被选择为积分追加项目");
                        fromProjectIdItem.clearValue();
                        return;
                    }
                    getReserveInteralByProjectId(projectId, 1);
                }
            }
        });
        
        fromIntegralItem = new TextItem("fromIntegral","积分提取项目预留积分");
        fromIntegralItem.setWidth("*");
        fromIntegralItem.setDisabled(true);
        fromIntegralItem.setDefaultValue(0);
        
        toProjectIdItem = new ComboBoxItem("toProjectId", "积分追加项目");
        toProjectIdItem.setWidth("*");
        toProjectIdItem.setChangeOnKeypress(false);
        RoleDefinition.setProjectItemValueMap(toProjectIdItem, ClientUtil.getPlateId());
        toProjectIdItem.addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent event) {
                int projectId = ClientUtil.checkAndGetIntValue(event.getValue());
                if(projectId > 0){
                    //获取目标项目ID
                    int fromProjectId = ClientUtil.checkAndGetIntValue(fromProjectIdItem.getValue());
                    if(fromProjectId == projectId){
                        SC.say("提示","该项目已被选择为积分提取项目");
                        toProjectIdItem.clearValue();
                        return;
                    }
                    getReserveInteralByProjectId(projectId, 2);
                }
            }
        });
        
        toIntegralItem = new TextItem("toIntegral","积分追加项目预留积分");
        toIntegralItem.setWidth("*");
        toIntegralItem.setDisabled(true);
        toIntegralItem.setDefaultValue(0);

        transferIntegralItem = new SpinnerItem("transferIntegral", "转移积分");
        transferIntegralItem.setMin(0);  
        transferIntegralItem.setStep(500f);  
        transferIntegralItem.setWriteStackedIcons(false);
        transferIntegralItem.setDefaultValue(0);
        transferIntegralItem.setWidth("*");
        transferIntegralItem.setColSpan(4);
        transferIntegralItem.setRowSpan(1);
        transferIntegralItem.addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent event) {
                //获取目标项目ID
                int fromProjectId = ClientUtil.checkAndGetIntValue(fromProjectIdItem.getValue());
                if(fromProjectId <= 0){
                    SC.say("提示","请先选择一个积分提取项目");
                    transferIntegralItem.setValue(0);
                    return;
                }
                //获取归属项目ID
                int toProjectId = ClientUtil.checkAndGetIntValue(toProjectIdItem.getValue());
                if(toProjectId <= 0){
                    SC.say("提示","请先选择一个积分追加项目项目");
                    transferIntegralItem.setValue(0);
                    return;
                }
                //获取新输入的积分值
                double newValue = ClientUtil.checkAndGetDoubleValue(event.getValue());
                //获取改变前的值
                double oldValue = ClientUtil.checkAndGetDoubleValue(event.getOldValue());
                //获取改变后与改变前的差值
                double finalValue = newValue - oldValue;
                //更新目标项目的预留积分
                fromIntegralItem.setValue(ClientUtil.checkAndGetDoubleValue(fromIntegralItem.getValue())-finalValue);
                //更新归属项目的预留积分
                toIntegralItem.setValue(ClientUtil.checkAndGetDoubleValue(toIntegralItem.getValue())+finalValue);
            }
        });

        remarkItem = new TextAreaItem("remark", "备注");
        remarkItem.setColSpan(4);
        remarkItem.setRowSpan(3);
        remarkItem.setWidth("*");

        form.setItems(fromProjectIdItem,fromIntegralItem, toProjectIdItem,toIntegralItem, transferIntegralItem, remarkItem);
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
                //获取目标项目ID
                int fromProjectId = ClientUtil.checkAndGetIntValue(fromProjectIdItem.getValue());
                if(fromProjectId <= 0){
                    SC.say("提示","请选择一个积分提取项目");
                    return;
                }
                //获取归属项目ID
                int toProjectId = ClientUtil.checkAndGetIntValue(toProjectIdItem.getValue());
                if(toProjectId <= 0){
                    SC.say("提示","请选择一个积分追加项目");
                    return;
                }
                //获取转移积分
                double transferIntegral = ClientUtil.checkAndGetDoubleValue(transferIntegralItem.getValue());
                if(transferIntegral <= 0){
                    SC.say("提示","请输入您要转移的积分");
                    return;
                }
                //获取备注
                String remark = (String)remarkItem.getValue();
                //获取当前板块负责人的ID
                int plateEmployeeId = ClientUtil.checkAndGetIntValue(Cookies.getCookie(ClientUtil.OPRERATORID_COOKIE));
                //获取当前板块负责人的板块ID
                int plateId = ClientUtil.checkAndGetIntValue(Cookies.getCookie(ClientUtil.OPRERATOR_PLATEID_COOKIE));
                LinkedHashMap map = new LinkedHashMap();
                map.put("fromProjectId", fromProjectId);
                map.put("toProjectId", toProjectId);
                map.put("transferIntegral", transferIntegral);
                map.put("toProjectId", toProjectId);
                map.put("plateEmployeeId", plateEmployeeId);
                map.put("plateId", plateId);
                map.put("remark", remark);
                DBDataSource.callOperation("EP_OnProjectReserveIntegral", map, new DSCallback() {
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
     * @param type：1：积分提取项目;2:积分追加项目
     */
    protected void getReserveInteralByProjectId(int projectId,final int type){
        LinkedHashMap map = new LinkedHashMap();
        map.put("projectId", projectId);
        DBDataSource.callOperation("EP_OnGetProjectReserveIntegral", map, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                    Record result = dsResponse.getData()[0];
                    //获取该项目的预留积分
                    double reserveIntegral = ClientUtil.checkAndGetDoubleValue(result.getAttribute("integral"));
                    if(type == 1){
                        fromIntegralItem.setValue(reserveIntegral);
                        //根据目标项目的预留积分，设置可转移的最大积分为该目标项目的预留积分
                        transferIntegralItem.setMax(reserveIntegral);
                    }else if(type == 2){
                        toIntegralItem.setValue(reserveIntegral);
                    }
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
