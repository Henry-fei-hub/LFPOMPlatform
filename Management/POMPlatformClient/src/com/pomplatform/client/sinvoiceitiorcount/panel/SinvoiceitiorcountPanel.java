package com.pomplatform.client.sinvoiceitiorcount.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PaginationPanel;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.user.client.ui.Label;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.attachment.panel.UpdateAttachmentPanel;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.contracticcisiior.panel.AddSignTwoShowContracticcisiiorPanel;
import com.pomplatform.client.minvoicettorunusecount.panel.MinvoicettorunusecountPanel;
import com.pomplatform.client.sinvoiceitiorcount.datasource.DSSinvoiceitiorcount;
import com.pomplatform.client.sinvoiceitiorcount.form.SinvoiceitiorcountSearchForm;
import com.pomplatform.client.sinvoiceitiorcount.form.SinvoiceitiorcountViewer;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.Browser;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.events.KeyPressEvent;
import com.smartgwt.client.widgets.events.KeyPressHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

/**
 * 
 * @Title: SinvoiceitiorcountPanel.java 
 * @Package com.pomplatform.client.sinvoiceitiorcount.panel 
 * @Description: 发票汇总面板
 * @author CL  
 * @date 2016年11月22日
 */
public class SinvoiceitiorcountPanel extends AbstractSearchPanel {
	
	private SinvoiceitiorcountSearchForm sinvoiceitiorcountSearchForm;
	
	private DSSinvoiceitiorcount dssinvoiceitiorcount;
	
	public static Label useSelectSumLabel; //选中后统计

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			SinvoiceitiorcountPanel cm = new SinvoiceitiorcountPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Sinvoiceitiorcount";
		}

	}

	@Override
	public void init() {
		super.init();
		resultGrid.setAutoFitFieldWidths(false);
	}
	
	@Override
	public void initComponents() {
		resultGrid.setShowRowNumbers(true);
		
		resultGrid.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				double invoiceAmountSum = 0;
				double noTaxAmountSum = 0;
				double outputTaxSum = 0;
				ListGridRecord [] fianlSelectRecords = resultGrid.getSelectedRecords();
				for (ListGridRecord listGridRecord : fianlSelectRecords) {
					invoiceAmountSum += listGridRecord.getAttributeAsDouble("invoiceAmount");
					noTaxAmountSum += listGridRecord.getAttributeAsDouble("noTaxAmount");
					outputTaxSum += listGridRecord.getAttributeAsDouble("outputTax");
				}
				String text = "选中汇总 [ 开票金额=" + BaseHelpUtils.get2Double(invoiceAmountSum) + "  不含税金额=" + BaseHelpUtils.get2Double(noTaxAmountSum) +
						"  销项税=" + BaseHelpUtils.get2Double(outputTaxSum) + "]"; 
				useSelectSumLabel.setText(text);
			}
		});
        resultGrid.setCanDragSelectText(true);
        resultGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
        resultGrid.setDrawAheadRatio(4); 
//		resultGrid.setHeaderHeight(60);
		ListGridField ticketingCompanyField = new ListGridField("ticketingCompany", 100);  
		ticketingCompanyField.setShowGridSummary(false);
		ticketingCompanyField.setFrozen(true);  
		ListGridField haveVoucherField = new ListGridField("haveVoucher", 100);  
		haveVoucherField.setShowGridSummary(false);
		ListGridField contractNameField = new ListGridField("contractName", 100);
		contractNameField.setShowGridSummary(false);
		ListGridField contractCodeField = new ListGridField("contractCode", 100);
		contractCodeField.setShowGridSummary(false);
		ListGridField invoiceTypeField = new ListGridField("invoiceType", 100);
		invoiceTypeField.setShowGridSummary(false);
		ListGridField invoiceCodeField = new ListGridField("invoiceCode", 100);
		invoiceCodeField.setShowGridSummary(false);
		ListGridField invoiceNumberField = new ListGridField("invoiceNumber", 100);
		invoiceNumberField.setShowGridSummary(false);
		ListGridField customerIdField = new ListGridField("customerId", 100);
		KeyValueManager.loadValueMap("customers", customerIdField);
		customerIdField.setShowGridSummary(false);
		ListGridField invoiceAmountField = new ListGridField("invoiceAmount", 100);
		ListGridField taxRateField = new ListGridField("taxRate", 100);
		taxRateField.setShowGridSummary(false);
		ListGridField noTaxAmountField = new ListGridField("noTaxAmount", 100);
		ListGridField outputTaxField = new ListGridField("outputTax", 100);
		ListGridField invoiceDateField = new ListGridField("invoiceDate", 100);
		invoiceDateField.setShowGridSummary(false);
		ListGridField signField = new ListGridField("sign", 100);
		signField.setShowGridSummary(false);
		ListGridField primaryInvoiceCodeField = new ListGridField("primaryInvoiceCode", 100);
		primaryInvoiceCodeField.setShowGridSummary(false);
		ListGridField primaryInvoiceNumberField = new ListGridField("primaryInvoiceNumber", 100);
		primaryInvoiceNumberField.setShowGridSummary(false);
		resultGrid.setFields(ticketingCompanyField,haveVoucherField,contractNameField,contractCodeField,invoiceTypeField,
				invoiceCodeField,invoiceNumberField,customerIdField,invoiceAmountField,taxRateField,
				noTaxAmountField,outputTaxField,invoiceDateField,signField,primaryInvoiceCodeField,
				primaryInvoiceNumberField);
