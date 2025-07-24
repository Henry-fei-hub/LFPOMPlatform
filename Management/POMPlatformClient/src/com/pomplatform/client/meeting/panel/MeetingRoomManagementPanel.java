package com.pomplatform.client.meeting.panel;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.*;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.meeting.datasource.DSMeetingRoomManagement;
import com.pomplatform.client.meeting.form.MeetingRoomManagementSearchForm;
import com.pomplatform.client.meeting.form.MeetingRoomManagementViewer;
import com.pomplatform.client.meeting.form.NewMeetingRoomManagementForm;
import com.pomplatform.client.meeting.form.UpdateMeetingRoomManagementForm;
import com.smartgwt.client.data.*;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;

import java.util.Map;
import java.util.logging.Logger;

public class MeetingRoomManagementPanel extends AbstractSearchPanel {


    private static final Logger __LOGGER = Logger.getLogger("");

    public static class Factory implements PanelFactory {
        private String id;

        @Override
        public Canvas create() {
            MeetingRoomManagementPanel cm = new MeetingRoomManagementPanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "MeetingRoomManagement";
        }

    }

    @Override
    public void init() {
        super.init();
        __controlPosition = LayoutConstant.RIGHT;
        resultGrid.setAutoFitFieldWidths(false);
    }

    @Override
    public void initComponents() {

        IButton refreshButton = new IButton("刷新");
        controlLayout.addMember(refreshButton);
        refreshButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                commonQuery();
            }
        });

        IButton operation1Button = new IButton("新建");
        controlLayout.addMember(operation1Button);
        operation1Button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                GWT.runAsync(new RunAsyncCallback() {
                    @Override
                    public void onFailure(Throwable reason) {
                        SC.say("failure to download");
                    }

                    @Override
                    public void onSuccess() {
                        NewMeetingRoomManagementForm detailForm = new NewMeetingRoomManagementForm();
                        detailForm.setTitle("新建会议室");
                        detailForm.addDataEditedHandler(new DataEditedHandler() {
                            @Override
                            public void onDataEdited(DataEditEvent event) {
                                RecordList list = resultGrid.getDataAsRecordList();
                                RecordList newList = new RecordList();
                                newList.addList(list.getRange(0, list.getLength()));
                                newList.add(event.getData());
                                resultGrid.setData(newList);
                                resultGrid.selectSingleRecord(newList.getLength() - 1);
                            }
                        });
                        detailForm.setSearchForm(searchForm);
                        detailForm.initComponents();
                        detailForm.startEdit();
                        detailForm.setWidth("40%");
                        detailForm.setHeight("40%");
                        detailForm.centerInPage();
                        detailForm.show();
                    }
                });
            }
        });

        IButton operation2Button = new IButton("修改");
        controlLayout.addMember(operation2Button);
        operation2Button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                GWT.runAsync(new RunAsyncCallback() {
                    @Override
                    public void onFailure(Throwable reason) {
                        SC.say("failure to download code");
                    }

                    @Override
                    public void onSuccess() {
                        if (!resultGrid.anySelected()) {
                            SC.say("请选择一条数据修改");
                            return;
                        }
                        final ListGridRecord selected1 = resultGrid.getSelectedRecord();
                        UpdateMeetingRoomManagementForm detailForm = new UpdateMeetingRoomManagementForm();
                        detailForm.setTitle("修改会议室");
                        detailForm.addDataEditedHandler(new DataEditedHandler() {
                            @Override
                            public void onDataEdited(DataEditEvent event) {
                                DBDataSource.copyRecord(event.getData(), selected1);
                                commonQuery();
                            }
                        });
                        detailForm.setSearchForm(searchForm);
                        detailForm.setRecord(selected1);
                        detailForm.setCurrentPage(getCurrentPage());
                        detailForm.initComponents();
                        detailForm.startEdit();
                        detailForm.setWidth("40%");
                        detailForm.setHeight("40%");
                        detailForm.centerInPage();
                        detailForm.show();
                        setCurrentPage(detailForm.getCurrentPage());
                    }
                });
            }
        });

        IButton removeButton = new IButton("删除");
        controlLayout.addMember(removeButton);
        removeButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {

                GWT.runAsync(new RunAsyncCallback() {
                    @Override
                    public void onFailure(Throwable throwable) {
                        SC.say("failure to download code");
                    }

                    @Override
                    public void onSuccess() {
                        if (!resultGrid.anySelected()) {
                            SC.say("请选择一条数据删除");
                            return;
                        }
                        SC.confirm("提示", "您确定删除该会议室吗？", new BooleanCallback() {
                            @Override
                            public void execute(Boolean aBoolean) {

                                if (aBoolean) {

                                    final ListGridRecord selected = resultGrid.getSelectedRecord();
                                    selected.setAttribute("deleteFlag", 1);
                                    DBDataSource.callOperation("ST_MeetingRoom", "delete", selected.toMap(), new DSCallback() {
                                        @Override
                                        public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                                            if (dsResponse.getStatus() >= 0) {
                                                int indexNum = resultGrid.getRowNum(selected);
                                                resultGrid.removeData(selected);
                                                resultGrid.selectSingleRecord(indexNum);
                                                SC.say("删除成功");
                                            } else {
                                                Map errors = dsResponse.getErrors();
                                                SC.say("delete failure" + errors);
                                            }

                                        }
                                    });
                                }
                            }
                        });
                    }
                });
            }
        });

        commonQuery();



        //预约时间管理
        IButton makingAppointment = new IButton("预约时间设置");
        controlLayout.addMember(makingAppointment);
        makingAppointment.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                PopupWindow pw = new PopupWindow();
                MeetingRoomRecordTimeSettingPanel panel = new MeetingRoomRecordTimeSettingPanel();
                panel.setParentWindow(pw);
                panel.setParentCanvas(pw);
                pw.addItem(panel);
                pw.setTitle("修改预约和推送时间");
                pw.setWidth(450);
                pw.setHeight(300);
                pw.centerInPage();
                pw.show();
            }
        });

    }

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
                detail.setTitle("MeetingRoomManagement");
                detail.setWidth100();
                detail.setHeight100();
                MeetingRoomManagementViewer detailForm = new MeetingRoomManagementViewer();
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
        criteria.put("addtionalCondition", "order by meeting_room_id");
        return true;
    }

    @Override
    public SearchForm generateSearchForm() {
        return new MeetingRoomManagementSearchForm();
    }

    @Override
    public DataSource getDataSource() {
        return DSMeetingRoomManagement.getInstance();
    }

    @Override
    public int getSearchFormHeight() {
        return 60;
    }

}

