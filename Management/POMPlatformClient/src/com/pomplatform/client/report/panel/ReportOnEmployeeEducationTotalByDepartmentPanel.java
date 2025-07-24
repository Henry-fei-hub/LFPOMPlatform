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
import com.pomplatform.client.report.datasource.DSReportOnEmployeeEducationTotalByDepartment;
import com.pomplatform.client.report.form.ReportOnEmployeeEducationTotalByDepartmentSearchForm;
import com.pomplatform.client.report.form.ReportOnEmployeeEducationTotalByDepartmentViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class ReportOnEmployeeEducationTotalByDepartmentPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ReportOnEmployeeEducationTotalByDepartmentPanel cm = new ReportOnEmployeeEducationTotalByDepartmentPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ReportOnEmployeeEducationTotalByDepartment";
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
		
		ListGridField departmentId = new ListGridField("departmentId", 100);  
		departmentId.setFrozen(true);  
		ListGridField year = new ListGridField("year", 60);  
		year.setFrozen(true); 
		ListGridField zeroNum1 = new ListGridField("zeroNum1", 60);  
		ListGridField oneNum1 = new ListGridField("oneNum1", 60);  
		ListGridField twoNum1 = new ListGridField("twoNum1", 60);  
		ListGridField threeNum1 = new ListGridField("threeNum1", 60);  
		ListGridField fourNum1 = new ListGridField("fourNum1", 60);  
		ListGridField fiveNum1 = new ListGridField("fiveNum1", 60);  
		ListGridField sixNum1 = new ListGridField("sixNum1", 60);  
		ListGridField totalNum1 = new ListGridField("totalNum1", 60);  
		
		ListGridField zeroNum2 = new ListGridField("zeroNum2", 60);  
		ListGridField oneNum2 = new ListGridField("oneNum2", 60);  
		ListGridField twoNum2 = new ListGridField("twoNum2", 60);  
		ListGridField threeNum2 = new ListGridField("threeNum2", 60);  
		ListGridField fourNum2 = new ListGridField("fourNum2", 60);  
		ListGridField fiveNum2 = new ListGridField("fiveNum2", 60);  
		ListGridField sixNum2 = new ListGridField("sixNum2", 60);   
		ListGridField totalNum2 = new ListGridField("totalNum2", 60); 
		
		ListGridField zeroNum3 = new ListGridField("zeroNum3", 60);  
		ListGridField oneNum3 = new ListGridField("oneNum3", 60);  
		ListGridField twoNum3 = new ListGridField("twoNum3", 60);  
		ListGridField threeNum3 = new ListGridField("threeNum3", 60);  
		ListGridField fourNum3 = new ListGridField("fourNum3", 60);  
		ListGridField fiveNum3 = new ListGridField("fiveNum3", 60);  
		ListGridField sixNum3 = new ListGridField("sixNum3", 60); 
		ListGridField totalNum3 = new ListGridField("totalNum3", 60); 
		
		ListGridField zeroNum4 = new ListGridField("zeroNum4", 60);  
		ListGridField oneNum4 = new ListGridField("oneNum4", 60);  
		ListGridField twoNum4 = new ListGridField("twoNum4", 60);  
		ListGridField threeNum4 = new ListGridField("threeNum4", 60);  
		ListGridField fourNum4 = new ListGridField("fourNum4", 60);  
		ListGridField fiveNum4 = new ListGridField("fiveNum4", 60);  
		ListGridField sixNum4 = new ListGridField("sixNum4", 60); 
		ListGridField totalNum4 = new ListGridField("totalNum4", 60); 
		
		ListGridField zeroNum5 = new ListGridField("zeroNum5", 60);  
		ListGridField oneNum5 = new ListGridField("oneNum5", 60);  
		ListGridField twoNum5 = new ListGridField("twoNum5", 60);  
		ListGridField threeNum5 = new ListGridField("threeNum5", 60);  
		ListGridField fourNum5 = new ListGridField("fourNum5", 60);  
		ListGridField fiveNum5 = new ListGridField("fiveNum5", 60);  
		ListGridField sixNum5 = new ListGridField("sixNum5", 60);  
		ListGridField totalNum5 = new ListGridField("totalNum5", 60); 
		
		ListGridField zeroNum6 = new ListGridField("zeroNum6", 60);  
		ListGridField oneNum6 = new ListGridField("oneNum6", 60);  
		ListGridField twoNum6 = new ListGridField("twoNum6", 60);  
		ListGridField threeNum6 = new ListGridField("threeNum6", 60);  
		ListGridField fourNum6 = new ListGridField("fourNum6", 60);  
		ListGridField fiveNum6 = new ListGridField("fiveNum6", 60);  
		ListGridField sixNum6 = new ListGridField("sixNum6", 60); 
		ListGridField totalNum6 = new ListGridField("totalNum6", 60);

		ListGridField zeroNum7 = new ListGridField("zeroNum7", 60);  
		ListGridField oneNum7 = new ListGridField("oneNum7", 60);  
		ListGridField twoNum7 = new ListGridField("twoNum7", 60);  
		ListGridField threeNum7 = new ListGridField("threeNum7", 60);  
		ListGridField fourNum7 = new ListGridField("fourNum7", 60);  
		ListGridField fiveNum7 = new ListGridField("fiveNum7", 60);  
		ListGridField sixNum7 = new ListGridField("sixNum7", 60); 
		ListGridField totalNum7 = new ListGridField("totalNum7", 60); 
		
		ListGridField zeroNum8 = new ListGridField("zeroNum8", 60);  
		ListGridField oneNum8 = new ListGridField("oneNum8", 60);  
		ListGridField twoNum8 = new ListGridField("twoNum8", 60);  
		ListGridField threeNum8 = new ListGridField("threeNum8", 60);  
		ListGridField fourNum8 = new ListGridField("fourNum8", 60);  
		ListGridField fiveNum8 = new ListGridField("fiveNum8", 60);  
		ListGridField sixNum8 = new ListGridField("sixNum8", 60); 
		ListGridField totalNum8 = new ListGridField("totalNum8", 60); 
		
		ListGridField zeroNum9 = new ListGridField("zeroNum9", 60);  
		ListGridField oneNum9 = new ListGridField("oneNum9", 60);  
		ListGridField twoNum9 = new ListGridField("twoNum9", 60);  
		ListGridField threeNum9 = new ListGridField("threeNum9", 60);  
		ListGridField fourNum9 = new ListGridField("fourNum9", 60);  
		ListGridField fiveNum9 = new ListGridField("fiveNum9", 60);  
		ListGridField sixNum9 = new ListGridField("sixNum9", 60); 
		ListGridField totalNum9 = new ListGridField("totalNum9", 60);
		
		ListGridField zeroNum10 = new ListGridField("zeroNum10", 60);  
		ListGridField oneNum10 = new ListGridField("oneNum10", 60);  
		ListGridField twoNum10 = new ListGridField("twoNum10", 60);  
		ListGridField threeNum10 = new ListGridField("threeNum10", 60);  
		ListGridField fourNum10 = new ListGridField("fourNum10", 60);  
		ListGridField fiveNum10 = new ListGridField("fiveNum10", 60);  
		ListGridField sixNum10 = new ListGridField("sixNum10", 60); 
		ListGridField totalNum10 = new ListGridField("totalNum10", 60); 
		
		ListGridField zeroNum11 = new ListGridField("zeroNum11", 60);  
		ListGridField oneNum11 = new ListGridField("oneNum11", 60);  
		ListGridField twoNum11 = new ListGridField("twoNum11", 60);  
		ListGridField threeNum11 = new ListGridField("threeNum11", 60);  
		ListGridField fourNum11 = new ListGridField("fourNum11", 60);  
		ListGridField fiveNum11 = new ListGridField("fiveNum11", 60);  
		ListGridField sixNum11 = new ListGridField("sixNum11", 60);  
		ListGridField totalNum11 = new ListGridField("totalNum11", 60); 
		
		ListGridField zeroNum12 = new ListGridField("zeroNum12", 60);  
		ListGridField oneNum12 = new ListGridField("oneNum12", 60);  
		ListGridField twoNum12 = new ListGridField("twoNum12", 60);  
		ListGridField threeNum12 = new ListGridField("threeNum12", 60);  
		ListGridField fourNum12 = new ListGridField("fourNum12", 60);  
		ListGridField fiveNum12 = new ListGridField("fiveNum12", 60);  
		ListGridField sixNum12 = new ListGridField("sixNum12", 60); 
		ListGridField totalNum12 = new ListGridField("totalNum12", 60); 
		

		resultGrid.setHeaderHeight(60);
		resultGrid.setHeaderSpans(new HeaderSpan[] {
		   new HeaderSpan("1月", new String[] {"zeroNum1","oneNum1","twoNum1","threeNum1","fourNum1","fiveNum1","sixNum1","totalNum1"}),
		   new HeaderSpan("2月", new String[] {"zeroNum2","oneNum2","twoNum2","threeNum2","fourNum2","fiveNum2","sixNum2","totalNum2"}),
		   new HeaderSpan("3月", new String[] {"zeroNum3","oneNum3","twoNum3","threeNum3","fourNum3","fiveNum3","sixNum3","totalNum3"}),
		   new HeaderSpan("4月", new String[] {"zeroNum4","oneNum4","twoNum4","threeNum4","fourNum4","fiveNum4","sixNum4","totalNum4"}),
		   new HeaderSpan("5月", new String[] {"zeroNum5","oneNum5","twoNum5","threeNum5","fourNum5","fiveNum5","sixNum5","totalNum5"}),
		   new HeaderSpan("6月", new String[] {"zeroNum6","oneNum6","twoNum6","threeNum6","fourNum6","fiveNum6","sixNum6","totalNum6"}),
		   new HeaderSpan("7月", new String[] {"zeroNum7","oneNum7","twoNum7","threeNum7","fourNum7","fiveNum7","sixNum7","totalNum7"}),
		   new HeaderSpan("8月", new String[] {"zeroNum8","oneNum8","twoNum8","threeNum8","fourNum8","fiveNum8","sixNum8","totalNum8"}),
		   new HeaderSpan("9月", new String[] {"zeroNum9","oneNum9","twoNum9","threeNum9","fourNum9","fiveNum9","sixNum9","totalNum9"}),
		   new HeaderSpan("10月", new String[] {"zeroNum10","oneNum10","twoNum10","threeNum10","fourNum10","fiveNum10","sixNum10","totalNum10"}),
		   new HeaderSpan("11月", new String[] {"zeroNum11","oneNum11","twoNum11","threeNum11","fourNum11","fiveNum11","sixNum11","totalNum11"}),
		   new HeaderSpan("12月", new String[] {"zeroNum12","oneNum12","twoNum12","threeNum12","fourNum12","fiveNum12","sixNum12","totalNum12"})
	    });
		
		resultGrid.setFields(departmentId, year, zeroNum1, oneNum1, twoNum1, threeNum1, fourNum1, fiveNum1, sixNum1, totalNum1, zeroNum2, oneNum2, twoNum2, threeNum2, fourNum2, fiveNum2, sixNum2, totalNum2, zeroNum3, oneNum3, twoNum3, threeNum3, fourNum3, fiveNum3, sixNum3, totalNum3, zeroNum4, oneNum4, twoNum4, threeNum4, fourNum4, fiveNum4, sixNum4, totalNum4, zeroNum5, oneNum5, twoNum5, threeNum5, fourNum5, fiveNum5, sixNum5, totalNum5, zeroNum6, oneNum6, twoNum6, threeNum6, fourNum6, fiveNum6, sixNum6, totalNum6, zeroNum7, oneNum7, twoNum7, threeNum7, fourNum7, fiveNum7, sixNum7, totalNum7, zeroNum8, oneNum8, twoNum8, threeNum8, fourNum8, fiveNum8, sixNum8, totalNum8, zeroNum9, oneNum9, twoNum9, threeNum9, fourNum9, fiveNum9, sixNum9, totalNum9, zeroNum10, oneNum10, twoNum10, threeNum10, fourNum10, fiveNum10, sixNum10, totalNum10, zeroNum11, oneNum11, twoNum11, threeNum11, fourNum11, fiveNum11, sixNum11, totalNum11, zeroNum12, oneNum12, twoNum12, threeNum12, fourNum12, fiveNum12, sixNum12, totalNum12);
	
//		commonQuery();
	}


	@Override
	public boolean checkSearchCriteria(Map criteria) {
		SC.debugger();
		if(plateId>0) {
			criteria.put("plateId", plateId);
		}else {
			SC.say("提示", "请选择业务部门");
			return false;
		}
		if(year>0) {
			criteria.put("year", year);
		}else {
			SC.say("提示", "请选择年份");
			return false;
		}
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSReportOnEmployeeEducationTotalByDepartment.getInstance();
	}
	
	
	public int getSearchFormHeight() {
		return 60;
	}
	
	

	private int plateId;
	private int year;
	public int getPlateId() {
		return plateId;
	}

	public void setPlateId(int plateId) {
		this.plateId = plateId;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}

