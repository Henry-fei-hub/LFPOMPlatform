package com.pomplatform.client.collection.panel;

import java.util.*;
import java.util.logging.Logger;

import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.PopupWindow;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractExpansionRelatedPage;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.collection.datasource.DSMItemCollection;
import com.pomplatform.client.collection.form.MItemCollectionSearchForm;
import com.pomplatform.client.collection.form.MItemCollectionViewer;
import com.pomplatform.client.receivables.datasource.DSMcapitalecoosmeor;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;

public class MItemCollectionPanel extends AbstractExpansionRelatedPage {

	private static Logger __LOGGER = Logger.getLogger("");

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			MItemCollectionPanel cm = new MItemCollectionPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "MItemCollection";
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
		IButton jdButton = new IButton("阶段回款");
		jdButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download");
					}

					@Override
					public void onSuccess() {
						if (!resultGrid.anySelected()) {
							SC.say("请选择一条数据");
							return;
						}
						ListGridRecord[] selected = resultGrid.getSelectedRecords();
						int contractId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("contractId"));
						String contractName = BaseHelpUtils.getString(selected[0].getAttribute("contractName"));
						PopupWindow pw = new PopupWindow();
						CustomItemCollectionMainPanel panel = new CustomItemCollectionMainPanel(contractId);
						pw.addItem(panel);
						panel.setParentCanvas(pw);
						;
						pw.setTitle("(" + contractName + ") 合同阶段回款");
						pw.setWidth100();
						pw.setHeight100();
						pw.centerInPage();
						pw.show();
					}
				});

			}
		});
		controlLayout.addMember(jdButton);
		IButton invoiceButton = new IButton("发票回款");
		invoiceButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download");
					}

					@Override
					public void onSuccess() {
						if (!resultGrid.anySelected()) {
							SC.say("请选择一条数据");
							return;
						}
						ListGridRecord[] selected = resultGrid.getSelectedRecords();
						int contractId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("contractId"));
						String contractName = BaseHelpUtils.getString(selected[0].getAttribute("contractName"));
						PopupWindow pw = new PopupWindow();
						SC.debugger();
						CustomItemInvoiceMainPanel panel = new CustomItemInvoiceMainPanel(contractId);
						pw.addItem(panel);
						panel.setParentCanvas(pw);
						;
						pw.setTitle("(" + contractName + ") 合同发票回款");
						pw.setWidth100();
						pw.setHeight100();
						pw.centerInPage();
						pw.show();
					}
				});

			}
		});
		controlLayout.addMember(invoiceButton);
		resultGrid.setCanEdit(false);
		ListGridField[] fields = new ListGridField[3];
		int idx = 0;
		fields[idx] = new ListGridField("infoCode");
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("projectCode");
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("contractCode");
		idx++;
		fields[idx] = new ListGridField("contractName");
		idx++;
		fields[idx] = new ListGridField("signingMoneySum");
		idx++;
		resultGrid.setFields(fields);
		resultGrid.setShowGridSummary(true);
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
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("MItemCollection");
				detail.setWidth100();
				detail.setHeight100();
				MItemCollectionViewer detailForm = new MItemCollectionViewer();
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
		__LOGGER.info("hasContractParagraphItem="+criteria.get("hasContractParagraph"));
		criteria.put("addtionalCondition", "order by contract_id desc");
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new MItemCollectionSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSMItemCollection.getInstance();
	}

	@Override
	public DataSource getChildDataSource() {
		return DSMcapitalecoosmeor.getInstance();
	}

	@Override
	public int getSearchFormHeight() {
		return 140;
	}

	// 设置统计的合计
	public String[] showGridSummary() {
		return new String[] { "borrowMoney", "loanMoney" };
	}

	@Override
	public void setChildGridOption(ListGrid resultChildGrid) {
		if (null != showGridSummary()) {
			resultChildGrid.setShowGridSummary(true);
			String[] sumFiled = showGridSummary();
			ListGridField[] fields = resultChildGrid.getFields();
			for (ListGridField listGridField : fields) {
				String fieldName = listGridField.getName();
				boolean flag = false;
				for (String string : sumFiled) {
					if (string.equals(fieldName)) {
						flag = true;
						break;
					}
				}
				listGridField.setShowGridSummary(flag);
			}
		}
	}

	@Override
	public Canvas[] getChildGridOptionCanvas() {
		Canvas[] canvasBtn = new Canvas[2];
		IButton selectBtn = new IButton("查看流水账回款发票");
		selectBtn.setWidth(150);
		selectBtn.hide();//暂不开发
		canvasBtn[0] = selectBtn;
		
		
		
		IButton exitInvoiceBtn = new IButton("解绑发票回款");
		canvasBtn[1] = exitInvoiceBtn;
		exitInvoiceBtn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!resultChildGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				final ListGridRecord selected = resultChildGrid.getSelectedRecord();
				Boolean hasInvoice = selected.getAttributeAsBoolean("hasInvoices");
				final int capitalId = selected.getAttributeAsInt("capitalId");
				
				__LOGGER.info("===========capitalId="+capitalId);
				if(!hasInvoice){
					SC.say("该笔回款没有绑定发票");
					return;
				}
				SC.ask("提示", "确认解绑发票回款", new BooleanCallback() {
					@Override
					public void execute(Boolean value) {
						final ListGridRecord record = resultChildGrid.getSelectedRecord();
						Map paramMap = record.toMap();
						paramMap.put("opt_type", "exitInvoice");
						if (value) {
							paramMap.put("capitalId", capitalId);
							DBDataSource.callOperation("EP_CustomItemCollectionHandler", paramMap,
							new DSCallback() {
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if (dsResponse.getStatus() < 0) {
										ClientUtil.displayErrorMessage(dsResponse);
									} else {
										resultChildGrid.refreshData();
									}
								}
							});
						}
					}
				});
			}
		});

		return canvasBtn;

	}
}