//		resultGrid.setHeaderSpans(new HeaderSpan[] {
//		    new HeaderSpan("已使用", new String[] { "ticketingCompany","contractName","contractCode",
//		    		"invoiceType","invoiceCode","invoiceNumber","clientName","invoiceAmount","taxRate",
//		    		"noTaxAmount","outputTax","invoiceDate","sign","primaryInvoiceCode","primaryInvoiceNumber"}),
//	    });
		resultGrid.setShowGridSummary(true);
		setMinSign(1);
		setMaxSign(5);
		setIsUseInvoice(true);
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.setIcon("[SKIN]/actions/refresh.png");
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				useSelectSumLabel.setText("");
				commonQuery();
			}
		});
		
		IButton countBtn = new IButton("发票汇总");
		controlLayout.addMember(countBtn);
		countBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(getIsUseInvoice()){
					PopupWindow pw = new PopupWindow();
					CustomSinvoiceitiorusecountPanel panel = new CustomSinvoiceitiorusecountPanel();
					panel.setParentCanvas(pw);
	                panel.setFatherWindow(pw);
	                Map params = sinvoiceitiorcountSearchForm.getValues();
	                params.put("minSign", getMinSign());
	                params.put("maxSign", getMaxSign());
	                panel.setParams(params);
	                panel.startEdit();
	                pw.addItem(panel);
	                pw.setTitle("已使用发票汇总");
	                pw.setWidth100();
	                pw.setHeight100();
	                pw.centerInPage();
	                pw.show();
				}else{
					MinvoicettorunusecountPanel panel = new MinvoicettorunusecountPanel();
					panel.getViewPanel();
					PopupWindow pw = new PopupWindow();
					panel.setParentCanvas(pw);
					pw.addItem(panel.getViewPanel());
					pw.setTitle("未使用发票汇总");
					pw.setWidth100();
					pw.setHeight100();
					pw.centerInPage();
					pw.show();
					panel.commonQuery();
				}
			}
		});
		IButton exportBtn = new IButton("导出");
		controlLayout.addMember(exportBtn);
		exportBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Map params = generateCriteria();
				if(null == params) {
					return;
				}
				DBDataSource.downloadFile("DW_Sinvoiceitiorcount", params);
			}
		});
		IButton conContractBtn = PermissionControl.createPermissionButton("关联合同", ERPPermissionStatic.INVOICES_MANAGEMENT_LINK_CONTRACT);
		controlLayout.addMember(conContractBtn);
		conContractBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				ListGridRecord [] allRecords = resultGrid.getSelectedRecords();
				List<Integer> list = new ArrayList<>();
				if(allRecords.length > 0){
					for (int i = 0; i < allRecords.length; i++) {
//						if(null == allRecords[i].getAttributeAsInt("contractId")){
//							
//						}
						list.add(i);
					}
					if(list.size() > 0){
//						ListGridRecord [] finRecords = new ListGridRecord[list.size()];
//						ListGridRecord sumRecord = new ListGridRecord();
//						sumRecord.setAttribute("invoiceId", -1);
//						double invoiceAmount = 0;//汇总开票金额
//						double noTaxAmount = 0;//汇总不含税金额
//						for (int i = 0; i < list.size(); i++) {
//							invoiceAmount += allRecords[list.get(i)].getAttributeAsDouble("invoiceAmount");
//							noTaxAmount += allRecords[list.get(i)].getAttributeAsDouble("noTaxAmount");
//							finRecords [i] = allRecords[list.get(i)];
//						}
//						sumRecord.setAttribute("invoiceAmount", invoiceAmount);
//						sumRecord.setAttribute("noTaxAmount", noTaxAmount);
//						finRecords[list.size()] = sumRecord;
						//添加面板设置数据
						PopupWindow pw = new PopupWindow();
						CustomSinvoiceitiorContractPanel panel = new CustomSinvoiceitiorContractPanel();
						panel.resultGrid.setData(allRecords);
						panel.addDataEditedHandler(new DataEditedHandler() {
							
							@Override
							public void onDataEdited(DataEditEvent event) {
								commonQuery();
							}
						});
						panel.setParentCanvas(pw);
		                panel.setFatherWindow(pw);
		                pw.addItem(panel);
		                pw.setTitle("导入发票管理关联合同");
		                pw.setWidth100();
		                pw.setHeight100();
		                pw.centerInPage();
		                pw.show();
		                
					}else{
						SC.say("您选择的发票不含有人工导入的发票数据！请重新选择！");
					}
				}else{
					SC.say("请选择需要管理的发票");
				}
				
			}
		});
		IButton negativeInvoiceBtn = PermissionControl.createPermissionButton("负数发票", ERPPermissionStatic.INVOICES_MANAGEMENT_NEGATIVE_INVOICE);
		controlLayout.addMember(negativeInvoiceBtn);
		negativeInvoiceBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(resultGrid.anySelected()){
					ListGridRecord record = resultGrid.getSelectedRecord();
					int contractId = record.getAttributeAsInt("contractId");
					String contractName = record.getAttributeAsString("contractName");
					AddSignTwoShowContracticcisiiorPanel panel = new AddSignTwoShowContracticcisiiorPanel(contractId, contractName, record);
					
					PopupWindow pw = new PopupWindow();
					pw.addCloseClickHandler(new CloseClickHandler() {
						
						@Override
						public void onCloseClick(CloseClickEvent event) {
							commonQuery();
						}
					});
					panel.addDataEditedHandler(new DataEditedHandler() {
						@Override
						public void onDataEdited(DataEditEvent event) {
							commonQuery();
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
		IButton updateDelInvoiceBtn = PermissionControl.createPermissionButton("填开作废", ERPPermissionStatic.INVOICES_MANAGEMENT_INVALID_INVOICE);
		controlLayout.addMember(updateDelInvoiceBtn);
		updateDelInvoiceBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(resultGrid.anySelected()){
					final ListGridRecord record = resultGrid.getSelectedRecord();
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
											commonQuery();
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
		IButton negativeDelInvoiceBtn = PermissionControl.createPermissionButton("负数作废", ERPPermissionStatic.INVOICES_MANAGEMENT_INVALID_NEGATIVE_INVOICE);
		controlLayout.addMember(negativeDelInvoiceBtn);
		negativeDelInvoiceBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(resultGrid.anySelected()){
					final ListGridRecord record = resultGrid.getSelectedRecord();
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
											commonQuery();
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
		
		IButton viewBtn = PermissionControl.createPermissionButton("查看确认函", ERPPermissionStatic.AT_CHECK_BTN);
		viewBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(!resultGrid.anySelected()){
					SC.say("请选择需要查看的确认函!");
					return;
				}
				Record record = resultGrid.getSelectedRecord();
				Map<String, Object> params = new HashMap<>();
				params.put("invoiceId", record.getAttribute("invoiceId"));
				DBDataSource.callOperation("ST_AttachmentLinkInvoice", "find", params, new DSCallback() {
					
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0){
							if(dsResponse.getData().length > 0){
								PopupWindow pw = new PopupWindow();
								UpdateAttachmentPanel panel = new UpdateAttachmentPanel(false);
								panel.initComponents();
								panel.setBusinessId(dsResponse.getData()[0].getAttribute("attachmentManageId"));
								panel.setFatherWindow(pw);
								panel.load();
								pw.addItem(panel);
				                pw.setTitle("查看确认函");
				                pw.setWidth100();
				                pw.setHeight100();
				                pw.centerInPage();
				                pw.show();
							}else{
								SC.say("该发票没有绑定确认函");
							}
							
						}
						
						
					}
				});
				
			}
		});
		controlLayout.addMember(viewBtn);
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
				detail.setTitle("Sinvoiceitiorcount");
				detail.setWidth100();
				detail.setHeight100();
				SinvoiceitiorcountViewer detailForm = new SinvoiceitiorcountViewer();
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
		if (!ClientUtil.checkIsHavePermission(ERPPermissionStatic.INVOICES_MANAGEMENT_VIEW_ALL_DATA)
				&& !ClientUtil.checkIsHavePermission(ERPPermissionStatic.INVOICES_MANAGEMENT_VIEW_DEPARTMENT_DATA)
				&& !ClientUtil.checkIsHavePermission(ERPPermissionStatic.INVOICES_MANAGEMENT_VIEW_MINE_DATA)) {
			//没有查看任何数据的权限
			return false;
		}
		criteria.put("addtionalCondition", "order by invoice_id");
		criteria.put("minSign", getMinSign());
		criteria.put("maxSign", getMaxSign());
		if (!ClientUtil.checkIsHavePermission(ERPPermissionStatic.INVOICES_MANAGEMENT_VIEW_ALL_DATA)
				&& ClientUtil.checkIsHavePermission(ERPPermissionStatic.INVOICES_MANAGEMENT_VIEW_DEPARTMENT_DATA)) {
			//查看部门数据的权限
			criteria.put("plateIds", PomPlatformClientUtil.getRolePlateId());
		}
		if (!ClientUtil.checkIsHavePermission(ERPPermissionStatic.INVOICES_MANAGEMENT_VIEW_ALL_DATA)
				&& !ClientUtil.checkIsHavePermission(ERPPermissionStatic.INVOICES_MANAGEMENT_VIEW_DEPARTMENT_DATA)
				&& ClientUtil.checkIsHavePermission(ERPPermissionStatic.INVOICES_MANAGEMENT_VIEW_MINE_DATA)) {
			//查看个人数据的权限
			criteria.put("projectManager", ClientUtil.getUserId());
		}
		List<Map<String, String>> list = new ArrayList<>();
		if(criteria.containsKey("haveVoucher") && !BaseHelpUtils.isNullOrEmpty(criteria.get("haveVoucher"))) {
			Map<String, String> kv = new HashMap<>();
			kv.put("key", "HAVING i.have_voucher = ?");
			
			if(BaseHelpUtils.getBoolean(criteria.get("haveVoucher"))) {
				kv.put("value", "having 1 = ? and kv.link_id is not null");
			}else {
				kv.put("value", "having 1 = ? and kv.link_id is null");
			}
			list.add(kv);
			criteria.remove("haveVoucher");
		}
		if(!list.isEmpty()) {
			criteria.put("keyValues", list);
		}
		return true;
	}
	
	@Override
	public SearchForm generateSearchForm() {
		sinvoiceitiorcountSearchForm = new SinvoiceitiorcountSearchForm();
		return sinvoiceitiorcountSearchForm;
	}

	@Override
	public DataSource getDataSource() {
		dssinvoiceitiorcount = DSSinvoiceitiorcount.getInstance();
		return dssinvoiceitiorcount;
	}
	
	@Override
	public int getSearchFormHeight() {
		return 140;
	}

	@Override
    public Canvas getViewPanel() {
        init();
        searchForm = generateSearchForm();
        useSelectSumLabel = new Label();
        useSelectSumLabel.setWidth("500");
        VLayout layout = new VLayout();
        layout.setWidth100();
        layout.setHeight100();
        layout.setBackgroundColor("#e2e2e2");

        if (searchForm != null) {
            ClientUtil.searchFormProcessAccordingToDevice(searchForm);
            if (getSearchFormHeight() > 0) {
                searchForm.setHeight(getSearchFormHeight());
            }
            HLayout searchLayout = new HLayout(5);
            searchLayout.setMargin(10);
            layout.addMember(searchLayout);

            searchForm.setWidth100();
            searchLayout.addMember(searchForm);

            VLayout buttonLayout = new VLayout(5);
            searchButton = new IButton("搜索");
            searchButton.setIcon("[SKIN]/actions/search.png");

            IButton resetButton = new IButton("重置");
            resetButton.setIcon("[SKIN]/actions/redo.png");

            buttonLayout.addMember(searchButton);
            buttonLayout.addMember(resetButton);

            searchLayout.addMember(buttonLayout);

            searchButton.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                	useSelectSumLabel.setText("");
                    currentPage = 1;
                    commonQuery();
                }
            });

            resetButton.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    searchForm.editNewRecord();
                }
            });
        }
        VLayout resultLayout = new VLayout();
        resultLayout.setWidth100();
        resultLayout.setHeight100();
        if (__needControl) {
            switch (__controlPosition) {
                case LayoutConstant.TOP:
                case LayoutConstant.BOTTOM:
                    toolBar = new ToolStrip();
                    toolBar.setHeight(40);
                    break;
                case LayoutConstant.RIGHT:
                case LayoutConstant.LEFT:
                    controlLayout = new VLayout();
                    controlLayout.setHeight100();
                    controlLayout.setWidth(120);
                    controlLayout.setLayoutTopMargin(30);
                    controlLayout.setLayoutLeftMargin(5);
                    controlLayout.setLayoutRightMargin(5);
                    controlLayout.setMembersMargin(10);
                    break;
            }
        }
        if (__needControl && __controlPosition == LayoutConstant.TOP) {
            resultLayout.addMember(toolBar);
        }
        HLayout main = new HLayout();
        main.setWidth100();
        main.setHeight100();
        resultLayout.addMember(main);
        if (__needControl && __controlPosition == LayoutConstant.LEFT) {
            main.addMember(controlLayout);
        }
        Canvas mainCanvas = null;
        if (__layoutMode == LayoutConstant.LEFTRIGHT) {
            mainCanvas = generateHDataCanvas();
        } else {
            mainCanvas = generateVDataCanvas();
        }
