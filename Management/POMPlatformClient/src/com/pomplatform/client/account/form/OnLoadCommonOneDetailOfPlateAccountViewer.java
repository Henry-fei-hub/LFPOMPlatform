package com.pomplatform.client.account.form;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import com.pomplatform.client.account.datasource.DSPlateDeployDetail;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.viewer.DetailViewer;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.data.*;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.GroupColumn;
import com.delicacy.client.ui.GenericViewWindow;
import com.smartgwt.client.widgets.form.SearchForm;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.account.datasource.DSOnLoadCommonOneDetailOfPlateAccount;

public class OnLoadCommonOneDetailOfPlateAccountViewer extends AbstractDetailViewer
{

	private final DelicacyListGrid employeeGrid = new DelicacyListGrid();
	private SearchForm __parentSearchForm;
	private ListGrid grid = new ListGrid();

	public OnLoadCommonOneDetailOfPlateAccountViewer(ListGrid listGrid) {
		grid = listGrid;
	}

	@Override
	public void initComponents() {
		super.initComponents();
		employeeGrid.setDataSource(DSPlateDeployDetail.getInstance());
	}

	@Override
	public int getHorizontalPercent() {
		return 0;
	}

	@Override
	public String getName() {
		return "部门账户明细";
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
		Record selected = grid.getSelectedRecord();
		Map params = new HashMap();
		DBDataSource.callOperation("NQ_OnLoadCommonOneDetailOfPlateAccount", "find", new DSCallback() {
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
		Record selected = grid.getSelectedRecord();
		Map params = new HashMap();
		params = new java.util.HashMap();
		params.put("plateDeployRecordId", selected.getAttributeAsString("businessId"));
		DBDataSource.callOperation("NQ_PlateDeployDetails", "find", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					employeeGrid.setData(dsResponse.getData());
				}
			}
		});
	}

	@Override
	public DataSource getMainDataSource() {
		return DSOnLoadCommonOneDetailOfPlateAccount.getInstance();
	}

	@Override
	public int getDetailCount(){
		return 1;
	}

	@Override
	public List<ListGrid> getDetailListGrids() {
		List<ListGrid> res = new ArrayList<ListGrid>();
		res.add(employeeGrid);
		return res;
	}

	@Override
	public List<String> getDetailNames() {
		List<String> res = new ArrayList<String>();
		res.add("转出明细");
		return res;
	}

	public SearchForm getParentSearchForm() {
		return this.__parentSearchForm;
	}

	public void setParentSearchForm( SearchForm value ) {
		this.__parentSearchForm = value;
	}


}

