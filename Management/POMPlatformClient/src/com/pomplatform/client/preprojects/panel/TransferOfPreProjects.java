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
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class TransferOfPreProjects extends HLayout implements HasHandlers {

	private Window parentWindow;
	private static Logger __logger = Logger.getLogger("");
	private ComboBoxItem customerNameItem;
	private TextItem projectNameItem;
	private SelectItem provinceItem;
	private SelectItem cityItem;
	private TextItem detailAddressItem;
	private SelectItem projectTypeItem;
	private TextItem totalBuildingAreasItem;
	private SelectItem projectOriginationItem;
	private TextItem contactPersonItem;
	private TextItem contactPhoneItem;

	public static DelicacyListGrid grid;

	private TextItem employeeIdItem;
	private ComboBoxItem transferEmployeeIdItem;
	private TextItem operateEmployeeIdItem;

	private IButton okBtn;
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	private int transferDepartmentId;
	public void initComponents() {
		
		setWidth("98%");
		setHeight100();
		setPadding(10);
		setMembersMargin(5);

		VLayout formLayout = new VLayout();
		formLayout.setHeight("90%");
		formLayout.setMembersMargin(5);
		formLayout.setWidth100();
		formLayout.setAlign(Alignment.CENTER);
		addMember(formLayout);

		HLayout employeeLayout = new HLayout();
		employeeLayout.setWidth100();
		employeeLayout.setHeight("15%");
		formLayout.addMember(employeeLayout);

		final DynamicForm employeeform = new DynamicForm();
		employeeform.setNumCols(4);
		employeeform.setAlign(Alignment.CENTER);
		employeeform.setPadding(5);
		employeeform.setMargin(5);
		employeeform.setWidth100();
		employeeform.setHeight100();

		employeeIdItem = new TextItem("employeeId","原报备人");
		employeeIdItem.setWidth("*");
		employeeIdItem.setValue(employeeId);
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.setDisabled(true);

		transferEmployeeIdItem = new ComboBoxItem("transferEmployeeId","转交人");
		transferEmployeeIdItem.setWidth("*");
		transferEmployeeIdItem.setValueMap(KeyValueManager.getValueMap("use_employees"));
		transferEmployeeIdItem.setChangeOnKeypress(false);
		transferEmployeeIdItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Map<String,Object> map = new HashMap<>();
				int employeeId = BaseHelpUtils.getIntValue(transferEmployeeIdItem.getValue());
				map.put("employeeId", employeeId);
				DBDataSource.callOperation("ST_Employee", "find", map, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus()>=0) {
							Record[] red=dsResponse.getData();
							for (Record record : red) {
								transferDepartmentId=BaseHelpUtils.getIntValue(record.getAttribute("departmentId"));
							}

						}
					}
				});
			}
		});

		operateEmployeeIdItem = new ComboBoxItem("operateEmployeeId");
		operateEmployeeIdItem.hide();
		operateEmployeeIdItem.setValue(ClientUtil.getEmployeeId());

		employeeform.setFields(employeeIdItem,transferEmployeeIdItem,operateEmployeeIdItem);
		ClientUtil.DynamicFormProcessAccordingToDevice(employeeform);
		employeeLayout.addMember(employeeform);

		HLayout messageLayout = new HLayout();
		messageLayout.setWidth100();
		messageLayout.setHeight("70%");
		messageLayout.setAlign(Alignment.CENTER);

		final DynamicForm form = new DynamicForm();
		form.setAlign(Alignment.CENTER);
		form.setPadding(5);
		form.setMargin(5);
		form.setWidth100();
		form.setHeight100();
		form.setCanEdit(false);

		customerNameItem = new ComboBoxItem("customerName",shouldNotBeNull+"客户名称");
		customerNameItem.setWidth("*");
