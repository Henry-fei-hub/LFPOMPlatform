package com.pomplatform.client.preprojects.panel;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.data.RoleDefinition;
import com.pomplatform.client.employeerescord.datasource.DSEmployee;
import com.pomplatform.client.operation.datasource.DSProjectManager;
import com.pomplatform.client.preprojects.datasource.DSprojectPreInfomations;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.TransferImgButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PreProjectBasicInformationNew extends AbstractWizadPage {
	private static final Logger __logger = Logger.getLogger("");
	private final TextItem infoCodeItem;
	private final TextItem projectNameItem;
	private final TextItem projectEnglishNameItem;
	private final SelectItem projectStatusItem;
	private final SelectItem designStatusItem;
	private final SelectItem projectOriginationItem;
	private final TextAreaItem projectOriginationRemarkItem;
	private final SelectItem provinceItem;
	private final SelectItem cityItem;
	private final TextItem detailAddressItem;
	private final DateItem infoRegisterTimeItem;
	private final TextItem customerNameItem;
	private final TextItem customerAddressItem;
	private final SelectItem projectSalesTeamItem;
	
	private DynamicForm __basicForm = new DynamicForm();
	private DelicacyListGrid employeeGrid;
	private DelicacyListGrid salePersonGrid;
	private DelicacyListGrid saleLeaderGrid;
	private DelicacyListGrid projectManageGrid;
	private DelicacyListGrid projectLeaderGrid;
	
	private HLayout allLayout;
	private HLayout leftLayout;
	private VLayout middleLayout;
	private VLayout rightLayout;
	private HLayout salePersonLayout;
	private HLayout saleLeaderLayout;
	private HLayout projectManageLayout;
	private HLayout projectLeaderLayout;
	
	private TransferImgButton addToButton1 = new TransferImgButton(TransferImgButton.RIGHT);
	private TransferImgButton addToButton2 = new TransferImgButton(TransferImgButton.RIGHT);
	private TransferImgButton addToButton3 = new TransferImgButton(TransferImgButton.RIGHT);
	private TransferImgButton addToButton4 = new TransferImgButton(TransferImgButton.RIGHT);
	
	public PreProjectBasicInformationNew() {
		
		allLayout = new HLayout(10);
		allLayout.setWidth100();
		allLayout.setHeight100();
		
		leftLayout = new HLayout(10);
		leftLayout.setWidth("40%");
		leftLayout.setHeight100();
		leftLayout.setLayoutRightMargin(10);
		leftLayout.setShowResizeBar(true);
		allLayout.addMember(leftLayout);
		
		infoCodeItem = new TextItem("infoCode", "信息编号");
		infoCodeItem.setWidth("*");
		infoCodeItem.setCanEdit(false);
		
		projectStatusItem = new SelectItem("projectStatus", "项目状态");
		projectStatusItem.setWidth("*");
		projectStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_144"));
		
		projectNameItem = new TextItem("projectName", "项目名称");
		projectNameItem.setWidth("*");
		
		projectEnglishNameItem = new TextItem("projectEnglishName", "项目英文名称");
		projectEnglishNameItem.setWidth("*");
		
		customerNameItem = new TextItem("customerName", "客户名称");
		customerNameItem.setWidth("*");
		
		customerAddressItem = new TextItem("customerAddress", "客户地址");
		customerAddressItem.setWidth("*");

		designStatusItem = new SelectItem("designStatus", "设计状态");
		designStatusItem.setWidth("*");
		designStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_145"));
		
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
						}
					}
				});
			}
		});
		
		cityItem = new SelectItem("city", "项目地址（市）");
		cityItem.setWidth("*");
		cityItem.setValueMap(new LinkedHashMap<>());
		
		detailAddressItem = new TextItem("detailAddress", "项目详细地址");
		detailAddressItem.setWidth("*");
		
		projectSalesTeamItem = new SelectItem("projectSalesTeam", "项目营销团队");
		projectSalesTeamItem.setWidth("*");
