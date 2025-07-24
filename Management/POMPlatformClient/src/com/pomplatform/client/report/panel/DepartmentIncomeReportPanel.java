package com.pomplatform.client.report.panel;

import java.util.*;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.ui.*;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.contract.datasource.DSContractDistributionChild;
import com.pomplatform.client.report.datasource.DSDepartmentIncomeDetailReport;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.ClientUtil;
import com.smartgwt.client.widgets.grid.ListGrid;
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
import com.pomplatform.client.report.datasource.DSDepartmentIncomeReport;
import com.pomplatform.client.report.form.DepartmentIncomeReportSearchForm;
import com.pomplatform.client.report.form.DepartmentIncomeReportViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;

import java.util.logging.Logger;

public class DepartmentIncomeReportPanel extends AbstractExpansionRelatedPage
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			DepartmentIncomeReportPanel cm = new DepartmentIncomeReportPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "DepartmentIncomeReport";
		}

	}

	@Override
	public void initComponents() {
		resultGrid.setAutoFitFieldWidths(false);
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
		IButton viewButton = new IButton("查看详细");
		viewButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		controlLayout.addMember(viewButton);
		commonQuery();

		//导出所有部门的数据
		IButton exportButton = new IButton("导出明细");
		exportButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent clickEvent) {
				Map condition = generateCriteria();
				DBDataSource.downloadFile("DW_DepartmentIncomeDetailReport", condition);
			}
		});
		controlLayout.addMember(exportButton);

		//导出部门汇总数据
		IButton exportTotalButton = new IButton("导出汇总");
		exportTotalButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent clickEvent) {
				Map condition = generateCriteria();
				DBDataSource.downloadFile("DW_DepartmentIncomeReport", condition);
			}
		});
		controlLayout.addMember(exportTotalButton);
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
				detail.setTitle("DepartmentIncomeReport"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				DepartmentIncomeReportViewer detailForm = new DepartmentIncomeReportViewer();
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
		int plateId = BaseHelpUtils.getIntValue(criteria.get("plateId"));
		if (plateId == 0) {
			if(!ClientUtil.checkIsHavePermission(ERPPermissionStatic.DEPARTMENT_INCOME_REPORT_ALL)) {
				String plateIds = PomPlatformClientUtil.getRolePlateId();
				if(BaseHelpUtils.isNullOrEmpty(plateIds)){
					criteria.put("plateId", -1);
				}else{
					List<Map> keyvalues = new ArrayList<>();
					Map<String, String> kv = new HashMap<>();
					kv.put("key", "and plate_id =?");
					kv.put("value", "and plate_id =? and plate_id in("+plateIds+")");
					keyvalues.add(kv);
					criteria.put("keyValues", keyvalues);
				}
			}
		}
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new DepartmentIncomeReportSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSDepartmentIncomeReport.getInstance();
	}

	@Override
	public DataSource getChildDataSource() {
		return DSDepartmentIncomeDetailReport.getInstance();
	}

	@Override
	public void setParentGridOption(ListGrid resultGrid) {
		resultGrid.setAutoFitFieldWidths(false);
	}

	@Override
	public void setChildGridOption(ListGrid resultChildGrid) {
		resultChildGrid.setAutoFitFieldWidths(false);
	}

	@Override
	public boolean doCustomCommonQuery() {
		return true;
	}

	@Override
	public void customCommonQuery(ListGridRecord record,ListGrid childGrid) {
		SC.debugger();
		Record record1 = record;
		int plateId = BaseHelpUtils.getIntValue(record.getAttribute("plateId"));
		Map param = generateCriteria();
		param.put("plateId", plateId);
		final LoadingWindow loading = new LoadingWindow();
		DBDataSource.callOperation("NQ_DepartmentIncomeDetailReport", "find", param, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
				loading.destroy();
				if (dsResponse.getStatus() >= 0) {
					Record[] data = dsResponse.getData();
					resultChildGrid.setData(data);
				}
			}
		});

	}

}

