package com.pomplatform.client.projectemployeeadvanceeachpersondetail.panel;

import java.util.Map;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.GenericViewWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.projectemployeeadvanceeachpersondetail.datasource.DSProjectEmployeeAdvanceEachPersonDetail;
import com.pomplatform.client.projectemployeeadvanceeachpersondetail.form.ProjectEmployeeAdvanceEachPersonDetailViewer;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class ProjectEmployeeAdvanceEachPersonDetailPanel extends AbstractSearchPanel {

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			ProjectEmployeeAdvanceEachPersonDetailPanel cm = new ProjectEmployeeAdvanceEachPersonDetailPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ProjectEmployeeAdvanceEachPersonDetail";
		}

	}

	@Override
	public void initComponents() {
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.setIcon("[SKIN]/actions/refresh.png");
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});

		IButton totalButton = new IButton("汇总");
		controlLayout.addMember(totalButton);
		totalButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				ListGridRecord[] recordList = resultGrid.getRecords();
				if (null != recordList && recordList.length > 0) {
					int length = recordList.length;
					if ("汇总".equals(recordList[length - 1].getAttribute("projectId"))) {// 如果已经存在汇总，则不可再进行汇总
						return;
					}
					double advanceIntegral = 0;// 项目总积分
					Record[] records = new Record[length + 1];
					for (int i = 0; i < length; i++) {
						records[i] = recordList[i];
						advanceIntegral += ClientUtil
								.checkAndGetDoubleValue(recordList[i].getAttribute("advanceIntegral"));
					}
					Record record = new Record();
					record.setAttribute("projectId", "汇总");
					record.setAttribute("advanceIntegral", advanceIntegral);
					records[length] = record;
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
				detail.setTitle("员工项目补贴明细");
				detail.setWidth100();
				detail.setHeight100();
				ProjectEmployeeAdvanceEachPersonDetailViewer detailForm = new ProjectEmployeeAdvanceEachPersonDetailViewer();
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
		criteria.put("projectId", projectId);
		criteria.put("employeeId", employeeId);
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		// return new ProjectEmployeeAdvanceEachPersonDetailSearchForm();
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSProjectEmployeeAdvanceEachPersonDetail.getInstance();
	}

	@Override
	public Canvas getViewPanel() {
		searchForm = generateSearchForm();
		VLayout layout = new VLayout();
		layout.setWidth100();
		layout.setHeight100();
		layout.setBackgroundColor("#e2e2e2");

		if (searchForm != null) {
			ClientUtil.searchFormProcessAccordingToDevice(searchForm);
			if (getSearchFormHeight() > 0) {
				searchForm.setHeight(getSearchFormHeight());
			}
			HLayout searchLayout = new HLayout(5);
			searchLayout.setMargin(10);
			layout.addMember(searchLayout);

			searchForm.setWidth100();
			searchLayout.addMember(searchForm);

			VLayout buttonLayout = new VLayout(5);
			searchButton = new IButton("搜索");
			searchButton.setIcon("[SKIN]/actions/search.png");

			IButton resetButton = new IButton("重置");
			resetButton.setIcon("[SKIN]/actions/redo.png");

			buttonLayout.addMember(searchButton);
			buttonLayout.addMember(resetButton);

			searchLayout.addMember(buttonLayout);

			searchButton.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					currentPage = 1;
					commonQuery();
				}
			});

			resetButton.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					searchForm.editNewRecord();
				}
			});
		}
		VLayout resultLayout = new VLayout();
		resultLayout.setWidth100();
		resultLayout.setHeight100();

		HLayout dataLayout = new HLayout();
		dataLayout.setHeight100();
		dataLayout.setWidth100();
		resultLayout.addMember(dataLayout);

		resultGrid = new DelicacyListGrid();
		resultGrid.setDataSource(getDataSource());

		dataLayout.addMember(resultGrid);
		if (showControlPanel()) {
			controlLayout = new VLayout();
			controlLayout.setHeight100();
			controlLayout.setLayoutTopMargin(30);
			controlLayout.setLayoutLeftMargin(5);
			controlLayout.setLayoutRightMargin(5);
			controlLayout.setMembersMargin(10);

			dataLayout.addMember(controlLayout);
		}

		layout.addMember(resultLayout);

		//initComponents();
		if (showControlPanel()) {
			setControlLayoutWidth();
		}
		return layout;
	}

	private Integer employeeId;
	private Integer projectId;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

}
