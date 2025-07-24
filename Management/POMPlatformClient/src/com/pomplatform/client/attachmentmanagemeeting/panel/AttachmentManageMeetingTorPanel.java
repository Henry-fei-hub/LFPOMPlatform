package com.pomplatform.client.attachmentmanagemeeting.panel;

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
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.attachmentmanagemeeting.datasource.DSAttachmentManageMeetingTor;
import com.pomplatform.client.attachmentmanagemeeting.form.AttachmentManageMeetingTorSearchForm;
import com.pomplatform.client.attachmentmanagemeeting.form.AttachmentManageMeetingTorViewer;
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
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.CellSavedEvent;
import com.smartgwt.client.widgets.grid.events.CellSavedHandler;
import com.smartgwt.client.widgets.grid.events.CellSelectionChangedEvent;
import com.smartgwt.client.widgets.grid.events.CellSelectionChangedHandler;
import com.smartgwt.client.widgets.grid.events.ChangedEvent;
import com.smartgwt.client.widgets.grid.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.grid.events.EditFailedEvent;
import com.smartgwt.client.widgets.grid.events.EditFailedHandler;
import com.smartgwt.client.widgets.grid.events.EditorExitEvent;
import com.smartgwt.client.widgets.grid.events.EditorExitHandler;

public class AttachmentManageMeetingTorPanel extends AbstractSearchPanel {

	private static final Logger __LOGGER = Logger.getLogger("");

