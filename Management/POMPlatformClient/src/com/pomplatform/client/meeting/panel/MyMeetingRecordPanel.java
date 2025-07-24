package com.pomplatform.client.meeting.panel;

import com.delicacy.client.MapUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyMenuMain;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.LoadingWindow;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.meeting.datasource.MeetingInfoBase;
import com.pomplatform.client.meeting.form.MyMeetingRoomservaTionSearchForm;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * 我的预约记录界面
 * @author xiaolong
 */
public class MyMeetingRecordPanel extends AbstractSearchPanel implements HasHandlers {
    private static final Logger __LOGGER = Logger.getLogger("MeetingRoomRecordShiftPanel");

    public static class Factory implements PanelFactory {
        private String id;

        @Override
        public Canvas create() {
            MyMeetingRecordPanel cm = new MyMeetingRecordPanel();
            id = cm.getID();
            __LOGGER.info("面板初始化时获取的id===============" + cm.getMeetingRelevanceId());
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "MeetingInfoBase";
        }

    }

    @Override
    public void init() {
        super.init();
        __controlPosition = LayoutConstant.RIGHT;

        /**
         * 添加选择框
         */
        resultGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
    }

    @Override
    public void initComponents() {
        commonQuery();
        getRecords();
    }

    /**
     * 获取所有记录
     */
    public void getRecords() {
        IButton confirmMeeting = new IButton("确认会议");
        controlLayout.addMember(confirmMeeting);
        confirmMeeting.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (!resultGrid.anySelected()) {
                    SC.say("请选择一条数据或多条数据进行修改");
                } else {
                    Map<String, Object> param = new HashMap<>(0);
                    MapUtils.convertRecordToMap(resultGrid, resultGrid.getSelectedRecords(), param, "meetings");
                    param.put("optType", "updateMeetingInfo");
                    DBDataSource.callOperation("EP_MeetingInfoProcessor", param, new DSCallback() {
                        @Override
                        public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                            SC.debugger();
                            if (dsResponse.getStatus() >= 0) {
                                SC.say("会议室激活成功");
                                commonQuery();
                            } else {
                                SC.say(dsResponse.getErrors().get("errorMsg").toString());
                            }
                        }
                    });
                }
            }
        });

    }


    /**
     * 自定义的查询
     */
    @Override
    public void commonQuery() {

        if (!DelicacyMenuMain.checkLogin()) {
            destroy();
            return;
        }
        Map condition = generateCriteria();
        if (condition == null) {
            return;
        }
        if (searchForm != null) {
            searchButton.setIcon("loading38.gif");
        }

        DBDataSource ds = (DBDataSource) getDataSource();
        String operationName = ds.getActionMode() + ds.getActionName();

        condition.put("meetingRelevanceId", meetingRelevanceId);
        final LoadingWindow loading = new LoadingWindow();
        DBDataSource.callOperation(operationName, "find", condition, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                loading.destroy();
                if (searchForm != null) {
                    searchButton.setIcon("[SKIN]/actions/search.png");
                }
                if (dsResponse.getStatus() >= 0) {
                    resultGrid.setData(dsResponse.getData());
                    afterDataReceived(dsResponse.getData());
                    if (isNeedPagenation() && pager != null) {
                        if (currentPage == 1) {
                            totalPages = dsResponse.getAttributeAsInt("totalPages");
                            pager.getTotalPages().setContents(String.valueOf(totalPages));
                        }
                    }
                } else {
                    SC.say(dsResponse.getErrors().get("errorMsg").toString());
                }
                if (showPagination() && pager != null) {
                    pager.getCurrentPage().setContents(String.valueOf(currentPage));
                }
            }
        });
    }

    @Override
    public boolean checkSearchCriteria(Map criteria) {
        criteria.put("optType", "getMeetingRecord");
        //如果拥有查看所有会议记录的权限
        if (!ClientUtil.checkIsHavePermission(ERPPermissionStatic.METING_RECORD_ALL)) {
            criteria.put("employeeId", ClientUtil.getUserId());
        }
        return true;
    }

    @Override
    public SearchForm generateSearchForm() {
        return new MyMeetingRoomservaTionSearchForm();
    }

    @Override
    public DataSource getDataSource() {
        return MeetingInfoBase.getInstance();
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


    private int meetingRelevanceId;

    public int getMeetingRelevanceId() {
        return meetingRelevanceId;
    }

    public void setMeetingRelevanceId(int meetingRelevanceId) {
        this.meetingRelevanceId = meetingRelevanceId;
    }

}
