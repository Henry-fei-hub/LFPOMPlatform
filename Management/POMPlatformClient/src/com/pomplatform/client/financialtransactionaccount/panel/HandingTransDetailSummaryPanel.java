package com.pomplatform.client.financialtransactionaccount.panel;

import java.util.Date;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.financialtransactionaccount.datasource.DSHandingTransDetailSummary;
import com.pomplatform.client.financialtransactionaccount.form.HandingTransDetailSummarySearchForm;
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

public class HandingTransDetailSummaryPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			HandingTransDetailSummaryPanel cm = new HandingTransDetailSummaryPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "HandingTransDetailSummary";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid.setAutoFitFieldWidths(false);
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
		
		IButton viewButton = new IButton("查看详细");
		viewButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		controlLayout.addMember(viewButton);
		
		IButton downloadButton = new IButton("导出");
		downloadButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				Map condition = generateCriteria();
				DBDataSource.downloadFile("DW_HandingTransDetailSummary", condition);
			}
		});
		controlLayout.addMember(downloadButton);
		
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
//				GenericViewWindow detail = new GenericViewWindow();
//				detail.setTitle("经办往来汇总"); 
//				detail.setWidth100(); 
//				detail.setHeight100(); 
//				HandingTransDetailSummaryViewer detailForm = new HandingTransDetailSummaryViewer();
//				detailForm.setParentSearchForm(searchForm);
//				detailForm.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_TAB);
//				detailForm.initComponents();
//				detailForm.viewSelectedData(resultGrid);
//				detail.setContent(detailForm);
//				detail.centerInPage();
//				detail.show();
				PopupWindow window = new PopupWindow("往来明细");
				window.setWidth100();
				window.setHeight100();
				window.centerInPage();
				Map params = generateCriteria();
				Record record = resultGrid.getSelectedRecord();
				TransDetailPanel panel = new TransDetailPanel();
				if(params.containsKey("startDate") && null != params.get("startDate")) {
					panel.setStartDate((Date)params.get("startDate"));
				}
				if(params.containsKey("endDate") && null != params.get("endDate")) {
					panel.setEndDate((Date)params.get("endDate"));
				}
				panel.setAccountId(record.getAttribute("financialTransactionAccountId"));
				panel.setFinancialNo(record.getAttribute("financeNo"));
				panel.setAccountName(record.getAttribute("accountName"));
				panel.setCompanyId(record.getAttribute("companyId"));
				panel.commonQuery();
				window.addMember(panel);
				window.show();
			}
		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		if(!ClientUtil.checkIsHavePermission(ERPPermissionStatic.TRANS_DETAIL_SUMMARY_VIEW_ALL) && ClientUtil.checkIsHavePermission(ERPPermissionStatic.TRANS_DETAIL_SUMMARY_VIEW_DEPARTMENT)) {
			//如果有查看部门数据的权限
			String plateIds = PomPlatformClientUtil.getRolePlateId();
			criteria.put("plateIds", plateIds);
		}
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new HandingTransDetailSummarySearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSHandingTransDetailSummary.getInstance();
	}


}

