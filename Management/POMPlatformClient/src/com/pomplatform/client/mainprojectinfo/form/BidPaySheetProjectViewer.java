package com.pomplatform.client.mainprojectinfo.form;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import com.smartgwt.client.widgets.viewer.DetailViewer;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.SectionStack;
import com.smartgwt.client.widgets.layout.SectionStackSection;
import com.smartgwt.client.widgets.layout.SplitPane;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.data.*;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.VisibilityMode;
import com.smartgwt.client.util.SC;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.GroupColumn;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.GenericViewWindow;
import com.smartgwt.client.widgets.form.SearchForm;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.mainprojectinfo.datasource.DSBidPaySheetProject;
import com.pomplatform.client.mainprojectinfo.datasource.DSproject;
import com.pomplatform.client.sprojectadvancerecord.datasource.DSSProjectAdvanceRecord;

public class BidPaySheetProjectViewer extends AbstractDetailViewer
{


	private SearchForm __parentSearchForm;
	private DelicacyListGrid projectGrid = new DelicacyListGrid();
	private SplitPane mainPane;
	public BidPaySheetProjectViewer() {
	}

	@Override
	public void initComponents() {
		super.initComponents();
		int d = 0;
		ListGridField[] dFields = new ListGridField[6];
		dFields[d] = new ListGridField("projectId");
		dFields[d].setHidden(true);
		d++;
		dFields[d] = new ListGridField("contractCode","订单编号");
		dFields[d].setWidth("25%");
		d++;
		dFields[d] = new ListGridField("projectName","项目名称");
		dFields[d].setWidth("25%");
		d++;
		dFields[d] = new ListGridField("plateId","业务部门");
		dFields[d].setValueMap(KeyValueManager.getValueMap("plate_records"));
		dFields[d].setWidth("25%");
		d++;
		dFields[d] = new ListGridField("totalAmount","落标补偿金");
		dFields[d].setWidth("25%");
		projectGrid.setDataSource(DSproject.getInstance());
		projectGrid.setShowRowNumbers(true);
		projectGrid.setFields(dFields);
		projectGrid.setShowGridSummary(false);
		projectGrid.setAutoFitFieldWidths(true);
	}

	@Override
	public int getHorizontalPercent() {
		return 40;
	}

	@Override
	public String getName() {
		return "BidPaySheetProject";
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
		params.put("personnelBusinessId", getBusinessId());
		DBDataSource.callOperation("NQ_BidPaySheetProject", "find", new DSCallback() {
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
		SC.debugger();
		Record selected = getRecord();
		int contractId = BaseHelpUtils.getIntValue(selected.getAttribute("linkId"));
		if(contractId>0) {
			Map params = new HashMap();
			params.put("contractId", contractId);
			params.put("projectType", 66);//投标订单
			DBDataSource.callOperation("ST_Project", "find",params, new DSCallback() {
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					if(dsResponse.getStatus() >= 0){
						if(dsResponse.getData().length>0) {
							projectGrid.setData(dsResponse.getData());
						}
					}
				}
			});
		}

	}

	@Override
	public DataSource getMainDataSource() {
		return DSBidPaySheetProject.getInstance();
	}

	@Override
	public int getDetailCount(){
		return 1;
	}

	@Override
	public List<ListGrid> getDetailListGrids() {
		List<ListGrid> res = new ArrayList<ListGrid>();
		res.add(projectGrid);
		return res;
	}

	@Override
	public List<String> getDetailNames() {
		List<String> res = new ArrayList<String>();
		res.add("投标订单信息");
		return res;
	}

	public SearchForm getParentSearchForm() {
		return this.__parentSearchForm;
	}

	public void setParentSearchForm( SearchForm value ) {
		this.__parentSearchForm = value;
	}


}

