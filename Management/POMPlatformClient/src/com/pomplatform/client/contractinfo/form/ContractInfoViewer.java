package com.pomplatform.client.contractinfo.form;

import java.util.ArrayList;
import java.util.List;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.data.*;
import com.delicacy.client.data.GroupColumn;
import com.smartgwt.client.widgets.form.SearchForm;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.pomplatform.client.contractinfo.datasource.DSContractInfo;

public class ContractInfoViewer extends AbstractDetailViewer {

    private SearchForm __parentSearchForm;

    public ContractInfoViewer() {
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
        return "主合同详情";
    }

    @Override
    public int getGroupCount() {
        return 1;
    }

    @Override
    public List<GroupColumn> getGroupColumnNames() {
        List<GroupColumn> gcs = new ArrayList<>();
        GroupColumn gc;
        gc = new GroupColumn();
        gc.setGroupName("GroupName1");
        gc.setGroupCaption("主合同详情");
//        gc.getColumnNames().add("contractId");
        gc.getColumnNames().add("projectCode");
        gc.getColumnNames().add("contractCode");
        gc.getColumnNames().add("contractName");
        gc.getColumnNames().add("customerName");
        gc.getColumnNames().add("signingCompanyName");
        gc.getColumnNames().add("contractFollower");
        gc.getColumnNames().add("status");
        gc.getColumnNames().add("contractType");
        gc.getColumnNames().add("businessType");
        gc.getColumnNames().add("projectLevel");
        gc.getColumnNames().add("contractDate");
        gc.getColumnNames().add("startDate");
        gc.getColumnNames().add("endDate");
        gc.getColumnNames().add("totalProjectTime");
        gc.getColumnNames().add("designAreas");
        gc.getColumnNames().add("contractPrice");
        gc.getColumnNames().add("signingMoneySum");
        gc.getColumnNames().add("projectAddress");
        gc.getColumnNames().add("remark");
        gc.getColumnNames().add("flowStatus");
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
        return DSContractInfo.getInstance();
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
