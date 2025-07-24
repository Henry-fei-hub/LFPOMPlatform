package com.pomplatform.client.contract.panel;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractExpansionRelatedPage;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LoadingWindow;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.contract.datasource.DSOnLoadAttachmentBindContract;
import com.pomplatform.client.contract.datasource.DSOnLoadContractAttachmentData;
import com.pomplatform.client.contract.form.OnLoadContractAttachmentDataSearchForm;
import com.pomplatform.client.contract.form.OnLoadContractAttachmentDataViewer;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
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
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class OnLoadContractAttachmentDataPanel extends AbstractExpansionRelatedPage{

	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			OnLoadContractAttachmentDataPanel cm = new OnLoadContractAttachmentDataPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OnLoadContractAttachmentData";
		}

	}

	@Override
	public void initComponents() {
		resultGrid.setAutoFitFieldWidths(false);
		ListGridField[] fields = new ListGridField[11];
		int idx = 0;
		fields[idx] = new ListGridField("contractAttachmentId");
		fields[idx].setCanEdit(false);
		fields[idx].setHidden(true);
		idx ++;
		fields[idx] = new ListGridField("fileId");
		fields[idx].setCanEdit(false);
		fields[idx].setHidden(true);
		idx ++;
		fields[idx] = new ListGridField("attachmentCode");
		fields[idx].setCanEdit(false);
		idx ++;
		fields[idx] = new ListGridField("attachmentName");
		fields[idx].setCanEdit(false);
		idx ++;
		fields[idx] = new ListGridField("companyId");
		fields[idx].setCanEdit(false);
		idx ++;
		fields[idx] = new ListGridField("signingMoneySum");
		fields[idx].setCanEdit(false);
		idx ++;
		fields[idx] = new ListGridField("uploadEmployeeId");
		fields[idx].setCanEdit(false);
		idx ++;
		fields[idx] = new ListGridField("uploadTime");
		fields[idx].setCanEdit(false);
		idx ++;
		fields[idx] = new ListGridField("isLink");
		fields[idx].setCanEdit(false);
		idx ++;
		fields[idx] = new ListGridField("fileUrl");
		fields[idx].setCanEdit(false);
		fields[idx].setLinkText("合同文件下载/预览");
		idx ++;
		fields[idx] = new ListGridField("remark");
		fields[idx].setCanEdit(false);
		idx ++;
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
		IButton uploadButton = PermissionControl.createPermissionButton("上传文件",
				ERPPermissionStatic.CONTRACT_ATTACHMENT_MANAGE_ADD_BTN);
		uploadButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				final PopupWindow popupWindow = new PopupWindow("合同文件上传");
				popupWindow.setWidth("50%");
				popupWindow.setHeight("60%");
				popupWindow.centerInPage();
				OnContractAttachmentUploadPanel uploadPanel = new OnContractAttachmentUploadPanel();
				uploadPanel.initComponents();
				popupWindow.addItem(uploadPanel);
				uploadPanel.addDataEditedHandler(new DataEditedHandler(){
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
				uploadPanel.setParentWindow(popupWindow);
				popupWindow.centerInPage();
				popupWindow.show();
			}
		});
		controlLayout.addMember(uploadButton);
		
		IButton bindButton = PermissionControl.createPermissionButton("绑定合同",
				ERPPermissionStatic.CONTRACT_ATTACHMENT_MANAGE_ADD_BTN);
		bindButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download code");
					}
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
						Record record = resultGrid.getSelectedRecord();
						final PopupWindow popupWindow = new PopupWindow("绑定合同");
						popupWindow.setWidth("70%");
						popupWindow.setHeight("80%");
						popupWindow.centerInPage();
						OnContractAttachmentBindPanel uploadPanel = new OnContractAttachmentBindPanel();
						uploadPanel.setRecord(record);
						uploadPanel.initComponents();
						popupWindow.addItem(uploadPanel);
						uploadPanel.addDataEditedHandler(new DataEditedHandler(){
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
						uploadPanel.setParentWindow(popupWindow);
						popupWindow.centerInPage();
						popupWindow.show();
					}
				});
			}
		});
		controlLayout.addMember(bindButton);
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
				detail.setTitle("合同文件库"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				OnLoadContractAttachmentDataViewer detailForm = new OnLoadContractAttachmentDataViewer();
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

	@SuppressWarnings("rawtypes")
	@Override
	public boolean checkSearchCriteria(Map criteria) {
		return true;
	}
	
	@Override
	public void customCommonQuery(ListGridRecord record,ListGrid childGrid) {
		//根据父级字段信息去检索子级的数据集
		int contractAttachmentId = BaseHelpUtils.getIntValue(record.getAttribute("contractAttachmentId"));
		int fileId = BaseHelpUtils.getIntValue(record.getAttribute("fileId"));
		//获取父级查询的开始日期和结束日期
		Map<String,Object> map = new HashMap<>();
		map.put("contractAttachmentId", contractAttachmentId);
		map.put("fileId", fileId);
		final LoadingWindow loading = new LoadingWindow();
		DBDataSource.callOperation("NQ_OnLoadAttachmentBindContract","find",map, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				loading.destroy();
				if (dsResponse.getStatus() >= 0) {
					childGrid.setData(dsResponse.getData());
				}
			}
		});
	}
	
	@Override
	public Canvas[] getChildGridOptionCanvas() {
		Canvas[] canvas = new Canvas[1]; 
		IButton unBindButton = new IButton("解绑");  
		canvas[0] = unBindButton;
		unBindButton.addClickHandler(new ClickHandler() {    
            public void onClick(ClickEvent event) { 
            	if(!resultChildGrid.anySelected()){ SC.say("请选择一条数据"); return;}
            	Record record = resultChildGrid.getSelectedRecord();
            	if(!BaseHelpUtils.isNullOrEmpty(record)){
            		SC.ask("提示","您确定要解绑吗?", new BooleanCallback() {
						@Override
						public void execute(Boolean value) {
							if(value){
								//获取主键Id
								int contractLinkAttachmentId = BaseHelpUtils.getIntValue(record.getAttribute("contractLinkAttachmentId"));
								Map<String,Object> map = new HashMap<>();
								map.put("contractLinkAttachmentId", contractLinkAttachmentId);
								final LoadingWindow loading = new LoadingWindow();
								DBDataSource.callOperation("ST_ContractLinkAttachment","delete",map, new DSCallback() {
									@Override
									public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
										loading.destroy();
										if (dsResponse.getStatus() >= 0) {
											customCommonQuery(resultGrid.getSelectedRecord(), resultChildGrid);
										}
									}
								});
							}
						}
					});
            	}
            }    
        }); 
		return canvas;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new OnLoadContractAttachmentDataSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSOnLoadContractAttachmentData.getInstance();
	}

	@Override
	public DataSource getChildDataSource() {
		return DSOnLoadAttachmentBindContract.getInstance();
	}


}

