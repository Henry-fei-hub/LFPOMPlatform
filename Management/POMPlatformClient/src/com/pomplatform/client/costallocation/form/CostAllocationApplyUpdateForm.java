package com.pomplatform.client.costallocation.form;

import java.math.BigDecimal;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.costallocation.datasource.DSCostAllocationApply;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class CostAllocationApplyUpdateForm extends AbstractWizadPage
{


	private final TextItem idItem;
	private final TextItem codeItem;
	private final TextItem nameItem;
	private final TextItem costItem;
	private final TextItem linkIdItem;
	private final SelectItem processTypeItem;
	private final SelectItem businessIdItem;
	private final TextItem processIdItem;
	private final TextItem processInstanceIdItem;
	private final SelectItem drafterItem;
	private final DateTimeItem createTimeItem;
	private final TextItem deleteFlagItem;
	private final TextAreaItem reasonItem;
	private final TextItem costTypeItem;
	private final TextItem plateIdItem;
	private final TextItem currencyItem;
	private final TextItem exchangeRateItem;
	private ResetCostDetailCostAllocation panel;

	public CostAllocationApplyUpdateForm() {
		DSCostAllocationApply ds = DSCostAllocationApply.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		
		processTypeItem = new SelectItem("processType", "原报销单类型");
		processTypeItem.setCanEdit(false);
		processTypeItem.setValueMap(KeyValueManager.getValueMap("system_process_types"));
		__formItems.add(processTypeItem);
		
		costTypeItem = new TextItem("costType", "原成本类型");
		costTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_121"));
		costTypeItem.setCanEdit(false);
		__formItems.add(costTypeItem);
		
		idItem = new TextItem("id", "id");
		idItem.hide();
		__formItems.add(idItem);
		
		codeItem = new TextItem("code", "编号");
		codeItem.setCanEdit(false);
		__formItems.add(codeItem);
		
		nameItem = new TextItem("name", "名称");
		nameItem.setCanEdit(false);
		__formItems.add(nameItem);
		
		plateIdItem = new TextItem("plateId", "原承担费用的业务部门");
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));
		plateIdItem.setCanEdit(false);
		__formItems.add(plateIdItem);
		
		costItem = new TextItem("cost", "成本");
		costItem.setCanEdit(false);
		__formItems.add(costItem);
		
		currencyItem = new TextItem("currency", "货币种类");
		currencyItem.setCanEdit(false);
		currencyItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_40"));
		__formItems.add(currencyItem);
		
		exchangeRateItem = new TextItem("exchangeRate", "汇率");
		exchangeRateItem.setCanEdit(false);
		__formItems.add(exchangeRateItem);
		
		linkIdItem = new TextItem("linkId", "原报销单的成本分摊表编码");
		linkIdItem.hide();
		__formItems.add(linkIdItem);
		
		businessIdItem = new SelectItem("businessId", "原报销单的业务表编码");
		businessIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		businessIdItem.hide();
		__formItems.add(businessIdItem);
		
		processIdItem = new TextItem("processId", "原报销单的流程编码");
		processIdItem.hide();
		__formItems.add(processIdItem);
		
		processInstanceIdItem = new TextItem("processInstanceId", "原报销单的流程实例编码");
		processInstanceIdItem.hide();
		__formItems.add(processInstanceIdItem);
		
		drafterItem = new SelectItem("drafter", "起草人");
		drafterItem.setValueMap(KeyValueManager.getValueMap("employees"));
		drafterItem.setCanEdit(false);
		__formItems.add(drafterItem);
		
		reasonItem = new TextAreaItem("reason", "申请缘由");
		reasonItem.setColSpan(4);
		reasonItem.setRowSpan(2);
		__formItems.add(reasonItem);
		
		createTimeItem = new DateTimeItem("createTime", "创建时间");
		createTimeItem.hide();
		__formItems.add(createTimeItem);
		
		deleteFlagItem = new TextItem("deleteFlag", "删除标识位");
		deleteFlagItem.hide();
		__formItems.add(deleteFlagItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		FormItem[] items = getFormItemArray();
		for(FormItem item : items){
			item.setWidth("*");
		}
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		setPageMode(PAGE_MODE_UPDATE);
		addMember(__form);
	}

	@Override
	public void startEdit() {
		Record record = getRecord();
		if(record != null){
			__form.editRecord(record);
			if(null != record.getAttribute("costType") && ClientUtil.checkAndGetIntValue(record.getAttribute("costType")) == ClientStaticUtils.DEPARTMENT_COST){
				codeItem.hide();
			}
			if(null != record.getAttribute("cost")){
				panel.setTotalCost(new BigDecimal(record.getAttribute("cost")));
			}
		}else{
			__form.editNewRecord();
		}
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSCostAllocationApply.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		if(null == reasonItem.getValue()){
			SC.say("请填写申请缘由");
			return false;
		}
		return true;
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}

	public ResetCostDetailCostAllocation getPanel() {
		return panel;
	}

	public void setPanel(ResetCostDetailCostAllocation panel) {
		this.panel = panel;
	}


}
