package com.pomplatform.client.workflow.projectNormalReimbursement.form;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.DownloadFileByUrl;
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
import com.pomplatform.client.workflow.datasource.DSReimbursementInvoiceInformation;
import com.pomplatform.client.workflow.panel.ProcessInputTaxAmountPanel;
import com.pomplatform.client.workflow.projectNormalReimbursement.datasource.DSNormalReimbursementLinkProject;
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

public class NormalReimbursementLinkProjectPanel extends AbstractWizadPage
{

	private static final Logger __logger = Logger.getLogger("");
	private DSCallback __startLoadedDetail;
	private DSCallback __endLoadedDetail;
	private DelicacyListGrid grid = new DelicacyListGrid(true);
	private AbstractWizadPage mainInfoPage;
	private AbstractWizadPage billInfoPage;
	private final LinkedHashMap<String, String> mainItemMap = new LinkedHashMap<>();
	private final LinkedHashMap<String, String> subItemMap = new LinkedHashMap<>();
	private NormalReimbursementLinkProjectPanel departmentPanel;
	private final LinkedHashMap<Integer, String> projectMap = new LinkedHashMap<>();
	private Integer processType;
	private ProjectNormalReimbursementDetailPanel detailInfoPage;
	private Record initData;
	private String processName;
	
	private int invoiceLinkKey = 0;

	// 进项税发票信息 存储跟费用分拆相关数据进行关联
	private Map<Integer, Record[]> reimbursementInvoiceMap = new HashMap<>();

	public Record getInitData() {
		return initData;
	}

	public void setInitData(Record initData) {
		this.initData = initData;
	}

	private int processId = 0;
	private int departmentId =0;
	//private IButton payseqbut;
	private int budgetManagementId=0;//预算单ID
	
	public NormalReimbursementLinkProjectPanel(){
		initPanel(false, null);
	}
	public NormalReimbursementLinkProjectPanel(boolean editInputTax, String processName){
		initPanel(editInputTax, processName);
		setProcessName(processName);
	}

