package com.pomplatform.client.workflow.panel;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.ValidateUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.selectgrid.datasource.DSSelectGridReceiveUnitValue;
import com.pomplatform.client.selectgridemployeevalue.datasource.DSSelectGridEmployeeValue;
import com.pomplatform.client.sprocessbilllistpppor.datasource.DSSprocessbilllistpppor;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.FloatItem;
import com.smartgwt.client.widgets.form.fields.RadioGroupItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class AddUpdateProcessBillListPanel extends VLayout implements HasHandlers {

	private static final Logger logger = Logger.getLogger("");
	private final DynamicForm form = new DynamicForm();
	private final VLayout vLayout;
	private final IButton saveButton;
	private final IButton cancelButton;
	private final IButton addUnitButton;
	private final HLayout buttonLayout;
	private Window parentWindow;
	protected final HandlerManager handlerManager = new HandlerManager(this);
	private BigDecimal amount = BigDecimal.ZERO;
	
	
	private final RadioGroupItem payForItem;
	private final ComboBoxItem employeeOrCompanyIdItem;
	private final TextItem selfBankNameItem;
	private final TextItem selfBankAccountItem;
	private final TextItem payeeNameItem;
	private final SelectItem otherNameItem;
	private final SelectItem otherBankNameItem;
	private final SelectItem otherBankAccountItem;
	private final FloatItem payMoneyItem;
	private final FloatItem balanceAmountItem;
	private final TextAreaItem remarkItem;
	
	private final ComboBoxItem employeeSelectItem;
	private final ComboBoxItem companySelectItem;
	
	private int companyId;
	
	private boolean __isFinance;
	
	private Integer processType;

	public Integer getProcessType() {
		return processType;
	}

	public void setProcessType(Integer processType) {
		this.processType = processType;
	}

	public Window getParentWindow() {
		return parentWindow;
	}

	public void setParentWindow(Window parentWindow) {
		this.parentWindow = parentWindow;
	}

	public AddUpdateProcessBillListPanel(boolean update, boolean isFinance,Record budgetRecord) {
		ListGridField employeeNoField = new ListGridField("employeeNo");
		ListGridField employeeNameField = new ListGridField("employeeName");
		ListGridField departmentIdField = new ListGridField("departmentId");
		
		ListGridField receiveUnitField = new ListGridField("receiveUnit");
		ListGridField bankAccountField = new ListGridField("bankAccount");
		ListGridField bankNameField = new ListGridField("bankName");
		
		__isFinance = isFinance;
		vLayout = new VLayout();
		vLayout.setWidth100();
		vLayout.setHeight100();
		vLayout.setMargin(10);
		vLayout.setMembersMargin(12);
		
		payForItem = new RadioGroupItem("payFor");  
		payForItem.setDefaultValue(1);  
		payForItem.setWidth("*");
		payForItem.setAlign(Alignment.CENTER);
		payForItem.setVertical(false);
		payForItem.setShowTitle(false);  
		payForItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_67"));  
		payForItem.addChangedHandler(new ChangedHandler() {  

			@Override
			public void onChanged(com.smartgwt.client.widgets.form.fields.events.ChangedEvent event) {
				int typeVal = BaseHelpUtils.getIntValue(event.getValue());
				employeeOrCompanyIdItem.clearValue();
				employeeSelectItem.clearValue();
				companySelectItem.clearValue();
				payeeNameItem.clearValue();
				selfBankNameItem.clearValue();
				selfBankAccountItem.clearValue();
				if(typeVal == 1){
					addUnitButton.hide();
//					employeeOrCompanyIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
					employeeSelectItem.show();
					companySelectItem.hide();
					remarkItem.setRequired(false);
				}else{
					addUnitButton.show();
					//设置下拉值
//					setSelectValue();
					companySelectItem.show();
					employeeSelectItem.hide();
					remarkItem.setRequired(true);
				}
				
			}  
        });  
		
		employeeSelectItem = new ComboBoxItem("employeeSelect", "收款方");
		employeeSelectItem.setChangeOnKeypress(false);
		employeeSelectItem.setRequired(true);
		employeeSelectItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		employeeSelectItem.setWidth("*");
		Criteria cd = new Criteria();
		cd.addCriteria("status", "0");
		employeeSelectItem.setOptionDataSource(DSSelectGridEmployeeValue.getInstance());
		employeeSelectItem.setOptionCriteria(cd);
		employeeSelectItem.setValueField("employeeId");
		employeeSelectItem.setDisplayField("employeeName");
		employeeSelectItem.setPickListFields(employeeNoField, employeeNameField, departmentIdField);
		employeeSelectItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				int __value = BaseHelpUtils.getIntValue(event.getValue());
				payeeNameItem.clearValue();
				selfBankNameItem.clearValue();
				selfBankAccountItem.clearValue();
				employeeOrCompanyIdItem.setValue(__value);
				if(__value > 0){
					int __typeVal = BaseHelpUtils.getIntValue(payForItem.getValue());
					Map<String, Object> params = new HashMap<>();
					if(__typeVal == 1){
						params.put("opt_type", "getEmployeeBankInfoById");
						params.put("employeeId", __value);
					}else if(__typeVal == 2){//收款单位
						params.put("opt_type", "getReceiveUnitInfoById");
						params.put("receiveUnitManageId", __value);
					}
					DBDataSource.callOperation("EP_CustomSprocessbilllistppporProcess", params, new DSCallback() {
						
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if(dsResponse.getStatus() > 0 && dsResponse.getData().length > 0){
								Record __record = dsResponse.getData()[0];
								if(__typeVal == 1){
									payeeNameItem.setValue(BaseHelpUtils.getString(event.getItem().getDisplayValue()));
									String bankId = BaseHelpUtils.getString(__record.getAttribute("bankId"));
									selfBankNameItem.setValue(KeyValueManager.getValueMap("system_dictionary_68").get(bankId));
									selfBankAccountItem.setValue(BaseHelpUtils.getString(__record.getAttribute("bankAccount")));
								}else if(__typeVal == 2){
									payeeNameItem.setValue(BaseHelpUtils.getString(__record.getAttribute("receiveUnit")));
									selfBankNameItem.setValue(BaseHelpUtils.getString(__record.getAttribute("bankName")));
									selfBankAccountItem.setValue(BaseHelpUtils.getString(__record.getAttribute("bankAccount")));
								}
							}
						}
					});
				}
			}
		});
		
		companySelectItem= new ComboBoxItem("companySelect", "收款方");
		companySelectItem.setChangeOnKeypress(false);
		companySelectItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		companySelectItem.setWidth("*");
		companySelectItem.hide();
		companySelectItem.setValueField("receiveUnitManageId");
		companySelectItem.setDisplayField("receiveUnit");
		companySelectItem.setPickListFields(receiveUnitField, bankNameField, bankAccountField);
		companySelectItem.setOptionDataSource(DSSelectGridReceiveUnitValue.getInstance());
		companySelectItem.setRequired(true);
		companySelectItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				int __value = BaseHelpUtils.getIntValue(event.getValue());
				payeeNameItem.clearValue();
				selfBankNameItem.clearValue();
				selfBankAccountItem.clearValue();
				employeeOrCompanyIdItem.setValue(__value);
				if(__value > 0){
					int __typeVal = BaseHelpUtils.getIntValue(payForItem.getValue());
					Map<String, Object> params = new HashMap<>();
					if(__typeVal == 1){
						params.put("opt_type", "getEmployeeBankInfoById");
						params.put("employeeId", __value);
					}else if(__typeVal == 2){//收款单位
						params.put("opt_type", "getReceiveUnitInfoById");
						params.put("receiveUnitManageId", __value);
					}
					DBDataSource.callOperation("EP_CustomSprocessbilllistppporProcess", params, new DSCallback() {
						
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if(dsResponse.getStatus() > 0 && dsResponse.getData().length > 0){
								Record __record = dsResponse.getData()[0];
								if(__typeVal == 1){
									payeeNameItem.setValue(BaseHelpUtils.getString(event.getItem().getDisplayValue()));
									String bankId = BaseHelpUtils.getString(__record.getAttribute("bankId"));
									selfBankNameItem.setValue(KeyValueManager.getValueMap("system_dictionary_68").get(bankId));
									selfBankAccountItem.setValue(BaseHelpUtils.getString(__record.getAttribute("bankAccount")));
								}else if(__typeVal == 2){
									payeeNameItem.setValue(BaseHelpUtils.getString(__record.getAttribute("receiveUnit")));
									selfBankNameItem.setValue(BaseHelpUtils.getString(__record.getAttribute("bankName")));
									selfBankAccountItem.setValue(BaseHelpUtils.getString(__record.getAttribute("bankAccount")));
								}
							}
						}
					});
				}
			}
		});
		
		employeeOrCompanyIdItem = new ComboBoxItem("employeeOrCompanyId", "收款方");
		employeeOrCompanyIdItem.setChangeOnKeypress(false);
		employeeOrCompanyIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		employeeOrCompanyIdItem.setWidth("*");
		employeeOrCompanyIdItem.setRequired(true);
		employeeOrCompanyIdItem.hide();
