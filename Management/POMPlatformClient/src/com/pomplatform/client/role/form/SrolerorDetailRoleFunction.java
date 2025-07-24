package com.pomplatform.client.role.form;

import java.util.*;
import com.delicacy.client.MapUtils;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.smartgwt.client.data.Criteria;
import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.widgets.TransferImgButton;
import java.util.logging.Logger;
import com.pomplatform.client.role.datasource.DSRoleFunction;
import com.pomplatform.client.role.datasource.DSSfunctionffor;

public class SrolerorDetailRoleFunction extends AbstractWizadPage {

    private static final Logger __logger = Logger.getLogger("");
    private final DelicacyListGrid grid = new DelicacyListGrid(true);
    private final DelicacyListGrid SourceGrid = new DelicacyListGrid();
    private final IButton searchButton = new IButton("查询");
    private final SfunctionfforSearchForm __searchForm = new SfunctionfforSearchForm();

    public SrolerorDetailRoleFunction() {

        VLayout SearchSourceLayout = new VLayout();
        SearchSourceLayout.setWidth("50%");
        SearchSourceLayout.setHeight100();
        SearchSourceLayout.setLayoutTopMargin(10);
        SearchSourceLayout.setLayoutRightMargin(5);
        SearchSourceLayout.setMembersMargin(10);
        SearchSourceLayout.setShowResizeBar(true);
        HLayout SearchLayout = new HLayout(5);
        SearchLayout.setWidth100();
        SearchLayout.setLayoutRightMargin(5);
        SearchSourceLayout.addMember(SearchLayout);
        SearchLayout.addMember(__searchForm);
        searchButton.setIcon("[SKIN]/actions/search.png");
        searchButton.setWidth(60);
        SearchLayout.addMember(searchButton);
        searchButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                Criteria condition = __searchForm.getValuesAsCriteria();
                reloadSource(SourceGrid, condition);
            }
        });
        HLayout SourceLayout = new HLayout(5);
        SourceLayout.setWidth100();
        SourceLayout.setHeight100();
        SearchSourceLayout.addMember(SourceLayout);
        SourceGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
        SourceGrid.setDataSource(DSSfunctionffor.getInstance());
        SourceLayout.addMember(SourceGrid);
        VLayout SourceControls = new VLayout();
        SourceControls.setHeight100();
        SourceControls.setWidth(60);
        SourceControls.setLayoutTopMargin(30);
        SourceControls.setLayoutLeftMargin(5);
        SourceControls.setLayoutRightMargin(5);
        SourceControls.setMembersMargin(10);
        SourceLayout.addMember(SourceControls);
        TransferImgButton AddToButton = new TransferImgButton(TransferImgButton.RIGHT);
        SourceControls.addMember(AddToButton);
        AddToButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (!SourceGrid.anySelected()) {
                    return;
                }
                addSelectedDataToTarget(SourceGrid, grid);
            }
        });
        SourceGrid.addDoubleClickHandler(new DoubleClickHandler() {
            @Override
            public void onDoubleClick(DoubleClickEvent event) {
                if (!SourceGrid.anySelected()) {
                    return;
                }
                addSelectedDataToTarget(SourceGrid, grid);
            }
        });
        addMember(SearchSourceLayout);
        HLayout roleFunctions = new HLayout();
        roleFunctions.setWidth("50%");
        roleFunctions.setHeight100();
        grid.setDataSource(DSRoleFunction.getInstance());
        grid.setAutoFitFieldWidths(false);
        roleFunctions.addMember(grid);
        VLayout roleFunctionsControls = new VLayout();
        roleFunctionsControls.setHeight100();
        roleFunctionsControls.setWidth(60);
        roleFunctionsControls.setLayoutTopMargin(30);
        roleFunctionsControls.setLayoutLeftMargin(5);
        roleFunctionsControls.setLayoutRightMargin(5);
        roleFunctionsControls.setMembersMargin(10);
        roleFunctions.addMember(roleFunctionsControls);
        addMember(roleFunctions);
//        IButton roleFunctionsNewButton = new IButton("新增");
//        roleFunctionsNewButton.setIcon("[SKIN]/actions/add.png");
//        roleFunctionsNewButton.addClickHandler(new ClickHandler() {
//            @Override
//            public void onClick(ClickEvent event) {
//                grid.startEditingNew();
//            }
//        });
        IButton roleFunctionsRemoveButton = new IButton("删除所有");
        roleFunctionsRemoveButton.setIcon("[SKIN]/actions/remove.png");
        roleFunctionsRemoveButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                grid.setData(new RecordList());
            }
        });
//        roleFunctionsControls.addMember(roleFunctionsNewButton);
        roleFunctionsControls.addMember(roleFunctionsRemoveButton);
    }

    @Override
    public void startEdit() {
        if (getPageMode() != PAGE_MODE_UPDATE) {
            return;
        }
        Map condition = new HashMap();
        condition.put("roleId", getRecord().getAttribute("roleId"));
        DBDataSource.callOperation("ST_RoleFunction", "find", condition, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                    grid.setData(dsResponse.getData());
                }
            }
        });
    }

    @Override
    public boolean checkData() {
        for (ListGridRecord r : grid.getRecords()) {
            __logger.info(MapUtils.convertRecordToMap(grid.getDataSource(), r).toString());
        }
        return true;
    }

    @Override
    public java.util.Map getValuesAsMap() {
        java.util.Map param = new java.util.HashMap();
        ListGridRecord[] rows = grid.getRecords();
        MapUtils.convertRecordToMap(grid.getDataSource(), rows, param, "detailRoleFunction");
        return param;
    }

    @Override
    public void reloadSourceData() {
        Criteria condition = __searchForm.getValuesAsCriteria();
        reloadSource(SourceGrid, condition);
    }

    private void reloadSource(final ListGrid source, Criteria condition) {
        if (condition == null) {
            condition = new Criteria();
        }
        FormItem item;
        Object val = null;
        searchButton.setIcon("loading38.gif");
        DBDataSource.callOperation("NQ_Sfunctionffor", "find", condition.getValues(), new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                searchButton.setIcon("[SKIN]/actions/search.png");
                if (dsResponse.getStatus() >= 0) {
                    source.setData(dsResponse.getData());
                }
            }
        });
    }

    private void addSelectedDataToTarget(ListGrid source, ListGrid target) {
        ListGridRecord[] selectedRecords = source.getSelectedRecords();
        RecordList originalList = target.getDataAsRecordList();
        FormItem item;
        Map<String, FormItem> items = getParentWindow().getFormItems();
        int originalLength = originalList.getLength();
        RecordList newList = new RecordList();
        if (originalLength > 0) {
            newList.addList(originalList.getRange(0, originalLength));
        }
        for (ListGridRecord selectedRecord : selectedRecords) {
            Map searchMap = new HashMap();
            item = items.get("roleId");
            if (item != null) {
                searchMap.put("roleId", item.getValue());
            }
            if (originalLength > 0) {
                int index = originalList.findIndex(searchMap);
                if (index != -1) {
                    continue;
                }
            }
            searchMap.put("functionId", selectedRecord.getAttribute("functionId"));
            newList.add(new Record(searchMap));
        }
        target.setData(newList);
    }

}
