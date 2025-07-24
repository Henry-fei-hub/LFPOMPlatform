package com.pomplatform.client.workflow.reimbursement.form;

import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.GenericWizadWindow;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NewReimbursementWithRForm extends GenericWizadWindow {

    @Override
    public String getActionName() {
        // 需要根据实际业务修改
        return "ST_ReimbursementWithR";
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
        final ReimbursementWithRGroupname1New main = new ReimbursementWithRGroupname1New();
        res.add(main);
        final ReimbursementWithRDetailReimbursementDetail detail = new ReimbursementWithRDetailReimbursementDetail();
        res.add(detail);
        detail.getDataGrid().addEditCompleteHandler(new EditCompleteHandler() {
            @Override
            public void onEditComplete(EditCompleteEvent event) {
                ListGridRecord[] data = detail.getDataGrid().getRecords();
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
        return res;
    }

}
