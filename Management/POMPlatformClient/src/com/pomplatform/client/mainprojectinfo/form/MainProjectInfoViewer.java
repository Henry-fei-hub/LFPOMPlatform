package com.pomplatform.client.mainprojectinfo.form;

import java.util.ArrayList;
import java.util.List;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.data.*;
import com.delicacy.client.data.GroupColumn;
import com.smartgwt.client.widgets.form.SearchForm;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.pomplatform.client.mainprojectinfo.datasource.DSMainProjectInfo;

public class MainProjectInfoViewer extends AbstractDetailViewer {

    private SearchForm __parentSearchForm;

    public MainProjectInfoViewer() {
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
        return 2;
    }

    @Override
    public List<GroupColumn> getGroupColumnNames() {
        List<GroupColumn> gcs = new ArrayList<>();
        GroupColumn gc;
        gc = new GroupColumn();
        gc.setGroupName("GroupName1");
        gc.setGroupCaption("项目详情1");
//        gc.getColumnNames().add("mainProjectId");
        gc.getColumnNames().add("infoCode");
        gc.getColumnNames().add("projectCode");
        gc.getColumnNames().add("projectName");
        gc.getColumnNames().add("projectEnglishName");
        gc.getColumnNames().add("projectStatus");
        gc.getColumnNames().add("designStatus");
        gc.getColumnNames().add("signCompany");
        gc.getColumnNames().add("isHighRiseBuilding");
        gc.getColumnNames().add("projectTotalInvestment");
        gc.getColumnNames().add("decorateMoneyControl");
        gc.getColumnNames().add("totalBuildingAreas");
        gc.getColumnNames().add("estimateTheDesignAreas");
        gc.getColumnNames().add("actualDesignAreas");
        gc.getColumnNames().add("buildingFloors");
        gc.getColumnNames().add("buildingHeight");
        gc.getColumnNames().add("fireResistanceRating");
        gc.getColumnNames().add("projectLevel");
        gc.getColumnNames().add("projectEndTime");
        gcs.add(gc);
        gc = new GroupColumn();
        gc.setGroupName("GroupName2");
        gc.setGroupCaption("项目详情2");
        gc.getColumnNames().add("projectOrigination");
        gc.getColumnNames().add("projectOriginationRemark");
        gc.getColumnNames().add("designCooperationName");
        gc.getColumnNames().add("designCooperationEnglishName");
        gc.getColumnNames().add("projectSalesTeam");
        gc.getColumnNames().add("projectSalesman");
        gc.getColumnNames().add("projectSalesTeamManager");
        gc.getColumnNames().add("designTeam");
        gc.getColumnNames().add("infoRegisterTime");
        gc.getColumnNames().add("projectApprovalTime");
        gc.getColumnNames().add("projectManager");
        gc.getColumnNames().add("projectLeader");
        gc.getColumnNames().add("hasContract");
        gc.getColumnNames().add("projectBaseOn");
        gc.getColumnNames().add("projectModel");
        gc.getColumnNames().add("designQualification");
        gc.getColumnNames().add("businessType");
        gc.getColumnNames().add("province");
        gc.getColumnNames().add("city");
        gc.getColumnNames().add("detailAddress");

        gcs.add(gc);
        return gcs;
    }

    @Override
    public void viewSelectedData(ListGrid grid) {
        super.viewSelectedData(grid);
    }

    @Override
    public DataSource getMainDataSource() {
        return DSMainProjectInfo.getInstance();
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
