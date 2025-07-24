package com.pomplatform.client.budgetmanagement.panel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.NewProcessWindow;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.google.gwt.storage.client.Storage;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.ChangedEvent;
import com.smartgwt.client.widgets.grid.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PaySeqAddPanel  extends HLayout implements HasHandlers {
	private Window parentWindow;
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	private static Logger __logger = Logger.getLogger("");
	private  HLayout mainLayout;
	private  VLayout rightLayout;
	private DelicacyListGrid paySeqGrid;
	private IButton  addbut;
	private IButton  savebut;
	private IButton  delbut;
	private IButton  quitbut;
	private IButton  paybut;

	public void initComponents() {
		mainLayout=new HLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();;
		addMember(mainLayout);

		paySeqGrid = new DelicacyListGrid(){
			protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
				int payType=BaseHelpUtils.getIntValue(record.getAttribute("payType"));
				if (getFieldName(colNum).equals("payAmount")) { 
					switch (payType) {
					case 1://项目日常报销
						getField(colNum).setCanEdit(false);
						break;
					case 2://普通日常报销
						getField(colNum).setCanEdit(false);
						break;
					case 3://项目差旅报销
						getField(colNum).setCanEdit(false);
						break;
					case 6://还款申请
						getField(colNum).setCanEdit(false);
						break;
					default:
						getField(colNum).setCanEdit(true);
						break;
					}
				}else if(getFieldName(colNum).equals("reimbursementAmount")) {//报销金额
					switch (payType) {
					case 4://借款申请
						getField(colNum).setCanEdit(false);
						break;
					case 5://预付款申请
						getField(colNum).setCanEdit(false);
						break; 
					case 6://还款申请
						getField(colNum).setCanEdit(false);
						break; 
					default:
						getField(colNum).setCanEdit(true);
						break;
					}
				}else if(getFieldName(colNum).equals("reverseAmount")) {//冲账
					switch (payType) {
					case 4://借款申请
						getField(colNum).setCanEdit(false);
						break;
					case 5://预付款申请
						getField(colNum).setCanEdit(false);
						break; 
					case 6://还款申请
						getField(colNum).setCanEdit(false);
						break; 
					default:
						getField(colNum).setCanEdit(true);
						break;
					}
				}else if(getFieldName(colNum).equals("returnAmount")) {//还款金额
					switch (payType) {
					case 6://还款申请
						getField(colNum).setCanEdit(true);
						break; 
					default:
						getField(colNum).setCanEdit(false);
						break;
					}
				}
				int payStatus=BaseHelpUtils.getIntValue(record.getAttribute("payStatus"));
				//获取付款类型ID  
				if(payStatus==1) {//未付款
					return null;
				}else if(payStatus==2) {//已付款 
					paySeqGrid.getRecord(rowNum).set_canEdit(false);
					return "color: 009966;";
				}else if(payStatus==3) {//付款申请中
					paySeqGrid.getRecord(rowNum).set_canEdit(false);
					return "color: #D2691E;";
				}
				else {
					return null;
				}

			}  
		};
		paySeqGrid.setWidth("90%");
		paySeqGrid.setAlign(Alignment.LEFT);
		paySeqGrid.setAutoFitFieldWidths(false);
		int a=0;
		ListGridField[] aFields = new ListGridField[6];
		aFields[a] = new ListGridField("paymentSequenceId","付款序列ID"); 
		aFields[a].setCanEdit(false);
		aFields[a].setHidden(true);
		a++;
		aFields[a] = new ListGridField("budgetManagementId","预算管理Id");
		aFields[a].setCanEdit(false);
		aFields[a].setHidden(true);
		a++;
		aFields[a] = new ListGridField("budgetAttachmentId","附件Id");
		aFields[a].setCanEdit(false);
		aFields[a].setHidden(true);
		a++;
		aFields[a] = new ListGridField("payType","付款类型");
		aFields[a].setAlign(Alignment.CENTER);
		SelectItem  payItme=new SelectItem();
		payItme.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		aFields[a].setEditorProperties(payItme);
		aFields[a].setValueMap(KeyValueManager.getValueMap("system_dictionary_190"));
		aFields[a].setWidth("25%");
		aFields[a].setCanEdit(true);
		aFields[a].addChangedHandler(new ChangedHandler() {

			@Override
			public void onChanged(ChangedEvent event) {
				int payType=BaseHelpUtils.getIntValue(event.getValue());
				switch (payType) {
				case 1://项目日常报销
					event.getForm().getItem("payAmount").setDisabled(true);
					event.getForm().getItem("returnAmount").setDisabled(true);
					break;
				case 2://普通日常报销
					event.getForm().getItem("payAmount").setDisabled(true);
					event.getForm().getItem("returnAmount").setDisabled(true);
					break;
				case 3://项目差旅报销
					event.getForm().getItem("payAmount").setDisabled(true);
					event.getForm().getItem("returnAmount").setDisabled(true);
					break;
				case 4://借款申请 
					event.getForm().getItem("reimbursementAmount").setDisabled(true);
					event.getForm().getItem("reverseAmount").setDisabled(true);
					event.getForm().getItem("returnAmount").setDisabled(true);
					break;
				case 5://预付款申请
					event.getForm().getItem("reimbursementAmount").setDisabled(true);
					event.getForm().getItem("reverseAmount").setDisabled(true);
					event.getForm().getItem("returnAmount").setDisabled(true);
					break;
				case 6://还款申请
					event.getForm().getItem("reimbursementAmount").setDisabled(true);
					event.getForm().getItem("reverseAmount").setDisabled(true);
					event.getForm().getItem("payAmount").setDisabled(true);
					break;
				}
			}

		});
		a++;
		aFields[a] = new ListGridField("applyPayDate","申请付款时间");  
		aFields[a].setAlign(Alignment.CENTER);
		DateTimeItem  dateItem=new DateTimeItem();
		dateItem.setUseTextField(true);
		aFields[a].setEditorProperties(dateItem);
		aFields[a].setWidth("25%");
		aFields[a].setDefaultValue(new Date());
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("reimbursementAmount","报销金额");
		aFields[a].setAlign(Alignment.RIGHT);
		aFields[a].setType(ListGridFieldType.FLOAT);
		aFields[a].setFormat("##,###,###,###,##0.00");
		aFields[a].setWidth("25%");
		aFields[a].setCanEdit(true);
		a++;
		aFields[a] = new ListGridField("payAmount","付款金额");
		aFields[a].setAlign(Alignment.RIGHT);
		aFields[a].setType(ListGridFieldType.FLOAT);
		aFields[a].setFormat("##,###,###,###,##0.00");
		aFields[a].setWidth("25%");
		aFields[a].setCanEdit(true);
		a++;
		aFields[a] = new ListGridField("reverseAmount","冲账金额");
		aFields[a].setAlign(Alignment.RIGHT);
		aFields[a].setType(ListGridFieldType.FLOAT);
		aFields[a].setFormat("##,###,###,###,##0.00");
		aFields[a].setWidth("25%");
		aFields[a].setCanEdit(true);
		a++;
		aFields[a] = new ListGridField("returnAmount","还款金额");
		aFields[a].setAlign(Alignment.RIGHT);
		aFields[a].setType(ListGridFieldType.FLOAT);
		aFields[a].setFormat("##,###,###,###,##0.00");
		aFields[a].setWidth("25%");
		aFields[a].setCanEdit(true);
		a++;
		aFields[a] = new ListGridField("receiveUnitManageId","收款方");
		aFields[a].setAlign(Alignment.CENTER);
		ComboBoxItem receiveUnitManageIdItem = new ComboBoxItem();
		receiveUnitManageIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		aFields[a].setEditorProperties(receiveUnitManageIdItem);
//		aFields[a].setValueMap(KeyValueManager.getValueMap("receive_unit_manages_company"));
		KeyValueManager.loadValueMap("receive_unit_manages_company",aFields[a]);
		aFields[a].setWidth("45%");
		aFields[a].setCanEdit(true);
		a++;
		aFields[a] = new ListGridField("psRemark","备注");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setWidth("45%");
		aFields[a].setCanEdit(true);
		a++;
		aFields[a] = new ListGridField("isLock","是否申请付款");
		aFields[a].setWidth("25%");
		aFields[a].setHidden(true);
		aFields[a].setCanEdit(true);
		a++;
		aFields[a] = new ListGridField("payStatus","付款状态");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setValueMap(KeyValueManager.getValueMap("system_dictionary_191"));
		aFields[a].setCanEdit(false);
		aFields[a].setDefaultValue(1);
		aFields[a].setWidth("15%");
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("payDate","付款时间");  
		aFields[a].setAlign(Alignment.CENTER);
		DateTimeItem  dateItems=new DateTimeItem();
		dateItem.setUseTextField(true);
		aFields[a].setEditorProperties(dateItems);
		aFields[a].setWidth("25%");
		aFields[a].setCanEdit(false);
		paySeqGrid.setFields(aFields);
		paySeqGrid.setShowGridSummary(true);
		paySeqGrid.setHeaderHeight(60);
		paySeqGrid.setHeaderSpans(new HeaderSpan(shouldNotBeNull+"维护付款序列", new String[] {"paymentSequenceId","budgetManagementId","budgetAttachmentId","payType","applyPayDate","reimbursementAmount","payAmount","reverseAmount","returnAmount","receiveUnitManageId","psRemark","payStatus","payDate"}));
		mainLayout.addMember(paySeqGrid);
		paySeqGrid.addEditCompleteHandler(new EditCompleteHandler() {
			@SuppressWarnings("unchecked")
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				int rowNum = event.getRowNum();
				//预算管理ID
				int budgetManagementId=BaseHelpUtils.getIntValue(record.getAttribute("budgetManagementId"));
				//获取附件id
				int budgetAttachmentId=BaseHelpUtils.getIntValue(record.getAttribute("budgetAttachmentId"));
				Record records=paySeqGrid.getRecord(rowNum);
				Map<String,Object> params = new HashMap<>();
				params.putAll(records.toMap());
				params.put("budgetManagementId", budgetManagementId);
				params.put("budgetAttachmentId", budgetAttachmentId);
				DBDataSource.callOperation("EP_EidtPaymentSequence",params,new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0) {
							loadData();
						}else {
							SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
						}
					}
				});	

			}
		});

		rightLayout=new VLayout(20);
		rightLayout.setMargin(10);
		rightLayout.setHeight100();
		rightLayout.setWidth("10%");
		mainLayout.addMember(rightLayout);

		IButton refreshButton = new IButton("刷新");
		rightLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				loadData();
			}
		});

		addbut=new IButton("新增");
		rightLayout.addMember(addbut);
		addbut.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				//获取收款单位ID
				int receiveUnitManageId=BaseHelpUtils.getIntValue(record.getAttribute("receiveUnitManageId"));
				//预算管理ID
				int budgetManagementId=BaseHelpUtils.getIntValue(record.getAttribute("budgetManagementId"));
				//获取附件id
				int budgetAttachmentId=BaseHelpUtils.getIntValue(record.getAttribute("budgetAttachmentId"));
				Record records=new Record();
				records.setAttribute("receiveUnitManageId",receiveUnitManageId);
				records.setAttribute("budgetManagementId",budgetManagementId);
				records.setAttribute("budgetAttachmentId",budgetAttachmentId);
				paySeqGrid.startEditingNew(records);
			}
		});

		savebut=new IButton("保存");
		savebut.hide();
		rightLayout.addMember(savebut);
		savebut.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Map<String,Object> map=new HashMap<>();
				//获取订单管理id
				int budgetManagementId=BaseHelpUtils.getIntValue(record.getAttribute("budgetManagementId"));
				//获取附件id
				int budgetAttachmentId=BaseHelpUtils.getIntValue(record.getAttribute("budgetAttachmentId"));
				Record[]  records=paySeqGrid.getRecords();
				for (Record record : records) {
					//获取付款类型
					int payType=BaseHelpUtils.getIntValue(record.getAttribute("payType"));
					if(payType<=0) {
						SC.say("新增的序列,付款类型不能为空,保存失败");
						return;
					}
				}
				for (Record payrecord : records) {
					//获取付款时间	 
					Date applyPayDate=payrecord.getAttributeAsDate("applyPayDate");	
					//获取付款金额
					BigDecimal  payAmount=BaseHelpUtils.getBigDecimalValue(payrecord.getAttribute("payAmount"));
					//获取收款方
					int receiveUnitManageId=BaseHelpUtils.getIntValue(payrecord.getAttribute("receiveUnitManageId"));
					//获取付款备注
					String 	psRemark=payrecord.getAttributeAsString("psRemark");
					//获取序列主键
					int paymentSequenceId=BaseHelpUtils.getIntValue(payrecord.getAttribute("paymentSequenceId"));
					//获取付款类型
					int payType=BaseHelpUtils.getIntValue(payrecord.getAttribute("payType"));
					//获取报销金额
					BigDecimal  reimbursementAmount=BaseHelpUtils.getBigDecimalValue(payrecord.getAttribute("reimbursementAmount"));
					//获取冲账金额 
					BigDecimal  reverseAmount=BaseHelpUtils.getBigDecimalValue(payrecord.getAttribute("reverseAmount"));
					//获取还款金额
					BigDecimal  returnAmount=BaseHelpUtils.getBigDecimalValue(payrecord.getAttribute("returnAmount"));
					if(paymentSequenceId>0&&!BaseHelpUtils.isNullOrEmpty(paymentSequenceId)) {//如果序列主键存在，只进行update操作
						map.put("paymentSequenceId", paymentSequenceId);
						map.put("budgetManagementId", budgetManagementId);
						map.put("budgetAttachmentId", budgetAttachmentId);
						map.put("applyPayDate", applyPayDate);
						map.put("payAmount", payAmount);
						map.put("receiveUnitManageId", receiveUnitManageId);
						map.put("psRemark", psRemark);
						map.put("payType", payType);
						map.put("reimbursementAmount", reimbursementAmount);
						map.put("reverseAmount", reverseAmount);
						map.put("returnAmount", returnAmount);
						DBDataSource.callOperation("ST_PaymentSequence","update",map,new DSCallback() {
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								if(dsResponse.getStatus()>=0) {
									/*savebut.setDisabled(true);
									if (getParentWindow() == null) {
										return;
									}
									getParentWindow().destroy();
									DataEditEvent dee = new DataEditEvent();
									fireEvent(dee);*/
									SC.say("保存成功");
									loadData();
								}else {
									SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
								}
							}
						});
					}else {
						map.put("budgetManagementId", budgetManagementId);
						map.put("budgetAttachmentId", budgetAttachmentId);
						map.put("applyPayDate", applyPayDate);
						map.put("payAmount", payAmount);
						map.put("receiveUnitManageId", receiveUnitManageId);
						map.put("psRemark", psRemark);
						map.put("payType", payType);
						map.put("reimbursementAmount", reimbursementAmount);
						map.put("reverseAmount", reverseAmount);
						map.put("returnAmount", returnAmount);
						DBDataSource.callOperation("ST_PaymentSequence","save",map,new DSCallback() {
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								if(dsResponse.getStatus()>=0) {
									/*savebut.setDisabled(true);
									if (getParentWindow() == null) {
										return;
									}
									getParentWindow().destroy();
									DataEditEvent dee = new DataEditEvent();
									fireEvent(dee);*/
									SC.say("保存成功");
									loadData();
								}else {
									SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
								}
							}
						});
					}
				}
			}
		});


		delbut=new IButton("删除");
		rightLayout.addMember(delbut);
		delbut.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(!paySeqGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				Record  payrecord=paySeqGrid.getSelectedRecord();
				int payStatus=BaseHelpUtils.getIntValue(payrecord.getAttribute("payStatus"));
				if(payStatus==2) {
					SC.say("此条付款序列已经付款,不能删除！");
					return;
				}
				if(payStatus==3) {
					SC.say("此条付款序列在付款申请中,不能删除！");
					return;
				}
				SC.ask("删除付款序列","确定要删除吗？",new BooleanCallback() {
					@Override
					public void execute(Boolean value) {
						if(value) {
							Map<String,Object> map=new HashMap<>();
							Record[]  records=paySeqGrid.getSelectedRecords();
							for (Record payrecord : records) {
								//获取主键
								int  paymentSequenceId=BaseHelpUtils.getIntValue(payrecord.getAttribute("paymentSequenceId"));
								if(paymentSequenceId<=0) {SC.say("找不到删除序列主键");return;}
								map.put("paymentSequenceId", paymentSequenceId);
								DBDataSource.callOperation("ST_PaymentSequence","delete",map,new DSCallback() {
									@Override
									public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
										if(dsResponse.getStatus()>=0){
											SC.say("删除成功"); 
											loadData();
										}else {
											SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
										}
									}
								});
							}
						}
						return;	
					}
				});
			}
		});

		paybut=new IButton("付款申请");
		rightLayout.addMember(paybut);
		paybut.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Record  payrecord=paySeqGrid.getSelectedRecord();
				if(cheakPaySeqData(payrecord)) {
					return;
				}
				int projectId=0;
				int budgetManagementId=0;
				int payType=0;
				int receiveUnitManageId=0;
				int budgetAttachmentId=0;
				int paymentSequenceId=0;
				BigDecimal reimbursementAmount=BigDecimal.ZERO;//报销金额
				BigDecimal  reverseAmount=BigDecimal.ZERO;//冲账金额
				BigDecimal payAmount=BigDecimal.ZERO;//付款金额
				BigDecimal returnAmount=BigDecimal.ZERO;//还款金额
				String bdCode="";
				String psRemark="";
				if(payrecord!=null){ 
					//获取付款类型ID  
					payType=BaseHelpUtils.getIntValue(payrecord.getAttribute("payType"));
					//获取收款方
					receiveUnitManageId=BaseHelpUtils.getIntValue(payrecord.getAttribute("receiveUnitManageId"));
					//获取预算管理Id
					budgetManagementId=BaseHelpUtils.getIntValue(payrecord.getAttribute("budgetManagementId"));
					//获取附件id
					budgetAttachmentId=BaseHelpUtils.getIntValue(payrecord.getAttribute("budgetAttachmentId"));
					//获取付款序列id
					paymentSequenceId=BaseHelpUtils.getIntValue(payrecord.getAttribute("paymentSequenceId"));
					//获取报销金额
					reimbursementAmount=BaseHelpUtils.getBigDecimalValue(payrecord.getAttribute("reimbursementAmount"));
					//获取冲账金额
					reverseAmount=BaseHelpUtils.getBigDecimalValue(payrecord.getAttribute("reverseAmount"));
					//获取还款金额
					returnAmount=BaseHelpUtils.getBigDecimalValue(payrecord.getAttribute("returnAmount"));
					//获取付款金额
					payAmount=BaseHelpUtils.getBigDecimalValue(payrecord.getAttribute("payAmount"));
					//获取备注
					psRemark=BaseHelpUtils.getString(payrecord.getAttribute("psRemark"));
				}
				if(mainRecord!=null) {
					//获取项目ID
					projectId=BaseHelpUtils.getIntValue(mainRecord.getAttribute("projectId"));
					//获取预算编号
					bdCode=BaseHelpUtils.getString(mainRecord.getAttribute("bdCode"));
				}
				if(payType<=0&&BaseHelpUtils.isNullOrEmpty(payType)) {
					SC.say("请选择付款类型");
					return;
				}
				switch (payType) {
				case 1://项目日常报销
					NewProcessWindow panel1=new NewProcessWindow();
					Record rcord1=new Record();
					if(payrecord!=null) {
						rcord1.setAttribute("receiveUnitManageId", receiveUnitManageId);
						rcord1.setAttribute("budgetManagementId", budgetManagementId);
						rcord1.setAttribute("budgetAttachmentId", budgetAttachmentId);
						rcord1.setAttribute("paymentSequenceId", paymentSequenceId);
						rcord1.setAttribute("reimbursementAmount", reimbursementAmount);//报销金额  
						rcord1.setAttribute("reverseAmount", reverseAmount);//冲账金额
						rcord1.setAttribute("payAmount", payAmount);//付款金额
						rcord1.setAttribute("psRemark", psRemark);
					}
					if(mainRecord!=null) {
						rcord1.setAttribute("projectId", projectId);
						rcord1.setAttribute("bdCode", bdCode);
					}
					panel1.setTitle("预算项目日常报销申请");
					panel1.setProcessId(ClientUtil.checkAndGetIntValue(gerProcessId("Project_normal_reimbursement")));
					panel1.setData(rcord1);
					panel1.setLayoutMode(0);
					panel1.initComponents();
					panel1.setWidth("100%");
					panel1.setHeight("100%");
					panel1.centerInPage();
					panel1.show();
					break;
				case 2://普通日常报销
					NewProcessWindow panel2=new NewProcessWindow();
					Record rcord2=new Record();
					if(payrecord!=null) {
						rcord2.setAttribute("receiveUnitManageId", receiveUnitManageId);
						rcord2.setAttribute("budgetManagementId", budgetManagementId);
						rcord2.setAttribute("budgetAttachmentId", budgetAttachmentId);
						rcord2.setAttribute("paymentSequenceId", paymentSequenceId);
						rcord2.setAttribute("reimbursementAmount", reimbursementAmount);//报销金额  
						rcord2.setAttribute("reverseAmount", reverseAmount);//冲账金额
						rcord2.setAttribute("payAmount", payAmount);//付款金额
						rcord2.setAttribute("psRemark", psRemark);
					}
					if(mainRecord!=null) {
						rcord2.setAttribute("projectId", projectId);
						rcord2.setAttribute("bdCode", bdCode);
					}
					panel2.setTitle("预算普通日常报销申请");
					panel2.setProcessId(ClientUtil.checkAndGetIntValue(gerProcessId("Common_normal_reimbursement")));
					panel2.setData(rcord2);
					panel2.setLayoutMode(0);
					panel2.initComponents();
					panel2.setWidth("100%");
					panel2.setHeight("100%");
					panel2.centerInPage();
					panel2.show();
					break;
				case 3://项目差旅报销
					NewProcessWindow panel3=new NewProcessWindow();
					Record rcord3=new Record();
					if(payrecord!=null) {
						rcord3.setAttribute("receiveUnitManageId", receiveUnitManageId);
						rcord3.setAttribute("budgetManagementId", budgetManagementId);
						rcord3.setAttribute("budgetAttachmentId", budgetAttachmentId);
						rcord3.setAttribute("paymentSequenceId", paymentSequenceId);
						rcord3.setAttribute("reimbursementAmount", reimbursementAmount);//报销金额  
						rcord3.setAttribute("reverseAmount", reverseAmount);//冲账金额
						rcord3.setAttribute("payAmount", payAmount);//付款金额
						rcord3.setAttribute("psRemark", psRemark);
					}
					if(mainRecord!=null) {
						rcord3.setAttribute("projectId", projectId);
						rcord3.setAttribute("bdCode", bdCode);
					}
					panel3.setTitle("预算项目差旅报销申请");
					panel3.setProcessId(ClientUtil.checkAndGetIntValue(gerProcessId("Project_travel_reimbursement")));
					panel3.setData(rcord3);
					panel3.setLayoutMode(0);
					panel3.initComponents();
					panel3.setWidth("100%");
					panel3.setHeight("100%");
					panel3.centerInPage();
					panel3.show();
					break;
				case 4://借款申请
					NewProcessWindow panel4=new NewProcessWindow();
					Record rcord4=new Record();
					if(payrecord!=null) {
						rcord4.setAttribute("receiveUnitManageId", receiveUnitManageId);
						rcord4.setAttribute("budgetManagementId", budgetManagementId);
						rcord4.setAttribute("budgetAttachmentId", budgetAttachmentId);
						rcord4.setAttribute("paymentSequenceId", paymentSequenceId);
						rcord4.setAttribute("reimbursementAmount", reimbursementAmount);//报销金额  
						rcord4.setAttribute("reverseAmount", reverseAmount);//冲账金额
						rcord4.setAttribute("payAmount", payAmount);//付款金额
						rcord4.setAttribute("psRemark", psRemark);
					}
					if(mainRecord!=null) {
						rcord4.setAttribute("projectId", projectId);
						rcord4.setAttribute("bdCode", bdCode);
					}
					panel4.setTitle("预算借款申请");
					panel4.setProcessId(ClientUtil.checkAndGetIntValue(gerProcessId("Borrow_money_manage")));
					panel4.setData(rcord4);
					panel4.setLayoutMode(0);
					panel4.initComponents();
					panel4.setWidth("100%");
					panel4.setHeight("100%");
					panel4.centerInPage();
					panel4.show();
					break;
				case 5://预付款
					NewProcessWindow panel5=new NewProcessWindow();
					Record rcord5=new Record();
					if(payrecord!=null) {
						rcord5.setAttribute("receiveUnitManageId", receiveUnitManageId);
						rcord5.setAttribute("budgetManagementId", budgetManagementId);
						rcord5.setAttribute("budgetAttachmentId", budgetAttachmentId);
						rcord5.setAttribute("paymentSequenceId", paymentSequenceId);
						rcord5.setAttribute("payAmount", payAmount);
					}
					if(mainRecord!=null) {
						rcord5.setAttribute("projectId", projectId);
						rcord5.setAttribute("bdCode", bdCode);
					}
					panel5.setTitle("预算付款申请");
					panel5.setProcessId(ClientUtil.checkAndGetIntValue(gerProcessId("Pay_money_manage")));
					panel5.setData(rcord5);
					panel5.setLayoutMode(0);
					panel5.initComponents();
					panel5.setWidth("80%");
					panel5.setHeight("80%");
					panel5.centerInPage();
					panel5.show();
					break;
				case 6://还款申请
					NewProcessWindow panel6=new NewProcessWindow();
					Record rcord6=new Record();
					if(payrecord!=null) {
						rcord6.setAttribute("receiveUnitManageId", receiveUnitManageId);
						rcord6.setAttribute("budgetManagementId", budgetManagementId);
						rcord6.setAttribute("budgetAttachmentId", budgetAttachmentId);
						rcord6.setAttribute("paymentSequenceId", paymentSequenceId);
						rcord6.setAttribute("returnAmount", returnAmount);
					}
					if(mainRecord!=null) {
						rcord6.setAttribute("projectIds", projectId);
						rcord6.setAttribute("bdCode", bdCode);
					}
					panel6.setTitle("预算还款申请");
					panel6.setProcessId(ClientUtil.checkAndGetIntValue(gerProcessId("Employee_repayment_apply")));
					panel6.setData(rcord6);
					panel6.setLayoutMode(0);
					panel6.initComponents();
					panel6.setWidth("80%");
					panel6.setHeight("80%");
					panel6.centerInPage();
					panel6.show();
					break;
				}
			}
		});


		quitbut=new IButton("关闭");
		rightLayout.addMember(quitbut);
		quitbut.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (getParentWindow() == null) {
					return;
				}
				getParentWindow().destroy();
				DataEditEvent dee = new DataEditEvent();
				fireEvent(dee);
			}
		});


	}

	public void loadData() {
		//final LoadingWindow loading = new LoadingWindow();
		//获取订单管理id
		int budgetManagementId=record.getAttributeAsInt("budgetManagementId");
		//获取附件id
		int budgetAttachmentId=record.getAttributeAsInt("budgetAttachmentId");
		Map<String,Object> map=new HashMap<>();
		map.put("budgetManagementId", budgetManagementId);
		map.put("budgetAttachmentId", budgetAttachmentId);
		map.put("addtionalCondition", "order by payment_sequence_id");  
		DBDataSource.callOperation("ST_PaymentSequence","find",map,new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				//loading.destroy();
				if(dsResponse.getStatus()>=0){
					paySeqGrid.setData(dsResponse.getData());
				}
			}
		});
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


	public Window getParentWindow() {
		return parentWindow;
	}

	public void setParentWindow(Window parentWindow) {
		this.parentWindow = parentWindow;
	}
	private Record record;

	public Record getRecord() {
		return record;
	}

	public void setRecord(Record record) {
		this.record = record;
	}

	private Record mainRecord;

	public Record getMainRecord() {
		return mainRecord;
	}

	public void setMainRecord(Record mainRecord) {
		this.mainRecord = mainRecord;
	}

	//获取流程ID
	public String gerProcessId(String workName) {
		String processId = "";
		Storage sta = Storage.getLocalStorageIfSupported();
							String str = sta.getItem(PomPlatformClientUtil.PROCESS_ID_COOKIE);
		if(!PomPlatformClientUtil.isNullOrEmpty(str)){
			String[] arr = str.split(",");
			for(String tempStr : arr){
				String[] tempArr = tempStr.split(":");
				//获取父级ID
				if(tempArr[0].replaceAll("\"", "").equals(workName)){
					processId = tempArr[1];
				}
			}
		}
		return processId;
	}

	public boolean cheakPaySeqData(Record records) {
		if(records==null) {
			SC.warn("提示","请选择一条数据进行付款申请！");
			return true;
		}
		int paymentSequenceId=BaseHelpUtils.getIntValue(records.getAttribute("paymentSequenceId"));
		int payStatus=BaseHelpUtils.getIntValue(records.getAttribute("payStatus"));
		if(paymentSequenceId<=0) {
			SC.warn("提示","此条付款序列没有保存,请单击保存，再进行付款申请！");
			return true;
		}
		if(payStatus==2) {
			SC.warn("提示","此条付款序列已经付款,不能再操作！");
			return true;
		}
		if(payStatus==3) {
			SC.warn("提示","此条付款序列在付款申请中,不能再操作！");
			return true;
		}
		ListGridRecord[] listRecord=paySeqGrid.getGridSummaryData();
		BigDecimal  amount=BigDecimal.ZERO;
		BigDecimal reimbursementAmount=BigDecimal.ZERO;
		BigDecimal payAmount=BigDecimal.ZERO;

		for (ListGridRecord listGridRecord : listRecord) {
			//canSelect=false, reimbursementAmount=38000, payAmount=626000, reverseAmount=621500, returnAmount=10000
			//获取报销总金额
			reimbursementAmount=BaseHelpUtils.getBigDecimalValue(listGridRecord.getAttribute("reimbursementAmount"));
			//获取付款金额
			payAmount=BaseHelpUtils.getBigDecimalValue(listGridRecord.getAttribute("payAmount"));
			amount=reimbursementAmount.add(payAmount);		
		}
		BigDecimal budgetContractAmountRest=BaseHelpUtils.getBigDecimalValue(record.getAttribute("budgetContractAmountRest"));
		if(amount.compareTo(budgetContractAmountRest)>0) {
			SC.warn("提示","当前付款序列总金额超过合同金额,请重新分配序列！"+"当前报销总金额为["+reimbursementAmount+"],付款总金额为["+payAmount+"],付款序列总金额为["+amount+"],合同剩余金额为["+budgetContractAmountRest+"]");
			return true;
		}

		return false;
	}





}
