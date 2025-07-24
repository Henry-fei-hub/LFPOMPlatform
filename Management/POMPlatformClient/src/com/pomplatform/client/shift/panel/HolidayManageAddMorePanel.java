package com.pomplatform.client.shift.panel;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

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
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.DateItemSelectorFormat;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class HolidayManageAddMorePanel extends HLayout implements HasHandlers {

	private Window parentWindow;
	private static Logger __logger = Logger.getLogger("");
	private TextItem nameItem;
	private DateItem startDateItem;
	private DateItem endDateItem;
	private TextAreaItem remarkItem;
	private IButton okBtn;

	public void initComponents() {
		setWidth("98%");
		setHeight100();
		setPadding(10);
		setMembersMargin(5);

		VLayout formLayout = new VLayout();
		formLayout.setHeight("98%");
		formLayout.setMembersMargin(5);
		formLayout.setWidth100();
		formLayout.setAlign(Alignment.CENTER);
		addMember(formLayout);

		HLayout messageLayout = new HLayout();
		messageLayout.setWidth100();
		messageLayout.setHeight("80%");
		messageLayout.setAlign(Alignment.CENTER);

		final DynamicForm form = new DynamicForm();
		form.setNumCols(6);
		form.setAlign(Alignment.CENTER);
		form.setPadding(5);
		form.setMargin(5);
		form.setWidth100();
		form.setHeight100();

		nameItem = new TextItem("name", "节日名称");
		nameItem.setWidth("*");

		startDateItem = new DateItem("startDate", "开始日期");
		startDateItem.setDefaultValue(new Date());
		startDateItem.setUseTextField(true);
		startDateItem.setWidth("*");
		startDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
		
		endDateItem = new DateItem("endDate", "结束日期");
		endDateItem.setDefaultValue(new Date());
		endDateItem.setUseTextField(true);
		endDateItem.setWidth("*");
		endDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
        
        remarkItem = new TextAreaItem("remark", "备注");
        remarkItem.setColSpan(6);
        remarkItem.setRowSpan(3);
        remarkItem.setWidth("*");
		
		form.setItems(nameItem, startDateItem,endDateItem, remarkItem);
		ClientUtil.DynamicFormProcessAccordingToDevice(form);
		messageLayout.addMember(form);
		formLayout.addMember(messageLayout);

		HLayout btnLayout = new HLayout();
		btnLayout.setWidth100();
		btnLayout.setHeight("20%");
		btnLayout.setMembersMargin(10);
		btnLayout.setAlign(Alignment.RIGHT);

		okBtn = new IButton("确认");
		okBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				SC.ask("提示", "确认保存?", new BooleanCallback() {
					@Override
					public void execute(Boolean value) {
						if (value) {
							//获取开始日期
							Date startDate = startDateItem.getValueAsDate();
							//获取结束日期
							Date endDate = endDateItem.getValueAsDate();
							String name = nameItem.getValueAsString();
							//获取备注信息
							String description =remarkItem.getValueAsString();
							//获取当前操作人
							int operateEmployeeId = ClientUtil.getEmployeeId();
							okBtn.setDisabled(true);
							Map<Object,Object> params = new HashMap<>();
							params.put("startDate", startDate);
							params.put("endDate", endDate);
							params.put("name", name);
							params.put("description", description);
							params.put("operateEmployeeId", operateEmployeeId);
							params.put("optType", "onSaveBatchHolidayInfo");
							DBDataSource.callOperation("EP_OnShiftManageProcess",params, new DSCallback() {
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if (dsResponse.getStatus() >= 0) {
										okBtn.setDisabled(false);
										SC.say("提示","操作成功");
									} else {
										SC.say("Failure" +dsResponse.getErrors().get("errorMsg"));
									}
								}
							});
						}
					}
				});

			}
		});
		
		IButton cleanBtn = new IButton("关闭");
		cleanBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (getParentWindow() == null) {
					return;
				}
				getParentWindow().destroy();
				DataEditEvent dee = new DataEditEvent();
				fireEvent(dee);
			}
		});
		btnLayout.addMember(okBtn);
		btnLayout.addMember(cleanBtn);
		formLayout.addMember(btnLayout);
		
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

	public Window getParentWindow() {
		return parentWindow;
	}

	public void setParentWindow(Window parentWindow) {
		this.parentWindow = parentWindow;
	}

	

}
