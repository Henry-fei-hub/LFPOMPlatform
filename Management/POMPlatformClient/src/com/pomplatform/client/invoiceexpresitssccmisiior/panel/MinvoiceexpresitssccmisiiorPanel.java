package com.pomplatform.client.invoiceexpresitssccmisiior.panel;

import java.util.ArrayList;
import java.util.Date;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.BooleanCallback;
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
import com.delicacy.client.ui.AbstractSearchPanel;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractExpansionRelatedPage;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.contracticcisiior.panel.AddSignZeroContracticcisiiorPanel;
import com.pomplatform.client.invoiceexpresitssccmisiior.datasource.DSMinvoiceexpresitssccmisiior;
import com.pomplatform.client.invoiceexpresitssccmisiior.form.MinvoiceexpresitssccmisiiorSearchForm;
import com.pomplatform.client.invoiceexpresitssccmisiior.form.MinvoiceexpresitssccmisiiorViewer;
import com.pomplatform.client.sinvoiceitior.datasource.DSSinvoiceitior;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @ClassName: MinvoiceexpresitssccmisiiorPanel 
 * @Description:  快递信息主面板
 * @author CL
 * @date 2016年11月16日 
 *
 */
public class MinvoiceexpresitssccmisiiorPanel extends AbstractExpansionRelatedPage {

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			MinvoiceexpresitssccmisiiorPanel cm = new MinvoiceexpresitssccmisiiorPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Minvoiceexpresitssccmisiior";
		}

	}

	@Override
	public void initComponents() {
		resultGrid.setCanEdit(false);
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.setIcon("[SKIN]/actions/refresh.png");
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
		IButton detailButton = PermissionControl.createPermissionButton("查看详情", ERPPermissionStatic.SIM_VIEW_DETAIL);
		controlLayout.addMember(detailButton);
		detailButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		
		
		IButton removeButton = new IButton("删除");
//		controlLayout.addMember(removeButton);
		removeButton.setIcon("[SKIN]/actions/remove.png");
		removeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("Please select a data to remove.");
				}
				final ListGridRecord selected = resultGrid.getSelectedRecord();
				DBDataSource.callOperation("ST_Minvoiceexpresitssccmisiior", "delete", selected.toMap(),
						new DSCallback() {
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
		IButton addButton = PermissionControl.createPermissionButton("发出快递", ERPPermissionStatic.SIM_SEND);
		controlLayout.addMember(addButton);
		addButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				PopupWindow pw = new PopupWindow();
				AddInvoiceExpressPanel panel = new AddInvoiceExpressPanel();
				panel.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						commonQuery();
						SC.say("提示", "操作成功");
					}
				});
				panel.setParentCanvas(pw);
				panel.setFatherWindow(pw);
				pw.addItem(panel);

				pw.setTitle("发出快递");
				pw.setShowCloseButton(false);
				pw.setWidth100();
				pw.setHeight100();
				pw.centerInPage();
				pw.show();
			}
		});
		
		IButton sendButton = PermissionControl.createPermissionButton("确认寄出", ERPPermissionStatic.SIM_SEND_COMFIRM);
		controlLayout.addMember(sendButton);
		sendButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(resultGrid.anySelected()){
					
					final ListGridRecord record = resultGrid.getSelectedRecord();
					int signStatus = record.getAttributeAsInt("signStatus");
					if(signStatus != 1){
						SC.say("该快递已经寄出！");
						return;
					}
					SC.ask("提示", "确认寄出？", new BooleanCallback() {
						
						@Override
						public void execute(Boolean value) {
							if(value){
								
								Map<String, Object> param = new HashMap<>();
								param.put("opt_type", "updateExpressType");
								param.put("invoiceExpressId", record.getAttribute("invoiceExpressId"));
								param.put("signStatus", 2);
								DBDataSource.callOperation("EP_CustomerMinvoiceexpresitssccmisiiorHandler", param, new DSCallback() {
									
									@Override
									public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
										if(dsResponse.getStatus() > 0){
											commonQuery();
										}else{
											ClientUtil.displayErrorMessage(dsResponse);
										}
										
									}
								});
							}
							
						}
					});
				}else{
					SC.say("请选择一条快递信息进行寄出！");
				}
				
			}
		});
		
		IButton updateButton = PermissionControl.createPermissionButton("修改快递", ERPPermissionStatic.SIM_UPDATE);
		controlLayout.addMember(updateButton);
		updateButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				
				if(resultGrid.anySelected()){
					ListGridRecord __record = resultGrid.getSelectedRecord();
					String courierNumber = __record.getAttribute("courierNumber");
					PopupWindow pw = new PopupWindow();
					UpdateInvoiceExpressPanel panel = new UpdateInvoiceExpressPanel(__record, 2);
					panel.addDataEditedHandler(new DataEditedHandler() {
						@Override
						public void onDataEdited(DataEditEvent event) {
							commonQuery();
							SC.say("提示", "操作成功");
						}
					});
					panel.setParentCanvas(pw);
					panel.setFatherWindow(pw);
					pw.addItem(panel);

					pw.setTitle("单号["+courierNumber+"]快递信息修改");
					pw.setShowCloseButton(false);
					pw.setWidth100();
					pw.setHeight100();
					pw.centerInPage();
					pw.show();
				}else{
					SC.say("清选择一条快递信息进行修改！");
				}
				
			}
		});
		
		IButton signButton = PermissionControl.createPermissionButton("签收登记", ERPPermissionStatic.SIM_SIGN);
		controlLayout.addMember(signButton);
		signButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				final ListGridRecord record = resultGrid.getSelectedRecord();
				int signStatus = record.getAttributeAsInt("signStatus");
				if(signStatus == 1){
					SC.say("该快递还未寄出！");
					return;
				}
				if(signStatus == 3){
					SC.say("该快递已签收！");
					return;
				}
				if(resultGrid.anySelected()){
					ListGridRecord __record = resultGrid.getSelectedRecord();
					String courierNumber = __record.getAttribute("courierNumber");
					PopupWindow pw = new PopupWindow();
					UpdateInvoiceExpressPanel panel = new UpdateInvoiceExpressPanel(__record, 1);
					panel.addDataEditedHandler(new DataEditedHandler() {
						@Override
						public void onDataEdited(DataEditEvent event) {
							commonQuery();
							SC.say("提示", "操作成功");
						}
					});
					panel.setParentCanvas(pw);
					panel.setFatherWindow(pw);
					pw.addItem(panel);

					pw.setTitle("单号["+courierNumber+"]快递信息");
					pw.setWidth100();
					pw.setHeight100();
					pw.centerInPage();
					pw.show();
				}else{
					SC.say("清选择一条快递信息进行签收登记！");
				}
				
			}
		});
		
		IButton deleteBtn = new IButton("删除快递");
		controlLayout.addMember(deleteBtn);
		deleteBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(resultGrid.anySelected()){
					SC.ask("确认删除?", new BooleanCallback() {
						
						@Override
						public void execute(Boolean value) {
							if(null != value && value){
								ListGridRecord selectRecord = resultGrid.getSelectedRecord();
								Map<String, Object> params = selectRecord.toMap();
								params.put("opt_type", "deleteExpress");
								DBDataSource.callOperation("EP_CustomerMinvoiceexpresitssccmisiiorHandler", params, new DSCallback() {
									
									@Override
									public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
										if(dsResponse.getStatus() >= 0){
											commonQuery();
										}else{
											ClientUtil.displayErrorMessage(dsResponse);
										}
										
									}
								});
							}
							
						}
					});
					
				}else{
					SC.say("请选择需要删除的快递单");
				}
				
			}
		});
		
		IButton exportBtn = new IButton("导出");
		controlLayout.addMember(exportBtn);
		exportBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				DBDataSource.downloadFile("DW_Minvoiceexpresitssccmisiior", generateCriteria());
				
			}
		});
		
		commonQuery();
	}

	public void showDetail() {
		if(resultGrid.anySelected()){
			ListGridRecord __record = resultGrid.getSelectedRecord();
			String courierNumber = __record.getAttribute("courierNumber");
			PopupWindow pw = new PopupWindow();
			UpdateInvoiceExpressPanel panel = new UpdateInvoiceExpressPanel(__record, 3);
			panel.addDataEditedHandler(new DataEditedHandler() {
				@Override
				public void onDataEdited(DataEditEvent event) {
					commonQuery();
					SC.say("提示", "操作成功");
				}
			});
			panel.setParentCanvas(pw);
			panel.setFatherWindow(pw);
			pw.addItem(panel);

			pw.setTitle("单号["+courierNumber+"]快递信息查看");
			pw.setWidth100();
			pw.setHeight100();
			pw.centerInPage();
			pw.show();
		}else{
			SC.say("清选择一条快递信息进行查看 ！");
		}
		
//		GWT.runAsync(new RunAsyncCallback() {
//			@Override
//			public void onFailure(Throwable reason) {
//				SC.say("failure to download code");
//			}
//
//			@Override
//			public void onSuccess() {
//				if (!resultGrid.anySelected()) {
//					SC.say("请选择一条数据");
//					return;
//				}
//				GenericViewWindow detail = new GenericViewWindow();
//				detail.setTitle("Minvoiceexpresitssccmisiior");
//				detail.setWidth100();
//				detail.setHeight100();
//				MinvoiceexpresitssccmisiiorViewer detailForm = new MinvoiceexpresitssccmisiiorViewer();
//				detailForm.setParentSearchForm(searchForm);
//				detailForm.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_TAB);
//				detailForm.initComponents();
//				detailForm.viewSelectedData(resultGrid);
//				detail.setContent(detailForm);
//				detail.centerInPage();
//				detail.show();
//			}
//		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("addtionalCondition", "order by invoice_express_id");
		List<Map> keyvalues = new ArrayList<>();
		if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.SIM_DATA_ALL)){
			
		}else if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.SIM_DATA_DEPARTMENT)){
			
			Map<String, String> kv = new HashMap<>();
			kv.put("key", "ie.contact_id = ?");
			StringBuilder sb = new StringBuilder();
			sb.append("ie.contact_id = ? and ")
				.append("ie.contract_id in (")
				.append("SELECT contract_id FROM projects WHERE plate_id in(select plate_id from departments where department_id in (SELECT department_id FROM employee_roles where employee_id =")
				.append(ClientUtil.getEmployeeId())
				.append(" AND role_id = 3))) ");
			kv.put("value", sb.toString());
			keyvalues.add(kv);
			criteria.put("keyValues", keyvalues);
		}else if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.SIM_DATA_PROJECT_MANAGE)){
			Map<String, String> kv = new HashMap<>();
			kv.put("key", "ie.contact_id = ?");
			StringBuilder sb = new StringBuilder();
			sb.append("ie.contact_id = ? and ")
				.append("ie.contract_id in (")
				.append("SELECT contract_id FROM projects WHERE project_manage_id = ")
				.append(ClientUtil.getEmployeeId())
				.append(") ");
			kv.put("value", sb.toString());
			keyvalues.add(kv);
			
		}
		if(null != criteria.get("showOrHide") && (Boolean)criteria.get("showOrHide")){
			Map<String, String> kv = new HashMap<>();
			kv.put("key", "i.sign = ?");
			kv.put("value", "i.sign = ? AND (date_part('day', now() - ie.courier_date) < 14 OR ie.sign_status <> 3)");
			keyvalues.add(kv);
		}
		if(keyvalues.size() > 0){
			criteria.put("keyValues", keyvalues);
		}
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new MinvoiceexpresitssccmisiiorSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSMinvoiceexpresitssccmisiior.getInstance();
	}

	@Override
	public DataSource getChildDataSource() {
		return DSSinvoiceitior.getInstance();
	}

	public String[] showSummaryField() {
		return new String[]{"invoiceAmount", "noTaxAmount", "outputTax"};
	}

	@Override
	public void setChildGridOption(ListGrid resultChildGrid) {
    	resultChildGrid.setShowGridSummary(true);
    	String [] sumFiled = showSummaryField();
    	
    	ListGridField [] fields = resultChildGrid.getFields();
    	for (ListGridField listGridField : fields) {
    		String fieldName = listGridField.getName();
    		boolean flag = false;
    		for (String string : sumFiled) {
				if(string.equals(fieldName)){
					flag = true;
					break;
				}
			}
    		listGridField.setShowGridSummary(flag);
		}
	}
}
