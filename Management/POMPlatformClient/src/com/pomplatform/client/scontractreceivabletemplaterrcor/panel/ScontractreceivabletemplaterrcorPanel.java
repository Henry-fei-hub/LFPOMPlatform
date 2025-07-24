package com.pomplatform.client.scontractreceivabletemplaterrcor.panel;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchTree;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.scontractreceivabletemplaterrcor.datasource.DSScontractreceivabletemplaterrcor;
import com.pomplatform.client.scontractreceivabletemplaterrcor.form.NewScontractreceivabletemplaterrcorForm;
import com.pomplatform.client.scontractreceivabletemplaterrcor.form.ScontractreceivabletemplaterrcorViewer;
import com.smartgwt.client.data.AdvancedCriteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.util.BooleanCallback;
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

public class ScontractreceivabletemplaterrcorPanel extends AbstractSearchTree {

	private static final Logger __LOGGER = Logger.getLogger("");

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			ScontractreceivabletemplaterrcorPanel cm = new ScontractreceivabletemplaterrcorPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Scontractreceivabletemplaterrcor";
		}

	}

	@Override
	public void init() {
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
	}

	@Override
	public void initComponents() {
		resultGrid.setCanEdit(true);
		TreeGridField[] fields = new TreeGridField[4];
		int idx = 0;
		fields[idx] = new TreeGridField("receivableName");
		fields[idx].setFrozen(true);
		fields[idx].setCanEdit(true);
		fields[idx].setWidth(300);
		idx ++;
		fields[idx] = new TreeGridField("receivablePercentage", "收款百分比");
		fields[idx].setDecimalPad(2);
		fields[idx].setFormat("#,###,###,###,###,##0.00");
		idx ++;
		fields[idx] = new TreeGridField("remark");
		idx ++;
		fields[idx] = new TreeGridField("createTime");
		fields[idx].setCanEdit(false);
		resultGrid.setFields(fields);
		resultGrid.setCanDrop(false);
		resultGrid.setShowOpenIcons(false);
		resultGrid.setShowDropIcons(false);
		resultGrid.setShowSelectedStyle(false);
		resultGrid.setShowPartialSelection(true);
//		resultGrid.addDropCompleteHandler(new DropCompleteHandler() {
//			@Override
//			public void onDropComplete(DropCompleteEvent event) {
//				Record[] rs = event.getTransferredRecords();
//				DBDataSource.printRecord(rs[0]);
//				for (Record r : rs) {
//					DBDataSource.callOperation("ST_ContractReceivableTemplate", "update", r.toMap(), new DSCallback() {
//						@Override
//						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//							if (dsResponse.getStatus() < 0) {
//								ClientUtil.displayErrorMessage(dsResponse);
//							}
//						}
//					});
//				}
//			}
//		});

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
				final int rowNumModified = event.getRowNum();
				Map params = resultGrid.getRecord(event.getRowNum()).toMap();
				params.put("employeeId", ClientUtil.getUserId());
				Object parentId = params.get("parentId");
				if (BaseHelpUtils.getIntValue(parentId)<=0) {
					params.put("parentId", "0");
					DBDataSource.callOperation("ST_ContractReceivableTemplate", "saveOrUpdate", params, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if (dsResponse.getStatus() < 0) {
								ClientUtil.displayErrorMessage(dsResponse);
								commonQuery();
							}else {
								DBDataSource.copyRecord(dsResponse.getData()[0], resultGrid.getRecord(rowNumModified));
								resultGrid.redraw();
							}
						}
					});
				}else {
					//获取合同数据
					params.put("opt_type", "saveOrUpdateTemplate");
					DBDataSource.callOperation("EP_CustomReceivableTemplateProcess", params, new DSCallback() {
						
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if (dsResponse.getStatus() >= 0) {
								DBDataSource.copyRecord(dsResponse.getData()[0], resultGrid.getRecord(rowNumModified));
								resultGrid.redraw();
							}else{
								ClientUtil.displayErrorMessage(dsResponse);
								commonQuery();
							}
							
						}
					});
				}
			}
		});

		IButton newButton = new IButton("新增模板");
		controlLayout.addMember(newButton);
		newButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Tree tree = resultGrid.getData();
				TreeNode node = new TreeNode();
				
				node.setIsFolder(true);
				node.setAttribute("receivableName","新模板" );
				tree.add(node, "/", 0);
//				resultGrid.selectSingleRecord(0);
//				resultGrid.startEditing(0);
				
				Map params = node.toMap();
				params.put("employeeId", ClientUtil.getUserId());
				Object parentId = params.get("parentId");
				params.put("parentId", "0");
				DBDataSource.callOperation("ST_ContractReceivableTemplate", "save", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() < 0) {
							ClientUtil.displayErrorMessage(dsResponse);
							commonQuery();
						}else {
							resultGrid.redraw();
						}
					}
				});
			}
		});

		IButton newAChildButton = new IButton("新增同级");
