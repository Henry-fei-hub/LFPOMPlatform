package com.pomplatform.client.project.form;

import com.delicacy.client.MapUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.GenericWizadWindow;
import com.pomplatform.client.data.RoleDefinition;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.util.SC;
import java.util.LinkedHashMap;

public class NewSprojectccporForm extends GenericWizadWindow {

    @Override
    public String getActionName() {
        // 需要根据实际业务修改
        return "EP_ProjectNewCreate";
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
                if (dsResponse.getStatus() >= 0) {//保存成功
                    // 保存成功后，向项目成员表中默认添加项目经理的数据
                    String employeeId = dsResponse.getData()[0].getAttribute("projectManageId");
                    //获取项目id
                    String projectId = dsResponse.getData()[0].getAttribute("projectId");
                    Map param = new LinkedHashMap();
                    param.put("employeeId", employeeId);
                    param.put("projectId", projectId);
                    String message = MapUtils.toJSON(param);
                    DBDataSource.callOperation("EP_SetProjectEmployee", "set", message, new DSCallback() {
                        @Override
                        public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                            if (dsResponse.getStatus() >= 0) {
                            } else {
                                Map errors = dsResponse.getErrors();
                                SC.say("操作失败" + errors);
                            }
                        }
                    });
                }
            }
        });
        List<AbstractWizadPage> res = new ArrayList<>();
        res.add(new SprojectccporNewForm());
        return res;
    }

}
