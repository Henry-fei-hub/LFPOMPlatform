package com.pomplatform.client.employeenew.form;

import com.delicacy.client.MapUtils;
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
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author Guangxun
 */
public class SemployeeSetLeaveForm extends HLayout implements HasHandlers {

    private Window parentWindow;
    private static Logger __logger = Logger.getLogger("");

    public SemployeeSetLeaveForm() {
    }

    public void initComponents(final String employeeId,final String employeeNo,final String employeeName) {
        setWidth100();
        setHeight100();
        setPadding(10);
        setMembersMargin(5);

        VLayout formLayout = new VLayout();
        formLayout.setHeight100();
        formLayout.setMembersMargin(5);
        formLayout.setWidth("50%");
        formLayout.setAlign(Alignment.CENTER);
        addMember(formLayout);

        HLayout messageLayout = new HLayout();
        messageLayout.setWidth100();
        messageLayout.setHeight100();
        messageLayout.setAlign(Alignment.CENTER);

        final DynamicForm form = new DynamicForm();
        form.setNumCols(2);
        form.setAlign(Alignment.CENTER);
        form.setWidth100();
        form.setHeight100();
        final TextItem employeeNoItem = new TextItem("employeeNo", "职员账号");
        employeeNoItem.setWidth("*");
        employeeNoItem.setDisabled(true);
        employeeNoItem.setDefaultValue(employeeNo);
        final TextItem employeeNameItem = new TextItem("employeeName", "职员姓名");
        employeeNameItem.setWidth("*");
        employeeNameItem.setDisabled(true);
        employeeNameItem.setDefaultValue(employeeName);
        final SelectItem Status = new SelectItem("status", "职员状态");
        Status.setWidth("*");
        Status.setRequired(true);
        Status.setDefaultValue(1);//设置离职
        Status.setCanEdit(false);
        Status.setValueMap((LinkedHashMap) KeyValueManager.getValueMap("system_dictionary_11"));

        final DateItem resignationDate = new DateItem("resignationDate", "离职日期");
        resignationDate.setRequired(false);
        resignationDate.setWidth("*");
        
        form.setItems(employeeNoItem,employeeNameItem,Status, resignationDate);
        messageLayout.addMember(form);
        formLayout.addMember(messageLayout);
        ClientUtil.DynamicFormProcessAccordingToDevice(form);
        HLayout btnLayout = new HLayout();
        btnLayout.setWidth100();
        btnLayout.setHeight("50%");
        btnLayout.setMembersMargin(10);
        btnLayout.setAlign(Alignment.CENTER);

        IButton okBtn = new IButton("Save");
        okBtn.setIcon("[SKIN]/actions/save.png");
        okBtn.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                if (!form.validate()) {
                    return;
                }
                Map param = new LinkedHashMap();
                param.put("status", Status.getValue());
                param.put("resignationDate", resignationDate.getValue());
                param.put("employeeId", employeeId);
                String message = MapUtils.toJSON(param);
                DBDataSource.callOperation("EP_EmployeeSetLeave", message, new DSCallback() {
                    @Override
                    public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                        if (dsResponse.getStatus() >= 0) {
                            SC.say("Success");
                            if (getParentWindow() == null) {
                                return;
                            }
                            getParentWindow().destroy();
                            DataEditEvent dee = new DataEditEvent();
                            fireEvent(dee);
                            
                        } else {
                            SC.say("Failure." + dsResponse.getErrors().get("errorMsg"));
                        }
                    }
                });
            }
        });
        IButton cleanBtn = new IButton("Close");
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

    public Window getParentWindow() {
        return parentWindow;
    }

    public void setParentWindow(Window parentWindow) {
        this.parentWindow = parentWindow;
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

}
