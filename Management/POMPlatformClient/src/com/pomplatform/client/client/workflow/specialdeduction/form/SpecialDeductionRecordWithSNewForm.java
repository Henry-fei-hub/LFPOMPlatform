package com.pomplatform.client.client.workflow.specialdeduction.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.client.workflow.specialdeduction.datasource.DSSpecialDeductionRecordWithS;

public class SpecialDeductionRecordWithSNewForm extends AbstractWizadPage
{


	private final TextItem employeIdItem;
	private final TextItem employeeNameItem;
	private final DateItem startDateItem;
	private final DateItem endDateItem;
	private final TextItem processTypeItem;
	private final TextItem deparmentIdItem;
	private final TextItem plateIdItem;
	private final TextItem companyIdItem;
	private final DateTimeItem createDateItem;
	private final CheckboxItem isEnableItem;
	private final TextItem remarkItem;

	public SpecialDeductionRecordWithSNewForm() {
		DSSpecialDeductionRecordWithS ds = DSSpecialDeductionRecordWithS.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		employeIdItem = new TextItem("employeId", "纳税人id");
		employeIdItem.setRequired(true);
		IsIntegerValidator employeIdValidator = new IsIntegerValidator();
		employeIdItem.setValidators(employeIdValidator);
		__formItems.add(employeIdItem);
		employeeNameItem = new TextItem("employeeName", "纳税人名字");
		__formItems.add(employeeNameItem);
		startDateItem = new DateItem("startDate", "有效开始时间");
		__formItems.add(startDateItem);
		endDateItem = new DateItem("endDate", "有效结束时间");
		__formItems.add(endDateItem);
		processTypeItem = new TextItem("processType", "流程类型");
		__formItems.add(processTypeItem);
		deparmentIdItem = new TextItem("deparmentId", "部门");
		__formItems.add(deparmentIdItem);
		plateIdItem = new TextItem("plateId", "业务部门");
		__formItems.add(plateIdItem);
		companyIdItem = new TextItem("companyId", "归属公司");
		__formItems.add(companyIdItem);
		createDateItem = new DateTimeItem("createDate", "创建时间");
		__formItems.add(createDateItem);
		isEnableItem = new CheckboxItem("isEnable", "是否可用");
		__formItems.add(isEnableItem);
		remarkItem = new TextItem("remark", "备注");
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
		if(getRecord() != null) __form.editRecord(getRecord());
		else __form.editNewRecord();
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSSpecialDeductionRecordWithS.getInstance());
		manager.addMember(__form);
	}

	@Override
	public Map getValuesAsMap() {
		return __form.getValues();
	}


}
