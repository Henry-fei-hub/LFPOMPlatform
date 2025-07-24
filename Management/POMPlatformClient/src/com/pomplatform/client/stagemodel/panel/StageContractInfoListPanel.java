package com.pomplatform.client.stagemodel.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.LoadingWindow;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.i18n.client.NumberFormat;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.stagemodel.datasource.DSStageContractInfoList;
import com.pomplatform.client.stagemodel.form.StageContractInfoListSearchForm;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.PrintPreviewCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.util.ValueCallback;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.PrintCanvas;
import com.smartgwt.client.widgets.PrintWindow;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class StageContractInfoListPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			StageContractInfoListPanel cm = new StageContractInfoListPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "StageContractInfoList";
		}

	}

	@Override
	public void init(){
		__layoutMode = LayoutConstant.LEFTRIGHT;
        __detailCanvas = new ArrayList<>();
        __controlPosition = LayoutConstant.RIGHT;
        __needPagenation = true;
        __needControl = true;
        __needViewPage = true;
		resultGrid = new DelicacyListGrid(){
			@Override
			protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
				if (BaseHelpUtils.getBigDecimalValue(record.getAttributeAsObject("revenuePercent")).compareTo(BaseHelpUtils.getBigDecimalValue(record.getAttributeAsObject("calculatePercent"))) > 0) {  //定稿标灰色
    				//黄色#F19E02;
					//紫色#E24BB3
    				//计算的百分比总和比营收百分比小的，即为可突破节点的合同，改变字体颜色
					return "color:#FF6600;";  
                } else{
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
		ListGridField[] fields = new ListGridField[9];
        int idx = 0;
        fields[idx] = new ListGridField("contractCode");
        idx++;
        fields[idx] = new ListGridField("contractName");
        idx++;
        fields[idx] = new ListGridField("signingMoneySum");
        idx++;
        fields[idx] = new ListGridField("revenue");
        idx++;
        fields[idx] = new ListGridField("revenuePercent");
        fields[idx].setCellFormatter(new CellFormatter() {  
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {  
                if (value != null) {  
                    NumberFormat nf = NumberFormat.getFormat("##0.00");  
                    try {  
                        return nf.format(BaseHelpUtils.getDoubleValue(value)*100)+"%";  
                    } catch (Exception e) {  
                        return value.toString();  
                    }  
                } else {  
                    return null;  
                }  
            }  
        });
        idx++;
        fields[idx] = new ListGridField("actualPercent");
        fields[idx].setCellFormatter(new CellFormatter() {  
        	public String format(Object value, ListGridRecord record, int rowNum, int colNum) {  
        		if (value != null) {  
        			NumberFormat nf = NumberFormat.getFormat("##0.00");  
        			try {  
        				return nf.format(BaseHelpUtils.getDoubleValue(value)*100)+"%";  
        			} catch (Exception e) {  
        				return value.toString();  
        			}  
        		} else {  
        			return null;  
        		}  
        	}  
        });
        idx++;
        fields[idx] = new ListGridField("invoiceAmount");
        idx++;
        fields[idx] = new ListGridField("capitalAmount");
        idx++;
        fields[idx] = new ListGridField("contractStatus");
        idx++;
        fields[idx] = new ListGridField("recordNo");
        resultGrid.setFields(fields);
        
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});

		IButton viewButton = new IButton("节点信息");
		viewButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){
							SC.say("请先选择一条数据");
							return;
						}
						Record selected = resultGrid.getSelectedRecords()[0];
						PopupWindow window = new PopupWindow("合同：" + selected.getAttribute("contractName") + "[" + selected.getAttribute("contractCode") + "]的小节点信息");
						window.setWidth100();
						window.setHeight100();
						ContractStageModelListPanel panel = new ContractStageModelListPanel();
						panel.setContractId(selected.getAttribute("contractId"));
						panel.commonQuery();
						window.addItem(panel);
						window.centerInPage();
						window.show();
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				});
			}
		});
		controlLayout.addMember(viewButton);
		
		IButton attachmentButton = new IButton("联查确认函");
		controlLayout.addMember(attachmentButton);
		attachmentButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){
							SC.say("请先选择一条数据");
							return;
						}
						Record selected = resultGrid.getSelectedRecords()[0];
						PopupWindow window = new PopupWindow("合同：" + selected.getAttribute("contractName") + "[" + selected.getAttribute("contractCode") + "]的确认函");
						window.setWidth100();
						window.setHeight100();
						OnLoadAttachmentDataOfAttachmentPanel panel = new OnLoadAttachmentDataOfAttachmentPanel();
						panel.setContractId(selected.getAttribute("contractId"));
						panel.commonQuery();
						window.addItem(panel);
						window.centerInPage();
						window.show();
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				});
			}
		});
		
		IButton invoiceButton = new IButton("联查发票");
		controlLayout.addMember(invoiceButton);
		invoiceButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){
							SC.say("请先选择一条数据");
							return;
						}
						Record selected = resultGrid.getSelectedRecords()[0];
						PopupWindow window = new PopupWindow("合同：" + selected.getAttribute("contractName") + "[" + selected.getAttribute("contractCode") + "]的发票");
						window.setWidth100();
						window.setHeight100();
						SinvoiceitiorcountPanel panel = new SinvoiceitiorcountPanel();
						panel.setContractId(selected.getAttribute("contractId"));
						panel.commonQuery();
						window.addItem(panel);
						window.centerInPage();
						window.show();
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				});
			}
		});
		
		IButton capitalButton = new IButton("联查回款");
		controlLayout.addMember(capitalButton);
		capitalButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){
							SC.say("请先选择一条数据");
							return;
						}
						Record selected = resultGrid.getSelectedRecords()[0];
						PopupWindow window = new PopupWindow("合同：" + selected.getAttribute("contractName") + "[" + selected.getAttribute("contractCode") + "]的回款");
						window.setWidth100();
						window.setHeight100();
						McapitalecoosmeorPanel panel = new McapitalecoosmeorPanel();
						panel.setContractId(selected.getAttribute("contractId"));
						panel.commonQuery();
						window.addItem(panel);
						window.centerInPage();
						window.show();
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				});
			}
		});
		
		IButton calculateAllButton = new IButton("计算所有合同");
		controlLayout.addMember(calculateAllButton);
		calculateAllButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						Map<String, Object> params = new HashMap<>();
		            	params.put("optType", "calculateAllContracts");
		            	DBDataSource.callOperation("EP_StageModelProcessor", params, new DSCallback() {
							
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								if(dsResponse.getStatus() >= 0){
									commonQuery();
								}else{
									ClientUtil.displayErrorMessage(dsResponse);
								}
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
		
		IButton printButton = new IButton("打印2017数据");
		controlLayout.addMember(printButton);
		printButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){
							SC.say("请选择一条记录");
							return;
						}
						Map<String, Object> params = new HashMap<>();
						params.put("optType", "get2017PrintHtml");
						params.put("contractId", resultGrid.getSelectedRecords()[0].getAttributeAsObject("contractId"));
						DBDataSource.callOperation("EP_StageModelProcessor", params, new DSCallback() {
							
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								if(dsResponse.getStatus() >= 0){
									Record record = dsResponse.getData()[0];
									if(null != record){
										PopupWindow window = new PopupWindow();
										HTMLPane htmlPane = new HTMLPane();  
								        htmlPane.setWidth100();  
								        htmlPane.setHeight100();  
								        htmlPane.setShowEdges(true);  
								        htmlPane.setBackgroundColor("#fff");
								        htmlPane.setContents(record.getAttribute("value"));  
								        htmlPane.setSelectContentOnSelectAll(true);  
								        htmlPane.draw(); 
								        htmlPane.show();
								        window.addMember(htmlPane);
								        window.setWidth100();
								        window.setHeight100();
								        window.centerInPage();
								        window.show();
								        Object[] arr = new Object[1];
										arr[0] = htmlPane;
										showPrintPreview(arr, null, "查看/打印", new PrintPreviewCallback() {
											@Override
											public void execute(PrintCanvas printCanvas, PrintWindow printWindow) {
												printWindow.addCloseClickHandler(new CloseClickHandler() {
													@Override
													public void onCloseClick(CloseClickEvent event) {
														htmlPane.destroy();
														window.destroy();
													}
												});
											}
										});
									}
								}else{
									ClientUtil.displayErrorMessage(dsResponse);
								}
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
		
		IButton print2Button = new IButton("指定年度打印");
		controlLayout.addMember(print2Button);
		print2Button.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()) {
							SC.say("请选择需要打印的合同");
							return;
						}
						SC.askforValue("请输入需要打印的年度", new ValueCallback() {
							
							@Override
							public void execute(String value) {
								if(BaseHelpUtils.isNullOrEmpty(value)) {
									SC.say("请输入年份");
									return;
								}
								Map<String, Object> params = new HashMap<>();
								params.put("optType", "getPrintHtmlByYear");
								params.put("year", value);
								if(resultGrid.anySelected()) {
									Record[] records = resultGrid.getSelectedRecords();
									StringBuilder sb = new StringBuilder();
									for(Record r : records) {
										String contractId = r.getAttribute("contractId");
										if(!BaseHelpUtils.isNullOrEmpty(contractId)) {
											if(sb.length() > 0) {
												sb.append(",");
											}
											sb.append(contractId);
										}
									}
									params.put("contractIds", sb.toString());
								}
								final LoadingWindow loading = new LoadingWindow();
								DBDataSource.callOperation("EP_StageModelProcessor", params, new DSCallback() {
									
									@Override
									public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
										loading.destroy();
										if(dsResponse.getStatus() >= 0){
											Record record = dsResponse.getData()[0];
											if(null != record){
												PopupWindow window = new PopupWindow();
												HTMLPane htmlPane = new HTMLPane();  
												htmlPane.setWidth100();  
												htmlPane.setHeight100();  
												htmlPane.setShowEdges(true);  
												htmlPane.setBackgroundColor("#fff");
												htmlPane.setContents(record.getAttribute("value"));  
												htmlPane.setSelectContentOnSelectAll(true);  
												htmlPane.draw(); 
												htmlPane.show();
												window.addMember(htmlPane);
												window.setWidth100();
												window.setHeight100();
												window.centerInPage();
												window.show();
												Object[] arr = new Object[1];
												arr[0] = htmlPane;
												showPrintPreview(arr, null, "查看/打印", new PrintPreviewCallback() {
													@Override
													public void execute(PrintCanvas printCanvas, PrintWindow printWindow) {
														printWindow.addCloseClickHandler(new CloseClickHandler() {
															@Override
															public void onCloseClick(CloseClickEvent event) {
																htmlPane.destroy();
																window.destroy();
															}
														});
													}
												});
											}
										}else{
											ClientUtil.displayErrorMessage(dsResponse);
										}
									}
								});
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
		
		IButton print3Button = new IButton("打印最后节点");
		controlLayout.addMember(print3Button);
		print3Button.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {

					@Override
					public void onSuccess() {
						SC.askforValue("请输入需要打印最后一个节点数据的年份", new ValueCallback() {
							
							@Override
							public void execute(String value) {
								if(BaseHelpUtils.isNullOrEmpty(value)) {
									SC.say("请输入年份");
									return;
								}
								Map<String, Object> params = new HashMap<>();
								params.put("optType", "getLastPointPrintHtmlByYear");
								params.put("year", value);
								final LoadingWindow loading = new LoadingWindow();
								DBDataSource.callOperation("EP_StageModelProcessor", params, new DSCallback() {
									
									@Override
									public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
										loading.destroy();
										if (dsResponse.getStatus() >= 0) {
											Record record = dsResponse.getData()[0];
											if (null != record) {
												PopupWindow window = new PopupWindow();
												HTMLPane htmlPane = new HTMLPane();
												htmlPane.setWidth100();
												htmlPane.setHeight100();
												htmlPane.setShowEdges(true);
												htmlPane.setBackgroundColor("#fff");
												htmlPane.setContents(record.getAttribute("value"));
												htmlPane.setSelectContentOnSelectAll(true);
												htmlPane.draw();
												htmlPane.show();
												window.addMember(htmlPane);
												window.setWidth100();
												window.setHeight100();
												window.centerInPage();
												window.show();
												Object[] arr = new Object[1];
												arr[0] = htmlPane;
												showPrintPreview(arr, null, "查看/打印", new PrintPreviewCallback() {
													@Override
													public void execute(PrintCanvas printCanvas, PrintWindow printWindow) {
														printWindow.addCloseClickHandler(new CloseClickHandler() {
															@Override
															public void onCloseClick(CloseClickEvent event) {
																htmlPane.destroy();
																window.destroy();
															}
														});
													}
												});
											}
										} else {
											ClientUtil.displayErrorMessage(dsResponse);
										}
									}
								});
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
		commonQuery();
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		List<Map> keyvalues = new ArrayList<>();
		if(criteria.containsKey("contractStatus") && null != criteria.get("contractStatus")){
			String contractStatus = criteria.get("contractStatus").toString().replace("[", "").replace("]", "");
			if(contractStatus.indexOf(",") >= 0){
				criteria.remove("contractStatus");
				Map<String, String> kv = new HashMap<>();
				kv.put("key", "and c.contract_status = ");
				kv.put("value", "and c.contract_status in (" + contractStatus +") and c.contract_status = ");
				keyvalues.add(kv);
			}else{
				//单选
				criteria.put("contractStatus", contractStatus);
			}
		}
		if(keyvalues.size() > 0){
			criteria.put("keyValues", keyvalues);
		}
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new StageContractInfoListSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSStageContractInfoList.getInstance();
	}


}

