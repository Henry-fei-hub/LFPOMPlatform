package com.pomplatform.client.report.panel;

import java.util.Date;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.PopupWindow;
import com.delicacy.client.ui.LayoutConstant;
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
import java.util.Objects;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.report.datasource.DSReportOfEmployeeCostAnalysis;
import com.pomplatform.client.report.form.ReportOfEmployeeCostAnalysisSearchForm;
import com.pomplatform.client.report.form.ReportOfEmployeeCostAnalysisViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class ReportOfEmployeeCostAnalysisPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ReportOfEmployeeCostAnalysisPanel cm = new ReportOfEmployeeCostAnalysisPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ReportOfEmployeeCostAnalysis";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid.setAutoFitFieldWidths(false);
		resultGrid.setShowGridSummary(true);
		resultGrid.setCanEdit(true);
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

		IButton viewButton = new IButton("查看详细");
		viewButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		controlLayout.addMember(viewButton);
		
		resultGrid.addEditCompleteHandler(new EditCompleteHandler() {
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				Map<String,Object> map = resultGrid.getRecord(event.getRowNum()).toMap();
				DBDataSource.callOperation("ST_EmployeeCostAnalysy", "saveOrUpdate", map, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0){
							commonQuery();
						}
					}
				});
			}
		});
		
		IButton monthButton = new IButton("统计");
		controlLayout.addMember(monthButton);
		monthButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Map<String,Object> params = generateCriteria();
				params.put("optType", "sumSalaryAndInsuranceCost");
				DBDataSource.callOperation("EP_OnReportProcess", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0){
							commonQuery();
						}else{
							SC.say(dsResponse.getErrors().get("errorMsg").toString());
						}
					}
				});
			}
		});
		
		IButton lockButton = new IButton("加锁");
		controlLayout.addMember(lockButton);
		lockButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Map<String,Object> params = generateCriteria();
				params.put("optType", "lockSalaryAndInsuranceCost");
				DBDataSource.callOperation("EP_OnReportProcess", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0){
							SC.say("加锁成功");
							commonQuery();
						}
					}
				});
			}
		});
		
		IButton importButton = new IButton("导出");
		controlLayout.addMember(importButton);
		importButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Map<String,Object> condition = generateCriteria();
				DBDataSource.downloadFile("DW_DownloadEmployeeCostAnalysy", condition);
			}
		});
		
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
				detail.setTitle("人工成本对比分析表"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				ReportOfEmployeeCostAnalysisViewer detailForm = new ReportOfEmployeeCostAnalysisViewer();
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
		criteria.put("addtionalCondition", "order by employee_cost_analysis_id");
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new ReportOfEmployeeCostAnalysisSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSReportOfEmployeeCostAnalysis.getInstance();
	}

	@Override
	public int getSearchFormHeight() {
		return 60;
	}

	@Override
	public void afterDataReceived(Record[] data) {
		if(!BaseHelpUtils.isNullOrEmpty(data)){
			boolean isLocked = false;
			for(Record e : data){
				isLocked = e.getAttributeAsBoolean("isLocked");
				if(isLocked){//如果数据已加锁，不能再进行编辑操作
					e.setAttribute("enabled", false);
				}
			}
		}
	}
}

