package com.pomplatform.client.plateintegraltransferrecord.panel;

import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.plateintegraltransferrecord.datasource.DSSplateIntegralTransferRecord;
import com.pomplatform.client.plateintegraltransferrecord.form.SplateIntegralTransferRecordSearchForm;
import com.pomplatform.client.plateintegraltransferrecord.form.SplateIntegralTransferRecordViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.Map;

public class SplateIntegralTransferRecordPanel extends AbstractSearchPanel {

    public static class Factory implements PanelFactory {

        private String id;

        @Override
        public Canvas create() {
            SplateIntegralTransferRecordPanel cm = new SplateIntegralTransferRecordPanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "SplateIntegralTransferRecord";
        }

    }

    @Override
    public void initComponents() {
        IButton refreshButton = new IButton("刷新");
        refreshButton.hide();
        controlLayout.addMember(refreshButton);
        refreshButton.setIcon("[SKIN]/actions/refresh.png");
        refreshButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                commonQuery();
            }
        });

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
        IButton removeButton = new IButton("删除");
        removeButton.hide();
        controlLayout.addMember(removeButton);
        removeButton.setIcon("[SKIN]/actions/remove.png");
        removeButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (!resultGrid.anySelected()) {
                    SC.say("Please select a data to remove.");
                }
                final ListGridRecord selected = resultGrid.getSelectedRecord();
                DBDataSource.callOperation("ST_SplateIntegralTransferRecord", "delete", selected.toMap(), new DSCallback() {
                    @Override
                    public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                        if (dsResponse.getStatus() < 0) {
                            ClientUtil.displayErrorMessage(dsResponse);
                        } else {
                            int indexNum = resultGrid.getRowNum(selected);
                            resultGrid.removeData(selected);
                            resultGrid.selectSingleRecord(indexNum);
                        }
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
                detail.setTitle("部门积分转移");
                detail.setWidth100();
                detail.setHeight100();
                SplateIntegralTransferRecordViewer detailForm = new SplateIntegralTransferRecordViewer();
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
        return 66; 
    }
    
    @Override
    public boolean checkSearchCriteria(Map criteria) {
        //如果么有查看所有数据的权限，则只查看自己部门下的数据
//        if(!ClientUtil.checkIsHavePermission(ERPPermissionStatic.PLATE_INTEGRAL_TRANSFER_ALL_DATA)){
//            //获取当前操作人的业务部门id
//            int plateId = ClientUtil.getPlateId();
//            criteria.put("plateId", plateId);
//        }
        criteria.put("addtionalCondition", "order by plate_integral_transfer_record_id");
        return true;
    }

    @Override
    public SearchForm generateSearchForm() {
        return new SplateIntegralTransferRecordSearchForm();
    }

    @Override
    public DataSource getDataSource() {
        return DSSplateIntegralTransferRecord.getInstance();
    }

}