//        main.addMember(mainCanvas);
        layout.addMember(resultLayout);
        
        IButton beforeButton=new IButton("已使用");
        beforeButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				useSelectSumLabel.setText("");
				ListGridField ticketingCompanyField = new ListGridField("ticketingCompany", 100);  
				ticketingCompanyField.setFrozen(true);  
				ticketingCompanyField.setShowGridSummary(false);
				ListGridField contractNameField = new ListGridField("contractName", 100);
				contractNameField.setShowGridSummary(false);
				ListGridField contractCodeField = new ListGridField("contractCode", 100);
				contractCodeField.setShowGridSummary(false);
				ListGridField invoiceTypeField = new ListGridField("invoiceType", 100);
				invoiceTypeField.setShowGridSummary(false);
				ListGridField invoiceCodeField = new ListGridField("invoiceCode", 100);
				invoiceCodeField.setShowGridSummary(false);
				ListGridField invoiceNumberField = new ListGridField("invoiceNumber", 100);
				invoiceNumberField.setShowGridSummary(false);
				ListGridField customerIdField = new ListGridField("customerId", 100);
				KeyValueManager.loadValueMap("customers", customerIdField);
				customerIdField.setShowGridSummary(false);
				ListGridField invoiceAmountField = new ListGridField("invoiceAmount", 100);
				ListGridField taxRateField = new ListGridField("taxRate", 100);
				taxRateField.setShowGridSummary(false);
				ListGridField noTaxAmountField = new ListGridField("noTaxAmount", 100);
				ListGridField outputTaxField = new ListGridField("outputTax", 100);
				ListGridField invoiceDateField = new ListGridField("invoiceDate", 100);
				invoiceDateField.setShowGridSummary(false);
				ListGridField signField = new ListGridField("sign", 100);
				signField.setShowGridSummary(false);
				ListGridField primaryInvoiceCodeField = new ListGridField("primaryInvoiceCode", 100);
				primaryInvoiceCodeField.setShowGridSummary(false);
				ListGridField primaryInvoiceNumberField = new ListGridField("primaryInvoiceNumber", 100);
				primaryInvoiceNumberField.setShowGridSummary(false);
				resultGrid.setFields(ticketingCompanyField,contractNameField,contractCodeField,invoiceTypeField,
						invoiceCodeField,invoiceNumberField,customerIdField,invoiceAmountField,taxRateField,
						noTaxAmountField,outputTaxField,invoiceDateField,signField,primaryInvoiceCodeField,
						primaryInvoiceNumberField);
				resultGrid.setShowGridSummary(true);
				//控制按钮显示
				controlLayout.getMember(3).show();
				controlLayout.getMember(4).show();
				controlLayout.getMember(5).show();
				controlLayout.getMember(6).show();
				
				sinvoiceitiorcountSearchForm.clearValues();
				sinvoiceitiorcountSearchForm.getItem("minInvoiceDate").show();
				sinvoiceitiorcountSearchForm.getItem("maxInvoiceDate").show();
				sinvoiceitiorcountSearchForm.getItem("contractName").show();
