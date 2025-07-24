package com.pomplatform.client.projectappendintegralrecordpor.panel;

import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.pomplatform.client.projectappendintegralrecordpor.datasource.DSSprojectappendintegralrecordpor;
import com.pomplatform.client.projectappendintegralrecordpor.form.SprojectappendintegralrecordporSearchForm;
import com.pomplatform.client.projectappendintegralrecordpor.form.SprojectappendintegralrecordporViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;

public class SprojectappendintegralrecordporPanel extends AbstractSearchPanel {

    public static class Factory implements PanelFactory {

        private String id;

        @Override
        public Canvas create() {
            SprojectappendintegralrecordporPanel cm = new SprojectappendintegralrecordporPanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "Sprojectappendintegralrecordpor";
        }

    }

    @Override
    public void initComponents() {
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
                detail.setTitle("项目追加积分记录");
                detail.setWidth100();
                detail.setHeight100();
                SprojectappendintegralrecordporViewer detailForm = new SprojectappendintegralrecordporViewer();
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
        return new SprojectappendintegralrecordporSearchForm();
    }

    @Override
    public DataSource getDataSource() {
        return DSSprojectappendintegralrecordpor.getInstance();
    }

}
