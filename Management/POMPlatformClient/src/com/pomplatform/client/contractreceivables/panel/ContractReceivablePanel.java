package com.pomplatform.client.contractreceivables.panel;

import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.ClientUtil;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.TreeNode;
import com.delicacy.client.ui.AbstractSearchTree;
import com.delicacy.client.ui.PopupWindow;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.contractreceivablecipor.datasource.DSMcontractreceivablecipcor;
import com.pomplatform.client.contractreceivables.datasource.DSContractReceivable;
import com.pomplatform.client.minvocieapplydedaocor.panel.AddOrUpdateContactsPanel;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.widgets.form.SearchForm;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class ContractReceivablePanel extends AbstractSearchTree
{
	private static Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ContractReceivablePanel cm = new ContractReceivablePanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ContractReceivable";
		}

	}
	@Override
	public void initComponents() {
		resultGrid.setCanEdit(true);
		TreeGridField[] fields = new TreeGridField[13];
		int idx = 0;
		fields[idx] = new TreeGridField("receivableName");
		fields[idx].setFrozen(true);
		fields[idx].setCanSort(true);
		fields[idx].setCanEdit(true);
		fields[idx].setWidth(300);
		idx ++;
		fields[idx] = new TreeGridField("receivablePercentage");
		fields[idx].setCanEdit(true);
		idx ++;
		fields[idx] = new TreeGridField("receivableSumMoney");
		fields[idx].setCanEdit(false);
		idx ++;
		fields[idx] = new TreeGridField("signingMoneySum");
		fields[idx].setHidden(false);
		fields[idx].setCanEdit(false);
		idx ++;
		fields[idx] = new TreeGridField("remark");
		fields[idx].setCanEdit(true);
		idx ++;
		fields[idx] = new TreeGridField("createTime");
		fields[idx].setCanEdit(false);
		idx ++;
		fields[idx] = new TreeGridField("updateTime");
		fields[idx].setCanEdit(false);
		idx ++;
		fields[idx] = new TreeGridField("operator");
		fields[idx].setCanEdit(false);
		idx ++;
		fields[idx] = new TreeGridField("infoCode");
		fields[idx].setDefaultValue(infoCode);
		fields[idx].setHidden(true);
		idx ++;
		fields[idx] = new TreeGridField("projectCode");
		fields[idx].setDefaultValue(projectCode);
		fields[idx].setHidden(true);
		idx ++;
		fields[idx] = new TreeGridField("contractId");
		fields[idx].setDefaultValue(contractId);
		fields[idx].setHidden(true);
		idx ++;
		fields[idx] = new TreeGridField("contractCode");
		fields[idx].setHidden(true);
		fields[idx].setDefaultValue(contractCode);
		resultGrid.setFields(fields);
		resultGrid.setShowGridSummary(true);
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
//					//如果更改为父节点 则把比例和金额更新为0
//					int parentId = BaseHelpUtils.getIntValue(r.getAttribute("parentId"));
//					if(parentId==0) {
//						r.setAttribute("receivablePercentage", 0);
//						r.setAttribute("receivableSumMoney", 0);
//					}
//					DBDataSource.callOperation("ST_ContractReceivable", "update", r.toMap(), new DSCallback() {
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
//				commonQuery();
				resultGrid.redraw();
			}
		});

		resultGrid.addEditCompleteHandler(new EditCompleteHandler() {
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				SC.debugger();
				int rowNum = event.getRowNum();
				TreeNode selectedRecord = resultGrid.getRecord(rowNum);
				ListGridRecord[] records = resultGrid.getRecords();
				BigDecimal hundred = new BigDecimal(100);
				BigDecimal percent = BigDecimal.ZERO;
				BigDecimal receivableSumMoney = BigDecimal.ZERO;
				int contractReceivableId = BaseHelpUtils.getIntValue(selectedRecord.getAttribute("contractReceivableId"));
				BigDecimal signingMoneySum =BaseHelpUtils.getBigDecimalValue(selectedRecord.getAttribute("signingMoneySum"));//签约总金额
				if(records.length>0) {
					for (ListGridRecord record : records) {
						int id = BaseHelpUtils.getIntValue(record.getAttribute("contractReceivableId"));
						BigDecimal value = BaseHelpUtils.getBigDecimalValue(record.getAttribute("receivablePercentage"));
						BigDecimal value2 = BaseHelpUtils.getBigDecimalValue(record.getAttribute("receivableSumMoney"));
						if(value.compareTo(hundred)>0) {
							SC.say("提示","收款百分比大于100");
							selectedRecord.setAttribute("receivableSumMoney", 0);
							selectedRecord.setAttribute("receivablePercentage", 0);
							return ;
						}
						if(value.compareTo(BigDecimal.ZERO)<0) {
							SC.say("提示","收款百分比不能为负数");
							selectedRecord.setAttribute("receivableSumMoney", 0);
							selectedRecord.setAttribute("receivablePercentage", 0);
							return ;
						}
						
						percent =percent.add(value);
						if(contractReceivableId!=id) {
							receivableSumMoney =receivableSumMoney.add(value2);
						}
					}
				}
				
				if(percent.compareTo(hundred)>0) {
					SC.say("提示","收款百分比大于100");
					selectedRecord.setAttribute("receivableSumMoney", 0);
					selectedRecord.setAttribute("receivablePercentage", 0);
					return ;
				}else if(percent.compareTo(hundred)==0) {
					BigDecimal value = signingMoneySum.subtract(receivableSumMoney);
					if(value.compareTo(BigDecimal.ZERO)>0) {
						selectedRecord.setAttribute("receivableSumMoney", value);
					}
				}else if(percent.compareTo(hundred)<0&&percent.compareTo(BigDecimal.ZERO)>0){
					BigDecimal receivablePercentage = BaseHelpUtils.getBigDecimalValue(selectedRecord.getAttribute("receivablePercentage"));
					BigDecimal value = signingMoneySum.multiply(receivablePercentage).divide(hundred,2,BigDecimal.ROUND_HALF_DOWN);
					selectedRecord.setAttribute("receivableSumMoney", value);
				}else if(percent.compareTo(BigDecimal.ZERO)==0) {
					selectedRecord.setAttribute("receivableSumMoney", 0);
					selectedRecord.setAttribute("receivablePercentage", 0);
				}else if(percent.compareTo(BigDecimal.ZERO)<0) {
					SC.say("提示","收款百分比不能为负数");
					selectedRecord.setAttribute("receivableSumMoney", 0);
					selectedRecord.setAttribute("receivablePercentage", 0);
					return ;
				}
				selectedRecord.setAttribute("updateTime", new Date());
//				records[rowNum] = selectedRecord;
//				resultGrid.setData(records);
//				resultGrid.redraw();
//				resultGrid.refreshFields();
				Map map = selectedRecord.toMap();
				map.put("contractId", contractId);
				map.put("operator", ClientUtil.getUserId());
				
				DBDataSource.callOperation("ST_ContractReceivable","saveOrUpdate",map, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() < 0) {
							commonQuery();
							ClientUtil.displayErrorMessage(dsResponse);
						}else {
//							SC.say("保存成功");
							commonQuery();
						}
					}
				});
			}
		});

		IButton newButton =PermissionControl.createPermissionButton("新增阶段", ERPPermissionStatic.CREATE_JD_BUTTON);
		controlLayout.addMember(newButton);
		newButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Record r =new Record();
				r.setAttribute("infoCode", infoCode);
				r.setAttribute("projectCode", projectCode);
				r.setAttribute("contractId", contractId);
				r.setAttribute("contractCode", contractCode);
				r.setAttribute("receivablePercentage", 0);
				r.setAttribute("receivableSumMoney", 0);
				r.setAttribute("signingMoneySum", signingMoneySum);
				r.setAttribute("createTime", new Date());
				r.setAttribute("operator", ClientUtil.getUserId());
				resultGrid.addData(r);