//		controlLayout.addMember(newAChildButton);
		newAChildButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				TreeNode currentNodea = resultGrid.getSelectedRecord();
				if (currentNodea == null) {
					SC.say("Please select a item as parent.");
					return;
				}
				if(currentNodea.getAttributeAsInt("parentId") == 0){
					return ;
				}
				AdvancedCriteria ac = new AdvancedCriteria();
				ac.addCriteria("contractReceivableTemplateId", currentNodea.getAttribute("parentId"));
				int num = resultGrid.findIndex(ac);
				TreeNode currentNode =resultGrid.getRecord(num) ;
				
				
				DBDataSource.printRecord(currentNode);
				Tree tree = resultGrid.getData();
				TreeNode newNode = new TreeNode();
				DBDataSource.copyRecordNotInclude(currentNode, newNode, "contractReceivableTemplateId", "children", "isFolder");
				newNode.setAttribute("parentId", ClientUtil.checkAndGetIntValue(currentNode.getAttribute("parentId")));
				DBDataSource.printRecord(newNode);
				newNode = tree.add(newNode, currentNode);
				resultGrid.openFolder(currentNode);
				resultGrid.selectSingleRecord(newNode);
				resultGrid.startEditing(resultGrid.getRowNum(newNode));
			}
		});
		
		
		
		IButton newChildButton = new IButton("新增子阶段");
		controlLayout.addMember(newChildButton);
		newChildButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				TreeNode currentNode = resultGrid.getSelectedRecord();
				if (currentNode == null) {
					SC.say("Please select a item as parent.");
					return;
				}
				int parentId = BaseHelpUtils.getIntValue(currentNode.getAttribute("parentId"));
				int contractReceivableTemplateId = BaseHelpUtils.getIntValue(currentNode.getAttribute("contractReceivableTemplateId"));
				if(parentId>0) {
					SC.say("请勿选择子阶段进行新增");
					return;
				}
				
				DBDataSource.printRecord(currentNode);
				Tree tree = resultGrid.getData();
				TreeNode newNode = new TreeNode();
				DBDataSource.copyRecordNotInclude(currentNode, newNode, "contractReceivableTemplateId", "children", "isFolder");
				newNode.setAttribute("parentId", contractReceivableTemplateId);
				DBDataSource.printRecord(newNode);
				newNode = tree.add(newNode, currentNode);
				resultGrid.openFolder(currentNode);
				resultGrid.selectSingleRecord(newNode);
				resultGrid.startEditing(resultGrid.getRowNum(newNode));
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
				SC.ask("确定删除?", new BooleanCallback() {
					
					@Override
					public void execute(Boolean value) {
						
						if(value) {
							// TODO Auto-generated method stub
							final ListGridRecord selected = resultGrid.getSelectedRecord();
							if(null == selected.getAttribute("contractReceivableTemplateId")){
								resultGrid.removeData(selected);
								return ;
							}
							DBDataSource.callOperation("ST_ContractReceivableTemplate", "delete", selected.toMap(), new DSCallback() {
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
						
						
					}
				});
				
				

			}
		});

		commonQuery();
	}

	public void showDetail() {
		GWT.runAsync(new RunAsyncCallback() {
			@Override
			public void onFailure(Throwable reason) {
				SC.say("failure to download code");
			}

			@Override
			public void onSuccess() {
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("Scontractreceivabletemplaterrcor");
				detail.setWidth100();
				detail.setHeight100();
				ScontractreceivabletemplaterrcorViewer detailForm = new ScontractreceivabletemplaterrcorViewer();
				detailForm.setParentSearchForm(searchForm);
				detailForm.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_TAB);
				detailForm.initComponents();
				detailForm.viewSelectedData(resultGrid);
				detail.setContent(detailForm);
				detail.centerInPage();
				detail.show();
			}
		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("addtionalCondition", "order by contract_receivable_template_id");
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
//		return new ScontractreceivabletemplaterrcorSearchForm();
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSScontractreceivabletemplaterrcor.getInstance();
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
		tree.setIdField("contractReceivableTemplateId");
		tree.setParentIdField("parentId");
		tree.setData(nodes);
		resultGrid.setData(tree);
		resultGrid.selectSingleRecord(0);
		TreeNode selectedNode = resultGrid.getSelectedRecord();
		if(selectedNode != null) resultGrid.openFolder(selectedNode);
		
	}

}
