package com.pomplatform.client.sreimbursementpackagemmror.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.sreimbursementpackagesummaryrror.datasource.DSSreimbursementpackagesummaryrror;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class UpdateReimbursementpackageSummaryPanel extends AbstractWizadPage implements HasHandlers {

	private static final Logger __LOGGER = Logger.getLogger("");

	private Integer packageId;

	public final static String BORDER_STYLE = "1px solid #ABABAB";
	public final static String BACKGROUND_COLOR = "azure";
	public final static String BUTTON_BACKGROUND_COLOR = "azure";
	public final static String FORM_BORDER_STYLE = "1px solid #808080";


	public final ListGrid sourceGrid = new ListGrid();
	
	public UpdateReimbursementpackageSummaryPanel(boolean isUpdate, boolean isCompleted, Integer companyId) {
		setBorder(BORDER_STYLE);
		int idx = 0;
		ListGridField[] fields = new ListGridField[4];
		fields[idx] = new ListGridField("payeeName");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("selfBankName");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("selfBankAccount");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("paymentAmount");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("strikeABalanceAmount");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("otherName");
		fields[idx].setShowGridSummary(false);
		fields[idx].setRequired(Boolean.TRUE);
		idx++;
		fields[idx] = new ListGridField("otherBankName");
		fields[idx].setCanEdit(false);
		fields[idx].setShowGridSummary(false);
		fields[idx].setRequired(Boolean.TRUE);
		idx++;
		fields[idx] = new ListGridField("otherBankAccount");
		fields[idx].setCanEdit(isUpdate);
		fields[idx].setShowGridSummary(false);
		fields[idx].setRequired(Boolean.TRUE);
		sourceGrid.setFields(fields);
		sourceGrid.setSaveLocally(true);
		sourceGrid.setShowRowNumbers(true);
		sourceGrid.setSelectionAppearance(SelectionAppearance.ROW_STYLE);
		sourceGrid.setDataSource(DSSreimbursementpackagesummaryrror.getInstance());
		sourceGrid.setShowGridSummary(true);
		sourceGrid.setSelectionType(SelectionStyle.SINGLE);
		sourceGrid.setCanEdit(false);
		sourceGrid.setCanSelectText(true);
		sourceGrid.setCanDragSelectText(true);
		sourceGrid.setHeaderHeight(60);
		sourceGrid.setHeaderSpans(new HeaderSpan[] { new HeaderSpan("汇总信息", new String[] { "payeeName", "selfBankName", "selfBankAccount", "paymentAmount", 
					"strikeABalanceAmount", "otherName", "otherBankName", "otherBankAccount"}) });
		
		if(isUpdate && ClientUtil.checkIsHavePermission(ERPPermissionStatic.RP_ADD_PAYMENTINFO)){
			sourceGrid.addDoubleClickHandler(new DoubleClickHandler() {
				
				@Override
				public void onDoubleClick(DoubleClickEvent event) {
					addPaymentInfo(true, companyId);
				}
			});
		}
		
		IButton updateAllBtn = PermissionControl.createPermissionButton("统一补充", ERPPermissionStatic.RP_ADD_PAYMENTINFO);
		updateAllBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				addPaymentInfo(false, companyId);
			}
		});
		
		IButton updateBtn = PermissionControl.createPermissionButton("付款补充", ERPPermissionStatic.RP_ADD_PAYMENTINFO);
		updateBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				addPaymentInfo(true, companyId);
			}
		});
		
		IButton updateSummaryPaymentInfoBtn = PermissionControl.createPermissionButton("保存修改", ERPPermissionStatic.RP_ADD_PAYMENTINFO);
		updateSummaryPaymentInfoBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(checkData()){
					SC.confirm("确认保存修改?", new BooleanCallback() {
						
						@Override
						public void execute(Boolean value) {
							if(value){
								ListGridRecord [] records = sourceGrid.getRecords();
								Map<String, Object> params = new HashMap<>();
								params.put("opt_type", "updateSummaryPaymentInfo");
								params.put("records", records);
								params.put("employeeId", ClientUtil.getEmployeeId());
								params.put("packageId", getPackageId());
								DBDataSource.callOperation("EP_ReimbursementPackageProcessor", params, new DSCallback() {
									@Override
									public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
										if(dsResponse.getStatus() > 0){
											SC.say("保存修改成功");
										}else{
											ClientUtil.displayErrorMessage(dsResponse);
										}
									}
								});
							}
							
						}
					});
				}else{
					SC.say("请补充好付款方信息！！！");
				}
				
			}
		});
		
		IButton completedUpdateBtn = PermissionControl.createPermissionButton("保存修改", ERPPermissionStatic.RP_UPDATE_COMPLETE);
		completedUpdateBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(checkData()){
					SC.confirm("确认修改?", new BooleanCallback() {
						
						@Override
						public void execute(Boolean value) {
							if(value){
								ListGridRecord [] records = sourceGrid.getRecords();
								Map<String, Object> params = new HashMap<>();
								params.put("opt_type", "completedUpdateSummary");
								params.put("records", records);
								params.put("employeeId", ClientUtil.getEmployeeId());
								params.put("packageId", getPackageId());
								DBDataSource.callOperation("EP_ReimbursementPackageProcessor", params, new DSCallback() {
									@Override
									public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
										if(dsResponse.getStatus() > 0){
											DataEditEvent dee = new DataEditEvent();
				                            fireEvent(dee);
										}else{
											ClientUtil.displayErrorMessage(dsResponse);
										}
									}
								});
							}
							
						}
					});
				}else{
					SC.say("请补充好付款方信息！！！");
				}
				
			}
		});
		
		IButton submitBtn = PermissionControl.createPermissionButton("通过审核", ERPPermissionStatic.RP_APPROVE_PROCESS);
		submitBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(checkData()){
					SC.confirm("确认通过审核?", new BooleanCallback() {
						
						@Override
						public void execute(Boolean value) {
							if(value){
								ListGridRecord [] records = sourceGrid.getRecords();
								Map<String, Object> params = new HashMap<>();
								params.put("opt_type", "submitPackage");
								params.put("records", records);
								params.put("employeeId", ClientUtil.getEmployeeId());
								params.put("packageId", getPackageId());
								DBDataSource.callOperation("EP_ReimbursementPackageProcessor", "submitPackage", params, new DSCallback() {
									@Override
									public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
										if(dsResponse.getStatus() > 0){
											DataEditEvent dee = new DataEditEvent();
				                            fireEvent(dee);
										}else{
											ClientUtil.displayErrorMessage(dsResponse);
										}
									}
								});
							}
							
						}
					});
				}else{
					SC.say("请补充好付款方信息！！！");
				}
				
			}
		});
		
		IButton makeBillBtn = PermissionControl.createPermissionButton("制单与查看", ERPPermissionStatic.RP_CMB_PAY);
		makeBillBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Map<String, Object> params = new HashMap<>();
				int packageId = getPackageId();
				params.put("opt_type", "viewMakeBill");
				params.put("packageId", packageId);
				DBDataSource.callOperation("EP_ReimbursementPackageProcessor", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0){
							PopupWindow pw = new PopupWindow();
							ViewPackageBillPanel panel = new ViewPackageBillPanel();
							panel.setPackageId(packageId);
							panel.startEdit();
							pw.addItem(panel);
							pw.setTitle("制单详情");
							pw.setWidth100();
							pw.setHeight100();
							pw.centerInPage();
							pw.show();
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
							int packageId = getPackageId();
							params.put("opt_type", "cmbcPay");
							params.put("packageId", packageId);
							DBDataSource.callOperation("EP_ReimbursementPackageProcessor", params, new DSCallback() {
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if(dsResponse.getStatus() >= 0){
										//进入查看支付结果的界面
										PopupWindow pw = new PopupWindow();
										MreimbursementpackagesummarycrtpporPanel panel = new MreimbursementpackagesummarycrtpporPanel();
										panel.setPackageId(packageId);
										panel.commonQuery();
										pw.addItem(panel);
										pw.setTitle("支付详情");
										pw.setWidth100();
										pw.setHeight100();
										pw.centerInPage();
										pw.show();
										
										
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
		
		IButton viewPayBtn = PermissionControl.createPermissionButton("查看支付结果", ERPPermissionStatic.RP_CMB_PAY);
		viewPayBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				PopupWindow pw = new PopupWindow();
				MreimbursementpackagesummarycrtpporPanel panel = new MreimbursementpackagesummarycrtpporPanel();
				panel.setPackageId(packageId);
				panel.commonQuery();
				pw.addItem(panel);
				pw.setTitle("支付结果详情");
				pw.setWidth100();
				pw.setHeight100();
				pw.centerInPage();
				pw.show();
				
			}
		});
		
		//画框框 布局。。。
		VLayout mainLayout = new VLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		mainLayout.addMember(sourceGrid);
		if(isUpdate){
			HLayout btnLayout = new HLayout();
			btnLayout.setMembersMargin(10);
			btnLayout.setPadding(5);
			btnLayout.setAlign(Alignment.RIGHT);
			btnLayout.setHeight("40");
			btnLayout.setWidth100();
			btnLayout.addMember(viewPayBtn);
			btnLayout.addMember(makeBillBtn);
			btnLayout.addMember(cmbPayBtn);
			
			
			btnLayout.addMember(updateAllBtn);
			btnLayout.addMember(updateBtn);
			btnLayout.addMember(updateSummaryPaymentInfoBtn);
			btnLayout.addMember(submitBtn);
			mainLayout.addMember(btnLayout);
		} else if (isCompleted && ClientUtil.checkIsHavePermission(ERPPermissionStatic.RP_UPDATE_COMPLETE)){
			HLayout btnLayout = new HLayout();
			btnLayout.setMembersMargin(10);
			btnLayout.setPadding(5);
			btnLayout.setAlign(Alignment.RIGHT);
			btnLayout.setHeight("40");
			btnLayout.setWidth100();
			btnLayout.addMember(viewPayBtn);
			btnLayout.addMember(makeBillBtn);
			btnLayout.addMember(cmbPayBtn);
			
			updateAllBtn.show();
			btnLayout.addMember(updateAllBtn);
			updateBtn.show();
			btnLayout.addMember(updateBtn);
			btnLayout.addMember(completedUpdateBtn);
			mainLayout.addMember(btnLayout);
		}
		addMember(mainLayout);
	}

	/**
	 * 
	 * @Title: addPaymentInfo 
	 * @Description: 添加付款方信息
	 * @param    
	 * @return void   
	 * @throws
	 */
	public void addPaymentInfo(boolean isOnlyOne, Integer companyId){
		if(isOnlyOne){
			if(sourceGrid.anySelected()){
				ListGridRecord selected = sourceGrid.getSelectedRecord();
				final int rowNo = sourceGrid.getRowNum(sourceGrid.getSelectedRecord());
				PopupWindow window = new PopupWindow();
				window.setWidth("30%");
				window.setHeight("70%");
				window.centerInPage();
				window.setTitle("补充付款方信息");
				UpdatePaymentInfoPanel panel = new UpdatePaymentInfoPanel(isOnlyOne, companyId);
				panel.startEdit(selected);
				panel.setDefaultValue(companyId);
				panel.setParentWindow(window);
				panel.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						Record record = event.getData();
						RecordList list = sourceGrid.getDataAsRecordList();
						RecordList newList = new RecordList();
						int size = list.getLength();
						for (int i = 0; i < size; i++) {
							if (i == rowNo) {
								Record __record = list.get(i);
								__record.setAttribute("otherName", record.getAttribute("otherName"));
								__record.setAttribute("otherBankName", record.getAttribute("otherBankName"));
								__record.setAttribute("otherBankAccount", record.getAttribute("otherBankAccount"));
								newList.add(__record);
							} else {
								newList.add(list.get(i));
							}
						}
						sourceGrid.setData(newList);
						sourceGrid.redraw();
					}
				});
				window.addItem(panel);
				window.show();
			}else{
				SC.say("请选择一条数据进行修改！");
			}
		}else{
			PopupWindow window = new PopupWindow();
			window.setWidth("30%");
			window.setHeight("50%");
			window.centerInPage();
			window.setTitle("补充付款方信息");
			UpdatePaymentInfoPanel panel = new UpdatePaymentInfoPanel(isOnlyOne, companyId);
			panel.setDefaultValue(companyId);
			panel.setParentWindow(window);
			panel.addDataEditedHandler(new DataEditedHandler() {
				@Override
				public void onDataEdited(DataEditEvent event) {
					Record record = event.getData();
					RecordList list = sourceGrid.getDataAsRecordList();
					RecordList newList = new RecordList();
					int size = list.getLength();
					for (int i = 0; i < size; i++) {
						Record __record = list.get(i);
						__record.setAttribute("otherName", record.getAttribute("otherName"));
						__record.setAttribute("otherBankName", record.getAttribute("otherBankName"));
						__record.setAttribute("otherBankAccount", record.getAttribute("otherBankAccount"));
						newList.add(__record);
					}
					sourceGrid.setData(newList);
					sourceGrid.redraw();
				}
			});
			window.addItem(panel);
			window.show();
		}
	}
	
	
	@Override
	public Map getValuesAsMap() {
		return null;
	}

	@Override
	public boolean checkData() {
		boolean flag = true;
		ListGridRecord [] record = sourceGrid.getRecords();
		for (ListGridRecord listGridRecord : record) {
			int index =sourceGrid.getRowNum(listGridRecord);
			if(!sourceGrid.validateRow(index)){
				flag = false;
				break;
			}
		}
		return flag;
	}

	@Override
	public void startEdit() {
		Map<String, Object> params = new HashMap<>();
		params.put("opt_type", "getPackageSummaryByPackageId");
		params.put("packageId", getPackageId());
		DBDataSource.callOperation("EP_ReimbursementPackageProcessor", "getPackageSummaryByPackageId", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() > 0){
					sourceGrid.setData(dsResponse.getData());
				}else{
					ClientUtil.displayErrorMessage(dsResponse);
				}
			}
		});
	}

	public DSSreimbursementpackagesummaryrror getDataSource() {
		return DSSreimbursementpackagesummaryrror.getInstance();
	}

	public Integer getPackageId() {
		return packageId;
	}

	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}
	
	protected final HandlerManager handlerManager = new HandlerManager(this);
    protected final List<DataEditedHandler> __dataEditedHandler = new ArrayList<>();

    @Override
    public void fireEvent(GwtEvent<?> event) {
        handlerManager.fireEvent(event);
    }

    public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
        return handlerManager.addHandler(DataEditEvent.TYPE, handler);
    }
}
