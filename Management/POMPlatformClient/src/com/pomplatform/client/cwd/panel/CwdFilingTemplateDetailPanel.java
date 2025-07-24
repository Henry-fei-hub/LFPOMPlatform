package com.pomplatform.client.cwd.panel;

import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractSearchTree;
import com.delicacy.client.ui.LayoutConstant;
import com.pomplatform.client.cwd.datasource.DSCwdFilingTemplateDetail;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DropCompleteEvent;
import com.smartgwt.client.widgets.events.DropCompleteHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.TreeNode;

public class CwdFilingTemplateDetailPanel extends AbstractSearchTree {

	private Integer cwdFilingTemplateId;
	
	
	private static final Logger __LOGGER = Logger.getLogger("");

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			CwdFilingTemplateDetailPanel cm = new CwdFilingTemplateDetailPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "CwdFilingTemplateDetail";
		}

	}

	@Override
	public void init() {
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		__needPagenation = false;
	}

	@Override
	public void initComponents() {
		resultGrid.setCanEdit(true);
		TreeGridField[] fields = new TreeGridField[6];
		int idx = 0;
		fields[idx] = new TreeGridField("fileName");
		fields[idx].setFrozen(true);
		fields[idx].setCanEdit(true);
		fields[idx].setWidth(300);
		idx++;
		fields[idx] = new TreeGridField("parentId");
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new TreeGridField("operatorId");
		fields[idx].setCanEdit(false);
		idx++;
		fields[idx] = new TreeGridField("createTime");
		fields[idx].setCanEdit(false);
		idx++;
		resultGrid.setFields(fields);
//		resultGrid.setShowFilterEditor(true);
//		resultGrid.setFilterOnKeypress(true);
		resultGrid.addDropCompleteHandler(new DropCompleteHandler() {
			@Override
			public void onDropComplete(DropCompleteEvent event) {
				Record[] rs = event.getTransferredRecords();
				DBDataSource.printRecord(rs[0]);
				for (Record r : rs) {
					DBDataSource.callOperation("ST_CwdFilingTemplateDetail", "update", r.toMap(), new DSCallback() {
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
					params.put("parentId", "0");
				}
				final int rowNumModified = event.getRowNum();
				DBDataSource.callOperation("ST_CwdFilingTemplateDetail", "saveOrUpdate", params, new DSCallback() {
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
		newButton.setIcon("[SKIN]/actions/add.png");
		newButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Tree tree = resultGrid.getData();
				TreeNode node = new TreeNode();
				node.setIsFolder(true);
				node.setAttribute("cwdFilingTemplateId", getCwdFilingTemplateId());
				node.setAttribute("operatorId", ClientUtil.getEmployeeId());
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
				DBDataSource.copyRecordNotInclude(currentNode, newNode, "cwdFilingTemplateDetailId", "children",
						"isFolder");
				newNode.setAttribute("cwdFilingTemplateId", getCwdFilingTemplateId());
				newNode.setAttribute("operatorId", ClientUtil.getEmployeeId());
				newNode.setAttribute("parentId",
						ClientUtil.checkAndGetIntValue(currentNode.getAttribute("cwdFilingTemplateDetailId")));
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
				DBDataSource.callOperation("ST_CwdFilingTemplateDetail", "delete", selected.toMap(), new DSCallback() {
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
		tree.setIdField("cwdFilingTemplateDetailId");
		tree.setParentIdField("parentId");
		tree.setData(nodes);
		tree.openAll();
		resultGrid.setData(tree);
		resultGrid.selectSingleRecord(0);
		TreeNode selectedNode = resultGrid.getSelectedRecord();
		if (selectedNode != null)
			resultGrid.openFolder(selectedNode);
	}

	@Override
	public boolean checkSearchCriteria(Criteria criteria) {
		criteria.addCriteria("addtionalCondition", "order by cwd_filing_template_detail_id");
		criteria.addCriteria("cwdFilingTemplateId", getCwdFilingTemplateId());
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSCwdFilingTemplateDetail.getInstance();
	}

	public Integer getCwdFilingTemplateId() {
		return cwdFilingTemplateId;
	}

	public void setCwdFilingTemplateId(Integer cwdFilingTemplateId) {
		this.cwdFilingTemplateId = cwdFilingTemplateId;
	}

}
