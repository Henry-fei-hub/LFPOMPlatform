package com.pomplatform.client.memployeeaaccadpppccor.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.attachment.panel.UpdateAttachmentEmpPanel;
import com.pomplatform.client.attachment.panel.ViewContractAttachmentDetailPanel;
import com.pomplatform.client.contracticcisiior.datasource.DSMcontracticcisiior;
import com.pomplatform.client.memployeeaaccadpppccor.datasource.DSMemployeeaaccadpppccor;
import com.pomplatform.client.memployeeaaccadpppccor.form.MemployeeaaccadpppccorSearchForm;
import com.pomplatform.client.receivables.datasource.DSMcapitalecoosmeor;
import com.pomplatform.client.sinvoiceitior.datasource.DSSinvoiceitior;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.grid.events.EditorExitEvent;
import com.smartgwt.client.widgets.grid.events.EditorExitHandler;
import com.smartgwt.client.widgets.layout.VLayout;

public class MemployeeaaccadpppccorPanel extends AbstractSearchPanel {

	private static final Logger __LOGGER = Logger.getLogger("");

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			MemployeeaaccadpppccorPanel cm = new MemployeeaaccadpppccorPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Memployeeaaccadpppccor";
		}

	}

	@Override
	public void init() {
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
	}

	@Override
	public void initComponents() {
		int index = 0;
		ListGridField[] fields = new ListGridField[12];
		fields[index] = new ListGridField("contractName");
		fields[index].setCanEdit(false);
		fields[index].setShowGridSummary(false);
		index++;
		fields[index] = new ListGridField("contractCode");
		fields[index].setCanEdit(false);
		fields[index].setShowGridSummary(false);
		index++;
		fields[index] = new ListGridField("amount");
		fields[index].setShowGridSummary(false);
		fields[index].setCanEdit(false);
		index++;
		fields[index] = new ListGridField("returnAmount");
		fields[index].setShowGridSummary(false);
		fields[index].setCanEdit(false);
		index++;
		fields[index] = new ListGridField("financeRemark");
		fields[index].setShowTitle(true);
		fields[index].setShowGridSummary(false);
		fields[index].setWidth(130);
		index++;
		fields[index] = new ListGridField("canReceivedPayment");
		fields[index].setShowGridSummary(false);
		index++;
		fields[index] = new ListGridField("residualReceipts");
		fields[index].setCanEdit(false);
		index++;
		fields[index] = new ListGridField("attachmentName");
		fields[index].setShowGridSummary(false);
		fields[index].setCanEdit(false);
		index++;
		fields[index] = new ListGridField("attachmentAddress");
		fields[index].setShowGridSummary(false);
		fields[index].setCanEdit(false);
		index++;
		fields[index] = new ListGridField("projectManageId");
		fields[index].setShowGridSummary(false);
		fields[index].setCanEdit(false);
		index++;
		fields[index] = new ListGridField("superProjectManageId");
		fields[index].setShowGridSummary(false);
		fields[index].setCanEdit(false);
		index++;
		fields[index] = new ListGridField("employeeNameStr");
		fields[index].setShowGridSummary(false);
		fields[index].setCanEdit(false);
		index++;
		fields[index] = new ListGridField("recordDate");
		fields[index].setShowGridSummary(false);
		fields[index].setCanEdit(false);
		
		resultGrid.setFields(fields);
		resultGrid.setCanEdit(true);
		resultGrid.setShowGridSummary(true);
		
		
		resultGrid.addEditCompleteHandler(new EditCompleteHandler() {
			
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				Record record = event.getNewValuesAsRecord();
				Map params = record.toMap();
				params.put("attachmentManageId", resultGrid.getSelectedRecord().getAttribute("attachmentManageId"));
				DBDataSource.callOperation("ST_AttachmentManage", "update", params, new DSCallback() {
					
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						commonQuery();
						
					}
				});
				
			}
		});
		resultGrid.addEditorExitHandler(new EditorExitHandler() {
			
			@Override
			public void onEditorExit(EditorExitEvent event) {
				Object value = event.getNewValue();
				String colName = resultGrid.getField(event.getColNum()).getName();
				Record record = event.getRecord();
				Map params = new HashMap<>();
				params.put(colName, value);
				params.put("attachmentManageId", resultGrid.getSelectedRecord().getAttribute("attachmentManageId"));
				DBDataSource.callOperation("ST_AttachmentManage", "update", params, new DSCallback() {
					
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						commonQuery();
						
					}
				});
				
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

//		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
//			@Override
//			public void onDoubleClick(DoubleClickEvent event) {
//				showDetail();
//			}
//		});
		IButton operation1Button = new IButton("查看详情");
		controlLayout.addMember(operation1Button);
		operation1Button.setIcon("[SKIN]/actions/view.png");
		operation1Button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		IButton viewInvoiceButton = new IButton("查看发票详情");
		controlLayout.addMember(viewInvoiceButton);
		viewInvoiceButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(resultGrid.anySelected()){
					PopupWindow pw = new PopupWindow();
					
					VLayout mianLayout = new VLayout();
					mianLayout.setHeight100();
					mianLayout.setWidth100();
					Criteria ct = new Criteria();
					ct.addCriteria("contractId", resultGrid.getSelectedRecord().getAttribute("contractId"));
					DelicacyListGrid grid = new DelicacyListGrid();
					grid.setDataSource(DSSinvoiceitior.getInstance());
					grid.setAutoFetchData(true);
					grid.setCriteria(ct);
					
					mianLayout.addMember(grid);
	                pw.addItem(mianLayout);
	                pw.setTitle("合同下发票详情");
	                pw.setWidth("80%");
	                pw.setHeight("80%");
	                pw.centerInPage();
	                pw.show();
				}else{
					SC.say("请选择一条数据进行查看");
				}
				
			}
		});
		IButton viewCaptailButton = new IButton("查看收款详情");
		controlLayout.addMember(viewCaptailButton);
		viewCaptailButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(resultGrid.anySelected()){
					PopupWindow pw = new PopupWindow();
					
					VLayout mianLayout = new VLayout();
					mianLayout.setHeight100();
					mianLayout.setWidth100();
					Criteria ct = new Criteria();
					ct.addCriteria("contractId", resultGrid.getSelectedRecord().getAttribute("contractId"));
					DelicacyListGrid grid = new DelicacyListGrid();
					grid.setDataSource(DSMcapitalecoosmeor.getInstance());
					grid.setAutoFetchData(true);
					grid.setCriteria(ct);
					
					mianLayout.addMember(grid);
	                pw.addItem(mianLayout);
	                pw.setTitle("合同下收款详情");
	                pw.setWidth("80%");
	                pw.setHeight("80%");
	                pw.centerInPage();
	                pw.show();
				}else{
					SC.say("请选择一条数据进行查看");
				}
				
			}
		});
		IButton exportBtn = new IButton("导出");
		controlLayout.addMember(exportBtn);
		exportBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				DBDataSource.downloadFile("DW_Memployeeaaccadpppccor", generateCriteria());
				
			}
		});
		IButton updateEmpBtn = new IButton("修改确认函人员");
		controlLayout.addMember(updateEmpBtn);
		updateEmpBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(!resultGrid.anySelected()){
					SC.say("请选择需要进行修改的确认函!");
					return;
				}
				PopupWindow pw = new PopupWindow();
				UpdateAttachmentEmpPanel panel = new UpdateAttachmentEmpPanel(resultGrid.getSelectedRecord());
				panel.addDataEditedHandler(new DataEditedHandler() {
                	@Override
                	public void onDataEdited(DataEditEvent event) {
                		commonQuery();
                		SC.say("提示","修改成功");
                	}
                });
				panel.loadEmpData();
				panel.setFatherWindow(pw);
				panel.setParentCanvas(pw);
                pw.addItem(panel);
                pw.setTitle("修改确认函人员");
                pw.setWidth(530);
                pw.setHeight("80%");
                pw.centerInPage();
                pw.show();
				
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
				if(!resultGrid.anySelected()){
					SC.say("请选择一条数据!");
					return;
				}
				viewDetailPanel.loadData(resultGrid.getSelectedRecord());
			}
		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("deleteFlag", 0);
		String tmpSql = "AND am.amount != am.return_amount";
		if (null != criteria.get("isEquals")) {
			if ((boolean) criteria.get("isEquals")) {
				List<Map> keyvalues = new ArrayList<>();
				Map<String, String> kv = new HashMap<>();
				kv.put("key", tmpSql);
				kv.put("value", "AND am.amount = am.return_amount");
				keyvalues.add(kv);
				criteria.put("keyValues", keyvalues);
			}
		} else {
			List<Map> keyvalues = new ArrayList<>();
			Map<String, String> kv = new HashMap<>();
			kv.put("key", tmpSql);
			kv.put("value", "");
			keyvalues.add(kv);
			criteria.put("keyValues", keyvalues);
		}
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new MemployeeaaccadpppccorSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSMemployeeaaccadpppccor.getInstance();
	}
	
	private ViewContractAttachmentDetailPanel viewDetailPanel;

	public ViewContractAttachmentDetailPanel getViewDetailPanel() {
		return viewDetailPanel;
	}

	public void setViewDetailPanel(ViewContractAttachmentDetailPanel viewDetailPanel) {
		this.viewDetailPanel = viewDetailPanel;
	}


}
