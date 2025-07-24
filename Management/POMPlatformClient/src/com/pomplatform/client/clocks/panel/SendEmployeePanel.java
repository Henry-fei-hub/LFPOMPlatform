package com.pomplatform.client.clocks.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.DelicacyPanel;
import com.delicacy.client.MapUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.LoadingWindow;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.clocks.datasource.DSClockList;
import com.pomplatform.client.employeerescord.datasource.DSEmployee;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.TransferImgButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.IPickTreeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class SendEmployeePanel extends DelicacyPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	private VLayout allLayout;
	private HLayout clockLayout;
	private VLayout employeeLeftLayout;
	private HLayout leftSearchLayout;
	private HLayout formLayout;
	private HLayout leftButtonLayout;
	private HLayout leftGridLayout;
	private HLayout employeeLayout;
	private HLayout buttonLayout;
	private DelicacyListGrid clockGrid;
	private DelicacyListGrid clockResultGrid;
	private DelicacyListGrid employeeGrid;
	private DelicacyListGrid employeeResultGrid;
	private DynamicForm dateForm;
	
	private TextItem employeeNoItem;
	private TextItem employeeNameItem;
	private IPickTreeItem departmentIdItem;
	private SelectItem plateIdItem;
	
	@Override
	public Canvas getViewPanel() {
        allLayout = new VLayout(10);
        allLayout.setWidth100();
        allLayout.setHeight100();
        allLayout.setBackgroundColor("#e2e2e2");

        clockLayout = new HLayout(10);
        clockLayout.setWidth100();
        clockLayout.setHeight("48%");
        clockLayout.setLayoutMargin(10);
        
        employeeLayout = new HLayout(10);
        employeeLayout.setWidth100();
        employeeLayout.setHeight("48%");
        employeeLayout.setLayoutMargin(10);
        
        buttonLayout = new HLayout(10);
        buttonLayout.setWidth100();
        buttonLayout.setHeight("4%");
        buttonLayout.setAlign(Alignment.RIGHT);
        buttonLayout.setLayoutMargin(10);
        buttonLayout.setMembersMargin(10);
        
        clockGrid = new DelicacyListGrid();
        clockGrid.setShowRowNumbers(true);
        clockGrid.setAutoFitFieldWidths(false);
        int index = 0;
		ListGridField [] fields = new ListGridField[5];
		fields[index] = new ListGridField("sn");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("deviceName");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("alias");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("ipaddress");
		index ++;
		fields[index] = new ListGridField("clockTypeId");
		clockGrid.setDataSource(DSClockList.getInstance());
		clockGrid.setFields(fields);
		clockGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		clockLayout.addMember(clockGrid);
		
		TransferImgButton addToButton1 = new TransferImgButton(TransferImgButton.RIGHT);
		clockLayout.addMember(addToButton1);
		addToButton1.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(!clockGrid.anySelected()){
					return;
				}
				addSelectedClockToTarget(clockGrid,clockResultGrid);
			}
		});
		clockGrid.addDoubleClickHandler(new DoubleClickHandler() {
            @Override
            public void onDoubleClick(DoubleClickEvent event) {
            	addSelectedClockToTarget(clockGrid,clockResultGrid);
            }
        });
		
		clockResultGrid = new DelicacyListGrid();
		clockResultGrid.setShowRowNumbers(true);
		clockResultGrid.setAutoFitFieldWidths(false);
        index = 0;
		fields = new ListGridField[5];
		fields[index] = new ListGridField("sn");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("alias");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("deviceName");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("ipaddress");
		index ++;
		fields[index] = new ListGridField("clockTypeId");
		clockResultGrid.setDataSource(DSClockList.getInstance());
		clockResultGrid.setFields(fields);
		clockResultGrid.setShowRowNumbers(true);
		clockResultGrid.setCanRemoveRecords(true);
		clockLayout.addMember(clockResultGrid);
		
		employeeLeftLayout = new VLayout(10);
		employeeLeftLayout.setWidth100();
		employeeLeftLayout.setHeight100();
		
		leftSearchLayout = new HLayout(10);
		leftSearchLayout.setWidth100();
		leftSearchLayout.setHeight("3%");
		
		leftGridLayout = new HLayout(10);
		leftGridLayout.setWidth100();
		leftGridLayout.setHeight("97%");
		
		leftButtonLayout = new HLayout(10);
		leftButtonLayout.setWidth("2%");
		leftButtonLayout.setHeight100();
		leftButtonLayout.setLayoutTopMargin(30);
		
		formLayout = new HLayout(10);
		formLayout.setWidth("98%");
		formLayout.setHeight100();
		
		employeeNoItem = new TextItem("employeeNo","员工编号");
		employeeNameItem = new TextItem("employeeName","员工姓名");
		departmentIdItem = new IPickTreeItem("departmentId", "归属部门");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));
		plateIdItem = new SelectItem("plateId","业务部门");
		plateIdItem.setAllowEmptyValue(true);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));
		
		dateForm = new DynamicForm();
		dateForm.setTitleAlign(Alignment.LEFT);
		dateForm.setTitleOrientation(TitleOrientation.TOP);
		dateForm.setWidth100();
	    dateForm.setHeight100();
	    dateForm.setNumCols(8);
	    dateForm.setMargin(10);
	    dateForm.setItems(employeeNoItem,employeeNameItem,plateIdItem,departmentIdItem);
	    formLayout.addMember(dateForm);
	    leftSearchLayout.addMember(formLayout);
	    
	    IButton searchButton = new IButton("搜索");
	    leftButtonLayout.addMember(searchButton);
	    leftSearchLayout.addMember(leftButtonLayout);
	    employeeLeftLayout.addMember(leftSearchLayout);
	    searchButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				loadEmployee();
			}
		});
	    
		employeeGrid = new DelicacyListGrid();
		employeeGrid.setShowRowNumbers(true);
		employeeGrid.setAutoFitFieldWidths(false);
        index = 0;
		fields = new ListGridField[5];
		fields[index] = new ListGridField("employeeId");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("employeeNo");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("employeeName");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("departmentId");
		index ++;
		fields[index] = new ListGridField("plateId");
		employeeGrid.setDataSource(DSEmployee.getInstance());
		employeeGrid.setFields(fields);
		employeeGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		leftGridLayout.addMember(employeeGrid);
		employeeLeftLayout.addMember(leftGridLayout);
		employeeLayout.addMember(employeeLeftLayout);
		
		TransferImgButton addToButton2 = new TransferImgButton(TransferImgButton.RIGHT);
		employeeLayout.addMember(addToButton2);
		addToButton2.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(!employeeGrid.anySelected()){
					return;
				}
				addSelectedEmployeeToTarget(employeeGrid,employeeResultGrid);
			}
		});
		employeeGrid.addDoubleClickHandler(new DoubleClickHandler() {
            @Override
            public void onDoubleClick(DoubleClickEvent event) {
            	addSelectedEmployeeToTarget(employeeGrid,employeeResultGrid);
            }
        });
		
		employeeResultGrid = new DelicacyListGrid();
		employeeResultGrid.setShowRowNumbers(true);
		employeeResultGrid.setAutoFitFieldWidths(false);
        index = 0;
		fields = new ListGridField[5];
		fields[index] = new ListGridField("employeeId");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("employeeNo");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("employeeName");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("departmentId");
		index ++;
		fields[index] = new ListGridField("plateId");
		employeeResultGrid.setDataSource(DSEmployee.getInstance());
		employeeResultGrid.setFields(fields);
		employeeResultGrid.setShowRowNumbers(true);
		employeeResultGrid.setCanRemoveRecords(true);
		employeeLayout.addMember(employeeResultGrid);
		
		IButton saveButton = new IButton("保存");
		saveButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Map<String,Object> param = new HashMap<>();
				param.put("optType", "onSaveEmpToClock");
				//获取操作人
				int operateEmployeeId = ClientUtil.getEmployeeId();
				param.put("operateEmployeeId",operateEmployeeId);
				//设置要下发的设备列表
				MapUtils.convertRecordToMap(clockResultGrid.getDataSource(), clockResultGrid.getRecords(), param, "clockList");
				//设置要下发的人员列表
				MapUtils.convertRecordToMap(employeeResultGrid.getDataSource(), employeeResultGrid.getRecords(), param, "employeeList");
				final LoadingWindow loading = new LoadingWindow();
				saveButton.setDisabled(true);
				DBDataSource.callOperation("EP_ClockMsgProcess", param,new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						saveButton.setDisabled(false);
						loading.destroy();
						if(dsResponse.getStatus() >= 0){
							SC.say("保存成功");
						}else{
							SC.say(dsResponse.getErrors().get("errorMsg").toString());
						}
					}
				});
			}
		});
		
		IButton cancelButton = new IButton("取消");
		cancelButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				getParentWindow().destroy();
			}
		});
		buttonLayout.addMember(saveButton);
		buttonLayout.addMember(cancelButton);
		
		allLayout.addMember(clockLayout);
		allLayout.addMember(employeeLayout);
		allLayout.addMember(buttonLayout);
		
		return allLayout;
	}
	
	//加载下发设备
	public void loadClock(){
		Map<String,Object> param = new HashMap<>();
		DBDataSource.callOperation("ST_Clock", "find", param,new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					clockGrid.setData(dsResponse.getData());
					clockGrid.redraw();
				}
			}
		});
	}
	
	//加载员工
	@SuppressWarnings("rawtypes")
	public void loadEmployee(){
		Map<String,Object> param = new HashMap<>();
		param.put("status",0);
		if(!BaseHelpUtils.isNullOrEmpty(employeeNoItem.getValue())){
			param.put("employeeNo",employeeNoItem.getValue());
		}
		if(!BaseHelpUtils.isNullOrEmpty(employeeNameItem.getValue())){
			param.put("employeeName",employeeNameItem.getValue());
		}
		if(!BaseHelpUtils.isNullOrEmpty(departmentIdItem.getValue())){
			param.put("departmentId",departmentIdItem.getValue());
		}
		if(!BaseHelpUtils.isNullOrEmpty(plateIdItem.getValue())){
			param.put("plateId",plateIdItem.getValue());
		}
		
		List<Map> keyvalues = new ArrayList<>();
		Map<String, String> kv = new HashMap<>();
		kv.put("key", "(EXTRACT(YEAR from onboard_date))");
		kv.put("value", "1");
		keyvalues.add(kv);
		
		Map<String, String> kv1 = new HashMap<>();
		kv1.put("key", "(EXTRACT(MONTH from onboard_date))");
		kv1.put("value", "1");
		keyvalues.add(kv1);
		
		Map<String, String> kv2 = new HashMap<>();
		kv2.put("key", "(EXTRACT(YEAR from resignation_date))");
		kv2.put("value", "1");
		keyvalues.add(kv2);
		
		Map<String, String> kv3 = new HashMap<>();
		kv3.put("key", "(EXTRACT(MONTH from resignation_date))");
		kv3.put("value", "1");
		keyvalues.add(kv3);
		
		Map<String, String> kv4 = new HashMap<>();
		kv4.put("key", "(EXTRACT(MONTH from birth))");
		kv4.put("value", "1");
		keyvalues.add(kv4);
		
		param.put("keyValues", keyvalues);
		DBDataSource.callOperation("NQ_Memployee", "find", param,new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					employeeGrid.setData(dsResponse.getData());
					employeeGrid.redraw();
				}
			}
		});
	}
	
	//添加要下发的设备
	private void addSelectedClockToTarget(ListGrid source, ListGrid target) {
        ListGridRecord[] selectedRecords = source.getSelectedRecords();
        RecordList originalList = target.getDataAsRecordList();
        int originalLength = originalList.getLength();
        RecordList newList = new RecordList();
        if (originalLength > 0) {
            newList.addList(originalList.getRange(0, originalLength));
        }
        for (ListGridRecord selectedRecord : selectedRecords) {
            Map<String,Object> searchMap = new HashMap<>();
            searchMap.put("sn", selectedRecord.getAttribute("sn"));
            searchMap.put("alias", selectedRecord.getAttribute("alias"));
            searchMap.put("deviceName", selectedRecord.getAttribute("deviceName"));
            searchMap.put("ipaddress", selectedRecord.getAttribute("ipaddress"));
            searchMap.put("clockTypeId", selectedRecord.getAttribute("clockTypeId"));
            if (originalLength > 0) {
                int index = originalList.findIndex(searchMap);
                if (index != -1) {
                    continue;
                }
            }
            newList.add(new Record(searchMap));
        }
        target.setData(newList);
    }
	
	//添加要下发的人员
	private void addSelectedEmployeeToTarget(ListGrid source, ListGrid target) {
        ListGridRecord[] selectedRecords = source.getSelectedRecords();
        RecordList originalList = target.getDataAsRecordList();
        int originalLength = originalList.getLength();
        RecordList newList = new RecordList();
        if (originalLength > 0) {
            newList.addList(originalList.getRange(0, originalLength));
        }
        for (ListGridRecord selectedRecord : selectedRecords) {
            Map<String,Object> searchMap = new HashMap<>();
            searchMap.put("employeeId", selectedRecord.getAttribute("employeeId"));
            searchMap.put("employeeNo", selectedRecord.getAttribute("employeeNo"));
            searchMap.put("employeeName", selectedRecord.getAttribute("employeeName"));
            searchMap.put("departmentId", selectedRecord.getAttribute("departmentId"));
            searchMap.put("plateId", selectedRecord.getAttribute("plateId"));
            if (originalLength > 0) {
                int index = originalList.findIndex(searchMap);
                if (index != -1) {
                    continue;
                }
            }
            newList.add(new Record(searchMap));
        }
        target.setData(newList);
    }
	
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			SendEmployeePanel cm = new SendEmployeePanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "clockList";
		}

	}
	
	private PopupWindow parentWindow;

	public PopupWindow getParentWindow() {
		return parentWindow;
	}

	public void setParentWindow(PopupWindow parentWindow) {
		this.parentWindow = parentWindow;
	}
	
}

