package com.pomplatform.client.preprojects.panel;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.employeerescord.datasource.DSEmployee;
import com.pomplatform.client.ja.ht.datasource.DSMainProject;
import com.pomplatform.client.preprojects.datasource.DSMainProjectSpecialty;
import com.pomplatform.client.preprojects.datasource.DSprojectPreInfomations;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.TransferImgButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.BooleanItem;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.DoubleItem;
import com.smartgwt.client.widgets.form.fields.RadioGroupItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.ChangeEvent;
import com.smartgwt.client.widgets.grid.events.ChangeHandler;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.grid.events.EditorExitEvent;
import com.smartgwt.client.widgets.grid.events.EditorExitHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class BeProjectBasicInformationUpdate extends AbstractWizadPage {
	private static final Logger __logger = Logger.getLogger("");
	private final TextItem preProjectIdItem;
	private final TextItem infoCodeItem;
	private final TextItem projectNameItem;
//	private final SelectItem projectStatusItem;
//	private final SelectItem designStatusItem;
	private final SelectItem projectOriginationItem;
	private final TextItem projectOriginationRemarkItem;
	private final SelectItem provinceItem;
	private final SelectItem cityItem;
	private final TextItem detailAddressItem;
//	private final DateItem infoRegisterTimeItem;
	private final ComboBoxItem clientIdItem;
	private final TextItem customerNameItem;
	private final TextItem customerAddressItem;
	//private final SelectItem projectSalesTeamItem;
	private final TextItem contactNameItem;
	private final TextItem contactPhoneItem;
	private final SelectItem comparisonFormItem;
	private final TextItem regionItem;
	private final TextAreaItem remarkItem;
	private final RadioGroupItem isOriginalItem;
	private final RadioGroupItem isSubProjectItem;
	private final TextItem gradeItem;
	private final RadioGroupItem isPubliclyBiddingItem;
	private final RadioGroupItem haveAgentsItem;
	private final SelectItem  ownerTypeIdItem;
	private final DoubleItem  contractAmountItem;
	private final ComboBoxItem  projectTypeItem;
	private final ComboBoxItem  parentCustomerNameItem;
	
	
	private DynamicForm __basicForm = new DynamicForm();
	private DelicacyListGrid businessTypeGrid;
	private DelicacyListGrid specialtyGrid;
	private DelicacyListGrid competitionUnitGrid;
	
	private HLayout allLayout;
	private HLayout leftLayout;
	private VLayout rightLayout;
	private HLayout businessTypeLayout;
	private HLayout specialtyLayout;
	private HLayout competitionUnitLayout;
	private VLayout button1Layout;
	private VLayout button2Layout;
	private VLayout button3Layout;
	
	private IButton addButton1;
	private IButton addButton2;
	private IButton addButton3;
	
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	private LinkedHashMap<String, String> customerNameMap = new LinkedHashMap<>();
	public BeProjectBasicInformationUpdate() {
		
		allLayout = new HLayout(10);
		allLayout.setWidth100();
		allLayout.setHeight100();
		
		leftLayout = new HLayout(10);
		leftLayout.setWidth("60%");
		leftLayout.setHeight100();
		leftLayout.setLayoutRightMargin(10);
		leftLayout.setShowResizeBar(true);
		allLayout.addMember(leftLayout);
		
		preProjectIdItem = new TextItem("preProjectId","前期项目id");
		preProjectIdItem.setHidden(true);
		__formItems.add(preProjectIdItem);
		
		infoCodeItem = new TextItem("infoCode", "信息编号");
		infoCodeItem.setWidth("*");
		infoCodeItem.setCanEdit(false);
		__formItems.add(infoCodeItem);
		
//		projectStatusItem = new SelectItem("projectStatus", shouldNotBeNull+"项目状态");
//		projectStatusItem.setWidth("*");
//		projectStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_154"));
//		projectStatusItem.setCanEdit(true);
//		projectStatusItem.setRequired(false);
//		projectStatusItem.setHidden(true);
//		__formItems.add(projectStatusItem);

		
		projectTypeItem = new ComboBoxItem("projectType","项目类别");
		projectTypeItem.setWidth("*");
		projectTypeItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		projectTypeItem.setRequired(false);
		projectTypeItem.setChangeOnKeypress(false);
		KeyValueManager.loadValueMap("system_dictionary_244", projectTypeItem);
		__formItems.add(projectTypeItem);
		
		projectNameItem = new TextItem("projectName", shouldNotBeNull+"项目名称");
		projectNameItem.setWidth("*");
		projectNameItem.setCanEdit(true);
		projectNameItem.setRequired(true);
		__formItems.add(projectNameItem);
		
//		designStatusItem = new SelectItem("designStatus", "设计状态");
//		designStatusItem.setWidth("*");
//		designStatusItem.setCanEdit(false);
//		designStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_155"));
//		__formItems.add(designStatusItem);
		
		
//		clientIdItem = new TextItem("clientId","客户名称id");
//		clientIdItem.setHidden(true);
//		__formItems.add(clientIdItem);
		
		parentCustomerNameItem = new ComboBoxItem("parentCustomerName","集团名称");
		parentCustomerNameItem.setWidth("*");
		KeyValueManager.loadValueMap("parent_customers_name",parentCustomerNameItem);
		__formItems.add(parentCustomerNameItem);
		parentCustomerNameItem.addChangeHandler(new com.smartgwt.client.widgets.form.fields.events.ChangeHandler() {
			
			@Override
			public void onChange(com.smartgwt.client.widgets.form.fields.events.ChangeEvent event) {
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
		clientIdItem.setChangeOnKeypress(false);
		clientIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		clientIdItem.setValueMap(KeyValueManager.getValueMap("customers_name")); 
		clientIdItem.addChangeHandler(new com.smartgwt.client.widgets.form.fields.events.ChangeHandler() {
			
			@Override
			public void onChange(com.smartgwt.client.widgets.form.fields.events.ChangeEvent event) {
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
		__formItems.add(clientIdItem);
		
		customerNameItem = new TextItem("customerName", shouldNotBeNull+"客户名称");
		customerNameItem.setWidth("*");
		customerNameItem.setCanEdit(false);
		customerNameItem.setRequired(true);
		customerNameItem.setHidden(true);
//		__formItems.add(customerNameItem);
		
		contactNameItem = new TextItem("contactName",shouldNotBeNull+"联系人");
		contactNameItem.setWidth("*");
		contactNameItem.setCanEdit(true);
		contactNameItem.setRequired(true);
		__formItems.add(contactNameItem);
		
		gradeItem = new TextItem("grade","职位");
		gradeItem.setWidth("*");
		gradeItem.setCanEdit(true);
		__formItems.add(gradeItem);
		
		contactPhoneItem = new TextItem("contactPhone","联系电话");
		contactPhoneItem.setWidth("*");
		contactPhoneItem.setCanEdit(true);
		contactPhoneItem.setRequired(false);
		__formItems.add(contactPhoneItem);
		
		customerAddressItem = new TextItem("customerAddress", "客户地址");
		customerAddressItem.setWidth("*");
		customerAddressItem.setCanEdit(true);
		customerAddressItem.setRequired(false);
		__formItems.add(customerAddressItem);

		provinceItem = new SelectItem("province", shouldNotBeNull+"项目地址（省）");
		provinceItem.setWidth("*");
		provinceItem.setCanEdit(true);
		provinceItem.setRequired(true);
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
		__formItems.add(provinceItem);
		
		cityItem = new SelectItem("city", shouldNotBeNull+"项目地址（市）");
		cityItem.setWidth("*");
		cityItem.setRequired(true);
		cityItem.setCanEdit(true);
		cityItem.setValueMap(new LinkedHashMap<>());
		__formItems.add(cityItem);
		
		detailAddressItem = new TextItem("detailAddress", "项目详细地址");
		detailAddressItem.setWidth("*");
		detailAddressItem.setRequired(false);
		detailAddressItem.setCanEdit(true);
		__formItems.add(detailAddressItem);
		
		regionItem = new TextItem("region","区域");
		regionItem.setWidth("*");
		regionItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_170"));
		regionItem.setCanEdit(false);
		__formItems.add(regionItem);
		
	/*	projectSalesTeamItem = new SelectItem("projectSalesTeam", shouldNotBeNull+"项目营销团队");
		projectSalesTeamItem.setWidth("*");
		projectSalesTeamItem.setRequired(true);
		projectSalesTeamItem.setCanEdit(true);
		projectSalesTeamItem.setValueMap(KeyValueManager.getValueMap("plate_record_type_three_str"));
		__formItems.add(projectSalesTeamItem);*/
		
		//contractAmount
		contractAmountItem=new DoubleItem("contractAmount","预估合同金额(元)");
		contractAmountItem.setWidth("*");
		contractAmountItem.setFormat("##,###,###,###,##0.00");
		__formItems.add(contractAmountItem);
		
		
		
		comparisonFormItem = new SelectItem("comparisonForm","比选形式");
		comparisonFormItem.setWidth("*");
		comparisonFormItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_168"));
		comparisonFormItem.setCanEdit(true);
		comparisonFormItem.setRequired(false);
		__formItems.add(comparisonFormItem);
		
		projectOriginationItem = new SelectItem("projectOrigination", "项目来源渠道");
		projectOriginationItem.setWidth("*");
		projectOriginationItem.setRequired(false);
		projectOriginationItem.setCanEdit(true);
		projectOriginationItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_156"));
		__formItems.add(projectOriginationItem);
		
		ownerTypeIdItem=new SelectItem("ownerTypeId",shouldNotBeNull+"业主所属行业");
		ownerTypeIdItem.setWidth("*");
		ownerTypeIdItem.setRequired(true);
		ownerTypeIdItem.setCanEdit(true);
		ownerTypeIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_177"));
		__formItems.add(ownerTypeIdItem);
		
		projectOriginationRemarkItem = new TextItem("projectOriginationRemark", "来源渠道说明");
		projectOriginationRemarkItem.setWidth("*");
		projectOriginationRemarkItem.setCanEdit(true);
		__formItems.add(projectOriginationRemarkItem);
		
//		infoRegisterTimeItem = new DateItem("infoRegisterTime", "信息登记时间");
//		infoRegisterTimeItem.setWidth("*");
//		infoRegisterTimeItem.setUseTextField(true);
//		infoRegisterTimeItem.setDefaultValue(new Date());
//		infoRegisterTimeItem.setCanEdit(false);
//		__formItems.add(infoRegisterTimeItem);
		
		LinkedHashMap<Boolean, String> booleanMap = new LinkedHashMap<>();
		booleanMap.put(true, "是");
		booleanMap.put(false, "否");
		
		isOriginalItem = new RadioGroupItem("isOriginal","原创");
		isOriginalItem.setWidth("*");
		isOriginalItem.setValueMap(booleanMap);
		isOriginalItem.setVertical(false); 
		isOriginalItem.setStartRow(true);
		__formItems.add(isOriginalItem);
		
		isSubProjectItem = new RadioGroupItem("isSubProject","建筑院分包项目");
		isSubProjectItem.setWidth("*");
		isSubProjectItem.setValueMap(booleanMap);
		isSubProjectItem.setVertical(false);
		__formItems.add(isSubProjectItem);
		
		isPubliclyBiddingItem = new RadioGroupItem("isPubliclyBidding","公开挂网招标");
		isPubliclyBiddingItem.setWidth("*");
		isPubliclyBiddingItem.setValueMap(booleanMap);
		isPubliclyBiddingItem.setVertical(false);
		isPubliclyBiddingItem.setStartRow(true);
		__formItems.add(isPubliclyBiddingItem);
		
		haveAgentsItem = new RadioGroupItem("haveAgents","有招标代理机构");
		haveAgentsItem.setWidth("*");
		haveAgentsItem.setValueMap(booleanMap);
		haveAgentsItem.setVertical(false);
		__formItems.add(haveAgentsItem);
		
		
		remarkItem = new TextAreaItem("remark","备注");
		remarkItem.setWidth("*");
		remarkItem.setColSpan(6);
		remarkItem.setRowSpan(3);
		__formItems.add(remarkItem);
		
		DSprojectPreInfomations ds = DSprojectPreInfomations.getInstance();
		__basicForm.setItems(getFormItemArray());
//		__basicForm.setCanEdit(false);
		__basicForm.setDataSource(ds);
		__basicForm.setNumCols(6);
		__basicForm.setWidth("50%");
		ClientUtil.DynamicFormProcessAccordingToDevice(__basicForm);
		isOriginalItem.setTitleOrientation(TitleOrientation.LEFT);
		isSubProjectItem.setTitleOrientation(TitleOrientation.LEFT);
		isPubliclyBiddingItem.setTitleOrientation(TitleOrientation.LEFT);
		haveAgentsItem.setTitleOrientation(TitleOrientation.LEFT);
		projectNameItem.setColSpan(6);
		ownerTypeIdItem.setColSpan(6);
		customerNameItem.setColSpan(6);
		parentCustomerNameItem.setColSpan(6);
		clientIdItem.setColSpan(6);
		projectOriginationRemarkItem.setColSpan(6);
		customerAddressItem.setColSpan(6);
		detailAddressItem.setColSpan(6);
		infoCodeItem.setColSpan(3);
		projectTypeItem.setColSpan(3);
		provinceItem.setColSpan(3);
		cityItem.setColSpan(3);
		regionItem.setColSpan(3);
		comparisonFormItem.setColSpan(3);
		//projectSalesTeamItem.setColSpan(3);
		contractAmountItem.setColSpan(3);
		projectOriginationItem.setColSpan(3);
//		isOriginalItem.setColSpan(3);
//		isSubProjectItem.setColSpan(3);
//		isPubliclyBiddingItem.setColSpan(3);
//		haveAgentsItem.setColSpan(3);
		setName("基本信息");
		leftLayout.addMember(__basicForm);
		
		rightLayout = new VLayout(10);
		rightLayout.setWidth("40%");
		rightLayout.setHeight100();
		allLayout.addMember(rightLayout);
		
		businessTypeGrid = new DelicacyListGrid();
		int a = 0;
		ListGridField[] aFields = new ListGridField[2];
		aFields[a] = new ListGridField("mainProjectBusinessTypeId");
		aFields[a].setHidden(true);
		a++;
		aFields[a] = new ListGridField("businessType","业务类别");
		aFields[a].setCanEdit(true);
		KeyValueManager.loadValueMap("production_value_coefficient_type",aFields[a]);
		a++;
		aFields[a] = new ListGridField("area", "面积");
		aFields[a].setCanEdit(true);
		a++;
		aFields[a] = new ListGridField("outputValue", "产值");
		aFields[a].setCanEdit(true);
		
		businessTypeGrid.setFields(aFields);
		businessTypeGrid.setAutoFitFieldWidths(false);
		businessTypeGrid.setCanRemoveRecords(true);
		businessTypeGrid.setShowGridSummary(true);
		businessTypeGrid.setHeaderHeight(60);
		businessTypeGrid.setCanEdit(true);
		businessTypeGrid.setHeaderSpans(new HeaderSpan(shouldNotBeNull+"业务类别", new String[] {"businessType", "area", "outputValue"}));
		businessTypeGrid.addEditorExitHandler(new EditorExitHandler() {
			
			@Override
			public void onEditorExit(EditorExitEvent event) {
				Object newValue = event.getNewValue();
				if(BaseHelpUtils.isNullOrEmpty(newValue)) {
					return;
				}
				if(event.getColNum() != 0 && event.getColNum() != 1) {
					return;
				}
				Record r = event.getRecord();
				if(null == r) {
					return;
				}
				Map<String, Object> params = new HashMap<>();
				params.put("optType", "calculateOutputValue");
				if(event.getColNum() == 0) {
					//修改了业务类别
					if(BaseHelpUtils.isNullOrZero(r.getAttribute("area"))) {
						return;
					}
					params.put("businessType", newValue);
					params.put("area", r.getAttribute("area"));
				}else {
					//修改了面积
					if(BaseHelpUtils.isNullOrZero(r.getAttribute("businessType"))) {
						return;
					}
					params.put("businessType", r.getAttribute("businessType"));
					params.put("area", newValue);
				}
				DBDataSource.callOperation("EP_PreProjectProcess", "find", params, new DSCallback() {
					
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0) {
							if(null != dsResponse.getData() && dsResponse.getData().length > 0) {
								Record result = dsResponse.getData()[0];
								r.setAttribute("area", result.getAttribute("area"));
								r.setAttribute("outputValue", result.getAttribute("outputValue"));
								businessTypeGrid.updateData(r);
								businessTypeGrid.redraw();
							}
						}else {
							ClientUtil.displayErrorMessage(dsResponse);
						}
					}
				});
			}
		});
		businessTypeGrid.addEditCompleteHandler(new EditCompleteHandler() {
			
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				Record r = businessTypeGrid.getRecord(event.getRowNum());
				if(BaseHelpUtils.isNullOrZero(r.getAttribute("outputValue"))) {
					if(BaseHelpUtils.isNullOrZero(r.getAttribute("businessType")) || BaseHelpUtils.isNullOrZero(r.getAttribute("area"))) {
						return;
					}
					Map<String, Object> params = new HashMap<>();
					params.put("optType", "calculateOutputValue");
					params.put("businessType", r.getAttribute("businessType"));
					params.put("area", r.getAttribute("area"));
					DBDataSource.callOperation("EP_PreProjectProcess", "find", params, new DSCallback() {
						
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if(dsResponse.getStatus() >= 0) {
								if(null != dsResponse.getData() && dsResponse.getData().length > 0) {
									Record result = dsResponse.getData()[0];
									r.setAttribute("area", result.getAttribute("area"));
									r.setAttribute("outputValue", result.getAttribute("outputValue"));
									businessTypeGrid.updateData(r);
									businessTypeGrid.redraw();
								}
							}else {
								ClientUtil.displayErrorMessage(dsResponse);
							}
						}
					});
				}
			}
		});

		businessTypeLayout = new HLayout(10);
		businessTypeLayout.setWidth100();
		businessTypeLayout.setHeight("33%");
		businessTypeLayout.addMember(businessTypeGrid);
		
		addButton1 = new IButton("新增");
		button1Layout = new VLayout(10);
		button1Layout.addMember(addButton1);
		button1Layout.setLayoutTopMargin(30);
		businessTypeLayout.addMember(button1Layout);
		rightLayout.addMember(businessTypeLayout);

//		addButton1.disable();
		addButton1.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Record r = new Record();
				businessTypeGrid.addData(r);
				businessTypeGrid.startEditing(businessTypeGrid.getRecords().length-1);
			}
		});

		specialtyGrid = new DelicacyListGrid();
		int b = 0;
		ListGridField[] bFields = new ListGridField[4];
		bFields[b] = new ListGridField("mainProjectSpecialtyId");
		bFields[b].setHidden(true);
		b++;
		bFields[b] = new ListGridField("specialtyId","参与专业");
		bFields[b].setWidth("33%");
		bFields[b].setCanEdit(true);
		KeyValueManager.loadValueMap("pm_specials",bFields[b]);
		b++;
		bFields[b] = new ListGridField("registrationSealEmployeeId","注册盖章人员");
		bFields[b].setWidth("33%");
		bFields[b].setCanEdit(true);
		KeyValueManager.loadValueMap("employees",bFields[b]);
		b++;
		bFields[b] = new ListGridField("isOutsourcing","是否外包");
		bFields[b].setType(ListGridFieldType.BOOLEAN);
		bFields[b].setWidth("33%");
		bFields[b].setCanEdit(true);
		specialtyGrid.setFields(bFields);
		specialtyGrid.setCanRemoveRecords(true);
		specialtyGrid.setHeaderHeight(60);
		specialtyGrid.setAutoFitFieldWidths(false);
		specialtyGrid.setHeaderSpans(new HeaderSpan(shouldNotBeNull+"项目参与专业", new String[] {"specialtyId","registrationSealEmployeeId","isOutsourcing"}));
		
		specialtyLayout = new HLayout(10);
		specialtyLayout.setWidth100();
		specialtyLayout.setHeight("33%");
		specialtyLayout.addMember(specialtyGrid);
		
		addButton2 = new IButton("新增");
		button2Layout = new VLayout(10);
		button2Layout.addMember(addButton2);
		button2Layout.setLayoutTopMargin(30);
		specialtyLayout.addMember(button2Layout);
		rightLayout.addMember(specialtyLayout);
		
//		addButton2.disable();
		addButton2.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				specialtyGrid.startEditingNew();
			}
		});
		
		competitionUnitGrid = new DelicacyListGrid();
		int c = 0;
		ListGridField[] cFields = new ListGridField[4];
		cFields[c] = new ListGridField("competitionUnitId","公司名称");
		ComboBoxItem companyIdBoxItem = new ComboBoxItem();
		companyIdBoxItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
