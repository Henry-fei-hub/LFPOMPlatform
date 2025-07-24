package com.pomplatform.client.receivables.panel;

import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.BasicPermissionStatic;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.app.datasource.DSDepartment;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractSearchTree;
import com.delicacy.client.ui.DelicacyListGrid;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DropCompleteEvent;
import com.smartgwt.client.widgets.events.DropCompleteHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.TreeNode;

public class CapitalDepartmentPanel extends AbstractSearchTree {
	private final Logger __logger = Logger.getLogger("");
    public static class Factory implements PanelFactory {

        private String id;

        @Override
        public Canvas create() {
            CapitalDepartmentPanel cm = new CapitalDepartmentPanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "Department";
        }

    }

    @Override
    public void initComponents() {
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
        fields[idx] = new TreeGridField("abbreviation");
        idx++;
        fields[idx] = new TreeGridField("managerId");
        ComboBoxItem managerIdcomboBox = new ComboBoxItem();
        fields[idx].setEditorProperties(managerIdcomboBox);
        resultGrid.setFields(fields);
        resultGrid.setShowFilterEditor(true);
        resultGrid.setFilterOnKeypress(true);
        resultGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
        resultGrid.setCascadeSelection(true);
        resultGrid.setCanEdit(false);

        IButton addButton = new IButton("添加");
        controlLayout.addMember(addButton);
        addButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
            	ListGridRecord [] selectRecords =  resultGrid.getSelectedRecords();
            	ListGridRecord [] existRecords = departmentGrid.getRecords();
            	for (ListGridRecord __selectRecord : selectRecords) {
            		boolean flag = true;
            		int departmentId = __selectRecord.getAttributeAsInt("departmentId");
            		for (ListGridRecord __existRecord : existRecords) {
            			int __departmentId = __existRecord.getAttributeAsInt("departmentId");
            			if(departmentId == __departmentId){
            				flag = false;
            				break;
            			}
    				}
            		if(flag){
            			departmentGrid.addData(__selectRecord);
            		}
				}
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
            DBDataSource.copyRecord(response.getData()[i], nodes[i]);
        }
        Tree tree = new Tree();
        tree.setModelType(TreeModelType.PARENT);
        tree.setRootValue("0");
        tree.setIdField("departmentId");
        tree.setParentIdField("parentId");
        tree.setData(nodes);
//        tree.openAll();
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
        return DSDepartment.getInstance();
    }

    public DelicacyListGrid departmentGrid;
    
}
