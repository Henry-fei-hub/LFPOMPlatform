package com.pomplatform.client.cwd.form;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.GenericWizadWindow;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.util.SC;

public class NewSoftwareUpdateVersionWithSForm extends GenericWizadWindow {

	@Override
	public String getActionName() {
		// 需要根据实际业务修改
		return "ST_SoftwareUpdateVersionWithS";
	}

	@Override
	public boolean checkData(Map data) {
		boolean flag = true;
		for (AbstractWizadPage abstractWizadPage : __pages) {
			flag = abstractWizadPage.checkData();
			if(!flag) {
				SC.say("请补充好需要填写的数据");
				break;
			}
		}
		return flag;
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
		res.add(new SoftwareUpdateVersionWithSNewForm());
		res.add(new SoftwareUpdateVersionWithSDetailSoftwareUpdateFile());
		return res;
	}

}
