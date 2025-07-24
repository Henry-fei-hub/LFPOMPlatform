package com.pomplatform.client.stagemodel.panel;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.PopupWindow;
import com.delicacy.client.ui.ViewProcessWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.capitaldistribution.panel.CapitalDistributionBarChartPanel;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.receivables.datasource.DSMcapitalecoosmeor;
import com.pomplatform.client.receivables.form.McapitalecoosmeorSearchForm;
import com.pomplatform.client.receivables.form.McapitalecoosmeorViewer;
import com.pomplatform.client.receivables.form.NewMcapitalecoosmeorForm;
import com.pomplatform.client.receivables.form.UpdateMcapitalecoosmeorForm;
import com.pomplatform.client.receivables.panel.CustomBingContractPanel;
import com.pomplatform.client.receivables.panel.PaymentDistributionPanel;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class McapitalecoosmeorPanel extends AbstractSearchPanel implements HasHandlers 
{

	private static Logger __LOGGER = Logger.getLogger("");
	
	public static DateTimeFormat __DF = DateTimeFormat.getFormat("yyyy-MM-dd hh:mm:ss");
	public static String minDateStr = "2017-01-01 00:00:00";
	
	private McapitalecoosmeorSearchForm searchForm ;
	
	protected final HandlerManager handlerManager = new HandlerManager(this);
	
	private IButton sureButton;
	
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			McapitalecoosmeorPanel cm = new McapitalecoosmeorPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Mcapitalecoosmeor";
		}

	}
	
	@Override
	public Canvas generateHDataCanvas() {
        resultGrid = new DelicacyListGrid() {  
            @Override  
            protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {  
//            	 if (getFieldName(colNum).equals("processStatus")) {  
            		 if (record.getAttributeAsInt("processStatus") == 3) {  
            			 return "color: #ABABAB;";
                     } else if (record.getAttributeAsInt("processStatus") == 0) {  
                    	 return "font-weight: bold;";
                     } else {  
                         return super.getCellCSSText(record, rowNum, colNum);  
                     }  
//            	 }else{
//            		 return super.getCellCSSText(record, rowNum, colNum);  
//            	 }
                
            }  
        };  
        resultGrid.setDataSource(getDataSource());
        resultGrid.setWidth100();
        resultGrid.setHeight100();
        return resultGrid;
    }
	
	@Override
	public void initComponents() {
		//设置行号
		resultGrid.setShowRowNumbers(true);
		//设置为可选的
		resultGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
        ListGridField moneyAttributeField = new ListGridField("moneyAttribute", 100);  
        moneyAttributeField.setFrozen(true);  
        moneyAttributeField.setShowGridSummary(false);
        ListGridField haveVoucherField = new ListGridField("haveVoucher", 80);  
        haveVoucherField.setShowGridSummary(false);
        ListGridField selfNameField = new ListGridField("selfName", 150);  
        selfNameField.setShowGridSummary(false);
        ListGridField selfBankNameField = new ListGridField("selfBankName", 150);
        ListGridField selfBankAccountField = new ListGridField("selfBankAccount", 100);
        ListGridField otherNameField = new ListGridField("otherName", 150);
//        ListGridField otherBankNameField = new ListGridField("otherBankName", 150);
//        ListGridField otherBankAccountField = new ListGridField("otherBankAccount", 100);
        ListGridField borrowMoneyField = new ListGridField("borrowMoney", 100);
        ListGridField loanMoneyField = new ListGridField("loanMoney", 100);
        ListGridField happenDateField = new ListGridField("happenDate", 150);
        ListGridField createDateField = new ListGridField("createDate", 150);
        ListGridField hasInvoicesField = new ListGridField("hasInvoices", 50);
        ListGridField hasContractReceivableField = new ListGridField("hasContractReceivable", 50);
        ListGridField employeeNameField = new ListGridField("employeeName", 100);
        ListGridField hasDistributionCollectionField = new ListGridField("hasDistributionCollection", 100);
        ListGridField contractCodeField = new ListGridField("contractCode", 100);
        ListGridField contractIdField = new ListGridField("contractId", 100);
        contractIdField.setShowGridSummary(false);
        ListGridField processStatusField = new ListGridField("processStatus", 100);
        ListGridField exchangeRateField = new ListGridField("exchangeRate", 100);
        ListGridField originalCurrencyField = new ListGridField("originalCurrency", 100);
//        processStatusField.setCellFormatter(new CellFormatter() {
//			
//			@Override
//			public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
//				if(null != value){ 
//					int status = BaseHelpUtils.getIntValue(record.getAttribute("processStatus"));
//					__LOGGER.info(status+"");
//					resultGrid.setBaseStyle("groupTitleStyleClick");
//					if(status == 3){
//						record.set_baseStyle("groupTitleStyleClick");
//					}
//					return value.toString();
//				};
//				return null;
//			}
//		});
        processStatusField.setShowGridSummary(false);
        
        employeeNameField.setShowGridSummary(false);
        ListGridField remarkField = new ListGridField("remark", 150);
		 
        resultGrid.setFields(moneyAttributeField,haveVoucherField,selfNameField,selfBankNameField,selfBankAccountField,otherNameField,
        		borrowMoneyField, loanMoneyField, exchangeRateField, originalCurrencyField, contractCodeField, contractIdField,happenDateField,createDateField,hasInvoicesField,
        		hasContractReceivableField,hasDistributionCollectionField,processStatusField,employeeNameField,remarkField);  
//        if(!ClientUtil.checkIsHavePermission(ERPPermissionStatic.BMZL_DATA)){
//        	 resultGrid.setShowGridSummary(true);
//		} 
       
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
		IButton operation1Button = new IButton("查看详情");
		controlLayout.addMember(operation1Button);
		operation1Button.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		
		IButton operation2Button = PermissionControl.createPermissionButton("流水登记", ERPPermissionStatic.LS_DJ);
		controlLayout.addMember(operation2Button);
		operation2Button.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download");
					}
					@Override
					public void onSuccess() {
						NewMcapitalecoosmeorForm detailForm = new NewMcapitalecoosmeorForm();
						detailForm.setTitle("流水登记");
						detailForm.addDataEditedHandler(new DataEditedHandler(){
							@Override
							public void onDataEdited(DataEditEvent event) {
								RecordList list = resultGrid.getDataAsRecordList();
								RecordList newList = new RecordList();
								newList.addList(list.getRange(0, list.getLength()));
								newList.add(event.getData());
								resultGrid.setData(newList);
								resultGrid.selectSingleRecord(newList.getLength()-1);
							}
						});
						detailForm.setSearchForm(searchForm);
						detailForm.initComponents();
						detailForm.startEdit();
						detailForm.setWidth("60%");
						detailForm.setHeight("60%");
						detailForm.centerInPage();
						detailForm.show();
					}
				});
			}
		});
		IButton operation3Button = PermissionControl.createPermissionButton("修改账单", ERPPermissionStatic.UPDATE_ZD);
		controlLayout.addMember(operation3Button);
		operation3Button.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download code");
					}
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){ SC.say("请选择一条数据修改"); return;}
						final ListGridRecord selected1 = resultGrid.getSelectedRecord();
						boolean hasInvoices=selected1.getAttributeAsBoolean("hasInvoices");
						boolean hasContractReceivable=selected1.getAttributeAsBoolean("hasContractReceivable");
						//只要绑定了发票或者合同阶段都不能修改
						if(hasInvoices){
							SC.say("账单绑定了发票不能修改");
							return;
						}
						if(hasContractReceivable){
							SC.say("账单绑定了合同阶段不能修改");
							return;
						}
						
						UpdateMcapitalecoosmeorForm detailForm = new UpdateMcapitalecoosmeorForm();
						detailForm.setTitle("修改账单");
						detailForm.addDataEditedHandler(new DataEditedHandler(){
							@Override
							public void onDataEdited(DataEditEvent event) {
								DBDataSource.copyRecord(event.getData(), selected1);
							}
						});
						detailForm.setSearchForm(searchForm);
						detailForm.setRecord(selected1);
						detailForm.setCurrentPage(getCurrentPage());
						detailForm.initComponents();
						detailForm.startEdit();
						detailForm.setWidth("60%");
						detailForm.setHeight("60%");
						detailForm.centerInPage();
						detailForm.show();
						setCurrentPage(detailForm.getCurrentPage());
					}
				});
			}
		});
		//绑定合同
		IButton bingContractButton =PermissionControl.createPermissionButton("绑定合同", ERPPermissionStatic.BING_HT);
		controlLayout.addMember(bingContractButton);
		bingContractButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				ListGridRecord[] selected = resultGrid.getSelectedRecords();
				int count=selected.length;
				if(count<=0){
					SC.say("请选择要绑定合同的流水账");
					return;
				}
				final StringBuffer contractId=new StringBuffer();
				//选中的ids
			    final StringBuilder ids=new StringBuilder();
				for(int i=0;i<selected.length;i++){
				    contractId.append(selected[i].getAttribute("contractId"));
					if(BaseHelpUtils.isNullOrEmpty(ids.toString())){
						int tempId=BaseHelpUtils.getIntValue(selected[i].getAttribute("capitalId"));
						if(tempId>0){
							ids.append(tempId);
						}
					}else{
						int tempId=BaseHelpUtils.getIntValue(selected[i].getAttribute("capitalId"));
						if(tempId>0){
							ids.append(",");
							ids.append(tempId);
						}
					}
				}
				__LOGGER.info("BaseHelpUtils.getIntValue(contractId)="+BaseHelpUtils.getIntValue(contractId+""));
				
				if(BaseHelpUtils.getIntValue(contractId+"")>0){
					SC.ask("已经绑定合同，是否要修改绑定的合同", new BooleanCallback() {
						@Override
						public void execute(Boolean value) {
							if(value){
								PopupWindow pw = new PopupWindow("绑定合同");
								CustomBingContractPanel panel=new CustomBingContractPanel(""+ids,BaseHelpUtils.getIntValue(contractId+""));
								panel.addDataEditedHandler(new DataEditedHandler() {
									@Override
									public void onDataEdited(DataEditEvent event) {
										commonQuery();
									}
								});
								panel.setPw(pw);
								pw.addCloseClickHandler(new CloseClickHandler() {
									
									@Override
									public void onCloseClick(CloseClickEvent event) {
										commonQuery();
									}
								});
								pw.addItem(panel);
								pw.setWidth("32%");
								pw.setHeight("32%");
								pw.centerInPage();
								pw.show();
							}
							
						}
					});
				}else{
					PopupWindow pw = new PopupWindow("绑定合同");
					CustomBingContractPanel panel=new CustomBingContractPanel(""+ids,0);
					panel.addDataEditedHandler(new DataEditedHandler() {
						@Override
						public void onDataEdited(DataEditEvent event) {
							commonQuery();
						}
					});
					panel.setPw(pw);
					pw.addCloseClickHandler(new CloseClickHandler() {
						
						@Override
						public void onCloseClick(CloseClickEvent event) {
							commonQuery();
						}
					});
					pw.addItem(panel);
					pw.setWidth("32%");
					pw.setHeight("32%");
					pw.centerInPage();
					pw.show();
				}
			}
		});
		 
		IButton exportButton = PermissionControl.createPermissionButton("导出", ERPPermissionStatic.DC_LS);
		controlLayout.addMember(exportButton);
		exportButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				SC.debugger();
				Map params=new HashMap();
				if(null != searchForm){
					 params=searchForm.getValues();
				}
				int val=BaseHelpUtils.getIntValue(params.get("isHasContract"));
				
