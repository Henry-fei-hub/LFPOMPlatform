package com.pomplatform.client.ja.ht.form;

import java.util.ArrayList;
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
import com.pomplatform.client.preprojects.datasource.DSprojectPreInfomations;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.TransferImgButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.BooleanItem;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.RadioGroupItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
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

public class EditMainProjectEmployeeInfoUpdate extends AbstractWizadPage {
	private static final Logger __logger = Logger.getLogger("");
//	private final SelectItem projectLevelItem;
//	private final SelectItem signCompanyItem;
//	private final SelectItem designQualificationItem;
//	private final SelectItem projectBaseOnItem;
//	private final DateItem projectApprovalTimeItem;
//	private final SelectItem designTeamItem;
//	private final TextItem designCooperationNameItem;
//	private final RadioGroupItem isHighRiseBuildingItem;
//	private final TextItem architecturaldesignUnitsItem;
//	
//	private final TextItem projectTotalInvestmentItem;
//	private final TextItem totalBuildingAreasItem;
//	private final TextItem fireResistanceRatingItem;
//	private final TextItem estimateTheDesignAreasItem;
//	private final TextItem actualDesignAreasItem;
//	private final TextItem buildingHeightItem;
//	private final TextItem buildingFloorsItem;
//	private final TextItem decorateMoneyControlItem;
//	private final SelectItem projectSalesTeamItem;
	
//	private DynamicForm __detailForm = new DynamicForm();
//	private DynamicForm __tecForm = new DynamicForm();
	private List<FormItem> __formItems2 = new ArrayList<>();;
	private DelicacyListGrid specialtyGrid;
	private DelicacyListGrid employeeGrid;
	private DelicacyListGrid salePersonGrid;
	private DelicacyListGrid projectManageGrid;
	private DelicacyListGrid projectType16Grid;
	private DelicacyListGrid projectResponsibleGrid;
	
	private HLayout allLayout;
	private VLayout rightLayout;
	
	private VLayout middleLayout;
	private HLayout salePersonLayout;
	private HLayout saleLeaderLayout;
	private HLayout projectManageLayout;
	private HLayout projectResponsibleLayout;
	private HLayout projectLeaderLayout;
	private HLayout projectType16Layout;
	private HLayout specialtyLayout;
	
	private TransferImgButton addToButton1 = new TransferImgButton(TransferImgButton.RIGHT);
	private TransferImgButton addToButton2 = new TransferImgButton(TransferImgButton.RIGHT);
	private TransferImgButton addToButton3 = new TransferImgButton(TransferImgButton.RIGHT);
	private TransferImgButton addToButton4 = new TransferImgButton(TransferImgButton.RIGHT);
	private TransferImgButton addToButton5 = new TransferImgButton(TransferImgButton.RIGHT);
	private TransferImgButton addToButton6 = new TransferImgButton(TransferImgButton.RIGHT);
	
	public static Label detailTitle;
	public static Label tecTitle;
	
