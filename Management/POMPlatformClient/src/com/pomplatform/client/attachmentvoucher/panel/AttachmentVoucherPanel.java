package com.pomplatform.client.attachmentvoucher.panel;

import java.util.Date;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.PopupWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.ClientUtil;
import com.smartgwt.client.widgets.grid.events.SelectionChangedHandler;
import com.smartgwt.client.widgets.grid.events.SelectionEvent;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.grid.events.SelectionUpdatedEvent;
import com.smartgwt.client.widgets.grid.events.SelectionUpdatedHandler;
import java.util.Objects;
import java.util.Set;

import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.attachmentvoucher.datasource.DSAttachmentVoucher;
import com.pomplatform.client.attachmentvoucher.form.AttachmentVoucherSearchForm;
import com.pomplatform.client.attachmentvoucher.form.AttachmentVoucherViewer;
import com.pomplatform.client.common.ClientStaticUtils;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Logger;

public class AttachmentVoucherPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			AttachmentVoucherPanel cm = new AttachmentVoucherPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "AttachmentVoucher";
		}

	}

	@Override
	public void init(){
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
		fields[index] = new ListGridField("attachmentName");
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
						params.put("optType", "deleteAttchmentK3Voucher");
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
		IButton exportBtn = new IButton("导出");
		controlLayout.addMember(exportBtn);
		exportBtn.addClickHandler(new ClickHandler() {

			@SuppressWarnings("unchecked")
			@Override
			public void onClick(ClickEvent event) {
				Map condition = generateCriteria();
				condition.put("employeeName", ClientUtil.getUserName());
				DBDataSource.downloadFile("DW_AttachmentVoucher", condition);

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
				detail.setTitle("AttachmentVoucher"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				AttachmentVoucherViewer detailForm = new AttachmentVoucherViewer();
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
		criteria.put("addtionalCondition", "order by attachment_manage_id");
		criteria.put("voucherType", 5);
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		AttachmentVoucherSearchForm form = new AttachmentVoucherSearchForm();
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
		return DSAttachmentVoucher.getInstance();
	}


}

