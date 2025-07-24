package com.pomplatform.client.contract.form;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.contract.datasource.DSTeamMembers;
import com.pomplatform.client.employeerescord.datasource.DSEmployee;
import com.smartgwt.client.data.*;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.util.ValueCallback;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.TransferImgButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class TeamBuildingForm extends VLayout{
	private static final Logger __logger = Logger.getLogger("");
	private final DelicacyListGrid grid = new DelicacyListGrid();
	private final DelicacyListGrid SourceGrid = new DelicacyListGrid();
	private final IButton searchButton = new IButton("搜索");
	private final IButton resetButton = new IButton("重置");
	Map<String,Object> result = new HashMap<>();
	Map<String,Object> removeEmployeeGradeId = new HashMap<>();
	private final TeamBuildingSearchForm __searchForm = new TeamBuildingSearchForm();
	private final DynamicForm form = new DynamicForm();
	private final DynamicForm form2 = new DynamicForm();
	private HLayout mainLayout;
	private VLayout vLayout1;
	private VLayout vLayout2;
	private VLayout vLayout3;
	private VLayout vLayout4;
	private HLayout hLayout1;
	private HLayout hLayout2;
	private HLayout hLayout3;
	private HLayout searchFormVlayout;
	private HLayout buttonVlayout;
	private VLayout girldVlayout;
	private TextItem orderIdItem;
    private TextItem projectNameItem;
    private TextItem projectIntegralItem;
    private TextItem departmentRateItem;
    private ListGridField employeeIdField;
    private ListGridField employeeNameField;
    private ListGridField rateField;
    private String oldValue = null;
    private int countPercent = 0;
	
	public void initComponents(Map<String, Object> params){
		setWidth100();
		setHeight100();
		mainLayout = new HLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		
		//左边的员工选择的框
		vLayout1 = new VLayout();
		vLayout1.setWidth("40%");
		vLayout1.setHeight100();
		mainLayout.addMember(vLayout1);
		
		hLayout1 = new HLayout();
		hLayout1.setWidth("95%");
		hLayout1.setHeight("10%");
//		hLayout1.setLayoutTopMargin(20);
		hLayout1.setLayoutLeftMargin(80);
		vLayout1.addMember(hLayout1);
		
		searchFormVlayout = new HLayout();
		searchFormVlayout.setWidth("100%");
		searchFormVlayout.setHeight("10%");
		searchFormVlayout.setAlign(Alignment.CENTER);
		ClientUtil.searchFormProcessAccordingToDevice(__searchForm);
		__searchForm.setHeight(90);
		searchFormVlayout.addMember(__searchForm);
		hLayout1.addMember(searchFormVlayout);
		
		buttonVlayout = new HLayout();
		buttonVlayout.setWidth("30%");
		buttonVlayout.setHeight("95%");
		searchButton.setIcon("[SKIN]/actions/search.png");
		searchButton.setWidth(80);
		buttonVlayout.setHeight100();
		buttonVlayout.setLayoutTopMargin(20);
		buttonVlayout.addMember(searchButton);
		searchButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Criteria condition = __searchForm.getValuesAsCriteria();
				SC.debugger();
				reloadSource(SourceGrid, condition);
			}
		});
		resetButton.setIcon("[SKIN]/actions/redo.png");
		resetButton.setWidth(80);
		buttonVlayout.addMember(resetButton);
		resetButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				__searchForm.editNewRecord();
			}
		});
		hLayout1.addMember(buttonVlayout);
		
		girldVlayout = new VLayout();	
		girldVlayout.setWidth("100%");
		girldVlayout.setHeight("90%");
		SourceGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		SourceGrid.setDataSource(DSTeamMembers.getInstance());
		girldVlayout.addMember(SourceGrid);
		girldVlayout.setLayoutLeftMargin(30);
		girldVlayout.setLayoutBottomMargin(30);
		vLayout1.addMember(girldVlayout);
			
		//中间的选择的按钮		
		vLayout2 = new VLayout();
