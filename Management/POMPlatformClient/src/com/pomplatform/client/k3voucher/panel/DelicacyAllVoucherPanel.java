package com.pomplatform.client.k3voucher.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.DelicacyPanel;
import com.delicacy.client.MapUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.PopupWindow;
import com.delicacy.client.ui.ViewProcessWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.reimbursement.form.NewK3VoucherListForm;
import com.pomplatform.client.reimbursement.form.UpdateK3VoucherListForm;
import com.pomplatform.client.reimbursement.panel.ReimbursementpackagemmrorPanel;
import com.pomplatform.client.sinvoiceitiorcount.panel.VoucherSinvoiceitiorcountPanel;
import com.pomplatform.client.sreimbursementpackagemmror.panel.UpdateReimbursementpackagePanel;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.util.ValueCallback;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class DelicacyAllVoucherPanel extends DelicacyPanel {

	private static Logger __logger = Logger.getLogger("");
	
	private AllVoucherSummaryPanel summaryPanel ;
	
	private CustomAllVoucherDetailPanel detailPanel;

	@Override
	public Canvas getViewPanel() {
		detailPanel = new CustomAllVoucherDetailPanel();
		summaryPanel = new AllVoucherSummaryPanel();
		
		HLayout mainLayout = new HLayout();
		mainLayout.setHeight100();
		mainLayout.setWidth100();
		
		summaryPanel.setWidth("25%");
		summaryPanel.setHeight100();
		summaryPanel.setDetailPanel(detailPanel);
		detailPanel.setWidth("*");
		detailPanel.setHeight100();
		mainLayout.addMember(summaryPanel);
		mainLayout.addMember(detailPanel);
		
		VLayout rightButtonLayout = new VLayout();
		rightButtonLayout.setHeight100();
		rightButtonLayout.setWidth(120);
		rightButtonLayout.setMembersMargin(3);
		rightButtonLayout.addMember(rightTopButtonLayout());
		rightButtonLayout.addMember(rightMidButtonLayout());
		rightButtonLayout.addMember(rightBottomButtonLayout());
		
		mainLayout.addMember(rightButtonLayout);
		return mainLayout;
	}

	public static class Factory implements PanelFactory {

		private String id;

		@Override
		public Canvas create() {
			DelicacyAllVoucherPanel cm = new DelicacyAllVoucherPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "DelicacyAllVoucherPanel";
		}

	}

	public Map generateDownloadCondition(boolean downloadAll) {
		Map condition = summaryPanel.generateCriteria();
		if(!downloadAll) {
			if(!summaryPanel.getResultGrid().anySelected()) {
				SC.say("请选择需要导出的凭证");
				return null;
			}
			Record[] records = summaryPanel.getResultGrid().getSelectedRecords();
			StringBuilder sb = new StringBuilder();
			for(Record r : records) {
				if(sb.length() > 0) {
					sb.append(",");
				}
				sb.append(r.getAttribute("sequenceNumber"));
			}
			Map<String, String> keyValue = new HashMap<>();
			keyValue.put("key", "and sequence_number = ?");
			keyValue.put("value", "and sequence_number = ? and sequence_number in (" + sb.toString() + ")");
			List<Map> keyValues = new ArrayList<>();
			keyValues.add(keyValue);
			condition.put("keyValues", keyValues);
		}
		condition.put("employeeName", ClientUtil.getUserName());
		return condition;
	}
	
	public VLayout rightTopButtonLayout() {
		VLayout buttonLayout = new VLayout();
		buttonLayout.setBackgroundColor("#E2E2E2");
		buttonLayout.setHeight("33%");
        buttonLayout.setWidth100();
        buttonLayout.setLayoutTopMargin(10);
        buttonLayout.setLayoutLeftMargin(10);
        buttonLayout.setLayoutRightMargin(5);
        buttonLayout.setMembersMargin(10);
        
		IButton button1 = new IButton("成本凭证");
		buttonLayout.addMember(button1);
		button1.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						PopupWindow window = new PopupWindow();
						ReimbursementpackagemmrorPanel panel = new ReimbursementpackagemmrorPanel();
						window.addMember(panel);
						window.setTitle("未生成凭证的汇总单");
						window.setWidth100();
						window.setHeight100();
						window.centerInPage();
						window.show();
						window.addCloseClickHandler(new CloseClickHandler() {
							
							@Override
							public void onCloseClick(CloseClickEvent event) {
								summaryPanel.commonQuery();
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
		
		IButton button2 = new IButton("账单流水凭证");
		buttonLayout.addMember(button2);
		button2.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						PopupWindow window = new PopupWindow();
						GenerateCapitalVoucherPanel panel = new GenerateCapitalVoucherPanel();
						Map map = summaryPanel.generateCriteria();
						if(!BaseHelpUtils.isNullOrEmpty(map.get("voucherYear"))) {
							panel.setYear(BaseHelpUtils.getIntValue(map.get("voucherYear")));
						}
						if(!BaseHelpUtils.isNullOrEmpty(map.get("voucherMonth"))) {
							panel.setMonth(BaseHelpUtils.getIntValue(map.get("voucherMonth")));
						}
						if(!BaseHelpUtils.isNullOrEmpty(map.get("companyId"))) {
							panel.setCompanyId(BaseHelpUtils.getIntValue(map.get("companyId")));
						}
						panel.commonQuery();
						window.addMember(panel);
						window.setTitle("未生成凭证的账单流水");
						window.setWidth100();
						window.setHeight100();
						window.centerInPage();
						window.show();
						window.addCloseClickHandler(new CloseClickHandler() {
							
							@Override
							public void onCloseClick(CloseClickEvent event) {
								summaryPanel.commonQuery();
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
		
		IButton button3 = new IButton("五险一金凭证");
		buttonLayout.addMember(button3);
		button3.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						PopupWindow window = new PopupWindow("生成五险一金凭证");
						CreateInsuranceAndHousingFundK3VoucherPanel panel = new CreateInsuranceAndHousingFundK3VoucherPanel();
						panel.setOperationName("EP_AllK3VoucherProcessor");
						panel.setOptType("createInsuranceAndHousingFundK3Voucher");
						panel.addDataEditedHandler(new DataEditedHandler() {
							@Override
							public void onDataEdited(DataEditEvent event) {
								summaryPanel.commonQuery();
							}
						});
						panel.setParentCanvas(window);
						panel.setFatherWindow(window);
						window.addItem(panel);
						window.setWidth("30%");
						window.setHeight("35%");
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
		
		IButton button4 = new IButton("工资凭证");
		buttonLayout.addMember(button4);
		button4.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						PopupWindow window = new PopupWindow("生成工资凭证");
						CreateSalaryK3VoucherPanel panel = new CreateSalaryK3VoucherPanel();
						panel.addDataEditedHandler(new DataEditedHandler() {
							@Override
							public void onDataEdited(DataEditEvent event) {
								summaryPanel.commonQuery();
							}
						});
						panel.setParentCanvas(window);
						panel.setFatherWindow(window);
						window.addItem(panel);
						window.setWidth("30%");
						window.setHeight("45%");
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
		
		IButton button5 = new IButton("营收凭证");
		buttonLayout.addMember(button5);
		button5.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						PopupWindow window = new PopupWindow("生成营收凭证");
						CreateRevenueK3VoucherPanel panel = new CreateRevenueK3VoucherPanel();
						panel.addDataEditedHandler(new DataEditedHandler() {
							@Override
							public void onDataEdited(DataEditEvent event) {
								summaryPanel.commonQuery();
							}
						});
						panel.setParentCanvas(window);
						panel.setFatherWindow(window);
						window.addItem(panel);
						window.setWidth("30%");
						window.setHeight("45%");
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
		
		IButton button6 = new IButton("发票凭证");
		buttonLayout.addMember(button6);
		button6.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						PopupWindow window = new PopupWindow("未生成凭证的发票");
						VoucherSinvoiceitiorcountPanel panel = new VoucherSinvoiceitiorcountPanel();
						window.addItem(panel);
						window.setWidth100();
						window.setHeight100();
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
		
		IButton button7 = new IButton("银行手续费");
		buttonLayout.addMember(button7);
		button7.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						PopupWindow window = new PopupWindow("生成银行手续费的凭证");
						CreateInsuranceAndHousingFundK3VoucherPanel panel = new CreateInsuranceAndHousingFundK3VoucherPanel();
						panel.setOperationName("EP_AllK3VoucherProcessor");
						panel.setOptType("createBankTransK3Voucher");
						panel.addDataEditedHandler(new DataEditedHandler() {
							@Override
							public void onDataEdited(DataEditEvent event) {
								summaryPanel.commonQuery();
							}
						});
						panel.setParentCanvas(window);
						panel.setFatherWindow(window);
						window.addItem(panel);
						window.setWidth("30%");
						window.setHeight("35%");
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
		return buttonLayout;
	}
	
	public VLayout rightMidButtonLayout() {
		VLayout buttonLayout = new VLayout();
		buttonLayout.setBackgroundColor("#E2E2E2");
		buttonLayout.setHeight("33%");
		buttonLayout.setWidth100();
		buttonLayout.setLayoutTopMargin(15);
		buttonLayout.setLayoutLeftMargin(10);
		buttonLayout.setLayoutRightMargin(5);
		buttonLayout.setMembersMargin(10);
		
		IButton viewPackageInfoButton = new IButton("联查汇总单");
		buttonLayout.addMember(viewPackageInfoButton);
		viewPackageInfoButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						DelicacyListGrid grid = summaryPanel.getResultGrid();
						if(!grid.anySelected()) {
							SC.say("请选择一条数据");
							return;
						}
						Record selected = grid.getSelectedRecord();
						if(BaseHelpUtils.getIntValue(selected.getAttribute("reimbursementPackageId")) == 0) {
							SC.say("该记录没有报表汇总单");
							return;
						}
						boolean isCompleted = true;
						boolean isTopUpdate = false;//顶部的修改标志
						boolean isBottomUpdate = false;//底部的修改标志
						PopupWindow pw = new PopupWindow();
						pw.setWidth100();
						pw.setHeight100();
						int packageId = selected.getAttributeAsInt("reimbursementPackageId");
						UpdateReimbursementpackagePanel panel = new UpdateReimbursementpackagePanel(packageId, isTopUpdate, isBottomUpdate, isCompleted, null);
						panel.setPackageId(packageId);
						panel.setFatherWindow(pw);
						panel.startEdit();
						panel.addDataEditedHandler(new DataEditedHandler() {
							@Override
							public void onDataEdited(DataEditEvent event) {
								SC.say("提示", "操作成功");
							}
						});
						panel.setParentCanvas(pw);
						pw.addItem(panel);
						pw.setTitle("报销单打包详情");
						pw.setWidth100();
						pw.setHeight100();
						pw.centerInPage();
						pw.show();
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				});
			}
		});
		
		IButton lockButton = new IButton("定稿");
		buttonLayout.addMember(lockButton);
		lockButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say("fail to download");
					}
					
					@Override
					public void onSuccess() {
						if(!summaryPanel.getResultGrid().anySelected()){
							SC.say("请选择需要定稿的凭证");
						}else{
							SC.confirm("确定要将选中的凭证定稿吗？", new BooleanCallback() {
								
								@Override
								public void execute(Boolean value) {
									if(value){
										Map<String, Object> params = new HashMap<>();
										params.put("optType", "lockVoucher");
										MapUtils.convertRecordToMap(summaryPanel.getResultGrid().getDataSource(), summaryPanel.getResultGrid().getSelectedRecords(), params,
												"list");
										DBDataSource.callOperation("EP_AllK3VoucherProcessor", params, new DSCallback() {
											@Override
											public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
												if (dsResponse.getStatus() < 0) {
													ClientUtil.displayErrorMessage(dsResponse);
												} else {
													summaryPanel.commonQuery();
												}
											}
										});
									}
								}
							});
						}
					}
					
				});
			}
		});
		
		IButton unlockButton = new IButton("取消定稿");
		buttonLayout.addMember(unlockButton);
		unlockButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if(!summaryPanel.getResultGrid().anySelected()){ SC.say("请选择一条数据"); return;}
						SC.confirm("确定要将选中的凭证取消定稿吗？", new BooleanCallback() {
							
							@Override
							public void execute(Boolean value) {
								if(value){
									Map<String, Object> params = new HashMap<>();
									MapUtils.convertRecordToMap(summaryPanel.getResultGrid().getDataSource(), summaryPanel.getResultGrid().getSelectedRecords(), params,
											"list");
									//根据凭证号来取消定稿
									params.put("optType", "unlockVoucherBySequenceNumber");
									DBDataSource.callOperation("EP_AllK3VoucherProcessor", params, new DSCallback() {
										
										@Override
										public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
											if(dsResponse.getStatus() >= 0){
												summaryPanel.commonQuery();
											}else{
												ClientUtil.displayErrorMessage(dsResponse);
											}
										}
									});
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
		
		IButton removeButton = new IButton("删除");
		buttonLayout.addMember(removeButton);
		removeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!summaryPanel.getResultGrid().anySelected()) {
					SC.say("Please select a data to remove.");
					return;
				}
				ListGridRecord[] records = summaryPanel.getResultGrid().getSelectedRecords();
				for(ListGridRecord record : records){
					if(record.getAttributeAsBoolean("locked")){
						SC.say("编号[" + record.getAttribute("reimbursementPackageCode") + "]，凭证号[" + record.getAttribute("sequenceNumber") + "]已定稿，不能执行删除操作");
						return;
					}
				}
				SC.confirm("确定要删除这些凭证吗？", new BooleanCallback() {
					@Override
					public void execute(Boolean value) {
						if(value){
							Map<String, Object> params = new HashMap<>();
							params.put("optType", "deleteVoucherByCode");
							MapUtils.convertRecordToMap(summaryPanel.getResultGrid().getDataSource(), summaryPanel.getResultGrid().getSelectedRecords(), params,
									"list");
							DBDataSource.callOperation("EP_AllK3VoucherProcessor", params, new DSCallback() {
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if (dsResponse.getStatus() < 0) {
										ClientUtil.displayErrorMessage(dsResponse);
									} else {
										summaryPanel.commonQuery();
									}
								}
							});
						}
					}
				});
			}
		});
		
		IButton downloadK3Button = new IButton("导出K3凭证");
		buttonLayout.addMember(downloadK3Button);
		downloadK3Button.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				SC.ask("导出类型选择", "选【是】导出根据条件筛选之后的凭证，<br>选【否】则只导出选中的凭证", new BooleanCallback() {
					
					@Override
					public void execute(Boolean value) {
						Map condition = generateDownloadCondition(value);
						if(null == condition) {
							return;
						}
						condition.put("downloadType", "k3");
						DBDataSource.downloadFile("DW_DownloadVoucher", condition);
					}
				});
			}
		});
		
		IButton downloadYonYouButton = new IButton("导出用友凭证");
		buttonLayout.addMember(downloadYonYouButton);
		downloadYonYouButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				SC.ask("导出类型选择", "选【是】导出根据条件筛选之后的凭证，<br>选【否】则只导出选中的凭证", new BooleanCallback() {
					
					@Override
					public void execute(Boolean value) {
						Map condition = generateDownloadCondition(value);
						if(null == condition) {
							return;
						}
						condition.put("downloadType", "yonyou");
						DBDataSource.downloadFile("DW_DownloadVoucher", condition);
					}
				});
			}
		});
		
		
		IButton dateButton = new IButton("归属日期");
		buttonLayout.addMember(dateButton);
		dateButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						SC.askforValue("请输入归属日期，例：2017-01-01", new ValueCallback() {
							@Override
							public void execute(String value) {
								if(BaseHelpUtils.isNullOrEmpty(value)) {
									return;
								}
								Map<String, Object> params = new HashMap<>();
								params.put("optType", "updateVestingDate");
								params.put("vestingDate", value);
								MapUtils.convertRecordToMap(summaryPanel.getResultGrid().getDataSource(), summaryPanel.getResultGrid().getSelectedRecords(), params,
										"list");
								DBDataSource.callOperation("EP_AllK3VoucherProcessor", params, new DSCallback() {
									@Override
									public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
										if (dsResponse.getStatus() < 0) {
											ClientUtil.displayErrorMessage(dsResponse);
										} else {
											summaryPanel.commonQuery();
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
		return buttonLayout;
	}
	
	public VLayout rightBottomButtonLayout() {
		VLayout buttonLayout = new VLayout();
		buttonLayout.setBackgroundColor("#E2E2E2");
		buttonLayout.setHeight("33%");
		buttonLayout.setWidth100();
		buttonLayout.setLayoutTopMargin(30);
		buttonLayout.setLayoutLeftMargin(10);
		buttonLayout.setLayoutRightMargin(5);
		buttonLayout.setMembersMargin(10);
		
		IButton viewReimbursementButton = new IButton("查看报销单");
		buttonLayout.addMember(viewReimbursementButton);
		viewReimbursementButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
					@Override
					public void onSuccess() {
						if(!detailPanel.getResultGrid().anySelected()) {
							SC.say("请选择一条数据");
							return;
						}
						Record record = detailPanel.getResultGrid().getSelectedRecord();
						if(BaseHelpUtils.isNullOrEmpty(record.getAttribute("processInstanceId"))) {
							SC.say("该记录没有关联流程数据");
							return;
						}
						ViewProcessWindow Reimbursement = new ViewProcessWindow();
						Reimbursement.setWidth("80%");
						Reimbursement.setHeight("80%");
						Reimbursement.setLayoutMode(0);
						Reimbursement.setInstanceData(record);
						Reimbursement.initComponents();
						Reimbursement.setTitle(ClientUtil.getProcessTypeName(record));
						Reimbursement.show();
					}
				});
			}
		});
		
		IButton newDetailButton = new IButton("新建凭证明细");
		buttonLayout.addMember(newDetailButton);
		newDetailButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
					@Override
					public void onSuccess() {
						NewK3VoucherListForm detailForm = new NewK3VoucherListForm();
						Record[] records = detailPanel.getResultGrid().getRecords();
						Record record = new Record();
						record.setAttribute("sequenceNumber", records[0].getAttribute("sequenceNumber"));
						record.setAttribute("reimbursementPackageCode", records[0].getAttribute("reimbursementPackageCode"));
						record.setAttribute("companyId", records[0].getAttribute("companyId"));
						record.setAttribute("internalSequenceNumber", records.length);
						if(null != records[0].getAttribute("vestingDate")){
							record.setAttribute("vestingDate", records[0].getAttributeAsDate("vestingDate"));
						}
						detailForm.setRecord(record);
						detailForm.setTitle("新建");
						detailForm.addDataEditedHandler(new DataEditedHandler(){
							@Override
							public void onDataEdited(DataEditEvent event) {
								detailPanel.commonQuery();
							}
						});
						detailForm.initComponents();
						detailForm.startEdit();
						detailForm.setWidth100();
						detailForm.setHeight100();
						detailForm.centerInPage();
						detailForm.show();
					}
				});
			}
		});
		
		IButton updateDetailButton = new IButton("修改凭证明细");
		buttonLayout.addMember(updateDetailButton);
		updateDetailButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download code");
					}
					@Override
					public void onSuccess() {
						if(!detailPanel.getResultGrid().anySelected()){ SC.say("请选择一条数据修改"); return;}
						final ListGridRecord selected1 = detailPanel.getResultGrid().getSelectedRecord();
						UpdateK3VoucherListForm detailForm = new UpdateK3VoucherListForm();
						detailForm.setTitle("修改");
						detailForm.addDataEditedHandler(new DataEditedHandler(){
							@Override
							public void onDataEdited(DataEditEvent event) {
								detailPanel.commonQuery();
							}
						});
						detailForm.setRecord(selected1);
						detailForm.initComponents();
						detailForm.startEdit();
						detailForm.setWidth100();
						detailForm.setHeight100();
						detailForm.centerInPage();
						detailForm.show();
					}
				});
			}
		});
		
		IButton deleteDetailButton = new IButton("删除凭证明细");
		buttonLayout.addMember(deleteDetailButton);
		deleteDetailButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download code");
					}
					@Override
					public void onSuccess() {
						if(!detailPanel.getResultGrid().anySelected()){ SC.say("请选择一条数据"); return;}
						final ListGridRecord selected1 = detailPanel.getResultGrid().getSelectedRecord();
						SC.confirm("确定要删除这条记录吗？", new BooleanCallback() {
							
							@Override
							public void execute(Boolean value) {
								if(value) {
									DBDataSource.callOperation("ST_K3Voucher", "delete", selected1.toMap(), new DSCallback() {
										@Override
										public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
											if (dsResponse.getStatus() < 0) {
												ClientUtil.displayErrorMessage(dsResponse);
											} else {
												detailPanel.commonQuery();
											}
										}
									});
								}
							}
						});
					}
				});
			}
		});
		return buttonLayout;
	}
}

