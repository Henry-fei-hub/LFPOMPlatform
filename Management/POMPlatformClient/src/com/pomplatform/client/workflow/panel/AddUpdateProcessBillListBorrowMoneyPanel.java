package com.pomplatform.client.workflow.panel;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
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
import com.pomplatform.client.sprocessbilllistpppor.datasource.DSSprocessbilllistpppor;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.TextMatchStyle;
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
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class AddUpdateProcessBillListBorrowMoneyPanel extends VLayout implements HasHandlers {

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
/*	private final FloatItem balanceAmountItem;
*/	private final TextAreaItem remarkItem;
	
	private int companyId;
	
	private boolean __isFinance;
	

	public Window getParentWindow() {
		return parentWindow;
	}

	public void setParentWindow(Window parentWindow) {
		this.parentWindow = parentWindow;
	}

	public AddUpdateProcessBillListBorrowMoneyPanel(boolean update, boolean isFinance) {
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
			public void onChanged(ChangedEvent event) {
				int typeVal = BaseHelpUtils.getIntValue(event.getValue());
				employeeOrCompanyIdItem.clearValue();
				payeeNameItem.clearValue();
				selfBankNameItem.clearValue();
				selfBankAccountItem.clearValue();
				if(typeVal == 1){
					addUnitButton.hide();
					employeeOrCompanyIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
				}else{
					addUnitButton.show();
					//设置下拉值
					setSelectValue();
				}
				
			}  
        });  
		
		employeeOrCompanyIdItem = new ComboBoxItem("employeeOrCompanyId", "收款方");
		employeeOrCompanyIdItem.setChangeOnKeypress(false);
		employeeOrCompanyIdItem.setWidth("*");
		employeeOrCompanyIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		employeeOrCompanyIdItem.setRequired(true);
		employeeOrCompanyIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeOrCompanyIdItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				int __value = BaseHelpUtils.getIntValue(event.getValue());
				payeeNameItem.clearValue();
				selfBankNameItem.clearValue();
				selfBankAccountItem.clearValue();
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
		
		/*balanceAmountItem = new FloatItem("balanceAmount", "差额金额");
		balanceAmountItem.setWidth("*");
		balanceAmountItem.setLength(18);
		balanceAmountItem.setDecimalPad(5);
		balanceAmountItem.setFormat("#,###,###,###,##0.00");*/
		
		remarkItem = new TextAreaItem("remark", "备注");
		remarkItem.setWidth("*");
		remarkItem.setColSpan(2);
		remarkItem.setRowSpan(3);

		form.setNumCols(2);
		form.setDataSource(DSSprocessbilllistpppor.getInstance());
		if(isFinance){
			form.setItems(payForItem, employeeOrCompanyIdItem, payeeNameItem, selfBankNameItem, selfBankAccountItem,
					otherNameItem, otherBankNameItem,otherBankAccountItem, payMoneyItem, /*balanceAmountItem,*/ remarkItem);
		}else{
			form.setItems(payForItem, employeeOrCompanyIdItem, payeeNameItem, selfBankNameItem, selfBankAccountItem,
					payMoneyItem,/* balanceAmountItem, */remarkItem);
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
								employeeOrCompanyIdItem.setValue(__id);
								payeeNameItem.setValue(BaseHelpUtils.getString(__record.getAttribute("receiveUnit")));
								selfBankNameItem.setValue(BaseHelpUtils.getString(__record.getAttribute("bankName")));
								selfBankAccountItem.setValue(BaseHelpUtils.getString(__record.getAttribute("bankAccount")));
								setSelectValue();
							}
						});
					}
				});
				window.addItem(panel);
				window.show();
			}
		});
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
	
	private void setSelectValue(){
		Map<String, Object> params = new HashMap<>();
		params.put("opt_type", "getReceiveUnitList");
		KeyValueManager.setValueMapFromQuery("EP_CustomSprocessbilllistppporProcess", MapUtils.toJSON(params), employeeOrCompanyIdItem);
	}

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
			if(payFor == 2){
				addUnitButton.show();
				setSelectValue();
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
		return form.validate();
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
