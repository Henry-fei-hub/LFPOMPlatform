package com.pomplatform.client.preprojects.panel;

import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.GenericWizadWindow;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.util.SC;

public class NewPreProjectInformationForm extends GenericWizadWindow {

	@Override
	public String getActionName() {
		// 需要根据实际业务修改
		return "EP_PreProjectProcess";
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
				SC.say("保存成功");
			}
		});
		List<AbstractWizadPage> res = new ArrayList<>();
		res.add(new PreProjectBasicInformationNew());
		res.add(new PreProjectDetailInformationNew());
		return res;
	}

}
