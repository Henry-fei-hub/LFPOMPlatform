package com.pomplatform.client.workflow.panel;

import java.util.*;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.ui.*;
import com.pomplatform.client.common.ClientStaticUtils;
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
import com.pomplatform.client.workflow.datasource.DSOnLoadApproveContractRunDry;
import com.pomplatform.client.workflow.form.OnLoadApproveContractRunDrySearchForm;
import com.pomplatform.client.workflow.form.OnLoadApproveContractRunDryViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;

import java.util.logging.Logger;

public class OnLoadApproveContractRunDryPanel extends AbstractSearchPanel {

    private int successSize = 0;

    private static IButton auditButton;
    private static final Logger __LOGGER = Logger.getLogger("");

    public static class Factory implements PanelFactory {
        private String id;

        @Override
        public Canvas create() {
            OnLoadApproveContractRunDryPanel cm = new OnLoadApproveContractRunDryPanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "OnLoadApproveContractRunDry";
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
                        Reimbursement.setData(selected);
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
                Reimbursement.setTitle("订单下达审批");
                Reimbursement.setProcessId(ClientUtil.checkAndGetIntValue(selected.getAttribute("processId")));
                Reimbursement.show();
            }
        });
    }

    @Override
    public boolean checkSearchCriteria(Map criteria) {
        if (ACTIVITY_TYPE_7 == activityType) {
            auditButton.hide();
        }
        criteria.put("processType", processType);
        criteria.put("employeeId", ClientUtil.getUserId());
        List<Map> keyvalues = new ArrayList<>();
        criteria.put("status", status);
        if (status == 2) {
            Map<String, String> kv = new HashMap<>();
            kv.put("key", "spia.status = ?");
            kv.put("value", "spia.status in (?,3,4,5,6)");
            keyvalues.add(kv);

            Map<String, String> kv2 = new HashMap<>();
            kv2.put("key", "sppt.status = ?");
            kv2.put("value", "sppt.status in (?,3,4,5,6)");
            keyvalues.add(kv2);
        }
        if (!BaseHelpUtils.isNullOrEmpty(keyvalues) && keyvalues.size() > 0) {
            criteria.put("keyValues", keyvalues);
        }
        return true;
    }


    @Override
    public SearchForm generateSearchForm() {
        return new OnLoadApproveContractRunDrySearchForm();
    }

    @Override
    public DataSource getDataSource() {
        return DSOnLoadApproveContractRunDry.getInstance();
    }

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
        if (status == 2) {//如果是已审核，则隐藏审批按钮
            auditButton.hide();
        } else {
            auditButton.show();
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

