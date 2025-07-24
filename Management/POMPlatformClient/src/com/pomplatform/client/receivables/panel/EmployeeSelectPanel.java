package com.pomplatform.client.receivables.panel;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.receivables.form.InvoiceReportDetailForm;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

import java.util.HashMap;

public class EmployeeSelectPanel extends VLayout implements HasHandlers {
    private final TextItem projectManagerIdItem;
    private final DynamicForm searchForm = new DynamicForm();
    private IButton saveButton = new IButton("确定");
    private IButton cancelButton = new IButton("取消");
    private VLayout topLayout;
    private HLayout bottomLayout;
    private Record record;
    private InvoiceReportDetailForm parentPanel;
    private PopupWindow paraentWindow;
    protected final HandlerManager handlerManager = new HandlerManager(this);

    public PopupWindow getParaentWindow() {
        return paraentWindow;
    }

    public void setParaentWindow(PopupWindow paraentWindow) {
        this.paraentWindow = paraentWindow;
    }

    public InvoiceReportDetailForm getParentPanel() {
        return parentPanel;
    }

    public void setParentPanel(InvoiceReportDetailForm parentPanel) {
        this.parentPanel = parentPanel;
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    @Override
    public void fireEvent(GwtEvent<?> event) {
        handlerManager.fireEvent(event);
    }

    public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
        return handlerManager.addHandler(DataEditEvent.TYPE, handler);
    }

    public EmployeeSelectPanel() {

        setWidth100();
        setHeight100();
        //顶层面板
        topLayout = new VLayout();
        topLayout.setWidth("100%");
        topLayout.setHeight("30%");
        topLayout.setLayoutRightMargin(10);
        addMember(topLayout);

        //底层面板
        bottomLayout = new HLayout();
        bottomLayout.setWidth("100%");
        bottomLayout.setHeight("70%");
        bottomLayout.setLayoutLeftMargin(100);
        bottomLayout.setLayoutTopMargin(25);
        bottomLayout.addMember(saveButton);
        bottomLayout.addMember(cancelButton);
        addMember(bottomLayout);

        projectManagerIdItem = new ComboBoxItem("projectManagerId", "项目经理");
        projectManagerIdItem.setWidth("*");
        KeyValueManager.loadValueMap("employees",projectManagerIdItem);
        searchForm.setHeight("100%");
        searchForm.setWidth("100%");
        searchForm.setItems(projectManagerIdItem);
        topLayout.addMember(searchForm);
        //保存按钮的单击事件
        saveButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                int employeeId = BaseHelpUtils.getIntValue(projectManagerIdItem.getValue());
                Record record = getRecord();
                String contractCode = BaseHelpUtils.getString(record.getAttribute("contractCode"));
                String projectManagerName = BaseHelpUtils.getString(projectManagerIdItem.getDisplayValue());
                int invoiceId = BaseHelpUtils.getIntValue(record.getAttribute("invoiceId"));
                SC.confirm("确认将合同编号为：" + contractCode + "的发票的项目经理更改为：" + projectManagerName, new BooleanCallback() {
                    @Override
                    public void execute(Boolean aBoolean) {
                        HashMap<String, Object> params = new HashMap<>();
                          params.put("optType","updateProjectManager");
                          params.put("projectMangerId",employeeId);
                          params.put("invoiceId",invoiceId);
                          DBDataSource.callOperation("EP_CapitalAndInvoiceProcessor", params, new DSCallback() {
                              @Override
                              public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
                                  if (dsResponse.getStatus() >= 0){
                                      DataEditEvent dee = new DataEditEvent();
                                      fireEvent(dee);
                                      paraentWindow.destroy();
                                  }
                              }
                          });
                    }
                });
            }
        });
        //取消事件的按钮
        cancelButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                paraentWindow.destroy();
            }
        });

    }
}
