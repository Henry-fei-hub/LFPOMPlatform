package com.pomplatform.client.contractincome.panel;

import java.math.BigDecimal;
import java.util.ArrayList;
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
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.contractincome.datasource.DSContractIncomeLedgerList;
import com.pomplatform.client.contractincome.form.ContractIncomeLedgerListSearchForm;
import com.pomplatform.client.contractincome.form.ContractIncomeLedgerListViewer;
import com.pomplatform.client.contractincome.form.NewContractIncomeLedgerListForm;
import com.pomplatform.client.contractincome.form.UpdateContractIncomeLedgerListForm;
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
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class ContractIncomeLedgerListPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ContractIncomeLedgerListPanel cm = new ContractIncomeLedgerListPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ContractIncomeLedgerList";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
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
		IButton operation2Button = new IButton("新建");
		controlLayout.addMember(operation2Button);
		operation2Button.hide();
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
						NewContractIncomeLedgerListForm detailForm = new NewContractIncomeLedgerListForm();
						detailForm.setTitle("新建");
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
						detailForm.setWidth100();
						detailForm.setHeight100();
						detailForm.centerInPage();
						detailForm.show();
					}
				});
			}
		});
		IButton operation3Button = new IButton("修改");
		controlLayout.addMember(operation3Button);
		if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.CONTRACT_INCOME_LEDGER_VIEW_ALL)){//查看所有
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
							UpdateContractIncomeLedgerListForm detailForm = new UpdateContractIncomeLedgerListForm();
							detailForm.setTitle("修改");
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
							detailForm.setWidth100();
							detailForm.setHeight100();
							detailForm.centerInPage();
							detailForm.show();
							setCurrentPage(detailForm.getCurrentPage());
						}
					});
				}
			});
		}else if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.CONTRACT_INCOME_LEDGER_VIEW_MINE)) {//仅查看与自己有关的数据
			operation3Button.addClickHandler(new ClickHandler(){
				@Override
				public void onClick(ClickEvent event) {
					if(!resultGrid.anySelected()){ SC.say("请选择一条数据修改"); return;}
					final ListGridRecord selected = resultGrid.getSelectedRecord();
					final PopupWindow popupWindow = new PopupWindow("修改项目状态");
					popupWindow.setWidth("30%");
					popupWindow.setHeight("30%");
					UpdateButtonPanel reckonButtonPanel = new UpdateButtonPanel();
					reckonButtonPanel.initComponents();
					reckonButtonPanel.setRecord(selected);
					reckonButtonPanel.lodaData();
					popupWindow.addItem(reckonButtonPanel);
					reckonButtonPanel.addDataEditedHandler(new DataEditedHandler(){
						@Override
						public void onDataEdited(DataEditEvent event) {
							commonQuery();
						}
					});
					popupWindow.addCloseClickHandler(new CloseClickHandler() {
						@Override
						public void onCloseClick(CloseClickEvent event) {
							popupWindow.destroy();
						}
					});
					reckonButtonPanel.setParentWindow(popupWindow);
					popupWindow.centerInPage();
					popupWindow.show();
				}
			});
		}
		
		
		IButton removeButton = new IButton("删除");
		controlLayout.addMember(removeButton);
		removeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
				}
				SC.ask("确定删除吗？", new BooleanCallback() {
					@Override
					public void execute(Boolean value) {
						if(value) {
							final ListGridRecord selected = resultGrid.getSelectedRecord();
							DBDataSource.callOperation("ST_ContractIncomeLedger", "delete", selected.toMap(), new DSCallback() {
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if (dsResponse.getStatus() < 0) {
										ClientUtil.displayErrorMessage(dsResponse);
									} else {
										SC.say("删除成功");
										commonQuery();
//										int indexNum = resultGrid.getRowNum(selected);
//										resultGrid.removeData(selected);
//										resultGrid.selectSingleRecord(indexNum);
									}
								}
							});
						}
					}
				});
			}
		});

		IButton updateDataButton = new IButton("更新数据");
		controlLayout.addMember(updateDataButton);
		updateDataButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Map params = generateCriteria();
				if(BaseHelpUtils.isNullOrEmpty(params.get("ledgerYear")) || BaseHelpUtils.isNullOrEmpty(params.get("ledgerMonth"))) {
					SC.say("请选择需要更新数据的年份和月份");
					return;
				}
				params.put("optType", "generateNewData");
				DBDataSource.callOperation("EP_ContractIncomeLedgerProcessor", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() < 0) {
							ClientUtil.displayErrorMessage(dsResponse);
						} else {
							SC.say("数据更新成功！");
							commonQuery();
						}
					}
				});
			}
		});
		
		
		IButton onLock =PermissionControl.createPermissionButton("加锁",ERPPermissionStatic.CONTRACT_INCOME_LEDGER_ON_LOCK);
		controlLayout.addMember(onLock);
		onLock.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(!resultGrid.anySelected()){
					SC.say("请至少选择一条数据");
					return;
				}
				SC.ask("确定给数据加锁吗？", new BooleanCallback() {
					@Override
					public void execute(Boolean value) {
						if(value) {
							Record[] records = resultGrid.getSelectedRecords();
							StringBuilder sb=new StringBuilder();
							for (Record record : records) {
								if(sb.length()>0) {
									sb.append(",");
								}
								sb.append(record.getAttribute("contractIncomeLedgerId"));
							}
							Map<String, Object> params = new HashMap<>();
							params.put("status", "onlock");
							params.put("values", sb.toString());
							params.put("optType", "onOrUpLock");
							DBDataSource.callOperation("EP_ContractIncomeLedgerProcessor", params, new DSCallback() {
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if (dsResponse.getStatus() >=0) {
										SC.say("加锁成功");
										commonQuery();
									} else {
										ClientUtil.displayErrorMessage(dsResponse);
									}
								}
							});
						}
					}
				});
			}
		});
		
		
		IButton quitLock =PermissionControl.createPermissionButton("解锁",ERPPermissionStatic.CONTRACT_INCOME_LEDGER_UP_LOCK);
		controlLayout.addMember(quitLock);
		quitLock.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(!resultGrid.anySelected()){
					SC.say("请至少选择一条数据");
					return;
				}
				SC.ask("确定给数据解锁吗？", new BooleanCallback() {
					@Override
					public void execute(Boolean value) {
						if(value) {
							Record[] records = resultGrid.getSelectedRecords();
							StringBuilder sb=new StringBuilder();
							for (Record record : records) {
								if(sb.length()>0) {
									sb.append(",");
								}
								sb.append(record.getAttribute("contractIncomeLedgerId"));
							}
							Map<String, Object> params = new HashMap<>();
							params.put("status", "uplock");
							params.put("values", sb.toString());
							params.put("optType", "onOrUpLock");
							DBDataSource.callOperation("EP_ContractIncomeLedgerProcessor", params, new DSCallback() {
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if (dsResponse.getStatus() >=0) {
										SC.say("解锁成功");
										commonQuery();
									} else {
										ClientUtil.displayErrorMessage(dsResponse);
									}
								}
							});
						}
					}
				});
			}
		});
		
		
		IButton exportButton = new IButton("导出报表");
		controlLayout.addMember(exportButton);
		exportButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Map condition = generateCriteria();
				DBDataSource.downloadFile("DW_ExportContractIncomeLedgerList", condition);
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
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("合同收入台账"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				ContractIncomeLedgerListViewer detailForm = new ContractIncomeLedgerListViewer();
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
		List<Map> keyValues = new ArrayList<>();
		if(BaseHelpUtils.getBoolean(criteria.get("isLastPayment"))) {
			//查看合同尾款，即 0% < (未收款/合同签约金额) <= 15%
			Map<String, String> kv = new HashMap<>();
			kv.put("key", "k order by k.income_ledger_number");
			kv.put("value", "k where k.unreceived_percent > 0 and k.unreceived_percent <= 0.15 order by k.income_ledger_number");
			keyValues.add(kv);
		}
		if(BaseHelpUtils.getBoolean(criteria.get("invoiceAmountIsGreaterThan0"))) {
			//开票金额>0
			Map<String, String> kv = new HashMap<>();
			kv.put("key", "cil.contract_code like ?");
			kv.put("value", "cil.contract_code like ? and cil.invoice_amount > 0 ");
			keyValues.add(kv);
		}
		int unReceiveAmountType = BaseHelpUtils.getIntValue(criteria.get("unReceiveAmountType"));
		if(unReceiveAmountType == 1) {
			//未收款>0
			Map<String, String> kv = new HashMap<>();
			kv.put("key", "cil.contract_code like ?");
			kv.put("value", "cil.contract_code like ? and cil.unreceived_contract_amount > 0 ");
			keyValues.add(kv);
		}else if(unReceiveAmountType == 2) {
			//未收款=0
			Map<String, String> kv = new HashMap<>();
			kv.put("key", "cil.contract_code like ?");
			kv.put("value", "cil.contract_code like ? and cil.unreceived_contract_amount = 0 ");
			keyValues.add(kv);
		}else if(unReceiveAmountType == 3) {
			//未收款<0
			Map<String, String> kv = new HashMap<>();
			kv.put("key", "cil.contract_code like ?");
			kv.put("value", "cil.contract_code like ? and cil.unreceived_contract_amount < 0 ");
			keyValues.add(kv);
		}
		//如果没有查看全部的权限
		if(!ClientUtil.checkIsHavePermission(ERPPermissionStatic.CONTRACT_INCOME_LEDGER_VIEW_ALL)){
			//仅查看与自己有关的数据
			if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.CONTRACT_INCOME_LEDGER_VIEW_MINE)) {
				Map<String, String> kv = new HashMap<>();
				kv.put("key", "and cil.is_locked = ?");
				kv.put("value", "and cil.is_locked = ? and cil.contract_id in( SELECT contract_id  FROM projects WHERE project_type=16 and (project_manage_id="+ClientUtil.getUserId()+" or plate_manager_id="+ClientUtil.getUserId()+") and contract_id > 0)");
				keyValues.add(kv);
			}
		}
		if(keyValues.size() > 0) {
			criteria.put("keyValues", keyValues);
		}
		criteria.put("addtionalCondition", "order by contract_income_ledger_id");
		return true;
	}

	@Override
	public int getSearchFormHeight() {
		return 170;
	}
	
	@Override
	public Canvas generateHDataCanvas() {
		resultGrid = new DelicacyListGrid() {
			@Override
			protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
				BigDecimal invoiceAmount = BaseHelpUtils.getBigDecimalValue(record.getAttribute("invoiceAmount"));
				if(invoiceAmount.compareTo(BigDecimal.ZERO) > 0) {
					//开票金额 > 0，黄色
					return "color: #C10317;";
				}else {
					BigDecimal unreceivedContractAmount = BaseHelpUtils.getBigDecimalValue(record.getAttribute("unreceivedContractAmount"));
					if(unreceivedContractAmount.compareTo(BigDecimal.ZERO) == 0) {
						//未收款 = 0； 灰色
						return "color: #A5A5A5";
					}else {
						return super.getCellCSSText(record, rowNum, colNum);
					}
				}
			}
		};
		resultGrid.setDataSource(getDataSource());
		resultGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		resultGrid.setWidth100();
		resultGrid.setHeight100();
		return resultGrid;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new ContractIncomeLedgerListSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSContractIncomeLedgerList.getInstance();
	}


}

