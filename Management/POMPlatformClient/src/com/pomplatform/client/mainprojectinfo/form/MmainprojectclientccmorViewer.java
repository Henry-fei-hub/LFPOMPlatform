package com.pomplatform.client.mainprojectinfo.form;

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
import com.pomplatform.client.mainprojectinfo.datasource.DSMmainprojectclientccmor;

public class MmainprojectclientccmorViewer extends AbstractDetailViewer
{


	private SearchForm __parentSearchForm;


	public MmainprojectclientccmorViewer() {
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
		return "Mmainprojectclientccmor";
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
		gc.setGroupCaption("客户信息");
		gc.getColumnNames().add("mainProjectId");
		gc.getColumnNames().add("clientId");
		gc.getColumnNames().add("clientName");
		gc.getColumnNames().add("clientPhone");
		gc.getColumnNames().add("clientCompany");
		gc.getColumnNames().add("clientAddress");
		gc.getColumnNames().add("clientJob");
		gc.getColumnNames().add("clientWeixin");
		gc.getColumnNames().add("clientQq");
		gc.getColumnNames().add("clientEmail");
		gc.getColumnNames().add("clientRole");
		gcs.add(gc);
		return gcs;
	}

	@Override
	public void viewSelectedData(ListGrid grid){
		super.viewSelectedData(grid);
	}

	@Override
	public DataSource getMainDataSource() {
		return DSMmainprojectclientccmor.getInstance();
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

