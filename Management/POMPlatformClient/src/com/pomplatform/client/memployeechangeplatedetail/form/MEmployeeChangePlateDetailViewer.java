package com.pomplatform.client.memployeechangeplatedetail.form;

import java.util.ArrayList;
import java.util.List;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.data.*;
import com.delicacy.client.data.GroupColumn;
import com.smartgwt.client.widgets.form.SearchForm;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.pomplatform.client.memployeechangeplatedetail.datasource.DSMEmployeeChangePlateDetail;

public class MEmployeeChangePlateDetailViewer extends AbstractDetailViewer {

    private SearchForm __parentSearchForm;

    public MEmployeeChangePlateDetailViewer() {
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
        return "职员转岗";
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
        gc.setGroupCaption("职员转岗信息");
        gc.getColumnNames().add("employeeChangePlateDetailId");
        gc.getColumnNames().add("employeeNo");
        gc.getColumnNames().add("employeeId");
        gc.getColumnNames().add("year");
        gc.getColumnNames().add("month");
        gc.getColumnNames().add("outPlateId");
        gc.getColumnNames().add("inPlateId");
        gc.getColumnNames().add("remark");
        gc.getColumnNames().add("createTime");
        gc.getColumnNames().add("updateTime");
        gcs.add(gc);
        return gcs;
    }

    @Override
    public void viewSelectedData(ListGrid grid) {
        super.viewSelectedData(grid);
    }

    @Override
    public DataSource getMainDataSource() {
        return DSMEmployeeChangePlateDetail.getInstance();
    }

    @Override
    public int getDetailCount() {
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

    public void setParentSearchForm(SearchForm value) {
        this.__parentSearchForm = value;
    }

}
