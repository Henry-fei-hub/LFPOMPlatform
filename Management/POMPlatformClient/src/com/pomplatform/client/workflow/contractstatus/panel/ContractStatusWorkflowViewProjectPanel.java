package com.pomplatform.client.workflow.contractstatus.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.GenericViewWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.common.SyncDataUtil;
import com.pomplatform.client.managementteamproject.datasource.DSMManagementTeamProject;
import com.pomplatform.client.projectreportrecorddetail.datasource.DSProjectReportRecordDetail;
import com.pomplatform.client.projectreportrecorddetail.form.ProjectReportRecordDetailViewer;
import com.pomplatform.client.projectview.form.SprojectViewViewer;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class ContractStatusWorkflowViewProjectPanel extends AbstractSearchPanel {

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			ContractStatusWorkflowViewProjectPanel cm = new ContractStatusWorkflowViewProjectPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ProjectReportRecordDetail";
		}

	}

	@Override
	public void init() {
		super.init();
		resultGrid = new DelicacyListGrid(){
			@Override
			protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
				//获取项目状态，如果项目暂停，则该行的字体颜色为红色，如果项目已结束，则该行的字体颜色为绿色
				int status = ClientUtil.checkAndGetIntValue(record.getAttribute("status"));
				if (status == ClientStaticUtils.PROJECT_STATUS_11) {  //项目已结束,标绿色
					return "color:#00B736;";  
				} else if (status == ClientStaticUtils.PROJECT_STATUS_10) {  //项目暂停,标红色
					return "color:#F01813;";  
				}else if(status == ClientStaticUtils.PROJECT_STATUS_5) {
					return "color:#DAA520;"; //项目无进度变为橘黄色
				}
				
				else {  
					return super.getCellCSSText(record, rowNum, colNum);  
				}  
			}
		};
		resultGrid.setDataSource(getDataSource());
		resultGrid.setShowRowNumbers(true);
		
		__needControl = false;
		__needPagenation = false;
	}

	@Override
	public void initComponents() {

		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				ListGridRecord[] selected = resultGrid.getSelectedRecords();
				int projectId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("projectId"));
				// 获取项目名称
//				final String projectName = KeyValueManager.getValue("projects", projectId + "");
				//修改下拉值的获取方式
				String projectName = SyncDataUtil.getProjectName(projectId);
//				Record record = getProjectName(projectId);
//				String projectName = BaseHelpUtils.getString(record.getAttribute("projectName"));
				final DelicacyListGrid projectViewGrid = new DelicacyListGrid();
				projectViewGrid.setDataSource(DSMManagementTeamProject.getInstance());
				Map condition = new java.util.HashMap();
				condition.put("projectId", projectId);
				List<Map> keyvalues = new ArrayList<>();
				Map<String, String> kv = new HashMap<>();
				kv.put("key", "p.department_id in (select child_id from department_ids where department_id = ? )");
				kv.put("value", "1 = 1");
				keyvalues.add(kv);
				condition.put("keyValues", keyvalues);
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
				detail.setTitle("项目积分汇总");
				detail.setWidth100();
				detail.setHeight100();
				ProjectReportRecordDetailViewer detailForm = new ProjectReportRecordDetailViewer();
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
		criteria.put("contractId", contractId);
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSProjectReportRecordDetail.getInstance();
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
	
	private Integer contractId;

	public Integer getContractId() {
		return contractId;
	}

	public void setContractId(Integer contractId) {
		this.contractId = contractId;
	}
	
}
