package com.pomplatform.client.sprojectintegralsumrecordpymor.form;

import java.util.ArrayList;
import java.util.List;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.data.*;
import com.delicacy.client.data.GroupColumn;
import com.smartgwt.client.widgets.form.SearchForm;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.pomplatform.client.sprojectintegralsumrecordpymor.datasource.DSSprojectintegralsumrecordpymor;

public class SprojectintegralsumrecordpymorViewer extends AbstractDetailViewer {

    private SearchForm __parentSearchForm;

    public SprojectintegralsumrecordpymorViewer() {
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
        return "Sprojectintegralsumrecordpymor";
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
        gc.setGroupCaption("项目积分汇总");
//        gc.getColumnNames().add("projectIntegralSumRecordId");
        gc.getColumnNames().add("subContractCode");
        gc.getColumnNames().add("subContractName");
        gc.getColumnNames().add("projectCode");
        gc.getColumnNames().add("projectId");
        gc.getColumnNames().add("plateId");
        gc.getColumnNames().add("year");
        gc.getColumnNames().add("month");
        gc.getColumnNames().add("projectIntegralSum");
        gc.getColumnNames().add("reserveIntegral");
        gc.getColumnNames().add("projectIntegral");
        gc.getColumnNames().add("undistributedProjectIntegral");
        gc.getColumnNames().add("distributedProjectIntegral");
        gc.getColumnNames().add("unsureIntegral");
        gc.getColumnNames().add("sureIntegral");
        gc.getColumnNames().add("settlementIntegral");
        gc.getColumnNames().add("projectCost");
        gc.getColumnNames().add("settledProjectCost");
        gc.getColumnNames().add("unsettledProjectCost");
        gc.getColumnNames().add("isLock");
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
        return DSSprojectintegralsumrecordpymor.getInstance();
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