//				dssinvoiceitiorcount.getField("primaryInvoiceNumber").setHidden(false);
//				dssinvoiceitiorcount.getField("primaryInvoiceCode").setHidden(false);
//				dssinvoiceitiorcount.getField("sign").setHidden(false);
//				dssinvoiceitiorcount.getField("invoiceDate").setHidden(false);
//				dssinvoiceitiorcount.getField("outputTax").setHidden(false);
//				dssinvoiceitiorcount.getField("noTaxAmount").setHidden(false);
//				dssinvoiceitiorcount.getField("taxRate").setHidden(false);
//				dssinvoiceitiorcount.getField("invoiceAmount").setHidden(false);
//				dssinvoiceitiorcount.getField("clientName").setHidden(false);
//				dssinvoiceitiorcount.getField("contractName").setHidden(false);
//				dssinvoiceitiorcount.getField("contractCode").setHidden(false);
				resultGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
				searchForm.setHeight(140);
//				resultGrid.setDataSource(dssinvoiceitiorcount);
//				resultGrid.setHeaderSpans(new HeaderSpan[] {
//				   new HeaderSpan("已使用", new String[] { "ticketingCompany","contractName","contractCode","invoiceType","invoiceCode","invoiceNumber","clientName","invoiceAmount","taxRate","noTaxAmount","outputTax","invoiceDate","sign","primaryInvoiceCode","primaryInvoiceNumber"}),
//			    });
				setMinSign(1);
				setMaxSign(5);
				setIsUseInvoice(true);
				commonQuery();
			}
		});
        IButton afterButton=new IButton("未使用");
        afterButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				useSelectSumLabel.setText("");
				sinvoiceitiorcountSearchForm.clearValues();
				sinvoiceitiorcountSearchForm.getItem("minInvoiceDate").hide();
				sinvoiceitiorcountSearchForm.getItem("maxInvoiceDate").hide();
				sinvoiceitiorcountSearchForm.getItem("contractName").hide();