	public EditMainProjectEmployeeInfoUpdate() {
		
		allLayout = new HLayout(10);
		allLayout.setWidth100();
		allLayout.setHeight100();
		
		middleLayout = new VLayout(10);
		middleLayout.setWidth("25%");
		middleLayout.setLayoutLeftMargin(10);
		allLayout.addMember(middleLayout);
		
		Criteria criteria = new Criteria();
		criteria.addCriteria("status", 0);
		
		ComboBoxItem employeeNameItem = new ComboBoxItem("employeeName","职员名称");
//		employeeNameItem.setValueMap(KeyValueManager.getValueMap("employee_names"));
		KeyValueManager.loadValueMap("employee_names",employeeNameItem);

		employeeNameItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		
		employeeGrid = new DelicacyListGrid();
		DSEmployee employeeDs = DSEmployee.getInstance();
		int eIndex = 0;
		ListGridField[] eFields = new ListGridField[4];
		eFields[eIndex] = new ListGridField("employeeId");
		eFields[eIndex].setHidden(true);
		eIndex++;
		eFields[eIndex] = new ListGridField("employeeNo");
		eFields[eIndex].setFilterOnKeypress(true);
		eFields[eIndex].setWidth("30%");
		eIndex++;
		eFields[eIndex] = new ListGridField("employeeName");
		eFields[eIndex].setEditorProperties(employeeNameItem);
//		eFields[eIndex].setFilterEditorValueMap(KeyValueManager.getValueMap("employee_names"));
		KeyValueManager.loadValueMap("employee_names",eFields[eIndex]);
		eFields[eIndex].setWidth("30%");
		eIndex++;
		eFields[eIndex] = new ListGridField("plateId");
		eFields[eIndex].setWidth("40%");
		employeeGrid.setDataSource(employeeDs);
		employeeGrid.setFields(eFields);
		employeeGrid.setShowFilterEditor(true);
		employeeGrid.filterData(criteria);
		employeeGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		middleLayout.addMember(employeeGrid);
		
		rightLayout = new VLayout(10);
		rightLayout.setWidth("35%%");
		rightLayout.setHeight100();
		allLayout.addMember(rightLayout);
		
		
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
		specialtyGrid.setHeaderSpans(new HeaderSpan("项目参与专业", new String[] {"specialtyId","registrationSealEmployeeId","isOutsourcing"}));
		specialtyLayout = new HLayout(10);
		specialtyLayout.setWidth100();
		specialtyLayout.setHeight("20%");
		specialtyLayout.addMember(addToButton6);
		specialtyLayout.addMember(specialtyGrid);
		rightLayout.addMember(specialtyLayout);
		
		addToButton6.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				specialtyGrid.startEditingNew();
			}
		});
		
		salePersonGrid = new DelicacyListGrid();
		int a = 0;
		ListGridField[] aFields = new ListGridField[5];
		aFields[a] = new ListGridField("mainProjectEmployeeId");
		aFields[a].setHidden(true);
		a++;
		aFields[a] = new ListGridField("employeeId");
		aFields[a].setValueMap(KeyValueManager.getValueMap("employees"));
		aFields[a].setWidth("20%");
		a++;
		aFields[a] = new ListGridField("employeeNo");
		aFields[a].setWidth("20%");
		a++;
		aFields[a] = new ListGridField("employeeName");
		aFields[a].setHidden(true);
		a++;
		aFields[a] = new ListGridField("plateId");
		aFields[a].setWidth("30%");
		a++;
		aFields[a] = new ListGridField("mainAndAssistance","主要/协助跟进人");
		aFields[a].setWidth("30%");
		aFields[a].setCanEdit(true);
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
		SelectItem mainAndAssistanceItem = new SelectItem("mainAndAssistance");
		aFields[a].setEditorProperties(mainAndAssistanceItem);
		aFields[a].setValueMap(KeyValueManager.getValueMap("system_dictionary_163"));
		salePersonGrid.setDataSource(employeeDs);
		salePersonGrid.setFields(aFields);
		salePersonGrid.setCanRemoveRecords(true);
		salePersonGrid.setHeaderHeight(60);
		salePersonGrid.setHeaderSpans(new HeaderSpan("项目秘书", new String[] {"employeeNo","employeeId","plateId","mainAndAssistance"}));
		
		salePersonLayout = new HLayout(10);
		salePersonLayout.setWidth100();
		salePersonLayout.setHeight("20%");
		salePersonLayout.addMember(addToButton1);
		salePersonLayout.addMember(salePersonGrid);
		rightLayout.addMember(salePersonLayout);

		addToButton1.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				addEmpToGrid(salePersonGrid);
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
		projectManageGrid.setHeaderSpans(new HeaderSpan("项目经理", new String[] {"employeeNo","employeeName","plateId"}));
		
		projectManageLayout = new HLayout(10);
		projectManageLayout.setWidth100();
		projectManageLayout.setHeight("20%");
		projectManageLayout.addMember(addToButton3);
		projectManageLayout.addMember(projectManageGrid);
		rightLayout.addMember(projectManageLayout);
		
		addToButton3.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				addEmpToGrid(projectManageGrid);
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
		projectResponsibleGrid.setHeaderSpans(new HeaderSpan("项目负责人", new String[] {"employeeNo","employeeId","plateId"}));

		projectResponsibleLayout = new HLayout(10);
		projectResponsibleLayout.setWidth100();
		projectResponsibleLayout.setHeight("20%");
		projectResponsibleLayout.addMember(addToButton4);
		projectResponsibleLayout.addMember(projectResponsibleGrid);
		rightLayout.addMember(projectResponsibleLayout);

		addToButton4.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				addEmpToGrid(projectResponsibleGrid);
			}
		});
		
		
		//管理人员
		projectType16Grid = new DelicacyListGrid();
		int j = 0;
		ListGridField[] jFields = new ListGridField[8];
		jFields[j] = new ListGridField("projectId");
		jFields[j].setHidden(true);
		j++;
		jFields[j] = new ListGridField("contractCode","订单编号");
		jFields[j].setHidden(false);
		j++;
		jFields[j] = new ListGridField("projectName","订单名称");
		jFields[j].setHidden(false);
		j++;
		jFields[j] = new ListGridField("employeeNo", "职员编号");
		jFields[j].setWidth("25%");
		j++;
		jFields[j] = new ListGridField("projectManageId", "职员名称");
		jFields[j].setValueMap(KeyValueManager.getValueMap("employees"));
		jFields[j].setWidth("25%");
		jFields[j].setCanEdit(false);
		j++;
		jFields[j] = new ListGridField("employeeName");
		jFields[j].setHidden(true);
		j++;
		jFields[j] = new ListGridField("plateId", "业务部门");
		jFields[j].setWidth("25%");
		jFields[j].setValueMap(KeyValueManager.getValueMap("plate_records"));