//		projectSalesTeamItem.setValueMap(KeyValueManager.getValueMap("plate_str"));
		KeyValueManager.loadValueMap("plate_str", projectSalesTeamItem);

		projectOriginationItem = new SelectItem("projectOrigination", "项目来源渠道");
		projectOriginationItem.setWidth("*");
		projectOriginationItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_146"));
		
		infoRegisterTimeItem = new DateItem("infoRegisterTime", "信息登记时间");
		infoRegisterTimeItem.setWidth("*");
		infoRegisterTimeItem.setUseTextField(true);
		infoRegisterTimeItem.setDefaultValue(new Date());
		infoRegisterTimeItem.setCanEdit(false);
		
		projectOriginationRemarkItem = new TextAreaItem("projectOriginationRemark", "来源渠道说明");
		projectOriginationRemarkItem.setWidth("*");
		projectOriginationRemarkItem.setColSpan(4);
		projectOriginationRemarkItem.setRowSpan(3);

		DSprojectPreInfomations ds = DSprojectPreInfomations.getInstance();
		__basicForm.setItems(infoCodeItem,projectStatusItem,projectNameItem,projectEnglishNameItem,designStatusItem,projectSalesTeamItem,customerNameItem,customerAddressItem,provinceItem,cityItem,detailAddressItem,projectOriginationItem,infoRegisterTimeItem,projectOriginationRemarkItem);
		__basicForm.setDataSource(ds);
		__basicForm.setNumCols(4);
		__basicForm.setWidth("40%");
		ClientUtil.DynamicFormProcessAccordingToDevice(__basicForm);
		projectNameItem.setColSpan(4);
		projectEnglishNameItem.setColSpan(4);
		customerNameItem.setColSpan(4);
		customerAddressItem.setColSpan(4);
		detailAddressItem.setColSpan(4);
		setName("基本信息");
		leftLayout.addMember(__basicForm);
		
		middleLayout = new VLayout(10);
		middleLayout.setWidth("25%");
		middleLayout.setLayoutLeftMargin(10);
		allLayout.addMember(middleLayout);
		
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
		middleLayout.addMember(employeeGrid);
		
		rightLayout = new VLayout(10);
		rightLayout.setWidth("35%%");
		rightLayout.setHeight100();
		allLayout.addMember(rightLayout);
		
		salePersonGrid = new DelicacyListGrid();
		int a = 0;
		ListGridField[] aFields = new ListGridField[4];
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
		salePersonGrid.setDataSource(employeeDs);
		salePersonGrid.setFields(aFields);
		salePersonGrid.setCanRemoveRecords(true);
		salePersonGrid.setHeaderHeight(60);
		salePersonGrid.setHeaderSpans(new HeaderSpan("项目营销专员", new String[] {"employeeNo","employeeName","plateId"}));
		
		salePersonLayout = new HLayout(10);
		salePersonLayout.setWidth100();
		salePersonLayout.setHeight("25%");
		salePersonLayout.addMember(addToButton1);
		salePersonLayout.addMember(salePersonGrid);
		rightLayout.addMember(salePersonLayout);

		addToButton1.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				addEmpToGrid(salePersonGrid);
			}
		});

		saleLeaderGrid = new DelicacyListGrid();
		int b = 0;
		ListGridField[] bFields = new ListGridField[4];
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
		saleLeaderGrid.setHeaderSpans(new HeaderSpan("运营董事", new String[] {"employeeNo","employeeName","plateId"}));
		
		saleLeaderLayout = new HLayout(10);
		saleLeaderLayout.setWidth100();
		saleLeaderLayout.setHeight("25%");
		saleLeaderLayout.addMember(addToButton2);
		saleLeaderLayout.addMember(saleLeaderGrid);
		rightLayout.addMember(saleLeaderLayout);
		
		addToButton2.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				addEmpToGrid(saleLeaderGrid);
			}
		});
		
		projectManageGrid = new DelicacyListGrid();
		int c = 0;
		ListGridField[] cFields = new ListGridField[4];
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
		projectManageLayout.setHeight("25%");
		projectManageLayout.addMember(addToButton3);
		projectManageLayout.addMember(projectManageGrid);
		rightLayout.addMember(projectManageLayout);
		
		addToButton3.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				addEmpToGrid(projectManageGrid);
			}
		});
		
		projectLeaderGrid = new DelicacyListGrid();
		int d = 0;
		ListGridField[] dFields = new ListGridField[4];
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
		projectLeaderGrid.setCanRemoveRecords(true);
		projectLeaderGrid.setHeaderHeight(60);
		projectLeaderGrid.setHeaderSpans(new HeaderSpan("项目主管领导", new String[] {"employeeNo","employeeName","plateId"}));
		
		projectLeaderLayout = new HLayout(10);
		projectLeaderLayout.setWidth100();
		projectLeaderLayout.setHeight("25%");
		projectLeaderLayout.addMember(addToButton4);
		projectLeaderLayout.addMember(projectLeaderGrid);
		rightLayout.addMember(projectLeaderLayout);
		
		addToButton4.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				addEmpToGrid(projectLeaderGrid);
			}
		});
		
		addMember(allLayout);
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
	public void startEdit() {
		Map<String,Object> map = new HashMap<>();
		map.put("optType", "loadDataForAddInfo");
		DBDataSource.callOperation("EP_PreProjectProcess", map, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					employeeGrid.setData(dsResponse.getData());
					Map<String,String> userData = dsResponse.getAttributeAsMap("userData");
					String infoCode = userData.get("infoCode");
					infoCodeItem.setValue(infoCode);
				}
			}
		});
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
		Map<String,Object> saveMap = __basicForm.getValues();
		saveMap.put("optType", "saveDataForAddInfo");
		MapUtils.convertRecordToMap(DSEmployee.getInstance(),salePersonGrid.getRecords(),saveMap,"salePersonReocrd");
		MapUtils.convertRecordToMap(DSEmployee.getInstance(),saleLeaderGrid.getRecords(),saveMap,"saleLeaderReocrd");
		MapUtils.convertRecordToMap(DSEmployee.getInstance(),projectManageGrid.getRecords(),saveMap,"projectManageReocrd");
		MapUtils.convertRecordToMap(DSEmployee.getInstance(),projectLeaderGrid.getRecords(),saveMap,"projectLeaderReocrd");
		return saveMap;
	}

}
