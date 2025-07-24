package com.pomplatform.client.report.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.report.datasource.DSReportOnEmployeeNumTotal;
import com.pomplatform.client.report.datasource.DSReportOnEmployeeNumTotalByDepartment;
import com.pomplatform.client.report.form.ReportOnEmployeeNumTotalSearchForm;
import com.pomplatform.client.report.form.ReportOnEmployeeNumTotalViewer;
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
import com.smartgwt.client.widgets.grid.HeaderSpan;

public class ReportOnEmployeeNumTotalByDepartmentPanel extends AbstractSearchPanel
{

	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ReportOnEmployeeNumTotalByDepartmentPanel cm = new ReportOnEmployeeNumTotalByDepartmentPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ReportOnEmployeeNumTotal";
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
		resultGrid.setHeaderHeight(60);
		resultGrid.setHeaderSpans(new HeaderSpan[] {
		   new HeaderSpan("1月", new String[] {"oneBeforNum","oneAfterNum","oneAverageNum"}),
		   new HeaderSpan("2月", new String[] {"twoBeforNum","twoAfterNum","twoAverageNum"}),
		   new HeaderSpan("3月", new String[] {"threeBeforNum","threeAfterNum","threeAverageNum"}),
		   new HeaderSpan("4月", new String[] {"fourBeforNum","fourAfterNum","fourAverageNum"}),
		   new HeaderSpan("5月", new String[] {"fiveBeforNum","fiveAfterNum","fiveAverageNum"}),
		   new HeaderSpan("6月", new String[] {"sixBeforNum","sixAfterNum","sixAverageNum"}),
		   new HeaderSpan("7月", new String[] {"sevenBeforNum","sevenAfterNum","sevenAverageNum"}),
		   new HeaderSpan("8月", new String[] {"eightBeforNum","eightAfterNum","eightAverageNum"}),
		   new HeaderSpan("9月", new String[] {"nineBeforNum","nineAfterNum","nineAverageNum"}),
		   new HeaderSpan("10月", new String[] {"tenBeforNum","tenAfterNum","tenAverageNum"}),
		   new HeaderSpan("11月", new String[] {"elevenBeforNum","elevenAfterNum","elevenAverageNum"}),
		   new HeaderSpan("12月", new String[] {"twelfBeforNum","twelfAfterNum","twelfAverageNum"})
	    });
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		if(!BaseHelpUtils.isNullOrEmpty(plateId)&&plateId>0) {
			criteria.put("plateId", plateId);
		}else {
			SC.say("提示", "请选择业务部门");
			return false;
		}
		if(!BaseHelpUtils.isNullOrEmpty(year)&&year>0) {
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
		return DSReportOnEmployeeNumTotalByDepartment.getInstance();
	}

	@Override
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

