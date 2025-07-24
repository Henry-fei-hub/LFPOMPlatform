package com.pomplatform.client.approveprojectstagestorageor.form;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import com.smartgwt.client.widgets.viewer.DetailViewer;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.data.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.GroupColumn;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.GenericViewWindow;
import com.pomplatform.client.projectStageStorage.datasource.DSSprojectstagestorageor;
import com.pomplatform.client.projectStageStorage.datasource.DSSprojectstagestorageor2;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.DelicacyListGrid;

public class SapproveprojectstagestorageorViewer extends AbstractDetailViewer
{


	private final DelicacyListGrid projectStageStoragesGrid = new DelicacyListGrid();
	private final DelicacyListGrid projectStagesGrid = new DelicacyListGrid();
	private SearchForm __parentSearchForm;
    private  DelicacyListGrid newGrid = new DelicacyListGrid();
    private  DelicacyListGrid oldGrid = new DelicacyListGrid();
	private  TextItem remarkItem;
	private TextItem projectNameItem;
	private TextItem projectIntegralItem;
	private SelectItem projectManageIdItem;
	private TextItem contractCodeItem;
    private  DynamicForm form;
    private  DynamicForm form2;
    private  DynamicForm form3;
    private int projectId;
    private int status;
	private Record[] data;



	public SapproveprojectstagestorageorViewer() {
		
	}

	public void initComponents(Record record) {
		projectId=BaseHelpUtils.getIntValue(record.getAttribute("projectId"));
		 VLayout SearchSourceLayout = new VLayout();
	        SearchSourceLayout.setWidth100();
	        SearchSourceLayout.setHeight100();
	        SearchSourceLayout.setLayoutTopMargin(10);
	        SearchSourceLayout.setLayoutRightMargin(5);
	        SearchSourceLayout.setMembersMargin(10);
	        SearchSourceLayout.setShowResizeBar(false);
	        
	        
	        HLayout baseLayout = new HLayout(5);
	        baseLayout.setWidth100();
	        baseLayout.setHeight("20");
	        projectNameItem = new TextItem("projectName","订单名称");
	        projectNameItem.setWidth("*");
	        projectNameItem.setValue(record.getAttribute("projectName"));
	        projectNameItem.setCanEdit(false);
	        
	        projectIntegralItem = new TextItem("projectIntegral","项目积分");
	        projectIntegralItem.setWidth("*");
//	        projectIntegralItem.setValue(record.getAttribute("projectIntegral"));
	        projectIntegralItem.setCanEdit(false);
	        
	        contractCodeItem = new TextItem("contractCode","订单编号");
	        contractCodeItem.setWidth("*");
	        contractCodeItem.setValue(record.getAttribute("contractCode"));
	        contractCodeItem.setCanEdit(false);
	        
	        projectManageIdItem =new SelectItem("projectManageId","专业负责人");
	        projectManageIdItem.setWidth("*");
	        projectManageIdItem.setCanEdit(false);
	        projectManageIdItem.setValue(record.getAttribute("projectManageId"));
	        KeyValueManager.loadValueMap("employees", projectManageIdItem);

	        form = new DynamicForm();
	        form.setNumCols(8);
	        form.setWidth100();
	        form.setHeight100();
	        form.setItems(contractCodeItem,projectNameItem,projectIntegralItem,projectManageIdItem);
	        baseLayout.addMember(form);
	        SearchSourceLayout.addMember(baseLayout);
	        
	        HLayout remarkLayout = new HLayout();
	        remarkLayout.setWidth("90%");
	        remarkLayout.setHeight("10%");
	        remarkItem=new TextItem("remark","备注");
	        remarkItem.setWidth("*");
	        remarkItem.setHeight(100);
	        remarkItem.setCanEdit(false);
//	        remarkItem.setValue(r.getAttribute("remark"));
	        form2 = new DynamicForm();
	        form2.setWidth100();
	        form2.setHeight100();
	        form2.setItems(remarkItem);
	        remarkLayout.addMember(form2);
	        SearchSourceLayout.addMember(remarkLayout);
	        
	        HLayout centerLayout = new HLayout(5);
	        centerLayout.setWidth100();
	        centerLayout.setHeight100();
	        
	        HLayout leftLayout = new HLayout(5);
	        leftLayout.setWidth100();
	        leftLayout.setHeight100();
	        
	        HLayout rightLayout = new HLayout(5);
	        rightLayout.setWidth100();
	        rightLayout.setHeight100();
	        
	        //左侧新数据
	        newGrid.setAutoFitFieldWidths(false);
	        newGrid.setDataSource(DSSprojectstagestorageor2.getInstance());
	        newGrid.setHeaderHeight(60);  
	        newGrid.setHeaderSpans(new HeaderSpan[] {
			   new HeaderSpan("现策划阶段", new String[] {"stageName","percent","projectAmount","remark"})
		    });
	        leftLayout.addMember(newGrid);
	        
	        //右侧旧数据加载
	        oldGrid.setAutoFitFieldWidths(false);
	        oldGrid.setDataSource(DSSprojectstagestorageor.getInstance());
	        oldGrid.setHeaderHeight(60);  
	        oldGrid.setHeaderSpans(new HeaderSpan[] {
	 			   new HeaderSpan("原策划阶段", new String[] {"stageName","percent","projectAmount","tabAmount","riginalPlan","projectConfirmAmount","remark"})
	 			    });
	        rightLayout.addMember(oldGrid);
	        
	        //已完成的则不显示左侧数据
/*	        status= BaseHelpUtils.getIntValue(record.getAttribute("status"));
	        if(status!=3&&status!=5) {
	        	centerLayout.addMember(leftLayout);
	        }*/
	        centerLayout.addMember(leftLayout);
	        centerLayout.addMember(rightLayout);
	        SearchSourceLayout.addMember(centerLayout);
	        projectStageStoragesGrid.addMember(SearchSourceLayout);
	        loadOldGridData(projectId);
	        loadNewGridData(projectId);
	        addMember(SearchSourceLayout);
	
		/*projectStageStoragesGrid.setDataSource(DSProjectStageStorage.getInstance());
		projectStageStoragesGrid.addDoubleClickHandler(new DoubleClickHandler(){
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("--项目阶段记录表");
				detail.setWidth(700); detail.setHeight(500); 
				ProjectStageStorageViewer viewer = new ProjectStageStorageViewer();
				viewer.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_NORMAL);
				viewer.initComponents();
				viewer.viewSelectedData((ListGrid)event.getSource());
				detail.setContent(viewer);
				detail.centerInPage();
				detail.show();
			}
		});
		projectStagesGrid.setDataSource(DSProjectStage.getInstance());
		projectStagesGrid.addDoubleClickHandler(new DoubleClickHandler(){
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("");
				detail.setWidth(700); detail.setHeight(500); 
				ProjectStageViewer viewer = new ProjectStageViewer();
				viewer.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_NORMAL);
				viewer.initComponents();
				viewer.viewSelectedData((ListGrid)event.getSource());
				detail.setContent(viewer);
				detail.centerInPage();
				detail.show();
			}
		});*/
	}

