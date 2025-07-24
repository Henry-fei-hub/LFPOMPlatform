package com.pomplatform.client.splateintegralsumrecordpysor.panel;

import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PaginationPanel;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.CommonFormat;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.common.SetPlateIntegralAccount;
import com.pomplatform.client.employeeawardtotal.panel.MemployeeAwardTotalPanel;
import com.pomplatform.client.splateintegralsumrecordpysor.datasource.DSSplateintegralsumrecordpysor;
import com.pomplatform.client.splateintegralsumrecordpysor.form.SplateintegralsumrecordpysorSearchForm;
import com.pomplatform.client.splateintegralsumrecordpysor.form.SplateintegralsumrecordpysorViewer;
import com.pomplatform.client.splateprojectordepartmentintegralsumrecordpysor.panel.SplateProjectOrDepartmentIntegralSumRecordpysorPanel;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.Browser;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.events.KeyPressEvent;
import com.smartgwt.client.widgets.events.KeyPressHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class SplateintegralsumrecordpysorPanel extends AbstractSearchPanel {

    public static final Logger logger = Logger.getLogger("");
    private DynamicForm __infoForm;
    private TextItem totalItem;
    private String plateIds;

    public static class Factory implements PanelFactory {

        private String id;

        @Override
        public Canvas create() {
            SplateintegralsumrecordpysorPanel cm = new SplateintegralsumrecordpysorPanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "Splateintegralsumrecordpysor";
        }

    }

    @Override
    public void initComponents() {
    	plateIds = PomPlatformClientUtil.getRolePlateId();
        resultGrid.setShowRowNumbers(true);
        resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
            @Override
            public void onDoubleClick(DoubleClickEvent event) {
                ListGridRecord[] selected = resultGrid.getSelectedRecords();
                int plateId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("plateId"));
                Map condition = generateCriteria();
                condition.put("plateId", plateId);
                //获取板块名称
                String plateName = KeyValueManager.getValue("system_dictionary_1", plateId + "");
                PopupWindow pw = new PopupWindow();
                SplateProjectOrDepartmentIntegralSumRecordpysorPanel panel = new SplateProjectOrDepartmentIntegralSumRecordpysorPanel();
                panel.setParamMap(condition);
                pw.addItem(panel.getViewPanel());
                pw.setTitle("业务部门(" + plateName + ")的汇总明细");
                pw.setWidth100();
                pw.setHeight100();
                pw.centerInPage();
                pw.show();
            }
        });

        IButton accountButton = PermissionControl.createPermissionButton("汇总计算", ERPPermissionStatic.PLATE_ACCOUNT_CALCULATE_BUTTON);
        controlLayout.addMember(accountButton);
        accountButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                GWT.runAsync(new RunAsyncCallback() {
                    @Override
                    public void onFailure(Throwable reason) {
                        SC.say("failure to download code");
                    }

                    @Override
                    public void onSuccess() {
                        PopupWindow popupWindow = new PopupWindow("汇总计算");
                        popupWindow.setWidth("50%");
                        popupWindow.setHeight("60%");
                        popupWindow.centerInPage();
                        SetPlateIntegralAccount account = new SetPlateIntegralAccount();
                        account.addDataEditedHandler(new DataEditedHandler() {
                            @Override
                            public void onDataEdited(DataEditEvent event) {
                                commonQuery();
                            }
                        });
                        //根据当前操作人是否拥有查看所有业务部门的数据已经计算功能，如果有，则计算所有业务部门的数据，如果没有，则计算当前操作人的所属业务部门的数据
                        account.initComponents(1,plateIds);
                        popupWindow.addItem(account);
                        account.setParentWindow(popupWindow);
                        popupWindow.centerInPage();
                        popupWindow.show();
                    }
                });
            }
        });

        IButton lockButton = PermissionControl.createPermissionButton("汇总加锁", ERPPermissionStatic.PLATE_ACCOUNT_LOCK_BUTTON);
        controlLayout.addMember(lockButton);
        lockButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                GWT.runAsync(new RunAsyncCallback() {
                    @Override
                    public void onFailure(Throwable reason) {
                        SC.say("failure to download code");
                    }

                    @Override
                    public void onSuccess() {
                    	PopupWindow popupWindow = new PopupWindow("汇总加锁");
                    	popupWindow.setWidth("50%");
                    	popupWindow.setHeight("60%");
                    	popupWindow.centerInPage();
                    	SetPlateIntegralAccount account = new SetPlateIntegralAccount();
                    	account.addDataEditedHandler(new DataEditedHandler() {
                    		@Override
                    		public void onDataEdited(DataEditEvent event) {
                    			commonQuery();
                    		}
                    	});
                    	account.initComponents(2, plateIds);
                    	popupWindow.addItem(account);
                    	account.setParentWindow(popupWindow);
                    	popupWindow.centerInPage();
                    	popupWindow.show();
                    }
                });
            }
        });
        
        IButton movelockButton = PermissionControl.createPermissionButton("汇总解锁", ERPPermissionStatic.PLATE_ACCOUNT_MOVE_LOCK_BUTTON);
        controlLayout.addMember(movelockButton);
        movelockButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                GWT.runAsync(new RunAsyncCallback() {
                    @Override
                    public void onFailure(Throwable reason) {
                        SC.say("failure to download code");
                    }

                    @Override
                    public void onSuccess() {
                    	PopupWindow popupWindow = new PopupWindow("汇总解锁");
                    	popupWindow.setWidth("50%");
                    	popupWindow.setHeight("60%");
                    	popupWindow.centerInPage();
                    	SetPlateIntegralAccount account = new SetPlateIntegralAccount();
                    	account.addDataEditedHandler(new DataEditedHandler() {
                    		@Override
                    		public void onDataEdited(DataEditEvent event) {
                    			commonQuery();
                    		}
                    	});
                    	account.initComponents(3,plateIds);
                    	popupWindow.addItem(account);
                    	account.setParentWindow(popupWindow);
                    	popupWindow.centerInPage();
                    	popupWindow.show();
                    }
                });
            }
        });
        
        IButton checkButton = PermissionControl.createPermissionButton("查看成员汇总", ERPPermissionStatic.INTEGRAL_TOTAL_VIEW_MEMBER);
        controlLayout.addMember(checkButton);
        checkButton.addClickHandler(new ClickHandler() {
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
        
        IButton downLoadButton = PermissionControl.createPermissionButton("导出", ERPPermissionStatic.PLATE_ACCOUNT_DOWNLOAD_BUTTON);
        controlLayout.addMember(downLoadButton);
        downLoadButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                Map condition = generateCriteria();
                ClientUtil.departmentParameterProcess(condition);
                DBDataSource.downloadFile("DW_Splateintegralsumrecordpysor", condition);
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
                detail.setTitle("业务部门积分汇总");
                detail.setWidth100();
                detail.setHeight100();
                SplateintegralsumrecordpysorViewer detailForm = new SplateintegralsumrecordpysorViewer();
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
                if (dsResponse.getStatus() >= 0) {
                    double achieveIntegral = 0;//价值积分
                    double projectIntegralSum = 0;//项目总积分
                    double projectIntegral = 0;//项目积分
                    double reserveIntegral = 0;//预留积分
                    double sureIntegral = 0;//确认积分
                    double costIntegral = 0;//成本积分
                    double settlementIntegral = 0;//结算积分
                    double salaryIntegral = 0;//人工成本
                    Record[] record = dsResponse.getData();
                    for (Record e : record) {
                        achieveIntegral += ClientUtil.checkAndGetDoubleValue(e.getAttribute("achieveIntegral"));
                        projectIntegralSum += ClientUtil.checkAndGetDoubleValue(e.getAttribute("projectIntegralSum"));
                        projectIntegral += ClientUtil.checkAndGetDoubleValue(e.getAttribute("projectIntegral"));
                        reserveIntegral += ClientUtil.checkAndGetDoubleValue(e.getAttribute("reserveIntegral"));
                        sureIntegral += ClientUtil.checkAndGetDoubleValue(e.getAttribute("sureIntegral"));
                        costIntegral += ClientUtil.checkAndGetDoubleValue(e.getAttribute("costIntegral"));
                        settlementIntegral += ClientUtil.checkAndGetDoubleValue(e.getAttribute("settlementIntegral"));
                        salaryIntegral += ClientUtil.checkAndGetDoubleValue(e.getAttribute("salaryIntegral"));
                    }
                    totalItem.setValue("价值积分:" + CommonFormat.doubleFormat(achieveIntegral) + "  项目总积分:" + CommonFormat.doubleFormat(projectIntegralSum) + "  项目积分:" + CommonFormat.doubleFormat(projectIntegral) + "  预留积分:" + CommonFormat.doubleFormat(reserveIntegral) + "  确认积分:" + CommonFormat.doubleFormat(sureIntegral) + "  成本积分:" + CommonFormat.doubleFormat(costIntegral) + "  结算积分:" + CommonFormat.doubleFormat(settlementIntegral) + "  人工成本:" + CommonFormat.doubleFormat(salaryIntegral));
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
        //如果没有查看所有部门数据，则只检索自己部门下的数据
        if(!ClientUtil.checkIsHavePermission(ERPPermissionStatic.PLATE_ACCOUNT_MANAGEMENT_CHECK_ALL_DATA)){
            int plateId = ClientUtil.getPlateId();
            criteria.put("plateId", plateId);
        }
        return true;
    }

    @Override
    public SearchForm generateSearchForm() {
        return new SplateintegralsumrecordpysorSearchForm();
    }

    @Override
    public DataSource getDataSource() {
        return DSSplateintegralsumrecordpysor.getInstance();
    }

    @Override
    public int getSearchFormHeight() {
        return 63;
    }

}
