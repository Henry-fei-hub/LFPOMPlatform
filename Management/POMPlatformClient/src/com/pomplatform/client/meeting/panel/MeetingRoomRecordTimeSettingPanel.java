package com.pomplatform.client.meeting.panel;

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
import com.smartgwt.client.data.Record;
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

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * 会议室时间区间设置
 *
 * @author xiaolong
 */
public class MeetingRoomRecordTimeSettingPanel extends VLayout implements HasHandlers {
    private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";

    private static final Logger logger = Logger.getLogger("MeetingRoomRecordTimeSettingPanel");
    private final DynamicForm form = new DynamicForm();
    private final VLayout vLayout;
    private final IButton saveButton;
    private final IButton cancelButton;
    private final HLayout buttonLayout;
    private Window parentWindow;
    protected final HandlerManager handlerManager = new HandlerManager(this);

    private final SelectItem outTimeItem;
    private final SelectItem pushTimeItem;

    private Integer processType;

    public Integer getProcessType() {
        return processType;
    }

    public void setProcessType(Integer processType) {
        this.processType = processType;
    }

    public Window getParentWindow() {
        return parentWindow;
    }

    public void setParentWindow(Window parentWindow) {
        this.parentWindow = parentWindow;
    }

    public MeetingRoomRecordTimeSettingPanel() {
        vLayout = new VLayout();
        vLayout.setWidth100();
        vLayout.setHeight100();
        vLayout.setMargin(10);
        vLayout.setMembersMargin(12);

        outTimeItem = new SelectItem("outTimeItem", shouldNotBeNull + "超时时间设置(超过预约时间未确认会议自动取消)");
        Map<Integer, Integer> outTimeMap = new HashMap<>();
        outTimeMap.put(0, 5);
        outTimeMap.put(1, 10);
        outTimeMap.put(2, 15);
        outTimeItem.setValueMap(outTimeMap);
        outTimeItem.setWidth("*");

        pushTimeItem = new SelectItem("pushTimeItem", shouldNotBeNull + "推送时间设置(会议开始前推送提醒通知)");
        Map<Integer, Integer> pushTimeMap = new HashMap<>();
        pushTimeMap.put(0, 5);
        pushTimeMap.put(1, 10);
        pushTimeMap.put(2, 15);
        pushTimeItem.setValueMap(pushTimeMap);
        pushTimeItem.setWidth("*");

        form.setNumCols(1);
        form.setItems(outTimeItem, pushTimeItem);
        ClientUtil.DynamicFormProcessAccordingToDevice(form);
        vLayout.addMember(form);
        form.setWidth100();
        form.setHeight100();


        saveButton = new IButton("保存", new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                SC.debugger();

                Map<String, Object> params = new HashMap<>(0);
                params.put("outTime", outTimeItem.getValue());
                params.put("pushTime", pushTimeItem.getValue());
                params.put("opt_type", "settingMeetingRecordTime");
                DBDataSource.callOperation("EP_MeetingRoomProcessor", params, new DSCallback() {
                    @Override
                    public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
                        if (dsResponse.getStatus() >= 0) {
                            SC.say("提示", "修改预约时间成功");
                            getParentWindow().destroy();
                        } else {
                            ClientUtil.displayErrorMessage(dsResponse);
                        }
                    }
                });
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
        buttonLayout.setHeight(20);
        buttonLayout.setMargin(8);
        buttonLayout.setMembersMargin(20);
        buttonLayout.setAlign(Alignment.CENTER);
        buttonLayout.addMember(saveButton);
        buttonLayout.addMember(cancelButton);
        vLayout.addMember(buttonLayout);
        addMember(vLayout);
    }

    /**
     * 加载数据将数据库中的数据显示出来
     */
//    @Override
//    protected void onLoad() {
//        Map<String, Object> params = new HashMap<>(0);
//        params.put("opt_type", "getMeetingRecordTime");
//        DBDataSource.callOperation("EP_MeetingRoomProcessor", params, new DSCallback() {
//            @Override
//            public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
//                if (dsResponse.getStatus() >= 0) {
//                    logger.info(dsResponse.getDataSource()+"=============获取数据");
//                    getParentWindow().destroy();
//                } else {
//                    ClientUtil.displayErrorMessage(dsResponse);
//                }
//            }
//        });
//    }

    @Override
    public void fireEvent(GwtEvent<?> event) {
        handlerManager.fireEvent(event);
    }

    public Record getValueAsRecord() {
        return form.getValuesAsRecord();
    }

    public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
        return handlerManager.addHandler(DataEditEvent.TYPE, handler);
    }
}
