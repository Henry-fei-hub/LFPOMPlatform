package com.pomplatform.client.department.panel;

import com.delicacy.client.BasicPermissionStatic;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.ClientUtil;
import com.smartgwt.client.types.AutoFitWidthApproach;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.TreeNode;
import com.delicacy.client.ui.AbstractSearchTree;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.department.datasource.DSDepartmentRoleFuns;
import com.pomplatform.client.department.datasource.DSRoleFuns;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.Map;
import java.util.logging.Logger;

public class DepartmentRoleFunsPanel extends AbstractSearchTree {
private static final Logger __logger = Logger.getLogger("DepartmentRoleFunsPanel");
    public static class Factory implements PanelFactory {

        private String id;

        @Override
        public Canvas create() {
            DepartmentRoleFunsPanel cm = new DepartmentRoleFunsPanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "DSDepartmentRoleFuns";
        }

    }

    @Override
    public void initComponents() {
        //行数据是否可编辑
        resultGrid.setCanEdit(false);
        TreeGridField[] fields = new TreeGridField[8];
        int idx = 0;
        fields[idx] = new TreeGridField("departmentId");
        fields[idx].setHidden(true);
        idx++;
        fields[idx] = new TreeGridField("departmentName");
        fields[idx].setFrozen(false);
        fields[idx].setCanEdit(false);
        fields[idx].setWidth(300);
        idx++;
        fields[idx] = new TreeGridField("parentId");
        fields[idx].setHidden(true);
        idx++;
        resultGrid.setFields(fields);
        resultGrid.setShowFilterEditor(true);
        resultGrid.setFilterOnKeypress(true);
        IButton refreshButton = new IButton("刷新");
        refreshButton.setIcon("[SKIN]/actions/refresh.png");
        controlLayout.addMember(refreshButton);
        refreshButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                commonQuery();
            }
        });

        commonQuery();
    }

    @Override
    public void fetchDataCallback(DSResponse response, Object rawData) {
        int len = response.getData().length;
        TreeNode[] nodes = new TreeNode[len];
        for (int i = 0; i < len; i++) {
            nodes[i] = new TreeNode();
            //设置图标
            String parentId = response.getData()[i].getAttribute("departmentId");
            if (!"".equals(parentId) && Integer.parseInt(parentId) >= 1000000) {
                nodes[i].setIcon("/images/photos/funs_view.png");
            }
            DBDataSource.copyRecord(response.getData()[i], nodes[i]);
        }
        Tree tree = new Tree();
        tree.setModelType(TreeModelType.PARENT);
        tree.setRootValue("0");
        tree.setIdField("departmentId");
        tree.setParentIdField("parentId");
        tree.setData(nodes);
        resultGrid.setData(tree);
        resultGrid.selectSingleRecord(0);
        TreeNode selectedNode = resultGrid.getSelectedRecord();
        if (selectedNode != null) {
            resultGrid.openFolder(selectedNode);
        }
    }

    @Override
    public boolean checkSearchCriteria(Criteria criteria) {
        criteria.addCriteria("addtionalCondition", "order by department_id");
        return true;
    }

    @Override
    public SearchForm generateSearchForm() {
        return null;
    }

    @Override
    public DataSource getDataSource() {
        return DSDepartmentRoleFuns.getInstance();
    }
    @Override
	public void generateTreeGrid() {
    	resultGrid = new TreeGrid();
        resultGrid.setDataSource(getDataSource());
        resultGrid.setSaveLocally(true);
        resultGrid.setAutoFetchData(false);
        resultGrid.setAutoFitWidthApproach(AutoFitWidthApproach.BOTH);
        resultGrid.setAutoFitFieldWidths(true);
        resultGrid.setShowHeaderContextMenu(false);
        resultGrid.setShowHeaderMenuButton(false);
        resultGrid.setCanEdit(true);
        resultGrid.setCanReorderRecords(false);
        resultGrid.setCanAcceptDroppedRecords(false);
        resultGrid.setCanReparentNodes(false);
	}
}