//		vLayout2.setWidth("10%");
//		vLayout2.setHeight100();】
		vLayout2.setHeight100();
		vLayout2.setWidth(60);
		vLayout2.setLayoutTopMargin(300);
		vLayout2.setLayoutLeftMargin(15);
		vLayout2.setLayoutRightMargin(5);
		vLayout2.setMembersMargin(10);
		TransferImgButton AddToButton = new TransferImgButton(TransferImgButton.RIGHT);
		vLayout2.addMember(AddToButton);
		mainLayout.addMember(vLayout2);
		AddToButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!SourceGrid.anySelected()) {
                    SC.say("请选择团队成员");;
                }
                addSelectedDataToTarget(SourceGrid, grid);
			}
		});
		
		
		//右边显示组建团队的成员
		vLayout3 = new VLayout();
		vLayout3.setWidth("40%");
		vLayout3.setHeight100();
		mainLayout.addMember(vLayout3);
		
		HLayout hLayout2 = new HLayout();
		hLayout2.setWidth("96%");
		hLayout2.setHeight("10%");
		hLayout2.setLayoutTopMargin(30);
		vLayout3.addMember(hLayout2);
		
		orderIdItem = new TextItem("contractId","合同Id");
		orderIdItem.setWidth(50);
		orderIdItem.setValue(params.get("contractId"));
		orderIdItem.setCanEdit(false);
		orderIdItem.setHidden(true);
        
		projectNameItem = new TextItem("projectNameItem","订单名称");
		projectNameItem.setWidth(400);
        projectNameItem.setValue(params.get("contractName"));
		projectNameItem.setCanEdit(false);
        
        projectIntegralItem = new TextItem("projectIntegralItem","项目积分");
        projectIntegralItem.setWidth(66);
        projectIntegralItem.setValue(params.get("amount"));
        projectIntegralItem.setCanEdit(false);
        projectIntegralItem.setHidden(true);
