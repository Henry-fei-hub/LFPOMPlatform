package com.pomplatform.client.meeting.panel;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.*;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.meeting.datasource.DSMeetingRoomReservaTionRecordPaymentBase;
import com.pomplatform.client.meeting.form.MeetingRoomReservaTionRecordPaymentBaseSearchForm;
import com.pomplatform.client.meeting.form.MeetingRoomReservaTionRecordPaymentBaseViewer;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;

import java.util.Map;
import java.util.logging.Logger;

/**
 * 会议室预约界面
 *
 * @author xiaolong
 */
public class MeetingRoomStatusPanel extends AbstractSearchPanel implements HasHandlers {
    private static final Logger __LOGGER = Logger.getLogger("");

    public static class Factory implements PanelFactory {
        private String id;

        @Override
        public Canvas create() {
            MeetingRoomStatusPanel cm = new MeetingRoomStatusPanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "MeetingRoomStatusPanel";
        }

    }

    @Override
    public void init() {
        super.init();
        resultGrid.setAutoFitFieldWidths(false);
        resultGrid.setDropLineThickness(2);
        resultGrid.setDropLineThickness(15);
        resultGrid.setShowDropLines(true);
        resultGrid.setCanEdit(true);
        resultGrid = new DelicacyListGrid() {
            @Override
            protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
            	String fieldName = resultGrid.getFieldName(colNum);
            	String str = "time";
            	if(fieldName.indexOf(str) != -1) {//说明包含这个字符串
            		String value = BaseHelpUtils.getString(record.getAttribute(fieldName));
            		int status = 0;
            		String content = "";
            		if(!BaseHelpUtils.isNullOrEmpty(value)) {
            			String[] arr = value.split("&&");
            			if(!BaseHelpUtils.isNullOrEmpty(arr) && arr.length > 0) {
            				status = BaseHelpUtils.getIntValue(arr[0]);
            				content = BaseHelpUtils.getString(KeyValueManager.getValue("system_dictionary_231", status+""));
            				//从第二个数据取数，第一个是status
            				for(int j = 1;j<arr.length;j++) {
            					if(!BaseHelpUtils.isNullOrEmpty(content)) {
            						content = content+"<br>";
            					}
            					content = content+arr[j];
            				}
            			}
            		}else {
            			content = BaseHelpUtils.getString(KeyValueManager.getValue("system_dictionary_231", status+""));
            		}
            		int hei = resultGrid.getCellHeight()+20;
            		resultGrid.setCellPadding(0);
            		String color = "";
            		if (status == 0) {
            			color = "background-color:#D5D5D5;";
                    } else if (status == 1) {
                    	color = "background-color:#F29B1B;color:#ffffff";
                    } else if (status == 2) {
                    	color = "background-color:#259B24;color:#ffffff";
                    } else if (status == 3) {
                    	color = "background-color:#F25157;color:#ffffff";
                    } else if (status == 4) {
                    	color = "background-color:#F25157;color:#ffffff";
                    }
            		content = "<div style='"+color+";height:"+hei+";display: flex;align-items: center;justify-content: center;'>"+content+"</div>";
            		record.setAttribute(fieldName, content);
            	}

                return super.getCellCSSText(record, rowNum, colNum);

            }
        };
        resultGrid.setDataSource(getDataSource());
        resultGrid.setHeaderHeight(40);
        resultGrid.setCellHeight(60);
        resultGrid.setAlign(Alignment.CENTER);
        resultGrid.setShowRowNumbers(true);
        resultGrid.setEditByCell(true);

    }

    @Override
    public void initComponents() {
//  表格的点击事件
//        resultGrid.addCellClickHandler(new CellClickHandler() {
//            @Override
//            public void onCellClick(CellClickEvent event) {
//                //列下标
//                int colNum = event.getColNum();
//                //行下标
//                int rowNum = event.getRowNum();
//                ListGridRecord selected = resultGrid.getSelectedRecord();
//                int meetingRoomId = Integer.parseInt(selected.getAttribute("meetingRoomId"));
//                Map<Integer, String> meetingRoomTimeMap = new HashMap<>();
//                meetingRoomTimeMap.put(0, "07:00-08:00");
//                meetingRoomTimeMap.put(1, "08:00-09:00");
//                meetingRoomTimeMap.put(2, "09:00-10:00");
//                meetingRoomTimeMap.put(3, "10:00-11:00");
//                meetingRoomTimeMap.put(4, "11:00-12:00");
//                meetingRoomTimeMap.put(5, "12:00-13:00");
//                meetingRoomTimeMap.put(6, "13:00-14:00");
//                meetingRoomTimeMap.put(7, "14:00-15:00");
//                meetingRoomTimeMap.put(8, "15:00-16:00");
//                meetingRoomTimeMap.put(9, "16:00-17:00");
//                meetingRoomTimeMap.put(10, "17:00-18:00");
//                meetingRoomTimeMap.put(11, "18:00-19:00");
//                meetingRoomTimeMap.put(12, "19:00-20:00");
//                meetingRoomTimeMap.put(13, "20:00-21:00");
//                meetingRoomTimeMap.put(14, "21:00-22:00");
//                String meetingRoomTime = meetingRoomTimeMap.get(colNum);
//                __LOGGER.info("会议室id" + meetingRoomId + "时间" + meetingRoomTime);
//                __LOGGER.info("列下标" + colNum + "行下标" + rowNum);
//
//                MeetingRoomRecordPanel panel = new MeetingRoomRecordPanel();
//                PopupWindow window = new PopupWindow();
//                window.addItem(panel);
//                panel.loadEmployee();
//                panel.MeetingRoomRecord();
//                panel.setParentWindow(window);
//                window.setTitle("新建会议");
//                window.setWidth("60%");
//                window.setHeight("60%");
//                window.centerInPage();
//                window.show();
//            }
//        });


        IButton refreshButton = new IButton("刷新");
        controlLayout.addMember(refreshButton);
        refreshButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                commonQuery();
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

        commonQuery();
    }

    /**
     * 显示所有数据
     */
    public void showDetail() {
        GWT.runAsync(new RunAsyncCallback() {
            @Override
            public void onFailure(Throwable reason) {
                SC.say("failure" + " to download code");
            }

            @Override
            public void onSuccess() {
                if (!resultGrid.anySelected()) {
                    SC.say("请选择一条数据");
                    return;
                }
                GenericViewWindow detail = new GenericViewWindow();
                detail.setTitle("会议室详情");
                detail.setWidth100();
                detail.setHeight100();
                MeetingRoomReservaTionRecordPaymentBaseViewer detailForm = new MeetingRoomReservaTionRecordPaymentBaseViewer();
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
        return true;
    }


    @Override
    public SearchForm generateSearchForm() {
        return new MeetingRoomReservaTionRecordPaymentBaseSearchForm();
    }

    @Override
    public DataSource getDataSource() {
        return DSMeetingRoomReservaTionRecordPaymentBase.getInstance();
    }

    @Override
    public int getSearchFormHeight() {
        return 60;
    }
}