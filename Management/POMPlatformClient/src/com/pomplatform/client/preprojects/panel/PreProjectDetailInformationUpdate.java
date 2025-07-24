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
import com.pomplatform.client.ja.ht.datasource.DSMainProject;
import com.pomplatform.client.operation.datasource.DSProjectManager;
import com.pomplatform.client.preprojects.datasource.DSprojectPreInfomations;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.TransferImgButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.BooleanItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.RadioGroupItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.ChangeEvent;
import com.smartgwt.client.widgets.grid.events.ChangeHandler;
import com.smartgwt.client.widgets.grid.events.ChangedEvent;
import com.smartgwt.client.widgets.grid.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PreProjectDetailInformationUpdate extends AbstractWizadPage {
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
	
	private final SelectItem closeReasonItem;
	private final TextAreaItem closeRemarkItem;
	private final RadioGroupItem isWinningBidItem;
	private final TextItem bidCompanyNumItem;
	private final SelectItem bidRankingTypeItem;
	private final TextItem bidRankingItem;
	
	private DynamicForm __detailForm = new DynamicForm();
	private DynamicForm __tecForm = new DynamicForm();
	private List<FormItem> __formItems2 = new ArrayList<>();;
	private DelicacyListGrid employeeGrid;
	private DelicacyListGrid salePersonGrid;
	private DelicacyListGrid saleLeaderGrid;
	private DelicacyListGrid projectManageGrid;
	private DelicacyListGrid projectLeaderGrid;
	
	private HLayout allLayout;
	private VLayout leftLayout;
	private VLayout rightLayout;
	private VLayout middleLayout;
	private VLayout leftDetailLayout;
	private VLayout leftTecLayout;
	private HLayout salePersonLayout;
	private HLayout saleLeaderLayout;
	private HLayout projectManageLayout;
	private HLayout projectLeaderLayout;
	
	private TransferImgButton addToButton1 = new TransferImgButton(TransferImgButton.RIGHT);
	private TransferImgButton addToButton2 = new TransferImgButton(TransferImgButton.RIGHT);
	private TransferImgButton addToButton3 = new TransferImgButton(TransferImgButton.RIGHT);
	private TransferImgButton addToButton4 = new TransferImgButton(TransferImgButton.RIGHT);
	
	public static Label detailTitle;
	public static Label tecTitle;
	
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	
	public PreProjectDetailInformationUpdate() {
		
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
		leftDetailLayout.setHeight("46%");

		detailTitle = new Label("项目详细信息");
		detailTitle.setHeight("5%");
		detailTitle.setAlign(Alignment.CENTER);
		leftDetailLayout.addMember(detailTitle);
		
		projectLevelItem = new SelectItem("projectLevel", "项目等级");
		projectLevelItem.setWidth("*");
		projectLevelItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_2"));
		projectLevelItem.setCanEdit(false);
		__formItems.add(projectLevelItem);
		
		signCompanyItem = new SelectItem("signCompany", "拟签约公司");
		signCompanyItem.setWidth("*");
		signCompanyItem.setValueMap(KeyValueManager.getValueMap("company_records"));
//		signCompanyItem.setRequired(true);
		__formItems.add(signCompanyItem);
		
		designQualificationItem = new SelectItem("designQualification", "设计资质章");
		designQualificationItem.setWidth("*");
		designQualificationItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_157"));
		designQualificationItem.setCanEdit(false);
		__formItems.add(designQualificationItem);
		
		projectBaseOnItem = new SelectItem("projectBaseOn", "立项依据");
		projectBaseOnItem.setWidth("*");
		projectBaseOnItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_28"));
//		projectBaseOnItem.setRequired(true);
		__formItems.add(projectBaseOnItem);
		
		projectApprovalTimeItem = new DateItem("projectApprovalTime", "立项时间");
		projectApprovalTimeItem.setWidth("*");
		projectApprovalTimeItem.setUseTextField(true);
		projectApprovalTimeItem.setCanEdit(false);
		//projectApprovalTimeItem.setDefaultValue(new Date());
		__formItems.add(projectApprovalTimeItem);
		
		designTeamItem = new SelectItem("designTeam", "主办设计团队");
		designTeamItem.setWidth("*");
		designTeamItem.setValueMap(KeyValueManager.getValueMap("plate_records"));
		designTeamItem.setCanEdit(false);
		__formItems.add(designTeamItem);

		isHighRiseBuildingItem = new BooleanItem("isHighRiseBuilding", "是否高层建筑");
		isHighRiseBuildingItem.setWidth("*");
		isHighRiseBuildingItem.setCanEdit(false);
		__formItems.add(isHighRiseBuildingItem);

		designCooperationNameItem = new TextItem("designCooperationName", "设计合作单位");
		designCooperationNameItem.setWidth("*");
		designCooperationNameItem.setCanEdit(false);
		__formItems.add(designCooperationNameItem);
		
		architecturaldesignUnitsItem = new TextItem("architecturalDesignUnits", "建筑设计单位");
		architecturaldesignUnitsItem.setWidth("*");
		architecturaldesignUnitsItem.setCanEdit(false);
		__formItems.add(architecturaldesignUnitsItem);
		
		DSprojectPreInfomations ds = DSprojectPreInfomations.getInstance();
		__detailForm.setItems(getFormItemArray());
		__detailForm.setDataSource(ds);
//		__detailForm.setCanEdit(false);
		__detailForm.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__detailForm);
		setName("基本信息");
		designCooperationNameItem.setColSpan(4);
		architecturaldesignUnitsItem.setColSpan(4);
		leftDetailLayout.addMember(__detailForm);
		leftLayout.addMember(leftDetailLayout);
		
		leftTecLayout = new VLayout(10);
		leftTecLayout.setWidth100();
		leftTecLayout.setHeight("40%");
		
		tecTitle = new Label("项目关闭信息");
		tecTitle.setHeight("5%");
		tecTitle.setAlign(Alignment.CENTER);
		leftTecLayout.addMember(tecTitle);
		
		closeReasonItem = new SelectItem("closeReason",shouldNotBeNull+"关闭原因");
		closeReasonItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_169"));
		closeReasonItem.setWidth("*");
		closeReasonItem.setRequired(true);
		__formItems2.add(closeReasonItem);

		LinkedHashMap<Boolean, String> booleanMap = new LinkedHashMap<>();
		booleanMap.put(true, "是");
		booleanMap.put(false, "否");
		
		isWinningBidItem = new RadioGroupItem("isWinningBid","是否中标");
		isWinningBidItem.setWidth("*");
		isWinningBidItem.setValueMap(booleanMap);
		isWinningBidItem.setVertical(false);
		isWinningBidItem.setStartRow(false);
		__formItems2.add(isWinningBidItem);
		
		bidCompanyNumItem = new TextItem("bidCompanyNum","参与投标公司数量");
		bidCompanyNumItem.setWidth("*");
		bidCompanyNumItem.setValidators(ValidateUtils.isIntValidator());
		__formItems2.add(bidCompanyNumItem);
		
		bidRankingTypeItem = new SelectItem("bidRankingType","投标排名类型");
		bidRankingTypeItem.setWidth("*");
		bidRankingTypeItem.setMultiple(true);
		bidRankingTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_173"));
		__formItems2.add(bidRankingTypeItem);
		
		bidRankingItem = new TextItem("bidRanking","投标排名名次");
		bidRankingItem.setValidators(ValidateUtils.isIntValidator());
		bidRankingItem.setWidth("*");
		__formItems2.add(bidRankingItem);
		
		closeRemarkItem = new TextAreaItem("closeRemark", shouldNotBeNull+"项目关闭备注");
		closeRemarkItem.setWidth("*");
		closeRemarkItem.setColSpan(4);
		closeRemarkItem.setRowSpan(2);
		closeRemarkItem.setRequired(true);
		__formItems2.add(closeRemarkItem);
		
		__tecForm = new DynamicForm();
		__tecForm.setItems(__formItems2.toArray(new FormItem[__formItems2.size()]));
		__tecForm.setDataSource(ds);
		__tecForm.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__tecForm);
		isWinningBidItem.setTitleOrientation(TitleOrientation.LEFT);
		closeReasonItem.setColSpan(4);
		isWinningBidItem.setColSpan(1);
		setName("项目关闭信息");
		leftTecLayout.addMember(__tecForm);
		leftLayout.addMember(leftTecLayout);
		
		middleLayout = new VLayout(10);
		middleLayout.setWidth("25%");
		middleLayout.setLayoutLeftMargin(10);
