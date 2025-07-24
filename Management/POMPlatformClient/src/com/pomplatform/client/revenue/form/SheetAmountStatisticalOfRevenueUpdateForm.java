package com.pomplatform.client.revenue.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.revenue.datasource.DSSheetAmountStatisticalOfRevenue;

public class SheetAmountStatisticalOfRevenueUpdateForm extends AbstractWizadPage
{


	private final SelectItem projectIdItem;
	private final SelectItem contractCodeItem;
	private final TextItem projectCodeItem;
	private final TextItem projectNameItem;
	private final SelectItem projectTypeItem;
	private final SelectItem plateIdItem;
	private final SelectItem designTypeItem;
	private final SelectItem departmentIdItem;
	private final SelectItem designPhaseItem;
	private final SelectItem projectLevelItem;
	private final SelectItem statusItem;
	private final SelectItem projectManageIdItem;
	private final TextItem workHoursItem;
	private final DateItem planStartDateItem;
	private final DateItem planEndDateItem;
	private final DateItem startDateItem;
	private final DateItem endDateItem;
	private final TextItem commonAreaItem;
	private final TextItem logisticsAreaItem;
	private final TextItem percentageItem;
	private final TextItem oldProjectDiscountItem;
	private final TextItem budgetItem;
	private final TextItem totalIntegralItem;
	private final TextItem reserveIntegralItem;
	private final TextItem totalAmountItem;
	private final TextItem projectIntegralItem;
	private final TextItem projectProgressItem;
	private final TextItem projectSizeItem;
	private final TextItem projectDescriptionItem;
	private final TextItem auditReasonItem;
	private final TextItem departmentManagerIdItem;
	private final TextItem bimAreaItem;
	private final TextItem cadAreaItem;
	private final TextItem humanAmountItem;
	private final TextItem appendTotalIntegralItem;
	private final TextItem appendIntegralItem;
	private final TextItem remarkItem;
	private final TextItem projectFinishPercentItem;
	private final TextItem parentIdItem;
	private final TextItem totalFinishPercentItem;
	private final TextItem projectGradeTypeItem;
	private final TextItem plateManagerIdItem;
	private final TextItem lastPercentItem;
	private final TextItem complaintPercentageItem;
	private final TextItem complaintIntegralItem;
	private final TextItem revenuePlateIdItem;
	private final TextItem sheetAmountItem;

