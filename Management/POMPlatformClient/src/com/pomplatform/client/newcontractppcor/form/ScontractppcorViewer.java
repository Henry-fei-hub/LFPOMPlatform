package com.pomplatform.client.newcontractppcor.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.data.*;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.GroupColumn;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.GenericViewWindow;
import com.smartgwt.client.widgets.form.SearchForm;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.contractsrecords.datasource.DSContractsRecords;
import com.pomplatform.client.newcontractppcor.datasource.DSScontractppcor;
import com.pomplatform.client.preprojectrecord.datasource.DSSpreProjectRecordRrtor;

public class ScontractppcorViewer extends AbstractDetailViewer
{


	private SearchForm __parentSearchForm;
	private final DelicacyListGrid contractRecordGrid = new DelicacyListGrid(); 


	public ScontractppcorViewer() {
	}

	@Override
	public void initComponents() {
		super.initComponents();
//		contractRecordGrid.setDataSource(DSContractsRecords.getInstance());
		contractRecordGrid.setDataSource(DSSpreProjectRecordRrtor.getInstance());
	}

	@Override
	public int getHorizontalPercent() {
		return 0;
	}

	@Override
	public String getName() {
		return "合同详细";
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
	public void viewSelectedData(ListGrid grid){
		super.viewSelectedData(grid);
		Record selected = grid.getSelectedRecord();
		Map<String,Object> params = new HashMap<>();
		int contractId = BaseHelpUtils.getIntValue(selected.getAttribute("contractId"));
		params.put("preProjectId", contractId);
		params.put("informationType", 2);
        DBDataSource.callOperation("ST_PreProjectRecord", "find", params, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                	contractRecordGrid.setData(dsResponse.getData());
                }
            }
		});
//		DBDataSource.callOperation("ST_ContractsRecords","find", params, new DSCallback() {
//			@Override
//			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//				if(dsResponse.getStatus() >= 0){
//					contractRecordGrid.setData(dsResponse.getData());
//				}
//			}
//		});
	}

	@Override
	public DataSource getMainDataSource() {
		return DSScontractppcor.getInstance();
	}

	@Override
	public int getDetailCount(){
		return 1;
	}

	@Override
	public List<ListGrid> getDetailListGrids() {
		List<ListGrid> res = new ArrayList<ListGrid>();
		res.add(contractRecordGrid);
		return res;
	}

	@Override
	public List<String> getDetailNames() {
		List<String> res = new ArrayList<String>();
		res.add("合同跟踪记录");
		return res;
	}

	public SearchForm getParentSearchForm() {
		return this.__parentSearchForm;
	}

	public void setParentSearchForm( SearchForm value ) {
		this.__parentSearchForm = value;
	}


}

