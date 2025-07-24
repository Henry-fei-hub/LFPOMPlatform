package com.pomplatform.client.onrevenue.panel;

import java.util.Map;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractExpansionRelatedPage;
import com.delicacy.client.ui.GenericViewWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.onrevenue.datasource.DSRevenueYearRecordOfRevenue;
import com.pomplatform.client.onrevenue.datasource.DSRevenueYearRecordOfRevenueChild;
import com.pomplatform.client.onrevenue.form.RevenueYearRecordOfRevenueSearchForm;
import com.pomplatform.client.onrevenue.form.RevenueYearRecordOfRevenueViewer;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;

public class RevenueYearRecordTotalOfRevenuePanel extends AbstractExpansionRelatedPage
{


	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			RevenueYearRecordTotalOfRevenuePanel cm = new RevenueYearRecordTotalOfRevenuePanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "RevenueYearRecordOfRevenue";
		}

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

		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				showDetail();
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
				detail.setTitle("年度营收"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				RevenueYearRecordOfRevenueViewer detailForm = new RevenueYearRecordOfRevenueViewer();
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
		criteria.put("parentId",0);
		criteria.put("flag",1);
		criteria.put("addtionalCondition", "order by revenue_year_record_id");
		return true;
	}
	
	@Override
	public int getSearchFormHeight() {
		return 60;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new RevenueYearRecordOfRevenueSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSRevenueYearRecordOfRevenue.getInstance();
	}

	@Override
	public DataSource getChildDataSource() {
		return DSRevenueYearRecordOfRevenueChild.getInstance();
	}


}

