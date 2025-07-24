package com.pomplatform.client.newcontractppcor.panel;

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
import com.delicacy.client.ui.LoadingWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.newcontractppcor.datasource.DSScontractppcor;
import com.pomplatform.client.newcontractppcor.form.ScontractppcorSearchForm;
import com.pomplatform.client.newcontractppcor.form.ScontractppcorViewer;
import com.pomplatform.client.newcontractppcor.form.UpdateScontractppcorForm;
import com.pomplatform.client.preprojectrecord.panel.NewPrePrejectRecordPanel;
import com.pomplatform.client.upload.panel.CommonUploadWindow;
import com.pomplatform.client.upload.panel.UploadCallBack;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class ScontractppcorPanel extends AbstractSearchPanel {

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			ScontractppcorPanel cm = new ScontractppcorPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Scontractppcor";
		}

	}
	
	
	@Override
	public void initComponents() {
		ListGridField[] fields = new ListGridField[23];
		int idx = 0;
		fields[idx++] = new ListGridField("contractCode");
		fields[idx++] = new ListGridField("contractName");
		fields[idx] = new ListGridField("serviceSuggestBook");
		fields[idx].setType(ListGridFieldType.LINK);  
		fields[idx].setAlign(Alignment.CENTER);  
		fields[idx++].setLinkText("合同附件下载/预览");
		fields[idx++] = new ListGridField("groupName");
		fields[idx++] = new ListGridField("customerId");
		//fields[idx++] = new ListGridField("signCompany");
		fields[idx++] = new ListGridField("projectCode");
		fields[idx++] = new ListGridField("contractType");
		fields[idx++] = new ListGridField("projectLevel");
		fields[idx++] = new ListGridField("totalProjectTime");
		fields[idx++] = new ListGridField("preProjectType");
		fields[idx++] = new ListGridField("mainProjectType");
		fields[idx++] = new ListGridField("signingMoneySum");
		fields[idx++] = new ListGridField("borrowMoneySum");
		fields[idx++] = new ListGridField("percent");
		fields[idx++] = new ListGridField("percentSum");
		fields[idx++] = new ListGridField("payableButNotPaid");
		fields[idx++] = new ListGridField("haveInvoiceAmount");
		//fields[idx++] = new ListGridField("unInvoiceAmount");
		fields[idx++] = new ListGridField("designTeam");
		fields[idx++] = new ListGridField("projectSecretary");
		fields[idx++] = new ListGridField("projectManager");
		fields[idx++] = new ListGridField("projectLeader");
		fields[idx++] = new ListGridField("mainProjectApprovalTime");
		fields[idx++] = new ListGridField("noBorrowMoneySum");
		fields[idx++] = new ListGridField("noPercent");
		fields[idx++] = new ListGridField("designAreas");
		fields[idx++] = new ListGridField("projectAddress");
		fields[idx++] = new ListGridField("relevantEmployeesName");
		fields[idx++] = new ListGridField("remark");
		fields[idx++] = new ListGridField("signingCompanyName");
		fields[idx++] = new ListGridField("businessType");
		fields[idx++] = new ListGridField("customerAddress");
		fields[idx++] = new ListGridField("contractSigningStatus");
		fields[idx++] = new ListGridField("contractDate");
		fields[idx++] = new ListGridField("sendingDate");
		fields[idx++] = new ListGridField("createTime");
		fields[idx++] = new ListGridField("updateTime");
		fields[idx++] = new ListGridField("operator");
		fields[idx++] = new ListGridField("contractStatus");

		resultGrid.setShowRowNumbers(true);
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
		IButton operation1Button = new IButton("查看详情");
		controlLayout.addMember(operation1Button);
		operation1Button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		IButton operation2Button = PermissionControl.createPermissionButton("补录合同信息",
				ERPPermissionStatic.UPDATE_CONTRACT_INFO_BTN);
		controlLayout.addMember(operation2Button);
		operation2Button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download code");
					}

					@Override
					public void onSuccess() {
						if (!resultGrid.anySelected()) {
							SC.say("请选择一条数据修改");
							return;
						}
						final ListGridRecord selected1 = resultGrid.getSelectedRecord();
						UpdateScontractppcorForm detailForm = new UpdateScontractppcorForm();
						detailForm.setTitle("修改合同");
						detailForm.addDataEditedHandler(new DataEditedHandler() {
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
		IButton uploadButton = PermissionControl.createPermissionButton("上传合同附件",
				ERPPermissionStatic.FINALLTY_INFO_UPLOAD_FILE_BUTTON);
		controlLayout.addMember(uploadButton);
		uploadButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
				} else {
					final Record selected = resultGrid.getSelectedRecord();
					GWT.runAsync(new RunAsyncCallback() {
						@Override
						public void onFailure(Throwable reason) {
							SC.say("failure to download code");
						}

						@Override
						public void onSuccess() {
							new CommonUploadWindow("上传合同附件", false, 100, null, 1, new UploadCallBack() {
								
								@Override
								public void execute(Map<String, Record> data) {
									Record fileData = null;
									for(String key : data.keySet()) {
										fileData = data.get(key);
										break;
									}
									if(null != fileData) {
										Map<String, String> params = new HashMap<>();
										params.put("optType", "updateServiceSuggestBook");
										params.put("contractId", selected.getAttribute("contractId"));
										params.put("serviceSuggestBookId", fileData.getAttribute("fileId"));
										params.put("serviceSuggestBook", fileData.getAttribute("fileUrl"));
										DBDataSource.callOperation("EP_ContractChangeProcess", "find", params, new DSCallback() {
											
											@Override
											public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
												if(dsResponse.getStatus() >= 0) {
													commonQuery();
												}else {
													ClientUtil.displayErrorMessage(dsResponse);
												}
											}
										});
									}
								}
							});
						}
					});
				}
			}
		});
		
