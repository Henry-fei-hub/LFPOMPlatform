package com.pomplatform.client.managementteamproject.panel;

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
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.managementteamproject.datasource.DSMManagementTeamProject;
import com.pomplatform.client.managementteamproject.form.MManagementTeamProjectSearchForm;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.myinvite.panel.MprojectAcceptTeamPanel;
import com.pomplatform.client.project.panel.SprojectccporPanelNew;
import com.pomplatform.client.projectlog.panel.SprojectlogppoorPanel;
import com.pomplatform.client.projectview.form.SprojectViewViewer;
import com.smartgwt.client.data.*;
import com.smartgwt.client.util.Browser;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import java.util.Map;
import java.util.logging.Logger;

public class MManagementTeamProjectPanel extends AbstractSearchPanel {
    private static final Logger __logger = Logger.getLogger("");
    private DynamicForm __infoForm ;
    private TextItem totalItem ;

    public static class Factory implements PanelFactory {

        private String id;

        @Override
        public Canvas create() {
            MManagementTeamProjectPanel cm = new MManagementTeamProjectPanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "MManagementTeamProject";
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
        
        IButton operation1Button = new IButton("查看详情");
        controlLayout.addMember(operation1Button);
        operation1Button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                showDetail();
            }
        });
        
        IButton operation2Button = new IButton("项目成员");
        controlLayout.addMember(operation2Button);
//        operation2Button.setIcon("[SKIN]/actions/edit.png");
        operation2Button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                GWT.runAsync(new RunAsyncCallback() {
                    @Override
                    public void onFailure(Throwable reason) {
                        SC.say("failure to download code");
                    }

                    @Override
                    public void onSuccess() {
                        if (!resultGrid.anySelected()) {
                            SC.say("请选择一条数据修改");
                            return;
                        }
                        ListGridRecord[] selected = resultGrid.getSelectedRecords();
                        String projectId = selected[0].getAttribute("projectId");
                        String projectName = selected[0].getAttribute("projectName");
                        PopupWindow pw = new PopupWindow();
                        MprojectAcceptTeamPanel myselfProject = new MprojectAcceptTeamPanel();
                        myselfProject.setProjectId(ClientUtil.checkAndGetIntValue(projectId));
                        pw.addItem(myselfProject.getViewPanel());
                        pw.setTitle(projectName+"项目组成员");
                        pw.setWidth100();
                        pw.setHeight100();
                        pw.centerInPage();
                        pw.show();
                        myselfProject.commonQuery();
                    }
                });
            }
        });
        
        final IButton operation13Button = new IButton("项目时间表");
        controlLayout.addMember(operation13Button);
        operation13Button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                GWT.runAsync(new RunAsyncCallback() {
                    @Override
                    public void onFailure(Throwable reason) {
                        SC.say("failure to download code");
                    }

                    @Override
                    public void onSuccess() {
                        if (!resultGrid.anySelected()) {
                            SC.say("请选择一条数据修改");
                            return;
                        }
                        ListGridRecord[] selected = resultGrid.getSelectedRecords();
                        String projectId = selected[0].getAttribute("projectId");
                        PopupWindow pw = new PopupWindow();
                        SprojectccporPanelNew myselfProject = new SprojectccporPanelNew();
                        myselfProject.setProjectId(ClientUtil.checkAndGetIntValue(projectId));
                        pw.addItem(myselfProject.getViewPanel());
                        pw.setTitle("项目时间表");
                        pw.setWidth100();
                        pw.setHeight100();
                        pw.centerInPage();
                        pw.show();
                        myselfProject.commonQuery();
                    }
                });
            }
        });
        
        IButton operation5Button = new IButton("项目日志");
        controlLayout.addMember(operation5Button);
        operation5Button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                GWT.runAsync(new RunAsyncCallback() {
                    @Override
                    public void onFailure(Throwable reason) {
                        SC.say("failure to download code");
                    }

                    @Override
                    public void onSuccess() {
                        if (!resultGrid.anySelected()) {
                            SC.say("请选择一条数据修改");
                            return;
                        }
                        ListGridRecord[] selected = resultGrid.getSelectedRecords();
                        String projectId = selected[0].getAttribute("projectId");
                        PopupWindow pw = new PopupWindow();
                        SprojectlogppoorPanel projectLog = new SprojectlogppoorPanel();
                        projectLog.setProjectId(ClientUtil.checkAndGetIntValue(projectId));
                        pw.addItem(projectLog.getViewPanel());
                        pw.setTitle("项目日志");
                        pw.setWidth100();
                        pw.setHeight100();
                        pw.centerInPage();
                        pw.show();
                        projectLog.commonQuery();
                    }
                });
            }
        });

        //默认执行一次查询
//        commonQuery();
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
                detail.setTitle("运营负责人项目");
                detail.setWidth100();
                detail.setHeight100();
                SprojectViewViewer detailForm = new SprojectViewViewer();
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
                double totalIntegral = 0;//项目总积分汇总
                double projectIntegral = 0;//项目积分
                double reserveIntegral = 0;//预留积分
                if (dsResponse.getStatus() >= 0) {
                    Record[] record = dsResponse.getData();
                    for(Record e : record){
                        totalIntegral += ClientUtil.checkAndGetDoubleValue(e.getAttribute("totalIntegral"));
                        projectIntegral += ClientUtil.checkAndGetDoubleValue(e.getAttribute("projectIntegral"));
                        reserveIntegral += ClientUtil.checkAndGetDoubleValue(e.getAttribute("reserveIntegral"));
                    }
                    totalItem.setValue("项目总积分:"+Math.round(totalIntegral)+"   项目积分:"+Math.round(projectIntegral)+"   预留积分:"+Math.round(reserveIntegral));
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
        ClientUtil.departmentParameterProcess(criteria);
        criteria.put("contractCode", contractCode);
        return true; 
    }
    
    @Override
    public int getSearchFormHeight() {
        return 126;
    }

    @Override
    public SearchForm generateSearchForm() {
        return new MManagementTeamProjectSearchForm();
    }

    @Override
    public DataSource getDataSource() {
        return DSMManagementTeamProject.getInstance();
    }
    
    private String contractCode;
    public void setContractCode(String contractCode){
        this.contractCode = contractCode;
    }
}