//				dssinvoiceitiorcount.getField("primaryInvoiceNumber").setHidden(true);
//				dssinvoiceitiorcount.getField("primaryInvoiceCode").setHidden(true);
//				dssinvoiceitiorcount.getField("sign").setHidden(true);
//				dssinvoiceitiorcount.getField("invoiceDate").setHidden(true);
//				dssinvoiceitiorcount.getField("outputTax").setHidden(true);
//				dssinvoiceitiorcount.getField("noTaxAmount").setHidden(true);
//				dssinvoiceitiorcount.getField("taxRate").setHidden(true);
//				dssinvoiceitiorcount.getField("invoiceAmount").setHidden(true);
//				dssinvoiceitiorcount.getField("clientName").setHidden(true);
//				dssinvoiceitiorcount.getField("contractName").setHidden(true);
//				dssinvoiceitiorcount.getField("contractCode").setHidden(true);
				
				//控制按钮隐藏
				controlLayout.getMember(3).hide();
				controlLayout.getMember(4).hide();
				controlLayout.getMember(5).hide();
				controlLayout.getMember(6).hide();
				searchForm.setHeight(100);
//				resultGrid.setDataSource(dssinvoiceitiorcount);
				ListGridField ticketingCompanyField = new ListGridField("ticketingCompany", 100);  
				ticketingCompanyField.setFrozen(true); 
				ListGridField invoiceTypeField = new ListGridField("invoiceType", 100);  
				ListGridField invoiceCodeField = new ListGridField("invoiceCode", 100);  
				ListGridField invoiceNumberField = new ListGridField("invoiceNumber", 100);
				resultGrid.setSelectionAppearance(SelectionAppearance.ROW_STYLE);
				resultGrid.setFields(ticketingCompanyField,invoiceTypeField,invoiceCodeField,invoiceNumberField);
