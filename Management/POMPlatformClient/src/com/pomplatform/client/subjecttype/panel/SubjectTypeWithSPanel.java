package com.pomplatform.client.subjecttype.panel;

import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractSearchTree;
import com.delicacy.client.ui.LayoutConstant;
import com.pomplatform.client.subjecttype.datasource.DSSubjectTypeWithS;
import com.pomplatform.client.subjecttype.form.SubjectTypeDetailSubjectDepartment;
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
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.grid.events.SelectionUpdatedEvent;
import com.smartgwt.client.widgets.grid.events.SelectionUpdatedHandler;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.TreeNode;

public class SubjectTypeWithSPanel extends AbstractSearchTree
{


	private static final Logger __LOGGER = Logger.getLogger("");
	protected SubjectTypeDetailSubjectDepartment __detailSubjectDepartment;

	public SubjectTypeDetailSubjectDepartment getDetailSubjectDepartment() {
		return __detailSubjectDepartment;
	}

	public void setDetailSubjectDepartment(SubjectTypeDetailSubjectDepartment val){
		__detailSubjectDepartment = val;
	}

	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			SubjectTypeWithSPanel cm = new SubjectTypeWithSPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "SubjectTypeWithS";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		__detailSubjectDepartment = new SubjectTypeDetailSubjectDepartment();
		__detailCanvas.add(__detailSubjectDepartment);
		__needPagenation = false;
	}

	@Override
	public void initComponents() {
		resultGrid.setCanEdit(true);
		TreeGridField[] fields = new TreeGridField[4];
		int idx = 0;
		fields[idx] = new TreeGridField("subjectTypeId");
		fields[idx].setHidden(true);
		idx ++;
		fields[idx] = new TreeGridField("parentId");
		fields[idx].setHidden(true);
		idx ++;
		fields[idx] = new TreeGridField("subjectName");
		fields[idx].setFrozen(true);
		fields[idx].setCanEdit(true);
		fields[idx].setWidth(300);
		idx ++;
		fields[idx] = new TreeGridField("enabled");
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
					DBDataSource.callOperation("ST_SubjectTypeWithS", "update", r.toMap(), new DSCallback() {
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
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				Map params = resultGrid.getRecord(event.getRowNum()).toMap();
				Object parentId = params.get("parentId");
				if (parentId == null) {
					params.put("parentId", "0");
				}
				final int rowNumModified = event.getRowNum();
				DBDataSource.callOperation("ST_SubjectTypeWithS", "saveOrUpdate", params, new DSCallback() {
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
		newButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Tree tree = resultGrid.getData();
				TreeNode node = new TreeNode();
				node.setIsFolder(true);
				tree.add(node, "/", 0);
				resultGrid.selectSingleRecord(0);
				resultGrid.startEditing(0);
				__detailSubjectDepartment.deselectAllSource();
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
				DBDataSource.copyRecordNotInclude(currentNode, newNode, "subjectTypeId", "children", "isFolder");
				newNode.setAttribute("parentId", ClientUtil.checkAndGetIntValue(currentNode.getAttribute("subjectTypeId")));
				DBDataSource.printRecord(newNode);
				newNode = tree.add(newNode, currentNode);
				resultGrid.openFolder(currentNode);
				resultGrid.selectSingleRecord(newNode);
				resultGrid.startEditing(resultGrid.getRowNum(newNode));
				__detailSubjectDepartment.deselectAllSource();
			}
		});

		IButton removeButton = new IButton("删除");
		controlLayout.addMember(removeButton);
		removeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("Please select a data to remove.");
				}
				final ListGridRecord selected = resultGrid.getSelectedRecord();
				DBDataSource.callOperation("ST_SubjectTypeWithS", "delete", selected.toMap(), new DSCallback() {
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

//		resultGrid.addSelectionUpdatedHandler(new SelectionUpdatedHandler() {
//			@Override
//			public void onSelectionUpdated(SelectionUpdatedEvent event) {
//				ListGridRecord r = resultGrid.getSelectedRecord();
//				if(r == null) return;
//				if(__selectedSubjectType != null && !__detailSubjectDepartment.isTheValuesEmpty()) {
//					Map params = __selectedSubjectType.toMap();
//					params.putAll(__detailSubjectDepartment.getValuesAsMap());
//					DBDataSource.callOperation("ST_SubjectTypeWithS", "update", params, new DSCallback() {
//						@Override
//						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//							if (dsResponse.getStatus() < 0) ClientUtil.displayErrorMessage(dsResponse);
//						}
//					});
//					__selectedSubjectType = r;
//					__detailSubjectDepartment.setRecord(r);
//					__detailSubjectDepartment.reloadDetailTableData();
//				}
//				__selectedSubjectType = r;
//				__detailSubjectDepartment.setRecord(r);
//				__detailSubjectDepartment.reloadDetailTableData();
//			}
//		});
		
		resultGrid.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				ListGridRecord r = resultGrid.getSelectedRecord();
				if(r == null) return;
				__detailSubjectDepartment.setRecord(r);
				__detailSubjectDepartment.reloadDetailTableData();
			}
		});

		__detailSubjectDepartment.getSourceGrid().addSelectionUpdatedHandler(new SelectionUpdatedHandler() {
			@Override
			public void onSelectionUpdated(SelectionUpdatedEvent event) {
				ListGridRecord r = resultGrid.getSelectedRecord();
				if(r == null) return;
				if(r != null && !__detailSubjectDepartment.isTheValuesEmpty()) {
					Map params = r.toMap();
					params.putAll(__detailSubjectDepartment.getValuesAsMap());
					DBDataSource.callOperation("ST_SubjectTypeWithS", "update", params, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if (dsResponse.getStatus() < 0) ClientUtil.displayErrorMessage(dsResponse);
						}
					});
				}
			}
		});

