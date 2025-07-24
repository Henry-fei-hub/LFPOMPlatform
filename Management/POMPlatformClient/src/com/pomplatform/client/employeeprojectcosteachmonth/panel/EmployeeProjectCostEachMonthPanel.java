package com.pomplatform.client.employeeprojectcosteachmonth.panel;

import java.util.Date;
import java.util.Map;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.employeedetail.panel.ProjectCostDetailPanel;
import com.pomplatform.client.employeeprojectcosteachmonth.datasource.DSEmployeeProjectCostEachMonth;
import com.pomplatform.client.employeeprojectcosteachmonth.form.EmployeeProjectCostEachMonthViewer;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class EmployeeProjectCostEachMonthPanel extends AbstractSearchPanel {

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			EmployeeProjectCostEachMonthPanel cm = new EmployeeProjectCostEachMonthPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "EmployeeProjectCostEachMonth";
		}

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
				if (resultGrid.anySelected()) {
					Record record = resultGrid.getSelectedRecords()[0];
					int year = ClientUtil.checkAndGetIntValue(record.getAttribute("year"));
					int month = ClientUtil.checkAndGetIntValue(record.getAttribute("month"));
					ProjectCostDetailPanel projectCost = new ProjectCostDetailPanel();
					projectCost.setEmployeeId(employeeId);
					projectCost.setYear(year);
					projectCost.setMonth(month);
					projectCost.commonQuery();
					PopupWindow window = new PopupWindow();
					window.setTitle(KeyValueManager.getValue("employees", record.getAttribute("employeeId")) + year
							+ "年" + month + "月项目成本明细");
					window.addMember(projectCost);
					window.setWidth100();
					window.setHeight100();
					window.centerInPage();
					window.show();
				}
			}
		});

		IButton totalButton = new IButton("汇总");
		controlLayout.addMember(totalButton);
		totalButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				ListGridRecord[] recordList = resultGrid.getRecords();
				int len = recordList.length;
				Record[] records = new Record[len + 1];
				if (len > 0) {
					double projectCost = 0;
					for (int i = 0; i < len; i++) {
						if ("汇总".equals(recordList[i].getAttribute("employeeId"))) {// 如果已经存在汇总，则不可再进行汇总
							return;
						}
						projectCost += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("projectCost"));
						records[i] = recordList[i];
					}
					Record record = new Record();
					record.setAttribute("employeeId", "汇总");
					record.setAttribute("projectCost", projectCost);
					records[len] = record;
					resultGrid.setData(records);
					resultGrid.redraw();
					resultGrid.setCanEdit(false);
				}

			}
		});

		resultGrid.setShowRowNumbers(true);
	}

	public void showDetail() {
		GWT.runAsync(new RunAsyncCallback() {
			@Override
			public void onFailure(Throwable reason) {
				SC.say("failure to download code");
			}

			@Override
			public void onSuccess() {
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("职员每月项目成本汇总");
				detail.setWidth100();
				detail.setHeight100();
				EmployeeProjectCostEachMonthViewer detailForm = new EmployeeProjectCostEachMonthViewer();
				detailForm.setParentSearchForm(searchForm);
				detailForm.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_TAB);
				detailForm.initComponents();
				detailForm.viewSelectedData(resultGrid);
				detail.setContent(detailForm);
				detail.centerInPage();
				detail.show();
			}
		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("employeeId", employeeId);
		criteria.put("startDate", startDate);
		criteria.put("endDate", endDate);
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		// return new EmployeeProjectCostEachMonthSearchForm();
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSEmployeeProjectCostEachMonth.getInstance();
	}

	@Override
	public void init() {
		super.init();
		__needViewPage = false;
	}
	
	private int employeeId;
	private Date startDate;
	private Date endDate;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
