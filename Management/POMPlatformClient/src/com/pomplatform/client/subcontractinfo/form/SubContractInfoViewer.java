package com.pomplatform.client.subcontractinfo.form;

import java.util.ArrayList;
import java.util.List;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.data.*;
import com.delicacy.client.data.GroupColumn;
import com.smartgwt.client.widgets.form.SearchForm;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.pomplatform.client.subcontractinfo.datasource.DSSubContractInfo;

public class SubContractInfoViewer extends AbstractDetailViewer {

    private SearchForm __parentSearchForm;

    public SubContractInfoViewer() {
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
        return "子合同详情";
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
        gc.setGroupCaption("子合同详情");
        gc.getColumnNames().add("subContractId");
        gc.getColumnNames().add("parentId");
        gc.getColumnNames().add("subContractCode");
        gc.getColumnNames().add("projectCode");
        gc.getColumnNames().add("businessType");
        gc.getColumnNames().add("projectType");
        gc.getColumnNames().add("departmentId");
        gc.getColumnNames().add("commonArea");
        gc.getColumnNames().add("logisticsArea");
        gc.getColumnNames().add("moneySum");
        gc.getColumnNames().add("createTime");
        gc.getColumnNames().add("subContractName");
        gc.getColumnNames().add("updateTime");
        gc.getColumnNames().add("projectId");
        gcs.add(gc);
        return gcs;
    }

    @Override
    public void viewSelectedData(ListGrid grid) {
        super.viewSelectedData(grid);
    }

    @Override
    public DataSource getMainDataSource() {
        return DSSubContractInfo.getInstance();
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
