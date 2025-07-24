package com.pomplatform.client.financialtransactionaccount.form;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.financialtransactionaccount.datasource.DSFinancialTransactionDetail;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;

public class TransDetailNewForm extends AbstractWizadPage
{

private static final Logger logger = Logger.getLogger("");
	private final TextItem financialTransactionAccountIdItem;
	private final DateItem recordDateItem;
	private final TextAreaItem summaryItem;
	private final SelectItem currencyTypeItem;
	private final TextItem originalDebitItem;
	private final TextItem originalCreditItem;
	private final TextItem exchangeRateItem;
	private final TextItem standardDebitItem;
	private final TextItem standardCreditItem;
	private final ComboBoxItem operatorAccountIdItem;
	private final CheckboxItem isLockedItem;
	private final CheckboxItem isHumanAddItem;
	private final CheckboxItem isCompletedItem;

	public TransDetailNewForm() {
		DSFinancialTransactionDetail ds = DSFinancialTransactionDetail.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		
		financialTransactionAccountIdItem = new TextItem("financialTransactionAccountId", "财务往来账户");
		financialTransactionAccountIdItem.setWidth("*");
		financialTransactionAccountIdItem.setCanEdit(false);
		KeyValueManager.loadValueMap("financial_transaction_accounts", financialTransactionAccountIdItem);
		__formItems.add(financialTransactionAccountIdItem);
		
		recordDateItem = new DateItem("recordDate", "日期");
		recordDateItem.setWidth("*");
		recordDateItem.setUseTextField(true);
		recordDateItem.setUseMask(true);
		__formItems.add(recordDateItem);
		
		currencyTypeItem = new SelectItem("currencyType", "货币种类");
		currencyTypeItem.setWidth("*");
		currencyTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_40"));
		currencyTypeItem.setDefaultValue(ClientStaticUtils.CURRENCY_0);
		currencyTypeItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				if(currencyTypeItem.getValue() != null) {
					int currency = BaseHelpUtils.getIntValue(currencyTypeItem.getValue());
					if(currency == ClientStaticUtils.CURRENCY_0) {
						exchangeRateItem.setValue(1);
						refreshOrginalSite();
					}else {
						Map<String, Object> params = new HashMap<>();
						params.put("currency", currency);
						DBDataSource.callOperation("EP_ExchangeRateUtils", params, new DSCallback() {
							
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								if(dsResponse.getStatus() >= 0) {
									Record r = dsResponse.getData()[0];
									exchangeRateItem.setValue(r.getAttribute("exchangeRate"));
									refreshOrginalSite();
								}else {
									ClientUtil.displayErrorMessage(dsResponse);
								}
							}
						});
					}
				}
			}
		});
		__formItems.add(currencyTypeItem);
		
		exchangeRateItem = new TextItem("exchangeRate", "汇率");
		exchangeRateItem.setWidth("*");
		exchangeRateItem.setDefaultValue(1);
		exchangeRateItem.setCanEdit(false);
		exchangeRateItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				refreshOrginalSite();
			}
		});
		__formItems.add(exchangeRateItem);
		
		originalDebitItem = new TextItem("originalDebit", "原币借");
		originalDebitItem.setWidth("*");
		originalDebitItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				if(null != originalDebitItem.getValue()) {
					BigDecimal originalDebit = BaseHelpUtils.getBigDecimalValue(originalDebitItem.getValue());
					if(originalDebit.compareTo(BigDecimal.ZERO) != 0) {
						originalCreditItem.setValue("0");
						standardCreditItem.setValue("0");
						BigDecimal rate = BaseHelpUtils.getBigDecimalValue(exchangeRateItem.getValue());
						if(rate.compareTo(BigDecimal.ZERO) != 0) {
							standardDebitItem.setValue(originalDebit.multiply(rate).setScale(2, BigDecimal.ROUND_HALF_UP));
						}
					}
				}
			}
		});
		__formItems.add(originalDebitItem);
		
		originalCreditItem = new TextItem("originalCredit", "原币贷");
		originalCreditItem.setWidth("*");
		originalCreditItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				if(null != originalCreditItem.getValue()) {
					BigDecimal originalCredit = BaseHelpUtils.getBigDecimalValue(originalCreditItem.getValue());
					if(originalCredit.compareTo(BigDecimal.ZERO) != 0) {
						originalDebitItem.setValue("0");
						standardDebitItem.setValue("0");
						BigDecimal rate = BaseHelpUtils.getBigDecimalValue(exchangeRateItem.getValue());
						if(rate.compareTo(BigDecimal.ZERO) != 0) {
							standardCreditItem.setValue(originalCredit.multiply(rate).setScale(2, BigDecimal.ROUND_HALF_UP));
						}
					}
				}
			}
		});
		__formItems.add(originalCreditItem);
		
		standardDebitItem = new TextItem("standardDebit", "本币借");
		standardDebitItem.setWidth("*");
		standardDebitItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				if(null != standardDebitItem.getValue()) {
					BigDecimal debit = BaseHelpUtils.getBigDecimalValue(standardDebitItem.getValue());
					if(debit.compareTo(BigDecimal.ZERO) != 0) {
						originalCreditItem.setValue("0");
						standardCreditItem.setValue("0");
						BigDecimal rate = BaseHelpUtils.getBigDecimalValue(exchangeRateItem.getValue());
						if(rate.compareTo(BigDecimal.ZERO) != 0) {
							originalDebitItem.setValue(debit.divide(rate, 2, BigDecimal.ROUND_HALF_UP));
						}
					}
				}
			}
		});
		__formItems.add(standardDebitItem);
		
		standardCreditItem = new TextItem("standardCredit", "本币贷");
		standardCreditItem.setWidth("*");
		standardCreditItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				if(null != standardCreditItem.getValue()) {
					BigDecimal debit = BaseHelpUtils.getBigDecimalValue(standardCreditItem.getValue());
					if(debit.compareTo(BigDecimal.ZERO) != 0) {
						originalDebitItem.setValue("0");
						standardDebitItem.setValue("0");
						BigDecimal rate = BaseHelpUtils.getBigDecimalValue(exchangeRateItem.getValue());
						if(rate.compareTo(BigDecimal.ZERO) != 0) {
							originalCreditItem.setValue(debit.divide(rate, 2, BigDecimal.ROUND_HALF_UP));
						}
					}
				}
			}
		});
		__formItems.add(standardCreditItem);
		
		operatorAccountIdItem = new ComboBoxItem("operatorAccountId", "经办人");
		KeyValueManager.loadValueMap("financial_transaction_accounts", operatorAccountIdItem);
		operatorAccountIdItem.setWidth("*");
		operatorAccountIdItem.setChangeOnKeypress(false);
		operatorAccountIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		__formItems.add(operatorAccountIdItem);
		
		summaryItem = new TextAreaItem("summary", "摘要");
		summaryItem.setWidth("*");
		summaryItem.setRowSpan(3);
		__formItems.add(summaryItem);
		
		isLockedItem = new CheckboxItem("isLocked", "是否锁定");
		isLockedItem.setDefaultValue(false);
		isLockedItem.hide();
		__formItems.add(isLockedItem);
		
		isHumanAddItem = new CheckboxItem("isHumanAdd", "是否人为添加");
		isHumanAddItem.setDefaultValue(true);
		isHumanAddItem.hide();
		__formItems.add(isHumanAddItem);
		
		isCompletedItem = new CheckboxItem("isCompleted", "是否完成");
		isCompletedItem.setDefaultValue(true);
		isCompletedItem.hide();
		__formItems.add(isCompletedItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		operatorAccountIdItem.setColSpan(4);
		summaryItem.setColSpan(4);
		addMember(__form);
	}

	/**
	 * 根据汇率和本位币借贷去刷新原币借贷金额
	 */
	public void refreshOrginalSite() {
		BigDecimal rate = BaseHelpUtils.getBigDecimalValue(exchangeRateItem.getValue());
		if(null != standardDebitItem.getValue()) {
			BigDecimal debit = BaseHelpUtils.getBigDecimalValue(standardDebitItem.getValue());
			if(debit.compareTo(BigDecimal.ZERO) != 0) {
				originalDebitItem.setValue(debit.divide(rate, 2, BigDecimal.ROUND_HALF_UP));
			}
		}
		if(null != standardCreditItem.getValue()) {
			BigDecimal credit = BaseHelpUtils.getBigDecimalValue(standardCreditItem.getValue());
			if(credit.compareTo(BigDecimal.ZERO) != 0) {
				originalCreditItem.setValue(credit.divide(rate, 2, BigDecimal.ROUND_HALF_UP));
			}
		}
	}
	
	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
		else __form.editNewRecord();
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSFinancialTransactionDetail.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
