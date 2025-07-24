package com.pomplatform.client.workflow.panel;

import java.math.BigDecimal;
import java.util.Date;
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
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.pomplatform.client.inputtaxinvoiceabpor.datasource.DSSinputtaxinvoiceLinkFinanceabpor;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.KeyPressEvent;
import com.smartgwt.client.widgets.form.fields.events.KeyPressHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.ChangedEvent;
import com.smartgwt.client.widgets.grid.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.grid.events.RemoveRecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RemoveRecordClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class ProcessInputTaxAmountPanel extends AbstractWizadPage {

	private static final Logger __logger = Logger.getLogger("");
	private DSCallback __startLoadedDetail;
	private DSCallback __endLoadedDetail;
	private DelicacyListGrid grid = new DelicacyListGrid();
	private AbstractWizadPage mainInfoPage;
	private Integer processType;
	private Record initData;
	private String code;
	private Integer companyId;

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

	public ProcessInputTaxAmountPanel() {
		VLayout mainLayout = new VLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		addMember(mainLayout);
		
		HLayout hLayout = new HLayout();
		hLayout.setWidth100();
		hLayout.setHeight(80);
		TextItem scanCodeItem = new TextItem("扫描入口");
		scanCodeItem.setWidth(500);
		scanCodeItem.addKeyPressHandler(new KeyPressHandler() {
			
			@Override
			public void onKeyPress(KeyPressEvent event) {
				if(event.getKeyName().equals("Enter")){
					String val = scanCodeItem.getValue().toString().replaceAll("，", ",");
					String [] valArra = val.split(",");
					if(valArra.length == 8 || valArra.length == 9){
						String type1 = valArra[0];
						String type2 = valArra[1];
						String code = valArra[2];
						String number = valArra[3];
						BigDecimal amount = new BigDecimal(valArra[4]);
						DateTimeFormat dtf = DateTimeFormat.getFormat("yyyyMMdd");
						Date invoiceDate = dtf.parse(valArra[5]);
						String otherCode = valArra[7];
						Record record = new Record();
						record.setAttribute("addType", 2);
						if(("01".equals(type1) || "1".equals(type1)) && ("01".equals(type2) || "1".equals(type2))){
							record.setAttribute("invoiceType", 1);
						}else if(("01".equals(type1) || "1".equals(type1)) && ("04".equals(type2) || "4".equals(type2))){
							record.setAttribute("invoiceType", 2);
						}
						record.setAttribute("invoiceCode", code);
						record.setAttribute("invoiceNumber", number);
						record.setAttribute("invoiceDate", invoiceDate);
						record.setAttribute("invoiceAmount", amount);
						record.setAttribute("randomCode", otherCode);
						record.setAttribute("processType", getProcessType());
						record.setAttribute("businessId", getBusinessId());
						record.setAttribute("code", getCode());
						record.setAttribute("operator", ClientUtil.getEmployeeId());
						record.setAttribute("companyId", getCompanyId());
						Map<String, Object> params = new HashMap<>();
						params.put("invoiceCode", code);
						params.put("invoiceNumber", number);
						params.put("businessId", getBusinessId());
						params.put("processType", getProcessType());
						DBDataSource.callOperation("EP_InputTaxInvoiceLinkFinanceProcess","",record.toMap(),new DSCallback() {
							
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								if (dsResponse.getStatus() > 0) {
									SC.debugger();
									grid.addData(dsResponse.getData()[0]);
								}else{
									SC.debugger();
									SC.say("该发票已经录入,单号为:"+dsResponse.getErrors().get("errorMsg"));
								}
							}
						});
//						DBDataSource.callOperation("ST_InputTaxInvoiceLinkFinance", "find", params, new DSCallback() {
//							
//							@Override
//							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//								Record [] records = dsResponse.getData();
//								if(records.length > 0){
//									AdvancedCriteria ac = new AdvancedCriteria();
//									ac.addCriteria("invoiceCode", code);
//									ac.addCriteria("invoiceNumber", number);
//									int rowNum = grid.findIndex(ac);
//									grid.selectSingleRecord(rowNum);
//									SC.say("该发票已经录入");
//								}else{
//									DBDataSource.callOperation("ST_InputTaxInvoiceLinkFinance", "save", record.toMap(), new DSCallback() {
//										
//										@Override
//										public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//											if(dsResponse.getStatus() >= 0){
//												grid.addData(dsResponse.getData()[0]);
//											}else{
//												ClientUtil.displayErrorMessage(dsResponse);
//											}
//											
//										}
//									});
//								}
//								
//							}
//						});
						scanCodeItem.clearValue();
						scanCodeItem.focusInItem();
					}else{
						SC.say("请扫描正确的发票二维码");
					}
				}
				
			}
		});
		
		DynamicForm form = new DynamicForm();
		form.setFields(scanCodeItem);
		ClientUtil.DynamicFormProcessAccordingToDevice(form);
		hLayout.addMember(form);
		mainLayout.addMember(hLayout);
		__dataGrid = grid;

		HLayout dataLayout = new HLayout();
		dataLayout.setWidth100();
		dataLayout.setHeight100();

		ListGridField[] fields = new ListGridField[12];
		int idx = 0;
		fields[idx] = new ListGridField("addType");
		fields[idx].setCanEdit(false);
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("invoiceType");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("invoiceCode");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("invoiceNumber");
		fields[idx].addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				if(null != event.getValue() && event.getValue().toString().length() == 8){
					Map<String, Object> params = new HashMap<>();
					params.put("invoiceNumber", event.getValue());
					DBDataSource.callOperation("ST_InputTaxInvoice", "find", params, new DSCallback() {
						
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							Record [] records = dsResponse.getData();
							if(records.length > 0){
								Record dataRecord = records[0];
								event.getForm().getItem("invoiceCode").setValue(dataRecord.getAttribute("invoiceCode"));
								event.getForm().getItem("invoiceDate").setValue(dataRecord.getAttributeAsDate("invoiceDate"));
								event.getForm().getItem("taxAmount").setValue(dataRecord.getAttribute("taxAmount"));
								event.getForm().getItem("invoiceAmount").setValue(dataRecord.getAttribute("invoiceAmount"));
								event.getForm().getItem("invoiceType").setValue(dataRecord.getAttribute("invoiceType"));
							}
							
						}
					});
				}
				
			}
		});
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("invoiceDate");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("invoiceAmount");
		fields[idx].setShowGridSummary(false);
		idx++;
