package com.pomplatform.client.panel;


import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.ui.*;
import com.pomplatform.client.datasource.DSSettlementApplicationProject;
import com.pomplatform.client.workflow.personnelbusiness.form.SettlementApplyNewForm;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.*;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.ClientUtil;

import com.delicacy.client.PanelFactory;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.layout.VLayout;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class SettlementApplicationProjectPanel extends AbstractWizadPage {


	private static final Logger __LOGGER = Logger.getLogger("");

	private static final DelicacyListGrid grid = new DelicacyListGrid();

	private SettlementApplyNewForm settlementApplyNewForm;



	public SettlementApplyNewForm getSettlementApplyNewForm() {
		return settlementApplyNewForm;
	}

	public void setSettlementApplyNewForm(SettlementApplyNewForm settlementApplyNewForm) {
		this.settlementApplyNewForm = settlementApplyNewForm;
	}

	private VLayout mainLayout;
	private Map map;


	@Override

	public Map getValuesAsMap() {
		return map;
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public void startEdit() {
		Map condition = new HashMap();
		condition.put("type", ClientUtil.getDepartmentId());
		DBDataSource.callOperation("NQ_SettlementApplicationProject", "find", condition, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					SC.debugger();
					Record[] records = dsResponse.getData();
				grid.setData(records);
				}
			}
		});
	}
	public SettlementApplicationProjectPanel() {
		mainLayout = new VLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		mainLayout.setBackgroundColor("#f2f2f2");
		mainLayout.setLayoutLeftMargin(30);
		mainLayout.setLayoutRightMargin(30);
		mainLayout.setLayoutTopMargin(15);
		addMember(mainLayout);
		mainLayout.addMember(grid);
		grid.setDataSource(DSSettlementApplicationProject.getInstance());

		grid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent doubleClickEvent) {
				if (!grid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				Record selected = grid.getSelectedRecords()[0];
				map = new HashMap();

				int projectId = BaseHelpUtils.getIntValue(selected.getAttribute("projectId"));
				String projectCode = BaseHelpUtils.getString(selected.getAttribute("projectCode"));
				String projectName = BaseHelpUtils.getString(selected.getAttribute("projectName"));
				map.put("projectId",projectId);
				map.put("projectCode",projectCode);
				map.put("projectName",projectName);
				settlementApplyNewForm.projectIdValue(projectId,projectCode,projectName);

			}
		});

	}

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			SettlementApplicationProjectPanel cm = new SettlementApplicationProjectPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "SettlementApplicationProject";
		}

	}


}

