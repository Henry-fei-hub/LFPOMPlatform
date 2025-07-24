package com.pomplatform.client.preprojects.panel;

import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.MapUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.operation.datasource.DSProjectManager;
import com.pomplatform.client.preprojects.datasource.DSprojectPreInfomations;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.BooleanItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PreProjectDetailInformationNew extends AbstractWizadPage {
	private static final Logger __logger = Logger.getLogger("");
	private final SelectItem projectLevelItem;
	private final SelectItem signCompanyItem;
	private final SelectItem designQualificationItem;
	private final SelectItem projectBaseOnItem;
	private final DateItem projectApprovalTimeItem;
	private final SelectItem designTeamItem;
	private final TextItem designCooperationNameItem;
	private final BooleanItem isHighRiseBuildingItem;
	private final TextItem architecturaldesignUnitsItem;
	
	private final TextItem projectTotalInvestmentItem;
	private final TextItem totalBuildingAreasItem;
	private final TextItem fireResistanceRatingItem;
	private final TextItem estimateTheDesignAreasItem;
	private final TextItem actualDesignAreasItem;
	private final TextItem buildingHeightItem;
	private final TextItem buildingFloorsItem;
	private final TextItem decorateMoneyControlItem;
	
	private DynamicForm __detailForm = new DynamicForm();
	private DynamicForm __tecForm = new DynamicForm();
	private DelicacyListGrid businessTypeGrid;
	private DelicacyListGrid specialtyGrid;
	private DelicacyListGrid competitionUnitGrid;
	
	private HLayout allLayout;
	private VLayout leftLayout;
	private VLayout rightLayout;
	private HLayout businessTypeLayout;
	private HLayout specialtyLayout;
	private HLayout competitionUnitLayout;
	private VLayout leftDetailLayout;
	private VLayout leftTecLayout;
	private VLayout button1Layout;
	private VLayout button2Layout;
	private VLayout button3Layout;
	
	private IButton addButton1;
	private IButton addButton2;
	private IButton addButton3;
	
	public static Label detailTitle;
	public static Label tecTitle;
	
	public PreProjectDetailInformationNew() {
		
		allLayout = new HLayout(10);
		allLayout.setWidth100();
		allLayout.setHeight100();
		
		leftLayout = new VLayout(10);
		leftLayout.setWidth("40%");
		leftLayout.setHeight100();
		leftLayout.setLayoutRightMargin(10);
		leftLayout.setShowResizeBar(true);
		allLayout.addMember(leftLayout);
		
		leftDetailLayout = new VLayout(10);
		leftDetailLayout.setWidth100();
		leftDetailLayout.setHeight("45%");

		detailTitle = new Label("项目详细信息");
		detailTitle.setHeight("5%");
		detailTitle.setAlign(Alignment.CENTER);
		leftDetailLayout.addMember(detailTitle);
		
		projectLevelItem = new SelectItem("projectLevel", "项目等级");
		projectLevelItem.setWidth("*");
		projectLevelItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_2"));
		
		signCompanyItem = new SelectItem("signCompany", "拟签约公司");
		signCompanyItem.setWidth("*");
		signCompanyItem.setValueMap(KeyValueManager.getValueMap("company_records"));
		
		designQualificationItem = new SelectItem("designQualification", "设计资质章");
		designQualificationItem.setWidth("*");
		designQualificationItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_147"));
		
		projectBaseOnItem = new SelectItem("projectBaseOn", "立项依据");
		projectBaseOnItem.setWidth("*");
		projectBaseOnItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_28"));
		
		projectApprovalTimeItem = new DateItem("projectApprovalTime", "立项时间");
		projectApprovalTimeItem.setWidth("*");
		projectApprovalTimeItem.setUseTextField(true);
		
		designTeamItem = new SelectItem("designTeam", "主办设计团队");
		designTeamItem.setWidth("*");
		designTeamItem.setValueMap(KeyValueManager.getValueMap("plate_records"));

		isHighRiseBuildingItem = new BooleanItem("isHighRiseBuilding", "是否高层建筑");
		isHighRiseBuildingItem.setWidth("*");

		designCooperationNameItem = new TextItem("designCooperationName", "设计合作单位");
		designCooperationNameItem.setWidth("*");
		
		architecturaldesignUnitsItem = new TextItem("architecturalDesignUnits", "建筑设计单位");
		architecturaldesignUnitsItem.setWidth("*");
		
		DSprojectPreInfomations ds = DSprojectPreInfomations.getInstance();
		__detailForm.setItems(projectLevelItem,signCompanyItem,designQualificationItem,projectBaseOnItem,projectApprovalTimeItem,designTeamItem,isHighRiseBuildingItem,designCooperationNameItem,architecturaldesignUnitsItem);
		__detailForm.setDataSource(ds);
		__detailForm.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__detailForm);
		setName("基本信息");
		designCooperationNameItem.setColSpan(4);
		architecturaldesignUnitsItem.setColSpan(4);
		leftDetailLayout.addMember(__detailForm);
		leftLayout.addMember(leftDetailLayout);
		
		leftTecLayout = new VLayout(10);
		leftTecLayout.setWidth100();
		leftTecLayout.setHeight("45%");
		
		tecTitle = new Label("项目技经指标");
		tecTitle.setHeight("5%");
		tecTitle.setAlign(Alignment.CENTER);
		leftTecLayout.addMember(tecTitle);
		
		projectTotalInvestmentItem = new TextItem("projectTotalInvestment","项目总投资额");
		projectTotalInvestmentItem.setWidth("*");

		totalBuildingAreasItem = new TextItem("totalBuildingAreas","建筑总面积");
		totalBuildingAreasItem.setWidth("*");
		
		fireResistanceRatingItem = new TextItem("fireResistanceRating","耐火等级");
		fireResistanceRatingItem.setWidth("*");
		
		estimateTheDesignAreasItem = new TextItem("estimateTheDesignAreas","计容建筑面积(㎡)");
		estimateTheDesignAreasItem.setWidth("*");
		
		actualDesignAreasItem = new TextItem("actualDesignAreas","实际设计面积");
		actualDesignAreasItem.setWidth("*");
		
		buildingHeightItem = new TextItem("buildingHeight","建筑高度");
		buildingHeightItem.setWidth("*");
		
		buildingFloorsItem = new TextItem("buildingFloors","建筑楼层");
		buildingFloorsItem.setWidth("*");
		
		decorateMoneyControlItem = new TextItem("decorateMoneyControl","装修造价控制");
		decorateMoneyControlItem.setWidth("*");
		
		__tecForm = new DynamicForm();
		__tecForm.setItems(projectTotalInvestmentItem,totalBuildingAreasItem,fireResistanceRatingItem,estimateTheDesignAreasItem,actualDesignAreasItem,buildingHeightItem,buildingFloorsItem,decorateMoneyControlItem);
		__tecForm.setDataSource(ds);
		__tecForm.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__tecForm);
		setName("技经指标");
		leftTecLayout.addMember(__tecForm);
		leftLayout.addMember(leftTecLayout);
		
		rightLayout = new VLayout(10);
		rightLayout.setWidth("35%");
		rightLayout.setHeight100();
		rightLayout.setLayoutLeftMargin(10);
		allLayout.addMember(rightLayout);
		
		businessTypeGrid = new DelicacyListGrid();
		int a = 0;
		ListGridField[] aFields = new ListGridField[1];
		aFields[a] = new ListGridField("businessType","业务类别");
