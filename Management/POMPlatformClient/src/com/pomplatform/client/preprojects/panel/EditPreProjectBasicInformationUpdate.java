package com.pomplatform.client.preprojects.panel;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
import com.pomplatform.client.ja.ht.datasource.DSMainProject;
import com.pomplatform.client.preprojects.datasource.DSprojectPreInfomations;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
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

public class EditPreProjectBasicInformationUpdate extends AbstractWizadPage {
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
	private final DateItem infoRegisterTimeItem;
	private final TextItem customerNameItem;
	private final TextItem customerAddressItem;
	//private final SelectItem projectSalesTeamItem;
	private final TextItem contactNameItem;
	private final TextItem contactPhoneItem;
	private final TextItem contactEmailItem;
	private final TextItem clientIdItem;
	private final SelectItem comparisonFormItem;
	private final TextItem regionItem;
	private final TextAreaItem remarkItem;
	private final RadioGroupItem isOriginalItem;
	private final RadioGroupItem isSubProjectItem;
	private final TextItem gradeItem;
	private final RadioGroupItem isPubliclyBiddingItem;
	private final RadioGroupItem haveAgentsItem;
	private final DoubleItem  contractAmountItem;
	
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
	
	public EditPreProjectBasicInformationUpdate() {
		
		allLayout = new HLayout(10);
		allLayout.setWidth100();
		allLayout.setHeight100();
		
		leftLayout = new HLayout(10);
		leftLayout.setWidth("50%");
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
		
//		projectStatusItem = new SelectItem("projectStatus", "项目状态");
//		projectStatusItem.setWidth("*");
//		projectStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_154_false"));
//		__formItems.add(projectStatusItem);
		
		projectNameItem = new TextItem("projectName", "项目名称");
		projectNameItem.setWidth("*");
		__formItems.add(projectNameItem);
		
//		designStatusItem = new SelectItem("designStatus", "设计状态");
//		designStatusItem.setWidth("*");
//		designStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_155"));
//		__formItems.add(designStatusItem);
		
		customerNameItem = new ComboBoxItem("customerName", "客户名称");
		customerNameItem.setWidth("*");
//		customerNameItem.setValueMap(KeyValueManager.getValueMap("customers_name"));
		KeyValueManager.loadValueMap("customers_name",customerNameItem);
		__formItems.add(customerNameItem);
		
		clientIdItem = new TextItem("clientId","客户id");
		clientIdItem.setHidden(true);
		__formItems.add(clientIdItem);
		
		contactNameItem = new TextItem("contactName","联系人");
		contactNameItem.setWidth("*");
		__formItems.add(contactNameItem);
		
		gradeItem = new TextItem("grade","职位");
		gradeItem.setWidth("*");
//		gradeItem.setStartRow(false);
		__formItems.add(gradeItem);
		
		contactPhoneItem = new TextItem("contactPhone","联系电话");
		contactPhoneItem.setWidth("*");
//		contactPhoneItem.setStartRow(false);
		__formItems.add(contactPhoneItem);
		
		contactEmailItem = new TextItem("contactEmail","联系人邮箱");
		contactEmailItem.setWidth("*");
		__formItems.add(contactEmailItem);
		
		customerAddressItem = new TextItem("customerAddress", "客户地址");
		customerAddressItem.setWidth("*");
		__formItems.add(customerAddressItem);

		provinceItem = new SelectItem("province", "项目地址（省）");
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
		
		cityItem = new SelectItem("city", "项目地址（市）");
		cityItem.setWidth("*");
		cityItem.setValueMap(new LinkedHashMap<>());
		__formItems.add(cityItem);
		
		detailAddressItem = new TextItem("detailAddress", "项目详细地址");
		detailAddressItem.setWidth("*");
		__formItems.add(detailAddressItem);
		
		regionItem = new TextItem("region","区域");
		regionItem.setWidth("*");
		regionItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_170"));
		regionItem.setCanEdit(false);
		__formItems.add(regionItem);
		
		/*projectSalesTeamItem = new SelectItem("projectSalesTeam", "项目营销团队");
		projectSalesTeamItem.setWidth("*");
		projectSalesTeamItem.setValueMap(KeyValueManager.getValueMap("plate_record_type_three_str"));
		__formItems.add(projectSalesTeamItem);*/
		
		
		contractAmountItem=new DoubleItem("contractAmount","预估合同金额(元)");
		contractAmountItem.setWidth("*");
		contractAmountItem.setFormat("##,###,###,###,##0.00");
		__formItems.add(contractAmountItem);
		
		
		comparisonFormItem = new SelectItem("comparisonForm","比选形式");
		comparisonFormItem.setWidth("*");
		comparisonFormItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_168"));
		__formItems.add(comparisonFormItem);
		
		projectOriginationItem = new SelectItem("projectOrigination", "项目来源渠道");
		projectOriginationItem.setWidth("*");
		projectOriginationItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_156"));
		__formItems.add(projectOriginationItem);
		
		projectOriginationRemarkItem = new TextItem("projectOriginationRemark", "来源渠道说明");
		projectOriginationRemarkItem.setWidth("*");
		__formItems.add(projectOriginationRemarkItem);
		
		infoRegisterTimeItem = new DateItem("infoRegisterTime", "信息登记时间");
		infoRegisterTimeItem.setWidth("*");
		infoRegisterTimeItem.setUseTextField(true);
		infoRegisterTimeItem.setDefaultValue(new Date());
		infoRegisterTimeItem.setCanEdit(false);
		infoRegisterTimeItem.setHidden(true);
		__formItems.add(infoRegisterTimeItem);
		
		LinkedHashMap<Boolean, String> booleanMap = new LinkedHashMap<>();
		booleanMap.put(true, "是");
		booleanMap.put(false, "否");
		
		isOriginalItem = new RadioGroupItem("isOriginal","原创");
		isOriginalItem.setWidth("*");
		isOriginalItem.setValueMap(booleanMap);
		isOriginalItem.setVertical(false);
		isOriginalItem.setStartRow(false);
		__formItems.add(isOriginalItem);
		
		isSubProjectItem = new RadioGroupItem("isSubProject","建筑院分包项目");
		isSubProjectItem.setWidth("*");
		isSubProjectItem.setValueMap(booleanMap);
		isSubProjectItem.setVertical(false);
		isSubProjectItem.setStartRow(false);
		__formItems.add(isSubProjectItem);
		
		isPubliclyBiddingItem = new RadioGroupItem("isPubliclyBidding","公开挂网招标");
		isPubliclyBiddingItem.setWidth("*");
		isPubliclyBiddingItem.setValueMap(booleanMap);
		isPubliclyBiddingItem.setVertical(false);
		isPubliclyBiddingItem.setStartRow(false);
		__formItems.add(isPubliclyBiddingItem);
		
		haveAgentsItem = new RadioGroupItem("haveAgents","有招标代理机构");
		haveAgentsItem.setWidth("*");
		haveAgentsItem.setValueMap(booleanMap);
		haveAgentsItem.setVertical(false);
		haveAgentsItem.setStartRow(false);
		__formItems.add(haveAgentsItem);
		
		
		remarkItem = new TextAreaItem("remark","备注");
		remarkItem.setWidth("*");
		remarkItem.setColSpan(6);
		remarkItem.setRowSpan(3);
		__formItems.add(remarkItem);

		DSprojectPreInfomations ds = DSprojectPreInfomations.getInstance();
		__basicForm.setItems(getFormItemArray());
		__basicForm.setDataSource(ds);
		__basicForm.setNumCols(6);
		__basicForm.setWidth("40%");
		ClientUtil.DynamicFormProcessAccordingToDevice(__basicForm);
		isOriginalItem.setTitleOrientation(TitleOrientation.LEFT);
		isSubProjectItem.setTitleOrientation(TitleOrientation.LEFT);
		isPubliclyBiddingItem.setTitleOrientation(TitleOrientation.LEFT);
		haveAgentsItem.setTitleOrientation(TitleOrientation.LEFT);
		projectNameItem.setColSpan(6);
		customerNameItem.setColSpan(6);
		customerAddressItem.setColSpan(6);
		detailAddressItem.setColSpan(6);
		infoCodeItem.setColSpan(3);
//		projectStatusItem.setColSpan(3);
		provinceItem.setColSpan(3);
		cityItem.setColSpan(3);
		regionItem.setColSpan(3);
		comparisonFormItem.setColSpan(3);
		contractAmountItem.setColSpan(3);
		projectOriginationItem.setColSpan(3);
		isOriginalItem.setColSpan(2);
		isSubProjectItem.setColSpan(2);
		isPubliclyBiddingItem.setColSpan(2);
		haveAgentsItem.setColSpan(2);
		projectOriginationRemarkItem.setColSpan(6);
		contactNameItem.setColSpan(3);
		gradeItem.setColSpan(3);
		contactPhoneItem.setColSpan(3);
		contactEmailItem.setColSpan(3);
		setName("基本信息");
		leftLayout.addMember(__basicForm);
		
		rightLayout = new VLayout(10);
		rightLayout.setWidth("50%");
		rightLayout.setHeight100();
		rightLayout.setLayoutLeftMargin(10);
		
		businessTypeGrid = new DelicacyListGrid();
		businessTypeGrid.setShowGridSummary(true);
		int a = 0;
		ListGridField[] aFields = new ListGridField[2];
		aFields[a] = new ListGridField("mainProjectBusinessTypeId");
		aFields[a].setHidden(true);
		a++;
		aFields[a] = new ListGridField("businessType","业务类别");
		aFields[a].setCanEdit(true);
		aFields[a].setShowGridSummary(false);
		KeyValueManager.loadValueMap("production_value_coefficient_type",aFields[a]);
		a++;
		aFields[a] = new ListGridField("area", "面积");
		aFields[a].setCanEdit(true);
		a++;
		aFields[a] = new ListGridField("outputValue", "产值");
		aFields[a].setCanEdit(false);
		
		businessTypeGrid.setFields(aFields);
		businessTypeGrid.setAutoFitFieldWidths(false);
		businessTypeGrid.setCanRemoveRecords(true);
		businessTypeGrid.setHeaderHeight(60);
		businessTypeGrid.setHeaderSpans(new HeaderSpan("业务类别", new String[] {"businessType", "area", "outputValue"}));
		businessTypeGrid.addEditorExitHandler(new EditorExitHandler() {
			
			@Override
			public void onEditorExit(EditorExitEvent event) {
				SC.debugger();
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
				SC.debugger();
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
		ListGridField[] bFields = new ListGridField[2];
		bFields[b] = new ListGridField("mainProjectSpecialtyId");
		bFields[b].setHidden(true);
		b++;
		bFields[b] = new ListGridField("specialtyId","参与专业");
		bFields[b].setCanEdit(true);
		KeyValueManager.loadValueMap("pm_specials",bFields[b]);
		b++;
		bFields[b] = new ListGridField("registrationSealEmployeeId","注册盖章人员");
		bFields[b].setCanEdit(true);
		KeyValueManager.loadValueMap("employees",bFields[b]);
		specialtyGrid.setDataSource(ds);
		specialtyGrid.setFields(bFields);
		specialtyGrid.setCanRemoveRecords(true);
		specialtyGrid.setHeaderHeight(60);
		specialtyGrid.setHeaderSpans(new HeaderSpan("项目参与专业", new String[] {"specialtyId","registrationSealEmployeeId"}));
		
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
		cFields[c].setEditorProperties(companyIdBoxItem);
//		cFields[c].setValueMap(KeyValueManager.getValueMap("competition_units"));
		KeyValueManager.loadValueMap("competition_units", cFields[c]);
		cFields[c].addChangeHandler(new ChangeHandler() {
			
			@Override
			public void onChange(ChangeEvent event) {
				int rowNum = event.getRowNum();
				Map<String,Object> cMap = new HashMap<>();
				cMap.put("competitionUnitId", event.getValue());
				SC.debugger();
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
		
		addButton3.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				competitionUnitGrid.startEditingNew();
			}
		});
		allLayout.addMember(rightLayout);
		addMember(allLayout);
	}

	
	@Override
	public void startEdit() {
		if (!BaseHelpUtils.isNullOrEmpty(getRecord())) {
			Record record = getRecord();
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
		saveMap.put("applyEmployeeId", ClientUtil.getEmployeeId());
		__logger.info("saveMap++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+saveMap);
		return saveMap;
	}
	
}
