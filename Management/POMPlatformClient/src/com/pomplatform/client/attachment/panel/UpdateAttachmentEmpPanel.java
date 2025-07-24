package com.pomplatform.client.attachment.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.DelicacyListGrid;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.attachment.datasource.DSAttachmentEmp;
import com.pomplatform.client.selectgridemployeevalue.datasource.DSSelectGridEmployeeValue;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class UpdateAttachmentEmpPanel extends VLayout implements HasHandlers{
	
	protected DynamicForm __form = new DynamicForm();
	
	
	private SelectItem departmentIdItem;
	
	private ListGrid empGrid;
	
	public final static String BORDER_STYLE = "1px solid gray";
    public final static String BACKGROUND_COLOR = "azure";
    public final static String BUTTON_BACKGROUND_COLOR = "azure";
    public final static String FORM_BORDER_STYLE = "1px solid #808080";
	
	public UpdateAttachmentEmpPanel(){
		
	}
	
	public UpdateAttachmentEmpPanel(Record record){
		setBackgroundColor(BACKGROUND_COLOR);
		setAttachmentManageId(record.getAttributeAsInt("attachmentManageId"));
		HLayout formLayout = new HLayout();
		formLayout.setHeight(200);
		formLayout.setWidth100();
		
		ListGridField employeeNameField = new ListGridField("employeeName");
		ListGridField employeeNoField = new ListGridField("employeeNo");
		ListGridField departmentIdField = new ListGridField("departmentId");
		
		Criteria ct = new Criteria();
		ct.addCriteria("status", 0);
		
		ComboBoxItem projectManageIdItem = new ComboBoxItem("projectManageId", "项目负责人");
		projectManageIdItem.setWidth("*");
		projectManageIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		projectManageIdItem.setChangeOnKeypress(false);
		projectManageIdItem.setOptionDataSource(DSSelectGridEmployeeValue.getInstance());
		projectManageIdItem.setValueField("employeeId");
		projectManageIdItem.setRequired(true);
		projectManageIdItem.setPickListCriteria(ct);
		projectManageIdItem.setDisplayField("employeeName");
		projectManageIdItem.setPickListFields(employeeNameField, employeeNoField, departmentIdField);
		projectManageIdItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				if(null != event.getValue()){
					ListGridRecord record = projectManageIdItem.getSelectedRecord();
					if(null != record){
						departmentIdItem.setValue(record.getAttribute("departmentId"));
					}
				}
				
			}
		});
		
	    departmentIdItem = new SelectItem("departmentId", "部门");
	    departmentIdItem.setRequired(true);
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		departmentIdItem.setHidden(false);
		departmentIdItem.setWidth("*");
		departmentIdItem.setDisabled(true);
		
		ComboBoxItem superProjectManageIdItem = new ComboBoxItem("superProjectManageId", "大项目负责人");
		superProjectManageIdItem.setChangeOnKeypress(false);
		superProjectManageIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
//		superProjectManageIdItem.setValueMap(KeyValueManager.getValueMap("employee_list"));
		KeyValueManager.loadValueMap("employee_list",superProjectManageIdItem);
		superProjectManageIdItem.setRequired(true);
		superProjectManageIdItem.setWidth("*");
//		superProjectManageIdItem.setPickListCriteria(ct);
//		superProjectManageIdItem.setOptionDataSource(DSSelectGridEmployeeValue.getInstance());
//		superProjectManageIdItem.setValueField("employeeId");
//		superProjectManageIdItem.setDisplayField("employeeName");
//		superProjectManageIdItem.setPickListFields(employeeNameField, employeeNoField, departmentIdField);
		__form.setFields(projectManageIdItem, departmentIdItem, superProjectManageIdItem);
		__form.setNumCols(2);
		__form.editRecord(record);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		formLayout.addMember(__form);
		
		HLayout empLayout = new HLayout();
		empLayout.setWidth100();
		
		VLayout gridLayout = new VLayout();
		gridLayout.setWidth("80%");
		gridLayout.setHeight100();
		
		empGrid = new ListGrid();
		ListGridField employeeIdGrid = new ListGridField("employeeId");
		
		ComboBoxItem employeeItem = new ComboBoxItem("employeeId", "员工");
		employeeItem.setPickListCriteria(ct);
		employeeItem.setChangeOnKeypress(false);
		employeeItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		employeeItem.setOptionDataSource(DSSelectGridEmployeeValue.getInstance());
		employeeItem.setValueField("employeeId");
		employeeItem.setDisplayField("employeeName");
		employeeItem.setPickListFields(employeeNameField, employeeNoField, departmentIdField);
		
		employeeIdGrid.setEditorProperties(employeeItem);
		empGrid.setCanEdit(true);
		empGrid.setCanRemoveRecords(true);
		empGrid.setFields(employeeIdGrid);
		empGrid.setSaveLocally(true);
		empGrid.setDataSource(DSAttachmentEmp.getInstance());
		gridLayout.addMember(empGrid);
		
		VLayout btnLayout = new VLayout();
		btnLayout.setMembersMargin(10);
		btnLayout.setPadding(10);
		btnLayout.setWidth(130);
		btnLayout.setHeight100();
		
		IButton addBtn = new IButton("新增");
		btnLayout.addMember(addBtn);
		addBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Record record = new Record();
				record.setAttribute("attachmentManageId", getAttachmentManageId());
				empGrid.startEditingNew(record);
				
			}
		});
		IButton submitBtn = new IButton("提交");
		btnLayout.addMember(submitBtn);
		submitBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(__form.validate()){
					Map params = __form.getValues();
					params.put("opt_type", "updateAttachmentEmp");
					params.put("list", empGrid.getRecords());
					params.put("employeeId", ClientUtil.getEmployeeId());
					DBDataSource.callOperation("EP_CustomAttachmentWorkProcess", params, new DSCallback() {
						
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if (dsResponse.getStatus() >= 0) {
								getFatherWindow().destroy();
								DataEditEvent dee = new DataEditEvent();
	                            fireEvent(dee);
							}else{
								ClientUtil.displayErrorMessage(dsResponse);
							}
							
						}
					});
				}else{
					SC.say("请按系统提示填写好信息");
				}
				
				
			}
		});
		
		empLayout.addMember(gridLayout);
		empLayout.addMember(btnLayout);
		addMember(formLayout);
		addMember(empLayout);
	}
	
	public void loadEmpData(){
		Map<String, Object> params = new HashMap<>();
		params.put("opt_type", "getAttachmentEmp");
		params.put("attachmentManageId", getAttachmentManageId());
		DBDataSource.callOperation("EP_CustomAttachmentWorkProcess", params, new DSCallback() {
			
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() > 0){
					empGrid.setData(dsResponse.getData());
				}
				
			}
		});
	}
	
	private int attachmentManageId;

	public int getAttachmentManageId() {
		return attachmentManageId;
	}

	public void setAttachmentManageId(int attachmentManageId) {
		this.attachmentManageId = attachmentManageId;
	}
	
	private Window fatherWindow;

	public Window getFatherWindow() {
		return fatherWindow;
	}

	public void setFatherWindow(Window fatherWindow) {
		this.fatherWindow = fatherWindow;
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
	
}
