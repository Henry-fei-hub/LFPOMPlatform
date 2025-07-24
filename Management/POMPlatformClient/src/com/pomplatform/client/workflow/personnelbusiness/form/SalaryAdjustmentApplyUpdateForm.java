package com.pomplatform.client.workflow.personnelbusiness.form;

import java.math.BigDecimal;
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
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.DoubleItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.VLayout;

public class SalaryAdjustmentApplyUpdateForm extends AbstractWizadPage
{

	private final ComboBoxItem employeeIdItem;
	private final TextItem employeeNoItem;
	private final TextItem departmentIdItem;
	private final TextItem companyIdItem;
	private final SelectItem typeItem;
	private final DateItem changeDateItem;
	private final TextItem dutyIdItem;
	private final DoubleItem monthPayItem;
	private final DoubleItem originalPayItem;
	private final TextAreaItem remarkItem;
	private final VLayout mainLayout;
	private final DoubleItem severanceItem;
	private final TextItem subTypeItem;

	public SalaryAdjustmentApplyUpdateForm() {
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
		
		employeeIdItem = new ComboBoxItem("employeeId", "调薪员工姓名");
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
		typeItem.setCanEdit(false);
		typeItem.setDisabled(true);
		__formItems.add(typeItem);

		departmentIdItem = new TextItem("departmentId", "所在部门");
		departmentIdItem.setDisabled(true);
		departmentIdItem.setWidth("*");
		departmentIdItem.setTextBoxStyle("customInputTextStyle");
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		__formItems.add(departmentIdItem);
		
		changeDateItem = new DateItem("endDate", "调薪日期");
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
		
		originalPayItem = new DoubleItem("originalPay", "现薪资");
		originalPayItem.setWidth("*");
		originalPayItem.setTextBoxStyle("customInputTextStyle");
		originalPayItem.setLength(18);
		originalPayItem.setDecimalPad(2);
		originalPayItem.setFormat("#,###,###,###,###,##0.00");
		originalPayItem.setDisabled(true);
		__formItems.add(originalPayItem);
		
		severanceItem = new DoubleItem("severance", "本次调薪金额");
		severanceItem.setTextBoxStyle("customInputTextStyle");
		severanceItem.setLength(18);
		severanceItem.setDecimalPad(2);
		severanceItem.setFormat("#,###,###,###,###,##0.00");
		severanceItem.setDisabled(true);
		__formItems.add(severanceItem);
		
		monthPayItem = new DoubleItem("monthPay", "调整后薪酬总额");
		monthPayItem.setWidth("*");
		monthPayItem.setTextBoxStyle("customInputTextStyle");
		monthPayItem.setLength(18);
		monthPayItem.setDecimalPad(2);
		monthPayItem.setFormat("#,###,###,###,###,##0.00");
		monthPayItem.setDisabled(true);
		__formItems.add(monthPayItem);
		
		subTypeItem = new TextItem("subType", "调薪比例（%）");
		subTypeItem.setTextBoxStyle("customInputTextStyle");
		subTypeItem.setDisabled(true);
		__formItems.add(subTypeItem);
		
		remarkItem = new TextAreaItem("remark", "备注");
		remarkItem.setColSpan(4);
		remarkItem.setRowSpan(3);
		remarkItem.setWidth("*");
		remarkItem.setTextBoxStyle("customTextAreaStyle");
		remarkItem.setDisabled(true);
		__formItems.add(remarkItem);
		
		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		setPageMode(PAGE_MODE_UPDATE);
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
	public void startEdit() {
		Record record = getRecord();
		if(record != null){
			__form.editRecord(record);
			if(record.getAttribute("employeeId") != null && !(record.getAttribute("drafter").equals(ClientUtil.getUserId()))){
				employeeIdItem.setDisabled(true);
			}
		}else{
			__form.editNewRecord();
		}
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSSalaryAdjustmentApply.getInstance());
		manager.addMember(__form);
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
		if(null == severanceItem.getValue()){
			SC.say("请填写上本次调薪金额");
			return false;
		}
		if(null == monthPayItem.getValue()){
			SC.say("请填写上调整后薪酬总额");
			return false;
		}
		return true;
	}

	@Override
	public java.util.Map getValuesAsMap() {
		Map map = __form.getValues();
		if(map.containsKey("basicProportionStr")){
			String value = map.get("basicProportionStr").toString().replaceAll("%", "");
			BigDecimal percent = (new BigDecimal(value)).divide(new BigDecimal(100), 4, BigDecimal.ROUND_DOWN);
			map.put("basicProportion", percent);
		}
		return map;
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
	}
	
	private String processName;
	
	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public void numberFormat(Object value, FormItem item){
		if(null != value){
			BigDecimal number = new BigDecimal(value.toString()).setScale(2, BigDecimal.ROUND_DOWN);
			item.setValue(number);
		}
	}
}
