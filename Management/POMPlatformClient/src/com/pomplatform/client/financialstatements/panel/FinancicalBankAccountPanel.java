package com.pomplatform.client.financialstatements.panel;

import java.util.Date;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.LoadingWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.financialstatements.datasource.DSFinancicalCapitalAnalysis;
import com.pomplatform.client.financialstatements.form.FinancicalCapitalAnalysisSearchForm;
import com.pomplatform.client.financialstatements.form.FinancicalCapitalAnalysisViewer;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridField;

public class FinancicalBankAccountPanel extends AbstractSearchPanel {

	private static final Logger __LOGGER = Logger.getLogger("");
	
	private FinancicalCapitalAnalysisSearchForm form;

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			FinancicalBankAccountPanel cm = new FinancicalBankAccountPanel();
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
		__needControl = false;
		__needPagenation = false;
	}

	@Override
	public void initComponents() {
		resultGrid.setShowGridSummary(true);
		ListGridField [] fields = new ListGridField[18];
		int index = 0;
		fields[index] = new ListGridField("bankAccount");
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
		resultGrid.setHeaderSpans(new HeaderSpan[] { new HeaderSpan("-", new String[] {"bankAccount", "initialBalance"}),
				new HeaderSpan("收到款",
						new String[] {"contractMoney", "rentReceivables", "employeeRepayment",
								"preCollection", "otherReceivables", "internalCollection"}),
				new HeaderSpan("支付款",
						new String[] { "salary", "projectReimbursement", "rentPayment", "assetPurchase", "financingPayment",
								"employeeLoan", "prePayment", "otherPayment", "internalPayment"}),
				new HeaderSpan("-", new String[] {"closingBalance"}) });

		
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
				detail.setTitle("FinancicalCapitalAnalysis");
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
		criteria.put("companyId", getCompanyId());
		criteria.put("opt_type", "analysisBankaccount");
		criteria.put("beginDate", getBeginDate());
		criteria.put("endDate", getEndDate());
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		 return null;
	}
	
	@Override
	public DataSource getDataSource() {
		return DSFinancicalCapitalAnalysis.getInstance();
	}
	
	private Integer companyId;

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	
	private Date BeginDate;
	
	private Date endDate;

	public Date getBeginDate() {
		return BeginDate;
	}

	public void setBeginDate(Date beginDate) {
		BeginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
