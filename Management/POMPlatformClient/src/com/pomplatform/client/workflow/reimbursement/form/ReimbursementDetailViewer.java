package com.pomplatform.client.workflow.reimbursement.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.GroupColumn;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.pomplatform.client.workflow.reimbursement.datasource.DSReimbursementDetail;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.viewer.DetailViewer;

public class ReimbursementDetailViewer extends AbstractDetailViewer {

    public ReimbursementDetailViewer() {
    }

    @Override
    public void initComponents() {
        super.initComponents();
    }

    @Override
    public int getHorizontalPercent() {
        return 0;
    }

    @Override
    public String getName() {
        return "报销明细";
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
        if (getBusinessId() == null) {
            return;
        }
        Map params = new HashMap();
        params.put("reimbursementDetailId", getBusinessId());
        DBDataSource.callOperation("ST_ReimbursementDetail", "find", new DSCallback() {
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
    }

    @Override
    public DataSource getMainDataSource() {
        return DSReimbursementDetail.getInstance();
    }

    @Override
    public int getDetailCount() {
        return 0;
    }

    @Override
    public List<ListGrid> getDetailListGrids() {
        List<ListGrid> res = new ArrayList<ListGrid>();
        return res;
    }

    @Override
    public List<String> getDetailNames() {
        List<String> res = new ArrayList<String>();
        return res;
    }

}
