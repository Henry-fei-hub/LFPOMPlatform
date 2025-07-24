package com.pomplatform.client.workflow.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.workflow.datasource.DSProjectEmployeeProcessApplication;

public class ProjectEmployeeProcessApplicationUpdateForm extends AbstractWizadPage
{


	private final TextItem personnelBusinessIdItem;
	private final TextItem processTypeItem;
	private final TextItem employeeIdItem;
	private final TextItem employeeNoItem;
	private final TextItem departmentIdItem;
	private final TextItem companyIdItem;
	private final TextItem typeItem;
	private final DateTimeItem startDateItem;
	private final TextItem startDateDetailItem;
	private final DateTimeItem endDateItem;
	private final TextItem endDateDetailItem;
	private final TextItem daysItem;
	private final TextItem reasonItem;
	private final TextItem remarkItem;
	private final TextItem addressItem;
	private final TextItem planItem;
	private final TextItem transportationItem;
	private final TextItem feeItem;
	private final TextItem unitItem;
	private final TextItem contactPersonItem;
	private final DateTimeItem createTimeItem;
	private final TextItem deleteFlagItem;
	private final TextItem nextAuditorItem;
	private final TextItem subTypeItem;
	private final TextItem hoursItem;
	private final TextItem companyProvinceItem;
	private final TextItem targetProvinceItem;
	private final TextItem numberOfBabyItem;
	private final TextItem attachmentItem;
	private final CheckboxItem isCompletedItem;
	private final TextItem subTypeStrItem;
	private final TextItem projectTypeItem;
	private final TextItem projectIdItem;
	private final TextItem projectNameItem;
	private final TextItem projectCodeItem;
	private final TextItem parentIdItem;
	private final CheckboxItem isRemoteCityItem;
	private final CheckboxItem provideAccommodationItem;
	private final TextItem livingExpensesItem;
	private final TextItem housingFinanceItem;
	private final TextItem drafterItem;
	private final TextItem cardItem;
	private final TextItem dutyIdItem;
	private final TextItem equivalentNumberItem;
	private final TextItem linkIdItem;
	private final TextItem severanceItem;
	private final TextItem salary1Item;
	private final TextItem salary2Item;
	private final TextItem originalPayItem;
	private final TextItem monthPayItem;
	private final TextItem basicProportionStrItem;
	private final TextItem basicProportionItem;
	private final TextItem monthBasicPayItem;
	private final TextItem monthPerformancePayItem;
	private final TextItem foremanPayItem;
	private final TextItem otherSubsidyItem;
	private final TextItem totalPayItem;
	private final TextItem annualPerformanceItem;
	private final TextItem costAttributionItem;
	private final DateTimeItem certificationTimeItem;
	private final TextItem projectIdsItem;
	private final TextItem paymentSequenceIdItem;
	private final TextItem budgetManagementIdItem;
	private final TextItem budgetAttachmentIdItem;
	private final TextItem stageIdItem;
	private final TextItem attachmentIdItem;
	private final TextItem attachmentNameItem;

