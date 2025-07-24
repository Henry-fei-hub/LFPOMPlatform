package com.pomplatform.client.projectstages.panel;

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
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.projectstages.datasource.DSOnLoadAuditListOfProjectStages;
import com.pomplatform.client.projectstages.form.OnLoadAuditListOfProjectStagesSearchForm;
import com.pomplatform.client.projectstages.form.OnLoadAuditListOfProjectStagesViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class OnLoadAuditListOfProjectStagesPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			OnLoadAuditListOfProjectStagesPanel cm = new OnLoadAuditListOfProjectStagesPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OnLoadAuditListOfProjectStages";
		}

	}

	private static IButton auditButton;
	
	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
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
            @Override
            public void onClick(ClickEvent event) {
            	generateAuditPanel();
            }
        });
//		commonQuery();
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
				ListGridRecord selected = resultGrid.getSelectedRecord();
                ViewProcessWindow Reimbursement = new ViewProcessWindow();
                Reimbursement.setLayoutMode(0);
                Reimbursement.setInstanceData(selected);
                Reimbursement.initComponents();
                Reimbursement.setWidth100();
                Reimbursement.setHeight100();
                Reimbursement.centerInPage();
                Reimbursement.setTitle("报价单审核流程");
                Reimbursement.show();
			}
		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		List<Map> keyvalues = new ArrayList<>();
		criteria.put("employeeId", ClientUtil.getUserId());
		if(status==1) {
			criteria.put("status",status);
		}else if(status==2) {
			Map<String, String> kv = new HashMap<>();
			kv.put("key", "spia.status = ?");
			kv.put("value", "1 =? and spia.status in (2,3,4,5,6)");
			keyvalues.add(kv);
			
			Map<String, String> kv2 = new HashMap<>();
			kv2.put("key", "sppt.status = ?");
			kv2.put("value", "sppt.status =? and sppt.status in (2,3,4,5,6)");
			keyvalues.add(kv2);
		}
		if(!keyvalues.isEmpty()) {
			criteria.put("keyValues", keyvalues);
		}
		return true;
	}
	
	public void generateAuditPanel() {
		if(resultGrid.anySelected()){
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
				Reimbursement.setLayoutMode(0);
				Reimbursement.setInstanceData(selected);
				Reimbursement.setProcessId(ClientUtil.checkAndGetIntValue(selected.getAttribute("processId")));
				Reimbursement.initComponents();
				Reimbursement.setTitle(ClientUtil.getProcessTypeName(selected));
				Reimbursement.setWidth100();
				Reimbursement.setHeight100();
				Reimbursement.centerInPage();
				Reimbursement.show();
    		}else {
    			//	普通节点审批
    			ApprovalmentWindow Reimbursement = new ApprovalmentWindow();
    			Reimbursement.addDataEditedHandler(new DataEditedHandler(){
    				@Override
    				public void onDataEdited(DataEditEvent event) {
						commonQuery();
    				}
    			});
    			Reimbursement.setLayoutMode(0);
    			Reimbursement.setInstanceData(selected);
    			Reimbursement.initComponents();
    			Reimbursement.setTitle(ClientUtil.getProcessTypeName(selected));
    			Reimbursement.setWidth100();
    			Reimbursement.setHeight100();
    			Reimbursement.centerInPage();
    			Reimbursement.show();
    		}
    	}else{
            SC.say("please select a record to edit");
            return;
        }
	}


	@Override
	public SearchForm generateSearchForm() {
		return new OnLoadAuditListOfProjectStagesSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSOnLoadAuditListOfProjectStages.getInstance();
	}
	
	private int status;
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		if(status==2) {
			auditButton.hide();
		}
		this.status = status;
	}
	
	@Override
	public int getSearchFormHeight() {
		return 60;
	}


}

