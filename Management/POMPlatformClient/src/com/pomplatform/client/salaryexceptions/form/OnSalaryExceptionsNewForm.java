package com.pomplatform.client.salaryexceptions.form;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.salaryexceptions.datasource.DSOnSalaryExceptions;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.VLayout;

public class OnSalaryExceptionsNewForm extends AbstractWizadPage
{


	private final TextItem employeeIdItem;
	private final TextItem employeeNoItem;
	private final TextItem departmentIdItem;
	private final TextItem companyIdItem;
	private final TextAreaItem reasonItem;
	private final DateTimeItem createTimeItem;
	private final Logger __logger = Logger.getLogger("");
	private PersonnelBusinesDetailSalaryException detail = new PersonnelBusinesDetailSalaryException();

	public OnSalaryExceptionsNewForm() {
		DSOnSalaryExceptions ds = DSOnSalaryExceptions.getInstance();
		VLayout mainLayout = new VLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		VLayout topLayout = new VLayout();
		topLayout.setWidth100();
		topLayout.setHeight("15%");
		VLayout buttonLayout = new VLayout();
		buttonLayout.setWidth100();
		buttonLayout.setHeight("70%");
		employeeIdItem = new TextItem("employeeId", "申请人");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.setDefaultValue(ClientUtil.getUserId());
		employeeIdItem.setWidth("*");
		employeeIdItem.setDisabled(true);
		employeeIdItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(employeeIdItem);
		
		employeeNoItem = new TextItem("employeeNo", "工号");
		employeeNoItem.setDefaultValue(ClientUtil.getUserNo());
		employeeNoItem.setWidth("*");
		employeeNoItem.setDisabled(true);
		employeeNoItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(employeeNoItem);
		
		departmentIdItem = new TextItem("departmentId", "部门");
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		departmentIdItem.setDisabled(true);
		departmentIdItem.setDefaultValue(ClientUtil.getDepartmentId());
		departmentIdItem.setTextBoxStyle("customInputTextStyle");
		departmentIdItem.setWidth("*");
		
		__formItems.add(departmentIdItem);
		companyIdItem = new TextItem("companyId", "归属公司");
		companyIdItem.setHidden(true);
		__formItems.add(companyIdItem);
		
		
		createTimeItem = new DateTimeItem("createTime", "当前时间");
		createTimeItem.setWidth("*");
	    createTimeItem.setDefaultValue(new Date());
	    createTimeItem.setTextBoxStyle("customInputTextStyle");
	    createTimeItem.setDisabled(true);
		__formItems.add(createTimeItem);
		
		
		
		
		reasonItem = new TextAreaItem("reason", "申请缘由");
		reasonItem.setWidth("*");
		reasonItem.setRowSpan(3);
		reasonItem.setColSpan(4);
		reasonItem.setHidden(true);
		__formItems.add(reasonItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		
		topLayout.addMember(__form);
		
		buttonLayout.addMember(detail);
		mainLayout.addMember(topLayout);
		mainLayout.addMember(buttonLayout);
		addMember(mainLayout);
	}

	@Override
	//提交时对数据的检查
	public boolean checkData() {
		Map<String,List<Map<String,Object>>> map = detail.getValuesAsMap();
		List<Map<String,Object>> list = map.get("detailSalaryException");
		for (int i = 0;i < list.size();i++) {
			if(BaseHelpUtils.isNullOrEmpty(list.get(i).get("remark"))) {
				SC.say("请备注您申请的原因，此处不能为空");
				return false;
			}
			if(BaseHelpUtils.isNullOrEmpty(list.get(i).get("actuallyDeduction"))) {
				SC.say("请备注您申请补回的金额，此处不能为空");
				return false;
			}
			BigDecimal attendanceDeduction = BaseHelpUtils.getBigDecimalValue(list.get(i).get("attendanceDeduction")).abs();
			BigDecimal actuallyDeduction = BaseHelpUtils.getBigDecimalValue(list.get(i).get("actuallyDeduction"));

			int a = actuallyDeduction.compareTo(attendanceDeduction);
			int zero = actuallyDeduction.compareTo(BigDecimal.ZERO);
			if(a > 0) {
				SC.say("申请补回的金额不能大于考情扣除金额");
				return false;
			}
			if(zero < 0) {
				SC.say("申请补回的金额不能为负数");
				return false;
			}
			
		}
		if(BaseHelpUtils.isNullOrEmpty(list) && list.size() == 0) {
			SC.say("请勾选要申请的工资异常数据");
			return false;
		}
		return true;
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
		else __form.editNewRecord();
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSOnSalaryExceptions.getInstance());
		manager.addMember(__form);
	}
	
	/**
	 * 
	 * 单击提交时
	 */

	@Override
	public java.util.Map getValuesAsMap() {
		Map<String,Object> values = __form.getValues();
		values.put("drafter", ClientUtil.getUserId());
		values.put("companyId", ClientUtil.getCompanyId());
	    //向子表插入数据
		values.putAll(detail.getValuesAsMap());
	    values.put("reason", "工资异常");
	    return values;
	}


}
