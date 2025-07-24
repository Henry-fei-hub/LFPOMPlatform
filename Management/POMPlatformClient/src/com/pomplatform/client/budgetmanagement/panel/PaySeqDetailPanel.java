package com.pomplatform.client.budgetmanagement.panel;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
import com.delicacy.client.ui.LoadingWindow;
import com.delicacy.client.ui.ViewProcessWindow;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PaySeqDetailPanel  extends HLayout implements HasHandlers {
	private Window parentWindow;
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	private static Logger __logger = Logger.getLogger("");
	private  VLayout mainLayout;
	private  HLayout  topLayout;
	private  VLayout   topbuttuon;
	private DelicacyListGrid paySeqGrid;
	private IButton  addbut;
	private IButton  savebut;
	private IButton  delbut;
	private Label totalsLabel;
	private SelectItem  payTypeItem;
	private ComboBoxItem  payNameItem;
	private SelectItem  payStatusItem;
	private IButton   searchBtn;
	private IButton   resetBtn;
	private DynamicForm form;
	private SelectItem  payForItem;
	public void initComponents() {
		mainLayout=new VLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();;
		addMember(mainLayout);

		topLayout=new HLayout(10);
		topLayout.setHeight("8%");
		topLayout.setMargin(10);
		topLayout.setWidth100();
		mainLayout.addMember(topLayout);

		form=new DynamicForm();
		form.setNumCols(4);
		form.setAlign(Alignment.CENTER);
		/*form.setPadding(5);
		form.setMargin(5)*/;
		form.setWidth100();
		form.setHeight("20%");



		payTypeItem=new SelectItem("payType","付款类型");
		payTypeItem.setWidth("*");
		payTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_193"));


		payForItem=new SelectItem("payFor","收款方类型");
		payForItem.setWidth("*");
		payForItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_196"));
		payForItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Map<String,Object> map=new HashMap<>();
				//获取订单管理id
				int budgetManagementId=record.getAttributeAsInt("budgetManagementId");
				//获取附件id
				int budgetAttachmentId=record.getAttributeAsInt("budgetAttachmentId");
				map.put("budgetManagementId", budgetManagementId);
				map.put("budgetAttachmentId", budgetAttachmentId);
				int payFor=BaseHelpUtils.getIntValue(event.getValue());
				if(payFor==1) {
					map.put("payFor", payFor);
					DBDataSource.callOperation("ST_PaymentSequence","find",map,new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if(dsResponse.getStatus()>=0){
								LinkedHashMap<String, String>  linkMap=new LinkedHashMap<>();
								Record[] records=dsResponse.getData();
								for (Record record : records) {
									String payName=record.getAttribute("payName");
									linkMap.put(payName, payName);
								}
								payNameItem.setValueMap(linkMap);
							}
						}
					});
				}else {
					map.put("payFor", payFor);
					DBDataSource.callOperation("ST_PaymentSequence","find",map,new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if(dsResponse.getStatus()>=0){
								LinkedHashMap<String, String>  linkMap=new LinkedHashMap<>();
								Record[] records=dsResponse.getData();
								for (Record record : records) {
									String payName=record.getAttribute("payName");
									linkMap.put(payName, payName);
								}
								payNameItem.setValueMap(linkMap);
							}
						}
					});
				}
			}
		});

		payNameItem=new ComboBoxItem("payName","收款方名称");
		payNameItem.setWidth("*");

		payStatusItem=new SelectItem("payStatus","付款状态");
		payStatusItem.setWidth("*");
		payStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_194"));
		form.setItems(payForItem,payNameItem,payTypeItem,payStatusItem);

		topLayout.addMember(form);

		topbuttuon=new VLayout(10);
		topbuttuon.setAlign(Alignment.RIGHT);
		topbuttuon.setHeight("8%");

		searchBtn=new IButton("搜索");
		searchBtn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				int payType=BaseHelpUtils.getIntValue(payTypeItem.getValue());
				int payFor=BaseHelpUtils.getIntValue(payForItem.getValue());
				int payStatus=BaseHelpUtils.getIntValue(payStatusItem.getValue());
				String payName=BaseHelpUtils.getString(payNameItem.getValue());
				serchData(payType, payFor, payStatus,payName);
			}
		});
		topbuttuon.addMember(searchBtn);

		resetBtn=new IButton("重置");
		resetBtn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				payTypeItem.clearValue();
				payNameItem.clearValue();
				payStatusItem.clearValue();
				serchData(null,null,null,null);
			}
		});
		topbuttuon.addMember(resetBtn);

		topLayout.addMember(topbuttuon);


		paySeqGrid=new DelicacyListGrid(){
			protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
				int payStatus=BaseHelpUtils.getIntValue(record.getAttribute("payStatus"));
				if(payStatus==1) {//未付款
					return null;
				}else if(payStatus==2) {//已付款 lightgray
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
		paySeqGrid.setWidth("100%");
		paySeqGrid.setAlign(Alignment.CENTER);
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
		aFields[a].setValueMap(KeyValueManager.getValueMap("system_dictionary_193"));
		aFields[a].setWidth("25%");
		aFields[a].setCanEdit(true);
		a++;
		aFields[a] = new ListGridField("applyPayDate","申请付款时间");
		DateTimeItem  dateItem=new DateTimeItem();
		dateItem.setUseTextField(true);
		aFields[a].setEditorProperties(dateItem);
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setWidth("25%");
		aFields[a].setDefaultValue(new Date());
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
		aFields[a].setValueMap(KeyValueManager.getValueMap("system_dictionary_196"));
		aFields[a].setWidth("15%");
		a++;
		aFields[a] = new ListGridField("payName","收款方名称");
		aFields[a].setWidth("45%");
		a++;
		aFields[a] = new ListGridField("psRemark","备注"); 
		aFields[a].setWidth("45%");
		a++;
		aFields[a] = new ListGridField("isLock","是否加锁");
		aFields[a].setWidth("25%");
		aFields[a].setHidden(true);
		a++;
		aFields[a] = new ListGridField("payStatus","付款状态");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setValueMap(KeyValueManager.getValueMap("system_dictionary_194"));
		aFields[a].setCanEdit(false);
		aFields[a].setDefaultValue(1);
		aFields[a].setWidth("15%");
		a++;
		aFields[a] = new ListGridField("payDate","付款时间");  
		DateTimeItem  dateItems=new DateTimeItem();
		dateItem.setUseTextField(true);
		aFields[a].setEditorProperties(dateItems);
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setWidth("25%");
		a++;
		aFields[a] = new ListGridField("processType");
		aFields[a].setHidden(true);
		aFields[a].setShowGridSummary(false);
		a++;
		aFields[a] = new ListGridField("processId");
		aFields[a].setShowGridSummary(false);
		aFields[a].setHidden(true);
		a++;
		aFields[a] = new ListGridField("reimbursementCode","报销编号");
		aFields[a].setWidth("25%");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setShowGridSummary(false);
		paySeqGrid.setFields(aFields);
		paySeqGrid.setCanEdit(false);
		paySeqGrid.setCanRemoveRecords(false);
		paySeqGrid.setShowGridSummary(true);
		paySeqGrid.addDoubleClickHandler(new DoubleClickHandler() {

			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				Record record=paySeqGrid.getSelectedRecord();
				int processType=BaseHelpUtils.getIntValue(record.getAttribute("processType"));
				int processId=BaseHelpUtils.getIntValue(record.getAttribute("processId"));
				if(processType<=0||processId<=0) {
					SC.say("此序列没有发起付款流程，无法查看付款详情");
					return;
				}
				int payType=BaseHelpUtils.getIntValue(record.getAttribute("payType"));
				int paymentSequenceId=BaseHelpUtils.getIntValue(record.getAttribute("paymentSequenceId"));
				int budgetAttachmentId=BaseHelpUtils.getIntValue(record.getAttribute("budgetAttachmentId"));
				int budgetManagementId=BaseHelpUtils.getIntValue(record.getAttribute("budgetManagementId"));
				Map<String,Object> map=new HashMap<>();
				map.put("paymentSequenceId", paymentSequenceId);
				map.put("budgetAttachmentId", budgetAttachmentId);
				map.put("budgetManagementId", budgetManagementId);
				map.put("payType", payType);
				map.put("processType", processType);
				map.put("processId", processId);
				map.put("optType", "payStatusInfo");
				DBDataSource.callOperation("EP_EidtPaymentSequence",map, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() >= 0) {
							@SuppressWarnings("unchecked")
							Map<String,Object> userDataMap = BaseHelpUtils.getResponseUserData(dsResponse);
							int processInstanceId=BaseHelpUtils.getIntValue(userDataMap.get("processInstanceId"));
							Record records=new Record();
							records.setAttribute("processType", processType);
							records.setAttribute("processId", processId);
							records.setAttribute("processInstanceId", processInstanceId);
							ViewProcessWindow Reimbursement = new ViewProcessWindow();
							Reimbursement.setWidth("80%");
							Reimbursement.setHeight("80%");
							Reimbursement.setLayoutMode(0);
							Reimbursement.setInstanceData(records);
							Reimbursement.initComponents();
							Reimbursement.setTitle(ClientUtil.getProcessTypeName(records));
							Reimbursement.show();
						}
					}
				});
			}
		});


		mainLayout.addMember(paySeqGrid);

	}

	public void loadData() {
		final LoadingWindow loading = new LoadingWindow();
		//获取订单管理id
		int budgetManagementId=record.getAttributeAsInt("budgetManagementId");
		//获取附件id
		int budgetAttachmentId=record.getAttributeAsInt("budgetAttachmentId");
		Map<String,Object> map=new HashMap<>();
		map.put("budgetManagementId", budgetManagementId);
		map.put("budgetAttachmentId", budgetAttachmentId);
		map.put("addtionalCondition", "order by payment_sequence_id desc");
		DBDataSource.callOperation("ST_PaymentSequence","find",map,new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				loading.destroy();
				if(dsResponse.getStatus()>=0){
					paySeqGrid.setData(dsResponse.getData());
					LinkedHashMap<String, String>  linkMap=new LinkedHashMap<>();
					Record[] records=dsResponse.getData();
					for (Record record : records) {
						String payName=record.getAttribute("payName");
						linkMap.put(payName, payName);
					}
					payNameItem.setValueMap(linkMap);
				}
			}
		});
	}

	public void serchData(Integer payType,Integer payFor,Integer payStatus,String payName) {
		final LoadingWindow loading = new LoadingWindow();
		Map<String,Object> map=new HashMap<>();
		//获取订单管理id
		int budgetManagementId=record.getAttributeAsInt("budgetManagementId");
		//获取附件id
		int budgetAttachmentId=record.getAttributeAsInt("budgetAttachmentId");
		map.put("budgetManagementId", budgetManagementId);
		map.put("budgetAttachmentId", budgetAttachmentId);
		if(!BaseHelpUtils.isNullOrEmpty(payType)&&payType>0){
			map.put("payType",payType);
		}
		if(!BaseHelpUtils.isNullOrEmpty(payFor)&& payFor > 0){
			map.put("payFor",payFor);
		}
		if(!BaseHelpUtils.isNullOrEmpty(payStatus) && payStatus > 0){
			map.put("payStatus",payStatus);
		}
		
		if(!BaseHelpUtils.isNullOrEmpty(payName) && payName.length()>0){
			map.put("payName",payName);
		}
		DBDataSource.callOperation("ST_PaymentSequence","find",map,new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				loading.destroy();
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


}
