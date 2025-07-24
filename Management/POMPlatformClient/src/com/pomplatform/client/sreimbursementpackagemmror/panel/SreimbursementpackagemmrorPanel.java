package com.pomplatform.client.sreimbursementpackagemmror.panel;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.*;
import com.delicacy.client.ui.AbstractExpansionRelatedPage;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.SyncDataUtil;
import com.pomplatform.client.reimbursementpackage.panel.NewReimbursementPackagePanel;
import com.pomplatform.client.sreimbursementpackagemmror.datasource.DSMcmbcpaydetailcctyrrosoowwwppor;
import com.pomplatform.client.sreimbursementpackagemmror.datasource.DSMreimbursementpackagesummarycrtppor;
import com.pomplatform.client.sreimbursementpackagemmror.datasource.DSScmbcpaydetailctyor;
import com.pomplatform.client.sreimbursementpackagemmror.datasource.DSSreimbursementpackagemmror;
import com.pomplatform.client.sreimbursementpackagemmror.form.SreimbursementpackagemmrorSearchForm;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditorExitEvent;
import com.smartgwt.client.widgets.grid.events.EditorExitHandler;

public class SreimbursementpackagemmrorPanel extends AbstractExpansionRelatedPage {

	private static final Logger __LOGGER = Logger.getLogger("");
	
	public static Map<String, Object> printMap = new HashMap<>();//打印的值存储

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			SreimbursementpackagemmrorPanel cm = new SreimbursementpackagemmrorPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Sreimbursementpackagemmror";
		}

	}

	@Override
	public void initComponents() {
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
		IButton operation1Button = new IButton("查看详情");
		controlLayout.addMember(operation1Button);
//		operation1Button.setIcon("[SKIN]/actions/view.png");
		operation1Button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		IButton removeButton = PermissionControl.createPermissionButton("删除", ERPPermissionStatic.RP_DELETE_PACKAGE	);
		controlLayout.addMember(removeButton);
//		removeButton.setIcon("[SKIN]/actions/remove.png");
		removeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("请选择需要删除的数据。");
					return;
				}
				boolean isCompeleted = resultGrid.getSelectedRecord().getAttributeAsBoolean("isCompleted");
				if(isCompeleted){
					SC.say("该打包已经通过出纳审核，不可删除");
					return;
				}
				SC.ask("确认删除？", new BooleanCallback() {
					
					@Override
					public void execute(Boolean value) {
						if(value){
							final ListGridRecord selected = resultGrid.getSelectedRecord();
							int packageId = selected.getAttributeAsInt("reimbursementPackageId");
							int employeeId = ClientUtil.getEmployeeId();
							Map<String, Object> params = new HashMap<>();
							params.put("packageId", packageId);
							params.put("employeeId", employeeId);
							params.put("opt_type", "deletePackage");
							DBDataSource.callOperation("EP_ReimbursementPackageProcessor", "deletePackage", params,
									new DSCallback() {
										@Override
										public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
											if (dsResponse.getStatus() < 0) {
												ClientUtil.displayErrorMessage(dsResponse);
											} else {
												int indexNum = resultGrid.getRowNum(selected);
												resultGrid.removeData(selected);
												resultGrid.selectSingleRecord(indexNum);
												SC.say("删除成功。");
											}
										}
									});
						}
					}
				});
			}
		});
		IButton doPackageBtn = PermissionControl.createPermissionButton("进行打包", ERPPermissionStatic.RP_ADD_PACKAGE);
