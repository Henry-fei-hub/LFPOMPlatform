package com.pomplatform.client.workflow.panel;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.print.attribute.standard.MediaSize.ISO;

import com.delicacy.client.MapUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.management.datasource.DSSelectGridEmployeeValue;
import com.delicacy.client.ui.DelicacyListGrid;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.pomplatform.client.capitaldistribution.datasource.DSPlateCapitalDistribution;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.workflow.datasource.DSUpdateActivityEmployee;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.SummaryFunctionType;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

public class UpdateActivityEmployeeEditPanel extends VLayout{

	private ToolStrip navLayout;
	
	private Window parent;
	
	private Record[] records;
	
	private ComboBoxItem employeeItem;
	
	protected final HandlerManager handlerManager = new HandlerManager(this);

	private static final Logger logger = Logger.getLogger("");
	
	public void initComponents(){
		setWidth100();
		setHeight100();
		
		ListGridField employeeIdField = new ListGridField("employeeId");
		ListGridField employeeNoField = new ListGridField("employeeNo");
		ListGridField employeeNameField = new ListGridField("employeeName");
		ListGridField departmentIdField = new ListGridField("departmentId");
		KeyValueManager.loadValueMap("all_departments",departmentIdField);
		
		employeeItem = new ComboBoxItem("employeeId", "新的节点审批人");
        employeeItem.setTitleOrientation(TitleOrientation.TOP);
        employeeItem.setOptionDataSource(DSSelectGridEmployeeValue.getInstance());
        employeeItem.setChangeOnKeypress(false);
        employeeItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
        employeeItem.setValueField(employeeIdField.getName());
        employeeItem.setDisplayField(employeeNameField.getName());
        employeeItem.setPickListFields(departmentIdField, employeeNoField, employeeNameField);
        employeeItem.setPickListWidth(500);
        employeeItem.setWidth("*");
        //只查询出在职的员工
        Criteria employeeCondition = new Criteria();
        employeeCondition.addCriteria("status", 0);
        employeeItem.setPickListCriteria(employeeCondition);
        employeeItem.setColSpan(2);
        
        DynamicForm form = new DynamicForm();
        form.setWidth100();
        form.setHeight100();
        form.setItems(employeeItem);
        form.setNumCols(2);
		addMember(form);
		
		IButton sureButton = new IButton("确定");
		sureButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if(null != employeeItem.getValue()){
							Map params = new HashMap<>();
							MapUtils.convertRecordToMap(DSUpdateActivityEmployee.getInstance(), records, params, "activityDatas");
							params.put("employeeId", employeeItem.getValue());
							params.put("optType", "updateActivityEmployee");
							DBDataSource.callOperation("EP_WrokflowProcessor", params, new DSCallback() {
								
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if(dsResponse.getStatus() >= 0){
										DataEditEvent dee = new DataEditEvent();
										dee.setData(new Record());
										fireEvent(dee);
										if(null == getParent()){
											return;
										}
										getParent().destroy();
									}else{
										ClientUtil.displayErrorMessage(dsResponse);
									}
								}
							});
						}
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				});
				
			}
		});
		
		IButton cancelButton = new IButton("取消");
		cancelButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if(null == getParent()){
							return;
						}
						getParent().destroy();
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				});
			}
		});
		
		navLayout = new ToolStrip();
		navLayout.setPadding(5);
		navLayout.setHeight(40);
		navLayout.setWidth100();
		navLayout.addFill();
		navLayout.setBackgroundColor("#f60");
		navLayout.setBorder("none");
		navLayout.setMembersMargin(15);
		navLayout.addMembers(sureButton, cancelButton);
		
		addMember(navLayout);	
	}

	public Window getParent() {
		return parent;
	}
	public void setParent(Window parent) {
		this.parent = parent;
	}
	
	public Record[] getRecords() {
		return records;
	}

	public void setRecords(Record[] records) {
		this.records = records;
	}

	@Override
	public void fireEvent(GwtEvent<?> event) {
		handlerManager.fireEvent(event);
	}
	
	public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
		return handlerManager.addHandler(DataEditEvent.TYPE, handler);
	}
}
