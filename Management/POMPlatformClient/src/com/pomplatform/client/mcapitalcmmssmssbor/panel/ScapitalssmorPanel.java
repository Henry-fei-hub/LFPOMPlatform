package com.pomplatform.client.mcapitalcmmssmssbor.panel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.mcapitalcmmssmssbor.datasource.DSScapitalssmor;
import com.pomplatform.client.mcapitalcmmssmssbor.form.ScapitalssmorViewer;
import com.pomplatform.client.mfinancialaccounting.panel.UpdateFinancialAccountingPanel;
import com.pomplatform.client.sreimbursementpackagemmror.panel.UpdateReimbursementpackagePanel;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class ScapitalssmorPanel extends AbstractSearchPanel {

	private static final Logger __LOGGER = Logger.getLogger("");

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			ScapitalssmorPanel cm = new ScapitalssmorPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Scapitalssmor";
		}

	}

	@Override
	public void init() {
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
	}

	@Override
	public void initComponents() {
//		int index = 0;
//		ListGridField [] fields = new ListGridField [10];
//		fields[index] = new ListGridField("selfName");
//		fields[index].setCanEdit(false);
//		index ++;
//		fields[index] = new ListGridField("selfBankName");
//		fields[index].setCanEdit(false);
//		index ++;
//		fields[index] = new ListGridField("selfBankAccount");
//		fields[index].setCanEdit(false);
//		index ++;
//		fields[index] = new ListGridField("otherName");
//		fields[index].setCanEdit(false);
//		index ++;
//		fields[index] = new ListGridField("borrowMoney");
//		fields[index].setCanEdit(false);
//		index ++;
//		fields[index] = new ListGridField("loanMoney");
//		fields[index].setCanEdit(false);
//		index ++;
//		fields[index] = new ListGridField("happenDate");
//		index ++;
//		fields[index] = new ListGridField("capitalType");
//		fields[index].setCanEdit(false);
//		index ++;
//		fields[index] = new ListGridField("balance");
//		fields[index].setCanEdit(false);
//		resultGrid.setFields(fields);
		resultGrid.setShowRowNumbers(true);
//		resultGrid.setCanEdit(true);
		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				showDetail();
			}
		});
		IButton operation1Button = new IButton("查看详情");
		controlLayout.addMember(operation1Button);
		operation1Button.setIcon("[SKIN]/actions/view.png");
		operation1Button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		IButton exportBtn = new IButton("导出");
		controlLayout.addMember(exportBtn);
		exportBtn.addClickHandler(new ClickHandler() {
			
			@SuppressWarnings({ "unchecked", "rawtypes" })
			@Override
			public void onClick(ClickEvent event) {
				Map condition = generateCriteria();
		        if (condition == null) {
		            return;
		        }
		        condition.put("balance", getBalance());
				DBDataSource.downloadFile("DW_Scapitalssmor", condition);
			}
		});
		IButton updateBtn = new IButton("修改发生日期");
		controlLayout.addMember(updateBtn);
		updateBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(!resultGrid.anySelected()){
					SC.say("请选择一条数据");
					return;
				}
				PopupWindow pw = new PopupWindow();
				pw.setWidth100();
				pw.setHeight100();
				UpdateCapitalHappenDatePanel panel = new UpdateCapitalHappenDatePanel();
				Record selectRecord = resultGrid.getSelectedRecord();
				int capitalType = selectRecord.getAttributeAsInt("capitalType");
				if(capitalType != 2){
					SC.say("只有流出的资金才可修改发生日期");
					return;
				}
				panel.startEdit(selectRecord);
				panel.setParentWindow(pw);
				panel.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						Record record = event.getData();
						Map params = record.toMap();
						params.put("opt_type", "updateCompleteTime");
						DBDataSource.callOperation("EP_CustomMcapitalReconciliation", params, new DSCallback() {
							
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								if(dsResponse.getStatus() > 0){
									commonQuery();
								}else{
									ClientUtil.displayErrorMessage(dsResponse);
								}
							}
						});
						
					}
				});
				panel.setParentCanvas(pw);
				panel.setParentWindow(pw);
				pw.addItem(panel);
				pw.setTitle("修改发生日期");
				pw.setWidth(450);
				pw.setHeight(480);
				pw.centerInPage();
				pw.show();
			}
		});
	}
	
	public void initData(Record record){
		//可以查询的做法
//		searchForm.getItem("minHappenDate").setValue(record.getAttributeAsDate("minHappenDate"));
//		searchForm.getItem("maxHappenDate").setValue(record.getAttributeAsDate("maxHappenDate"));
//		searchForm.getItem("selfBankAccount").setValue(record.getAttributeAsString("selfBankAccount"));
		setMinHappenDate(record.getAttributeAsDate("minHappenDate"));
		setBalance(new BigDecimal(record.getAttributeAsString("beforeMoney")));
		setMaxHappenDate(record.getAttributeAsDate("maxHappenDate"));
		setSelfBankAccount(record.getAttributeAsString("selfBankAccount"));
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
				Record record = resultGrid.getSelectedRecord();
				int type = record.getAttributeAsInt("capitalType");
				if(1 == type){//插看当前详情
					GenericViewWindow detail = new GenericViewWindow();
					detail.setTitle("详细");
					detail.setWidth100();
					detail.setHeight100();
					ScapitalssmorViewer detailForm = new ScapitalssmorViewer();
					detailForm.setParentSearchForm(searchForm);
					detailForm.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_TAB);
					detailForm.initComponents();
					detailForm.viewSelectedData(resultGrid);
					detail.setContent(detailForm);
					detail.centerInPage();
					detail.show();
				} else {//查看打包汇总详情
					int summaryId = record.getAttributeAsInt("reimbursementPackageSummaryId");
					Map<String, Object> params = new HashMap<>();
					params.put("summaryId", summaryId);
					params.put("opt_type", "getPackageidBySummaryid");
					DBDataSource.callOperation("EP_ReimbursementPackageProcessor", params, new DSCallback() {
						
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							int status = Integer.parseInt(data.toString());
							if(status > 0){
								PopupWindow pw = new PopupWindow();
								pw.setWidth100();
								pw.setHeight100();
								UpdateReimbursementpackagePanel panel = new UpdateReimbursementpackagePanel(status, false, false, true, null);
								panel.setPackageId(status);
								panel.setFatherWindow(pw);
								panel.startEdit();
								panel.setParentCanvas(pw);
								pw.addItem(panel);
								pw.setTitle("报销单打包详情");
								pw.setWidth100();
								pw.setHeight100();
								pw.centerInPage();
								pw.show();
							}
							
						}
					});
				}
				
			}
		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("addtionalCondition", "order by capital_id");
		criteria.put("balance", getBalance());
		criteria.put("minHappenDate", getMinHappenDate());
		criteria.put("maxHappenDate", getMaxHappenDate());
		criteria.put("selfBankAccount", getSelfBankAccount());
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
//		return new ScapitalssmorSearchForm();
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSScapitalssmor.getInstance();
	}
	
	private BigDecimal balance;
	
	private Date minHappenDate;
	
	private Date maxHappenDate;
	
	private String selfBankAccount;

	public Date getMinHappenDate() {
		return minHappenDate;
	}

	public void setMinHappenDate(Date minHappenDate) {
		this.minHappenDate = minHappenDate;
	}

	public Date getMaxHappenDate() {
		return maxHappenDate;
	}

	public void setMaxHappenDate(Date maxHappenDate) {
		this.maxHappenDate = maxHappenDate;
	}

	public String getSelfBankAccount() {
		return selfBankAccount;
	}

	public void setSelfBankAccount(String selfBankAccount) {
		this.selfBankAccount = selfBankAccount;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
}
