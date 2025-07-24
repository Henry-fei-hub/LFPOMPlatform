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
import com.pomplatform.client.report.datasource.DSReportOnEmployeeAgeTotal;
import com.pomplatform.client.report.form.ReportOnEmployeeAgeTotalSearchForm;
import com.pomplatform.client.report.form.ReportOnEmployeeAgeTotalViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class ReportOnEmployeeAgeTotalPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ReportOnEmployeeAgeTotalPanel cm = new ReportOnEmployeeAgeTotalPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ReportOnEmployeeAgeTotal";
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
		ListGridField sixNum1 = new ListGridField("sixNum1", 60);  
		ListGridField sevenNum1 = new ListGridField("sevenNum1", 60);  
		ListGridField eightNum1 = new ListGridField("eightNum1", 60);  
		ListGridField nineNum1 = new ListGridField("nineNum1", 60);  
		ListGridField zeroNum1 = new ListGridField("zeroNum1", 60);  
		ListGridField totalNum1 = new ListGridField("totalNum1", 60);  
		
		ListGridField sixNum2 = new ListGridField("sixNum2", 60);  
		ListGridField sevenNum2 = new ListGridField("sevenNum2", 60);  
		ListGridField eightNum2 = new ListGridField("eightNum2", 60);  
		ListGridField nineNum2 = new ListGridField("nineNum2", 60);  
		ListGridField zeroNum2 = new ListGridField("zeroNum2", 60);  
		ListGridField totalNum2 = new ListGridField("totalNum2", 60); 
		
		ListGridField sixNum3 = new ListGridField("sixNum3", 60);  
		ListGridField sevenNum3 = new ListGridField("sevenNum3", 60);  
		ListGridField eightNum3 = new ListGridField("eightNum3", 60);  
		ListGridField nineNum3 = new ListGridField("nineNum3", 60);  
		ListGridField zeroNum3 = new ListGridField("zeroNum3", 60);  
		ListGridField totalNum3 = new ListGridField("totalNum3", 60); 
		
		ListGridField sixNum4 = new ListGridField("sixNum4", 60);  
		ListGridField sevenNum4 = new ListGridField("sevenNum4", 60);  
		ListGridField eightNum4 = new ListGridField("eightNum4", 60);  
		ListGridField nineNum4 = new ListGridField("nineNum4", 60);  
		ListGridField zeroNum4 = new ListGridField("zeroNum4", 60);  
		ListGridField totalNum4 = new ListGridField("totalNum4", 60); 
		
		ListGridField sixNum5 = new ListGridField("sixNum5", 60);  
		ListGridField sevenNum5 = new ListGridField("sevenNum5", 60);  
		ListGridField eightNum5 = new ListGridField("eightNum5", 60);  
		ListGridField nineNum5 = new ListGridField("nineNum5", 60);  
		ListGridField zeroNum5 = new ListGridField("zeroNum5", 60);  
		ListGridField totalNum5 = new ListGridField("totalNum5", 60); 
		
		ListGridField sixNum6 = new ListGridField("sixNum6", 60);  
		ListGridField sevenNum6 = new ListGridField("sevenNum6", 60);  
		ListGridField eightNum6 = new ListGridField("eightNum6", 60);  
		ListGridField nineNum6 = new ListGridField("nineNum6", 60);  
		ListGridField zeroNum6 = new ListGridField("zeroNum6", 60);  
		ListGridField totalNum6 = new ListGridField("totalNum6", 60);

		ListGridField sixNum7 = new ListGridField("sixNum7", 60);  
		ListGridField sevenNum7 = new ListGridField("sevenNum7", 60);  
		ListGridField eightNum7 = new ListGridField("eightNum7", 60);  
		ListGridField nineNum7 = new ListGridField("nineNum7", 60);  
		ListGridField zeroNum7 = new ListGridField("zeroNum7", 60);  
		ListGridField totalNum7 = new ListGridField("totalNum7", 60); 
		
		ListGridField sixNum8 = new ListGridField("sixNum8", 60);  
		ListGridField sevenNum8 = new ListGridField("sevenNum8", 60);  
		ListGridField eightNum8 = new ListGridField("eightNum8", 60);  
		ListGridField nineNum8 = new ListGridField("nineNum8", 60);  
		ListGridField zeroNum8 = new ListGridField("zeroNum8", 60);  
		ListGridField totalNum8 = new ListGridField("totalNum8", 60); 
		
		ListGridField sixNum9 = new ListGridField("sixNum9", 60);  
		ListGridField sevenNum9 = new ListGridField("sevenNum9", 60);  
		ListGridField eightNum9 = new ListGridField("eightNum9", 60);  
		ListGridField nineNum9 = new ListGridField("nineNum9", 60);  
		ListGridField zeroNum9 = new ListGridField("zeroNum9", 60);  
		ListGridField totalNum9 = new ListGridField("totalNum9", 60);
		
		ListGridField sixNum10 = new ListGridField("sixNum10", 60);  
		ListGridField sevenNum10 = new ListGridField("sevenNum10", 60);  
		ListGridField eightNum10 = new ListGridField("eightNum10", 60);  
		ListGridField nineNum10 = new ListGridField("nineNum10", 60);  
		ListGridField zeroNum10 = new ListGridField("zeroNum10", 60);  
		ListGridField totalNum10 = new ListGridField("totalNum10", 60); 
		
		ListGridField sixNum11 = new ListGridField("sixNum11", 60);  
		ListGridField sevenNum11 = new ListGridField("sevenNum11", 60);  
		ListGridField eightNum11 = new ListGridField("eightNum11", 60);  
		ListGridField nineNum11 = new ListGridField("nineNum11", 60);  
		ListGridField zeroNum11 = new ListGridField("zeroNum11", 60);  
		ListGridField totalNum11 = new ListGridField("totalNum11", 60); 
		
		ListGridField sixNum12 = new ListGridField("sixNum12", 60);  
		ListGridField sevenNum12 = new ListGridField("sevenNum12", 60);  
		ListGridField eightNum12 = new ListGridField("eightNum12", 60);  
		ListGridField nineNum12 = new ListGridField("nineNum12", 60);  
		ListGridField zeroNum12 = new ListGridField("zeroNum12", 60);  
		ListGridField totalNum12 = new ListGridField("totalNum12", 60); 
		
		
		resultGrid.setHeaderHeight(60);
		resultGrid.setHeaderSpans(new HeaderSpan[] {
		   new HeaderSpan("1月", new String[] {"sixNum1","sevenNum1","eightNum1","nineNum1","zeroNum1","totalNum1"}),
		   new HeaderSpan("2月", new String[] {"sixNum2","sevenNum2","eightNum2","nineNum2","zeroNum2","totalNum2"}),
		   new HeaderSpan("3月", new String[] {"sixNum3","sevenNum3","eightNum3","nineNum3","zeroNum3","totalNum3"}),
		   new HeaderSpan("4月", new String[] {"sixNum4","sevenNum4","eightNum4","nineNum4","zeroNum4","totalNum4"}),
		   new HeaderSpan("5月", new String[] {"sixNum5","sevenNum5","eightNum5","nineNum5","zeroNum5","totalNum5"}),
		   new HeaderSpan("6月", new String[] {"sixNum6","sevenNum6","eightNum6","nineNum6","zeroNum6","totalNum6"}),
		   new HeaderSpan("7月", new String[] {"sixNum7","sevenNum7","eightNum7","nineNum7","zeroNum7","totalNum7"}),
		   new HeaderSpan("8月", new String[] {"sixNum8","sevenNum8","eightNum8","nineNum8","zeroNum8","totalNum8"}),
		   new HeaderSpan("9月", new String[] {"sixNum9","sevenNum9","eightNum9","nineNum9","zeroNum9","totalNum9"}),
		   new HeaderSpan("10月", new String[] {"sixNum10","sevenNum10","eightNum10","nineNum10","zeroNum10","totalNum10"}),
		   new HeaderSpan("11月", new String[] {"sixNum11","sevenNum11","eightNum11","nineNum11","zeroNum11","totalNum11"}),
		   new HeaderSpan("12月", new String[] {"sixNum12","sevenNum12","eightNum12","nineNum12","zeroNum12","totalNum12"})
	    });
		
		resultGrid.setFields(plateId, year, sixNum1, sevenNum1, eightNum1, nineNum1, zeroNum1, totalNum1, sixNum2, sevenNum2, eightNum2, nineNum2, zeroNum2, totalNum2, sixNum3, sevenNum3, eightNum3, nineNum3, zeroNum3, totalNum3, sixNum4, sevenNum4, eightNum4, nineNum4, zeroNum4, totalNum4, sixNum5, sevenNum5, eightNum5, nineNum5, zeroNum5, totalNum5, sixNum6, sevenNum6, eightNum6, nineNum6, zeroNum6, totalNum6, sixNum7, sevenNum7, eightNum7, nineNum7, zeroNum7, totalNum7, sixNum8, sevenNum8, eightNum8, nineNum8, zeroNum8, totalNum8, sixNum9, sevenNum9, eightNum9, nineNum9, zeroNum9, totalNum9, sixNum10, sevenNum10, eightNum10, nineNum10, zeroNum10, totalNum10, sixNum11, sevenNum11, eightNum11, nineNum11, zeroNum11, totalNum11, sixNum12, sevenNum12, eightNum12, nineNum12, zeroNum12, totalNum12);
		
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
				ReportOnEmployeeAgeTotalByDepartmentPanel panel = new ReportOnEmployeeAgeTotalByDepartmentPanel();
				pw.addItem(panel);
				panel.setPlateId(plateId);
				panel.setYear(year);
				panel.initComponents();
				panel.commonQuery();
				pw.setTitle("业务部门(" + plateName + ")下的年龄结构");
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
		return new ReportOnEmployeeAgeTotalSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSReportOnEmployeeAgeTotal.getInstance();
	}

	public int getSearchFormHeight() {
		return 60;
	}

}





































