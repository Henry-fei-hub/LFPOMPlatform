package com.pomplatform.client.preprojects.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.ValidateUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.NewProcessWindow;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.google.gwt.storage.client.Storage;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.MultiComboBoxItem;
import com.smartgwt.client.widgets.form.fields.RadioGroupItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class ReportedOfPreProjects extends HLayout implements HasHandlers {

	private Window parentWindow;
	private static Logger __logger = Logger.getLogger("");
	private ComboBoxItem clientIdItem;
	private ComboBoxItem parentCustomerName;
	private TextItem projectNameItem;
	private SelectItem provinceItem;
	private SelectItem cityItem;
	private TextItem detailAddressItem;
	private ComboBoxItem projectTypeItem;
	private TextItem totalBuildingAreasItem;
	private SelectItem projectOriginationItem;
	private TextItem contactPersonItem;
	private TextItem contactPhoneItem;
	private SelectItem comparisonFormItem;
	private TextItem estimateTheDesignAreasItem;
	private TextItem projectNameOneItem;
	private TextItem regionItem;
	private TextItem gradeItem;
	private TextAreaItem remarkItem;
	public static DelicacyListGrid grid;
//	private  SelectItem ourEmployeesItem;
	private TextItem ourEmployeesName;
	private MultiComboBoxItem projectTypesItem;
	private RadioGroupItem isOperationDepartmentItem;
//	private TextItem projectTypeNameItem;
	private TextItem projectTypesNameItem;
	private IButton okBtn;
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	
	private LinkedHashMap<String, String> customerNameMap = new LinkedHashMap<>();

	
	public void initComponents() {
		setWidth("98%");
		setHeight100();
		setPadding(10);
		setMembersMargin(5);

		VLayout formLayout = new VLayout();
		formLayout.setHeight("98%");
		formLayout.setMembersMargin(5);
		formLayout.setWidth100();
		formLayout.setAlign(Alignment.CENTER);
		addMember(formLayout);

		HLayout messageLayout = new HLayout();
		messageLayout.setWidth100();
		messageLayout.setHeight100();
		messageLayout.setAlign(Alignment.CENTER);

		final DynamicForm form = new DynamicForm();
		form.setNumCols(6);
		form.setAlign(Alignment.CENTER);
		form.setPadding(5);
		form.setMargin(5);
		form.setWidth100();
		form.setHeight100();
		
		parentCustomerName = new ComboBoxItem("parentCustomerName","集团名称");
		parentCustomerName.setWidth("*");
		parentCustomerName.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		KeyValueManager.loadValueMap("parent_customers_name",parentCustomerName);
		parentCustomerName.addChangeHandler(new ChangeHandler() {
			
			@Override
			public void onChange(ChangeEvent event) {
				int parentId = BaseHelpUtils.getIntValue(event.getValue());
				if(parentId<=0) {
					KeyValueManager.loadValueMap("customers_name",clientIdItem);
				}else {
					Map<String,Object> params = new HashMap<>();
					params.put("parentId", parentId);
					params.put("optType", "loadCustomerNameByParentId");
					DBDataSource.callOperation("EP_PreProjectProcess", params, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							customerNameMap.clear();
							if(dsResponse.getStatus() >= 0){
								SC.debugger();
								Record[] records = dsResponse.getData();
								if(records.length>0) {	
									for (Record record : records) {
										customerNameMap.put(record.getAttribute("customerId"), record.getAttribute("customerName"));
									}
								}
							}
							clientIdItem.setValue(""); 
							clientIdItem.setValueMap(customerNameMap); 
						}
					});
				}
				
			}
		});

		clientIdItem = new ComboBoxItem("clientId",shouldNotBeNull+"客户名称");
		clientIdItem.setWidth("*");
		clientIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		KeyValueManager.loadValueMap("customers_name",clientIdItem);
		clientIdItem.setRequired(true);
		clientIdItem.addChangeHandler(new ChangeHandler() {
			
			@Override
			public void onChange(ChangeEvent event) {
				int customerId = BaseHelpUtils.getIntValue(event.getValue());
				if(customerId>0) {
					Map<String,Object> params = new HashMap<>();
					params.put("customerId", customerId);
					params.put("optType", "loadparentCustomerNameById");
					DBDataSource.callOperation("EP_PreProjectProcess", params, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if(dsResponse.getStatus()>=0) {
								Record[] data1 = dsResponse.getData();
								if(data1.length>0) {
									int parentId = BaseHelpUtils.getIntValue(data1[0].getAttribute("parentId"));
									if(parentId>0) {
										parentCustomerName.setValue(parentId);
									}else {
										parentCustomerName.setValue("");
									}
								}else {
									parentCustomerName.setValue("");
								}
							}
						}
					});
				}
			}
		});
		
		
		projectNameItem = new TextItem("projectName",shouldNotBeNull+"项目名称");
		projectNameItem.setWidth("*");
		projectNameItem.setRequired(true);
		projectNameItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				projectNameOneItem.setValue(projectNameItem.getValue());
			}
		});


		projectNameOneItem = new TextItem("projectNameOne",shouldNotBeNull+"报备申请时项目名称");
		projectNameOneItem.setWidth("*");
		projectNameOneItem.setRequired(true);
		projectNameOneItem.setHidden(true);
		
		provinceItem = new SelectItem("province",shouldNotBeNull+"项目地址（省）");
		provinceItem.setWidth("*");
		provinceItem.setValueMap(KeyValueManager.getValueMap("provinces_names"));
		provinceItem.setRequired(true);
		provinceItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Map<String,Object> provinceMap = new HashMap<>();
				provinceMap.put("optType", "getCityNames");
				provinceMap.put("province", provinceItem.getValue());
				DBDataSource.callOperation("EP_PreProjectProcess", provinceMap, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						cityItem.clearValue();
						if(dsResponse.getStatus() >= 0){
							Record[] cityRecords = dsResponse.getData();
							LinkedHashMap<String, String> cityMap = new LinkedHashMap<>();
							for(Record e : cityRecords){
								cityMap.put(e.getAttribute("allName"), e.getAttribute("allName"));
							}
							cityItem.setValueMap(cityMap);
							if(!BaseHelpUtils.isNullOrEmpty(dsResponse.getAttribute("userData"))){
								Map<String,Object> map = dsResponse.getAttributeAsMap("userData");
								regionItem.setValue(map.get("region"));
							}
						}
					}
				});
			}
		});
		
		cityItem = new SelectItem("city",shouldNotBeNull+"市");
		cityItem.setWidth("*");
		cityItem.setRequired(true);
		
		regionItem = new TextItem("region","区域");
		regionItem.setWidth("*");
		regionItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_170"));
		regionItem.setCanEdit(false);
		
		detailAddressItem = new TextItem("detailAddress","详细地址");
		detailAddressItem.setWidth("*");
		detailAddressItem.setRequired(false);
		
		contactPersonItem = new TextItem("contactName",shouldNotBeNull+"联系人");
		contactPersonItem.setWidth("*");
		contactPersonItem.setRequired(true);
		
		gradeItem = new TextItem("grade","职位");
		gradeItem.setWidth("*");
		gradeItem.setRequired(false);
		
		contactPhoneItem = new TextItem("contactPhone","联系电话");
		contactPhoneItem.setWidth("*");
		contactPhoneItem.setRequired(false);
		
		projectTypeItem = new ComboBoxItem("projectType","项目类别");
		projectTypeItem.setWidth("*");
		projectTypeItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		projectTypeItem.setRequired(false);
		projectTypeItem.setChangeOnKeypress(false);
		KeyValueManager.loadValueMap("system_dictionary_244", projectTypeItem);

		projectTypesItem = new MultiComboBoxItem("businessTypes","业务类别");
		projectTypesItem.setWidth("*");
		projectTypesItem.setRequired(false);
		projectTypesItem.setChangeOnKeypress(false);
		KeyValueManager.loadValueMap("production_value_coefficient_type", projectTypesItem);
		projectTypesItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent changedEvent) {
				Object employeeName = projectTypesItem.getDisplayValue();
				projectTypesNameItem.setValue(employeeName);
			}
		});

		projectTypesNameItem = new TextItem("businessType",shouldNotBeNull+"业务类别名称");
		projectTypesNameItem.setWidth("*");
		projectTypesNameItem.setRequired(true);
		projectTypesNameItem.setHidden(true);

		totalBuildingAreasItem = new TextItem("totalBuildingAreas","总建筑面积(㎡)");
		totalBuildingAreasItem.setWidth("*");
		totalBuildingAreasItem.setFormat("##,###,###,###,##0.00");
		totalBuildingAreasItem.setDecimalPad(2);
		totalBuildingAreasItem.setValidators(ValidateUtils.isFloatValidator());

		estimateTheDesignAreasItem = new TextItem("estimateTheDesignAreas","计容建筑面积(㎡)");
		estimateTheDesignAreasItem.setWidth("*");
		estimateTheDesignAreasItem.setFormat("##,###,###,###,##0.00");
		estimateTheDesignAreasItem.setDecimalPad(2);
		estimateTheDesignAreasItem.setValidators(ValidateUtils.isFloatValidator());
		
		projectOriginationItem = new SelectItem("projectOrigination",shouldNotBeNull+"项目来源");
		projectOriginationItem.setRequired(true);
		projectOriginationItem.setWidth("*");
		projectOriginationItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_156"));
		projectOriginationItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent changedEvent) {
				Object projectOrigination = projectOriginationItem.getDisplayValue();
				if(projectOrigination.equals("其他")){
					remarkItem.setTitle(shouldNotBeNull+"项目来源说明");
					remarkItem.setRequired(true);
				}else {
					remarkItem.setTitle("备注");
					remarkItem.setRequired(false);
				}
			}
		});
		comparisonFormItem = new SelectItem("comparisonForm","比选形式");
		comparisonFormItem.setWidth("*");
		comparisonFormItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_168"));
		
		ListGridField eNoField = new ListGridField("employeeNo");
		ListGridField eNameField = new ListGridField("employeeName");
		ListGridField departmentIdField = new ListGridField("departmentId");
		eNameField.setCanFilter(true);
		Criteria c = new Criteria();
		c.addCriteria("status", 0);
		
