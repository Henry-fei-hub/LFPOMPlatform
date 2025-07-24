package com.pomplatform.client.designer.panel;

import com.delicacy.client.MapUtils;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.pomplatform.client.designer.datasource.DSMprojectemployeepor;
import com.pomplatform.client.designer.form.MprojectemployeeporViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.smartgwt.client.data.*;
import com.smartgwt.client.util.ValueCallback;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import java.util.Map;

public class MprojectemployeeporPanel extends AbstractSearchPanel {

    public static class Factory implements PanelFactory {

        private String id;

        @Override
        public Canvas create() {
            MprojectemployeeporPanel cm = new MprojectemployeeporPanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "Mprojectemployeepor";
        }

    }

    public MprojectemployeeporPanel() {
        super();
    }

    @Override
    public void initComponents() {
        resultGrid.setShowRowNumbers(true);
        resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
            @Override
            public void onDoubleClick(DoubleClickEvent event) {
                showDetail();
            }
        });
        IButton viewButton = new IButton("刷新");
        viewButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                commonQuery();
            }
        });
        controlLayout.addMember(viewButton);
        
        IButton acceptButton = PermissionControl.createPermissionButton("接受邀请", ERPPermissionStatic.MY_INVITE_ACCEPT_BUTTON);
        acceptButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (!resultGrid.anySelected()) {
                    SC.say("请选择一条数据");
                    return;
                }
                ListGridRecord lgr = resultGrid.getSelectedRecord();
                DBDataSource.callOperation("EP_DesignerInvitationProcess",
                        MapUtils.convertRecordToMap(resultGrid.getDataSource(), lgr), new DSCallback() {
                    @Override
                    public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                        if (dsResponse.getStatus() >= 0) {
                            commonQuery();
                        } else {
                            Map errors = dsResponse.getErrors();
                            SC.say(errors.toString());
                        }
                    }

                });
            }
        });
        controlLayout.addMember(acceptButton);
        controlLayout.addMember(viewButton);
        
        IButton rejectButton = PermissionControl.createPermissionButton("谢绝邀请", ERPPermissionStatic.MY_INVITE_REFUSE_BUTTON);
        rejectButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (!resultGrid.anySelected()) {
                    SC.say("请选择一条数据");
                    return;
                }
                ListGridRecord lgr = resultGrid.getSelectedRecord();
                final Map params = MapUtils.convertRecordToMap(resultGrid.getDataSource(), lgr);
                SC.askforValue("拒绝理由", "为啥回绝我，给个理由先", new ValueCallback() {
                    @Override
                    public void execute(String value) {
                        params.put("workContent", value);
                        DBDataSource.callOperation("EP_DesignerRejectionProcess", params, new DSCallback() {
                            @Override
                            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                                if (dsResponse.getStatus() >= 0) {
                                    commonQuery();
                                } else {
                                    Map errors = dsResponse.getErrors();
                                    SC.say(errors.toString());
                                }
                            }

                        });
                    }

                });

            }
        });
        controlLayout.addMember(rejectButton);
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
                GenericViewWindow detail = new GenericViewWindow();
                detail.setTitle("设计师-我的邀请");
                detail.setWidth100();
                detail.setHeight100();
                MprojectemployeeporViewer detailForm = new MprojectemployeeporViewer();
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
    public SearchForm generateSearchForm() {
        return null;
    }

    @Override
    public DataSource getDataSource() {
        return DSMprojectemployeepor.getInstance();
    }

    @Override
    public boolean checkSearchCriteria(Map criteria) {
        criteria.put("employeeId", ClientUtil.getUserId());
        criteria.put("status", 0);
        return true;
    }

    @Override
    public boolean showPagination() {
        return false;
    }

}
