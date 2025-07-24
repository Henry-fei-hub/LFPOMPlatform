package com.pomplatform.client.common;

import com.delicacy.client.MapUtils;
import com.pomplatform.client.operation.panel.*;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteHandler;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.util.SC;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.smartgwt.client.util.Browser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class UploadSubContract extends PopupWindow implements HasHandlers {

    private Map<String, Object> params = new HashMap<>();
    
    public UploadSubContract(final int contractId) {
        super("文件上传");
        setWidth("50%");
        setHeight("50%");
        centerInPage();
        params.put("contractId", contractId);
        if (!Browser.getIsDesktop()) {
            setWidth100();
            setHeight100();
        }
        final FormPanel formPanel = new FormPanel();
        formPanel.setMethod(FormPanel.METHOD_POST);// 设置提交的方式为post 文件上传必须使用这个方式
        formPanel.setEncoding(FormPanel.ENCODING_MULTIPART);// 设置上传文件时使用的编码方式 （必须使用此方式）
        formPanel.setWidth("100%");
        formPanel.setHeight("100%");
        formPanel.addSubmitCompleteHandler(new SubmitCompleteHandler() {
            @Override
            public void onSubmitComplete(SubmitCompleteEvent event) {
                try {
                    destroy();
                    DSResponse res = DBDataSource.processHttpResponse(event.getResults());
                    if (res.getStatus() >= 0) {
//                        SC.say("项目经费导入成功");
                    } else {
                        SC.say("导入失败:" + res.getErrors());
                    }
                    DataEditEvent dee = new DataEditEvent();
                    dee.setData(res.getData()[0]);
                    fireEvent(dee);
                } catch (Exception ex) {
                }
            }
        });

        Button cancelButton = new Button("取消");
        cancelButton.setWidth("100px");
        Button uploadButton = new Button("上传");
        uploadButton.setWidth("100px");
        
        cancelButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                destroy();
            }
        });

        FlexTable btnLayout = new FlexTable();
        btnLayout.getElement().getStyle().setMarginLeft(100, Unit.PX);
        btnLayout.setWidget(0, 0, cancelButton);
        btnLayout.setWidget(0, 1, uploadButton);

        final FlexTable vertical = new FlexTable();
        vertical.getElement().getStyle().setMarginLeft(100, Unit.PX);
        vertical.setWidth("100%");
        vertical.setHeight("100%");
        vertical.setCellPadding(1);
        vertical.setCellSpacing(15);
        formPanel.setWidget(vertical);

        for (int i = 0; i < 5; i++) {
            vertical.setText(i, 0, "");
        }
        final FileUpload fileUpload = new FileUpload();
        fileUpload.setName("上传文件");
        vertical.setWidget(2, 0, fileUpload);
        vertical.setHTML(3, 0, "<span><b>注:支持上传文件包括(.xls)</b></span>");

        for (int i = 0; i < 4; i++) {
            vertical.getRowFormatter().getElement(i).getStyle().setHeight(30, Unit.PX);
        }
        vertical.getColumnFormatter().setWidth(0, "100px");
        vertical.getFlexCellFormatter().setColSpan(3, 0, 2);
        DockLayoutPanel global = new DockLayoutPanel(Unit.PX);
        global.setWidth("100%");
        global.setHeight("100%");
        global.addSouth(btnLayout, 40);
        global.add(formPanel);
        this.addItem(global);

        uploadButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                String fileName1 = fileUpload.getFilename();// 获取文件的名称和路径
                vertical.setWidget(4, 0, MapUtils.generateFormDataForUpload(params));
                if (fileName1 == null || fileName1.trim().length() <= 0) {
                    SC.say("请点击 选择文件 按钮选择你要上传的文件");
                    return;
                }
                if (!ClientUtil.isExcelFile(fileName1)) {
                    SC.say("上传失败，文件格式格式不对。");
                    return;
                }
                formPanel.setAction(DBDataSource.getServerURL("UP_UploadSubContract"));
                formPanel.submit();
            }
        });
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
