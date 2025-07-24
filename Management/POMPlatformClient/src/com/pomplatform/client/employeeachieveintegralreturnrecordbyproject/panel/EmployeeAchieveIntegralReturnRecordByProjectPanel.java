package com.pomplatform.client.employeeachieveintegralreturnrecordbyproject.panel;

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
import com.pomplatform.client.employeeachieveintegralreturnrecordbyproject.datasource.DSEmployeeAchieveIntegralReturnRecordByProject;
import com.pomplatform.client.employeeachieveintegralreturnrecordbyproject.form.EmployeeAchieveIntegralReturnRecordByProjectSearchForm;
import com.pomplatform.client.employeeachieveintegralreturnrecordbyproject.form.EmployeeAchieveIntegralReturnRecordByProjectViewer;
import com.pomplatform.client.managementteamproject.datasource.DSMManagementTeamProject;
import com.pomplatform.client.projectview.form.SprojectViewViewer;
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

public class EmployeeAchieveIntegralReturnRecordByProjectPanel extends AbstractSearchPanel
{


	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			EmployeeAchieveIntegralReturnRecordByProjectPanel cm = new EmployeeAchieveIntegralReturnRecordByProjectPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "EmployeeAchieveIntegralReturnRecordByProject";
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
				String projectName = SyncDataUtil.getProjectName(projectId);
//				Record record = getProjectName(projectId);
//				final String projectName = BaseHelpUtils.getString(record.getAttribute("projectName"));
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
				int len = recordList.length;
				Record[] records = new Record[len + 1];
				if (len > 0) {
					double achieveIntegral = 0;
					for (int i = 0; i < len; i++) {
						if ("汇总".equals(recordList[i].getAttribute("plateId"))) {// 如果已经存在汇总，则不可再进行汇总
							return;
						}
						achieveIntegral += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("achieveIntegral"));
						records[i] = recordList[i];
					}
					Record record = new Record();
					record.setAttribute("plateId", "汇总");
					record.setAttribute("achieveIntegral", achieveIntegral);
					records[len] = record;
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
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("Semployeeachieveintegralreturnrecordprror"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				EmployeeAchieveIntegralReturnRecordByProjectViewer detailForm = new EmployeeAchieveIntegralReturnRecordByProjectViewer();
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
		criteria.put("plateId", plateId);
		criteria.put("recordYear", recordYear);
		criteria.put("recordMonth", recordMonth);
		criteria.put("employeeId", employeeId);
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
//		return new EmployeeAchieveIntegralReturnRecordByProjectSearchForm();
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSEmployeeAchieveIntegralReturnRecordByProject.getInstance();
	}
	
	private Integer plateId;
	private Integer recordYear;
	private Integer recordMonth;
	private Integer employeeId;
	
	public Integer getPlateId() {
		return plateId;
	}

	public void setPlateId(Integer plateId) {
		this.plateId = plateId;
	}

	public Integer getRecordYear() {
		return recordYear;
	}

	public void setRecordYear(Integer recordYear) {
		this.recordYear = recordYear;
	}

	public Integer getRecordMonth() {
		return recordMonth;
	}

	public void setRecordMonth(Integer recordMonth) {
		this.recordMonth = recordMonth;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
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

}

