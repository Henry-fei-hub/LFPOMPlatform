package com.pomplatform.client.preprojects.panel;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.DelicacyListGrid;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.RadioGroupItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.VLayout;

public class SimilarPreProjectInfoPanel extends VLayout {

	private static Logger __logger = Logger.getLogger("");
	private TextItem applyEmployeeIdItem;
	private DateTimeItem createTimeItem;
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
	private SelectItem comparisonFormItem;
	private TextItem estimateTheDesignAreasItem;
	private TextItem regionItem;
	private TextItem gradeItem;
	private TextAreaItem remarkItem;
	private ComboBoxItem parentCustomerName;
	
	public static DelicacyListGrid grid;
	private final DynamicForm form = new DynamicForm();
	private final DynamicForm infoForm2 = new DynamicForm();
	
	private VLayout rightOneLayout;
	private VLayout rightTwoLayout;
	
	private TextItem customerTypeItem;
	private TextItem isWarehousItem;
	private TextItem isApplyQuoteItem;
	private TextItem infoCodeItem;
	
	private static Label otherInfo;
	private RadioGroupItem isOperationDepartmentItem;
	private LinkedHashMap<Boolean, String> booleanMap = new LinkedHashMap<>();
	private LinkedHashMap<String, String> customerNameMap = new LinkedHashMap<>();
	
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";

	public SimilarPreProjectInfoPanel() {
		setWidth100();
		setHeight100();
		setPadding(10);
		setMembersMargin(5);
		setLayoutLeftMargin(10);

		booleanMap.put(true, "是");
		booleanMap.put(false, "否");
		
//		rightLayout = new VLayout(10);
//		rightLayout.setWidth("48%");
//		rightLayout.setHeight100();
//		rightLayout.setLayoutLeftMargin(10);

		otherInfo = new Label("相似的项目信息,<b style = \"color:red;font-size:14px\">请核对是否同一项目</b>");
		otherInfo.setHeight("5%");
		otherInfo.setAlign(Alignment.CENTER);
		addMember(otherInfo);
//		rightLayout.addMember(otherInfo);
		
		rightOneLayout = new VLayout();
		rightOneLayout.setWidth100();
		rightOneLayout.setHeight("75%");
		addMember(rightOneLayout);
//		rightLayout.addMember(rightOneLayout);
		
		applyEmployeeIdItem = new TextItem("applyEmployeeId", "报备人");
		applyEmployeeIdItem.setWidth("*");
		applyEmployeeIdItem.setCanEdit(false);
		KeyValueManager.loadValueMap("employees",applyEmployeeIdItem);
		
		createTimeItem = new DateTimeItem("createTime", "报备时间");
		createTimeItem.setWidth("*");
		createTimeItem.setCanEdit(false);
		
		parentCustomerName = new ComboBoxItem("parentCustomerName",shouldNotBeNull+"集团名称");
		parentCustomerName.setWidth("*");
		KeyValueManager.loadValueMap("parent_customers_name",parentCustomerName);
		parentCustomerName.addChangeHandler(new ChangeHandler() {
			
			@Override
			public void onChange(ChangeEvent event) {
				SC.debugger();
				int parentId = BaseHelpUtils.getIntValue(event.getValue());
				if(parentId<=0) {
					SC.say("提示","请选择正确的集团公司");
				}
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
						customerNameItem.setValueMap(customerNameMap); 
					}
				});
				
			}
		});
		
		customerNameItem = new ComboBoxItem("customerName","客户名称");
		customerNameItem.setWidth("*");
		KeyValueManager.loadValueMap("customers_name",customerNameItem);
		
		
		
		projectNameItem = new TextItem("projectName","项目名称");
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
		
		regionItem = new TextItem("region","区域");
		regionItem.setWidth("*");
		regionItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_170"));
		regionItem.setCanEdit(false);
		
		contactPersonItem = new TextItem("contactName","联系人");
		contactPersonItem.setWidth("*");
		
		gradeItem = new TextItem("grade","职位");
		gradeItem.setWidth("*");
		
		contactPhoneItem = new TextItem("contactPhone","联系电话");
		contactPhoneItem.setWidth("*");
		
		projectTypeItem = new SelectItem("projectType","业务类别");
		projectTypeItem.setWidth("*");
