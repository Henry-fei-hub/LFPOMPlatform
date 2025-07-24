package com.pomplatform.client.memployeechangeplatedetail.form;

import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.GenericWizadWindow;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;

public class NewMEmployeeChangePlateDetailForm extends GenericWizadWindow {

    @Override
    public String getActionName() {
        // 需要根据实际业务修改
        return "ST_CustomEmployeeChangePlateDetail";
    }

    @Override
    public boolean checkData(Map data) {
        return true;
    }

    @Override
    public int getPageCount() {
        return 1;
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
        res.add(new MEmployeeChangePlateDetailGroupname1New());
        return res;
    }

}
