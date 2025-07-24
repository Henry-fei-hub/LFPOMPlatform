package com.pomplatform.client.approveprojectstagestorageor.form;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import com.smartgwt.client.widgets.viewer.DetailViewer;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.data.*;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.GroupColumn;
import com.delicacy.client.ui.GenericViewWindow;
/*import com.pomplatform.client.approveprojectstagestorageor.datasource.DSProjectStage;
import com.pomplatform.client.approveprojectstagestorageor.datasource.DSProjectStageStorage;
import com.pomplatform.client.approveprojectstagestorageor.datasource.DSProjectStageStorage2;
import com.pomplatform.client.approveprojectstagestorageor.datasource.DSapproveprojectstagestoragecor;*/
import com.pomplatform.client.projectStageStorage.datasource.DSSprojectstagestorageor;
import com.smartgwt.client.widgets.form.SearchForm;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.DelicacyListGrid;

public class approveprojectstagestoragecorViewer extends AbstractDetailViewer
{


	private final DelicacyListGrid projectStageStoragesGrid = new DelicacyListGrid();
	private final DelicacyListGrid projectStagesGrid = new DelicacyListGrid();
	private SearchForm __parentSearchForm;


	public approveprojectstagestoragecorViewer() {
	}		
	
	@Override
	public void initComponents() {
		super.initComponents();
//		projectStageStoragesGrid.setDataSource(DSProjectStageStorage2.getInstance());
		projectStageStoragesGrid.setAutoFitFieldWidths(true);
		projectStageStoragesGrid.addDoubleClickHandler(new DoubleClickHandler(){
			@Override
			public void onDoubleClick(DoubleClickEvent event) {/*
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("请求审核项目阶段记录");
				detail.setWidth(700);
				detail.setHeight(500); 
				ProjectStageStorageViewer viewer = new ProjectStageStorageViewer();
				viewer.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_NORMAL);
				viewer.initComponents();
				viewer.viewSelectedData((ListGrid)event.getSource());
				detail.setContent(viewer);
				detail.centerInPage();detail.show();
			*/}
		});
//		projectStagesGrid.setDataSource(DSProjectStage.getInstance());
		projectStagesGrid.setDataSource(DSSprojectstagestorageor.getInstance());
		projectStagesGrid.setAutoFitFieldWidths(false);
		projectStagesGrid.addDoubleClickHandler(new DoubleClickHandler(){
			@Override
			public void onDoubleClick(DoubleClickEvent event) {/*
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("现有项目阶段记录");
				detail.setWidth(700);
				detail.setHeight(500); 
				ProjectStageViewer viewer = new ProjectStageViewer();
				viewer.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_NORMAL);
				viewer.initComponents();
				viewer.viewSelectedData((ListGrid)event.getSource());
				detail.setContent(viewer);
				detail.centerInPage();
				detail.show();
			*/}
		});
	}

	@Override
	public int getHorizontalPercent() {
		return 0;
	}

	@Override
	public String getName() {
		return "approveprojectstagestoragecor";
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
		params.put("approveProjectStageStorageId", getBusinessId());
		DBDataSource.callOperation("NQ_approveprojectstagestoragecor", "find", new DSCallback() {
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
		condition.put("projectId", selected.getAttributeAsString("projectId"));
		DBDataSource.callOperation("ST_ProjectStageStorage", "find", condition, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					projectStageStoragesGrid.setData(dsResponse.getData());
				}
			}
		});
		
        Map params = new HashMap();
		 //加载项目每个阶段已确认积分
		params.put("projectId",selected.getAttributeAsString("projectId"));
        DBDataSource.callOperation("NQ_OnLoadProjectStageSettlement", "find", params, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                	Record[] data2 = dsResponse.getData();

                	for (Record record : data2) {
                		BigDecimal settlementIntegral=BigDecimal.ZERO;
                    	int attachmentNum=0;
                    	//是否跨阶段
                		 attachmentNum = BaseHelpUtils.getIntValue(record.getAttribute("attachmentNum"));
             			if(attachmentNum>0) {
            				record.setAttribute("riginalPlan", 0);
            			}else {
            				record.setAttribute("riginalPlan", 1);
            			}
                		settlementIntegral= BaseHelpUtils.getBigDecimalValue(record.getAttribute("settlementIntegral"));
                		//已确认积分
                		record.setAttribute("projectConfirmAmount",settlementIntegral);
					}
                	projectStagesGrid.setData(data2);
                }
            }
        });
		
/*		condition = new java.util.HashMap();
		condition.put("projectId", selected.getAttributeAsString("projectId"));
		DBDataSource.callOperation("ST_ProjectStage", "find", condition, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					projectStagesGrid.setData(dsResponse.getData());
				}
			}
		});*/
	}

	@Override
	public DataSource getMainDataSource() {
		return null;
//		return DSapproveprojectstagestoragecor.getInstance();
	}

	@Override
	public int getDetailCount(){
		return 2;
	}

	@Override
	public List<ListGrid> getDetailListGrids() {
		List<ListGrid> res = new ArrayList<ListGrid>();
		res.add(projectStageStoragesGrid);
		res.add(projectStagesGrid);
		return res;
	}

	@Override
	public List<String> getDetailNames() {
		List<String> res = new ArrayList<String>();
		res.add("请求审核项目阶段记录表");
		res.add("已有项目阶段记录");
		return res;
	}

	public SearchForm getParentSearchForm() {
		return this.__parentSearchForm;
	}

	public void setParentSearchForm( SearchForm value ) {
		this.__parentSearchForm = value;
	}


}

