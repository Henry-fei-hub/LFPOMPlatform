package com.pomplatform.client.sinvoiceitiorcount.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.delicacy.client.PaginationPanel;
import com.delicacy.client.PanelFactory;
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
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.sinvoiceitiorcount.datasource.DSSinvoiceitiorcount;
import com.pomplatform.client.sinvoiceitiorcount.form.SinvoiceitiorcountSearchForm;
import com.pomplatform.client.sinvoiceitiorcount.form.SinvoiceitiorcountViewer;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.util.Browser;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
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
public class VoucherSinvoiceitiorcountPanel extends AbstractSearchPanel {
	
	private SinvoiceitiorcountSearchForm sinvoiceitiorcountSearchForm;
	
	private DSSinvoiceitiorcount dssinvoiceitiorcount;
	
	public static Label useSelectSumLabel; //选中后统计

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			VoucherSinvoiceitiorcountPanel cm = new VoucherSinvoiceitiorcountPanel();
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
		customerIdField.setShowGridSummary(false);
		KeyValueManager.loadValueMap("customers", customerIdField);
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
		
		IButton conContractBtn = new IButton("关联合同");
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
		
		IButton createVoucherButton = new IButton("生成凭证");
		createVoucherButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						createVoucherButton.setDisabled(true);
						if(!resultGrid.anySelected()){
							SC.say("请选择一条数据");
							createVoucherButton.setDisabled(false);
							return;
						}
						Record[] records = resultGrid.getSelectedRecords();
						int length = records.length;
						Object[] ids = new Object[length];
						for(int i = 0; i < length; i++){
							ids[i] = records[i].getAttribute("invoiceId");
						}
						Map<String, Object> params = new HashMap<>();
						params.put("invoiceId", ids);
						params.put("optType", "createInvoiceK3Voucher");
						DBDataSource.callOperation("EP_AllK3VoucherProcessor", params, new DSCallback() {
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								if (dsResponse.getStatus() < 0) {
									ClientUtil.displayErrorMessage(dsResponse);
								} else {
									SC.say("凭证生成成功");
									commonQuery();
								}
								createVoucherButton.setDisabled(false);
							}
						});
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				});
			}
		});
		controlLayout.addMember(createVoucherButton);
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
		criteria.put("addtionalCondition", "order by invoice_id");
		criteria.put("minSign", getMinSign());
		criteria.put("maxSign", getMaxSign());
		List<Map<String, String>> list = new ArrayList<>();
		Map<String, String> kv = new HashMap<>();
		kv.put("key", "HAVING i.have_voucher = ?");
		kv.put("value", "having 1 = ? and kv.link_id is null");
		list.add(kv);
		criteria.put("keyValues", list);
		criteria.remove("haveVoucher");
		return true;
	}
	
	@Override
	public SearchForm generateSearchForm() {
		sinvoiceitiorcountSearchForm = new SinvoiceitiorcountSearchForm();
		sinvoiceitiorcountSearchForm.getItem("haveVoucher").hide();
		sinvoiceitiorcountSearchForm.getItem("haveVoucher").setDefaultValue(false);
		return sinvoiceitiorcountSearchForm;
	}

	@Override
	public DataSource getDataSource() {
		dssinvoiceitiorcount = DSSinvoiceitiorcount.getInstance();
		return dssinvoiceitiorcount;
	}
	
	@Override
	public int getSearchFormHeight() {
		return 158;
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
        layout.addMember(resultLayout);
        
        
        HLayout boxLayout=new HLayout(10);
        boxLayout.setWidth100();
        boxLayout.setLayoutLeftMargin(17);
        boxLayout.addMember(useSelectSumLabel);
        
        VLayout centerLayout = new VLayout(5);
        centerLayout.addMember(boxLayout);
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
