package com.pomplatform.client.contracticcisiior.panel;

import java.util.HashMap;
import java.util.Map;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractExpansionRelatedPage;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.contracticcisiior.datasource.DSMcontracticcisiior;
import com.pomplatform.client.contracticcisiior.form.McontracticcisiiorSearchForm;
import com.pomplatform.client.contracticcisiior.form.McontracticcisiiorViewer;
import com.pomplatform.client.sinvoiceitior.datasource.DSSinvoiceitior;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class McontracticcisiiorPanel extends AbstractExpansionRelatedPage {

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			McontracticcisiiorPanel cm = new McontracticcisiiorPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Mcontracticcisiior";
		}

	}

	@Override
	public void initComponents() {
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.setIcon("[SKIN]/actions/refresh.png");
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});

		IButton addSignZeroInvoiceBtn = new IButton("填开发票");
		controlLayout.addMember(addSignZeroInvoiceBtn);
		addSignZeroInvoiceBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				Integer contractId = null;// 合同编码
				String contractName = null;// 合同名称
				if (resultGrid.anySelected()) {
					ListGridRecord record = resultGrid.getSelectedRecord();
					contractId = record.getAttributeAsInt("contractId");
					contractName = record.getAttributeAsString("contractName");
				}

				PopupWindow pw = new PopupWindow();
				AddSignZeroContracticcisiiorPanel panel = new AddSignZeroContracticcisiiorPanel(contractId,
						contractName);
				panel.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						if(resultGrid.anySelected()){
							resultChildGrid.refreshData();
						}else{
							commonQuery();
						}
						SC.say("提示", "操作成功");
					}
				});
				panel.setParentCanvas(pw);
				panel.setFatherWindow(pw);
				pw.addItem(panel);

				pw.setTitle("填开发票");
				pw.setShowCloseButton(false);
				pw.setWidth100();
				pw.setHeight100();
				pw.centerInPage();
				pw.show();
			}
		});
		
		IButton updateInvoiceBtn = new IButton("修改填开发票");
		controlLayout.addMember(updateInvoiceBtn);
		updateInvoiceBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Integer contractId = null;// 合同编码
				String contractName = null;// 合同名称
				if (resultGrid.anySelected()) {
					ListGridRecord record = resultGrid.getSelectedRecord();
					contractId = record.getAttributeAsInt("contractId");
					contractName = record.getAttributeAsString("contractName");
					UpdateContractInvoicePanel panel = new UpdateContractInvoicePanel();
					panel.setContractId(contractId);
					panel.startEdit();
					
					PopupWindow pw = new PopupWindow();
					pw.addCloseClickHandler(new CloseClickHandler() {
						
						@Override
						public void onCloseClick(CloseClickEvent event) {
							resultChildGrid.refreshData();
						}
					});
					panel.addDataEditedHandler(new DataEditedHandler() {
						@Override
						public void onDataEdited(DataEditEvent event) {
							resultChildGrid.refreshData();
						}
					});
					panel.setParentCanvas(pw);
					panel.setFatherWindow(pw);
					pw.addItem(panel);
					pw.setTitle("(合同["+ contractName + "])发票修改");
					pw.setWidth100();
					pw.setHeight100();
					pw.centerInPage();
					pw.show();
				}else{
					SC.say("请选择一条数据");
					return ;
				}
			}
		});
		
		IButton negativeInvoiceBtn = new IButton("负数发票");
		controlLayout.addMember(negativeInvoiceBtn);
		negativeInvoiceBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Integer contractId = null;// 合同编码
				String contractName = null;// 合同名称
				if (resultGrid.anySelected()) {
					ListGridRecord record = resultGrid.getSelectedRecord();
					contractId = record.getAttributeAsInt("contractId");
					contractName = record.getAttributeAsString("contractName");
					AddSignTwoManyEditContracticcisiiorPanel panel = new AddSignTwoManyEditContracticcisiiorPanel(contractId, contractName);
					
					PopupWindow pw = new PopupWindow();
					pw.addCloseClickHandler(new CloseClickHandler() {
						
						@Override
						public void onCloseClick(CloseClickEvent event) {
							resultChildGrid.refreshData();
						}
					});
					panel.addDataEditedHandler(new DataEditedHandler() {
						@Override
						public void onDataEdited(DataEditEvent event) {
							resultChildGrid.refreshData();
						}
					});
					panel.setParentCanvas(pw);
					panel.setFatherWindow(pw);
					pw.addItem(panel);
					pw.setTitle("(合同["+ contractName + "])开负数发票");
					pw.setWidth100();
					pw.setHeight100();
					pw.centerInPage();
					pw.show();
				}else{
					SC.say("请选择一条数据");
					return ;
				}
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
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("Mcontracticcisiior");
				detail.setWidth100();
				detail.setHeight100();
				McontracticcisiiorViewer detailForm = new McontracticcisiiorViewer();
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
		criteria.put("addtionalCondition", "order by contract_id");
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new McontracticcisiiorSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSMcontracticcisiior.getInstance();
	}
	
	@Override
	public DataSource getChildDataSource() {
		return DSSinvoiceitior.getInstance();
	}

	public String[] showSummaryField() {
		return new String[]{"invoiceAmount", "noTaxAmount", "outputTax"};
	}

	@Override
	public void setChildGridOption(ListGrid resultChildGrid) {
    	resultChildGrid.setShowGridSummary(true);
    	String [] sumFiled = showSummaryField();
    	
    	ListGridField [] fields = resultChildGrid.getFields();
    	for (ListGridField listGridField : fields) {
    		String fieldName = listGridField.getName();
    		boolean flag = false;
    		for (String string : sumFiled) {
				if(string.equals(fieldName)){
					flag = true;
					break;
				}
			}
    		listGridField.setShowGridSummary(flag);
		}
	}

	@Override
	public Canvas[] getChildGridOptionCanvas() {
		Canvas [] opCanvas= new Canvas[3];
		IButton negativeInvoiceBtn = new IButton("负数发票");
		negativeInvoiceBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(resultChildGrid.anySelected()){
					ListGridRecord record = resultChildGrid.getSelectedRecord();
					ListGridRecord record1 = resultGrid.getSelectedRecord();
					int contractId = record1.getAttributeAsInt("contractId");
					String contractName = record1.getAttributeAsString("contractName");
					AddSignTwoShowContracticcisiiorPanel panel = new AddSignTwoShowContracticcisiiorPanel(contractId, contractName, record);
					
					PopupWindow pw = new PopupWindow();
					pw.addCloseClickHandler(new CloseClickHandler() {
						
						@Override
						public void onCloseClick(CloseClickEvent event) {
							resultChildGrid.refreshData();
						}
					});
					panel.addDataEditedHandler(new DataEditedHandler() {
						@Override
						public void onDataEdited(DataEditEvent event) {
							resultChildGrid.refreshData();
						}
					});
					panel.setParentCanvas(pw);
					panel.setFatherWindow(pw);
					pw.addItem(panel);
					pw.setTitle("(合同["+ contractName + "])开负数发票");
					pw.setWidth100();
					pw.setHeight100();
					pw.centerInPage();
					pw.show();
				}else{
					SC.say("请选择一条发票信息");
				}
			}
		});
		IButton updateDelInvoiceBtn = new IButton("填开作废");
		updateDelInvoiceBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(resultChildGrid.anySelected()){
					final ListGridRecord record = resultChildGrid.getSelectedRecord();
					String invoiceNumber = record.getAttributeAsString("invoiceNumber");
					int sign = record.getAttributeAsInt("sign");
					if(sign != 1){
						SC.say("请选择一张正常状态的发票填开作废！");
						return ;
					}
					SC.ask("提示", "确定要将发票号为["+invoiceNumber +"]的发票填开作废吗", new BooleanCallback() {
						
						@Override
						public void execute(Boolean value) {
							if(value){
								int invoiceId = record.getAttributeAsInt("invoiceId");
								Map<String, Object> params = new HashMap<>();
								params.put("invoiceId", invoiceId);
								params.put("sign", 3);
								params.put("opt_type", "abandonedInvoices");
								DBDataSource.callOperation("EP_CustomSinvoiceitiorHandler", "abandonedInvoices", params, new DSCallback() {
									
									@Override
									public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
										if(dsResponse.getStatus() > 0){
											resultChildGrid.refreshData();
										}else{
											ClientUtil.displayErrorMessage(dsResponse);
										}
										
									}
								});
							}
						}
					});
					
				}else{
					SC.say("请选择一条发票信息");
				}
			}
		});
		IButton negativeDelInvoiceBtn = new IButton("负数作废");
		negativeDelInvoiceBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(resultChildGrid.anySelected()){
					final ListGridRecord record = resultChildGrid.getSelectedRecord();
					String invoiceNumber = record.getAttributeAsString("invoiceNumber");
					int sign = record.getAttributeAsInt("sign");
					if(sign != 2){
						SC.say("请选择一张负数发票负数作废！");
						return ;
					}
					SC.ask("提示", "确定要将发票号为["+invoiceNumber +"]的发票填负数作废吗?", new BooleanCallback() {
						
						@Override
						public void execute(Boolean value) {
							if(value){
								int invoiceId = record.getAttributeAsInt("invoiceId");
								Map<String, Object> params = new HashMap<>();
								params.put("invoiceId", invoiceId);
								params.put("sign", 4);
								params.put("opt_type", "abandonedInvoices");
								DBDataSource.callOperation("EP_CustomSinvoiceitiorHandler", "abandonedInvoices", params, new DSCallback() {
									
									@Override
									public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
										if(dsResponse.getStatus() > 0){
											resultChildGrid.refreshData();
										}else{
											ClientUtil.displayErrorMessage(dsResponse);
										}
										
									}
								});
							}
						}
					});
					
				}else{
					SC.say("请选择一条发票信息");
				}
			}
		});
		opCanvas[0] = negativeInvoiceBtn;
		opCanvas[1] = updateDelInvoiceBtn;
		opCanvas[2] = negativeDelInvoiceBtn;
		return opCanvas;
	}
	
	
}
