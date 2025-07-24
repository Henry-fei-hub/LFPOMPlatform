package com.pomplatform.client.workflow.personnelbusiness.form;

import java.math.BigDecimal;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.ValidateUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.DoubleItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.IntegerItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.form.validator.IsIntegerValidator;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class EquipmentDetailPanel extends VLayout implements HasHandlers {

	private static final Logger logger = Logger.getLogger("");
	private final SelectItem typeItem;
	private final DoubleItem priceItem;
	private final IntegerItem amountItem;
	private final DoubleItem totalPriceItem;
	private final TextAreaItem remarkItem;
	private final TextItem personnelBusinessLinkEquipmentIdItem;
	private final TextItem parentIdItem;
	private final TextItem processTypeItem;
	private final DateTimeItem createTimeItem;
	private final DynamicForm form = new DynamicForm();
	private final VLayout vLayout;
	private final IButton saveButton;
	private final IButton cancelButton;
	private final HLayout buttonLayout;
	private Window parentWindow;
	protected final HandlerManager handlerManager = new HandlerManager(this);

	public EquipmentDetailPanel() {
		IsIntegerValidator intValidate = new IsIntegerValidator();
		intValidate.setErrorMessage("数据有误，请从下拉列表中选取正确数据");
		
		vLayout = new VLayout();
		vLayout.setWidth100();
		vLayout.setHeight100();
		vLayout.setMargin(10);
		vLayout.setMembersMargin(6);

		typeItem = new SelectItem("type", "类型");
		typeItem.setRequired(true);
		typeItem.setChangeOnKeypress(false);
		typeItem.setWidth("*");
//		typeItem.setValueMap(KeyValueManager.getValueMap("equipment_types"));
		KeyValueManager.loadValueMap("equipment_types",typeItem);
		typeItem.setValidateOnExit(true);
		typeItem.setValidators(intValidate);

		priceItem = new DoubleItem("price", "单价（元）");
		priceItem.setRequired(true);
		priceItem.setValidateOnExit(true);
		priceItem.setValidators(ValidateUtils.isFloatValidator());
		priceItem.setLength(18);
		priceItem.setDecimalPad(2);
		priceItem.setFormat("#,###,###,###,###,##0.00");
		priceItem.setWidth("*");
		priceItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				if (null != event.getValue()) {
					FormItem item = event.getItem();
					BigDecimal newValue = new BigDecimal(item.getValue().toString()).setScale(2,BigDecimal.ROUND_DOWN);
					item.setValue(newValue);
					if(null != amountItem.getValue()){
						totalPriceItem.setValue(newValue.multiply(new BigDecimal(amountItem.getValueAsString())));
					}
				}
			}
		});
		
		amountItem = new IntegerItem("amount", "数量");
		amountItem.setRequired(true);
		amountItem.setValidateOnExit(true);
		amountItem.setValidators(ValidateUtils.isIntValidator());
		amountItem.setWidth("*");
		amountItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				if (null != event.getValue()) {
					FormItem item = event.getItem();
					int value = ClientUtil.checkAndGetIntValue(event.getValue());
					item.setValue(value);
					if(null != priceItem.getValue()){
						totalPriceItem.setValue(new BigDecimal(value).multiply(new BigDecimal(priceItem.getValueAsString())));
					}
				}
			}
		});

		totalPriceItem = new DoubleItem("totalPrice", "总价（元）");
		totalPriceItem.setRequired(true);
		totalPriceItem.setValidateOnExit(true);
		totalPriceItem.setValidators(ValidateUtils.isFloatValidator());
		totalPriceItem.setLength(18);
		totalPriceItem.setDecimalPad(2);
		totalPriceItem.setFormat("#,###,###,###,###,##0.00");
		totalPriceItem.setWidth("*");
		totalPriceItem.setDisabled(true);
		totalPriceItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				if (null != event.getValue()) {
					FormItem item = event.getItem();
					BigDecimal newValue = new BigDecimal(item.getValue().toString()).setScale(2,BigDecimal.ROUND_DOWN);
					item.setValue(newValue);
				}
			}
		});
		
		remarkItem = new TextAreaItem("remark", "备注");
		remarkItem.setColSpan(3);
		remarkItem.setRowSpan(3);
		remarkItem.setWidth("*");

		personnelBusinessLinkEquipmentIdItem = new TextItem("personnelBusinessLinkEquipmentId", "设备采购ID");
		personnelBusinessLinkEquipmentIdItem.setHidden(true);

		parentIdItem = new TextItem("parentId", "父级ID");
		parentIdItem.setHidden(true);
		
		processTypeItem = new TextItem("processType", "流程类型");
		processTypeItem.setHidden(true);

		createTimeItem = new DateTimeItem("createTime", "创建时间");
		createTimeItem.setHidden(true);

		form.setItems(typeItem, priceItem, amountItem, totalPriceItem, remarkItem, personnelBusinessLinkEquipmentIdItem, parentIdItem, processTypeItem, createTimeItem);

		vLayout.addMember(form);

		saveButton = new IButton("确定", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(DataValidate()){
					DataEditEvent dee = new DataEditEvent();
					dee.setData(getValueAsRecord());
					logger.info(dee.getData().toMap().toString());
					fireEvent(dee);
					if (null == getParentWindow()) {
						return;
					}
					getParentWindow().destroy();
				}else{
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
	
	public void startEdit(Record record){
		form.editRecord(record);
	}
	
	public boolean DataValidate(){
		if(typeItem.validate()&&priceItem.validate()&&amountItem.validate()&&totalPriceItem.validate()){
			return true;
		}
		return false;
	}
	
	public Window getParentWindow() {
		return parentWindow;
	}

	public void setParentWindow(Window parentWindow) {
		this.parentWindow = parentWindow;
	}
}