//		allLayout.addMember(middleLayout);
		
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
		employeeGrid.setFilterOnKeypress(true);
		employeeGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
//		middleLayout.addMember(employeeGrid);
		
		rightLayout = new VLayout(10);
		rightLayout.setWidth("50%");
		rightLayout.setHeight100();
		allLayout.addMember(rightLayout);
		
		salePersonGrid = new DelicacyListGrid();
		int a = 0;
		ListGridField[] aFields = new ListGridField[5];
		aFields[a] = new ListGridField("mainProjectEmployeeId");
		aFields[a].setHidden(true);
		a++;
		aFields[a] = new ListGridField("employeeId");
		aFields[a].setHidden(true);
		a++;
		aFields[a] = new ListGridField("employeeNo");
		aFields[a].setWidth("30%");
		a++;
		aFields[a] = new ListGridField("employeeName");
		aFields[a].setWidth("30%");
		a++;
		aFields[a] = new ListGridField("plateId");
		aFields[a].setWidth("40%");
		salePersonGrid.setAutoFitFieldWidths(false);
		salePersonGrid.setDataSource(employeeDs);
		salePersonGrid.setFields(aFields);
		salePersonGrid.setCanRemoveRecords(false);
		salePersonGrid.setHeaderHeight(60);
		salePersonGrid.setHeaderSpans(new HeaderSpan("项目营销专员", new String[] {"employeeNo","employeeName","plateId"}));
		
		salePersonLayout = new HLayout(10);
		salePersonLayout.setWidth100();
		salePersonLayout.setHeight("25%");
