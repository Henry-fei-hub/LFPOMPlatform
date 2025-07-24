package com.pomplatform.client.contractchange.form;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.common.SyncDataUtil;
import com.pomplatform.client.contractchange.datasource.DSChangeProjectInfo;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.DoubleItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;

public class ChangeProjectInfoNewForm extends AbstractWizadPage
{


	private final TextItem projectIdItem;
	private final TextItem contractCodeItem;
	private final DoubleItem sheetAmountItem;
	private final DoubleItem sheetChangeAmountItem;
	private final DoubleItem sheetFinalAmountItem;
	private final TextItem sheetChangeViewItem;
	private final DoubleItem totalIntegralItem;
	private final DoubleItem totalChangeIntegralItem;
	private final DoubleItem totalFinalIntegralItem;
	private final TextItem totalChangeViewItem;
	private final DoubleItem commonAreaItem;
	private final DoubleItem logisticsAreaItem;
	private final DoubleItem designAreaItem;
	private final TextItem complaintPercentageItem;
	private final TextItem complaintIntegralItem;
	private final TextItem flagItem;
	private final TextItem operateEmployeeIdItem;
	private final DateTimeItem operateTimeItem;
	private final TextAreaItem remarkItem;
	private BigDecimal sheetAmount;
	private BigDecimal totalIntegral;

