package com.pomplatform.client.department.panel;

import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.types.AutoFitWidthApproach;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.TreeNode;
import com.delicacy.client.ui.AbstractSearchTree;
import com.delicacy.client.ui.LoadingWindow;
import com.delicacy.client.PanelFactory;
import com.pomplatform.client.department.datasource.DSDepartmentRoleEmployee;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.logging.Logger;

public class DepartmentRoleEmployeePanel extends AbstractSearchTree {

    private static final Logger __logger = Logger.getLogger("DepartmentRoleEmployeePanel");

    public static class Factory implements PanelFactory {

        private String id;

        @Override
        public Canvas create() {
            DepartmentRoleEmployeePanel cm = new DepartmentRoleEmployeePanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "DSDepartmentRoleEmployee";
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
        fields[idx].setFrozen(true);
        fields[idx].setCanEdit(true);
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
    	final LoadingWindow loading = new LoadingWindow();
        int len = response.getData().length;
        TreeNode[] nodes = new TreeNode[len];
        for (int i = 0; i < len; i++) {
            nodes[i] = new TreeNode();
            //设置图标
            String parentId = response.getData()[i].getAttribute("departmentId");
            if (!"".equals(parentId) && Integer.parseInt(parentId) >= 100000) {
                nodes[i].setIcon("/images/photos/photo_view.png");
            }
//            __logger.info(parentId + "====" + response.getData()[i].getAttribute("departmentName"));
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
        loading.destroy();
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
        return DSDepartmentRoleEmployee.getInstance();
    }
    @Override
	public void generateTreeGrid() {
		// TODO Auto-generated method stub
     	final LoadingWindow loading = new LoadingWindow();
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
        loading.destroy();
	}
}