	public ProjectEmployeeProcessApplicationUpdateForm() {
		DSProjectEmployeeProcessApplication ds = DSProjectEmployeeProcessApplication.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		personnelBusinessIdItem = new TextItem("personnelBusinessId", "人事业务编码");
		personnelBusinessIdItem.setDisabled(true);
		personnelBusinessIdItem.setRequired(true);
		IsIntegerValidator personnelBusinessIdValidator = new IsIntegerValidator();
		personnelBusinessIdItem.setValidators(personnelBusinessIdValidator);
		__formItems.add(personnelBusinessIdItem);
		processTypeItem = new TextItem("processType", "类型 13请假  14出差  15打卡  16外出  17加班");
		__formItems.add(processTypeItem);
		employeeIdItem = new TextItem("employeeId", "申请人");
		__formItems.add(employeeIdItem);
		employeeNoItem = new TextItem("employeeNo", "工号");
		__formItems.add(employeeNoItem);
		departmentIdItem = new TextItem("departmentId", "部门");
		__formItems.add(departmentIdItem);
		companyIdItem = new TextItem("companyId", "归属公司");
		__formItems.add(companyIdItem);
		typeItem = new TextItem("type", "假期类型");
		__formItems.add(typeItem);
		startDateItem = new DateTimeItem("startDate", "开始日期");
		__formItems.add(startDateItem);
		startDateDetailItem = new TextItem("startDateDetail", "0上午   1下午");
		__formItems.add(startDateDetailItem);
		endDateItem = new DateTimeItem("endDate", "截止日期");
		__formItems.add(endDateItem);
		endDateDetailItem = new TextItem("endDateDetail", "0上午   1下午");
		__formItems.add(endDateDetailItem);
		daysItem = new TextItem("days", "天数");
		__formItems.add(daysItem);
		reasonItem = new TextItem("reason", "申请缘由");
		__formItems.add(reasonItem);
		remarkItem = new TextItem("remark", "备注");
		__formItems.add(remarkItem);
		addressItem = new TextItem("address", "地址");
		__formItems.add(addressItem);
		planItem = new TextItem("plan", "计划安排");
		__formItems.add(planItem);
		transportationItem = new TextItem("transportation", "交通工具");
		__formItems.add(transportationItem);
		feeItem = new TextItem("fee", "预计费用");
		__formItems.add(feeItem);
		unitItem = new TextItem("unit", "外访单位");
		__formItems.add(unitItem);
		contactPersonItem = new TextItem("contactPerson", "联系人");
		__formItems.add(contactPersonItem);
		createTimeItem = new DateTimeItem("createTime", "起草时间");
		__formItems.add(createTimeItem);
		deleteFlagItem = new TextItem("deleteFlag", "删除状态  0未删除    1已删除");
		__formItems.add(deleteFlagItem);
		nextAuditorItem = new TextItem("nextAuditor", "自定义的审核人");
		__formItems.add(nextAuditorItem);
		subTypeItem = new TextItem("subType", "假期类型明细项");
		__formItems.add(subTypeItem);
		hoursItem = new TextItem("hours", "小时");
		__formItems.add(hoursItem);
		companyProvinceItem = new TextItem("companyProvince", "公司所在省份");
		__formItems.add(companyProvinceItem);
		targetProvinceItem = new TextItem("targetProvince", "目标省份");
		__formItems.add(targetProvinceItem);
		numberOfBabyItem = new TextItem("numberOfBaby", "多胞胎假请填写婴儿数量");
		__formItems.add(numberOfBabyItem);
		attachmentItem = new TextItem("attachment", "附件");
		__formItems.add(attachmentItem);
		isCompletedItem = new CheckboxItem("isCompleted", "是否审批通过");
		__formItems.add(isCompletedItem);
		subTypeStrItem = new TextItem("subTypeStr", "假期类型明细项");
		__formItems.add(subTypeStrItem);
		projectTypeItem = new TextItem("projectType", "项目类型 1项目 2前期项目");
		__formItems.add(projectTypeItem);
		projectIdItem = new TextItem("projectId", "项目主键");
		__formItems.add(projectIdItem);
		projectNameItem = new TextItem("projectName", "项目名称");
		__formItems.add(projectNameItem);
		projectCodeItem = new TextItem("projectCode", "项目编号");
		__formItems.add(projectCodeItem);
		parentIdItem = new TextItem("parentId", "父级编码  用于记录是根据哪一条记录进行延期");
		__formItems.add(parentIdItem);
		isRemoteCityItem = new CheckboxItem("isRemoteCity", "是否为边远城市");
		__formItems.add(isRemoteCityItem);
		provideAccommodationItem = new CheckboxItem("provideAccommodation", "是否提供住宿");
		__formItems.add(provideAccommodationItem);
		livingExpensesItem = new TextItem("livingExpenses", "生活费用(元/月)");
		__formItems.add(livingExpensesItem);
		housingFinanceItem = new TextItem("housingFinance", "住房费用(元/月)");
		__formItems.add(housingFinanceItem);
		drafterItem = new TextItem("drafter", "起草人");
		__formItems.add(drafterItem);
		cardItem = new TextItem("card", "身份证");
		__formItems.add(cardItem);
		dutyIdItem = new TextItem("dutyId", "职务");
		__formItems.add(dutyIdItem);
		equivalentNumberItem = new TextItem("equivalentNumber", "对等号  与  冲账结合实现 借款与冲账与还款");
		__formItems.add(equivalentNumberItem);
		linkIdItem = new TextItem("linkId", "关联表编码");
		__formItems.add(linkIdItem);
		severanceItem = new TextItem("severance", "离职补偿金");
		__formItems.add(severanceItem);
		salary1Item = new TextItem("salary1", "薪资1");
		__formItems.add(salary1Item);
		salary2Item = new TextItem("salary2", "薪资2");
		__formItems.add(salary2Item);
		originalPayItem = new TextItem("originalPay", "现薪资");
		__formItems.add(originalPayItem);
		monthPayItem = new TextItem("monthPay", "月薪");
		__formItems.add(monthPayItem);
		basicProportionStrItem = new TextItem("basicProportionStr", "基本比例（显示用）");
		__formItems.add(basicProportionStrItem);
		basicProportionItem = new TextItem("basicProportion", "基本比例（计算用）");
		__formItems.add(basicProportionItem);
		monthBasicPayItem = new TextItem("monthBasicPay", "月基本工资");
		__formItems.add(monthBasicPayItem);
		monthPerformancePayItem = new TextItem("monthPerformancePay", "月绩效工资");
		__formItems.add(monthPerformancePayItem);
		foremanPayItem = new TextItem("foremanPay", "工龄工资");
		__formItems.add(foremanPayItem);
		otherSubsidyItem = new TextItem("otherSubsidy", "其他补贴");
		__formItems.add(otherSubsidyItem);
		totalPayItem = new TextItem("totalPay", "全薪");
		__formItems.add(totalPayItem);
		annualPerformanceItem = new TextItem("annualPerformance", "年度绩效");
		__formItems.add(annualPerformanceItem);
		costAttributionItem = new TextItem("costAttribution", "费用归属(1IT人员,2管理人员,3设计人员,4研发人员,5营销人员)");
		__formItems.add(costAttributionItem);
		certificationTimeItem = new DateTimeItem("certificationTime", "领证时间");
		__formItems.add(certificationTimeItem);
		projectIdsItem = new TextItem("projectIds", "项目编码");
		__formItems.add(projectIdsItem);
		paymentSequenceIdItem = new TextItem("paymentSequenceId", "付款序列编码");
		__formItems.add(paymentSequenceIdItem);
		budgetManagementIdItem = new TextItem("budgetManagementId", "预算管理编码");
		__formItems.add(budgetManagementIdItem);
		budgetAttachmentIdItem = new TextItem("budgetAttachmentId", "预算附件编码");
		__formItems.add(budgetAttachmentIdItem);
		stageIdItem = new TextItem("stageId", "阶段id");
		__formItems.add(stageIdItem);
		attachmentIdItem = new TextItem("attachmentId", "附件编码");
		__formItems.add(attachmentIdItem);
		attachmentNameItem = new TextItem("attachmentName", "附件名称");
		__formItems.add(attachmentNameItem);

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
		manager.setDataSource(DSProjectEmployeeProcessApplication.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public Map getValuesAsMap() {
		return __form.getValues();
	}


}
