package com.pomplatform.client.workflow.form;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.ValidateUtils;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.form.validator.IsIntegerValidator;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class NormalReimbursementDetailPanel extends VLayout implements HasHandlers {

	private static final Logger logger = Logger.getLogger("");
	private final SelectItem mainItemIdItem;
	private final SelectItem subItemIdItem;
	private final TextItem amountItem;
	private final TextAreaItem remarkItem;
	private final TextItem projectNormalReimbursementDetailIdItem;
	private final TextItem projectNormalReimbursementIdItem;
	private final DateTimeItem reimbursementTimeItem;
	private final TextItem statusItem;
	private final DynamicForm form = new DynamicForm();
	private final VLayout vLayout;
	private final IButton saveButton;
	private final IButton cancelButton;
	private final HLayout buttonLayout;
	private Window parentWindow;
	protected final HandlerManager handlerManager = new HandlerManager(this);
	private LinkedHashMap<String,String> mainItemMap = new LinkedHashMap<>();
	private LinkedHashMap<String,String> subItemMap = new LinkedHashMap<>();

	public NormalReimbursementDetailPanel(LinkedHashMap<String,String> mainItemMap, final LinkedHashMap<String,String> subItemMap) {
		this.mainItemMap = mainItemMap;
		this.subItemMap = subItemMap;
		IsIntegerValidator intValidate = new IsIntegerValidator();
		intValidate.setErrorMessage("数据有误，请从下拉列表中选取正确数据");
		
		vLayout = new VLayout();
		vLayout.setWidth100();
		vLayout.setHeight100();
		vLayout.setMargin(10);
		vLayout.setMembersMargin(6);

		mainItemIdItem = new SelectItem("mainItemId", "报销科目");
		mainItemIdItem.setRequired(true);
		mainItemIdItem.setChangeOnKeypress(false);
		mainItemIdItem.setValueMap(mainItemMap);
		mainItemIdItem.setWidth("*");
		mainItemIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		mainItemIdItem.setValidateOnExit(true);
		mainItemIdItem.setValidators(intValidate);

		subItemIdItem = new SelectItem("subItemId", "报销选项");
		subItemIdItem.setChangeOnKeypress(false);
		subItemIdItem.setWidth("*");
		subItemIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		subItemIdItem.setValidateOnExit(true);
		subItemIdItem.setValidators(intValidate);

		amountItem = new TextItem("amount", "报销金额");
		amountItem.setRequired(true);
		amountItem.setValidateOnExit(true);
		amountItem.setValidators(ValidateUtils.isFloatValidator());
		amountItem.setWidth("*");
		amountItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				if (null != event.getValue()) {
					FormItem item = event.getItem();
					BigDecimal newValue = new BigDecimal(item.getValue().toString())
							.divide(BigDecimal.ONE, 2, BigDecimal.ROUND_DOWN);
					item.setValue(newValue);
				}
			}
		});

		remarkItem = new TextAreaItem("remark", "摘要");
		remarkItem.setColSpan(3);
		remarkItem.setRowSpan(3);
		remarkItem.setRequired(true);
		remarkItem.setWidth("*");

		projectNormalReimbursementDetailIdItem = new TextItem("projectNormalReimbursementDetailIdField", "普通报销详情ID");
		projectNormalReimbursementDetailIdItem.setHidden(true);

		projectNormalReimbursementIdItem = new TextItem("projectNormalReimbursementId", "普通报销主要信息ID");
		projectNormalReimbursementIdItem.setHidden(true);

		reimbursementTimeItem = new DateTimeItem("reimbursementTime", "费用产生时间");
		reimbursementTimeItem.setHidden(true);

		statusItem = new TextItem("status", "状态");
		statusItem.setHidden(true);

		mainItemIdItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				subItemIdItem.clearValue();
				if (null != event.getValue()) {
					LinkedHashMap<String,String> tempMap = new LinkedHashMap<>();
					String parent = event.getValue().toString();
					for(String str : subItemMap.keySet()){
						String[] arr = str.split("-");
						if(arr[1].equals(parent)){
							tempMap.put(arr[0], subItemMap.get(str));
						}
					}
					subItemIdItem.setValueMap(tempMap);
				}
			}
		});

		form.setItems(mainItemIdItem, subItemIdItem, amountItem, remarkItem, projectNormalReimbursementDetailIdItem,
				projectNormalReimbursementIdItem, reimbursementTimeItem, statusItem);

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
		if(null != mainItemIdItem.getValue()){
			LinkedHashMap<String,String> tempMap = new LinkedHashMap<>();
			String parent = mainItemIdItem.getValue().toString();
			for(String str : subItemMap.keySet()){
				String[] arr = str.split("-");
				if(arr[1].equals(parent)){
					tempMap.put(arr[0], subItemMap.get(str));
				}
			}
			subItemIdItem.setValueMap(tempMap);
		}
	}
	
	public boolean DataValidate(){
		if(mainItemIdItem.validate()&&subItemIdItem.validate()&&amountItem.validate()&&remarkItem.validate()&&null!=amountItem.getValue()){
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