	private RightAttachmentManageMeetingTorPanel rightPanel;

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			AttachmentManageMeetingTorPanel cm = new AttachmentManageMeetingTorPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "AttachmentManageMeetingTor";
		}

	}

	@Override
	public void init() {
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid.setAutoFitFieldWidths(true);
	}

	@Override
	public void initComponents() {
		resultGrid.setCanEdit(true);
		// contractCodeField, contractNameField, amountField, returnAmountField,
		// projectManageIdField, contractIdField,
		// expectReturnDateField, needReturnAmountField, remarkField,
		// publishDateField, submitDateField, endDateField,
		// mettingStatusField, operatorStatusField
		ListGridField[] fields = new ListGridField[13];
		int index = 0;
		fields[index] = new ListGridField("contractCode");
		fields[index].setCanEdit(false);
		index++;
		fields[index] = new ListGridField("contractName");
		fields[index].setCanEdit(false);
		index++;
		fields[index] = new ListGridField("amount");
		fields[index].setCanEdit(false);
		index++;
		fields[index] = new ListGridField("invoiceAmount");
		fields[index].setCanEdit(false);
		index++;
		fields[index] = new ListGridField("returnAmount");
		fields[index].setCanEdit(false);
		index++;
		fields[index] = new ListGridField("projectManageId");
		if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.AC_ALL_DATA)) {
			fields[index].setCanEdit(true);
		} else {
			fields[index].setCanEdit(false);
		}
		index++;
		fields[index] = new ListGridField("expectReturnDate");
		fields[index].addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				//获取发票金额和回款金额
				BigDecimal invoiceAmount =BaseHelpUtils.getBigDecimalValue(event.getForm().getField("invoiceAmount").getValue());
				BigDecimal returnAmount =BaseHelpUtils.getBigDecimalValue(event.getForm().getField("returnAmount").getValue());
				event.getForm().getField("needReturnAmount").setValue(invoiceAmount.subtract(returnAmount));
			}
		});
		fields[index].setCanEdit(true);
		index++;
		fields[index] = new ListGridField("needReturnAmount");
		fields[index].setCanEdit(true);
		index++;
		fields[index] = new ListGridField("remark");
		fields[index].setWidth(200);
		fields[index].setCanEdit(true);
		index++;
		fields[index] = new ListGridField("publishDate");
		fields[index].setCanEdit(false);
		index++;
		fields[index] = new ListGridField("submitDate");
		fields[index].setCanEdit(false);
		index++;
		fields[index] = new ListGridField("endDate");
		fields[index].setCanEdit(false);
		index++;
		fields[index] = new ListGridField("operatorStatus");
		fields[index].setCanEdit(false);
		
		// resultGrid.setHeaderHeight(60);
		
		resultGrid.setFields(fields);
		resultGrid.addEditCompleteHandler(new EditCompleteHandler() {
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				Map newMap = event.getNewValues();
				Map oldMap = event.getOldValues().toMap();
				if(newMap.containsKey("expectReturnDate")){
					if(BaseHelpUtils.isNullOrEmpty(newMap.get("expectReturnDate"))){
						newMap.put("expectReturnDate", "kong");
					}
				}
				if(newMap.containsKey("needReturnAmount")){
					if(BaseHelpUtils.isNullOrEmpty(newMap.get("needReturnAmount"))){
						newMap.put("needReturnAmount", "kong");
					}
				}
				if(newMap.containsKey("remark")){
					if(BaseHelpUtils.isNullOrEmpty(newMap.get("remark"))){
						newMap.put("remark", "kong");
					}
				}
				if(!newMap.containsKey("projectManageId")){
					newMap.put("projectManageId", oldMap.get("projectManageId"));
				}
				newMap.put("attachmentManageId", oldMap.get("attachmentManageId"));
				newMap.put("operatorStatus", oldMap.get("operatorStatus"));
				newMap.put("optType", "updateAttachment");
				newMap.put("employeeId", ClientUtil.getEmployeeId());
				updateAttachment(newMap);
				commonQuery();
			}
		});
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.setIcon("[SKIN]/actions/refresh.png");
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});

		IButton operation1Button = new IButton("查看详情");
		controlLayout.addMember(operation1Button);
		operation1Button.setIcon("[SKIN]/actions/view.png");
		operation1Button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Record record = resultGrid.getSelectedRecord();
				getRightPanel().setAttachmentManageId(record.getAttributeAsInt("attachmentManageId"));
				getRightPanel().commonQuery();
			}
		});
		IButton removeButton = PermissionControl.createPermissionButton("删除", ERPPermissionStatic.AC_DELETE_BUTTON);
		controlLayout.addMember(removeButton);
		removeButton.setIcon("[SKIN]/actions/remove.png");
		removeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("Please select a data to remove.");
				}
				Map newMap = new HashMap<>();
				String ids="";
				Record[] selectRecords = resultGrid.getSelectedRecords();
				for (int i = 0; i < selectRecords.length; i++) {
					if (i != 0) {
						ids += ",";
					}
					ids += selectRecords[i].getAttribute("attachmentManageMeetingId");
				}
				newMap.put("ids", ids);
				newMap.put("optType", "deleteAttachment");
				final ListGridRecord selected = resultGrid.getSelectedRecord();
				DBDataSource.callOperation("EP_SponsorAttachment", newMap, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() < 0) {
							commonQuery();
							ClientUtil.displayErrorMessage(dsResponse);
						} else {
							SC.say("确认函删除成功");
						}
					}
				});
			}
		});

		IButton publishAttachmentButton = PermissionControl.createPermissionButton("发布确认函",
				ERPPermissionStatic.AC_PUBLISH_BUTTON);
		controlLayout.addMember(publishAttachmentButton);
		publishAttachmentButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				Map<String, Object> params = new HashMap<>();
				params.put("optType", "publishAttachment");
				DBDataSource.callOperation("EP_SponsorAttachment", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() >= 0) {
							commonQuery();
							SC.say("发布确认函成功");
						} else {
							ClientUtil.displayErrorMessage(dsResponse);
						}

					}
				});
			}
		});

		IButton submitAttachmentButton = PermissionControl.createPermissionButton("提交确认函",
				ERPPermissionStatic.AC_SUBMIT_BUTTON);
		controlLayout.addMember(submitAttachmentButton);
		submitAttachmentButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Map<String, Object> params = new HashMap<>();
				params.put("optType", "submitAttachment");
				Record[] records = resultGrid.getRecords();
				for (Record record : records) {
					if (record.toMap().get("projectManageId").equals(ClientUtil.getEmployeeId())) {
						params.put("projectManageId", ClientUtil.getEmployeeId());
						break;
					}
				}
				DBDataSource.callOperation("EP_SponsorAttachment", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						__LOGGER.info(dsResponse.toString());
						if (dsResponse.getStatus() >= 0) {
							commonQuery();
							SC.say("提交确认函成功");
						} else {
							//SC.say("123213123");
							SC.say(""+dsResponse.getErrors().get("errorMsg"));
						//	ClientUtil.displayErrorMessage(dsResponse);
						}

					}
				});
			}
		});
		IButton revokeAttachmentButton = PermissionControl.createPermissionButton("撤销",ERPPermissionStatic.AC_REVOKE_BUTTON);
		controlLayout.addMember(revokeAttachmentButton);
		revokeAttachmentButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("请选择相关数据撤销");
				}
				Map newMap = new HashMap<>();
				Map oldMap = resultGrid.getSelectedRecord().toMap();
				String ids="";
				Record[] selectRecords = resultGrid.getSelectedRecords();
				for (int i = 0; i < selectRecords.length; i++) {
					if (i != 0) {
						ids += ",";
					}
					ids += selectRecords[i].getAttribute("attachmentManageMeetingId");
				}
			//	newMap.put("projectManageId", oldMap.get("projectManageId"));
				newMap.put("ids", ids);
				newMap.put("operatorStatus", 1);
				newMap.put("optType", "revokeAttachment");
				//撤销单条数据
				//newMap.put("attachmentManageMeetingId", oldMap.get("attachmentManageMeetingId"));
				DBDataSource.callOperation("EP_SponsorAttachment", newMap, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() < 0) {
							ClientUtil.displayErrorMessage(dsResponse);
						} else {
							commonQuery();
							SC.say("撤销成功");
						}
					}
				});
			}
		});
		// PermissionControl.createPermissionButton("定稿",
		// ERPPermissionStatic.AC_ALL_DATA);
		IButton endAttachmentButton = PermissionControl.createPermissionButton("定稿", ERPPermissionStatic.AC_END_BUTTON);
		controlLayout.addMember(endAttachmentButton);
		endAttachmentButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Map<String, Object> params = new HashMap<>();
				params.put("optType", "endAttachment");
				params.put("", ClientUtil.getEmployeeId());
				DBDataSource.callOperation("EP_SponsorAttachment", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() >= 0) {
							commonQuery();
							SC.say("确认函定稿成功");
						} else {
							ClientUtil.displayErrorMessage(dsResponse);
						}

					}
				});
			}
		});
		commonQuery();
	}

	public void updateAttachment(Map newMap) {

		DBDataSource.callOperation("EP_SponsorAttachment", newMap, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					commonQuery();
					SC.say("修改成功");
				} else {
					SC.say(""+dsResponse.getErrors().get("errorMsg"));
					//ClientUtil.displayErrorMessage(dsResponse);
				}

			}
		});
		// DBDataSource.callOperation("ST_AttachmentManageMeeting", "update",
		// newMap, new DSCallback() {
		// @Override
		// public void execute(DSResponse dsResponse, Object data, DSRequest
		// dsRequest) {
		// if (dsResponse.getStatus() < 0) {
		// ClientUtil.displayErrorMessage(dsResponse);
		// } else {
		// commonQuery();
		// SC.say("修改成功");
		// }
		// }
		// });
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
				detail.setTitle("AttachmentManageMeetingTor");
				detail.setWidth100();
				detail.setHeight100();
				AttachmentManageMeetingTorViewer detailForm = new AttachmentManageMeetingTorViewer();
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
		criteria.put("addtionalCondition", "order by attachment_manage_meeting_id");
		if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.AC_ALL_DATA)) {
			List<Map> keyvalues = new ArrayList<>();
			Map<String, String> kv = new HashMap<>();
			kv.put("key", "AND amm.metting_status = ?");
			kv.put("value", "AND amm.metting_status = ? AND amm.metting_status IN(1, 2)");
			keyvalues.add(kv);
			criteria.put("keyValues", keyvalues);
		} else {
			criteria.put("mettingStatus", 2);
			criteria.put("projectManageId", ClientUtil.getEmployeeId());
		}

		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new AttachmentManageMeetingTorSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSAttachmentManageMeetingTor.getInstance();
	}

	public RightAttachmentManageMeetingTorPanel getRightPanel() {
		return rightPanel;
	}

	public void setRightPanel(RightAttachmentManageMeetingTorPanel rightPanel) {
		this.rightPanel = rightPanel;
	}

}
