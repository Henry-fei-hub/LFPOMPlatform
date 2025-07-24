package com.pomplatform.client.myinvite.panel;

import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.designer.panel.DesignerProjectPanel;
import com.pomplatform.client.myinvite.datasource.DSMprojectTeamdor;
import com.pomplatform.client.myinvite.form.MprojectTeamViewer;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import java.util.Map;

public class MprojectTeamPanel extends AbstractSearchPanel {

    private int projectId = 0;

    /**
     * @return the projectId
     */
    public int getProjectId() {
        return projectId;
    }

    /**
     * @param projectId the projectId to set
     */
    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public static class Factory implements PanelFactory {

        private String id;

        @Override
        public Canvas create() {
            MprojectTeamPanel cm = new MprojectTeamPanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "Mprojectemployeeppedor";
        }

    }

    @Override
    public boolean checkSearchCriteria(Map criteria) {
        criteria.put("projectId", getProjectId());
        return true;
    }

    @Override
    public void initComponents() {
        resultGrid.setShowRowNumbers(true);
        resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
            @Override
            public void onDoubleClick(DoubleClickEvent event) {
                ListGridRecord[] selected = resultGrid.getSelectedRecords();
                String employeeId = selected[0].getAttribute("employeeId");
                String employeeName = KeyValueManager.getValueMap("employees").get(employeeId);
                PopupWindow pw = new PopupWindow();
                DesignerProjectPanel myselfProject = new DesignerProjectPanel();
                myselfProject.setEmployeeId(ClientUtil.checkAndGetIntValue(employeeId));
                pw.addItem(myselfProject.getViewPanel());
                pw.setTitle(employeeName+"设计师目前参与的项目");
                pw.setWidth100();
                pw.setHeight100();
                pw.centerInPage();
                pw.show();
                myselfProject.commonQuery();
            }
        });
        IButton operation1Button = new IButton("查看详情");
        controlLayout.addMember(operation1Button);
//        operation1Button.setIcon("[SKIN]/actions/view.png");
        operation1Button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                showDetail();
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
                GenericViewWindow detail = new GenericViewWindow();
                detail.setTitle("设计师信息");
                detail.setWidth100();
                detail.setHeight100();
                MprojectTeamViewer detailForm = new MprojectTeamViewer();
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
    public int getSearchFormHeight() {
        return 50;
    }

    @Override
    public SearchForm generateSearchForm() {
        return null;
    }

    @Override
    public DataSource getDataSource() {
        return DSMprojectTeamdor.getInstance();
    }

}
