package com.pomplatform.client.platereportrecorddetail.form;

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
import com.pomplatform.client.platereportrecorddetail.datasource.DSPlateReportRecordDetail;

public class PlateReportRecordDetailViewer extends AbstractDetailViewer
{


	private SearchForm __parentSearchForm;


	public PlateReportRecordDetailViewer() {
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
		return "业务部门积分汇总";
	}

	@Override
	public int getGroupCount() {
		return 2;
	}

	@Override
	public List<GroupColumn> getGroupColumnNames() {
		List<GroupColumn> gcs = new ArrayList<GroupColumn>();
		GroupColumn gc;
        gc = new GroupColumn();
        gc.setGroupName("PlateBase");
        gc.setGroupCaption("积分余额");
        gc.getColumnNames().add("achieveIntegral");
        gcs.add(gc);
        gc = new GroupColumn();
        gc.setGroupName("PlateInfoBase");
        gc.setGroupCaption("部门汇总信息");
        gc.getColumnNames().add("projectSettlement");
        gc.getColumnNames().add("companySubsidy");
        gc.getColumnNames().add("employeeAchieveIntegralReturn");
        gc.getColumnNames().add("salaryReturn");
        gc.getColumnNames().add("salaryAdvance");
        gc.getColumnNames().add("managerProjectIntegral");
        gc.getColumnNames().add("plateCost");
        gc.getColumnNames().add("projectAdvance");
        gcs.add(gc);
		return gcs;
	}

	@Override
	public void viewSelectedData(ListGrid grid){
		super.viewSelectedData(grid);
	}

	@Override
	public DataSource getMainDataSource() {
		return DSPlateReportRecordDetail.getInstance();
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