//		IButton inputButton = new IButton("合同录入");
		IButton inputButton = PermissionControl.createPermissionButton("合同录入",
				ERPPermissionStatic.CONTRACTS_INPUT_BUTTON);
		controlLayout.addMember(inputButton);
		inputButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				NewContractForm contractForm = new NewContractForm();
				contractForm.setTitle("合同录入");
				contractForm.addDataEditedHandler(new DataEditedHandler() {
                	@Override
                	public void onDataEdited(DataEditEvent event) {
                		commonQuery();
                	}
                });
				contractForm.initComponents();
				contractForm.startEdit();
				contractForm.setWidth100();
				contractForm.setHeight100();
				contractForm.centerInPage();
				contractForm.show();
			}
		});
		
		IButton checkButton = new IButton("金额校验");
		controlLayout.addMember(checkButton);
		checkButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Map<String,Object> params = new HashMap<>();
				params.put("flag", 2);
				final LoadingWindow loading = new LoadingWindow();
				DBDataSource.callOperation("NQ_Scontractppcor", params, new DSCallback() {
					
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						loading.destroy();
						if(dsResponse.getStatus() >= 0){
							resultGrid.setData(dsResponse.getData());
							resultGrid.redraw();
						}
					}
				});
			}
		});
		
//		IButton exportBtn = new IButton("导出");
		IButton exportBtn = PermissionControl.createPermissionButton("导出",ERPPermissionStatic.CONTRACTS_EXPORT_BUTTON);
		exportBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				DBDataSource.downloadFile("DW_Scontractppcor", generateCriteria());
				
			}
		});
		controlLayout.addMember(exportBtn);
		
//		IButton recordButton = new IButton("新增跟踪记录");
		IButton recordButton = PermissionControl.createPermissionButton("新增跟踪记录",
				ERPPermissionStatic.CONTRACTS_RECORD_BUTTON);
		controlLayout.addMember(recordButton);
		recordButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				if(!resultGrid.anySelected()){ 
					SC.say("请选择一条数据修改"); 
					return;
				}
				final ListGridRecord selected = resultGrid.getSelectedRecord();
				NewPrePrejectRecordPanel detailForm = new NewPrePrejectRecordPanel();
				detailForm.setTitle("新增合同跟踪记录");
				detailForm.addDataEditedHandler(new DataEditedHandler(){
					@Override
					public void onDataEdited(DataEditEvent event) {
						commonQuery();
					}
				});
				detailForm.setSearchForm(searchForm);
				detailForm.setRecord(selected);
				detailForm.setCurrentPage(getCurrentPage());
				detailForm.setIsContract(true);
				detailForm.initComponents();
				detailForm.setWidth("40%");
				detailForm.setHeight("70%");
				detailForm.startEdit();
				detailForm.centerInPage();
				detailForm.show();
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
				detail.setTitle("合同详情");
				detail.setWidth100();
				detail.setHeight100();
				ScontractppcorViewer detailForm = new ScontractppcorViewer();
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
		List<Map> keyvalues = new ArrayList<>();
		criteria.put("addtionalCondition", "order by contract_id");
