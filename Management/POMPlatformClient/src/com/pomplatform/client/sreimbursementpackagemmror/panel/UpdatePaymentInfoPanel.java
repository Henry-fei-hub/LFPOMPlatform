package com.pomplatform.client.sreimbursementpackagemmror.panel;

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
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FloatItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class UpdatePaymentInfoPanel extends VLayout implements HasHandlers {

	private static final Logger logger = Logger.getLogger("");
	private final DynamicForm form = new DynamicForm();
	private final VLayout vLayout;
	private final IButton saveButton;
	private final IButton cancelButton;
	private final HLayout buttonLayout;
	private Window parentWindow;
	protected final HandlerManager handlerManager = new HandlerManager(this);
	private BigDecimal amount = BigDecimal.ZERO;
	
	
	private final TextItem selfBankNameItem;
	private final TextItem selfBankAccountItem;
	private final TextItem payeeNameItem;
	private final SelectItem otherNameItem;
	private final SelectItem otherBankNameItem;
	private final SelectItem otherBankAccountItem;
	private final FloatItem payMoneyItem;
	private final FloatItem balanceAmountItem;
	
	private int companyId;
	
	
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

	public UpdatePaymentInfoPanel(boolean isOnlyOne, Integer companyId) {
		vLayout = new VLayout();
		vLayout.setWidth100();
		vLayout.setHeight100();
		vLayout.setMargin(10);
		vLayout.setMembersMargin(12);
		
		payeeNameItem = new TextItem("payeeName", "收款人");
		payeeNameItem.setWidth("*");
		payeeNameItem.setDisabled(true);
		
		selfBankNameItem = new TextItem("selfBankName", "银行名称");
		selfBankNameItem.setWidth("*");
		selfBankNameItem.setRequired(true);
		selfBankNameItem.setDisabled(true);

		selfBankAccountItem = new TextItem("selfBankAccount", "银行账号");
		selfBankAccountItem.setWidth("*");
		selfBankAccountItem.setDisabled(true);
		selfBankAccountItem.setRequired(true);
		
		payMoneyItem = new FloatItem("paymentAmount", "付款金额");
		payMoneyItem.setWidth("*");
		payMoneyItem.setLength(18);
		payMoneyItem.setDecimalPad(5);
		payMoneyItem.setRequired(true);
		payMoneyItem.setDisabled(true);
		payMoneyItem.setFormat("#,###,###,###,##0.00");
		
		balanceAmountItem = new FloatItem("strikeABalanceAmount", "冲账金额");
		balanceAmountItem.setWidth("*");
		balanceAmountItem.setLength(18);
		balanceAmountItem.setDecimalPad(5);
		balanceAmountItem.setDisabled(true);
		balanceAmountItem.setFormat("#,###,###,###,##0.00");
		
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
		
		form.setNumCols(2);
//		form.setDataSource(DSSreimbursementpackagesummaryrror.getInstance());
		if(isOnlyOne){
			form.setItems(payeeNameItem, selfBankNameItem, selfBankAccountItem, payMoneyItem, balanceAmountItem,
					otherNameItem, otherBankNameItem,otherBankAccountItem);
		} else {
			form.setItems(otherNameItem, otherBankNameItem,otherBankAccountItem);
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
		
		
		buttonLayout = new HLayout();
		buttonLayout.setWidth100();
		buttonLayout.setHeight(20);
		buttonLayout.setMargin(8);
		buttonLayout.setMembersMargin(20);
		buttonLayout.setAlign(Alignment.CENTER);
		buttonLayout.addMember(saveButton);
		buttonLayout.addMember(cancelButton);
		
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
	public void startEdit(Record record) {
		form.editRecord(record);
		//  可以操做付款人
		if(!BaseHelpUtils.isNullOrEmpty(record.getAttribute("otherName"))){
			int __companyId = record.getAttributeAsInt("otherName");
			otherNameItem.setValue(__companyId);
			setSelectBankAddressByCompanyId(__companyId);
			setSelectBankAccountByCompanyIdAndBankName(__companyId, record.getAttribute("otherBankName"));
		}
				
	}
	
	public void setDefaultValue(Integer companyId) {
		if(null != otherNameItem.getValue()) {
			return;
		}
		// 查询出归属公司默认卡号进行付款
		if(null != companyId) {
			Map<String, Object> params = new HashMap<>();
			params.put("objectId", companyId);
			params.put("objectType", 2);
			params.put("defaultCard", true);
			params.put("enabled", true);
			DBDataSource.callOperation("ST_CardManage", "find", params, new DSCallback() {
				
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					if(dsResponse.getStatus() >= 0) {
						Record [] records = dsResponse.getData();
						if(records.length > 0) {
							Record rd = records[0];
							otherNameItem.setValue(rd.getAttribute("objectId"));
							otherBankAccountItem.setValue(rd.getAttribute("bankAccount"));
							otherBankNameItem.setValue(rd.getAttribute("bankAddress"));
						}
					}
					
				}
			});
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
