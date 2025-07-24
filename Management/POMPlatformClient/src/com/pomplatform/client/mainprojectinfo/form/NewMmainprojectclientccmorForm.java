package com.pomplatform.client.mainprojectinfo.form;

import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.GenericWizadWindow;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;

public class NewMmainprojectclientccmorForm extends GenericWizadWindow {
    
    private int mainProjectId;
    
    public void setMainProjectId(int mainProjectId){
        this.mainProjectId = mainProjectId;
    }

    @Override
    public String getActionName() {
        // 需要根据实际业务修改
        return "ST_SaveClientAndMainProjectClient";
    }

    @Override
    public boolean checkData(Map data) {
        data.put("mainProjectId", mainProjectId);
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
        res.add(new MmainprojectclientccmorGroupname1New());
        return res;
    }

}
