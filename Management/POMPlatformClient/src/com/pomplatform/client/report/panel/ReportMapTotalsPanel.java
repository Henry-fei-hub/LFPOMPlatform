package com.pomplatform.client.report.panel;

import java.util.*;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.ui.*;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.ClientUtil;
import com.smartgwt.client.widgets.grid.events.SelectionChangedHandler;
import com.smartgwt.client.widgets.grid.events.SelectionEvent;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.grid.events.SelectionUpdatedEvent;
import com.smartgwt.client.widgets.grid.events.SelectionUpdatedHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.delicacy.client.PanelFactory;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.report.datasource.DSReportMapTotals;
import com.pomplatform.client.report.form.ReportMapTotalsSearchForm;
import com.pomplatform.client.report.form.ReportMapTotalsViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;

import java.util.logging.Logger;

public class ReportMapTotalsPanel extends AbstractSearchPanel
{
	private String plateIds;
	private String[] plateIdArr;


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ReportMapTotalsPanel cm = new ReportMapTotalsPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ReportMapTotals";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid.setAutoFitFieldWidths(false);
	}

	@Override
	public void initComponents() {
		plateIds = PomPlatformClientUtil.getRolePlateId();
		plateIdArr = plateIds.split(",");
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.setIcon("[SKIN]/actions/refresh.png");
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
		IButton operation1Button = new IButton("查看详情");
		controlLayout.addMember(operation1Button);
		operation1Button.setIcon("[SKIN]/actions/view.png");
		operation1Button.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		IButton downLoadButton = new IButton("导出");
		controlLayout.addMember(downLoadButton);
		downLoadButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Map condition = generateCriteria();
				ClientUtil.departmentParameterProcess(condition);
				DBDataSource.downloadFile("DW_ReportMapTotals", condition);
			}
		});
//		IButton removeButton = new IButton("删除");
//		controlLayout.addMember(removeButton);
//		removeButton.setIcon("[SKIN]/actions/remove.png");
//		removeButton.addClickHandler(new ClickHandler() {
//			@Override
//			public void onClick(ClickEvent event) {
//				if (!resultGrid.anySelected()) {
//					SC.say("Please select a data to remove.");
//				}
//				final ListGridRecord selected = resultGrid.getSelectedRecord();
//				DBDataSource.callOperation("ST_ReportMapTotals", "delete", selected.toMap(), new DSCallback() {
//					@Override
//					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//						if (dsResponse.getStatus() < 0) {
//							ClientUtil.displayErrorMessage(dsResponse);
//						} else {
//							int indexNum = resultGrid.getRowNum(selected);
//							resultGrid.removeData(selected);
//							resultGrid.selectSingleRecord(indexNum);
//						}
//					}
//				});
//			}
//		});

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
				SC.debugger();
				ListGridRecord selected = resultGrid.getSelectedRecord();
				ViewProcessWindow Reimbursement = new ViewProcessWindow();
				Reimbursement.setLayoutMode(0);
				Reimbursement.setInstanceData(selected);
				Reimbursement.initComponents();
				Reimbursement.setWidth("80%");
				Reimbursement.setHeight("80%");
				Reimbursement.setTitle(ClientUtil.getProcessTypeName(selected));
				Reimbursement.show();
				Reimbursement.centerInPage();

			/*	GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("出图统计表");
				detail.setWidth100();
				detail.setHeight100();
				ReportMapTotalsViewer detailForm = new ReportMapTotalsViewer();
				detailForm.setParentSearchForm(searchForm);
				detailForm.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_TAB);
				detailForm.initComponents();
				detailForm.viewSelectedData(resultGrid);
				detail.setContent(detailForm);
				detail.centerInPage();
				detail.show();*/
			}
		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		SC.debugger();
		int projectManagerId = ClientUtil.getEmployeeId();
		if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.REPORT_MAP_QUERY_ALL)) {
				//如果有查看所有数据权限
			return true;
		}
		else if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.REPORT_MAP_QUERY_DEPARTNENT)) {
				//如果有查看管理部门
				//获取自己管理部门的部门id数据集
				String plateIds = PomPlatformClientUtil.getRolePlateId();
				if(!BaseHelpUtils.isNullOrEmpty(plateIds)) {
					List<Map> keyvalues = new ArrayList<>();
					Map<String, String> kv = new HashMap<>();
					kv.put("key", "ORDER BY pb.start_date desc");
					kv.put("value", "and (d.plate_id in("+plateIds+") or pb.employee_id ="+projectManagerId+ ") ORDER BY pb.start_date desc ");
					keyvalues.add(kv);
					criteria.put("keyValues", keyvalues);
				}else {
					criteria.put("employeeId", projectManagerId);
				}
		}
		else {
				//否则只能查看个人管理数据权限
				criteria.put("employeeId", projectManagerId);
			}
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new ReportMapTotalsSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSReportMapTotals.getInstance();
	}


}

