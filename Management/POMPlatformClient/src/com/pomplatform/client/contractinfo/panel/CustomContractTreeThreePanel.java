package com.pomplatform.client.contractinfo.panel;


import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractSearchTree;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.contractinfo.datasource.DSContractCustomInfo;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.TreeNode;


public class CustomContractTreeThreePanel extends AbstractSearchTree {
	private static final Logger __logger = Logger.getLogger("");
	
	private static int flowStatus = 3;
	
	//查看详情页 是否只显示不操作
	private static boolean isShow = false;	
	
    public static class Factory implements PanelFactory {
    	
        private String id;

        @Override
        public Canvas create() {
            CustomContractTreeThreePanel cm = new CustomContractTreeThreePanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "CustomContractTree";
        }

    }

    @Override
    public void initComponents() {
        //行数据是否可编辑
        resultGrid.setCanEdit(false);
        TreeGridField[] fields = new TreeGridField[4];
        int idx = 0;
        fields[idx] = new TreeGridField("contractId");
        fields[idx].setHidden(true);
        idx++;
        fields[idx] = new TreeGridField("contractName");
        fields[idx].setFrozen(true);
        fields[idx].setWidth(300);
        idx++;
        fields[idx] = new TreeGridField("contractCode");
        idx++;
        fields[idx] = new TreeGridField("parentId");
        idx++;
        resultGrid.setFields(fields);
        resultGrid.setShowFilterEditor(false);
        resultGrid.setFilterOnKeypress(true);
//        resultGrid.addDropCompleteHandler(new DropCompleteHandler() {
//            @Override
//            public void onDropComplete(DropCompleteEvent event) {
//                Record[] rs = event.getTransferredRecords();
//                DBDataSource.printRecord(rs[0]);
//                for (Record r : rs) {
//                    DBDataSource.callOperation("ST_DepartmentRole", "update", r.toMap(), new DSCallback() {
//                        @Override
//                        public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//                            if (dsResponse.getStatus() < 0) {
//                                ClientUtil.displayErrorMessage(dsResponse);
//                            }
//                        }
//                    });
//                }
//            }
//        });

        IButton refreshButton = new IButton("刷新");
        refreshButton.setIcon("[SKIN]/actions/refresh.png");
        controlLayout.addMember(refreshButton);
        refreshButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                commonQuery();
            }
        });
        //根据主合同的流程状态设置查询主合同信息
        String showButtonTitle = "";
        switch (flowStatus) {
		case 0:
			showButtonTitle = "查看详情";
			break;
		case 1:
			showButtonTitle = "承接部门";
			break;
		case 2:
			showButtonTitle = "运营价格";
			break;
		case 3:
			showButtonTitle = "价格审核";
			break;
		default:
			break;
		}
        IButton showButton = PermissionControl.createPermissionButton(showButtonTitle, ERPPermissionStatic.CONTRACT_INFO_MANAGEMENT);
        controlLayout.addMember(showButton);
        showButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
            	ListGridRecord[] selected = resultGrid.getSelectedRecords();
				final ListGridRecord selected1 = resultGrid.getSelectedRecord();
                int parentId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("parentId"));
                if(0 == parentId){
                	parentId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("contractId"));
                }
                String contractName = selected[0].getAttribute("contractName");
                PopupWindow pw = new PopupWindow();
                CustomContractMainPanel panel = new CustomContractMainPanel(parentId, selected1, flowStatus, isShow);
                panel.addDataEditedHandler(new DataEditedHandler() {
                	@Override
                	public void onDataEdited(DataEditEvent event) {
                		commonQuery();
                		SC.say("提示","操作成功");
                	}
                });
                panel.setParentWindow(pw);
                pw.addItem(panel);
                panel.setParentCanvas(pw);;
                pw.setTitle("合同(" + contractName + ")管理");
                pw.setWidth100();
                pw.setHeight100();
                pw.centerInPage();
                pw.show();
            }
        });
        
        IButton newChildButton = PermissionControl.createPermissionButton("添加子合同", ERPPermissionStatic.CONTRACT_INFO_MANAGEMENT);
        //只有主合同最开始才有添加子合同选项
        if(flowStatus == 0){
        	controlLayout.addMember(newChildButton);
        }
        newChildButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                TreeNode currentNode = resultGrid.getSelectedRecord();
                if (0 != BaseHelpUtils.getIntValue(currentNode.getAttribute("parentId"))) {
                    SC.say("Please select a item as parent.");
                    return;
                }
                
                int contractId = ClientUtil.checkAndGetIntValue(currentNode.getAttribute("contractId"));
                String contractName = currentNode.getAttribute("contractName");
                PopupWindow pw = new PopupWindow();
                CustomAddSubContractMainPanel panel = new CustomAddSubContractMainPanel(contractId, currentNode, 0);
                panel.addDataEditedHandler(new DataEditedHandler() {
                	@Override
                	public void onDataEdited(DataEditEvent event) {
                		commonQuery();
                		SC.say("提示","操作成功");
                	}
                });
                pw.addItem(panel);
                panel.setParentCanvas(pw);
                panel.setParentWindow(pw);
                pw.setTitle("合同(" + contractName + ")管理");
                pw.setWidth100();
                pw.setHeight100();
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
//            //设置图标
//            String parentId = response.getData()[i].getAttribute("departmentId");
//            if (!"".equals(parentId) && Integer.parseInt(parentId) >= 100000) {
//                nodes[i].setIcon("/images/photos/role_view.png");
//            }
            DBDataSource.copyRecord(response.getData()[i], nodes[i]);
        }
        Tree tree = new Tree();
        tree.setModelType(TreeModelType.PARENT);
        tree.setRootValue("0");
        tree.setIdField("contractId");
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
    	
        criteria.addCriteria("flowStatus", flowStatus);
        
        criteria.addCriteria("opt_type", "getMainContract");
        return true;
    }

    @Override
    public SearchForm generateSearchForm() {
        return null;
    }

    @Override
    public DataSource getDataSource() {
        return DSContractCustomInfo.getInstance();
    }

}
