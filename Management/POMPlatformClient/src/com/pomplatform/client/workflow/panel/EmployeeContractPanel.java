package com.pomplatform.client.workflow.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.EditProcessWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.ViewProcessWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.workflow.datasource.DSEmployeeContract;
import com.pomplatform.client.workflow.form.EmployeeContractSearchForm;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class EmployeeContractPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	private String status;
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			EmployeeContractPanel cm = new EmployeeContractPanel();
			id = cm.getID();
			return cm;
		}


		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "EmployeeContract";
		}

	}

	@Override
	public void init(){
		super.init();
		resultGrid.setAutoFitFieldWidths(false);
		__controlPosition = LayoutConstant.RIGHT;
	}

	public int activityType;
	public int getActivityType() {
		return activityType;
	}

	public void setActivityType(int activityType) {
		this.activityType = activityType;
	}


	@Override
	public void initComponents() {
		resultGrid.setAutoFitFieldWidths(false);
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.setIcon("[SKIN]/actions/refresh.png");
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
		commonQuery();


		IButton editButton = new IButton("撤销修改");
		controlLayout.addMember(editButton);
		editButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {

					@Override
					public void onSuccess() {
						if (!resultGrid.anySelected()) {
							SC.say("please select a record to edit");
							return;
						}
						ListGridRecord selected = resultGrid.getSelectedRecord();
						SC.debugger();
						int status = selected.getAttributeAsInt("processStatus");
						if (status != 0) {
							SC.say("对不起，该申请不能修改！");
							return;
						}
						EditProcessWindow Reimbursement = new EditProcessWindow();
						Reimbursement.addDataEditedHandler(new DataEditedHandler() {
							@Override
							public void onDataEdited(DataEditEvent event) {
								DBDataSource.copyRecord(event.getData(), resultGrid.getSelectedRecord());
								resultGrid.redraw();
							}
						});
						Reimbursement.setLayoutMode(0);
						Reimbursement.setProcessId(selected.getAttributeAsInt("processId"));
						Reimbursement.setInstanceData(selected);
						Reimbursement.initComponents();
						Reimbursement.setTitle(ClientUtil.getProcessTypeName(selected));
						Reimbursement.show();
					}

					@Override
					public void onFailure(Throwable reason) {
						SC.say("请按Ctrl+F5刷新页面再操作");
					}
				});

			}
		});
		resultGrid.setAutoFitFieldWidths(true);
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
				LinkedHashMap<String, String> map = KeyValueManager.getValueMap("processExecutors");
				ViewProcessWindow Reimbursement = new ViewProcessWindow();
				Reimbursement.setWidth("80%");
				Reimbursement.setHeight("80%");
				Reimbursement.setLayoutMode(0);
				Reimbursement.setInstanceData(selected);
				SC.debugger();
				int processId = ClientUtil.checkAndGetIntValue(selected.getAttribute("processId"));

				Reimbursement.setProcessId(ClientUtil.checkAndGetIntValue(selected.getAttribute("processId")));
				Reimbursement.initComponents();
				Reimbursement.setTitle(ClientUtil.getProcessTypeName(selected));
				Reimbursement.show();
			}
		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		List<Map> keyvalues = new ArrayList<>();
		criteria.put("employeId",ClientUtil.getEmployeeId());
		if(!BaseHelpUtils.isNullOrEmpty(status)) {
			Map<String, String> kv2 = new HashMap<>();
			kv2.put("key", "A.process_status IN ( 0, 1 )");
			kv2.put("value", status);
			keyvalues.add(kv2);

		}
		if(!BaseHelpUtils.isNullOrEmpty(keyvalues)) {
			criteria.put("keyValues", keyvalues);
		}
		return true;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new EmployeeContractSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSEmployeeContract.getInstance();
	}


}

