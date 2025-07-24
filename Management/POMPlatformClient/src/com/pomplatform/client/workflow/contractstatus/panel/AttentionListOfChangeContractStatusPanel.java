package com.pomplatform.client.workflow.contractstatus.panel;

import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.process.SystemProcessConstants;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.AttentionWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.workflow.contractstatus.datasource.DSAttentionListOfChangeContractStatus;
import com.pomplatform.client.workflow.contractstatus.form.AttentionListOfChangeContractStatusSearchForm;
import com.pomplatform.client.workflow.panel.MyCostAllocationDesignPanel;
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

public class AttentionListOfChangeContractStatusPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	private Integer processType;
	private Integer status;
	private static IButton auditButton;
	private static IButton agreeButton;
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			AttentionListOfChangeContractStatusPanel cm = new AttentionListOfChangeContractStatusPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "AttentionListOfChangeContractStatus";
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
            	final ListGridRecord[] records = resultGrid.getSelectedRecords();
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
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				ListGridRecord selected = resultGrid.getSelectedRecord();
                AttentionWindow Reimbursement = new AttentionWindow();
                Reimbursement.addDataEditedHandler(new DataEditedHandler() {
                    @Override
                    public void onDataEdited(DataEditEvent event) {
                        commonQuery();
                    }

                });
                Reimbursement.setLayoutMode(0);
                Reimbursement.setInstanceData(selected);
                Reimbursement.initComponents();
                Reimbursement.setTitle(ClientUtil.getProcessTypeName(selected));
                Reimbursement.setWidth("60%");
                Reimbursement.setHeight100();
                Reimbursement.centerInPage();
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
		if(!BaseHelpUtils.isNullOrEmpty(processType)) {
			criteria.put("processType", processType);
		}
		if(!BaseHelpUtils.isNullOrEmpty(status)) {
			criteria.put("status", status);
		}
		criteria.put("employeeId", ClientUtil.getUserId());
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new AttentionListOfChangeContractStatusSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSAttentionListOfChangeContractStatus.getInstance();
	}

	public void resetDataSource() {
		DataSource ds = getDataSource();
		if(Objects.equals(status, SystemProcessConstants.ATTENTION_STATUS_DONE)){//如果是已审核，则隐藏审批按钮
			agreeButton.hide();
			auditButton.hide();
		}else{
			resultGrid.setSelectionType(SelectionStyle.SIMPLE);  
			resultGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		}
	}
	
	public Integer getProcessType() {
		return processType;
	}

	public void setProcessType(Integer processType) {
		this.processType = processType;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}

