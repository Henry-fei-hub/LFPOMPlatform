package com.pomplatform.client.specialdeduction.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.specialdeduction.datasource.DSSspecialdeductionmonthdetailedpor;

public class SspecialdeductionmonthdetailedporNewForm extends AbstractWizadPage
{


	private final TextItem employeeIdItem;
	private final TextItem employeeNoItem;
	private final TextItem departmentIdItem;
	private final TextItem plateIdItem;
	private final TextItem yearItem;
	private final TextItem monthItem;
	private final TextItem amountItem;
	private final DateTimeItem createTimeItem;
	private final TextItem specialDeductionTypeIdsItem;
	private final TextItem specialDeductionDetailIdsItem;

	public SspecialdeductionmonthdetailedporNewForm() {
		DSSspecialdeductionmonthdetailedpor ds = DSSspecialdeductionmonthdetailedpor.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		employeeIdItem = new TextItem("employeeId", "职员id");
		__formItems.add(employeeIdItem);
		employeeNoItem = new TextItem("employeeNo", "职员编号");
		__formItems.add(employeeNoItem);
		departmentIdItem = new TextItem("departmentId", "归属部门");
		__formItems.add(departmentIdItem);
		plateIdItem = new TextItem("plateId", "业务部门");
		__formItems.add(plateIdItem);
		yearItem = new TextItem("year", "年度");
		__formItems.add(yearItem);
		monthItem = new TextItem("month", "月份");
		__formItems.add(monthItem);
		amountItem = new TextItem("amount", "专项扣除总金额");
		__formItems.add(amountItem);
		createTimeItem = new DateTimeItem("createTime", "创建时间");
		__formItems.add(createTimeItem);
		specialDeductionTypeIdsItem = new TextItem("specialDeductionTypeIds", "专项扣除类型ids");
		__formItems.add(specialDeductionTypeIdsItem);
		specialDeductionDetailIdsItem = new TextItem("specialDeductionDetailIds", "专项扣除详情ids");
		__formItems.add(specialDeductionDetailIdsItem);

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
		manager.setDataSource(DSSspecialdeductionmonthdetailedpor.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
