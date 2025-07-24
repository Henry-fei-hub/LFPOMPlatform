package com.pomplatform.client.customer.panel;

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
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class AddCustomerContactPanel extends HLayout implements HasHandlers {
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	private Window parentWindow;
	private static Logger __logger = Logger.getLogger("");
	private DynamicForm form;
	private TextItem nameItem;
	private TextItem gradeItem;
	private TextItem mobileItem;
	private TextItem telephoneItem;
	private TextItem emailItem;
	private DateItem birthDateItem;
	private SelectItem genderItem;
	private TextItem workAddressItem;
	private SelectItem employeeTypeItem;
	private SelectItem personalInfluenceItem;
	private SelectItem cooperationRelationItem;
	private SelectItem cooperationAttitudeItem;
	private TextAreaItem complaintAdviceItem;
	private TextAreaItem giftRecordItem;
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
		
		nameItem = new TextItem("name", "姓名");
		nameItem.setWidth("*");
		__formItems.add(nameItem);
		
		gradeItem = new TextItem("grade", "职务");
		gradeItem.setWidth("*");
		__formItems.add(gradeItem);

		mobileItem = new TextItem("mobile", "商务座机");
		mobileItem.setWidth("*");
		__formItems.add(mobileItem);
		
		telephoneItem = new TextItem("telephone", "移动电话");
		telephoneItem.setWidth("*");
		__formItems.add(telephoneItem);
		
		emailItem = new TextItem("email", "邮箱地址");
		emailItem.setWidth("*");
		__formItems.add(emailItem);
		
		birthDateItem = new DateItem("birthDate", "生日日期");
		birthDateItem.setWidth("*");
		birthDateItem.setUseTextField(true);
		__formItems.add(birthDateItem);
		
		genderItem = new SelectItem("gender","性别");
		genderItem.setWidth("*");
		genderItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_12"));
		__formItems.add(genderItem);
		
		workAddressItem = new TextItem("workAddress","工作地址");
		workAddressItem.setWidth("*");
		__formItems.add(workAddressItem);
        
		employeeTypeItem = new SelectItem("employeeType", "联系人类型");
		employeeTypeItem.setWidth("*");
		employeeTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_146"));
		__formItems.add(employeeTypeItem);

		personalInfluenceItem = new SelectItem("personalInfluence", "个人影响力");
		personalInfluenceItem.setWidth("*");
		personalInfluenceItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_147"));
		__formItems.add(personalInfluenceItem);
		
		cooperationRelationItem = new SelectItem("cooperationRelation", "与我司合作关系");
		cooperationRelationItem.setWidth("*");
		cooperationRelationItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_148"));
		__formItems.add(cooperationRelationItem);
		
		cooperationAttitudeItem = new SelectItem("cooperationAttitude", "对我司态度");
		cooperationAttitudeItem.setWidth("*");
		cooperationAttitudeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_149"));
		__formItems.add(cooperationAttitudeItem);
		
		complaintAdviceItem = new TextAreaItem("complaintAdvice","投诉&建议");
		complaintAdviceItem.setWidth("*");
		complaintAdviceItem.setColSpan(2);
		complaintAdviceItem.setRowSpan(2);
		__formItems.add(complaintAdviceItem);
		
		giftRecordItem = new TextAreaItem("giftRecord","礼物记录");
		giftRecordItem.setWidth("*");
		giftRecordItem.setColSpan(2);
		giftRecordItem.setRowSpan(2);
		__formItems.add(giftRecordItem);
		
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
		/*if(len > 0){
			for(FormItem r : __formItems){
				String name = r.getName();
				Object value = r.getValue();
				if(BaseHelpUtils.isNullOrEmpty(value)){
					if(name == "name"){
						SC.say("提示","姓名不可为空");
						isSubmit = false;
						break;
					}else if(name == "grade"){
						SC.say("提示","职务不可为空");
						isSubmit = false;
						break;
					}else if(name == "mobile"){
						SC.say("提示","商务座机不可为空");
						isSubmit = false;
						break;
					}else if(name == "telephone"){
						SC.say("提示","移动电话不可为空");
						isSubmit = false;
						break;
					}else if(name == "birthDate"){
						SC.say("提示","生日日期不可为空");
						isSubmit = false;
						break;
					}else if(name == "gender"){
						SC.say("提示","性别不可为空");
						isSubmit = false;
						break;
					}else if(name == "employeeType"){
						SC.say("提示","联系人类型不可为空");
						isSubmit = false;
						break;
					}
				}
			}
		}*/
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
