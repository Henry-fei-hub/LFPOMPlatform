package com.pomplatform.client.operation.form;

import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.GenericWizadWindow;
import com.pomplatform.client.data.RoleDefinition;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;

public class UpdateProjectManagerForm123 extends GenericWizadWindow {

	@Override
	public String getActionName() {
		// 需要根据实际业务修改
		return "EP_ProjectUpdate123";
	}

	@Override
    public boolean checkData(Map data) {
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
		setSubaction("update");
		List<AbstractWizadPage> res = new ArrayList<>();
		res.add(new ProjectManagerProjectbasicUpdate123());
		res.add(new ProjectManagerOtherinfoUpdate123());
		return res;
	}

}
