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

public class SetPlateIntegralTransfer extends HLayout implements HasHandlers {

    private Window parentWindow;
    private static Logger __logger = Logger.getLogger("");
    private ComboBoxItem fromPlateIdItem;
    private ComboBoxItem toPlateIdItem;
    private TextItem fromIntegralItem;
    private TextItem toIntegralItem;
    private SpinnerItem transferIntegralItem;
    private TextAreaItem remarkItem;
    private DateItem transferDateItem;

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

        fromPlateIdItem = new ComboBoxItem("fromPlateId", "积分提取部门");
        fromPlateIdItem.setWidth("*");
        fromPlateIdItem.setCanEdit(false);
        //设置默认为当前操作人的业务部门
        fromPlateIdItem.setDefaultValue(ClientUtil.getPlateId());
        fromPlateIdItem.setChangeOnKeypress(false);
        fromPlateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));

        fromIntegralItem = new TextItem("fromIntegral", "积分提取部门(价值积分)");
        fromIntegralItem.setWidth("*");
        fromIntegralItem.setDisabled(true);
        fromIntegralItem.setDefaultValue(0);

        toPlateIdItem = new ComboBoxItem("toPlateId", "积分追加部门");
        toPlateIdItem.setWidth("*");
        toPlateIdItem.setChangeOnKeypress(false);
        toPlateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
        toPlateIdItem.addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent event) {
                int plateId = ClientUtil.checkAndGetIntValue(event.getValue());
                if (plateId > 0) {
                    //获取积分提取部门ID
                    int fromPlateId = ClientUtil.getPlateId();
                    if (fromPlateId == plateId) {
                        SC.say("提示", "该部门已被选择为积分提取部门");
                        toPlateIdItem.clearValue();
                        return;
                    }
                }
            }
        });

        toIntegralItem = new TextItem("toIntegral", "积分追加部门积分");
        toIntegralItem.setWidth("*");
        toIntegralItem.setDisabled(true);
        toIntegralItem.setDefaultValue(0);
        
        transferDateItem = new DateItem("transferDate","转移日期");
        transferDateItem.setWidth("*");
        transferDateItem.setDefaultValue(new Date());
        transferDateItem.setShowIcons(false);
        transferDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);

        transferIntegralItem = new SpinnerItem("transferIntegral", "转移积分");
        transferIntegralItem.setMin(0);
        transferIntegralItem.setStep(500f);
        transferIntegralItem.setWriteStackedIcons(false);
        transferIntegralItem.setDefaultValue(0);
        transferIntegralItem.setWidth("*");
//        transferIntegralItem.setColSpan(4);
//        transferIntegralItem.setRowSpan(1);
        transferIntegralItem.addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent event) {
                //获取积分提取部门ID
                int fromPlateId = ClientUtil.getPlateId();
                if (fromPlateId <= 0) {
                    SC.say("提示", "未获取到当前操作人的部门");
                    transferIntegralItem.setValue(0);
                    return;
                }
                //获取归属部门ID
                int toPlateId = ClientUtil.checkAndGetIntValue(toPlateIdItem.getValue());
                if (toPlateId <= 0) {
                    SC.say("提示", "请先选择一个积分追加部门");
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
                fromIntegralItem.setValue(ClientUtil.checkAndGetDoubleValue(fromIntegralItem.getValue()) - finalValue);
                //更新归属项目的预留积分
                toIntegralItem.setValue(ClientUtil.checkAndGetDoubleValue(toIntegralItem.getValue()) + finalValue);
            }
        });

        remarkItem = new TextAreaItem("remark", "备注");
        remarkItem.setColSpan(4);
        remarkItem.setRowSpan(3);
        remarkItem.setWidth("*");

        form.setItems(fromPlateIdItem, fromIntegralItem, toPlateIdItem, toIntegralItem,transferDateItem, transferIntegralItem, remarkItem);
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
                //获取积分提取部门ID
                int fromPlateId = ClientUtil.getPlateId();
                if (fromPlateId <= 0) {
                    SC.say("提示", "未获取到当前操作人的部门");
                    transferIntegralItem.setValue(0);
                    return;
                }
                //获取归属部门ID
                int toPlateId = ClientUtil.checkAndGetIntValue(toPlateIdItem.getValue());
                if (toPlateId <= 0) {
                    SC.say("提示", "请先选择一个积分追加部门");
                    transferIntegralItem.setValue(0);
                    return;
                }
                //获取转移积分
                double transferIntegral = ClientUtil.checkAndGetDoubleValue(transferIntegralItem.getValue());
                if (transferIntegral <= 0) {
                    SC.say("提示", "请输入您要转移的积分");
                    return;
                }
                
                int plateEmployeeId = ClientUtil.getEmployeeId();
                //获取结算日期
                Date transferDate = transferDateItem.getValueAsDate();
                //获取备注
                String remark = (String) remarkItem.getValue();
                LinkedHashMap map = new LinkedHashMap();
                map.put("fromPlateId", fromPlateId);
                map.put("toPlateId", toPlateId);
                map.put("transferIntegral", transferIntegral);
                map.put("plateEmployeeId", plateEmployeeId);
                map.put("transferDate", transferDate);
                map.put("remark", remark);
                DBDataSource.callOperation("EP_OnPlateReserveIntegral", map, new DSCallback() {
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
        //加载页面是加载数据，获取当前操作人的部门的可结算的预留积分
        int plateId = ClientUtil.getPlateId();
        getReserveInteralByProjectId(plateId);
    }

    /**
     * 根据选择下拉的获取业务部门可结算的预留积分
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
                    //获取该业务部门可结算的预留积分
                    double achieveIntegral = ClientUtil.checkAndGetDoubleValue(result.getAttribute("achieveIntegral"));
                    fromIntegralItem.setValue(achieveIntegral);
                    //根据目标部门的价值积分，设置可转移的最大积分为该目标部门的价值积分
                    transferIntegralItem.setMax(achieveIntegral);
                } else {
                    SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
                }
            }
        });
    }
    ;
    
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
