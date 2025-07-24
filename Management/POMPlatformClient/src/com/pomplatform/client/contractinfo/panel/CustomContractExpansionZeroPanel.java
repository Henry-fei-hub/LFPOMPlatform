package com.pomplatform.client.contractinfo.panel;


import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractExpansionRelatedPage;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.contractinfo.datasource.DSContractCustomInfo;
import com.pomplatform.client.subcontractinfo.datasource.DSSubContractInfo;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;


public class CustomContractExpansionZeroPanel extends AbstractExpansionRelatedPage {
	private static final Logger __logger = Logger.getLogger("");
	
	private static int flowStatus = 0;
	
	//查看详情页 是否只显示不操作
	private static boolean isShow = true;
	
    public static class Factory implements PanelFactory {
    	
        private String id;

        @Override
        public Canvas create() {
            CustomContractExpansionZeroPanel cm = new CustomContractExpansionZeroPanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "CustomContractTreeZero";
        }

    }

    @Override
    public void initComponents() {
        //行数据是否可编辑
        resultGrid.setCanEdit(false);
//        resultChildGrid.setCanEdit(false);
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
        IButton showButton = PermissionControl.createPermissionButton(showButtonTitle, ERPPermissionStatic.CONTRACT_INFO_SELECT_CONTRACTS_BUTTON);
        controlLayout.addMember(showButton);
        showButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
            	ListGridRecord[] selected = resultGrid.getSelectedRecords();
            	if(selected.length < 1){
            		SC.say("请选择一条数据");
            		return;
            	}
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
                pw.setTitle("订单(" + contractName + ")管理");
                pw.setWidth100();
                pw.setHeight100();
                pw.centerInPage();
                pw.show();
            }
        });
        
        IButton newChildButton = PermissionControl.createPermissionButton("新增子订单", ERPPermissionStatic.CONTRACT_INFO_ADD_CONTRACTS_BUTTON);
        //只有主合同最开始才有添加子合同选项
        if(flowStatus == 0){
        	controlLayout.addMember(newChildButton);
        }
        newChildButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
            	ListGridRecord[] selected = resultGrid.getSelectedRecords();
            	if(selected.length < 1){
            		SC.say("请选择一条数据");
            		return;
            	}
                ListGridRecord currentNode = resultGrid.getSelectedRecord();
                if (0 != BaseHelpUtils.getIntValue(currentNode.getAttribute("parentId"))) {
                    SC.say("Please select a item as parent.");
                    return;
                }
                int contractId = ClientUtil.checkAndGetIntValue(currentNode.getAttribute("contractId"));
                String contractName = currentNode.getAttribute("contractName");
                int flowStatus = currentNode.getAttributeAsInt("flowStatus");
                PopupWindow pw = new PopupWindow();
                CustomAddSubContractMainPanel panel = new CustomAddSubContractMainPanel(contractId, currentNode, flowStatus);
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
                pw.setTitle("订单(" + contractName + ")管理");
                pw.setWidth100();
                pw.setHeight100();
                pw.centerInPage();
                pw.show();
                
            }
        });

        commonQuery();
    }

    @Override
    public boolean checkSearchCriteria(Map criteria) {
        criteria.put("flowStatus", flowStatus);
        criteria.put("opt_type", "getMainContract");
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

	@Override
	public DataSource getChildDataSource() {
		return DSSubContractInfo.getInstance();
	}

}
