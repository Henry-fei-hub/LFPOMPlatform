package com.pomplatform.client.plateintegralsend.panel;

import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.ClientUtil;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.pomplatform.client.ERPPermissionStatic;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.plateintegralsend.datasource.DSPlateIntegralSend;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.tree.TreeGridField;
import java.util.Date;
import java.util.Map;

public class PlateIntegralSendPanel extends AbstractSearchPanel {

    public static class Factory implements PanelFactory {

        private String id;

        @Override
        public Canvas create() {
            PlateIntegralSendPanel cm = new PlateIntegralSendPanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "PlateIntegralSend";
        }

    }

    @Override
    public void initComponents() {
        if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.PLATE_SEND_UPDATE_BUTTON)){
            resultGrid.setCanEdit(true);
        }else{
            resultGrid.setCanEdit(false);
        }
        IButton refreshButton = new IButton("刷新");
        controlLayout.addMember(refreshButton);
//        refreshButton.setIcon("[SKIN]/actions/refresh.png");
        refreshButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                commonQuery();
            }
        });

        ListGridField[] fields = new ListGridField[5];
        int idx = 0;
        fields[idx] = new TreeGridField("plateId");
        idx++;
        fields[idx] = new TreeGridField("sendIntegral");
        idx++;
        fields[idx] = new TreeGridField("employeeId");
        //获取当前操作人的id
        int employeeId = ClientUtil.getEmployeeId();
        fields[idx].setCanEdit(false);
        fields[idx].setDefaultValue(employeeId);
        idx++;
        fields[idx] = new TreeGridField("sendDate");
        fields[idx].setDefaultValue(new Date());
        idx++;
        fields[idx] = new TreeGridField("remark");
        idx++;
        resultGrid.setFields(fields);
        resultGrid.setShowFilterEditor(true);
        resultGrid.setFilterOnKeypress(true);
        IButton newButton = PermissionControl.createPermissionButton("新建", ERPPermissionStatic.PLATE_SEND_SAVE_BUTTON);
        controlLayout.addMember(newButton);
//        newButton.setIcon("[SKIN]/actions/add.png");
        newButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                resultGrid.startEditingNew();
            }
        });

        resultGrid.addEditCompleteHandler(new EditCompleteHandler() {
            @Override
            public void onEditComplete(EditCompleteEvent event) {
                Map params = resultGrid.getRecord(event.getRowNum()).toMap();
                final int rowNumModified = event.getRowNum();
                DBDataSource.callOperation("ST_PlateIntegralSend", "saveOrUpdate", params, new DSCallback() {
                    @Override
                    public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                        if (dsResponse.getStatus() < 0) {
                            ClientUtil.displayErrorMessage(dsResponse);
                        } else {
                            DBDataSource.copyRecord(dsResponse.getData()[0], resultGrid.getRecord(rowNumModified));
                            resultGrid.redraw();
                        }
                    }
                });
            }
        });

        IButton removeButton = PermissionControl.createPermissionButton("删除", ERPPermissionStatic.PLATE_SEND_DELETE_BUTTON);
        controlLayout.addMember(removeButton);
//        removeButton.setIcon("[SKIN]/actions/remove.png");
        removeButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (!resultGrid.anySelected()) {
                    SC.say("Please select a data to remove.");
                }
                final ListGridRecord selected = resultGrid.getSelectedRecord();
                DBDataSource.callOperation("ST_PlateIntegralSend", "delete", selected.toMap(), new DSCallback() {
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
    
    @Override
    public boolean checkSearchCriteria(Map criteria) {
        //如果没有查看所有部门数据，则只检索自己部门下的数据
        if(!ClientUtil.checkIsHavePermission(ERPPermissionStatic.PLATE_SEND_CHECK_ALL_DATA)){
            int plateId = ClientUtil.getPlateId();
            criteria.put("plateId", plateId);
        }
        return true;
    }

    @Override
    public SearchForm generateSearchForm() {
        return null;
    }

    @Override
    public DataSource getDataSource() {
        return DSPlateIntegralSend.getInstance();
    }

}