	public ChangeProjectInfoNewForm() {
		setLayoutLeftMargin(25);
		setLayoutRightMargin(25);
		setLayoutTopMargin(15);
		
		DSChangeProjectInfo ds = DSChangeProjectInfo.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		
		contractCodeItem = new TextItem("contractCode", "订单编号");
		contractCodeItem.setWidth("*");
		contractCodeItem.setTextBoxStyle("customInputTextStyle");
		contractCodeItem.setDisabled(true);
		__formItems.add(contractCodeItem);
		
		projectIdItem = new TextItem("projectId", "订单名称");
		projectIdItem.setWidth("*");
		projectIdItem.setTextBoxStyle("customInputTextStyle");
		projectIdItem.setDisabled(true);
//		KeyValueManager.loadValueMap("projects",projectIdItem);
		KeyValueManager.loadValueMap("projects",projectIdItem);
		__formItems.add(projectIdItem);
		
		commonAreaItem = new DoubleItem("commonArea", "公区面积");
		commonAreaItem.setWidth("*");
		commonAreaItem.setTextBoxStyle("customInputTextStyle");
		commonAreaItem.setLength(18);
		commonAreaItem.setDecimalPad(2);
		commonAreaItem.setFormat("#,###,###,###,###,##0.00");
		commonAreaItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				numberFormat(event);
			}
		});
		__formItems.add(commonAreaItem);
		
		sheetAmountItem = new DoubleItem("sheetAmount", "订单合同金额");
		sheetAmountItem.setWidth("*");
		sheetAmountItem.setTextBoxStyle("customInputTextStyle");
		sheetAmountItem.setDisabled(true);
		sheetAmountItem.setLength(18);
		sheetAmountItem.setDecimalPad(2);
		sheetAmountItem.setFormat("#,###,###,###,###,##0.00");
		__formItems.add(sheetAmountItem);
		
		totalIntegralItem = new DoubleItem("totalIntegral", "订单总积分");
		totalIntegralItem.setWidth("*");
		totalIntegralItem.setTextBoxStyle("customInputTextStyle");
		totalIntegralItem.setDisabled(true);
		totalIntegralItem.setLength(18);
		totalIntegralItem.setDecimalPad(2);
		totalIntegralItem.setFormat("#,###,###,###,###,##0.00");
		__formItems.add(totalIntegralItem);
		
		logisticsAreaItem = new DoubleItem("logisticsArea", "后勤面积");
		logisticsAreaItem.setWidth("*");
		logisticsAreaItem.setTextBoxStyle("customInputTextStyle");
		logisticsAreaItem.setLength(18);
		logisticsAreaItem.setDecimalPad(2);
		logisticsAreaItem.setFormat("#,###,###,###,###,##0.00");
		logisticsAreaItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				numberFormat(event);
			}
		});
		__formItems.add(logisticsAreaItem);
		
		sheetChangeAmountItem = new DoubleItem("sheetChangeAmount", "订单合同变更金额");
		sheetChangeAmountItem.setWidth("*");
		sheetChangeAmountItem.setTextBoxStyle("customInputTextStyle");
		sheetChangeAmountItem.setLength(18);
		sheetChangeAmountItem.setDecimalPad(2);
		sheetChangeAmountItem.setFormat("#,###,###,###,###,##0.00");
		sheetChangeAmountItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				if(null == event.getValue()){
					sheetChangeAmountItem.setValue(0);
					sheetFinalAmountItem.setValue(sheetAmount);
				}else{
					BigDecimal value = new BigDecimal(event.getValue().toString()).setScale(2, BigDecimal.ROUND_DOWN);
					sheetFinalAmountItem.setValue(sheetAmount.add(value));
					sheetChangeAmountItem.setValue(value);
				}
			}
		});
		__formItems.add(sheetChangeAmountItem);
		
		totalChangeIntegralItem = new DoubleItem("totalChangeIntegral", "订单变更积分");
		totalChangeIntegralItem.setWidth("*");
		totalChangeIntegralItem.setTextBoxStyle("customInputTextStyle");
		totalChangeIntegralItem.setLength(18);
		totalChangeIntegralItem.setDecimalPad(2);
		totalChangeIntegralItem.setFormat("#,###,###,###,###,##0.00");
		totalChangeIntegralItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				if(null == event.getValue()){
					totalChangeIntegralItem.setValue(0);
					totalFinalIntegralItem.setValue(totalIntegral);
				}else{
					BigDecimal value = new BigDecimal(event.getValue().toString()).setScale(2, BigDecimal.ROUND_DOWN);
					totalFinalIntegralItem.setValue(totalIntegral.add(value));
					totalChangeIntegralItem.setValue(value);
				}
			}
		});
		__formItems.add(totalChangeIntegralItem);
		
		designAreaItem = new DoubleItem("designArea", "设计面积");
		designAreaItem.setWidth("*");
		designAreaItem.setTextBoxStyle("customInputTextStyle");
		designAreaItem.setLength(18);
		designAreaItem.setDecimalPad(2);
		designAreaItem.setFormat("#,###,###,###,###,##0.00");
		designAreaItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				numberFormat(event);
			}
		});
		__formItems.add(designAreaItem);
		
		sheetFinalAmountItem = new DoubleItem("sheetFinalAmount", "订单合同变更后金额");
		sheetFinalAmountItem.setWidth("*");
		sheetFinalAmountItem.setTextBoxStyle("customInputTextStyle");
		sheetFinalAmountItem.setLength(18);
		sheetFinalAmountItem.setDecimalPad(2);
		sheetFinalAmountItem.setFormat("#,###,###,###,###,##0.00");
		sheetFinalAmountItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				if(null == event.getValue()){
					sheetFinalAmountItem.setValue(0);
					sheetChangeAmountItem.setValue(sheetAmount);
				}else{
					BigDecimal value = new BigDecimal(event.getValue().toString()).setScale(2, BigDecimal.ROUND_DOWN);
					sheetChangeAmountItem.setValue(value.subtract(sheetAmount));
					sheetFinalAmountItem.setValue(value);
				}
			}
		});
		__formItems.add(sheetFinalAmountItem);
		
		totalFinalIntegralItem = new DoubleItem("totalFinalIntegral", "订单变更后总积分");
		totalFinalIntegralItem.setWidth("*");
		totalFinalIntegralItem.setTextBoxStyle("customInputTextStyle");
		totalFinalIntegralItem.setLength(18);
		totalFinalIntegralItem.setDecimalPad(2);
		totalFinalIntegralItem.setFormat("#,###,###,###,###,##0.00");
		totalFinalIntegralItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				if(null == event.getValue()){
					totalFinalIntegralItem.setValue(0);
					totalChangeIntegralItem.setValue(totalIntegral);
				}else{
					BigDecimal value = new BigDecimal(event.getValue().toString()).setScale(2, BigDecimal.ROUND_DOWN);
					totalChangeIntegralItem.setValue(value.subtract(totalIntegral));
					totalFinalIntegralItem.setValue(value);
				}
			}
		});
		__formItems.add(totalFinalIntegralItem);
		
		sheetChangeViewItem = new TextItem("sheetChangeView", "订单合同金额变更显示");
		sheetChangeViewItem.hide();
		__formItems.add(sheetChangeViewItem);
		
		totalChangeViewItem = new TextItem("totalChangeView", "订单总积分变更显示");
		totalChangeViewItem.hide();
		__formItems.add(totalChangeViewItem);
		
		complaintPercentageItem = new TextItem("complaintPercentage", "投诉保证金比例");
		complaintPercentageItem.hide();
		__formItems.add(complaintPercentageItem);
		
		complaintIntegralItem = new TextItem("complaintIntegral", "投诉保证金");
		complaintIntegralItem.hide();
		__formItems.add(complaintIntegralItem);
		
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
		remarkItem.setColSpan(6);
		remarkItem.setRowSpan(2);
		remarkItem.setTextBoxStyle("customTextAreaStyle");
		__formItems.add(remarkItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(6);
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
			sheetAmount = new BigDecimal(record.getAttribute("sheetAmount"));
			totalIntegral = new BigDecimal(record.getAttribute("totalIntegral"));
//			contractCodeItem.setDefaultValue(KeyValueManager.getValue("project_contract_codes", record.getAttribute("projectId")));
			//获取合同编号
			String contractCode = SyncDataUtil.getContractCode(BaseHelpUtils.getIntValue(record.getAttribute("projectId")));
//			Record record1 = getProjectName(BaseHelpUtils.getIntValue(record.getAttribute("projectId")));
//			String contractCode = BaseHelpUtils.getString(record1.getAttribute("contractCode"));
			contractCodeItem.setDefaultValue(contractCode);
		}
		else __form.editNewRecord();
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSChangeProjectInfo.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		Map map = __form.getValues();
		if((null == sheetFinalAmountItem.getValue() && null == totalFinalIntegralItem.getValue()) || ((null != sheetFinalAmountItem.getValue() && sheetAmountItem.getValue().toString().equals(sheetFinalAmountItem.getValue().toString())) && (null != totalFinalIntegralItem.getValue()  && totalIntegralItem.getValue().toString().equals(totalFinalIntegralItem.getValue().toString())))){
			return null;
		}
		if(map.containsKey("sheetChangeAmount") && null != map.get("sheetChangeAmount")){
			StringBuilder sb = new StringBuilder();
			sb.append(sheetAmount).append("(");
			BigDecimal change = new BigDecimal(map.get("sheetChangeAmount").toString());
			if(change.compareTo(BigDecimal.ZERO) >= 0){
				sb.append("+");
			}
			sb.append(change).append(")→");
			sb.append(sheetFinalAmountItem.getValue());
			map.put("sheetChangeView", sb.toString());
		}
		if(map.containsKey("totalChangeIntegral") && null != map.get("totalChangeIntegral")){
			StringBuilder sb = new StringBuilder();
			sb.append(totalIntegral).append("(");
			BigDecimal change = new BigDecimal(map.get("totalChangeIntegral").toString());
			if(change.compareTo(BigDecimal.ZERO) >= 0){
				sb.append("+");
			}
			sb.append(change).append(")→");
			sb.append(totalFinalIntegralItem.getValue());
			map.put("totalChangeView", sb.toString());
		}
		return map;
	}
	
	public void numberFormat(ChangedEvent event) {
		if(null == event.getValue()){
			event.getItem().setValue(0);
		}else{
			BigDecimal value = new BigDecimal(event.getValue().toString()).setScale(2, BigDecimal.ROUND_DOWN);
			event.getItem().setValue(value);
		}
	}

	/**
	 * 获取项目的名称
	 * @param projectId
	 * @return
	 */
	private Record getProjectName(Integer projectId){
		Record record = new Record();
		HashMap<Object, Object> map = new HashMap<>();
		map.put("projectId",projectId);
		DBDataSource.callOperation("ST_Project", "find", map, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					Record[] records = dsResponse.getData();
					if(!BaseHelpUtils.isNullOrEmpty(records) && records.length > 0){
						//获取项目名称
						String projectName = BaseHelpUtils.getString(records[0].getAttribute("projectName"));
						record.setAttribute("projectName",projectName);
					}
				}
			}
		});
		return record;
	}
	
}
