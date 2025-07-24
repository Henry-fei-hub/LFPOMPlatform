package com.pomplatform.client.poolmanage.panel;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.workflow.datasource.DSBusinessCategory;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout; 

public class SetBusinessPanel extends HLayout implements HasHandlers {

	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	private final Logger __logger = Logger.getLogger("");
    private Window parentWindow;
    private DynamicForm form;
    private TextItem employeeNoItem;
    private TextItem employeeNameItem;
    private SelectItem businessIdsItem;

    public void initComponents() {
    	VLayout totalLayout = new VLayout(10);
    	totalLayout.setWidth100();
    	totalLayout.setHeight100();
    	addMember(totalLayout);
    	
    	form = new DynamicForm();
        form.setNumCols(2);
        form.setAlign(Alignment.CENTER);
        form.setHeight("90%");
        
        employeeNoItem = new TextItem("employeeNo","员工编号");
        employeeNoItem.setWidth("*");
        employeeNoItem.setDisabled(true);
        
        employeeNameItem = new TextItem("employeeName","员工姓名");
        employeeNameItem.setWidth("*");
        employeeNameItem.setDisabled(true);
        
        businessIdsItem = new SelectItem("businessIds",shouldNotBeNull+"业务类别");
        businessIdsItem.setWidth("*");
        businessIdsItem.setOptionDataSource(DSBusinessCategory.getInstance());
        businessIdsItem.setCanEdit(true);
        businessIdsItem.setChangeOnKeypress(true);
        businessIdsItem.setValueField("businessCategoryId");
        businessIdsItem.setDisplayField("businessCategoryName");
        businessIdsItem.setMultiple(true);
        
        form.setItems(employeeNoItem,employeeNameItem,businessIdsItem);
        ClientUtil.DynamicFormProcessAccordingToDevice(form);
        totalLayout.addMember(form);
  
        HLayout hLayout = new HLayout(10);  
        hLayout.setMembersMargin(10); 
        hLayout.setAlign(Alignment.RIGHT);
        hLayout.setHeight("10%");
        IButton sureButton = new IButton("确认");
        sureButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				String businessNames = BaseHelpUtils.getString(businessIdsItem.getDisplayValue());
				String businessIds = BaseHelpUtils.getString(businessIdsItem.getValue());
				if(BaseHelpUtils.isNullOrEmpty(businessIds)) {
					SC.say("提示", "请选择业态数据");
					return;
				}
				if(!BaseHelpUtils.isNullOrEmpty(parentWindow)) {
					parentWindow.destroy();
				}
				Record record = new Record();
				record.setAttribute("businessNames", businessNames);
				record.setAttribute("businessIds", businessIds);
				DataEditEvent dee = new DataEditEvent();
				dee.setData(record);
				fireEvent(dee);
			}
		});
        IButton cancelButton = new IButton("取消");
        cancelButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(!BaseHelpUtils.isNullOrEmpty(parentWindow)) {
					parentWindow.destroy();
				}
			}
		});
        hLayout.addMember(sureButton);  
        hLayout.addMember(cancelButton);  
  
        totalLayout.addMember(hLayout);  
    }
    
    public void setData(Record record) {
    	if(!BaseHelpUtils.isNullOrEmpty(record)) {
    		form.setValues(record.toMap());
    	}
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
