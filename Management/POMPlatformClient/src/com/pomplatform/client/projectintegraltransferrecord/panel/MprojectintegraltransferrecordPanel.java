package com.pomplatform.client.projectintegraltransferrecord.panel;

import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.pomplatform.client.projectintegraltransferrecord.datasource.DSMprojectintegraltransferrecord;
import com.pomplatform.client.projectintegraltransferrecord.form.MprojectintegraltransferrecordSearchForm;
import com.pomplatform.client.projectintegraltransferrecord.form.MprojectintegraltransferrecordViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.user.client.Cookies;
import com.pomplatform.client.data.RoleDefinition;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.Map;

public class MprojectintegraltransferrecordPanel extends AbstractSearchPanel {

    public static class Factory implements PanelFactory {

        private String id;

        @Override
        public Canvas create() {
            MprojectintegraltransferrecordPanel cm = new MprojectintegraltransferrecordPanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "Mprojectintegraltransferrecord";
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
        IButton operation1Button = new IButton("查看详情");
        operation1Button.hide();
        controlLayout.addMember(operation1Button);
        operation1Button.setIcon("[SKIN]/actions/view.png");
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
                detail.setTitle("项目积分转移");
                detail.setWidth100();
                detail.setHeight100();
                MprojectintegraltransferrecordViewer detailForm = new MprojectintegraltransferrecordViewer();
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
        int roleId = ClientUtil.checkAndGetIntValue(Cookies.getCookie(ClientUtil.OPRERATOR_ROLETYPEID_COOKIE));
        if(roleId != RoleDefinition.ROLE_MANAGEMENT_TEAM){
            return 63; 
        }else{
            return 126;
        }
    }
    
    @Override
    public boolean checkSearchCriteria(Map criteria) {
        //如果是高管角色，即可查看所有的记录，其它角色只能查看自己板块的
        int roleId = ClientUtil.checkAndGetIntValue(Cookies.getCookie(ClientUtil.OPRERATOR_ROLETYPEID_COOKIE));
        if(roleId != RoleDefinition.ROLE_MANAGEMENT_TEAM){
            //获取当前登录人的板块id
            int plateId = ClientUtil.checkAndGetIntValue(Cookies.getCookie(ClientUtil.OPRERATOR_PLATEID_COOKIE));
            criteria.put("plateId",plateId);
        }
        return super.checkSearchCriteria(criteria); 
    }
    
    @Override
    public SearchForm generateSearchForm() {
        return new MprojectintegraltransferrecordSearchForm();
    }

    @Override
    public DataSource getDataSource() {
        return DSMprojectintegraltransferrecord.getInstance();
    }

}
