package com.pomplatform.client.operation.panel;

import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.PopupWindow;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.operation.datasource.DSProjectManager;
import com.pomplatform.client.operation.form.ProjectManagerSearchForm;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.common.SetProjectAppendIntegral;
import com.pomplatform.client.operation.form.ProjectManagerViewer;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.logging.Logger;

public class OperationManagerPanel extends AbstractSearchPanel {
    private final Logger __logger = Logger.getLogger("");
    public static class Factory implements PanelFactory {
        
        private String id;

        @Override
        public Canvas create() {
            OperationManagerPanel cm = new OperationManagerPanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "ProjectManager";
        }

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
        IButton operation1Button = new IButton("查看详情");
        controlLayout.addMember(operation1Button);
        operation1Button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                showDetail();
            }
        });

        IButton operation2Button = new IButton("追加积分");
        controlLayout.addMember(operation2Button);
        operation2Button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                GWT.runAsync(new RunAsyncCallback() {
                    @Override
                    public void onFailure(Throwable reason) {
                        SC.say("failure to download code");
                    }

                    @Override
                    public void onSuccess() {
                        if (!resultGrid.anySelected()) {
                            SC.say("请选择一条数据修改");
                            return;
                        }
                        ListGridRecord[] selected = resultGrid.getSelectedRecords();
                        int projectId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("projectId"));
                        double totalIntegral = ClientUtil.checkAndGetDoubleValue(selected[0].getAttribute("totalIntegral"));//项目总积分
                        double projectIntegral = ClientUtil.checkAndGetDoubleValue(selected[0].getAttribute("projectIntegral"));//项目积分
                        double reserveIntegral = ClientUtil.checkAndGetDoubleValue(selected[0].getAttribute("reserveIntegral"));//预留积分
                        double appendTotalIntegral = ClientUtil.checkAndGetDoubleValue(selected[0].getAttribute("appendTotalIntegral"));//追加总积分
                        int appendIntegral = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("appendIntegral"));//追加积分
                        String remark = selected[0].getAttribute("remark");//备注
                        String projectName = selected[0].getAttribute("projectName");//项目名称
                        PopupWindow popupWindow = new PopupWindow("项目审核");
                        popupWindow.setWidth("50%");
                        popupWindow.setHeight("60%");
                        popupWindow.centerInPage();
                        SetProjectAppendIntegral audit = new SetProjectAppendIntegral();
                        audit.addDataEditedHandler(new DataEditedHandler() {
                            @Override
                            public void onDataEdited(DataEditEvent event) {
                                commonQuery();
                            }
                        });
                        audit.initComponents(Boolean.FALSE,projectName, projectId, totalIntegral, projectIntegral, reserveIntegral, appendTotalIntegral, appendIntegral, remark);
                        popupWindow.addItem(audit);
                        audit.setParentWindow(popupWindow);
                        popupWindow.centerInPage();
                        popupWindow.show();
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
                if (!resultGrid.anySelected()) {
                    SC.say("请选择一条数据");
                    return;
                }
                GenericViewWindow detail = new GenericViewWindow();
                detail.setTitle("项目管理");
                detail.setWidth100();
                detail.setHeight100();
                ProjectManagerViewer detailForm = new ProjectManagerViewer();
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
        return new ProjectManagerSearchForm();
    }

    @Override
    public DataSource getDataSource() {
        return DSProjectManager.getInstance();
    }

}
