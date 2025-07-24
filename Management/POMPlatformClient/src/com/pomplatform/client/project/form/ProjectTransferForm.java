package com.pomplatform.client.project.form;

import com.delicacy.client.MapUtils;
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
import com.smartgwt.client.widgets.form.fields.SelectItem;
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
public class ProjectTransferForm extends HLayout implements HasHandlers {

    
    private Window parentWindow;
    private static Logger __logger = Logger.getLogger("");

    public ProjectTransferForm() {
    }

    public void initComponents(final String projectId) {
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
        final SelectItem designPhase = new SelectItem("designPhase", "设计阶段");
        designPhase.setWidth("*");
        designPhase.setRequired(true);
        designPhase.setValueMap((LinkedHashMap) KeyValueManager.getValueMap("system_dictionary_7"));

        form.setItems(designPhase);
        messageLayout.addMember(form);
        formLayout.addMember(messageLayout);

        HLayout btnLayout = new HLayout();
        btnLayout.setWidth100();
        btnLayout.setHeight(70);
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
                param.put("designPhase", designPhase.getValue());
                param.put("projectId", projectId);
                String message = MapUtils.toJSON(param);
                DBDataSource.callOperation("EP_ProjectTransfer", message, new DSCallback() {
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
