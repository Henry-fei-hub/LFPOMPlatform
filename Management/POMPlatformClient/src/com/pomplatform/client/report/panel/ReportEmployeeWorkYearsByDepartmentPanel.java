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
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.grid.events.SelectionUpdatedEvent;
import com.smartgwt.client.widgets.grid.events.SelectionUpdatedHandler;
import java.util.Objects;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyListGrid;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.report.datasource.DSReportEmployeeWorkYearsByDepartment;
import com.pomplatform.client.report.form.ReportEmployeeWorkYearsByDepartmentSearchForm;
import com.pomplatform.client.report.form.ReportEmployeeWorkYearsByDepartmentViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class ReportEmployeeWorkYearsByDepartmentPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ReportEmployeeWorkYearsByDepartmentPanel cm = new ReportEmployeeWorkYearsByDepartmentPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ReportEmployeeWorkYearsByDepartment";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid.setCanEdit(false);
		__needControl=false;
	}

	@Override
	public void initComponents() {
		resultGrid.setHeaderHeight(60);
		resultGrid.setHeaderSpans(new HeaderSpan[] {
		   new HeaderSpan("1月", new String[] {"oneInner","oneInnerPercent","threeInner","threeInnerPercent","fiveInner","fiveInnerPercent","tenInner","tenInnerPercent","tenAdd","tenAddPercent","total"}),
		   new HeaderSpan("2月", new String[] {"oneInnerTwo","oneInnerPercentTwo","threeInnerTwo","threeInnerPercentTwo","fiveInnerTwo","fiveInnerPercentTwo","tenInnerTwo","tenInnerPercentTwo","tenAddTwo","tenAddPercentTwo","totalTwo"}),
		   new HeaderSpan("3月", new String[] {"oneInnerThree","oneInnerPercentThree","threeInnerThree","threeInnerPercentThree","fiveInnerThree","fiveInnerPercentThree","tenInnerThree","tenInnerPercentThree","tenAddThree","tenAddPercentThree","totalThree"}),
		   new HeaderSpan("4月", new String[] {"oneInnerFour","oneInnerPercentFour","threeInnerFour","threeInnerPercentFour","fiveInnerFour","fiveInnerPercentFour","tenInnerFour","tenInnerPercentFour","tenAddFour","tenAddPercentFour","totalFour"}),
		   new HeaderSpan("5月", new String[] {"oneInnerFive","oneInnerPercentFive","threeInnerFive","threeInnerPercentFive","fiveInnerFive","fiveInnerPercentFive","tenInnerFive","tenInnerPercentFive","tenAddFive","tenAddPercentFive","totalFive"}),
		   new HeaderSpan("6月", new String[] {"oneInnerSix","oneInnerPercentSix","threeInnerSix","threeInnerPercentSix","fiveInnerSix","fiveInnerPercentSix","tenInnerSix","tenInnerPercentSix","tenAddSix","tenAddPercentSix","totalSix"}),
		   new HeaderSpan("7月", new String[] {"oneInnerSeven","oneInnerPercentSeven","threeInnerSeven","threeInnerPercentSeven","fiveInnerSeven","fiveInnerPercentSeven","tenInnerSeven","tenInnerPercentSeven","tenAddSeven","tenAddPercentSeven","totalSeven"}),
		   new HeaderSpan("8月", new String[] {"oneInnerEight","oneInnerPercentEight","threeInnerEight","threeInnerPercentEight","fiveInnerEight","fiveInnerPercentEight","tenInnerEight","tenInnerPercentEight","tenAddEight","tenAddPercentEight","totalEight"}),
		   new HeaderSpan("9月", new String[] {"oneInnerNine","oneInnerPercentNine","threeInnerNine","threeInnerPercentNine","fiveInnerNine","fiveInnerPercentNine","tenInnerNine","tenInnerPercentNine","tenAddNine","tenAddPercentNine","totalNine"}),
		   new HeaderSpan("10月", new String[] {"oneInnerTen","oneInnerPercentTen","threeInnerTen","threeInnerPercentTen","fiveInnerTen","fiveInnerPercentTen","tenInnerTen","tenInnerPercentTen","tenAddTen","tenAddPercentTen","totalTen"}),
		   new HeaderSpan("11月", new String[] {"oneInnerEleven","oneInnerPercentEleven","threeInnerEleven","threeInnerPercentEleven","fiveInnerEleven","fiveInnerPercentEleven","tenInnerEleven","tenInnerPercentEleven","tenAddEleven","tenAddPercentEleven","totalEleven"}),
		   new HeaderSpan("12月", new String[] {"oneInnerTwelf","oneInnerPercentTwelf","threeInnerTwelf","threeInnerPercentTwelf","fiveInnerTwelf","fiveInnerPercentTwelf","tenInnerTwelf","tenInnerPercentTwelf","tenAddTwelf","tenAddPercentTwelf","totalTwelf"}),
	    });
		}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("optType","onLoadYearEmpWorkYearsByDepartment");
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
	
	//根据行内某字段的值改变行字体颜色
	@Override
	public Canvas generateHDataCanvas() {
		resultGrid = new DelicacyListGrid() {
			@Override
			protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
				Integer[] arr = {1,3,5,7,9,11, 12,14,16,18,20,22, 23,25,27,29,31,33, 34,36,38,40,42,44, 45,47,49,51,53,55, 56,58,60,62,64,66
						, 67,69,71,73,75,77, 78,80,82,84,86,88, 89,91,93,95,97,99, 100,102,104,106,108,110, 111,113,115,117,119,121, 122,124,126,128,130,132};
				List<Integer> list = Arrays.asList(arr);
				if (list.contains(colNum)) {
					return "color: red;";
				} else {
					return super.getCellCSSText(record, rowNum, colNum);
				}
			}
		};
		resultGrid.setDataSource(getDataSource());
		resultGrid.setWidth100();
		resultGrid.setHeight100();
		return resultGrid;
	}


	@Override
	public SearchForm generateSearchForm() {
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSReportEmployeeWorkYearsByDepartment.getInstance();
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

