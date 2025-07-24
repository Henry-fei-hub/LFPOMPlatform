package com.pomplatform.client.preprojects.panel;

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
import com.pomplatform.client.workflow.datasource.DSBusinessCategory;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.MultiComboBoxLayoutStyle;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class ReportedOfPreProjectsForUpdate extends AbstractWizadPage {

	private static Logger __logger = Logger.getLogger("");
	private ComboBoxItem clientIdItem;
	private ComboBoxItem parentCustomerNameItem;
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
	private TextItem regionItem;
	private TextItem gradeItem;
	private TextAreaItem remarkItem;
	private TextItem applyEmployeeIdItem;
	private DateTimeItem createTimeItem;
	private TextItem projectNameOneItem;

	public static DelicacyListGrid grid;
	private final DynamicForm form = new DynamicForm();
	private final DynamicForm infoForm = new DynamicForm();
	
	private HLayout allLayout;
	private VLayout leftLayout;
	private VLayout leftOneLayout;
	private VLayout leftTwoLayout;
	
	private TextItem customerTypeItem;
	private TextItem isWarehousItem;
	private TextItem isApplyQuoteItem;
	private TextItem infoCodeItem;
	private RadioGroupItem isOperationDepartmentItem;
	private MultiComboBoxItem projectTypesItem;
	private TextItem projectTypesNameItem;
	private LinkedHashMap<Boolean, String> booleanMap = new LinkedHashMap<>();
	private LinkedHashMap<String, String> customerNameMap = new LinkedHashMap<>();

	private SimilarPreProjectInfoPanel similarPanel1 = null;
	private SimilarPreProjectInfoPanel similarPanel2 = null;
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	
	public ReportedOfPreProjectsForUpdate() {
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public void startEdit() {
		Record record = getRecord();
		Map<String,Object> map =new HashMap<>();
		map.putAll(record.toMap());
		map.put("optType", "PreProjectProcess");
		DBDataSource.callOperation("EP_PreProjectProcess", map, new DSCallback() {
			
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					Record[] records = dsResponse.getData();
					setWidth("98%");
					setHeight100();
					setPadding(10);
					setMembersMargin(5);
					
					booleanMap.put(true, "是");
					booleanMap.put(false, "否");

					allLayout = new HLayout();
					allLayout.setHeight100();
					allLayout.setMembersMargin(5);
					allLayout.setWidth100();
					allLayout.setAlign(Alignment.CENTER);

					leftLayout = new VLayout(10);
					leftLayout.setWidth100();
					leftLayout.setHeight100();
					leftLayout.setLayoutRightMargin(10);
					
					leftOneLayout = new VLayout();
					leftOneLayout.setWidth100();
					leftOneLayout.setHeight("75%");
					leftLayout.addMember(leftOneLayout);

					form.setPadding(5);
					form.setMargin(5);
					form.setWidth100();
					form.setHeight100();
					
					applyEmployeeIdItem=new TextItem("applyEmployeeId","报备人");
					applyEmployeeIdItem.setDisabled(true);
					applyEmployeeIdItem.setWidth("*");
					KeyValueManager.loadValueMap("employees", applyEmployeeIdItem);
					
					createTimeItem=new DateTimeItem("createTime","报备登记时间");
					createTimeItem.setDisabled(true);
					createTimeItem.setWidth("*");
					
					parentCustomerNameItem = new ComboBoxItem("parentCustomerName","集团名称");
					parentCustomerNameItem.setWidth("*");
					KeyValueManager.loadValueMap("parent_customers_name",parentCustomerNameItem);
					parentCustomerNameItem.addChangeHandler(new ChangeHandler() {
						
						@Override
						public void onChange(ChangeEvent event) {
							int parentId = BaseHelpUtils.getIntValue(event.getValue());
							if(parentId<=0) {
								clientIdItem.setValueMap(KeyValueManager.getValueMap("customers_name")); 
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
					clientIdItem.setRequired(true);
					clientIdItem.setValueMap(KeyValueManager.getValueMap("customers_name")); 
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
													parentCustomerNameItem.setValue(parentId);
												}else {
													parentCustomerNameItem.setValue("");
												}
											}else {
												parentCustomerNameItem.setValue("");
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
					
					provinceItem = new SelectItem("province",shouldNotBeNull+"项目地址（省）");
					provinceItem.setWidth("*");
					provinceItem.setRequired(true);
					provinceItem.setValueMap(KeyValueManager.getValueMap("provinces_names"));
					
					cityItem = new SelectItem("city",shouldNotBeNull+"市");
					cityItem.setRequired(true);
					cityItem.setWidth("*");
					
					detailAddressItem = new TextItem("detailAddress","详细地址");
					detailAddressItem.setWidth("*");
					detailAddressItem.setRequired(false);
					
					regionItem = new TextItem("region","区域");
					regionItem.setWidth("*");
					regionItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_170"));
					regionItem.setCanEdit(false);
					
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
					projectTypesItem.setCanEdit(true);
			        projectTypesItem.setChangeOnKeypress(true);
			        KeyValueManager.loadValueMap("production_value_coefficient_type", projectTypesItem);
			        projectTypesItem.addChangedHandler(new ChangedHandler() {
			            @Override
			            public void onChanged(ChangedEvent changedEvent) {
			                Object employeeName = projectTypesItem.getDisplayValue();
			                projectTypesNameItem.setValue(employeeName);
			            }
			        });

			        projectTypesNameItem = new TextItem("businessType","业务类别名称");
			        projectTypesNameItem.setWidth("*");
			        projectTypesNameItem.hide();

					totalBuildingAreasItem = new TextItem("totalBuildingAreas","总建筑面积(㎡)");
					totalBuildingAreasItem.setWidth("*");
					
					estimateTheDesignAreasItem = new TextItem("estimateTheDesignAreas","计容建筑面积(㎡)");
					estimateTheDesignAreasItem.setWidth("*");

					comparisonFormItem = new SelectItem("comparisonForm","比选形式");
					comparisonFormItem.setWidth("*");
					comparisonFormItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_168"));
					
					projectOriginationItem = new SelectItem("projectOrigination",shouldNotBeNull+"项目来源");
					projectOriginationItem.setWidth("*");
					projectOriginationItem.setRequired(true);
					projectOriginationItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_156"));
					
					isOperationDepartmentItem = new RadioGroupItem("isOperationDepartment",shouldNotBeNull+"运营组分配项目");
					isOperationDepartmentItem.setWidth("*");
					isOperationDepartmentItem.setRequired(false);
					isOperationDepartmentItem.setTitleStyle("radio_title_class");
					isOperationDepartmentItem.setValueMap(booleanMap);
					isOperationDepartmentItem.setVertical(false);
					isOperationDepartmentItem.hide();
					
					remarkItem = new TextAreaItem("remark","备注");
					remarkItem.setWidth("*");

					projectNameOneItem = new TextItem("projectNameOne",shouldNotBeNull+"报备申请时项目名称");
					projectNameOneItem.setWidth("*");
					projectNameOneItem.setHidden(true);

					form.setItems(applyEmployeeIdItem,createTimeItem,parentCustomerNameItem,clientIdItem,projectNameItem,provinceItem,cityItem,regionItem,detailAddressItem,contactPersonItem,gradeItem,contactPhoneItem,projectTypeItem,projectTypesItem,projectTypesNameItem,totalBuildingAreasItem,estimateTheDesignAreasItem,projectOriginationItem,comparisonFormItem,isOperationDepartmentItem,remarkItem,projectNameOneItem);
					form.setNumCols(6);
					ClientUtil.DynamicFormProcessAccordingToDevice(form);
					applyEmployeeIdItem.setColSpan(3);
					createTimeItem.setColSpan(3);
					parentCustomerNameItem.setColSpan(6);
					clientIdItem.setColSpan(6);
					projectNameItem.setColSpan(6);
					detailAddressItem.setColSpan(6);
					comparisonFormItem.setColSpan(3);
					projectOriginationItem.setColSpan(3);
					remarkItem.setColSpan(6);
					remarkItem.setRowSpan(2);
					projectTypeItem.setColSpan(3);
					projectTypesItem.setColSpan(3);
					estimateTheDesignAreasItem.setColSpan(3);
					totalBuildingAreasItem.setColSpan(3);
					leftOneLayout.addMember(form);

					leftTwoLayout = new VLayout();
					leftTwoLayout.setWidth100();
					leftTwoLayout.setHeight("25%");
					leftLayout.addMember(leftTwoLayout);
					
					infoCodeItem = new TextItem("infoCode","信息编号");
					infoCodeItem.setWidth("*");
					
					customerTypeItem = new TextItem("customerType","客户类型");
					customerTypeItem.setWidth("*");
					customerTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_151"));
					customerTypeItem.setEmptyDisplayValue("无");
					
					isWarehousItem = new TextItem("isWarehous","是否已入库");
					isWarehousItem.setWidth("*");
					isWarehousItem.setEmptyDisplayValue("无");
					isWarehousItem.setValueMap(booleanMap);
					
					isApplyQuoteItem = new TextItem("isApplyQuote","是否已提供战略报价");
					isApplyQuoteItem.setWidth("*");
					isApplyQuoteItem.setEmptyDisplayValue("无");
					isApplyQuoteItem.setValueMap(booleanMap);
					
					infoForm.setPadding(5);
					infoForm.setMargin(5);
					infoForm.setWidth100();
					infoForm.setHeight100();
					infoForm.setNumCols(4);
					infoForm.setCanEdit(false);
					infoForm.setItems(infoCodeItem,customerTypeItem,isWarehousItem,isApplyQuoteItem);
					ClientUtil.DynamicFormProcessAccordingToDevice(infoForm);
					leftTwoLayout.addMember(infoForm);
					
					allLayout.addMember(leftLayout);
					
					if(null != records && records.length > 0){
						allLayout.removeChild(leftLayout);
						int similarDataSize = records.length;
						int width = 100 / similarDataSize;
						leftLayout.setWidth(width + "%");
						leftLayout.setShowResizeBar(true);
						allLayout.addMember(leftLayout);
						
						similarPanel1 = new SimilarPreProjectInfoPanel();
						similarPanel1.setWidth(width + "%");
						similarPanel1.setShowResizeBar(true);
						similarPanel1.setData(records[0].toMap());
						similarPanel1.startEdit();
						allLayout.addMember(similarPanel1);
						
						if(similarDataSize > 1) {
							similarPanel2 = new SimilarPreProjectInfoPanel();
							similarPanel2.setWidth(width + "%");
							similarPanel2.setShowResizeBar(true);
							similarPanel2.setData(records[1].toMap());
							similarPanel2.startEdit();
							allLayout.addMember(similarPanel2);
						}
						
					}
					setPageMode(PAGE_MODE_UPDATE);
					addMember(allLayout);
				}
			}
		});
		
		int parentId = BaseHelpUtils.getIntValue(record.getAttribute("parentCustomerName"));
		if(parentId>0) {
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
					clientIdItem.setValueMap(customerNameMap); 
				}
			});
		}
		
	
		
		
		if(!BaseHelpUtils.isNullOrEmpty(record)){
			String[] businessTypes = BaseHelpUtils.getString(record.getAttribute("businessTypes")).replaceAll("\\[","").replaceAll("]","").replaceAll(" ","").split(",");
			if(businessTypes.length>0&&!BaseHelpUtils.isNullOrEmpty(businessTypes)) {
				record.setAttribute("businessTypes",businessTypes);
			}
			form.setValues(record.toMap());
			infoForm.setValues(record.toMap());

		}

		int clientId = BaseHelpUtils.getIntValue(record.getAttribute("clientId"));
		Map<String,Object> params =new HashMap<>();
		params.put("customerId", clientId);
		DBDataSource.callOperation("ST_Customer", "find", params, new DSCallback() {
			
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					Record result = dsResponse.getData()[0];
					infoForm.getField("customerType").setValue(result.getAttribute("customerType"));
					infoForm.getField("isWarehous").setValue(result.getAttribute("isWarehous"));
					infoForm.getField("isApplyQuote").setValue(result.getAttribute("isApplyQuote"));
				}
			}
		});
	}
	
	@Override
	public Map getValuesAsMap() {
		Map<String,Object> values = form.getValues();
		return values;
	}

	@Override
	public boolean checkData() {
		return true;
	}


	public LinkedHashMap<String, String> getCustomerNameMap() {
		return customerNameMap;
	}


	public void setCustomerNameMap(LinkedHashMap<String, String> customerNameMap) {
		this.customerNameMap = customerNameMap;
	}
	
	
	

}