//		cFields[c].setValueMap(KeyValueManager.getValueMap("competition_units"));
		KeyValueManager.loadValueMap("competition_units", cFields[c]);
		cFields[c].setEditorProperties(companyIdBoxItem);
		cFields[c].addChangeHandler(new ChangeHandler() {
			
			@Override
			public void onChange(ChangeEvent event) {
				int rowNum = event.getRowNum();
				Map<String,Object> cMap = new HashMap<>();
				cMap.put("competitionUnitId", event.getValue());
				DBDataSource.callOperation("ST_CompetitionUnit", "find", cMap, new DSCallback() {
					
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0){
							Record cRecord = dsResponse.getData()[0];
							competitionUnitGrid.setEditValue(rowNum, "name", cRecord.getAttribute("name"));
							competitionUnitGrid.setEditValue(rowNum, "address", cRecord.getAttribute("address"));
						}
					}
				});
			}
		});
		c++;
		cFields[c] = new ListGridField("name");
		cFields[c].setHidden(true);
		c++;
		cFields[c] = new ListGridField("address","公司地址");
		cFields[c].setHidden(true);
		c++;
		cFields[c] = new ListGridField("biddingInformation","备注（报价/其他竞争信息）");
		competitionUnitGrid.setFields(cFields);
		competitionUnitGrid.setAutoFitFieldWidths(false);
		competitionUnitGrid.setCanRemoveRecords(true);
		competitionUnitGrid.setHeaderHeight(60);
		competitionUnitGrid.setCanEdit(true);
		competitionUnitGrid.setHeaderSpans(new HeaderSpan("竞争单位", new String[] {"competitionUnitId","biddingInformation"}));
		
		competitionUnitLayout = new HLayout(10);
		competitionUnitLayout.setWidth100();
		competitionUnitLayout.setHeight("33%");
		competitionUnitLayout.addMember(competitionUnitGrid);
		
		addButton3 = new IButton("新增");
		button3Layout = new VLayout(10);
		button3Layout.addMember(addButton3);
		button3Layout.setLayoutTopMargin(30);
		competitionUnitLayout.addMember(button3Layout);
		rightLayout.addMember(competitionUnitLayout);
		
