package com.pomplatform.client.sprojectadvancerecord.panel;

import java.util.HashMap;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.GenericViewWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.common.SyncDataUtil;
import com.pomplatform.client.managementteamproject.datasource.DSMManagementTeamProject;
import com.pomplatform.client.projectview.form.SprojectViewViewer;
import com.pomplatform.client.sprojectadvancerecord.datasource.DSSProjectAdvanceRecord;
import com.pomplatform.client.sprojectadvancerecord.form.SProjectAdvanceRecordViewer;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
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

public class SProjectAdvanceRecordPanel extends AbstractSearchPanel {

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			SProjectAdvanceRecordPanel cm = new SProjectAdvanceRecordPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "SProjectAdvanceRecord";
		}

	}

	@Override
	public void initComponents() {
		resultGrid.setShowRowNumbers(true);
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
				ListGridRecord[] selected = resultGrid.getSelectedRecords();
				int projectId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("projectId"));
				// 获取项目名称
//				final String projectName = KeyValueManager.getValue("projects", projectId + "");
				//更换去下拉值的fangshi
				String projectName = SyncDataUtil.getProjectName(projectId);
//				Record projectNameRecord = getProjectName(projectId);
//				String projectName = BaseHelpUtils.getString(projectNameRecord.getAttribute("projectName"));
				final DelicacyListGrid projectViewGrid = new DelicacyListGrid();
				projectViewGrid.setDataSource(DSMManagementTeamProject.getInstance());
				Map condition = new java.util.HashMap();
				condition.put("projectId", projectId);
				DBDataSource.callOperation("NQ_MManagementTeamProject", "find", condition, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() >= 0) {
							projectViewGrid.setData(dsResponse.getData());
							projectViewGrid.selectRecord(0);
							GenericViewWindow detail = new GenericViewWindow();
							detail.setTitle("项目(" + projectName + ")的相关信息");
							detail.setWidth100();
							detail.setHeight100();
							SprojectViewViewer detailForm = new SprojectViewViewer();
							detailForm.setParentSearchForm(searchForm);
							detailForm.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_TAB);
							detailForm.initComponents();
							detailForm.viewSelectedData(projectViewGrid);
							detail.setContent(detailForm);
							detail.centerInPage();
							detail.show();
						}
					}
				});
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
					if ("汇总".equals(recordList[length - 1].getAttribute("plateId"))) {// 如果已经存在汇总，则不可再进行汇总
						return;
					}
					double advanceIntegral = 0;
					double leftIntegral = 0;
					Record[] records = new Record[length + 1];
					for (int i = 0; i < length; i++) {
						records[i] = recordList[i];
						advanceIntegral += ClientUtil
								.checkAndGetDoubleValue(recordList[i].getAttribute("advanceIntegral"));
						leftIntegral += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("leftIntegral"));
					}
					Record record = new Record();
					record.setAttribute("plateId", "汇总");
					record.setAttribute("advanceIntegral", advanceIntegral);
					record.setAttribute("leftIntegral", leftIntegral);
					records[length] = record;
					resultGrid.setData(records);
					resultGrid.redraw();
					resultGrid.setCanEdit(false);
				}
			}
		});

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
				detail.setTitle("部门每月项目补贴明细");
				detail.setWidth100();
				detail.setHeight100();
				SProjectAdvanceRecordViewer detailForm = new SProjectAdvanceRecordViewer();
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

	/**
	 * 获取项目的名称
	 * @param projectId
	 * @return
	 */
	private Record getProjectName(Integer projectId){
		Record record = new Record();
		HashMap<Object, Object> map = new HashMap<>();
		map.put("projectId",projectId);
		DBDataSource.callOperation("ST_Project", "find", map, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					Record[] records = dsResponse.getData();
					if(!BaseHelpUtils.isNullOrEmpty(records) && records.length > 0){
						//获取项目名称
						String projectName = BaseHelpUtils.getString(records[0].getAttribute("projectName"));
						record.setAttribute("projectName",projectName);
					}
				}
			}
		});
		return record;
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		if (null != plateId) {
			criteria.put("plateId", plateId);
		}
		if (null != year && null != month) {
			criteria.put("advanceYear", year);
			criteria.put("advanceMonth", month);
		}
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		// return new SProjectAdvanceRecordSearchForm();
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSSProjectAdvanceRecord.getInstance();
	}

	private Integer plateId;
	private Integer year;
	private Integer month;

	public Integer getPlateId() {
		return plateId;
	}

	public void setPlateId(Integer plateId) {
		this.plateId = plateId;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}
}
