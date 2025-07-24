package com.pomplatform.client.k3voucher.panel;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.k3voucher.datasource.DSIncomeVoucher;
import com.pomplatform.client.k3voucher.form.IncomeVoucherSearchForm;
import com.pomplatform.client.k3voucher.form.IncomeVoucherViewer;
import com.pomplatform.client.reimbursement.form.UpdateIncomeK3VoucherForm;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.events.KeyPressEvent;
import com.smartgwt.client.widgets.events.KeyPressHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class IncomeVoucherPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			IncomeVoucherPanel cm = new IncomeVoucherPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "IncomeVoucher";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid = new DelicacyListGrid(){
			@Override
			protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
				if (record.getAttributeAsBoolean("locked")) {  //定稿标绿色
                    return "color:#00B736;";  
                } else {  
                    return super.getCellCSSText(record, rowNum, colNum);  
                }  
			}
		};
		resultGrid.setDataSource(getDataSource());
		resultGrid.setShowRowNumbers(true);
	}

	@Override
	public void initComponents() {
		ListGridField[] fields = new ListGridField[12];
		int idx = 0;
		fields[idx] = new ListGridField("companyId");
		idx++;
		fields[idx] = new ListGridField("invoiceNumber");
		idx++;
		fields[idx] = new ListGridField("vestingDate");
		idx++;
		fields[idx] = new ListGridField("sequenceNumber");
		idx++;
		fields[idx] = new ListGridField("code");
		idx++;
		fields[idx] = new ListGridField("name");
		idx++;
		fields[idx] = new ListGridField("debitSide");
		idx++;
		fields[idx] = new ListGridField("creditSide");
		idx++;
		fields[idx] = new ListGridField("customerId");
		idx++;
		fields[idx] = new ListGridField("contractCode");
		idx++;
		fields[idx] = new ListGridField("contractName");
		idx++;
		fields[idx] = new ListGridField("contractArea");
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
				showDetail();
			}
		});
		IButton viewButton = new IButton("查看详细");
		viewButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		controlLayout.addMember(viewButton);
		
		IButton download = new IButton("导出凭证");
		controlLayout.addMember(download);
		download.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Map<Object, Object> condition = generateCriteria();
				condition.put("employeeName", ClientUtil.getUserName());
				DBDataSource.downloadFile("DW_IncomeVoucher", condition);
			}
		});
		
		IButton updateButton = new IButton("修改");
		controlLayout.addMember(updateButton);
		updateButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){ SC.say("请选择一条数据修改"); return;}
						final ListGridRecord selected1 = resultGrid.getSelectedRecord();
						UpdateIncomeK3VoucherForm detailForm = new UpdateIncomeK3VoucherForm();
						detailForm.setTitle("修改");
						detailForm.addDataEditedHandler(new DataEditedHandler(){
							@Override
							public void onDataEdited(DataEditEvent event) {
								commonQuery();
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
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				});
			}
		});
		
		IButton deleteButton = new IButton("删除");
		controlLayout.addMember(deleteButton);
		deleteButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
						Record[] records = resultGrid.getSelectedRecords();
						Set<Integer> set = new HashSet<>();
						for(Record record : records){
							if(record.getAttributeAsBoolean("locked")){
								SC.say("包含了已定稿的凭证，无法删除");
								return;
							}
							set.add(ClientUtil.checkAndGetIntValue(record.getAttribute("sequenceNumber")));
						}
						Map<String, Object> params = new HashMap<>();
						//根据凭证号来删除凭证
						params.put("optType", "deleteVoucherBySequenceNumber");
						params.put("sequenceNumber", set);
						DBDataSource.callOperation("EP_K3VoucherProcess", params, new DSCallback() {
							
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
		
		IButton lockButton = new IButton("定稿");
		controlLayout.addMember(lockButton);
		lockButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
						Record[] records = resultGrid.getSelectedRecords();
						Set<Integer> set = new HashSet<>();
						for(Record record : records){
							set.add(ClientUtil.checkAndGetIntValue(record.getAttribute("sequenceNumber")));
						}
						Map<String, Object> params = new HashMap<>();
						//根据凭证号来定稿
						params.put("optType", "lockVoucherBySequenceNumber");
						params.put("sequenceNumber", set);
						DBDataSource.callOperation("EP_K3VoucherProcess", params, new DSCallback() {
							
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
		
		IButton unlockButton = new IButton("取消定稿");
		controlLayout.addMember(unlockButton);
		unlockButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
						Record[] records = resultGrid.getSelectedRecords();
						Set<Integer> set = new HashSet<>();
						for(Record record : records){
							set.add(ClientUtil.checkAndGetIntValue(record.getAttribute("sequenceNumber")));
						}
						Map<String, Object> params = new HashMap<>();
						//根据凭证号来取消定稿
						params.put("optType", "unlockVoucherBySequenceNumber");
						params.put("sequenceNumber", set);
						DBDataSource.callOperation("EP_K3VoucherProcess", params, new DSCallback() {
							
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
				detail.setTitle("收入/收款凭证"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				IncomeVoucherViewer detailForm = new IncomeVoucherViewer();
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
		criteria.put("addtionalCondition", "order by k3_voucher_id");
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		IncomeVoucherSearchForm form = new IncomeVoucherSearchForm();
		form.addKeyPressHandler(new KeyPressHandler() {
			
			@Override
			public void onKeyPress(KeyPressEvent event) {
				String name = event.getKeyName();
				if(name.equals("Enter")){
					commonQuery();
				}
			}
		});
		return form;
	}

	@Override
	public DataSource getDataSource() {
		return DSIncomeVoucher.getInstance();
	}

	@Override
	public int getSearchFormHeight() {
		return 160;
	}
}

