package com.pomplatform.client.departmentmanagerproject.form;

import java.util.ArrayList;
import java.util.List;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.data.*;
import com.delicacy.client.data.GroupColumn;
import com.smartgwt.client.widgets.form.SearchForm;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.pomplatform.client.departmentmanagerproject.datasource.DSMDepartmentManagerProject;

public class MDepartmentManagerProjectViewer extends AbstractDetailViewer {

    private SearchForm __parentSearchForm;

    public MDepartmentManagerProjectViewer() {
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
        return "板块运营负责人项目";
    }

    @Override
    public int getGroupCount() {
        return 0;
    }

    @Override
    public List<GroupColumn> getGroupColumnNames() {
        List<GroupColumn> gcs = new ArrayList<>();
        return gcs;
    }

    @Override
    public void viewSelectedData(ListGrid grid) {
        super.viewSelectedData(grid);
    }

    @Override
    public DataSource getMainDataSource() {
        return DSMDepartmentManagerProject.getInstance();
    }

    @Override
    public int getDetailCount() {
        return 0;
    }

    @Override
    public List<ListGrid> getDetailListGrids() {
        List<ListGrid> res = new ArrayList<>();
        return res;
    }

    @Override
    public List<String> getDetailNames() {
        List<String> res = new ArrayList<>();
        return res;
    }

    public SearchForm getParentSearchForm() {
        return this.__parentSearchForm;
    }

    public void setParentSearchForm(SearchForm value) {
        this.__parentSearchForm = value;
    }

}
