package com.pomplatform.client.stagemodel.panel;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.attachment.datasource.DSOnLoadAttachmentDataOfAttachment;
import com.pomplatform.client.attachment.form.OnLoadAttachmentDataOfAttachmentViewer;
import com.pomplatform.client.common.ClientStaticUtils;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.GroupStartOpen;
import com.smartgwt.client.types.SortDirection;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridField;

public class OnLoadAttachmentDataOfAttachmentPanel extends AbstractSearchPanel implements HasHandlers {
	private static final Logger __LOGGER = Logger.getLogger("");
	
	protected final HandlerManager handlerManager = new HandlerManager(this);

	private IButton sureButton;
	
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
				paymentGradeDescriptionField, operateEmployeeIdField, operateTimeField, remarkField, haveVoucherField);

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
						String evidence = "确认函：" + record.getAttribute("perfessionRemark") + "; ID:" + record.getAttribute("attachmentManageId");
						Date confirmDate = record.getAttributeAsDate("operateTime");
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
		
		resultGrid.setGroupStartOpen(GroupStartOpen.NONE);
		resultGrid.setGroupSortDirection(SortDirection.DESCENDING);
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
		if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.AL_VIEW_ALL_DATA)) {
			criteria.put("type", 1);
		} else if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.AL_VIEW_DPT_DATA)) {
			criteria.put("type", 2);
		} else if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.AL_VIEW_OWN_DATA)) {
			criteria.put("type", 3);
		} else {
			criteria.put("type", 3);
		}
		criteria.put("contractId", contractId);
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSOnLoadAttachmentDataOfAttachment.getInstance();
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
