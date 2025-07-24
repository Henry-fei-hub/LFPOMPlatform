package com.pomplatform.client.workflow.professional.panel;

import java.util.Date;

import com.delicacy.client.ui.*;
import com.pomplatform.client.workflow.professional.datasource.DSOnLoadAttentionListOfProfessionalApproval;
import com.pomplatform.client.workflow.professional.form.NewOnLoadAttentionListOfProfessionalApprovalForm;
import com.pomplatform.client.workflow.professional.form.OnLoadAttentionListOfProfessionalApprovalSearchForm;
import com.pomplatform.client.workflow.professional.form.OnLoadAttentionListOfProfessionalApprovalViewer;
import com.pomplatform.client.workflow.professional.form.UpdateOnLoadAttentionListOfProfessionalApprovalForm;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
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

import com.smartgwt.client.widgets.grid.ListGridField;
import com.delicacy.client.PanelFactory;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class OnLoadAttentionListOfProfessionalApprovalPanel extends AbstractSearchPanel
{

	private static IButton agreeButton;
	private static IButton batchAgreeButton;

	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			OnLoadAttentionListOfProfessionalApprovalPanel cm = new OnLoadAttentionListOfProfessionalApprovalPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OnLoadAttentionListOfProfessionalApproval";
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
		IButton operation1Button = new IButton("查看详情");
		controlLayout.addMember(operation1Button);
		operation1Button.setIcon("[SKIN]/actions/view.png");
		operation1Button.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		agreeButton = new IButton("批阅");
		controlLayout.addMember(agreeButton);
		agreeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("please select a record to edit");
					return;
				}
				ListGridRecord selected = resultGrid.getSelectedRecord();
				AttentionWindow Reimbursement = new AttentionWindow();
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
		});

		batchAgreeButton = new IButton("批量已阅");
		controlLayout.addMember(batchAgreeButton);
		batchAgreeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				final ListGridRecord[] records = resultGrid.getSelection();
				if(null != records && records.length > 0){
					SC.confirm("您确定已经要进行批量操作吗？", new BooleanCallback() {
						@Override
						public void execute(Boolean value) {
							if (value) {
								if(null != records){
									successSize = 0;
									for(ListGridRecord record: records){
										final int sizeRecord = records.length;
										Map params = record.toMap();
										params.put("approvalment", 0);
										DBDataSource.callOperation("EP_AttentionProcessor", params, new DSCallback() {
											@Override
											public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
												if (dsResponse.getStatus() >= 0) {
													successSize++;
													if(sizeRecord == successSize){
														commonQuery();
													}
												}else{
													SC.say(dsResponse.getErrors().get("errorMsg").toString());
													return;
												}
											}
										});
									}
								}
							}
						}
					});
				}else{
					SC.say("please select a record");
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
				ListGridRecord selected = resultGrid.getSelectedRecord();
				GenericViewWindow detail = new GenericViewWindow();
				//detail.setTitle("OnLoadAttentionListOfProfessionalApproval");
				detail.setTitle(ClientUtil.getProcessTypeName(selected));
				detail.setWidth100(); 
				detail.setHeight100(); 
				OnLoadAttentionListOfProfessionalApprovalViewer detailForm = new OnLoadAttentionListOfProfessionalApprovalViewer();
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
		if (ACTIVITY_TYPE_8 == activityType) {
			agreeButton.hide();
			batchAgreeButton.hide();
		}
		criteria.put("employeeId", ClientUtil.getUserId());
		criteria.put("employeeNo", ClientUtil.getUserNo());
		criteria.put("processType", processType);
		criteria.put("status", status);
		return true;
	}

	@Override
	public int getSearchFormHeight() {
		return 60;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new OnLoadAttentionListOfProfessionalApprovalSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSOnLoadAttentionListOfProfessionalApproval.getInstance();
	}

	private int successSize = 0;
	private int processType;
	private int status;

	public int getProcessType() {
		return processType;
	}

	public void setProcessType(int processType) {
		this.processType = processType;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		if(status == 2){//如果是已办-知会，则隐藏审批按钮
			agreeButton.hide();
			batchAgreeButton.hide();
		}
		this.status = status;
	}

	public static final int ACTIVITY_TYPE_8 = 8;

	private int activityType;

	public int getActivityType() {
		return activityType;
	}

	public void setActivityType(int activityType) {
		this.activityType = activityType;
	}
}

