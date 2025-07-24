package com.pomplatform.client.meeting.form;

import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.GenericWizadWindow;
import com.pomplatform.client.activitympcor.form.ActivityMeetNewForm;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.util.SC;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 新增预约界面
 */
public class NewActivityMeetsFrom  extends GenericWizadWindow {

    @Override
    public int getPageCount() {
        return 1;
    }

    @Override
    public String getActionName() {
        // 需要根据实际业务修改
        return "ST_Meeting";
    }
    @Override
    public boolean checkData(Map data) {
        boolean status = true;
        for(AbstractWizadPage wp : __pages){
            if(!wp.checkData()){
                status = false;
            }
        }
        return status;
    }

    @Override
    public List<AbstractWizadPage> getPages() {
        setCallback(new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                // 请在此编写成功保存后要做的工作
                SC.say("保存成功");
            }
        });
        List<AbstractWizadPage> res = new ArrayList<>();
        res.add(new ActivityMeetNewForm());
        return res;
    }


}
