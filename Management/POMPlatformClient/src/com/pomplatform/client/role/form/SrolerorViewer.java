package com.pomplatform.client.role.form;

import java.util.ArrayList;
import java.util.List;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.data.*;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.GroupColumn;
import com.delicacy.client.ui.GenericViewWindow;
import com.smartgwt.client.widgets.form.SearchForm;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.role.datasource.DSSroleror;
import com.pomplatform.client.role.datasource.DSRoleFunction;

public class SrolerorViewer extends AbstractDetailViewer {

    private final DelicacyListGrid roleFunctionsGrid = new DelicacyListGrid();
    private SearchForm __parentSearchForm;

    public SrolerorViewer() {
    }

    @Override
    public void initComponents() {
        super.initComponents();
        roleFunctionsGrid.setDataSource(DSRoleFunction.getInstance());
        roleFunctionsGrid.addDoubleClickHandler(new DoubleClickHandler() {
            @Override
            public void onDoubleClick(DoubleClickEvent event) {
                GenericViewWindow detail = new GenericViewWindow();
                detail.setTitle("功能信息");
                detail.setWidth(700);
                detail.setHeight(500);
                RoleFunctionViewer viewer = new RoleFunctionViewer();
                viewer.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_NORMAL);
                viewer.initComponents();
                viewer.viewSelectedData((ListGrid) event.getSource());
                detail.setContent(viewer);
                detail.centerInPage();
                detail.show();
            }
        });
    }

    @Override
    public int getHorizontalPercent() {
        return 0;
    }

    @Override
    public String getName() {
        return "角色信息";
    }

    @Override
    public int getGroupCount() {
        return 0;
    }

    @Override
    public List<GroupColumn> getGroupColumnNames() {
        List<GroupColumn> gcs = new ArrayList<GroupColumn>();
        return gcs;
    }

    @Override
    public void viewSelectedData(ListGrid grid) {
        super.viewSelectedData(grid);
        Record selected = grid.getSelectedRecord();
        Object val;
        java.util.Map condition = null;
        java.util.Map parentSearch = __parentSearchForm == null ? new java.util.HashMap() : __parentSearchForm.getValues();
        condition = new java.util.HashMap();
        condition.put("roleId", selected.getAttributeAsString("roleId"));
        DBDataSource.callOperation("ST_RoleFunction", "find", condition, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                    roleFunctionsGrid.setData(dsResponse.getData());
                }
            }
        });
    }

    @Override
    public DataSource getMainDataSource() {
        return DSSroleror.getInstance();
    }

    @Override
    public int getDetailCount() {
        return 1;
    }

    @Override
    public List<ListGrid> getDetailListGrids() {
        List<ListGrid> res = new ArrayList<ListGrid>();
        res.add(roleFunctionsGrid);
        return res;
    }

    @Override
    public List<String> getDetailNames() {
        List<String> res = new ArrayList<String>();
        res.add("功能信息");
        return res;
    }

    public SearchForm getParentSearchForm() {
        return this.__parentSearchForm;
    }

    public void setParentSearchForm(SearchForm value) {
        this.__parentSearchForm = value;
    }

}
