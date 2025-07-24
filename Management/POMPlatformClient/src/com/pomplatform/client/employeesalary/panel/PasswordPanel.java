package com.pomplatform.client.employeesalary.panel;


import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.PasswordItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PasswordPanel extends VLayout implements HasHandlers {

    private final PasswordItem passwordItem;
    private final VLayout vLayout;
    private Window parentWindow;
    private final IButton saveButton;
    private final IButton cancelButton;
    private final DynamicForm form = new DynamicForm();
    private final HLayout buttonLayout;
    protected final HandlerManager handlerManager = new HandlerManager(this);

    public Window getParentWindow() {
        return parentWindow;
    }

    public void setParentWindow(Window parentWindow) {
        this.parentWindow = parentWindow;
    }

    public PasswordPanel() {

        vLayout = new VLayout();
        vLayout.setWidth100();
        vLayout.setHeight100();


        passwordItem = new PasswordItem();
        passwordItem.setName("password");
        passwordItem.setTitle("确认秘钥");
        form.setItems(passwordItem);

        vLayout.addMember(form);

        addMember(vLayout);

        saveButton = new IButton("确定", new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                DataEditEvent dee = new DataEditEvent();
                Record record = new Record();
                record.setAttribute("password", passwordItem.getValue());
                dee.setData(record);
                fireEvent(dee);
                getParentWindow().destroy();
            }
        });

        cancelButton = new IButton("取消", new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (null == getParentWindow()) {
                    return;
                }

                getParentWindow().destroy();
            }
        });

        buttonLayout = new HLayout();
        buttonLayout.setWidth100();
        buttonLayout.setHeight100();
        buttonLayout.setMargin(8);
        buttonLayout.setMembersMargin(20);
        buttonLayout.setAlign(Alignment.CENTER);
        buttonLayout.addMember(saveButton);
        buttonLayout.addMember(cancelButton);

        vLayout.addMember(buttonLayout);


    }

    public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
        return handlerManager.addHandler(DataEditEvent.TYPE, handler);
    }

    @Override
    public void fireEvent(GwtEvent<?> event) {
        handlerManager.fireEvent(event);
    }

}