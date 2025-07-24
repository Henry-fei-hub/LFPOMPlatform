package com.pomplatform.client.ja.ht.panel;

import java.util.Map;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.project.datasource.DSOnBidSheetProject;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.BooleanItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.DoubleItem;
import com.smartgwt.client.widgets.form.fields.IntegerItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.form.validator.IsStringValidator;
import com.smartgwt.client.widgets.form.validator.LengthRangeValidator;

public class BidPaySheetProjectNewForm extends AbstractWizadPage
{
	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;
	private final TextItem projectCodeItem;
	private final TextItem projectNameItem;
	private final DoubleItem signingMoneySumItem;
	private final DateItem bidDateItem;
	private final SelectItem bidClassTypeItem;
	private final IntegerItem bidUnitNumItem;
	private final TextItem ourOrderItem;
	private final DoubleItem bigPayAmountItem;
	private final BooleanItem bigIsAchieveAmountItem;
	private final DoubleItem bigAdvanceAmountItem;
	
	private final TextAreaItem remarkItem;

	public BidPaySheetProjectNewForm() {
		DSOnBidSheetProject ds = DSOnBidSheetProject.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setDisabled(true);
		contractCodeItem.setWidth("*");
		__formItems.add(contractCodeItem);
		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setDisabled(true);
		contractNameItem.setWidth("*");
		__formItems.add(contractNameItem);
		projectCodeItem = new TextItem("projectCode", "订单编号");
		projectCodeItem.setDisabled(true);
		projectCodeItem.setWidth("*");
		__formItems.add(projectCodeItem);
		projectNameItem = new TextItem("projectName", "订单名称");
		projectNameItem.setWidth("*");
		projectNameItem.setDisabled(true);
		projectNameItem.setWidth("*");
		__formItems.add(projectNameItem);
		
		signingMoneySumItem = new DoubleItem("signingMoneySum", "投标金额");
		signingMoneySumItem.setWidth("*");
		__formItems.add(signingMoneySumItem);
		
		bidDateItem = new DateItem("bidDate","投标日期");
		bidDateItem.setWidth("*");
		bidDateItem.setUseTextField(true);
		__formItems.add(bidDateItem);
		
		bidClassTypeItem = new SelectItem("bidClassType","投标类型");
		bidClassTypeItem.setWidth("*");
		bidClassTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_129"));
		__formItems.add(bidClassTypeItem);
		
		bidUnitNumItem = new IntegerItem("bidUnitNum","投标单位总数");
		bidUnitNumItem.setWidth("*");
		__formItems.add(bidUnitNumItem);
		
		ourOrderItem = new TextItem("ourOrder","我方排名");
		ourOrderItem.setWidth("*");
		__formItems.add(ourOrderItem);
		
		bigPayAmountItem = new DoubleItem("bigPayAmount","落标补偿金");
		bigPayAmountItem.setWidth("*");
		__formItems.add(bigPayAmountItem);
		
		bigIsAchieveAmountItem = new BooleanItem("bigIsAchieveAmount","是否收到落标补偿");
		bigIsAchieveAmountItem.setWidth("*");
		__formItems.add(bigIsAchieveAmountItem);
		bigIsAchieveAmountItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				boolean value = (Boolean)event.getValue();
				if(value){
					bigAdvanceAmountItem.show();
				}else{
					bigAdvanceAmountItem.hide();
				}
			}
		});
		
		bigAdvanceAmountItem = new DoubleItem("bigAdvanceAmount","甲方补偿金额");
		bigAdvanceAmountItem.setWidth("*");
		bigAdvanceAmountItem.hide();
		__formItems.add(bigAdvanceAmountItem);
		
		
		remarkItem = new TextAreaItem("remark", "备注");
		remarkItem.setWidth("*");
		remarkItem.setRowSpan(3);
		remarkItem.setColSpan(4);
		remarkItem.setRequired(true);
		IsStringValidator remarkValidator = new IsStringValidator();
		LengthRangeValidator remarkLengthValidator = new LengthRangeValidator();
		remarkLengthValidator.setMax(512);
		remarkItem.setValidators(remarkValidator, remarkLengthValidator);
		__formItems.add(remarkItem);
		
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
		Record record = getRecord();
		if(getRecord() != null) {
			__form.editRecord(record);
		}
		else __form.editNewRecord();
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSOnBidSheetProject.getInstance());
		manager.addMember(__form);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public java.util.Map getValuesAsMap() {
		Map map = __form.getValues();
		map.put("operator", ClientUtil.getUserId());
		return map;
	}
}
