package com.pomplatform.client.workflow.panel;

import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractExpansionRelatedPage;
import com.delicacy.client.ui.AttentionWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.preprojectnormalreimbursement.datasource.DSNormalReimbursementLinkMainProject;
import com.pomplatform.client.workflow.commonNormalReimbursement.datasource.DSNormalReimbursementLinkDepartment;
import com.pomplatform.client.workflow.datasource.DSNormalReimbursementsAttentionOfWorkflow;
import com.pomplatform.client.workflow.form.NormalReimbursementsAttentionOfWorkflowSearchForm;
import com.pomplatform.client.workflow.projectNormalReimbursement.datasource.DSNormalReimbursementLinkProject;
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

public class NormalReimbursementsAttentionOfWorkflowPanel extends AbstractExpansionRelatedPage
{

	private static final Logger __LOGGER = Logger.getLogger("");
	private static IButton auditButton;
	private static IButton agreeButton;
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			NormalReimbursementsAttentionOfWorkflowPanel cm = new NormalReimbursementsAttentionOfWorkflowPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "NormalReimbursementsAttentionOfWorkflow";
		}

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
		auditButton = new IButton("批阅");
		controlLayout.addMember(auditButton);
		auditButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                showDetail();
            }
        });
        
        agreeButton = new IButton("批量已阅");
        controlLayout.addMember(agreeButton);
        agreeButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
            	final ListGridRecord[] records = resultGrid.getSelection();
            	if(null != records && records.length > 0){
            		SC.confirm("您确定已经要进行批量操作吗？", new BooleanCallback() {
                        @Override
                        public void execute(Boolean value) {
                            if (value) {
                                submit(records, 0);
                            }
                        }
                    });
            	}else{
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
	}
	
	private int successSize = 0;
	public void submit(ListGridRecord[] records, int approvalment) {
		if(null != records){
			successSize = 0;
			for(ListGridRecord record: records){
				final int sizeRecord = records.length;
				Map params = record.toMap();
				params.put("approvalment", approvalment);
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

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("employeeId", ClientUtil.getUserId());
		criteria.put("status",status);
		criteria.put("processType",processType);
		return true;
	}
	
	@Override
    public int getSearchFormHeight() {
    	return 60;
    }


	@Override
	public SearchForm generateSearchForm() {
		return new NormalReimbursementsAttentionOfWorkflowSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSNormalReimbursementsAttentionOfWorkflow.getInstance();
	}

	private int status;
	private int processType;
	
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
		if(status == 2){//如果是已审核，则隐藏审批按钮
			agreeButton.hide();
			auditButton.hide();
		}else{
			resultGrid.setSelectionType(SelectionStyle.SIMPLE);  
			resultGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		}
		this.status = status;
	}

	@Override
	public DataSource getChildDataSource() {
		switch (this.processType) {
		case 2: //项目日常报销
			return DSNormalReimbursementLinkProject.getInstance();
		case 3: //普通日常报销
			return DSNormalReimbursementLinkDepartment.getInstance();
		case 8: //前期项目日常报销
			return DSNormalReimbursementLinkMainProject.getInstance();
		case 10: //公司日常报销
			return DSNormalReimbursementLinkDepartment.getInstance();
		default:
			break;
		}
		return null;
	}

}

