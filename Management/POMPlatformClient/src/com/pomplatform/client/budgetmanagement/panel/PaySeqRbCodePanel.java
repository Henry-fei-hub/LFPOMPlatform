package com.pomplatform.client.budgetmanagement.panel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.crypto.SealedObject;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.google.gwt.dom.client.Text;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.google.gwt.i18n.client.Messages.Select;
import com.google.gwt.thirdparty.common.css.compiler.ast.CssCombinatorNode.Combinator;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DoubleItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PaySeqRbCodePanel  extends HLayout implements HasHandlers{
	private Window parentWindow;
	protected final HandlerManager handlerManager = new HandlerManager(this);
	protected final List<DataEditedHandler> __dataEditedHandler = new ArrayList<>();
	private static final Logger _logger = Logger.getLogger("");
	private IButton saveButton;
	private  IButton cancelButton;
	private VLayout  mainLayout;
	private  DynamicForm  searchForm;
	private TextItem  payTypeItem;
	private ComboBoxItem  employeeIdItem;
	private ComboBoxItem reimbursementCodeItem;
	private TextItem payStatusItem;
	private DoubleItem  reimbursementAmountItem;
	private DoubleItem  payAmountItem;
	private DoubleItem  reverseAmountItem;
	private DoubleItem  returnAmountItem;
	private HLayout bottomLayout;
	private SelectItem payForItem;
	private TextItem payNameItem;
	private TextItem bearFeeNameItem;
	private SelectItem receiveUnitManageIdItem;
	private LinkedHashMap<Integer, String> employeeReceiveMap=new LinkedHashMap<>();
	private LinkedHashMap<Integer, String> comPanyReceiveMap=new LinkedHashMap<>();
	public void initComponents() {
		mainLayout=new VLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		addMember(mainLayout);

		employeeIdItem = new ComboBoxItem("employeeId", "申请人");
		LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
		map.put(303, "任梦夷");
		map.put(2183, "李小燕");
		map.put(2147, "贲丽蓉");
		map.put(205, "韩冬");
		employeeIdItem.setWidth("*");
		employeeIdItem.setChangeOnKeypress(false);
		employeeIdItem.setValueMap(map);
		employeeIdItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				int employeeId=BaseHelpUtils.getIntValue(event.getValue());
				int payType=BaseHelpUtils.getIntValue(payTypeItem.getValue());
				int processType=0;
				/*map.put(3, "普通日常报销");
				map.put(2, "项目日常报销");
				map.put(8, "前期项目日常报销");
				map.put(5, "普通差旅报销");
				map.put(4, "项目差旅报销");
				map.put(9, "前期项目差旅报销");
				map.put(6, "借款申请");
				map.put(7, "预付款申请");
				map.put(39, "成本调节");*/
				switch (payType) {
				case 1://项目日常报销
					processType=2;
					break;
				case 2://普通日常报销
					processType=3;
					break;
				case 3://项目差旅报销
					processType=4;
					break;
				case 4://借款申请
					processType=4;
					break;
				case 5://预付款申请
					processType=7;
					break; 
				case 6://还款申请
					break; 
				}
				Map<String,Object> params=new HashMap<>();
				params.put("employeeId", employeeId);
				params.put("processType", processType);
				DBDataSource.callOperation("NQ_SearchReimbursementInfo",params,new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus()>=0) {
							Record[] records=dsResponse.getData();
							LinkedHashMap<String, String> mapLink=new LinkedHashMap<>();
							for (Record record : records) {
								String code=BaseHelpUtils.getString(record.getAttribute("code"));
								mapLink.put(code, code);
							}
							reimbursementCodeItem.setValueMap(mapLink);
						}
					}
				});

			}
		});




		payTypeItem=new TextItem("payType","报销类型");
		payTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_193"));
		payTypeItem.setWidth("*");
		payTypeItem.setCanEdit(false);
		payTypeItem.setDisabled(true);


		reimbursementCodeItem=new ComboBoxItem("reimbursementCode","报销编号");
		//reimbursementCodeItem.setChangeOnKeypress(false);
		reimbursementCodeItem.setWidth("*"); 
		reimbursementCodeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				int payType=BaseHelpUtils.getIntValue(payTypeItem.getValue());
				String reimbursementCode=BaseHelpUtils.getString(event.getValue());
				Map<String,Object> params=new HashMap<>();
				params.put("code", reimbursementCode);
				DBDataSource.callOperation("NQ_SearchReimbursementInfo",params,new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus()>=0) {
							Record records=dsResponse.getData()[0];
							String bearFeeName=BaseHelpUtils.getString(records.getAttribute("bearFeeName"));
							bearFeeNameItem.setValue(bearFeeName);
						}
					}
				});
				String StName="";
				switch (payType) {
				case 1://项目日常报销
					StName="ProjectNormalReimbursement";
					queryData(reimbursementCode,StName,2);
					break;
				case 2://普通日常报销
					StName="ProjectNormalReimbursement";
					queryData(reimbursementCode,StName,3);
					break;
				case 3://项目差旅报销
					StName="TravelReimbursement";
					queryData(reimbursementCode,StName,4);
					break;
				case 4://借款申请
					StName="EmployeeMoneyManage";
					queryData(reimbursementCode,StName,6);
					break;
				case 5://预付款申请
					StName="PayMoneyManage";
					queryPayDate(reimbursementCode, StName);
					break; 
				case 6://还款申请
					break; 
				}
			}
		});

		bearFeeNameItem = new TextItem("bearFeeName", "费用承担主体");
		bearFeeNameItem.setWidth("*");
		bearFeeNameItem.setCanEdit(false);
		bearFeeNameItem.setDisabled(true);
		
		
		
		payStatusItem=new TextItem("payStatus","付款状态");
		payStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_194"));
		payStatusItem.setWidth("*");
		payStatusItem.setCanEdit(false);
		payStatusItem.setDisabled(true);

		payForItem=new SelectItem("payFor","收款方类型");
		payForItem.setWidth("*");
		payForItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_196"));
		payForItem.setCanEdit(true);
		payForItem.setDisabled(false);
		payForItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				int payFor=BaseHelpUtils.getIntValue(event.getValue());
				if(payFor==1) {
					receiveUnitManageIdItem.clearValue();
					receiveUnitManageIdItem.setValueMap(employeeReceiveMap);
				}else if(payFor==2) {
					receiveUnitManageIdItem.clearValue();
					receiveUnitManageIdItem.setValueMap(comPanyReceiveMap);
				}
			}
		});

		payNameItem=new TextItem("payName","收款方名称");
		payNameItem.hide();
		payNameItem.setWidth("*");
		payNameItem.setCanEdit(false);
		payNameItem.setDisabled(true);

		receiveUnitManageIdItem=new SelectItem("receiveUnitManageIdItem","收款方");
		receiveUnitManageIdItem.setWidth("*");
		receiveUnitManageIdItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				int payType=BaseHelpUtils.getIntValue(payTypeItem.getValue());
				if(payType!=5) {
					int payFor=BaseHelpUtils.getIntValue(payForItem.getValue());
					if(payFor==1) {
						payNameItem.setValue(employeeReceiveMap.get(BaseHelpUtils.getIntValue(event.getValue())));
					}else if(payFor==2) {
						payNameItem.setValue(comPanyReceiveMap.get(BaseHelpUtils.getIntValue(event.getValue())));
					}
				}
			}
		});


		reimbursementAmountItem=new DoubleItem("reimbursementAmount","报销金额");
		reimbursementAmountItem.setFormat("##,###,###,###,##0.00");
		reimbursementAmountItem.setWidth("*");

		payAmountItem=new DoubleItem("payAmount","付款金额");
		payAmountItem.setFormat("##,###,###,###,##0.00");
		payAmountItem.setWidth("*");

		reverseAmountItem=new DoubleItem("reverseAmount","冲账金额");
		reverseAmountItem.setFormat("##,###,###,###,##0.00");
		reverseAmountItem.setWidth("*");

		returnAmountItem=new DoubleItem("returnAmount","还款金额");
		returnAmountItem.setFormat("##,###,###,###,##0.00");
		returnAmountItem.setWidth("*");


		searchForm=new DynamicForm();
		searchForm.setAlign(Alignment.CENTER);
		searchForm.setNumCols(4);
		searchForm.setPadding(3);
		searchForm.setMargin(5);
		searchForm.setWidth("100%");;
		searchForm.setHeight("100%");
		searchForm.setFields(employeeIdItem,payTypeItem,reimbursementCodeItem,bearFeeNameItem,payStatusItem,payForItem,payNameItem,receiveUnitManageIdItem,reimbursementAmountItem,payAmountItem,reverseAmountItem,returnAmountItem);
		ClientUtil.DynamicFormProcessAccordingToDevice(searchForm);
		receiveUnitManageIdItem.setColSpan(4);
		mainLayout.addMember(searchForm);

		bottomLayout=new HLayout(20);
		bottomLayout.setAlign(Alignment.CENTER);
		bottomLayout.setWidth100();
		bottomLayout.setHeight("30%");
		mainLayout.addMember(bottomLayout);

		saveButton=new IButton("确定");
		bottomLayout.addMember(saveButton);
		saveButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Map<String,Object> map=new HashMap<>();
				int payType=BaseHelpUtils.getIntValue(payTypeItem._getValue());
				String reimbursementCode=BaseHelpUtils.getString(reimbursementCodeItem.getValue());
				BigDecimal reimbursementAmount=BaseHelpUtils.getBigDecimalValue(reimbursementAmountItem.getValue());
				BigDecimal reverseAmount=BaseHelpUtils.getBigDecimalValue(reverseAmountItem.getValue());
				BigDecimal payAmount=BaseHelpUtils.getBigDecimalValue(payAmountItem.getValue());
				BigDecimal returnAmount=BaseHelpUtils.getBigDecimalValue(returnAmountItem.getValue());
				int paymentSequenceId=BaseHelpUtils.getIntValue(record.getAttribute("paymentSequenceId"));
				int payFor=BaseHelpUtils.getIntValue(payForItem.getValue());
				int receiveUnitManageId=BaseHelpUtils.getIntValue(receiveUnitManageIdItem.getValue());
				int payStatus=BaseHelpUtils.getIntValue(payStatusItem.getValue());
				String payName="";
				if(payFor==1) {
					payName= employeeReceiveMap.get(receiveUnitManageId);
					map.put("payFor", payFor);
					map.put("payName", payName);
				}else {
					payName= comPanyReceiveMap.get(receiveUnitManageId);
					map.put("payFor", payFor);
					map.put("payName", payName);
				}
				map.put("receiveUnitManageId", receiveUnitManageId);
				map.put("paymentSequenceId", paymentSequenceId);
				map.put("payType", payType);
				map.put("reimbursementCode", reimbursementCode);
				map.put("reimbursementAmount", reimbursementAmount);
				map.put("reverseAmount", reverseAmount);
				map.put("payAmount", payAmount);
				map.put("returnAmount", returnAmount);
				map.put("returnAmount", returnAmount);
				map.put("payStatus", payStatus);
				map.put("optType", "budgetInto");
				DBDataSource.callOperation("EP_EidtPaymentSequence",map,new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0) {
							getParentWindow().destroy();
							DataEditEvent dee = new DataEditEvent();
							fireEvent(dee);
							if (null == getParentWindow()) {
								return;
							}
						}else {
							SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
						}
					}
				});	
			}
		});

		cancelButton=new IButton("取消");
		bottomLayout.addMember(cancelButton);





	}

	public void lodaData() {
		int payType=BaseHelpUtils.getIntValue(record.getAttribute("payType"));
		String reimbursementCode=BaseHelpUtils.getString(record.getAttribute("reimbursementCode"));
		if(!BaseHelpUtils.isNullOrEmpty(reimbursementCode)) {
			String StName="";
			reimbursementCodeItem.setValue(reimbursementCode);
			switch (payType) {
			case 1://项目日常报销
				StName="ProjectNormalReimbursement";
				queryData(reimbursementCode,StName,2);
				break;
			case 2://普通日常报销
				StName="ProjectNormalReimbursement";
				queryData(reimbursementCode,StName,3);
				break;
			case 3://项目差旅报销
				StName="TravelReimbursement";
				queryData(reimbursementCode,StName,4);
				break;
			case 4://借款申请
				StName="EmployeeMoneyManage";
				queryData(reimbursementCode,StName,6);
				break;
			case 5://预付款申请
				StName="PayMoneyManage";
				queryPayDate(reimbursementCode, StName);
				break; 
			case 6://还款申请
				break; 
			}
		}
		payTypeItem.setValue(payType);
		switch (payType) {
		case 1://项目日常报销
			returnAmountItem.setDisabled(true);
			//queryValueMApDate("ProjectNormalReimbursement");
			break;
		case 2://普通日常报销
			returnAmountItem.setDisabled(true);
			//queryValueMApDate("ProjectNormalReimbursement");
			break;
		case 3://项目差旅报销
			returnAmountItem.setDisabled(true);
			//queryValueMApDate("TravelReimbursement");
			break;
		case 4://借款申请
			returnAmountItem.setDisabled(true);
			reimbursementAmountItem.setDisabled(true);
			reverseAmountItem.setDisabled(true);
			//queryValueMApDate("EmployeeMoneyManage");
			break;
		case 5://预付款申请
			returnAmountItem.setDisabled(true);
			reimbursementAmountItem.setDisabled(true);
			reverseAmountItem.setDisabled(true);
			//queryValueMApDate("PayMoneyManage");
			break; 
		case 6://还款申请
			reimbursementAmountItem.setDisabled(true);
			reverseAmountItem.setDisabled(true);
			payAmountItem.setDisabled(true);
			break; 
		}





	}
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

	public void queryData(String reimbursementCode,String StName,Integer processType) {
		if(BaseHelpUtils.isNullOrEmpty(processType)||processType<=0) {
			SC.say("找不到流程类型");
			return;
		}
		Map<String,Object> params = new HashMap<>();
		params.put("code", reimbursementCode);
		DBDataSource.callOperation("ST_"+StName, "find", params, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0) {
					Record record=dsResponse.getData()[0];
					if(BaseHelpUtils.isNullOrEmpty(record)||record==null) {
						payAmountItem.setValue(BigDecimal.ZERO);
						reverseAmountItem.setValue(BigDecimal.ZERO);
						reimbursementAmountItem.setValue(BigDecimal.ZERO);
						returnAmountItem.setValue(BigDecimal.ZERO);
						payStatusItem.clearValue();
						payForItem.clearValue();
						payNameItem.clearValue();
						receiveUnitManageIdItem.clearValue();
						return;
					}
					if(processType==2||processType==3||processType==4) {
						//获取报销金额
						BigDecimal reimbursementAmount=BaseHelpUtils.getBigDecimalValue(record.getAttribute("amount"));
						reimbursementAmountItem.setValue(reimbursementAmount);
					}
					if(processType==6) {
						//获取借款金额
						BigDecimal borrowMoney=BaseHelpUtils.getBigDecimalValue(record.getAttribute("borrowMoney"));
						payAmountItem.setValue(borrowMoney);
					}
					Map<String,Object> map = new HashMap<>();
					if(StName.equals("TravelReimbursement")) {
						//获取主键
						int travelReimbursementId=BaseHelpUtils.getIntValue(record.getAttribute("travelReimbursementId"));
						map.put("businessId", travelReimbursementId);
					}else if(StName.equals("EmployeeMoneyManage")) {
						//获取主键
						int employeeMoneyManageId=BaseHelpUtils.getIntValue(record.getAttribute("employeeMoneyManageId"));
						map.put("businessId", employeeMoneyManageId);
					}
					else {
						//获取主键
						int projectNormalReimbursementId=BaseHelpUtils.getIntValue(record.getAttribute("projectNormalReimbursementId"));
						map.put("businessId", projectNormalReimbursementId);
					}
					//获取付款状态
					boolean isCompleted=BaseHelpUtils.getBoolean(record.getAttribute("isCompleted"));
					if(isCompleted==true) {
						payStatusItem.setValue(2);//已付款
					}else {
						payStatusItem.setValue(1);//未付款
					}
					map.put("processType",processType);
					DBDataSource.callOperation("ST_ProcessBillList", "find", map, new DSCallback(){
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if(dsResponse.getStatus() >= 0) {
								Record[] records=dsResponse.getData();
								//获取付款金额
								BigDecimal payAmount=BigDecimal.ZERO;
								//获取冲账金额
								BigDecimal reverseAmount=BigDecimal.ZERO;
								//获取收款方类型
								int payFor=0;
								//获取收款方id
								int employeeOrCompanyId=0;
								LinkedHashMap<Integer, String>  linkMap=new LinkedHashMap<>();
								if(records.length==0||BaseHelpUtils.isNullOrEmpty(records)) {
									SC.say("找不到账单流水数据,请检查报销编号是否正确");
									return;
								}
								for (Record record : records) {
									payAmount=payAmount.add(BaseHelpUtils.getBigDecimalValue(record.getAttribute("payMoney")));
									reverseAmount=reverseAmount.add(BaseHelpUtils.getBigDecimalValue(record.getAttribute("balanceAmount")));
									payFor=BaseHelpUtils.getIntValue(record.getAttribute("payFor"));
									employeeOrCompanyId=BaseHelpUtils.getIntValue(record.getAttribute("employeeOrCompanyId"));
									if(payFor==1) {
										employeeReceiveMap.put(employeeOrCompanyId, KeyValueManager.getValue("employees", employeeOrCompanyId+""));
										receiveUnitManageIdItem.setValueMap(employeeReceiveMap);
									}else {
										comPanyReceiveMap.put(employeeOrCompanyId, KeyValueManager.getValue("receive_unit_manages_company", employeeOrCompanyId+""));
										receiveUnitManageIdItem.setValueMap(comPanyReceiveMap);
									}
									linkMap.put(payFor,KeyValueManager.getValue("system_dictionary_196", payFor+""));
								}
								payForItem.setValueMap(linkMap);
								payForItem.setValue(payFor);
								receiveUnitManageIdItem.setValue(employeeOrCompanyId);
								payAmountItem.setValue(payAmount);
								reverseAmountItem.setValue(reverseAmount);
							}
						}
					});
				}
			}
		});
	}

	public  void queryPayDate(String reimbursementCode,String StName) {
		Map<String,Object> params = new HashMap<>();
		params.put("code", reimbursementCode);
		DBDataSource.callOperation("ST_"+StName, "find", params, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0) {
					Record records=dsResponse.getData()[0];
					if(BaseHelpUtils.isNullOrEmpty(records)&&records==null) {
						payAmountItem.setValue(BigDecimal.ZERO);
						reverseAmountItem.setValue(BigDecimal.ZERO);
						reimbursementAmountItem.setValue(BigDecimal.ZERO);
						returnAmountItem.setValue(BigDecimal.ZERO);
						payStatusItem.clearValue();
						payForItem.clearValue();
						payNameItem.clearValue();
						receiveUnitManageIdItem.clearValue();
						return;
					}
					//获取付款状态
					boolean isCompleted=BaseHelpUtils.getBoolean(records.getAttribute("isCompleted"));
					if(isCompleted==true) {
						payStatusItem.setValue(2);//已付款
					}else {
						payStatusItem.setValue(1);//未付款
					}
					//获取收款方名称
					String receiveUnit=BaseHelpUtils.getString(records.getAttribute("receiveUnit"));
					Map<String,Object> map = new HashMap<>();
					map.put("receiveUnit", receiveUnit);
					DBDataSource.callOperation("ST_ReceiveUnitManage", "find", map, new DSCallback(){
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if(dsResponse.getStatus() >= 0) {
								payNameItem.setValue(receiveUnit);
								payForItem.setValue(2);
								Record recordu=dsResponse.getData()[0];
								int receiveUnitManageId=BaseHelpUtils.getIntValue(recordu.getAttribute("receiveUnitManageId"));
								if(receiveUnitManageId>0) {
									receiveUnitManageIdItem.setValueMap(KeyValueManager.getValueMap("receive_unit_manages_company"));
									receiveUnitManageIdItem.setValue(receiveUnitManageId);
									receiveUnitManageIdItem.setDisabled(true);
								}else {
									SC.say("找不到收款方ID");
								}
							}
						}
					});
					//获取付款金额
					BigDecimal payAmount=BaseHelpUtils.getBigDecimalValue(records.getAttribute("payAmount"));
					payAmountItem.setValue(payAmount);
				}
			}
		});
	}


}
