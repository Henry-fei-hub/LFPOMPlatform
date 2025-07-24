package com.pomplatform.client.reimbursementinfo.panel;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.delicacy.client.MapUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.sprocessbilllistpppor.datasource.DSSprocessbilllistpppor;
import com.pomplatform.client.workflow.commonNormalReimbursement.datasource.DSProjectNormalReimbursementDetail;
import com.pomplatform.client.workflow.commonTravelReimbursement.datasource.DSTravelReimbursementDetail;
import com.pomplatform.client.workflow.datasource.DSEmployeeBorrowMoneyByWorkflow;
import com.pomplatform.client.workflow.datasource.DSPayMoneyManageOfWorkflow;
import com.pomplatform.client.workflow.panel.AddUpdateProcessBillListPanel;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class CompleteProcessBillListPanel extends AbstractWizadPage {

	private static final Logger __logger = Logger.getLogger("");
	private DSCallback __startLoadedDetail;
	private DSCallback __endLoadedDetail;
	private DelicacyListGrid grid = new DelicacyListGrid(true);
	private DelicacyListGrid viewGrid = new DelicacyListGrid(false);
	private AbstractWizadPage mainInfoPage;
	private Integer processType;
	private Integer businessId;
	private PopupWindow parent;
	private HLayout a;
	public boolean isFinance = false; //如果是财务出纳处理
	
  	//定义流程类型
  	public static final int PROCESS_TYPE_2 = 2;//项目日常报销
  	public static final int PROCESS_TYPE_3 = 3;//普通日常报销
  	public static final int PROCESS_TYPE_4 = 4;//项目差旅报销
  	public static final int PROCESS_TYPE_5 = 5;//普通差旅报销
  	public static final int PROCESS_TYPE_6 = 6;//借款申请
  	public static final int PROCESS_TYPE_7 = 7;//付款申请
  	public static final int PROCESS_TYPE_8 = 8;//前期项目日常报销
  	public static final int PROCESS_TYPE_9 = 9;//前期项目差旅报销
  	public static final int PROCESS_TYPE_10 = 10;//公司日常报销

	public CompleteProcessBillListPanel(String processName) {
		
	}
	public void init2(){
		
		__dataGrid = grid;
		VLayout v = new VLayout();
		a = new HLayout();
		a.setWidth100();
		a.setHeight("80%");
		a.addMember(viewGrid);
		HLayout normalReimbursementLinkDepartments = new HLayout();
		normalReimbursementLinkDepartments.setBorder("2px solid #808080");
		normalReimbursementLinkDepartments.setWidth100();
		normalReimbursementLinkDepartments.setHeight100();

		ListGridField[] fields = new ListGridField[12];
		int idx = 0;
		fields[idx] = new ListGridField("payFor");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("payeeName");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("selfBankName");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("selfBankAccount");
		fields[idx].setShowGridSummary(false);
		idx++;
		if(isFinance){
			fields[idx] = new ListGridField("otherName");
			fields[idx].setShowGridSummary(false);
			idx++;
			fields[idx] = new ListGridField("otherBankName");
			fields[idx].setShowGridSummary(false);
			idx++;
			fields[idx] = new ListGridField("otherBankAccount");
			fields[idx].setShowGridSummary(false);
			idx++;
		}
		fields[idx] = new ListGridField("payMoney");
		idx++;
		fields[idx] = new ListGridField("balanceAmount");
		idx++;
		fields[idx] = new ListGridField("remark");
		fields[idx].setShowGridSummary(false);
		grid.setHeaderHeight(60);
		if(isFinance){
			grid.setHeaderSpans(new HeaderSpan[] { new HeaderSpan("收款信息", new String[] { "payFor", "payeeName", "selfBankName", "selfBankAccount", 
					"payMoney", "balanceAmount", "otherName", "otherBankName", "otherBankAccount", "remark" }) });
		}else{
			grid.setHeaderSpans(new HeaderSpan[] { new HeaderSpan("收款信息", new String[] { "payFor", "payeeName", "selfBankName", "selfBankAccount", "payMoney", "balanceAmount", "remark" }) });

		}
		grid.setFields(fields);
		grid.setShowGridSummary(true);
		grid.setCanEdit(false);
		grid.setDataSource(DSSprocessbilllistpppor.getInstance());
		grid.setAutoFitFieldWidths(false);
		normalReimbursementLinkDepartments.addMember(grid);

		VLayout normalReimbursementLinkDepartmentsControls = new VLayout();
		normalReimbursementLinkDepartmentsControls.setHeight100();
		normalReimbursementLinkDepartmentsControls.setWidth(60);
		normalReimbursementLinkDepartmentsControls.setLayoutTopMargin(30);
		normalReimbursementLinkDepartmentsControls.setLayoutLeftMargin(5);
		normalReimbursementLinkDepartmentsControls.setLayoutRightMargin(5);
		normalReimbursementLinkDepartmentsControls.setMembersMargin(10);
		normalReimbursementLinkDepartments.addMember(normalReimbursementLinkDepartmentsControls);
		v.addMember(a);
		v.addMember(normalReimbursementLinkDepartments);
		addMember(v);
		
		
		IButton normalReimbursementLinkDepartmentsNewButton = new IButton("新增");
		normalReimbursementLinkDepartmentsNewButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
//				if (null != mainInfoPage) {
//					String errorMsg = "没有填写归属公司或者报销金额";
//					String __errorMsg = "报销金额必须大于0才能添加";
//					FormItem amountItem = mainInfoPage.findNamedItem("amount");
//					FormItem companyIdItem = mainInfoPage.findNamedItem("companyId");
//					if (null != amountItem && null != companyIdItem && null != amountItem.getValue()
//							&& null != companyIdItem.getValue()) {
						// 获取当前可以被分拆的金额总额
//						BigDecimal amount = new BigDecimal(amountItem.getValue().toString());
//						ListGridRecord[] records = grid.getRecords();
//						if (null != records) {
//							for (ListGridRecord record : records) {
//								if (null != record.getAttribute("payMoney")) {
//									amount = amount.subtract(new BigDecimal(record.getAttribute("payMoney")));
//								}
//							}
//						}
//						if (amount.compareTo(BigDecimal.ZERO) <= 0) {
//							SC.warn("提示", __errorMsg);
//							return;
//						}
						PopupWindow window = new PopupWindow();
						window.setWidth("30%");
						if(isFinance){
							window.setHeight("80%");
						}else{
						    window.setHeight("62%");
						}
						window.centerInPage();
						window.setTitle("新增收款信息");
						AddUpdateProcessBillListPanel panel = new AddUpdateProcessBillListPanel(
								false, isFinance,null);
						BigDecimal amount = null; 
						panel.startEdit(null, amount, false);
						panel.setParentWindow(window);
						panel.addDataEditedHandler(new DataEditedHandler() {
							@Override
							public void onDataEdited(DataEditEvent event) {
								Record record = event.getData();
								RecordList list = grid.getDataAsRecordList();
								list.add(record);
								grid.setData(list);
								grid.redraw();
							}
						});
						window.addItem(panel);
						window.show();
//					} else {
//						SC.warn("提示", errorMsg);
//					}
//				}
			}
		});
		IButton normalReimbursementLinkDepartmentsUpdateButton = new IButton("修改");
		normalReimbursementLinkDepartmentsUpdateButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
