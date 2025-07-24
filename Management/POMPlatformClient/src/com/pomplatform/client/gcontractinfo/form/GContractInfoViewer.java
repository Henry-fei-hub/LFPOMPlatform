package com.pomplatform.client.gcontractinfo.form;

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
import com.pomplatform.client.gcontractinfo.datasource.DSGContractInfo;

public class GContractInfoViewer extends AbstractDetailViewer
{


	private SearchForm __parentSearchForm;


	public GContractInfoViewer() {
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
		return "主合同";
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
		gc.setGroupCaption("主合同");
		gc.getColumnNames().add("contractId");
		gc.getColumnNames().add("contractCode");
		gc.getColumnNames().add("contractName");
		gc.getColumnNames().add("customerName");
		gc.getColumnNames().add("startDate");
		gc.getColumnNames().add("endDate");
		gc.getColumnNames().add("status");
		gc.getColumnNames().add("projectCode");
		gc.getColumnNames().add("contractType");
		gc.getColumnNames().add("projectLevel");
		gc.getColumnNames().add("totalProjectTime");
		gc.getColumnNames().add("signingMoneySum");
		gc.getColumnNames().add("designAreas");
		gc.getColumnNames().add("contractPrice");
		gc.getColumnNames().add("projectAddress");
		gc.getColumnNames().add("contractFollower");
		gc.getColumnNames().add("remark");
		gc.getColumnNames().add("contractDate");
		gc.getColumnNames().add("createTime");
		gc.getColumnNames().add("updateTime");
		gc.getColumnNames().add("signingCompanyName");
		gc.getColumnNames().add("businessType");
		gc.getColumnNames().add("flowStatus");
		gcs.add(gc);
		return gcs;
	}

	@Override
	public void viewSelectedData(ListGrid grid){
		super.viewSelectedData(grid);
	}

	@Override
	public DataSource getMainDataSource() {
		return DSGContractInfo.getInstance();
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

