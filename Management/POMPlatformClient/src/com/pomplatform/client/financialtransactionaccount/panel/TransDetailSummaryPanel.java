package com.pomplatform.client.financialtransactionaccount.panel;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.Print;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.financialtransactionaccount.datasource.DSTransDetailSummary;
import com.pomplatform.client.financialtransactionaccount.form.TransDetailSummarySearchForm;
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
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;

public class TransDetailSummaryPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			TransDetailSummaryPanel cm = new TransDetailSummaryPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "TransDetailSummary";
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
		
		IButton disableReimbursableButton = new IButton("禁用借款预付款");
		disableReimbursableButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				if(!resultGrid.anySelected()) {
					SC.say("请选择需要禁用的账户");
					return;
				}
				Record selected = resultGrid.getSelectedRecord();
				if(BaseHelpUtils.getIntValue(selected.getAttribute("accountType")) != ClientStaticUtils.FINANCIAL_ACCOUNT_TYPE_EMPLOYEE) {
					SC.say("该账户不是职员账户，无法禁用");
					return;
				}
				if(!selected.getAttributeAsBoolean("reimbursable")) {
					SC.say("该账户已被禁用");
					return;
				}
				Map params = selected.toMap();
				params.put("reimbursable", false);
				DBDataSource.callOperation("ST_FinancialTransactionAccount", "update", params, new DSCallback() {
					
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0) {
							SC.say("禁用成功");
							selected.setAttribute("reimbursable", false);
							resultGrid.redraw();
						}
					}
				});
			}
		});
		controlLayout.addMember(disableReimbursableButton);
		
		IButton enableReimbursableButton = new IButton("解禁借款预付款");
		enableReimbursableButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				if(!resultGrid.anySelected()) {
					SC.say("请选择需要解禁的账户");
					return;
				}
				Record selected = resultGrid.getSelectedRecord();
				if(BaseHelpUtils.getIntValue(selected.getAttribute("accountType")) != ClientStaticUtils.FINANCIAL_ACCOUNT_TYPE_EMPLOYEE) {
					SC.say("该账户不是职员账户，无需解禁");
					return;
				}
				if(selected.getAttributeAsBoolean("reimbursable")) {
					SC.say("该账户未被禁用，无需解禁");
					return;
				}
				Map params = selected.toMap();
				params.put("reimbursable", true);
				DBDataSource.callOperation("ST_FinancialTransactionAccount", "update", params, new DSCallback() {
					
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0) {
							SC.say("解禁成功");
							selected.setAttribute("reimbursable", true);
							resultGrid.redraw();
						}
					}
				});
			}
		});
		controlLayout.addMember(enableReimbursableButton);
		
		IButton printButton = new IButton("打印汇总表");
		printButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				Record[] records = resultGrid.getRecords();
				if(null == records || records.length == 0) {
					SC.say("没有数据可供打印");
					return;
				}
				Map<String, Object> map = new HashMap<>();
				map.put("records", records);
				TransDetailSummaryPrintPanel print = new TransDetailSummaryPrintPanel();
				print.setPrintData(map);
				Print.it(print.generatePrintHTML());
			}
		});
		controlLayout.addMember(printButton);
		
		IButton downloadButton = new IButton("导出");
		downloadButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				Map condition = generateCriteria();
				DBDataSource.downloadFile("DW_TransDetailSummary", condition);
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
//				detail.setTitle("往来模块汇总"); 
//				detail.setWidth100(); 
//				detail.setHeight100(); 
//				TransDetailSummaryViewer detailForm = new TransDetailSummaryViewer();
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
		criteria.put("deleteFlag", ClientStaticUtils.NO_DELETE);
		if(!ClientUtil.checkIsHavePermission(ERPPermissionStatic.TRANS_DETAIL_SUMMARY_VIEW_ALL) && ClientUtil.checkIsHavePermission(ERPPermissionStatic.TRANS_DETAIL_SUMMARY_VIEW_DEPARTMENT)) {
			//如果有查看部门数据的权限
			String plateIds = PomPlatformClientUtil.getRolePlateId();
			criteria.put("plateIds", plateIds);
		}
		criteria.put("addtionalCondition", "order by financial_transaction_account_id");
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new TransDetailSummarySearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSTransDetailSummary.getInstance();
	}


}