//		if(!ClientUtil.checkIsHavePermission(ERPPermissionStatic.CONTRACT_MANAGEMENT_INFO_SHOW_ALL)){
//			if(!ClientUtil.checkIsHavePermission(ERPPermissionStatic.CONTRACT_MANAGEMENT_INFO_SHOW_PLATE)){
//				if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.CONTRACT_MANAGEMENT_INFO_SHOW_MANAGE)){
//					criteria.put("projectManageId", ClientUtil.getUserId());
//				}else {
//					SC.say("提示","你没有查看权限!");
//					return false;
//				}
//			}else {
//				int plateId = BaseHelpUtils.getIntValue(criteria.get("plateId"));
//				if(plateId<=0) {
//					return false;
//				}
//			}
//		}
//		String projectSecretaryId = BaseHelpUtils.getString(criteria.get("projectSecretaryId"));
//		if(BaseHelpUtils.isNullOrEmpty(projectSecretaryId)){
//			Map<String, String> kv = new HashMap<>();
//			kv.put("key", "remp.project_secretary LIKE concat ( '%', ( SELECT employee_name FROM employees WHERE 1=1 ), '%' )");
//			kv.put("value", "1=1");
//			keyvalues.add(kv);
////			criteria.put("projectSecretaryId","99999");
//		}
//		String projectManagerId = BaseHelpUtils.getString(criteria.get("projectManagerId"));
//		if(BaseHelpUtils.isNullOrEmpty(projectManagerId)){
//			Map<String, String> kv = new HashMap<>();
//			kv.put("key", "remp.project_manager LIKE concat ( '%', ( SELECT employee_name FROM employees WHERE 1=1 ), '%' )");
//			kv.put("value", "1=1");
//			keyvalues.add(kv);
////			criteria.put("projectManagerId","99999");
//		}
//		String projectLeaderId = BaseHelpUtils.getString(criteria.get("projectLeaderId"));
//		if(BaseHelpUtils.isNullOrEmpty(projectLeaderId)){
//			Map<String, String> kv = new HashMap<>();
//			kv.put("key", "remp.project_leader LIKE concat ( '%', ( SELECT employee_name FROM employees WHERE 1=1 ), '%' )");
//			kv.put("value", "1=1");
//			keyvalues.add(kv);
////			criteria.put("projectLeaderId","99999");
//		}
//		if(!BaseHelpUtils.isNullOrEmpty(keyvalues) && keyvalues.size() > 0){
//			criteria.put("keyValues", keyvalues);
//		}
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new ScontractppcorSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSScontractppcor.getInstance();
	}

	@Override
	public int getSearchFormHeight() {
		return 200;
	}
	
	private static final Logger __LOGGER = Logger.getLogger("");
	
	
	@Override
	public Canvas generateHDataCanvas() {
		resultGrid = new DelicacyListGrid() {  
            @Override  
            protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
        		 if ((BaseHelpUtils.getBigDecimalValue(record.getAttribute("percent")).multiply(hundred)).compareTo(BaseHelpUtils.getBigDecimalValue(record.getAttribute("percentSum")))<0) { 
        			 return "color: red;";
                 }else {  
                     return super.getCellCSSText(record, rowNum, colNum);  
                 }  
            } 
        };
		resultGrid.setDataSource(getDataSource());
		resultGrid.setWidth100();
		resultGrid.setHeight100();
		return resultGrid;
	}
	
	private BigDecimal hundred = new BigDecimal(100);
	
}
