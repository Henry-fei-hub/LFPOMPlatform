package com.pomplatform.client.report.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.report.datasource.DSReportOfSumRevenueYearRecords;
import com.pomplatform.client.report.form.ReportOfSumRevenueYearRecordsSearchForm;
import com.pomplatform.client.report.form.ReportOfSumRevenueYearRecordsViewer;
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

public class ReportOfSumRevenueYearRecordsPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ReportOfSumRevenueYearRecordsPanel cm = new ReportOfSumRevenueYearRecordsPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ReportOfSumRevenueYearRecords";
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
				Record record = resultGrid.getSelectedRecord();
				if(!BaseHelpUtils.isNullOrEmpty(record.getAttribute("plateId"))){
					int plateId = BaseHelpUtils.getIntValue(record.getAttribute("plateId"));
					int year = BaseHelpUtils.getIntValue(record.getAttribute("year"));
					ReportOfSumRevenueYearRecordDetailPanel panel = new ReportOfSumRevenueYearRecordDetailPanel();
					PopupWindow window = new PopupWindow();
					panel.setPlateId(plateId);
					panel.setYear(year);
					panel.startEdit();
					window.addItem(panel);
					window.setTitle("营收统计详情表");
					window.setWidth100();
					window.setHeight100();
					window.centerInPage();
					window.show();
				}
			}
		});
		
		IButton exportButton = new IButton("导出");
		exportButton.addClickHandler(new ClickHandler(){
			@SuppressWarnings("rawtypes")
			@Override
			public void onClick(ClickEvent event) {
				Map condition = generateCriteria();
				DBDataSource.downloadFile("DW_OnDownloadSumRevenueYearRecords", condition);
			}
		});
		controlLayout.addMember(exportButton);
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
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("ReportOfSumRevenueYearRecords"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				ReportOfSumRevenueYearRecordsViewer detailForm = new ReportOfSumRevenueYearRecordsViewer();
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

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public boolean checkSearchCriteria(Map criteria) {
		//如果没有查看所有数据权限
		if (!ClientUtil.checkIsHavePermission(ERPPermissionStatic.REPORT_OF_SUM_REVENUE_CHECK_ALL)) {
			if(BaseHelpUtils.isNullOrEmpty(criteria.get("plateId"))) {
				//获取自己管理部门的部门id数据集
				String plateIds = PomPlatformClientUtil.getRolePlateId();
				if(!BaseHelpUtils.isNullOrEmpty(plateIds)) {
					List<Map> keyvalues = new ArrayList<>();
					Map<String, String> kv = new HashMap<>();
					kv.put("key", "and p.revenue_plate_id = ?");
					kv.put("value", "and p.revenue_plate_id in("+plateIds+") and p.revenue_plate_id = ?");
					keyvalues.add(kv);
					criteria.put("keyValues", keyvalues);
				}else {
					criteria.put("plateId",-1);
				}
			}
		}
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new ReportOfSumRevenueYearRecordsSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSReportOfSumRevenueYearRecords.getInstance();
	}

	@Override
	public int getSearchFormHeight() {
		return 60;
	}

}

