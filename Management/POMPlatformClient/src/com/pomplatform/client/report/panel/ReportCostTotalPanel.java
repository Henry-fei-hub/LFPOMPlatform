package com.pomplatform.client.report.panel;

import java.util.Map;
import java.util.logging.Logger;

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
import com.google.gwt.i18n.client.NumberFormat;
import com.pomplatform.client.report.datasource.DSReportCostTotal;
import com.pomplatform.client.report.form.ReportCostTotalSearchForm;
import com.pomplatform.client.report.form.ReportCostTotalViewer;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.GroupStartOpen;
import com.smartgwt.client.types.RecordSummaryFunctionType;
import com.smartgwt.client.types.SummaryFunctionType;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.ListGridSummaryField;
import com.smartgwt.client.widgets.grid.events.CellDoubleClickEvent;
import com.smartgwt.client.widgets.grid.events.CellDoubleClickHandler;

public class ReportCostTotalPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ReportCostTotalPanel cm = new ReportCostTotalPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ReportCostTotal";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid.setShowRowNumbers(false);
		
		ListGridField plateIdField = new ListGridField("plateId");
		plateIdField.setShowGridSummary(false);  
		plateIdField.setShowGroupSummary(true);  
		plateIdField.setIncludeInRecordSummary(false);
		plateIdField.setHidden(true);
		plateIdField.setWidth(130);
		
		ListGridField feeTypeField = new ListGridField("feeType");
		feeTypeField.setShowGroupSummary(false);  
		feeTypeField.setShowGridSummary(false);
		feeTypeField.setIncludeInRecordSummary(false);
		feeTypeField.setWidth(90);
		
		ListGridField januaryField = new ListGridField("january");  
		januaryField.setShowGroupSummary(true);  
		januaryField.setShowGridSummary(true);  
        januaryField.setSummaryFunction(SummaryFunctionType.SUM);
        januaryField.setWidth(130);
        
        ListGridField februaryField = new ListGridField("february");  
        februaryField.setShowGroupSummary(true);  
        februaryField.setShowGridSummary(true);  
        februaryField.setSummaryFunction(SummaryFunctionType.SUM); 
        februaryField.setWidth(130);
        
        ListGridField marchField = new ListGridField("march");  
        marchField.setShowGroupSummary(true);  
        marchField.setShowGridSummary(true);  
        marchField.setSummaryFunction(SummaryFunctionType.SUM); 
        marchField.setWidth(130);
        
        ListGridField aprilField = new ListGridField("april");  
		aprilField.setShowGroupSummary(true);  
		aprilField.setShowGridSummary(true);  
        aprilField.setSummaryFunction(SummaryFunctionType.SUM); 
        aprilField.setWidth(130);
        
        ListGridField mayField = new ListGridField("may");  
		mayField.setShowGroupSummary(true);  
		mayField.setShowGridSummary(true);  
        mayField.setSummaryFunction(SummaryFunctionType.SUM); 
        mayField.setWidth(130);
        
        ListGridField juneField = new ListGridField("june");  
		juneField.setShowGroupSummary(true);  
		juneField.setShowGridSummary(true);  
        juneField.setSummaryFunction(SummaryFunctionType.SUM); 
        juneField.setWidth(130);
        
        ListGridField julyField = new ListGridField("july");  
		julyField.setShowGroupSummary(true);  
		julyField.setShowGridSummary(true);  
        julyField.setSummaryFunction(SummaryFunctionType.SUM); 
        julyField.setWidth(130);
        
        ListGridField augustField = new ListGridField("august");  
		augustField.setShowGroupSummary(true);  
		augustField.setShowGridSummary(true);  
        augustField.setSummaryFunction(SummaryFunctionType.SUM); 
        augustField.setWidth(130);
        
        ListGridField septemberField = new ListGridField("september");  
		septemberField.setShowGroupSummary(true);  
		septemberField.setShowGridSummary(true);  
        septemberField.setSummaryFunction(SummaryFunctionType.SUM); 
        septemberField.setWidth(130);
        
        ListGridField octoberField = new ListGridField("october");  
		octoberField.setShowGroupSummary(true);  
		octoberField.setShowGridSummary(true);  
        octoberField.setSummaryFunction(SummaryFunctionType.SUM); 
        octoberField.setWidth(130);
        
        ListGridField novemberField = new ListGridField("november");  
		novemberField.setShowGroupSummary(true);  
		novemberField.setShowGridSummary(true);  
        novemberField.setSummaryFunction(SummaryFunctionType.SUM); 
        novemberField.setWidth(130);
        
        ListGridField decemberField = new ListGridField("december");  
		decemberField.setShowGroupSummary(true);  
		decemberField.setShowGridSummary(true);  
        decemberField.setSummaryFunction(SummaryFunctionType.SUM); 
        decemberField.setWidth(130);
        
        ListGridSummaryField totalField = new ListGridSummaryField("total", "合计");  
        totalField.setAlign(Alignment.RIGHT);  
        totalField.setRecordSummaryFunction(RecordSummaryFunctionType.SUM);  
        totalField.setSummaryFunction(SummaryFunctionType.SUM);  
        totalField.setShowGridSummary(true);  
        totalField.setShowGroupSummary(true);
        totalField.setWidth(130);
        totalField.setCellFormatter(new CellFormatter() {  
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {  
                if (value == null) return null;  
                try {
                    NumberFormat nf = NumberFormat.getFormat("#,##0.00");  
                    return nf.format(((Number) value).doubleValue());  
                } catch (Exception e) {  
                    return value.toString();  
                }  
            }  
        });
        
        resultGrid.setFields(plateIdField, feeTypeField, januaryField, februaryField, marchField, aprilField, mayField, juneField, julyField, augustField, septemberField, octoberField, novemberField, decemberField, totalField);
        resultGrid.setGroupByField("plateId");  
        resultGrid.setShowGridSummary(true);  
        resultGrid.setShowGroupSummary(true);  
        resultGrid.setShowGroupSummaryInHeader(true); 
        resultGrid.setGroupStartOpen(GroupStartOpen.ALL); 
	}

	@Override
	public void initComponents() {
		 
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});

		resultGrid.addCellDoubleClickHandler(new CellDoubleClickHandler() {
			
			@Override
			public void onCellDoubleClick(CellDoubleClickEvent event) {
				if(event.getColNum() >= 2){
					Record record = event.getRecord();
					ReportCostDetailByMonthPanel panel = new ReportCostDetailByMonthPanel();
					String plateId = record.getAttribute("plateId");
					String year = record.getAttribute("year");
					int month = event.getColNum() - 1;
					panel.setPlateId(plateId);
					panel.setYear(year);
					panel.setMonth(month);
					panel.commonQuery();
					PopupWindow window = new PopupWindow(KeyValueManager.getValue("plate_records", record.getAttribute("plateId")) + year + "年" + month + "月成本明细");
					window.setWidth100();
					window.setHeight100();
					window.addMember(panel);
					window.centerInPage();
					window.show();
				}
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
		
		IButton download = new IButton("导出");
		controlLayout.addMember(download);
		download.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Map<Object, Object> condition = generateCriteria();
				DBDataSource.downloadFile("DW_ReportCostTotal", condition);
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
				detail.setTitle("成本汇总总表"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				ReportCostTotalViewer detailForm = new ReportCostTotalViewer();
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
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new ReportCostTotalSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSReportCostTotal.getInstance();
	}

	@Override
	public int getSearchFormHeight() {
		return 70;
	}
}

