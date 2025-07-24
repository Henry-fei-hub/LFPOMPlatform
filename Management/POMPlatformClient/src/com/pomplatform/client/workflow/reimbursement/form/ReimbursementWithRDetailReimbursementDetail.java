package com.pomplatform.client.workflow.reimbursement.form;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.delicacy.client.MapUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.workflow.reimbursement.datasource.DSReimbursementDetail;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class ReimbursementWithRDetailReimbursementDetail extends AbstractWizadPage {

    private static final Logger __logger = Logger.getLogger("");
    private final DelicacyListGrid grid = new DelicacyListGrid(true);

    public ReimbursementWithRDetailReimbursementDetail() {
        __dataGrid = grid;
        HLayout reimbursementDetails = new HLayout();
        reimbursementDetails.setWidth100();
        reimbursementDetails.setHeight100();
        grid.setDataSource(DSReimbursementDetail.getInstance());
        grid.setAutoFitFieldWidths(false);
        reimbursementDetails.addMember(grid);
        VLayout reimbursementDetailsControls = new VLayout();
        reimbursementDetailsControls.setHeight100();
        reimbursementDetailsControls.setWidth(60);
        reimbursementDetailsControls.setLayoutTopMargin(30);
        reimbursementDetailsControls.setLayoutLeftMargin(5);
        reimbursementDetailsControls.setLayoutRightMargin(5);
        reimbursementDetailsControls.setMembersMargin(10);
        reimbursementDetails.addMember(reimbursementDetailsControls);
        addMember(reimbursementDetails);
        IButton reimbursementDetailsNewButton = new IButton("新增");
        reimbursementDetailsNewButton.setIcon("[SKIN]/actions/add.png");
        reimbursementDetailsNewButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                grid.startEditingNew();
            }
        });
        IButton reimbursementDetailsRemoveButton = new IButton("删除所有");
        reimbursementDetailsRemoveButton.setIcon("[SKIN]/actions/remove.png");
        reimbursementDetailsRemoveButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                grid.setData(new RecordList());
            }
        });
        reimbursementDetailsControls.addMember(reimbursementDetailsNewButton);
        reimbursementDetailsControls.addMember(reimbursementDetailsRemoveButton);
    }

    @Override
    public void startEdit() {
        if (getPageMode() != PAGE_MODE_UPDATE) {
            return;
        }
        reloadDetailTableData();
    }

    public void reloadDetailTableData() {
        Map<String,Object> condition = new HashMap<>();
        condition.put("reimbursementId", getRecord().getAttribute("reimbursementId"));
        DBDataSource.callOperation("ST_ReimbursementDetail", "find", condition, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                    grid.setData(dsResponse.getData());
                }
            }
        });
    }

    @Override
    public boolean checkData() {
        for (ListGridRecord r : grid.getRecords()) {
            __logger.info(MapUtils.convertRecordToMap(grid.getDataSource(), r).toString());
        }
        return true;
    }

    @Override
    public Set<String> getItemNames() {
        Set<String> res = new HashSet<>();
        res.add("detailReimbursementDetail");
        return res;
    }

    @Override
    public Map getValuesAsMap() {
        Map<String,Object> param = new HashMap<>();
        ListGridRecord[] rows = grid.getRecords();
        MapUtils.convertRecordToMap(grid.getDataSource(), rows, param, "detailReimbursementDetail");
        return param;
    }

    @Override
    public String getName() {
        return "报销明细";
    }

}
