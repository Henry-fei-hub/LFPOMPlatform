package com.pomplatform.client.plateprojectintegraldetail.panel;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PaginationPanel;
import com.pomplatform.client.common.SyncDataUtil;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.plateprojectintegraldetail.datasource.DSMplateProjectIntegralDetail;
import com.pomplatform.client.plateprojectintegraldetail.form.MplateProjectIntegralDetailSearchForm;
import com.pomplatform.client.plateprojectintegraldetail.form.MplateProjectIntegralDetailViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.managementteamproject.datasource.DSMManagementTeamProject;
import com.pomplatform.client.projectview.form.SprojectViewViewer;
import com.smartgwt.client.data.*;
import com.smartgwt.client.util.Browser;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class MplateProjectIntegralDetailPanel extends AbstractSearchPanel {

    private final Logger __logger = Logger.getLogger("");
    private DynamicForm __infoForm;
    private TextItem totalItem;

    public static class Factory implements PanelFactory {

        private String id;

        @Override
        public Canvas create() {
            MplateProjectIntegralDetailPanel cm = new MplateProjectIntegralDetailPanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "MplateProjectIntegralDetail";
        }
    }

    private int plateId;

    /**
     * @return the plateId
     */
    public int getPlateId() {
        return plateId;
    }

    /**
     * @param plateId the plateId to set
     */
    public void setPlateId(int plateId) {
        this.plateId = plateId;
    }

    @Override
    public void initComponents() {
        resultGrid.setShowRowNumbers(true);
        resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
            @Override
            public void onDoubleClick(DoubleClickEvent event) {
                showDetail();
            }
        });
        IButton operation1Button = new IButton("查看详情");
        operation1Button.hide();
        controlLayout.addMember(operation1Button);
        operation1Button.setIcon("[SKIN]/actions/view.png");
        operation1Button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                showDetail();
            }
        });
    }

    public void showDetail() {
        GWT.runAsync(new RunAsyncCallback() {
            @Override
            public void onFailure(Throwable reason) {
                SC.say("failure to download code");
            }

            @Override
            public void onSuccess() {
                if (!resultGrid.anySelected()) {
                    SC.say("请选择一条数据");
                    return;
                }
                ListGridRecord[] selected = resultGrid.getSelectedRecords();
                int projectId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("projectId"));
                //获取项目名称
//                final String projectName = KeyValueManager.getValue("projects", projectId + "");
                String projectName = SyncDataUtil.getProjectName(projectId);
//                Record record = getProjectName(projectId);
//                String projectName = BaseHelpUtils.getString(record.getAttribute("projectName"));
                final DelicacyListGrid projectViewGrid = new DelicacyListGrid();
                projectViewGrid.setDataSource(DSMManagementTeamProject.getInstance());
                Map condition = new java.util.HashMap();
                condition.put("projectId", projectId);
                DBDataSource.callOperation("NQ_MManagementTeamProject", "find", condition, new DSCallback() {
                    @Override
                    public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                        if (dsResponse.getStatus() >= 0) {
                            projectViewGrid.setData(dsResponse.getData());
                            projectViewGrid.selectRecord(0);
                            GenericViewWindow detail = new GenericViewWindow();
                            detail.setTitle("项目(" + projectName + ")的相关信息");
                            detail.setWidth100();
                            detail.setHeight100();
                            SprojectViewViewer detailForm = new SprojectViewViewer();
                            detailForm.setParentSearchForm(searchForm);
                            detailForm.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_TAB);
                            detailForm.initComponents();
                            detailForm.viewSelectedData(projectViewGrid);
                            detail.setContent(detailForm);
                            detail.centerInPage();
                            detail.show();
                        }
                    }
                });

//                GenericViewWindow detail = new GenericViewWindow();
//                detail.setTitle("项目积分详情");
//                detail.setWidth100();
//                detail.setHeight100();
//                MplateProjectIntegralDetailViewer detailForm = new MplateProjectIntegralDetailViewer();
//                detailForm.setParentSearchForm(searchForm);
//                detailForm.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_TAB);
//                detailForm.initComponents();
//                detailForm.viewSelectedData(resultGrid);
//                detail.setContent(detailForm);
//                detail.centerInPage();
//                detail.show();
            }
        });
    }

    @Override
    public Canvas getViewPanel() {
        searchForm = generateSearchForm();
        VLayout layout = new VLayout();
        layout.setWidth100();
        layout.setHeight100();
        layout.setBackgroundColor("#e2e2e2");

        if (searchForm != null) {
            ClientUtil.searchFormProcessAccordingToDevice(searchForm);
            if (getSearchFormHeight() > 0) {
                searchForm.setHeight(getSearchFormHeight());
            }
            HLayout searchLayout = new HLayout(5);
            searchLayout.setMargin(10);
            layout.addMember(searchLayout);

            searchForm.setWidth100();
            searchLayout.addMember(searchForm);

            VLayout buttonLayout = new VLayout(5);
            searchButton = new IButton("搜索");
            searchButton.setIcon("[SKIN]/actions/search.png");

            IButton resetButton = new IButton("重置");
            resetButton.setIcon("[SKIN]/actions/redo.png");

            buttonLayout.addMember(searchButton);
            buttonLayout.addMember(resetButton);

            searchLayout.addMember(buttonLayout);

            searchButton.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    currentPage = 1;
                    commonQuery();
                }
            });

            resetButton.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    searchForm.editNewRecord();
                }
            });
        }
        VLayout resultLayout = new VLayout();
        resultLayout.setWidth100();
        resultLayout.setHeight100();

        HLayout dataLayout = new HLayout();
        dataLayout.setHeight100();
        dataLayout.setWidth100();
        resultLayout.addMember(dataLayout);

        resultGrid = new DelicacyListGrid();
        resultGrid.setDataSource(getDataSource());

        __infoForm = new DynamicForm();
        __infoForm.setWidth100();
        __infoForm.setHeight("8%");
        __infoForm.setNumCols(2);
        ClientUtil.DynamicFormProcessAccordingToDevice(__infoForm);
        totalItem = new TextItem("汇总");
        totalItem.setCanEdit(false);
        totalItem.setWidth("*");

        __infoForm.setFields(totalItem);

        VLayout newLayout = new VLayout();
        newLayout.addMember(resultGrid);
        newLayout.addMember(__infoForm);

        dataLayout.addMember(newLayout);
        if (showControlPanel()) {
            controlLayout = new VLayout();
            controlLayout.setHeight100();
            controlLayout.setLayoutTopMargin(30);
            controlLayout.setLayoutLeftMargin(5);
            controlLayout.setLayoutRightMargin(5);
            controlLayout.setMembersMargin(10);

            dataLayout.addMember(controlLayout);
        }

        layout.addMember(resultLayout);

        if (Browser.getIsDesktop() && showPagination()) {
            pager = new PaginationPanel();
            resultLayout.addMember(pager);

            pager.getGotoButton().addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    TextItem item = pager.getGotoPage();
                    String strPageNo = item.getValueAsString();
                    if (strPageNo == null || strPageNo.equals("")) {
                        return;
                    }
                    currentPage = Integer.parseInt(strPageNo);
                    commonQuery();
                }
            });
            pager.getFirstButton().addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    currentPage = 1;
                    commonQuery();
                }
            });
            pager.getPreviousButton().addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    if (currentPage > 1) {
                        currentPage--;
                        commonQuery();
                    }
                }
            });
            pager.addKeyPressHandler(new KeyPressHandler() {

                @Override
                public void onKeyPress(KeyPressEvent event) {
                    if (event.getKeyName() != null) {
                        switch (event.getKeyName()) {
                            case "Arrow_Right":
                                if (currentPage < totalPages) {
                                    currentPage++;
                                    commonQuery();
                                }
                                break;
                            case "Arrow_Left":
                                if (currentPage > 1) {
                                    currentPage--;
                                    commonQuery();
                                }
                                break;
                        }
                    }
                }
            });
            pager.getNextButton().addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    if (currentPage < totalPages) {
                        currentPage++;
                        commonQuery();
                    }
                }
            });
            pager.getLastButton().addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    if (totalPages > 0) {
                        currentPage = totalPages;
                        commonQuery();
                    }
                }
            });
            pager.getRefreshButton().addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    commonQuery();
                }
            });
        }
        initComponents();
        if (showControlPanel()) {
            setControlLayoutWidth();
        }
        return layout;
    }

    @Override
    public void commonQuery() {
        Map condition = generateCriteria();
        if (condition == null) {
            return;
        }
        if (searchForm != null) {
            searchButton.setIcon("loading38.gif");
        }
        DBDataSource ds = (DBDataSource) getDataSource();
        String operationName = ds.getActionMode() + ds.getActionName();
        DBDataSource.callOperation(operationName, condition, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (searchForm != null) {
                    searchButton.setIcon("[SKIN]/actions/search.png");
                }
                double achieveIntegral = 0;//价值积分
                double reserveIntegral = 0;//预留积分
                double sureIntegral = 0;//确认积分
                double costIntegral = 0;//成本积分
                double salaryIntegral = 0;//人工成本
                if (dsResponse.getStatus() >= 0) {
                    Record[] record = dsResponse.getData();
                    for (Record e : record) {
                        achieveIntegral += ClientUtil.checkAndGetDoubleValue(e.getAttribute("achieveIntegral"));
                        reserveIntegral += ClientUtil.checkAndGetDoubleValue(e.getAttribute("reserveIntegral"));
                        sureIntegral += ClientUtil.checkAndGetDoubleValue(e.getAttribute("sureIntegral"));
                        costIntegral += ClientUtil.checkAndGetDoubleValue(e.getAttribute("costIntegral"));
                        salaryIntegral += ClientUtil.checkAndGetDoubleValue(e.getAttribute("salaryIntegral"));
                    }
                    totalItem.setValue("价值积分:" + Math.round(achieveIntegral) + "  预留积分:" + Math.round(reserveIntegral) + "  确认积分:" + Math.round(sureIntegral) + "  项目成本:" + Math.round(costIntegral) + "  人工成本:" + Math.round(salaryIntegral));
                    resultGrid.setData(record);
                    afterDataReceived(dsResponse.getData());
                    if (showPagination()) {
                        if (currentPage == 1) {
                            totalPages = dsResponse.getAttributeAsInt("totalPages");
                            pager.getTotalPages().setContents(String.valueOf(totalPages));
                        }
                    }
                } else {
                    SC.say(dsResponse.getErrors().get("errorMsg").toString());
                }
                if (showPagination()) {
                    pager.getCurrentPage().setContents(String.valueOf(currentPage));
                }
            }
        });
    }

    @Override
    public boolean checkSearchCriteria(Map criteria) {
        if (plateId > 0) {
            criteria.put("plateId", plateId);
        }
        return true;
    }

    @Override
    public SearchForm generateSearchForm() {
        return new MplateProjectIntegralDetailSearchForm();
    }

    @Override
    public DataSource getDataSource() {
        return DSMplateProjectIntegralDetail.getInstance();
    }

    @Override
    public int getSearchFormHeight() {
        return 126;
    }

    /**
     * 获取项目的名称
     * @param projectId
     * @return
     */
    private Record getProjectName(Integer projectId){
        Record record = new Record();
        HashMap<Object, Object> map = new HashMap<>();
        map.put("projectId",projectId);
        DBDataSource.callOperation("ST_Project", "find", map, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
                if(dsResponse.getStatus() >= 0){
                    Record[] records = dsResponse.getData();
                    if(!BaseHelpUtils.isNullOrEmpty(records) && records.length > 0){
                        //获取项目名称
                        String projectName = BaseHelpUtils.getString(records[0].getAttribute("projectName"));
                        record.setAttribute("projectName",projectName);
                    }
                }
            }
        });
        return record;
    }
}
