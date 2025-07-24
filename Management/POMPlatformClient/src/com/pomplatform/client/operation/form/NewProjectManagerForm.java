package com.pomplatform.client.operation.form;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
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

public class NewProjectManagerForm extends GenericWizadWindowForSaveProject {

	@Override
	public String getActionName() {
		// 需要根据实际业务修改
		return "EP_ProjectNewCreate";
	}

	@Override
    public boolean checkData(Map data) {
		if (ClientUtil.isNullOrEmpty(data.get("contractCode"))) {
			SC.say("订单编号必须输入");
			return false;
		}
		if (ClientUtil.isNullOrZero(data.get("commonArea")) || BaseHelpUtils.getIntValue(data.get("commonArea")) <= 0) {
			SC.say("公共面积必须大于 0");
			return false;
		}
        return RoleDefinition.checkProjectValidaion(data);
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
		res.add(new ProjectManagerProjectbasicNew());
		res.add(new ProjectManagerOtherinfoNew());
		return res;
	}

}