//		addButton3.disable();
		addButton3.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				competitionUnitGrid.startEditingNew();
			}
		});
		setPageMode(PAGE_MODE_UPDATE);
		addMember(allLayout);
	}

	@Override
	public void startEdit() {
		SC.debugger();
		if (!BaseHelpUtils.isNullOrEmpty(getRecord())) {
			Record record = getRecord();
			if(BaseHelpUtils.getIntValue(record.getAttribute("clientId"))>0) {
				Map<String,Object> params = new HashMap<>();
				params.put("customerId", BaseHelpUtils.getIntValue(record.getAttribute("clientId")));
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
			__basicForm.editRecord(record);
			int preProjectId = BaseHelpUtils.getIntValue(record.getAttribute("preProjectId"));
			Map<String,Object> searchMap = new HashMap<>();
			searchMap.put("preProjectId", preProjectId);
			DBDataSource.callOperation("ST_MainProjectBusinessType", "find", searchMap, new DSCallback() {
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					if(dsResponse.getStatus() >= 0){
						businessTypeGrid.setData(dsResponse.getData());
					}
				}
			});
			DBDataSource.callOperation("ST_MainProjectSpecialty", "find", searchMap, new DSCallback() {
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					if(dsResponse.getStatus() >= 0){
						specialtyGrid.setData(dsResponse.getData());
					}
				}
			});
			DBDataSource.callOperation("NQ_LoadCompetitionUnitsData", searchMap, new DSCallback() {
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					if(dsResponse.getStatus() >= 0){
						competitionUnitGrid.setData(dsResponse.getData());
					}
				}
			});
		} 
	}

	@Override
	public Set<String> getItemNames() {
		Set<String> set = super.getItemNames();
		return set;
	}
	
	@Override
	public boolean checkData() {
		
		if(!__basicForm.validate()){
			SC.say("请按系统提示修改信息");
			return false;
		}
		else if(businessTypeGrid.getRecords().length==0) {
			SC.say("业务类别不能为空");
			return false;
		}
		else if(specialtyGrid.getRecords().length==0) {
			SC.say("项目参与专业不能为空");
			return false;
		}else if(specialtyGrid.getRecords().length > 0) {	
			Map <String,Object> maps=new HashMap<>();
			int registrationSealEmployeeId = 0;
			int specialtyId = 0;
			for (int i = 0; i < specialtyGrid.getRecords().length; i++) {
				maps=specialtyGrid.getRecords()[i].toMap();	
				specialtyId=BaseHelpUtils.getIntValue(maps.get("specialtyId"));
				registrationSealEmployeeId=BaseHelpUtils.getIntValue(maps.get("registrationSealEmployeeId"));
				if(specialtyId<=0) {
					return false;
				}
			}
		}
		
		return true;
		
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSMainProject.getInstance());
		manager.addMember(__basicForm);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		Map<String,Object> saveMap = __basicForm.getValues();
		MapUtils.convertRecordToMap(businessTypeGrid,businessTypeGrid.getRecords(),saveMap,"businessTypeReocrd");
		MapUtils.convertRecordToMap(specialtyGrid,specialtyGrid.getRecords(),saveMap,"specialtyReocrd");
		MapUtils.convertRecordToMap(competitionUnitGrid,competitionUnitGrid.getRecords(),saveMap,"competitionUnitRecord");
		return saveMap;
	}
	
}
