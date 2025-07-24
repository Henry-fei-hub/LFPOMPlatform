package com.pomplatform.client.projectstages.form;

import java.math.BigDecimal;
import java.util.*;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.smartgwt.client.data.Criteria;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.SelectionChangedHandler;
import com.smartgwt.client.widgets.grid.events.SelectionEvent;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.widgets.TransferImgButton;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeNode;
import java.util.logging.Logger;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.pomplatform.client.projectstages.datasource.DSProjectStageProcessDetail;
import com.pomplatform.client.projectstages.datasource.DSSprojectstagecor;

public class ProjectStagesProcessApplicationDetailProjectStageProcessDetail extends AbstractWizadPage
{

	private static final Logger __logger = Logger.getLogger("");
	private DSCallback __startLoadedDetail;
	private DSCallback __endLoadedDetail;
	private final DelicacyListGrid grid = new DelicacyListGrid() {
		@Override
		protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
			//获取本次确认积分
			int isSure = BaseHelpUtils.getIntValue(record.getAttribute("isSure"));
			if (isSure == 1) {
				return "color: red;";
			}
			else {
				return super.getCellCSSText(record, rowNum, colNum);
			}
		}
	};
	public ProjectStagesProcessApplicationDetailProjectStageProcessDetail(ProjectStagesProcessApplicationNewForm projectStagesProcessApplicationNewForm){


		HLayout projectStageProcessDetails = new HLayout();
		projectStageProcessDetails.setWidth100();
		projectStageProcessDetails.setHeight100();
		grid.setDataSource(DSSprojectstagecor.getInstance());
		grid.setAutoFitFieldWidths(false);
//		grid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		grid.setCanRemoveRecords(false);
		grid.setShowGridSummary(true);
		grid.setCanEdit(false);
		grid.addSelectionChangedHandler(new SelectionChangedHandler() {
			
			@Override
			public void onSelectionChanged(SelectionEvent event) {
				ListGridRecord[] selectedRecords = grid.getSelectedRecords();
				BigDecimal notProjectAmountSum =BigDecimal.ZERO;
				if(selectedRecords.length>0) {
					for (ListGridRecord listGridRecord : selectedRecords) {
						BigDecimal notProjectAmount = BaseHelpUtils.getBigDecimalValue(listGridRecord.getAttribute("projectAmount"));
						notProjectAmountSum = notProjectAmountSum.add(notProjectAmount);
					}
				}
				projectStagesProcessApplicationNewForm.getItems().get("applyAmount").setValue(notProjectAmountSum);
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
			loadValue(getRecord());
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
					ListGridRecord[] records = grid.getRecords();
					for (ListGridRecord record : records){
						String projectAmount = record.getAttribute("projectAmount");
						if("0".equals(projectAmount)){
							record.setEnabled(false);
						}
					}
					if(__endLoadedDetail != null) __endLoadedDetail.execute(dsResponse, data, dsRequest);
				}
			}
		});
	}

	public void loadValue(Record record) {
		Map condition = new HashMap();
		int projectStageProcessRecordId = BaseHelpUtils.getIntValue(record.getAttribute("projectStageProcessRecordId"));
		condition.put("contractId", record.getAttribute("contractId"));
		condition.put("addtionalCondition", " order by project_stage_id");
		condition.put("projectStageProcessRecordId", projectStageProcessRecordId);
		DBDataSource.callOperation("NQ_LoadCurrentProjectStageProcessDetail", "find", condition, new DSCallback() {
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

}

