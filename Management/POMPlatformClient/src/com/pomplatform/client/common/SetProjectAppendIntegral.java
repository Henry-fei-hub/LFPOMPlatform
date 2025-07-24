package com.pomplatform.client.common;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
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
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Logger;

public class SetProjectAppendIntegral extends HLayout implements HasHandlers {

    private Window parentWindow;
    private static Logger __logger = Logger.getLogger("");
    private TextItem projectNameItem;
    private SpinnerItem appendIntegralItem;
    private TextAreaItem remarkItem;
    private TextItem percentageItem;

    /**
     * 
     * @param flag:true:表示板块运营负责人的操作;false:表示运营部门人的操作
     * @param projectName
     * @param projectId
     * @param totalIntegral
     * @param projectIntegral
     * @param reserveIntegral
     * @param appendTotalIntegral
     * @param appendIntegral
     * @param remark 
     */
    public void initComponents(final boolean flag,final String projectName, final int projectId, final double totalIntegral, final double projectIntegral, final double reserveIntegral, final double appendTotalIntegral, final int appendIntegral, final String remark) {
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

        appendIntegralItem = new SpinnerItem("appendIntegral", "追加积分");
        if(flag)appendIntegralItem.setCanEdit(false);
        appendIntegralItem.setMin(0);  
        appendIntegralItem.setMax(999999999);  
        appendIntegralItem.setStep(100f);  
        appendIntegralItem.setWriteStackedIcons(false);
        appendIntegralItem.setDefaultValue(appendIntegral);
        appendIntegralItem.setWidth("*");

        percentageItem = new TextItem("percentage", "核算比例");
        if(!flag)percentageItem.hide();
        percentageItem.setDefaultValue(30);
        percentageItem.setWidth("*");

        remarkItem = new TextAreaItem("remark", "备注");
        remarkItem.setColSpan(2);
        remarkItem.setRowSpan(3);
        remarkItem.setDefaultValue(remark);
        remarkItem.setWidth("*");

        form.setItems(projectNameItem, appendIntegralItem, percentageItem, remarkItem);
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
                int appendIntegralValue = ClientUtil.checkAndGetIntValue(appendIntegralItem.getValue());
                String percentageValue = "0";
                if(flag) percentageValue = (String) percentageItem.getValue();
                String remarkValue = (String) remarkItem.getValue();
                
                LinkedHashMap map = new LinkedHashMap();
                map.put("flag", flag);
                map.put("projectId", projectId);
                map.put("totalIntegral", totalIntegral);
                map.put("projectIntegral", projectIntegral);
                map.put("reserveIntegral", reserveIntegral);
                map.put("appendTotalIntegral", appendTotalIntegral);
                map.put("appendIntegral", appendIntegralValue);
                map.put("percentage", percentageValue);
                map.put("remark", remarkValue);
                DBDataSource.callOperation("EP_OnSetProjectAppendIntegral", map, new DSCallback() {
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
