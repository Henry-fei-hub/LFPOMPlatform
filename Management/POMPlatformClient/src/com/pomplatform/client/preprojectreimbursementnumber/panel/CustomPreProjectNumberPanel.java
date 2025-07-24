package com.pomplatform.client.preprojectreimbursementnumber.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.LayoutPolicy;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.validator.IsIntegerValidator;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

public class CustomPreProjectNumberPanel extends AbstractWizadPage {

	private static Logger __LOGGER = Logger.getLogger("");
	 
	private DynamicForm __infoForm;
	private final TextItem preProjectReimbursementNumberIdItem;
	private final TextItem customNumberItem;
	private final ComboBoxItem mainProjectIdItem;
	private final ComboBoxItem projectManagerItem;
	private final SelectItem businessTypeItem;
	private final SelectItem projectTypeItem;
	private final SelectItem deptItem;
	private final TextItem remarkItem;
	
	
	public static PopupWindow popupWindow;

	public CustomPreProjectNumberPanel(ListGridRecord selected1) {
		String arr[]=null;
		String customNumber=selected1.getAttributeAsString("customNumber");
		if(!BaseHelpUtils.isNullOrEmpty(customNumber)){
			//1608008-06-33-812
			arr=customNumber.split("-");
		}
		
		
		preProjectReimbursementNumberIdItem = new TextItem("preProjectReimbursementNumberId", "主键编码");
		preProjectReimbursementNumberIdItem.setRequired(true);
		preProjectReimbursementNumberIdItem.setHidden(true);
		preProjectReimbursementNumberIdItem.setValue(selected1.getAttributeAsInt("preProjectReimbursementNumberId"));
		IsIntegerValidator preProjectReimbursementNumberIdValidator = new IsIntegerValidator();
		preProjectReimbursementNumberIdItem.setValidators(preProjectReimbursementNumberIdValidator);
		__formItems.add(preProjectReimbursementNumberIdItem);
		
		customNumberItem = new TextItem("customNumber", "前期项目信息编号");
		customNumberItem.setWidth("*");
		customNumberItem.setValue(customNumber);
		customNumberItem.setDisabled(true);
		__formItems.add(customNumberItem);
		mainProjectIdItem = new ComboBoxItem("mainProjectId", "前期项目");
		mainProjectIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		mainProjectIdItem.setWidth("*");
		LinkedHashMap<Integer, String> mainProjectIdLinkHashMap=new LinkedHashMap<>();
		Map preparams = new HashMap<>();
		DBDataSource.callOperation("EP_CustomPreProjectName", preparams, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() < 0) {
					ClientUtil.displayErrorMessage(dsResponse);
				} else {
					Record[] record=dsResponse.getData();
					for(Record obj:record){
						mainProjectIdLinkHashMap.put(obj.getAttributeAsInt("preProjectId"), obj.getAttributeAsString("projectName"));
					}
					mainProjectIdItem.setValueMap(mainProjectIdLinkHashMap);
					mainProjectIdItem.setValue(selected1.getAttributeAsInt("mainProjectId"));
				}
			}
		});
		
		__formItems.add(mainProjectIdItem);
		projectManagerItem = new ComboBoxItem("projectManager", "项目经理");
		projectManagerItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		projectManagerItem.setWidth("*");
		LinkedHashMap<Integer, String> projectManagerLinkHashMap=new LinkedHashMap<>();
		Map params = new HashMap<>();
		params.put("roleId", 4);
		params.put("status", 0);
		DBDataSource.callOperation("EP_CustomProjectManager", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() < 0) {
					ClientUtil.displayErrorMessage(dsResponse);
				} else {
					Record record[]=dsResponse.getData();
					for(Record obj:record){
						if(!Objects.equals(270, obj.getAttributeAsInt("employeeId"))){
							projectManagerLinkHashMap.put(obj.getAttributeAsInt("employeeId"), obj.getAttributeAsString("employeeName"));
						}
					}
					projectManagerItem.setValueMap(projectManagerLinkHashMap);
					projectManagerItem.setValue(selected1.getAttributeAsInt("projectManager"));
				}
			}
		});
		__formItems.add(projectManagerItem);
		businessTypeItem = new SelectItem("preBusinessType", "业务类别");
		businessTypeItem.setWidth("*");
		businessTypeItem.setValue(selected1.getAttributeAsInt("preBusinessType"));
		businessTypeItem.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));
		__formItems.add(businessTypeItem);
		projectTypeItem = new SelectItem("preProjectType", "项目类别");
		projectTypeItem.setWidth("*");
		projectTypeItem.setValue(selected1.getAttributeAsInt("preProjectType"));
		projectTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_70"));
		__formItems.add(projectTypeItem);
		
		deptItem= new SelectItem("plateId", "部门");
		deptItem.setWidth("*");
		deptItem.setValue(selected1.getAttributeAsInt("plateId"));
		deptItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		__formItems.add(deptItem);
		
		remarkItem = new TextItem("remark", "备注");
		remarkItem.setWidth("*");
		remarkItem.setValue(selected1.getAttributeAsString("remark"));
		__formItems.add(remarkItem);
		
		__infoForm = new DynamicForm();
		__infoForm.setFields(preProjectReimbursementNumberIdItem, customNumberItem,
				mainProjectIdItem,projectManagerItem,businessTypeItem,projectTypeItem,
				deptItem,remarkItem);
		__infoForm.setWidth100();
		__infoForm.setHeight100();
		__infoForm.setNumCols(2);
		ClientUtil.DynamicFormProcessAccordingToDevice(__infoForm);
		// 底部工具栏添加
		ToolStrip btnLayout = new ToolStrip();
		btnLayout.setVPolicy(LayoutPolicy.FILL);
		btnLayout.setPadding(5);
		btnLayout.setHeight(40);
		btnLayout.setWidth100();
		btnLayout.addFill();
		IButton saveBtn = new IButton("保存");
		saveBtn.setIcon("[SKIN]/actions/save.png");
		btnLayout.addMember(saveBtn);
		btnLayout.addSpacer(10);
		saveBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				Map<String,Object> params=new HashMap<>();
				params.put("opt_type", "updatePreProject");
				params.put("preProjectReimbursementNumberId", BaseHelpUtils.getIntValue(__infoForm.getItem("preProjectReimbursementNumberId").getValue()));
				params.put("customNumber", BaseHelpUtils.getString(__infoForm.getItem("customNumber").getValue()));
				params.put("mainProjectId", BaseHelpUtils.getIntValue(__infoForm.getItem("mainProjectId").getValue()));
				params.put("projectManager", BaseHelpUtils.getIntValue(__infoForm.getItem("projectManager").getValue()));
				params.put("preBusinessType", BaseHelpUtils.getIntValue(__infoForm.getItem("preBusinessType").getValue()));
				params.put("preProjectType", BaseHelpUtils.getIntValue(__infoForm.getItem("preProjectType").getValue()));
				params.put("plateId", BaseHelpUtils.getIntValue(__infoForm.getItem("plateId").getValue()));
				params.put("remark", BaseHelpUtils.getString(__infoForm.getItem("remark").getValue()));
				DBDataSource.callOperation("EP_CustomPreProject", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() < 0) {
							ClientUtil.displayErrorMessage(dsResponse);
						} else {
							pw.destroy();
							DataEditEvent dee = new DataEditEvent();
							fireEvent(dee);
						}
					}
				});
			}
		});

		IButton cancelBtn = new IButton("取消");
		cancelBtn.setIcon("[SKIN]/actions/close.png");
		btnLayout.addMember(cancelBtn);
		btnLayout.addSpacer(10);
		cancelBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				SC.ask("提示", "确认取消?", new BooleanCallback() {
					@Override
					public void execute(Boolean value) {
						if (value) {
							pw.destroy();
						}
					}
				});
			}
		});
		VLayout topVL=new VLayout();
		topVL.setWidth100();
		topVL.addMember(__infoForm);
		VLayout bottVL=new VLayout();
		bottVL.setWidth100();
		bottVL.setHeight(40);
		bottVL.addMember(btnLayout);
		
		VLayout bigV=new VLayout();
		bigV.setWidth100();
		bigV.setHeight100();
		bigV.addMember(topVL);
		bigV.addMember(bottVL);
		addMember(bigV);
	}

	 
	// 效验数据
	@Override
	public boolean checkData() {
		boolean isFlag = true;
		return isFlag;
	}

	@Override
	public Set<String> getItemNames() {
		Set<String> res = new HashSet<>();
		res.add("customOutTemplate");
		return res;
	}

	@Override
	public String getName() {
		return "";
	}

	@Override
	public Map getValuesAsMap() {
		return null;
	}


	@Override
	public void startEdit() {
		// TODO Auto-generated method stub
		
	}
	
	private PopupWindow pw;

	public PopupWindow getPw() {
		return pw;
	}


	public void setPw(PopupWindow pw) {
		this.pw = pw;
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