//		__detailSubjectDepartment.getSourceGrid().addRecordClickHandler(new RecordClickHandler() {
//			@Override
//			public void onRecordClick(RecordClickEvent event) {
//				__LOGGER.info("----------------------------");
//				final ListGridRecord clickedRecord = event.getRecord();
//				ListGridRecord subjectTypeWithSRecord = resultGrid.getSelectedRecord();
//				clickedRecord.setAttribute("subjectTypeId", subjectTypeWithSRecord.getAttribute("subjectTypeId"));
//				if (event.getFieldNum() == 0) {
//					if (isInOriginalList(clickedRecord)) {
//						DBDataSource.callOperation("ST_SubjectDepartment", "delete", clickedRecord.toMap(), new DSCallback() {
//							@Override
//							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//								if (dsResponse.getStatus() < 0) ClientUtil.displayErrorMessage(dsResponse);
//								else DBDataSource.copyRecord(dsResponse.getData()[0], clickedRecord);
//							}
//						});
//					} else {
//						DBDataSource.callOperation("ST_SubjectDepartment", "save", clickedRecord.toMap(), new DSCallback() {
//							@Override
//							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//								if (dsResponse.getStatus() < 0) ClientUtil.displayErrorMessage(dsResponse);
//								else DBDataSource.copyRecord(dsResponse.getData()[0], clickedRecord);
//							}
//						});
//						__selectedSubjectDepartment = clickedRecord;
//					}
//				} else if (isInOriginalList(clickedRecord)) {
//					__selectedSubjectDepartment = clickedRecord;
//				}
//				__originalSelectedSubjectDepartments = __detailSubjectDepartment.getSourceGrid().getSelectedRecords();
//			}
//		});

		__detailSubjectDepartment.startEdit();
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
		tree.setIdField("subjectTypeId");
		tree.setParentIdField("parentId");
		tree.setData(nodes);
		resultGrid.setData(tree);
		resultGrid.selectSingleRecord(0);
		TreeNode selectedNode = resultGrid.getSelectedRecord();
		if(selectedNode != null) resultGrid.openFolder(selectedNode);
	}

	@Override
	public boolean checkSearchCriteria(Criteria criteria) {
		criteria.addCriteria("addtionalCondition", "order by subject_type_id");
		return true;
	}

	private ListGridRecord __selectedSubjectType;
	private ListGridRecord __selectedSubjectDepartment;
	private ListGridRecord[] __originalSelectedSubjectDepartments;

	private boolean isInOriginalList(ListGridRecord clicked) {
		if (__originalSelectedSubjectDepartments == null || __originalSelectedSubjectDepartments.length == 0) return false;
		for (ListGridRecord r : __originalSelectedSubjectDepartments) {
			if (Objects.equals(r.getAttributeAsInt("departmentId"), clicked.getAttributeAsInt("departmentId"))) return true;
		}
		return false;
	}


	@Override
	public SearchForm generateSearchForm() {
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSSubjectTypeWithS.getInstance();
	}


}

