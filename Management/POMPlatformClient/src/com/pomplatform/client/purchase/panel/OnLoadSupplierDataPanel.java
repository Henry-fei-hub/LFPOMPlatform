package com.pomplatform.client.purchase.panel;

import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchTree;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.purchase.datasource.DSOnLoadSupplierData;
import com.pomplatform.client.purchase.form.OnLoadSupplierDataSearchForm;
import com.pomplatform.client.purchase.form.OnLoadSupplierDataViewer;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.TreeModelType;
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

public class OnLoadSupplierDataPanel extends AbstractSearchTree
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			OnLoadSupplierDataPanel cm = new OnLoadSupplierDataPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OnLoadSupplierData";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
	}

	@Override
	public void initComponents() {
		TreeGridField[] fields = new TreeGridField[16];
        int idx = 0;
        fields[idx] = new TreeGridField("supplierId");
        fields[idx].setHidden(true);
        idx++;
        fields[idx] = new TreeGridField("supplierName");
        fields[idx].setFrozen(true);
        fields[idx].setCanEdit(true);
        fields[idx].setWidth(300);
        idx++;
        fields[idx] = new TreeGridField("supplierType");
        idx++;
        fields[idx] = new TreeGridField("supplierLevel");
        idx++;
        fields[idx] = new TreeGridField("majorContactPerson");
        idx++;
        fields[idx] = new TreeGridField("contactPhone");
        idx++;
        fields[idx] = new TreeGridField("majorBusiness");
        idx++;
        fields[idx] = new TreeGridField("startOrderCount");
        idx++;
        fields[idx] = new TreeGridField("productionCycle");
        idx++;
        fields[idx] = new TreeGridField("logisticsCycle");
        idx++;
        fields[idx] = new TreeGridField("logisticsType");
        idx++;
        fields[idx] = new TreeGridField("country");
        idx++;
        fields[idx] = new TreeGridField("province");
        idx++;
        fields[idx] = new TreeGridField("city");
        idx++;
        fields[idx] = new TreeGridField("address");
        idx++;
        fields[idx] = new TreeGridField("parentId");
        fields[idx].setHidden(true);
        idx++;
        resultGrid.setFields(fields);
        resultGrid.setCanEdit(false);
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
		viewButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		controlLayout.addMember(viewButton);
		
		
		IButton addButton = PermissionControl.createPermissionButton("新增",ERPPermissionStatic.SUPPLIER_MANAGEMENT_ADD);
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
						PopupWindow popupWindow = new PopupWindow("供应商信息登记");
						popupWindow.setWidth100();
						popupWindow.setHeight100();
						SupplierManageNewDesignPanel panel = new SupplierManageNewDesignPanel();
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
		
		IButton updateButton = PermissionControl.createPermissionButton("修改",ERPPermissionStatic.SUPPLIER_MANAGEMENT_UPDATE);
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
						PopupWindow popupWindow = new PopupWindow("供应商信息补录修改");
						popupWindow.setWidth100();
						popupWindow.setHeight100();
						SupplierManageUpdateDesignPanel panel = new SupplierManageUpdateDesignPanel();
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
		
		IButton apprailseButton = PermissionControl.createPermissionButton("发起评价",ERPPermissionStatic.SUPPLIER_MANAGEMENT_APPRAISE);
		controlLayout.addMember(apprailseButton);
		apprailseButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download code");
					}
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
						Record record = resultGrid.getSelectedRecord();
						//获取供应商id
						int supplierId = BaseHelpUtils.getIntValue(record.getAttribute("supplierId"));
						//获取供应商名称
						String supplierName = BaseHelpUtils.getString(record.getAttribute("supplierName"));						
						final PopupWindow popupWindow = new PopupWindow(supplierName + "-评价");
						popupWindow.setWidth("70%");
						popupWindow.setHeight("90%");
						popupWindow.centerInPage();
						SupplierAppraisePanel panel = new SupplierAppraisePanel();
						panel.initComponents(supplierId,supplierName);
						panel.load();
						popupWindow.addItem(panel);
						panel.setParentWindow(popupWindow);
						popupWindow.centerInPage();
						popupWindow.show();
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
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("供应商"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				OnLoadSupplierDataViewer detailForm = new OnLoadSupplierDataViewer();
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

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("addtionalCondition", "order by supplier_id");
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new OnLoadSupplierDataSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSOnLoadSupplierData.getInstance();
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
        tree.setIdField("supplierId");
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