//				DBDataSource.callOperation("ST_ContractReceivable", "save", r.toMap(), new DSCallback() {
//					@Override
//					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//						if (dsResponse.getStatus() < 0) {
//							ClientUtil.displayErrorMessage(dsResponse);
//						}else {
//							commonQuery();
//						}
//					}
//				});
			}
		});
		
		IButton newChildButton =PermissionControl.createPermissionButton("新增子阶段", ERPPermissionStatic.CREATE_ZJD_BUTTON);
//		controlLayout.addMember(newChildButton);
		newChildButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				TreeNode currentNode = resultGrid.getSelectedRecord();
				if (currentNode == null) {
					SC.say("Please select a item as parent.");
					return;
				}
//				DBDataSource.printRecord(currentNode);
//				Tree tree = resultGrid.getData();
//				TreeNode newNode = new TreeNode();
//				DBDataSource.copyRecordNotInclude(currentNode, newNode, "contractReceivableId", "children", "isFolder");
//				newNode.setAttribute("parentId", ClientUtil.checkAndGetIntValue(currentNode.getAttribute("contractReceivableId")));
//				DBDataSource.printRecord(newNode);
//				newNode = tree.add(newNode, currentNode);
//				resultGrid.openFolder(currentNode);
//				resultGrid.selectSingleRecord(newNode);
//				resultGrid.startEditing(resultGrid.getRowNum(newNode));
				Record r =new Record();
				r.setAttribute("infoCode", infoCode);
				r.setAttribute("projectCode", projectCode);
				r.setAttribute("contractId", contractId);
				r.setAttribute("contractCode", contractCode);
				r.setAttribute("parentId", ClientUtil.checkAndGetIntValue(currentNode.getAttribute("contractReceivableId")));
				r.setAttribute("receivablePercentage", 0);
				r.setAttribute("receivableSumMoney", 0);
				DBDataSource.callOperation("ST_ContractReceivable", "save", r.toMap(), new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() < 0) {
							ClientUtil.displayErrorMessage(dsResponse);
						}else {
							SC.say("保存成功");
//							commonQuery();
						}
					}
				});
				
			}
		});

		IButton removeButton =PermissionControl.createPermissionButton("删除", ERPPermissionStatic.DEL_JD_AND_ZJD);
		controlLayout.addMember(removeButton);
		removeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("Please select a data to remove.");
				}
				final ListGridRecord selected = resultGrid.getSelectedRecord();
				if(null ==selected.getAttribute("contractReceivableId")){
					resultGrid.removeData(selected);
					return ;
				}
				
				DBDataSource.callOperation("ST_ContractReceivable", "delete", selected.toMap(), new DSCallback() {
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
		
		
		IButton saveButton =PermissionControl.createPermissionButton("保存", ERPPermissionStatic.SAVE_JD_AND_ZJD);
//		controlLayout.addMember(saveButton);
		saveButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Map condition = new HashMap<>();
				condition.put("contractId", contractId);
				condition.put("optType", "saveContractReceivableList");
				MapUtils.convertRecordToMap(resultGrid,resultGrid.getRecords(),condition,"contractReceivableList");
				
				DBDataSource.callOperation("EP_ContractReceivableProcessor",condition, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() < 0) {
							commonQuery();
							ClientUtil.displayErrorMessage(dsResponse);
						}else {
							SC.say("保存成功");
							commonQuery();
						}
					}
				});
			}
		});
		
		
		
		IButton applyButton = new IButton("应用模板");
		controlLayout.addMember(applyButton);
		applyButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				PopupWindow pw = new PopupWindow();
				ApplyTemplatePanel panel = new ApplyTemplatePanel();
				panel.setContractId(contractId);
				panel.setSigningMoneySum(signingMoneySum);
				panel.startEdit();
				panel.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						commonQuery();
					}
				});
				panel.setParentCanvas(pw);
				panel.setFatherWindow(pw);
				pw.addItem(panel);
				pw.setTitle("应用阶段模板");
				pw.setWidth("30%");
				pw.setHeight("50%");
				pw.centerInPage();
				pw.show();
				
			}
		});
		commonQuery();
	}

	@Override
	public void fetchDataCallback(DSResponse response, Object rawData) {
		List<Integer> list = new ArrayList<>();
		ListGridRecord[] selectRecords = resultGrid.getSelectedRecords();
		for (int i = 0; i < selectRecords.length; i++) {
			list.add(resultGrid.getRowNum(selectRecords[i]));
		}
		int len = response.getData().length;
		TreeNode[] nodes = new TreeNode[len];
		for (int i = 0; i < len; i++) {
			nodes[i] = new TreeNode();
			DBDataSource.copyRecord(response.getData()[i], nodes[i]);
		}
		Tree tree = new Tree();
		tree.setModelType(TreeModelType.PARENT);
		tree.setRootValue("");
		tree.setIdField("contractReceivableId");
		tree.setParentIdField("parentId");
		tree.setData(nodes);
		tree.openAll();
		resultGrid.setData(tree);
		resultGrid.sort();
		resultGrid.selectSingleRecord(0);
		for (Integer integer : list) {
			resultGrid.selectRecord(integer);
		}
//		TreeNode selectedNode = resultGrid.getSelectedRecord();
//		if(selectedNode != null) resultGrid.openFolder(selectedNode);
	}
	@Override
	public boolean checkSearchCriteria(Criteria criteria) {
		criteria.addCriteria("contractId", contractId);
		criteria.addCriteria("addtionalCondition", "order by cr.receivable_name");
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSMcontractreceivablecipcor.getInstance();
//		return DSContractReceivable.getInstance();
	}
	
	public static String infoCode;
	public static String projectCode;
	public static int contractId;
	public static String contractCode;
	public static BigDecimal signingMoneySum;
	
}

