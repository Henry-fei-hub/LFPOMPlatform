package com.pomplatform.client.report.panel;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.report.datasource.DSReportEmployeeDailyHoursTotal;
import com.pomplatform.client.report.form.ReportEmployeeDailyHoursTotalSearchForm;
import com.pomplatform.client.report.form.ReportEmployeeDailyHoursTotalViewer;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;

import java.util.Map;
import java.util.logging.Logger;

/**
 * 员工日工时统计表
 */
public class ReportEmployeeDailyHoursTotalPanel extends AbstractSearchPanel {


    private static final Logger __LOGGER = Logger.getLogger("");

    public static class Factory implements PanelFactory {
        private String id;

        @Override
        public Canvas create() {
            ReportEmployeeDailyHoursTotalPanel cm = new ReportEmployeeDailyHoursTotalPanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "ReportEmployeeDailyHoursTotal";
        }

    }

    @Override
    public void init() {
        super.init();
        __controlPosition = LayoutConstant.RIGHT;
    }

    @Override
    public void initComponents() {
        IButton refreshButton = new IButton("刷新");
        controlLayout.addMember(refreshButton);
        refreshButton.setIcon("[SKIN]/actions/refresh.png");
        refreshButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                commonQuery();
            }
        });

        resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
            @Override
            public void onDoubleClick(DoubleClickEvent event) {
                showDetail();
            }
        });
        IButton viewButton = new IButton("查看详细");
        viewButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                showDetail();
            }
        });
        controlLayout.addMember(viewButton);

        IButton exportButton = new IButton("导出");
        exportButton.addClickHandler(new ClickHandler() {
            @SuppressWarnings("rawtypes")
            @Override
            public void onClick(ClickEvent clickEvent) {
                Map condition = generateCriteria();
                DBDataSource.downloadFile("DW_ReportEmployeeDaily", condition);
            }
        });
        controlLayout.addMember(exportButton);


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
                detail.setTitle("员工日工时详情");
                detail.setWidth100();
                detail.setHeight100();
                ReportEmployeeDailyHoursTotalViewer detailForm = new ReportEmployeeDailyHoursTotalViewer();
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
    public boolean checkSearchCriteria(Map criteria) {
        criteria.put("addtionalCondition", "order by employee_id");
        return true;
    }


    @Override
    public SearchForm generateSearchForm() {
        return new ReportEmployeeDailyHoursTotalSearchForm();
    }

    @Override
    public DataSource getDataSource() {
        return DSReportEmployeeDailyHoursTotal.getInstance();
    }


    @Override
    public int getSearchFormHeight() {
        return 60;
    }


}

