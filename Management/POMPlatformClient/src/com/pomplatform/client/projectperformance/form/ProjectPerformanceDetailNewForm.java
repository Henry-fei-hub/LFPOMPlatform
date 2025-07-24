package com.pomplatform.client.projectperformance.form;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.projectperformance.datasource.DSProjectPerformanceDetail;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.DoubleItem;
import com.smartgwt.client.widgets.form.fields.IntegerItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;

public class ProjectPerformanceDetailNewForm extends AbstractWizadPage
{


	private final TextItem integralItem;
	private final TextItem percentItem;
	private final DoubleItem performanceIntegralItem;
	private final DateItem recordDateItem;
	private final TextItem clientComplaintItem;
	private final SelectItem reasonItem;
	private final TextAreaItem remarkItem;
	private final TextItem projectIdItem;
	private final TextItem projectCodeItem;
//	private final TextItem contractIdItem;
	private final DoubleItem deductIntegralItem;
	private final DoubleItem awardIntegralItem;
	private final DoubleItem leftIntegralItem;
	private final IntegerItem typeItem;
	private final IntegerItem performanceFlagItem;
	private final TextItem plateIdItem;
	
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";

	public ProjectPerformanceDetailNewForm() {
		setLayoutLeftMargin(25);
		setLayoutRightMargin(25);
		setLayoutTopMargin(15);
		
		DSProjectPerformanceDetail ds = DSProjectPerformanceDetail.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		
//		contractIdItem = new TextItem("contractId", "合同编号");
//		contractIdItem.setWidth("*");
//		contractIdItem.setTextBoxStyle("customInputTextStyle");
//		contractIdItem.setCanEdit(false);
//		contractIdItem.hide();
//		contractIdItem.setValueMap(KeyValueManager.getValueMap("contracts_2"));
//		__formItems.add(contractIdItem);
		
		plateIdItem = new TextItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextBoxStyle("customInputTextStyle");
		plateIdItem.setCanEdit(false);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		__formItems.add(plateIdItem);
		
		projectCodeItem = new TextItem("projectId", "订单编号");
		projectCodeItem.setWidth("*");
		projectCodeItem.setTextBoxStyle("customInputTextStyle");
		projectCodeItem.setCanEdit(false);
//		projectCodeItem.setValueMap(KeyValueManager.getValueMap("project_code"));
		KeyValueManager.loadValueMap("project_code", projectCodeItem);
		__formItems.add(projectCodeItem);
		
		projectIdItem = new TextItem("projectId", "订单名称");
		projectIdItem.setWidth("*");
		projectIdItem.setTextBoxStyle("customInputTextStyle");
		projectIdItem.setCanEdit(false);
		KeyValueManager.loadValueMap("projects",projectIdItem);
		__formItems.add(projectIdItem);
		
		integralItem = new DoubleItem("integral", "质量保证金");
		integralItem.setWidth("*");
		integralItem.setTextBoxStyle("customInputTextStyle");
		integralItem.setLength(18);
		integralItem.setDecimalPad(2);
		integralItem.setFormat("#,###,###,###,###,##0.00");
		integralItem.setCanEdit(false);
		__formItems.add(integralItem);
		
		deductIntegralItem = new DoubleItem("deductIntegral", "已扣积分");
		deductIntegralItem.setWidth("*");
		deductIntegralItem.setTextBoxStyle("customInputTextStyle");
		deductIntegralItem.setLength(18);
		deductIntegralItem.setDecimalPad(2);
		deductIntegralItem.setFormat("#,###,###,###,###,##0.00");
		deductIntegralItem.setCanEdit(false);
		__formItems.add(deductIntegralItem);
		
		awardIntegralItem = new DoubleItem("awardIntegral", "已奖积分");
		awardIntegralItem.setWidth("*");
		awardIntegralItem.setTextBoxStyle("customInputTextStyle");
		awardIntegralItem.setLength(18);
		awardIntegralItem.setDecimalPad(2);
		awardIntegralItem.setFormat("#,###,###,###,###,##0.00");
		awardIntegralItem.setCanEdit(false);
		__formItems.add(awardIntegralItem);
		
		leftIntegralItem = new DoubleItem("leftIntegral", "剩余积分");
		leftIntegralItem.setWidth("*");
		leftIntegralItem.setTextBoxStyle("customInputTextStyle");
		leftIntegralItem.setLength(18);
		leftIntegralItem.setDecimalPad(2);
		leftIntegralItem.setFormat("#,###,###,###,###,##0.00");
		leftIntegralItem.setCanEdit(false);
		__formItems.add(leftIntegralItem);
		
		percentItem = new DoubleItem("percent", shouldNotBeNull + "奖励比例(%)");
		percentItem.setWidth("*");
		percentItem.setTextBoxStyle("customInputTextStyle");
		percentItem.setLength(18);
		percentItem.setDecimalPad(4);
		percentItem.setFormat("##,###,###,###,##0.000,0");
		percentItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				typeItem.setValue(0);
				if(null == event.getValue()){
					percentItem.setValue(0);
					performanceIntegralItem.setValue(0);
				}else{
					BigDecimal value = new BigDecimal(event.getValue().toString()).setScale(4, BigDecimal.ROUND_DOWN);
					performanceIntegralItem.setValue(value.multiply(new BigDecimal(integralItem.getValue().toString())).divide(new BigDecimal(100), 2, BigDecimal.ROUND_DOWN));
					percentItem.setValue(value);
				}
			}
		});
		__formItems.add(percentItem);
		
		performanceIntegralItem = new DoubleItem("performanceIntegral", shouldNotBeNull + "绩效奖励");
		performanceIntegralItem.setWidth("*");
		performanceIntegralItem.setTextBoxStyle("customInputTextStyle");
		performanceIntegralItem.setLength(18);
		performanceIntegralItem.setDecimalPad(2);
		performanceIntegralItem.setFormat("#,###,###,###,###,##0.00");
		performanceIntegralItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				typeItem.setValue(1);
				if(null == event.getValue()){
					percentItem.setValue(0);
					performanceIntegralItem.setValue(0);
				}else{
					BigDecimal value = new BigDecimal(event.getValue().toString()).setScale(2, BigDecimal.ROUND_DOWN);
					percentItem.setValue((null == integralItem.getValue() || (null != integralItem.getValue() && new BigDecimal(integralItem.getValue().toString()).compareTo(BigDecimal.ZERO) == 0)) ? 0 : value.multiply(new BigDecimal(100)).divide(new BigDecimal(integralItem.getValue().toString()), 4, BigDecimal.ROUND_DOWN));
					performanceIntegralItem.setValue(value);
				}
			}
		});
		__formItems.add(performanceIntegralItem);
		
		recordDateItem = new DateItem("recordDate", shouldNotBeNull + "日期");
		recordDateItem.setWidth("*");
		recordDateItem.setCanEdit(false);
		recordDateItem.setDefaultValue(new Date());
		recordDateItem.setTextBoxStyle("customInputTextStyle");
		recordDateItem.setUseMask(true);
		__formItems.add(recordDateItem);
		
		clientComplaintItem = new TextItem("clientComplaint", "客户投诉");
		clientComplaintItem.setWidth("*");
		clientComplaintItem.hide();
		clientComplaintItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(clientComplaintItem);
		
		reasonItem = new SelectItem("reason", shouldNotBeNull + "惩罚原因");
		reasonItem.setWidth("*");
		reasonItem.hide();
		reasonItem.setControlStyle("customInputTextStyle");
		reasonItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_84"));
		__formItems.add(reasonItem);
		
		remarkItem = new TextAreaItem("remark", shouldNotBeNull + "奖励说明(不能少于20个字)");
		remarkItem.setWidth("*");
		remarkItem.setColSpan(6);
		remarkItem.setRowSpan(2);
		remarkItem.setTextBoxStyle("customTextAreaStyle");
		__formItems.add(remarkItem);

		typeItem = new IntegerItem("type", "类型");
		typeItem.hide();
		__formItems.add(typeItem);
		
		performanceFlagItem = new IntegerItem("performanceFlag", "绩效类型");
		performanceFlagItem.hide();
		__formItems.add(performanceFlagItem);
		
		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		__form.setCellPadding(15);
		addMember(__form);
	}

	@Override
	public boolean checkData() {
		if(null == percentItem.getValue() || null == performanceIntegralItem.getValue()){
			SC.say("请填写上比例或绩效");
			return false;
		}
		if(null == recordDateItem.getValue()){
			SC.say("请填写日期");
			return false;
		}
		if(null == remarkItem.getValue()){
			SC.say("请填写说明");
			return false;
		}
		if(remarkItem.getValue().toString().length() < 20){
			SC.say("绩效说明不得少于20个字");
			return false;
		}
		return true;
	}

	@Override
	public void startEdit() {
		Record record = getRecord();
		if(record != null){
			__form.editRecord(record);
			String performanceFlag = record.getAttribute("performanceFlag");
			if(null != performanceFlag && performanceFlag.equals("1")){//惩罚
				reasonItem.show();
				remarkItem.setTitle(shouldNotBeNull + "惩罚说明(不能少于20个字)");
				percentItem.setTitle(shouldNotBeNull + "扣除比例(%)");
				performanceIntegralItem.setTitle(shouldNotBeNull + "绩效扣除");
				awardIntegralItem.hide();
			}else if(null != performanceFlag && performanceFlag.equals("2")){//奖励
				reasonItem.hide();
				remarkItem.setTitle(shouldNotBeNull + "奖励说明(不能少于20个字)");
				percentItem.setTitle(shouldNotBeNull + "奖励比例(%)");
				performanceIntegralItem.setTitle(shouldNotBeNull + "绩效奖励");
				deductIntegralItem.hide();
			}
		}else{
			__form.editNewRecord();
		}
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSProjectPerformanceDetail.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		if(checkData()){
			Map map = __form.getValues();
			map.put("businessType", 2);
			return map;
		}else{
			return null;
		}
	}

}
