package com.pomplatform.client.preprojectnormalreimbursement.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.GroupColumn;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.memployeemoneymanageeeedcieftrcvmmor.panel.MemployeemoneymanageeeedcieftrcvmmorPanel;
import com.pomplatform.client.preprojectnormalreimbursement.datasource.DSNormalReimbursementLinkMainProject;
import com.pomplatform.client.preprojectnormalreimbursement.datasource.DSPreProjectNormalReimbursement;
import com.pomplatform.client.preprojectnormalreimbursement.datasource.DSProjectNormalReimbursementDetail;
import com.pomplatform.client.spaymoneymanagemmcor.panel.SpaymoneymanagemmcorPanel;
import com.pomplatform.client.sprocessbilllistpppor.datasource.DSSprocessbilllistpppor;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.viewer.DetailViewer;

public class PreProjectNormalReimbursementViewer extends AbstractDetailViewer
{


	private final DelicacyListGrid projectNormalReimbursementDetailsGrid = new DelicacyListGrid();
	private final DelicacyListGrid normalReimbursementLinkMainProjectsGrid = new DelicacyListGrid();
	private final DelicacyListGrid processBillListGrid = new DelicacyListGrid();
	private SearchForm __parentSearchForm;
	private String processName;
	private Integer processType;

	public PreProjectNormalReimbursementViewer() {
	}

	@Override
	public void initComponents() {
		super.initComponents();
		projectNormalReimbursementDetailsGrid.setDataSource(DSProjectNormalReimbursementDetail.getInstance());
		projectNormalReimbursementDetailsGrid.addDoubleClickHandler(new DoubleClickHandler(){
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("");
				detail.setWidth(700); detail.setHeight(500); 
				ProjectNormalReimbursementDetailViewer viewer = new ProjectNormalReimbursementDetailViewer();
				viewer.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_NORMAL);
				viewer.initComponents();
				viewer.viewSelectedData((ListGrid)event.getSource());
				detail.setContent(viewer);
				detail.centerInPage();detail.show();
			}
		});
		normalReimbursementLinkMainProjectsGrid.setDataSource(DSNormalReimbursementLinkMainProject.getInstance());
		
		
		
		normalReimbursementLinkMainProjectsGrid.addDoubleClickHandler(new DoubleClickHandler(){
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("");
				detail.setWidth(700); detail.setHeight(500); 
				NormalReimbursementLinkMainProjectViewer viewer = new NormalReimbursementLinkMainProjectViewer();
				viewer.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_NORMAL);
				viewer.initComponents();
				viewer.viewSelectedData((ListGrid)event.getSource());
				detail.setContent(viewer);
				detail.centerInPage();detail.show();
			}
		});
		processBillListGrid.setDataSource(DSSprocessbilllistpppor.getInstance());
		processBillListGrid.setSelectionType(SelectionStyle.SINGLE);
		if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.VIEW_ALL_MONEY)){
			processBillListGrid.addDoubleClickHandler(new DoubleClickHandler() {
				
				@Override
				public void onDoubleClick(DoubleClickEvent event) {
					if(processBillListGrid.anySelected()){
						
						Record record = processBillListGrid.getSelectedRecord();
						int payFor = record.getAttributeAsInt("payFor");
						PopupWindow window = new PopupWindow();
						window.setWidth100();
						window.setHeight100();
						window.centerInPage();
						
						if(payFor == 1){//个人
							window.setTitle("个人借款信息");
							MemployeemoneymanageeeedcieftrcvmmorPanel panel = new MemployeemoneymanageeeedcieftrcvmmorPanel();
							panel.initData(record);
							window.addItem(panel);
						}else{//收款单位
							window.setTitle("单位预付款信息");
							SpaymoneymanagemmcorPanel panel = new SpaymoneymanagemmcorPanel();
							panel.initData(record);
							window.addItem(panel);
						}
						window.show();
					}
				}
			});
		}
	}

	@Override
	public int getHorizontalPercent() {
		return 0;
	}

	@Override
	public String getName() {
		return "前期项目日常报销";
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
		params.put("projectNormalReimbursementId", getBusinessId());
		DBDataSource.callOperation("NQ_PreProjectNormalReimbursement", "find", new DSCallback() {
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
		condition.put("projectNormalReimbursementId", selected.getAttributeAsString("projectNormalReimbursementId"));
		DBDataSource.callOperation("ST_ProjectNormalReimbursementDetail", "find", condition, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					projectNormalReimbursementDetailsGrid.setData(dsResponse.getData());
				}
			}
		});
		condition = new java.util.HashMap();
		condition.put("projectNormalReimbursementId", selected.getAttributeAsString("projectNormalReimbursementId"));
		DBDataSource.callOperation("ST_NormalReimbursementLinkMainProject", "find", condition, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					normalReimbursementLinkMainProjectsGrid.setData(dsResponse.getData());
				}
			}
		});
		condition = new HashMap<>();
		condition.put("opt_type", "getBillListByBusinessidProcesstype");
		condition.put("businessId", selected.getAttributeAsString("projectNormalReimbursementId"));
		condition.put("processType", getProcessType());
		DBDataSource.callOperation("EP_CustomSprocessbilllistppporProcess", condition, new DSCallback() {

			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					processBillListGrid.setData(dsResponse.getData());
				}
			}
		});
	}

	@Override
	public DataSource getMainDataSource() {
		return DSPreProjectNormalReimbursement.getInstance();
	}

	@Override
	public int getDetailCount(){
		return 3;
	}

	@Override
	public List<ListGrid> getDetailListGrids() {
		List<ListGrid> res = new ArrayList<ListGrid>();
		res.add(projectNormalReimbursementDetailsGrid);
		res.add(normalReimbursementLinkMainProjectsGrid);
		res.add(processBillListGrid);
		return res;
	}

	@Override
	public List<String> getDetailNames() {
		List<String> res = new ArrayList<String>();
		res.add("");
		res.add("");
		res.add("账单流水");
		return res;
	}

	public SearchForm getParentSearchForm() {
		return this.__parentSearchForm;
	}

	public void setParentSearchForm( SearchForm value ) {
		this.__parentSearchForm = value;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public Integer getProcessType() {
		return processType;
	}

	public void setProcessType(Integer processType) {
		this.processType = processType;
	}

}

