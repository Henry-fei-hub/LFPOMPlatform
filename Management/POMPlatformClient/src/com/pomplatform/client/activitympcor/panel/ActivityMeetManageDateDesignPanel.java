package com.pomplatform.client.activitympcor.panel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.datepicker.client.CalendarView;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.account.panel.PlateAccountDesignPanel;
import com.pomplatform.client.activitympcor.datasource.DSSactivityMpcor;
import com.pomplatform.client.activitympcor.form.ActivityMeetDetailViewer;
import com.pomplatform.client.activitympcor.form.DetailsActivityMeetPanel;
import com.pomplatform.client.activitympcor.form.NewActivityMeetForm;
import com.pomplatform.client.activitympcor.form.UpdateActivityMeetPanel;
import com.pomplatform.client.company.datasource.DSCompanyReportIntegralDataSource;
import com.pomplatform.client.selectgridemployeevalue.datasource.DSSelectGridEmployeeValue;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceSequenceField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.DateItemSelectorFormat;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.calendar.Calendar;
import com.smartgwt.client.widgets.calendar.events.CalendarEventAdded;
import com.smartgwt.client.widgets.calendar.events.CalendarEventChangedEvent;
import com.smartgwt.client.widgets.calendar.events.DateChangedEvent;
import com.smartgwt.client.widgets.calendar.events.DateChangedHandler;
import com.smartgwt.client.widgets.calendar.events.EventAddedHandler;
import com.smartgwt.client.widgets.calendar.events.EventChangedHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.MultiComboBoxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;

