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
import com.delicacy.client.ui.LoadingWindow;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.department.datasource.DSRoleFuns;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.Map;
import java.util.logging.Logger;

public class RoleFunsPanel extends AbstractSearchTree {
private static final Logger __logger = Logger.getLogger("RoleEmployeePanel");
    public static class Factory implements PanelFactory {

        private String id;

        @Override
        public Canvas create() {
            RoleFunsPanel cm = new RoleFunsPanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "DSRoleFuns";
        }

    }

    @Override
    public void initComponents() {
    	final LoadingWindow loading = new LoadingWindow();
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

        resultGrid.addEditCompleteHandler(new EditCompleteHandler() {
            @Override
            public void onEditComplete(EditCompleteEvent event) {
                Map params = resultGrid.getRecord(event.getRowNum()).toMap();
                Object parentId = params.get("parentId");
                if (parentId == null) {
                    params.put("parentId", "0");
                }
                final int rowNumModified = event.getRowNum();
                DBDataSource.callOperation("ST_DSRoleFuns", "saveOrUpdate", params, new DSCallback() {
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

        IButton newButton = PermissionControl.createPermissionButton("新建", BasicPermissionStatic.DEPRATMENT_ADD_BUTTON);
//        controlLayout.addMember(newButton);
        newButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                Tree tree = resultGrid.getData();
                TreeNode node = new TreeNode();
                node.setIsFolder(true);
                tree.add(node, "/", 0);
                resultGrid.selectSingleRecord(0);
                resultGrid.startEditing(0);
            }
        });

        IButton newChildButton = PermissionControl.createPermissionButton("新建子项", BasicPermissionStatic.DEPRATMENT_ADD_SON_BUTTON);
//        controlLayout.addMember(newChildButton);
        newChildButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                TreeNode currentNode = resultGrid.getSelectedRecord();
                if (currentNode == null) {
                    SC.say("Please select a item as parent.");
                    return;
                }
                DBDataSource.printRecord(currentNode);
                Tree tree = resultGrid.getData();
                TreeNode newNode = new TreeNode();
                DBDataSource.copyRecordNotInclude(currentNode, newNode, "departmentId", "children", "isFolder");
                newNode.setAttribute("parentId", ClientUtil.checkAndGetIntValue(currentNode.getAttribute("departmentId")));
                DBDataSource.printRecord(newNode);
                newNode = tree.add(newNode, currentNode);
                resultGrid.openFolder(currentNode);
                resultGrid.selectSingleRecord(newNode);
                resultGrid.startEditing(resultGrid.getRowNum(newNode));
            }
        });

        IButton removeButton = PermissionControl.createPermissionButton("删除", BasicPermissionStatic.DEPRATMENT_DELETE_BUTTON);
//        controlLayout.addMember(removeButton);
        removeButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (!resultGrid.anySelected()) {
                    SC.say("Please select a data to remove.");
                }
                final ListGridRecord selected = resultGrid.getSelectedRecord();
                DBDataSource.callOperation("ST_DSRoleFuns", "delete", selected.toMap(), new DSCallback() {
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
        loading.destroy();
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
        return DSRoleFuns.getInstance();
    }
    @Override
	public void generateTreeGrid() {
		// TODO Auto-generated method stub
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
