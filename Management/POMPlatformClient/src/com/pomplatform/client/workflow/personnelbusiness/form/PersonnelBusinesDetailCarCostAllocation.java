package com.pomplatform.client.workflow.personnelbusiness.form;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
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
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.common.SyncDataUtil;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSCarCostAllocationEdit;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSCarCostAllocationPreProjectEdit;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSCarCostAllocationProjectEdit;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PersonnelBusinesDetailCarCostAllocation extends AbstractWizadPage
{

	private static final Logger __logger = Logger.getLogger("");
	private DSCallback __startLoadedDetail;
	private DSCallback __endLoadedDetail;
	private DelicacyListGrid grid = new DelicacyListGrid(true);
	public int type = ClientStaticUtils.DEPARTMENT_USE_CAR;
	public BigDecimal cost = BigDecimal.ZERO;

	public void setCorrectDataSrouce(int value){
		type = value;
		grid.setData(new RecordList());
		switch(type){
		case ClientStaticUtils.DEPARTMENT_USE_CAR:
			grid.setDataSource(DSCarCostAllocationEdit.getInstance());
			break;
		case ClientStaticUtils.PROJECT_USE_CAR:
			grid.setDataSource(DSCarCostAllocationProjectEdit.getInstance());
			break;	
		case ClientStaticUtils.PRE_PROJECT_USE_CAR:
			grid.setDataSource(DSCarCostAllocationPreProjectEdit.getInstance());
			break;	
		default:
			break;
		}
		grid.redraw();
	}
	
	public PersonnelBusinesDetailCarCostAllocation(){
		grid.addEditCompleteHandler(new EditCompleteHandler() {
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				Record record = grid.getRecord(event.getRowNum());
				if(null != record.getAttribute("percent")){
					if(event.getColNum() == 0){
						String value = record.getAttribute("id");
						switch(type){
						case ClientStaticUtils.DEPARTMENT_USE_CAR:
							record.setAttribute("name", KeyValueManager.getValue("departments", value));
							break;
						case ClientStaticUtils.PROJECT_USE_CAR:
							String projectName = SyncDataUtil.getProjectName(BaseHelpUtils.getIntValue(value));
							String projectCode = SyncDataUtil.getContractCode(BaseHelpUtils.getIntValue(value));
//							Record record1 = getProjectName(BaseHelpUtils.getIntValue(value));
//							String projectName = BaseHelpUtils.getString(record1.getAttribute("projectName"));
//							String projectCode = BaseHelpUtils.getString(record1.getAttribute(record1.getAttribute("projectCode")));
//							record.setAttribute("code", KeyValueManager.getValue("project_code", value));
//							record.setAttribute("name", KeyValueManager.getValue("projects", value));
							record.setAttribute("code", projectCode);
							record.setAttribute("name", projectName);
							break;	
						case ClientStaticUtils.PRE_PROJECT_USE_CAR:
							record.setAttribute("code", KeyValueManager.getValue("pre_main_project_number", value));
							//根据前期项目id
							Map<String,Object> param = new HashMap<>();
							param.put("preProjectId",KeyValueManager.getValue("pre_main_project_id", value));
							DBDataSource.callOperation("ST_PreProject", "find",param, new DSCallback() {
		                        @Override
		                        public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
		                            if (dsResponse.getStatus() >= 0) {
		                            	//获取数据集
		                            	Record[] records = dsResponse.getData();
		                            	if(!BaseHelpUtils.isNullOrEmpty(records) && records.length > 0) {
		                            		Record r = records[0];
		                            		//获取项目名称
		                            		String projectName = BaseHelpUtils.getString(r.getAttribute("projectName"));
		                            		record.setAttribute("name",projectName);
		                            	}
		                            }
		                        }
		                    });
							break;	
						default:
							break;
						}
					}
					BigDecimal percent = new BigDecimal(record.getAttribute("percent")).setScale(2, BigDecimal.ROUND_DOWN);
					record.setAttribute("percent", percent);
					record.setAttribute("costAllocation", cost.multiply(percent).divide(new BigDecimal(100), 2, BigDecimal.ROUND_DOWN));
					grid.updateData(record);
				}
				Record[] records = grid.getRecords();
				BigDecimal leftPercent = new BigDecimal(100);
				BigDecimal costSum = BigDecimal.ZERO;
				int length = records.length;
				int i = 0;
				for(Record obj : records){
					i++;
					if(null != obj.getAttribute("percent")){
						leftPercent = leftPercent.subtract(new BigDecimal(obj.getAttribute("percent")));
					}
					if(i < length && null != obj.getAttribute("costAllocation")){
						costSum = costSum.add(new BigDecimal(obj.getAttribute("costAllocation")));
					}
				}
				if(leftPercent.compareTo(BigDecimal.ZERO) == 0){
					Record lastRecord = grid.getRecord(records.length - 1);
					lastRecord.setAttribute("costAllocation", cost.subtract(costSum));
					grid.updateData(lastRecord);
				}
			}
		});
		HLayout carCostAllocations = new HLayout();
		carCostAllocations.setWidth100();
		carCostAllocations.setHeight100();
		grid.setDataSource(DSCarCostAllocationEdit.getInstance());
		grid.setAutoFitFieldWidths(false);
		carCostAllocations.addMember(grid);
		VLayout carCostAllocationsControls = new VLayout();
		carCostAllocationsControls.setHeight100();
		carCostAllocationsControls.setWidth(60);
		carCostAllocationsControls.setLayoutTopMargin(30);
		carCostAllocationsControls.setLayoutLeftMargin(5);
		carCostAllocationsControls.setLayoutRightMargin(5);
		carCostAllocationsControls.setMembersMargin(10);
		carCostAllocations.addMember(carCostAllocationsControls);
		addMember(carCostAllocations);
		IButton carCostAllocationsNewButton = new IButton("新增");
		carCostAllocationsNewButton.addClickHandler( new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						carCostAllocationsNewButton.setDisabled(true);
						BigDecimal leftPercent = new BigDecimal(100);
						Record[] records = grid.getRecords();
						BigDecimal costSum = BigDecimal.ZERO;
						for(Record record : records){
							if(null != record.getAttribute("percent")){
								leftPercent = leftPercent.subtract(new BigDecimal(record.getAttribute("percent")));
							}
							if(null != record.getAttribute("costAllocation")){
								costSum = costSum.add(new BigDecimal(record.getAttribute("costAllocation")));
							}
						}
						if(leftPercent.compareTo(BigDecimal.ZERO) > 0){
							Record record = new Record();
							record.setAttribute("type", type);
							record.setAttribute("cost", cost);
							record.setAttribute("percent", leftPercent);
							record.setAttribute("costAllocation", cost.subtract(costSum));
							grid.addData(record);
							grid.startEditing(grid.getRecords().length-1);
						}else{
							SC.say("成本分摊比例已 >= 100%，请重新确认每一项需要承担的成本比例");
						}
						carCostAllocationsNewButton.setDisabled(false);
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				});
			}
		});
		IButton carCostAllocationsRemoveButton = new IButton("删除所有");
		carCostAllocationsRemoveButton.addClickHandler( new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				grid.setData(new RecordList());
			}
		});
		carCostAllocationsControls.addMember(carCostAllocationsNewButton);
		carCostAllocationsControls.addMember(carCostAllocationsRemoveButton);
	}

	@Override
	public void startEdit() {
		if(getPageMode() != PAGE_MODE_UPDATE) return;
		reloadDetailTableData();
	}

	public void reloadDetailTableData(){
		Map condition = new HashMap();
		condition.put("personnelBusinessId", getRecord().getAttribute("personnelBusinessId"));
		DBDataSource.callOperation("ST_CarCostAllocation", "find", condition, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0) {
					if(__startLoadedDetail != null) __startLoadedDetail.execute(dsResponse, data, dsRequest);
					grid.setData(dsResponse.getData());
					if(__endLoadedDetail != null) __endLoadedDetail.execute(dsResponse, data, dsRequest);
				}
			}
		});
	}

	@Override
	public boolean checkData() {
		BigDecimal percent = BigDecimal.ZERO;
		BigDecimal cost = BigDecimal.ZERO;
		for(ListGridRecord r : grid.getRecords()) {
			if(null != r.getAttribute("percent")){
				percent = percent.add(new BigDecimal(r.getAttribute("percent")));
			}
			if(null != r.getAttribute("costAllocation")){
				cost = cost.add(new BigDecimal(r.getAttribute("costAllocation")));
			}
			if(ClientUtil.checkAndGetIntValue(r.getAttribute("id")) == 0){
				switch(type){
				case ClientStaticUtils.DEPARTMENT_USE_CAR:
					SC.say("请选择分摊成本的部门");
					return false;
				case ClientStaticUtils.PROJECT_USE_CAR:
					SC.say("请选择分摊成本的订单");
					return false;
				case ClientStaticUtils.PRE_PROJECT_USE_CAR:
					SC.say("请选择分摊成本的前期项目");
					return false;
				default :
					return false;
				}
			}
		}
		if(percent.compareTo(new BigDecimal(100)) != 0 || cost.compareTo(this.cost) != 0){
			SC.say("成本分摊数据有误，请重新核对");
			return false;
		}
		return true;
	}

	@Override
	public Set<String> getItemNames() {
		Set<String> res = new HashSet<>();
		res.add("detailCarCostAllocation");
		return res;
	}

	@Override
	public boolean isTheValuesEmpty() {
		ListGridRecord[] rows = grid.getRecords();
		return rows == null || rows.length == 0;
	}

	@Override
	public Map getValuesAsMap() {
		Map param = new HashMap();
		ListGridRecord[] rows = grid.getRecords();
		MapUtils.convertRecordToMap(grid.getDataSource(), rows, param, "detailCarCostAllocation");
		return param;
	}

	@Override
	public String getName() {
		return "";
	}

	public DSCallback getStartLoadedDetail() {
		return this.__startLoadedDetail;
	}

	public void setStartLoadedDetail( DSCallback value ) {
		this.__startLoadedDetail = value;
	}

	public DSCallback getEndLoadedDetail() {
		return this.__endLoadedDetail;
	}

	public void setEndLoadedDetail( DSCallback value ) {
		this.__endLoadedDetail = value;
	}

	public DelicacyListGrid getGrid() {
		return this.grid;
	}

	public void setGrid( DelicacyListGrid value ) {
		this.grid = value;
	}

	public void clearGridRecords(){
		this.grid.setRecords(new ListGridRecord[0]);
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
		Record[] records = grid.getRecords();
		if(null != records){
			BigDecimal leftPercent = new BigDecimal(100);
			BigDecimal costSum = BigDecimal.ZERO;
			int length = records.length;
			int i = 0;
			for(Record obj : records){
				i++;
				obj.setAttribute("cost", cost);
				if(null != obj.getAttribute("percent")){
					BigDecimal percent = new BigDecimal(obj.getAttribute("percent"));
					leftPercent = leftPercent.subtract(percent);
					BigDecimal costAllocation = cost.multiply(percent).divide(new BigDecimal(100), 2, BigDecimal.ROUND_DOWN);
					obj.setAttribute("costAllocation", costAllocation);
					if(i < length){
						costSum = costSum.add(costAllocation);
					}
				}
				grid.updateData(obj);
			}
			if(leftPercent.compareTo(BigDecimal.ZERO) == 0){
				Record lastRecord = grid.getRecord(records.length - 1);
				lastRecord.setAttribute("costAllocation", cost.subtract(costSum));
				grid.updateData(lastRecord);
			}
		}
	}

	/**
	 * 获取项目的名称
	 * @param projectId
	 * @return
	 */
	private Record getProjectName(Integer projectId){
		Record record = new Record();
		HashMap<Object, Object> map = new HashMap<>();
		map.put("projectId",projectId);
		DBDataSource.callOperation("ST_Project", "find", map, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					Record[] records = dsResponse.getData();
					if(!BaseHelpUtils.isNullOrEmpty(records) && records.length > 0){
						//获取项目名称
						String projectName = BaseHelpUtils.getString(records[0].getAttribute("projectName"));
						record.setAttribute("projectName",projectName);
					}
				}
			}
		});
		return record;
	}
	
}