//		fields[idx] = new ListGridField("taxRate");
//		fields[idx].setShowGridSummary(false);
//		idx++;
		fields[idx] = new ListGridField("taxAmount");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("remark");
		fields[idx].setShowGridSummary(false);
		grid.setFields(fields);
		grid.setCanEdit(true);
		grid.setShowGridSummary(true);
		grid.setDataSource(DSSinputtaxinvoiceLinkFinanceabpor.getInstance());
		grid.setAutoFitFieldWidths(true);
		grid.addRemoveRecordClickHandler(new RemoveRecordClickHandler() {
			
			@Override
			public void onRemoveRecordClick(RemoveRecordClickEvent event) {
				Record record = grid.getRecord(event.getRowNum());
				DBDataSource.callOperation("ST_InputTaxInvoiceLinkFinance", "delete", record.toMap(), new DSCallback() {
					
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0){
						}else{
							ClientUtil.displayErrorMessage(dsResponse);
						}
						
					}
				});
				
			}
		});
		grid.addEditCompleteHandler(new EditCompleteHandler() {
			
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				Record oldRecord = event.getOldValues();
				Record newRrecord = grid.getSelectedRecord();
				if(null == newRrecord.getAttribute("invoiceNumber") || null == newRrecord.getAttribute("invoiceCode")){
					return;
				}
				if(null != oldRecord.getAttribute("invoiceNumber") && oldRecord.getAttribute("invoiceNumber").equals(newRrecord.getAttribute("invoiceNumber"))){
					DBDataSource.callOperation("ST_InputTaxInvoiceLinkFinance", "update", newRrecord.toMap(), new DSCallback() {
						
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if(dsResponse.getStatus() >= 0){
							}else{
								ClientUtil.displayErrorMessage(dsResponse);
							}
							
						}
					});
				}else{
					Map<String, Object> params = new HashMap<>();
//					params.put("invoiceCode", newRrecord.getAttribute("invoiceCode"));
					params.put("invoiceNumber", newRrecord.getAttribute("invoiceNumber"));
					params.put("businessId", getBusinessId());
					params.put("processType", getProcessType());
					DBDataSource.callOperation("ST_InputTaxInvoiceLinkFinance", "find", params, new DSCallback() {
						
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							Record [] records = dsResponse.getData();
							if(records.length > 0){
								startEdit();
//								AdvancedCriteria ac = new AdvancedCriteria();
//								ac.addCriteria("invoiceCode", newRrecord.getAttribute("invoiceCode"));
//								ac.addCriteria("invoiceNumber", newRrecord.getAttribute("invoiceNumber"));
//								int rowNum = grid.findIndex(ac);
//								grid.selectSingleRecord(rowNum);
								SC.say("该发票号码已存在");
							}else{
								DBDataSource.callOperation("ST_InputTaxInvoiceLinkFinance", "update", newRrecord.toMap(), new DSCallback() {
									
									@Override
									public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
										if(dsResponse.getStatus() >= 0){
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
		dataLayout.addMember(grid);

		VLayout controlsLayout = new VLayout();
		controlsLayout.setHeight100();
		controlsLayout.setWidth(60);
		controlsLayout.setLayoutTopMargin(30);
		controlsLayout.setLayoutLeftMargin(5);
		controlsLayout.setLayoutRightMargin(5);
		controlsLayout.setMembersMargin(10);
		dataLayout.addMember(controlsLayout);
		mainLayout.addMember(dataLayout);
		
		IButton addButton = new IButton("新增");
		addButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Record record = new Record();
				record.setAttribute("addType", 1);
				record.setAttribute("processType", getProcessType());
				record.setAttribute("businessId", getBusinessId());
				record.setAttribute("code", getCode());
				record.setAttribute("operator", ClientUtil.getEmployeeId());
				record.setAttribute("companyId", getCompanyId());
				DBDataSource.callOperation("ST_InputTaxInvoiceLinkFinance", "save", record.toMap(), new DSCallback() {
					
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0){
							grid.addData(dsResponse.getData()[0]);
						}else{
							ClientUtil.displayErrorMessage(dsResponse);
						}
						
					}
				});
			}
		});
//		IButton updateButton = new IButton("修改");
//		updateButton.addClickHandler(new ClickHandler() {
//			@Override
//			public void onClick(ClickEvent event) {
//			}
//		});
//		IButton removeButton = new IButton("删除所有");
//		removeButton.setIcon("[SKIN]/actions/remove.png");
//		removeButton.addClickHandler(new ClickHandler() {
//			@Override
//			public void onClick(ClickEvent event) {
//				grid.setData(new RecordList());
//			}
//		});
		controlsLayout.addMember(addButton);
//		controlsLayout.addMember(updateButton);
//		controlsLayout.addMember(removeButton);
	}


	@Override
	public void startEdit() {
		reloadDetailTableData();
	}

	public void reloadDetailTableData() {
		Map condition = new HashMap();
//		Record record = getRecord();
//		int __businessId = 0;
//		switch (getProcessType()) {
//		case PROCESS_TYPE_2:
//			__businessId = BaseHelpUtils.getIntValue(getRecord().getAttribute("projectNormalReimbursementId"));
//			break;
//		case PROCESS_TYPE_3:
//			__businessId = BaseHelpUtils.getIntValue(getRecord().getAttribute("projectNormalReimbursementId"));
//			break;
//		case PROCESS_TYPE_4:
//			__businessId = BaseHelpUtils.getIntValue(getRecord().getAttribute("travelReimbursementId"));
//			break;
//		case PROCESS_TYPE_5:
//			__businessId = BaseHelpUtils.getIntValue(getRecord().getAttribute("travelReimbursementId"));
//			break;
//		case PROCESS_TYPE_6:
//			__businessId = BaseHelpUtils.getIntValue(getRecord().getAttribute("employeeMoneyManageId"));
//			break;
//		case PROCESS_TYPE_7:
//			__businessId = BaseHelpUtils.getIntValue(getRecord().getAttribute("payMoneyManageId"));
//			break;
//		case PROCESS_TYPE_8:
//			__businessId = BaseHelpUtils.getIntValue(getRecord().getAttribute("projectNormalReimbursementId"));
//			break;
//		case PROCESS_TYPE_9:
//			__businessId = BaseHelpUtils.getIntValue(getRecord().getAttribute("travelReimbursementId"));
//			break;
//		case PROCESS_TYPE_10:
//			__businessId = BaseHelpUtils.getIntValue(getRecord().getAttribute("projectNormalReimbursementId"));
//			break;
//		default:
//			break;
//		}
//		setBusinessId(__businessId);
		condition.put("businessId", getBusinessId());
		condition.put("processType", getProcessType());
		DBDataSource.callOperation("ST_InputTaxInvoiceLinkFinance", "find",
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
		MapUtils.convertRecordToMap(grid.getDataSource(), rows, param, "detailInputTaxInovice");
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
	
	private Integer businessId;

	public Integer getBusinessId() {
		return businessId;
	}


	public void setBusinessId(Integer businessId) {
		this.businessId = businessId;
	}

	public Record getInitData() {
		return initData;
	}

	public void setInitData(Record initData) {
		this.initData = initData;
	}

	protected final HandlerManager handlerManager = new HandlerManager(this);

	private Window fatherWindow;

	public Window getFatherWindow() {
		return fatherWindow;
	}

	public void setFatherWindow(Window fatherWindow) {
		this.fatherWindow = fatherWindow;
	}
	
	@Override
	public void fireEvent(GwtEvent<?> event) {
		handlerManager.fireEvent(event);
	}

	public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
		return handlerManager.addHandler(DataEditEvent.TYPE, handler);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	
}
