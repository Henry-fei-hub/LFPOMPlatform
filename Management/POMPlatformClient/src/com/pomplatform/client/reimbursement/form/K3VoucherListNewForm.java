package com.pomplatform.client.reimbursement.form;

import java.math.BigDecimal;
import java.util.Date;
import java.util.logging.Logger;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.reimbursement.datasource.DSK3VoucherList;
import com.pomplatform.client.selectgrid.datasource.DSSelectGridProjectValue;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGridField;

public class K3VoucherListNewForm extends AbstractWizadPage
{


	private final ComboBoxItem projectIdItem;
	private final SelectItem companyIdItem;
	private final TextItem sequenceNumberItem;
	private final TextItem internalSequenceNumberItem;
	private final TextItem codeItem;
	private final TextItem nameItem;
	private final TextItem secondaryCodeItem;
	private final TextItem secondaryNameItem;
	private final TextItem remarkItem;
	private final TextItem simplifyRemarkItem;
	private final TextItem debitSideItem;
	private final TextItem creditSideItem;
	private final TextItem reimbursementPackageCodeItem;
	private final TextItem amountOfReimbursementItem;
	private final TextItem inputTaxItem;
	private final TextItem selfBankAccountItem;
	private final TextItem otherBankAccountItem;
	private final CheckboxItem needToChangeItem;
	private final DateItem vestingDateItem;
	private final CheckboxItem lockedItem;
	private final DateTimeItem createTimeItem;
	private final DateTimeItem updateTimeItem;
	private final DateTimeItem lockedTimeItem;