	public SheetAmountStatisticalOfRevenueUpdateForm() {
		DSSheetAmountStatisticalOfRevenue ds = DSSheetAmountStatisticalOfRevenue.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		projectIdItem = new SelectItem("projectId", "项目编码");
//		KeyValueManager.loadValueMap("projects",projectIdItem);
		KeyValueManager.loadValueMap("projects", projectIdItem);
		projectIdItem.setDisabled(true);
		projectIdItem.setRequired(true);
		IsIntegerValidator projectIdValidator = new IsIntegerValidator();
		projectIdItem.setValidators(projectIdValidator);
		__formItems.add(projectIdItem);
		contractCodeItem = new SelectItem("contractCode", "合同编号");
//		contractCodeItem.setValueMap(KeyValueManager.getValueMap("contracts"));
		KeyValueManager.loadValueMap("contracts", contractCodeItem);
		__formItems.add(contractCodeItem);
		projectCodeItem = new TextItem("projectCode", "项目编号");
		__formItems.add(projectCodeItem);
		projectNameItem = new TextItem("projectName", "项目名称");
		__formItems.add(projectNameItem);
		projectTypeItem = new SelectItem("projectType", "项目类别");
//		projectTypeItem.setValueMap(KeyValueManager.getValueMap("contracts"));
		KeyValueManager.loadValueMap("contracts", projectTypeItem);
		__formItems.add(projectTypeItem);
		plateIdItem = new SelectItem("plateId", "板块");
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		__formItems.add(plateIdItem);
		designTypeItem = new SelectItem("designType", "业务类别");
		designTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_15"));
		__formItems.add(designTypeItem);
		departmentIdItem = new SelectItem("departmentId", "归属部门");
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		__formItems.add(departmentIdItem);
		designPhaseItem = new SelectItem("designPhase", "设计阶段");
		designPhaseItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_7"));
		__formItems.add(designPhaseItem);
		projectLevelItem = new SelectItem("projectLevel", "项目等级");
		projectLevelItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_2"));
		__formItems.add(projectLevelItem);
		statusItem = new SelectItem("status", "项目状态");
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_39"));
		__formItems.add(statusItem);
		projectManageIdItem = new SelectItem("projectManageId", "专业负责人");
		projectManageIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		__formItems.add(projectManageIdItem);
		workHoursItem = new TextItem("workHours", "预估工时");
		__formItems.add(workHoursItem);
		planStartDateItem = new DateItem("planStartDate", "项目计划开始日期");
		__formItems.add(planStartDateItem);
		planEndDateItem = new DateItem("planEndDate", "项目计划结束日期");
		__formItems.add(planEndDateItem);
		startDateItem = new DateItem("startDate", "项目开始日期");
		__formItems.add(startDateItem);
		endDateItem = new DateItem("endDate", "项目结束日期");
		__formItems.add(endDateItem);
		commonAreaItem = new TextItem("commonArea", "公区面积");
		__formItems.add(commonAreaItem);
		logisticsAreaItem = new TextItem("logisticsArea", "后勤面积");
		__formItems.add(logisticsAreaItem);
		percentageItem = new TextItem("percentage", "核算比例");
		__formItems.add(percentageItem);
		oldProjectDiscountItem = new TextItem("oldProjectDiscount", "遗留项目折算");
		__formItems.add(oldProjectDiscountItem);
		budgetItem = new TextItem("budget", "预算");
		__formItems.add(budgetItem);
		totalIntegralItem = new TextItem("totalIntegral", "项目总积分");
		__formItems.add(totalIntegralItem);
		reserveIntegralItem = new TextItem("reserveIntegral", "预留积分");
		__formItems.add(reserveIntegralItem);
		totalAmountItem = new TextItem("totalAmount", "项目总金额");
		__formItems.add(totalAmountItem);
		projectIntegralItem = new TextItem("projectIntegral", "项目积分");
		__formItems.add(projectIntegralItem);
		projectProgressItem = new TextItem("projectProgress", "项目进度");
		__formItems.add(projectProgressItem);
		projectSizeItem = new TextItem("projectSize", "项目大小");
		__formItems.add(projectSizeItem);
		projectDescriptionItem = new TextItem("projectDescription", "项目描述");
		__formItems.add(projectDescriptionItem);
		auditReasonItem = new TextItem("auditReason", "审核意见");
		__formItems.add(auditReasonItem);
		departmentManagerIdItem = new TextItem("departmentManagerId", "部门经理");
		__formItems.add(departmentManagerIdItem);
		bimAreaItem = new TextItem("bimArea", "BIM面积");
		__formItems.add(bimAreaItem);
		cadAreaItem = new TextItem("cadArea", "设计面积");
		__formItems.add(cadAreaItem);
		humanAmountItem = new TextItem("humanAmount", "手工计算积分");
		__formItems.add(humanAmountItem);
		appendTotalIntegralItem = new TextItem("appendTotalIntegral", "追加总积分");
		__formItems.add(appendTotalIntegralItem);
		appendIntegralItem = new TextItem("appendIntegral", "追加积分");
		__formItems.add(appendIntegralItem);
		remarkItem = new TextItem("remark", "备注");
		remarkItem.setRequired(true);
		IsStringValidator remarkValidator = new IsStringValidator();
		LengthRangeValidator remarkLengthValidator = new LengthRangeValidator();
		remarkLengthValidator.setMax(512);
		remarkItem.setValidators(remarkValidator, remarkLengthValidator);
		__formItems.add(remarkItem);
		projectFinishPercentItem = new TextItem("projectFinishPercent", "项目完成百分比");
		__formItems.add(projectFinishPercentItem);
		parentIdItem = new TextItem("parentId", "是否为630项目，0是   1不是       默认值为0");
		__formItems.add(parentIdItem);
		totalFinishPercentItem = new TextItem("totalFinishPercent", "项目总完成百分比");
		__formItems.add(totalFinishPercentItem);
		projectGradeTypeItem = new TextItem("projectGradeType", "2配合专业项目)");
		__formItems.add(projectGradeTypeItem);
		plateManagerIdItem = new TextItem("plateManagerId", "板块负责人");
		__formItems.add(plateManagerIdItem);
		lastPercentItem = new TextItem("lastPercent", "上次结算时的百分比");
		__formItems.add(lastPercentItem);
		complaintPercentageItem = new TextItem("complaintPercentage", "投诉折算比例");
		__formItems.add(complaintPercentageItem);
		complaintIntegralItem = new TextItem("complaintIntegral", "投诉保证金");
		__formItems.add(complaintIntegralItem);
		revenuePlateIdItem = new TextItem("revenuePlateId", "业务部门");
		__formItems.add(revenuePlateIdItem);
		sheetAmountItem = new TextItem("sheetAmount", "订单金额");
		__formItems.add(sheetAmountItem);

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
		manager.setDataSource(DSSheetAmountStatisticalOfRevenue.getInstance());
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
