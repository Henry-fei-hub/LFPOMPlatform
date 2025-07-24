package com.pomplatform.client.projectcostlist.panel;

import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.pomplatform.client.projectcostlist.datasource.DSProjectCostList;
import com.pomplatform.client.projectcostlist.form.ProjectCostListSearchForm;
import com.pomplatform.client.projectcostlist.form.ProjectCostListViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;

public class ProjectCostListPanel extends AbstractSearchPanel {

    public static class Factory implements PanelFactory {

        private String id;

        @Override
        public Canvas create() {
            ProjectCostListPanel cm = new ProjectCostListPanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "ProjectCostList";
        }

    }

    @Override
    public void initComponents() {
        resultGrid.setShowRowNumbers(true);
        commonQuery();
        resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
            @Override
            public void onDoubleClick(DoubleClickEvent event) {
                showDetail();
            }
        });
//        IButton viewButton = new IButton("查看详细");
//        viewButton.addClickHandler(new ClickHandler() {
//            @Override
//            public void onClick(ClickEvent event) {
//                showDetail();
//            }
//        });
//        controlLayout.addMember(viewButton);
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
                detail.setTitle("项目成本");
                detail.setWidth100();
                detail.setHeight100();
                ProjectCostListViewer detailForm = new ProjectCostListViewer();
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
        return new ProjectCostListSearchForm();
    }

    @Override
    public DataSource getDataSource() {
        return DSProjectCostList.getInstance();
    }

    @Override
    public int getSearchFormHeight() {
        return 63;
    }

}
