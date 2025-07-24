package com.pomplatform.client.receivables.form;

import java.math.BigDecimal;
import java.util.Objects;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.receivables.datasource.DSMcapitalecoosmeor;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.DoubleItem;
import com.smartgwt.client.widgets.form.fields.FloatItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.form.validator.IsStringValidator;
import com.smartgwt.client.widgets.form.validator.LengthRangeValidator;

public class McapitalecoosmeorGroupname3Update extends AbstractWizadPage {

	private final TextItem borrowMoneyItem;
	private final TextItem loanMoneyItem;
	private final TextItem operatorItem;
	private final DateTimeItem happenDateItem;
	private final DateTimeItem createDateItem;
	private final TextItem employeeNameItem;
	private final DoubleItem actualAmountItem;
	private final DateItem actualReceiveDateItem;
	private final TextAreaItem remarkItem;
	private final FloatItem exchangeRateItem;
	private final FloatItem originalCurrencyItem;

	public McapitalecoosmeorGroupname3Update() {
		DSMcapitalecoosmeor ds = DSMcapitalecoosmeor.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		borrowMoneyItem = new FloatItem("borrowMoney", "借(增加)人民币金额");
		borrowMoneyItem.addChangedHandler(new ChangedHandler() {

			@Override
			public void onChanged(ChangedEvent event) {
				if (null != event.getValue()) {
					Float exchangeRate = exchangeRateItem.getValueAsFloat();
					if (Objects.equals(exchangeRate, 1f)) {
						originalCurrencyItem.setValue(event.getValue());
					}
				}

			}
		});
		borrowMoneyItem.setWidth("*");
		__formItems.add(borrowMoneyItem);
		exchangeRateItem = new FloatItem("exchangeRate", "汇率");
		exchangeRateItem.setDefaultValue(1);
		exchangeRateItem.setWidth("*");
		__formItems.add(exchangeRateItem);
		originalCurrencyItem = new FloatItem("originalCurrency", "原币金额");
		originalCurrencyItem.addChangedHandler(new ChangedHandler() {

			@Override
			public void onChanged(ChangedEvent event) {
				if (null != event.getValue()) {
					Float exchangeRate = exchangeRateItem.getValueAsFloat();
					if (Objects.equals(exchangeRate, 1f)) {
						borrowMoneyItem.setValue(event.getValue());
					}
				}

			}
		});
		originalCurrencyItem.setWidth("*");
		__formItems.add(originalCurrencyItem);
		loanMoneyItem = new TextItem("loanMoney", "贷（减少）");
		loanMoneyItem.setHidden(true);
		__formItems.add(loanMoneyItem);
		operatorItem = new TextItem("operator", "操作人id");
		operatorItem.setHidden(true);
		__formItems.add(operatorItem);
		happenDateItem = new DateTimeItem("happenDate", "发生日期");
		happenDateItem.setWidth("*");
		__formItems.add(happenDateItem);
		createDateItem = new DateTimeItem("createDate", "登记日期");
		createDateItem.setDisabled(true);
		createDateItem.setWidth("*");
		__formItems.add(createDateItem);
		employeeNameItem = new TextItem("employeeName", "登记人");
		employeeNameItem.setRequired(true);
		employeeNameItem.setDisabled(true);
		employeeNameItem.setWidth("*");

		IsStringValidator employeeNameValidator = new IsStringValidator();
		LengthRangeValidator employeeNameLengthValidator = new LengthRangeValidator();
		employeeNameLengthValidator.setMax(64);
		employeeNameItem.setValidators(employeeNameValidator, employeeNameLengthValidator);
		__formItems.add(employeeNameItem);
		
		actualAmountItem = new DoubleItem("actualAmount", "实际到账金额");
		actualAmountItem.setWidth("*");
		actualAmountItem.setLength(18);
		actualAmountItem.setDecimalPad(2);
		actualAmountItem.setFormat("#,###,###,###,###,##0.00");
		actualAmountItem.hide();
		__formItems.add(actualAmountItem);
		actualAmountItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				if(null != event.getValue()){
					BigDecimal actualAmount = new BigDecimal(event.getValue().toString()).setScale(2, BigDecimal.ROUND_DOWN);
					actualAmountItem.setValue(actualAmount);
				}else{
					actualAmountItem.setValue(0);
				}
			}
		});
		
		actualReceiveDateItem = new DateItem("actualReceiveDate", "实际到账日期");
		actualReceiveDateItem.setWidth("*");
		actualReceiveDateItem.setUseTextField(true);
		actualReceiveDateItem.setUseMask(true);
		actualReceiveDateItem.hide();
		__formItems.add(actualReceiveDateItem);
		
		remarkItem = new TextAreaItem("remark", "备注");
		remarkItem.setWidth("*");
		remarkItem.setRowSpan(3);
		__formItems.add(remarkItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		remarkItem.setColSpan(4);
		setPageMode(PAGE_MODE_UPDATE);
		setName("账单金额及登记信息");
		addMember(__form);
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSMcapitalecoosmeor.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public void startEdit() {
		Record r = getRecord();
		if (null != r) {
			__form.editRecord(r);
			int moneyAttribute = BaseHelpUtils.getIntValue(r.getAttribute("moneyAttribute"));
			if(moneyAttribute == ClientStaticUtils.CAPITAL_MONEY_ATTRIBUTION_11 || moneyAttribute == ClientStaticUtils.CAPITAL_MONEY_ATTRIBUTION_13) {
				actualAmountItem.show();
				actualReceiveDateItem.show();
			}
		}
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}

}
