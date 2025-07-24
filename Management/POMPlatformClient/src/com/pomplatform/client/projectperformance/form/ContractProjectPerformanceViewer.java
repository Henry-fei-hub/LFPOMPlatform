package com.pomplatform.client.projectperformance.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.GroupColumn;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.projectperformance.datasource.DSContractProjectPerformance;
import com.pomplatform.client.projectperformance.datasource.DSProjectPerformanceDetail;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.viewer.DetailViewer;

public class ContractProjectPerformanceViewer extends AbstractDetailViewer{
	private DelicacyListGrid performanceAchieveGrid = new DelicacyListGrid();
	private DelicacyListGrid performancePayGrid = new DelicacyListGrid();

	private SearchForm __parentSearchForm;


	public ContractProjectPerformanceViewer() {
	}

	@Override
	public void initComponents() {
		super.initComponents();
		performanceAchieveGrid.setDataSource(DSProjectPerformanceDetail.getInstance());
		performanceAchieveGrid.setShowRowNumbers(true);
		performanceAchieveGrid.setAutoFitFieldWidths(false);
		
		performancePayGrid.setDataSource(DSProjectPerformanceDetail.getInstance());
		performancePayGrid.setShowRowNumbers(true);
		performancePayGrid.setAutoFitFieldWidths(false);
	}

	@Override
	public int getHorizontalPercent() {
		return 0;
	}

	@Override
	public String getName() {
		return "合同项目绩效";
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
		DBDataSource.callOperation("NQ_ContractProjectPerformance", "find", new DSCallback() {
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
		Record record = grid.getSelectedRecord();
		//获取合同ID
		int contractId = BaseHelpUtils.getIntValue(record.getAttribute("contractId"));
		//获取项目经理ID
		int employeeId = BaseHelpUtils.getIntValue(record.getAttribute("projectManageId"));
		int businessType = 1;//说明是项目经理绩效
		int performanceFlag = 2;//说明是奖励积分
		Map<String,Object> param = new HashMap<>();
		param.put("contractId", contractId);
		param.put("employeeId", employeeId);
		param.put("businessType", businessType);
		param.put("performanceFlag", performanceFlag);
		DBDataSource.callOperation("NQ_ProjectPerformanceDetail", "find", param, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					performanceAchieveGrid.setData(dsResponse.getData());
					//奖励
					performanceAchieveGrid.getField("performanceIntegral").setTitle("绩效奖励");
					performanceAchieveGrid.getField("percent").setTitle("奖励比例(%)");
					performanceAchieveGrid.getField("reason").setHidden(true);
					performanceAchieveGrid.getField("remark").setTitle("奖励说明");
					LinkedHashMap<String, String> linked = new LinkedHashMap<>();
					linked.put("0", "按比例奖励积分");
					linked.put("1", "按绩效奖励积分");
					performanceAchieveGrid.getField("type").setValueMap(linked);
				}
			}
		});
		performanceFlag = 1;//说明是扣除积分
		param.put("performanceFlag", performanceFlag);
		DBDataSource.callOperation("NQ_ProjectPerformanceDetail", "find", param, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					performancePayGrid.setData(dsResponse.getData());
					//惩罚
					performancePayGrid.getField("performanceIntegral").setTitle("绩效扣除");
					performancePayGrid.getField("percent").setTitle("扣除比例(%)");
					performancePayGrid.getField("reason").setHidden(false);
					performancePayGrid.getField("remark").setTitle("惩罚说明");
					LinkedHashMap<String, String> linked = new LinkedHashMap<>();
					linked.put("0", "按比例扣除积分");
					linked.put("1", "按绩效扣除积分");
					performancePayGrid.getField("type").setValueMap(linked);
					performancePayGrid.redraw();
				}
			}
		});
	}

	public void viewDetailData(){
	}

	@Override
	public DataSource getMainDataSource() {
		return DSContractProjectPerformance.getInstance();
	}

	@Override
	public int getDetailCount(){
		return 2;
	}

	@Override
	public List<ListGrid> getDetailListGrids() {
		List<ListGrid> res = new ArrayList<ListGrid>();
		res.add(performanceAchieveGrid);
		res.add(performancePayGrid);
		return res;
	}

	@Override
	public List<String> getDetailNames() {
		List<String> res = new ArrayList<String>();
		res.add("绩效奖励积分明细");
		res.add("绩效扣除积分明细");
		return res;
	}

	public SearchForm getParentSearchForm() {
		return this.__parentSearchForm;
	}

	public void setParentSearchForm( SearchForm value ) {
		this.__parentSearchForm = value;
	}


}

