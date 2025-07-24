package com.pomplatform.client.reimbursement.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.reimbursement.datasource.DSK3VoucherSummary;
import com.pomplatform.client.reimbursement.form.K3VoucherSummarySearchForm;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
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
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.events.KeyPressEvent;
import com.smartgwt.client.widgets.events.KeyPressHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class K3VoucherSummaryPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			K3VoucherSummaryPanel cm = new K3VoucherSummaryPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "K3VoucherSummary";
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
		resultGrid.setAutoFitFieldWidths(false);
		resultGrid.setShowRowNumbers(true);
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
		IButton viewButton = new IButton("查看详细");
		viewButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		controlLayout.addMember(viewButton);
		
		IButton dateButton = new IButton("归属日期");
		controlLayout.addMember(dateButton);
		dateButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				SC.askforValue("请输入归属日期，例：2017-01-01", new ValueCallback() {
					@Override
					public void execute(String value) {
						if(BaseHelpUtils.isNullOrEmpty(value)) {
							return;
						}
						Map<String, Object> params = new HashMap<>();
						params.put("optType", "updateVestingDate");
						params.put("vestingDate", value);
						MapUtils.convertRecordToMap(resultGrid.getDataSource(), resultGrid.getSelectedRecords(), params,
								"list");
						DBDataSource.callOperation("EP_K3VoucherProcess", params, new DSCallback() {
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								if (dsResponse.getStatus() < 0) {
									ClientUtil.displayErrorMessage(dsResponse);
								} else {
									commonQuery();
								}
							}
						});
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
					public void onFailure(Throwable reason) {
						SC.say("fail to download");
					}
					
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){
							SC.say("请选择需要定稿的凭证");
						}else{
							boolean goOn = true;
							Record[] records = resultGrid.getSelectedRecords();
							for(Record record :records){
								if(null == record.getAttribute("debitSide") || null == record.getAttribute("creditSide") || (null != record.getAttribute("debitSide") && null != record.getAttribute("creditSide") && !(record.getAttribute("debitSide").equals(record.getAttribute("creditSide"))))){
									goOn = false;
								}
							}
							if(goOn){
								SC.confirm("确定要将选中的报销汇总单的凭证定稿吗？", new BooleanCallback() {
									
									@Override
									public void execute(Boolean value) {
										if(value){
											Map<String, Object> params = new HashMap<>();
											params.put("optType", "lockVoucher");
											MapUtils.convertRecordToMap(resultGrid.getDataSource(), resultGrid.getSelectedRecords(), params,
													"list");
											DBDataSource.callOperation("EP_K3VoucherProcess", params, new DSCallback() {
												@Override
												public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
													if (dsResponse.getStatus() < 0) {
														ClientUtil.displayErrorMessage(dsResponse);
													} else {
														commonQuery();
													}
												}
											});
										}
									}
								});
							}else{
								SC.say("您选中的凭证中，有凭证的借方和贷方金额不相等，烦请再次核对！");
							}
						}
					}
					
				});
			}
		});
		
		IButton removeButton = new IButton("删除");
		controlLayout.addMember(removeButton);
		removeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("Please select a data to remove.");
					return;
				}
				ListGridRecord[] records = resultGrid.getSelectedRecords();
				for(ListGridRecord record : records){
					if(record.getAttributeAsBoolean("locked")){
						SC.say("汇总单：" + record.getAttribute("reimbursementPackageCode") + "已定稿，不能执行删除操作");
						return;
					}
				}
				SC.confirm("确定要删除这些凭证吗？", new BooleanCallback() {
					@Override
					public void execute(Boolean value) {
						if(value){
							Map<String, Object> params = new HashMap<>();
							params.put("optType", "deleteVoucherByCode");
							MapUtils.convertRecordToMap(resultGrid.getDataSource(), resultGrid.getSelectedRecords(), params,
									"list");
							DBDataSource.callOperation("EP_K3VoucherProcess", params, new DSCallback() {
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if (dsResponse.getStatus() < 0) {
										ClientUtil.displayErrorMessage(dsResponse);
									} else {
										commonQuery();
									}
								}
							});
						}
					}
				});
			}
		});
		
		IButton createData = new IButton("生成凭证");
		controlLayout.addMember(createData);
		createData.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
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
						commonQuery();
					}
				});
			}
		});
		
		IButton download = new IButton("导出凭证");
		controlLayout.addMember(download);
		download.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Map<Object, String> condition = new HashMap<>();
				Record[] records = resultGrid.getRecords();
				int length = records.length;
				for(int i = 0; i < length; i++){
					condition.put(i, records[i].getAttribute("reimbursementPackageCode"));
				}
				condition.put("employeeName", ClientUtil.getUserName());
				DBDataSource.downloadFile("DW_K3VoucherList", condition);
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
				if(!resultGrid.anySelected()){ 
					SC.say("请选择一条数据"); 
					return;
				}
				PopupWindow window = new PopupWindow();
				Record record = resultGrid.getSelectedRecords()[0];
				String code = record.getAttribute("reimbursementPackageCode");
				String company = KeyValueManager.getValue("system_dictionary_26", record.getAttribute("companyId"));
				window.setTitle(company + " " + code + "的K3凭证"); 
				window.setWidth100(); 
				window.setHeight100(); 
				K3VoucherListPanel panel = new K3VoucherListPanel();
				panel.setCode(code);
				panel.commonQuery();
				window.addMember(panel);
				window.centerInPage();
				window.show();
			}
		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		K3VoucherSummarySearchForm form = new K3VoucherSummarySearchForm();
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
		return DSK3VoucherSummary.getInstance();
	}


}

