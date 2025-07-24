package com.pomplatform.client.report.panel;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.report.datasource.DSReportYearEmpWorkYears;
import com.pomplatform.client.report.form.ReportEmployeeWorkYearsSearchForm;
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
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class ReportEmployeeWorkYearsPanel extends AbstractSearchPanel
{

	private static int year;
	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ReportEmployeeWorkYearsPanel cm = new ReportEmployeeWorkYearsPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ReportEmployeeWorkYears";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid.setShowGridSummary(true);
		resultGrid.setCanEdit(false);
		resultGrid.setShowRowNumbers(true); 	
	}

	@Override
	public void initComponents() {
		resultGrid.setShowRowNumbers(true); 
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
				// 获取检索栏的开始日期和结束日期
				PopupWindow pw = new PopupWindow();
				ReportEmployeeWorkYearsByDepartmentPanel panel = new ReportEmployeeWorkYearsByDepartmentPanel();
				pw.addItem(panel);
				panel.setPlateId(plateId);
				panel.setYear(year);
				panel.commonQuery();
				pw.setTitle("业务部门(" + plateName + ")下的司龄分析汇总");
				pw.setWidth100();
				pw.setHeight100();
				pw.centerInPage();
				pw.show();
			}
		});
		
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});
		
		IButton plateGenderNum = new IButton("部门月汇总");
		controlLayout.addMember(plateGenderNum);
		plateGenderNum.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				PopupWindow pw = new PopupWindow();
				ReportOfWorkYearsPlateMonthPanel panel = new ReportOfWorkYearsPlateMonthPanel();
				pw.addItem(panel);
				panel.startEdit();
				pw.setTitle("部门月汇总");
				pw.setWidth100();
				pw.setHeight100();
				pw.centerInPage();
				pw.show();
			}
		});
		
		IButton plateOneNum = new IButton("事业部汇总");
		controlLayout.addMember(plateOneNum);
		plateOneNum.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				PopupWindow pw = new PopupWindow();
				ReportOfWorkYearsPlateMonthPanel panel = new ReportOfWorkYearsPlateMonthPanel();
				pw.addItem(panel);
				panel.setPlateType(1);
				panel.startEdit();
				pw.setTitle("事业部汇总");
				pw.setWidth100();
				pw.setHeight100();
				pw.centerInPage();
				pw.show();
			}
		});
		
		IButton plateTwoNum = new IButton("职能部门汇总");
		controlLayout.addMember(plateTwoNum);
		plateTwoNum.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				PopupWindow pw = new PopupWindow();
				ReportOfWorkYearsPlateMonthPanel panel = new ReportOfWorkYearsPlateMonthPanel();
				pw.addItem(panel);
				panel.setPlateType(2);
				panel.startEdit();
				pw.setTitle("职能部门汇总");
				pw.setWidth100();
				pw.setHeight100();
				pw.centerInPage();
				pw.show();
			}
		});
		
		IButton plateThreeNum = new IButton("营销中心汇总");
		controlLayout.addMember(plateThreeNum);
		plateThreeNum.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				PopupWindow pw = new PopupWindow();
				ReportOfWorkYearsPlateMonthPanel panel = new ReportOfWorkYearsPlateMonthPanel();
				pw.addItem(panel);
				panel.setPlateType(3);
				panel.startEdit();
				pw.setTitle("营销中心汇总");
				pw.setWidth100();
				pw.setHeight100();
				pw.centerInPage();
				pw.show();
			}
		});

		commonQuery();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("optType","onLoadYearEmpWorkYears");
		year=BaseHelpUtils.getIntValue(criteria.get("year"));
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
					return super.getCellCSSText(record, rowNum, colNum);
				} else {
					return "color: red;";
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
		return new ReportEmployeeWorkYearsSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSReportYearEmpWorkYears.getInstance();
	}

	@Override
	public int getSearchFormHeight() {
		return 60;
	}
}

