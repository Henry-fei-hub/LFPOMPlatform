package com.pomplatform.client.payment.panel;

import java.util.Map;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.payment.datasource.DSOnSalaryTaxData;
import com.pomplatform.client.payment.form.OnSalaryTotalDataSearchForm;
import com.pomplatform.client.payment.form.OnSalaryTotalDataViewer;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.HeaderSpan;

public class OnSalaryTaxDataPanel extends AbstractSearchPanel
{

	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			OnSalaryTaxDataPanel cm = new OnSalaryTaxDataPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OnSalaryTotalData";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid.setShowRowNumbers(true);
		resultGrid.setAutoFitFieldWidths(true);
		resultGrid.setShowGridSummary(true);
	}

	@Override
	public void initComponents() {
		resultGrid.setHeaderHeight(60);
		resultGrid.setHeaderSpans(new HeaderSpan[] {
		   new HeaderSpan("个人社会保险", new String[] {"personalPension","personalMedicalInsurance","personalLargeMedicalInsurance","personalSeriousIllInsurance","personalUnemploymentInsurance","personalHeating","totalInsurance"}),
		   new HeaderSpan("专项扣除", new String[] {"specialDuduct1","specialDuduct2","specialDuduct3","specialDuduct4","specialDuduct5","specialDuduct6","specialAdditionalDuduct","specialDuductSum"})
	    });
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});
		IButton exportBtn = new IButton("导出");
		controlLayout.addMember(exportBtn);
		exportBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				DBDataSource.downloadFile("DW_OnSalaryTotalData", generateCriteria());
			}
		});
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
				detail.setTitle("工资总表"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				OnSalaryTotalDataViewer detailForm = new OnSalaryTotalDataViewer();
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
	public int getSearchFormHeight() {
		return 60;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new OnSalaryTotalDataSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSOnSalaryTaxData.getInstance();
	}


}

