package com.pomplatform.client.workflow.form;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.FloatItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.IntegerItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.form.validator.CustomValidator;
import com.smartgwt.client.widgets.form.validator.IsIntegerValidator;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class TravelReimbursementDetailPanel extends VLayout implements HasHandlers {

	private static final Logger logger = Logger.getLogger("");
	private final IntegerItem travelReimbursementDetailIdItem;
	private final IntegerItem travelReimbursementIdItem;
	private final DateItem startDateItem;
	private final DateItem endDateItem;
	private final TextItem startAddressItem;
	private final TextItem arrivingAddressItem;
	private final IntegerItem travelDaysItem;
	private final FloatItem airfareItem;
	private final FloatItem carBoatFeeItem;
	private final FloatItem cityTransportationItem;
	private final FloatItem shippingFeeItem;
	private final FloatItem accommodationFeeItem;
	private final FloatItem drivingFeeItem;
	private final FloatItem travelAllowanceItem;
	private final FloatItem sumItem;
	private final TextAreaItem remarkItem;
	private final DynamicForm form = new DynamicForm();
	private final VLayout vLayout;
	private final IButton saveButton;
	private final IButton cancelButton;
	private final HLayout buttonLayout;
	private Window parentWindow;
	protected final HandlerManager handlerManager = new HandlerManager(this);

	public Window getParentWindow() {
		return parentWindow;
	}

	public void setParentWindow(Window parentWindow) {
		this.parentWindow = parentWindow;
	}

	public TravelReimbursementDetailPanel(Object startDate, Object endDate) {

		IsIntegerValidator intValidate = new IsIntegerValidator();
		intValidate.setErrorMessage("数据有误，请从下拉列表中选取正确数据");

		CustomValidator notNullValidate = new CustomValidator() {
			@Override
			protected boolean condition(Object value) {
				if (ClientUtil.isNullOrEmpty(value)) {
					return false;
				}
				return true;
			}
		};
		notNullValidate.setErrorMessage("必填项");

		vLayout = new VLayout();
		vLayout.setWidth100();
		vLayout.setHeight100();
		vLayout.setMargin(10);
		vLayout.setMembersMargin(6);

		travelReimbursementDetailIdItem = new IntegerItem("travelReimbursementDetailId", "差旅报销明细ID");
		travelReimbursementDetailIdItem.setHidden(true);

		travelReimbursementIdItem = new IntegerItem("travelReimbursementId", "差旅主表ID");
		travelReimbursementIdItem.setHidden(true);

		startDateItem = new DateItem("startDate", "开始日期");
		startDateItem.setWidth("*");
		startDateItem.setUseTextField(true);  
		startDateItem.setUseMask(true);
		if(null != startDate){
			startDateItem.setDefaultValue(startDate);
		}

		endDateItem = new DateItem("endDate", "结束日期");
		endDateItem.setWidth("*");
		endDateItem.setUseTextField(true);  
		endDateItem.setUseMask(true);
		if(null != endDate){
			endDateItem.setDefaultValue(endDate);
		}

		startAddressItem = new TextItem("startAddress", "出发地");
		startAddressItem.setWidth("*");
		startAddressItem.setValidateOnExit(true);
		startAddressItem.setValidators(notNullValidate);
		
		arrivingAddressItem = new TextItem("arrivingAddress", "目的地");
		arrivingAddressItem.setWidth("*");
		arrivingAddressItem.setValidateOnExit(true);
		arrivingAddressItem.setValidators(notNullValidate);
		
		travelDaysItem = new IntegerItem("travelDays", "天数");
		travelDaysItem.setLength(5);
		travelDaysItem.setWidth("*");
		travelDaysItem.setDisabled(true);
		if(null != startDate && null != endDate){
			long time = ((Date)endDate).getTime() - ((Date)startDate).getTime();
			if(time >= 0){
				time = time/1000/60/60/24;
				travelDaysItem.setValue(time+1);
			}
		}
		
		airfareItem = new FloatItem("airfare", "机票");
		airfareItem.setWidth("*");
		airfareItem.setLength(18);
		airfareItem.setDecimalPad(5);
		airfareItem.setFormat("#,###,###,###,##0.00");
		
		carBoatFeeItem = new FloatItem("carBoatFee", "车船费");
		carBoatFeeItem.setWidth("*");
		carBoatFeeItem.setLength(18);
		carBoatFeeItem.setDecimalPad(5);
		carBoatFeeItem.setFormat("#,###,###,###,##0.00");
		
		cityTransportationItem = new FloatItem("cityTransportation", "市内交通费");
		cityTransportationItem.setWidth("*");
		cityTransportationItem.setLength(18);
		cityTransportationItem.setDecimalPad(5);
		cityTransportationItem.setFormat("#,###,###,###,##0.00");
		
		shippingFeeItem = new FloatItem("shippingFee", "托运费");
		shippingFeeItem.setWidth("*");
		shippingFeeItem.setLength(18);
		shippingFeeItem.setDecimalPad(5);
		shippingFeeItem.setFormat("#,###,###,###,##0.00");
		
		accommodationFeeItem = new FloatItem("accommodationFee", "住宿费");
		accommodationFeeItem.setWidth("*");
		accommodationFeeItem.setLength(18);
		accommodationFeeItem.setDecimalPad(5);
		accommodationFeeItem.setFormat("#,###,###,###,##0.00");
		
		drivingFeeItem = new FloatItem("drivingFee", "自驾车费");
		drivingFeeItem.setWidth("*");
		drivingFeeItem.setLength(18);
		drivingFeeItem.setDecimalPad(5);
		drivingFeeItem.setFormat("#,###,###,###,##0.00");
		
		travelAllowanceItem = new FloatItem("travelAllowance", "出差补助");
		travelAllowanceItem.setWidth("*");
		travelAllowanceItem.setLength(18);
		travelAllowanceItem.setDecimalPad(5);
		travelAllowanceItem.setFormat("#,###,###,###,##0.00");
		
		sumItem = new FloatItem("sum", "小计");
		sumItem.setWidth("*");
		sumItem.setDisabled(true);
		sumItem.setLength(18);
		sumItem.setDecimalPad(5);
		sumItem.setFormat("#,###,###,###,##0.00");

		remarkItem = new TextAreaItem("remark", "摘要");
		remarkItem.setRequired(true);
		remarkItem.setColSpan(3);
		remarkItem.setRowSpan(3);
		remarkItem.setWidth("*");
		
		//选择日期后自动显示出差天数
		endDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				if(null != startDateItem.getValue() && null != endDateItem.getValue()){
					Date startDate = startDateItem.getValueAsDate();
					Date endDate = endDateItem.getValueAsDate();
					long time = endDate.getTime() - startDate.getTime();
					if(time >= 0){
						time = time/1000/60/60/24;
						travelDaysItem.setValue(time+1);
					}else{
						travelDaysItem.clearValue();
						SC.warn("提示","开始日期不能大于结束日期");
					}
				}
			}
		});
		
		startDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				if(null != startDateItem.getValue() && null != endDateItem.getValue()){
					Date startDate = startDateItem.getValueAsDate();
					Date endDate = endDateItem.getValueAsDate();
					long time = endDate.getTime() - startDate.getTime();
					if(time >= 0){
						time = time/1000/60/60/24;
						travelDaysItem.setValue(time+1);
					}else{
						travelDaysItem.clearValue();
						SC.warn("提示","开始日期不能大于结束日期");
					}
				}
			}
		});
		
		//小计自动汇总
		airfareItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				sumMoney(event);
			}
		});
		
		carBoatFeeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				sumMoney(event);
			}
		});
		
		cityTransportationItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				sumMoney(event);
			}
		});
		
		shippingFeeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				sumMoney(event);
			}
		});
		
		accommodationFeeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				sumMoney(event);
			}
		});
		
		drivingFeeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				sumMoney(event);
			}
		});
		
		travelAllowanceItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				sumMoney(event);
			}
		});

		form.setNumCols(4);
		form.setItems(travelReimbursementDetailIdItem, travelReimbursementIdItem, startDateItem, endDateItem,
				startAddressItem, arrivingAddressItem, travelDaysItem, airfareItem, carBoatFeeItem,
				cityTransportationItem, shippingFeeItem, accommodationFeeItem, drivingFeeItem, travelAllowanceItem,
				sumItem, remarkItem);

		vLayout.addMember(form);

		saveButton = new IButton("确定", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (form.validate() && DataValidate() ) {
					if(record!=null) {
						//获取小计
						BigDecimal sum=BaseHelpUtils.getBigDecimalValue(sumItem.getValue());
						//获取付款金额
						BigDecimal payAmount=BaseHelpUtils.getBigDecimalValue(record.getAttribute("payAmount"));
						//获取冲账金额
						BigDecimal  reverseAmount=BaseHelpUtils.getBigDecimalValue(record.getAttribute("reverseAmount"));
						//金额
						BigDecimal amount=BigDecimal.ZERO;
						amount=payAmount.add(reverseAmount);
						if(sum.compareTo(amount)!=0) {
							SC.ask("小计金额["+sum+"]与预算附件金额["+amount+"]不相等,是否继续呢？", new BooleanCallback() {
								@Override
								public void execute(Boolean value) {
									if(value) {
										DataEditEvent dee = new DataEditEvent();
										dee.setData(getValueAsRecord());
										fireEvent(dee);
										if (null == getParentWindow()) {
											return;
										}
										getParentWindow().destroy();
									}else {
										return;
									}
								}
							});
						}else {
							DataEditEvent dee = new DataEditEvent();
							dee.setData(getValueAsRecord());
							fireEvent(dee);
							if (null == getParentWindow()) {
								return;
							}
							getParentWindow().destroy();
						}
					}else {
						DataEditEvent dee = new DataEditEvent();
						dee.setData(getValueAsRecord());
						fireEvent(dee);
						if (null == getParentWindow()) {
							return;
						}
						getParentWindow().destroy();
					}
				} else {
					return;
				}
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
		buttonLayout.setHeight100();
		buttonLayout.setMargin(8);
		buttonLayout.setMembersMargin(20);
		buttonLayout.setAlign(Alignment.CENTER);
		buttonLayout.addMember(saveButton);
		buttonLayout.addMember(cancelButton);

		vLayout.addMember(buttonLayout);

		addMember(vLayout);
	}

	@Override
	public void fireEvent(GwtEvent<?> event) {
		handlerManager.fireEvent(event);
	}

	public Record getValueAsRecord() {
		Map map = form.getValues();
		Record record = new Record();
		if (null != map && !map.isEmpty()) {
			for (Object key : map.keySet()) {
				record.setAttribute(key.toString(), map.get(key));
			}
		}
		return record;
	}

	public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
		return handlerManager.addHandler(DataEditEvent.TYPE, handler);
	}

	public void startEdit(Record record) {
		form.editRecord(record);
	}

	//保证起止日期、起讫地点、备注、报销金额不为空
	public boolean DataValidate() {
		if (null != startDateItem.getValue() && null != endDateItem.getValue()) {
			Date startDate = startDateItem.getValueAsDate();
			Date endDate = endDateItem.getValueAsDate();
			long time = endDate.getTime() - startDate.getTime();
			if (time >= 0) {
				if (startAddressItem.validate() && arrivingAddressItem.validate() && null != travelDaysItem.getValue()
						&& ClientUtil.checkAndGetIntValue(travelDaysItem.getValue()) > 0 && null != sumItem.getValue()
						&& (new BigDecimal(ClientUtil.checkAndGetDoubleValue(sumItem.getValue()))
								.compareTo(BigDecimal.ZERO) > 0)) {
					return true;
				}
			}else{
				SC.warn("提示", "开始日期不能大于结束日期");
				return false;
			}
		}
		SC.warn("提示", "请将数据填写完善之后再提交");
		return false;
	}
	
	//汇总所有报销小项的总额
	public void sumMoney(ChangedEvent event) {
		BigDecimal sum = BigDecimal.ZERO;
		if (null != event.getValue()) {
			FormItem item = event.getItem();
			BigDecimal newValue = new BigDecimal(item.getValue().toString())
					.divide(BigDecimal.ONE, 2, BigDecimal.ROUND_DOWN);
			item.setValue(newValue);
		}
		if (null != airfareItem.getValue()) {
			sum = sum.add(new BigDecimal(airfareItem.getValueAsString()));
		}
		if (null != carBoatFeeItem.getValue()) {
			sum = sum.add(new BigDecimal(carBoatFeeItem.getValueAsString()));
		}
		if (null != cityTransportationItem.getValue()) {
			sum = sum.add(new BigDecimal(cityTransportationItem.getValueAsString()));
		}
		if (null != shippingFeeItem.getValue()) {
			sum = sum.add(new BigDecimal(shippingFeeItem.getValueAsString()));
		}
		if (null != accommodationFeeItem.getValue()) {
			sum = sum.add(new BigDecimal(accommodationFeeItem.getValueAsString()));
		}
		if (null != drivingFeeItem.getValue()) {
			sum = sum.add(new BigDecimal(drivingFeeItem.getValueAsString()));
		}
		if (null != travelAllowanceItem.getValue()) {
			sum = sum.add(new BigDecimal(travelAllowanceItem.getValueAsString()));
		}
		if (null != sumItem) {
			sumItem.setValue(sum);
		}
	}
	
	private Record record;

	public Record getRecord() {
		return record;
	}

	public void setRecord(Record record) {
		this.record = record;
	}
	
}
