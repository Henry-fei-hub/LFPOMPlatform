package com.pomplatform.client.stagemodel.panel;

import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractSearchTree;
import com.google.gwt.i18n.client.NumberFormat;
import com.pomplatform.client.stagemodel.datasource.DSStageModelTree;
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
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.TreeNode;

public class StageModelTreePanel extends AbstractSearchTree
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			StageModelTreePanel cm = new StageModelTreePanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "StageModelTree";
		}
		
	}

	@Override
	public void generateTreeGrid(){
		super.generateTreeGrid();
		resultGrid.setAutoFitFieldWidths(false);
	}
	
	@Override
	public void initComponents() {
        resultGrid.setCanEdit(true);
        TreeGridField[] fields = new TreeGridField[9];
        int idx = 0;
        fields[idx] = new TreeGridField("stageModelId");
        fields[idx].setHidden(true);  
        idx++;
        fields[idx] = new TreeGridField("stageModelName");
        idx++;
        fields[idx] = new TreeGridField("remark");
        idx++;
        fields[idx] = new TreeGridField("percent");
        fields[idx].setCellFormatter(new CellFormatter() {  
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {  
                if (value != null) {  
                    NumberFormat nf = NumberFormat.getFormat("##0.00");  
                    try {  
                        return nf.format(BaseHelpUtils.getDoubleValue(value)*100)+"%";  
                    } catch (Exception e) {  
                        return value.toString();  
                    }  
                } else {  
                    return null;  
                }  
            }  
        });
        idx++;
        fields[idx] = new TreeGridField("parentId");
        fields[idx].setHidden(true);
        idx++;
        fields[idx] = new TreeGridField("leafNode");
        idx++;
        fields[idx] = new TreeGridField("orderNo");
        idx++;
        fields[idx] = new TreeGridField("needManagerAudit");
        idx++;
        fields[idx] = new TreeGridField("needDesignDirectorAudit");
        resultGrid.setFields(fields);
        resultGrid.setShowFilterEditor(false);
        resultGrid.setFilterOnKeypress(false);
        resultGrid.addDropCompleteHandler(new DropCompleteHandler() {
            @Override
            public void onDropComplete(DropCompleteEvent event) {
                Record[] rs = event.getTransferredRecords();
                DBDataSource.printRecord(rs[0]);
                for (Record r : rs) {
                    DBDataSource.callOperation("ST_StageModel", "update", r.toMap(), new DSCallback() {
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
        
        IButton checkButton = new IButton("查看");
        controlLayout.addMember(checkButton);
        checkButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                TreeNode currentNode = resultGrid.getSelectedRecord();
                Tree tree = resultGrid.getData();
                TreeNode parentNode = tree.getParent(currentNode);
                __LOGGER.info("父节点信息："+parentNode.getName()+"  Title:"+parentNode.getTitle());
                TreeNode[] arr = tree.getChildren(parentNode);
                for(TreeNode obj : arr){
                	__LOGGER.info(obj.getName()+"  Title:"+obj.getTitle());
                }
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
                DBDataSource.callOperation("ST_StageModel", "saveOrUpdate", params, new DSCallback() {
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
                DBDataSource.copyRecordNotInclude(currentNode, newNode, "stageModelId", "children", "isFolder");
                newNode.setAttribute("parentId", ClientUtil.checkAndGetIntValue(currentNode.getAttribute("stageModelId")));
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
                final ListGridRecord selected = resultGrid.getSelectedRecord();
                //获取主键ID
                int stageModelId = BaseHelpUtils.getIntValue(selected.getAttribute("stageModelId"));
                if(stageModelId > 0){
                	DBDataSource.callOperation("ST_StageModel", "delete", selected.toMap(), new DSCallback() {
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
        tree.setIdField("stageModelId");
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
    	criteria.addCriteria("addtionalCondition", "order by order_no, stage_model_id");
        return true;
    }

    @Override
    public SearchForm generateSearchForm() {
        return null;
    }

	@Override
	public DataSource getDataSource() {
		return DSStageModelTree.getInstance();
	}


}

