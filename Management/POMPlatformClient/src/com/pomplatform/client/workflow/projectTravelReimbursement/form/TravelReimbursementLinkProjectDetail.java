package com.pomplatform.client.workflow.projectTravelReimbursement.form;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.SyncDataUtil;
import com.pomplatform.client.workflow.commonNormalReimbursement.form.InputTaxRecordPanel;
import com.pomplatform.client.workflow.commonNormalReimbursement.form.NormalReimbursementLinkDepartmentPopupPanel;
import com.pomplatform.client.workflow.datasource.DSReimbursementInvoiceInformation;
import com.pomplatform.client.workflow.form.TravelReimbursementLinkProjectPanel;
import com.pomplatform.client.workflow.panel.ProcessInputTaxAmountPanel;
import com.pomplatform.client.workflow.projectTravelReimbursement.datasource.DSTravelReimbursementLinkProject;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.grid.events.RemoveRecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RemoveRecordClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class TravelReimbursementLinkProjectDetail extends AbstractWizadPage
{

	private static final Logger __logger = Logger.getLogger("");
	private DSCallback __startLoadedDetail;
	private DSCallback __endLoadedDetail;
	private DelicacyListGrid grid = new DelicacyListGrid(true);
	private AbstractWizadPage mainInfoPage;
	private final LinkedHashMap<Integer, String> projectMap = new LinkedHashMap<>();
	private Integer processType;
	private String processName;
	
	private int invoiceLinkKey = 0;

	// 进项税发票信息 存储跟费用分拆相关数据进行关联
	private Map<Integer, Record[]> reimbursementInvoiceMap = new HashMap<>();

	public TravelReimbursementLinkProjectDetail(){
		initPanel(false, null);
	}
	
	public TravelReimbursementLinkProjectDetail(boolean editInputTax, String processName){
		initPanel(editInputTax, processName);
	}

	public void initPanel(boolean editInputTax, String processName){
		setProcessName(processName);
		//加载项目数据，以供费用分拆时使用
		Map<String, Object> map = new HashMap<>();
		map.put("optType", "getMainProjectName");
		DBDataSource.callOperation("EP_GetUserInfoById", map, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Map userMap = BaseHelpUtils.getResponseUserData(dsResponse);
					if(!BaseHelpUtils.isNullOrEmpty(userMap) && userMap.size() > 0) {
						projectMap.putAll(userMap);
					}
				}
			}
		});
		
		__dataGrid = grid;
		HLayout travelReimbursementDetails = new HLayout();
		travelReimbursementDetails.setWidth100();
		travelReimbursementDetails.setHeight100();
		ListGridField[] fields = new ListGridField[7];
		int idx = 0;
		fields[idx] = new ListGridField("projectId");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("contractCode");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("plateId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("amount");
		idx++;
		fields[idx] = new ListGridField("inputTax");
		fields[idx].setHidden(!editInputTax);
		fields[idx].addRecordClickHandler(new RecordClickHandler() {
			@Override
			public void onRecordClick(RecordClickEvent event) {
				if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.TAX_INVOICES_EDIT_RECORD)) {
					PopupWindow popupWindow = new PopupWindow();
					popupWindow.setTitle("进项税记录"); 
					popupWindow.setWidth("60%"); 
					popupWindow.setHeight("70%");
					InputTaxRecordPanel panel =new InputTaxRecordPanel();
					panel.addDataEditedHandler(new DataEditedHandler(){
						@Override
						public void onDataEdited(DataEditEvent event) {
						}
					});
					popupWindow.addCloseClickHandler(new CloseClickHandler() {
						@Override
						public void onCloseClick(CloseClickEvent event) {
							popupWindow.destroy();
						}
					});
					Record [] records=grid.getRecords();
					panel.setRecords(records);
					panel.setRecord(record);
					panel.setBunessId(4);//项目差旅报销
					panel.initComponents();
					panel.lodaData();
					popupWindow.addItem(panel);
					panel.setParentWindow(popupWindow);
					popupWindow.centerInPage();
					popupWindow.show();
				}
			}
		});
		idx++;
		fields[idx] = new ListGridField("inputTaxRebate");
		idx++;
		fields[idx] = new ListGridField("finalAmount");
		fields[idx].setHidden(!editInputTax);
		grid.setHeaderHeight(60); 
		grid.setHeaderSpans(new HeaderSpan[] {
		   new HeaderSpan("费用分拆<font style=\"color:red; font-weight:bold\">【如有增值税专用发票，进项税必填，其他发票无需填写】</font>", new String[] {"projectId","contractCode","plateId","amount", "inputTax","inputTaxRebate", "finalAmount"})
	    });
		grid.setFields(fields);
		grid.setCanEdit(false);
		grid.setDataSource(DSTravelReimbursementLinkProject.getInstance());
		grid.setAutoFitFieldWidths(false);
		grid.setShowGridSummary(true);
		grid.addRemoveRecordClickHandler(new RemoveRecordClickHandler() {
			
			@Override
			public void onRemoveRecordClick(RemoveRecordClickEvent event) {
				int rowNum = event.getRowNum();
				Record record = grid.getRecord(rowNum);
				dealwithReimbursementInvoice(1, record);
				
			}
		});
		travelReimbursementDetails.addMember(grid);
		VLayout travelReimbursementDetailsControls = new VLayout();
		travelReimbursementDetailsControls.setHeight100();
		travelReimbursementDetailsControls.setWidth(60);
		travelReimbursementDetailsControls.setLayoutTopMargin(30);
		travelReimbursementDetailsControls.setLayoutLeftMargin(5);
		travelReimbursementDetailsControls.setLayoutRightMargin(5);
		travelReimbursementDetailsControls.setMembersMargin(10);
		travelReimbursementDetails.addMember(travelReimbursementDetailsControls);
		addMember(travelReimbursementDetails);
		IButton travelReimbursementDetailsNewButton = new IButton("新增");
		travelReimbursementDetailsNewButton.addClickHandler( new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				if(null != mainInfoPage){
					FormItem amountItem = mainInfoPage.findNamedItem("amount");
					FormItem employeeItem = mainInfoPage.findNamedItem("applicant");
					if(null != amountItem && null != employeeItem && null != amountItem.getValue()){
						//获取当前可以被分拆的金额总额
						BigDecimal amount = new BigDecimal(amountItem.getValue().toString());
						ListGridRecord[] records = grid.getRecords();
						//获取已经分摊了费用的项目
						Map projects = new HashMap();
						if(null != records){
							for(ListGridRecord record : records){
								if(null != record.getAttribute("amount")){
									amount = amount.subtract(new BigDecimal(record.getAttribute("amount")));
								}
								if(null != record.getAttribute("projectId")){
									projects.put(record.getAttribute("projectId"), null);
								}
							}
						}
						if(amount.compareTo(BigDecimal.ZERO)<=0){
							SC.warn("提示", "报销金额必须大于0才能添加项目");
							return;
						}
						final int employeeId = ClientUtil.checkAndGetIntValue(employeeItem.getValue());
						PopupWindow window = new PopupWindow();
						window.setWidth("35%");
						window.setHeight("45%");
						window.centerInPage();
						window.setTitle("新增项目");
						TravelReimbursementLinkProjectPanel panel = new TravelReimbursementLinkProjectPanel(false, null, editInputTax);
						if(BdRecord!=null) {
						panel.startEdit(BdRecord, employeeId, amount, projects, false);
						}else {
						panel.startEdit(null, employeeId, amount, projects, false);
						}
						panel.setParentWindow(window);
						panel.addDataEditedHandler(new DataEditedHandler() {
							@Override
							public void onDataEdited(DataEditEvent event) {
								Record record = event.getData();
								int tmpLinkKey = 0;
								if(BaseHelpUtils.isNullOrEmpty(record.getAttribute("invoiceLinkKey"))) {
									invoiceLinkKey ++;
									tmpLinkKey = invoiceLinkKey;
									record.setAttribute("invoiceLinkKey", tmpLinkKey);
								}
								RecordList list = grid.getDataAsRecordList();
								list.add(record);
								grid.setData(list);
								grid.redraw();
								dealwithReimbursementInvoice(3, record);
							}
						});
						window.addItem(panel);
						window.show();
					}else{
						SC.warn("提示", "没有填写报销人或者报销金额");
					}
				}
			}
		});
		
		IButton travelReimbursementDetailsUpdateButton = new IButton("修改");
		travelReimbursementDetailsUpdateButton.addClickHandler( new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				if(null != projectMap && !projectMap.isEmpty()){
					if(null != mainInfoPage && null != grid.getSelectedRecord()){
						FormItem amountItem = mainInfoPage.findNamedItem("amount");
						FormItem employeeItem = mainInfoPage.findNamedItem("applicant");
						if(null != amountItem && null != employeeItem && null != amountItem.getValue()){
							//获取当前可以被分拆的金额总额
							BigDecimal amount = new BigDecimal(amountItem.getValue().toString());
							ListGridRecord[] records = grid.getRecords();
							//获取已经分摊了费用的项目
							Map projects = new HashMap();
							if(null != records){
								for(ListGridRecord record : records){
									if(null != record.getAttribute("amount")){
										amount = amount.subtract(new BigDecimal(record.getAttribute("amount")));
									}
									if(null != record.getAttribute("projectId")){
										projects.put(record.getAttribute("projectId"), null);
									}
								}
							}
							ListGridRecord selected = grid.getSelectedRecord();
							projects.put(selected.getAttribute("projectId"), 1);
							final int employeeId = ClientUtil.checkAndGetIntValue(employeeItem.getValue());
							final int rowNo = grid.getRowNum(grid.getSelectedRecord());
							PopupWindow window = new PopupWindow();
							window.setWidth("35%");
							window.setHeight("45%");
							window.centerInPage();
							window.setTitle("修改项目");
							TravelReimbursementLinkProjectPanel panel = new TravelReimbursementLinkProjectPanel(true, projectMap, editInputTax);
							selected.setAttribute("leftAmount", amount);
							panel.startEdit(selected, employeeId, amount, projects, true);
							panel.setParentWindow(window);
							panel.addDataEditedHandler(new DataEditedHandler() {
								@Override
								public void onDataEdited(DataEditEvent event) {
									Record record = event.getData();
									int tmpLinkKey = 0;
									if(BaseHelpUtils.isNullOrEmpty(record.getAttribute("invoiceLinkKey"))) {
										invoiceLinkKey ++;
										tmpLinkKey = invoiceLinkKey;
										record.setAttribute("invoiceLinkKey", tmpLinkKey);
									} 
									RecordList list = grid.getDataAsRecordList();
									RecordList newList = new RecordList();
									int size = list.getLength();
									for(int i=0 ; i<size; i++){
										if(i == rowNo){
											newList.add(record);
										}else{
											newList.add(list.get(i));
										}
									}
									grid.setData(newList);
									grid.redraw();
									dealwithReimbursementInvoice(4, record);
								}
							});
							window.addItem(panel);
							window.show();
							initInvoiceListRecord(selected, panel);
						}else{
							SC.warn("提示", "没有填写报销人或者报销金额");
						}
					}
				}
			}
		});
		IButton travelReimbursementDetailsRemoveButton = new IButton("删除所有");
		travelReimbursementDetailsRemoveButton.addClickHandler( new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				grid.setData(new RecordList());
				dealwithReimbursementInvoice(2, record);
			}
		});
		IButton inputTaxButton = new IButton("录入进项发票");
		inputTaxButton.hide();
		if(null != processName && processName.contains("财务会计")){
			inputTaxButton.show();
		}
		inputTaxButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				PopupWindow window = new PopupWindow();
				window.setWidth("90%");
				window.setHeight("90%");
				window.centerInPage();
				window.setTitle("录入进项发票");
				ProcessInputTaxAmountPanel panel = new ProcessInputTaxAmountPanel();
				panel.setProcessType(getProcessType());
				panel.setCode(mainInfoPage.findNamedItem("code").getValue().toString());
				panel.setCompanyId(BaseHelpUtils.getIntValue(mainInfoPage.findNamedItem("companyId").getValue()));
				int __businessId = 0;
				switch (getProcessType()) {
				case 2:
					__businessId = BaseHelpUtils.getIntValue(mainInfoPage.findNamedItem("projectNormalReimbursementId").getValue());
					break;
				case 3:
					__businessId = BaseHelpUtils.getIntValue(mainInfoPage.findNamedItem("projectNormalReimbursementId").getValue());
					break;
				case 4:
					__businessId = BaseHelpUtils.getIntValue(mainInfoPage.findNamedItem("travelReimbursementId").getValue());
					break;
				case 5:
					__businessId = BaseHelpUtils.getIntValue(mainInfoPage.findNamedItem("travelReimbursementId").getValue());
					break;
				case 6:
					__businessId = BaseHelpUtils.getIntValue(mainInfoPage.findNamedItem("employeeMoneyManageId").getValue());
					break;
				case 7:
					__businessId = BaseHelpUtils.getIntValue(mainInfoPage.findNamedItem("payMoneyManageId").getValue());
					break;
				case 8:
					__businessId = BaseHelpUtils.getIntValue(mainInfoPage.findNamedItem("projectNormalReimbursementId").getValue());
					break;
				case 9:
					__businessId = BaseHelpUtils.getIntValue(mainInfoPage.findNamedItem("travelReimbursementId").getValue());
					break;
				case 10:
					__businessId = BaseHelpUtils.getIntValue(mainInfoPage.findNamedItem("projectNormalReimbursementId").getValue());
					break;
				default:
					break;
				}
				panel.setBusinessId(__businessId);
				panel.startEdit();
				panel.setFatherWindow(window);
				panel.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
