package com.pomplatform.client.bonuspayment.panel;

import java.util.ArrayList;
import java.util.Date;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.PopupWindow;
import com.delicacy.client.ui.ViewProcessWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PooledTaskWindow;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.ClientUtil;
import com.smartgwt.client.widgets.grid.events.SelectionChangedHandler;
import com.smartgwt.client.widgets.grid.events.SelectionEvent;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.grid.events.SelectionUpdatedEvent;
import com.smartgwt.client.widgets.grid.events.SelectionUpdatedHandler;
import java.util.Objects;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.ApprovalmentWindow;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.bonuspayment.datasource.DSBonusPaymentAuditOfWorkflow;
import com.pomplatform.client.bonuspayment.form.BonusPaymentAuditOfWorkflowSearchForm;
import com.pomplatform.client.bonuspayment.form.BonusPaymentAuditOfWorkflowViewer;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.trainingmanagement.form.trainingManagementsApplyOfWorkflowViewer;
import com.pomplatform.client.workflow.form.BonusPaymentRecordWithBViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class BonusPaymentAuditOfWorkflowPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	private static IButton auditButton;
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			BonusPaymentAuditOfWorkflowPanel cm = new BonusPaymentAuditOfWorkflowPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "BonusPaymentAuditOfWorkflow";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid.setAutoFitFieldWidths(false);
		resultGrid.setCanEdit(false);
		resultGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
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
		IButton viewButton = new IButton("查看详细");
		viewButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		controlLayout.addMember(viewButton);
		
		auditButton = new IButton("审批");
		controlLayout.addMember(auditButton);
		auditButton.addClickHandler(new ClickHandler() {
			@SuppressWarnings("deprecation")
			@Override
			public void onClick(ClickEvent event) {
				if(resultGrid.anySelected()){
					SC.debugger();
            		ListGridRecord selected = resultGrid.getSelectedRecords()[0];
            		if(BaseHelpUtils.getIntValue(selected.getAttributeAsObject("typeFlag")) == ClientStaticUtils.ACTIVITY_TYPE_FLAG_POOL) {
            			//	任务池审批
            			PooledTaskWindow Reimbursement = new PooledTaskWindow();
                        Reimbursement.addDataEditedHandler(new DataEditedHandler() {
                            @Override
                            public void onDataEdited(DataEditEvent event) {
                                commonQuery();
                            }
                        });
                        Reimbursement.setWidth100();
                        Reimbursement.setHeight100();
                        Reimbursement.setLayoutMode(0);
                        Reimbursement.setInstanceData(selected);
                        Reimbursement.setProcessId(ClientUtil.checkAndGetIntValue(selected.getAttribute("processId")));
                        Reimbursement.initComponents();
                        Reimbursement.setTitle(ClientUtil.getProcessTypeName(selected));
                        Reimbursement.show();
            		}else {
            			//	普通节点审批
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
            		}
            	}else{
                    SC.say("please select a record to edit");
                    return;
                }
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
                Reimbursement.setProcessId(ClientUtil.checkAndGetIntValue(selected.getAttribute("processId")));
                Reimbursement.initComponents();
                Reimbursement.setTitle(ClientUtil.getProcessTypeName(selected));
                Reimbursement.show();
			}
		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {

		criteria.put("employeeId", ClientUtil.getUserId());
		SC.debugger();
 		List<Map> keyvalues = new ArrayList<>();
		if(status == 1){
			criteria.put("status", status);
		}else if(status == 2){
			Map<String, String> kv = new HashMap<>();
			kv.put("key", "spia.status =?");
			kv.put("value", "spia.status =? and spia.status in (2,3,4,5,6)");
			keyvalues.add(kv);

			Map<String, String> kv3 = new HashMap<>();
			kv3.put("key", "sppt.status =?");
			kv3.put("value", "sppt.status =? and sppt.status in (2,3,4,5,6)");
			keyvalues.add(kv3);
		}
		if(!BaseHelpUtils.isNullOrEmpty(keyvalues)){
			criteria.put("keyValues", keyvalues);
		}
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new BonusPaymentAuditOfWorkflowSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSBonusPaymentAuditOfWorkflow.getInstance();
	}
	
	public int getSearchFormHeight() {
		return 60;
	}
	
	private int status;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		if (status == 2) {// 如果是已审核，则隐藏审批按钮
			auditButton.hide();
		} else {
			resultGrid.setSelectionType(SelectionStyle.SIMPLE);
			resultGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		}
		this.status = status;
	}
	
	


}

