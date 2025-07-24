package com.pomplatform.client.contractchange.form;

import java.math.BigDecimal;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.contractchange.datasource.DSChangeContractInfo;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.DoubleItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;

public class ChangeContractInfoNewForm extends AbstractWizadPage
{


	private final TextItem contractIdItem;
	private final TextItem contractCodeItem;
	private final DoubleItem contractAmountItem;
	private final DoubleItem contractChangeAmountItem;
	private final DoubleItem contractFinalAmountItem;
	private final TextItem contractChangeViewItem;
	private final TextItem flagItem;
	private final TextItem operateEmployeeIdItem;
	private final DateTimeItem operateTimeItem;
	private final TextAreaItem remarkItem;
	private BigDecimal contractAmount;

	public ChangeContractInfoNewForm() {
		setLayoutLeftMargin(25);
		setLayoutRightMargin(25);
		setLayoutTopMargin(15);
		
		DSChangeContractInfo ds = DSChangeContractInfo.getInstance();
		
		__form.setWidth100();
		__form.setHeight100();
		
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		contractCodeItem.setDisabled(true);
		contractCodeItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(contractCodeItem);
		
		contractIdItem = new TextItem("contractId", "合同");
		contractIdItem.setWidth("*");
		contractIdItem.setTextBoxStyle("customInputTextStyle");
		contractIdItem.setDisabled(true);
//		contractIdItem.setValueMap(KeyValueManager.getValueMap("contracts_1"));
		KeyValueManager.loadValueMap("contracts_1", contractIdItem);
		__formItems.add(contractIdItem);
		
		contractAmountItem = new DoubleItem("contractAmount", "合同金额");
		contractAmountItem.setWidth("*");
		contractAmountItem.setTextBoxStyle("customInputTextStyle");
		contractAmountItem.setDisabled(true);
		contractAmountItem.setLength(18);
		contractAmountItem.setDecimalPad(2);
		contractAmountItem.setFormat("#,###,###,###,###,##0.00");
		__formItems.add(contractAmountItem);
		
		contractChangeAmountItem = new DoubleItem("contractChangeAmount", "合同变更金额");
		contractChangeAmountItem.setWidth("*");
		contractChangeAmountItem.setTextBoxStyle("customInputTextStyle");
		contractChangeAmountItem.setLength(18);
		contractChangeAmountItem.setDecimalPad(2);
		contractChangeAmountItem.setFormat("#,###,###,###,###,##0.00");
		contractChangeAmountItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				if(null == event.getValue()){
					contractChangeAmountItem.setValue(0);
					contractFinalAmountItem.setValue(contractAmount);
				}else{
					BigDecimal value = new BigDecimal(event.getValue().toString()).setScale(2, BigDecimal.ROUND_DOWN);
					contractFinalAmountItem.setValue(contractAmount.add(value));
					contractChangeAmountItem.setValue(value);
				}
			}
		});
		__formItems.add(contractChangeAmountItem);
		
		contractFinalAmountItem = new DoubleItem("contractFinalAmount", "合同变更后金额");
		contractFinalAmountItem.setWidth("*");
		contractFinalAmountItem.setTextBoxStyle("customInputTextStyle");
		contractFinalAmountItem.setLength(18);
		contractFinalAmountItem.setDecimalPad(2);
		contractFinalAmountItem.setFormat("#,###,###,###,###,##0.00");
		contractFinalAmountItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				if(null == event.getValue()){
					contractFinalAmountItem.setValue(0);
					contractChangeAmountItem.setValue(contractAmount);
				}else{
					BigDecimal value = new BigDecimal(event.getValue().toString()).setScale(2, BigDecimal.ROUND_DOWN);
					contractChangeAmountItem.setValue(value.subtract(contractAmount));
					contractFinalAmountItem.setValue(value);
				}
			}
		});
		__formItems.add(contractFinalAmountItem);
		
		contractChangeViewItem = new TextItem("contractChangeView", "金额变更显示");
		contractChangeViewItem.hide();
		__formItems.add(contractChangeViewItem);
		
		flagItem = new TextItem("flag", "状态");
		flagItem.hide();
		__formItems.add(flagItem);
		
		operateEmployeeIdItem = new TextItem("operateEmployeeId", "操作人");
		operateEmployeeIdItem.setDefaultValue(ClientUtil.getUserId());
		operateEmployeeIdItem.hide();
		__formItems.add(operateEmployeeIdItem);
		
		operateTimeItem = new DateTimeItem("operateTime", "操作时间");
		operateTimeItem.hide();
		__formItems.add(operateTimeItem);
		
		remarkItem = new TextAreaItem("remark", "备注");
		remarkItem.setWidth("*");
		remarkItem.setColSpan(4);
		remarkItem.setRowSpan(2);
		remarkItem.setTextBoxStyle("customTextAreaStyle");
		__formItems.add(remarkItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(2);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		__form.setCellPadding(15);
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
			//获取合同编号
			String contractCode = BaseHelpUtils.getString(record.getAttribute("contractCode"));
			contractAmount = new BigDecimal(record.getAttribute("contractAmount"));
			contractCodeItem.setDefaultValue(contractCode);
		}
		else __form.editNewRecord();
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSChangeContractInfo.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		Map map = __form.getValues();
		if(map.containsKey("contractChangeAmount") && null != map.get("contractChangeAmount")){
			StringBuilder sb = new StringBuilder();
			sb.append(contractAmount).append("(");
			BigDecimal change = new BigDecimal(map.get("contractChangeAmount").toString());
			if(change.compareTo(BigDecimal.ZERO) >= 0){
				sb.append("+");
			}
			sb.append(change).append(")→");
			sb.append(contractFinalAmountItem.getValue());
			map.put("contractChangeView", sb.toString());
		}
		return map;
	}


}
