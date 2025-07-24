package com.pomplatform.client.contractsrecords.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.GroupColumn;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.aboutcontractsrecord.datasource.DSAboutContractsRecord;
import com.pomplatform.client.contractsrecords.datasource.DSContractsRecords;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.viewer.DetailViewer;

public class ContractsRecordsViewer extends AbstractDetailViewer
{


	private SearchForm __parentSearchForm;
	private final DelicacyListGrid ContractRecordsGrid = new DelicacyListGrid();

	public ContractsRecordsViewer() {
	}

	@Override
	public void initComponents() {
		super.initComponents();
		ContractRecordsGrid.setDataSource(DSAboutContractsRecord.getInstance());
	}

	@Override
	public int getHorizontalPercent() {
		return 0;
	}

	@Override
	public String getName() {
		return "合同信息";
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
		params.put("contractsRecordsId", getBusinessId());
		DBDataSource.callOperation("NQ_ContractsRecords", "find", new DSCallback() {
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
		Record selected = grid.getSelectedRecord();
		Map<String,Object> params = new HashMap<>();
		int contractId = BaseHelpUtils.getIntValue(selected.getAttribute("contractId"));
		String infoCode=BaseHelpUtils.getString(selected.getAttribute("infoCode"));
		if(contractId>0) {
			params.put("contractId", contractId);
		}
		if(infoCode.length()>0) {
			params.put("infoCode", infoCode);
		}
		 DBDataSource.callOperation("NQ_AboutContractsRecord",params, new DSCallback() {
	            @Override
	            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
	                if (dsResponse.getStatus() >= 0) {
	                	ContractRecordsGrid.setData(dsResponse.getData());
	                }
	            }
			});
		
		
		viewDetailData();
	}

	public void viewDetailData(){
	}
	


	@Override
	public DataSource getMainDataSource() {
		return DSContractsRecords.getInstance();
	}

	@Override
	public int getDetailCount(){
		return 1;
	}

	@Override
	public List<ListGrid> getDetailListGrids() {
		List<ListGrid> res = new ArrayList<ListGrid>();
		res.add(ContractRecordsGrid);
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

