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
import com.pomplatform.client.report.datasource.DSReportOnEmployeeBenefitTotal;
import com.pomplatform.client.report.form.ReportOnEmployeeBenefitTotalSearchForm;
import com.pomplatform.client.report.form.ReportOnEmployeeBenefitTotalViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class ReportOnEmployeeBenefitTotalPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ReportOnEmployeeBenefitTotalPanel cm = new ReportOnEmployeeBenefitTotalPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ReportOnEmployeeBenefitTotal";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid.setShowGridSummary(true);
		__needControl = false;
	}

	@Override
	public void initComponents() {
		
		ListGridField plateId = new ListGridField("plateId", 100);  
		plateId.setFrozen(true);  
		ListGridField year = new ListGridField("year", 60);  
		year.setFrozen(true); 
		ListGridField oneNum1 = new ListGridField("oneNum1", 60);  
		ListGridField twoNum1 = new ListGridField("twoNum1", 60);  
		ListGridField totalNum1 = new ListGridField("totalNum1", 60);  
		
		ListGridField oneNum2 = new ListGridField("oneNum2", 60);  
		ListGridField twoNum2 = new ListGridField("twoNum2", 60);  
		ListGridField totalNum2 = new ListGridField("totalNum2", 60); 
		
		ListGridField oneNum3 = new ListGridField("oneNum3", 60);  
		ListGridField twoNum3 = new ListGridField("twoNum3", 60);  
		ListGridField totalNum3 = new ListGridField("totalNum3", 60); 
		
		ListGridField oneNum4 = new ListGridField("oneNum4", 60);  
		ListGridField twoNum4 = new ListGridField("twoNum4", 60);  
		ListGridField totalNum4 = new ListGridField("totalNum4", 60); 
		
		ListGridField oneNum5 = new ListGridField("oneNum5", 60);  
		ListGridField twoNum5 = new ListGridField("twoNum5", 60);  
		ListGridField totalNum5 = new ListGridField("totalNum5", 60); 
		
		ListGridField oneNum6 = new ListGridField("oneNum6", 60);  
		ListGridField twoNum6 = new ListGridField("twoNum6", 60);  
		ListGridField totalNum6 = new ListGridField("totalNum6", 60);

		ListGridField oneNum7 = new ListGridField("oneNum7", 60);  
		ListGridField twoNum7 = new ListGridField("twoNum7", 60);  
		ListGridField totalNum7 = new ListGridField("totalNum7", 60); 
		
		ListGridField oneNum8 = new ListGridField("oneNum8", 60);  
		ListGridField twoNum8 = new ListGridField("twoNum8", 60);  
		ListGridField totalNum8 = new ListGridField("totalNum8", 60); 
		
		ListGridField oneNum9 = new ListGridField("oneNum9", 60);  
		ListGridField twoNum9 = new ListGridField("twoNum9", 60);  
		ListGridField totalNum9 = new ListGridField("totalNum9", 60);
		
		ListGridField oneNum10 = new ListGridField("oneNum10", 60);  
		ListGridField twoNum10 = new ListGridField("twoNum10", 60);  
		ListGridField totalNum10 = new ListGridField("totalNum10", 60); 
		
		ListGridField oneNum11 = new ListGridField("oneNum11", 60);  
		ListGridField twoNum11 = new ListGridField("twoNum11", 60);  
		ListGridField totalNum11 = new ListGridField("totalNum11", 60); 
		
		ListGridField oneNum12 = new ListGridField("oneNum12", 60);  
		ListGridField twoNum12 = new ListGridField("twoNum12", 60);  
		ListGridField totalNum12 = new ListGridField("totalNum12", 60); 
		

		resultGrid.setHeaderHeight(60);
		resultGrid.setHeaderSpans(new HeaderSpan[] {
		   new HeaderSpan("1月", new String[] {"oneNum1","twoNum1","totalNum1"}),
		   new HeaderSpan("2月", new String[] {"oneNum2","twoNum2","totalNum2"}),
		   new HeaderSpan("3月", new String[] {"oneNum3","twoNum3","totalNum3"}),
		   new HeaderSpan("4月", new String[] {"oneNum4","twoNum4","totalNum4"}),
		   new HeaderSpan("5月", new String[] {"oneNum5","twoNum5","totalNum5"}),
		   new HeaderSpan("6月", new String[] {"oneNum6","twoNum6","totalNum6"}),
		   new HeaderSpan("7月", new String[] {"oneNum7","twoNum7","totalNum7"}),
		   new HeaderSpan("8月", new String[] {"oneNum8","twoNum8","totalNum8"}),
		   new HeaderSpan("9月", new String[] {"oneNum9","twoNum9","totalNum9"}),
		   new HeaderSpan("10月", new String[]{"oneNum10","twoNum10","totalNum10"}),
		   new HeaderSpan("11月", new String[]{"oneNum11","twoNum11","totalNum11"}),
		   new HeaderSpan("12月", new String[]{"oneNum12","twoNum12","totalNum12"})
	    });
		
		resultGrid.setFields(plateId, year, oneNum1, twoNum1, totalNum1, oneNum2, twoNum2, totalNum2, oneNum3, twoNum3, totalNum3, oneNum4, twoNum4, totalNum4, oneNum5, twoNum5, totalNum5, oneNum6, twoNum6, totalNum6, oneNum7, twoNum7, totalNum7, oneNum8, twoNum8, totalNum8, oneNum9, twoNum9, totalNum9, oneNum10, twoNum10, totalNum10, oneNum11, twoNum11, totalNum11, oneNum12, twoNum12, totalNum12);
		
		
		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				Record record = resultGrid.getSelectedRecord();
				int plateId = BaseHelpUtils.getIntValue(record.getAttribute("plateId"));
				int year = BaseHelpUtils.getIntValue(record.getAttribute("year"));
				// 获取业务部门名称
				String plateName = KeyValueManager.getValue("system_dictionary_1", plateId + "");
				// 获取检索栏的开始日期和结束日期
				PopupWindow pw = new PopupWindow();
				ReportOnEmployeeBenefitTotalByDepartmentPanel panel = new ReportOnEmployeeBenefitTotalByDepartmentPanel();
				pw.addItem(panel);
				panel.setPlateId(plateId);
				panel.setYear(year);
				panel.initComponents();
				panel.commonQuery();
				pw.setTitle("业务部门(" + plateName + ")下的效益指数分析");
				pw.setWidth100();
				pw.setHeight100();
				pw.centerInPage();
				pw.show();
			}
		});
		
		commonQuery();
	}


	@Override
	public boolean checkSearchCriteria(Map criteria) {
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new ReportOnEmployeeBenefitTotalSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSReportOnEmployeeBenefitTotal.getInstance();
	}
	
	public int getSearchFormHeight() {
		return 60;
	}


}

