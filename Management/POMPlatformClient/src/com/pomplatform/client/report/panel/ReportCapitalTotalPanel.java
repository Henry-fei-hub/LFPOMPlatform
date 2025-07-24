package com.pomplatform.client.report.panel;

import java.util.Arrays;
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
import com.smartgwt.client.widgets.grid.events.CellClickEvent;
import com.smartgwt.client.widgets.grid.events.CellClickHandler;
import com.smartgwt.client.widgets.grid.events.CellDoubleClickEvent;
import com.smartgwt.client.widgets.grid.events.CellDoubleClickHandler;
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
import com.pomplatform.client.report.datasource.DSReportCapitalTotal;
import com.pomplatform.client.report.form.ReportCapitalTotalSearchForm;
import com.pomplatform.client.report.form.ReportCapitalTotalViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class ReportCapitalTotalPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ReportCapitalTotalPanel cm = new ReportCapitalTotalPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ReportCapitalTotal";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid.setShowGridSummary(true);
	}

	@Override
	public void initComponents() {
		
		resultGrid.setHeaderHeight(60);
		resultGrid.setHeaderSpans(new HeaderSpan[] {
		   new HeaderSpan("1月", new String[] {"januaryRevenue","plateJanuaryRevenue"}),
		   new HeaderSpan("2月", new String[] {"februaryRevenue","plateFebruaryRevenue"}),
		   new HeaderSpan("3月", new String[] {"marchRevenue","plateMarchRevenue"}),
		   new HeaderSpan("4月", new String[] {"aprilRevenue","plateAprilRevenue"}),
		   new HeaderSpan("5月", new String[] {"mayRevenue","plateMayRevenue"}),
		   new HeaderSpan("6月", new String[] {"juneRevenue","plateJuneRevenue"}),
		   new HeaderSpan("7月", new String[] {"julyRevenue","plateJulyRevenue"}),
		   new HeaderSpan("8月", new String[] {"augustRevenue","plateAugustRevenue"}),
		   new HeaderSpan("9月", new String[] {"septemberRevenue","plateSeptemberRevenue"}),
		   new HeaderSpan("10月", new String[] {"octoberRevenue","plateOctoberRevenue"}),
		   new HeaderSpan("11月", new String[] {"novemberRevenue","plateNovemberRevenue"}),
		   new HeaderSpan("12月", new String[] {"decemberRevenue","plateDecemberRevenue"})
	    });
		
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});

		IButton exportButton = new IButton("导出");
		exportButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				Map condition = generateCriteria();
				DBDataSource.downloadFile("DW_OnDownloadReportCapitalTotal", condition);
			}
		});
		controlLayout.addMember(exportButton);
		
		resultGrid.addCellDoubleClickHandler(new CellDoubleClickHandler() {
			
			@Override
			public void onCellDoubleClick(CellDoubleClickEvent event) {
				Record record = resultGrid.getSelectedRecord();
				if(!BaseHelpUtils.isNullOrEmpty(record.getAttribute("plateId"))){//部门不为空才可以查看详情
					int plateId = BaseHelpUtils.getIntValue(record.getAttribute("plateId"));
					int year = BaseHelpUtils.getIntValue(record.getAttribute("year"));
					
					int colNum = event.getColNum();
					Integer[] arrProject = { 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25 };
				    List<Integer> listProject = Arrays.asList(arrProject);
				     
				    PopupWindow window = new PopupWindow();
					if(colNum > 2){//从第3列开始，单数为项目组，双数为部门
				    	if (listProject.contains(colNum)) {//项目组
				    		ReportCapitaProjectDetailPanel ppanel = new ReportCapitaProjectDetailPanel();
				    		ppanel.setPlateId(plateId);
				    		ppanel.setYear(year);
				    		ppanel.startEdit();
				    		window.addItem(ppanel);
				    	} else {//部门 
				    		ReportCapitaDepartmentDetailPanel dpanel = new ReportCapitaDepartmentDetailPanel();
				    		dpanel.setPlateId(plateId);
				    		dpanel.setYear(year);
				    		dpanel.startEdit();
				    		window.addItem(dpanel);
				    	}
				    }
					window.setTitle("现金流详情表");
					window.setWidth100();
					window.setHeight100();
					window.centerInPage();
					window.show();
				}
				
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
				detail.setTitle("ReportCapitalTotal"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				ReportCapitalTotalViewer detailForm = new ReportCapitalTotalViewer();
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
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new ReportCapitalTotalSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSReportCapitalTotal.getInstance();
	}

	@Override
	public int getSearchFormHeight() {
		return 60;
	}

}

