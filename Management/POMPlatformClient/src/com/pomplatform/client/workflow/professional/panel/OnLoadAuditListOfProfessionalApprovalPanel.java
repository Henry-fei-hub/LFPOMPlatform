package com.pomplatform.client.workflow.professional.panel;

import java.util.*;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.ui.*;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.workflow.panel.MyCostAllocationDesignPanel;
import com.pomplatform.client.workflow.panel.MyPersonnelFlowDesignPanel;
import com.pomplatform.client.workflow.professional.datasource.DSOnLoadAuditListOfProfessionalApproval;
import com.pomplatform.client.workflow.professional.form.NewOnLoadAuditListOfProfessionalApprovalForm;
import com.pomplatform.client.workflow.professional.form.OnLoadAuditListOfProfessionalApprovalSearchForm;
import com.pomplatform.client.workflow.professional.form.OnLoadAuditListOfProfessionalApprovalViewer;
import com.pomplatform.client.workflow.professional.form.UpdateOnLoadAuditListOfProfessionalApprovalForm;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.SelectionStyle;
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
import com.smartgwt.client.widgets.grid.ListGridField;
import com.delicacy.client.PanelFactory;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;

import java.util.logging.Logger;

public class OnLoadAuditListOfProfessionalApprovalPanel extends AbstractSearchPanel {
    private int successSize = 0;

    private static IButton auditButton;
    private static IButton batchAuditButton;
    private Integer status;

    private static final Logger __LOGGER = Logger.getLogger("");

    public static class Factory implements PanelFactory {
        private String id;

        @Override
        public Canvas create() {
            OnLoadAuditListOfProfessionalApprovalPanel cm = new OnLoadAuditListOfProfessionalApprovalPanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "OnLoadAuditListOfProfessionalApproval";
        }

    }

    @Override
    public void init() {
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
        operation1Button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                showDetail();
            }
        });
        auditButton = new IButton("审批");
        controlLayout.addMember(auditButton);
        auditButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (resultGrid.anySelected()) {
                    ListGridRecord selected = resultGrid.getSelectedRecords()[0];
                    if (BaseHelpUtils.getIntValue(selected.getAttributeAsObject("typeFlag")) == ClientStaticUtils.ACTIVITY_TYPE_FLAG_POOL) {
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
                    } else {
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
                } else {
                    SC.say("please select a record to edit");
                    return;
                }
            }
        });

        batchAuditButton = new IButton("批量审批");
//        SC.debugger();
        controlLayout.addMember(batchAuditButton);
        if (processType == 84) {
            batchAuditButton.hide();
        }
        batchAuditButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                final ListGridRecord[] records = resultGrid.getSelectedRecords();
                if (null != records && records.length > 0) {
                    SC.confirm("您确定已经要进行批量操作吗？", new BooleanCallback() {
                        @Override
                        public void execute(Boolean value) {
                            if (value) {
                                if (null != records) {
                                    successSize = 0;
                                    for (ListGridRecord record : records) {
                                        //record.setAttribute("personnelBusinessId", record.getAttribute("businessId"));
                                        final int recordSize = records.length;
                                        if (ClientUtil.checkAndGetIntValue(record.getAttribute("activityType")) == 3) {
                                            SC.say("对不起，处理节点不支持批量审批");
                                            return;
                                        }
                                        Map params = record.toMap();
                                        params.put("approvalment", 0);
                                        params.put("userData", record.toMap());
                                        String operationName = null;
                                        DBDataSource.callOperation(operationName, params, new DSCallback() {
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
                    SC.say("请选择一条数据");
                    return;
                }
                ListGridRecord selected = resultGrid.getSelectedRecord();
                ViewProcessWindow Reimbursement = new ViewProcessWindow();
                Reimbursement.setWidth("80%");
                Reimbursement.setHeight("80%");
                Reimbursement.setLayoutMode(0);
                Reimbursement.setInstanceData(selected);
                Reimbursement.initComponents();
                Reimbursement.setTitle("专业负责人审批");
                Reimbursement.setProcessId(ClientUtil.checkAndGetIntValue(selected.getAttribute("processId")));
                Reimbursement.show();

				/*ListGridRecord selected = resultGrid.getSelectedRecord();
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle(ClientUtil.getProcessTypeName(selected));
				//detail.setTitle("专业负责人审批");
				detail.setWidth100();
				detail.setHeight100(); 
				OnLoadAuditListOfProfessionalApprovalViewer detailForm = new OnLoadAuditListOfProfessionalApprovalViewer();
				detailForm.setParentSearchForm(searchForm);
				detailForm.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_TAB);
				detailForm.initComponents();
				detailForm.viewSelectedData(resultGrid);
				detail.setContent(detailForm);
				detail.centerInPage();
				detail.show();*/
            }
        });
    }

    @Override
    public boolean checkSearchCriteria(Map criteria) {
        List<Map> keyvalues = new ArrayList<>();
        if (ACTIVITY_TYPE_7 == activityType) {
            auditButton.hide();
            batchAuditButton.hide();
        }
        criteria.put("employeeId", ClientUtil.getUserId());
        criteria.put("processType", processType);
        __LOGGER.info("status:" + status);
        if(status==1) {
            criteria.put("status",status);
        }else if(status==2) {
            criteria.put("status",status);
        }
        
        criteria.put("addtionalCondition", "order by process_instance_activity_id");
        criteria.put("addtionalCondition", "order by professional_approval__id");
        return true;
    }

    @Override
    public int getSearchFormHeight() {
        return 60;
    }

    @Override
    public SearchForm generateSearchForm() {
        return new OnLoadAuditListOfProfessionalApprovalSearchForm();
    }

    @Override
    public DataSource getDataSource() {
        return DSOnLoadAuditListOfProfessionalApproval.getInstance();
    }

    private int processType;

    public int getProcessType() {
        return processType;
    }

    public void setProcessType(int processType) {
        this.processType = processType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
//        if ("2".equals(status) || "3".equals(status)) {//如果是已审核，则隐藏审批按钮
//            auditButton.hide();
//            batchAuditButton.hide();
//        }
//        this.status = status;
        if(status == 2){//如果是已审核，则隐藏审批按钮
            auditButton.hide();
            batchAuditButton.hide();

        }else{
            auditButton.show();
            batchAuditButton.show();
//			newProcessButton.show();
//			deleteCostButton.show();
            resultGrid.setSelectionType(SelectionStyle.SIMPLE);
            resultGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
        }
        this.status = status;
    }

    private int activityType;

    public int getActivityType() {
        return activityType;
    }

    public void setActivityType(int activityType) {
        this.activityType = activityType;
    }

    public static final int ACTIVITY_TYPE_7 = 7;
}