//				if(val==1){
//					params.put("contractId", 1);
//				}else if(val==2){
//					params.put("contractId", 2);
//				}
				if (val==1) {
					List<Map> keyvalues = new ArrayList<>();
					Map<String, String> kv = new HashMap<>();
					kv.put("key", "c.contract_id= ?");
					kv.put("value", "(c.contract_id is null or c.contract_id= ? )");
					keyvalues.add(kv);
					params.put("contractId", 0);
					params.put("keyValues", keyvalues);
				} else if (val==2) {
					List<Map> keyvalues = new ArrayList<>();
					Map<String, String> kv = new HashMap<>();
					kv.put("key", "c.contract_id= ?");
					kv.put("value", "c.contract_id> ?");
					params.put("contractId", 0);
					keyvalues.add(kv);
					params.put("keyValues", keyvalues);
				}
				DBDataSource.downloadFile("DW_Mcapitalecoosmeor", params);
			}
		});
		IButton removeButton =PermissionControl.createPermissionButton("删除", ERPPermissionStatic.DEL_LS);
		controlLayout.addMember(removeButton);
		removeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("Please select a data to remove.");
				}
				final ListGridRecord selected = resultGrid.getSelectedRecord();
				SC.ask("确定要删除", new BooleanCallback() {
					@Override
					public void execute(Boolean value) {
						if(value){
							DBDataSource.callOperation("ST_Capital", "delete", selected.toMap(), new DSCallback() {
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
			}
		});
		//回款分配
		IButton addDepEmBtn = PermissionControl.createPermissionButton("回款分配", ERPPermissionStatic.HKFP_LS);
		controlLayout.addMember(addDepEmBtn);
		addDepEmBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				CapitalDistributionBarChartPanel panel = new CapitalDistributionBarChartPanel();
				panel.initComponents();
				panel.setContractId(resultGrid.getSelectedRecords()[0].getAttribute("contractId"));
				panel.loadData();
				PopupWindow window = new PopupWindow("回款分配");
				window.setWidth100();
				window.setHeight100();
				window.centerInPage();
				window.addMember(panel);
				window.show();
			}
		});
		IButton showProcessBtn = PermissionControl.createPermissionButton("查看回款流程", ERPPermissionStatic.HKFP_LS);;
		controlLayout.addMember(showProcessBtn);
		showProcessBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
                    SC.say("请选择一条数据");
                    return;
                }
				ListGridRecord selected = resultGrid.getSelectedRecord();
				Map params = selected.toMap();
				Integer businessId = selected.getAttributeAsInt("capitalDistributionId");
				if(null == businessId){
					SC.say("该回款没有进行分配");
					return;
				}
				params.put("opt_type", "getSystemInstanceData");
				params.put("processType", 11);
				params.put("businessId", businessId);
				DBDataSource.callOperation("EP_CollectionDistribution", params, new DSCallback() {
					
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() > 0){
							Record __record = dsResponse.getData()[0];
							ViewProcessWindow Reimbursement = new ViewProcessWindow();
			                Reimbursement.setWidth("80%");
			                Reimbursement.setHeight("80%");
			                Reimbursement.setLayoutMode(0);
			                Reimbursement.setInstanceData(__record);
			                Reimbursement.initComponents();
			                Reimbursement.setTitle(ClientUtil.getProcessTypeName(__record));
			                Reimbursement.show();
						} else {
							ClientUtil.displayErrorMessage(dsResponse);
						}
						
					}
				});
               
				
			}
		});
		
		IButton orderFpBtn = PermissionControl.createPermissionButton("手动回款分配", ERPPermissionStatic.SD_HKFP_LS);
		controlLayout.addMember(orderFpBtn);
		orderFpBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if (resultGrid.anySelected()) {
					int processStatus = resultGrid.getSelectedRecord().getAttributeAsInt("processStatus");
					int contractId = BaseHelpUtils.getIntValue(resultGrid.getSelectedRecord().getAttribute("contractId"));
					if(processStatus != 0 && processStatus != 3){
						SC.say("该收款不可进行手动回款");
						return;
					}
					if(contractId <= 0){
						SC.say("该收款没有绑定合同");
						return;
					}
					PopupWindow pw = new PopupWindow();
					PaymentDistributionPanel panel = new PaymentDistributionPanel(resultGrid, contractId);
					panel.startEdit();
					panel.addDataEditedHandler(new DataEditedHandler() {
						@Override
						public void onDataEdited(DataEditEvent event) {
							commonQuery();
							SC.say("提示", "操作成功");
						}
					});
					panel.setParentCanvas(pw);
					panel.setFatherWindow(pw);
					pw.addItem(panel);
					pw.setTitle("回款分配");
					pw.setWidth100();
					pw.setHeight100();
					pw.centerInPage();
					pw.show();
				} else {
					SC.say("请选择一条数据");
				}
				
			}
		});
		
		IButton createVoucherButton = PermissionControl.createPermissionButton("生成凭证", ERPPermissionStatic.ZD_SCPZ);
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
							ids[i] = records[i].getAttribute("capitalId");
						}
						Map<String, Object> params = new HashMap<>();
						params.put("capitalId", ids);
						params.put("optType", "createCapitalK3Voucher");
						DBDataSource.callOperation("EP_K3VoucherProcess", params, new DSCallback() {
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								if (dsResponse.getStatus() < 0) {
									ClientUtil.displayErrorMessage(dsResponse);
								} else {
									SC.say("凭证生成成功");
									for(Record record : records){
										record.setAttribute("haveVoucher", true);
									}
									resultGrid.redraw();
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
		IButton deleteVoucherButton = PermissionControl.createPermissionButton("删除凭证", ERPPermissionStatic.ZD_DPZ);
		deleteVoucherButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){
							SC.say("请选择一条数据");
							return;
						}
						Record[] records = resultGrid.getSelectedRecords();
						int length = records.length;
						Object[] ids = new Object[length];
						for(int i = 0; i < length; i++){
							ids[i] = records[i].getAttribute("capitalId");
						}
						Map<String, Object> params = new HashMap<>();
						params.put("capitalId", ids);
						params.put("optType", "deleteCapitalK3Voucher");
						DBDataSource.callOperation("EP_K3VoucherProcess", params, new DSCallback() {
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								if (dsResponse.getStatus() < 0) {
									ClientUtil.displayErrorMessage(dsResponse);
								} else {
									SC.say("凭证已删除");
									for(Record record : records){
										record.setAttribute("haveVoucher", false);
									}
									resultGrid.redraw();
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
		controlLayout.addMember(deleteVoucherButton);
		
		sureButton = new IButton("选为证据");
		sureButton.hide();
		controlLayout.addMember(sureButton);
		sureButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){
							SC.say("请选择一条数据");
							return;
						}
						if(BaseHelpUtils.isNullOrEmpty(ids)){
							SC.say("请选择需要证据佐证的节点");
							return;
						}
						Record record = resultGrid.getSelectedRecords()[0];
						String evidence = "回款金额：" + record.getAttribute("borrowMoney") + "; 回款备注：" + record.getAttribute("remark") + "; ID:" + record.getAttribute("capitalId");
						Date confirmDate = record.getAttributeAsDate("happenDate");
						Map<String, Object> params = new HashMap<>();
						params.put("optType", "selectEvidence");
						params.put("evidence", evidence);
						params.put("confirmDate", confirmDate);
						params.put("ids", ids);
						DBDataSource.callOperation("EP_StageModelProcessor", params, new DSCallback() {
							
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								if(dsResponse.getStatus() >= 0){
									DataEditEvent dee = new DataEditEvent();
									fireEvent(dee);
									if (null == getParentWindow()) {
										return;
									}
									getParentWindow().destroy();
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
				detail.setTitle("Mcapitalecoosmeor"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				McapitalecoosmeorViewer detailForm = new McapitalecoosmeorViewer();
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
		criteria.put("contractId", contractId);
		criteria.put("moneyAttribute", 1);
		Date minDate = __DF.parse(minDateStr);
		int val = BaseHelpUtils.getIntValue(criteria.get("isHasContract"));
//		if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.BMZL_DATA)){
////			if(null == criteria.get("minHappenDate")){
////				searchForm.getField("minHappenDate").setValue(minDate);
////				criteria.put("minHappenDate", minDate);
////			} else {
////				//当只有部门助理权限的时候  只能查看最小时间之后的
////				Date checkDate = (Date) criteria.get("minHappenDate");
////				if(checkDate.compareTo(minDate) < 0){
////					searchForm.getField("minHappenDate").setValue(minDate);
////					criteria.put("minHappenDate", minDate);
////				}
////			}
//			List<Map> keyvalues = new ArrayList<>();
//			Map<String, String> kv = new HashMap<>();
//			kv.put("key", "c.contract_id= ?");
//			StringBuilder sb = new StringBuilder();
//			sb.append("c.contract_id= ? and ")
//				.append("c.contract_id in (")
//				.append("SELECT contract_id FROM projects WHERE plate_id in(select plate_id from departments where department_id in (SELECT department_id FROM employee_roles where employee_id =")
//				.append(ClientUtil.getEmployeeId())
//				.append(" AND role_id = 3))) ");
//			kv.put("value", sb.toString());
//			keyvalues.add(kv);
////			criteria.put("contractId", 0);
//			criteria.put("keyValues", keyvalues);
//		}else{
//			if (val==1) {
//				List<Map> keyvalues = new ArrayList<>();
//				Map<String, String> kv = new HashMap<>();
//				kv.put("key", "c.contract_id= ?");
//				kv.put("value", "(c.contract_id is null or c.contract_id= ? )");
//				keyvalues.add(kv);
//				criteria.put("contractId", 0);
//				criteria.put("keyValues", keyvalues);
//			} else if (val==2) {
//				List<Map> keyvalues = new ArrayList<>();
//				Map<String, String> kv = new HashMap<>();
//				kv.put("key", "c.contract_id= ?");
//				kv.put("value", "c.contract_id> ?");
//				criteria.put("contractId", 0);
//				keyvalues.add(kv);
//				criteria.put("keyValues", keyvalues);
//			}
//		}
//		if(val==1){
//			criteria.put("contractId", 1);
//		}else if(val==2){
//			criteria.put("contractId", 2);
//		}
		
		criteria.put("addtionalCondition", " order by create_date desc");
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
//		searchForm = new McapitalecoosmeorSearchForm();
//		searchForm.addKeyPressHandler(new KeyPressHandler() {
//			
//			@Override
//			public void onKeyPress(KeyPressEvent event) {
//				String name = event.getKeyName();
//				if(name.equals("Enter")){
//					commonQuery();
//				}
//				
//			}
//		});
//		if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.BMZL_DATA)){
//			searchForm.getField("moneyAttribute").setDisabled(true);
//			searchForm.getField("moneyAttribute").setDefaultValue(1);
////			Date defaultDate = __DF.parse(minDateStr);
////			searchForm.getField("minHappenDate").setDefaultValue(defaultDate);
//		} else{
//			searchForm.getField("isHasContract").addChangedHandler(new ChangedHandler() {
//				
//				@Override
//				public void onChanged(ChangedEvent event) {
//					Object val = event.getValue();
//					if(null != val && val.toString().equals("1")){
//						searchForm.getField("moneyAttribute").setValue(1);
//					}
//				}
//			});
//		}
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSMcapitalecoosmeor.getInstance();
	}
	
	@Override
	public void fireEvent(GwtEvent<?> event) {
		handlerManager.fireEvent(event);
	}

	public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
		return handlerManager.addHandler(DataEditEvent.TYPE, handler);
	}
	
	private Window parentWindow;
	private String contractId;
	private String ids;

	public Window getParentWindow() {
		return parentWindow;
	}

	public void setParentWindow(Window parentWindow) {
		this.parentWindow = parentWindow;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
	
	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public void showSureButton(){
		sureButton.show();
	}
	
}

