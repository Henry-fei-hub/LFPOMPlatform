package com.pomplatform.client.meeting.panel;

import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.activitympcor.form.GenericDetailsWindow;
import com.pomplatform.client.meeting.form.MeetingRoomInfoForm;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MeetingRoomInfoPanel  extends GenericDetailsWindow {

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
    public List<AbstractWizadPage> getPages() {
        setCallback(new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                // 请在此编写成功保存后要做的工作
            }
        });
        List<AbstractWizadPage> res = new ArrayList<>();
        res.add(new MeetingRoomInfoForm());
        return res;

    }

    @Override
    public boolean checkData(Map data) {
        return true;
    }
}
