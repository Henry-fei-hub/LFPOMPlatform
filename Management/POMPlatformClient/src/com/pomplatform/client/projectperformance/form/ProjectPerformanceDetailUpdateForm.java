package com.pomplatform.client.projectperformance.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.projectperformance.datasource.DSProjectPerformanceDetail;

public class ProjectPerformanceDetailUpdateForm extends AbstractWizadPage
{


	private final TextItem projectPerformanceIdItem;
	private final SelectItem contractIdItem;
	private final SelectItem projectIdItem;
	private final TextItem integralItem;
	private final TextItem percentItem;
	private final TextItem performanceIntegralItem;
	private final SelectItem employeeIdItem;
	private final DateItem recordDateItem;
	private final TextItem clientComplaintItem;
	private final TextItem reasonItem;
	private final CheckboxItem isSubmitItem;
	private final TextItem performanceFlagItem;
	private final SelectItem businessTypeItem;
	private final TextItem operateEmployeeIdItem;
	private final DateTimeItem operateTimeItem;
	private final TextItem remarkItem;

	public ProjectPerformanceDetailUpdateForm() {
		DSProjectPerformanceDetail ds = DSProjectPerformanceDetail.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		projectPerformanceIdItem = new TextItem("projectPerformanceId", "主键编码");
		projectPerformanceIdItem.setDisabled(true);
		projectPerformanceIdItem.setRequired(true);
		IsIntegerValidator projectPerformanceIdValidator = new IsIntegerValidator();
		projectPerformanceIdItem.setValidators(projectPerformanceIdValidator);
		__formItems.add(projectPerformanceIdItem);
		contractIdItem = new SelectItem("contractId", "合同编码");
//		contractIdItem.setValueMap(KeyValueManager.getValueMap("contracts"));
		KeyValueManager.loadValueMap("contracts",contractIdItem);
		__formItems.add(contractIdItem);
		projectIdItem = new SelectItem("projectId", "项目编码");
		KeyValueManager.loadValueMap("projects",projectIdItem);
		__formItems.add(projectIdItem);
		integralItem = new TextItem("integral", "积分");
		__formItems.add(integralItem);
		percentItem = new TextItem("percent", "比例");
		__formItems.add(percentItem);
		performanceIntegralItem = new TextItem("performanceIntegral", "扣除/奖励积分");
		__formItems.add(performanceIntegralItem);
		employeeIdItem = new SelectItem("employeeId", "职员");
//		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		KeyValueManager.loadValueMap("employees",employeeIdItem);
		__formItems.add(employeeIdItem);
		recordDateItem = new DateItem("recordDate", "日期");
		__formItems.add(recordDateItem);
		clientComplaintItem = new TextItem("clientComplaint", "客户投诉");
		__formItems.add(clientComplaintItem);
		reasonItem = new TextItem("reason", "原因");
		__formItems.add(reasonItem);
		isSubmitItem = new CheckboxItem("isSubmit", "是否提交");
		__formItems.add(isSubmitItem);
		performanceFlagItem = new TextItem("performanceFlag", "绩效类型");
		__formItems.add(performanceFlagItem);
		businessTypeItem = new SelectItem("businessType", "业务类型");
		businessTypeItem.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));
		__formItems.add(businessTypeItem);
		operateEmployeeIdItem = new TextItem("operateEmployeeId", "操作人");
		__formItems.add(operateEmployeeIdItem);
		operateTimeItem = new DateTimeItem("operateTime", "操作时间");
		__formItems.add(operateTimeItem);
		remarkItem = new TextItem("remark", "备注");
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
		manager.setDataSource(DSProjectPerformanceDetail.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