	public void initPanel(boolean editInputTax, String processName){
		//加载项目数据，以供费用分拆时使用
		Map<String, Object> map = new HashMap<>();
		DBDataSource.callOperation("EP_GetProjectByProjectName", map, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record[] record = dsResponse.getData();
					for (Record obj : record) {
						projectMap.put(obj.getAttributeAsInt("projectId"), obj.getAttribute("projectName"));
					}
				}
			}
		});
		
		__dataGrid = grid;

		HLayout normalReimbursementLinkProjects = new HLayout();
		normalReimbursementLinkProjects.setWidth100();
		normalReimbursementLinkProjects.setHeight100();
		ListGridField[] fields = new ListGridField[10];
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
					panel.initComponents();
					panel.setBunessId(2);//项目日常报销
					//panel.initComponents();
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
		   new HeaderSpan("项目日常报销费用清单<font style=\"color:red; font-weight:bold\">【如有增值税专用发票，进项税必填，其他发票无需填写】</font>", new String[] {"mainItemId","subItemId","remark","projectId","contractCode","plateId","amount","inputTax","inputTaxRebate","finalAmount"})
	    });
		grid.setFields(fields);
		grid.setCanEdit(false);
		grid.setShowGridSummary(true);
		grid.setDataSource(DSNormalReimbursementLinkProject.getInstance());
		grid.setAutoFitFieldWidths(false);
		
		grid.addRemoveRecordClickHandler(new RemoveRecordClickHandler() {
			@Override
			public void onRemoveRecordClick(RemoveRecordClickEvent event) {
				int rowNum = event.getRowNum();
				Record record = grid.getRecord(rowNum);
				dealwithReimbursementInvoice(1, record);
				//获取当前删除行数据的报销科目和报销选项和费用
				int mainItemId = BaseHelpUtils.getIntValue(record.getAttribute("mainItemId"));
				int subItemId = BaseHelpUtils.getIntValue(record.getAttribute("subItemId"));
				BigDecimal amount = BaseHelpUtils.getBigDecimalValue(record.getAttribute("amount"));
				String remark = BaseHelpUtils.getString(record.getAttribute("remark"));
				String contractCode = BaseHelpUtils.getString(record.getAttribute("contractCode"));
				if(amount.compareTo(BigDecimal.ZERO) == 0){
					return;
				}
				//获取报销费用清单gird数据
				ProjectNormalReimbursementDetailPanel detailePanel = getDetailInfoPage();
				AbstractWizadPage mainPanel = getMainInfoPage();
				DelicacyListGrid detailGrid = detailePanel.getGrid();
				Record[] records = detailGrid.getRecords();
				if(!BaseHelpUtils.isNullOrEmpty(records)){
					for(Record r : records){
						int mainItemIdDetail = BaseHelpUtils.getIntValue(r.getAttribute("mainItemId"));
						int subItemIdDetail = BaseHelpUtils.getIntValue(r.getAttribute("subItemId"));
						String remarkDetail = BaseHelpUtils.getString(r.getAttribute("remark"));
						BigDecimal amountDetail = BaseHelpUtils.getBigDecimalValue(r.getAttribute("amount"));
						String identification = BaseHelpUtils.getString(r.getAttribute("identification"));
						//报销科目和报销选项以及摘要相同的删除
						if(mainItemId == mainItemIdDetail && subItemId == subItemIdDetail && remark.equals(remarkDetail) && amount.equals(amountDetail) && identification.equals(contractCode)){
							BigDecimal amountDetail1 = BaseHelpUtils.getBigDecimalValue(r.getAttribute("amount"));
							BigDecimal newAmount = amountDetail1.subtract(amount);
							BigDecimal amount1 = BaseHelpUtils.getBigDecimalValue(mainInfoPage.findNamedItem("amount").getValue());
							BigDecimal newAmount2 = amount1.subtract(amount);
							mainPanel.findNamedItem("amount").setValue(newAmount2);
							detailGrid.removeData(r);
						}
						
					}
				}
				detailGrid.redraw();
/*************************************************原本需要合并***********************/				
//				int rowNum = event.getRowNum();
//				Record record = grid.getRecord(rowNum);
//				//获取当前删除行数据的报销科目和报销选项和费用
//				int mainItemId = BaseHelpUtils.getIntValue(record.getAttribute("mainItemId"));
//				int subItemId = BaseHelpUtils.getIntValue(record.getAttribute("subItemId"));
//				BigDecimal amount = BaseHelpUtils.getBigDecimalValue(record.getAttribute("amount"));
//				if(amount.compareTo(BigDecimal.ZERO) == 0){
//					return;
//				}
//				//获取报销费用清单gird数据
//				ProjectNormalReimbursementDetailPanel detailePanel = getDetailInfoPage();
//				AbstractWizadPage mainPanel = getMainInfoPage();
//				DelicacyListGrid detailGrid = detailePanel.getGrid();
//				Record[] records = detailGrid.getRecords();
//				if(!BaseHelpUtils.isNullOrEmpty(records)){
//					for(Record r : records){
//						int mainItemIdDetail = BaseHelpUtils.getIntValue(r.getAttribute("mainItemId"));
//						int subItemIdDetail = BaseHelpUtils.getIntValue(r.getAttribute("subItemId"));
//						if(mainItemId == mainItemIdDetail && subItemId == subItemIdDetail){
//							BigDecimal amountDetail = BaseHelpUtils.getBigDecimalValue(r.getAttribute("amount"));
//							BigDecimal newAmount = amountDetail.subtract(amount);
//							BigDecimal amount1 = BaseHelpUtils.getBigDecimalValue(mainInfoPage.findNamedItem("amount").getValue());
//							BigDecimal newAmount2 = amount1.subtract(amount);
//							mainPanel.findNamedItem("amount").setValue(newAmount2);
//							if(newAmount.compareTo(BigDecimal.ZERO) == 0){
//								detailGrid.removeData(r);
//							}else{
//								r.setAttribute("amount", newAmount);
//								detailGrid.updateData(r);
//								departmentPanelInfoChange(new BigDecimal("0"));
//							}
//							detailGrid.redraw();
//							break;
//						}
//						
//					}
//				}
			}
		});
		
		
		normalReimbursementLinkProjects.addMember(grid);
		VLayout normalReimbursementLinkProjectsControls = new VLayout();
		normalReimbursementLinkProjectsControls.setHeight100();
		normalReimbursementLinkProjectsControls.setWidth(60);
		normalReimbursementLinkProjectsControls.setLayoutTopMargin(30);
		normalReimbursementLinkProjectsControls.setLayoutLeftMargin(5);
		normalReimbursementLinkProjectsControls.setLayoutRightMargin(5);
		normalReimbursementLinkProjectsControls.setMembersMargin(10);
		normalReimbursementLinkProjects.addMember(normalReimbursementLinkProjectsControls);
		addMember(normalReimbursementLinkProjects);
		IButton normalReimbursementLinkProjectsNewButton = new IButton("新增");
		normalReimbursementLinkProjectsNewButton.addClickHandler( new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				if (null != mainInfoPage) {
					final PopupWindow window = new PopupWindow("新增报销信息");
					window.setWidth(550);
					window.setHeight(560);
					window.centerInPage();
					int newDepartmentId = ClientUtil
							.checkAndGetIntValue(mainInfoPage.findNamedItem("departmentId").getValue());
					if (departmentId != newDepartmentId) {
						newWindowWithDBDataSource(window, newDepartmentId, new Record(), false,editInputTax);
					} else {
						newWindowWithoutDBDataSource(window, new Record(), false,editInputTax);
					}
					
				}else{
					SC.warn("提示", "没有填写报销人");
				}
/*********************************原有的报销的逻辑*************************************/				
//				if(null != mainInfoPage){
//					FormItem amountItem = mainInfoPage.findNamedItem("amount");
//					FormItem employeeItem = mainInfoPage.findNamedItem("employeeId");
//					if(null != amountItem && null != employeeItem && null != amountItem.getValue()){
//						//获取当前可以被分拆的金额总额
//						BigDecimal amount = new BigDecimal(amountItem.getValue().toString());
//						ListGridRecord[] records = grid.getRecords();
//						//获取已经分摊了费用的项目
//						Map projects = new HashMap();
//						if(null != records){
//							for(ListGridRecord record : records){
//								if(null != record.getAttribute("amount")){
//									amount = amount.subtract(new BigDecimal(record.getAttribute("amount")));
//								}
//								if(null != record.getAttribute("projectId")){
//									projects.put(record.getAttribute("projectId"), null);
//								}
//							}
//						}
//						if(amount.compareTo(BigDecimal.ZERO)<=0){
//							SC.warn("提示", "报销金额必须大于0才能添加项目");
//							return;
//						}
//						final int employeeId = ClientUtil.checkAndGetIntValue(employeeItem.getValue());
//						PopupWindow window = new PopupWindow();
//						window.setWidth("30%");
//						window.setHeight("35%");
//						window.centerInPage();
//						window.setTitle("新增项目");
//						NormalReimbursementLinkProjectPopupPanel panel = new NormalReimbursementLinkProjectPopupPanel(false, null, editInputTax);
//						panel.startEdit(null, employeeId, amount, projects, false);
//						panel.setParentWindow(window);
//						panel.addDataEditedHandler(new DataEditedHandler() {
//							@Override
//							public void onDataEdited(DataEditEvent event) {
//								Record record = event.getData();
//								RecordList list = grid.getDataAsRecordList();
//								list.add(record);
//								grid.setData(list);
//								grid.redraw();
//							}
//						});
//						window.addItem(panel);
//						window.show();
//					}else{
//						SC.warn("提示", "没有填写报销人或者报销金额");
//					}
//				}
			}
		});
		
		IButton downloadTemplate = new IButton("下载模板");
		downloadTemplate.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
            	DownloadFileByUrl.download("/files/linkProject.xlsx");
            }
        });
		
		IButton importBtn = new IButton("导入");
		importBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				int departmentId = ClientUtil.getDepartmentId();
				Map<String,Object> param = new HashMap<>();
				param.put("opt_type", "onUploadLinkProject");
				param.put("departmentId", departmentId);
				UploadReimburseData uploadXls = new UploadReimburseData("费用分拆导入", param, DBDataSource.getServerURL("UP_OnUploadReimbursementDataProcess"));
				uploadXls.setGrid(grid);
				ProjectNormalReimbursementDetailPanel detailePanel = getDetailInfoPage();
				DelicacyListGrid detailGrid = detailePanel.getGrid();
				RecordList recordList = new RecordList();
				uploadXls.setReturnDataListen(new UploadReimburseReturnListen() {
					@Override
					public void returnData(Record[] records) {
						BigDecimal amount = BigDecimal.ZERO;
						for (Record record : records){
							Record detailRecord = new Record();
							detailRecord.setAttribute("mainItemId" ,  BaseHelpUtils.getIntValue(record.getAttribute("mainItemId")));
							detailRecord.setAttribute("subItemId" ,  BaseHelpUtils.getIntValue(record.getAttribute("subItemId")));
							detailRecord.setAttribute("remark" ,  BaseHelpUtils.getString(record.getAttribute("remark")));
							BigDecimal tempAmount = BaseHelpUtils.getBigDecimalValue(record.getAttribute("amount"));
							detailRecord.setAttribute("amount" ,  tempAmount);
							detailRecord.setAttribute("identification" ,  BaseHelpUtils.getString(record.getAttribute("contractCode")));
							recordList.add(detailRecord);
							amount = amount.add(tempAmount);
						}
						if(null != mainInfoPage)
							mainInfoPage.findNamedItem("amount").setValue(amount);
					}
				});
				detailGrid.setData(recordList);
				detailGrid.redraw();
				uploadXls.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						Record record = event.getData();
						if(record.getAttributeAsInt("status") == 2){
							SC.say(record.getAttribute("errorMsg"));
						}
					}
				});
				uploadXls.show();

			}
		});

		IButton normalReimbursementLinkProjectsUpdateButton = new IButton("修改");
		normalReimbursementLinkProjectsUpdateButton.addClickHandler( new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				if(null != projectMap && !projectMap.isEmpty()){
					if(null != mainInfoPage && null != grid.getSelectedRecord()){
						FormItem amountItem = mainInfoPage.findNamedItem("amount");
						FormItem employeeItem = mainInfoPage.findNamedItem("employeeId");
						if(null != amountItem && null != employeeItem && null != amountItem.getValue()){
							//获取当前可以被分拆的金额总额
							BigDecimal amount = new BigDecimal(amountItem.getValue().toString());
							ListGridRecord[] records = grid.getRecords();
							//获取已经分摊了费用的项目
							Map projects = new HashMap();
							if(null != records){
								for(ListGridRecord record : records){
//									if(null != record.getAttribute("amount")){
//										amount = amount.subtract(new BigDecimal(record.getAttribute("amount")));
//									}
									if(null != record.getAttribute("projectId")){
										projects.put(record.getAttribute("projectId"), null);
									}
								}
							}
							FormItem departmentItem = mainInfoPage.findNamedItem("departmentId");
							departmentId = ClientUtil.checkAndGetIntValue(departmentItem.getValue());
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
									
										ListGridRecord selected = grid.getSelectedRecord();
										projects.put(selected.getAttribute("projectId"), 1);
										final int employeeId = ClientUtil.checkAndGetIntValue(employeeItem.getValue());
										final int rowNo = grid.getRowNum(grid.getSelectedRecord());
										PopupWindow window = new PopupWindow();
										window.setWidth(550);
										window.setHeight(560);
										window.centerInPage();
										window.setTitle("修改项目");
										NormalReimbursementLinkProjectPopupPanel panel = new NormalReimbursementLinkProjectPopupPanel(true, projectMap, editInputTax,mainItemMap, subItemMap);
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
												updateDetailPanel(record,selected);
												grid.redraw();
												dealwithReimbursementInvoice(4, record);
											}
										});
										window.addItem(panel);
										window.show();
										initInvoiceListRecord(selected, panel);
									
									} else {
										SC.say(dsResponse.getErrors().get("errorMsg").toString());
									}
								}
							});
							
							
							
						}else{
							SC.warn("提示", "没有填写报销人或者报销金额");
						}
					}
				}else{
					SC.warn("提示","数据加载中，请稍后再点击修改按钮");
				}
			}
		});
		
		IButton normalReimbursementLinkProjectsRemoveButton = new IButton("删除所有");
		normalReimbursementLinkProjectsRemoveButton.addClickHandler( new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				grid.setData(new RecordList());
				AbstractWizadPage mainPanel = getMainInfoPage();
				ProjectNormalReimbursementDetailPanel panle = getDetailInfoPage();
				mainPanel.findNamedItem("amount").setValue(new BigDecimal("0"));
				panle.getGrid().setData(new RecordList());
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
		/*payseqbut=new IButton("付款序列");
		payseqbut.hide();
		payseqbut.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(bdrecord!=null) {
					budgetManagementId=bdrecord.getAttributeAsInt("budgetManagementId");
				}
				final PopupWindow popupWindow = new PopupWindow("查看绑定的付款序列");
				popupWindow.setWidth("70%");
				popupWindow.setHeight("70%");
				popupWindow.centerInPage();
				OnNrPaymentSequenceinfoPanel nrpaySeqPanel = new OnNrPaymentSequenceinfoPanel();
				nrpaySeqPanel.setBudgetManagementId(budgetManagementId);;
				nrpaySeqPanel.initComponents();
				nrpaySeqPanel.lodaDate();
				popupWindow.addItem(nrpaySeqPanel);
				nrpaySeqPanel.setParentWindow(popupWindow);
				popupWindow.centerInPage();
				popupWindow.show();
			}
		});*/

		
		
		
		normalReimbursementLinkProjectsControls.addMember(normalReimbursementLinkProjectsNewButton);
		normalReimbursementLinkProjectsControls.addMember(normalReimbursementLinkProjectsUpdateButton);
		normalReimbursementLinkProjectsControls.addMember(normalReimbursementLinkProjectsRemoveButton);
		normalReimbursementLinkProjectsControls.addMember(inputTaxButton);
		normalReimbursementLinkProjectsControls.addMember(importBtn);
		normalReimbursementLinkProjectsControls.addMember(downloadTemplate);
		//normalReimbursementLinkProjectsControls.addMember(payseqbut);
	}
	
	//修改时更改detailPanel的数据
			public void updateDetailPanel(Record record,Record selectedRecord){
				RecordList recordList = new RecordList();
				//修改后的数据
		 		int mainItemIdNew = BaseHelpUtils.getIntValue(record.getAttribute("mainItemId"));
				int subItemIdNew = BaseHelpUtils.getIntValue(record.getAttribute("subItemId"));
				String remarkNew = BaseHelpUtils.getString(record.getAttribute("remark"));
				BigDecimal amountNew = BaseHelpUtils.getBigDecimalValue(record.getAttribute("amount"));
				String contractCodeNew = BaseHelpUtils.getString(record.getAttribute("contractCode"));
				//修改前的数据
				int mainItemIdOld = BaseHelpUtils.getIntValue(selectedRecord.getAttribute("mainItemId"));
				int subItemIdOld = BaseHelpUtils.getIntValue(selectedRecord.getAttribute("subItemId"));
				String remarkOld = BaseHelpUtils.getString(selectedRecord.getAttribute("remark"));
				BigDecimal amountOld = BaseHelpUtils.getBigDecimalValue(selectedRecord.getAttribute("amount"));
				String contractCodeOld = BaseHelpUtils.getString(selectedRecord.getAttribute("contractCode"));

				ProjectNormalReimbursementDetailPanel detailePanel = getDetailInfoPage();
				DelicacyListGrid detailGrid = detailePanel.getGrid();
				Record[] records = detailGrid.getRecords();
				for (Record record2 : records) {
					int mainItemIdDetail = BaseHelpUtils.getIntValue(record2.getAttribute("mainItemId"));
					int subItemIdNewDetail = BaseHelpUtils.getIntValue(record2.getAttribute("subItemId"));
					String remarkNewDetail = BaseHelpUtils.getString(record2.getAttribute("remark"));
					BigDecimal amountNewDetail = BaseHelpUtils.getBigDecimalValue(record2.getAttribute("amount"));
					String identificationDetail = BaseHelpUtils.getString(record2.getAttribute("identification"));
					//删除报销科目和报销选项以及摘要以及报销金额相同的一条数据(暂时存在一个问题就是以上几个条件都相同的时候就会全删除。。。)
					if (mainItemIdDetail == mainItemIdOld && subItemIdNewDetail == subItemIdOld && remarkNewDetail.equals(remarkOld) && amountNewDetail.equals(amountOld) && identificationDetail.equals(contractCodeOld)) {
						detailGrid.removeData(record2);
						break;
					}
				}
				detailGrid.redraw();
				
				//新增一条新的数据
				ProjectNormalReimbursementDetailPanel detailePanel1 = getDetailInfoPage();
				DelicacyListGrid detailGrid1 = detailePanel1.getGrid();
				Record[] records2 = detailGrid1.getRecords();
				for (Record record2 : records2) {
					recordList.add(record2);
				}
				Record record2 = new Record();
				if (mainItemIdNew != 0) {
					record2.setAttribute("mainItemId", mainItemIdNew);
				}
				if (subItemIdNew != 0) {
					record2.setAttribute("subItemId", subItemIdNew);
				}
				record2.setAttribute("amount", amountNew);
				record2.setAttribute("remark", remarkNew);
				record2.setAttribute("identification",contractCodeNew);
				recordList.add(record2);
				detailGrid1.setData(recordList);
				detailGrid1.redraw();
				//修改主面板的报销的金额
				detailGrid.redraw();
				Record[] records3 = detailGrid.getRecords();
				BigDecimal leftAmount = new BigDecimal("0");
				SC.debugger();
				for (Record record3 : records3) {
					BigDecimal tempAmount = BaseHelpUtils.getBigDecimalValue(record3.getAttribute("amount"));
					leftAmount = leftAmount.add(tempAmount);
				}
				AbstractWizadPage mainPanel = getMainInfoPage();
				mainPanel.findNamedItem("amount").setValue(leftAmount);
/****************************************合并的逻辑*********************************/				
//				Boolean flag = false;
//				RecordList recordList = new RecordList();
//		 		int mainItemIdNew = BaseHelpUtils.getIntValue(record.getAttribute("mainItemId"));
//				int subItemIdNew = BaseHelpUtils.getIntValue(record.getAttribute("subItemId"));
//				int mainItemIdOld = BaseHelpUtils.getIntValue(selectedRecord.getAttribute("mainItemId"));
//				int subItemIdOld = BaseHelpUtils.getIntValue(selectedRecord.getAttribute("subItemId"));
//				BigDecimal amountNew = BaseHelpUtils.getBigDecimalValue(record.getAttribute("amount"));
//				BigDecimal amountOld = BaseHelpUtils.getBigDecimalValue(selectedRecord.getAttribute("amount"));
//				ProjectNormalReimbursementDetailPanel detailePanel = getDetailInfoPage();
//				DelicacyListGrid detailGrid = detailePanel.getGrid();
//				Record[] records = detailGrid.getRecords();
//				//只修改了报销的金额，没有修改报销科目和报销选项
//				if (mainItemIdNew == mainItemIdOld && subItemIdNew == subItemIdOld) {
//					BigDecimal tempAmount = amountNew.subtract(amountOld);
//					for (Record recordDetail : records) {
//						int mainItemIdDetail = BaseHelpUtils.getIntValue(recordDetail.getAttribute("mainItemId"));
//						int subItemIdDetail = BaseHelpUtils.getIntValue(recordDetail.getAttribute("subItemId"));
//						//寻找到相同的报销科目和报销选项
//						if (mainItemIdDetail == mainItemIdNew && subItemIdDetail == subItemIdNew) {
//							BigDecimal amount1 = BaseHelpUtils.getBigDecimalValue(recordDetail.getAttribute("amount"));
//							BigDecimal amountSure = amount1.add(tempAmount);
//							recordDetail.setAttribute("amount", amountSure);
//							detailGrid.updateData(recordDetail);
//						}
//					}
//				}//修改了报销的科目和报销的选项
//				else{
//					for (Record recordDetail : records) {
//						int mainItemIdDetail = BaseHelpUtils.getIntValue(recordDetail.getAttribute("mainItemId"));
//						int subItemIdDetail = BaseHelpUtils.getIntValue(recordDetail.getAttribute("subItemId"));
//						if (mainItemIdNew == mainItemIdDetail && subItemIdNew == subItemIdDetail) {
//							flag = true;
//						}
//					}
//					//修改过后的报销科目以及报销选项和原有的相同（旧的数据需要减，新的数据需要相加）
//					if (flag) {
//						//找到detail中相同的报销科目直接加上修改后的金额
//						for (Record recordDetail : records) {
//							int mainItemIdDetail = BaseHelpUtils.getIntValue(recordDetail.getAttribute("mainItemId"));
//							int subItemIdDetail = BaseHelpUtils.getIntValue(recordDetail.getAttribute("subItemId"));
//							if (mainItemIdDetail == mainItemIdNew && subItemIdDetail == subItemIdNew) {
//								BigDecimal amountDetail = BaseHelpUtils.getBigDecimalValue(recordDetail.getAttribute("amount"));
//								BigDecimal tempAmount = amountDetail.add(amountNew);
//								recordDetail.setAttribute("amount", tempAmount);
//								detailGrid.updateData(recordDetail);
//							}
//						}
//						//找到修改之间旧的数据更改金额
//						for (Record recordDetail : records) {
//							int mainItemIdDetail = BaseHelpUtils.getIntValue(recordDetail.getAttribute("mainItemId"));
//							int subItemIdDetail = BaseHelpUtils.getIntValue(recordDetail.getAttribute("subItemId"));
//							if (mainItemIdDetail == mainItemIdOld && subItemIdDetail == subItemIdOld) {
//								BigDecimal amountDetail = BaseHelpUtils.getBigDecimalValue(recordDetail.getAttribute("amount"));
//								BigDecimal tempaAmount = amountDetail.subtract(amountOld);
//								//如果减去等于0就删除
//								if(tempaAmount.compareTo(BigDecimal.ZERO) == 0){
//									detailGrid.removeData(recordDetail);
//								}else{
//									recordDetail.setAttribute("amount", tempaAmount);
//									detailGrid.updateData(recordDetail);
//								}
//							}
//						}
//					}
//					//修改过后的报销科目以及报销选项没有和原有的相同（旧的数据需要减。新曾一条数据）
//					else{
//						//找到修改之间旧的数据更改金额
//						for (Record recordDetail : records) {
//							int mainItemIdDetail = BaseHelpUtils.getIntValue(recordDetail.getAttribute("mainItemId"));
//							int subItemIdDetail = BaseHelpUtils.getIntValue(recordDetail.getAttribute("subItemId"));
//							if (mainItemIdDetail == mainItemIdOld && subItemIdDetail == subItemIdOld) {
//								BigDecimal amountDetail = BaseHelpUtils.getBigDecimalValue(recordDetail.getAttribute("amount"));
//								BigDecimal tempaAmount = amountDetail.subtract(amountOld);
//								//如果减去等于0就删除
//								SC.debugger();
//								if(tempaAmount.compareTo(BigDecimal.ZERO) == 0){
//									detailGrid.removeData(recordDetail);
//								}else{
//									recordDetail.setAttribute("amount", tempaAmount);
//									detailGrid.updateData(recordDetail);
//								}
//							}
//						}
//						detailGrid.redraw();
//						//新增一条数据
////						ProjectNormalReimbursementDetailPanel detailePanel1 = getDetailInfoPage();
////						DelicacyListGrid detailGrid1 = detailePanel1.getGrid();
//						Record[] records2 = detailGrid.getRecords();
//						Record record2 = new Record();
//						record2.setAttribute("mainItemId", mainItemIdNew);
//						record2.setAttribute("subItemId", subItemIdNew);
//						record2.setAttribute("amount", amountNew);
//						for (Record recordDetail : records2) {
//							recordList.add(recordDetail);
//						}
//						recordList.add(record2);
//						detailGrid.setData(recordList);
//					}
//				}
//				detailGrid.redraw();
//				Record[] records2 = detailGrid.getRecords();
//				BigDecimal leftAmount = new BigDecimal("0");
//				SC.debugger();
//				for (Record record2 : records2) {
//					BigDecimal tempAmount = BaseHelpUtils.getBigDecimalValue(record2.getAttribute("amount"));
//					leftAmount = leftAmount.add(tempAmount);
//				}
//				AbstractWizadPage mainPanel = getMainInfoPage();
//				mainPanel.findNamedItem("amount").setValue(leftAmount);
				}
	
	public void newWindowWithDBDataSource(final PopupWindow window, final int departmentId, final Record editRecord,
			final boolean update,boolean editInputTax) {
		FormItem amountItem = mainInfoPage.findNamedItem("amount");
		FormItem employeeItem = mainInfoPage.findNamedItem("employeeId");
		final int employeeId = ClientUtil.checkAndGetIntValue(employeeItem.getValue());
		ListGridRecord[] records = grid.getRecords();
		Map projects = new HashMap();
		if(null != records){
			for(ListGridRecord record : records){
				if(null != record.getAttribute("projectId")){
					projects.put(record.getAttribute("projectId"), null);
				}
			}
		}
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
					NormalReimbursementLinkProjectPopupPanel panel = new NormalReimbursementLinkProjectPopupPanel(false, null, editInputTax,mainItemMap, subItemMap);
					panel.startEdit(bdrecord, employeeId, null, projects, false);
//					panel.startEdit();
				//panel.setBdrecord(bdrecord);
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
							if (update) {
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
								dealwithReimbursementInvoice(4, record);
							} else {
								/*__logger.info("外面record+++++++++++++++++++++++++++++++++++++++++++++++++++"+record.toMap());
								 budgetManagementId=BaseHelpUtils.getIntValue(record.getAttribute("budgetManagementId"));
								 __logger.info("budgetManagementId+++++++++++++++++++++++++++++++++++++++++++++++++++"+budgetManagementId);*/
								/*if(budgetManagementId>0) {
									payseqbut.show();
								}*/
								
								RecordList list = grid.getDataAsRecordList();
								list.add(record);
								grid.setData(list);
								dealwithReimbursementInvoice(3, record);
								initDetailPanelDate(record);
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

	public void newWindowWithoutDBDataSource(final PopupWindow window, final Record editRecord, final boolean update ,boolean editInputTax) {
		FormItem amountItem = mainInfoPage.findNamedItem("amount");
		FormItem employeeItem = mainInfoPage.findNamedItem("employeeId");
		final int employeeId = ClientUtil.checkAndGetIntValue(employeeItem.getValue());
		ListGridRecord[] records = grid.getRecords();
		Map projects = new HashMap();
		if(null != records){
			for(ListGridRecord record : records){
				if(null != record.getAttribute("projectId")){
					projects.put(record.getAttribute("projectId"), null);
				}
			}
		}
		NormalReimbursementLinkProjectPopupPanel panel = new NormalReimbursementLinkProjectPopupPanel(false, null, editInputTax,mainItemMap, subItemMap);
		panel.startEdit(bdrecord, employeeId, null, projects, false);
		//panel.setBdrecord(bdrecord);
//		panel.startEdit(editRecord);
		panel.addDataEditedHandler(new DataEditedHandler() {
			@Override
			public void onDataEdited(DataEditEvent event) {
				Record record = event.getData();
				int tmpLinkKey = 0;
				if(BaseHelpUtils.isNullOrEmpty(record.getAttribute("invoiceLinkKey"))) {
					invoiceLinkKey ++;
					record.setAttribute("invoiceLinkKey", tmpLinkKey);
				} 
				if (update) {
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
					dealwithReimbursementInvoice(4, record);
				} else {
					RecordList list = grid.getDataAsRecordList();
					list.add(record);
					grid.setData(list);
					initDetailPanelDate(record);
					dealwithReimbursementInvoice(3, record);
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
//				departmentPanel.reDrawGrid();
				departmentPanel.redraw();
			}
		}
	}
	
	/**
	 *根据linkPanel的数据自动加载detailPanle的数据 
	 */
	public void initDetailPanelDate(Record temprecord){
		RecordList recordList = new RecordList();
		Integer mainItemId = temprecord.getAttributeAsInt("mainItemId");
		Integer subItemId = temprecord.getAttributeAsInt("subItemId");
		BigDecimal amount = BaseHelpUtils.getBigDecimalValue(temprecord.getAttributeAsFloat("amount"));
		String remark = temprecord.getAttributeAsString("remark");
		String contractCode = BaseHelpUtils.getString(temprecord.getAttribute("contractCode"));
		ProjectNormalReimbursementDetailPanel detailePanel = getDetailInfoPage();
		DelicacyListGrid detailGrid = detailePanel.getGrid();
		ListGridRecord[] detailRecords = detailGrid.getRecords();
		Record record = new Record();
		record.setAttribute("mainItemId", mainItemId);
		record.setAttribute("subItemId", subItemId);
		record.setAttribute("amount", amount);
		record.setAttribute("remark", remark);
		record.setAttribute("identification",contractCode);
		for (ListGridRecord listGridRecord2 : detailRecords) {
			recordList.add(listGridRecord2);
		}
		recordList.add(record);
		detailGrid.setData(recordList);
/************************************原本需要合并报销科目和报销选项的逻辑**********************************/	
//		SC.debugger();
//		Boolean flag = false;
//		RecordList recordList = new RecordList();
//			Integer mainItemId = temprecord.getAttributeAsInt("mainItemId");
//			Integer subItemId = temprecord.getAttributeAsInt("subItemId");
//			BigDecimal amount = BaseHelpUtils.getBigDecimalValue(temprecord.getAttributeAsFloat("amount"));
//			ProjectNormalReimbursementDetailPanel detailePanel = getDetailInfoPage();
//			DelicacyListGrid detailGrid = detailePanel.getGrid();
//			ListGridRecord[] detailRecords = detailGrid.getRecords();
//			if (detailRecords.length == 0) {
//				Record record = new Record();
//				record.setAttribute("mainItemId", mainItemId);
//				record.setAttribute("subItemId", subItemId);
//				record.setAttribute("amount", amount);
//				recordList.add(record);
//			}else{
//				for (ListGridRecord listGridRecord2 : detailRecords) {
//					Integer detailmainItemId = listGridRecord2.getAttributeAsInt("mainItemId");
//					Integer detailsubItemId = listGridRecord2.getAttributeAsInt("subItemId");
//					//合并报销科目相同的报销
//					if (detailmainItemId == mainItemId && detailsubItemId == subItemId) {
//						flag = true;
//					}
//				}
//				if (flag) {
//					for (ListGridRecord listGridRecord2 : detailRecords) {
//						Integer detailmainItemId = listGridRecord2.getAttributeAsInt("mainItemId");
//						Integer detailsubItemId = listGridRecord2.getAttributeAsInt("subItemId");
//						//合并报销科目相同的报销
//						if (detailmainItemId == mainItemId && detailsubItemId == subItemId) {
//							BigDecimal detailamount = BaseHelpUtils.getBigDecimalValue(listGridRecord2.getAttributeAsFloat("amount"));
//							BigDecimal tempAmount = detailamount.add(amount);
//							listGridRecord2.setAttribute("amount", tempAmount);
//							recordList.add(listGridRecord2);
//						}
//						else {
//							recordList.add(listGridRecord2);
//						}
//					}
//				}else{
//					Record record = new Record();
//					record.setAttribute("mainItemId", mainItemId);
//					record.setAttribute("subItemId", subItemId);
//					record.setAttribute("amount", amount);
//					for (ListGridRecord listGridRecord2 : detailRecords) {
//						recordList.add(listGridRecord2);
//					}
//					recordList.add(record);
//				}
//			}
//		ProjectNormalReimbursementDetailPanel detailePanel1 = getDetailInfoPage();
//		DelicacyListGrid detailGrid2 = detailePanel1.getGrid();
//		detailGrid2.setData(recordList);
	}
	
	@Override
	public void startEdit() {
		if(null != getInitData()) {
			Integer optionType = initData.getAttributeAsInt("optionType");
			if (optionType != null && optionType == 1) {//进入复制发起流程
				Record record = getInitData();
				String businessId = record.getAttribute("businessId");
				HashMap<Object, Object> conditions = new HashMap<>();
				conditions.put("projectNormalReimbursementId", businessId);
				DBDataSource.callOperation("ST_NormalReimbursementLinkProject", "find", conditions, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
						Record[] records = dsResponse.getData();
						SC.debugger();
						RecordList recordValues = new RecordList();
						for (Record record2 : records) {
							Record recordValue = new Record();
							Map<String, Object> map = record2.toMap();
							recordValue.setAttribute("mainItemId", map.get("mainItemId"));
							recordValue.setAttribute("subItemId", map.get("subItemId"));
							recordValue.setAttribute("amount", map.get("amount"));
							recordValue.setAttribute("remark", map.get("remark"));
							recordValue.setAttribute("finalAmount", map.get("finalAmount"));
							recordValue.setAttribute("inputTax", map.get("inputTax"));
							recordValue.setAttribute("plateId", map.get("plateId"));
							recordValue.setAttribute("contractCode", map.get("contractCode"));
							recordValue.setAttribute("projectId", map.get("projectId"));
							recordValues.add(recordValue);
						}
						grid.setData(recordValues);
					}
				});
			}
		}
		if(getPageMode() != PAGE_MODE_UPDATE) return;
		reloadDetailTableData();
	}

	public void reloadDetailTableData(){
		Map condition = new HashMap();
		condition.put("projectNormalReimbursementId", getRecord().getAttribute("projectNormalReimbursementId"));
		DBDataSource.callOperation("ST_NormalReimbursementLinkProject", "find", condition, new DSCallback(){
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
//					int projectNormalReimbursementId=BaseHelpUtils.getIntValue(recorda.getAttribute("projectNormalReimbursementId"));
//					Map<String,Object> params = new HashMap<>();
//					params.put("businessId",projectNormalReimbursementId);
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
	
	
	public void initInvoiceListRecord(Record record, NormalReimbursementLinkProjectPopupPanel panel) {
		Integer invoiceLinkKey = record.getAttributeAsInt("invoiceLinkKey");
		if(null != invoiceLinkKey) {
			if(reimbursementInvoiceMap.containsKey(invoiceLinkKey)) {
				panel.initInvoiceRecords(record, reimbursementInvoiceMap.get(invoiceLinkKey));
			} else {
				Integer normalReimbursementLinkDepartmentId = record.getAttributeAsInt("normalReimbursementLinkProjectId");
				if(null != normalReimbursementLinkDepartmentId && null != getRecord()) {
					Map<String, Object> params = new HashMap<>();
					params.put("detailId", normalReimbursementLinkDepartmentId);
					params.put("processType", getProcessType());
					params.put("businessId", getRecord().getAttribute("projectNormalReimbursementId"));
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
		if(null == record) {
			return;
		}
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
		res.add("detailNormalReimbursementLinkProject");
		return res;
	}

	@Override
	public boolean isTheValuesEmpty() {
		ListGridRecord[] rows = grid.getRecords();
		return rows == null || rows.length == 0;
	}

	@Override
	public Map getValuesAsMap() {
		Map<String,Object> param = new HashMap<String,Object>();
		ListGridRecord[] rows = grid.getRecords();
		MapUtils.convertRecordToMap(grid.getDataSource(), rows, param, "detailNormalReimbursementLinkProject");
		if(bdrecord!=null) {
			int budgetManagementId=0;
			int budgetAttachmentId=0;
			int paymentSequenceId=0;
			BigDecimal reimbursementAmount=BigDecimal.ZERO;//报销金额
			BigDecimal  reverseAmount=BigDecimal.ZERO;//冲账金额
			//获取预算管理Id
			 budgetManagementId=BaseHelpUtils.getIntValue(bdrecord.getAttribute("budgetManagementId"));
			//获取附件id
			 budgetAttachmentId=BaseHelpUtils.getIntValue(bdrecord.getAttribute("budgetAttachmentId"));
			//获取付款序列id
			 paymentSequenceId=BaseHelpUtils.getIntValue(bdrecord.getAttribute("paymentSequenceId"));
			//获取报销金额
			 reimbursementAmount=BaseHelpUtils.getBigDecimalValue(bdrecord.getAttribute("reimbursementAmount"));
			//获取冲账金额
			 reverseAmount=BaseHelpUtils.getBigDecimalValue(bdrecord.getAttribute("reverseAmount"));
			 param.put("budgetManagementId",budgetManagementId);
			 param.put("budgetAttachmentId",budgetAttachmentId);
			 param.put("paymentSequenceId",paymentSequenceId);
			 param.put("reimbursementAmount",reimbursementAmount);
			 param.put("reverseAmount",reverseAmount);
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
	
	public int getProcessId() {
		return processId;
	}

	public void setProcessId(int processId) {
		this.processId = processId;
	}
	
	public ProjectNormalReimbursementDetailPanel getDetailInfoPage() {
		return detailInfoPage;
	}

	public void setDetailInfoPage(ProjectNormalReimbursementDetailPanel detailInfoPage) {
		this.detailInfoPage = detailInfoPage;
	}
	
	public AbstractWizadPage getBillInfoPage() {
		return billInfoPage;
	}

	public void setBillInfoPage(AbstractWizadPage billInfoPage) {
		this.billInfoPage = billInfoPage;
	}
     
	private Record bdrecord;

	public Record getBdrecord() {
		return bdrecord;
	}
	public void setBdrecord(Record bdrecord) {
		this.bdrecord = bdrecord;
		/*if(bdrecord!=null) {
			payseqbut.show();
		}*/
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}
	
	
}