//				String errorMsg = "没有填写归属公司或者报销金额";
//				switch (processType) {
//				case 6://借款申请
//					errorMsg = "没有填写归属公司或借款金额";
//					break;
//				case 7://预付款申请
//					errorMsg = "没有填写归属公司或付款金额";
//					break;
//				}
//				if (null != mainInfoPage && null != grid.getSelectedRecord()) {
				if (null != grid.getSelectedRecord()) {
//					FormItem amountItem = mainInfoPage.findNamedItem("amount");
//					FormItem departmentItem = mainInfoPage.findNamedItem("departmentId");
//					FormItem companyIdItem = mainInfoPage.findNamedItem("companyId");
//					if(null != processType){
//						switch (processType) {
//							case 6://借款申请
//								amountItem = mainInfoPage.findNamedItem("borrowMoney");
//								break;
//							case 7://预付款申请
//								amountItem = mainInfoPage.findNamedItem("payAmount");
//								break;
//						}
//					}
//					if (null != amountItem && null != companyIdItem && null != amountItem.getValue()
//							&& null != companyIdItem.getValue()) {
						// 获取当前可以被分拆的金额总额
//						BigDecimal amount = new BigDecimal(amountItem.getValue().toString());
//						ListGridRecord[] records = grid.getRecords();
//						if (null != records) {
//							for (ListGridRecord record : records) {
//								if (null != record.getAttribute("payMoney")) {
//									amount = amount.subtract(new BigDecimal(record.getAttribute("payMoney")));
//								}
//							}
//						}
//						int companyId = BaseHelpUtils.getIntValue(companyIdItem.getValue());
						ListGridRecord selected = grid.getSelectedRecord();
						final int rowNo = grid.getRowNum(grid.getSelectedRecord());
						PopupWindow window = new PopupWindow();
						window.setWidth("30%");
						if(isFinance){
							window.setHeight("80%");
						}else{
						    window.setHeight("62%");
						}
						window.centerInPage();
						window.setTitle("修改收款信息");
						AddUpdateProcessBillListPanel panel = new AddUpdateProcessBillListPanel(
								true, isFinance,null);
						BigDecimal amount = null;
//						selected.setAttribute("leftAmount", amount);
						panel.startEdit(selected, amount, true);
						panel.setParentWindow(window);
						panel.addDataEditedHandler(new DataEditedHandler() {
							@Override
							public void onDataEdited(DataEditEvent event) {
								Record record = event.getData();
								RecordList list = grid.getDataAsRecordList();
								RecordList newList = new RecordList();
								int size = list.getLength();
								for (int i = 0; i < size; i++) {
									if (i == rowNo) {
										newList.add(record);
									} else {
										newList.add(list.get(i));
									}
								}
								grid.setData(newList);
								grid.redraw();
							}
						});
						window.addItem(panel);
						window.show();
//					} else {
//						SC.warn("提示", errorMsg);
//					}
				}
			}
		});
		IButton normalReimbursementLinkDepartmentsRemoveButton = new IButton("删除所有");
		normalReimbursementLinkDepartmentsRemoveButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				grid.setData(new RecordList());
			}
		});
		IButton submit = new IButton("提~♥~交");
		submit.setIcon("[SKIN]/actions/save.png");
		submit.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Map map = getValuesAsMap();
				map.put("optType", "completeInfo");
				map.put("processTypeId", getProcessType());
				map.put("businessId", getBusinessId());
				map.put("employeeId", ClientUtil.getUserId());
				DBDataSource.callOperation("EP_ReimbursementInfo", map, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus()>=0){
							parent.destroy();
						}else{
							SC.say(dsResponse.getErrors().get("errorMsg").toString());
						}
					}
				});
			}
		});
		normalReimbursementLinkDepartmentsControls.addMember(normalReimbursementLinkDepartmentsNewButton);
		normalReimbursementLinkDepartmentsControls.addMember(normalReimbursementLinkDepartmentsUpdateButton);
		normalReimbursementLinkDepartmentsControls.addMember(normalReimbursementLinkDepartmentsRemoveButton);
		normalReimbursementLinkDepartmentsControls.addMember(submit);
	}
	public void init(){
		switch (processType) {
		//日常报销
		case PROCESS_TYPE_2:
		case PROCESS_TYPE_3:
		case PROCESS_TYPE_8:
		case PROCESS_TYPE_10:
			viewGrid.setDataSource(DSProjectNormalReimbursementDetail.getInstance());
			break;
		//差旅报销
		case PROCESS_TYPE_4:
		case PROCESS_TYPE_5:
		case PROCESS_TYPE_9:
			viewGrid.setDataSource(DSTravelReimbursementDetail.getInstance());
			break;
		//借款
		case PROCESS_TYPE_6:
			viewGrid.setDataSource(DSEmployeeBorrowMoneyByWorkflow.getInstance());
			break;
		//预付款
		case PROCESS_TYPE_7:
			viewGrid.setDataSource(DSPayMoneyManageOfWorkflow.getInstance());
			break;
		default:
			break;
		}
		Map params = new HashMap<>();
		params.put("optType", "loadDetail");
		params.put("processTypeId", processType);
		params.put("businessId", businessId);
		DBDataSource.callOperation("EP_ReimbursementInfo", "loadDetail", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					viewGrid.setData(dsResponse.getData());
					viewGrid.redraw();
				}else{
					SC.say(dsResponse.getErrors().get("errorMsg").toString());
				}
			}
		});
		init2();
	}
	
	@Override
	public void startEdit() {
		if (getPageMode() != PAGE_MODE_UPDATE)
			return;
		reloadDetailTableData();
	}

	public void reloadDetailTableData() {
		Map condition = new HashMap();
		Record record = getRecord();
		condition.put("businessId", getBusinessId());
		condition.put("processType", getProcessType());
		condition.put("opt_type", "getBillListByBusinessidProcesstype");
		DBDataSource.callOperation("EP_CustomSprocessbilllistppporProcess", "getBillListByBusinessidProcesstype", condition, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					if (__startLoadedDetail != null)
						__startLoadedDetail.execute(dsResponse, data, dsRequest);
					grid.setData(dsResponse.getData());
					if (__endLoadedDetail != null)
						__endLoadedDetail.execute(dsResponse, data, dsRequest);
				}
			}
		});
	}

	@Override
	public boolean checkData() {
		for (ListGridRecord r : grid.getRecords()) {
			__logger.info(MapUtils.convertRecordToMap(grid.getDataSource(), r).toString());
		}
		return true;
	}

	@Override
	public Set<String> getItemNames() {
		Set<String> res = new HashSet<>();
		res.add("detailProcessBillListApply");
		return res;
	}

	@Override
	public boolean isTheValuesEmpty() {
		ListGridRecord[] rows = grid.getRecords();
		return rows == null || rows.length == 0;
	}

	@Override
	public Map getValuesAsMap() {
		Map param = new HashMap();
		ListGridRecord[] rows = grid.getRecords();
		MapUtils.convertRecordToMap(grid.getDataSource(), rows, param, "detailList");
		return param;
	}

	@Override
	public String getName() {
		return "";
	}

	public DSCallback getStartLoadedDetail() {
		return this.__startLoadedDetail;
	}

	public void setStartLoadedDetail(DSCallback value) {
		this.__startLoadedDetail = value;
	}

	public DSCallback getEndLoadedDetail() {
		return this.__endLoadedDetail;
	}

	public void setEndLoadedDetail(DSCallback value) {
		this.__endLoadedDetail = value;
	}

	public DelicacyListGrid getGrid() {
		return this.grid;
	}

	public void setGrid(DelicacyListGrid value) {
		this.grid = value;
	}

	public AbstractWizadPage getMainInfoPage() {
		return mainInfoPage;
	}

	public void setMainInfoPage(AbstractWizadPage mainInfoPage) {
		this.mainInfoPage = mainInfoPage;
	}

	public void reDrawGrid() {
		if (null != grid)
			this.grid.redraw();
	}

	public Integer getProcessType() {
		return processType;
	}

	public void setProcessType(Integer processType) {
		this.processType = processType;
	}

	public Integer getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Integer businessId) {
		this.businessId = businessId;
	}


	public PopupWindow getParent() {
		return parent;
	}


	public void setParent(PopupWindow parent) {
		this.parent = parent;
	}
	
}
