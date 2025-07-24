package com.pomplatform.client.workflow.panel;

import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.ApprovalmentWindow;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.approveprojectstagestorageor.form.SapproveprojectstagestorageorViewer;
import com.pomplatform.client.workflow.datasource.DSOnLoadAuditListOfApproveProjectStageStroage;
import com.pomplatform.client.workflow.form.OnLoadAuditListOfApproveProjectStageStroageSearchForm;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class OnLoadAuditListOfApproveProjectStageStroagePanel extends AbstractSearchPanel
{

	private static IButton auditButton;
	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			OnLoadAuditListOfApproveProjectStageStroagePanel cm = new OnLoadAuditListOfApproveProjectStageStroagePanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OnLoadAuditListOfApproveProjectStageStroage";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
	}

	@Override
	public void initComponents() {
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
		
		auditButton = new IButton("审批");
		controlLayout.addMember(auditButton);
		auditButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
            	ListGridRecord[] records = resultGrid.getSelection();
            	if(null != records && records.length > 0){
            		ListGridRecord selected = records[0];
                    ApprovalmentWindow Reimbursement = new ApprovalmentWindow();
                    Reimbursement.addDataEditedHandler(new DataEditedHandler(){
                        @Override
                        public void onDataEdited(DataEditEvent event) {
                            commonQuery();
                        }
                    });
                    SC.debugger();
                    Reimbursement.setNeedPagination(false);
                    Reimbursement.setWidth("80%");
                    Reimbursement.setHeight("80%");
                    Reimbursement.setLayoutMode(0);
                    Reimbursement.setInstanceData(selected);
                    Reimbursement.initComponents();
                    Reimbursement.setTitle(ClientUtil.getProcessTypeName(selected));
                    Reimbursement.show();
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
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("自定义项目阶段模板申请"); 
				detail.setWidth("60%"); 
				detail.setHeight("60%"); 
//				OnLoadAuditListOfApproveProjectStageStroageViewer detailForm = new OnLoadAuditListOfApproveProjectStageStroageViewer();
				SapproveprojectstagestorageorViewer detailForm = new SapproveprojectstagestorageorViewer();
//				approveprojectstagestoragecorViewer detailForm = new approveprojectstagestoragecorViewer();
				detailForm.setParentSearchForm(searchForm);
				detailForm.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_TAB);
				Record record = resultGrid.getSelectedRecord();
				detailForm.initComponents(record);
				detailForm.viewSelectedData(resultGrid);
				detail.setContent(detailForm);
				detail.centerInPage();
				detail.show();
			}
		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("employeeId", ClientUtil.getUserId());
		criteria.put("processType", processType);
		criteria.put("status", status);
/*		criteria.put("addtionalCondition", "order by process_instance_activity_id");
		criteria.put("addtionalCondition", "order by approve_project_stage_storage_id");*/
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new OnLoadAuditListOfApproveProjectStageStroageSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSOnLoadAuditListOfApproveProjectStageStroage.getInstance();
	}
	
	private int processType;
	
	private int status;
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		if(status == 2){//如果是已审核，则隐藏审批按钮
			auditButton.hide();
		}else{
			resultGrid.setSelectionType(SelectionStyle.SIMPLE);  
			resultGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		}
		this.status = status;
	}

	public int getProcessType() {
		return processType;
	}

	public void setProcessType(int processType) {
		this.processType = processType;
	}


}

