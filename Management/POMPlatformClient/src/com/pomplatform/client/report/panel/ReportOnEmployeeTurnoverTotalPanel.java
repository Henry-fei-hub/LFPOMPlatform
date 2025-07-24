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
import com.pomplatform.client.report.datasource.DSReportOnEmployeeTurnoverTotal;
import com.pomplatform.client.report.form.ReportOnEmployeeTurnoverTotalSearchForm;
import com.pomplatform.client.report.form.ReportOnEmployeeTurnoverTotalViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class ReportOnEmployeeTurnoverTotalPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ReportOnEmployeeTurnoverTotalPanel cm = new ReportOnEmployeeTurnoverTotalPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ReportOnEmployeeTurnoverTotal";
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
		ListGridField threeNum1 = new ListGridField("threeNum1", 60);  
		ListGridField fourNum1 = new ListGridField("fourNum1", 60);  
		
		ListGridField oneNum2 = new ListGridField("oneNum2", 60);  
		ListGridField twoNum2 = new ListGridField("twoNum2", 60);  
		ListGridField threeNum2 = new ListGridField("threeNum2", 60);  
		ListGridField fourNum2 = new ListGridField("fourNum2", 60);  
		
		ListGridField oneNum3 = new ListGridField("oneNum3", 60);  
		ListGridField twoNum3 = new ListGridField("twoNum3", 60);  
		ListGridField threeNum3 = new ListGridField("threeNum3", 60);  
		ListGridField fourNum3 = new ListGridField("fourNum3", 60);  
		
		ListGridField oneNum4 = new ListGridField("oneNum4", 60);  
		ListGridField twoNum4 = new ListGridField("twoNum4", 60);  
		ListGridField threeNum4 = new ListGridField("threeNum4", 60);  
		ListGridField fourNum4 = new ListGridField("fourNum4", 60);  
		
		ListGridField oneNum5 = new ListGridField("oneNum5", 60);  
		ListGridField twoNum5 = new ListGridField("twoNum5", 60);  
		ListGridField threeNum5 = new ListGridField("threeNum5", 60);  
		ListGridField fourNum5 = new ListGridField("fourNum5", 60);  
		
		ListGridField oneNum6 = new ListGridField("oneNum6", 60);  
		ListGridField twoNum6 = new ListGridField("twoNum6", 60);  
		ListGridField threeNum6 = new ListGridField("threeNum6", 60);  
		ListGridField fourNum6 = new ListGridField("fourNum6", 60);  

		ListGridField oneNum7 = new ListGridField("oneNum7", 60);  
		ListGridField twoNum7 = new ListGridField("twoNum7", 60);  
		ListGridField threeNum7 = new ListGridField("threeNum7", 60);  
		ListGridField fourNum7 = new ListGridField("fourNum7", 60);  
		
		ListGridField oneNum8 = new ListGridField("oneNum8", 60);  
		ListGridField twoNum8 = new ListGridField("twoNum8", 60);  
		ListGridField threeNum8 = new ListGridField("threeNum8", 60);  
		ListGridField fourNum8 = new ListGridField("fourNum8", 60);  

		
		ListGridField oneNum9 = new ListGridField("oneNum9", 60);  
		ListGridField twoNum9 = new ListGridField("twoNum9", 60);  
		ListGridField threeNum9 = new ListGridField("threeNum9", 60);  
		ListGridField fourNum9 = new ListGridField("fourNum9", 60);  

		
		ListGridField oneNum10 = new ListGridField("oneNum10", 60);  
		ListGridField twoNum10 = new ListGridField("twoNum10", 60);  
		ListGridField threeNum10 = new ListGridField("threeNum10", 60);  
		ListGridField fourNum10 = new ListGridField("fourNum10", 60);  

		
		ListGridField oneNum11 = new ListGridField("oneNum11", 60);  
		ListGridField twoNum11 = new ListGridField("twoNum11", 60);  
		ListGridField threeNum11 = new ListGridField("threeNum11", 60);  
		ListGridField fourNum11 = new ListGridField("fourNum11", 60);  

		
		ListGridField oneNum12 = new ListGridField("oneNum12", 60);  
		ListGridField twoNum12 = new ListGridField("twoNum12", 60);  
		ListGridField threeNum12 = new ListGridField("threeNum12", 60);  
		ListGridField fourNum12 = new ListGridField("fourNum12", 60);  

		

		resultGrid.setHeaderHeight(60);
		resultGrid.setHeaderSpans(new HeaderSpan[] {
				new HeaderSpan("1月", new String[] { "oneNum1","fourNum1" , "threeNum1", "twoNum1" }),
				new HeaderSpan("2月", new String[] { "oneNum2","fourNum2" , "threeNum2", "twoNum2" }),
				new HeaderSpan("3月", new String[] { "oneNum3","fourNum3" , "threeNum3", "twoNum3" }),
				new HeaderSpan("4月", new String[] { "oneNum4","fourNum4" , "threeNum4", "twoNum4" }),
				new HeaderSpan("5月", new String[] { "oneNum5","fourNum5" , "threeNum5", "twoNum5" }),
				new HeaderSpan("6月", new String[] { "oneNum6","fourNum6" , "threeNum6", "twoNum6" }),
				new HeaderSpan("7月", new String[] { "oneNum7","fourNum7" , "threeNum7", "twoNum7" }),
				new HeaderSpan("8月", new String[] { "oneNum8","fourNum8" , "threeNum8", "twoNum8" }),
				new HeaderSpan("9月", new String[] { "oneNum9","fourNum9" , "threeNum9", "twoNum9" }),
				new HeaderSpan("10月", new String[]{ "oneNum10","fourNum10", "threeNum10", "twoNum10"}),
				new HeaderSpan("11月", new String[]{ "oneNum11","fourNum11", "threeNum11", "twoNum11"}),
				new HeaderSpan("12月", new String[]{ "oneNum12","fourNum12", "threeNum12", "twoNum12"})
	    });
		
		resultGrid.setFields(plateId, year, oneNum1, twoNum1, threeNum1, fourNum1, oneNum2, twoNum2, threeNum2, fourNum2, oneNum3, twoNum3, threeNum3, fourNum3, oneNum4, twoNum4, threeNum4, fourNum4, oneNum5, twoNum5, threeNum5, fourNum5, oneNum6, twoNum6, threeNum6, fourNum6, oneNum7, twoNum7, threeNum7, fourNum7, oneNum8, twoNum8, threeNum8, fourNum8, oneNum9, twoNum9, threeNum9, fourNum9, oneNum10, twoNum10, threeNum10, fourNum10, oneNum11, twoNum11, threeNum11, fourNum11, oneNum12, twoNum12, threeNum12, fourNum12);
		
		
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
				ReportOnEmployeeTurnoverTotalByDepartmentPanel panel = new ReportOnEmployeeTurnoverTotalByDepartmentPanel();
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
		return new ReportOnEmployeeTurnoverTotalSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSReportOnEmployeeTurnoverTotal.getInstance();
	}
	
	
	public int getSearchFormHeight() {
		return 60;
	}
	

}

