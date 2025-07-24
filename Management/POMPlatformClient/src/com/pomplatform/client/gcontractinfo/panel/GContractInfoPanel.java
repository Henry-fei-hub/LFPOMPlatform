package com.pomplatform.client.gcontractinfo.panel;

import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.gcontractinfo.datasource.DSGContractInfo;
import com.pomplatform.client.gcontractinfo.form.GContractInfoSearchForm;
import com.pomplatform.client.gcontractinfo.form.GContractInfoViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.managementteamproject.panel.MManagementTeamProjectPanel;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class GContractInfoPanel extends AbstractSearchPanel {

    public static class Factory implements PanelFactory {

        private String id;

        @Override
        public Canvas create() {
            GContractInfoPanel cm = new GContractInfoPanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "GContractInfo";
        }

    }

    @Override
    public void initComponents() {
        commonQuery();
        resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
            @Override
            public void onDoubleClick(DoubleClickEvent event) {
                ListGridRecord[] selected = resultGrid.getSelectedRecords();
                String contractCode = selected[0].getAttribute("contractCode");
                PopupWindow pw = new PopupWindow("项目");
                MManagementTeamProjectPanel panel = new MManagementTeamProjectPanel();
                panel.setContractCode(contractCode);
                pw.addItem(panel.getViewPanel());
                pw.setWidth100();
                pw.setHeight100();
                pw.centerInPage();
                pw.show();
                panel.commonQuery();
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
                detail.setTitle("主合同");
                detail.setWidth100();
                detail.setHeight100();
                GContractInfoViewer detailForm = new GContractInfoViewer();
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
        return new GContractInfoSearchForm();
    }

    @Override
    public DataSource getDataSource() {
        return DSGContractInfo.getInstance();
    }

    @Override
    public int getSearchFormHeight() {
        return 63;
    }

}
