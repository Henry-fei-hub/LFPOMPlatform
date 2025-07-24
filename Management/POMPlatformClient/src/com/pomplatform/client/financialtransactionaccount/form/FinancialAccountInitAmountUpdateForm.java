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
import com.pomplatform.client.financialtransactionaccount.datasource.DSFinancialAccountInitAmount;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.form.validator.IsIntegerValidator;

public class FinancialAccountInitAmountUpdateForm extends AbstractWizadPage
{


	private final TextItem financialAccountInitAmountIdItem;
	private final TextItem financialTransactionAccountIdItem;
	private final ComboBoxItem companyIdItem;
	private final SelectItem currencyTypeItem;
	private final TextItem originalDebitItem;
	private final TextItem originalCreditItem;
	private final TextItem exchangeRateItem;
	private final TextItem standardDebitItem;
	private final TextItem standardCreditItem;
	private final TextAreaItem summaryItem;
	private final TextItem attachmentIdItem;
	private final TextItem operatorIdItem;
	private final DateTimeItem createTimeItem;
	private final TextItem deleteFlagItem;

	private static final Logger logger = Logger.getLogger("");
	
	public FinancialAccountInitAmountUpdateForm() {
		DSFinancialAccountInitAmount ds = DSFinancialAccountInitAmount.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		
		financialAccountInitAmountIdItem = new TextItem("financialAccountInitAmountId", "主键编码");
		financialAccountInitAmountIdItem.setDisabled(true);
		financialAccountInitAmountIdItem.setRequired(true);
		financialAccountInitAmountIdItem.hide();
		IsIntegerValidator financialAccountInitAmountIdValidator = new IsIntegerValidator();
		financialAccountInitAmountIdItem.setValidators(financialAccountInitAmountIdValidator);
		__formItems.add(financialAccountInitAmountIdItem);
		
		financialTransactionAccountIdItem = new TextItem("financialTransactionAccountId", "财务往来账户");
		financialTransactionAccountIdItem.setWidth("*");
		financialTransactionAccountIdItem.setCanEdit(false);
		KeyValueManager.loadValueMap("financial_transaction_accounts", financialTransactionAccountIdItem);
		__formItems.add(financialTransactionAccountIdItem);
		
		companyIdItem = new ComboBoxItem("companyId", "归属公司");
		companyIdItem.setWidth("*");
		companyIdItem.setChangeOnKeypress(false);
		companyIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		companyIdItem.setValueMap(KeyValueManager.getValueMap("company_records"));
		companyIdItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				String id = BaseHelpUtils.getString(financialTransactionAccountIdItem.getValue());
				Map<String, String> params = new HashMap<>();
				params.put("financialTransactionAccountId", id);
				params.put("companyId", BaseHelpUtils.getString(event.getValue()));
				DBDataSource.callOperation("ST_FinancialAccountInitAmount", "find", params, new DSCallback() {
					
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0) {
							Record[] records = dsResponse.getData();
							if(null != records && records.length != 0) {
								__form.editRecord(records[0]);
							}
						}else {
							ClientUtil.displayErrorMessage(dsResponse);
						}
					}
				});
			}
		});
		__formItems.add(companyIdItem);
		
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
		
		summaryItem = new TextAreaItem("summary", "摘要");
		summaryItem.setWidth("*");
		summaryItem.setColSpan(2);
		summaryItem.setRowSpan(3);
		__formItems.add(summaryItem);
		
		attachmentIdItem = new TextItem("attachmentId", "附件编码");
		attachmentIdItem.hide();
		__formItems.add(attachmentIdItem);
		
		operatorIdItem = new TextItem("operatorId", "操作人");
		operatorIdItem.setValue(ClientUtil.getUserId());
		operatorIdItem.hide();
		__formItems.add(operatorIdItem);
		
		createTimeItem = new DateTimeItem("createTime", "创建时间");
		createTimeItem.hide();
		__formItems.add(createTimeItem);
		
		deleteFlagItem = new TextItem("deleteFlag", "删除状态");
		deleteFlagItem.hide();
		__formItems.add(deleteFlagItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(2);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		setPageMode(PAGE_MODE_UPDATE);
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
	public void startEdit() {
		if(null != getRecord()) {
			__form.editRecord(getRecord());
		}else {
			__form.editNewRecord();
		}
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSFinancialAccountInitAmount.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
