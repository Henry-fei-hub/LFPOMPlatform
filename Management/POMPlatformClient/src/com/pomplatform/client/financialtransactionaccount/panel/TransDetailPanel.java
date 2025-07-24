package com.pomplatform.client.financialtransactionaccount.panel;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.Print;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.ViewProcessWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.i18n.client.NumberFormat;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.financialtransactionaccount.datasource.DSTransDetail;
import com.pomplatform.client.financialtransactionaccount.form.NewTransDetailForm;
import com.pomplatform.client.financialtransactionaccount.form.TransDetailSearchForm;
import com.pomplatform.client.financialtransactionaccount.form.TransDetailViewer;
import com.pomplatform.client.financialtransactionaccount.form.UpdateFinancialAccountInitAmountForm;
import com.pomplatform.client.financialtransactionaccount.form.UpdateTransDetailForm;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class TransDetailPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	private Date startDate;
	private Date endDate;
	private String accountId;
	private String accountName;
	private String financialNo;
	private String companyId;
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			TransDetailPanel cm = new TransDetailPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "TransDetail";
		}

	}

	
	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		
		resultGrid = new DelicacyListGrid(){
			@Override
			protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
				if (null == record.getAttribute("isCompleted") || record.getAttribute("isCompleted").equals("false")) {  
					//流程未完成，标红色
					return "color:#D11212;";  
                } else if(null != record.getAttribute("isHumanAdd") && record.getAttribute("isHumanAdd").equals("true")) {
                	//人为添加的数据，表绿色
                	return "color:#219B23;";
                }else{
                	return super.getCellCSSText(record, rowNum, colNum); 
                }
			}
		};
		resultGrid.setDataSource(getDataSource());
    	resultGrid.setShowRowNumbers(true);
		resultGrid.setAutoFitFieldWidths(false);
	}

	@Override
	public void initComponents() {
		ListGridField[] fields = new ListGridField[11];
		int idx = 0;
		fields[idx++] = new ListGridField("companyId");
		fields[idx++] = new ListGridField("accountType");
		fields[idx++] = new ListGridField("financeNo");
		fields[idx++] = new ListGridField("accountName");
		fields[idx++] = new ListGridField("accountStatus");
		fields[idx++] = new ListGridField("recordDate");
		fields[idx++] = new ListGridField("summary");
		fields[idx++] = new ListGridField("standardDebit");
		fields[idx++] = new ListGridField("standardCredit");
		fields[idx] = new ListGridField("balanceDebit", "余额借");
		fields[idx].setAlign(Alignment.RIGHT);
		fields[idx].setCellFormatter(new CellFormatter() {
			
			@Override
			public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
				BigDecimal topBalance = BigDecimal.ZERO;
				BigDecimal balance = BaseHelpUtils.getBigDecimalValue(record.getAttribute("standardDebit")).subtract(BaseHelpUtils.getBigDecimalValue(record.getAttribute("standardCredit")));
				if(rowNum > 0){
					Record tempRecord = resultGrid.getRecord(rowNum - 1);
					topBalance = BaseHelpUtils.getBigDecimalValue(tempRecord.getAttribute("balanceDebit")).subtract(BaseHelpUtils.getBigDecimalValue(tempRecord.getAttribute("balanceCredit")));
				}
				balance = topBalance.add(balance);
				if(balance.compareTo(BigDecimal.ZERO) < 0) {
					balance = BigDecimal.ZERO;
				}
				NumberFormat nf = NumberFormat.getFormat("#,###,###,###,###,##0.00");
				record.setAttribute("balanceDebit", balance.toString());
				return nf.format(balance);
			}
		});
		idx++;
		fields[idx] = new ListGridField("balanceCredit", "余额贷");
		fields[idx].setAlign(Alignment.RIGHT);
		fields[idx].setCellFormatter(new CellFormatter() {
			
			@Override
			public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
				BigDecimal topBalance = BigDecimal.ZERO;
				BigDecimal balance = BaseHelpUtils.getBigDecimalValue(record.getAttribute("standardCredit")).subtract(BaseHelpUtils.getBigDecimalValue(record.getAttribute("standardDebit")));
				if(rowNum > 0){
					Record tempRecord = resultGrid.getRecord(rowNum - 1);
					topBalance = BaseHelpUtils.getBigDecimalValue(tempRecord.getAttribute("balanceCredit")).subtract(BaseHelpUtils.getBigDecimalValue(tempRecord.getAttribute("balanceDebit")));
				}
				balance = topBalance.add(balance);
				if(balance.compareTo(BigDecimal.ZERO) < 0) {
					balance = BigDecimal.ZERO;
				}
				NumberFormat nf = NumberFormat.getFormat("#,###,###,###,###,##0.00");
				record.setAttribute("balanceCredit", balance.toString());
				return nf.format(balance);
			}
		});
		resultGrid.setFields(fields);
		
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
				showWorkFlowInfo();
			}
		});
		
		IButton operation1Button = new IButton("查看详情");
		controlLayout.addMember(operation1Button);
		operation1Button.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		
		IButton initButton = PermissionControl.createPermissionButton("设置期初余额", ERPPermissionStatic.TRANS_DETAILS_INIT);
		controlLayout.addMember(initButton);
		initButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				Record r = new Record();
				r.setAttribute("financialTransactionAccountId", accountId);
				UpdateFinancialAccountInitAmountForm detailForm = new UpdateFinancialAccountInitAmountForm();
				detailForm.setTitle("设置期初余额");
				detailForm.addDataEditedHandler(new DataEditedHandler(){
					@Override
					public void onDataEdited(DataEditEvent event) {
						commonQuery();
					}
				});
				detailForm.setSearchForm(searchForm);
				detailForm.setRecord(r);
				detailForm.setCurrentPage(getCurrentPage());
				detailForm.initComponents();
				detailForm.startEdit();
				detailForm.setWidth("40%");
				detailForm.setHeight("80%");
				detailForm.centerInPage();
				detailForm.show();
				setCurrentPage(detailForm.getCurrentPage());
			}
		});
		
		IButton operation2Button = PermissionControl.createPermissionButton("新建", ERPPermissionStatic.TRANS_DETAILS_CREATE_BUTTON);
		controlLayout.addMember(operation2Button);
		operation2Button.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
					@Override
					public void onSuccess() {
						Record record = new Record();
						record.setAttribute("financialTransactionAccountId", accountId);
						record.setAttribute("operatorAccountId", accountId);
						NewTransDetailForm detailForm = new NewTransDetailForm();
						detailForm.setTitle("新建");
						detailForm.addDataEditedHandler(new DataEditedHandler(){
							@Override
							public void onDataEdited(DataEditEvent event) {
								commonQuery();
							}
						});
						detailForm.setSearchForm(searchForm);
						detailForm.setRecord(record);
						detailForm.initComponents();
						detailForm.startEdit();
						detailForm.setWidth("40%");
						detailForm.setHeight("80%");
						detailForm.centerInPage();
						detailForm.show();
					}
				});
			}
		});
		
		IButton operation3Button = PermissionControl.createPermissionButton("修改", ERPPermissionStatic.TRANS_DETAILS_UPDATE_BUTTON);
		controlLayout.addMember(operation3Button);
		operation3Button.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){ SC.say("请选择一条数据修改"); return;}
						final ListGridRecord selected1 = resultGrid.getSelectedRecord();
						if(selected1.getAttributeAsBoolean("isHumanAdd")) {
							Record record = new Record();
							record.setAttribute("financialTransactionDetailId", selected1.getAttribute("financialTransactionDetailId"));
							UpdateTransDetailForm detailForm = new UpdateTransDetailForm();
							detailForm.setTitle("修改");
							detailForm.addDataEditedHandler(new DataEditedHandler(){
								@Override
								public void onDataEdited(DataEditEvent event) {
									commonQuery();
								}
							});
							detailForm.setSearchForm(searchForm);
							detailForm.setRecord(record);
							detailForm.setCurrentPage(getCurrentPage());
							detailForm.initComponents();
							detailForm.startEdit();
							detailForm.setWidth("40%");
							detailForm.setHeight("80%");
							detailForm.centerInPage();
							detailForm.show();
							setCurrentPage(detailForm.getCurrentPage());
						}else {
							SC.say("系统数据，不允许修改");
						}
					}
				});
			}
		});
		
		IButton removeButton = PermissionControl.createPermissionButton("删除", ERPPermissionStatic.TRANS_DETAILS_DELETE_BUTTON);
		controlLayout.addMember(removeButton);
		removeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("请选择需要删除的数据");
				}
				final ListGridRecord selected = resultGrid.getSelectedRecord();
				if(selected.getAttributeAsBoolean("isHumanAdd")) {
					SC.confirm("确定要删掉这条记录吗？", new BooleanCallback() {
						
						@Override
						public void execute(Boolean value) {
							if(value) {
								DBDataSource.callOperation("ST_FinancialTransactionDetail", "delete", selected.toMap(), new DSCallback() {
									@Override
									public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
										if (dsResponse.getStatus() < 0) {
											ClientUtil.displayErrorMessage(dsResponse);
										} else {
											int indexNum = resultGrid.getRowNum(selected);
											resultGrid.removeData(selected);
											resultGrid.selectSingleRecord(indexNum);
										}
									}
								});
							}
						}
					});
				}else {
					SC.say("系统数据，不允许删除");
				}
			}
		});
		
		IButton printButton = new IButton("打印对账单");
		printButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				Record[] records = resultGrid.getRecords();
				if(null == records || records.length == 0) {
					SC.say("没有数据可供打印");
					return;
				}
				TransDetailPrintPanel print = new TransDetailPrintPanel();
				print.setRecords(records);;
				Print.it(print.generatePrintHTML());
			}
		});
		controlLayout.addMember(printButton);

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
				detail.setTitle("往来明细"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				TransDetailViewer detailForm = new TransDetailViewer();
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
	
	public void showWorkFlowInfo() {
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
				Record selected = resultGrid.getSelectedRecords()[0];
				//如果是报销流转过来的数据，则看报销单的内容
				if(ClientUtil.checkAndGetIntValue(selected.getAttribute("processInstanceId")) > 0 && ClientUtil.checkAndGetIntValue(selected.getAttribute("processId")) > 0 && ClientUtil.checkAndGetIntValue(selected.getAttribute("processType")) > 0){
					ViewProcessWindow Reimbursement = new ViewProcessWindow();
	                Reimbursement.setWidth("80%");
	                Reimbursement.setHeight("80%");
	                Reimbursement.setLayoutMode(0);
	                Reimbursement.setInstanceData(selected);
	                Reimbursement.initComponents();
	                Reimbursement.setTitle(ClientUtil.getProcessTypeName(selected));
	                Reimbursement.show();
				}
			}
		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("addtionalCondition", "order by financial_transaction_account_id");
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new TransDetailSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSTransDetail.getInstance();
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
		searchForm.getItem("startDate").setValue(startDate);
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
		searchForm.getItem("endDate").setValue(endDate);
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
		if(!BaseHelpUtils.isNullOrEmpty(accountId)) {
			searchForm.getItem("financialTransactionAccountId").setDefaultValue(accountId);
		}
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
		if(!BaseHelpUtils.isNullOrEmpty(accountName)) {
			searchForm.getItem("accountName").setDefaultValue(accountName);
		}
	}

	public String getFinancialNo() {
		return financialNo;
	}

	public void setFinancialNo(String financialNo) {
		this.financialNo = financialNo;
		if(!BaseHelpUtils.isNullOrEmpty(financialNo)) {
			searchForm.getItem("financeNo").setDefaultValue(financialNo);
		}
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
		if(!BaseHelpUtils.isNullOrEmpty(companyId)) {
			searchForm.getItem("companyId").setDefaultValue(companyId);
		}
	}

}

