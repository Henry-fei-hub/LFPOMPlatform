package com.pomplatform.client.workflow.form;

import java.math.BigDecimal;
import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.types.DateItemSelectorFormat;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.workflow.datasource.DSBonusPaymentRecordWithB;

public class BonusPaymentRecordWithBUpdateForm extends AbstractWizadPage
{


	private final TextItem bonusPaymentRecordIdItem;
	private final SelectItem plateIdItem;
	private final TextItem payIntegralItem;
	private final DateItem payDateItem;
	private final TextAreaItem remarkItem;
	private final DateItem applyTimeItem;
	private final DateItem auditingTimeItem;

	public BonusPaymentRecordWithBUpdateForm() {
		DSBonusPaymentRecordWithB ds = DSBonusPaymentRecordWithB.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		bonusPaymentRecordIdItem = new TextItem("bonusPaymentRecordId", "主键编码");
		bonusPaymentRecordIdItem.setDisabled(true);
		bonusPaymentRecordIdItem.setRequired(true);
		bonusPaymentRecordIdItem.hide();
		IsIntegerValidator bonusPaymentRecordIdValidator = new IsIntegerValidator();
		bonusPaymentRecordIdItem.setValidators(bonusPaymentRecordIdValidator);
		__formItems.add(bonusPaymentRecordIdItem);
		plateIdItem = new SelectItem("plateId", "业务部门");
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		plateIdItem.setCanEdit(false);
		plateIdItem.setWidth("*");
		__formItems.add(plateIdItem);
		payIntegralItem = new DoubleItem("payIntegral", "发放积分");
		payIntegralItem.setLength(12);
		payIntegralItem.setDecimalPad(2);
		payIntegralItem.setFormat("#,###,###,##0.00");
		payIntegralItem.setWidth("*");
		payIntegralItem.setCanEdit(false);
		__formItems.add(payIntegralItem);
		applyTimeItem = new DateItem("applyTime", "创建时间");
		applyTimeItem.setWidth("*");
		applyTimeItem.setDisabled(true);
		applyTimeItem.setUseTextField(true);
		applyTimeItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
		__formItems.add(applyTimeItem);
		auditingTimeItem = new DateItem("auditingTime", "发放时间");
		auditingTimeItem.setWidth("*");
		auditingTimeItem.setUseTextField(true);
		auditingTimeItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
		__formItems.add(auditingTimeItem);
		payDateItem = new DateItem("payDate", "申请时间");
		payDateItem.setWidth("*");
		payDateItem.setUseTextField(true);
		payDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
		__formItems.add(payDateItem);
		remarkItem = new TextAreaItem("remark", "申请缘由");
		remarkItem.setLength(512);
		remarkItem.setColSpan(6);
		remarkItem.setRowSpan(2);
		remarkItem.setWidth("*");
		remarkItem.setHeight(70);
		__formItems.add(remarkItem);
		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		setPageMode(PAGE_MODE_UPDATE);
		addMember(__form);
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSBonusPaymentRecordWithB.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		if(BaseHelpUtils.getIntValue(plateIdItem.getValue())<=0){
			SC.say("提示","业务部门不能为空");
			return false;
		}
		if(BaseHelpUtils.getBigDecimalValue(payIntegralItem.getValue()).compareTo(BigDecimal.ZERO)<=0){
			SC.say("提示","发放积分不能少于0");
			return false;
		}
		if(null==payDateItem.getValue()){
			SC.say("提示","申请时间不能为空");
			return false;
		}
		if(null==auditingTimeItem.getValue()){
			SC.say("提示","发放时间不能为空");
			return false;
		}
		if(null==remarkItem.getValue()){
			SC.say("提示","申请缘由不能为空");
			return false;
		}
		return true;
	}

	@Override
	public Map getValuesAsMap() {
		return __form.getValues();
	}

	public TextItem getBonusPaymentRecordIdItem() {
		return bonusPaymentRecordIdItem;
	}

	public SelectItem getPlateIdItem() {
		return plateIdItem;
	}

	public TextItem getPayIntegralItem() {
		return payIntegralItem;
	}

	public DateItem getPayDateItem() {
		return payDateItem;
	}

	public TextAreaItem getRemarkItem() {
		return remarkItem;
	}


	public DateItem getApplyTimeItem() {
		return applyTimeItem;
	}


	

}