public class ActivityMeetManageDateDesignPanel extends AbstractWizadPage {
	private final Logger logger = Logger.getLogger("");
	private HLayout mainLayout;
	private DataSource eventDS;
	private Calendar calendar;
	private final SelectItem ourEmployeesItem;
//	private final SelectItem ourDesignerEmployeesItem;
	public ActivityMeetManageDateDesignPanel() {
		mainLayout = new HLayout(10);
		mainLayout.setWidth100();
		mainLayout.setHeight100();

		eventDS = new DataSource();
		DataSourceSequenceField eventIdField = new DataSourceSequenceField("activitieId");
		eventIdField.setPrimaryKey(true);

		DataSourceTextField meetTitleField = new DataSourceTextField("meetTitle");
		DataSourceTextField remarkField = new DataSourceTextField("remark");
		DataSourceDateTimeField meetTimeField = new DataSourceDateTimeField("meetTime");
		DataSourceTextField viewTitleField = new DataSourceTextField("viewTitle");
		viewTitleField.setHidden(true);

		eventDS.setFields(eventIdField, meetTitleField, remarkField, meetTimeField);
		eventDS.setClientOnly(true);
		eventDS.setTitleField("viewTitle");
		calendar = new Calendar();
		calendar.setWidth100();
		calendar.setHeight100();
		calendar.setAutoFetchData(true);
		calendar.setShowWeekView(false);
		calendar.setShowDayView(false);
		calendar.setEventNameFieldTitle("会议主题");
		calendar.setRemoveButtonTitle("删除");
		calendar.setSaveButtonTitle("保存");
		calendar.setDataSource(eventDS);
		// calendar.setStartDateField("startTime");
		// calendar.setEndDateField("endTime");
		calendar.setCanRemoveEvents(false);

		// calendar.setShowOtherDays(true);

		// calendar.setShowDayView(false);
		// calendar.setShowWeekView(false);
		// calendar.setShowOtherDays(false);
		// calendar.setShowDayHeaders(false);
		// calendar.setShowDatePickerButton(false);
		// calendar.setShowAddEventButton(false);
		// calendar.setDisableWeekends(false);
		// calendar.setShowDateChooser(false);
		calendar.setCanCreateEvents(false);
		calendar.setCanEditEvents(false);

		calendar.addDateChangedHandler(new DateChangedHandler() {

			@Override
			public void onDateChanged(DateChangedEvent event) {
				getRecords();
			}
		});
		calendar.addEventAddedHandler(new EventAddedHandler() {
			@Override
			public void onEventAdded(CalendarEventAdded event) {
				Record record = event.getEvent();
				Date chosenDate = calendar.getChosenDate();
				Map<Object, Object> param = new HashMap<>();

				param.put("meetTime", chosenDate);
				param.put("operateEmployeeId", ClientUtil.getEmployeeId());
				param.put("operateTime", new Date());
				param.putAll(record.toMap());
				String ourEmployees = BaseHelpUtils.getString(record.toMap().get("ourEmployees"));
				if (!BaseHelpUtils.isNullOrEmpty(ourEmployees)) {
					param.put("ourEmployees", ourEmployees.substring(1, ourEmployees.length() - 1));
				}
				DBDataSource.callOperation("ST_Activity", "save", param, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() >= 0) {
							Record[] records = dsResponse.getData();
							if (records.length > 0) {
								SC.say("提示", "保存成功");
								getRecords();
							}
						} else {
							SC.say(dsResponse.getErrors().get("errorMsg").toString());
						}
					}
				});
			}
		});

		calendar.addEventChangedHandler(new EventChangedHandler() {
			@Override
			public void onEventChanged(CalendarEventChangedEvent event) {
				Record record = event.getEvent();
				Date chosenDate = calendar.getChosenDate();
				Map<Object, Object> param = new HashMap<>();
				param.put("meetTime", chosenDate);
				param.put("operateEmployeeId", ClientUtil.getEmployeeId());
				param.put("operateTime", new Date());
				param.putAll(record.toMap());
				String ourEmployees = BaseHelpUtils.getString(record.toMap().get("ourEmployees"));
				logger.info(ourEmployees);
				if (!BaseHelpUtils.isNullOrEmpty(ourEmployees)) {
					param.put("ourEmployees", ourEmployees.substring(1, ourEmployees.length() - 1));
				}
				DBDataSource.callOperation("ST_Activity", "update", param, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() >= 0) {
							Record[] records = dsResponse.getData();
							if (records.length > 0) {
								SC.say("提示", "更新成功");
							}
						} else {
							SC.say(dsResponse.getErrors().get("errorMsg").toString());
						}
					}
				});
			}
		});

		DSSactivityMpcor ds = DSSactivityMpcor.getInstance();
		TextItem meetTitleItem = new TextItem("meetTitle", "会议主题");
		meetTitleItem.setWidth(350);
		SelectItem meetTypeItem = new SelectItem("meetType", "会议类型");
		meetTypeItem.setWidth(350);

		meetTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_150"));
		TextItem customerNameItem = new TextItem("customerName", "客户名称");
		customerNameItem.setWidth(350);
		TextItem projectNameItem = new TextItem("projectName", "项目名称");
		projectNameItem.setWidth(350);
		TextItem contactNameItem = new TextItem("contactName", "联系人");
		contactNameItem.setWidth(350);
		DateTimeItem meetTimeItem = new DateTimeItem("meetTime", "会议时间");
		meetTimeItem.setHidden(true);
		meetTimeItem.setWidth(350);
		meetTimeItem.setUseTextField(true);
		meetTimeItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH_DAY);
		TextItem theirEmployeesItem = new TextItem("theirEmployees", "甲方出席人员");
		theirEmployeesItem.setWidth(350);
		ListGridField eNoField = new ListGridField("employeeNo");
		ListGridField eNameField = new ListGridField("employeeName");
		ListGridField departmentIdField = new ListGridField("departmentId");
		eNameField.setCanFilter(true);
		Criteria c = new Criteria();
		c.addCriteria("status", 0);
		ourEmployeesItem = new SelectItem("ourEmployees", "我方营销出席人员");
		ourEmployeesItem.setWidth(350);
		ourEmployeesItem.setMultiple(true);
		ourEmployeesItem.setChangeOnKeypress(false);
		ourEmployeesItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		ourEmployeesItem.setOptionDataSource(DSSelectGridEmployeeValue.getInstance());
		ourEmployeesItem.setOptionCriteria(c);
		ourEmployeesItem.setValueField("employeeName");
		ourEmployeesItem.setDisplayField("employeeName");
		ourEmployeesItem.setUseClientFiltering(true);
		ourEmployeesItem.setPickListFields(eNoField, eNameField, departmentIdField);
		TextItem meetAddressItem = new TextItem("meetAddress", "会议地址");
		meetAddressItem.setWidth(700);
		meetAddressItem.setColSpan(4);
		TextAreaItem theirRequireItem = new TextAreaItem("theirRequire", "甲方要求");
		theirRequireItem.setWidth(700);
		theirRequireItem.setHeight(75);
		theirRequireItem.setColSpan(4);
		TextAreaItem meetTargetItem = new TextAreaItem("meetTarget", "会议目标");
		meetTargetItem.setWidth(700);
		meetTargetItem.setHeight(75);
		meetTargetItem.setColSpan(4);
		TextAreaItem remarkItem = new TextAreaItem("remark", "备注信息");
		remarkItem.setWidth(700);
		remarkItem.setHeight(75);
		remarkItem.setColSpan(4);

		TextItem descItem = new TextItem();
		descItem.setName("description");
		descItem.setTitle("Description");
		// descItem.setHidden(true);
		// calendar.setEventDialogCustomizer(null);
		calendar.setEventDialogFields(meetTitleItem, meetTypeItem, customerNameItem, projectNameItem, contactNameItem,
				meetTimeItem, theirEmployeesItem, ourEmployeesItem, meetAddressItem, theirRequireItem, meetTargetItem,
				remarkItem);
		calendar.setEventEditorFields(meetTitleItem, meetTypeItem, customerNameItem, projectNameItem, contactNameItem,
				meetTimeItem, theirEmployeesItem, ourEmployeesItem, meetAddressItem, theirRequireItem, meetTargetItem,
				remarkItem);
		calendar.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				Calendar aCalendar = (Calendar) event.getSource();
				getDetailsRecords(aCalendar.getChosenDate());
			}
		});
		mainLayout.addMember(calendar);
		addMember(mainLayout);
	}

	public void getRecords() {
		Map<Object, Object> param = new HashMap<>();
		if (!ClientUtil.checkIsHavePermission(ERPPermissionStatic.ACTIVITY_MEET_ALL_DATE)) {
			param.put("operateEmployeeId", ClientUtil.getEmployeeId());
		}
		DBDataSource.callOperation("ST_Activity", "find", param, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				String meetTitle = "";
				String meetType = "";
				String meetAddress = "";
				String contactName = "";
				if (dsResponse.getStatus() >= 0) {
					Record[] records = dsResponse.getData();
					if (records.length > 0) {
						for (Record r : records) {
							if (BaseHelpUtils.getIntValue(r.getAttribute("meetType")) == 1) {
								meetType = "业主来我司考察";
							}
							if (BaseHelpUtils.getIntValue(r.getAttribute("meetType")) == 2) {
								meetType = "我司出差拜访";
							}
							if (!BaseHelpUtils.isNullOrEmpty(r.getAttribute("meetTitle"))) {
								meetTitle = r.getAttribute("meetTitle");
							}
							if (!BaseHelpUtils.isNullOrEmpty(r.getAttribute("meetAddress"))) {
								meetAddress = r.getAttribute("meetAddress");
							}
							if (!BaseHelpUtils.isNullOrEmpty(r.getAttribute("contactName"))) {
								contactName = r.getAttribute("contactName");
							}

							r.setAttribute("viewTitle", "<br/>会议主题：" + meetTitle + "<br/>会议类型：" + meetType
									+ "<br/>会议地点：" + meetAddress + "<br/>联系人：" + contactName);
						}
						eventDS.setTestData(records);
						calendar.setData(records);
						calendar.redraw();
					}
				} else {
					SC.say(dsResponse.getErrors().get("errorMsg").toString());
				}
			}
		});
	}

	public void getDetailsRecords(Date meetTime) {
		Map<Object, Object> param = new HashMap<>();
		param.put("meetTime", meetTime);
		param.put("optType", "pcDetailsData");
		/*if (!ClientUtil.checkIsHavePermission(ERPPermissionStatic.ACTIVITY_MEET_ALL_DATE)) {
			param.put("operateEmployeeId", ClientUtil.getEmployeeId());
		}*/
		DBDataSource.callOperation("EP_GetActivityDetailsProcess", param, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {

				if (dsResponse.getStatus() >= 0) {
					Record[] records = dsResponse.getData();
					if (records.length > 0) {
						if (records.length == 1) {
							GWT.runAsync(new RunAsyncCallback() {
								@Override
								public void onFailure(Throwable reason) {
									SC.say("failure to download");
								}

								@Override
								public void onSuccess() {

									DetailsActivityMeetPanel detailForm = new DetailsActivityMeetPanel();
									detailForm.setTitle("会议详情");
									detailForm.setSearchForm(searchForm);
									
									detailForm.setRecord(records[0]);
									detailForm.initComponents();
									detailForm.startEdit();
									detailForm.setWidth("80%");
									detailForm.setHeight("80%");
									detailForm.centerInPage();
									detailForm.show();
								}
							});
						} else {
							
							PopupWindow pw = new PopupWindow();
							ActivityMeetDetailViewer activityPanel = new ActivityMeetDetailViewer();
							pw.addItem(activityPanel);
							activityPanel.setRecords(records);
							activityPanel.initComponents();
							pw.setTitle("会议详情");
							pw.setWidth("80%");
							pw.setHeight("80%");
							pw.centerInPage();
							pw.show();
							
						}
					}
				} else {
				}
			}
		});
	}

	@Override
	public Map getValuesAsMap() {
		Map params = __form.getValues();
		ListGridRecord[] reRecords = ourEmployeesItem.getSelectedRecords();
		if (!BaseHelpUtils.isNullOrEmpty(reRecords)) {
			String ourEmployees = "";
			for (int i = 0; i < reRecords.length; i++) {
				if (i != 0) {
					ourEmployees += ",";
				}
				ourEmployees += reRecords[i].getAttribute("employeeName");
			}
			params.put("ourEmployees", ourEmployees);
		}
		return params;
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public void startEdit() {

		if (getRecord() != null) {
			Record record = getRecord();
			String idStr = record.getAttribute("ourEmployees");
			if (!BaseHelpUtils.isNullOrEmpty(idStr)) {
				String[] strArra = idStr.split(",");
				record.setAttribute("ourEmployees", strArra);
			}
			__form.editRecord(record);
		} else {
			__form.editNewRecord();
		}

	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSSactivityMpcor.getInstance());
		manager.addMember(__form);
	}

	public String getActionName() {
		// 需要根据实际业务修改
		return "ST_Activity";
	}

}
