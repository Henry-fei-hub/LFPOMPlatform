package com.pomplatform.client.employee.panel;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractSearchTree;
import com.pomplatform.client.employee.datasource.DSDictionartManagenment;
import com.pomplatform.client.employee.form.DictionarymanagermentSearchForm;
import com.smartgwt.client.data.*;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.TreeNode;

import java.util.Map;

public class DictionaryManagementPanel extends AbstractSearchTree {

    public static class Factory implements PanelFactory {

        private String id;

        @Override
        public Canvas create() {
            DictionaryManagementPanel cm = new DictionaryManagementPanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "dictionaryManagement";
        }

    }



    @Override
    public void fetchDataCallback(DSResponse response, Object rawData) {
        int len = response.getData().length;
        TreeNode[] nodes = new TreeNode[len];
        for (int i = 0; i < len; i++) {
            nodes[i] = new TreeNode();
            DBDataSource.copyRecord(response.getData()[i], nodes[i]);
        }
        Tree functionTree = new Tree();
        functionTree.setModelType(TreeModelType.PARENT);
        functionTree.setRootValue(0);
        functionTree.setIdField("dictionaryId");
        functionTree.setParentIdField("parentId");
        functionTree.setData(nodes);
        resultGrid.setData(functionTree);
        resultGrid.selectSingleRecord(0);
        TreeNode selectedNode = resultGrid.getSelectedRecord();
        resultGrid.openFolder(selectedNode);
    }

    @Override
    public SearchForm generateSearchForm() {
        return new DictionarymanagermentSearchForm();
    }

    @Override
    public DataSource getDataSource() {

//        return null;
       return DSDictionartManagenment.getInstance();
    }

    @Override
    public boolean checkSearchCriteria(Map criteria) {
        String dicTypeName = BaseHelpUtils.getString(criteria.get("dicTypeId"));
        SC.debugger();
        if (null != dicTypeName){
            criteria.put("dicTypeName" , dicTypeName);
        }
        criteria.put("optType", "initDate");
        return true;
    }

    @Override
    public void initComponents() {
        TreeGridField nameField = new TreeGridField("dicTypeId");
        nameField.setFrozen(true);
        nameField.setWidth(300);
        nameField.setHidden(true);
        TreeGridField functionIdField = new TreeGridField("dicTypeName");
        functionIdField.setCanEdit(false);
        functionIdField.setHidden(false);
        TreeGridField parentIdField = new TreeGridField("parentId");
        parentIdField.setHidden(true);
        TreeGridField codeField = new TreeGridField("dicTypeValueId");
        TreeGridField applicationIdField = new TreeGridField("dicTypeValue");
        resultGrid.setFields(functionIdField, parentIdField, nameField, codeField, applicationIdField);
        resultGrid.setShowFilterEditor(true);
        resultGrid.setFilterOnKeypress(true);
        IButton refreshBtn = new IButton("刷新");
        refreshBtn.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                commonQuery();
            }
        });
        controlLayout.addMember(refreshBtn);
        commonQuery();

        IButton createButton = new IButton("新增下拉值");
        controlLayout.addMember(createButton);
        createButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                TreeNode currentNode = resultGrid.getSelectedRecord();
                int dicTypeId = BaseHelpUtils.getIntValue(currentNode.getAttribute("dicTypeValueId"));
                if (currentNode == null || dicTypeId != 0) {
                    SC.say("请选择一个类别添加下拉值");
                    return;
                }
                DBDataSource.printRecord(currentNode);
                Tree tree = resultGrid.getData();
                TreeNode newNode = new TreeNode();
//                DBDataSource.copyRecordNotInclude(currentNode, newNode);
                newNode.setAttribute("dicTypeName",currentNode.getAttribute("dicTypeName"));
                newNode.setAttribute("dicTypeId",currentNode.getAttribute("dicTypeId"));
                currentNode.setAttribute("flags", 9999);
                newNode.setAttribute("flags", 9999);
                DBDataSource.printRecord(newNode);
                newNode = tree.add(newNode, currentNode);
                resultGrid.openFolder(currentNode);
                resultGrid.selectSingleRecord(newNode);
                resultGrid.startEditing(resultGrid.getRowNum(newNode));
            }
        });

        IButton deleteButton = new IButton("删除");
        controlLayout.addMember(deleteButton);
        deleteButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                TreeNode currentNode = resultGrid.getSelectedRecord();
                int flags = BaseHelpUtils.getIntValue(currentNode.getAttribute("flags"));
                if (currentNode == null) {
                    SC.say("请选择一条数据删除");
                    return;
                }
                TreeNode selectedRecord = resultGrid.getSelectedRecord();
                SC.debugger();
                Map params = selectedRecord.toMap();
                params.put("optType", "deleteData");
                params.put("flags",flags);
                DBDataSource.callOperation("EP_OnCommonProcess",params, new DSCallback() {
                    @Override
                    public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                        SC.debugger();
                        if (dsResponse.getStatus() < 0) {
                            SC.say("failure. " + dsResponse.getErrors().get("errorMsg"));
                        } else {
                            SC.say("删除成功，请刷新数据！");
                            resultGrid.redraw();
                        }
                    }

                });
            }
        });


        resultGrid.addEditCompleteHandler(new EditCompleteHandler() {
            @Override
            public void onEditComplete(EditCompleteEvent event) {
                TreeNode currentNode = resultGrid.getSelectedRecord();
                Record record = resultGrid.getRecord(event.getRowNum());
                Map params = record.toMap();
                SC.debugger();
                params.put("optType","saveAndUpdate");
                final int rowNumModified = event.getRowNum();
                DBDataSource.callOperation("EP_OnCommonProcess",params, new DSCallback() {
                    @Override
                    public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                        SC.debugger();
                        if (dsResponse.getStatus() < 0) {
                            SC.say("保存失败！");
                        } else {
                            DBDataSource.copyRecord(dsResponse.getData()[0], resultGrid.getRecord(rowNumModified));
                            SC.say("保存成功！");
                            resultGrid.redraw();
                        }
                    }

                });
            }

        });
    }
}
