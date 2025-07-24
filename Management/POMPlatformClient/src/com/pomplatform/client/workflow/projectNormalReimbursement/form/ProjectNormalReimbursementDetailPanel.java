package com.pomplatform.client.workflow.projectNormalReimbursement.form;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.workflow.commonNormalReimbursement.form.NormalReimbursementLinkDepartmentPanel;
import com.pomplatform.client.workflow.form.NormalReimbursementDetailPanel;
import com.pomplatform.client.workflow.projectNormalReimbursement.datasource.DSProjectNormalReimbursementDetail;
import com.smartgwt.client.data.*;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

import java.math.BigDecimal;
import java.util.*;
import java.util.logging.Logger;

public class ProjectNormalReimbursementDetailPanel extends AbstractWizadPage {

	private static final Logger __logger = Logger.getLogger("");
	private DSCallback __startLoadedDetail;
	private DSCallback __endLoadedDetail;
	private DelicacyListGrid grid = new DelicacyListGrid(true);
	private final LinkedHashMap<String, String> mainItemMap = new LinkedHashMap<>();
	private final LinkedHashMap<String, String> subItemMap = new LinkedHashMap<>();
	private AbstractWizadPage mainInfoPage;
	private NormalReimbursementLinkDepartmentPanel departmentPanel;
	private NormalReimbursementLinkProjectPanel linkDepartmentPanel;
	private int processId = 0;
	private int departmentId = 0;
	private Record initData;

