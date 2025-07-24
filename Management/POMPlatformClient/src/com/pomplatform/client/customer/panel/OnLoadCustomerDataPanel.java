package com.pomplatform.client.customer.panel;

import java.util.Map;
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
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.customer.datasource.DSOnLoadCustomerData;
import com.pomplatform.client.customer.form.OnLoadCustomerDataSearchForm;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.TreeNode;

public class OnLoadCustomerDataPanel extends AbstractSearchTree
{
	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			OnLoadCustomerDataPanel cm = new OnLoadCustomerDataPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OnLoadCustomerData";
		}

	}

	@Override
	public void initComponents() {
		TreeGridField[] fields = new TreeGridField[13];
        int idx = 0;
        fields[idx] = new TreeGridField("customerId");
        fields[idx].setHidden(true);
        idx++;
        fields[idx] = new TreeGridField("customerName");
        fields[idx].setFrozen(true);
        fields[idx].setCanEdit(true);
        fields[idx].setWidth(300);
        idx++;
        fields[idx] = new TreeGridField("companyAddress");
        idx++;
        fields[idx] = new TreeGridField("companyMobile");
        idx++;
        fields[idx] = new TreeGridField("customerType");
        idx++;
        fields[idx] = new TreeGridField("customerLevel");
        idx++;
        fields[idx] = new TreeGridField("reportEmployeeId");
        idx++;
        fields[idx] = new TreeGridField("companyProvince");
        idx++;
        fields[idx] = new TreeGridField("companyCity");
        idx++;
        fields[idx] = new TreeGridField("isSure");
        idx++;
        fields[idx] = new TreeGridField("isWarehous");
        idx++;
        fields[idx] = new TreeGridField("isApplyQuote");
        idx++;
        fields[idx] = new TreeGridField("parentId");
        fields[idx].setHidden(true);
        idx++;
        resultGrid.setFields(fields);
        resultGrid.setFilterOnKeypress(true);
		resultGrid.setAutoFitFieldWidths(false);
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});

		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				showDetail();
			}
		});
		IButton viewButton = new IButton("查看详细");
		controlLayout.addMember(viewButton);
		viewButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		
		IButton addButton = PermissionControl.createPermissionButton("客户报备",ERPPermissionStatic.CUSTOMER_RESOURCES_ADD);
		controlLayout.addMember(addButton);
		addButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download code");
					}
					@Override
					public void onSuccess() {
						PopupWindow popupWindow = new PopupWindow("客户信息报备登记");
						popupWindow.setWidth100();
						popupWindow.setHeight100();
						ClientManageNewDesignPanel panel = new ClientManageNewDesignPanel();
						panel.addDataEditedHandler(new DataEditedHandler() {
							@Override
							public void onDataEdited(DataEditEvent event) {
								commonQuery();
							}
						});
						popupWindow.addItem(panel);
						panel.setParWindow(popupWindow);
						popupWindow.centerInPage();
						popupWindow.show();
					}
				});
			}
		});
		
		IButton updateButton = PermissionControl.createPermissionButton("补录修改",ERPPermissionStatic.CUSTOMER_RESOURCES_UPDATE);
		controlLayout.addMember(updateButton);
		updateButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download code");
					}
					@SuppressWarnings({ "rawtypes", "unchecked" })
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
						Record record = resultGrid.getSelectedRecord();
						Map valueMap = record.toMap();
						PopupWindow popupWindow = new PopupWindow("客户信息补录修改");
						popupWindow.setWidth100();
						popupWindow.setHeight100();
						ClientManageUpdateDesignPanel panel = new ClientManageUpdateDesignPanel();
						panel.addDataEditedHandler(new DataEditedHandler() {
							@Override
							public void onDataEdited(DataEditEvent event) {
								commonQuery();
							}
						});
						popupWindow.addItem(panel);
						panel.setParWindow(popupWindow);
						panel.setValueRecord(valueMap);
						popupWindow.centerInPage();
						popupWindow.show();
					}
				});
			}
		});
		
		IButton deleteButton = PermissionControl.createPermissionButton("删除",ERPPermissionStatic.CUSTOMER_RESOURCES_DELETE);
		controlLayout.addMember(deleteButton);
		deleteButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download code");
					}
					@SuppressWarnings({ "rawtypes", "unchecked"})
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
						Record record = resultGrid.getSelectedRecord();
						Map valueMap = record.toMap();
						//已报备客户不可删除
						int reportEmployeeId = BaseHelpUtils.getIntValue(valueMap, "reportEmployeeId");
						if(reportEmployeeId > 0){//说明已报备人员
							SC.say("提示","该客户已报备人员不可删除");
							return;
						}
						//正式客户不可删除
						boolean isSure = BaseHelpUtils.getBoolean(valueMap.get("isSure"));
						if(isSure){
							SC.say("提示","该客户已成为正式客户不可删除");
							return;
						}
						valueMap.put("optType","onCustomerInfoDelete");
						SC.ask("提示","您确认要删除该数据吗?", new BooleanCallback() {
							@Override
							public void execute(Boolean value) {
								if(value){
									DBDataSource.callOperation("EP_OnCustomerProcess","delete",valueMap, new DSCallback() {
							            @Override
							            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							                if (dsResponse.getStatus() >= 0) {
							                    SC.say("提示","删除成功");
							                    commonQuery();
							                }else{
							                	Map errors = dsResponse.getErrors();
							                	SC.say("提示",errors.get("errors").toString());
							                }
							            }
							        });
								}
							}
						});
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
			@SuppressWarnings({ "unchecked", "rawtypes" })
			@Override
			public void onSuccess() {
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				Record record = resultGrid.getSelectedRecord();
				Map valueMap = record.toMap();
				PopupWindow popupWindow = new PopupWindow("客户信息补录详情");
				popupWindow.setWidth100();
				popupWindow.setHeight100();
				ClientManageViewDesignPanel panel = new ClientManageViewDesignPanel();
				popupWindow.addItem(panel);
				panel.setParWindow(popupWindow);
				panel.setValueRecord(valueMap);
				popupWindow.centerInPage();
				popupWindow.show();
			}
		});
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public boolean checkSearchCriteria(Map criteria) {
		//如果没有查看所有的权限，则只能查看自己报备的数据权限
		if(!ClientUtil.checkIsHavePermission(ERPPermissionStatic.CUSTOMER_RESOURCES_CHECK_ALL_DATA)){
			int reportEmployeeId = ClientUtil.getEmployeeId();
			criteria.put("reportEmployeeId", reportEmployeeId);
		}
		return true;
	}
	
	@Override
	public int getSearchFormHeight() {
		return 120;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new OnLoadCustomerDataSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSOnLoadCustomerData.getInstance();
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
        tree.setIdField("customerId");
        tree.setParentIdField("parentId");
        tree.setData(nodes);
        resultGrid.setData(tree);
        resultGrid.selectSingleRecord(0);
        TreeNode selectedNode = resultGrid.getSelectedRecord();
        if (selectedNode != null) {
            resultGrid.openFolder(selectedNode);
        }
	}


}

