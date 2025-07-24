package com.pomplatform.client.workflow.personnel.form;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import com.pomplatform.client.workflow.personnelbusiness.form.ReturnOfItemDetailUpdate;
import com.pomplatform.client.workflow.personnelbusiness.form.ReturnOfItemsUpdateForm;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.layout.HLayout;
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
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.workflow.personnel.datasource.DSWorkingHoursLinkPersonnelBusiness;

public class WorkingHoursLinkPersonnelBusinessViewer extends AbstractDetailViewer
{
	private WorkingHoursLinkPersonnelBusinessNewForm mainPanel;
	private WorkHourdetailForm workHourdetailForm;

	private SearchForm __parentSearchForm;


	public WorkingHoursLinkPersonnelBusinessViewer() {

	}

	@Override
	public void initComponents() {
		HLayout mainLayout = new HLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		addMember(mainLayout);

		mainPanel = new WorkingHoursLinkPersonnelBusinessNewForm(false);
		mainPanel.setPageMode(AbstractWizadPage.PAGE_MODE_UPDATE);
		workHourdetailForm = new WorkHourdetailForm(false);

		mainLayout.addMember(mainPanel);
		mainLayout.addMember(workHourdetailForm);
		load();
	}

	@Override
	public int getHorizontalPercent() {
		return 0;
	}

	@Override
	public DataSource getMainDataSource() {
		return null;
	}

	@Override
	public String getName() {
		return "WorkingHoursLinkPersonnelBusiness";
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
		Record instanceData = get__instanceData();
		String personnelBusinessId = instanceData.getAttribute("personnelBusinessId");
		if(null == personnelBusinessId) return;
		Map params = new HashMap();
		params.put("personnelBusinessId", personnelBusinessId);
		DBDataSource.callOperation("NQ_WorkingHoursLinkPersonnelBusiness", "find",params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					Record record = dsResponse.getData()[0];
					mainPanel.setRecord(record);
					mainPanel.startEdit();
					workHourdetailForm.setRecord(record);
					workHourdetailForm.startEdit();
				}
			}
		});
	}


	@Override
	public int getDetailCount(){
		return 0;
	}

	@Override
	public List<ListGrid> getDetailListGrids() {
		List<ListGrid> res = new ArrayList<ListGrid>();
		return res;
	}

	@Override
	public List<String> getDetailNames() {
		List<String> res = new ArrayList<String>();
		return res;
	}

	public SearchForm getParentSearchForm() {
		return this.__parentSearchForm;
	}

	public void setParentSearchForm( SearchForm value ) {
		this.__parentSearchForm = value;
	}

	@Override
	public Map getValues() {
		Map map = mainPanel.getValuesAsMap();
		Map valuesAsMap = workHourdetailForm.getValuesAsMap();
		if (null != valuesAsMap) {
			map.put("workHoursDetails", valuesAsMap.get("workHoursDetails"));
		}
		return map;
	}
}

