package com.pomplatform.client.treedesignconsideration.panel;

import java.util.Date;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.PopupWindow;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.ClientUtil;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.TreeNode;
import com.delicacy.client.ui.AbstractSearchTree;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.treedesignconsideration.datasource.DSTreeDesignConsideration;
import com.pomplatform.client.treedesignconsideration.form.TreeDesignConsiderationViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.Map;

public class TreeDesignConsiderationPanel extends AbstractSearchTree
{


	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			TreeDesignConsiderationPanel cm = new TreeDesignConsiderationPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "TreeDesignConsideration";
		}

	}

	@Override
	public void initComponents() {
		resultGrid.setCanEdit(true);
		TreeGridField[] fields = new TreeGridField[7];
		int idx = 0;
		fields[idx] = new TreeGridField("businessType");
		PickTreeItem businessTypePickTree = new PickTreeItem();
		businessTypePickTree.setCanSelectParentItems(true);
		businessTypePickTree.setValueField("treeId");
		businessTypePickTree.setValueTree(KeyValueManager.getTree("production_value_coefficient_type", ""));
		fields[idx].setEditorProperties(businessTypePickTree);
		idx ++;
		fields[idx] = new TreeGridField("projectType");
		PickTreeItem projectTypePickTree = new PickTreeItem();
		projectTypePickTree.setCanSelectParentItems(true);
		projectTypePickTree.setValueField("treeId");
		projectTypePickTree.setValueTree(KeyValueManager.getTree("system_dictionary_32", ""));
		fields[idx].setEditorProperties(projectTypePickTree);
		idx ++;
		fields[idx] = new TreeGridField("mainDesignAreaName");
		idx ++;
		fields[idx] = new TreeGridField("decorationStatus");
		PickTreeItem decorationStatusPickTree = new PickTreeItem();
		decorationStatusPickTree.setCanSelectParentItems(true);
		decorationStatusPickTree.setValueField("treeId");
		decorationStatusPickTree.setValueTree(KeyValueManager.getTree("system_dictionary_30", ""));
		fields[idx].setEditorProperties(decorationStatusPickTree);
		idx ++;
		fields[idx] = new TreeGridField("designArea");
		idx ++;
		fields[idx] = new TreeGridField("remark");
		idx ++;
		fields[idx] = new TreeGridField("splitPrice");
		idx ++;
		resultGrid.setFields(fields);
		resultGrid.setShowFilterEditor(true);
		resultGrid.setFilterOnKeypress(true);
		resultGrid.addDropCompleteHandler(new DropCompleteHandler() {
			@Override
			public void onDropComplete(DropCompleteEvent event) {
				Record[] rs = event.getTransferredRecords();
				DBDataSource.printRecord(rs[0]);
				for (Record r : rs) {
					DBDataSource.callOperation("ST_TreeDesignConsideration", "update", r.toMap(), new DSCallback() {
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
		refreshButton.setIcon("[SKIN]/actions/refresh.png");
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
					params.put("parentId", "");
				}
				final int rowNumModified = event.getRowNum();
				DBDataSource.callOperation("ST_TreeDesignConsideration", "saveOrUpdate", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() < 0) {
							ClientUtil.displayErrorMessage(dsResponse);
						}else {
							DBDataSource.copyRecord(dsResponse.getData()[0], resultGrid.getRecord(rowNumModified));
							resultGrid.redraw();
						}
					}
				});
			}
		});

		IButton newButton = new IButton("新建");
		controlLayout.addMember(newButton);
		newButton.setIcon("[SKIN]/actions/add.png");
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
		newChildButton.setIcon("[SKIN]/actions/add.png");
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
				DBDataSource.copyRecordNotInclude(currentNode, newNode, "designConsiderationId", "children", "isFolder");
				newNode.setAttribute("parentId", ClientUtil.checkAndGetIntValue(currentNode.getAttribute("designConsiderationId")));
				DBDataSource.printRecord(newNode);
				newNode = tree.add(newNode, currentNode);
				resultGrid.openFolder(currentNode);
				resultGrid.selectSingleRecord(newNode);
				resultGrid.startEditing(resultGrid.getRowNum(newNode));
			}
		});

		IButton removeButton = new IButton("删除");
		controlLayout.addMember(removeButton);
		removeButton.setIcon("[SKIN]/actions/remove.png");
		removeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("Please select a data to remove.");
				}
				final ListGridRecord selected = resultGrid.getSelectedRecord();
				DBDataSource.callOperation("ST_TreeDesignConsideration", "delete", selected.toMap(), new DSCallback() {
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
	public void fetchDataCallback(DSResponse response, Object rawData) {
		int len = response.getData().length;
		TreeNode[] nodes = new TreeNode[len];
		for (int i = 0; i < len; i++) {
			nodes[i] = new TreeNode();
			DBDataSource.copyRecord(response.getData()[i], nodes[i]);
		}
		Tree tree = new Tree();
		tree.setModelType(TreeModelType.PARENT);
		tree.setRootValue("");
		tree.setIdField("designConsiderationId");
		tree.setParentIdField("parentId");
		tree.setData(nodes);
		resultGrid.setData(tree);
		resultGrid.selectSingleRecord(0);
		TreeNode selectedNode = resultGrid.getSelectedRecord();
		if(selectedNode != null) resultGrid.openFolder(selectedNode);
	}

	@Override
	public boolean checkSearchCriteria(Criteria criteria) {
		criteria.addCriteria("addtionalCondition", "order by design_consideration_id");
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSTreeDesignConsideration.getInstance();
	}


}