//						Record record = event.getData();
//						RecordList list = grid.getDataAsRecordList();
//						RecordList newList = new RecordList();
//						int size = list.getLength();
//						for (int i = 0; i < size; i++) {
//							if (i == rowNo) {
//								newList.add(record);
//							} else {
//								newList.add(list.get(i));
//							}
//						}
//						grid.setData(newList);
//						grid.redraw();
					}
				});
				window.addItem(panel);
				window.show();
			}
		});
		travelReimbursementDetailsControls.addMember(travelReimbursementDetailsNewButton);
		travelReimbursementDetailsControls.addMember(travelReimbursementDetailsUpdateButton);
		travelReimbursementDetailsControls.addMember(travelReimbursementDetailsRemoveButton);
		travelReimbursementDetailsControls.addMember(inputTaxButton);
	}
	@Override
	public void startEdit() {
		if(getPageMode() != PAGE_MODE_UPDATE) return;
		reloadDetailTableData();
	}

	public void reloadDetailTableData(){
		Map condition = new HashMap();
		condition.put("travelReimbursementId", getRecord().getAttribute("travelReimbursementId"));
		DBDataSource.callOperation("ST_TravelReimbursementLinkProject", "find", condition, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0) {
					Record [] records = dsResponse.getData();
					initLinkKey(records);
					if(__startLoadedDetail != null) __startLoadedDetail.execute(dsResponse, data, dsRequest);
					grid.setData(records);
					if(__endLoadedDetail != null) __endLoadedDetail.execute(dsResponse, data, dsRequest);
				}
			}
		});
	}

	@Override
	public boolean checkData() {
		BigDecimal amount = BigDecimal.ZERO;
		BigDecimal inputTax = BigDecimal.ZERO;
		for (ListGridRecord r : grid.getRecords()) {
			__logger.info(MapUtils.convertRecordToMap(grid.getDataSource(), r).toString());
			amount = amount.add(BaseHelpUtils.getBigDecimalValue(r.getAttributeAsObject("amount")));
			inputTax = inputTax.add(BaseHelpUtils.getBigDecimalValue(r.getAttributeAsObject("inputTax")));
		}
		if(inputTax.compareTo(BigDecimal.ZERO) > 0 && amount.compareTo(BigDecimal.ZERO) > 0) {
			// 进项税不能超过报销总额的16%
			if(inputTax.compareTo(amount.multiply(new BigDecimal(0.16))) > 0) {
				SC.say("进项税不能超过报销总额的16%");
				return false;
			}
		}
		
//		if(null != getProcessName() && getProcessName().contains("财务会计")){
//			if(inputTax.compareTo(BigDecimal.ZERO)>0) {
//				Record recorda=grid.getRecords()[0];
//				if(recorda!=null) {
//					int travelReimbursementId=BaseHelpUtils.getIntValue(recorda.getAttribute("travelReimbursementId"));
//					Map<String,Object> params = new HashMap<>();
//					params.put("businessId",travelReimbursementId);
//					params.put("processType",processType);
//					Record[] records=SyncDataUtil.getValueByTableNames("ST_InputTaxRecord", "find", params);
//					if(!BaseHelpUtils.isNullOrEmpty(records)) {
//						return true;
//					}else {
//						SC.say("获取进项税记录失败！请单击列表中进项税贴入进项税记录");
//						return false;
//					}
//				}else {
//					SC.say("获取报销主键失败！");
//					return false;
//				}
//			}
//		}
		
		return true;
	}

	/**
	 * 初始化关联key
	 * @param record
	 */
	public void initLinkKey(Record [] record) {
		for (Record record2 : record) {
			int linkKey = BaseHelpUtils.getIntValue(record2.getAttribute("invoiceLinkKey"));
			if(linkKey > 0 && linkKey > invoiceLinkKey) {
				invoiceLinkKey = linkKey;
			}
		}
		for (Record record2 : record) {
			int linkKey = BaseHelpUtils.getIntValue(record2.getAttribute("invoiceLinkKey"));
			if(linkKey <= 0 ) {
				invoiceLinkKey ++;
				record2.setAttribute("invoiceLinkKey", invoiceLinkKey);
			}
		}
	}
	
	
	public void initInvoiceListRecord(Record record, TravelReimbursementLinkProjectPanel panel) {
		Integer invoiceLinkKey = record.getAttributeAsInt("invoiceLinkKey");
		if(null != invoiceLinkKey) {
			if(reimbursementInvoiceMap.containsKey(invoiceLinkKey)) {
				panel.initInvoiceRecords(record, reimbursementInvoiceMap.get(invoiceLinkKey));
			} else {
				Integer normalReimbursementLinkDepartmentId = record.getAttributeAsInt("travelReimbursementLinkProjectId");
				if(null != normalReimbursementLinkDepartmentId && null != getRecord()) {
					Map<String, Object> params = new HashMap<>();
					params.put("detailId", normalReimbursementLinkDepartmentId);
					params.put("processType", getProcessType());
					params.put("businessId", getRecord().getAttribute("travelReimbursementId"));
					DBDataSource.callOperation("ST_ReimbursementInvoiceInformation", "find", params, new DSCallback() {
						
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if(dsResponse.getStatus() >= 0 ) {
								reimbursementInvoiceMap.put(invoiceLinkKey, dsResponse.getData());
								panel.initInvoiceRecords(record, reimbursementInvoiceMap.get(invoiceLinkKey));
							} else {
								panel.initInvoiceRecords(record, null);
							}
						}
					});
				} else {
					panel.initInvoiceRecords(record, null);
				}
			}
		} else {
			panel.initInvoiceRecords(record, null);
		}
		
	}

	/**
	 * 处理报销费用清单相关联的发票信息
	 * @param operateType
	 * @param record
	 */
	public void dealwithReimbursementInvoice(int operateType, Record record) {
		int tmpLinkKey = BaseHelpUtils.getIntValue(record.getAttribute("invoiceLinkKey"));
		Record[] invoiceListMap = record.getAttributeAsRecordArray("invoiceList");
		switch (operateType) {
		case 1: // 单条删除
			if(reimbursementInvoiceMap.containsKey(tmpLinkKey)) {
				reimbursementInvoiceMap.put(tmpLinkKey, new Record[0]);
			}
			break;
		case 2: // 全部删除
			for (Integer key : reimbursementInvoiceMap.keySet()) {
				reimbursementInvoiceMap.put(key, new Record[0]);
			}
			break;
		case 3: // 新增
		case 4: // 修改
			String haveElectronicInvoice = record.getAttribute("haveElectronicInvoice");
			String inputTax = record.getAttribute("inputTax");
			// 如果有电子发票 或有进项税
			if((!BaseHelpUtils.isNullOrEmpty(haveElectronicInvoice) && haveElectronicInvoice.equals("2"))
					|| (!BaseHelpUtils.isNullOrEmpty(inputTax) && new BigDecimal(inputTax).compareTo(BigDecimal.ZERO) > 0)) {
				if(!BaseHelpUtils.isNullOrEmpty(invoiceListMap) && invoiceListMap.length > 0) {
					reimbursementInvoiceMap.put(tmpLinkKey, invoiceListMap);
				} else {
					if(operateType == 4) {
						if(reimbursementInvoiceMap.containsKey(tmpLinkKey)) {
							reimbursementInvoiceMap.put(tmpLinkKey, new Record[0]);
						}
					}
				}
			} else {
				if(!BaseHelpUtils.isNullOrEmpty(invoiceListMap)) {
					reimbursementInvoiceMap.put(tmpLinkKey, invoiceListMap);
				}
			}
			break;
		default:
			break;
		}
	}
	
	@Override
	public Set<String> getItemNames() {
		Set<String> res = new HashSet<>();
		res.add("detailTravelReimbursementLinkProjectDetail");
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
		MapUtils.convertRecordToMap(grid.getDataSource(), rows, param, "detailTravelReimbursementLinkProject");
		if(BdRecord!=null) {
			int budgetManagementId=0;
			int budgetAttachmentId=0;
			int paymentSequenceId=0;
			//获取预算管理Id
			 budgetManagementId=BaseHelpUtils.getIntValue(BdRecord.getAttribute("budgetManagementId"));
			//获取附件id
			 budgetAttachmentId=BaseHelpUtils.getIntValue(BdRecord.getAttribute("budgetAttachmentId"));
			//获取付款序列id
			 paymentSequenceId=BaseHelpUtils.getIntValue(BdRecord.getAttribute("paymentSequenceId"));
			 param.put("budgetManagementId",budgetManagementId);
			 param.put("budgetAttachmentId",budgetAttachmentId);
			 param.put("paymentSequenceId",paymentSequenceId);
		}
		Map<Integer, Map> invoiceListMap = new HashMap<>();
		for (Integer key : reimbursementInvoiceMap.keySet()) {
			Map tmpMap = new HashMap();
			Record[] valueRecordArr = reimbursementInvoiceMap.get(key);
			MapUtils.convertRecordToMap(DSReimbursementInvoiceInformation.getInstance(), valueRecordArr, tmpMap, "invoiceList");
			invoiceListMap.put(key, tmpMap);
		}
		param.put("invoiceListMap", invoiceListMap);
		return param;
	}

	@Override
	public String getName() {
		return "";
	}

	public DSCallback getStartLoadedDetail() {
		return this.__startLoadedDetail;
	}

	public void setStartLoadedDetail( DSCallback value ) {
		this.__startLoadedDetail = value;
	}

	public DSCallback getEndLoadedDetail() {
		return this.__endLoadedDetail;
	}

	public void setEndLoadedDetail( DSCallback value ) {
		this.__endLoadedDetail = value;
	}

	public DelicacyListGrid getGrid() {
		return this.grid;
	}

	public void setGrid( DelicacyListGrid value ) {
		this.grid = value;
	}

	public AbstractWizadPage getMainInfoPage() {
		return mainInfoPage;
	}

	public void setMainInfoPage(AbstractWizadPage mainInfoPage) {
		this.mainInfoPage = mainInfoPage;
	}

	public Integer getProcessType() {
		return processType;
	}

	public void setProcessType(Integer processType) {
		this.processType = processType;
	}
	
	private Record BdRecord;

	public Record getBdRecord() {
		return BdRecord;
	}

	public void setBdRecord(Record BdRecord) {
		this.BdRecord = BdRecord;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}
	
	
	
}