//		employeeOrCompanyIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
//		employeeOrCompanyIdItem.addChangedHandler(new ChangedHandler() {
//			
//			@Override
//			public void onChanged(ChangedEvent event) {
//				int __value = BaseHelpUtils.getIntValue(event.getValue());
//				payeeNameItem.clearValue();
//				selfBankNameItem.clearValue();
//				selfBankAccountItem.clearValue();
//				if(__value > 0){
//					int __typeVal = BaseHelpUtils.getIntValue(payForItem.getValue());
//					Map<String, Object> params = new HashMap<>();
//					if(__typeVal == 1){
//						params.put("opt_type", "getEmployeeBankInfoById");
//						params.put("employeeId", __value);
//					}else if(__typeVal == 2){//收款单位
//						params.put("opt_type", "getReceiveUnitInfoById");
//						params.put("receiveUnitManageId", __value);
//					}
//					DBDataSource.callOperation("EP_CustomSprocessbilllistppporProcess", params, new DSCallback() {
//						
//						@Override
//						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//							if(dsResponse.getStatus() > 0 && dsResponse.getData().length > 0){
//								Record __record = dsResponse.getData()[0];
//								if(__typeVal == 1){
//									payeeNameItem.setValue(BaseHelpUtils.getString(event.getItem().getDisplayValue()));
//									String bankId = BaseHelpUtils.getString(__record.getAttribute("bankId"));
//									selfBankNameItem.setValue(KeyValueManager.getValueMap("system_dictionary_68").get(bankId));
//									selfBankAccountItem.setValue(BaseHelpUtils.getString(__record.getAttribute("bankAccount")));
//								}else if(__typeVal == 2){
//									payeeNameItem.setValue(BaseHelpUtils.getString(__record.getAttribute("receiveUnit")));
//									selfBankNameItem.setValue(BaseHelpUtils.getString(__record.getAttribute("bankName")));
//									selfBankAccountItem.setValue(BaseHelpUtils.getString(__record.getAttribute("bankAccount")));
//								}
//							}
//						}
//					});
//				}
//			}
//		});
		payeeNameItem = new TextItem("payeeName", "收款人");
		payeeNameItem.setWidth("*");
		payeeNameItem.setHidden(true);
		
		selfBankNameItem = new TextItem("selfBankName", "银行名称");
		selfBankNameItem.setWidth("*");
		selfBankNameItem.setRequired(true);
		selfBankNameItem.setDisabled(true);

		selfBankAccountItem = new TextItem("selfBankAccount", "银行账号");
		selfBankAccountItem.setWidth("*");
		selfBankAccountItem.setDisabled(true);
		selfBankAccountItem.setRequired(true);
		
		otherNameItem = new SelectItem("otherName", "付款方");
		otherNameItem.setWidth("*");
		otherNameItem.setRequired(true);
		otherNameItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_69"));
		otherNameItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				otherBankNameItem.clearValue();
				otherBankAccountItem.clearValue();
				setSelectBankAddressByCompanyId(BaseHelpUtils.getIntValue(event.getValue()));
				
			}
		});
		
		otherBankNameItem = new SelectItem("otherBankName", "银行名称(付款方)");
		otherBankNameItem.setWidth("*");
		otherBankNameItem.setRequired(true);
		otherBankNameItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				otherBankAccountItem.clearValue();
				setSelectBankAccountByCompanyIdAndBankName(BaseHelpUtils.getIntValue(otherNameItem.getValue()), event.getValue().toString());
			}
		});
		
		otherBankAccountItem = new SelectItem("otherBankAccount", "银行账号(付款方)");
		otherBankAccountItem.setWidth("*");
		otherBankAccountItem.setRequired(true);
		
		payMoneyItem = new FloatItem("payMoney", "付款金额");
		payMoneyItem.setWidth("*");
		payMoneyItem.setLength(18);
		payMoneyItem.setDecimalPad(5);
		payMoneyItem.setRequired(true);
		payMoneyItem.setFormat("#,###,###,###,##0.00");
		
		balanceAmountItem = new FloatItem("balanceAmount", "冲账金额");
		balanceAmountItem.setWidth("*");
		balanceAmountItem.setLength(18);
		balanceAmountItem.setDecimalPad(5);
		balanceAmountItem.setFormat("#,###,###,###,##0.00");
		
		remarkItem = new TextAreaItem("remark", "备注(<font color='red'>简写付款原因，即：用途（17个字内，包括字母和数字）</font>)");
		remarkItem.setValidators(ValidateUtils.StringLenValidator(0, 17));
		remarkItem.setWidth("*");
		remarkItem.setColSpan(2);
		remarkItem.setRowSpan(3);

		form.setNumCols(2);
		form.setDataSource(DSSprocessbilllistpppor.getInstance());
		if(isFinance){
			form.setItems(payForItem, employeeSelectItem, companySelectItem, employeeOrCompanyIdItem, payeeNameItem, selfBankNameItem, selfBankAccountItem,
					otherNameItem, otherBankNameItem,otherBankAccountItem, payMoneyItem, balanceAmountItem, remarkItem);
		}else{
			form.setItems(payForItem, employeeSelectItem, companySelectItem, employeeOrCompanyIdItem, payeeNameItem, selfBankNameItem, selfBankAccountItem,
					payMoneyItem, balanceAmountItem, remarkItem);
		}
		ClientUtil.DynamicFormProcessAccordingToDevice(form);
		vLayout.addMember(form);
		form.setWidth100();
		form.setHeight100();

		saveButton = new IButton("确定", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (DataValidate()) {
					DataEditEvent dee = new DataEditEvent();
					dee.setData(getValueAsRecord());
					fireEvent(dee);
					if (null == getParentWindow()) {
						return;
					}
					getParentWindow().destroy();
				} else {
					return;
				}
			}
		});

		cancelButton = new IButton("取消", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (null == getParentWindow()) {
					return;
				}
				getParentWindow().destroy();
			}
		});
		
		addUnitButton = new IButton("添加收款单位", new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				PopupWindow window = new PopupWindow();
				window.setWidth("30%");
				window.setHeight("95%");
				window.centerInPage();
				window.setTitle("添加收款单位");
				AddReceiveUnitPanel panel = new AddReceiveUnitPanel();
				panel.setParentWindow(window);
				panel.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						final Record __record = event.getData();
						Map params = __record.toMap();
						params.put("operateEmployeeId", ClientUtil.getEmployeeId());
						params.put("opt_type", "addReceiveUnitInfo");
						DBDataSource.callOperation("EP_CustomSprocessbilllistppporProcess", params, new DSCallback() {
							
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								int __id = BaseHelpUtils.getIntValue(data);
								companySelectItem.setValue(__id);
								employeeOrCompanyIdItem.setValue(__id);
								payeeNameItem.setValue(BaseHelpUtils.getString(__record.getAttribute("receiveUnit")));
								selfBankNameItem.setValue(BaseHelpUtils.getString(__record.getAttribute("bankName")));
								selfBankAccountItem.setValue(BaseHelpUtils.getString(__record.getAttribute("bankAccount")));
//								setSelectValue();
							}
						});
					}
				});
				window.addItem(panel);
				window.show();
			}
		});
		if(budgetRecord!=null) {
		int processType=BaseHelpUtils.getIntValue(budgetRecord.getAttribute("processType"));
		if(processType==2||processType==3||processType==4){//预算时触发,项目日常报销，普通日常报销,项目差旅报销
			Map<String, Object> params = new HashMap<>();
			int payFor=BaseHelpUtils.getIntValue(budgetRecord.getAttribute("payFor"));
			//收款单位
			int receiveUnitManageId=BaseHelpUtils.getIntValue(budgetRecord.getAttribute("receiveUnitManageId"));
			//获取付款金额
			BigDecimal  payAmount=BaseHelpUtils.getBigDecimalValue(budgetRecord.getAttribute("payAmount"));
			//获取冲账金额
			BigDecimal  reverseAmount=BaseHelpUtils.getBigDecimalValue(budgetRecord.getAttribute("reverseAmount"));
			//获取备注
			String remark=BaseHelpUtils.getString(budgetRecord.getAttribute("psRemark"));
			if(payFor == 1){//个人
				payMoneyItem.setValue(payAmount);
				remarkItem.setValue(remark);
				balanceAmountItem.setValue(reverseAmount);
				addUnitButton.hide();
				employeeSelectItem.show();
				companySelectItem.hide();
				payForItem.setValue(1);
				employeeSelectItem.setValue(receiveUnitManageId);
				employeeOrCompanyIdItem.setValue(receiveUnitManageId);
				params.put("opt_type", "getEmployeeBankInfoById");
				params.put("employeeId", receiveUnitManageId);
				DBDataSource.callOperation("EP_CustomSprocessbilllistppporProcess", params, new DSCallback() {

					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() > 0 && dsResponse.getData().length > 0){
							Record __record = dsResponse.getData()[0];
							payeeNameItem.setValue(BaseHelpUtils.getString(employeeSelectItem.getDisplayValue()));
							String bankId = BaseHelpUtils.getString(__record.getAttribute("bankId"));
							selfBankNameItem.setValue(KeyValueManager.getValueMap("system_dictionary_68").get(bankId));
							selfBankAccountItem.setValue(BaseHelpUtils.getString(__record.getAttribute("bankAccount")));
						}
					}
				});
			}else{//公司
				payMoneyItem.setValue(payAmount);
				remarkItem.setValue(remark);
				balanceAmountItem.setValue(reverseAmount);
				payForItem.setValue(2);
				addUnitButton.show();
				companySelectItem.show();
				employeeSelectItem.hide();
				companySelectItem.setValue(receiveUnitManageId);
				payeeNameItem.clearValue();
				selfBankNameItem.clearValue();
				selfBankAccountItem.clearValue();
				employeeOrCompanyIdItem.setValue(receiveUnitManageId);
				params.put("opt_type", "getReceiveUnitInfoById");
				params.put("receiveUnitManageId", receiveUnitManageId);
				DBDataSource.callOperation("EP_CustomSprocessbilllistppporProcess", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() > 0 && dsResponse.getData().length > 0){
							Record __record = dsResponse.getData()[0];
							payeeNameItem.setValue(BaseHelpUtils.getString(__record.getAttribute("receiveUnit")));
							selfBankNameItem.setValue(BaseHelpUtils.getString(__record.getAttribute("bankName")));
							selfBankAccountItem.setValue(BaseHelpUtils.getString(__record.getAttribute("bankAccount")));
						}
					}
				});
			}
		}else{
			payForItem.setDefaultValue(1);  
			addUnitButton.hide();
		}
	}
		addUnitButton.hide();
		
		buttonLayout = new HLayout();
		buttonLayout.setWidth100();
		buttonLayout.setHeight(20);
		buttonLayout.setMargin(8);
		buttonLayout.setMembersMargin(20);
		buttonLayout.setAlign(Alignment.CENTER);
		buttonLayout.addMember(saveButton);
		buttonLayout.addMember(cancelButton);
		if(!isFinance){}buttonLayout.addMember(addUnitButton);
		
		vLayout.addMember(buttonLayout);

		addMember(vLayout);
