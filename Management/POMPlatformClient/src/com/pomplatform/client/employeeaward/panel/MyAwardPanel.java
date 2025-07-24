package com.pomplatform.client.employeeaward.panel;

import com.delicacy.client.PaginationPanel;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.employeeaward.datasource.DSMemployeeAward;
import com.pomplatform.client.employeeaward.form.MemployeeAwardViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.common.CommonFormat;
import com.pomplatform.client.employeeaward.form.MyAwardSearchForm;
import com.smartgwt.client.data.*;
import com.smartgwt.client.util.Browser;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import java.util.Map;

public class MyAwardPanel extends AbstractSearchPanel {
    private DynamicForm __infoForm ;
    private TextItem totalItem ;

    public static class Factory implements PanelFactory {

        private String id;

        @Override
        public Canvas create() {
            MyAwardPanel cm = new MyAwardPanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "MemployeeAward";
        }

    }

    @Override
    public void initComponents() {
        commonQuery();
        resultGrid.setShowRowNumbers(true);
        resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
            @Override
            public void onDoubleClick(DoubleClickEvent event) {
                //showDetail();//暂时不开放，等奖金结算完的时候再说
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
                detail.setTitle("职员奖金");
                detail.setWidth100();
                detail.setHeight100();
                MemployeeAwardViewer detailForm = new MemployeeAwardViewer();
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
        return 63;
    }

    @Override
    public boolean checkSearchCriteria(Map criteria) {
        criteria.put("employeeId", ClientUtil.getEmployeeId());
        ClientUtil.departmentParameterProcess(criteria);
        return true;
    }

    @Override
    public SearchForm generateSearchForm() {
        return new MyAwardSearchForm();
    }

    @Override
    public DataSource getDataSource() {
        return DSMemployeeAward.getInstance();
    }
    
}
