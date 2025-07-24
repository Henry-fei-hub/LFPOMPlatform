package com.pomplatform.client.purchase.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class AddSupplierContactPanel extends HLayout implements HasHandlers {
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	private Window parentWindow;
	private static Logger __logger = Logger.getLogger("");
	private DynamicForm form;
	private TextItem contactNameItem;
	private TextItem contactPositionItem;
	private TextItem contactPhoneItem;
	private TextItem contactEmailItem;
	private TextItem contactFaxItem;
	private SelectItem contactGenderItem;
	private SelectItem contactTypeItem;
	private TextAreaItem remarkItem;
	private IButton okBtn;

	public void initComponents() {
		VLayout formLayout = new VLayout();
		formLayout.setHeight100();
		formLayout.setWidth100();
		formLayout.setAlign(Alignment.CENTER);
		addMember(formLayout);

		form = new DynamicForm();
		form.setNumCols(4);
		form.setAlign(Alignment.CENTER);
		form.setPadding(5);
		form.setMargin(5);
		form.setWidth100();
		form.setHeight("95%");
		formLayout.addMember(form);
		
		contactNameItem = new TextItem("contactName", shouldNotBeNull+"姓名");
		contactNameItem.setWidth("*");
		__formItems.add(contactNameItem);
		
		contactPositionItem = new TextItem("contactPosition", "职位");
		contactPositionItem.setWidth("*");
		__formItems.add(contactPositionItem);

		contactPhoneItem = new TextItem("contactPhone","联系电话");
		contactPhoneItem.setWidth("*");
		__formItems.add(contactPhoneItem);
		
		contactEmailItem = new TextItem("contactEmail", "邮箱地址");
		contactEmailItem.setWidth("*");
		__formItems.add(contactEmailItem);
		
		contactFaxItem = new TextItem("contactFax", "传真");
		contactFaxItem.setWidth("*");
		__formItems.add(contactFaxItem);
		
		contactGenderItem = new SelectItem("contactGender","性别");
		contactGenderItem.setWidth("*");
		contactGenderItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_12"));
		__formItems.add(contactGenderItem);
        
		contactTypeItem = new SelectItem("contactType", shouldNotBeNull+"联系人类型");
		contactTypeItem.setWidth("*");
		contactTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_146"));
		__formItems.add(contactTypeItem);

        remarkItem = new TextAreaItem("remark", "备注");
        remarkItem.setColSpan(4);
        remarkItem.setRowSpan(2);
        remarkItem.setWidth("*");
        __formItems.add(remarkItem);
        
		form.setItems(getFormItemArray());
		ClientUtil.DynamicFormProcessAccordingToDevice(form);
		HLayout btnLayout = new HLayout(10);
		btnLayout.setWidth100();
		btnLayout.setHeight("5%");
		btnLayout.setAlign(Alignment.RIGHT);

		okBtn = new IButton("确认");
		okBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (getParentWindow() == null) {
					return;
				}
				boolean isSubmit = checkData();
				if(isSubmit){
					Map<String,Object> map = getValueMap();
					getParentWindow().setLayoutData(map);
					DataEditEvent dee = new DataEditEvent();
					fireEvent(dee);
					getParentWindow().destroy();
				}
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
			}
		});
		btnLayout.addMember(okBtn);
		btnLayout.addMember(cleanBtn);
		formLayout.addMember(btnLayout);
		
	}
	
	protected List<FormItem> __formItems = new ArrayList<>();
	protected final HandlerManager handlerManager = new HandlerManager(this);
	protected final List<DataEditedHandler> __dataEditedHandler = new ArrayList<>();
	
	public FormItem[] getFormItemArray() {
        return __formItems.toArray(new FormItem[__formItems.size()]);
    }
	
	//数据校验
	public Boolean checkData(){
		int len = __formItems.size();
		boolean isSubmit = true;
		if(len > 0){
			for(FormItem r : __formItems){
				String name = r.getName();
				Object value = r.getValue();
				if(BaseHelpUtils.isNullOrEmpty(value)){
					if(name == "contactName"){
						SC.say("提示","姓名不可为空");
						isSubmit = false;
						break;
					}else if(name == "contactType"){
						SC.say("提示","联系人类型不可为空");
						isSubmit = false;
						break;
					}
				}
			}
		}
		return isSubmit;
	}
	
	//数据封装
	public Map<String,Object> getValueMap(){
		Map<String,Object> valueMap = new HashMap<>();
		int len = __formItems.size();
		if(len > 0){
			for(FormItem r : __formItems){
				valueMap.put(r.getName(),r.getValue());
			}
		}
		return valueMap;
	}
	
	//设置表单不可编辑
	public void setFormItemDisabled(){
		okBtn.hide();
		int len = __formItems.size();
		if(len > 0){
			for(FormItem r : __formItems){
				r.setDisabled(true);
			}
		}
	}
	
	//修改装载数据
	public void setValueRecord(Map<String,Object> valueMap){
		if(!BaseHelpUtils.isNullOrEmpty(valueMap)){
			form.setValues(valueMap);
		}
	}

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
	
	LinkedHashMap<String,String> map = new LinkedHashMap<>();

	public LinkedHashMap<String, String> getMap() {
		return map;
	}

	public void setMap(LinkedHashMap<String, String> map) {
		this.map = map;
	}
	

}
