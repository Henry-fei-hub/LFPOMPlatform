package com.pomplatform.client.preprojecttransferrecordpors.form;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.ValidateUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.preprojecttransferrecordpors.datasource.DSForPreproJectTransFerrecordporDate;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class ForPreproJectTransFerrecordporUpdateForm extends AbstractWizadPage
{


	private static Logger __logger = Logger.getLogger("");
	private ComboBoxItem customerNameItem;
	private TextItem projectNameItem;
	private TextItem provinceItem;
	private TextItem cityItem;
	private TextItem detailAddressItem;
	private SelectItem projectTypeItem;
	private TextItem totalBuildingAreasItem;
	private SelectItem projectOriginationItem;
	private TextItem contactPersonItem;
	private TextItem contactPhoneItem;
	
	public static DelicacyListGrid grid;
	
//	final DynamicForm employeeform;
	
	private TextItem employeeIdItem;
	private ComboBoxItem transferEmployeeIdItem;
	private TextItem operateEmployeeIdItem;
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";

	public ForPreproJectTransFerrecordporUpdateForm() {
		DSForPreproJectTransFerrecordporDate ds = DSForPreproJectTransFerrecordporDate.getInstance();
		setWidth("98%");
		setHeight100();
		setPadding(10);
		setMembersMargin(5);
		
		VLayout formLayout = new VLayout();
		formLayout.setHeight("70%");
		formLayout.setMembersMargin(5);
		formLayout.setWidth100();
		formLayout.setAlign(Alignment.CENTER);
		addMember(formLayout);
		
		/*HLayout employeeLayout = new HLayout();
		employeeLayout.setWidth100();
		employeeLayout.setHeight("15%");
		formLayout.addMember(employeeLayout)*/;
		
		/*employeeform = new DynamicForm();
		employeeform.setNumCols(4);
		employeeform.setAlign(Alignment.CENTER);
		employeeform.setPadding(5);
		employeeform.setMargin(5);
		employeeform.setWidth100();
		employeeform.setHeight100();*/
		
		employeeIdItem = new TextItem("employeeId","原报备人");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.setWidth("*");
		employeeIdItem.setDisabled(true);
		
		transferEmployeeIdItem = new ComboBoxItem("transferEmployeeId", "转交人");
		transferEmployeeIdItem.setWidth("*");
		transferEmployeeIdItem.setValueMap(KeyValueManager.getValueMap("use_employees"));
		transferEmployeeIdItem.setCanEdit(true);
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
							
							
						}
					}
				});
			}
		});
		
	
		
		operateEmployeeIdItem = new ComboBoxItem("operateEmployeeId");
		operateEmployeeIdItem.hide();
		operateEmployeeIdItem.setValue(ClientUtil.getEmployeeId());
        
		/*employeeform.setDataSource(ds);
		employeeform.setFields(employeeIdItem,transferEmployeeIdItem);
		ClientUtil.DynamicFormProcessAccordingToDevice(employeeform);
		employeeLayout.addMember(employeeform);*/
		
		HLayout messageLayout = new HLayout();
		messageLayout.setWidth100();
		messageLayout.setHeight("70%");
		messageLayout.setAlign(Alignment.CENTER);

//		final DynamicForm form = new DynamicForm();
		__form.setAlign(Alignment.CENTER);
		__form.setDataSource(ds);
		__form.setPadding(4);
		__form.setMargin(4);
		__form.setWidth100();
		__form.setHeight100();
		__form.setCanEdit(false);

		customerNameItem = new ComboBoxItem("customerName",shouldNotBeNull+"客户名称");
		customerNameItem.setWidth("*");
//		customerNameItem.setValueMap(KeyValueManager.getValueMap("customers_name"));
        KeyValueManager.loadValueMap("customers_name",customerNameItem);
		projectNameItem = new TextItem("projectName",shouldNotBeNull+"项目名称");
		projectNameItem.setWidth("*");
		
		provinceItem = new TextItem("province","项目地址（省）");
		provinceItem.setWidth("*");
		provinceItem.setValueMap(KeyValueManager.getValueMap("provinces_names"));
		provinceItem.setHidden(false);
		
		cityItem = new TextItem("city", "项目地址（市）");
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
		totalBuildingAreasItem.setHidden(false);
		
		projectOriginationItem = new SelectItem("projectOrigination","项目来源");
		projectOriginationItem.setWidth("*");
		projectOriginationItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_156"));
		
		contactPersonItem = new TextItem("contactName",shouldNotBeNull+"联系人");
		contactPersonItem.setWidth("*");
		
		contactPhoneItem = new TextItem("contactPhone",shouldNotBeNull+"联系电话");
		contactPhoneItem.setWidth("*");
		
		__form.setItems(employeeIdItem,transferEmployeeIdItem,operateEmployeeIdItem,customerNameItem,projectNameItem,provinceItem,cityItem,detailAddressItem,projectTypeItem,totalBuildingAreasItem,projectOriginationItem,contactPersonItem,contactPhoneItem);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		customerNameItem.setColSpan(4);
		projectNameItem.setColSpan(4);
		detailAddressItem.setColSpan(4);
		messageLayout.addMember(__form);
		formLayout.addMember(messageLayout);

		HLayout btnLayout = new HLayout();
		btnLayout.setWidth100();
		btnLayout.setHeight("3%");
		btnLayout.setMembersMargin(10);
		btnLayout.setAlign(Alignment.RIGHT);


		formLayout.addMember(btnLayout);
		
	}

	@Override
	public void startEdit() {
		__logger.info("getRecord()+++++++++++++++++++++++++++++++++++++++++++"+getRecord().toMap().toString());
		if(getRecord() != null) __form.editRecord(getRecord());
		
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSForPreproJectTransFerrecordporDate.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