//		salePersonLayout.addMember(addToButton1);
		salePersonLayout.addMember(salePersonGrid);
		rightLayout.addMember(salePersonLayout);

		addToButton1.disable();
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
		saleLeaderGrid.setCanRemoveRecords(false);
		saleLeaderGrid.setHeaderHeight(60);
		saleLeaderGrid.setAutoFitFieldWidths(false);
		saleLeaderGrid.setHeaderSpans(new HeaderSpan("运营董事", new String[] {"employeeNo","employeeName","plateId"}));
		
		saleLeaderLayout = new HLayout(10);
		saleLeaderLayout.setWidth100();
		saleLeaderLayout.setHeight("25%");
//		saleLeaderLayout.addMember(addToButton2);
		saleLeaderLayout.addMember(saleLeaderGrid);
		rightLayout.addMember(saleLeaderLayout);
		
		addToButton2.disable();
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
		projectManageGrid.setCanRemoveRecords(false);
		projectManageGrid.setHeaderHeight(60);
		projectManageGrid.setAutoFitFieldWidths(false);
		projectManageGrid.setHeaderSpans(new HeaderSpan("项目经理", new String[] {"employeeNo","employeeName","plateId"}));
		
		projectManageLayout = new HLayout(10);
		projectManageLayout.setWidth100();
		projectManageLayout.setHeight("25%");
//		projectManageLayout.addMember(addToButton3);
		projectManageLayout.addMember(projectManageGrid);
		rightLayout.addMember(projectManageLayout);
		
		addToButton3.disable();
		addToButton3.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				addEmpToGrid(projectManageGrid);
			}
		});
		
		projectLeaderGrid = new DelicacyListGrid();
		int d = 0;
		ListGridField[] dFields = new ListGridField[5];
		dFields[d] = new ListGridField("mainProjectEmployeeId");
		dFields[d].setHidden(true);
		d++;
		dFields[d] = new ListGridField("employeeId");
		dFields[d].setHidden(true);
		d++;
		dFields[d] = new ListGridField("employeeNo");
		dFields[d].setWidth("30%");
		d++;
		dFields[d] = new ListGridField("employeeName");
		dFields[d].setWidth("30%");
		d++;
		dFields[d] = new ListGridField("plateId");
		dFields[d].setWidth("40%");
		projectLeaderGrid.setDataSource(employeeDs);
		projectLeaderGrid.setFields(dFields);
		projectLeaderGrid.setCanRemoveRecords(false);
		projectLeaderGrid.setHeaderHeight(60);
		projectLeaderGrid.setAutoFitFieldWidths(false);
		projectLeaderGrid.setHeaderSpans(new HeaderSpan("项目主管领导", new String[] {"employeeNo","employeeName","plateId"}));
		
		projectLeaderLayout = new HLayout(10);
		projectLeaderLayout.setWidth100();
		projectLeaderLayout.setHeight("25%");
