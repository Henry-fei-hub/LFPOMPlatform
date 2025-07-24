package com.pomplatform.client.activitympcor.panel;

import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.activitympcor.datasource.DSSactivityMpcor;
import com.pomplatform.client.company.datasource.DSCompanyReportIntegralDataSource;
import com.pomplatform.client.shift.panel.HolidayManageDateDesignPanel;
import com.pomplatform.client.shift.panel.HolidayManageOfShiftPanel;
import com.smartgwt.client.types.Side;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;

public class ActivityMeetManageDesignPanel extends AbstractWizadPage {
	private final Logger logger = Logger.getLogger("");

	public ActivityMeetManageDesignPanel() {

		HLayout mainLayout = new HLayout(10);
		mainLayout.setWidth100();
		mainLayout.setHeight100();

		TabSet topTabSet = new TabSet();
		topTabSet.setTabBarPosition(Side.TOP);

		Tab tTab1 = new Tab("日历表", "pieces/16/pawn_blue.png");
		ActivityMeetManageDateDesignPanel panel = new ActivityMeetManageDateDesignPanel();
		tTab1.setPane(panel);

		Tab tTab2 = new Tab("详情表", "pieces/16/pawn_green.png");
		SactivityMpcorPanel activityPanel = new SactivityMpcorPanel();
		 tTab2.setPane(activityPanel);

		topTabSet.addTab(tTab1);
		topTabSet.addTab(tTab2);

		mainLayout.addMember(topTabSet);
		addMember(mainLayout);

	}

	@Override
	public Map getValuesAsMap() {
		Map values = __form.getValues();
		return values;
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSSactivityMpcor.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public void startEdit() {

	}

	public String getActionName() {
		// 需要根据实际业务修改
		return "ST_Activity";
	}
}