//		controlLayout.addMember(doPackageBtn);
		doPackageBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				PopupWindow pw = new PopupWindow();
				pw.setWidth100();
				pw.setHeight100();
				NewReimbursementPackagePanel panel = new NewReimbursementPackagePanel();
				panel.setParentWindow(pw);
				panel.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						commonQuery();
						SC.say("提示", "操作成功");
					}
				});
				panel.setParentCanvas(pw);
				panel.setParentWindow(pw);
				pw.addItem(panel);
				pw.setTitle("报销单打包");
				pw.setWidth100();
				pw.setHeight100();
				pw.centerInPage();
				pw.show();
			}
		});
		
		
		IButton doPackageBtn1 = PermissionControl.createPermissionButton("进行打包", ERPPermissionStatic.RP_ADD_PACKAGE);
		controlLayout.addMember(doPackageBtn1);
		doPackageBtn1.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				PopupWindow pw = new PopupWindow();
				pw.setWidth100();
				pw.setHeight100();
				DoReimbursementpackagePanel panel = new DoReimbursementpackagePanel();
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
				pw.setTitle("报销单打包");
				pw.setWidth100();
				pw.setHeight100();
				pw.centerInPage();
				pw.show();
			}
		});
		
		IButton printBtn = new IButton("打印");
		controlLayout.addMember(printBtn);
		printBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(!resultGrid.anySelected()){
					SC.say("请选择一条数据");
					return;
				}
				getPrintDataToHtml(resultGrid.getSelectedRecord());
			}
		});
		
		IButton exportBtn = new IButton("导出");
		controlLayout.addMember(exportBtn);
		exportBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(!resultGrid.anySelected()){
					SC.say("请选择一条数据");
					return;
				}
				Map<String, Object> params = new HashMap<>();
				int packageId = resultGrid.getSelectedRecord().getAttributeAsInt("reimbursementPackageId");
				params.put("packageId", packageId);
				DBDataSource.downloadFile("DW_ReimbursementPackageProcessor", params);
			}
		});
		
		commonQuery();
	}
	
	/**
	 * 
	 * @Title: getPrintDataToHtml 
	 * @Description: 获取打印数据并且根据打印数据创建出打印HTML进行打印
	 * @param @param record   
	 * @return void   
	 * @throws
	 */
	public void getPrintDataToHtml(Record record){
		printMap.clear();
		final int packageId = record.getAttributeAsInt("reimbursementPackageId");
		Map<String, Object> condition = new HashMap<>();
		condition.put("packageId", packageId);
		condition.put("opt_type", "getPackageDetailById");
		DBDataSource.callOperation("EP_ReimbursementPackageProcessor", condition, new DSCallback() {
			
			@SuppressWarnings("unchecked")
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					Record[] tmpData = dsResponse.getData();
					printMap.putAll(tmpData[0].toMap());
					getReimbursements(condition);
				}else{
					ClientUtil.displayErrorMessage(dsResponse);
				}
				
			}
		});
	}
	
	/**
	 * 
	 * @Title: getReimbursements 
	 * @Description: 获取4张表所有的报销单
	 * @param @param condition   
	 * @return void   
	 * @throws
	 */
	public void getReimbursements(Map<String, Object> condition){
		condition.put("opt_type", "getReimbursementsByPacakgeId");
		DBDataSource.callOperation("EP_ReimbursementPackageProcessor", condition, new DSCallback() {
			
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					Record[] tmpData = dsResponse.getData();
					printMap.put("topData", tmpData);
					getSubjectData(condition);
				}else{
					ClientUtil.displayErrorMessage(dsResponse);
				}
				
			}
		});
	}
	
	/**
	 * 
	 * @Title: getSubjectData 
	 * @Description: 获取所有的汇总合并科目数据
	 * @param @param condition   
	 * @return void   
	 * @throws
	 */
	public void getSubjectData(Map<String, Object> condition){
		condition.put("opt_type", "getSubjectByPackageId");
		DBDataSource.callOperation("EP_ReimbursementPackageProcessor", condition, new DSCallback() {
			
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					Record[] tmpData = dsResponse.getData();
					printMap.put("centerData", tmpData);
					getPaymentInfo(condition);
				}else{
					ClientUtil.displayErrorMessage(dsResponse);
				}
				
			}
		});
	}
	
	/**
	 * 
	 * @Title: getPaymentInfo 
	 * @Description: 获取所有的付款合并信息数据
	 * @param @param condition   
	 * @return void   
	 * @throws
	 */
	public void getPaymentInfo(Map<String, Object> condition){
		condition.put("opt_type", "getPackageSummaryByPackageId");
		DBDataSource.callOperation("EP_ReimbursementPackageProcessor", condition, new DSCallback() {
			
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					Record[] tmpData = dsResponse.getData();
					printMap.put("bottomData", tmpData);
					SreimbursementpackagePrintPanel printHtml = new SreimbursementpackagePrintPanel();
					printHtml.setPrintData(printMap);
					Print.it(printHtml.generatePrintHTML());
				}else{
					ClientUtil.displayErrorMessage(dsResponse);
				}
				
			}
		});
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
				ListGridRecord selectRecord = resultGrid.getSelectedRecord();
				boolean isCompleted = selectRecord.getAttributeAsBoolean("isCompleted");
				
				boolean isTopUpdate = false;//顶部的修改标志
				boolean isBottomUpdate = false;//底部的修改标志
				
				//通过权限 角色来进行修改判断
				if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.RP_UPDATE_BLANCE)){
					isTopUpdate = true; 
				}
				if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.RP_ADD_PAYMENTINFO)
						|| ClientUtil.checkIsHavePermission(ERPPermissionStatic.RP_APPROVE_PROCESS)){
					isBottomUpdate = true;
				}
				
				//当打包的数据已经通过完成审批时  不准许任何修改  该判断权重最高
				if(isCompleted){
					isTopUpdate = false;
					isBottomUpdate = false;
				}
				PopupWindow pw = new PopupWindow();
				pw.setWidth100();
				pw.setHeight100();
				int packageId = selectRecord.getAttributeAsInt("reimbursementPackageId");
				Integer companyId = selectRecord.getAttributeAsInt("companyId");
				UpdateReimbursementpackagePanel panel = new UpdateReimbursementpackagePanel(packageId, isTopUpdate, isBottomUpdate, isCompleted, companyId);
				panel.setPackageId(packageId);
				panel.setFatherWindow(pw);
				panel.startEdit();
				panel.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						commonQuery();
						SC.say("提示", "操作成功");
					}
				});
				panel.setParentCanvas(pw);
				pw.addItem(panel);
				pw.setTitle("报销单打包详情");
				pw.setWidth100();
				pw.setHeight100();
				pw.centerInPage();
				pw.show();
				
			}
		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		//如果没有查询所有的权限 则加入默认角色去进行查询
		if(!ClientUtil.checkIsHavePermission(ERPPermissionStatic.RP_VIEW_ALL_DATA)){
			criteria.put("roleId", ClientUtil.getRoleId());
		}
		criteria.put("addtionalCondition", "order by reimbursement_package_id");
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new SreimbursementpackagemmrorSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSSreimbursementpackagemmror.getInstance();
	}
	
	
	
	@Override
	public ListGrid createChildGrid() {
		ListGrid grid = new ListGrid() {  
            @Override  
            protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {  
        		 if (record.getAttributeAsInt("payStatus") == 1) {  
        			 return "background-color: red!important;";
                 } else {  
                     return super.getCellCSSText(record, rowNum, colNum);  
                 }  
                
            }  
        };  
		return grid;
	}

	@Override
	public void setChildGridOption(ListGrid resultChildGrid) {
		resultChildGrid.setShowRowNumbers(true);
		resultChildGrid.setCanEdit(true);
		int index = 0;
		ListGridField [] fields = new ListGridField[12];
		fields[index] = new ListGridField("yurref");
		fields[index].setCanEdit(false);
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("dbtacc");
		fields[index].setCanEdit(false);
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("dbtbbk");
		fields[index].setCanEdit(false);
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("trsamt");
		fields[index].setCanEdit(false);
//		index ++;
//		fields[index] = new ListGridField("ccynbr");
//		fields[index].setCanEdit(false);
//		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("nusage");
		fields[index].addEditorExitHandler(new EditorExitHandler() {
			
			@Override
			public void onEditorExit(EditorExitEvent event) {
				Record record = event.getRecord();
				if(null != event.getNewValue()){
					record.setAttribute("nusage", event.getNewValue());
					updateNusageOrBusnar(record);
					
				}
				
			}
		});
		fields[index].setCanEdit(true);
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("busnar");
		fields[index].addEditorExitHandler(new EditorExitHandler() {
			
			@Override
			public void onEditorExit(EditorExitEvent event) {
				Record record = event.getRecord();
				if(null != event.getNewValue()){
					record.setAttribute("busnar", event.getNewValue());
					updateNusageOrBusnar(record);
				}
				
			}
		});
		fields[index].setCanEdit(true);
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("crtacc");
		fields[index].setCanEdit(false);
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("crtnam");
		fields[index].setCanEdit(false);
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("crtbnk");
		fields[index].setCanEdit(true);
		fields[index].setShowGridSummary(false);
		fields[index].addEditorExitHandler(new EditorExitHandler() {
			
			@Override
			public void onEditorExit(EditorExitEvent event) {
				Record record = event.getRecord();
				if(null != event.getNewValue()){
					record.setAttribute("crtbnk", event.getNewValue());
					updateNusageOrBusnar(record);
				}
				
			}
		});
		index ++;
		fields[index] = new ListGridField("crtpvc");
		fields[index].setCanEdit(false);
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("crtcty");
		fields[index].setCanEdit(false);
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("status");
		fields[index].setCanEdit(false);
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("payStatus");
		fields[index].setCanEdit(false);
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("payResult");
		fields[index].setCanEdit(false);
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("cperrorMsg");
		fields[index].setCanEdit(false);
		fields[index].setShowGridSummary(false);
		resultChildGrid.setFields(fields);
		resultChildGrid.setShowGridSummary(true);
	}
	
	

	@Override
	public Canvas[] getChildGridOptionCanvas() {
		Canvas [] canvas = new Canvas[3];
		IButton updateSummaryPaymentBtn = PermissionControl.createPermissionButton("补充付款数据", ERPPermissionStatic.RP_CMB_PAY);
		updateSummaryPaymentBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				PopupWindow pw = new PopupWindow();
				Record selectRecord = resultGrid.getSelectedRecord();
				int reimbursementPackageId = selectRecord.getAttributeAsInt("reimbursementPackageId");
				Integer companyId = selectRecord.getAttributeAsInt("companyId");
				Boolean isComplete = selectRecord.getAttributeAsBoolean("isCompleted");
				MakeBillBeforeUpdateSummaryPanel panel = new MakeBillBeforeUpdateSummaryPanel(isComplete, companyId);
				panel.setPackageId(reimbursementPackageId);
				panel.addDataEditedHandler(new DataEditedHandler() {
					
					@Override
					public void onDataEdited(DataEditEvent event) {
						pw.destroy();
						resultChildGrid.refreshData();
						
					}
				});
				panel.startEdit();
				pw.addItem(panel);
				pw.setTitle("付款详情数据");
				pw.setWidth("80%");
				pw.setHeight("60%");
				pw.centerInPage();
				pw.show();
				
			}
		});
		IButton makeBillBtn = PermissionControl.createPermissionButton("制单", ERPPermissionStatic.RP_CMB_PAY);
		makeBillBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Map<String, Object> params = new HashMap<>();
				int packageId = resultGrid.getSelectedRecord().getAttributeAsInt("reimbursementPackageId");
				params.put("opt_type", "viewMakeBill");
				params.put("packageId", packageId);
				DBDataSource.callOperation("EP_ReimbursementPackageProcessor", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0){
							resultChildGrid.refreshData();
							SC.say("操作成功");
						}else{
							ClientUtil.displayErrorMessage(dsResponse);
						}
					}
				});
				
			}
		});
		
		IButton cmbPayBtn = PermissionControl.createPermissionButton("招商在线付款", ERPPermissionStatic.RP_CMB_PAY);
		cmbPayBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				SC.ask("确认支付？确认后制单数据将提交到招商银行系统！", new BooleanCallback() {
					
					@Override
					public void execute(Boolean value) {
						if(null != value && value){
							Map<String, Object> params = new HashMap<>();
							int packageId = resultGrid.getSelectedRecord().getAttributeAsInt("reimbursementPackageId");
							params.put("opt_type", "cmbcPay");
							params.put("packageId", packageId);
							DBDataSource.callOperation("EP_ReimbursementPackageProcessor", params, new DSCallback() {
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if(dsResponse.getStatus() >= 0){
										resultChildGrid.refreshData();
										SC.say("操作成功");
									}else{
										ClientUtil.displayErrorMessage(dsResponse);
									}
								}
							});
						}
					}
				});
				
				
			}
		});
		canvas[0] = updateSummaryPaymentBtn;
		canvas[1] = makeBillBtn;
		canvas[2] = cmbPayBtn;
		return canvas;
	}

	@Override
	public DataSource getChildDataSource() {
		return DSMcmbcpaydetailcctyrrosoowwwppor.getInstance();
	}

	public void updateNusageOrBusnar(Record record) {
		Map<String, Object> condition = record.toMap();
		condition.put("opt_type", "updateNusageOrBusnar");
		DBDataSource.callOperation("EP_ReimbursementPackageProcessor", condition, new DSCallback() {
			
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() < 0){
					__LOGGER.info("错误！ " + dsResponse.getErrors().get("errorMsg"));
				}
				
			}
		});
	}
}