	@Override
	public int getHorizontalPercent() {
		return 0;
	}

	@Override
	public String getName() {
		return "自定义项目阶段模板详情";
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
		DBDataSource.callOperation("NQ_Sapproveprojectstagestorageor", "find", new DSCallback() {
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

	//加载旧数据
    public void loadOldGridData(int projectId) {
        Map params = new HashMap();
		 //加载项目每个阶段已确认积分
		params.put("projectId",projectId);
		SC.debugger();
        DBDataSource.callOperation("NQ_OnLoadProjectStageSettlement", "find", params, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
    			SC.debugger();
                if (dsResponse.getStatus() >= 0) {
    				BigDecimal sum=BigDecimal.ZERO;
                	Record[] data2 = dsResponse.getData();
                	if(data2.length>0) {
                		for (Record r : data2) {
                			BigDecimal settlementIntegral=BigDecimal.ZERO;
                			int attachmentNum=0;
                			//是否跨阶段
                			attachmentNum = BaseHelpUtils.getIntValue(r.getAttribute("attachmentNum"));
                			if(attachmentNum>0) {
                				r.setAttribute("riginalPlan",0);
                			}else {
                				r.setAttribute("riginalPlan",1);
                			}
                			settlementIntegral= BaseHelpUtils.getBigDecimalValue(r.getAttribute("settlementIntegral"));
                			//已确认积分
                			r.setAttribute("projectConfirmAmount",settlementIntegral);
                			
        					BigDecimal bigDecimalValue = BaseHelpUtils.getBigDecimalValue(r.getAttribute("projectAmount"));
        					sum=sum.add(bigDecimalValue);
/*        			        if(status==3||status==5) {
        			        	remarkItem.setValue(r.getAttribute("remark"));
        			        }*/
                		}
        				projectIntegralItem.setValue(sum);
                	}
                	oldGrid.setData(data2);
                }
            }
        });
    }
	
    //加载新数据
    public void loadNewGridData(int projectId) {
    	Map params = new HashMap();
    	//加载项目每个阶段已确认积分
    	params.put("projectId",projectId);
    	DBDataSource.callOperation("ST_ProjectStageStorage", "find", params, new DSCallback() {
    		@Override
    		public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
    			if (dsResponse.getStatus() >= 0) {
    				Record[] records = dsResponse.getData();
    				if(records.length>0) {
    					newGrid.setData(records);
    			        remarkItem.setValue(records[0].getAttribute("remark"));
    				}
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
//					projectStageStoragesGrid.setData(dsResponse.getData());
				}
			}
		});
		condition = new java.util.HashMap();
		condition.put("projectId", selected.getAttributeAsString("projectId"));
		DBDataSource.callOperation("ST_ProjectStage", "find", condition, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
//					projectStagesGrid.setData(dsResponse.getData());
				}
			}
		});
	}

	@Override
	public DataSource getMainDataSource() {
//		return DSSapproveprojectstagestorageor.getInstance();
		return null;
	}

	@Override
	public int getDetailCount(){
		return 1;
	}

	@Override
	public List<ListGrid> getDetailListGrids() {
		List<ListGrid> res = new ArrayList<ListGrid>();
//		res.add(projectStageStoragesGrid);
//		res.add(projectStagesGrid);
		return res;
	}

	@Override
	public List<String> getDetailNames() {
		List<String> res = new ArrayList<String>();
//		res.add("项目阶段记录表");
//		res.add("");
		return res;
	}

	public SearchForm getParentSearchForm() {
		return this.__parentSearchForm;
	}

	public void setParentSearchForm( SearchForm value ) {
		this.__parentSearchForm = value;
	}


}

