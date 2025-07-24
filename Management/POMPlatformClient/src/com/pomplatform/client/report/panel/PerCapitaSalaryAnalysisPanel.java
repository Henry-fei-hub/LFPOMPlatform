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
import com.pomplatform.client.report.datasource.DSPerCapitaSalaryAnalysis;
import com.pomplatform.client.report.form.PerCapitaSalaryAnalysisSearchForm;
import com.pomplatform.client.report.form.PerCapitaSalaryAnalysisViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class PerCapitaSalaryAnalysisPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			PerCapitaSalaryAnalysisPanel cm = new PerCapitaSalaryAnalysisPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "PerCapitaSalaryAnalysis";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid.setAutoFitFieldWidths(true);
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
		
		IButton outputButton = new IButton("导出");
		controlLayout.addMember(outputButton);
		outputButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Map condition = generateCriteria();
				DBDataSource.downloadFile("DW_PerCapitaSalaryAnalysis", condition);
			}
		});
		
		
		IButton outputButton2 = new IButton("导出二级部门");
		controlLayout.addMember(outputButton2);
		outputButton2.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Map condition = generateCriteria();
				DBDataSource.downloadFile("DW_PerCapitaSalaryAnalysisByDepartment", condition);
			}
		});
		
		resultGrid.setHeaderHeight(60); 
		resultGrid.setHeaderSpans(new HeaderSpan[] {
		   new HeaderSpan("第一季度", new String[] {"firstQuarter","firstPayIntegral","one","oneAverage","oneAverageNum"}),
		   new HeaderSpan("第二季度", new String[] {"secondQuarter","secondPayIntegral","two","twoAverage","twoAverageNum"}),
		   new HeaderSpan("第三季度", new String[] {"thirdQuarter","thirdPayIntegral","three","threeAverage","threeAverageNum"}),
		   new HeaderSpan("第四季度", new String[] {"fourthQuarter","fourthPayIntegral","four","fourAverage","fourAverageNum"}),
		   new HeaderSpan("合计", new String[] {"totalQuarter","totalPayQuarter","five","fiveAverage","fiveAverageNum"})
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
				PerCapitaSalaryAnalysisByDepartmentPanel panel = new PerCapitaSalaryAnalysisByDepartmentPanel();
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
				detail.setTitle("PerCapitaSalaryAnalysis"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				PerCapitaSalaryAnalysisViewer detailForm = new PerCapitaSalaryAnalysisViewer();
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
		return new PerCapitaSalaryAnalysisSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSPerCapitaSalaryAnalysis.getInstance();
	}
	
	public int getSearchFormHeight() {
		return 60;
	}

}















