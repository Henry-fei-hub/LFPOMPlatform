package com.pomplatform.client.employeeawardtotal.panel;

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
import com.pomplatform.client.employeeawardtotal.datasource.DSMemployeeAwardTotal;
import com.pomplatform.client.employeeawardtotal.form.MemployeeAwardTotalSearchForm;
import com.pomplatform.client.plateintegralassignrecord.panel.SplateIntegralAssignRecordPanel;
import com.pomplatform.client.projectcost.panel.SprojectcostpcorPanel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.user.client.Cookies;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.CommonFormat;
import com.pomplatform.client.data.RoleDefinition;
import com.pomplatform.client.employeeaward.panel.MemployeeAwardPanel;
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

public class MemployeeAwardTotalPanel extends AbstractSearchPanel {
    private final Logger __logger = Logger.getLogger("");
    private DynamicForm __infoForm ;
    private TextItem totalItem ;
    private int plateId;
    private int flag;

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

    /**
     * @return the flag
     */
    public int getFlag() {
        return flag;
    }

    /**
     * @param flag the flag to set
     */
    public void setFlag(int flag) {
        this.flag = flag;
    }
    public static class Factory implements PanelFactory {

        private String id;

        @Override
        public Canvas create() {
            MemployeeAwardTotalPanel cm = new MemployeeAwardTotalPanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "MemployeeAwardTotal";
        }
    }

    @Override
    public void initComponents() {
        resultGrid.setShowRowNumbers(true);
        commonQuery();
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
        
        IButton operation6Button = new IButton("导出");
        controlLayout.addMember(operation6Button);
        operation6Button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                Map condition = generateCriteria();
                ClientUtil.departmentParameterProcess(condition);
                DBDataSource.downloadFile("DW_MemployeeAwardTotal", condition);
            }
        });
        
        final IButton checkIntegralButton = new IButton("查看积分发放");
        controlLayout.addMember(checkIntegralButton);
        checkIntegralButton.addClickHandler(new ClickHandler() {
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
                        ListGridRecord selected = resultGrid.getSelectedRecord();
                        int employeeId = ClientUtil.checkAndGetIntValue(selected.getAttribute("employeeId"));
                        //获取职员名称
                        String employeeName = KeyValueManager.getValue("employees",String.valueOf(employeeId));
                        PopupWindow pw = new PopupWindow();
                        SplateIntegralAssignRecordPanel spp = new SplateIntegralAssignRecordPanel();
                        spp.setEmployeeId(employeeId);
                        pw.addItem(spp.getViewPanel());
                        pw.setTitle("职员("+employeeName+")的积分发放记录");
                        pw.setWidth100();
                        pw.setHeight100();
                        pw.centerInPage();
                        pw.show();
                        spp.commonQuery();
                    }
                });
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
                Map condition = new HashMap();
                if (searchForm != null) {
                    Map values = searchForm.getValues();
                    condition.putAll(values);
                }
                int years = ClientUtil.checkAndGetIntValue(condition.get("years"));
                int startMonth = ClientUtil.checkAndGetIntValue(condition.get("startMonth"));
                int endMonth = ClientUtil.checkAndGetIntValue(condition.get("endMonth"));
                ListGridRecord[] selected = resultGrid.getSelectedRecords();
                String employeeName = selected[0].getAttribute("employeeName");
                int employeeId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("employeeId"));
                PopupWindow pw = new PopupWindow();
                MemployeeAwardPanel myselfProject = new MemployeeAwardPanel();
                myselfProject.setYears(years);
                myselfProject.setStartMonth(startMonth);
                myselfProject.setEndMonth(endMonth);
                myselfProject.setEmployeeId(employeeId);
                pw.addItem(myselfProject.getViewPanel());
                pw.setTitle(employeeName+years+"年从"+startMonth+"月到"+endMonth+"月的积分明细");
                pw.setWidth100();
                pw.setHeight100();
                pw.centerInPage();
                pw.show();
                myselfProject.commonQuery();
                
//                GenericViewWindow detail = new GenericViewWindow();
//                detail.setTitle("积分汇总");
//                detail.setWidth100();
//                detail.setHeight100();
//                MemployeeAwardTotalViewer detailForm = new MemployeeAwardTotalViewer();
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
                double planIntegral = 0;//预分配积分
                double achieveAward = 0;//价值积分
                double achieveIntegral = 0;//结算积分
                double projectCost = 0;//项目成本
                double sureIntegral = 0;//确认积分
                double baseSalary = 0;//人工成本
                if (dsResponse.getStatus() >= 0) {
                    Record[] record = dsResponse.getData();
                    for(Record e : record){
                        planIntegral += ClientUtil.checkAndGetDoubleValue(e.getAttribute("planIntegral"));
                        achieveAward += ClientUtil.checkAndGetDoubleValue(e.getAttribute("achieveAward"));
                        achieveIntegral += ClientUtil.checkAndGetDoubleValue(e.getAttribute("achieveIntegral"));
                        projectCost += ClientUtil.checkAndGetDoubleValue(e.getAttribute("projectCost"));
                        sureIntegral += ClientUtil.checkAndGetDoubleValue(e.getAttribute("sureIntegral"));
                        baseSalary += ClientUtil.checkAndGetDoubleValue(e.getAttribute("baseSalary"));
                    }
                    totalItem.setValue("预分配积分:"+CommonFormat.doubleFormat(planIntegral)+"  确认积分:"+CommonFormat.doubleFormat(sureIntegral)+"  项目成本:"+CommonFormat.doubleFormat(projectCost)+"  结算积分:"+CommonFormat.doubleFormat(achieveIntegral)+"  价值积分:"+CommonFormat.doubleFormat(achieveAward)+"  人工成本:"+CommonFormat.doubleFormat(baseSalary));
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
        if(!ClientUtil.checkIsHavePermission(ERPPermissionStatic.EMPLOYEE_INTEGRAL_TOTAL_CHECK_ALL_DATA)){
            int plateIdLogin = ClientUtil.getPlateId();
            criteria.put("plateId", plateIdLogin);
        }
        if(flag == 1){
            criteria.put("plateId",plateId);
        }
        //获取年份和月份，拼凑成日期格式
        int yearsValue = ClientUtil.checkAndGetIntValue(criteria.get("years"));
        int startMonthValue = ClientUtil.checkAndGetIntValue(criteria.get("startMonth"));
        int endMonthValue = ClientUtil.checkAndGetIntValue(criteria.get("endMonth"));
        String startMonth = yearsValue+"-"+startMonthValue+"-01";
        String endMonth;
        if(endMonthValue==12){
            endMonth = (yearsValue+1)+"-01-01";
        }else{
            endMonth = yearsValue+"-"+(endMonthValue+1)+"-01";
        }
        criteria.put("startMonth", startMonth);
        criteria.put("endMonth", endMonth);
        //把年份和月份传到后台去检索公共的成本
        criteria.put("yearsValue", yearsValue);
        criteria.put("startMonthValue", startMonthValue);
        criteria.put("endMonthValue", endMonthValue);
        String employeeNameValue = (String)criteria.get("employeeNameValue");
        if(employeeNameValue != null && employeeNameValue.length()>0){
            criteria.put("employeeName", employeeNameValue);
        }
        ClientUtil.departmentParameterProcess(criteria);
        return true; 
    }
    
    @Override
    public SearchForm generateSearchForm() {
        return new MemployeeAwardTotalSearchForm();
    }

    @Override
    public DataSource getDataSource() {
        return DSMemployeeAwardTotal.getInstance();
    }

}
