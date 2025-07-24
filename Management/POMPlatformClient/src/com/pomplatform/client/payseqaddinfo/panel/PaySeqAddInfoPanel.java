package com.pomplatform.client.payseqaddinfo.panel;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.NewProcessWindow;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.storage.client.Storage;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.budgetmanagement.panel.PaySeqRbCodePanel;
import com.pomplatform.client.budgetmanagement.panel.PaySeqReceiveInfo;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.common.SyncDataUtil;
import com.pomplatform.client.payseqaddinfo.datasource.DSPaySeqAddInfo;
import com.pomplatform.client.payseqaddinfo.form.PaySeqAddInfoViewer;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.ChangedEvent;
import com.smartgwt.client.widgets.grid.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;

public class PaySeqAddInfoPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			PaySeqAddInfoPanel cm = new PaySeqAddInfoPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "PaySeqAddInfo";
		}

	}

	@Override
	public void init(){
		super.init();

		resultGrid = new DelicacyListGrid(){
			protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
				int payType=BaseHelpUtils.getIntValue(record.getAttribute("payType"));
				if (getFieldName(colNum).equals("payAmount")) { 
					switch (payType) {
					/*case 1://项目日常报销
						getField(colNum).setCanEdit(false);
						break;
					case 2://普通日常报销
						getField(colNum).setCanEdit(false);
						break;
					case 3://项目差旅报销
						getField(colNum).setCanEdit(false);
						break;*/
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
					resultGrid.getRecord(rowNum).set_canEdit(false);
					return "color: 009966;";
				}else if(payStatus==3) {//付款申请中
					resultGrid.getRecord(rowNum).set_canEdit(false);
					return "color: #D2691E;";
				}
				else {
					return null;
				}

			}  
		};
		resultGrid.setWidth("90%");
		resultGrid.setAlign(Alignment.LEFT);
		resultGrid.setAutoFitFieldWidths(false);
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
		aFields[a].setShowGridSummary(false);
		SelectItem  payItme=new SelectItem();
		payItme.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		aFields[a].setEditorProperties(payItme);
		aFields[a].setValueMap(KeyValueManager.getValueMap("system_dictionary_193"));
		aFields[a].setWidth("25%");
		aFields[a].setCanEdit(true);
		aFields[a].addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				int payType=BaseHelpUtils.getIntValue(event.getValue());
				switch (payType) {
				case 1://项目日常报销
					//event.getForm().getItem("payAmount").setDisabled(true);
					event.getForm().getItem("returnAmount").setDisabled(true);
					break;
				case 2://普通日常报销
					//event.getForm().getItem("payAmount").setDisabled(true);
					event.getForm().getItem("returnAmount").setDisabled(true);
					break;
				case 3://项目差旅报销
					//event.getForm().getItem("payAmount").setDisabled(true);
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
		//aFields[a].setDefaultValue(new Date());
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("reimbursementAmount","报销金额");
		aFields[a].setAlign(Alignment.RIGHT);
		aFields[a].setType(ListGridFieldType.FLOAT);
		aFields[a].setFormat("##,###,###,###,##0.00");
		aFields[a].setWidth("25%");
		aFields[a].setCanEdit(true);
		a++;
		aFields[a] = new ListGridField("payAmount","<span style='color:red;'>付款金额</span>");
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
		aFields[a] = new ListGridField("payFor","收款方类型");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setShowGridSummary(false);
		ComboBoxItem payForItem = new ComboBoxItem();
		payForItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		aFields[a].setEditorProperties(payForItem);
		aFields[a].setValueMap(KeyValueManager.getValueMap("system_dictionary_196"));
		aFields[a].setWidth("20%");
		aFields[a].setCanEdit(true);
		aFields[a].addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				int rowRum=event.getRowNum();
				Record record=resultGrid.getRecord(rowRum);
				int paymentSequenceId=BaseHelpUtils.getIntValue(record.getAttribute("paymentSequenceId"));
				Map<String,Object> params = new HashMap<>();
				params.put("paymentSequenceId", paymentSequenceId);
				params.put("payFor", event.getValue());
				params.put("optType", "payForUpdate");
				DBDataSource.callOperation("EP_EidtPaymentSequence",params,new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0) {
							event.getForm().getItem("payName").clearValue();
							commonQuery();
						}else {
							SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
						}
					}
				});	
			}
		});
		a++;
		aFields[a] = new ListGridField("receiveUnitManageId","收款方Id");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setShowGridSummary(false);
		ComboBoxItem receiveUnitManageIdItem = new ComboBoxItem();
		receiveUnitManageIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		aFields[a].setEditorProperties(receiveUnitManageIdItem);
		aFields[a].setWidth("45%");
		aFields[a].setCanEdit(false);
		aFields[a].setHidden(true);
		a++;
		aFields[a] = new ListGridField("payName","收款方名称");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setWidth("45%");
		aFields[a].setCanEdit(false);
		aFields[a].addRecordClickHandler(new RecordClickHandler() {
			@Override
			public void onRecordClick(RecordClickEvent event) {
				int rowRum=event.getRecordNum();
				Record record=resultGrid.getRecord(rowRum);
				int payStatus=BaseHelpUtils.getIntValue(record.getAttribute("payStatus"));
				//获取付款类型ID  
				if(payStatus==2) {//已付款
					SC.say("已付款不能更改收款方");
					return ;
				}else if(payStatus==3) {//付款申请中
					SC.say("付款申请中不能更改收款方");
					return ;
				}
				PopupWindow popupWindow = new PopupWindow();
				popupWindow.setTitle("添加收款方"); 
				popupWindow.setWidth("50%"); 
				popupWindow.setHeight("50%");
				PaySeqReceiveInfo PaySeqReceiveInfoPanel =new PaySeqReceiveInfo();
				PaySeqReceiveInfoPanel.addDataEditedHandler(new DataEditedHandler(){
					@Override
					public void onDataEdited(DataEditEvent event) {
						commonQuery();
					}
				});
				popupWindow.addCloseClickHandler(new CloseClickHandler() {
					@Override
					public void onCloseClick(CloseClickEvent event) {
						popupWindow.destroy();
					}
				});
				PaySeqReceiveInfoPanel.setRecord(record);
				PaySeqReceiveInfoPanel.initComponents();
				PaySeqReceiveInfoPanel.lodaData();
				popupWindow.addItem(PaySeqReceiveInfoPanel);
				PaySeqReceiveInfoPanel.setParentWindow(popupWindow);
				popupWindow.centerInPage();
				popupWindow.show();			
			}
		});
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
		aFields[a].setShowGridSummary(false);
		aFields[a].setValueMap(KeyValueManager.getValueMap("system_dictionary_194"));
		aFields[a].setCanEdit(false);
		aFields[a].setDefaultValue(1);
		aFields[a].setWidth("15%");
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("payDate","付款时间");  
		aFields[a].setAlign(Alignment.CENTER);
		DateTimeItem  dateItems=new DateTimeItem();
		dateItems.setUseTextField(true);
		aFields[a].setEditorProperties(dateItems);
		aFields[a].setWidth("25%");
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("reimbursementCode","报销编号");  
		aFields[a].setWidth("25%");
		aFields[a].setCanEdit(false);
		aFields[a].setHidden(false);
		aFields[a].addRecordClickHandler(new RecordClickHandler() {
			@Override
			public void onRecordClick(RecordClickEvent event) {
				if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.BD_EDIT_REIMBURSEMENT)) {
					int rowRum=event.getRecordNum();
					Record record=resultGrid.getRecord(rowRum);
					int payType=BaseHelpUtils.getIntValue(record.getAttribute("payType"));
					if(BaseHelpUtils.isNullOrEmpty(payType)||payType<=0) {
						SC.say("请选择付款类型");
						return;
					}
					int payStatus=BaseHelpUtils.getIntValue(record.getAttribute("payStatus"));
					if(payStatus==2) {
						SC.say("此序列已付款，不能编辑报销编号");
						return;
					}
					if(payStatus==3) {
						SC.say("此序列在付款申请中，不能编辑报销编号");
						return;
					}
					PopupWindow popupWindow = new PopupWindow();
					popupWindow.setTitle("报销编号查询"); 
					popupWindow.setWidth("60%"); 
					popupWindow.setHeight("70%");
					PaySeqRbCodePanel paySeqRbCodePanel =new PaySeqRbCodePanel();
					paySeqRbCodePanel.addDataEditedHandler(new DataEditedHandler(){
						@Override
						public void onDataEdited(DataEditEvent event) {
							commonQuery();
						}
					});
					popupWindow.addCloseClickHandler(new CloseClickHandler() {
						@Override
						public void onCloseClick(CloseClickEvent event) {
							popupWindow.destroy();
						}
					});
					paySeqRbCodePanel.setRecord(record);
					paySeqRbCodePanel.initComponents();
					paySeqRbCodePanel.lodaData();
					popupWindow.addItem(paySeqRbCodePanel);
					paySeqRbCodePanel.setParentWindow(popupWindow);
					popupWindow.centerInPage();
					popupWindow.show();
				}
			}
		});
		a++;
		aFields[a] = new ListGridField("projectId","项目名称");  
		aFields[a].setWidth("25%");
		aFields[a].setCanEdit(false);
		aFields[a].setHidden(true);
		resultGrid.setFields(aFields);
		resultGrid.setDataSource(getDataSource());
		resultGrid.setShowGridSummary(true);
		resultGrid.addEditCompleteHandler(new EditCompleteHandler() {
			@SuppressWarnings("unchecked")
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				int rowNum = event.getRowNum();
				Record records=resultGrid.getRecord(rowNum);
				int payType=BaseHelpUtils.getIntValue(records.getAttribute("payType"));
				if(payType<=0) {
					SC.say("请选择付款类型");
				}
				//预算管理ID
				int budgetManagementId=BaseHelpUtils.getIntValue(record.getAttribute("budgetManagementId"));
				//获取附件id
				int budgetAttachmentId=BaseHelpUtils.getIntValue(record.getAttribute("budgetAttachmentId"));
				Map<String,Object> params = new HashMap<>();
				params.putAll(records.toMap());
				params.put("budgetManagementId", budgetManagementId);
				params.put("budgetAttachmentId", budgetAttachmentId);
				params.put("applyPayDate", new Date());
				params.put("optType", "savaOrUpdate");
				DBDataSource.callOperation("EP_EidtPaymentSequence",params,new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0) {
							commonQuery();
						}else {
							SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
						}
					}
				});	

			}
		});
		__controlPosition = LayoutConstant.RIGHT;
	}

	@Override
	public void initComponents() {
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});

		IButton  addbut=new IButton("新增");
		controlLayout.addMember(addbut);
		addbut.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				//获取收款单位ID
				int receiveUnitManageId=BaseHelpUtils.getIntValue(record.getAttribute("receiveUnitManageId"));
				//预算管理ID
				int budgetManagementId=BaseHelpUtils.getIntValue(record.getAttribute("budgetManagementId"));
				//获取附件id
				int budgetAttachmentId=BaseHelpUtils.getIntValue(record.getAttribute("budgetAttachmentId"));
				//项目Id
				int projectId=BaseHelpUtils.getIntValue(mainRecord.getAttribute("projectId"));
				Map<String,Object> map=new HashMap<>();
				map.put("receiveUnitManageId", receiveUnitManageId);
				Record reRecord=SyncDataUtil.getValueByTableName("ST_ReceiveUnitManage", "find",map);
				//获取收款方名称
				String payName=BaseHelpUtils.getString(reRecord.getAttribute("receiveUnit"));
				Record records=new Record();
				records.setAttribute("receiveUnitManageId",receiveUnitManageId);
				records.setAttribute("payFor",2);
				records.setAttribute("budgetManagementId",budgetManagementId);
				records.setAttribute("budgetAttachmentId",budgetAttachmentId);
				records.setAttribute("payName",payName);
				records.setAttribute("projectId",projectId);
				resultGrid.startEditingNew(records);
			}
		});

		IButton delbut=new IButton("删除");
		controlLayout.addMember(delbut);
		delbut.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				Record  payrecord=resultGrid.getSelectedRecord();
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
							Record[]  records=resultGrid.getSelectedRecords();
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
											commonQuery();
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

		IButton paybut=new IButton("付款申请");
		controlLayout.addMember(paybut);
		paybut.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Record  payrecord=resultGrid.getSelectedRecord();
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
				int payFor=0;
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
					//收款方类型
					payFor=BaseHelpUtils.getIntValue(payrecord.getAttribute("payFor"));
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
						rcord1.setAttribute("payFor", payFor);
					}
					if(mainRecord!=null) {
						rcord1.setAttribute("projectId", projectId);
						rcord1.setAttribute("bdCode", bdCode);
					}
					panel1.setTitle("预算项目日常报销申请");
					panel1.setProcessId(ClientUtil.checkAndGetIntValue(gerProcessId("Project_normal_reimbursement")));
					panel1.addDataEditedHandler(new DataEditedHandler() {
						@Override
						public void onDataEdited(DataEditEvent event) {
							commonQuery();
						}
					});
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
						rcord2.setAttribute("payFor", payFor);
					}
					if(mainRecord!=null) {
						rcord2.setAttribute("projectId", projectId);
						rcord2.setAttribute("bdCode", bdCode);
					}
					panel2.setTitle("预算普通日常报销申请");
					panel2.addDataEditedHandler(new DataEditedHandler() {
						@Override
						public void onDataEdited(DataEditEvent event) {
							commonQuery();
						}
					});
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
						rcord3.setAttribute("payFor", payFor);
					}
					if(mainRecord!=null) {
						rcord3.setAttribute("projectId", projectId);
						rcord3.setAttribute("bdCode", bdCode);
					}
					panel3.setTitle("预算项目差旅报销申请");
					panel3.addDataEditedHandler(new DataEditedHandler() {
						@Override
						public void onDataEdited(DataEditEvent event) {
							commonQuery();
						}
					});
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
						rcord4.setAttribute("payFor", payFor);
					}
					if(mainRecord!=null) {
						rcord4.setAttribute("projectId", projectId);
						rcord4.setAttribute("bdCode", bdCode);
					}
					panel4.setTitle("预算借款申请");
					panel4.addDataEditedHandler(new DataEditedHandler() {
						@Override
						public void onDataEdited(DataEditEvent event) {
							commonQuery();
						}
					});
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
						rcord5.setAttribute("payFor", payFor);
					}
					if(mainRecord!=null) {
						rcord5.setAttribute("projectId", projectId);
						rcord5.setAttribute("bdCode", bdCode);
					}
					panel5.setTitle("预算付款申请");
					panel5.addDataEditedHandler(new DataEditedHandler() {
						@Override
						public void onDataEdited(DataEditEvent event) {
							commonQuery();
						}
					});
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
						rcord6.setAttribute("payFor", payFor);
					}
					if(mainRecord!=null) {
						rcord6.setAttribute("projectIds", projectId);
						rcord6.setAttribute("bdCode", bdCode);
					}
					panel6.setTitle("预算还款申请");
					panel6.addDataEditedHandler(new DataEditedHandler() {
						@Override
						public void onDataEdited(DataEditEvent event) {
							commonQuery();
						}
					});
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

		IButton downbut=new IButton("导出序列");
		controlLayout.addMember(downbut);
		downbut.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Map condition = generateCriteria();
				DBDataSource.downloadFile("DW_ExportPaySeqInfo", condition);
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
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("PaySeqAddInfo"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				PaySeqAddInfoViewer detailForm = new PaySeqAddInfoViewer();
				detailForm.setParentSearchForm(searchForm);
				detailForm.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_TAB);
				detailForm.initComponents();
				detailForm.viewSelectedData(resultGrid);
				detail.setContent(detailForm);
				detail.centerInPage();
				detail.show();
			}
		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		//获取预算管理id
		int budgetManagementId=record.getAttributeAsInt("budgetManagementId");
		//获取附件id
		int budgetAttachmentId=record.getAttributeAsInt("budgetAttachmentId");
		criteria.put("budgetManagementId", budgetManagementId);
		criteria.put("budgetAttachmentId", budgetAttachmentId);
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		//return new PaySeqAddInfoSearchForm();
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSPaySeqAddInfo.getInstance();
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

	public boolean cheakPaySeqData(Record records) {
		if(records==null) {
			SC.warn("提示","请选择一条数据进行付款申请！");
			return true;
		}
		int payStatus=BaseHelpUtils.getIntValue(records.getAttribute("payStatus"));
		int payType=BaseHelpUtils.getIntValue(records.getAttribute("payType"));
		String payName=BaseHelpUtils.getString(records.getAttribute("payName"));
		int payFor=BaseHelpUtils.getIntValue(records.getAttribute("payFor"));
		String psRemark=BaseHelpUtils.getString(records.getAttribute("psRemark"));
		if(payFor<=0) {
			SC.warn("提示","请选择收款方类型");
			return true;
		}
		if(payType<=0) {
			SC.warn("提示","请选择付款类型");
			return true;
		}
		if(payType==4) {//借款
			if(payFor==ClientStaticUtils.PAY_FOR_RECEIVE_UNIT) {//公司
				SC.warn("提示","借款"+"<span style='color:red;'>收款方类型</span>"+"只能选择个人,请重新选择！");
				return true;
			}
		}
		if(payType==5) {//预付款
			if(payFor==ClientStaticUtils.PAY_FOR_EMPLOYEE) {//个人
				SC.warn("提示","预付款"+"<span style='color:red;'>收款方类型</span>"+"只能选择公司,请重新选择！");
				return true;
			}
		}
		if(payType==6) {//预付款
			if(payFor==ClientStaticUtils.PAY_FOR_EMPLOYEE) {//个人
				SC.warn("提示","还款"+"<span style='color:red;'>收款方类型</span>"+"只能选择公司,请重新选择！");
				return true;
			}
		}
		if(BaseHelpUtils.isNullOrEmpty(payName)&&payName.length()==0) {
			SC.warn("提示","请选择收款方");
			return true;
		}
		if(BaseHelpUtils.isNullOrEmpty(psRemark)&&psRemark.length()==0) {
			SC.warn("提示","请填写备注");
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
		ListGridRecord[] listRecord=resultGrid.getGridSummaryData();
		BigDecimal payAmount=BigDecimal.ZERO;
		BigDecimal returnAmount=BigDecimal.ZERO;
		for (ListGridRecord listGridRecord : listRecord) {
			//获取付款总金额
			payAmount=BaseHelpUtils.getBigDecimalValue(listGridRecord.getAttribute("payAmount"));
			//获取还款金额
			returnAmount=BaseHelpUtils.getBigDecimalValue(listGridRecord.getAttribute("returnAmount"));
		}
		//合同剩余金额
		BigDecimal budgetContractAmountRest=BaseHelpUtils.getBigDecimalValue(record.getAttribute("budgetContractAmountRest"));
		//合同预算金额
		BigDecimal budgetContractAmount=BaseHelpUtils.getBigDecimalValue(record.getAttribute("budgetContractAmount"));
		//合同已付金额
		BigDecimal budgetContractAmountUse=BaseHelpUtils.getBigDecimalValue(record.getAttribute("budgetContractAmountUse"));
		if(payAmount.subtract(returnAmount).compareTo(budgetContractAmount)>0) {
			SC.warn("提示","当前付款序列总金额超过合同预算金额,请重新分配序列！"+"<br>"+"当前序列付款总金额为[<b>"+payAmount.subtract(returnAmount)+"</b>],"+"<br>"+"合同预算金额为[<b>"+budgetContractAmount+"</b>],合同已付金额为[<b>"+budgetContractAmountUse+"</b>],合同剩余金额为[<b>"+budgetContractAmountRest+"</b>]");
			return true;
		}

		return false;
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
}

