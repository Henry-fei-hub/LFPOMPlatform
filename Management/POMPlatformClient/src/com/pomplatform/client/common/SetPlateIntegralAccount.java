package com.pomplatform.client.common;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.LoadingWindow;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.ERPPermissionStatic;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.DateItemSelectorFormat;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class SetPlateIntegralAccount extends HLayout implements HasHandlers {

	private Window parentWindow;
	private static Logger __logger = Logger.getLogger("");
	private SelectItem plateIdItem;
	private DateItem startDateItem;
	private DateItem endDateItem;
	private String[] plateIdArr;

	// falg:1:表示计算操作;2:表示加锁操作;3:表示解锁操作;4:表示积分回收
	public void initComponents(final int flag, final String plateIdStr) {
		if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.PLATE_ACCOUNT_MANAGEMENT_CHECK_ALL_DATA)
				|| (!ClientUtil.checkIsHavePermission(ERPPermissionStatic.PLATE_ACCOUNT_MANAGEMENT_CHECK_ALL_DATA)
						&& ClientUtil
								.checkIsHavePermission(ERPPermissionStatic.PLATE_ACCOUNT_MANAGEMENT_CHECK_MYPLATE_DATA)
						&& null != plateIdStr && plateIdStr.length() > 0)) {

			if (null != plateIdStr && plateIdStr.length() > 0) {
				plateIdArr = plateIdStr.split(",");
			}
			setWidth100();
			setHeight100();
			setPadding(10);
			setMembersMargin(5);

			VLayout formLayout = new VLayout();
			formLayout.setHeight100();
			formLayout.setMembersMargin(5);
			formLayout.setWidth("100%");
			formLayout.setAlign(Alignment.CENTER);
			addMember(formLayout);

			HLayout messageLayout = new HLayout();
			messageLayout.setWidth100();
			messageLayout.setHeight("80%");
			messageLayout.setAlign(Alignment.CENTER);

			final DynamicForm form = new DynamicForm();
			form.setNumCols(2);
			form.setAlign(Alignment.CENTER);
			form.setWidth("90%");
			form.setHeight100();

			// 根据当前业务部门id，获取其名称
			plateIdItem = new SelectItem("plateName", "业务部门");
			plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
			if (!ClientUtil.checkIsHavePermission(ERPPermissionStatic.PLATE_ACCOUNT_MANAGEMENT_CHECK_ALL_DATA)
					&& ClientUtil.checkIsHavePermission(ERPPermissionStatic.PLATE_ACCOUNT_MANAGEMENT_CHECK_MYPLATE_DATA)
					&& null != plateIdArr && plateIdArr.length > 0) {

				plateIdItem.setValue(plateIdArr[0]);
				plateIdItem.addChangeHandler(new ChangeHandler() {

					@Override
					public void onChange(ChangeEvent event) {
						if (!BaseHelpUtils.isNullOrEmpty(event.getValue())) {
							String value = BaseHelpUtils.getString(event.getValue());
							boolean change = false;// 是否允许本次业务部们搜索条件的变动，默认为否
							for (String str : plateIdArr) {
								if (str.equals(value)) {
									change = true;
									break;
								}
							}
							if (!change) {
								plateIdItem.setValue(event.getOldValue());
								SC.warn("提示", "您没有查看该部门数据的权限");
							}
						}
					}
				});
			}

			startDateItem = new DateItem("startDate", "开始年月份");
			startDateItem.setDefaultValue(new Date());
			startDateItem.setShowIcons(false);
			startDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);

			endDateItem = new DateItem("endDate", "结束年月份");
			endDateItem.setDefaultValue(new Date());
			endDateItem.setShowIcons(false);
			endDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);

			form.setItems(plateIdItem, startDateItem, endDateItem);
			ClientUtil.DynamicFormProcessAccordingToDevice(form);
			messageLayout.addMember(form);
			formLayout.addMember(messageLayout);
			HLayout btnLayout = new HLayout();
			btnLayout.setWidth100();
			btnLayout.setHeight(70);
			btnLayout.setMembersMargin(10);
			btnLayout.setAlign(Alignment.CENTER);

			IButton okBtn = new IButton("确认");
			okBtn.setIcon("[SKIN]/actions/save.png");
			okBtn.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					if (!form.validate()) {
						return;
					}
					String plateId = plateIdItem.getValueAsString();
					if (null == plateId || plateId.length() == 0) {
						SC.say("提示", "请选择业务部门");
						return;
					}
					// 获取开始年月份
					Date startDate = startDateItem.getValueAsDate();
					// 获取结束年月份
					Date endDate = endDateItem.getValueAsDate();

					if (startDate.after(endDate)) {
						SC.say("提示", "开始年月份不可大于结束年月份");
						return;
					}

					LinkedHashMap map = new LinkedHashMap();
					map.put("plateId", plateId);
					map.put("startDate", startDate);
					map.put("endDate", endDate);
					if (flag == 1) {// 计算操作
						onAccountSave(map);
					} else if (flag == 2) {// 加锁操作
						onLockSave(map);
					} else if (flag == 3){// 解锁操作
						onMoveLockSave(map);
					} else if(flag == 4){// 积分回收操作
						onReturnIntegral(map);
					}
				}
			});
			IButton cleanBtn = new IButton("关闭");
			cleanBtn.setIcon("[SKIN]/actions/close.png");
			cleanBtn.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					if (getParentWindow() == null) {
						return;
					}
					getParentWindow().destroy();
				}
			});
			btnLayout.addMember(okBtn);
			btnLayout.addMember(cleanBtn);
			formLayout.addMember(btnLayout);
		}
	}
	
	protected void onReturnIntegral(LinkedHashMap map) {
		final LoadingWindow loading = new LoadingWindow();
		map.put("operateEmployeeId", ClientUtil.getEmployeeId());
		DBDataSource.callOperation("EP_PlateEmployeeAchieveIntegralReturn", map, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				loading.destroy();
				if (dsResponse.getStatus() >= 0) {
					SC.say("操作成功");
					if (getParentWindow() == null) {
						return;
					}
					getParentWindow().destroy();
					DataEditEvent dee = new DataEditEvent();
					fireEvent(dee);
				} else {
					SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
				}
			}
		});
	}

	/**
	 * 解锁操作
	 * 
	 * @param map
	 */
	protected void onMoveLockSave(LinkedHashMap map) {
		final LoadingWindow loading = new LoadingWindow();
		DBDataSource.callOperation("EP_ProjectIntegralMoveLock", map, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				loading.destroy();
				if (dsResponse.getStatus() >= 0) {
					SC.say("操作成功");
					if (getParentWindow() == null) {
						return;
					}
					getParentWindow().destroy();
					DataEditEvent dee = new DataEditEvent();
					fireEvent(dee);
				} else {
					SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
				}
			}
		});
	}

	/**
	 * 上锁操作
	 * 
	 * @param map
	 */
	protected void onLockSave(LinkedHashMap map) {
		final LoadingWindow loading = new LoadingWindow();
		DBDataSource.callOperation("EP_ProjectIntegralLock", map, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				loading.destroy();
				if (dsResponse.getStatus() >= 0) {
					SC.say("操作成功");
					if (getParentWindow() == null) {
						return;
					}
					getParentWindow().destroy();
					DataEditEvent dee = new DataEditEvent();
					fireEvent(dee);
				} else {
					SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
				}
			}
		});
	}

	/**
	 * 计算操作
	 * 
	 * @param map
	 */
	protected void onAccountSave(LinkedHashMap map) {
		final LoadingWindow loading = new LoadingWindow();
		DBDataSource.callOperation("EP_ProjectIntegralAccount", map, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				loading.destroy();
				if (dsResponse.getStatus() >= 0) {
					SC.say("操作成功");
					if (getParentWindow() == null) {
						return;
					}
					getParentWindow().destroy();
					DataEditEvent dee = new DataEditEvent();
					fireEvent(dee);
				} else {
					SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
				}
			}
		});
	}

	protected final HandlerManager handlerManager = new HandlerManager(this);
	protected final List<DataEditedHandler> __dataEditedHandler = new ArrayList<>();
	private double reserveIntegral;

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

	/**
	 * @return the reserveIntegral
	 */
	public double getReserveIntegral() {
		return reserveIntegral;
	}

	/**
	 * @param reserveIntegral
	 *            the reserveIntegral to set
	 */
	public void setReserveIntegral(double reserveIntegral) {
		this.reserveIntegral = reserveIntegral;
	}

}
