package com.pomplatform.client.scapitaldistributionor.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.ApprovalmentWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.ViewProcessWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.scapitaldistributionor.datasource.DSCapitalDistributionsAuditOfWorkflow;
import com.pomplatform.client.scapitaldistributionor.form.CapitalDistributionsAuditOfWorkflowSearchForm;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class CapitalDistributionsAuditOfWorkflowPanel extends AbstractSearchPanel {

	private static IButton auditButton;
	private static IButton agreeButton;
	@SuppressWarnings("unused")
	private static final Logger __LOGGER = Logger.getLogger("");

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			CapitalDistributionsAuditOfWorkflowPanel cm = new CapitalDistributionsAuditOfWorkflowPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "CapitalDistributionsAuditOfWorkflow";
		}

	}

	@Override
	public void init() {
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
	}

	@Override
	public void initComponents() {
		resultGrid.setShowRowNumbers(true);
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
		auditButton = new IButton("审批");
		controlLayout.addMember(auditButton);
		auditButton.addClickHandler(new ClickHandler() {
			@SuppressWarnings("deprecation")
			@Override
			public void onClick(ClickEvent event) {
				ListGridRecord[] records = resultGrid.getSelection();
				if (null != records && records.length > 0) {
					ListGridRecord selected = records[0];
					ApprovalmentWindow Reimbursement = new ApprovalmentWindow();
					Reimbursement.addDataEditedHandler(new DataEditedHandler() {
						@Override
						public void onDataEdited(DataEditEvent event) {
							commonQuery();
						}
					});
					Reimbursement.setWidth("80%");
					Reimbursement.setHeight("80%");
					Reimbursement.setLayoutMode(0);
					Reimbursement.setInstanceData(selected);
					Reimbursement.initComponents();
					Reimbursement.setTitle(ClientUtil.getProcessTypeName(selected));
					Reimbursement.show();
				} else {
					SC.say("please select a record to edit");
					return;
				}
			}
		});

		agreeButton = new IButton("批量审批");
//		controlLayout.addMember(agreeButton);
		agreeButton.addClickHandler(new ClickHandler() {
			@SuppressWarnings("deprecation")
			@Override
			public void onClick(ClickEvent event) {
				final ListGridRecord[] records = resultGrid.getSelection();
				if (null != records && records.length > 0) {
					SC.confirm("您确定已经要进行批量操作吗？", new BooleanCallback() {
						@Override
						public void execute(Boolean value) {
							if (value) {
								submit(records, 0);
							}
						}
					});
				} else {
					SC.say("please select a record");
					return;
				}
			}
		});
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
					SC.say("please select a record to edit");
					return;
				}
				ListGridRecord selected = resultGrid.getSelectedRecord();
				ViewProcessWindow Reimbursement = new ViewProcessWindow();
				Reimbursement.setWidth("80%");
				Reimbursement.setHeight("80%");
				Reimbursement.setLayoutMode(0);
				Reimbursement.setInstanceData(selected);
				Reimbursement.initComponents();
				Reimbursement.setTitle(ClientUtil.getProcessTypeName(selected));
				Reimbursement.show();
			}
		});
	}

	private int successSize = 0;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void submit(ListGridRecord[] records, int approvalment) {
		if (null != records) {
			successSize = 0;
			for (ListGridRecord record : records) {
				if(ClientUtil.checkAndGetIntValue(record.getAttribute("activityType")) == 3){
					SC.say("对不起，处理节点不支持批量审批");
					return;
				}
				record.setAttribute("capitalDistributionId", record.getAttribute("businessId"));
				final int recordSize = records.length;
				Map params = record.toMap();
				params.put("approvalment", approvalment);
				params.put("userData", record.toMap());
				DBDataSource.callOperation("EP_WorkFlowActivityProcessor", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() >= 0) {
							successSize++;
							if (recordSize == successSize) {
								commonQuery();
							}
						} else {
							SC.say(dsResponse.getErrors().get("errorMsg").toString());
							return;
						}
					}
				});
			}
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("employeeId", ClientUtil.getUserId());
		if(status==1) {
			criteria.put("status",status);
		}else if(status==2) {
			List<Map> keyvalues = new ArrayList<>();
				Map<String, String> kv = new HashMap<>();
				kv.put("key", "spia.status =?");
				kv.put("value", "spia.status =? and spia.status in (2,3,6)");
				keyvalues.add(kv);
				criteria.put("keyValues", keyvalues);
		}
		criteria.put("processType", processType);
		if (!BaseHelpUtils.isNullOrEmpty(code)) {
			criteria.put("code", code);
		}
		criteria.put("addtionalCondition", "order by process_instance_id");
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new CapitalDistributionsAuditOfWorkflowSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSCapitalDistributionsAuditOfWorkflow.getInstance();
	}

	private int status;
	private int processType;
	private String code;

	public int getProcessType() {
		return processType;
	}

	public void setProcessType(int processType) {
		this.processType = processType;
	}

	public int getStatus() {
		return status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setStatus(int status) {
		if (status == 2) {// 如果是已审核，则隐藏审批按钮
			agreeButton.hide();
			auditButton.hide();
		} else {
			resultGrid.setSelectionType(SelectionStyle.SIMPLE);
			resultGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		}
		this.status = status;
	}
}
