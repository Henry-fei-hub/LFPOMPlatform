package com.pomplatform.client.projectteambuild.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.GenericWizadWindow;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;

public class UpdateSprojectteambuildForm extends GenericWizadWindow {

	private static Logger __logger = Logger.getLogger("");

	@Override
	public String getActionName() {
		// 需要根据实际业务修改
		return "ST_ProjectEmployee";
	}

	@Override
	public void initComponents() {
		super.initComponents();
		saveButton.hide();
		cancelButton.hide();
		
	}
	
	@Override
	public boolean checkData(Map data) {
		return false;
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
//		saveButton.hide();
		setSubaction("find");
		List<AbstractWizadPage> res = new ArrayList<>();
//        res.add(new SprojectteambuildUpdateForm());
		SprojectteambuildDetailProjectEmployee projectemployee = new SprojectteambuildDetailProjectEmployee();
		projectemployee.setPageMode(AbstractWizadPage.PAGE_MODE_UPDATE);
		res.add(projectemployee);
		return res;
	}

}
