package com.pomplatform.client.workflow.panel;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.sprocessbilllistpppor.datasource.DSSprocessbilllistpppor;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class ProcessBillListApplyPanel extends AbstractWizadPage {

	private static final Logger __logger = Logger.getLogger("");
	private DSCallback __startLoadedDetail;
	private DSCallback __endLoadedDetail;
	private DelicacyListGrid grid = new DelicacyListGrid(true);
	private AbstractWizadPage mainInfoPage;
	private Integer processType;
	public boolean isFinance = false; // 如果是财务出纳处理
	private Record initData;
	private String tempDate = "工资发放总表";

	// 定义流程类型
	public static final int PROCESS_TYPE_2 = 2;// 项目日常报销
	public static final int PROCESS_TYPE_3 = 3;// 普通日常报销
	public static final int PROCESS_TYPE_4 = 4;// 项目差旅报销
	public static final int PROCESS_TYPE_5 = 5;// 普通差旅报销
	public static final int PROCESS_TYPE_6 = 6;// 借款申请
	public static final int PROCESS_TYPE_7 = 7;// 付款申请
	public static final int PROCESS_TYPE_8 = 8;// 前期项目日常报销
	public static final int PROCESS_TYPE_9 = 9;// 前期项目差旅报销
	public static final int PROCESS_TYPE_10 = 10;// 公司日常报销

	public ProcessBillListApplyPanel(String processName) {
		if (!BaseHelpUtils.isNullOrEmpty(processName) && processName.contains("出纳")) {
			isFinance = true;
		}

		__dataGrid = grid;
		
		HLayout normalReimbursementLinkDepartments = new HLayout();
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
		if (isFinance) {
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
		idx++;
		fields[idx] = new ListGridField("employeeFundIssuanceId");
		fields[idx].setHidden(true);
		grid.setHeaderHeight(60);
		if (isFinance) {
			grid.setHeaderSpans(new HeaderSpan[] { new HeaderSpan("收款信息(申请金额= 付款金额(实付金额) + 冲账金额)",
					new String[] { "payFor", "payeeName", "selfBankName", "selfBankAccount", "payMoney",
							"balanceAmount", "otherName", "otherBankName", "otherBankAccount", "remark" }) });
		} else {
			grid.setHeaderSpans(
					new HeaderSpan[] { new HeaderSpan("收款信息(申请金额= 付款金额(实付金额) + 冲账金额)", new String[] { "payFor",
							"payeeName", "selfBankName", "selfBankAccount", "payMoney", "balanceAmount", "remark" }) });

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
		addMember(normalReimbursementLinkDepartments);
		IButton normalReimbursementLinkDepartmentsNewButton = new IButton("新增");
		normalReimbursementLinkDepartmentsNewButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (null != mainInfoPage) {
					String errorMsg = "没有填写归属公司或者报销金额";
					String __errorMsg = "报销金额必须大于0才能添加";
					// switch (processType) {
					// case 6://借款申请
					// errorMsg = "没有填写归属公司或借款金额";
					// __errorMsg = "借款金额必须大于0才能添加";
					// break;
					// case 7://预付款申请
					// errorMsg = "没有填写归属公司或付款金额";
					// __errorMsg = "付款金额必须大于0才能添加";
					// break;
					// }
					FormItem amountItem = mainInfoPage.findNamedItem("amount");
					FormItem companyIdItem = mainInfoPage.findNamedItem("companyId");
					// if(null != processType){
					// switch (processType) {
					// case 6://借款申请
					// amountItem = mainInfoPage.findNamedItem("borrowMoney");
					// break;
					// case 7://预付款申请
					// amountItem = mainInfoPage.findNamedItem("payAmount");
					// break;
					// }
					// }
					if (null != amountItem && null != companyIdItem && null != amountItem.getValue()
							&& null != companyIdItem.getValue()) {
						// 获取当前可以被分拆的金额总额
						BigDecimal amount = new BigDecimal(amountItem.getValue().toString());
						ListGridRecord[] records = grid.getRecords();
						if (null != records) {
							for (ListGridRecord record : records) {
								if (null != record.getAttribute("payMoney")) {
									amount = amount.subtract(new BigDecimal(record.getAttribute("payMoney")));
								}
							}
						}
						if (amount.compareTo(BigDecimal.ZERO) <= 0) {
							SC.warn("提示", __errorMsg);
							return;
						}
						PopupWindow window = new PopupWindow();
						window.setWidth("30%");
						if (isFinance) {
							window.setHeight("80%");
						} else {
							window.setHeight("62%");
						}
						window.centerInPage();
						window.setTitle("新增收款信息");
						AddUpdateProcessBillListPanel panel = new AddUpdateProcessBillListPanel(false, isFinance,budgetRecord);
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
					} else {
						SC.warn("提示", errorMsg);
					}
				}
			}
		});
		IButton normalReimbursementLinkDepartmentsUpdateButton = new IButton("修改");
		normalReimbursementLinkDepartmentsUpdateButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				String errorMsg = "没有填写归属公司或者报销金额";
				if (null != processType) {
					switch (processType) {
					case 6:// 借款申请
						errorMsg = "没有填写归属公司或借款金额";
						break;
					case 7:// 预付款申请
						errorMsg = "没有填写归属公司或付款金额";
						break;
					}
				}
				if (null != mainInfoPage && null != grid.getSelectedRecord()) {
					FormItem amountItem = mainInfoPage.findNamedItem("amount");
					// FormItem departmentItem =
					// mainInfoPage.findNamedItem("departmentId");
					FormItem companyIdItem = mainInfoPage.findNamedItem("companyId");
					if (null != processType) {
						switch (processType) {
						case 6:// 借款申请
							amountItem = mainInfoPage.findNamedItem("borrowMoney");
							break;
						case 7:// 预付款申请
							amountItem = mainInfoPage.findNamedItem("payAmount");
							break;
						}
					}
					if (null != amountItem && null != companyIdItem && null != amountItem.getValue()
							&& null != companyIdItem.getValue()) {
						// 获取当前可以被分拆的金额总额
						BigDecimal amount = new BigDecimal(amountItem.getValue().toString());
						ListGridRecord[] records = grid.getRecords();
						if (null != records) {
							for (ListGridRecord record : records) {
								if (null != record.getAttribute("payMoney")) {
									amount = amount.subtract(new BigDecimal(record.getAttribute("payMoney")));
								}
							}
						}
						// int companyId =
						// BaseHelpUtils.getIntValue(companyIdItem.getValue());
						ListGridRecord selected = grid.getSelectedRecord();
						final int rowNo = grid.getRowNum(grid.getSelectedRecord());
						PopupWindow window = new PopupWindow();
						window.setWidth("30%");
						if (isFinance) {
							window.setHeight("80%");
						} else {
							window.setHeight("62%");
						}
						window.centerInPage();
						window.setTitle("修改收款信息");
						AddUpdateProcessBillListPanel panel = new AddUpdateProcessBillListPanel(true, isFinance,budgetRecord);
						selected.setAttribute("leftAmount", amount);
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
					} else {
						SC.warn("提示", errorMsg);
					}
				}
			}
		});
		IButton normalReimbursementLinkDepartmentsRemoveButton = new IButton("删除所有");
		normalReimbursementLinkDepartmentsRemoveButton.setIcon("[SKIN]/actions/remove.png");
		normalReimbursementLinkDepartmentsRemoveButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				grid.setData(new RecordList());
			}
		});
		normalReimbursementLinkDepartmentsControls.addMember(normalReimbursementLinkDepartmentsNewButton);
		normalReimbursementLinkDepartmentsControls.addMember(normalReimbursementLinkDepartmentsUpdateButton);
		normalReimbursementLinkDepartmentsControls.addMember(normalReimbursementLinkDepartmentsRemoveButton);
	}

	/**
	 * 
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description: 主要用于借款与预付款申请
	 * </p>
	 * 
	 * @param processName
	 * @param __processType
	 */
	public ProcessBillListApplyPanel(String processName, final int __processType) {
		if (!BaseHelpUtils.isNullOrEmpty(processName) && processName.contains("出纳")) {
			isFinance = true;
		}

		__dataGrid = grid;

		HLayout normalReimbursementLinkDepartments = new HLayout();
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
		if (isFinance) {
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
		if (__processType == 6 || __processType == 7) {
			fields[idx].setHidden(true);
		}
		idx++;
		fields[idx] = new ListGridField("remark");
		fields[idx].setShowGridSummary(false);
		grid.setHeaderHeight(60);
		if (isFinance) {
			grid.setHeaderSpans(new HeaderSpan[] { new HeaderSpan("收款信息",
					new String[] { "payFor", "payeeName", "selfBankName", "selfBankAccount", "payMoney",
							"balanceAmount", "otherName", "otherBankName", "otherBankAccount", "remark" }) });
		} else {
			String title = "收款信息";
			if(__processType == 6){
				title = title + " <font style='color:red;font-weight:bold;'>借款以【收款人】 作为记账及核销人</font>";
			}
			grid.setHeaderSpans(new HeaderSpan[] { new HeaderSpan(title, new String[] { "payFor", "payeeName",
					"selfBankName", "selfBankAccount", "payMoney", "balanceAmount", "remark" }) });
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
		addMember(normalReimbursementLinkDepartments);

		IButton normalReimbursementLinkDepartmentsNewButton = new IButton("新增");
		normalReimbursementLinkDepartmentsNewButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (__processType == 7 && grid.getRecords().length > 0) {
					SC.say("预付款申请只能添加一条收款信息");
					return;
				}
				if (null != mainInfoPage) {
					String errorMsg = "没有填写归属公司或者报销金额";
					String __errorMsg = "报销金额必须大于0才能添加";
					switch (__processType) {
					case 6:// 借款申请
						errorMsg = "没有填写归属公司或借款金额";
						__errorMsg = "借款金额必须大于0才能添加";
						break;
					case 7:// 预付款申请
						errorMsg = "没有填写归属公司或付款金额";
						__errorMsg = "付款金额必须大于0才能添加";
						break;
					}
					FormItem amountItem = mainInfoPage.findNamedItem("amount");
					FormItem companyIdItem = mainInfoPage.findNamedItem("companyId");
					switch (__processType) {
					case 6:// 借款申请
						amountItem = mainInfoPage.findNamedItem("borrowMoney");
						break;
					case 7:// 预付款申请
						amountItem = mainInfoPage.findNamedItem("payAmount");
						break;
					}
					if (null != amountItem && null != companyIdItem && null != amountItem.getValue()
							&& null != companyIdItem.getValue()) {
						// 获取当前可以被分拆的金额总额
						BigDecimal amount = new BigDecimal(amountItem.getValue().toString());
						ListGridRecord[] records = grid.getRecords();
						if (null != records) {
							for (ListGridRecord record : records) {
								if (null != record.getAttribute("payMoney")) {
									amount = amount.subtract(new BigDecimal(record.getAttribute("payMoney")));
								}
							}
						}
						if (amount.compareTo(BigDecimal.ZERO) <= 0) {
							SC.warn("提示", __errorMsg);
							return;
						}
						PopupWindow window = new PopupWindow();
						window.setWidth("30%");
						if (isFinance) {
							window.setHeight("80%");
						} else {
							window.setHeight("62%");
						}
						window.centerInPage();
						window.setTitle("新增收款信息");
						AddUpdateProcessBillListPanel panel = new AddUpdateProcessBillListPanel(false, isFinance,
								__processType,budgetRecord);
						panel.startEdit(null, amount, false);
						panel.setParentWindow(window);
						panel.addDataEditedHandler(new DataEditedHandler() {
							@Override
							public void onDataEdited(DataEditEvent event) {
								Record record = event.getData();
								if (__processType == 7) {
									updateMainPageView(record);
								}
								RecordList list = grid.getDataAsRecordList();
								list.add(record);
								grid.setData(list);
								grid.redraw();
							}
						});
						window.addItem(panel);
						window.show();
					} else {
						SC.warn("提示", errorMsg);
					}
				}
			}
		});
		IButton normalReimbursementLinkDepartmentsUpdateButton = new IButton("修改");
		normalReimbursementLinkDepartmentsUpdateButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				String errorMsg = "没有填写归属公司或者报销金额";
				switch (__processType) {
				case 6:// 借款申请
					errorMsg = "没有填写归属公司或借款金额";
					break;
				case 7:// 预付款申请
					errorMsg = "没有填写归属公司或付款金额";
					break;
				}
				if (null != mainInfoPage && null != grid.getSelectedRecord()) {
					FormItem amountItem = mainInfoPage.findNamedItem("amount");
					// FormItem departmentItem =
					// mainInfoPage.findNamedItem("departmentId");
					FormItem companyIdItem = mainInfoPage.findNamedItem("companyId");
					switch (__processType) {
					case 6:// 借款申请
						amountItem = mainInfoPage.findNamedItem("borrowMoney");
						break;
					case 7:// 预付款申请
						amountItem = mainInfoPage.findNamedItem("payAmount");
						break;
					}
					if (null != amountItem && null != companyIdItem && null != amountItem.getValue()
							&& null != companyIdItem.getValue()) {
						// 获取当前可以被分拆的金额总额
						BigDecimal amount = new BigDecimal(amountItem.getValue().toString());
						ListGridRecord[] records = grid.getRecords();
						if (null != records) {
							for (ListGridRecord record : records) {
								if (null != record.getAttribute("payMoney")) {
									amount = amount.subtract(new BigDecimal(record.getAttribute("payMoney")));
								}
							}
						}
						// int companyId =
						// BaseHelpUtils.getIntValue(companyIdItem.getValue());
						ListGridRecord selected = grid.getSelectedRecord();
						final int rowNo = grid.getRowNum(grid.getSelectedRecord());
						PopupWindow window = new PopupWindow();
						window.setWidth("30%");
						if (isFinance) {
							window.setHeight("80%");
						} else {
							window.setHeight("62%");
						}
						window.centerInPage();
						window.setTitle("修改收款信息");
						AddUpdateProcessBillListPanel panel = new AddUpdateProcessBillListPanel(true, isFinance,
								__processType,budgetRecord);
						selected.setAttribute("leftAmount", amount);
						panel.startEdit(selected, amount, true);
						panel.setParentWindow(window);
						panel.addDataEditedHandler(new DataEditedHandler() {
							@Override
							public void onDataEdited(DataEditEvent event) {
								Record record = event.getData();
								if (__processType == 7) {
									updateMainPageView(record);
								}
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
					} else {
						SC.warn("提示", errorMsg);
					}
				}
			}
		});
		IButton normalReimbursementLinkDepartmentsRemoveButton = new IButton("删除所有");
		normalReimbursementLinkDepartmentsRemoveButton.setIcon("[SKIN]/actions/remove.png");
		normalReimbursementLinkDepartmentsRemoveButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				grid.setData(new RecordList());
			}
		});
		normalReimbursementLinkDepartmentsControls.addMember(normalReimbursementLinkDepartmentsNewButton);
		normalReimbursementLinkDepartmentsControls.addMember(normalReimbursementLinkDepartmentsUpdateButton);
		normalReimbursementLinkDepartmentsControls.addMember(normalReimbursementLinkDepartmentsRemoveButton);
	}

	private void updateMainPageView(Record record) {
		if (null != mainInfoPage) {
			mainInfoPage.findNamedItem("receiveUnit").setValue(record.getAttribute("payeeName"));
			mainInfoPage.findNamedItem("bankAccount").setValue(record.getAttribute("selfBankAccount"));
			mainInfoPage.findNamedItem("bankName").setValue(record.getAttribute("selfBankName"));
			mainInfoPage.findNamedItem("payAmount").setValue(record.getAttribute("payMoney"));
		}
	}

	@Override
	public void startEdit() {
		if(null != getInitData()){
			Integer optionType = initData.getAttributeAsInt("optionType");
			int budgetManagementId=BaseHelpUtils.getIntValue(initData.getAttribute("budgetManagementId"));
			if (optionType != null && optionType == 1) {//进入复制发起流程
				Record record = getInitData();
				int processType = record.getAttributeAsInt("processType");
				int businessId = record.getAttributeAsInt("businessId");
				Map params = new HashMap<>();
				params.put("processType", processType);
				params.put("businessId", businessId);
				DBDataSource.callOperation("ST_ProcessBillList", "find", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						Record[] records = dsResponse.getData();
						RecordList recordList = new RecordList();
						Record record = new Record();
						for (Record record2 : records) {
							Map map = record2.toMap();

							record.setAttribute("payFor", map.get("payFor"));
							record.setAttribute("employeeOrCompanyId", map.get("employeeOrCompanyId"));
							record.setAttribute("moneyAttribute", map.get("moneyAttribute"));
							record.setAttribute("payeeName", map.get("payeeName"));
							record.setAttribute("selfBankName", map.get("selfBankName"));
							record.setAttribute("selfBankAccount", map.get("selfBankAccount"));
							record.setAttribute("otherName", map.get("otherName"));
							record.setAttribute("otherBankName", map.get("otherBankName"));
							record.setAttribute("otherBankAccount", map.get("otherBankAccount"));
							record.setAttribute("balanceAmount", map.get("balanceAmount")); 
							record.setAttribute("remark", map.get("remark")); 
							//record.setAttribute("operator", map.get("operator"));
							record.setAttribute("equivalentNumber", map.get("equivalentNumber")); 
							record.setAttribute("payMoney", map.get("payMoney")); 
							recordList.add(record);
							//							
							//							
							//							map.put("processBillListId", null);
							//							map.put("businessId", null);
							//							map.put("companyId", null);
							//							map.put("year", null);
							//							map.put("month", null);
							//							map.put("payType", null); 
							//							map.put("isComplete", null);  
							//							map.put("createTime", null);  
							//							map.put("payType", null);  
						}
						grid.setData(recordList);
					}
				});
			}else if(budgetManagementId>0) {

			}
			else{
				//薪资发放流程最后一个节点
				int type = getInitData().getAttributeAsInt("type");
				Map params = getInitData().toMap();
				if(type == 1){
					params.put("opt_type", "getSalaryReceiveUnitManages");
					DBDataSource.callOperation("EP_CustomSprocessbilllistppporProcess", params, new DSCallback() {

						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if(dsResponse.getStatus() >= 0){
								grid.setData(dsResponse.getData());
							}
						}
					});
				}else if(type == 2){
					params.put("opt_type", "getSalaryBonusReceiveUnitManages");
					DBDataSource.callOperation("EP_CustomSprocessbilllistppporProcess", params, new DSCallback() {

						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if(dsResponse.getStatus() >= 0){
								__logger.info(dsResponse.getData() + "");
								grid.setData(dsResponse.getData());
							}
						}
					});
				}else if(type == 3){
					params.put("opt_type", "getSalaryAnnualBonusReceiveUnitManages");
					DBDataSource.callOperation("EP_CustomSprocessbilllistppporProcess", params, new DSCallback() {

						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if(dsResponse.getStatus() >= 0){
								grid.setData(dsResponse.getData());
							}
						}
					});
				}
			}
		}
		//工资发放总表传过来的数据操作
		Record record = getRecord();
		if (null != record) {
			String optType = record.getAttribute("optType");
			RecordList recordList = new RecordList();
			if (tempDate.equals(optType)) {
				int employeeFundIssuanceId = BaseHelpUtils.getIntValue(record.getAttribute("employeeFundIssuanceId"));
				HashMap<String, Object> params = new HashMap<>();
				params.put("employeeFundIssuanceId", employeeFundIssuanceId);
				DBDataSource.callOperation("ST_EmployeeFundIssuanceDetail", "find", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
						int status = dsResponse.getStatus();
						if (status >= 0) {
							Record[] records = dsResponse.getData();
							for (Record record : records) {
								//获取子表的员工工号
								int employeeId = BaseHelpUtils.getIntValue(record.getAttribute("employeeId"));
								SC.debugger();
								String employeeName = KeyValueManager.getValueMap("employees").get(employeeId + "");
								//获取发放的钱数
								BigDecimal issueMoney = BaseHelpUtils.getBigDecimalValue(record.getAttribute("issueMoney"));
								HashMap<String, Object> params = new HashMap<>();
								params.put("opt_type", "getEmployeeBankInfoById");
								params.put("employeeId", employeeId);
								DBDataSource.callOperation("EP_CustomSprocessbilllistppporProcess", params, new DSCallback() {
									@Override
									public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
										if(dsResponse.getStatus() > 0 && dsResponse.getData().length > 0){
											Record bankRecord = dsResponse.getData()[0];
											//获取银行ID
											String bankId = BaseHelpUtils.getString(bankRecord.getAttribute("bankId"));
											//获取银行名称
											String bankName = KeyValueManager.getValueMap("system_dictionary_68").get(bankId);
											//获取银行卡号
											String bankAccount = BaseHelpUtils.getString(bankRecord.getAttribute("bankAccount"));

											Record tempRecord = new Record();
											tempRecord.setAttribute("employeeOrCompanyId", employeeId);
											tempRecord.setAttribute("payFor", 1);
											tempRecord.setAttribute("payeeName", employeeName);
											tempRecord.setAttribute("selfBankName", bankName);
											tempRecord.setAttribute("selfBankAccount", bankAccount);
											tempRecord.setAttribute("payMoney", issueMoney);
											tempRecord.setAttribute("employeeFundIssuanceId", employeeFundIssuanceId);
											recordList.add(tempRecord);
										}
									}
								});
							}

						}
					}
				});
				grid.setData(recordList);
			}
		}

		if (getPageMode() != PAGE_MODE_UPDATE)
			return;
		reloadDetailTableData();
	}

	public void reloadDetailTableData() {
		Map condition = new HashMap();
		Record record = getRecord();
		int __businessId = 0;
		switch (getProcessType()) {
		case PROCESS_TYPE_2:
			__businessId = BaseHelpUtils.getIntValue(getRecord().getAttribute("projectNormalReimbursementId"));
			break;
		case PROCESS_TYPE_3:
			__businessId = BaseHelpUtils.getIntValue(getRecord().getAttribute("projectNormalReimbursementId"));
			break;
		case PROCESS_TYPE_4:
			__businessId = BaseHelpUtils.getIntValue(getRecord().getAttribute("travelReimbursementId"));
			break;
		case PROCESS_TYPE_5:
			__businessId = BaseHelpUtils.getIntValue(getRecord().getAttribute("travelReimbursementId"));
			break;
		case PROCESS_TYPE_6:
			__businessId = BaseHelpUtils.getIntValue(getRecord().getAttribute("employeeMoneyManageId"));
			break;
		case PROCESS_TYPE_7:
			__businessId = BaseHelpUtils.getIntValue(getRecord().getAttribute("payMoneyManageId"));
			break;
		case PROCESS_TYPE_8:
			__businessId = BaseHelpUtils.getIntValue(getRecord().getAttribute("projectNormalReimbursementId"));
			break;
		case PROCESS_TYPE_9:
			__businessId = BaseHelpUtils.getIntValue(getRecord().getAttribute("travelReimbursementId"));
			break;
		case PROCESS_TYPE_10:
			__businessId = BaseHelpUtils.getIntValue(getRecord().getAttribute("projectNormalReimbursementId"));
			break;
		default:
			break;
		}
		condition.put("businessId", __businessId);
		condition.put("processType", getProcessType());
		condition.put("opt_type", "getBillListByBusinessidProcesstype");
		DBDataSource.callOperation("EP_CustomSprocessbilllistppporProcess", "getBillListByBusinessidProcesstype",
				condition, new DSCallback() {
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
		boolean flag = true;
		ListGridRecord[] records = grid.getRecords();
		if (records.length > 0) {
			FormItem amountItem = mainInfoPage.findNamedItem("amount");
			if (null != processType) {
				switch (processType) {
				case 6:// 借款申请
					amountItem = mainInfoPage.findNamedItem("borrowMoney");
					break;
				case 7:// 预付款申请
					amountItem = mainInfoPage.findNamedItem("payAmount");
					break;
				}
			}
			if (null != records) {
				BigDecimal amount = new BigDecimal(amountItem.getValue().toString());
				BigDecimal payMoney = BigDecimal.ZERO;
				BigDecimal blanceMoney = BigDecimal.ZERO;
				for (Record record : records) {
					if(BaseHelpUtils.isNullOrEmpty(record.getAttribute("employeeOrCompanyId"))) {
						SC.say("收款方信息有误，ID缺失");
						return false;
					}
					if (null != record.getAttribute("payMoney")) {
						payMoney = payMoney.add(new BigDecimal(record.getAttributeAsString("payMoney")));
					}
					if (null != record.getAttribute("balanceAmount")) {
						blanceMoney = blanceMoney.add(new BigDecimal(record.getAttributeAsString("balanceAmount")));
					}
				}
				if (amount.compareTo(payMoney.add(blanceMoney)) != 0) {
					flag = false;
					StringBuilder sb = new StringBuilder();
					sb.append("申请金额[").append(BaseHelpUtils.format(amount, 2)).append("]与收款信息中的(付款金额[")
							.append(BaseHelpUtils.format(payMoney, 2)).append("]");
					;
					if (null == getProcessType() || (6 != getProcessType() && 7 != getProcessType())) {
						sb.append(" + 冲账金额[").append(BaseHelpUtils.format(blanceMoney, 2)).append("]");
					}
					sb.append(")的总和不相等,清进行核对后再提交");
					SC.say(sb.toString());
				}
			}
		} else {
			flag = false;
			SC.say("请添加收款信息！");
		}
		// for (ListGridRecord r : grid.getRecords()) {
		// __logger.info(MapUtils.convertRecordToMap(grid.getDataSource(),
		// r).toString());
		// }
		return flag;
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
		MapUtils.convertRecordToMap(grid.getDataSource(), rows, param, "detailProcessBillListApply");
		MapUtils.convertRecordToMap(grid.getDataSource(), rows, param, "detailSprocessbilllistpppor");
		return param;
	}

	public Record[] getValuesAsRecords(){
		return grid.getRecords();
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

	public Record getInitData() {
		return initData;
	}

	public void setInitData(Record initData) {
		this.initData = initData;
	}

	public void inintReNewData(Record record) {
		if (record == null) {
			return;
		}
		if (record.getAttribute("processType") != null && record.getAttribute("processType") != "" && record.getAttribute("businessId") != null && record.getAttribute("businessId") != "") {
			int processType = record.getAttributeAsInt("processType");
			int businessId = record.getAttributeAsInt("businessId");
			Map params = new HashMap<>();
			
			params.put("processType", processType);
			params.put("businessId", businessId);
			DBDataSource.callOperation("ST_ProcessBillList", "find", params, new DSCallback() {
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					Record[] records = dsResponse.getData();
					for (Record record2 : records) {
						Record record3 = new Record();
						Map map = record2.toMap();
						map.put("processBillListId", null);
						map.put("companyId", null);
						map.put("year", null);
						map.put("month", null);
						map.put("payType", null);
					}
					
					grid.setData(records);
				}
			});
			
		}
	}
	
	private  Record budgetRecord;

	public Record getBudgetRecord() {
		return budgetRecord;
	}

	public void setBudgetRecord(Record budgetRecord) {
		this.budgetRecord = budgetRecord;
	}
	

}
