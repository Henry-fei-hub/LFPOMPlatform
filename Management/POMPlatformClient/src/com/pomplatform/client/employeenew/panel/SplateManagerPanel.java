package com.pomplatform.client.employeenew.panel;

import com.smartgwt.client.widgets.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.user.client.Cookies;
import com.pomplatform.client.data.RoleDefinition;
import com.pomplatform.client.designer.panel.DesignerProjectPanel;
import com.pomplatform.client.employeenew.datasource.DSSplateManager;
import com.pomplatform.client.employeenew.form.SemployeeNewSearchForm;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import java.util.Map;

public class SplateManagerPanel extends AbstractSearchPanel {

    public static class Factory implements PanelFactory {

        private String id;

        @Override
        public Canvas create() {
            SplateManagerPanel cm = new SplateManagerPanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "SemployeeNew";
        }

    }

    @Override
    public void initComponents() {
        commonQuery();
        resultGrid.setShowRowNumbers(true);
        resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
            @Override
            public void onDoubleClick(DoubleClickEvent event) {
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
                ListGridRecord[] selected = resultGrid.getSelectedRecords();
                String employeeId = selected[0].getAttribute("employeeId");
                String employeeName = KeyValueManager.getValueMap("employees").get(employeeId);
                PopupWindow pw = new PopupWindow();
                DesignerProjectPanel myselfProject = new DesignerProjectPanel();
                myselfProject.setEmployeeId(ClientUtil.checkAndGetIntValue(employeeId));
                pw.addItem(myselfProject.getViewPanel());
                pw.setTitle(employeeName + "参与的项目");
                pw.setWidth100();
                pw.setHeight100();
                pw.centerInPage();
                pw.show();
                myselfProject.commonQuery();
            }
        });
    }

    @Override
    public boolean checkSearchCriteria(Map criteria) {
        ClientUtil.departmentParameterProcess(criteria);
        //获取角色id
        int roleId = ClientUtil.checkAndGetIntValue(Cookies.getCookie(ClientUtil.OPRERATOR_ROLETYPEID_COOKIE));
        if (RoleDefinition.ROLE_MANAGEMENT_TEAM == roleId) {
        } else {
            criteria.put("plateId", Cookies.getCookie(ClientUtil.OPRERATOR_PLATEID_COOKIE));
        }
        return true;
    }

    @Override
    public SearchForm generateSearchForm() {
        //获取角色id
        int roleId = ClientUtil.checkAndGetIntValue(Cookies.getCookie(ClientUtil.OPRERATOR_ROLETYPEID_COOKIE));
        if (RoleDefinition.ROLE_MANAGEMENT_TEAM == roleId) {
            return new SemployeeNewSearchForm();
        } else {
            return null;
        }
    }

    @Override
    public int getSearchFormHeight() {
        //获取角色id
        int roleId = ClientUtil.checkAndGetIntValue(Cookies.getCookie(ClientUtil.OPRERATOR_ROLETYPEID_COOKIE));
        if (RoleDefinition.ROLE_MANAGEMENT_TEAM == roleId) {
            return 126;
        } else {
            return super.getSearchFormHeight();
        }
    }
    
    @Override
    public DataSource getDataSource() {
        return DSSplateManager.getInstance();
    }

}