//		ourEmployeesItem = new SelectItem("ourEmployees",shouldNotBeNull+"项目主管领导");
//		ourEmployeesItem.setWidth("*");
//		ourEmployeesItem.setMultiple(true);
//		ourEmployeesItem.setRequired(true);
//		ourEmployeesItem.setChangeOnKeypress(false);
////		ourEmployeesItem.setPickListWidth(300);
//		ourEmployeesItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
//		ourEmployeesItem.setOptionDataSource(DSGetPlateManagers.getInstance());
//		ourEmployeesItem.setDefaultToFirstOption(false);
//		ourEmployeesItem.setOptionCriteria(c);
//		ourEmployeesItem.setValueField("employeeId");
//		ourEmployeesItem.setDisplayField("employeeName");
//		ourEmployeesItem.setUseClientFiltering(true);
//		ourEmployeesItem.setPickListFields(eNoField, eNameField, departmentIdField);
//		ourEmployeesItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		
		LinkedHashMap<Boolean, String> booleanMap = new LinkedHashMap<>();
		booleanMap.put(true, "是");
		booleanMap.put(false, "否");
		
		isOperationDepartmentItem = new RadioGroupItem("isOperationDepartment",shouldNotBeNull+"运营组分配项目");
		isOperationDepartmentItem.setWidth("*");
		isOperationDepartmentItem.setRequired(false);
		isOperationDepartmentItem.setTitleStyle("radio_title_class");
		isOperationDepartmentItem.setValueMap(booleanMap);
		isOperationDepartmentItem.setVertical(false);
		isOperationDepartmentItem.hide();
		
		remarkItem = new TextAreaItem("remark","备注");
		remarkItem.setWidth("*");
		
		form.setItems(parentCustomerName,clientIdItem,projectNameItem,provinceItem,cityItem,regionItem,detailAddressItem,contactPersonItem,gradeItem,contactPhoneItem,projectTypeItem,projectTypesItem,totalBuildingAreasItem,estimateTheDesignAreasItem,projectOriginationItem,comparisonFormItem,isOperationDepartmentItem,remarkItem,projectNameOneItem,projectTypesNameItem);
		form.setNumCols(6);
		ClientUtil.DynamicFormProcessAccordingToDevice(form);
		isOperationDepartmentItem.setTitleOrientation(TitleOrientation.LEFT);
		parentCustomerName.setColSpan(6);
		clientIdItem.setColSpan(6);
		//isOperationDepartmentItem.setColSpan(4);
		projectNameItem.setColSpan(6);
		detailAddressItem.setColSpan(6);
		projectTypeItem.setColSpan(3);
		projectTypesItem.setColSpan(3);
		estimateTheDesignAreasItem.setColSpan(3);
		totalBuildingAreasItem.setColSpan(3);
		projectOriginationItem.setColSpan(3);
		comparisonFormItem.setColSpan(3);
		remarkItem.setColSpan(6);
		remarkItem.setRowSpan(2);
		messageLayout.addMember(form);
		formLayout.addMember(messageLayout);

		HLayout btnLayout = new HLayout();
		btnLayout.setWidth100();
		btnLayout.setHeight("20%");
		btnLayout.setMembersMargin(10);
		btnLayout.setAlign(Alignment.RIGHT);

		okBtn = new IButton("确认");
		okBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				Map<String,String> params = new HashMap<>();
				params.putAll(form.getValues());
				if(!form.validate()){
					SC.say("请按系统提示修改信息");
					return;
				}

				params.put("optType", "checkSimilarPercent");
				DBDataSource.callOperation("EP_PreProjectProcess", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0){ 
							SC.debugger();
							Record[] records = dsResponse.getData();
							//获取process_id
							String processId = "";
							Storage sta = Storage.getLocalStorageIfSupported();
							String str = sta.getItem(PomPlatformClientUtil.PROCESS_ID_COOKIE);
					    	if(!PomPlatformClientUtil.isNullOrEmpty(str)){
					    		String[] arr = str.split(",");
					    		for(String tempStr : arr){
					    			String[] tempArr = tempStr.split(":");
					    			//获取父级ID
					    			if(tempArr[0].replaceAll("\"", "").equals("Pre_project_report")){
					    				processId = tempArr[1];
					    			}
					    		}
					    	}
							NewProcessWindow panel = new NewProcessWindow();
							panel.setProcessId(ClientUtil.checkAndGetIntValue(processId));
							panel.setTitle(KeyValueManager.getValue("employee_processes", processId));
							panel.setLayoutMode(0);
							Record dataRecord = new Record();
//							params.put("ourEmployeesName", ourEmployeesItem.getDisplayValue());
							dataRecord.setAttribute("formData", params);
							if(null == records || records.length == 0){//如果为空则说明没有相似度大于等于60%的项目存在
								dataRecord.setAttribute("hasSimilar", false);
								panel.setData(dataRecord);
								panel.initComponents();
								panel.setWidth("40%");
								panel.setHeight("98%");
							}else{
								dataRecord.setAttribute("hasSimilar", true);
								int length = records.length;
								dataRecord.setAttribute("similarDataSize", length);
								for(int i = 0; i < length; i++) {
									dataRecord.setAttribute("similarFromData" + i, records[i].toMap());
								}
								panel.setData(dataRecord);
								panel.initComponents();
								panel.setWidth100();
								panel.setHeight100();
							}
							panel.centerInPage();
							panel.show();
							getParentWindow().destroy();
						}
					}
				});
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
				DataEditEvent dee = new DataEditEvent();
				fireEvent(dee);
			}
		});
		btnLayout.addMember(okBtn);
		btnLayout.addMember(cleanBtn);
		formLayout.addMember(btnLayout);
		
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
