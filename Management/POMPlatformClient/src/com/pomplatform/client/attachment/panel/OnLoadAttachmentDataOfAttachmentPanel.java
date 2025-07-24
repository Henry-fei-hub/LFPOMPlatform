package com.pomplatform.client.attachment.panel;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.NewProcessWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.attachment.datasource.DSOnLoadAttachmentDataOfAttachment;
import com.pomplatform.client.attachment.form.OnLoadAttachmentDataOfAttachmentSearchForm;
import com.pomplatform.client.attachment.form.OnLoadAttachmentDataOfAttachmentViewer;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.GroupStartOpen;
import com.smartgwt.client.types.SortDirection;
import com.smartgwt.client.util.BooleanCallback;
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

public class OnLoadAttachmentDataOfAttachmentPanel extends AbstractSearchPanel {
	private static final Logger __LOGGER = Logger.getLogger("");

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			OnLoadAttachmentDataOfAttachmentPanel cm = new OnLoadAttachmentDataOfAttachmentPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OnLoadAttachmentDataOfAttachment";
		}

	}

	@Override
	public void init() {
		super.init();
		resultGrid.setAutoFitFieldWidths(false);
		__controlPosition = LayoutConstant.RIGHT;
	}

	@Override
	public void initComponents() {
		ListGridField contractNameField = new ListGridField("contractName");
		contractNameField.setShowGroupSummary(false);
		contractNameField.setShowGridSummary(false);
		contractNameField.setHidden(false);
		contractNameField.setCanGroupBy(true);

		ListGridField contractIdField = new ListGridField("contractId");
		contractIdField.setShowGroupSummary(false);
		contractIdField.setShowGridSummary(false);
		contractIdField.setHidden(true);
		contractIdField.setCanGroupBy(false);

		ListGridField attachmentCodeField = new ListGridField("attachmentCode");
		attachmentCodeField.setShowGroupSummary(false);
		attachmentCodeField.setShowGridSummary(false);
		attachmentCodeField.setCanGroupBy(false);
		attachmentCodeField.setCanSort(true);

		ListGridField attachmentAddressField = new ListGridField("attachmentAddress");
		attachmentAddressField.setShowGroupSummary(false);
		attachmentAddressField.setShowGridSummary(false);
		attachmentAddressField.setCanGroupBy(false);

		ListGridField perfessionRemarkField = new ListGridField("perfessionRemark");
		perfessionRemarkField.setShowGroupSummary(false);
		perfessionRemarkField.setShowGridSummary(false);
		perfessionRemarkField.setCanGroupBy(false);

		ListGridField amountField = new ListGridField("amount");
		amountField.setShowGroupSummary(true);
		amountField.setShowGridSummary(true);
		amountField.setCanGroupBy(false);

		ListGridField invoiceAmountField = new ListGridField("invoiceAmount");
		invoiceAmountField.setShowGroupSummary(true);
		invoiceAmountField.setShowGridSummary(true);
		invoiceAmountField.setCanGroupBy(false);
		
		ListGridField returnAmountField = new ListGridField("returnAmount");
		returnAmountField.setShowGroupSummary(true);
		returnAmountField.setShowGridSummary(true);
		returnAmountField.setCanGroupBy(false);


		ListGridField paymentSureField = new ListGridField("paymentSure");
		paymentSureField.setShowGroupSummary(false);
		paymentSureField.setShowGridSummary(false);
		paymentSureField.setCanGroupBy(false);

		ListGridField paymentGradeDescriptionField = new ListGridField("paymentGradeDescription");
		paymentGradeDescriptionField.setShowGroupSummary(false);
		paymentGradeDescriptionField.setShowGridSummary(false);
		paymentGradeDescriptionField.setCanGroupBy(false);

		ListGridField operateEmployeeIdField = new ListGridField("operateEmployeeId");
		operateEmployeeIdField.setShowGroupSummary(false);
		operateEmployeeIdField.setShowGridSummary(false);
		operateEmployeeIdField.setCanGroupBy(true);

		ListGridField operateTimeField = new ListGridField("operateTime");
		operateTimeField.setShowGroupSummary(false);
		operateTimeField.setShowGridSummary(false);
		operateTimeField.setCanGroupBy(true);

		ListGridField remarkField = new ListGridField("remark");
		remarkField.setShowGroupSummary(false);
		remarkField.setShowGridSummary(false);
		remarkField.setCanGroupBy(false);

		ListGridField confirmationLetterField = new ListGridField("confirmationLetter");
		confirmationLetterField.setShowGroupSummary(false);
		confirmationLetterField.setShowGridSummary(false);
		confirmationLetterField.setCanGroupBy(false);

		ListGridField haveVoucherField = new ListGridField("haveVoucher");
		haveVoucherField.setShowGroupSummary(false);
		haveVoucherField.setShowGridSummary(false);
		haveVoucherField.setCanGroupBy(false);

		resultGrid.setShowRowNumbers(true);
		resultGrid.setShowGridSummary(true);
		resultGrid.setGroupByField("contractName");
		resultGrid.setGroupStartOpen(GroupStartOpen.ALL);
		resultGrid.setShowAllRecords(true);
		resultGrid.setShowGroupSummary(true);
		resultGrid.setFields(contractNameField, contractIdField, attachmentCodeField, attachmentAddressField,
				perfessionRemarkField, amountField,invoiceAmountField, returnAmountField,  paymentSureField,
				paymentGradeDescriptionField, operateEmployeeIdField, operateTimeField, remarkField,confirmationLetterField, haveVoucherField);
		resultGrid.configureGrouping();
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});

		// 上传确认函
		IButton uploadFileButton = new IButton("申请确认函");
		controlLayout.addMember(uploadFileButton);
		uploadFileButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				NewProcessWindow distribution = new NewProcessWindow();
				distribution.setTitle("确认函申请");
				distribution.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						// 操作成功
						commonQuery();
					}
				});
				Map<String, String> processIdMap = PomPlatformClientUtil.getUserProcessId(PomPlatformClientUtil.PARENT_PROCESS_TYPE_4);
				Integer value = ClientUtil.checkAndGetIntValue(processIdMap.get("Attachment_apply"));
				distribution.setProcessId(value);
				distribution.setLayoutMode(0);
				distribution.initComponents();
				distribution.setTitle(KeyValueManager.getValue("employee_processes", String.valueOf(value)));
				distribution.show();
			}
		});
		IButton setButton = new IButton("分组设置");
		controlLayout.addMember(setButton);
		setButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				resultGrid.configureGrouping();

			}
		});
		IButton openButton = new IButton("展开分组");
		controlLayout.addMember(openButton);
		openButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				resultGrid.setGroupStartOpen(GroupStartOpen.ALL);
				resultGrid.regroup();
			}
		});
		IButton closeButton = new IButton("收拢分组");
		controlLayout.addMember(closeButton);
		closeButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				resultGrid.setGroupStartOpen("none");
				resultGrid.regroup();
				commonQuery();
			}
		});

		IButton createK3CodeBtn = new IButton("生成凭证");
		if (!ClientUtil.checkIsHavePermission(ERPPermissionStatic.AL_VIEW_ALL_DATA)) {
			createK3CodeBtn.hide();
		}
		controlLayout.addMember(createK3CodeBtn);
		createK3CodeBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (resultGrid.anySelected()) {
					String ids = "";
					Record[] selectRecords = resultGrid.getSelectedRecords();
					for (int i = 0; i < selectRecords.length; i++) {
						if (i != 0) {
							ids += ",";
						}
						ids += selectRecords[i].getAttributeAsInt("attachmentManageId");
					}
					if (!BaseHelpUtils.isNullOrEmpty(ids)) {
						Map<String, Object> params = new HashMap<>();
						params.put("ids", ids);
						params.put("optType", "createAttachmentK3Voucher");
						DBDataSource.callOperation("EP_K3VoucherProcess", params, new DSCallback() {

							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								if (dsResponse.getStatus() >= 0) {
									commonQuery();
									SC.say("生成成功");
								} else {
									ClientUtil.displayErrorMessage(dsResponse);
								}

							}
						});
					}
				} else {
					SC.say("请选择需要生成凭证的数据");
				}

			}
		});

		IButton exportButton = new IButton("导出");
		controlLayout.addMember(exportButton);
		exportButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				DBDataSource.downloadFile("DW_OnLoadAttachmentDataOfAttachment", generateCriteria());

			}
		});

		IButton attachmentButton = PermissionControl.createPermissionButton("发起确认函",
				ERPPermissionStatic.AC_START_BUTTON);
		controlLayout.addMember(attachmentButton);
		attachmentButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				Map<String, Object> params = generateCriteria();
				Map<String, Object> dateparams = new HashMap<>();
				//params.put("contractStatus", searchForm.getValue("contractStatusM"));
				params.put("optType", "insertData");
				dateparams.put("dateAttachment", "dateAttachment");
				//params.put("operator", ClientUtil.getEmployeeId());
				
				DBDataSource.callOperation("EP_SponsorAttachment", dateparams, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						String dataStr=BaseHelpUtils.getString(data);
						if (dataStr.equals("1")) {
							params.put("first", "first");
							DBDataSource.callOperation("EP_SponsorAttachment", params, new DSCallback() {
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if (dsResponse.getStatus() >= 0) {
										SC.say("发起确认函成功");
									} else {
										SC.say(""+dsResponse.getErrors().get("errorMsg"));
										//ClientUtil.displayErrorMessage(dsResponse);
									}

								}
							});
						}else{
							SC.confirm("您上次发起时间为："+dataStr+",您确定发起确认函吗?", new BooleanCallback() {
								
								@Override
								public void execute(Boolean value) {
									if (value) {
										DBDataSource.callOperation("EP_SponsorAttachment", params, new DSCallback() {
											@Override
											public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
												if (dsResponse.getStatus() >= 0) {
													commonQuery();
													SC.say("发起确认函成功");
												} else {
												//	ClientUtil.displayErrorMessage(dsResponse);
													SC.say(""+dsResponse.getErrors().get("errorMsg"));
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


		IButton confirmationButton = PermissionControl.createPermissionButton("回收确认函",
				ERPPermissionStatic.RECOVERY_ATTACHMENT_SURE);
		controlLayout.addMember(confirmationButton);
		confirmationButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				ListGridRecord selected1 = resultGrid.getSelectedRecord();
				int attachmentManageId = selected1.getAttributeAsInt("attachmentManageId");
				HashMap<Object, Object> map = new HashMap<>();
				map.put("attachmentManageId",attachmentManageId);
				DBDataSource.callOperation("ST_AttachmentManage","find", map, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() >= 0) {
							Record record = dsResponse.getData()[0];
								boolean confirmationLetter =record.getAttributeAsBoolean("confirmationLetter");
								if(confirmationLetter){
									SC.say("确认函已回收");
									return;
								}else {
									map.put("confirmationLetter","true");
									map.put("optType", "isConfirmationLetter");

									DBDataSource.callOperation("EP_SponsorAttachment", map, new DSCallback() {
										@Override
										public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
											if (dsResponse.getStatus() >= 0) {
												commonQuery();
												SC.say("回收确认函成功");
											} else {
												SC.say(""+dsResponse.getErrors().get("errorMsg"));
											}
										}
									});

								}
						}

					}
				});



			}
		});

		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				showDetail();
			}
		});
		resultGrid.setGroupStartOpen(GroupStartOpen.NONE);
		resultGrid.setGroupSortDirection(SortDirection.DESCENDING);
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
				detail.setTitle("确认函管理");
				detail.setWidth100();
				detail.setHeight100();
				OnLoadAttachmentDataOfAttachmentViewer detailForm = new OnLoadAttachmentDataOfAttachmentViewer();
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
	public int getSearchFormHeight() {
		return 60;
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("employeeId", ClientUtil.getEmployeeId());
		criteria.put("checkEmployeeId", form.getField("aliEmployeeId")._getValue());
		if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.AL_VIEW_ALL_DATA)) {
			criteria.put("type", 1);
		} else if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.AL_VIEW_DPT_DATA)) {
			criteria.put("type", 2);
			String plateIds = PomPlatformClientUtil.getRolePlateId();
			criteria.put("plateIds",plateIds);
		} else if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.AL_VIEW_OWN_DATA)) {
			criteria.put("type", 3);
		} else {
			criteria.put("type", 3);
		}
		if (null!=searchForm.getValue("contractStatusM")) {
			String  contractStatusM= searchForm.getValues().get("contractStatusM").toString();
			contractStatusM=contractStatusM.replaceAll("\\[", "(");
     		contractStatusM=contractStatusM.replaceAll("\\]", ")");
     		criteria.put("contractStatusM", contractStatusM);
		}
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		form = new OnLoadAttachmentDataOfAttachmentSearchForm();
		if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.AL_VIEW_ALL_DATA)) {
			Map<String, Object> params = new HashMap<>();
			params.put("opt_type", "getDeptEmployee");
			params.put("type", 1);
			KeyValueManager.setValueMapFromQuery("EP_CustomAttachmentWorkProcess", params,
					form.getField("aliEmployeeId"));
		} else if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.AL_VIEW_DPT_DATA)) {
			Map<String, Object> params = new HashMap<>();
			params.put("employeeId", ClientUtil.getUserId());
			params.put("type", 2);
			String plateIds = PomPlatformClientUtil.getRolePlateId();
			params.put("plateIds",plateIds);
			params.put("opt_type", "getDeptEmployee");
			KeyValueManager.setValueMapFromQuery("EP_CustomAttachmentWorkProcess", params,
					form.getField("aliEmployeeId"));
		} else if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.AL_VIEW_OWN_DATA)) {
			form.getField("aliEmployeeId").setValueMap(KeyValueManager.getValueMap("employees"));
			form.getField("aliEmployeeId").setValue(ClientUtil.getUserId());
			form.getField("aliEmployeeId").setDisabled(true);
		} else {
			form.getField("aliEmployeeId").setValueMap(KeyValueManager.getValueMap("employees"));
			form.getField("aliEmployeeId").setValue(ClientUtil.getUserId());
			form.getField("aliEmployeeId").setDisabled(true);
		}
		return form;
	}

	@Override
	public DataSource getDataSource() {
		return DSOnLoadAttachmentDataOfAttachment.getInstance();
	}

	private OnLoadAttachmentDataOfAttachmentSearchForm form;
}
