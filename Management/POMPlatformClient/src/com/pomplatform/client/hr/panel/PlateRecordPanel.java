package com.pomplatform.client.hr.panel;

import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractSearchTree;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.hr.datasource.DSPlateRecord;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.TextMatchStyle;
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

public class PlateRecordPanel extends AbstractSearchTree {
	private final Logger __logger = Logger.getLogger("");
    public static class Factory implements PanelFactory {

        private String id;

        @Override
        public Canvas create() {
            PlateRecordPanel cm = new PlateRecordPanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "PlateRecord";
        }

    }

    @Override
    public void initComponents() {
        TreeGridField[] fields = new TreeGridField[8];
        int idx = 0;
        fields[idx] = new TreeGridField("plateRecordId");
        fields[idx].setHidden(true);
        idx++;
        fields[idx] = new TreeGridField("plateId");
        fields[idx].setHidden(true);
        idx++;
        fields[idx] = new TreeGridField("plateName");
        fields[idx].setFrozen(true);
        fields[idx].setCanEdit(true);
        fields[idx].setWidth(300);
        idx++;
        fields[idx] = new TreeGridField("plateCode");
        idx++;
        fields[idx] = new TreeGridField("hrCode");
        idx++;
        fields[idx] = new TreeGridField("plateType");
        idx++;
        fields[idx] = new TreeGridField("plateManagerId");
        ComboBoxItem managerIdcomboBox = new ComboBoxItem();
        managerIdcomboBox.setTextMatchStyle(TextMatchStyle.SUBSTRING);
//        managerIdcomboBox.setValueMap(KeyValueManager.getValueMap("employees"));
        KeyValueManager.loadValueMap("employees",managerIdcomboBox);
        fields[idx].setEditorProperties(managerIdcomboBox);
        idx++;
        fields[idx] = new TreeGridField("parentId");
        fields[idx].setHidden(true);
        idx++;
        resultGrid.setFields(fields);
        resultGrid.setShowFilterEditor(true);
        resultGrid.setFilterOnKeypress(true);
        resultGrid.addDropCompleteHandler(new DropCompleteHandler() {
            @Override
            public void onDropComplete(DropCompleteEvent event) {
                Record[] rs = event.getTransferredRecords();
                DBDataSource.printRecord(rs[0]);
                for (Record r : rs) {
                    DBDataSource.callOperation("ST_PlateRecord", "update", r.toMap(), new DSCallback() {
                        @Override
                        public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                            if (dsResponse.getStatus() < 0) {
                                ClientUtil.displayErrorMessage(dsResponse);
                            }
                        }
                    });
                }
            }
        });

        IButton refreshButton = new IButton("刷新");
        controlLayout.addMember(refreshButton);
        refreshButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                commonQuery();
            }
        });

        resultGrid.addEditCompleteHandler(new EditCompleteHandler() {
            @SuppressWarnings({ "unchecked", "rawtypes" })
			@Override
            public void onEditComplete(EditCompleteEvent event) {
                Map params = resultGrid.getRecord(event.getRowNum()).toMap();
                Object parentId = params.get("parentId");
                if (parentId == null) {
                    params.put("parentId", "0");
                }
                final int rowNumModified = event.getRowNum();
                DBDataSource.callOperation("ST_PlateRecordCustom", "saveOrUpdate", params, new DSCallback() {
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

        IButton newButton = new IButton("新建");
        controlLayout.addMember(newButton);
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

        IButton newChildButton = new IButton("新建子项");
        controlLayout.addMember(newChildButton);
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
                DBDataSource.copyRecordNotInclude(currentNode, newNode, "plateRecordId", "children", "isFolder");
                newNode.setAttribute("parentId", ClientUtil.checkAndGetIntValue(currentNode.getAttribute("plateRecordId")));
                DBDataSource.printRecord(newNode);
                newNode = tree.add(newNode, currentNode);
                resultGrid.openFolder(currentNode);
                resultGrid.selectSingleRecord(newNode);
                resultGrid.startEditing(resultGrid.getRowNum(newNode));
            }
        });
        IButton removeButton = new IButton("删除");
        removeButton.hide();
        controlLayout.addMember(removeButton);
        removeButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (!resultGrid.anySelected()) {
                    SC.say("Please select a data to remove.");
                }
                final ListGridRecord selected = resultGrid.getSelectedRecord();
                //获取部门id，只有存在部门id才可做删除，否则刷新
                int plateRecordId = BaseHelpUtils.getIntValue(selected.getAttribute("plateRecordId"));
                if(plateRecordId > 0){
                	DBDataSource.callOperation("ST_PlateRecord", "delete", selected.toMap(), new DSCallback() {
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
                }else{
                	commonQuery();
                }
            }
        });
        
        IButton linkButton = new IButton("关联部门");
        controlLayout.addMember(linkButton);
        linkButton.addClickHandler(new ClickHandler() {
            @SuppressWarnings("static-access")
			@Override
            public void onClick(ClickEvent event) {
            	PopupWindow pw = new PopupWindow();
            	PlateLinkDepartmentPanel panel = new PlateLinkDepartmentPanel();
				pw.addItem(panel);
				panel.loadData();
				pw.setTitle("业务板块与部门关联");
				pw.setWidth100();
				pw.setHeight100();
				panel.setParentWindows(pw);
				pw.centerInPage();
				pw.show();
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
        tree.setIdField("plateRecordId");
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
        criteria.addCriteria("addtionalCondition", "order by plate_id");
        return true;
    }

    @Override
    public SearchForm generateSearchForm() {
        return null;
    }

    @Override
    public DataSource getDataSource() {
        return DSPlateRecord.getInstance();
    }

}