//        projectIntegralItem = BaseHelpUtils.getBigDecimalValue(projectIntegralItem.getValue());
        form.setNumCols(8);
        form.setWidth100();
        form.setHeight100();
        form.setItems(orderIdItem,projectNameItem,projectIntegralItem);
        projectNameItem.setColSpan(3);
        hLayout2.addMember(form);
        
        vLayout4 = new VLayout();
        vLayout4.setWidth("96%");
        vLayout4.setHeight("70%");
        vLayout4.setLayoutTopMargin(20);
        
        employeeIdField = new ListGridField("employeeId","员工姓名");
        employeeIdField.setRequired(true);
        employeeIdField.setHidden(false);
        employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));
        
        employeeNameField = new ListGridField("employeeName","员工姓名");
        employeeNameField.setRequired(true);
        employeeNameField.setHidden(true);
        
        rateField = new ListGridField("rate","所占比例(%)");
        rateField.setRequired(false);
        rateField.setHidden(false);
        vLayout3.addMember(vLayout4);
        
        grid.setCanReorderRecords(true);
        grid.setAutoFitFieldWidths(false);
        grid.setShowGridSummary(false);
        grid.setShowRowNumbers(true);
        grid.setCanRemoveRecords(true);
        grid.setDataSource(DSEmployee.getInstance());
        grid.setFields(employeeIdField,employeeNameField,rateField);
        vLayout4.addMember(grid);
        
        hLayout2 = new HLayout();
        hLayout2.setWidth("96%");
        hLayout2.setHeight("10%");
        vLayout3.addMember(hLayout2);
        departmentRateItem = new TextItem("departmentRate","部门预留(%)");
        departmentRateItem.setWidth("*");
        form2.setWidth100();
        form2.setHeight100();
        form2.setItems(departmentRateItem);
        hLayout2.addMember(form2);
        hLayout2.setAlign(Alignment.LEFT);
        hLayout2.setLayoutTopMargin(30);
        
        hLayout3 = new HLayout();
        hLayout3.setWidth("10%");
        hLayout3.setHeight("10%");
        vLayout3.addMember(hLayout3);
        Button saveButton = new Button("保存");
        saveButton.setWidth(66);
        hLayout3.addMember(saveButton);
        hLayout3.setLayoutLeftMargin(300);
        saveButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				int temRate = 0;
				ListGridRecord[] gridData = grid.getRecords();
				Integer contractId = BaseHelpUtils.getIntValue(form.getValueAsString("contractId"));
				int departmentRate = BaseHelpUtils.getIntValue(form2.getValue("departmentRate"));
				Map<String, Object> conditions = new HashMap<>();
				List<Map<String, Object>> list = new ArrayList<>();
				for (ListGridRecord listGridRecord : gridData) {
					Map<String, Object> params = new HashMap<>();
					params.put("employeeId", listGridRecord.getAttributeAsInt("employeeId"));
					params.put("rate", listGridRecord.getAttributeAsInt("rate"));
					temRate = temRate + listGridRecord.getAttributeAsInt("rate");
					list.add(params);
				}
				SC.debugger();
				int temRate1 = BaseHelpUtils.getIntValue(form2.getValue("departmentRate"));
				temRate = temRate + temRate1;
				__logger.info("6656666666"+temRate);
				if (temRate != 100) {
					SC.say("分配比例不为100%");
					return;
				}
				if (!BaseHelpUtils.isNullOrEmpty(departmentRate)) {
					conditions.put("departmentRate", departmentRate);
					conditions.put("contractId", contractId);
				}
				conditions.put("optType", "teamBuilding");
				conditions.put("list", list);
				DBDataSource.callOperation("EP_NewContractDistributionProcess", conditions, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						SC.debugger();
						if (dsResponse.getStatus() > 0) {
							SC.say("保存成功");
							//保存成功后在contractDistribution表中保存一个已经分配团队的表示
//							//分配积分
//							Map<String, Object> params = new HashMap<>();
//							params.put("optType", "settlementPercentage");
//							params.put("tempData", "1");
//							DBDataSource.callOperation("EP_NewContractDistributionProcess", params, new DSCallback() {
//								@Override
//								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//								}
//							});
						}else if (dsResponse.getStatus() < 0) {
							SC.say("保存失败");
						}else {
							SC.say("该订单已经组建团队!");
						}
						
					}
				});
				
			}
		});
		addMember(mainLayout);
		
		 grid.addDoubleClickHandler(new DoubleClickHandler() {
				@Override
				public void onDoubleClick(DoubleClickEvent event) {
					ListGridRecord selected = grid.getSelectedRecord();
					ListGridRecord[] gridData = grid.getRecords();
					SC.debugger();
					oldValue = "";
					Map<String,Object> params = new HashMap<>();
					if(!BaseHelpUtils.isNullOrEmpty(selected)){
						countPercent = 0;
						for(ListGridRecord e : gridData){
							countPercent += BaseHelpUtils.getIntValue(e.getAttribute("rate"));
						}
						if(!BaseHelpUtils.isNullOrEmpty(selected.getAttribute("rate"))){
							countPercent = countPercent - BaseHelpUtils.getIntValue(selected.getAttribute("rate"));
						}
						if(!BaseHelpUtils.isNullOrEmpty(selected.getAttribute("rate"))){
							oldValue = BaseHelpUtils.getString(selected.getAttribute("rate"));
						}
						SC.askforValue("提成占比(%):", new ValueCallback() {
							@Override
							public void execute(String value) {
								if(BaseHelpUtils.isNullOrEmpty(value)){
									value = oldValue;
								}else{
									if(BaseHelpUtils.getIntValue(value) < 0){
										SC.say("提示","该阶段占比不可为负数");
										value = oldValue;
									}else if(BaseHelpUtils.getIntValue(value) == 0){
										SC.say("提示","阶段占比不可等于0或不可输入小数点");
										value = oldValue;
									}
								}
								int add = countPercent + BaseHelpUtils.getIntValue(value);
								if(add > 100){
									SC.say("提示","阶段总占比不能大于100%");
									return;
								}
								SC.debugger();
								selected.setAttribute("rate", BaseHelpUtils.getIntValue(value));
								__logger.info("oooooooooooooooooo"+selected.getAttribute("rate"));
								__logger.info("oooooooooooooooooo"+selected.getAttribute("employeeId"));
								grid.updateData(selected);
							}
						});
					}
				}
			});
		
		//初始化数据
		reloadSource(SourceGrid, null);
		//初始化团队
		reloadTeam(params);
	}
	//回显团队组建
	private void reloadTeam(Map<String, Object> params) {
		String contractId = BaseHelpUtils.getStringValue(params, "contractId");
		Map<String, Object> condition = new HashMap<>();
		condition.put("contractId", contractId);
		DBDataSource.callOperation("ST_TeamBuilding", "find", condition, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				RecordList newList = new RecordList();
//				RecordList recordList = dsResponse.getDataAsRecordList();
//				grid.setData(recordList);
				Record[] records = dsResponse.getData();
				SC.debugger();
				Map searchMap = new HashMap();
				for (Record record : records) {
					__logger.info("9================"+record.toMap());
					if (BaseHelpUtils.getIntValue(record.getAttribute("employeeId")) > 0) {
						searchMap.put("employeeId", record.getAttribute("employeeId"));
						searchMap.put("rate", record.getAttribute("rate"));
						newList.add(new Record(searchMap));
					}
					else{
						form2.setValue("departmentRate", record.getAttribute("rate"));
					}
				}
				grid.setData(newList);
			}
		});
	}

	//加载数据
	protected void reloadSource(DelicacyListGrid source, Criteria condition) {
		SC.debugger();
		if (condition == null) {
			condition = new Criteria();
		}
		Map params = condition.getValues();
		if (!BaseHelpUtils.isNullOrEmpty(params.get("departmentId"))) {
			String tempdepartmentId = params.get("departmentId").toString();
			String[] departmnets = tempdepartmentId.split("/");
			int size = departmnets.length;
			int departmentId = Integer.parseInt(departmnets[size - 1]);
			params.put("departmentId", departmentId);
		}
		SC.debugger();
		DBDataSource.callOperation("NQ_TeamMembers", "find", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				searchButton.setIcon("[SKIN]/actions/search.png");
				if (dsResponse.getStatus() >= 0) {
					source.setData(dsResponse.getData());
				}
			}
		});
	}
	
	//添加团队成员
	private void addSelectedDataToTarget(ListGrid source, ListGrid target) {
        ListGridRecord[] selectedRecords = source.getSelectedRecords();
        SC.debugger();
//        RecordList originalList = target.getDataAsRecordList();
        FormItem item;
//        Map<String, FormItem> items = getParentWindow().getFormItems();
//        int originalLength = originalList.getLength();
		RecordList dataAsRecordList = target.getDataAsRecordList();
//		RecordList newList = new RecordList();
//        if (originalLength > 0) {
//            newList.addList(originalList.getRange(0, originalLength));
//        }
        for (ListGridRecord selectedRecord : selectedRecords) {
            Map searchMap = new HashMap();
            searchMap.put("employeeId", selectedRecord.getAttribute("employeeId"));
            searchMap.put("employeeName", selectedRecord.getAttribute("employeeName"));
            searchMap.put("rate", 0);
//            searchMap.put("stageName", selectedRecord.getAttribute("dicTypeValue"));
//            if (originalLength > 0) {
//                int index = originalList.findIndex(searchMap);
//                if (index != -1) {
//                    continue;
//                }
//            }
			dataAsRecordList.add(new Record(searchMap));
        }
        target.setData(dataAsRecordList);
    }
}