//		setSelectValue();
	}
	
	/**
	 * 
	 * <p>Title: </p> 
	 * <p>Description: 用于预付款与借款</p> 
	 * @param update
	 * @param isFinance
	 * @param processType
	 */
	public AddUpdateProcessBillListPanel(boolean update, boolean isFinance, int processType,Record budgetRecord) {
		ListGridField employeeNoField = new ListGridField("employeeNo");
		ListGridField employeeNameField = new ListGridField("employeeName");
		ListGridField departmentIdField = new ListGridField("departmentId");
		
		ListGridField receiveUnitField = new ListGridField("receiveUnit");
		ListGridField bankAccountField = new ListGridField("bankAccount");
		ListGridField bankNameField = new ListGridField("bankName");
		
		__isFinance = isFinance;
		vLayout = new VLayout();
		vLayout.setWidth100();
		vLayout.setHeight100();
		vLayout.setMargin(10);
		vLayout.setMembersMargin(12);
		payForItem = new RadioGroupItem("payFor");
		payForItem.setWidth("*");
		payForItem.setAlign(Alignment.CENTER);
		payForItem.setVertical(false);
		payForItem.setShowTitle(false);  
		payForItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_67"));  
		if(processType == ClientStaticUtils.PROCESS_TYPE_7) {
			payForItem.setValue(2);
			payForItem.setCanEdit(false);
		}else if(processType == ClientStaticUtils.PROCESS_TYPE_6) {
			payForItem.setValue(1);
			payForItem.setCanEdit(false);
		}
		payForItem.addChangedHandler(new ChangedHandler() {  

			@Override
			public void onChanged(com.smartgwt.client.widgets.form.fields.events.ChangedEvent event) {
				int typeVal = BaseHelpUtils.getIntValue(event.getValue());
				employeeOrCompanyIdItem.clearValue();
				employeeSelectItem.clearValue();
				companySelectItem.clearValue();
				payeeNameItem.clearValue();
				selfBankNameItem.clearValue();
				selfBankAccountItem.clearValue();
				if(typeVal == 1){
					addUnitButton.hide();
//					employeeOrCompanyIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
					employeeSelectItem.show();
					companySelectItem.hide();
					remarkItem.setRequired(false);
				}else{
					addUnitButton.show();
					//设置下拉值
//					setSelectValue();
					companySelectItem.show();
					employeeSelectItem.hide();
					remarkItem.setRequired(true);
				}
				
			}  
        });  
		
		employeeSelectItem = new ComboBoxItem("employeeSelect", "收款方");
		employeeSelectItem.setChangeOnKeypress(false);
		employeeSelectItem.setRequired(true);
		employeeSelectItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		employeeSelectItem.setWidth("*");
		Criteria cd = new Criteria();
		cd.addCriteria("status", "0");
		employeeSelectItem.setOptionDataSource(DSSelectGridEmployeeValue.getInstance());
		employeeSelectItem.setOptionCriteria(cd);
		employeeSelectItem.setValueField("employeeId");
		employeeSelectItem.setDisplayField("employeeName");
		employeeSelectItem.setPickListFields(employeeNoField, employeeNameField, departmentIdField);
		employeeSelectItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				int __value = BaseHelpUtils.getIntValue(event.getValue());
				payeeNameItem.clearValue();
				selfBankNameItem.clearValue();
				selfBankAccountItem.clearValue();
				employeeOrCompanyIdItem.setValue(__value);
				if(__value > 0){
					int __typeVal = BaseHelpUtils.getIntValue(payForItem.getValue());
					Map<String, Object> params = new HashMap<>();
					if(__typeVal == 1){
						params.put("opt_type", "getEmployeeBankInfoById");
						params.put("employeeId", __value);
					}else if(__typeVal == 2){//收款单位
						params.put("opt_type", "getReceiveUnitInfoById");
						params.put("receiveUnitManageId", __value);
					}
					DBDataSource.callOperation("EP_CustomSprocessbilllistppporProcess", params, new DSCallback() {
						
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if(dsResponse.getStatus() > 0 && dsResponse.getData().length > 0){
								Record __record = dsResponse.getData()[0];
								if(__typeVal == 1){
									payeeNameItem.setValue(BaseHelpUtils.getString(event.getItem().getDisplayValue()));
									String bankId = BaseHelpUtils.getString(__record.getAttribute("bankId"));
									selfBankNameItem.setValue(KeyValueManager.getValueMap("system_dictionary_68").get(bankId));
									selfBankAccountItem.setValue(BaseHelpUtils.getString(__record.getAttribute("bankAccount")));
								}else if(__typeVal == 2){
									payeeNameItem.setValue(BaseHelpUtils.getString(__record.getAttribute("receiveUnit")));
									selfBankNameItem.setValue(BaseHelpUtils.getString(__record.getAttribute("bankName")));
									selfBankAccountItem.setValue(BaseHelpUtils.getString(__record.getAttribute("bankAccount")));
								}
							}
						}
					});
				}
			}
		});
		
		companySelectItem= new ComboBoxItem("companySelect", "收款方");
		companySelectItem.setChangeOnKeypress(false);
		companySelectItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		companySelectItem.setWidth("*");
		companySelectItem.hide();
		companySelectItem.setValueField("receiveUnitManageId");
		companySelectItem.setDisplayField("receiveUnit");
		companySelectItem.setPickListFields(receiveUnitField, bankNameField, bankAccountField);
		companySelectItem.setOptionDataSource(DSSelectGridReceiveUnitValue.getInstance());
		companySelectItem.setRequired(true);
		companySelectItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				int __value = BaseHelpUtils.getIntValue(event.getValue());
				payeeNameItem.clearValue();
				selfBankNameItem.clearValue();
				selfBankAccountItem.clearValue();
				employeeOrCompanyIdItem.setValue(__value);
				if(__value > 0){
					int __typeVal = BaseHelpUtils.getIntValue(payForItem.getValue());
					Map<String, Object> params = new HashMap<>();
					if(__typeVal == 1){
						params.put("opt_type", "getEmployeeBankInfoById");
						params.put("employeeId", __value);
					}else if(__typeVal == 2){//收款单位
						params.put("opt_type", "getReceiveUnitInfoById");
						params.put("receiveUnitManageId", __value);
					}
					DBDataSource.callOperation("EP_CustomSprocessbilllistppporProcess", params, new DSCallback() {
						
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if(dsResponse.getStatus() > 0 && dsResponse.getData().length > 0){
								Record __record = dsResponse.getData()[0];
								if(__typeVal == 1){
									payeeNameItem.setValue(BaseHelpUtils.getString(event.getItem().getDisplayValue()));
									String bankId = BaseHelpUtils.getString(__record.getAttribute("bankId"));
									selfBankNameItem.setValue(KeyValueManager.getValueMap("system_dictionary_68").get(bankId));
									selfBankAccountItem.setValue(BaseHelpUtils.getString(__record.getAttribute("bankAccount")));
								}else if(__typeVal == 2){
									payeeNameItem.setValue(BaseHelpUtils.getString(__record.getAttribute("receiveUnit")));
									selfBankNameItem.setValue(BaseHelpUtils.getString(__record.getAttribute("bankName")));
									selfBankAccountItem.setValue(BaseHelpUtils.getString(__record.getAttribute("bankAccount")));
								}
							}
						}
					});
				}
			}
		});
		
		employeeOrCompanyIdItem = new ComboBoxItem("employeeOrCompanyId", "收款方");
		employeeOrCompanyIdItem.setChangeOnKeypress(false);
		employeeOrCompanyIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		employeeOrCompanyIdItem.setWidth("*");
		employeeOrCompanyIdItem.setRequired(true);
		employeeOrCompanyIdItem.hide();
