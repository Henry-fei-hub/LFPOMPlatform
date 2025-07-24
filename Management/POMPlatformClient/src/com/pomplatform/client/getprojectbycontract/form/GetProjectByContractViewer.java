package com.pomplatform.client.getprojectbycontract.form;

import java.util.ArrayList;
import java.util.List;
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
import com.pomplatform.client.getprojectbycontract.datasource.DSGetProjectByContract;

public class GetProjectByContractViewer extends AbstractDetailViewer
{


	private SearchForm __parentSearchForm;


	public GetProjectByContractViewer() {
	}

	@Override
	public void initComponents() {
		super.initComponents();
	}

	@Override
	public int getHorizontalPercent() {
		return 0;
	}

	@Override
	public String getName() {
		return "项目详情";
	}

	@Override
	public int getGroupCount() {
		return 1;
	}

	@Override
	public List<GroupColumn> getGroupColumnNames() {
		List<GroupColumn> gcs = new ArrayList<GroupColumn>();
		GroupColumn gc;
		gc = new GroupColumn();
		gc.setGroupName("GroupName1");
		gc.setGroupCaption("项目详情");
		gc.getColumnNames().add("projectId");
		gc.getColumnNames().add("contractCode");
		gc.getColumnNames().add("projectCode");
		gc.getColumnNames().add("projectName");
		gc.getColumnNames().add("projectType");
		gc.getColumnNames().add("plateId");
		gc.getColumnNames().add("designType");
		gc.getColumnNames().add("departmentId");
		gc.getColumnNames().add("designPhase");
		gc.getColumnNames().add("projectLevel");
		gc.getColumnNames().add("status");
		gc.getColumnNames().add("projectManageId");
		gc.getColumnNames().add("workHours");
		gc.getColumnNames().add("planStartDate");
		gc.getColumnNames().add("planEndDate");
		gc.getColumnNames().add("startDate");
		gc.getColumnNames().add("endDate");
		gc.getColumnNames().add("commonArea");
		gc.getColumnNames().add("logisticsArea");
		gc.getColumnNames().add("percentage");
		gc.getColumnNames().add("oldProjectDiscount");
		gc.getColumnNames().add("budget");
		gc.getColumnNames().add("totalIntegral");
		gc.getColumnNames().add("reserveIntegral");
		gc.getColumnNames().add("totalAmount");
		gc.getColumnNames().add("projectIntegral");
		gc.getColumnNames().add("projectProgress");
		gc.getColumnNames().add("projectSize");
		gc.getColumnNames().add("projectDescription");
		gc.getColumnNames().add("auditReason");
		gc.getColumnNames().add("departmentManagerId");
		gc.getColumnNames().add("bimArea");
		gc.getColumnNames().add("cadArea");
		gc.getColumnNames().add("humanAmount");
		gc.getColumnNames().add("appendTotalIntegral");
		gc.getColumnNames().add("appendIntegral");
		gc.getColumnNames().add("remark");
		gc.getColumnNames().add("projectFinishPercent");
		gc.getColumnNames().add("parentId");
		gc.getColumnNames().add("totalFinishPercent");
		gc.getColumnNames().add("projectGradeType");
		gc.getColumnNames().add("plateManagerId");
		gc.getColumnNames().add("lastPercent");
		gcs.add(gc);
		return gcs;
	}

	@Override
	public void viewSelectedData(ListGrid grid){
		super.viewSelectedData(grid);
	}

	@Override
	public DataSource getMainDataSource() {
		return DSGetProjectByContract.getInstance();
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


}

