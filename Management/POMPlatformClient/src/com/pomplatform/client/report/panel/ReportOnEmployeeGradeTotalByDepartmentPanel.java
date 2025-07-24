package com.pomplatform.client.report.panel;

import java.util.Date;

import com.pomplatform.client.report.datasource.DSReportOnEmployeeGradeTotal;
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
import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.report.datasource.DSReportOnEmployeeGradeTotalByDepartment;
import com.pomplatform.client.report.form.ReportOnEmployeeGradeTotalByDepartmentSearchForm;
import com.pomplatform.client.report.form.ReportOnEmployeeGradeTotalByDepartmentViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class ReportOnEmployeeGradeTotalByDepartmentPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ReportOnEmployeeGradeTotalByDepartmentPanel cm = new ReportOnEmployeeGradeTotalByDepartmentPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ReportOnEmployeeGradeTotalByDepartment";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		__needControl = false;
		resultGrid.setShowGridSummary(true);
		resultGrid.setAutoFitFieldWidths(true);
	}

	@Override
	public void initComponents() {
		ListGridField[] fields = new ListGridField[70];
		int idx = 0;
		fields[idx] = new ListGridField("departmentId");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("year");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("a1");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("a2");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("a3");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("a4");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("a5");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("a6");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("a7");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("a8");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("a9");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("a10");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("a11");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("a12");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("a13");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("a14");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("a15");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("a16");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("a17");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("a18");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("a19");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("a20");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("b1");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("b2");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("b3");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("b4");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("b5");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("b6");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("b7");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("b8");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("b9");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("b10");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("b11");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("b12");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("b13");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("b14");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("b15");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("b16");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("b17");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("b18");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("b19");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("b20");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("c1");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("c2");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("c3");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("c4");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("c5");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("c6");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("c7");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("c8");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("c9");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("c10");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("c11");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("c12");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("c13");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("c14");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("c15");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("c16");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("c17");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("c18");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("c19");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("c20");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("otherNum");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("totalNum");
		fields[idx].setShowGridSummary(true);
		idx++;
		resultGrid.setDataSource(DSReportOnEmployeeGradeTotalByDepartment.getInstance());
		resultGrid.setFields(fields);
	}


	@Override
	public boolean checkSearchCriteria(Map criteria) {
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
		return DSReportOnEmployeeGradeTotalByDepartment.getInstance();
	}
	
	@Override
	public int getSearchFormHeight() {
		return 60;
	}


	private int plateId;
	private int year;
	private int month;
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

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	

}

