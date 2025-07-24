package com.pomplatform.client.report.panel;

import java.util.ArrayList;
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
import com.pomplatform.client.report.datasource.DSReportOfGenderAnalysisByDepartment;
import com.pomplatform.client.report.form.ReportOfGenderAnalysisByDepartmentSearchForm;
import com.pomplatform.client.report.form.ReportOfGenderAnalysisByDepartmentViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class ReportOfGenderAnalysisByDepartmentPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ReportOfGenderAnalysisByDepartmentPanel cm = new ReportOfGenderAnalysisByDepartmentPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ReportOfGenderAnalysisByDepartment";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		__needControl = false;
	}

	@Override
	public void initComponents() {		
		resultGrid.setHeaderHeight(60);
		resultGrid.setHeaderSpans(new HeaderSpan[] {
			   new HeaderSpan("1月", new String[] {"maleJanuary","maleJanuaryPer","femaleJanuary","femaleJanuaryPer","januaryTotal"}),
			   new HeaderSpan("2月", new String[] {"maleFebruary","maleFebruaryPer","femaleFebruary","femaleFebruaryPer","februaryTotal"}),
			   new HeaderSpan("3月", new String[] {"maleMarch","maleMarchPer","femaleMarch","femaleMarchPer","marchTotal"}),
			   new HeaderSpan("4月", new String[] {"maleApril","maleAprilPer","femaleApril","femaleAprilPer","aprilTotal"}),
			   new HeaderSpan("5月", new String[] {"maleMay","maleMayPer","femaleMay","femaleMayPer","mayTotal"}),
			   new HeaderSpan("6月", new String[] {"maleJune","maleJunePer","femaleJune","femaleJunePer","juneTotal"}),
			   new HeaderSpan("7月", new String[] {"maleJuly","maleJulyPer","femaleJuly","femaleJulyPer","julyTotal"}),
			   new HeaderSpan("8月", new String[] {"maleAugust","maleAugustPer","femaleAugust","femaleAugustPer","augustTotal"}),
			   new HeaderSpan("9月", new String[] {"maleSeptember","maleSeptemberPer","femaleSeptember","femaleSeptemberPer","septemberTotal"}),
			   new HeaderSpan("10月", new String[] {"maleOctober","maleOctoberPer","femaleOctober","femaleOctoberPer","octoberTotal"}),
			   new HeaderSpan("11月", new String[] {"maleNovember","maleNovemberPer","femaleNovember","femaleNovemberPer","novemberTotal"}),
			   new HeaderSpan("12月", new String[] {"maleDecember","maleDecemberPer","femaleDecember","femaleDecemberPer","decemberTotal"})
		    });
		}


	@Override
	public boolean checkSearchCriteria(Map criteria) {
		if (!BaseHelpUtils.isNullOrEmpty(plateId)&&plateId > 0) {
			criteria.put("plateId", plateId);
		}else {
			SC.say("提示", "业务部门不可为空");
			return false;
		}
		if (!BaseHelpUtils.isNullOrEmpty(year)&&year > 0) {
			List<Map> keyvalues = new ArrayList<>();
			Map<String, Object> kv = new HashMap<>();
			kv.put("key", "9999");
			kv.put("value",year);
			keyvalues.add(kv);
			criteria.put("keyValues", keyvalues);
		}else {
			SC.say("提示", "年份不可为空");
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
		return DSReportOfGenderAnalysisByDepartment.getInstance();
	}

	private int year;
	private int plateId;
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getPlateId() {
		return plateId;
	}

	public void setPlateId(int plateId) {
		this.plateId = plateId;
	}
	
	

}