//		customerNameItem.setValueMap(KeyValueManager.getValueMap("customers_name"));
		KeyValueManager.loadValueMap("customers_name",customerNameItem);
		projectNameItem = new TextItem("projectName",shouldNotBeNull+"项目名称");
		projectNameItem.setWidth("*");

		provinceItem = new SelectItem("province","项目地址（省）");
		provinceItem.setWidth("*");
		provinceItem.setValueMap(KeyValueManager.getValueMap("provinces_names"));
		provinceItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Map<String,Object> provinceMap = new HashMap<>();
				provinceMap.put("optType", "getCityNames");
				provinceMap.put("province", provinceItem.getValue());
				DBDataSource.callOperation("EP_PreProjectProcess", provinceMap, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0){
							Record[] cityRecords = dsResponse.getData();
							LinkedHashMap<String, String> cityMap = new LinkedHashMap<>();
							for(Record e : cityRecords){
								cityMap.put(e.getAttribute("allName"), e.getAttribute("allName"));
							}
							cityItem.setValueMap(cityMap);
						}
					}
				});
			}
		});

		cityItem = new SelectItem("city","市");
		cityItem.setWidth("*");

		detailAddressItem = new TextItem("detailAddress","详细地址");
		detailAddressItem.setWidth("*");

		projectTypeItem = new SelectItem("businessType","业务类别");
		projectTypeItem.setWidth("*");
		//projectTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_32"));

		totalBuildingAreasItem = new TextItem("totalBuildingAreas","项目面积(㎡)");
		totalBuildingAreasItem.setWidth("*");
		totalBuildingAreasItem.setFormat("##,###,###,###,##0.00");
		totalBuildingAreasItem.setDecimalPad(2);
		totalBuildingAreasItem.setValidators(ValidateUtils.isFloatValidator());

		projectOriginationItem = new SelectItem("projectOrigination","项目来源");
		projectOriginationItem.setWidth("*");
		projectOriginationItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_156"));

		contactPersonItem = new TextItem("contactName",shouldNotBeNull+"联系人");
		contactPersonItem.setWidth("*");

		contactPhoneItem = new TextItem("contactPhone",shouldNotBeNull+"联系电话");
		contactPhoneItem.setWidth("*");

		form.setItems(customerNameItem,projectNameItem,provinceItem,cityItem,detailAddressItem,projectTypeItem,totalBuildingAreasItem,projectOriginationItem,contactPersonItem,contactPhoneItem);
		form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(form);
		customerNameItem.setColSpan(4);
		projectNameItem.setColSpan(4);
		detailAddressItem.setColSpan(4);
		messageLayout.addMember(form);
		formLayout.addMember(messageLayout);
		form.editRecord(recordData);

		HLayout btnLayout = new HLayout();
		btnLayout.setWidth100();
		btnLayout.setHeight("10%");
		btnLayout.setMembersMargin(10);
		btnLayout.setAlign(Alignment.RIGHT);

		okBtn = new IButton("确认");
		okBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				Map<String,Object> param = employeeform.getValues();
				//				Map<String,Object>  params=form.getValues();
				param.putAll(form.getValues());


				if(BaseHelpUtils.isNullOrEmpty(param.get("transferEmployeeId"))){
					SC.say("转交人不能为空");
					return;
				}
				int olderDepartmentId=BaseHelpUtils.getIntValue(recordData.getAttribute("departmentId"));
				String employeeName = KeyValueManager.getValue("employees", param.get("transferEmployeeId") + "");
				if(olderDepartmentId!=transferDepartmentId) {
					SC.say(employeeName+"和您不在一个部门,您确定转交吗？",new BooleanCallback() {
						@Override
						public void execute(Boolean value) {
							if(value) {
								DBDataSource.callOperation("EP_PreProjectProcess",  param, new DSCallback() {
									@Override
									public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
										if(dsResponse.getStatus() >= 0){
											Record record = dsResponse.getData()[0];
											//获取process_id
											String processId = "";
											Storage sta = Storage.getLocalStorageIfSupported();
							String str = sta.getItem(PomPlatformClientUtil.PROCESS_ID_COOKIE);
											if(!PomPlatformClientUtil.isNullOrEmpty(str)){
												String[] arr = str.split(",");
												for(String tempStr : arr){
													String[] tempArr = tempStr.split(":");
													//获取父级ID
													if(tempArr[0].replaceAll("\"", "").equals("Prepro_JectTransFerrecordpor")){
														processId = tempArr[1];
													}
												}
											}
											NewProcessWindow panel = new NewProcessWindow();
											Record dataRecord = new Record();
											dataRecord.setAttribute("formData", param);
											panel.setData(dataRecord);
											panel.setProcessId(ClientUtil.checkAndGetIntValue(processId));
											panel.setLayoutMode(0);
											panel.initComponents();
											panel.setWidth("40%");
											panel.setHeight("98%");
											panel.centerInPage();
											panel.show();
										}
									}});

							}

						}
					});
					return;
				}else {
					SC.say("确定将该项目转交给 ["+employeeName+"] 吗？",new BooleanCallback() {

						@Override
						public void execute(Boolean value) {
							if(value){
								param.put("preProjectId", recordData.getAttribute("preProjectId"));
								param.put("optType", "transferProject");		
								DBDataSource.callOperation("EP_PreProjectProcess",param, new DSCallback() {

									@Override
									public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
										if(dsResponse.getStatus() >= 0){
											SC.say("项目转交成功");
											getParentWindow().destroy();
											DataEditEvent dee = new DataEditEvent();
											fireEvent(dee);
										}
									}
								});
							}
						}
					});
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

	private int employeeId;
	private Record recordData;



	public Record getRecordData() {
		return recordData;
	}

	public void setRecordData(Record recordData) {
		this.recordData = recordData;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}


}
