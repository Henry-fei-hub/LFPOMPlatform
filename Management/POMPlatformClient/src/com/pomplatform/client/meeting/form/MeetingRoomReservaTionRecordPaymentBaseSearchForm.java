package com.pomplatform.client.meeting.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.meeting.datasource.CDMeetingRoomReservaTionRecordPaymentBase;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MeetingRoomReservaTionRecordPaymentBaseSearchForm extends SearchForm
{
	private final SelectItem meetingRoomIdItem;
	private final DateItem meetingDateItemStart;
	private final DateItem meetingDateItemEnd;
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";

	public MeetingRoomReservaTionRecordPaymentBaseSearchForm() {
		setWidth100();
		setHeight(200);
		setDataSource(CDMeetingRoomReservaTionRecordPaymentBase.getInstance());


		meetingRoomIdItem = new SelectItem("meetingRoomId", "会议室名称");
		KeyValueManager.loadValueMap("meeting_rooms", meetingRoomIdItem);
		meetingRoomIdItem.setWidth("*");
		meetingRoomIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		meetingRoomIdItem.setChangeOnKeypress(false);


		/**
		 * 开始时间限制为当天，并且结束时间必须大于开始日期
		 */
		meetingDateItemStart = new DateItem("startDate", "开始日期");
		meetingDateItemStart.setWidth("*");
		meetingDateItemStart.setUseTextField(true);
		meetingDateItemStart.setDisabled(true);
		meetingDateItemStart.setDefaultValue(new Date());
		meetingDateItemStart.setUseMask(true);


		meetingDateItemEnd =new DateItem("endDate", shouldNotBeNull+"结束时间");
		meetingDateItemEnd.setUseTextField(true);
		meetingDateItemEnd.setUseMask(true);
		meetingDateItemEnd.setWidth("*");
		meetingDateItemEnd.setDefaultValue(new Date());

		/**
		 * 结束时间
		 */
		meetingDateItemEnd.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				if(null != event.getValue() && null != meetingDateItemStart.getValue()){
					Map<String, Object> params = new HashMap<>();
					DBDataSource.callOperation("EP_ReckonRevenueCapitals", params, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							Date startDate = (Date) meetingDateItemStart.getValue();
							Date endDate =(Date) meetingDateItemEnd.getValue();
							if(startDate.after(endDate)){
								SC.say("开始时间不能晚于结束时间");
							}else {
								Date val2 = (Date) event.getValue();
								ClientUtil.searchDateFormat(val2, meetingDateItemEnd);
							}
						}
					});
				}
			}
		});
		setItems(meetingRoomIdItem,meetingDateItemStart,meetingDateItemEnd);
		setNumCols(7);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}
}
