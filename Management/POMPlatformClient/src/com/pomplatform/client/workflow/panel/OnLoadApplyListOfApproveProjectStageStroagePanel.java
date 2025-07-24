package com.pomplatform.client.workflow.panel;

import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.EditProcessWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.ViewProcessWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.workflow.datasource.DSOnLoadApplyListOfApproveProjectStageStroage;
import com.pomplatform.client.workflow.form.OnLoadApplyListOfApproveProjectStageStroageSearchForm;
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

public class OnLoadApplyListOfApproveProjectStageStroagePanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			OnLoadApplyListOfApproveProjectStageStroagePanel cm = new OnLoadApplyListOfApproveProjectStageStroagePanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OnLoadApplyListOfApproveProjectStageStroage";
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
/*				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("自定义项目阶段模板申请"); 
				detail.setWidth("60%"); 
				detail.setHeight("60%"); 
//				OnLoadApplyListOfApproveProjectStageStroageViewer detailForm = new OnLoadApplyListOfApproveProjectStageStroageViewer();
				SapproveprojectstagestorageorViewer detailForm = new SapproveprojectstagestorageorViewer();
				detailForm.setParentSearchForm(searchForm);
				detailForm.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_TAB);
				Record record = resultGrid.getSelectedRecord();
//				detailForm.initComponents();
				detailForm.initComponents(record);
				detailForm.viewSelectedData(resultGrid);
				detail.setContent(detailForm);
				detail.centerInPage();
				detail.show();*/
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

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		SC.debugger();
		String userId = ClientUtil.getUserId();
		criteria.put("employeeId", ClientUtil.getUserId());
		criteria.put("processType",processType);
/*		criteria.put("addtionalCondition", "order by process_instance_id");
		criteria.put("addtionalCondition", "order by approve_project_stage_storage_id");*/
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new OnLoadApplyListOfApproveProjectStageStroageSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSOnLoadApplyListOfApproveProjectStageStroage.getInstance();
	}

	public void createUploadButton() {
		// TODO Auto-generated method stub
		
	}
	
	private int processType;
	
	public int getProcessType() {
		return processType;
	}

	public void setProcessType(int processType) {
		this.processType = processType;
	}



}