//		aFields[a].setValueMap(KeyValueManager.getValueMap("pre_business_type"));
		KeyValueManager.loadValueMap("pre_business_type",aFields[a]);
		businessTypeGrid.setFields(aFields);
		businessTypeGrid.setAutoFitFieldWidths(false);
		businessTypeGrid.setCanRemoveRecords(true);
		businessTypeGrid.setHeaderHeight(60);
		businessTypeGrid.setHeaderSpans(new HeaderSpan("业务类别", new String[] {"businessType"}));
		
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
				businessTypeGrid.startEditingNew();
			}
		});

		specialtyGrid = new DelicacyListGrid();
		int b = 0;
		ListGridField[] bFields = new ListGridField[1];
		bFields[b] = new ListGridField("specialtyId","参与专业");
//		bFields[b].setValueMap(KeyValueManager.getValueMap("pm_specials"));
		KeyValueManager.loadValueMap("pm_specials",bFields[b]);
		specialtyGrid.setDataSource(ds);
		specialtyGrid.setFields(bFields);
		specialtyGrid.setCanRemoveRecords(true);
		specialtyGrid.setHeaderHeight(60);
		specialtyGrid.setHeaderSpans(new HeaderSpan("项目参与专业", new String[] {"specialtyId"}));
		
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
		ListGridField[] cFields = new ListGridField[2];
		cFields[c] = new ListGridField("employeeNo","公司名称");
		c++;
		cFields[c] = new ListGridField("employeeName","公司地址");
		competitionUnitGrid.setFields(cFields);
		competitionUnitGrid.setAutoFitFieldWidths(false);
		competitionUnitGrid.setCanRemoveRecords(true);
		competitionUnitGrid.setHeaderHeight(60);
		competitionUnitGrid.setHeaderSpans(new HeaderSpan("竞争单位", new String[] {"employeeNo","employeeName"}));
		
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
		
		addMember(allLayout);
	}

	@Override
	public void startEdit() {
		if (getRecord() != null) {
			__form.editRecord(getRecord());
		} else {
			__form.editNewRecord();
		}
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSProjectManager.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		Map<String,Object> saveMap = __detailForm.getValues();
		saveMap.putAll(__tecForm.getValues());
		MapUtils.convertRecordToMap(businessTypeGrid,businessTypeGrid.getRecords(),saveMap,"businessTypeReocrd");
		MapUtils.convertRecordToMap(specialtyGrid,specialtyGrid.getRecords(),saveMap,"specialtyReocrd");
//		MapUtils.convertRecordToMap(DSEmployee.getInstance(),salePersonGrid.getRecords(),saveMap,"salePersonReocrd");
		return saveMap;
	}

}
