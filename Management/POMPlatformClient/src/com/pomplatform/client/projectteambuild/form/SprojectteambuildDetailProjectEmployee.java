package com.pomplatform.client.projectteambuild.form;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.GenericViewWindow;
import com.pomplatform.client.projectemployee.datasource.DSOnLoadProjectEmpByProcess;
import com.pomplatform.client.projectstages.datasource.DSProjectStageProcessDetail;
import com.pomplatform.client.projectteambuild.datasource.DSSemployeeedror;
import com.pomplatform.client.projectteambuild.datasource.DSSprojectteambuild;
import com.pomplatform.client.projectteambuild.panel.ProjectEmployeePlanIntegralProgressPanel;
import com.pomplatform.client.workflow.datasource.DSProjectEmployee;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.util.ValueCallback;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.TransferImgButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.CellClickEvent;
import com.smartgwt.client.widgets.grid.events.CellClickHandler;
import com.smartgwt.client.widgets.grid.events.CellDoubleClickEvent;
import com.smartgwt.client.widgets.grid.events.CellDoubleClickHandler;
import com.smartgwt.client.widgets.grid.events.RemoveRecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RemoveRecordClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class SprojectteambuildDetailProjectEmployee extends AbstractWizadPage {

	private static final Logger __logger = Logger.getLogger("");
	private DelicacyListGrid grid ;
	private final DelicacyListGrid SourceGrid = new DelicacyListGrid();
	private final IButton searchButton = new IButton("搜索");
	private final IButton resetButton = new IButton("重置");
	private final SemployeeedrorSearchForm __searchForm = new SemployeeedrorSearchForm();
	//定义项目Id
	private int projectId = 0;
	private int departmentManagerId = 0;
	//定义map来存放成员是否可删除
	private Map<Integer,Boolean> notCanDeleteMap = new HashMap<>();
	
	
	public SprojectteambuildDetailProjectEmployee() {
		VLayout SearchSourceLayout = new VLayout();
		SearchSourceLayout.setWidth("25%");
		SearchSourceLayout.setHeight100();
		SearchSourceLayout.setLayoutTopMargin(10);
		SearchSourceLayout.setLayoutRightMargin(5);
		SearchSourceLayout.setShowResizeBar(true);
		addMember(SearchSourceLayout);
		
		HLayout SearchLayout = new HLayout(5);
		SearchLayout.setHeight("5%");
		SearchLayout.setLayoutRightMargin(5);
		SearchSourceLayout.addMember(SearchLayout);
		ClientUtil.searchFormProcessAccordingToDevice(__searchForm);
		__searchForm.setHeight(90);
		SearchLayout.addMember(__searchForm);
		
		VLayout ButtonLayout = new VLayout(5);
		searchButton.setIcon("[SKIN]/actions/search.png");
		searchButton.setWidth(80);
		ButtonLayout.setHeight100();
		ButtonLayout.addMember(searchButton);
		searchButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Criteria condition = __searchForm.getValuesAsCriteria();
				reloadSource(SourceGrid, condition);
			}
		});
		resetButton.setIcon("[SKIN]/actions/redo.png");
		resetButton.setWidth(80);
		ButtonLayout.addMember(resetButton);
		resetButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				__searchForm.editNewRecord();
			}
		});
		SearchLayout.addMember(ButtonLayout);
		
		VLayout SourceLayout = new VLayout(5);
		SourceLayout.setWidth100();
		SourceLayout.setHeight("95%");
		SearchSourceLayout.addMember(SourceLayout);
		
		VLayout sourceGridLayout = new VLayout();
		SourceLayout.addMember(sourceGridLayout);
		sourceGridLayout.setWidth100();
		sourceGridLayout.setHeight("55%");
		
		SourceGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		SourceGrid.setDataSource(DSSemployeeedror.getInstance());
		sourceGridLayout.addMember(SourceGrid);
		
		HLayout projectEmployees = new HLayout();
		projectEmployees.setWidth("75%");
		projectEmployees.setHeight100();
		projectEmployees.setLayoutLeftMargin(5);
		addMember(projectEmployees);
		
		TransferImgButton addToButton = new TransferImgButton(TransferImgButton.RIGHT);
		projectEmployees.addMember(addToButton);
		addToButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				addSelectedEmployee();
			}
		});
		
		VLayout leftLayout = new VLayout(10);
		leftLayout.setAlign(Alignment.RIGHT);
		projectEmployees.addMember(leftLayout);
		
		grid = new DelicacyListGrid();
		grid.setDataSource(DSOnLoadProjectEmpByProcess.getInstance());
		grid.setHeight("95%");
		grid.setAutoFitFieldWidths(false);
		grid.setCanRemoveRecords(true);
		grid.setHeaderHeight(60); 
		grid.setShowRowNumbers(true);
		grid.addRemoveRecordClickHandler(new RemoveRecordClickHandler() {
			@Override
			public void onRemoveRecordClick(RemoveRecordClickEvent event) {
				SC.debugger();
				int rowNum = event.getRowNum();
				Record record = grid.getRecord(rowNum);
				//获取成员Id
				int employeeId = BaseHelpUtils.getIntValue(record.getAttribute("employeeId"));
				if(employeeId == 0){
					SC.say("提示","操作异常:成员不可为空");
					event.cancel();
					return;
				}
				if(notCanDeleteMap.containsKey(employeeId)){//说明该成员已有确认积分，不可删除
					SC.say("提示","操作异常:该成员已有确认积分,不可删除");
					event.cancel();
					return;
				}
			}
		});
		
		HLayout leftLayout2 = new HLayout(2);
		leftLayout2.setWidth("100%");
		leftLayout2.setAlign(Alignment.RIGHT);
		
		leftLayout.addMember(grid);
		leftLayout.addMember(leftLayout2);
		
	}
	

	/**
	 * 选取需要的人员
	 * 
	 */
	private void addSelectedEmployee() {
		ListGridRecord[] selectedRecords = SourceGrid.getSelectedRecords();
		RecordList originalList = grid.getDataAsRecordList();
		int originalLength = originalList.getLength();
		RecordList newList = new RecordList();
		if (originalLength > 0) {
			newList.addList(originalList.getRange(0, originalLength));
		}
		SourceGrid.deselectAllRecords();
		for (ListGridRecord selectedRecord : selectedRecords) {
			Map<String,Object> searchMap = new HashMap<>();
			SC.debugger();
			//团队组建不需要吧积分管理员进行添加
			int employeeId = BaseHelpUtils.getIntValue(selectedRecord.getAttribute("employeeId"));
			if(!notCanDeleteMap.containsKey(employeeId)) {
				searchMap.put("employeeId", selectedRecord.getAttribute("employeeId"));
				if (originalLength > 0) {
					int index = originalList.findIndex(searchMap);
					if (index != -1) {
						continue;
					}
				}
				int gradeId = BaseHelpUtils.getIntValue(selectedRecord.getAttribute("gradeId"));
				searchMap.put("employeeNo", selectedRecord.getAttribute("employeeNo"));
				searchMap.put("employeeName", selectedRecord.getAttribute("employeeName"));
				searchMap.put("departmentId", selectedRecord.getAttribute("departmentId"));
				searchMap.put("roleId", selectedRecord.getAttribute("roleId"));
				searchMap.put("gradeId",gradeId);
				searchMap.put("status", selectedRecord.getAttribute("status"));
				newList.add(new Record(searchMap));
			}else {
				SC.say("提示","操作异常:该成员("+selectedRecord.getAttribute("employeeName")+")是团队组建一员");
				return;
			}
			
		}
		grid.setData(newList);
	}
	
	
	
	
	/**
	 * 去重resultList
	 * @param gradeId
	 */
	private void chekcResultList(List<Map<String,Object>> resultList,Map<String, Object> map){
			int projectId = BaseHelpUtils.getIntValue(map.get("projectId"));
			int stageId = BaseHelpUtils.getIntValue(map.get("stageId"));
			int employeeId = BaseHelpUtils.getIntValue(map.get("employeeId"));
			
			int flag =-1;//默认没有
			for (int i = 0; i < resultList.size(); i++) {
				Map<String, Object> params = resultList.get(i);
				int projectId2 = BaseHelpUtils.getIntValue(params.get("projectId"));
				int stageId2 = BaseHelpUtils.getIntValue(params.get("stageId"));
				int employeeId2 = BaseHelpUtils.getIntValue(params.get("employeeId"));
				
				//如果有重复则从list中去除
				if(projectId==projectId2&&stageId==stageId2&&employeeId==employeeId2) {
					flag=i;
					break;
				}
			}
			if(flag>=0) {
				resultList.remove(flag);
			}
			map.put("oldPlanIntegral", 0);
			resultList.add(map);
	 }
	
	
	@Override
	public void startEdit() {
		Record record = getRecord();
		projectId = BaseHelpUtils.getIntValue(record.getAttribute("projectId"));
		departmentManagerId = BaseHelpUtils.getIntValue(record.getAttribute("departmentManagerId"));
		Map<String,Object> condition = new HashMap<>();
		int projectId = BaseHelpUtils.getIntValue(record.getAttribute("projectId"));
		condition.put("projectId",projectId);
//		getLeftEmpData(condition);
		reloadSource(SourceGrid, null);
		if (getPageMode() == PAGE_MODE_UPDATE) {
			//加载项目成员信息PERSONNEL_BUSINESS_ID
			condition.put("businessId",BaseHelpUtils.getIntValue(record.getAttribute("personnelBusinessId")));
			getEmpData(condition);
		}else {
			condition.put("status",2);
			getEmpData(condition);
		}
		
		Map<String,Object> map = new HashMap<>();
		map.put("projectId",projectId);
		map.put("optType","checkProjectSettlement");
		DBDataSource.callOperation("EP_OnProjectCommonProcess",  map, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record[] records = dsResponse.getData();
					if(records.length>0) {
						for (Record record : records) {
							notCanDeleteMap.put(BaseHelpUtils.getIntValue(record.getAttribute("employeeId")), true);
						}
					}
				}
			}
		});
		
		
		
	}
	
	//加载成员列表信息
	public void getEmpData(Map<String,Object> condition){
		DBDataSource.callOperation("NQ_OnLoadProjectEmpByProcess", "find", condition, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record[] records = dsResponse.getData();
					grid.setData(records);
				}
			}
		});
	}

	@Override
	public boolean checkData() {
		ListGridRecord[] records = grid.getRecords();
		if (records.length <= 0) {
			SC.say("成员列表不能为空");
			return false;
		}
		if(projectId<=0) {
			SC.say("订单信息不能为空");
			return false;
		}
		if (getPageMode() != PAGE_MODE_UPDATE) {
		if(departmentManagerId<=0) {
			SC.say("部门经理不能为空");
			return false;
		}
		}
		return true;
	}

	@Override
	public java.util.Map<String,Object> getValuesAsMap() {
		Map param = new HashMap();
		param.put("projectId", projectId);
		param.put("employeeId", ClientUtil.getUserId());
		param.put("processType", 79);
		param.put("departmentId", departmentManagerId);
		ListGridRecord[] rows = grid.getRecords();
		
		if (getPageMode() == PAGE_MODE_UPDATE) {
			param.put("personnelBusinessId", getRecord().getAttribute("personnelBusinessId"));
		}	
		
		MapUtils.convertRecordToMap(DSProjectEmployee.getInstance(), rows, param, "detailProjectEmployee");
		return param;
	}

	@Override
	public void reloadSourceData() {
		Criteria condition = __searchForm.getValuesAsCriteria();
		reloadSource(SourceGrid, condition);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void reloadSource(final ListGrid source, Criteria condition) {
		if (condition == null) {
			condition = new Criteria();
		}
		Map params = condition.getValues();
		ClientUtil.departmentParameterProcess(params);
		//获取项目标示类型,如果是非设计项目，则需要加载没有职级的人员，如果是设计项目，则加载有职级的人员
		int projectFlag = BaseHelpUtils.getIntValue(getRecord().getAttribute("projectFlag"));
		if(projectFlag > 1){//说明是非设计项目
			List<Map<String, String>> keyvalues = new ArrayList<>();
			Map<String, String> kv = new HashMap<>();
			kv.put("key", "e.grade_id >0");
			kv.put("value", "1=1");
			keyvalues.add(kv);
			params.put("keyValues", keyvalues);
		}
		searchButton.setIcon("loading38.gif");
		DBDataSource.callOperation("NQ_Semployeeedror", "find", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				searchButton.setIcon("[SKIN]/actions/search.png");
				if (dsResponse.getStatus() >= 0) {
					source.setData(dsResponse.getData());
				}
			}
		});
	}

	
}
