package com.pomplatform.client.projectstages.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.GroupColumn;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.GenericViewWindow;
import com.pomplatform.client.projectstages.datasource.DSProjectStageProcessDetail;
import com.pomplatform.client.projectstages.datasource.DSProjectStagesProcessApplication;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.viewer.DetailViewer;

public class ProjectStagesProcessApplicationViewer extends AbstractDetailViewer
{


	private final DelicacyListGrid projectStageProcessDetailsGrid = new DelicacyListGrid();
	private SearchForm __parentSearchForm;

	private ProjectStagesProcessApplicationNewForm projectStagesProcessApplicationNewForm;
	private ProjectStagesProcessApplicationDetailProjectStageProcessDetail projectStagesProcessApplicationDetailProjectStageProcessDetail;

	public ProjectStagesProcessApplicationViewer() {
	}

	@Override
	public void initComponents() {
		Record record = get__instanceData();
		setWidth100();
		setHeight100();
		HLayout mainLayout = new HLayout();
		mainLayout.setHeight100();
		mainLayout.setWidth100();
		addMember(mainLayout);

		VLayout topLayout = new VLayout();
		topLayout.setHeight100();
		topLayout.setWidth("30%");
		mainLayout.addMember(topLayout);
		projectStagesProcessApplicationNewForm = new ProjectStagesProcessApplicationNewForm();
		projectStagesProcessApplicationNewForm.loadValue(record);
		topLayout.addMember(projectStagesProcessApplicationNewForm);

		HLayout bottomLayout = new HLayout();
		bottomLayout.setHeight100();
		bottomLayout.setWidth("70%");
		mainLayout.addMember(bottomLayout);
		projectStagesProcessApplicationDetailProjectStageProcessDetail = new ProjectStagesProcessApplicationDetailProjectStageProcessDetail(projectStagesProcessApplicationNewForm);
		projectStagesProcessApplicationDetailProjectStageProcessDetail.loadValue(record);
		bottomLayout.addMember(projectStagesProcessApplicationDetailProjectStageProcessDetail);
		projectStagesProcessApplicationDetailProjectStageProcessDetail.setPageMode(AbstractWizadPage.PAGE_MODE_UPDATE);
	}

	@Override
	public int getHorizontalPercent() {
		return 0;
	}

	@Override
	public String getName() {
		return "ProjectStagesProcessApplication";
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
	public void viewRecord(Record r) {
		if(BaseHelpUtils.isNullOrEmpty(r)) {
			return;
		}
		Map<String,Object> params = new HashMap<>();
		params.put("projectStageProcessRecordId", r.getAttribute("projectStageProcessRecordId"));
		DBDataSource.callOperation("NQ_ProjectStagesProcessApplication", "find",params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					Record[] datas = dsResponse.getData();
					for(DetailViewer v : detailViewers){
						v.setData(datas);
						if(dsResponse.getData().length == 0) continue;
						v.selectRecord(0);
						v.redraw();
					}
					setRecord(datas[0]);
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
		condition.put("projectStageProcessRecordId", selected.getAttributeAsString("projectStageProcessRecordId"));
		DBDataSource.callOperation("ST_ProjectStageProcessDetail", "find", condition, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					projectStageProcessDetailsGrid.setData(dsResponse.getData());
				}
			}
		});
	}

	@Override
	public DataSource getMainDataSource() {
		return DSProjectStagesProcessApplication.getInstance();
	}

	@Override
	public int getDetailCount(){
		return 1;
	}

	@Override
	public List<ListGrid> getDetailListGrids() {
		List<ListGrid> res = new ArrayList<ListGrid>();
//		res.add(projectStageProcessDetailsGrid);
		return res;
	}

	@Override
	public List<String> getDetailNames() {
		List<String> res = new ArrayList<String>();
		res.add("");
		return res;
	}

	public SearchForm getParentSearchForm() {
		return this.__parentSearchForm;
	}

	public void setParentSearchForm( SearchForm value ) {
		this.__parentSearchForm = value;
	}


}

