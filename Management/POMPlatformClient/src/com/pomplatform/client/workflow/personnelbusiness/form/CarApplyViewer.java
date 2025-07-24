package com.pomplatform.client.workflow.personnelbusiness.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.GroupColumn;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.GenericViewWindow;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSCarApply;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSCarCostAllocation;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSCarCostAllocationPreProject;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSCarCostAllocationProject;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.viewer.DetailViewer;

public class CarApplyViewer extends AbstractDetailViewer
{


	private final DelicacyListGrid carCostAllocationsGrid = new DelicacyListGrid();
	private SearchForm __parentSearchForm;
	private static final Logger logger = Logger.getLogger("");


	public CarApplyViewer() {
	}

	@Override
	public void viewRecord(Record r, boolean includeDetail) {
		super.viewRecord(r, includeDetail);
		if(null != getRecord()){
			switch(ClientUtil.checkAndGetIntValue(getRecord().getAttribute("startDateDetail"))){
			case ClientStaticUtils.DEPARTMENT_USE_CAR:
				carCostAllocationsGrid.setDataSource(DSCarCostAllocation.getInstance());
				break;
			case ClientStaticUtils.PRE_PROJECT_USE_CAR:
				carCostAllocationsGrid.setDataSource(DSCarCostAllocationPreProject.getInstance());
				break;
			case ClientStaticUtils.PROJECT_USE_CAR:
				carCostAllocationsGrid.setDataSource(DSCarCostAllocationProject.getInstance());
				break;
			default:
				break;
			}
		}
	}
	@Override
	public void initComponents() {
		super.initComponents();
		carCostAllocationsGrid.setDataSource(DSCarCostAllocation.getInstance());
		carCostAllocationsGrid.addDoubleClickHandler(new DoubleClickHandler(){
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("");
				detail.setWidth(700); detail.setHeight(500); 
				CarCostAllocationViewer viewer = new CarCostAllocationViewer();
				viewer.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_NORMAL);
				viewer.initComponents();
				viewer.viewSelectedData((ListGrid)event.getSource());
				detail.setContent(viewer);
				detail.centerInPage();detail.show();
			}
		});
	}

	@Override
	public int getHorizontalPercent() {
		return 0;
	}

	@Override
	public String getName() {
		return "用车申请";
	}

	@Override
	public int getGroupCount() {
		return 0;
	}

	@Override
	public List<GroupColumn> getGroupColumnNames() {
		List<GroupColumn> gcs = new ArrayList<GroupColumn>();
		return gcs;
	}

	@Override
	public void load() {
		if(getBusinessId() == null) return;
		Map params = new HashMap();
		params.put("personnelBusinessId", getBusinessId());
		DBDataSource.callOperation("NQ_CarApply", "find", new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					for(DetailViewer v : detailViewers){
						v.setData(dsResponse.getData());
						if(dsResponse.getData().length == 0) continue;
						v.selectRecord(0);
						v.redraw();
					}
					setRecord(dsResponse.getData()[0]);
					viewDetailData();
				}
			}
		});
	}

	@Override
	public void viewSelectedData(ListGrid grid){
		super.viewSelectedData(grid);
		setRecord(grid.getSelectedRecord());
		viewDetailData();
	}

	public void viewDetailData(){
		Record selected = getRecord();
		Object val;
		java.util.Map condition = null;
		java.util.Map parentSearch = __parentSearchForm == null ? new java.util.HashMap() : __parentSearchForm.getValues();
		condition = new java.util.HashMap();
		condition.put("personnelBusinessId", selected.getAttributeAsString("personnelBusinessId"));
		DBDataSource.callOperation("ST_CarCostAllocation", "find", condition, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					carCostAllocationsGrid.setData(dsResponse.getData());
				}
			}
		});
	}

	@Override
	public DataSource getMainDataSource() {
		return DSCarApply.getInstance();
	}

	@Override
	public int getDetailCount(){
		return 1;
	}

	@Override
	public List<ListGrid> getDetailListGrids() {
		List<ListGrid> res = new ArrayList<ListGrid>();
		carCostAllocationsGrid.setAutoFitFieldWidths(false);
		res.add(carCostAllocationsGrid);
		return res;
	}

	@Override
	public List<String> getDetailNames() {
		List<String> res = new ArrayList<String>();
		res.add("");
		return res;
	}

	public SearchForm getParentSearchForm() {
		return this.__parentSearchForm;
	}

	public void setParentSearchForm( SearchForm value ) {
		this.__parentSearchForm = value;
	}


}

