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
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.bonuspayment.form.bonusSummaryViewer;
import com.pomplatform.client.bonuspayment.panel.bonusSummaryDetailPanel;
import com.pomplatform.client.report.datasource.DSSalaryBonusAnalysis;
import com.pomplatform.client.report.form.SalaryBonusAnalysisSearchForm;
import com.pomplatform.client.report.form.SalaryBonusAnalysisViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class SalaryBonusAnalysisPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			SalaryBonusAnalysisPanel cm = new SalaryBonusAnalysisPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "SalaryBonusAnalysis";
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
		
		resultGrid.setHeaderHeight(60); 
		resultGrid.setHeaderSpans(new HeaderSpan[] {
		   new HeaderSpan("第一季度", new String[] {"firstQuarter","firstPayIntegral","one"}),
		   new HeaderSpan("第二季度", new String[] {"secondQuarter","secondPayIntegral","two"}),
		   new HeaderSpan("第三季度", new String[] {"thirdQuarter","thirdPayIntegral","three"}),
		   new HeaderSpan("第四季度", new String[] {"fourthQuarter","fourthPayIntegral","four"}),
		   new HeaderSpan("合计", new String[] {"totalQuarter","totalPayIntegral","total"})
	    });	
		
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});
		
		IButton outputButton = new IButton("导出");
		controlLayout.addMember(outputButton);
		outputButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Map condition = generateCriteria();
				DBDataSource.downloadFile("DW_SalaryBonusAnalysis", condition);
			}
		});
		
		
		IButton outputButton2 = new IButton("导出二级部门");
		controlLayout.addMember(outputButton2);
		outputButton2.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Map condition = generateCriteria();
			/*	int year = BaseHelpUtils.getIntValue(condition.get("year"));
				if (year > 0) {
					condition.put("firststart", year+"-01-01");
					condition.put("firstend", year+"-03-31");
					condition.put("secondstart", year+"-04-01");
					condition.put("secondend", year+"-06-30");
					condition.put("thirdstart", year+"-07-01");
					condition.put("thirdend", year+"-09-31");
					condition.put("fourthstart", year+"-10-01");
					condition.put("fourthend", year+"-12-31");
				}else {
					SC.say("提示", "年份不可为空");
				}*/
				DBDataSource.downloadFile("DW_SalaryBonusAnalysisByDepartment", condition);
			}
		});

		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				Record record = resultGrid.getSelectedRecord();
				int plateId = BaseHelpUtils.getIntValue(record.getAttribute("plateId"));
				// 获取业务部门名称
				String plateName = KeyValueManager.getValue("system_dictionary_1", plateId + "");
				// 获取年月份
				int year = BaseHelpUtils.getIntValue(record.getAttribute("year"));
				// 获取检索栏的开始日期和结束日期
				PopupWindow pw = new PopupWindow();
				SalaryBonusAnalysisByDepartmentPanel panel = new SalaryBonusAnalysisByDepartmentPanel();
				pw.addItem(panel);
				panel.setPlateId(plateId);
				panel.setYear(year);
//				panel.initComponents();
				panel.commonQuery();
				pw.setTitle("业务部门(" + plateName + ")下的归属部门汇总");
				pw.setWidth100();
				pw.setHeight100();
				pw.centerInPage();
				pw.show();
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
				detail.setTitle("bonusSummary"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				bonusSummaryViewer detailForm = new bonusSummaryViewer();
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
		if(BaseHelpUtils.isNullOrEmpty(criteria.get("year"))) {
			SC.say("提示","年份不能为空");
			return false;
		}else {
			String year = BaseHelpUtils.getString(criteria.get("year"));
			criteria.put("firstStart", year+"-01-01");
			criteria.put("firstEnd", year+"-03-31");
			criteria.put("secondStart", year+"-04-01");
			criteria.put("secondEnd", year+"-06-30");
			criteria.put("thirdStart", year+"-07-01");
			criteria.put("thirdEnd", year+"-09-31");
			criteria.put("fourthStart", year+"-10-01");
			criteria.put("fourthEnd", year+"-12-31");
			return true;
		}
	}


	@Override
	public SearchForm generateSearchForm() {
		return new SalaryBonusAnalysisSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSSalaryBonusAnalysis.getInstance();
	}
	
	public int getSearchFormHeight() {
		return 60;
	}


}

