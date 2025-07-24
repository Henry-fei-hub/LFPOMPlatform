package com.pomplatform.client.report.form;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.GroupColumn;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.GenericViewWindow;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.pomplatform.client.purchase.form.ProductAttributeViewer;
import com.pomplatform.client.report.datasource.DSReportEmployeeDailyHoursDetailTotal;
import com.pomplatform.client.report.datasource.DSWorkingHourReportManage;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.viewer.DetailViewer;

import java.util.*;

public class ReportEmployeeDailyHoursTotalViewer extends AbstractDetailViewer {


    private SearchForm __parentSearchForm;
    private final DelicacyListGrid productAttributesGrid = new DelicacyListGrid();
    public ReportEmployeeDailyHoursTotalViewer() {
    }

    @Override
    public void initComponents() {
        super.initComponents();

        productAttributesGrid.setDataSource(DSWorkingHourReportManage.getInstance());
        productAttributesGrid.addDoubleClickHandler(new DoubleClickHandler() {
            @Override
            public void onDoubleClick(DoubleClickEvent event) {

            }
        });

    }

    @Override
    public int getHorizontalPercent() {
        return 0;
    }

    @Override
    public String getName() {
        return "基础信息";
    }

    @Override
    public int getGroupCount() {
        return 0;
    }

    @Override
    public List<GroupColumn> getGroupColumnNames() {
        List<GroupColumn> gcs = new ArrayList<GroupColumn>();
        return gcs;
    }

    @Override
    public void load() {
        if (getBusinessId() == null) return;
        Map params = new HashMap();
        params.put("employeeId", getBusinessId());
        DBDataSource.callOperation("NQ_ReportEmployeeDailyHoursTotal", "find", new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                    for (DetailViewer v : detailViewers) {
                        v.setData(dsResponse.getData());
                        if (dsResponse.getData().length == 0) continue;
                        v.selectRecord(0);
                        v.redraw();
                    }
                    setRecord(dsResponse.getData()[0]);
                    viewDetailData();
                }
            }
        });
    }

    @Override
    public void viewSelectedData(ListGrid grid) {
        super.viewSelectedData(grid);
        setRecord(grid.getSelectedRecord());
        viewDetailData();
    }

    public void viewDetailData() {
        Record selected = getRecord();
        DateTimeFormat __DF = DateTimeFormat.getFormat("yyyy-MM-dd");
        Date workDate = selected.getAttributeAsDate("workDate");
        String yearStr = __DF.format(workDate);
        Map condition = new HashMap(0);
        condition.put("employeeId", BaseHelpUtils.getString(selected.getAttribute("employeeId")));
        condition.put("startWorkDate", yearStr);
        condition.put("endWorkDate",yearStr);
        DBDataSource.callOperation("NQ_WorkingHourManage", "find", condition, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                    productAttributesGrid.setData(dsResponse.getData());
                }
            }
        });
    }

    @Override
    public DataSource getMainDataSource() {
        return DSReportEmployeeDailyHoursDetailTotal.getInstance();
    }

    @Override
    public int getDetailCount() {
        return 1;
    }

    @Override
    public List<ListGrid> getDetailListGrids() {
        List<ListGrid> res = new ArrayList<ListGrid>();
        res.add(productAttributesGrid);
        return res;
    }

    @Override
    public List<String> getDetailNames() {
        List<String> res = new ArrayList<String>();
        res.add("项目信息");
        return res;
    }

    public SearchForm getParentSearchForm() {
        return this.__parentSearchForm;
    }

    public void setParentSearchForm(SearchForm value) {
        this.__parentSearchForm = value;
    }


}