//				resultGrid.setHeaderSpans(new HeaderSpan[] {
//				   new HeaderSpan("未使用", new String[] {"ticketingCompany","invoiceType","invoiceCode","invoiceNumber"}),
//			    });
				resultGrid.setShowGridSummary(false);
				setMinSign(0);
				setMaxSign(0);
				setIsUseInvoice(false);
				commonQuery();
			}
		});
        
        HLayout boxLayout=new HLayout(10);
        boxLayout.setWidth100();
        boxLayout.setLayoutLeftMargin(17);
        if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.INVOICES_MANAGEMENT_VIEW_ALL_DATA)) {
	        boxLayout.addMember(beforeButton);
	        boxLayout.addMember(afterButton);
		}
        boxLayout.addMember(useSelectSumLabel);
        
        VLayout centerLayout = new VLayout(5);
        centerLayout.addMember(boxLayout);
//        boxLayout.setHeight("");
        centerLayout.addMember(mainCanvas);
        main.addMember(centerLayout);
        if (__needControl && __controlPosition == LayoutConstant.RIGHT) {
            main.addMember(controlLayout);
        }
        if (__needControl && __controlPosition == LayoutConstant.BOTTOM) {
            resultLayout.addMember(toolBar);
        }
        
        resultLayout.addMember(main);

        if (Browser.getIsDesktop() && showPagination()) {
            pager = new PaginationPanel();
            resultLayout.addMember(pager);

            pager.getGotoButton().addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    TextItem item = pager.getGotoPage();
                    String strPageNo = item.getValueAsString();
                    if (strPageNo == null || strPageNo.equals("")) {
                        return;
                    }
                    currentPage = Integer.parseInt(strPageNo);
                    commonQuery();
                }
            });
            pager.getFirstButton().addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    currentPage = 1;
                    commonQuery();
                }
            });
            pager.getPreviousButton().addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    if (currentPage > 1) {
                        currentPage--;
                        commonQuery();
                    }
                }
            });
            pager.addKeyPressHandler(new KeyPressHandler() {

                @Override
                public void onKeyPress(KeyPressEvent event) {
                    if (event.getKeyName() != null) {
                        switch (event.getKeyName()) {
                            case "Arrow_Right":
                                if (currentPage < totalPages) {
                                    currentPage++;
                                    commonQuery();
                                }
                                break;
                            case "Arrow_Left":
                                if (currentPage > 1) {
                                    currentPage--;
                                    commonQuery();
                                }
                                break;
                        }
                    }
                }
            });
            pager.getNextButton().addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    if (currentPage < totalPages) {
                        currentPage++;
                        commonQuery();
                    }
                }
            });
            pager.getLastButton().addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    if (totalPages > 0) {
                        currentPage = totalPages;
                        commonQuery();
                    }
                }
            });
            pager.getRefreshButton().addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    commonQuery();
                }
            });
        }
        initComponents();
        if (showControlPanel()) {
            setControlLayoutWidth();
        }
        return layout;
    }
	
	private Integer minSign;
	
	private Integer maxSign;
	
	private Boolean isUseInvoice;//true : 是使用发票面板 ------false:未使用发票面板

	public Boolean getIsUseInvoice() {
		return isUseInvoice;
	}

	public void setIsUseInvoice(Boolean isUseInvoice) {
		this.isUseInvoice = isUseInvoice;
	}

	public Integer getMinSign() {
		return minSign;
	}

	public void setMinSign(Integer minSign) {
		this.minSign = minSign;
	}

	public Integer getMaxSign() {
		return maxSign;
	}

	public void setMaxSign(Integer maxSign) {
		this.maxSign = maxSign;
	}
	
	
}
