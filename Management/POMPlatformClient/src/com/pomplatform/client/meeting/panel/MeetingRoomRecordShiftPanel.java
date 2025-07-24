package com.pomplatform.client.meeting.panel;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.*;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.meeting.datasource.MeetingInfoBase;
import com.pomplatform.client.meeting.form.MyMeetingRoomservaTionSearchForm;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * 会议室记录表
 *
 * @author xiaolong
 */
public class MeetingRoomRecordShiftPanel extends AbstractSearchPanel implements HasHandlers {
    private static final Logger __LOGGER = Logger.getLogger("MeetingRoomRecordShiftPanel");

    public static class Factory implements PanelFactory {
        private String id;

        @Override
        public Canvas create() {
            MeetingRoomRecordShiftPanel cm = new MeetingRoomRecordShiftPanel();
            id = cm.getID();
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
        resultGrid.setAutoFitFieldWidths(false);
        __controlPosition = LayoutConstant.RIGHT;
    }

    @Override
    public void initComponents() {

        commonQuery();

        IButton refreshButton = new IButton("刷新");
        controlLayout.addMember(refreshButton);
        refreshButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                commonQuery();
            }
        });

        IButton lookMeetingRoomButton = new IButton("查看会议室状态");
        controlLayout.addMember(lookMeetingRoomButton);
        lookMeetingRoomButton.hide();
        lookMeetingRoomButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                MeetingRoomStatusPanel panel = new MeetingRoomStatusPanel();
                PopupWindow window = new PopupWindow();
                window.addMember(panel);
                window.setTitle("查看会议室状态");
                window.setWidth100();
                window.setHeight100();
                window.centerInPage();
                window.show();
            }
        });


        resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
            @Override
            public void onDoubleClick(DoubleClickEvent event) {
                showDetail();
            }
        });


        /**
         * 确认会议并激活，只有已激活的会议室才可以使用
         */
        IButton myReservationButton = new IButton("确认会议");
        controlLayout.addMember(myReservationButton);
        myReservationButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {

                if (!resultGrid.anySelected()) {
                    SC.say("请选择一条数据");
                    return;
                }

                ListGridRecord gridRecord = resultGrid.getSelectedRecord();
                int status = BaseHelpUtils.getIntValue(gridRecord.getAttribute("status"));
                int meetingStatus = BaseHelpUtils.getIntValue(gridRecord.getAttribute("meetingStatus"));
                int meetingRelevanceId = BaseHelpUtils.getIntValue(gridRecord.getAttribute("meetingRelevanceId"));

                if (status == 1) {
                    SC.ask("提示", "确认激活该条会议记录？", new BooleanCallback() {
                        @Override
                        public void execute(Boolean value) {
                            if (value) {
                                Map<String, Object> param = new HashMap<>(0);
                                param.put("meetingRelevanceId", meetingRelevanceId);
                                param.put("meetingStatus", meetingStatus);
                                param.put("optType", "updateMeetingInfo");

                                DBDataSource.callOperation("EP_MeetingInfoProcessor", param, new DSCallback() {
                                    @Override
                                    public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {

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
                } else {
                    SC.say("只能激活已预约状态的会议记录");
                }

            }
        });


        /**
         * 取消预约
         */
        IButton cancelReservation = new IButton("取消预约");
        controlLayout.addMember(cancelReservation);
        cancelReservation.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                if (!resultGrid.anySelected()) {
                    SC.say("请选择一条数据");
                    return;
                }
                ListGridRecord gridRecord = resultGrid.getSelectedRecord();
                int status = BaseHelpUtils.getIntValue(gridRecord.getAttribute("status"));
                int meetingStatus = BaseHelpUtils.getIntValue(gridRecord.getAttribute("meetingStatus"));
                int meetingRelevanceId = BaseHelpUtils.getIntValue(gridRecord.getAttribute("meetingRelevanceId"));

                if (status == 1) {
                    SC.ask("提示", "确认取消？", new BooleanCallback() {
                        @Override
                        public void execute(Boolean value) {
                            if (value) {
                                Map<String, Object> param = new HashMap<>(0);
                                param.put("meetingRelevanceId", meetingRelevanceId);
                                param.put("status", status);
                                param.put("optType", "cancelReservation");
                                DBDataSource.callOperation("EP_MeetingInfoProcessor", param, new DSCallback() {
                                    @Override
                                    public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                                        if (dsResponse.getStatus() >= 0) {
                                            int indexNum = resultGrid.getRowNum(gridRecord);
                                            resultGrid.removeData(gridRecord);
                                            resultGrid.selectSingleRecord(indexNum);
                                            SC.say("取消会议预约成功");
                                            commonQuery();
                                        } else {
                                            SC.say(dsResponse.getErrors().get("errorMsg").toString());
                                        }
                                    }
                                });
                            }
                        }
                    });

                } else {
                    SC.say("只能取消已预约状态的会议记录");
                }
            }
        });


        IButton addButton = new IButton("新建会议");
        controlLayout.addMember(addButton);
        addButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                /**
                 * 预约会议室的界面
                 */
                MeetingRoomRecordPanel panel = new MeetingRoomRecordPanel();

                panel.addDataEditedHandler(new DataEditedHandler() {
                    @Override
                    public void onDataEdited(DataEditEvent event) {
                        commonQuery();
                    }
                });

                PopupWindow window = new PopupWindow();
                window.addItem(panel);
                panel.loadEmployee();
                panel.MeetingRoomRecord();
                panel.setParentWindow(window);
                window.setTitle("新建会议");
                window.setWidth("80%");
                window.setHeight("80%");
                window.centerInPage();
                window.show();

            }
        });

        /**
         * 周例会预约
         */
        IButton weekRegularMeeting = new IButton("新建周例会");
        controlLayout.addMember(weekRegularMeeting);
        weekRegularMeeting.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                MeetingRoomWeekPanel panel = new MeetingRoomWeekPanel();
                panel.addDataEditedHandler(new DataEditedHandler() {
                    @Override
                    public void onDataEdited(DataEditEvent event) {
                        commonQuery();
                    }
                });
                PopupWindow window = new PopupWindow();
                window.addItem(panel);
                panel.loadEmployee();
                panel.MeetingRoomRecord();
                panel.setParentWindow(window);
                window.setTitle("新建周例会");
                window.setWidth("80%");
                window.setHeight("80%");
                window.centerInPage();
                window.show();
            }
        });


        /**
         * 月例会预约
         */
        IButton mouthRegularMeeting = new IButton("新建月例会");
        mouthRegularMeeting.hide();
        controlLayout.addMember(mouthRegularMeeting);
        mouthRegularMeeting.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                MeetingRoomMonthPanel panel = new MeetingRoomMonthPanel();

                panel.addDataEditedHandler(new DataEditedHandler() {
                    @Override
                    public void onDataEdited(DataEditEvent event) {
                        commonQuery();
                    }
                });

                PopupWindow window = new PopupWindow();
                window.addItem(panel);
                panel.loadEmployee();
                panel.MeetingRoomRecord();
                panel.setParentWindow(window);
                window.setTitle("新建月例会");
                window.setWidth("60%");
                window.setHeight("60%");
                window.centerInPage();
                window.show();
            }
        });


        /**
         * 修改预约（更新操作）
         */
        IButton appointmentButton = new IButton("修改预约");
        controlLayout.addMember(appointmentButton);
        appointmentButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {

                if (!resultGrid.anySelected()) {
                    SC.say("请选择一条数据");
                    return;
                }
                ListGridRecord gridRecord = resultGrid.getSelectedRecord();
                int meetingRelevanceId = BaseHelpUtils.getIntValue(gridRecord.getAttribute("meetingRelevanceId"));
                int status = BaseHelpUtils.getIntValue(gridRecord.getAttribute("status"));
                int meetingRoomId = BaseHelpUtils.getIntValue(gridRecord.getAttribute("meetingRoomId"));
                String meetingTheme = BaseHelpUtils.getString(gridRecord.getAttribute("meetingTheme"));
                int meetingStatus = BaseHelpUtils.getIntValue(gridRecord.getAttribute("meetingStatus"));
                int startTime = BaseHelpUtils.getIntValue(gridRecord.getAttribute("startTime"));
                int endTime = BaseHelpUtils.getIntValue(gridRecord.getAttribute("endTime"));
                Date recordDate = gridRecord.getAttributeAsDate("recordDate");
                Date meetingTime = gridRecord.getAttributeAsDate("meetingTime");
                int weekTime = BaseHelpUtils.getIntValue(gridRecord.getAttribute("weekTime"));
                int howManyWeeks = BaseHelpUtils.getIntValue(gridRecord.getAttribute("howManyWeeks"));

                /**
                 * 预约会议室的界面
                 */
                if (status == 1) {
                    if (meetingStatus == 1) {
                        MeetingAppointmentTimePanel panel = new MeetingAppointmentTimePanel();
                        panel.addDataEditedHandler(new DataEditedHandler() {
                            @Override
                            public void onDataEdited(DataEditEvent event) {
                                commonQuery();
                            }
                        });
                        PopupWindow window = new PopupWindow();
                        window.addItem(panel);
                        //将数据传到页面中
                        panel.setParentWindow(window);
                        panel.MeetingRoomRecord(status, meetingStatus, meetingRelevanceId, meetingRoomId, meetingTheme,
                                startTime, endTime, recordDate);
                        panel.loadEmployee();
                        panel.loadConfrees();
                        window.setTitle("修改普通会议预约");
                        window.setWidth("60%");
                        window.setHeight("60%");
                        window.centerInPage();
                        window.show();
                    } else if (meetingStatus == 2) {
                        MeetingAppointmentTimeWeekPanel panel = new MeetingAppointmentTimeWeekPanel();
                        panel.addDataEditedHandler(new DataEditedHandler() {
                            @Override
                            public void onDataEdited(DataEditEvent event) {
                                commonQuery();
                            }
                        });

                        PopupWindow window = new PopupWindow();
                        window.addItem(panel);
                        //将数据传到页面中
                        panel.setParentWindow(window);
                        panel.MeetingRoomRecordWeek(status, meetingStatus, meetingRelevanceId, meetingRoomId, meetingTheme,
                                startTime, endTime, weekTime, meetingTime);

                        panel.loadEmployee();
                        panel.loadConfrees();
                        window.setTitle("修改周例会会议预约");
                        window.setWidth("60%");
                        window.setHeight("60%");
                        window.centerInPage();
                        window.show();

                    }
                } else {
                    SC.say("只能修改已预约状态的会议记录");
                }
            }

        });
    }

    @Override
    public void commonQuery() {
        if (!DelicacyMenuMain.checkLogin()) {
            destroy();
            return;
        }

        Map condition = generateCriteria();
        if (null == condition) {
            return;
        }

        if (null != searchForm) {
            searchButton.setIcon("loading38.gif");
        }

        DBDataSource ds = (DBDataSource) getDataSource();
        String operationName = ds.getActionMode() + ds.getActionName();
        final LoadingWindow loading = new LoadingWindow();
        DBDataSource.callOperation(operationName, "find", condition, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                loading.destroy();
                if (null != searchForm) {
                    searchButton.setIcon("[SKIN]/actions/search.png");
                }
                if (dsResponse.getStatus() >= 0) {
                    resultGrid.setData(dsResponse.getData());
                    afterDataReceived(dsResponse.getData());
                    if (isNeedPagenation() && null != pager) {
                        if (currentPage == 1) {
                            totalPages = dsResponse.getAttributeAsInt("totalPages");
                            pager.getTotalPages().setContents(String.valueOf(totalPages));
                        }
                    }
                } else {
                    SC.say(dsResponse.getErrors().get("errorMsg").toString());
                }
                if (showPagination() && null != pager) {
                    pager.getCurrentPage().setContents(String.valueOf(currentPage));
                }
            }
        });
    }


    /**
     * 显示一条数据详情
     */
    public void showDetail() {
        GWT.runAsync(new RunAsyncCallback() {
            @Override
            public void onFailure(Throwable reason) {
                SC.say("failure to download code");
            }

            @Override
            public void onSuccess() {
                if (!resultGrid.anySelected()) {
                    SC.say("请选择一条数据");
                    return;
                }
                GenericViewWindow detail = new GenericViewWindow();
                detail.setTitle("会议室预约记录");
                detail.setWidth100();
                detail.setHeight100();
                MeetingRoomRecordSearchPanel detailForm = new MeetingRoomRecordSearchPanel();
                detailForm.setParentSearchForm(searchForm);
                detailForm.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_TAB);
                detailForm.initComponents();
                detailForm.viewSelectedData(resultGrid);
                detail.setContent(detailForm);
                detail.centerInPage();
                detail.show();
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
}
