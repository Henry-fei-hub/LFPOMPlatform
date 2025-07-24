package com.pomplatform.client.projectsettlement.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.projectsettlement.datasource.DSProjectSettlementProcessApplication;

public class ProjectSettlementProcessApplicationNewForm extends AbstractWizadPage
{


	private final TextItem projectIdItem;
	private final TextItem employeeIdItem;
	private final TextItem remarkItem;
	private final DateItem settlementDateItem;
	private final TextItem totalAmountItem;
	private final TextItem totalCostItem;
	private final TextItem projectAmountItem;
	private final TextItem leftAmountItem;
	private final TextItem statusItem;
	private final TextItem stageIdItem;
	private final TextItem settlementStatusItem;
	private final TextItem flagItem;

	public ProjectSettlementProcessApplicationNewForm() {
		DSProjectSettlementProcessApplication ds = DSProjectSettlementProcessApplication.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		projectIdItem = new TextItem("projectId", "项目代码");
		projectIdItem.setRequired(true);
		IsIntegerValidator projectIdValidator = new IsIntegerValidator();
		projectIdItem.setValidators(projectIdValidator);
		__formItems.add(projectIdItem);
		employeeIdItem = new TextItem("employeeId", "结算操作人");
		__formItems.add(employeeIdItem);
		remarkItem = new TextItem("remark", "结算原因");
		__formItems.add(remarkItem);
		settlementDateItem = new DateItem("settlementDate", "结算日期");
		__formItems.add(settlementDateItem);
		totalAmountItem = new TextItem("totalAmount", "确认积分");
		__formItems.add(totalAmountItem);
		totalCostItem = new TextItem("totalCost", "项目成本");
		__formItems.add(totalCostItem);
		projectAmountItem = new TextItem("projectAmount", "项目积分");
		__formItems.add(projectAmountItem);
		leftAmountItem = new TextItem("leftAmount", "项目结余积分");
		__formItems.add(leftAmountItem);
		statusItem = new TextItem("status", "结算状态");
		__formItems.add(statusItem);
		stageIdItem = new TextItem("stageId", "项目阶段");
		__formItems.add(stageIdItem);
		settlementStatusItem = new TextItem("settlementStatus", "3已驳回");
		__formItems.add(settlementStatusItem);
		flagItem = new TextItem("flag", "1历史数据结算；2新方式数据结算");
		__formItems.add(flagItem);

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
		manager.setDataSource(DSProjectSettlementProcessApplication.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
