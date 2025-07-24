package com.pomplatform.client.sprojectintegralsumrecordpymor.panel;

import com.delicacy.client.PaginationPanel;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.sprojectintegralsumrecordpymor.datasource.DSSprojectintegralsumrecordpymor;
import com.pomplatform.client.sprojectintegralsumrecordpymor.form.SprojectintegralsumrecordpymorViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.common.CommonFormat;
import com.smartgwt.client.data.*;
import com.smartgwt.client.util.Browser;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import java.util.Map;
import java.util.logging.Logger;

public class SprojectintegralsumrecordpymorPanel extends AbstractSearchPanel {

    public static final Logger logger = Logger.getLogger("");
    private DynamicForm __infoForm;
    private TextItem totalItem;
    private Map paramMap;

    public static class Factory implements PanelFactory {

        private String id;

        @Override
        public Canvas create() {
            SprojectintegralsumrecordpymorPanel cm = new SprojectintegralsumrecordpymorPanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "Sprojectintegralsumrecordpymor";
        }

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
        commonQuery();
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
                GenericViewWindow detail = new GenericViewWindow();
                detail.setTitle("项目积分汇总明细");
                detail.setWidth100();
                detail.setHeight100();
                SprojectintegralsumrecordpymorViewer detailForm = new SprojectintegralsumrecordpymorViewer();
                detailForm.setParentSearchForm(searchForm);
                detailForm.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_TAB);
                detailForm.initComponents();
                detailForm.viewSelectedData(resultGrid);
                detail.setContent(detailForm);
                detail.centerInPage();
                detail.show();
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
        DBDataSource ds = (DBDataSource) getDataSource();
        String operationName = ds.getActionMode() + ds.getActionName();
        DBDataSource.callOperation(operationName, condition, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                    double projectIntegralSum = 0;//项目总积分
                    double projectIntegral = 0;//项目积分
                    double reserveIntegral = 0;//预留积分
                    double sureIntegral = 0;//确认积分
                    double costIntegral = 0;//成本积分
                    double settlementIntegral = 0;//结算积分
                    Record[] record = dsResponse.getData();
                    for (Record e : record) {
                        if (projectIntegralSum == 0) {
                            projectIntegralSum = ClientUtil.checkAndGetDoubleValue(e.getAttribute("projectIntegralSum"));
                        }
                        if (projectIntegral == 0) {
                            projectIntegral = ClientUtil.checkAndGetDoubleValue(e.getAttribute("projectIntegral"));
                        }
                        if (reserveIntegral == 0) {
                            reserveIntegral = ClientUtil.checkAndGetDoubleValue(e.getAttribute("reserveIntegral"));
                        }
                        sureIntegral += ClientUtil.checkAndGetDoubleValue(e.getAttribute("sureIntegral"));
                        costIntegral += ClientUtil.checkAndGetDoubleValue(e.getAttribute("projectCost"));
                        settlementIntegral += ClientUtil.checkAndGetDoubleValue(e.getAttribute("settlementIntegral"));
                    }
                    totalItem.setValue("项目总积分:" + CommonFormat.doubleFormat(projectIntegralSum) + "  项目积分:" + CommonFormat.doubleFormat(projectIntegral) + "  预留积分:" + CommonFormat.doubleFormat(reserveIntegral) + "  确认积分:" + CommonFormat.doubleFormat(sureIntegral) + "  项目成本:" + CommonFormat.doubleFormat(costIntegral) + "  结算积分:" + CommonFormat.doubleFormat(settlementIntegral));
                    resultGrid.setData(record);
                    afterDataReceived(record);
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
        if (paramMap != null && paramMap.size() > 0) {
            int projectId = ClientUtil.checkAndGetIntValue(paramMap.get("projectId"));
            int year = ClientUtil.checkAndGetIntValue(paramMap.get("year"));
            int startMonth = ClientUtil.checkAndGetIntValue(paramMap.get("startMonth"));
            int endMonth = ClientUtil.checkAndGetIntValue(paramMap.get("endMonth"));
            criteria.put("projectId", projectId);
            if (year > 0) {
                criteria.put("year", year);
            }
            if (startMonth > 0) {
                criteria.put("startMonth", startMonth);
            }
            if (endMonth > 0) {
                criteria.put("endMonth", endMonth);
            }
            return true;
        }
        return false;
    }

    @Override
    public SearchForm generateSearchForm() {
        return null;
    }

    @Override
    public DataSource getDataSource() {
        return DSSprojectintegralsumrecordpymor.getInstance();
    }

    public void setParamMap(Map map) {
        this.paramMap = map;
    }

    public Map getParamMap() {
        return this.paramMap;
    }

}
