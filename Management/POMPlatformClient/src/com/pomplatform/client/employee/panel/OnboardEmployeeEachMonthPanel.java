package com.pomplatform.client.employee.panel;

import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.PopupWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.pomplatform.client.employee.datasource.DSOnboardEmployeeEachMonth;
import com.pomplatform.client.employee.form.OnboardEmployeeEachMonthSearchForm;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.Map;
import java.util.logging.Logger;

public class OnboardEmployeeEachMonthPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			OnboardEmployeeEachMonthPanel cm = new OnboardEmployeeEachMonthPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OnboardEmployeeEachMonth";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid.setAutoFitFieldWidths(false);
		resultGrid.setShowGridSummary(true);
	}

	@Override
	public void initComponents() {
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});

		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				showDetail();
			}
		});
		IButton viewButton = new IButton("查看详细");
		viewButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		controlLayout.addMember(viewButton);
		commonQuery();
	}

	public void showDetail() {
		GWT.runAsync(new RunAsyncCallback() {
			@Override
			public void onFailure(Throwable reason) {
				SC.say("failure to download code");
			}
			@Override
			public void onSuccess() {
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				Record record = resultGrid.getSelectedRecord();
				PopupWindow window = new PopupWindow(record.getAttribute("year") + "年" + record.getAttribute("month") + "月" + KeyValueManager.getValue("departments", record.getAttribute("departmentId")) + "入职员工明细表");
				window.setWidth100();
				window.setHeight100();
				OnboardEmployeeEachMonthDetailPanel panel = new OnboardEmployeeEachMonthDetailPanel();
				panel.setPlateId(record.getAttribute("plateId"));
				panel.setDepartmentId(record.getAttribute("departmentId"));
				panel.setYear(BaseHelpUtils.getIntValue(record.getAttribute("year")));
				panel.setMonth(BaseHelpUtils.getIntValue(record.getAttribute("month")));
				panel.commonQuery();
				window.addMember(panel);
				window.centerInPage();
				window.show();
			}
		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("plateId", plateId);
		criteria.put("year", year);
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new OnboardEmployeeEachMonthSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSOnboardEmployeeEachMonth.getInstance();
	}

	@Override
	public int getSearchFormHeight() {
		return 60;
	}
	
	private String plateId;
	private int year;
	
	public String getPlateId() {
		return plateId;
	}

	public void setPlateId(String plateId) {
		this.plateId = plateId;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}