//		if(processType == 7){
//			setSelectValue();
//		}else{
//			
////			employeeOrCompanyIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
//		}
//		employeeOrCompanyIdItem.addChangedHandler(new ChangedHandler() {
//			
//			@Override
//			public void onChanged(ChangedEvent event) {
//				int __value = BaseHelpUtils.getIntValue(event.getValue());
//				payeeNameItem.clearValue();
//				selfBankNameItem.clearValue();
//				selfBankAccountItem.clearValue();
//				if(__value > 0){
//					int __typeVal = BaseHelpUtils.getIntValue(payForItem.getValue());
//					Map<String, Object> params = new HashMap<>();
//					if(__typeVal == 1){
//						params.put("opt_type", "getEmployeeBankInfoById");
//						params.put("employeeId", __value);
//					}else if(__typeVal == 2){//收款单位
//						params.put("opt_type", "getReceiveUnitInfoById");
//						params.put("receiveUnitManageId", __value);
//					}
//					DBDataSource.callOperation("EP_CustomSprocessbilllistppporProcess", params, new DSCallback() {
//						
//						@Override
//						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//							if(dsResponse.getStatus() > 0 && dsResponse.getData().length > 0){
//								Record __record = dsResponse.getData()[0];
//								if(__typeVal == 1){
//									payeeNameItem.setValue(BaseHelpUtils.getString(event.getItem().getDisplayValue()));
//									String bankId = BaseHelpUtils.getString(__record.getAttribute("bankId"));
//									selfBankNameItem.setValue(KeyValueManager.getValueMap("system_dictionary_68").get(bankId));
//									selfBankAccountItem.setValue(BaseHelpUtils.getString(__record.getAttribute("bankAccount")));
//								}else if(__typeVal == 2){
//									payeeNameItem.setValue(BaseHelpUtils.getString(__record.getAttribute("receiveUnit")));
//									selfBankNameItem.setValue(BaseHelpUtils.getString(__record.getAttribute("bankName")));
//									selfBankAccountItem.setValue(BaseHelpUtils.getString(__record.getAttribute("bankAccount")));
//								}
//							}
//						}
//					});
//				}
//			}
//		});
		payeeNameItem = new TextItem("payeeName", "收款人");
		payeeNameItem.setWidth("*");
		payeeNameItem.setHidden(true);
		
		selfBankNameItem = new TextItem("selfBankName", "银行名称");
		selfBankNameItem.setWidth("*");
		selfBankNameItem.setRequired(true);
		selfBankNameItem.setDisabled(true);

		selfBankAccountItem = new TextItem("selfBankAccount", "银行账号");
		selfBankAccountItem.setWidth("*");
		selfBankAccountItem.setDisabled(true);
		selfBankAccountItem.setRequired(true);
		
		otherNameItem = new SelectItem("otherName", "付款方");
		otherNameItem.setWidth("*");
		otherNameItem.setRequired(true);
		otherNameItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_69"));
		otherNameItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				otherBankNameItem.clearValue();
				otherBankAccountItem.clearValue();
				setSelectBankAddressByCompanyId(BaseHelpUtils.getIntValue(event.getValue()));
				
			}
		});
		
		otherBankNameItem = new SelectItem("otherBankName", "银行名称(付款方)");
		otherBankNameItem.setWidth("*");
		otherBankNameItem.setRequired(true);
		otherBankNameItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				otherBankAccountItem.clearValue();
				setSelectBankAccountByCompanyIdAndBankName(BaseHelpUtils.getIntValue(otherNameItem.getValue()), event.getValue().toString());
			}
		});
		
		otherBankAccountItem = new SelectItem("otherBankAccount", "银行账号(付款方)");
		otherBankAccountItem.setWidth("*");
		otherBankAccountItem.setRequired(true);
		
		payMoneyItem = new FloatItem("payMoney", "付款金额");
		payMoneyItem.setWidth("*");
		payMoneyItem.setLength(18);
		payMoneyItem.setDecimalPad(5);
		payMoneyItem.setRequired(true);
		payMoneyItem.setFormat("#,###,###,###,##0.00");
		
		balanceAmountItem = new FloatItem("balanceAmount", "冲账金额"); 
		balanceAmountItem.setWidth("*");
		balanceAmountItem.setLength(18);
		balanceAmountItem.setDecimalPad(5);
		balanceAmountItem.setFormat("#,###,###,###,##0.00");
		if(processType == 6 || processType == 7){
			balanceAmountItem.setHidden(true);;
		}
		
		remarkItem = new TextAreaItem("remark", "备注(<font color='red'>简写付款原因，即：用途（17个字内，包括字母和数字）</font>)");
		remarkItem.setValidators(ValidateUtils.StringLenValidator(0, 17));
		remarkItem.setWidth("*");
		remarkItem.setColSpan(2);
		remarkItem.setRowSpan(3);

		form.setNumCols(2);
		form.setDataSource(DSSprocessbilllistpppor.getInstance());
		if(isFinance){
			form.setItems(payForItem, employeeSelectItem, companySelectItem, employeeOrCompanyIdItem, payeeNameItem, selfBankNameItem, selfBankAccountItem,
					otherNameItem, otherBankNameItem,otherBankAccountItem, payMoneyItem, balanceAmountItem, remarkItem);
		}else{
			form.setItems(payForItem, employeeSelectItem, companySelectItem, employeeOrCompanyIdItem, payeeNameItem, selfBankNameItem, selfBankAccountItem,
					payMoneyItem, balanceAmountItem, remarkItem);
		}
		ClientUtil.DynamicFormProcessAccordingToDevice(form);
		vLayout.addMember(form);
		form.setWidth100();
		form.setHeight100();

		saveButton = new IButton("确定", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (DataValidate()) {
					DataEditEvent dee = new DataEditEvent();
					dee.setData(getValueAsRecord());
					fireEvent(dee);
					if (null == getParentWindow()) {
						return;
					}
					getParentWindow().destroy();
				} else {
					return;
				}
			}
		});

		cancelButton = new IButton("取消", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (null == getParentWindow()) {
					return;
				}
				getParentWindow().destroy();
			}
		});
		
		addUnitButton = new IButton("添加收款单位", new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				PopupWindow window = new PopupWindow();
				window.setWidth("30%");
				window.setHeight("95%");
				window.centerInPage();
				window.setTitle("添加收款单位");
				AddReceiveUnitPanel panel = new AddReceiveUnitPanel();
				panel.setParentWindow(window);
				panel.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						final Record __record = event.getData();
						Map params = __record.toMap();
						params.put("operateEmployeeId", ClientUtil.getEmployeeId());
						params.put("opt_type", "addReceiveUnitInfo");
						DBDataSource.callOperation("EP_CustomSprocessbilllistppporProcess", params, new DSCallback() {
							
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								int __id = BaseHelpUtils.getIntValue(data);
								companySelectItem.setValue(__id);
								employeeOrCompanyIdItem.setValue(__id);
								payeeNameItem.setValue(BaseHelpUtils.getString(__record.getAttribute("receiveUnit")));
								selfBankNameItem.setValue(BaseHelpUtils.getString(__record.getAttribute("bankName")));
								selfBankAccountItem.setValue(BaseHelpUtils.getString(__record.getAttribute("bankAccount")));
//								setSelectValue();
							}
						});
					}
				});
				window.addItem(panel);
				window.show();
			}
		});
		if(budgetRecord!=null) {
			if(processType==7||processType==6){//预付款,借款预算时触发
				Map<String, Object> params = new HashMap<>();
				int payFor=BaseHelpUtils.getIntValue(budgetRecord.getAttribute("payFor"));
				int receiveUnitManageId=BaseHelpUtils.getIntValue(budgetRecord.getAttribute("receiveUnitManageId"));
				BigDecimal payAmount=BaseHelpUtils.getBigDecimalValue(budgetRecord.getAttribute("payAmount"));
				if(processType==7) {
				payForItem.setDefaultValue(2);
				payForItem.setDisabled(true);
				companySelectItem.setValue(receiveUnitManageId);
				payMoneyItem.setValue(payAmount);
				payeeNameItem.clearValue();
				selfBankNameItem.clearValue();
				selfBankAccountItem.clearValue();
				employeeOrCompanyIdItem.setValue(receiveUnitManageId);
						params.put("opt_type", "getReceiveUnitInfoById");
						params.put("receiveUnitManageId", receiveUnitManageId);
					DBDataSource.callOperation("EP_CustomSprocessbilllistppporProcess", params, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if(dsResponse.getStatus() > 0 && dsResponse.getData().length > 0){
								Record __record = dsResponse.getData()[0];
									payeeNameItem.setValue(BaseHelpUtils.getString(__record.getAttribute("receiveUnit")));
									selfBankNameItem.setValue(BaseHelpUtils.getString(__record.getAttribute("bankName")));
									selfBankAccountItem.setValue(BaseHelpUtils.getString(__record.getAttribute("bankAccount")));
							}
						}
					});
				employeeSelectItem.hide();
				companySelectItem.show();
				}
				if(processType==6) {
					payMoneyItem.setValue(payAmount);
					employeeOrCompanyIdItem.setValue(receiveUnitManageId);
					if(payFor==1) {//个人
						payForItem.setValue(1);
						addUnitButton.hide();
						employeeSelectItem.show();
						companySelectItem.hide();
						employeeSelectItem.setValue(receiveUnitManageId);
						params.put("opt_type", "getEmployeeBankInfoById");
						params.put("employeeId", receiveUnitManageId);
						DBDataSource.callOperation("EP_CustomSprocessbilllistppporProcess", params, new DSCallback() {

							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								if(dsResponse.getStatus() > 0 && dsResponse.getData().length > 0){
									Record __record = dsResponse.getData()[0];
									payeeNameItem.setValue(BaseHelpUtils.getString(employeeSelectItem.getDisplayValue()));
									String bankId = BaseHelpUtils.getString(__record.getAttribute("bankId"));
									selfBankNameItem.setValue(KeyValueManager.getValueMap("system_dictionary_68").get(bankId));
									selfBankAccountItem.setValue(BaseHelpUtils.getString(__record.getAttribute("bankAccount")));
								}
							}
						});
					}else {//公司
						payForItem.setValue(2);
						addUnitButton.show();
						companySelectItem.show();
						employeeSelectItem.hide();
						companySelectItem.setValue(receiveUnitManageId);
						payeeNameItem.clearValue();
						selfBankNameItem.clearValue();
						selfBankAccountItem.clearValue();
						params.put("opt_type", "getReceiveUnitInfoById");
						params.put("receiveUnitManageId", receiveUnitManageId);
						DBDataSource.callOperation("EP_CustomSprocessbilllistppporProcess", params, new DSCallback() {
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								if(dsResponse.getStatus() > 0 && dsResponse.getData().length > 0){
									Record __record = dsResponse.getData()[0];
									payeeNameItem.setValue(BaseHelpUtils.getString(__record.getAttribute("receiveUnit")));
									selfBankNameItem.setValue(BaseHelpUtils.getString(__record.getAttribute("bankName")));
									selfBankAccountItem.setValue(BaseHelpUtils.getString(__record.getAttribute("bankAccount")));
								}
							}
						});
					}
				}
			}
			
		}
		if(processType==7) {
			payForItem.setDefaultValue(2);
			payForItem.setDisabled(true);
			employeeSelectItem.hide();
			companySelectItem.show();
		}else{
			payForItem.setDefaultValue(1);  
			addUnitButton.hide();
			}
		buttonLayout = new HLayout();
		buttonLayout.setWidth100();
		buttonLayout.setHeight(20);
		buttonLayout.setMargin(8);
		buttonLayout.setMembersMargin(20);
		buttonLayout.setAlign(Alignment.CENTER);
		buttonLayout.addMember(saveButton);
		buttonLayout.addMember(cancelButton);
		if(!isFinance){}buttonLayout.addMember(addUnitButton);
		
		vLayout.addMember(buttonLayout);

		addMember(vLayout);