//		projectTypeItem.setValueMap(KeyValueManager.getValueMap("pre_business_type"));
		KeyValueManager.loadValueMap("pre_business_type",projectTypeItem);
		
		totalBuildingAreasItem = new TextItem("totalBuildingAreas","总建筑面积(㎡)");
		totalBuildingAreasItem.setWidth("*");
		
		estimateTheDesignAreasItem = new TextItem("estimateTheDesignAreas","计容建筑面积(㎡)");
		estimateTheDesignAreasItem.setWidth("*");

		comparisonFormItem = new SelectItem("comparisonForm","比选形式");
		comparisonFormItem.setWidth("*");
		comparisonFormItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_168"));
		
		projectOriginationItem = new SelectItem("projectOrigination","项目来源");
		projectOriginationItem.setWidth("*");
		projectOriginationItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_156"));
		
		
		isOperationDepartmentItem = new RadioGroupItem("isOperationDepartment",shouldNotBeNull+"运营组分配项目");
		isOperationDepartmentItem.setWidth("*");
		isOperationDepartmentItem.setRequired(true);
		isOperationDepartmentItem.setTitleStyle("radio_title_class");
		isOperationDepartmentItem.setValueMap(booleanMap);
		isOperationDepartmentItem.setVertical(false);
		
		remarkItem = new TextAreaItem("remark","备注");
		remarkItem.setWidth("*");
		
		form.setPadding(5);
		form.setMargin(5);
		form.setCanEdit(false);
		form.setItems(applyEmployeeIdItem, createTimeItem,parentCustomerName, customerNameItem,projectNameItem,provinceItem,cityItem,regionItem,detailAddressItem,contactPersonItem,gradeItem,contactPhoneItem,projectTypeItem,totalBuildingAreasItem,estimateTheDesignAreasItem,projectOriginationItem,comparisonFormItem,isOperationDepartmentItem,remarkItem);
		form.setWidth100();
		form.setNumCols(6);
		ClientUtil.DynamicFormProcessAccordingToDevice(form);
		applyEmployeeIdItem.setColSpan(3);
		createTimeItem.setColSpan(3);
		parentCustomerName.setColSpan(6);
		customerNameItem.setColSpan(6);
		projectNameItem.setColSpan(6);
		detailAddressItem.setColSpan(6);
		comparisonFormItem.setColSpan(3);
		projectOriginationItem.setColSpan(3);
		remarkItem.setColSpan(6);
		remarkItem.setRowSpan(2);
		rightOneLayout.addMember(form);
		
		rightTwoLayout = new VLayout();
		rightTwoLayout.setWidth100();
		rightTwoLayout.setHeight("25%");
		addMember(rightTwoLayout);
//		rightLayout.addMember(rightTwoLayout);
		
		infoCodeItem = new TextItem("infoCode","信息编号");
		infoCodeItem.setWidth("*");
		
		customerTypeItem = new TextItem("customerType","客户类型");
		customerTypeItem.setWidth("*");
		customerTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_151"));
		
		isWarehousItem = new TextItem("isWarehous","是否已入库");
		isWarehousItem.setWidth("*");
		isWarehousItem.setValueMap(booleanMap);
		
		isApplyQuoteItem = new TextItem("isApplyQuote","是否已提供战略报价");
		isApplyQuoteItem.setWidth("*");
		isApplyQuoteItem.setValueMap(booleanMap);
		
		infoForm2.setPadding(5);
		infoForm2.setMargin(5);
		infoForm2.setWidth100();
		infoForm2.setHeight100();
		infoForm2.setNumCols(4);
		infoForm2.setCanEdit(false);
		infoForm2.setItems(infoCodeItem,customerTypeItem,isWarehousItem,isApplyQuoteItem);
		ClientUtil.DynamicFormProcessAccordingToDevice(infoForm2);
		rightTwoLayout.addMember(infoForm2);
		
	}


	public void startEdit() {
		if(null != data && !data.isEmpty()) {
			form.setValues(data);
			String customerName = BaseHelpUtils.getString(form.getField("customerName").getValue());
			getCustomerInfo(customerName,infoForm2);
			String infoCode = BaseHelpUtils.getString(data.get("infoCode"));
			setInfoCode(infoCode);
		}
	}
	
	/**
	 * 获取客户信息（是否已入库，是否有战略报价等）
	 * @param clientId
	 */
	public void getCustomerInfo(String clientName,DynamicForm addForm){
		Map<String,Object> clientMap = new HashMap<>();
		clientMap.put("optType", "getCustomerInfo");
		clientMap.put("customerName", clientName);
		DBDataSource.callOperation("EP_PreProjectProcess", clientMap, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					if(!BaseHelpUtils.isNullOrEmpty(dsResponse.getAttribute("userData"))){
						Map<String,Object> result = dsResponse.getAttributeAsMap("userData");
						addForm.setValues(result);
						infoForm2.getField("infoCode").setValue(infoCode);
					}
				}
			}
		});
	}
	
	private String infoCode;
	private Map<String, Object> data;

	public String getInfoCode() {
		return infoCode;
	}

	public void setInfoCode(String infoCode) {
		this.infoCode = infoCode;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

}
