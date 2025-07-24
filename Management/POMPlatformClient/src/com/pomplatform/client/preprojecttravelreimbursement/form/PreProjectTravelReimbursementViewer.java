package com.pomplatform.client.preprojecttravelreimbursement.form;

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
import com.pomplatform.client.preprojecttravelreimbursement.datasource.DSPreProjectTravelReimbursement;
import com.pomplatform.client.preprojecttravelreimbursement.datasource.DSTravelReimbursementDetail;
import com.pomplatform.client.preprojecttravelreimbursement.datasource.DSTravelReimbursementLinkMainProject;
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

public class PreProjectTravelReimbursementViewer extends AbstractDetailViewer
{


	private final DelicacyListGrid travelReimbursementDetailsGrid = new DelicacyListGrid();
	private final DelicacyListGrid travelReimbursementLinkMainProjectsGrid = new DelicacyListGrid();
	private final DelicacyListGrid processBillListGrid = new DelicacyListGrid();
	private SearchForm __parentSearchForm;
	private String processName;
	private Integer processType;

	public PreProjectTravelReimbursementViewer() {
	}

	@Override
	public void initComponents() {
		super.initComponents();
		travelReimbursementDetailsGrid.setDataSource(DSTravelReimbursementDetail.getInstance());
		travelReimbursementDetailsGrid.addDoubleClickHandler(new DoubleClickHandler(){
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("");
				detail.setWidth(700); detail.setHeight(500); 
				TravelReimbursementDetailViewer viewer = new TravelReimbursementDetailViewer();
				viewer.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_NORMAL);
				viewer.initComponents();
				viewer.viewSelectedData((ListGrid)event.getSource());
				detail.setContent(viewer);
				detail.centerInPage();detail.show();
			}
		});
		travelReimbursementLinkMainProjectsGrid.setDataSource(DSTravelReimbursementLinkMainProject.getInstance());
		travelReimbursementLinkMainProjectsGrid.addDoubleClickHandler(new DoubleClickHandler(){
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("");
				detail.setWidth(700); detail.setHeight(500); 
				TravelReimbursementLinkMainProjectViewer viewer = new TravelReimbursementLinkMainProjectViewer();
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
		return "项目前期差旅报销";
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
		params.put("travelReimbursementId", getBusinessId());
		DBDataSource.callOperation("NQ_PreProjectTravelReimbursement", "find", new DSCallback() {
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
		condition.put("travelReimbursementId", selected.getAttributeAsString("travelReimbursementId"));
		DBDataSource.callOperation("ST_TravelReimbursementDetail", "find", condition, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					travelReimbursementDetailsGrid.setData(dsResponse.getData());
				}
			}
		});
		condition = new java.util.HashMap();
		condition.put("travelReimbursementId", selected.getAttributeAsString("travelReimbursementId"));
		DBDataSource.callOperation("ST_TravelReimbursementLinkMainProject", "find", condition, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					travelReimbursementLinkMainProjectsGrid.setData(dsResponse.getData());
				}
			}
		});
		condition = new HashMap<>();
		condition.put("opt_type", "getBillListByBusinessidProcesstype");
		condition.put("businessId", selected.getAttributeAsString("travelReimbursementId"));
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
		return DSPreProjectTravelReimbursement.getInstance();
	}

	@Override
	public int getDetailCount(){
		return 3;
	}

	@Override
	public List<ListGrid> getDetailListGrids() {
		List<ListGrid> res = new ArrayList<ListGrid>();
		res.add(travelReimbursementDetailsGrid);
		res.add(travelReimbursementLinkMainProjectsGrid);
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

