package com.pomplatform.client.meeting.form;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.meeting.datasource.DSMeetingRoomReservation;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.form.validator.IsIntegerValidator;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class MeetingRoomReservationNewForm extends AbstractWizadPage {

    private final SelectItem meetingRoomIdItem;
    private final TextItem meetingRoomSiteItem;
    private final SelectItem meetingRoomTimeStartItem;
    private final SelectItem meetingRoomTimeEndItem;
    private final TextItem meetingRoomTimeItem;
    private final DateItem meetingDateItem;
    private final TextItem employeeIdItem;
    private final TextItem statusItem;
    private final TextItem meetingRoomMasterItem;
    private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
    private final TextItem meetingRoomContainNumItem;

    private final Logger logger = Logger.getLogger("");

    public MeetingRoomReservationNewForm() {
        DSMeetingRoomReservation ds = DSMeetingRoomReservation.getInstance();
        __form.setWidth100();
        __form.setHeight100();

        meetingRoomIdItem = new SelectItem("meetingRoomId", "会议室名称");
        meetingRoomIdItem.setWidth(400);
        meetingRoomIdItem.setValueMap(KeyValueManager.getValueMap("meeting_rooms"));
        meetingRoomIdItem.addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent changedEvent) {
                int MeetingRoomId = BaseHelpUtils.getIntValue(changedEvent.getValue());
                Map<String, Object> params = new HashMap<>();
                params.put("meetingRoomId", MeetingRoomId);

                DBDataSource.callOperation("ST_MeetingRoom", "find", params, new DSCallback() {
                    @Override
                    public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
                        if (dsResponse.getStatus() >= 0) {
                            Record[] records = dsResponse.getData();
                            if (null != records && records.length > 0) {
                                Record record = records[0];
                                meetingRoomSiteItem.setValue(record.getAttribute("site"));
                                meetingRoomContainNumItem.setValue(record.getAttribute("containNum"));
                                meetingRoomMasterItem.setValue(record.getAttribute("meetingRoomMaster"));
                            }
                        } else {
                            ClientUtil.displayErrorMessage(dsResponse);
                        }
                    }
                });

            }
        });
        __formItems.add(meetingRoomIdItem);


        meetingRoomSiteItem = new TextItem("site", shouldNotBeNull + "会议室地点");
        meetingRoomSiteItem.setValueMap(KeyValueManager.getValueMap("meeting_rooms"));
        meetingRoomSiteItem.setCanEdit(false);
        meetingRoomSiteItem.setWidth(400);
        __formItems.add(meetingRoomSiteItem);


        meetingRoomMasterItem = new TextItem("meetingRoomMaster", shouldNotBeNull + "会议室负责人");
        meetingRoomMasterItem.setValueMap(KeyValueManager.getValueMap("meeting_rooms"));
        meetingRoomMasterItem.setCanEdit(false);
        meetingRoomMasterItem.setWidth(400);
        __formItems.add(meetingRoomMasterItem);


        meetingRoomContainNumItem = new TextItem("containNum", shouldNotBeNull + "会议室容纳人数");
        meetingRoomContainNumItem.setValueMap(KeyValueManager.getValueMap("meeting_rooms"));
        meetingRoomContainNumItem.setCanEdit(false);
        meetingRoomContainNumItem.setWidth(400);
        __formItems.add(meetingRoomContainNumItem);


        employeeIdItem = new TextItem("employeeId", shouldNotBeNull + "预约人ID");
        employeeIdItem.setCanEdit(false);
        employeeIdItem.setWidth(400);
        employeeIdItem.setValueMap(KeyValueManager.getValueMap(shouldNotBeNull + "employees"));
        employeeIdItem.setDefaultValue(ClientUtil.getUserId());
        __formItems.add(employeeIdItem);

        meetingRoomTimeItem = new TextItem("meetingRoomTime", shouldNotBeNull + "时间区间");
        meetingRoomTimeItem.setHidden(true);
        meetingRoomTimeItem.setWidth(400);
        __formItems.add(meetingRoomTimeItem);

        meetingDateItem = new DateItem("meetingDate", shouldNotBeNull + "日期");
        meetingDateItem.setWidth(400);
        /**
         * 这里可能会出现bug
         * 日期的选中事件，将下面的开始时间和结束时间清除
         */
        __formItems.add(meetingDateItem);

        meetingRoomTimeStartItem = new SelectItem("meeting_room_start_time", shouldNotBeNull + "开始时间");
        meetingRoomTimeStartItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_232"));
        meetingRoomTimeStartItem.setWidth(400);


        meetingRoomTimeStartItem.addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent changedEvent) {
                /**
                 * 将会议室ID，当天的日期和时间传到后台
                 */
                int MeetingRoomId = BaseHelpUtils.getIntValue(changedEvent.getValue());
                Map<String, Object> params = new HashMap<>();
                params.put("meetingRoomId", MeetingRoomId);
                params.put("meetingDate", meetingDateItem.getValue());

                DBDataSource.callOperation("ST_MeetingRoom", "find", params, new DSCallback() {
                    @Override
                    public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {

                        if (dsResponse.getStatus() >= 0) {

                            Record[] records = dsResponse.getData();

                            if (null != records && records.length > 0) {

                                Record record = records[0];

                                params.put("meeting_room_start_time",meetingRoomTimeStartItem.getValue());

                            }
                        } else {

                            ClientUtil.displayErrorMessage(dsResponse);

                        }
                    }
                });
            }
        });
        __formItems.add(meetingRoomTimeStartItem);


        meetingRoomTimeEndItem = new SelectItem("meeting_room_end_time", shouldNotBeNull + "结束时间");
        meetingRoomTimeEndItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_232"));
        meetingRoomTimeEndItem.setWidth(400);
        meetingRoomTimeEndItem.addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent changedEvent) {
                /**
                 * 将会议室ID，当天的日期和时间传到后台
                 */
                int MeetingRoomId = BaseHelpUtils.getIntValue(changedEvent.getValue());
                Map<String, Object> params = new HashMap<>();
                params.put("meetingRoomId", MeetingRoomId);
                params.put("meetingDate", meetingDateItem.getValue());

                DBDataSource.callOperation("ST_MeetingRoom", "find", params, new DSCallback() {
                    @Override
                    public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
                        if (dsResponse.getStatus() >= 0) {
                            Record[] records = dsResponse.getData();
                            if (null != records && records.length > 0) {
                                Record record = records[0];
                                params.put("meeting_room_end_time",meetingRoomTimeEndItem.getValue());
                            }
                        } else {
                            ClientUtil.displayErrorMessage(dsResponse);
                        }
                    }
                });
            }
        });
        __formItems.add(meetingRoomTimeEndItem);

        statusItem = new TextItem("status", "状态(0,已预约，1，未预约)");
        statusItem.setRequired(true);
        statusItem.setHidden(true);
        IsIntegerValidator statusValidator = new IsIntegerValidator();
        statusItem.setDefaultValue(1);
        statusItem.setValidators(statusValidator);
        __formItems.add(statusItem);

        __form.setItems(getFormItemArray());
        __form.setDataSource(ds);
        __form.setNumCols(2);
        __form.setWidth100();
        __form.setHeight100();
        ClientUtil.DynamicFormProcessAccordingToDevice(__form);
        addMember(__form);
    }

    @Override
    public boolean checkData() {

        if (null == meetingRoomSiteItem.getValue()) {
            SC.say("请选择会议室");
            return false;
        }
        if (null == meetingRoomTimeStartItem.getValue()) {
            SC.say("请填写开始时间");
            return false;
        }
        if (null == meetingRoomTimeEndItem.getValue()) {
            SC.say("请填写结束时间");
            return false;
        }

        /**
         * 获取开始时间和结束时间转成int类型
         */
        if (Integer.parseInt((meetingRoomTimeEndItem.getValue().toString()))
                <
                Integer.parseInt((meetingRoomTimeStartItem.getValue().toString()))) {
            SC.say("结束时间不能早于开始时间");
            return false;
        }
        return true;
    }

    @Override
    public void startEdit() {
        if (getRecord() != null) __form.editRecord(getRecord());
        else __form.editNewRecord();
    }

    @Override
    public void setValueManage(ValuesManager manager) {
        manager.setDataSource(DSMeetingRoomReservation.getInstance());
        manager.addMember(__form);
    }

    @Override
    public Map getValuesAsMap() {
       Map <String ,Object> map =__form.getValues();
        map.put("optType","");
        return map;
    }


}
