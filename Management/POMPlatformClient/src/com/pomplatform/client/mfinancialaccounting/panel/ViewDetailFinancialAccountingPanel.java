package com.pomplatform.client.mfinancialaccounting.panel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.mfinancialaccounting.datasource.DSMfinancialAccounting;
import com.pomplatform.client.preprojectnormalreimbursement.datasource.DSNormalReimbursementLinkMainProject;
import com.pomplatform.client.preprojecttravelreimbursement.datasource.DSTravelReimbursementLinkMainProject;
import com.pomplatform.client.sprocessbilllistpppor.datasource.DSSprocessbilllistpppor;
import com.pomplatform.client.sreimbursementpackagemmror.panel.UpdateReimbursementpackageSummaryPanel;
import com.pomplatform.client.workflow.commonNormalReimbursement.datasource.DSNormalReimbursementLinkDepartment;
import com.pomplatform.client.workflow.commonTravelReimbursement.datasource.DSTravelReimbursementDetail;
import com.pomplatform.client.workflow.commonTravelReimbursement.datasource.DSTravelReimbursementLinkDepartment;
import com.pomplatform.client.workflow.panel.AddUpdateProcessBillListPanel;
import com.pomplatform.client.workflow.projectNormalReimbursement.datasource.DSNormalReimbursementLinkProject;
import com.pomplatform.client.workflow.projectNormalReimbursement.datasource.DSProjectNormalReimbursementDetail;
import com.pomplatform.client.workflow.projectTravelReimbursement.datasource.DSTravelReimbursementLinkProject;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.viewer.DetailViewer;


public class ViewDetailFinancialAccountingPanel extends AbstractWizadPage implements HasHandlers{
	
//	private final UpdateReimbursementpackageSummaryPanel reimbursementpackageSummaryPanel;//
	/**
	 * 项目日常报销
	 */
	public static final int PROCESS_TYPE_2 = 2;
    /**
     * 普通日常报销
     */
  	public static final int PROCESS_TYPE_3 = 3;
  	/**
  	 * 项目差旅报销
  	 */
  	public static final int PROCESS_TYPE_4 = 4;
  	/**
  	 * 普通差旅报销
  	 */
  	public static final int PROCESS_TYPE_5 = 5;
  	/**
  	 * 借款申请
  	 */
  	public static final int PROCESS_TYPE_6 = 6;
  	/**
  	 * 预付款申请
  	 */
  	public static final int PROCESS_TYPE_7 = 7;
  	/**
  	 * 前期项目日常报销
  	 */
  	public static final int PROCESS_TYPE_8 = 8;
  	/**
  	 * 前期项目差旅报销
  	 */
  	public static final int PROCESS_TYPE_9 = 9;
  	/**
  	 * 公司日常报销
  	 */
  	public static final int PROCESS_TYPE_10 = 10;
	
    public final static String BORDER_STYLE = "1px solid gray";
    public final static String BACKGROUND_COLOR = "azure";
    public final static String BUTTON_BACKGROUND_COLOR = "azure";
    public final static String FORM_BORDER_STYLE = "1px solid #808080";
    
    public DelicacyListGrid topGrid = new DelicacyListGrid();
    public DelicacyListGrid middleGrid = new DelicacyListGrid();
    public DelicacyListGrid bottomGrid = new DelicacyListGrid();
    
	private static final Logger __LOGGER = Logger.getLogger("");
	
	public final Record mainRecord;
	public final int processType;
	
	private static DetailViewer view;  
	
