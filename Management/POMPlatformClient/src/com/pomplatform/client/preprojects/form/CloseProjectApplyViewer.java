package com.pomplatform.client.preprojects.form;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import com.smartgwt.client.widgets.viewer.DetailViewer;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.data.*;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.GroupColumn;
import com.delicacy.client.ui.GenericViewWindow;
import com.smartgwt.client.widgets.form.SearchForm;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.preprojects.datasource.DSCloseProjectApply;
import com.pomplatform.client.preprojects.datasource.DSMainProjectBusinessType;
import com.pomplatform.client.preprojects.datasource.DSMainProjectSpecialty;
import com.pomplatform.client.preprojects.datasource.DSMainProjectCompetitionUnit;

public class CloseProjectApplyViewer extends AbstractDetailViewer
{


	private final DelicacyListGrid mainProjectBusinessTypesGrid = new DelicacyListGrid();
	private final DelicacyListGrid mainProjectSpecialtyGrid = new DelicacyListGrid();
	private final DelicacyListGrid mainProjectCompetitionUnitsGrid = new DelicacyListGrid();
	private SearchForm __parentSearchForm;


	public CloseProjectApplyViewer() {
	}

	@Override
	public void initComponents() {
		super.initComponents();
		mainProjectBusinessTypesGrid.setDataSource(DSMainProjectBusinessType.getInstance());
		mainProjectBusinessTypesGrid.addDoubleClickHandler(new DoubleClickHandler(){
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("前期项目的业务类别子表");
				detail.setWidth(700); detail.setHeight(500); 
				MainProjectBusinessTypeViewer viewer = new MainProjectBusinessTypeViewer();
				viewer.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_NORMAL);
				viewer.initComponents();
				viewer.viewSelectedData((ListGrid)event.getSource());
				detail.setContent(viewer);
				detail.centerInPage();detail.show();
			}
		});
		mainProjectSpecialtyGrid.setDataSource(DSMainProjectSpecialty.getInstance());
		mainProjectSpecialtyGrid.addDoubleClickHandler(new DoubleClickHandler(){
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("前期项目的专业子表");
				detail.setWidth(700); detail.setHeight(500); 
				MainProjectSpecialtyViewer viewer = new MainProjectSpecialtyViewer();
				viewer.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_NORMAL);
				viewer.initComponents();
				viewer.viewSelectedData((ListGrid)event.getSource());
				detail.setContent(viewer);
				detail.centerInPage();detail.show();
			}
		});
		mainProjectCompetitionUnitsGrid.setDataSource(DSMainProjectCompetitionUnit.getInstance());
		mainProjectCompetitionUnitsGrid.addDoubleClickHandler(new DoubleClickHandler(){
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("前期项目的竞争单位子表");
				detail.setWidth(700); detail.setHeight(500); 
				MainProjectCompetitionUnitViewer viewer = new MainProjectCompetitionUnitViewer();
				viewer.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_NORMAL);
				viewer.initComponents();
				viewer.viewSelectedData((ListGrid)event.getSource());
				detail.setContent(viewer);
				detail.centerInPage();detail.show();
			}
		});
	}

	@Override
	public int getHorizontalPercent() {
		return 0;
	}

	@Override
	public String getName() {
		return "项目关闭";
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
		params.put("preProjectId", getBusinessId());
		DBDataSource.callOperation("NQ_CloseProjectApply", "find", new DSCallback() {
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
		condition.put("mainProjectId", selected.getAttributeAsString("preProjectId"));
		DBDataSource.callOperation("ST_MainProjectBusinessType", "find", condition, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					mainProjectBusinessTypesGrid.setData(dsResponse.getData());
				}
			}
		});
		condition = new java.util.HashMap();
		condition.put("mainProjectId", selected.getAttributeAsString("preProjectId"));
		DBDataSource.callOperation("ST_MainProjectSpecialty", "find", condition, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					mainProjectSpecialtyGrid.setData(dsResponse.getData());
				}
			}
		});
		condition = new java.util.HashMap();
		condition.put("mainProjectId", selected.getAttributeAsString("preProjectId"));
		DBDataSource.callOperation("ST_MainProjectCompetitionUnit", "find", condition, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					mainProjectCompetitionUnitsGrid.setData(dsResponse.getData());
				}
			}
		});
	}

	@Override
	public DataSource getMainDataSource() {
		return DSCloseProjectApply.getInstance();
	}

	@Override
	public int getDetailCount(){
		return 3;
	}

	@Override
	public List<ListGrid> getDetailListGrids() {
		List<ListGrid> res = new ArrayList<ListGrid>();
		res.add(mainProjectBusinessTypesGrid);
		res.add(mainProjectSpecialtyGrid);
		res.add(mainProjectCompetitionUnitsGrid);
		return res;
	}

	@Override
	public List<String> getDetailNames() {
		List<String> res = new ArrayList<String>();
		res.add("前期项目的业务类别子表");
		res.add("前期项目的专业子表");
		res.add("前期项目的竞争单位子表");
		return res;
	}

	public SearchForm getParentSearchForm() {
		return this.__parentSearchForm;
	}

	public void setParentSearchForm( SearchForm value ) {
		this.__parentSearchForm = value;
	}


}