//		projectType16Grid.setDataSource(employeeDs);
		projectType16Grid.setFields(jFields);
		projectType16Grid.setCanRemoveRecords(false);
		projectType16Grid.setHeaderHeight(60);
		projectType16Grid.setAutoFitFieldWidths(true);
		projectType16Grid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		projectType16Grid
				.setHeaderSpans(new HeaderSpan("管理人员", new String[] {"projectId","contractCode","projectName","employeeNo", "projectManageId", "plateId"}));

		projectType16Layout = new HLayout(10);
		projectType16Layout.setWidth100();
		projectType16Layout.setHeight("20%");
		projectType16Layout.addMember(addToButton5);
		projectType16Layout.addMember(projectType16Grid);
		rightLayout.addMember(projectType16Layout);

		addToButton5.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				addEmpToGrid2(projectType16Grid);
			}
		});
		
		addMember(allLayout);
	}

	@Override
	public void startEdit() {
		if (getRecord() != null) {
			Record record = getRecord();
			
			Map<String,Object> map = new HashMap<>();
			if(BaseHelpUtils.getIntValue(record.getAttribute("mainProjectId"))>0) {
				map.put("mainProjectId", record.getAttribute("mainProjectId"));
				DBDataSource.callOperation("ST_MainProjectSpecialty", "find", map, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0){
							specialtyGrid.setData(dsResponse.getData());
						}
					}
				});
				map.put("relation", 1);//项目秘书
				DBDataSource.callOperation("NQ_SearchMainProjectEmployeeData", map, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0){
							salePersonGrid.setData(dsResponse.getData());
						}
					}
				});
				
				map.put("relation", 3);//项目经理
				DBDataSource.callOperation("NQ_SearchMainProjectEmployeeData", map, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0){
							projectManageGrid.setData(dsResponse.getData());
						}
					}
				});
				
				map.put("relation", 5);//专业负责人
				DBDataSource.callOperation("NQ_SearchMainProjectEmployeeData", map, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0){
							projectResponsibleGrid.setData(dsResponse.getData());
						}
					}
				});
			}
			
			//管理订单的管理人员
			if(!BaseHelpUtils.isNullOrEmpty(record.getAttribute("projectCode"))) {
				map.put("projectCode", record.getAttribute("projectCode"));
				DBDataSource.callOperation("NQ_SearchProjectType16Data", map, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0){
							projectType16Grid.setData(dsResponse.getData());
						}
					}
				});
			}
			
			map = new HashMap<>();
			map.put("optType", "loadDataForAddInfo");
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
	
	/**
	 * 将选中人员添加到对应的grid中
	 * @param targetGrid
	 */
	private void addEmpToGrid2(DelicacyListGrid targetGrid) {
		ListGridRecord selectedRecord = employeeGrid.getSelectedRecord();
		ListGridRecord[] addRecords = targetGrid.getSelectedRecords();
		if(BaseHelpUtils.isNullOrEmpty(selectedRecord)) {
			SC.say("提示","请从左侧勾选一个成员！");
			return ;
		}
		
		if(BaseHelpUtils.isNullOrEmpty(addRecords)||addRecords.length<=0) {
			SC.say("提示","请从右侧勾选至少一个订单！");
			return ;
		}
		
		ListGridRecord[] removeRecords = new ListGridRecord[addRecords.length];
		removeRecords = addRecords;
		for (ListGridRecord listGridRecord : addRecords) {
			listGridRecord.setAttribute("projectManageId", selectedRecord.getAttribute("employeeId"));
			listGridRecord.setAttribute("employeeNo", selectedRecord.getAttribute("employeeNo"));
			listGridRecord.setAttribute("employeeName", selectedRecord.getAttribute("employeeName"));
			listGridRecord.setAttribute("plateId", selectedRecord.getAttribute("plateId"));
		}
		
		for (ListGridRecord listGridRecord : removeRecords) {
			targetGrid.removeData(listGridRecord);
		}
		
		for (ListGridRecord listGridRecord : removeRecords) {
			targetGrid.addData(listGridRecord);
		}
		
		targetGrid.redraw();
		targetGrid.deselectAllRecords();
		
	}
	
	
	@Override
	public boolean checkData() {
		if (specialtyGrid.getRecords().length > 0) {
			Map<String, Object> maps = new HashMap<>();
			int registrationSealEmployeeId = 0;
			int specialtyId = 0;
			for (int i = 0; i < specialtyGrid.getRecords().length; i++) {
				maps = specialtyGrid.getRecords()[i].toMap();
				specialtyId = BaseHelpUtils.getIntValue(maps.get("specialtyId"));
				registrationSealEmployeeId = BaseHelpUtils.getIntValue(maps.get("registrationSealEmployeeId"));
				if (specialtyId <= 0) {
					SC.say("提示","参与专业不能为空");
					return false;
				}
			}
		}
		return true;
		
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
	}

	@Override
	public java.util.Map getValuesAsMap() {
		Map<String,Object> saveMap =new HashMap<String, Object>();
		MapUtils.convertRecordToMap(salePersonGrid,salePersonGrid.getRecords(),saveMap,"salePersonReocrd");
		MapUtils.convertRecordToMap(DSEmployee.getInstance(),projectManageGrid.getRecords(),saveMap,"projectManageReocrd");
		MapUtils.convertRecordToMap(projectType16Grid,projectType16Grid.getRecords(),saveMap,"projectType16Record");
		MapUtils.convertRecordToMap(projectResponsibleGrid,projectResponsibleGrid.getRecords(),saveMap,"projectResponsibleRecord");
		MapUtils.convertRecordToMap(specialtyGrid,specialtyGrid.getRecords(),saveMap,"specialtyReocrd");
		return saveMap;
	}

}
