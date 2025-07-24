package com.pomplatform.client.preprojects.panel;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.ValidateUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.employeerescord.datasource.DSEmployee;
import com.pomplatform.client.employeerescord.datasource.DSOnJobEmployees;
import com.pomplatform.client.ja.ht.datasource.DSMainProject;
import com.pomplatform.client.preprojects.datasource.DSprojectPreInfomations;
import com.pomplatform.client.stage.form.MainProjectDetailStage;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.TransferImgButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.RadioGroupItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.ChangedEvent;
import com.smartgwt.client.widgets.grid.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class BeProjectDetailInformationUpdate extends AbstractWizadPage {
	private static final Logger __logger = Logger.getLogger("");
	private final SelectItem projectLevelItem;
	private final SelectItem signCompanyItem;
	private final SelectItem designQualificationItem;
	private final SelectItem projectBaseOnItem;
	private final DateItem projectApprovalTimeItem;
	private final SelectItem designTeamItem;
	private final TextItem designCooperationNameItem;
	private final RadioGroupItem isHighRiseBuildingItem;
	private final RadioGroupItem isModifyProjectItem;
	private final TextItem architecturaldesignUnitsItem;

	private final TextItem projectTotalInvestmentItem;
	//private final TextItem estimatePriceItem;
	private final TextItem totalBuildingAreasItem;
	private final TextItem fireResistanceRatingItem;
	private final TextItem estimateTheDesignAreasItem;
	private final TextItem actualDesignAreasItem;
	private final TextItem buildingHeightItem;
	private final TextItem buildingFloorsItem;
	private final TextItem decorateMoneyControlItem;
	private final SelectItem projectSalesTeamItem;
	private final SelectItem mainProjectStageIdItem;

	private DynamicForm __detailForm = new DynamicForm();
	private DynamicForm __tecForm = new DynamicForm();
	private List<FormItem> __formItems2 = new ArrayList<>();;
	private DelicacyListGrid employeeGrid;
	private DelicacyListGrid salePersonGrid;
	private DelicacyListGrid saleLeaderGrid;
	private DelicacyListGrid projectManageGrid;
	private DelicacyListGrid projectLeaderGrid;
	private DelicacyListGrid projectResponsibleGrid;

	private HLayout allLayout;
	private VLayout leftLayout;
	private VLayout rightLayout;
	private VLayout leftDetailLayout;
	private VLayout leftTecLayout;
	private VLayout middleLayout;
	private HLayout salePersonLayout;
	private HLayout saleLeaderLayout;
	private HLayout projectManageLayout;
	private HLayout projectLeaderLayout;
	private HLayout projectResponsibleLayout;
	      
	private TransferImgButton addToButton1 = new TransferImgButton(TransferImgButton.RIGHT);
	private TransferImgButton addToButton2 = new TransferImgButton(TransferImgButton.RIGHT);
	private TransferImgButton addToButton3 = new TransferImgButton(TransferImgButton.RIGHT);
	private TransferImgButton addToButton4 = new TransferImgButton(TransferImgButton.RIGHT);
	private TransferImgButton addToButton5 = new TransferImgButton(TransferImgButton.RIGHT);

	public static Label detailTitle;
	public static Label tecTitle;

	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";

	public BeProjectDetailInformationUpdate() {

		allLayout = new HLayout(10);
		allLayout.setWidth100();
		allLayout.setHeight100();

		leftLayout = new VLayout(10);
		leftLayout.setWidth("50%");
		leftLayout.setHeight100();
		leftLayout.setLayoutRightMargin(10);
		leftLayout.setShowResizeBar(true);
		allLayout.addMember(leftLayout);

		leftDetailLayout = new VLayout(10);
		leftDetailLayout.setWidth100();
		leftDetailLayout.setHeight("65%");

		detailTitle = new Label("项目详细信息");
		detailTitle.setHeight("5%");
		detailTitle.setAlign(Alignment.CENTER);
		leftDetailLayout.addMember(detailTitle);

		projectLevelItem = new SelectItem("projectLevel", "项目等级");
		projectLevelItem.setWidth("*");
		projectLevelItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_2"));
		projectLevelItem.setCanEdit(true);
		projectLevelItem.setRequired(false);
		__formItems.add(projectLevelItem);

		signCompanyItem = new SelectItem("signCompany", shouldNotBeNull+"拟签约公司");
		signCompanyItem.setWidth("*");
		signCompanyItem.setValueMap(KeyValueManager.getValueMap("company_records"));
		signCompanyItem.setRequired(true);
		__formItems.add(signCompanyItem);

		designQualificationItem = new SelectItem("designQualification", shouldNotBeNull+"设计资质章");
		designQualificationItem.setWidth("*");
		designQualificationItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_157"));
		designQualificationItem.setCanEdit(true);
		designQualificationItem.setRequired(true);
		__formItems.add(designQualificationItem);

		projectBaseOnItem = new SelectItem("projectBaseOn", shouldNotBeNull+"立项依据");
		projectBaseOnItem.setWidth("*");
		projectBaseOnItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_28"));
		projectBaseOnItem.setRequired(true);
		__formItems.add(projectBaseOnItem);

		projectApprovalTimeItem = new DateItem("projectApprovalTime", "立项时间");
		projectApprovalTimeItem.setWidth("*");
		projectApprovalTimeItem.setUseTextField(true);
		projectApprovalTimeItem.setDefaultValue(new Date());
		__formItems.add(projectApprovalTimeItem);

		designTeamItem = new SelectItem("designTeam", shouldNotBeNull+"主办设计团队");
		designTeamItem.setWidth("*");
		designTeamItem.setValueMap(KeyValueManager.getValueMap("plate_records"));
		designTeamItem.setCanEdit(true);
		designTeamItem.setRequired(true);
		__formItems.add(designTeamItem);
		
		projectSalesTeamItem = new SelectItem("projectSalesTeam","项目营销团队");
		projectSalesTeamItem.setWidth("*");
		projectSalesTeamItem.setRequired(false);
		projectSalesTeamItem.setCanEdit(true);
//		projectSalesTeamItem.setValueMap(KeyValueManager.getValueMap("plate_record_type_three_str"));
		KeyValueManager.loadValueMap("plate_record_type_three_str",projectSalesTeamItem);
		__formItems.add(projectSalesTeamItem);
		
		mainProjectStageIdItem = new SelectItem("mainProjectStageId", shouldNotBeNull+"立项类型");
		mainProjectStageIdItem.setWidth("*");
		mainProjectStageIdItem.setRequired(true);
		mainProjectStageIdItem.setCanEdit(true);
		mainProjectStageIdItem.setValueMap(KeyValueManager.getValueMap("main_project_stages"));
		mainProjectStageIdItem.addChangeHandler(new com.smartgwt.client.widgets.form.fields.events.ChangeHandler() {
			
			@Override
			public void onChange(com.smartgwt.client.widgets.form.fields.events.ChangeEvent event) {
				int parentId = BaseHelpUtils.getIntValue(event.getValue());
				if(parentId>0) {
					mainProjectDetailStage.contractTypeItem.setValue(parentId);
					mainProjectDetailStage.changeContractType();
				}
			}
		});
		__formItems.add(mainProjectStageIdItem);
		
		LinkedHashMap<Boolean, String> booleanMap = new LinkedHashMap<>();
		booleanMap.put(true, "是");
		booleanMap.put(false, "否");
		
		isHighRiseBuildingItem = new RadioGroupItem("isHighRiseBuilding", "是否高层建筑");
		isHighRiseBuildingItem.setWidth("*");
		isHighRiseBuildingItem.setValueMap(booleanMap);
		isHighRiseBuildingItem.setVertical(false); 
		isHighRiseBuildingItem.setStartRow(true);
		isHighRiseBuildingItem.setTitleOrientation(TitleOrientation.LEFT);
		__formItems.add(isHighRiseBuildingItem);
		
		isModifyProjectItem = new RadioGroupItem("isModifyProject", shouldNotBeNull+"是否修改项目");
		isModifyProjectItem.setWidth("*");
		isModifyProjectItem.setValueMap(booleanMap);
		isModifyProjectItem.setRequired(true);
		isModifyProjectItem.setVertical(false); 
		isModifyProjectItem.setStartRow(false);
		isModifyProjectItem.setTitleOrientation(TitleOrientation.LEFT);
		__formItems.add(isModifyProjectItem);

		designCooperationNameItem = new TextItem("designCooperationName", "设计合作单位");
		designCooperationNameItem.setWidth("*");
		designCooperationNameItem.setCanEdit(true);
		__formItems.add(designCooperationNameItem);

		architecturaldesignUnitsItem = new TextItem("architecturalDesignUnits", "建筑设计单位");
		architecturaldesignUnitsItem.setWidth("*");
		architecturaldesignUnitsItem.setCanEdit(true);
		__formItems.add(architecturaldesignUnitsItem);

		DSprojectPreInfomations ds = DSprojectPreInfomations.getInstance();
		__detailForm.setItems(getFormItemArray());
		__detailForm.setDataSource(ds);
		//		__detailForm.setCanEdit(false);
		__detailForm.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__detailForm);
		setName("基本信息");
		designCooperationNameItem.setColSpan(4);
		projectSalesTeamItem.setColSpan(2);
		mainProjectStageIdItem.setColSpan(2);
		architecturaldesignUnitsItem.setColSpan(4);
		leftDetailLayout.addMember(__detailForm);
		leftLayout.addMember(leftDetailLayout);

		leftTecLayout = new VLayout(10);
		leftTecLayout.setWidth100();
		leftTecLayout.setHeight("35%");

		tecTitle = new Label("项目技经指标");
		tecTitle.setHeight("5%");
		tecTitle.setAlign(Alignment.CENTER);
		leftTecLayout.addMember(tecTitle);

		projectTotalInvestmentItem = new TextItem("projectTotalInvestment","项目总投资额(元)");
		projectTotalInvestmentItem.setWidth("*");
		projectTotalInvestmentItem.setDecimalPad(2); 
		projectTotalInvestmentItem.setFormat("##,###,###,###,##0.00");
		projectTotalInvestmentItem.setValidators(ValidateUtils.isFloatValidator());
		__formItems2.add(projectTotalInvestmentItem);

		
		/*estimatePriceItem=new TextItem("estimatePrice",shouldNotBeNull+"预估价格(元)");
		estimatePriceItem.setWidth("*");
		estimatePriceItem.setDecimalPad(2);
		estimatePriceItem.setFormat("##,###,###,###,##0.00");
		estimatePriceItem.setRequired(true);
		estimatePriceItem.setValidators(ValidateUtils.isFloatValidator());
		__formItems2.add(estimatePriceItem);*/
		
		totalBuildingAreasItem = new TextItem("totalBuildingAreas","建筑总面积(㎡)");
		totalBuildingAreasItem.setWidth("*");
		totalBuildingAreasItem.setDecimalPad(2);
		totalBuildingAreasItem.setFormat("##,###,###,###,##0.00");
		totalBuildingAreasItem.setValidators(ValidateUtils.isFloatValidator());
		__formItems2.add(totalBuildingAreasItem);

		fireResistanceRatingItem = new TextItem("fireResistanceRating","耐火等级");
		fireResistanceRatingItem.setWidth("*");
		__formItems2.add(fireResistanceRatingItem);

		estimateTheDesignAreasItem = new TextItem("estimateTheDesignAreas","计容建筑面积(㎡)");
		estimateTheDesignAreasItem.setWidth("*");
		estimateTheDesignAreasItem.setDecimalPad(2);
		estimateTheDesignAreasItem.setFormat("##,###,###,###,##0.00");
		estimateTheDesignAreasItem.setValidators(ValidateUtils.isFloatValidator());
		estimateTheDesignAreasItem.setRequired(false);
		__formItems2.add(estimateTheDesignAreasItem);

		actualDesignAreasItem = new TextItem("actualDesignAreas","实际设计面积(㎡)");
		actualDesignAreasItem.setWidth("*");
		actualDesignAreasItem.setDecimalPad(2);
		actualDesignAreasItem.setFormat("##,###,###,###,##0.00");
		actualDesignAreasItem.setValidators(ValidateUtils.isFloatValidator());
		__formItems2.add(actualDesignAreasItem);

		buildingHeightItem = new TextItem("buildingHeight","建筑高度(m)");
		buildingHeightItem.setWidth("*");
		buildingHeightItem.setDecimalPad(2);
		buildingHeightItem.setFormat("##,###,###,###,##0.00");
		buildingHeightItem.setValidators(ValidateUtils.isFloatValidator());
		__formItems2.add(buildingHeightItem);

		buildingFloorsItem = new TextItem("buildingFloors","建筑楼层(层)");
		buildingFloorsItem.setWidth("*");
		buildingFloorsItem.setDecimalPad(2);
		buildingFloorsItem.setFormat("##,###,###,###,##0.00");
		buildingFloorsItem.setValidators(ValidateUtils.isFloatValidator());
		__formItems2.add(buildingFloorsItem);

		decorateMoneyControlItem = new TextItem("decorateMoneyControl","装修造价控制(元)");
		decorateMoneyControlItem.setWidth("*");
		decorateMoneyControlItem.setDecimalPad(2);
		decorateMoneyControlItem.setFormat("##,###,###,###,##0.00");
		decorateMoneyControlItem.setValidators(ValidateUtils.isFloatValidator());
		__formItems2.add(decorateMoneyControlItem);

		__tecForm = new DynamicForm();
		__tecForm.setItems(__formItems2.toArray(new FormItem[__formItems2.size()]));
		__tecForm.setDataSource(ds);
		__tecForm.setCanEdit(true);
		__tecForm.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__tecForm);
		setName("技经指标");
		leftTecLayout.addMember(__tecForm);
		leftLayout.addMember(leftTecLayout);

		middleLayout = new VLayout(10);
		middleLayout.setWidth("25%");
		middleLayout.setLayoutLeftMargin(10);
		allLayout.addMember(middleLayout);

		rightLayout = new VLayout(10);
		rightLayout.setWidth("50%");
		rightLayout.setHeight100();
		rightLayout.setLayoutLeftMargin(10);
		allLayout.addMember(rightLayout);

		employeeGrid = new DelicacyListGrid();
		DSEmployee employeeDs = DSEmployee.getInstance();
		int eIndex = 0;
		ListGridField[] eFields = new ListGridField[4];
		eFields[eIndex] = new ListGridField("employeeId");
		eFields[eIndex].setHidden(true);
		eIndex++;
		eFields[eIndex] = new ListGridField("employeeNo");
		eFields[eIndex].setWidth("30%");
		eIndex++;
		eFields[eIndex] = new ListGridField("employeeName");
		eFields[eIndex].setWidth("30%");
		eIndex++;
		eFields[eIndex] = new ListGridField("plateId");
		eFields[eIndex].setWidth("40%");
		employeeGrid.setDataSource(employeeDs);
		employeeGrid.setFields(eFields);
		employeeGrid.setShowFilterEditor(true);
		employeeGrid.setFilterOnKeypress(false);
		employeeGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		middleLayout.addMember(employeeGrid);

		salePersonGrid = new DelicacyListGrid();
		int a = 0;
		ListGridField[] aFields = new ListGridField[6];
		aFields[a] = new ListGridField("projectStageId");
		aFields[a].setHidden(true);
		a++;
		aFields[a] = new ListGridField("employeeId");
		aFields[a].setValueMap(KeyValueManager.getValueMap("employees"));
		aFields[a].setWidth("30%");
		a++;
		aFields[a] = new ListGridField("employeeName");
		aFields[a].setHidden(true);
		a++;
		aFields[a] = new ListGridField("plateId");
		aFields[a].setWidth("40%");
		a++;
		aFields[a] = new ListGridField("mainAndAssistance","主要/协助跟进人");
		aFields[a].setWidth("30%");
		aFields[a].setCanEdit(true);
		SelectItem mainAndAssistanceItem = new SelectItem("mainAndAssistance");
		aFields[a].setEditorProperties(mainAndAssistanceItem);
		aFields[a].setValueMap(KeyValueManager.getValueMap("system_dictionary_163"));
		aFields[a].addChangedHandler(new ChangedHandler() {

			@Override
			public void onChanged(ChangedEvent event) {
				Record[] records = salePersonGrid.getRecords();
				int rowNum = event.getRowNum();
				Record newRecord = salePersonGrid.getEditedRecord(rowNum);
				Map<Integer,Integer> map = new HashMap<>();
				for(Record re : records){
					map.put(BaseHelpUtils.getIntValue(re.getAttribute("employeeId")),BaseHelpUtils.getIntValue(re.getAttribute("mainAndAssistance")));
				}
				map.put(BaseHelpUtils.getIntValue(newRecord.getAttribute("employeeId")),BaseHelpUtils.getIntValue(newRecord.getAttribute("mainAndAssistance")));
				if(!map.containsValue(1)){
					SC.say("该项目必须有一位主要跟进人");
					salePersonGrid.cancelEditing();
				}
			}
		});
		salePersonGrid.setAutoFitFieldWidths(false);
		salePersonGrid.setDataSource(employeeDs);
		salePersonGrid.setFields(aFields);
		salePersonGrid.setCanRemoveRecords(true);
		salePersonGrid.setHeaderHeight(60);
		salePersonGrid.setHeaderSpans(new HeaderSpan(shouldNotBeNull+"项目秘书", new String[] {"employeeNo","employeeId","plateId","mainAndAssistance"}));

		salePersonLayout = new HLayout(10);
		salePersonLayout.setWidth100();
		salePersonLayout.setHeight("20%");
		salePersonLayout.addMember(addToButton1);
		salePersonLayout.addMember(salePersonGrid);
		rightLayout.addMember(salePersonLayout);

		//		addToButton1.disable();
		addToButton1.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				addEmpToGrid(salePersonGrid);
			}
		});

		saleLeaderGrid = new DelicacyListGrid();
		int b = 0;
		ListGridField[] bFields = new ListGridField[5];
		bFields[b] = new ListGridField("mainProjectEmployeeId");
		bFields[b].setHidden(true);
		b++;
		bFields[b] = new ListGridField("employeeId");
		bFields[b].setHidden(true);
		b++;
		bFields[b] = new ListGridField("employeeNo");
		bFields[b].setWidth("30%");
		b++;
		bFields[b] = new ListGridField("employeeName");
		bFields[b].setWidth("30%");
		b++;
		bFields[b] = new ListGridField("plateId");
		bFields[b].setWidth("40%");
		saleLeaderGrid.setDataSource(employeeDs);
		saleLeaderGrid.setFields(bFields);
		saleLeaderGrid.setCanRemoveRecords(true);
		saleLeaderGrid.setHeaderHeight(60);
		saleLeaderGrid.setAutoFitFieldWidths(false);
		saleLeaderGrid.setHeaderSpans(new HeaderSpan(shouldNotBeNull+"运营董事", new String[] {"employeeNo","employeeName","plateId"}));

		saleLeaderLayout = new HLayout(10);
		saleLeaderLayout.setWidth100();
		saleLeaderLayout.setHeight("20%");
		saleLeaderLayout.addMember(addToButton2);
		saleLeaderLayout.addMember(saleLeaderGrid);
		rightLayout.addMember(saleLeaderLayout);

		//		addToButton2.disable();
		addToButton2.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				addEmpToGrid(saleLeaderGrid);
			}
		});

		projectManageGrid = new DelicacyListGrid();
		int c = 0;
		ListGridField[] cFields = new ListGridField[5];
		cFields[c] = new ListGridField("mainProjectEmployeeId");
		cFields[c].setHidden(true);
		c++;
		cFields[c] = new ListGridField("employeeId");
		cFields[c].setHidden(true);
		c++;
		cFields[c] = new ListGridField("employeeNo");
		cFields[c].setWidth("30%");
		c++;
		cFields[c] = new ListGridField("employeeName");
		cFields[c].setWidth("30%");
		c++;
		cFields[c] = new ListGridField("plateId");
		cFields[c].setWidth("40%");
		projectManageGrid.setDataSource(employeeDs);
		projectManageGrid.setFields(cFields);
		projectManageGrid.setCanRemoveRecords(true);
		projectManageGrid.setHeaderHeight(60);
		projectManageGrid.setAutoFitFieldWidths(false);
		projectManageGrid.setHeaderSpans(new HeaderSpan("项目经理", new String[] {"employeeNo","employeeName","plateId"}));

		projectManageLayout = new HLayout(10);
		projectManageLayout.setWidth100();
		projectManageLayout.setHeight("20%");
		projectManageLayout.addMember(addToButton3);
		projectManageLayout.addMember(projectManageGrid);
		rightLayout.addMember(projectManageLayout);

		//		addToButton3.disable();
		addToButton3.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				addEmpToGrid(projectManageGrid);
			}
		});

		projectLeaderGrid = new DelicacyListGrid();
		int e = 0;
		ListGridField[] dFields = new ListGridField[6];
		dFields[e] = new ListGridField("mainProjectEmployeeId");
		dFields[e].setHidden(true);
		e++;
		dFields[e] = new ListGridField("employeeNo","职员编号");
		dFields[e].setWidth("25%");
		e++;
		dFields[e] = new ListGridField("employeeId","职员名称");
		dFields[e].setValueMap(KeyValueManager.getValueMap("employees"));
		dFields[e].setWidth("25%");
		e++;
		dFields[e] = new ListGridField("employeeName");
		dFields[e].setHidden(true);
		e++;
		dFields[e] = new ListGridField("plateId","业务部门");                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
		dFields[e].setWidth("25%");
		e++;
		dFields[e] = new ListGridField("isPlateManager","是否事业部负责人");
		dFields[e].setWidth("25%");
		dFields[e].setType(ListGridFieldType.BOOLEAN);
		dFields[e].setCanEdit(true);
		projectLeaderGrid.setDataSource(employeeDs);
		projectLeaderGrid.setFields(dFields);
		projectLeaderGrid.setCanRemoveRecords(true);
		projectLeaderGrid.setHeaderHeight(60);
		projectLeaderGrid.setAutoFitFieldWidths(false);
		projectLeaderGrid.setHeaderSpans(new HeaderSpan(shouldNotBeNull+"项目主管领导", new String[] {"employeeNo","employeeId","plateId","isPlateManager"}));

		projectLeaderLayout = new HLayout(10);
		projectLeaderLayout.setWidth100();
		projectLeaderLayout.setHeight("20%");
		projectLeaderLayout.addMember(addToButton4);
		projectLeaderLayout.addMember(projectLeaderGrid);
		rightLayout.addMember(projectLeaderLayout);

		//		addToButton4.disable();
		addToButton4.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				addEmpToGrid(projectLeaderGrid);
			}
		});
		
		
		//项目负责人responsible
		projectResponsibleGrid = new DelicacyListGrid();
		int f = 0;
		ListGridField[] fFields = new ListGridField[6];
		fFields[f] = new ListGridField("mainProjectEmployeeId");
		fFields[f].setHidden(true);
		f++;
		fFields[f] = new ListGridField("employeeNo","职员编号");
		fFields[f].setWidth("25%");
		f++;
		fFields[f] = new ListGridField("employeeId","职员名称");
		fFields[f].setValueMap(KeyValueManager.getValueMap("employees"));
		fFields[f].setWidth("25%");
		f++;
		fFields[f] = new ListGridField("employeeName");
		fFields[f].setHidden(true);
		f++;
		fFields[f] = new ListGridField("plateId","业务部门");
		fFields[f].setWidth("25%");
		projectResponsibleGrid.setDataSource(employeeDs);
		projectResponsibleGrid.setFields(fFields);
		projectResponsibleGrid.setCanRemoveRecords(true);
		projectResponsibleGrid.setHeaderHeight(60);
		projectResponsibleGrid.setAutoFitFieldWidths(false);
		projectResponsibleGrid.setHeaderSpans(new HeaderSpan(shouldNotBeNull+"项目负责人", new String[] {"employeeNo","employeeId","plateId"}));

		projectResponsibleLayout = new HLayout(10);
		projectResponsibleLayout.setWidth100();
		projectResponsibleLayout.setHeight("20%");
		projectResponsibleLayout.addMember(addToButton5);
		projectResponsibleLayout.addMember(projectResponsibleGrid);
		rightLayout.addMember(projectResponsibleLayout);

		addToButton5.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				addEmpToGrid(projectResponsibleGrid);
			}
		});
		

		setPageMode(PAGE_MODE_UPDATE);
		addMember(allLayout);
	}

	@Override
	public void startEdit() {
		if (getRecord() != null) {
			Record record = getRecord();
			__detailForm.editRecord(record);
			__tecForm.editRecord(record);

			Map<String,Object> map = new HashMap<>();
			map.put("preProjectId", record.getAttribute("preProjectId"));
			map.put("relation", 1);
			DBDataSource.callOperation("NQ_SearchMainProjectEmployeeData", map, new DSCallback() {
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					if(dsResponse.getStatus() >= 0){
						salePersonGrid.setData(dsResponse.getData());
					}
				}
			});

			map.put("relation", 2);
			DBDataSource.callOperation("NQ_SearchMainProjectEmployeeData", map, new DSCallback() {
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					if(dsResponse.getStatus() >= 0){
						saleLeaderGrid.setData(dsResponse.getData());
					}
				}
			});

			map.put("relation", 3);
			DBDataSource.callOperation("NQ_SearchMainProjectEmployeeData", map, new DSCallback() {
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					if(dsResponse.getStatus() >= 0){
						projectManageGrid.setData(dsResponse.getData());
					}
				}
			});

			map.put("relation", 4);
			DBDataSource.callOperation("NQ_SearchMainProjectEmployeeData", map, new DSCallback() {
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					if(dsResponse.getStatus() >= 0){
						projectLeaderGrid.setData(dsResponse.getData());
					}
				}
			});
			
			map.put("relation", 5);
			DBDataSource.callOperation("NQ_SearchMainProjectEmployeeData", map, new DSCallback() {
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					if(dsResponse.getStatus() >= 0){
						projectResponsibleGrid.setData(dsResponse.getData());
					}
				}
			});

			map = new HashMap<>();
			map.put("optType", "loadDataForAddInfo");
			map.put("loadType", 1);
			DBDataSource.callOperation("EP_PreProjectProcess", map, new DSCallback() {
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					if(dsResponse.getStatus() >= 0){
						employeeGrid.setData(dsResponse.getData());
					}
				}
			});
		} 
	}

	/**
	 * 将选中人员添加到对应的grid中
	 * @param targetGrid
	 */
	private void addEmpToGrid(DelicacyListGrid targetGrid) {
		ListGridRecord[] selectedRecords = employeeGrid.getSelectedRecords();
		RecordList oriRecords = targetGrid.getDataAsRecordList();
		int oriLength = oriRecords.getLength();
		RecordList newList = new RecordList();
		if (oriLength > 0) {
			newList.addList(oriRecords.getRange(0, oriLength));
		}
		employeeGrid.deselectAllRecords();
		for (ListGridRecord selectedRecord : selectedRecords) {
			Map<String,Object> searchMap = new HashMap<>();
			searchMap.put("employeeId", selectedRecord.getAttribute("employeeId"));
			if (oriLength > 0) {
				int index = oriRecords.findIndex(searchMap);
				if (index != -1) {
					continue;
				}
			}
			searchMap.put("employeeId", selectedRecord.getAttribute("employeeId"));
			searchMap.put("employeeNo", selectedRecord.getAttribute("employeeNo"));
			searchMap.put("employeeName", selectedRecord.getAttribute("employeeName"));
			searchMap.put("plateId", selectedRecord.getAttribute("plateId"));
			newList.add(new Record(searchMap));
		}
		targetGrid.setData(newList);
	}

	@Override
	public boolean checkData() {
//		Map <String,Object> maps=new HashMap<>();
//		boolean checkIsPlateManager=false;
//		if(projectLeaderGrid.getRecords().length != 0) {		
//			for (int i = 0; i < projectLeaderGrid.getRecords().length; i++) {
//				maps=projectLeaderGrid.getRecords()[i].toMap();	
//				checkIsPlateManager=BaseHelpUtils.getBoolean(maps.get("isPlateManager"));
//				if(checkIsPlateManager) {
//					break;
//				}
//			}
//		}
		if(!__tecForm.validate()){
			SC.say("请按系统提示修改信息");
			return false;
		}else if(!__detailForm.validate()){
			SC.say("请按系统提示修改信息");
			return false;
		}else if(salePersonGrid.getRecords().length == 0){
			SC.say("项目秘书不能为空");
			return false;
		}else if(saleLeaderGrid.getRecords().length == 0){
			SC.say("运营董事不能为空");
			return false;
		}else /*if(projectManageGrid.getRecords().length == 0){
			SC.say("项目经理不能为空");
			return false;
		}else*/ if(projectLeaderGrid.getRecords().length == 0){
			SC.say("项目主管领导不能为空");
			return false;
		}else /*if(checkIsPlateManager==false) {
			SC.say("事业部负责人必须选择一人");
			return false;
		}else*/ if(projectResponsibleGrid.getRecords().length == 0){
			SC.say("项目负责人不能为空");
			return false;
		}else{
			return true;
		}
	}

	@Override
	public Set<String> getItemNames() {
		Set<String> set = super.getItemNames();
		Set<String> res = new HashSet<>();
		for (FormItem i : __formItems2) {
			res.add(i.getName());
		}
		set.addAll(res);
		return set;
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSMainProject.getInstance());
		manager.addMember(__detailForm);
		manager.addMember(__tecForm);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		Map<String,Object> saveMap = __detailForm.getValues();
		Map<String,Object> tecMap = __tecForm.getValues();
		for (FormItem i : __formItems2) {
			saveMap.put(i.getName(), tecMap.get(i.getName()));
		}
		MapUtils.convertRecordToMap(salePersonGrid,salePersonGrid.getRecords(),saveMap,"salePersonReocrd");
		MapUtils.convertRecordToMap(DSEmployee.getInstance(),saleLeaderGrid.getRecords(),saveMap,"saleLeaderReocrd");
		MapUtils.convertRecordToMap(DSEmployee.getInstance(),projectManageGrid.getRecords(),saveMap,"projectManageReocrd");
		MapUtils.convertRecordToMap(projectLeaderGrid,projectLeaderGrid.getRecords(),saveMap,"projectLeaderReocrd");
		MapUtils.convertRecordToMap(projectResponsibleGrid,projectResponsibleGrid.getRecords(),saveMap,"projectResponsibleRecord");
		return saveMap;
	}
	
	
	private MainProjectDetailStage mainProjectDetailStage;

	public MainProjectDetailStage getMainProjectDetailStage() {
		return mainProjectDetailStage;
	}

	public void setMainProjectDetailStage(MainProjectDetailStage mainProjectDetailStage) {
		this.mainProjectDetailStage = mainProjectDetailStage;
	}
	
	

}