//		projectLeaderLayout.addMember(addToButton4);
		projectLeaderLayout.addMember(projectLeaderGrid);
		rightLayout.addMember(projectLeaderLayout);
		
		addToButton4.disable();
		addToButton4.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				addEmpToGrid(projectLeaderGrid);
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
			String str = record.getAttribute("bidRankingType");
			if(!ClientUtil.isNullOrEmpty(str)){
				String[] value = str.split(",");
				bidRankingTypeItem.setValues(value);
			}
			Map<String,Object> map = new HashMap<>();
			map.put("optType", "loadDataForUpdateInfo");
			map.put("preProjectId", record.getAttribute("preProjectId"));
			DBDataSource.callOperation("EP_PreProjectProcess", map, new DSCallback() {
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					if(dsResponse.getStatus() >= 0){
						if(!BaseHelpUtils.isNullOrEmpty(dsResponse.getAttribute("userData"))){
							@SuppressWarnings("unchecked")
							Map<String,List<Record>> getEmpMap = dsResponse.getAttributeAsMap("userData");
							List<Record> salePersonMap = getEmpMap.get("salePerson");
							Record[] salePerson = new Record[salePersonMap.size()];
							int index1 = 0;
							for(Record a : salePersonMap){
								salePerson[index1] = a;
								index1++;
							}
							salePersonGrid.setData(salePerson);
							
							List<Record> saleLeaderMap = getEmpMap.get("saleLeader");
							Record[] saleLeader = new Record[saleLeaderMap.size()];
							int index2 = 0;
							for(Record b : saleLeaderMap){
								saleLeader[index2] = b;
								index2++;
							}
							saleLeaderGrid.setData(saleLeader);
							
							List<Record> projectManageMap = getEmpMap.get("projectManage");
							Record[] projectManage = new Record[projectManageMap.size()];
							int index3 = 0;
							for(Record c : projectManageMap){
								projectManage[index3] = c;
								index3++;
							}
							projectManageGrid.setData(projectManage);
							
							List<Record> projectLeaderMap = getEmpMap.get("projectLeader");
							Record[] projectLeader = new Record[projectLeaderMap.size()];
							int index4 = 0;
							for(Record d : projectLeaderMap){
								projectLeader[index4] = d ;
								index4++;
							}
							projectLeaderGrid.setData(projectLeader);
							
							employeeGrid.setData(dsResponse.getData());
						}
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
		if(!__tecForm.validate()){
			SC.say("请按系统提示修改信息");
			return false;
		}else if(!__detailForm.validate()){
			SC.say("请按系统提示修改信息");
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
		String[] arr = bidRankingTypeItem.getValues();
		if(null != arr && arr.length > 0){
			StringBuilder sb = new StringBuilder();
			for(String str : arr){
				if(sb.length() > 0){
					sb.append(",");
				}
				sb.append(str);
			}
			saveMap.put("bidRankingType", sb.toString());
		}
		MapUtils.convertRecordToMap(DSEmployee.getInstance(),salePersonGrid.getRecords(),saveMap,"salePersonReocrd");
		MapUtils.convertRecordToMap(DSEmployee.getInstance(),saleLeaderGrid.getRecords(),saveMap,"saleLeaderReocrd");
		MapUtils.convertRecordToMap(DSEmployee.getInstance(),projectManageGrid.getRecords(),saveMap,"projectManageReocrd");
		MapUtils.convertRecordToMap(DSEmployee.getInstance(),projectLeaderGrid.getRecords(),saveMap,"projectLeaderReocrd");
		return saveMap;
	}

}
