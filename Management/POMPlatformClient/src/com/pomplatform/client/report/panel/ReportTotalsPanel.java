package com.pomplatform.client.report.panel;

import java.util.Date;
import java.util.HashMap;
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
import com.delicacy.client.ui.LoadingWindow;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.report.datasource.DSReportTotals;
import com.pomplatform.client.report.form.ReportTotalsSearchForm;
import com.pomplatform.client.report.form.ReportTotalsViewer;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.events.CellClickEvent;
import com.smartgwt.client.widgets.grid.events.CellClickHandler;
import com.smartgwt.client.widgets.grid.events.CellDoubleClickEvent;
import com.smartgwt.client.widgets.grid.events.CellDoubleClickHandler;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;

public class ReportTotalsPanel extends AbstractSearchPanel
{
	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ReportTotalsPanel cm = new ReportTotalsPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ReportTotals";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid.setShowGridSummary(true);
		resultGrid.setCanEdit(true);
		__needViewPage = false;
	}

	@Override
	public void initComponents() {
		resultGrid.setHeaderHeight(60);
		resultGrid.setHeaderSpans(new HeaderSpan[] {
			new HeaderSpan("本月现金流",new String[] {"monthCapitalPlate","monthCapitalProject"}),
			new HeaderSpan("累计现金流",new String[] {"totalCapitalPlate","totalCapitalProject"}),
			new HeaderSpan("本月确认积分",new String[] {"monthSureIntegralPlate","monthSureIntegralProject"}),
			new HeaderSpan("累计确认积分",new String[] {"totalSureIntegralPlate","totalSureIntegralProject"}),
			new HeaderSpan("本月成本",new String[] {"monthCostPlate","monthCostProject","monthCostProjectBefore"}),
			new HeaderSpan("累计成本",new String[] {"totalCostPlate","totalCostProject","totalCostProjectBefore"}),
			new HeaderSpan("年度指标",new String[] {"minEmpNum","yearAverageEmpRevenue","yearCapital","benefit","yearRevenue"})
		});
		
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});
		
		IButton accountButton = new IButton("统计");
		controlLayout.addMember(accountButton);
		accountButton.addClickHandler(new ClickHandler() {
			@SuppressWarnings({ "rawtypes"})
			@Override
			public void onClick(ClickEvent event) {
				Map<String,Object> params = new HashMap<>();
				Map condition = generateCriteria();
				//获取年份
				int year = BaseHelpUtils.getIntValue(condition,"year");
				if(year == 0){
					SC.say("提示","请选择统计的年份");
					return;
				}
				params.put("year", year);
				params.put("optType", "onAccountReportTotal");
				final LoadingWindow loading = new LoadingWindow();
				DBDataSource.callOperation("EP_OnReportProcess","find", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						loading.destroy();
						if(dsResponse.getStatus() >= 0){
							commonQuery();
						}
					}
				});
			}
		});

		IButton exportButton = new IButton("导出");
		exportButton.addClickHandler(new ClickHandler(){
			@SuppressWarnings("rawtypes")
			@Override
			public void onClick(ClickEvent event) {
				Map condition = generateCriteria();
				DBDataSource.downloadFile("DW_OnDownloadReportTotals", condition);
			}
		});
		controlLayout.addMember(exportButton);
		
		resultGrid.addEditCompleteHandler(new EditCompleteHandler() {
			
			@SuppressWarnings("unchecked")
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				Map<String,Object> params = resultGrid.getRecord(event.getRowNum()).toMap();
				DBDataSource.callOperation("ST_ReportTotal","saveOrUpdate", params, new DSCallback() {
					
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0){
							commonQuery();
						}
					}
				});
			}
		});
		
		resultGrid.addCellClickHandler(new CellClickHandler() {
			
			@Override
			public void onCellClick(CellClickEvent event) {
				int colNum = event.getColNum();
				Record record = resultGrid.getRecord(event.getRowNum());
				if(colNum > 2 && colNum < 23){
					int plateId = record.getAttributeAsInt("plateId");
					int year = record.getAttributeAsInt("year");
					PopupWindow window = new PopupWindow();
					if(colNum == 3){//本月不含税应收
						ReportOfSumRevenueYearRecordDetailPanel panel1 = new ReportOfSumRevenueYearRecordDetailPanel();
						panel1.setPlateId(plateId);
						panel1.setYear(year);
						panel1.startEdit();
						window.addItem(panel1);
						window.setTitle("营收统计详情表");
					}else if(colNum == 4){//累计不含税营收 
						ReportOfSumRevenueYearRecordsPanel panel2 = new ReportOfSumRevenueYearRecordsPanel();
						window.addItem(panel2);
						window.setTitle("累计不含税营收表");
					}else if(colNum == 5){//本月现金流部门 
						ReportCapitaDepartmentDetailPanel panel3 = new ReportCapitaDepartmentDetailPanel();
						panel3.setPlateId(plateId);
			    		panel3.setYear(year);
			    		panel3.startEdit();
			    		window.setTitle("现金流详情表(部门)");
			    		window.addItem(panel3);
					}else if(colNum == 6){//本月现金流项目组 
						ReportCapitaProjectDetailPanel panel4 = new ReportCapitaProjectDetailPanel();
						panel4.setPlateId(plateId);
			    		panel4.setYear(year);
			    		panel4.startEdit();
			    		window.setTitle("现金流详情表(项目组)");
			    		window.addItem(panel4);
					}else if(colNum == 7 || colNum == 8){//累计现金流 
						ReportCapitalTotalPanel panel5 = new ReportCapitalTotalPanel();
						window.setTitle("累计现金流");
			    		window.addItem(panel5);
					}else if(colNum == 9 || colNum == 10){//本月确认积分
						ReportSureIntegralDetailPanel panel6 = new ReportSureIntegralDetailPanel();
						panel6.setPlateId(plateId);
			    		panel6.setYear(year);
			    		panel6.startEdit();
			    		window.setTitle("确认积分详情表");
			    		window.addItem(panel6);
					}else if(colNum == 11 || colNum == 12){//累计确认积分
						ReportSureIntegralTotalPanel panel7 = new ReportSureIntegralTotalPanel();
			    		window.setTitle("累计确认积分");
			    		window.addItem(panel7);
					}else if(colNum == 13 || colNum == 14){//本月薪酬
						ReportOfSalaryTotalPanel panel8 = new ReportOfSalaryTotalPanel();
			    		window.setTitle("薪酬表");
			    		window.addItem(panel8);
					}else if(colNum == 15 || colNum == 16 || colNum == 17){//本月成本
						ReportCostDetailByMonthPanel panel9 = new ReportCostDetailByMonthPanel();
						Date currentDate = new Date();
						int month = currentDate.getMonth()+1;
						panel9.setPlateId(plateId+"");
						panel9.setYear(year+"");
						panel9.setMonth(month);
						panel9.commonQuery();
						window.setTitle(KeyValueManager.getValue("plate_records", record.getAttribute("plateId")) + year + "年" + month + "月成本明细");
						window.addMember(panel9);
					}else if(colNum == 18 || colNum == 19 || colNum == 20){//累计成本
						ReportCostTotalPanel panel10 = new ReportCostTotalPanel();
						window.setTitle("累计成本");
						window.addMember(panel10);
					}else if(colNum == 21 || colNum == 22){//新签合同额
						ReportNewContractTotalPanel panel11 = new ReportNewContractTotalPanel();
						window.setTitle("新签合同额");
						window.addMember(panel11);
					}
					window.setWidth100();
					window.setHeight100();
					window.centerInPage();
					window.show();
				}	
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
				detail.setTitle("ReportTotals"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				ReportTotalsViewer detailForm = new ReportTotalsViewer();
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
	public void commonQuery() {
		currentPage = 0;
		super.commonQuery();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean checkSearchCriteria(Map criteria) {
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new ReportTotalsSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSReportTotals.getInstance();
	}

	@Override
	public int getSearchFormHeight() {
		return 60;
	}
	
}

