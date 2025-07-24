package com.pomplatform.client.reimbursement.form;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.k3code.datasource.DSCustomerK3Code;
import com.pomplatform.client.k3code.datasource.DSSk3codetpor;
import com.pomplatform.client.reimbursement.datasource.DSK3VoucherList;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.DoubleItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.form.validator.IsIntegerValidator;
import com.smartgwt.client.widgets.grid.ListGridField;

public class IncomeK3VoucherUpdateForm extends AbstractWizadPage
{


	private final TextItem k3VoucherIdItem;
	private final SelectItem companyIdItem;
	private final TextItem sequenceNumberItem;
	private final TextItem internalSequenceNumberItem;
	private final ComboBoxItem codeItem;
	private final TextItem codeIdItem;
	private final ComboBoxItem secondaryCodeItem;
	private final TextItem secondaryCodeIdItem;
	private final TextItem remarkItem;
	private final TextItem simplifyRemarkItem;
	private final TextItem debitSideItem;
	private final TextItem creditSideItem;
	private final TextItem reimbursementPackageCodeItem;
	private final TextItem selfBankAccountItem;
	private final TextItem otherBankAccountItem;
	private final CheckboxItem needToChangeItem;
	private final DateItem vestingDateItem;
	private final CheckboxItem lockedItem;
	private final DateTimeItem createTimeItem;
	private final DateTimeItem updateTimeItem;
	private final DateTimeItem lockedTimeItem;
	
	public IncomeK3VoucherUpdateForm() {
		DSK3VoucherList ds = DSK3VoucherList.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		
		k3VoucherIdItem = new TextItem("k3VoucherId", "主键编码");
		k3VoucherIdItem.setDisabled(true);
		k3VoucherIdItem.setRequired(true);
		k3VoucherIdItem.hide();
		IsIntegerValidator k3VoucherIdValidator = new IsIntegerValidator();
		k3VoucherIdItem.setValidators(k3VoucherIdValidator);
		__formItems.add(k3VoucherIdItem);
		
		companyIdItem = new SelectItem("companyId", "归属公司");
		companyIdItem.setDisabled(true);
		companyIdItem.setWidth("*");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		__formItems.add(companyIdItem);
		
		sequenceNumberItem = new TextItem("sequenceNumber", "凭证号");
		sequenceNumberItem.setDisabled(true);
		sequenceNumberItem.setWidth("*");
		__formItems.add(sequenceNumberItem);
		
		reimbursementPackageCodeItem = new TextItem("invoiceNumber", "发票号码");
		reimbursementPackageCodeItem.setWidth("*");
		reimbursementPackageCodeItem.setDisabled(true);
		__formItems.add(reimbursementPackageCodeItem);
		
		internalSequenceNumberItem = new TextItem("internalSequenceNumber", "凭证内序号");
		internalSequenceNumberItem.setWidth("*");
		__formItems.add(internalSequenceNumberItem);
		
		//员工信息字段
		ListGridField k3CodeIdField = new ListGridField("k3CodeId");
		ListGridField k3CodeField = new ListGridField("k3Code");
		ListGridField k3NameField = new ListGridField("k3Name");
		
        codeItem = new ComboBoxItem("code", "科目代码");
        codeItem.setWidth("*");
        codeItem.setChangeOnKeypress(false);
        codeItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
        codeItem.setOptionDataSource(DSSk3codetpor.getInstance());
        codeItem.setValueField(k3CodeIdField.getName());
        codeItem.setDisplayField(k3CodeField.getName());
        codeItem.setPickListFields(k3NameField, k3CodeField);
        codeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				codeIdItem.setValue(event.getValue());
			}
		});
		__formItems.add(codeItem);
		
		codeIdItem = new TextItem("codeId", "科目名称");
		codeIdItem.setWidth("*");
		codeIdItem.setDisabled(true);
//		codeIdItem.setValueMap(KeyValueManager.getValueMap("k3_code_name"));
		KeyValueManager.loadValueMap("k3_code_name",codeIdItem);
		__formItems.add(codeIdItem);
		
		secondaryCodeItem = new ComboBoxItem("secondaryCode", "辅助核算代码");
		secondaryCodeItem.setWidth("*");
		secondaryCodeItem.setChangeOnKeypress(false);
		secondaryCodeItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		secondaryCodeItem.setValueField(k3CodeIdField.getName());
		secondaryCodeItem.setDisplayField(k3CodeField.getName());
		secondaryCodeItem.setPickListFields(k3NameField, k3CodeField);
		secondaryCodeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				secondaryCodeIdItem.setValue(event.getValue());
			}
		});
		__formItems.add(secondaryCodeItem);
		
		secondaryCodeIdItem = new TextItem("secondaryCodeId", "辅助核算名称");
		secondaryCodeIdItem.setWidth("*");
		secondaryCodeIdItem.setDisabled(true);
