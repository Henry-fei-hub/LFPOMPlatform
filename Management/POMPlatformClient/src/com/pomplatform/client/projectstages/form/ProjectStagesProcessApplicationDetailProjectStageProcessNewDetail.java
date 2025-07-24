package com.pomplatform.client.projectstages.form;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.projectstages.datasource.DSProjectStageProcessDetail;
import com.pomplatform.client.projectstages.datasource.DSSprojectstagecor;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.SelectionChangedHandler;
import com.smartgwt.client.widgets.grid.events.SelectionEvent;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

public class ProjectStagesProcessApplicationDetailProjectStageProcessNewDetail extends AbstractWizadPage
{

	private static final Logger __logger = Logger.getLogger("");
	private DSCallback __startLoadedDetail;
	private DSCallback __endLoadedDetail;
	private DelicacyListGrid grid = new DelicacyListGrid(true);
	public ProjectStagesProcessApplicationDetailProjectStageProcessNewDetail(ProjectStagesProcessApplicationNewForm projectStagesProcessApplicationNewForm){


		HLayout projectStageProcessDetails = new HLayout();
		projectStageProcessDetails.setWidth100();
		projectStageProcessDetails.setHeight100();
		grid.setDataSource(DSSprojectstagecor.getInstance());
		grid.setAutoFitFieldWidths(false);
		grid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		grid.setCanRemoveRecords(false);
		grid.setShowGridSummary(true);
		grid.setCanEdit(false);
		grid.addSelectionChangedHandler(new SelectionChangedHandler() {
			
			@Override
			public void onSelectionChanged(SelectionEvent event) {
				ListGridRecord[] selectedRecords = grid.getSelectedRecords();
				BigDecimal notProjectAmountSum =BigDecimal.ZERO;
				BigDecimal currentRate = BigDecimal.ZERO;
				if(selectedRecords.length>0) {
					for (ListGridRecord listGridRecord : selectedRecords) {
						BigDecimal notProjectAmount = BaseHelpUtils.getBigDecimalValue(listGridRecord.getAttribute("projectAmount"));
						BigDecimal percent = BaseHelpUtils.getBigDecimalValue(listGridRecord.getAttribute("percent"));
						notProjectAmountSum = notProjectAmountSum.add(notProjectAmount);
						currentRate = currentRate.add(percent);
					}
				}
				//设置本次分配金额
				projectStagesProcessApplicationNewForm.getItems().get("applyAmount").setValue(notProjectAmountSum);
				//设置本次分配的比例
				projectStagesProcessApplicationNewForm.getItems().get("currentApplyRate").setValue(currentRate);
				//设置主表数据
				projectStagesProcessApplicationNewForm.loadMainValue();
			}
		});
		projectStageProcessDetails.addMember(grid);
		VLayout projectStageProcessDetailsControls = new VLayout();
		projectStageProcessDetailsControls.setHeight100();
		projectStageProcessDetailsControls.setWidth(60);
		projectStageProcessDetailsControls.setLayoutTopMargin(30);
		projectStageProcessDetailsControls.setLayoutLeftMargin(5);
		projectStageProcessDetailsControls.setLayoutRightMargin(5);
		projectStageProcessDetailsControls.setMembersMargin(10);
		projectStageProcessDetails.addMember(projectStageProcessDetailsControls);
		addMember(projectStageProcessDetails);
	}

	@Override
	public void startEdit() {
		if(getPageMode() == PAGE_MODE_UPDATE) {
			reloadDetailTableData();
		}else {
			reloadDetailTableDataNew();
		}
	}

	public void reloadDetailTableDataNew(){
		Map condition = new HashMap();
        condition.put("contractId", getRecord().getAttribute("contractId"));
        condition.put("addtionalCondition", " order by project_stage_id");
        DBDataSource.callOperation("NQ_Sprojectstagecor", "find", condition, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                	grid.setData(dsResponse.getData());
					ListGridRecord[] records = grid.getRecords();
					for (ListGridRecord record : records){
						String projectAmount = record.getAttribute("projectAmount");
						if("0".equals(projectAmount)){
							record.setEnabled(false);
						}
					}
                }
            }
        });
	}
	
	public void reloadDetailTableData(){
      Map condition = new HashMap();
		condition.put("projectStageProcessRecordId", getRecord().getAttribute("projectStageProcessRecordId"));
		condition.put("addtionalCondition", "order by project_stage_process_detail_id asc");
		DBDataSource.callOperation("ST_ProjectStageProcessDetail", "find", condition, new DSCallback(){
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
		ListGridRecord[] selectedRecords = new ListGridRecord[100];
		if(getPageMode() == PAGE_MODE_UPDATE) {
			selectedRecords = grid.getRecords();
		}else {
			selectedRecords = grid.getSelectedRecords();
		}
    	
    	if(selectedRecords.length<=0) {
    		SC.say("提示","请选择最少一个阶段");
    		return false;
    	}else {
    		for (ListGridRecord listGridRecord : selectedRecords) {
    			BigDecimal projectAmount = BaseHelpUtils.getBigDecimalValue(listGridRecord.getAttribute("projectAmount"));
    			String stageName = listGridRecord.getAttribute("stageName");
    			if(projectAmount.compareTo(BigDecimal.ZERO)<=0) {	
    				SC.say("提示",stageName+"阶段未确认积分小于等于0,请勿勾选！");
    				return false;
    			}
			}
    	}
		return true;
	}

	@Override
	public Set<String> getItemNames() {
		Set<String> res = new HashSet<>();
		res.add("detailProjectStageProcessDetail");
		return res;
	}

	@Override
	public boolean isTheValuesEmpty() {
		ListGridRecord[] rows = grid.getRecords();
		return rows == null || rows.length == 0;
	}

	@Override
	public Map getValuesAsMap() {
		SC.debugger();
		Map param = new HashMap();
		ListGridRecord[] rows = new ListGridRecord[100];
		if(getPageMode() == PAGE_MODE_UPDATE) {
			rows =grid.getRecords();
		}else {
			rows =grid.getSelectedRecords();
		}
		
		if(rows.length>0) {
			param.put("mainProjectId", BaseHelpUtils.getIntValue(rows[0].getAttribute("mainProjectId")));
		}
		param.put("operateEmployeeId",BaseHelpUtils.getIntValue( ClientUtil.getUserId()));
		MapUtils.convertRecordToMap(DSProjectStageProcessDetail.getInstance(), rows, param, "detailProjectStageProcessDetail");
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


}

