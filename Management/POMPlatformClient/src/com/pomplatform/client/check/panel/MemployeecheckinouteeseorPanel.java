package com.pomplatform.client.check.panel;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.check.datasource.DSMemployeecheckinouteeseor;
import com.pomplatform.client.check.form.MemployeecheckinouteeseorSearchForm;
import com.pomplatform.client.check.form.MemployeecheckinouteeseorViewer;
import com.smartgwt.client.data.*;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.Map;

public class MemployeecheckinouteeseorPanel extends AbstractSearchPanel {

    public static class Factory implements PanelFactory {

        private String id;

        @Override
        public Canvas create() {
            MemployeecheckinouteeseorPanel cm = new MemployeecheckinouteeseorPanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "Memployeecheckinouteeseor";
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
        IButton viewButton = new IButton("查看详细");
        viewButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                showDetail();
            }
        });
        controlLayout.addMember(viewButton);
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
                detail.setTitle("考勤数据");
                detail.setWidth100();
                detail.setHeight100();
                MemployeecheckinouteeseorViewer detailForm = new MemployeecheckinouteeseorViewer();
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
        //数据权限控制  查看当前用户的数据  < 查看当前板块 < 查看所有
        if(!ClientUtil.checkIsHavePermission(ERPPermissionStatic.CHECK_ALL_SHOW_DATA)){
            if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.CHECK_PLATE_SHOW_DATA)){//只能看自己板块的  （板块管理员查看）
                int plateId = ClientUtil.getPlateId();
                criteria.put("plateId", plateId);
            }else{ 
                if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.CHECK_ONLY_MINE_SHOW_DATA)){
                    int employeeId = ClientUtil.getEmployeeId();
                    criteria.put("employeeId", employeeId);
                }else{
                    criteria.put("employeeId", -1);
                }
            }
        }
        return true; 
    }
    
    @Override
    public SearchForm generateSearchForm() {
        return new MemployeecheckinouteeseorSearchForm();
    }

    @Override
    public DataSource getDataSource() {
        return DSMemployeecheckinouteeseor.getInstance();
    }

    @Override
    public int getSearchFormHeight() {
        return 63;
    }

}