//		secondaryCodeIdItem.setValueMap(KeyValueManager.getValueMap("k3_code_name"));
		KeyValueManager.loadValueMap("k3_code_name",secondaryCodeIdItem);
		__formItems.add(secondaryCodeIdItem);
		
		remarkItem = new TextItem("remark", "备注");
		remarkItem.setWidth("*");
		__formItems.add(remarkItem);
		
		simplifyRemarkItem = new TextItem("simplifyRemark", "简化备注");
		simplifyRemarkItem.setWidth("*");
		__formItems.add(simplifyRemarkItem);
		
		debitSideItem = new DoubleItem("debitSide", "借方");
		debitSideItem.setWidth("*");
		debitSideItem.setLength(18);
		debitSideItem.setDecimalPad(2);
		debitSideItem.setFormat("#,###,###,###,###,##0.00");
		debitSideItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				numberFormat(event);
			}
		});
		__formItems.add(debitSideItem);
		
		creditSideItem = new DoubleItem("creditSide", "贷方");
		creditSideItem.setWidth("*");
		creditSideItem.setLength(18);
		creditSideItem.setDecimalPad(2);
		creditSideItem.setFormat("#,###,###,###,###,##0.00");
		creditSideItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				numberFormat(event);
			}
		});
		__formItems.add(creditSideItem);
		
		selfBankAccountItem = new TextItem("selfBankAccount", "我方银行账号");
		selfBankAccountItem.setWidth("*");
		__formItems.add(selfBankAccountItem);
		
		otherBankAccountItem = new TextItem("otherBankAccount", "对方银行账号");
		otherBankAccountItem.setWidth("*");
		__formItems.add(otherBankAccountItem);
		
		needToChangeItem = new CheckboxItem("needToChange", "需要调整");
		__formItems.add(needToChangeItem);
		
		vestingDateItem = new DateItem("vestingDate", "归属日期");
		vestingDateItem.setDisabled(true);
		vestingDateItem.hide();
		__formItems.add(vestingDateItem);
		
		lockedItem = new CheckboxItem("locked", "是否定稿");
		lockedItem.hide();
		__formItems.add(lockedItem);
		
		createTimeItem = new DateTimeItem("createTime", "创建时间");
		createTimeItem.hide();
		__formItems.add(createTimeItem);
		
		updateTimeItem = new DateTimeItem("updateTime", "修改时间");
		updateTimeItem.setDefaultValue(new Date());
		updateTimeItem.hide();
		__formItems.add(updateTimeItem);
		
		lockedTimeItem = new DateTimeItem("lockedTime", "定稿时间");
		lockedTimeItem.hide();
		__formItems.add(lockedTimeItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		setPageMode(PAGE_MODE_UPDATE);
		addMember(__form);
	}

	@Override
	public void startEdit() {
		Record record = getRecord();
		if(record != null){
			__form.editRecord(record);
			int codeType = ClientUtil.checkAndGetIntValue(record.getAttribute("codeType"));
			Criteria condition = new Criteria();
			condition.addCriteria("type", codeType);
			codeItem.setPickListCriteria(condition);
			int secondaryCodeType = ClientUtil.checkAndGetIntValue(record.getAttribute("secondaryCodeType"));
			if(secondaryCodeType == 9){
				secondaryCodeItem.setOptionDataSource(DSCustomerK3Code.getInstance());
			}
		}
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSK3VoucherList.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public java.util.Map getValuesAsMap() {
		Map map = __form.getValues();
		//把codeItem 和 辅助核算 的 id 和文字 取出来，放到map中
		if(null != codeItem.getDisplayValue()){
			map.put("code", codeItem.getDisplayValue());
		}
		if(null != codeIdItem.getDisplayValue()){
			map.put("name", codeIdItem.getDisplayValue());
		}
		if(null != secondaryCodeItem.getDisplayValue()){
			map.put("secondaryCode", secondaryCodeItem.getDisplayValue());
		}
		if(null != secondaryCodeIdItem.getDisplayValue()){
			map.put("secondaryName", secondaryCodeIdItem.getDisplayValue());
		}
		return map;
	}

	public void numberFormat(ChangedEvent event){
		if(null == event.getValue()){
			event.getItem().setValue(0);
		}else{
			BigDecimal value = new BigDecimal(event.getValue().toString()).setScale(2, BigDecimal.ROUND_DOWN);
			event.getItem().setValue(value);
		}
	}
}
