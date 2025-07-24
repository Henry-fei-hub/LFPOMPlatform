package com.pomplatform.client.workflow.reimbursement.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.GroupColumn;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.GenericViewWindow;
import com.pomplatform.client.workflow.reimbursement.datasource.DSReimbursementDetail;
import com.pomplatform.client.workflow.reimbursement.datasource.DSReimbursementWithR;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.viewer.DetailViewer;

public class ReimbursementWithRViewer extends AbstractDetailViewer {

    private final DelicacyListGrid reimbursementDetailsGrid = new DelicacyListGrid();

    public ReimbursementWithRViewer() {
    }

    @Override
    public void initComponents() {
        super.initComponents();
        reimbursementDetailsGrid.setDataSource(DSReimbursementDetail.getInstance());
        reimbursementDetailsGrid.addDoubleClickHandler(new DoubleClickHandler() {
            @Override
            public void onDoubleClick(DoubleClickEvent event) {
                GenericViewWindow detail = new GenericViewWindow();
                detail.setTitle("报销明细");
                detail.setWidth(700);
                detail.setHeight(500);
                ReimbursementDetailViewer viewer = new ReimbursementDetailViewer();
                viewer.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_NORMAL);
                viewer.initComponents();
                viewer.viewSelectedData((ListGrid) event.getSource());
                detail.setContent(viewer);
                detail.centerInPage();
                detail.show();
            }
        });
    }

    @Override
    public int getHorizontalPercent() {
        return 0;
    }

    @Override
    public String getName() {
        return "报销";
    }

    @Override
    public int getGroupCount() {
        return 1;
    }

    @Override
    public List<GroupColumn> getGroupColumnNames() {
        List<GroupColumn> gcs = new ArrayList<>();
        GroupColumn gc;
        gc = new GroupColumn();
        gc.setGroupName("GroupName1");
        gc.setGroupCaption("基本信息");
        gc.getColumnNames().add("subject");
        gc.getColumnNames().add("remark");
        gc.getColumnNames().add("amount");
        gcs.add(gc);
        return gcs;
    }

    @Override
    public void load() {
        if (getBusinessId() == null) {
            return;
        }
        Map params = new HashMap();
        params.put("reimbursementId", getBusinessId());
        DBDataSource.callOperation("ST_ReimbursementWithR", "find", new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                    for (DetailViewer v : detailViewers) {
                        v.setData(dsResponse.getData());
                        if (dsResponse.getData().length == 0) {
                            continue;
                        }
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

    @Override
    public void viewDetailData() {
        Record selected = getRecord();
        Object val;
        Map condition = null;
        condition = new HashMap();
        condition.put("reimbursementId", selected.getAttributeAsString("reimbursementId"));
        DBDataSource.callOperation("ST_ReimbursementDetail", "find", condition, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                    reimbursementDetailsGrid.setData(dsResponse.getData());
                }
            }
        });
    }

    @Override
    public DataSource getMainDataSource() {
        return DSReimbursementWithR.getInstance();
    }

    @Override
    public int getDetailCount() {
        return 1;
    }

    @Override
    public List<ListGrid> getDetailListGrids() {
        List<ListGrid> res = new ArrayList<>();
        res.add(reimbursementDetailsGrid);
        return res;
    }

    @Override
    public List<String> getDetailNames() {
        List<String> res = new ArrayList<>();
        res.add("报销明细");
        return res;
    }

}
