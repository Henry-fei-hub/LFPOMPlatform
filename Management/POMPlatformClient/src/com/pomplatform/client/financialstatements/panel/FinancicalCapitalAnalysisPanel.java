package com.pomplatform.client.financialstatements.panel;

import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.LoadingWindow;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.financialstatements.datasource.DSFinancicalCapitalAnalysis;
import com.pomplatform.client.financialstatements.form.FinancicalCapitalAnalysisSearchForm;
import com.pomplatform.client.financialstatements.form.FinancicalCapitalAnalysisViewer;
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
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridField;

public class FinancicalCapitalAnalysisPanel extends AbstractSearchPanel {

	private static final Logger __LOGGER = Logger.getLogger("");
	
	private FinancicalCapitalAnalysisSearchForm form;

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			FinancicalCapitalAnalysisPanel cm = new FinancicalCapitalAnalysisPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "FinancicalCapitalAnalysis";
		}

	}

	@Override
	public void init() {
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid.setAutoFitFieldWidths(false);
	}

	@Override
	public void initComponents() {
		resultGrid.setShowGridSummary(true);
		ListGridField [] fields = new ListGridField[18];
		int index = 0;
		fields[index] = new ListGridField("companyId");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("initialBalance");
		index ++;
		fields[index] = new ListGridField("contractMoney");
		index ++;
		fields[index] = new ListGridField("rentReceivables");
		index ++;
//		fields[index] = new ListGridField("financingReceivables");
//		index ++;
		fields[index] = new ListGridField("employeeRepayment");
		index ++;
		fields[index] = new ListGridField("preCollection");
		index ++;
		fields[index] = new ListGridField("otherReceivables");
		index ++;
		fields[index] = new ListGridField("internalCollection");
		index ++;
		fields[index] = new ListGridField("projectReimbursement");
		index ++;
		fields[index] = new ListGridField("employeeLoan");
		index ++;
		fields[index] = new ListGridField("prePayment");
		index ++;
		fields[index] = new ListGridField("otherPayment");
		index ++;
		fields[index] = new ListGridField("internalPayment");
		index ++;
		fields[index] = new ListGridField("closingBalance");
		resultGrid.setHeaderHeight(60);
		resultGrid.setFields(fields);
		resultGrid.setHeaderSpans(new HeaderSpan[] { new HeaderSpan("-", new String[] {"companyId", "initialBalance"}),
				new HeaderSpan("收到款",
						new String[] {"contractMoney", "rentReceivables", "employeeRepayment",
								"preCollection", "otherReceivables", "internalCollection"}),
				new HeaderSpan("支付款",
						new String[] { "salary", "projectReimbursement", "rentPayment", "assetPurchase", "financingPayment",
								"employeeLoan", "prePayment", "otherPayment", "internalPayment"}),
				new HeaderSpan("-", new String[] {"closingBalance"}) });

		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				showDetail();
			}
		});
		IButton showContractMoneyBtn = new IButton("查看项目收款");
		controlLayout.addMember(showContractMoneyBtn);
		showContractMoneyBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(resultGrid.anySelected()){
					Record record = resultGrid.getSelectedRecord();
					ScapitalipcorPanel panel = new ScapitalipcorPanel();
					panel.setCompanyId(record.getAttributeAsInt("companyId"));
					panel.setMinHappenDate(form.getValuesAsRecord().getAttributeAsDate("beginDate"));
					panel.setMaxHappenDate(form.getValuesAsRecord().getAttributeAsDate("endDate"));
					panel.commonQuery();
					PopupWindow pw = new PopupWindow();
					panel.setParentCanvas(pw);
					pw.addItem(panel);
					pw.setTitle("合同收款详情");
					pw.setWidth("60%");
					pw.setHeight("80%");
					pw.centerInPage();
					pw.show();
				}else{
					SC.say("请选择一条数据");
				}
				
			}
		});
		IButton showBankMoneyBtn = new IButton("查看账号详细");
		controlLayout.addMember(showBankMoneyBtn);
		showBankMoneyBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(resultGrid.anySelected()){
					Record record = resultGrid.getSelectedRecord();
					FinancicalBankAccountPanel panel = new FinancicalBankAccountPanel();
					panel.setCompanyId(record.getAttributeAsInt("companyId"));
					panel.setBeginDate(form.getValuesAsRecord().getAttributeAsDate("beginDate"));
					panel.setEndDate(form.getValuesAsRecord().getAttributeAsDate("endDate"));
					panel.commonQuery();
					PopupWindow pw = new PopupWindow();
					panel.setParentCanvas(pw);
					pw.addItem(panel);
					pw.setTitle("账号收支详情");
					pw.setWidth("80%");
					pw.setHeight("80%");
					pw.centerInPage();
					pw.show();
				}else{
					SC.say("请选择一条数据");
				}
				
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
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("详情");
				detail.setWidth100();
				detail.setHeight100();
				FinancicalCapitalAnalysisViewer detailForm = new FinancicalCapitalAnalysisViewer();
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

	public void commonQuery() {
        Map condition = generateCriteria();
        if (condition == null) {
            return;
        }
        if (searchForm != null) {
            searchButton.setIcon("loading38.gif");
        }
        DBDataSource ds = (DBDataSource) getDataSource();
        String operationName = ds.getActionMode() + ds.getActionName();
        final LoadingWindow loading = new LoadingWindow();
        DBDataSource.callOperation(operationName, "find", condition, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
            	loading.destroy();
                if (searchForm != null) {
                    searchButton.setIcon("[SKIN]/actions/search.png");
                }
                if (dsResponse.getStatus() >= 0) {
                    resultGrid.setData(dsResponse.getData());
                    afterDataReceived(dsResponse.getData());
                    if (isNeedPagenation() && pager != null) {
                        if (currentPage == 1) {
                            totalPages = dsResponse.getAttributeAsInt("totalPages");
                            pager.getTotalPages().setContents(String.valueOf(totalPages));
                        }
                    }
                } else {
                    SC.say(dsResponse.getErrors().get("errorMsg").toString());
                }
                if (showPagination() && pager != null) {
                    pager.getCurrentPage().setContents(String.valueOf(currentPage));
                }
            }
        });
    }
	
	@Override
	public boolean checkSearchCriteria(Map criteria) {
		__LOGGER.info(criteria.toString());
		if(null != criteria.get("companyId")){
			String str = criteria.get("companyId").toString();
			criteria.put("companyIds", str.toString().substring(1, str.length() - 1));
		}
		criteria.put("opt_type", "analysisCapitals");
		__LOGGER.info(criteria.toString());
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		 form = new FinancicalCapitalAnalysisSearchForm();
		 return form;
	}
	
	@Override
	public int getSearchFormHeight() {
		return 60;
	}

	@Override
	public DataSource getDataSource() {
		return DSFinancicalCapitalAnalysis.getInstance();
	}

}