	public ProjectNormalReimbursementDetailPanel() {

		__dataGrid = grid;
		HLayout projectNormalReimbursementDetails = new HLayout();
		projectNormalReimbursementDetails.setWidth100();
		projectNormalReimbursementDetails.setHeight100();
		ListGridField[] fields = new ListGridField[4];
		int idx = 0;
		fields[idx] = new ListGridField("mainItemId");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("subItemId");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("remark");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("amount");
		idx++;
		fields[idx] = new ListGridField("identification");
		grid.setHeaderHeight(60);
		grid.setHeaderSpans(new HeaderSpan[] {
				new HeaderSpan("报销科目<font style=\"color:red; font-weight:bold\">【报销科目合并，本框内不再需要填写数据】</font>", new String[] { "mainItemId", "subItemId", "remark", "amount","identification"}) });
		grid.setFields(fields);
		grid.setShowGridSummary(true);
		grid.setCanEdit(false);
		grid.setDataSource(DSProjectNormalReimbursementDetail.getInstance());
		grid.setAutoFitFieldWidths(false);
		grid.setCanRemoveRecords(false);
//		grid.addRemoveRecordClickHandler(new RemoveRecordClickHandler() {
//			@Override
//			public void onRemoveRecordClick(RemoveRecordClickEvent event) {
//				if (null != departmentPanel) {
//					int rowNum = event.getRowNum();
//					BigDecimal amount = BigDecimal.ZERO;
//					ListGridRecord[] data = grid.getRecords();
//					int i = 0;
//					for (ListGridRecord r : data) {
//						if (i != rowNum && null != r.getAttribute("amount")) {
//							amount = amount.add(new BigDecimal(r.getAttribute("amount")));
//						}
//						i++;
//					}
//					departmentPanelInfoChange(amount);
//				}
//				EditCompleteEvent editCompleteEvent = new EditCompleteEvent(null);
//				grid.fireEvent(editCompleteEvent);
//			}
//		});
		projectNormalReimbursementDetails.addMember(grid);
		VLayout projectNormalReimbursementDetailsControls = new VLayout();
		projectNormalReimbursementDetailsControls.setHeight100();
		projectNormalReimbursementDetailsControls.setWidth(60);
		projectNormalReimbursementDetailsControls.setLayoutTopMargin(30);
		projectNormalReimbursementDetailsControls.setLayoutLeftMargin(5);
		projectNormalReimbursementDetailsControls.setLayoutRightMargin(5);
		projectNormalReimbursementDetailsControls.setMembersMargin(10);
//		projectNormalReimbursementDetails.addMember(projectNormalReimbursementDetailsControls);
		addMember(projectNormalReimbursementDetails);
		IButton projectNormalReimbursementDetailsNewButton = new IButton("新增");
		projectNormalReimbursementDetailsNewButton.hide();
		projectNormalReimbursementDetailsNewButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (null != mainInfoPage && null != mainInfoPage.findNamedItem("amount")
						&& null != mainInfoPage.findNamedItem("departmentId")
						&& ClientUtil.checkAndGetIntValue(mainInfoPage.findNamedItem("departmentId").getValue()) > 0
						&& processId > 0) {
					final PopupWindow window = new PopupWindow("新增报销信息");
					window.setWidth(450);
					window.setHeight(310);
					window.centerInPage();
					int newDepartmentId = ClientUtil
							.checkAndGetIntValue(mainInfoPage.findNamedItem("departmentId").getValue());
					if (departmentId != newDepartmentId) {
						newWindowWithDBDataSource(window, newDepartmentId, new Record(), false);
					} else {
						newWindowWithoutDBDataSource(window, new Record(), false);
					}
				}
			}
		});
		IButton projectNormalReimbursementDetailsUpdateButton = new IButton("修改");
		projectNormalReimbursementDetailsUpdateButton.hide();
		projectNormalReimbursementDetailsUpdateButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (grid.anySelected()) {
					if (null != mainInfoPage && null != mainInfoPage.findNamedItem("amount")
							&& null != mainInfoPage.findNamedItem("departmentId")
							&& ClientUtil.checkAndGetIntValue(mainInfoPage.findNamedItem("departmentId").getValue()) > 0
							&& processId > 0) {
						final PopupWindow window = new PopupWindow("修改报销信息");
						window.setWidth(450);
						window.setHeight(310);
						window.centerInPage();
						int newDepartmentId = ClientUtil
								.checkAndGetIntValue(mainInfoPage.findNamedItem("departmentId").getValue());
						Record record = grid.getSelectedRecord();
						if (departmentId != newDepartmentId) {
							newWindowWithDBDataSource(window, newDepartmentId, record, true);
						} else {
							newWindowWithoutDBDataSource(window, record, true);
						}
					}
				} else {
					SC.say("请选择一条数据");
				}
			}
		});
		IButton projectNormalReimbursementDetailsRemoveButton = new IButton("删除所有");
		projectNormalReimbursementDetailsRemoveButton.hide();
		projectNormalReimbursementDetailsRemoveButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				grid.setData(new RecordList());
				departmentPanelInfoChange(BigDecimal.ZERO);
				EditCompleteEvent editCompleteEvent = new EditCompleteEvent(null);
				grid.fireEvent(editCompleteEvent);
			}
		});
		projectNormalReimbursementDetailsControls.addMember(projectNormalReimbursementDetailsNewButton);
		projectNormalReimbursementDetailsControls.addMember(projectNormalReimbursementDetailsUpdateButton);
		projectNormalReimbursementDetailsControls.addMember(projectNormalReimbursementDetailsRemoveButton);
	}

	@Override
	public void startEdit() {
		if(null != getInitData()){
			Integer optionType = initData.getAttributeAsInt("optionType");
			int budgetManagementId=BaseHelpUtils.getIntValue(initData.getAttribute("budgetManagementId"));
			if (optionType != null && optionType == 1) {//进入复制发起流程
				Record record = getInitData();
				String businessId = record.getAttribute("businessId");
				Map params = new HashMap<>();
				params.put("projectNormalReimbursementId", businessId);
				DBDataSource.callOperation("ST_ProjectNormalReimbursementDetail", "find", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						Record[] records = dsResponse.getData();
						RecordList recordValues = new RecordList();
						for (Record record2 : records) {
							Record recordValue = new Record();
							Map<String, Object> map = record2.toMap();
							recordValue.setAttribute("mainItemId", map.get("mainItemId"));
							recordValue.setAttribute("subItemId", map.get("subItemId"));
							recordValue.setAttribute("amount", map.get("amount"));
							recordValue.setAttribute("remark", map.get("remark"));
							recordValue.setAttribute("identification" , map.get("identification"));
							recordValues.add(recordValue);
						}
						grid.setData(recordValues);
					}
				});
//				HashMap<Object, Object> conditions = new HashMap<>();
//				conditions.put("projectNormalReimbursementId" , businessId);
//				DBDataSource.callOperation("ST_NormalReimbursementLinkProject", "find", conditions, new DSCallback() {
//					@Override
//					public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
//						Record[] records = dsResponse.getData();
//						SC.debugger();
//						RecordList recordValues = new RecordList();
//						for (Record record2 : records) {
//							Record recordValue = new Record();
//							Map<String, Object> map = record2.toMap();
//							recordValue.setAttribute("mainItemId", map.get("mainItemId"));
//							recordValue.setAttribute("subItemId", map.get("subItemId"));
//							recordValue.setAttribute("amount", map.get("amount"));
//							recordValue.setAttribute("remark", map.get("remark"));
//							recordValue.setAttribute("finalAmount" , map.get("finalAmount"));
//							recordValue.setAttribute("inputTax" , map.get("inputTax"));
//							recordValue.setAttribute("plateId" , map.get("plateId"));
//							recordValue.setAttribute("contractCode" , map.get("contractCode"));
//							recordValue.setAttribute("projectId" , map.get("projectId"));
//							recordValues.add(recordValue);
//						}
//						NormalReimbursementLinkProjectPanel linkDepartmentPanel = getLinkDepartmentPanel();
//						DelicacyListGrid grid = linkDepartmentPanel.getGrid();
//						grid.setData(recordValues);
//					}
//				});

			}else if(budgetManagementId>0) {
				
			}
			else {
			int year = getInitData().getAttributeAsInt("year");
			String month = getInitData().getAttribute("month");
			int type = getInitData().getAttributeAsInt("type");
			Object shouldSalary = null;
			Object leaveAdvance = null;
			Object shouldBonus = null;
			String typeStr = "";
			String remark1 = "";
			String remark2 = "";
			String remark3 = "";
			String remark = "";
			if(type == 1){
				typeStr = "工资"; 
				remark = month + "月" + typeStr;
				remark1 = remark + "(应付工资)";
				remark2 = remark + "(离职补偿)";
				remark3 = remark + "(应付奖金)";
				shouldSalary = getInitData().getAttributeAsObject("shouldSalary");
				leaveAdvance = getInitData().getAttributeAsObject("leaveAdvance");
				shouldBonus = getInitData().getAttributeAsObject("shouldBonus");
			}else if(type == 2){
				typeStr = "项目奖金";
				remark = month + "月" + typeStr;
				remark1 = remark + "(应发奖金)";
				remark2 = remark + "(应纳个税)";
				remark3 = remark + "(实发奖金)";
				shouldSalary = getInitData().getAttributeAsObject("shouldBonus");
				leaveAdvance = getInitData().getAttributeAsObject("shouldTax");
				shouldBonus = getInitData().getAttributeAsObject("factBonus");
			}else if(type == 3){
				String remarkSuffix = "应发13薪奖金" + getInitData().getAttribute("thirteenBonus") + ";"
										+ "应发年度绩效工资" + getInitData().getAttribute("yearPerformanceBonus") + ";"
										+ "应发项目奖金" + getInitData().getAttribute("programBonus") + ";"
										+ "补/扣工资差额" + getInitData().getAttribute("salaryDiffDeduct") + ";"
										+ "调户押金返还" + getInitData().getAttribute("transferAccountMoney") + ";"
										+ "调户押金扣除" + getInitData().getAttribute("depositDeduct") + ";"
										+ "报销扣款" + getInitData().getAttribute("reimbursementDeduct") + ";"
										+ "其他扣款" + getInitData().getAttribute("otherDeduct") + ";";
				
				typeStr = "年终奖金";
				remark = year + "年" + typeStr + ";" + remarkSuffix;
				remark1 = remark;
				remark2 = remark + "(应纳个税)";
				remark3 = remark + "(实发奖金)";
				shouldSalary = getInitData().getAttributeAsObject("shouldTotal");
				leaveAdvance = getInitData().getAttributeAsObject("shouldTax");
				shouldBonus = getInitData().getAttributeAsObject("factBonus");
			}
			
			//应付工资
			Record rowData = new Record();
			rowData.setAttribute("mainItemId", 181);
			rowData.setAttribute("subItemId", 211);
			rowData.setAttribute("amount", shouldSalary);
			rowData.setAttribute("remark", remark1);
			
			//离职补偿
			Record rowData1 = new Record();
			rowData1.setAttribute("mainItemId", 181);
			rowData1.setAttribute("subItemId", 213);
			rowData1.setAttribute("amount", leaveAdvance);
			rowData1.setAttribute("remark", remark2);
			
			//应付奖金
			Record rowData2 = new Record();
			rowData2.setAttribute("mainItemId", 181);
			rowData2.setAttribute("subItemId", 212);
			rowData2.setAttribute("amount", shouldBonus);
			rowData2.setAttribute("remark", remark3);
			if(type == 1){
				grid.setData(new Record[]{rowData, rowData1, rowData2});
			}else if(type == 2 || type == 3){
				grid.setData(new Record[]{rowData});
			}
		}
		}
		if (getPageMode() != PAGE_MODE_UPDATE)
			return;
		reloadDetailTableData();
	}

	public void reloadDetailTableData() {
		Map condition = new HashMap();
		condition.put("projectNormalReimbursementId", getRecord().getAttribute("projectNormalReimbursementId"));
		DBDataSource.callOperation("ST_ProjectNormalReimbursementDetail", "find", condition, new DSCallback() {
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
		res.add("detailProjectNormalReimbursementDetail");
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
		MapUtils.convertRecordToMap(grid.getDataSource(), rows, param, "detailProjectNormalReimbursementDetail");
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

	public void newWindowWithDBDataSource(final PopupWindow window, final int departmentId, final Record editRecord,
			final boolean update) {
		this.departmentId = departmentId;
		Map<String, Object> paramsMap = new HashMap<>();
		paramsMap.put("processId", processId);
		paramsMap.put("departmentId", departmentId);
		DBDataSource.callOperation("EP_GetSubTypeByProcessAndDepartment", paramsMap, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record[] records = dsResponse.getData();
					for (Record obj : records) {
						if (obj.getAttributeAsInt("parentId") == 0) {
							mainItemMap.put(obj.getAttribute("subjectTypeId"), obj.getAttribute("subjectName"));
						} else {
							subItemMap.put(obj.getAttribute("subjectTypeId") + "-" + obj.getAttribute("parentId"),
									obj.getAttribute("subjectName"));
						}
					}
					NormalReimbursementDetailPanel panel = new NormalReimbursementDetailPanel(mainItemMap, subItemMap);
					panel.startEdit(editRecord);
					panel.addDataEditedHandler(new DataEditedHandler() {
						@Override
						public void onDataEdited(DataEditEvent event) {
							if (update) {
								Record record = event.getData();
								RecordList list = grid.getDataAsRecordList();
								RecordList newList = new RecordList();
								int size = list.getLength();
								int rowNo = grid.getRowNum(grid.getSelectedRecord());
								for (int i = 0; i < size; i++) {
									if (i == rowNo) {
										newList.add(record);
									} else {
										newList.add(list.get(i));
									}
								}
								grid.setData(newList);
							} else {
								SC.debugger();
								Record record = event.getData();
								RecordList list = grid.getDataAsRecordList();
								list.add(record);
								grid.setData(list);
							}
							grid.redraw();
							FormItem item = mainInfoPage.findNamedItem("amount");
							BigDecimal amount = BigDecimal.ZERO;
							if (null != item) {
								ListGridRecord[] data = grid.getRecords();
								if (data == null || data.length == 0) {
									item.setValue(amount);
									return;
								}
								for (ListGridRecord r : data) {
									if (null != r.getAttribute("amount")) {
										amount = amount.add(new BigDecimal(r.getAttribute("amount")));
									}
								}
								item.setValue(amount);
							}
							departmentPanelInfoChange(amount);
						}
					});
					panel.setParentWindow(window);
					window.addItem(panel);
					window.show();
				} else {
					SC.say(dsResponse.getErrors().get("errorMsg").toString());
				}
			}
		});
	}

	public void newWindowWithoutDBDataSource(final PopupWindow window, final Record editRecord, final boolean update) {
		NormalReimbursementDetailPanel panel = new NormalReimbursementDetailPanel(mainItemMap, subItemMap);
		panel.startEdit(editRecord);
		panel.addDataEditedHandler(new DataEditedHandler() {
			@Override
			public void onDataEdited(DataEditEvent event) {
				if (update) {
					Record record = event.getData();
					RecordList list = grid.getDataAsRecordList();
					RecordList newList = new RecordList();
					int size = list.getLength();
					int rowNo = grid.getRowNum(grid.getSelectedRecord());
					for (int i = 0; i < size; i++) {
						if (i == rowNo) {
							newList.add(record);
						} else {
							newList.add(list.get(i));
						}
					}
					grid.setData(newList);
				} else {
					Record record = event.getData();
					RecordList list = grid.getDataAsRecordList();
					list.add(record);
					grid.setData(list);
				}
				grid.redraw();
				FormItem item = mainInfoPage.findNamedItem("amount");
				BigDecimal amount = BigDecimal.ZERO;
				if (null != item) {
					ListGridRecord[] data = grid.getRecords();
					if (data == null || data.length == 0) {
						item.setValue(amount);
						return;
					}
					for (ListGridRecord r : data) {
						if (null != r.getAttribute("amount")) {
							amount = amount.add(new BigDecimal(r.getAttribute("amount")));
						}
					}
					item.setValue(amount);
				}
				departmentPanelInfoChange(amount);
			}
		});
		panel.setParentWindow(window);
		window.addItem(panel);
		window.show();
	}

	public void departmentPanelInfoChange(BigDecimal amount) {
		if (null != departmentPanel) {
			DelicacyListGrid departmentRecords = departmentPanel.getGrid();
			if (departmentRecords.getRecords().length <= 1) {
				// 只有部门费用分拆的数据量<=1条的时候，才需要在金额变动的时候，跟着变动部门分担的费用，多于1条数据的，由用户自行调整部门分担费用
				ListGridRecord departmentRecord = departmentRecords.getRecord(0);
				if (null == departmentRecord) {
					departmentRecord = new ListGridRecord();
					FormItem departmentItem = mainInfoPage.findNamedItem("departmentId");
					if (null != departmentItem && null != departmentItem.getValue()) {
						String departmentId = departmentItem.getValue().toString();
						departmentRecord.setAttribute("departmentId", departmentId);
					}
				}
				departmentRecord.setAttribute("amount", amount);
				departmentRecord.setAttribute("inputTax", 0);
				departmentRecord.setAttribute("finalAmount", amount);
				ListGridRecord[] recordArr = new ListGridRecord[1];
				recordArr[0] = departmentRecord;
				departmentRecords.setRecords(recordArr);
				departmentPanel.setGrid(departmentRecords);
				departmentPanel.reDrawGrid();
			}
		}
	}



	public int getProcessId() {
		return processId;
	}

	public void setProcessId(int processId) {
		this.processId = processId;
	}

	public NormalReimbursementLinkDepartmentPanel getDepartmentPanel() {
		return departmentPanel;
	}

	public void setDepartmentPanel(NormalReimbursementLinkDepartmentPanel departmentPanel) {
		this.departmentPanel = departmentPanel;
	}

	public Record getInitData() {
		return initData;
	}

	public void setInitData(Record initData) {
		this.initData = initData;
	}


	public void setLinkDepartmentPanel(NormalReimbursementLinkProjectPanel link) {
	}
	public NormalReimbursementLinkProjectPanel getLinkDepartmentPanel() {
		return linkDepartmentPanel;
	}
}
