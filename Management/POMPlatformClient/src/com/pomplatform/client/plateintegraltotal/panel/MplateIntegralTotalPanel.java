package com.pomplatform.client.plateintegraltotal.panel;

import com.delicacy.client.PaginationPanel;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.plateintegraltotal.datasource.DSMplateIntegralTotal;
import com.pomplatform.client.plateintegraltotal.form.MplateIntegralTotalSearchForm;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.user.client.Cookies;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.data.RoleDefinition;
import com.pomplatform.client.employeeawardtotal.panel.MemployeeAwardTotalPanel;
import com.pomplatform.client.plateintegraldetail.panel.MplateIntegralDetailPanel;
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

public class MplateIntegralTotalPanel extends AbstractSearchPanel {
    private final Logger __logger = Logger.getLogger("");
    private DynamicForm __infoForm ;
    private TextItem totalItem ;
    public static class Factory implements PanelFactory {

        private String id;

        @Override
        public Canvas create() {
            MplateIntegralTotalPanel cm = new MplateIntegralTotalPanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "MplateIntegralTotal";
        }

    }

    @Override
    public void initComponents() {
        commonQuery();
        resultGrid.setAutoFitFieldWidths(false);
        resultGrid.setAutoFetchData(false);
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
        
        IButton operation2Button = PermissionControl.createPermissionButton("查看成员汇总", ERPPermissionStatic.INTEGRAL_TOTAL_VIEW_MEMBER);
        controlLayout.addMember(operation2Button);
        operation2Button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (!resultGrid.anySelected()) {
                    SC.say("请选择一条数据");
                    return;
                }
                ListGridRecord[] selected = resultGrid.getSelectedRecords();
                int plateId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("plateId"));
                //获取板块名称
                String palteName = KeyValueManager.getValue("system_dictionary_1", plateId+"");
                PopupWindow pw = new PopupWindow();
                MemployeeAwardTotalPanel myselfProject = new MemployeeAwardTotalPanel();
                myselfProject.setPlateId(plateId);
                myselfProject.setFlag(1);
                pw.addItem(myselfProject.getViewPanel());
                pw.setTitle("业务部门("+palteName+")的成员汇总");
                pw.setWidth100();
                pw.setHeight100();
                pw.centerInPage();
                pw.show();
                myselfProject.commonQuery();
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
                int plateId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("plateId"));
                //获取板块名称
                String palteName = KeyValueManager.getValue("system_dictionary_1", plateId+"");
                PopupWindow pw = new PopupWindow();
                MplateIntegralDetailPanel myselfProject = new MplateIntegralDetailPanel();
                myselfProject.setPlateId(plateId);
                pw.addItem(myselfProject.getViewPanel());
                pw.setTitle("业务部门("+palteName+")的汇总明细");
                pw.setWidth100();
                pw.setHeight100();
                pw.centerInPage();
                pw.show();
                myselfProject.commonQuery();
                
//                GenericViewWindow detail = new GenericViewWindow();
//                detail.setTitle("板块积分汇总");
//                detail.setWidth100();
//                detail.setHeight100();
//                MplateIntegralTotalViewer detailForm = new MplateIntegralTotalViewer();
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
                    for(Record e : record){
                        achieveIntegral += ClientUtil.checkAndGetDoubleValue(e.getAttribute("achieveIntegral"));
                        reserveIntegral += ClientUtil.checkAndGetDoubleValue(e.getAttribute("reserveIntegral"));
                        sureIntegral += ClientUtil.checkAndGetDoubleValue(e.getAttribute("sureIntegral"));
                        costIntegral += ClientUtil.checkAndGetDoubleValue(e.getAttribute("costIntegral"));
                        salaryIntegral += ClientUtil.checkAndGetDoubleValue(e.getAttribute("salaryIntegral"));
                    }
                    totalItem.setValue("价值积分:"+Math.round(achieveIntegral)+"  预留积分:"+Math.round(reserveIntegral)+"  确认积分:"+Math.round(sureIntegral)+"  成本积分:"+Math.round(costIntegral)+"  人工成本:"+Math.round(salaryIntegral));
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
        //如果是高管，则查看所有版块
        int roleID = ClientUtil.getRoleId();
        //获取板块
        int plateId = ClientUtil.checkAndGetIntValue(Cookies.getCookie(ClientUtil.OPRERATOR_PLATEID_COOKIE));
        if(roleID != RoleDefinition.ROLE_MANAGEMENT_TEAM){
            criteria.put("plateId", plateId);
        }
        return true; 
    }
    
    @Override
    public int getSearchFormHeight() {
        return 63; 
    }
    
    @Override
    public SearchForm generateSearchForm() {
        return new MplateIntegralTotalSearchForm();
    }

    @Override
    public DataSource getDataSource() {
        return DSMplateIntegralTotal.getInstance();
    }

}
