package com.pomplatform.client.workflow.personnelbusiness.form;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.selectgridemployeevalue.datasource.DSSelectGridEmployeeValue;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSSalaryAdjustmentApply;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.BooleanItem;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.DoubleItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.form.fields.events.EditorExitEvent;
import com.smartgwt.client.widgets.form.fields.events.EditorExitHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.VLayout;

public class SalaryAdjustmentApplyNewForm extends AbstractWizadPage
{

	private final ComboBoxItem employeeIdItem;
	private final TextItem employeeNoItem;
	private final TextItem departmentIdItem;
	private final TextItem companyIdItem;
	private final SelectItem typeItem;
	private final DateItem changeDateItem;
	private final TextItem drafterItem;
	private final TextItem dutyIdItem;
	private final DoubleItem monthPayItem;
	private final DoubleItem foremanPayItem;
	private final DoubleItem totalPayItem;
	private final BooleanItem enabledItem;
	private final DoubleItem housingFinanceItem;
	private final VLayout mainLayout;
	private final DoubleItem feeItem;
	private final TextItem subTypeItem;

	public SalaryAdjustmentApplyNewForm() {
		mainLayout = new VLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		mainLayout.setBackgroundColor("#fff");
		mainLayout.setLayoutLeftMargin(30);
		mainLayout.setLayoutRightMargin(30);
		mainLayout.setLayoutTopMargin(15);
		
		DSSalaryAdjustmentApply ds = DSSalaryAdjustmentApply.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		
		ListGridField eNoField = new ListGridField("employeeNo");
		ListGridField eNameField = new ListGridField("employeeName");
		ListGridField departmentIdField = new ListGridField("departmentId");
		Criteria c = new Criteria();
		c.addCriteria("status", 0);
		
		employeeIdItem = new ComboBoxItem("employeeId", "调薪员工姓名(支持姓名模糊搜索)");
		employeeIdItem.setWidth("*");
		employeeIdItem.setChangeOnKeypress(false);
		employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		employeeIdItem.setOptionDataSource(DSSelectGridEmployeeValue.getInstance());
		employeeIdItem.setOptionCriteria(c);
		employeeIdItem.setValueField("employeeId");
		employeeIdItem.setDisplayField("employeeName");
		employeeIdItem.setPickListFields(eNoField, eNameField, departmentIdField);
		employeeIdItem.setControlStyle("customInputTextStyle");
		__formItems.add(employeeIdItem);
		employeeIdItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				if(null != event.getValue()){
					getUserBasicInfo(event.getValue());
				}else{
					employeeNoItem.clearValue();
					departmentIdItem.clearValue();
					companyIdItem.clearValue();
				}
			}

		});
		
		dutyIdItem = new TextItem("dutyId", "职务");
		dutyIdItem.setWidth("*");
		dutyIdItem.setTextBoxStyle("customInputTextStyle");
		dutyIdItem.setValueMap(KeyValueManager.getValueMap("duties"));
		dutyIdItem.setDisabled(true);
		__formItems.add(dutyIdItem);

		companyIdItem = new TextItem("companyId", "归属公司");
		companyIdItem.setDisabled(true);
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		companyIdItem.setTextBoxStyle("customInputTextStyle");
		companyIdItem.hide();
		__formItems.add(companyIdItem);

		typeItem = new SelectItem("type", "调薪类型");
		typeItem.setWidth("*");
		typeItem.setControlStyle("customInputTextStyle");
		typeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_95"));
		__formItems.add(typeItem);

		departmentIdItem = new TextItem("departmentId", "所在部门");
		departmentIdItem.setDisabled(true);
		departmentIdItem.setWidth("*");
		departmentIdItem.setTextBoxStyle("customInputTextStyle");
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		__formItems.add(departmentIdItem);
		
		changeDateItem = new DateItem("startDate", "调薪日期");
		changeDateItem.setWidth("*");
		changeDateItem.setUseMask(true);
		changeDateItem.setUseTextField(true);
		changeDateItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(changeDateItem);
		
		employeeNoItem = new TextItem("employeeNo", "工号");
		employeeNoItem.setDisabled(true);
		employeeNoItem.setWidth("*");
		employeeNoItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(employeeNoItem);
		
		drafterItem = new TextItem("drafter", "起草人");
		drafterItem.setDefaultValue(ClientUtil.getUserId());
		drafterItem.hide();
		__formItems.add(drafterItem);
		
		housingFinanceItem = new DoubleItem("housingFinance", "原薪资");
		housingFinanceItem.setWidth("*");
		housingFinanceItem.setTextBoxStyle("customInputTextStyle");
		housingFinanceItem.setLength(18);
		housingFinanceItem.setDecimalPad(2);
		housingFinanceItem.setFormat("#,###,###,###,###,##0.00");
		housingFinanceItem.setDisabled(true);
		__formItems.add(housingFinanceItem);
		
		feeItem = new DoubleItem("fee", "本次调薪金额");
		feeItem.setTextBoxStyle("customInputTextStyle");
		feeItem.setLength(18);
		feeItem.setDecimalPad(2);
		feeItem.setFormat("#,###,###,###,###,##0.00");
		__formItems.add(feeItem);
		feeItem.addEditorExitHandler(new EditorExitHandler() {
			
			@Override
			public void onEditorExit(EditorExitEvent event) {
				if(null != event.getValue()){
					BigDecimal fee = new BigDecimal(event.getValue().toString()).setScale(2, BigDecimal.ROUND_DOWN);
					BigDecimal housingFinance = new BigDecimal(null == housingFinanceItem.getValue()? "0" : housingFinanceItem.getValue().toString()).setScale(2, BigDecimal.ROUND_DOWN);
					BigDecimal totalPay = fee.add(housingFinance);
					BigDecimal percent = fee.multiply(new BigDecimal(100)).divide(housingFinance,2,BigDecimal.ROUND_DOWN);
					BigDecimal foremanPay = new BigDecimal(foremanPayItem.getValue().toString());
					monthPayItem.setValue(totalPay.subtract(foremanPay)); 
					totalPayItem.setValue(totalPay);
					feeItem.setValue(fee);
					subTypeItem.setValue(percent+"%");
				}else{
					totalPayItem.clearValue();
					feeItem.clearValue();
					subTypeItem.clearValue();
					monthPayItem.clearValue();
				}
				
			}
		});
		
		totalPayItem = new DoubleItem("totalPay", "调整后薪酬总额");
		totalPayItem.setWidth("*");
		totalPayItem.setTextBoxStyle("customInputTextStyle");
		totalPayItem.setLength(18);
		totalPayItem.setDecimalPad(2);
		totalPayItem.setFormat("#,###,###,###,###,##0.00");
		__formItems.add(totalPayItem);
		totalPayItem.addEditorExitHandler(new EditorExitHandler() {
			
			@Override
			public void onEditorExit(EditorExitEvent event) {
				if(null != event.getValue()){
					BigDecimal totalPay = new BigDecimal(event.getValue().toString()).setScale(2, BigDecimal.ROUND_DOWN);
					BigDecimal housingFinance = new BigDecimal(null == housingFinanceItem.getValue()? "0" : housingFinanceItem.getValue().toString()).setScale(2, BigDecimal.ROUND_DOWN);
					BigDecimal fee = totalPay.subtract(housingFinance);
					BigDecimal percent = fee.multiply(new BigDecimal(100)).divide(housingFinance,2,BigDecimal.ROUND_DOWN);
					BigDecimal foremanPay = new BigDecimal(foremanPayItem.getValue().toString());
					monthPayItem.setValue(totalPay.subtract(foremanPay));
					totalPayItem.setValue(totalPay);
					feeItem.setValue(fee);
					subTypeItem.setValue(percent+"%");
				}else{
					totalPayItem.clearValue();
					feeItem.clearValue();
					subTypeItem.clearValue();
					monthPayItem.clearValue();
				}
				
			}
		});
		
		subTypeItem = new TextItem("subType", "调薪比例");
		subTypeItem.setTextBoxStyle("customInputTextStyle");
		subTypeItem.setDisabled(true);
		__formItems.add(subTypeItem);
		
		monthPayItem = new DoubleItem("monthPay", "月薪");
		monthPayItem.setWidth("*");
		monthPayItem.setTextBoxStyle("customInputTextStyle");
		monthPayItem.setLength(18);
		monthPayItem.setDecimalPad(2);
		monthPayItem.setFormat("#,###,###,###,###,##0.00");
		monthPayItem.hide();
		__formItems.add(monthPayItem);
		
		foremanPayItem = new DoubleItem("foremanPay", "工龄工资");
		foremanPayItem.setWidth("*");
		foremanPayItem.setTextBoxStyle("customInputTextStyle");
		foremanPayItem.setLength(18);
		foremanPayItem.setDecimalPad(2);
		foremanPayItem.setFormat("#,###,###,###,###,##0.00");
		foremanPayItem.hide();
		__formItems.add(foremanPayItem);
		
		enabledItem = new BooleanItem("enabled", "该工资记录是否可用");
		enabledItem.setDefaultValue(false);
		enabledItem.hide();
		__formItems.add(enabledItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		__form.setCellPadding(10);
		mainLayout.addMember(__form);
		addMember(mainLayout);
		FormItem[] items = __form.getFields();
		int width = (mainLayout.getWidth()-30)/23*10;
		int width2 = width * 7 / 10;
		mainLayout.setLayoutLeftMargin(width * 3 / 10 + 10);
		mainLayout.setLayoutRightMargin(0);
		for(FormItem item : items){
			item.setWidth(width2);
		}
	}

	@Override
	public boolean checkData() {
		if(null == typeItem.getValue()){
			SC.say("请选择调薪类型");
			return false;
		}
		if(null == employeeIdItem.getValue()){
			SC.say("请填写上调薪员工姓名");
			return false;
		}
		if(null == changeDateItem.getValue()){
			SC.say("请填写上调薪日期");
			return false;
		}
		if(null == feeItem.getValue()){
			SC.say("请填写上本次调薪金额");
			return false;
		}
		if(null == totalPayItem.getValue()){
			SC.say("请填写上调整后薪酬总额");
			return false;
		}
		return true;
	}

	@Override
	public void startEdit() {
		Record record = getRecord();
		if(record != null){
			__form.editRecord(record);
			if(record.getAttribute("employeeId") != null){
				employeeIdItem.setDisabled(true);
				getUserBasicInfo(record.getAttribute("employeeId"));
			}
		}
		else __form.editNewRecord();
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSSalaryAdjustmentApply.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}

	public void getUserBasicInfo(Object employeeId) {
		Map<String, Object> params = new HashMap<>();
		params.put("optType", "getBasicInfo");
		params.put("employeeId", employeeId);
		DBDataSource.callOperation("EP_GetUserInfoById", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					Record record = dsResponse.getData()[0];
					if(null != record){
						if(null != record.getAttribute("employeeNo")){
							employeeNoItem.setValue(record.getAttribute("employeeNo"));
						}
						if(null != record.getAttribute("departmentId")){
							departmentIdItem.setValue(record.getAttribute("departmentId"));
						}
						if(null != record.getAttribute("companyId")){
							companyIdItem.setValue(record.getAttribute("companyId"));
						}
						if(null != record.getAttribute("dutyId")){
							dutyIdItem.setValue(record.getAttribute("dutyId"));
						}
					}
				}else{
					ClientUtil.displayErrorMessage(dsResponse);
				}
			}
		});
		params.put("optType", "getSalary");
		DBDataSource.callOperation("EP_GetUserInfoById", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					Record record = dsResponse.getData()[0];
					if(null != record){
						if(null != record.getAttribute("monthPay")){
							housingFinanceItem.setValue(record.getAttribute("monthPay"));
						}
					}
				}else{
					ClientUtil.displayErrorMessage(dsResponse);
				}
			}
		});
		Date date = new Date();
		params.put("year", date.getYear() + 1900);
		params.put("month", date.getMonth() + 1);
		DBDataSource.callOperation("ST_SalaryOfWorkYear", "find", params, new DSCallback() {
			
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					Record record = dsResponse.getData()[0];
					if(null != record && null != record.getAttribute("workMoney")){
						foremanPayItem.setValue(record.getAttribute("workMoney"));
					}
				}
			}
		});
	}
	
	public void numberFormat(Object value, FormItem item){
		if(null != value){
			BigDecimal number = new BigDecimal(value.toString()).setScale(2, BigDecimal.ROUND_DOWN);
			item.setValue(number);
		}
	}
}
