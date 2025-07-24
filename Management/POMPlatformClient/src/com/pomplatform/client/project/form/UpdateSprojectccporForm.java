package com.pomplatform.client.project.form;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.GenericWizadWindow;
import com.pomplatform.client.data.RoleDefinition;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;

public class UpdateSprojectccporForm extends GenericWizadWindow {

    @Override
    public String getActionName() {
        // 需要根据实际业务修改
        return "EP_ProjectUpdate";
    }

    @Override
    public boolean checkData(Map data) {
        return RoleDefinition.checkProjectValidaion(data);
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
        setSubaction("update");
        List<AbstractWizadPage> res = new ArrayList<>();
        res.add(new SprojectccporUpdateForm());
        return res;
    }

}
