package com.pomplatform.client.report.panel;

import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PopupWindow;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.pomplatform.client.payment.panel.MonthPaymentDesignPanel;
import com.pomplatform.client.report.datasource.DSReportOfGenderAnalysis;
import com.pomplatform.client.report.form.ReportOfGenderAnalysisSearchForm;
import com.pomplatform.client.report.form.ReportOfGenderAnalysisViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class ReportOfGenderAnalysisPanel extends AbstractSearchPanel
{

	private static int year;
	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ReportOfGenderAnalysisPanel cm = new ReportOfGenderAnalysisPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ReportOfGenderAnalysis";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid.setShowGridSummary(true);
		resultGrid.setCanEdit(true);
		
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
		
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});

		IButton viewButton = new IButton("查看详细");
		viewButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		controlLayout.addMember(viewButton);
		
		IButton plateGenderNum = new IButton("部门月汇总");
		controlLayout.addMember(plateGenderNum);
		plateGenderNum.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				PopupWindow pw = new PopupWindow();
				ReportOfGenderPlateMonthPanel panel = new ReportOfGenderPlateMonthPanel();
				pw.addItem(panel);
				panel.startEdit();
				pw.setTitle("部门月汇总");
				pw.setWidth100();
				pw.setHeight100();
				pw.centerInPage();
				pw.show();
			}
		});
		
		IButton plateSumButton = new IButton("事业部汇总");
		controlLayout.addMember(plateSumButton);
		plateSumButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				PopupWindow pw = new PopupWindow();
				ReportOfGenderPlateMonthPanel panel = new ReportOfGenderPlateMonthPanel();
				pw.addItem(panel);
				panel.setPlateType(1);//事业部
				panel.startEdit();
				pw.setTitle("事业部汇总");
				pw.setWidth100();
				pw.setHeight100();
				pw.centerInPage();
				pw.show();
			}
		});
		
		IButton plateSumButton2 = new IButton("职能部门汇总");
		controlLayout.addMember(plateSumButton2);
		plateSumButton2.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				PopupWindow pw = new PopupWindow();
				ReportOfGenderPlateMonthPanel panel = new ReportOfGenderPlateMonthPanel();
				pw.addItem(panel);
				panel.setPlateType(2);//职能部门
				panel.startEdit();
				pw.setTitle("职能部门汇总");
				pw.setWidth100();
				pw.setHeight100();
				pw.centerInPage();
				pw.show();
			}
		});
		
		IButton plateSumButton3 = new IButton("营销中心汇总");
		controlLayout.addMember(plateSumButton3);
		plateSumButton3.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				PopupWindow pw = new PopupWindow();
				ReportOfGenderPlateMonthPanel panel = new ReportOfGenderPlateMonthPanel();
				pw.addItem(panel);
				panel.setPlateType(3);//营销中心
				panel.startEdit();
				pw.setTitle("营销中心汇总");
				pw.setWidth100();
				pw.setHeight100();
				pw.centerInPage();
				pw.show();
			}
		});
		
		IButton checkButton = new IButton("业务部门分析汇总");
		controlLayout.addMember(checkButton);
		checkButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
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
					ReportOfGenderAnalysisByDepartmentPanel panel = new ReportOfGenderAnalysisByDepartmentPanel();
					pw.addItem(panel);
					panel.setPlateId(plateId);
					panel.setYear(year);
//					panel.initComponents();
					panel.commonQuery();
					pw.setTitle("业务部门(" + plateName + ")下的性别分析汇总");
					pw.setWidth100();
					pw.setHeight100();
					pw.centerInPage();
					pw.show();
			}
		});
		
		resultGrid.addEditCompleteHandler(new EditCompleteHandler() {
			
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				Record record = resultGrid.getRecord(event.getRowNum());
				BigDecimal maleProportion = BigDecimal.ZERO;
				BigDecimal femaleProportion = BigDecimal.ZERO;
				if(!BaseHelpUtils.isNullOrEmpty(record.getAttribute("maleProportionStr"))){
					maleProportion = BaseHelpUtils.getBigDecimalValue(record.getAttribute("maleProportionStr").split("%")[0]);
				}
				if(!BaseHelpUtils.isNullOrEmpty(record.getAttribute("femaleProportionStr"))){
					femaleProportion = BaseHelpUtils.getBigDecimalValue(record.getAttribute("femaleProportionStr").split("%")[0]);
				}
				Map<String,Object> params = new HashMap<>();
				params.put("genderProportionId", record.getAttribute("genderProportionId"));
				params.put("plateId", record.getAttribute("plateId"));
				params.put("maleProportionStr", record.getAttribute("maleProportionStr"));
				params.put("femaleProportionStr", record.getAttribute("femaleProportionStr"));
				params.put("maleProportion", maleProportion);
				params.put("femaleProportion", femaleProportion);
				DBDataSource.callOperation("ST_GenderProportion","saveOrUpdate", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0){
							commonQuery();
						}
					}
				});
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
				detail.setTitle("性别分析"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				ReportOfGenderAnalysisViewer detailForm = new ReportOfGenderAnalysisViewer();
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
		List<Map> keyvalues = new ArrayList<>();
		Map<String, Object> kv = new HashMap<>();
    	kv.put("key", "9999");
    	kv.put("value",BaseHelpUtils.getIntValue( criteria.get("year")));
    	keyvalues.add(kv);
    	criteria.put("keyValues", keyvalues);
    	
    	year=BaseHelpUtils.getIntValue(criteria.get("year"));
    	
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new ReportOfGenderAnalysisSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSReportOfGenderAnalysis.getInstance();
	}

	@Override
	public int getSearchFormHeight() {
		return 60;
	}
}

