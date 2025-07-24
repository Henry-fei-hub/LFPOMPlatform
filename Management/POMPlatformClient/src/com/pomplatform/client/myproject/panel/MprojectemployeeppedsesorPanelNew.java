package com.pomplatform.client.myproject.panel;

import com.delicacy.client.DelicacyPanel;
import com.delicacy.client.PaginationPanel;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.pomplatform.client.myproject.datasource.DSMprojectemployeeppedsesor;
import com.pomplatform.client.myproject.form.MprojectemployeeppedsesorSearchForm;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.datepicker.client.CalendarUtil;
import com.smartgwt.client.data.*;
import com.smartgwt.client.types.BackgroundRepeat;
import com.smartgwt.client.types.TimeUnit;
import com.smartgwt.client.widgets.calendar.CalendarEvent;
import com.smartgwt.client.widgets.calendar.HeaderLevel;
import com.smartgwt.client.widgets.calendar.Lane;
import com.smartgwt.client.widgets.calendar.Timeline;
import com.smartgwt.client.widgets.calendar.events.CalendarEventClick;
import com.smartgwt.client.widgets.calendar.events.EventClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class MprojectemployeeppedsesorPanelNew extends DelicacyPanel {

    private static final Logger __logger = Logger.getLogger("");
    protected PaginationPanel pager;
    protected SearchForm searchForm;
    protected Timeline resultGrid;
    protected VLayout controlLayout;
    private int __currentPage = 0;
    private IButton searchButton;

    public static class Factory implements PanelFactory {

        private String id;

        @Override
        public Canvas create() {
            MprojectemployeeppedsesorPanelNew cm = new MprojectemployeeppedsesorPanelNew();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "Mprojectemployeeppedsesor";
        }

    }

    @Override
    public Canvas getViewPanel() {
        searchForm = generateSearchForm();
        VLayout layout = new VLayout();
        layout.setWidth100();
        layout.setHeight100();
        layout.setBackgroundImage("backgrounds/bg.jpg");
        layout.setBackgroundRepeat(BackgroundRepeat.REPEAT);

        if (searchForm != null) {

            HLayout searchLayout = new HLayout(5);
            searchLayout.setMargin(10);
            layout.addMember(searchLayout);

            searchForm.setWidth100();
            searchLayout.addMember(searchForm);

            VLayout buttonLayout = new VLayout(5);
            searchButton = new IButton("Find");
            searchButton.setIcon("[SKIN]/actions/search.png");

            IButton resetButton = new IButton("Reset");
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
        dataLayout.setBorder("2px solid gray");
        resultLayout.addMember(dataLayout);

        resultGrid = new Timeline();

        HeaderLevel[] headerLevels = new HeaderLevel[]{
            new HeaderLevel(TimeUnit.WEEK),
            new HeaderLevel(TimeUnit.DAY)
        };
        ListGridField[] laneFields = new ListGridField[]{
            new ListGridField("projectName", "项目名称", 220)};
        resultGrid.setCanEditLane(false);
        resultGrid.setCanEditEvents(false);
        resultGrid.setLaneFields(laneFields);
        //设置默认显示当前月的数据,默认显示当前月到后两个月
        Date startDate = new Date();
        CalendarUtil.setToFirstDayOfMonth(startDate);
        resultGrid.setStartDate(startDate);
        Date endDate = new Date();
        CalendarUtil.addMonthsToDate(endDate, 2);
        CalendarUtil.setToFirstDayOfMonth(endDate);
        resultGrid.setEndDate(endDate);
        resultGrid.setHeaderLevels(headerLevels);
        resultGrid.setDataSource(getDataSource());

        resultGrid.addEventClickHandler(new EventClickHandler() {
            @Override
            public void onEventClick(CalendarEventClick event) {
                event.cancel();
                CalendarEvent ce = event.getEvent();
                Map ceData = ce.toMap();
                __logger.info(ceData.toString());
            }

        });

        dataLayout.addMember(resultGrid);
        controlLayout = new VLayout();
        controlLayout.setHeight100();
        controlLayout.setLayoutTopMargin(30);
        controlLayout.setLayoutLeftMargin(5);
        controlLayout.setLayoutRightMargin(5);
        controlLayout.setMembersMargin(10);

        dataLayout.addMember(controlLayout);
        pager = new PaginationPanel();
        resultLayout.addMember(pager);

        layout.addMember(resultLayout);

        pager.getGotoButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                TextItem item = pager.getGotoPage();
                String strPageNo = item.getValueAsString();
                if (strPageNo == null || strPageNo.equals("")) {
                    return;
                }
                currentPage = ClientUtil.checkAndGetIntValue(strPageNo);
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
        initComponents();
        setControlLayoutWidth();
        return layout;
    }

    public void initComponents() {
        resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
            @Override
            public void onDoubleClick(DoubleClickEvent event) {
                showDetail();
            }
        });
//        IButton viewButton = new IButton("查看详细");
//        viewButton.addClickHandler(new ClickHandler() {
//            @Override
//            public void onClick(ClickEvent event) {
//                showDetail();
//            }
//        });
//        controlLayout.addMember(viewButton);
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
//                GenericViewWindow detail = new GenericViewWindow();
//                detail.setTitle("我的项目");
//                detail.setWidth("60%");
//                detail.setHeight("60%");
//                MprojectemployeeppedsesorViewer detailForm = new MprojectemployeeppedsesorViewer();
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

    public SearchForm generateSearchForm() {
        return new MprojectemployeeppedsesorSearchForm();
    }

    public DataSource getDataSource() {
        return DSMprojectemployeeppedsesor.getInstance();
    }

    public void setControlLayoutWidth() {
        setControlLayoutWidth(120);
    }

    public void setControlLayoutWidth(int w) {
        controlLayout.setWidth(w);
        Canvas[] mems = controlLayout.getMembers();
        if (mems != null && mems.length > 0) {
            for (Canvas c : mems) {
                c.setWidth(w - 10);
            }
        }
    }

    public Map generateCriteria() {
        Map condition = new HashMap();
        if (searchForm != null) {
            Map values = searchForm.getValues();
            condition.putAll(values);
        }
        Map pageCon = pager.getPagenationCondition(currentPage, pageLines);
        condition.putAll(pageCon);
        if (!checkSearchCriteria(condition)) {
            return null;
        }
        return condition;
    }

    public void commonQuery() {
        Map condition = generateCriteria();
        if (condition == null) {
            return;
        }
        searchButton.setIcon("loading38.gif");
        DBDataSource ds = (DBDataSource) getDataSource();
        String operationName = ds.getActionMode() + ds.getActionName();
        DBDataSource.callOperation(operationName, condition, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                searchButton.setIcon("[SKIN]/actions/search.png");
                if (dsResponse.getStatus() >= 0) {
                    Record[] rs = dsResponse.getData();
                    CalendarEvent[] ces = new CalendarEvent[rs.length];
                    Lane[] lanes = new Lane[rs.length];
                    int idx = 0;
                    if (rs != null && rs.length > 0) {
                        for (Record r : rs) {
                            String lname = String.valueOf(ClientUtil.checkAndGetIntValue(r.getAttribute("projectEmployeeId")));
                            ces[idx] = new CalendarEvent(ClientUtil.checkAndGetIntValue(r.getAttribute("projectEmployeeId")), r.getAttribute("projectName"), "",
                                    r.getAttributeAsDate("startDate"),
                                    r.getAttributeAsDate("endDate"), lname);
                            DBDataSource.copyRecord(r, ces[idx]);
                            lanes[idx] = new Lane(lname, r.getAttribute("projectName"));
                            lanes[idx].setAttribute("projectName", r.getAttribute("projectName"));
                            idx++;
                        }
                    }
                    resultGrid.setLanes(lanes);
                    resultGrid.setData(ces);
                    if (currentPage == 1) {
                        totalPages = dsResponse.getAttributeAsInt("totalPages");
                        pager.getTotalPages().setContents(String.valueOf(totalPages));
                    }
                } else {
                    SC.say(dsResponse.getErrors().get("errorMsg").toString());
                }
                pager.getCurrentPage().setContents(String.valueOf(currentPage));
            }
        });
    }

    public boolean checkSearchCriteria(Map criteria) {
        criteria.put("employeeId", Cookies.getCookie(ClientUtil.OPRERATORID_COOKIE));
        return true;
    }

    public String getSourceGenUrl() {
        return null;
    }

    @Override
    public String getIntro() {
        return null;
    }
    private int totalPages = 0;
    protected int currentPage = 1;
    private final int pageLines = 20;

    protected void setAppWindowAttributes() {
        popupWindow.setWidth100();
        popupWindow.setHeight100();
        popupWindow.setIsModal(true);
        popupWindow.setShowCloseButton(true);
        popupWindow.setShowMaximizeButton(true);
        popupWindow.setShowMinimizeButton(true);
        popupWindow.addCloseClickHandler(new CloseClickHandler() {
            @Override
            public void onCloseClick(CloseClickEvent event) {
                popupWindow.destroy();
            }
        });
    }

    protected Window popupWindow;

    /**
     * @return the __currentPage
     */
    public int getCurrentPage() {
        return __currentPage;
    }

    /**
     * @param __currentPage the __currentPage to set
     */
    public void setCurrentPage(int __currentPage) {
        this.__currentPage = __currentPage;
    }

}
