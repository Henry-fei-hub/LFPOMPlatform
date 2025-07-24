package com.pomplatform.client.revenuevoucher.panel;

import java.util.Date;
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
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.revenuevoucher.datasource.DSRevenueVoucher;
import com.pomplatform.client.revenuevoucher.form.RevenueVoucherSearchForm;
import com.pomplatform.client.revenuevoucher.form.RevenueVoucherViewer;
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
import com.smartgwt.client.widgets.events.KeyPressEvent;
import com.smartgwt.client.widgets.events.KeyPressHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class RevenueVoucherPanel extends AbstractSearchPanel {

	private static final Logger __LOGGER = Logger.getLogger("");

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			RevenueVoucherPanel cm = new RevenueVoucherPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "RevenueVoucher";
		}

	}

	@Override
	public void init() {
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
	}
	
	@Override
	public Canvas generateHDataCanvas() {
        resultGrid = new DelicacyListGrid() {  
            @Override  
            protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {  
            		 if (record.getAttributeAsBoolean("locked")) {  
            			 return "color: #ABABAB;";
                     } else {  
                         return super.getCellCSSText(record, rowNum, colNum);  
                     }  
                
            }  
        };  
        resultGrid.setDataSource(getDataSource());
        resultGrid.setWidth100();
        resultGrid.setHeight100();
        return resultGrid;
    }

	@Override
	public void initComponents() {
		int index = 0;
		ListGridField [] fields = new ListGridField[10];
		fields[index] = new ListGridField("sequenceNumber");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("remark");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("showName");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("name");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("additionalLinkId");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("code");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("debitSide");
		index ++;
		fields[index] = new ListGridField("creditSide");
		index ++;
		fields[index] = new ListGridField("secondaryName");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("secondaryCode");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("vestingDate");
		fields[index].setShowGridSummary(false);
		
		resultGrid.setShowGridSummary(true);
		resultGrid.setFields(fields);
		
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.setIcon("[SKIN]/actions/refresh.png");
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});

		IButton addBtn = new IButton("生成凭证");
		controlLayout.addMember(addBtn);
		addBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				PopupWindow pw = new PopupWindow();
				AddRevenueVoucherPanel panel = new AddRevenueVoucherPanel();
				panel.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						commonQuery();
					}
				});
				panel.setParentCanvas(pw);
				panel.setFatherWindow(pw);
				pw.addItem(panel);
				pw.setTitle("生成凭证");
				pw.setWidth("30%");
				pw.setHeight("30%");
				pw.centerInPage();
				pw.show();

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
		IButton updateContactBtn = new IButton("该月缺合同");
		controlLayout.addMember(updateContactBtn);
		updateContactBtn.addClickHandler(new ClickHandler() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void onClick(ClickEvent event) {
				if(resultGrid.anySelected()){
					Record record = resultGrid.getSelectedRecord();
					Date vestingDate = record.getAttributeAsDate("vestingDate");
					int year = vestingDate.getYear() + 1900;
					int month = vestingDate.getMonth() +1;
					PopupWindow pw = new PopupWindow("绑定合同");
					MprojectcrymorPanel panel=new MprojectcrymorPanel();
					panel.setMonth(month);
					panel.setYear(year);
					panel.commonQuery();
					panel.addDataEditedHandler(new DataEditedHandler() {
						@Override
						public void onDataEdited(DataEditEvent event) {
							commonQuery();
						}
					});
					panel.setPw(pw);
					pw.addItem(panel);
					pw.centerInPage();
					pw.show();
				}else{
					SC.say("请选择一条数据进行修改");
				}
				
			}
		});
		IButton updateBusinessTypeBtn = new IButton("该月缺业务类别");
		controlLayout.addMember(updateBusinessTypeBtn);
		updateBusinessTypeBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(resultGrid.anySelected()){
					Record record = resultGrid.getSelectedRecord();
					Date vestingDate = record.getAttributeAsDate("vestingDate");
					int year = vestingDate.getYear() + 1900;
					int month = vestingDate.getMonth() +1;
					PopupWindow pw = new PopupWindow("修改业务类别");
					MprojectcrymorBusinessTypePanel panel=new MprojectcrymorBusinessTypePanel();
					panel.setMonth(month);
					panel.setYear(year);
					panel.commonQuery();
					panel.addDataEditedHandler(new DataEditedHandler() {
						@Override
						public void onDataEdited(DataEditEvent event) {
							commonQuery();
						}
					});
					panel.setPw(pw);
					pw.addItem(panel);
					pw.centerInPage();
					pw.show();
					
				}else{
					SC.say("请选择一条数据进行修改");
				}
				
			}
		});
		IButton updateAreaBtn = new IButton("该月缺区域");
		controlLayout.addMember(updateAreaBtn);
		updateAreaBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(resultGrid.anySelected()){
					Record record = resultGrid.getSelectedRecord();
					Date vestingDate = record.getAttributeAsDate("vestingDate");
					int year = vestingDate.getYear() + 1900;
					int month = vestingDate.getMonth() +1;
					PopupWindow pw = new PopupWindow("修改区域");
					MprojectcrymorAreaPanel panel=new MprojectcrymorAreaPanel();
					panel.setMonth(month);
					panel.setYear(year);
					panel.commonQuery();
					panel.addDataEditedHandler(new DataEditedHandler() {
						@Override
						public void onDataEdited(DataEditEvent event) {
							commonQuery();
						}
					});
					panel.setPw(pw);
					pw.addItem(panel);
					pw.centerInPage();
					pw.show();
					
				}else{
					SC.say("请选择一条数据进行修改");
				}
				
			}
		});
		
		
		IButton updateAllBusinessTypeBtn = new IButton("该月所有营收订单");
		controlLayout.addMember(updateAllBusinessTypeBtn);
		updateAllBusinessTypeBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(resultGrid.anySelected()){
					Record record = resultGrid.getSelectedRecord();
					Date vestingDate = record.getAttributeAsDate("vestingDate");
					int year = vestingDate.getYear() + 1900;
					int month = vestingDate.getMonth() +1;
					PopupWindow pw = new PopupWindow("修改业务类别");
					MprojectcrymorBusinessTypePanel panel=new MprojectcrymorBusinessTypePanel();
					panel.setMonth(month);
					panel.setIsAll(true);
					panel.setYear(year);
					panel.commonQuery();
					panel.addDataEditedHandler(new DataEditedHandler() {
						@Override
						public void onDataEdited(DataEditEvent event) {
							commonQuery();
						}
					});
					panel.setPw(pw);
					pw.addItem(panel);
					pw.centerInPage();
					pw.show();
					
				}else{
					SC.say("请选择一条数据进行修改");
				}
				
			}
		});
		
		IButton updateAllAreaBtn = new IButton("该月所有合同区域");
		controlLayout.addMember(updateAllAreaBtn);
		updateAllAreaBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(resultGrid.anySelected()){
					Record record = resultGrid.getSelectedRecord();
					Date vestingDate = record.getAttributeAsDate("vestingDate");
					int year = vestingDate.getYear() + 1900;
					int month = vestingDate.getMonth() +1;
					PopupWindow pw = new PopupWindow("修改区域");
					MprojectcrymorAreaPanel panel=new MprojectcrymorAreaPanel();
					panel.setMonth(month);
					panel.setYear(year);
					panel.setIsAll(true);
					panel.commonQuery();
					panel.addDataEditedHandler(new DataEditedHandler() {
						@Override
						public void onDataEdited(DataEditEvent event) {
							commonQuery();
						}
					});
					panel.setPw(pw);
					pw.addItem(panel);
					pw.centerInPage();
					pw.show();
					
				}else{
					SC.say("请选择一条数据进行修改");
				}
				
			}
		});
		
		IButton exportBtn = new IButton("导出");
		controlLayout.addMember(exportBtn);
		exportBtn.addClickHandler(new ClickHandler() {

			@SuppressWarnings("unchecked")
			@Override
			public void onClick(ClickEvent event) {
				Map condition = generateCriteria();
				condition.put("employeeName", ClientUtil.getUserName());
				DBDataSource.downloadFile("DW_RevenueVoucher", condition);

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
				detail.setTitle("RevenueVoucher");
				detail.setWidth100();
				detail.setHeight100();
				RevenueVoucherViewer detailForm = new RevenueVoucherViewer();
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
		criteria.put("voucherType", 4);
		return true;
	}

	@Override
	public int getSearchFormHeight() {
		return 150;
	}

	@Override
	public SearchForm generateSearchForm() {
		RevenueVoucherSearchForm form = new RevenueVoucherSearchForm();
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
		return DSRevenueVoucher.getInstance();
	}

}