	public K3VoucherListNewForm() {
		DSK3VoucherList ds = DSK3VoucherList.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		
		//项目信息字段
		ListGridField projectIdField = new ListGridField("projectId");
		ListGridField contractCodeField = new ListGridField("contractCode");
		ListGridField projectNameField = new ListGridField("projectName");
		projectIdItem = new ComboBoxItem("projectId", "项目");
		projectIdItem.setWidth("*");
		projectIdItem.setChangeOnKeypress(false);
		projectIdItem.setOptionDataSource(DSSelectGridProjectValue.getInstance());
		projectIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		projectIdItem.setValueField(projectIdField.getName());
		projectIdItem.setDisplayField(projectNameField.getName());
		projectIdItem.setPickListFields(projectIdField, projectNameField, contractCodeField);
		__formItems.add(projectIdItem);
		
		companyIdItem = new SelectItem("companyId", "归属公司");
		companyIdItem.setDisabled(true);
		companyIdItem.setWidth("*");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		__formItems.add(companyIdItem);
		
		sequenceNumberItem = new TextItem("sequenceNumber", "凭证号");
		sequenceNumberItem.setDisabled(true);
		sequenceNumberItem.setWidth("*");
		__formItems.add(sequenceNumberItem);
		
		internalSequenceNumberItem = new TextItem("internalSequenceNumber", "凭证内序号");
		internalSequenceNumberItem.setWidth("*");
		internalSequenceNumberItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				if(null == event.getValue()){
					internalSequenceNumberItem.setValue(internalSequenceNumber);
				}else{
					int num = ClientUtil.checkAndGetIntValue(event.getValue());
					if(num < 0 || num > internalSequenceNumber){
						SC.say("凭证内序号只能填写0~" + internalSequenceNumber + "之间的整数");
						internalSequenceNumberItem.setValue(internalSequenceNumber);
					}else{
						internalSequenceNumberItem.setValue(num);
					}
				}
			}
		});
		__formItems.add(internalSequenceNumberItem);
		
		codeItem = new TextItem("code", "科目代码");
		codeItem.setWidth("*");
		__formItems.add(codeItem);
		
		nameItem = new TextItem("name", "科目名称");
		nameItem.setWidth("*");
		__formItems.add(nameItem);
		
		secondaryCodeItem = new TextItem("secondaryCode", "辅助核算代码");
		secondaryCodeItem.setWidth("*");
		__formItems.add(secondaryCodeItem);
		
		secondaryNameItem = new TextItem("secondaryName", "辅助核算名称");
		secondaryNameItem.setWidth("*");
		__formItems.add(secondaryNameItem);
		
		remarkItem = new TextItem("remark", "备注");
		remarkItem.setWidth("*");
		__formItems.add(remarkItem);
		
		simplifyRemarkItem = new TextItem("simplifyRemark", "简化备注");
		simplifyRemarkItem.setWidth("*");
		__formItems.add(simplifyRemarkItem);
		
		debitSideItem = new TextItem("debitSide", "借方");
		debitSideItem.setWidth("*");
		debitSideItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				numberFormat(event);
			}
		});
		__formItems.add(debitSideItem);
		
		creditSideItem = new TextItem("creditSide", "贷方");
		creditSideItem.setWidth("*");
		creditSideItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				numberFormat(event);
			}
		});
		__formItems.add(creditSideItem);
		
		reimbursementPackageCodeItem = new TextItem("reimbursementPackageCode", "报销汇总编号");
		reimbursementPackageCodeItem.setWidth("*");
		reimbursementPackageCodeItem.setDisabled(true);
		__formItems.add(reimbursementPackageCodeItem);
		
		amountOfReimbursementItem = new TextItem("amountOfReimbursement", "报销金额");
		amountOfReimbursementItem.setWidth("*");
		amountOfReimbursementItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				numberFormat(event);
			}
		});
		__formItems.add(amountOfReimbursementItem);
		
		inputTaxItem = new TextItem("inputTax", "进项税");
		inputTaxItem.setWidth("*");
		inputTaxItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				numberFormat(event);
			}
		});
		__formItems.add(inputTaxItem);
		
		selfBankAccountItem = new TextItem("selfBankAccount", "我方银行账号");
		selfBankAccountItem.setWidth("*");
		__formItems.add(selfBankAccountItem);
		
		otherBankAccountItem = new TextItem("otherBankAccount", "对方银行账号");
		otherBankAccountItem.setWidth("*");
		__formItems.add(otherBankAccountItem);
		
		needToChangeItem = new CheckboxItem("needToChange", "需要调整");
		__formItems.add(needToChangeItem);
		
		vestingDateItem = new DateItem("vestingDate", "归属日期");
		vestingDateItem.setWidth("*");
		vestingDateItem.setDisabled(true);
		vestingDateItem.setUseMask(true);
		vestingDateItem.hide();
		__formItems.add(vestingDateItem);
		
		lockedItem = new CheckboxItem("locked", "是否锁定");
		lockedItem.hide();
		__formItems.add(lockedItem);
		
		createTimeItem = new DateTimeItem("createTime", "创建时间");
		createTimeItem.setDefaultValue(new Date());
		createTimeItem.hide();
		__formItems.add(createTimeItem);
		
		updateTimeItem = new DateTimeItem("updateTime", "修改时间");
		updateTimeItem.hide();
		__formItems.add(updateTimeItem);
		
		lockedTimeItem = new DateTimeItem("lockedTime", "定稿时间");
		lockedTimeItem.hide();
		__formItems.add(lockedTimeItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public void startEdit() {
		if(getRecord() != null){ 
			Record record = getRecord();
			__form.editRecord(record);
			internalSequenceNumber = ClientUtil.checkAndGetIntValue(record.getAttribute("internalSequenceNumber"));
		}else{
			__form.editNewRecord();
		}
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSK3VoucherList.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}

	private int internalSequenceNumber = 0;
	
	public void numberFormat(ChangedEvent event){
		if(null == event.getValue()){
			event.getItem().setValue(0);
		}else{
			BigDecimal value = new BigDecimal(event.getValue().toString()).setScale(2, BigDecimal.ROUND_DOWN);
			event.getItem().setValue(value);
		}
	}
private static final Logger logger = Logger.getLogger("");
}