//		setSelectValue();
	}


	@Override
	public void fireEvent(GwtEvent<?> event) {
		handlerManager.fireEvent(event);
	}

	public Record getValueAsRecord() {
		Map map = form.getValues();
		Record record = new Record();
		if (null != map && !map.isEmpty()) {
			for (Object key : map.keySet()) {
				record.setAttribute(key.toString(), map.get(key));
			}
		}
		return record;
	}

	public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
		return handlerManager.addHandler(DataEditEvent.TYPE, handler);
	}
	
//	private void setSelectValue(){
//		Map<String, Object> params = new HashMap<>();
//		params.put("opt_type", "getReceiveUnitList");
//		KeyValueManager.setValueMapFromQuery("EP_CustomSprocessbilllistppporProcess", MapUtils.toJSON(params), companySelectItem);
//	}

	/**
	 * 
	 * @param record
	 *            需要编辑的记录
	 * @param departmentId
	 *            报销部门ID
	 * @param amount
	 *            
	 * @param update
	 *            本次操作是否是修改操作
	 */
	public void startEdit(Record record, BigDecimal amount, boolean update) {
		if (update) {
			form.editRecord(record);
			int payFor = record.getAttributeAsInt("payFor");
			int employeeOrCompanyId = record.getAttributeAsInt("employeeOrCompanyId");
			if(payFor == 2){
				addUnitButton.show();
//				setSelectValue();
				companySelectItem.show();
				companySelectItem.setValue(employeeOrCompanyId);
				employeeSelectItem.hide();
			}else{
				companySelectItem.hide();
				employeeSelectItem.show();
				employeeSelectItem.setValue(employeeOrCompanyId);
			}
		}else{
			
		}
		//出纳时  可以操做付款人
		if(__isFinance){
			if(update){
				if(!BaseHelpUtils.isNullOrEmpty(record.getAttribute("otherName"))){
					int __companyId = record.getAttributeAsInt("otherName");
					otherNameItem.setValue(companyId);
					setSelectBankAddressByCompanyId(__companyId);
					setSelectBankAccountByCompanyIdAndBankName(__companyId, record.getAttribute("otherBankName"));
				}
				
			}else{
				otherNameItem.setValue(getCompanyId());
				setSelectBankAddressByCompanyId(getCompanyId());
			}
			
		}
	}
	
	private void setSelectBankAccountByCompanyIdAndBankName(int __companyId, String bankAddress){
		Map<String, Object> params = new HashMap<>();
		params.put("opt_type", "getBankcardByCmpAndAddress");
		params.put("objectId", __companyId);
		params.put("objectType", 2);
		params.put("bankAddress", bankAddress);
		KeyValueManager.setValueMapFromQuery("EP_CustomSprocessbilllistppporProcess", MapUtils.toJSON(params), otherBankAccountItem);
	}
	
	private void setSelectBankAddressByCompanyId(int __companyId){
		Map<String, Object> params = new HashMap<>();
		params.put("opt_type", "getBankAddressByCompany");
		params.put("objectId", __companyId);
		params.put("objectType", 2);
		KeyValueManager.setValueMapFromQuery("EP_CustomSprocessbilllistppporProcess", MapUtils.toJSON(params), otherBankNameItem);
	}
	

	// 数据验证
	public boolean DataValidate() {
		if(form.validate()) {
			if(null != employeeOrCompanyIdItem.getValue() && BaseHelpUtils.getIntValue(employeeOrCompanyIdItem.getValue()) == 0) {
				SC.say("收款方只能从下拉列表中选择数据");
				return false;
			}
			return true;
		}
		return false;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	
	
}