	public ViewDetailFinancialAccountingPanel(Record record){
		this.mainRecord = record;
//		setBorder(BORDER_STYLE);
		setBackgroundColor(BACKGROUND_COLOR);
		VLayout mainLayout = new VLayout();
		
		HLayout allH = new HLayout();
		allH.setWidth100();
		allH.setHeight100();
		allH.setMargin(5);
		topGrid.setAutoFitFieldWidths(false);
		middleGrid.setAutoFitFieldWidths(false);
		bottomGrid.setAutoFitFieldWidths(false);
		//左边显示查看的数据
		view = new DetailViewer();
		view.setCanSelectText(true);
		view.setDataSource(DSMfinancialAccounting.getInstance());
		view.setData(new Record[]{record});
		
		VLayout leftLayout = new VLayout();//左边的表单
		leftLayout.setWidth("25%");
		leftLayout.setHeight100();
		leftLayout.addMember(view);
		
		VLayout rightLayout = new VLayout();//右边详情与汇总的面板
		rightLayout.setWidth("75%");
		rightLayout.setHeight100();
		
		boolean bePacked = record.getAttributeAsBoolean("bePacked");
		processType = record.getAttributeAsInt("processType");
		//设置账单流水的DataSource
		bottomGrid.setDataSource(DSSprocessbilllistpppor.getInstance());
		//根据不同报销设置不同的DataSource
		switch (processType) {
		//日常报销
		case PROCESS_TYPE_2:
			topGrid.setDataSource(DSProjectNormalReimbursementDetail.getInstance());
			middleGrid.setDataSource(DSNormalReimbursementLinkProject.getInstance());
			break;
		case PROCESS_TYPE_3:
			topGrid.setDataSource(DSProjectNormalReimbursementDetail.getInstance());
			middleGrid.setDataSource(DSNormalReimbursementLinkDepartment.getInstance());
			break;
		case PROCESS_TYPE_8:
			topGrid.setDataSource(DSProjectNormalReimbursementDetail.getInstance());
			middleGrid.setDataSource(DSNormalReimbursementLinkMainProject.getInstance());
			break;
		case PROCESS_TYPE_10:
			topGrid.setDataSource(DSProjectNormalReimbursementDetail.getInstance());
			middleGrid.setDataSource(DSNormalReimbursementLinkDepartment.getInstance());
			break;
		//差旅报销
		case PROCESS_TYPE_4:
			topGrid.setDataSource(DSTravelReimbursementDetail.getInstance());
			middleGrid.setDataSource(DSTravelReimbursementLinkProject.getInstance());
			break;
		case PROCESS_TYPE_5:
			topGrid.setDataSource(DSTravelReimbursementDetail.getInstance());
			middleGrid.setDataSource(DSTravelReimbursementLinkDepartment.getInstance());
			break;
		case PROCESS_TYPE_9:
			topGrid.setDataSource(DSTravelReimbursementDetail.getInstance());
			middleGrid.setDataSource(DSTravelReimbursementLinkMainProject.getInstance());
			rightLayout.addMember(topGrid);
			break;
		//借款申请
		case PROCESS_TYPE_6:
		//预付款申请	
		case PROCESS_TYPE_7:
			break;
		default:
			break;
		}
		if(processType != PROCESS_TYPE_6 && processType != PROCESS_TYPE_7){
			rightLayout.addMember(topGrid);
			rightLayout.addMember(middleGrid);
		}
		rightLayout.addMember(bottomGrid);
		
		IButton updateBtn = new IButton("修改付款信息");
		updateBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(!bottomGrid.anySelected()){
					SC.say("请选一条收款信息");
				}
				ListGridRecord selected = bottomGrid.getSelectedRecord();
				final int rowNo = bottomGrid.getRowNum(bottomGrid.getSelectedRecord());
				PopupWindow window = new PopupWindow();
				window.setWidth("30%");
				window.setHeight("80%");
				window.centerInPage();
				window.setTitle("修改收款信息");
				AddUpdateProcessBillListPanel panel = new AddUpdateProcessBillListPanel(
						true, true, processType,budgetRecord);
				selected.setAttribute("leftAmount", record.getAttribute("amount"));
				panel.startEdit(selected, new BigDecimal(record.getAttribute("amount")), true);
				panel.setParentWindow(window);
				panel.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						Record record = event.getData();
						RecordList list = bottomGrid.getDataAsRecordList();
						RecordList newList = new RecordList();
						int size = list.getLength();
						for (int i = 0; i < size; i++) {
							if(6 == processType || 7 == processType){
								record.setAttribute("balanceAmount", BigDecimal.ZERO);
							}
							if (i == rowNo) {
								newList.add(record);
							} else {
								newList.add(list.get(i));
							}
						}
						bottomGrid.setData(newList);
						bottomGrid.redraw();
					}
				});
				window.addItem(panel);
				window.show();
			}
		});
		IButton confirmBtn = new IButton("确认修改");
		confirmBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(checkData()){
					SC.confirm("确认修改", new BooleanCallback() {
						
						@Override
						public void execute(Boolean value) {
							if(value){
								Map<String, Object> params = new HashMap<>();
								params.put("records", bottomGrid.getRecords());
								params.put("opt_type", "updateProcessBillList");
								params.put("processType", processType);
								DBDataSource.callOperation("EP_CustomMfinancialAccountingProcess", params, new DSCallback() {
									@Override
									public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
										if(dsResponse.getStatus() > 0){
											getFatherWindow().destroy();
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
				}
			}
		});
		if(!bePacked){
			HLayout btnLayout = new HLayout();
			btnLayout.setMembersMargin(10);
			btnLayout.setPadding(5);
			btnLayout.setAlign(Alignment.RIGHT);
			btnLayout.setHeight("40");
			btnLayout.setWidth100();
			btnLayout.addMember(updateBtn);
			btnLayout.addMember(confirmBtn);
			rightLayout.addMember(btnLayout);
		}
		
//		reimbursementpackageSummaryPanel= new UpdateReimbursementpackageSummaryPanel(bottomUpdate);
//		reimbursementpackageSummaryPanel.setPackageId(packageId);
//		reimbursementpackageSummaryPanel.setHeight("34%");
//		rightLayout.addMember(reimbursementpackageSummaryPanel);
//		reimbursementpackageSummaryPanel.startEdit();
//		reimbursementpackageSummaryPanel.addDataEditedHandler(new DataEditedHandler() {
//			
//			@Override
//			public void onDataEdited(DataEditEvent event) {
//				getFatherWindow().destroy();
//				DataEditEvent dee = new DataEditEvent();
//                fireEvent(dee);
//			}
//		});
		
		allH.addMember(leftLayout);
		allH.addMember(rightLayout);
		mainLayout.addMember(allH);
		addMember(mainLayout);
	}

	@Override
	public Map getValuesAsMap() {
		return null;
	}

	@Override
	public boolean checkData() {
		boolean flag = true;
		ListGridRecord [] records = bottomGrid.getRecords();
		if(records.length > 0){
			if (null != records) {
				BigDecimal amount = new BigDecimal(mainRecord.getAttribute("amount"));
				BigDecimal payMoney = BigDecimal.ZERO;
				BigDecimal blanceMoney = BigDecimal.ZERO;
				for (Record record : records) {
					if (null != record.getAttribute("payMoney")) {
						payMoney = payMoney.add(new BigDecimal(record.getAttributeAsString("payMoney")));
					}
					if (null != record.getAttribute("balanceAmount")){
						blanceMoney = blanceMoney.add(new BigDecimal(record.getAttributeAsString("balanceAmount")));
					}
				}
				if(amount.compareTo(payMoney.add(blanceMoney)) != 0){
					flag = false;
					StringBuilder sb = new StringBuilder();
					sb.append("申请金额[")
						.append(BaseHelpUtils.format(amount, 2))
						.append("]与收款信息中的(付款金额[")
						.append(BaseHelpUtils.format(payMoney, 2))
						.append("]");;
						if(6 != processType && 7 != processType){
							sb.append(" + 冲账金额[")
							.append(BaseHelpUtils.format(blanceMoney, 2))
							.append("]");
						}
						sb.append(")的总和不相等,清进行核对后再提交");
					SC.say(sb.toString());
				}
			}
		}else{
			flag = false;
			SC.say("请添加收款信息！");
		}
//		for (ListGridRecord r : grid.getRecords()) {
//			__logger.info(MapUtils.convertRecordToMap(grid.getDataSource(), r).toString());
//		}
		return flag;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void startEdit() {
		Map params = this.mainRecord.toMap();
		if(processType != PROCESS_TYPE_6 && processType != PROCESS_TYPE_7){
			params.put("opt_type", "getBusinessDataByProcessData");
			DBDataSource.callOperation("EP_CustomMfinancialAccountingProcess", params, new DSCallback() {
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					if(dsResponse.getStatus() > 0){
						middleGrid.setData(dsResponse.getData());
					}else{
//						ClientUtil.displayErrorMessage(dsResponse);
					}
				}
			});
			params.put("opt_type", "getBusinessDetailByProcessData");
			DBDataSource.callOperation("EP_CustomMfinancialAccountingProcess", params, new DSCallback() {
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					if(dsResponse.getStatus() > 0){
						topGrid.setData(dsResponse.getData());
					}else{
//						ClientUtil.displayErrorMessage(dsResponse);
					}
				}
			});
		}
		params.put("opt_type", "getBillListByReimbursement");
		DBDataSource.callOperation("EP_ReimbursementPackageProcessor", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() > 0){
					bottomGrid.setData(dsResponse.getData());
				}else{
//					ClientUtil.displayErrorMessage(dsResponse);
				}
			}
		});
	}
	
	private Window fatherWindow;

	public Window getFatherWindow() {
		return fatherWindow;
	}

	public void setFatherWindow(Window fatherWindow) {
		this.fatherWindow = fatherWindow;
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
    
    private  Record budgetRecord;

	public Record getBudgetRecord() {
		return budgetRecord;
	}

	public void setBudgetRecord(Record budgetRecord) {
		this.budgetRecord = budgetRecord;
	}
}
