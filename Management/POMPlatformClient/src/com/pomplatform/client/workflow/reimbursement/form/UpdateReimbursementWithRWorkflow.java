package com.pomplatform.client.workflow.reimbursement.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.AbstractWizadPage;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;

public class UpdateReimbursementWithRWorkflow extends AbstractProcessPanel {

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
                    setData(dsResponse.getData()[0]);
                    refreshPageData();
                }
            }
        });
    }

    @Override
    public boolean checkData(Map data) {
        return true;
    }

    @Override
    public int getPageCount() {
        return 2;
    }

    @Override
    public List<AbstractWizadPage> getPages() {
        setCallback(new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                // 请在此编写成功保存后要做的工作
            }
        });
        List<AbstractWizadPage> res = new ArrayList<>();
        final ReimbursementWithRGroupname1Update main = new ReimbursementWithRGroupname1Update();
        res.add(main);
        final ReimbursementWithRDetailReimbursementDetail reimbursementdetail = new ReimbursementWithRDetailReimbursementDetail();
        reimbursementdetail.setPageMode(AbstractWizadPage.PAGE_MODE_UPDATE);
        reimbursementdetail.getDataGrid().addEditCompleteHandler(new EditCompleteHandler() {
            @Override
            public void onEditComplete(EditCompleteEvent event) {
                ListGridRecord[] data = reimbursementdetail.getDataGrid().getRecords();
                if (data == null || data.length == 0) {
                    return;
                }
                double amount = 0.0;
                for (ListGridRecord r : data) {
                    amount += r.getAttributeAsDouble("amount");
                }
                FormItem item = main.findNamedItem("amount");
                if (item != null) {
                    item.setValue(amount);
                }
            }
        });
        res.add(reimbursementdetail);
        return res;
    }

    

}
