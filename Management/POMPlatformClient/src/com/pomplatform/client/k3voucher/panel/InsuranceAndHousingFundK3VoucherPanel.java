package com.pomplatform.client.k3voucher.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
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
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.k3voucher.datasource.DSInsuranceAndHousingFundK3Voucher;
import com.pomplatform.client.k3voucher.form.InsuranceAndHousingFundK3VoucherSearchForm;
import com.pomplatform.client.k3voucher.form.InsuranceAndHousingFundK3VoucherViewer;
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
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class InsuranceAndHousingFundK3VoucherPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			InsuranceAndHousingFundK3VoucherPanel cm = new InsuranceAndHousingFundK3VoucherPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "InsuranceAndHousingFundK3Voucher";
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
		
		IButton createVoucherButton = new IButton("生成凭证");
		controlLayout.addMember(createVoucherButton);
		createVoucherButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						PopupWindow window = new PopupWindow("生成五险一金凭证");
						CreateInsuranceAndHousingFundK3VoucherPanel panel = new CreateInsuranceAndHousingFundK3VoucherPanel();
						panel.addDataEditedHandler(new DataEditedHandler() {
							@Override
							public void onDataEdited(DataEditEvent event) {
								commonQuery();
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
		
		IButton deleteButton = new IButton("删除凭证");
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
		
		IButton downloadButton = new IButton("导出凭证");
		controlLayout.addMember(downloadButton);
		downloadButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						Map params = generateCriteria();
						params.put("employeeName", ClientUtil.getUserName());
						DBDataSource.downloadFile("DW_InsuranceAndHousingFundK3Voucher", params);
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
				detail.setTitle("五险一金凭证"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				InsuranceAndHousingFundK3VoucherViewer detailForm = new InsuranceAndHousingFundK3VoucherViewer();
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
		//五险一金
		criteria.put("voucherType", "6");
		List<Map> keyvalues = new ArrayList<>();
		if(!criteria.containsKey("year") || null == criteria.get("year")){
			Map<String, String> kv = new HashMap<>();
			kv.put("key", "EXTRACT(YEAR from vesting_date)");
			kv.put("value", "1");
			keyvalues.add(kv);
		}
		if(!criteria.containsKey("month") || null == criteria.get("month")){
			Map<String, String> kv = new HashMap<>();
			kv.put("key", "EXTRACT(MONTH from vesting_date)");
			kv.put("value", "1");
			keyvalues.add(kv);
		}
		criteria.put("keyValues", keyvalues);
		criteria.put("addtionalCondition", "order by k3_voucher_id");
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		InsuranceAndHousingFundK3VoucherSearchForm form = new InsuranceAndHousingFundK3VoucherSearchForm();
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
		return DSInsuranceAndHousingFundK3Voucher.getInstance();
	}


}

