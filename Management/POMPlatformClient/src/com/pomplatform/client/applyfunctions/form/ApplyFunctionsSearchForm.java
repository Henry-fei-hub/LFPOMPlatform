package com.pomplatform.client.applyfunctions.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.applyfunctions.datasource.CDApplyFunctions;

public class ApplyFunctionsSearchForm extends SearchForm
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

	public ApplyFunctionsSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDApplyFunctions.getInstance());
		personnelBusinessIdItem = new TextItem("personnelBusinessId", "人事业务编码");
		processTypeItem = new TextItem("processType", "类型 13请假  14出差  15打卡  16外出  17加班");
		employeeIdItem = new TextItem("employeeId", "申请人");
		employeeNoItem = new TextItem("employeeNo", "工号");
		departmentIdItem = new TextItem("departmentId", "部门");
		companyIdItem = new TextItem("companyId", "归属公司");
		typeItem = new TextItem("type", "假期类型");
		startDateItem = new DateTimeItem("startDate", "开始日期");
		startDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, startDateItem);
			}
		});
		startDateDetailItem = new TextItem("startDateDetail", "0上午   1下午");
		endDateItem = new DateTimeItem("endDate", "截止日期");
		endDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, endDateItem);
			}
		});
		endDateDetailItem = new TextItem("endDateDetail", "0上午   1下午");
		daysItem = new TextItem("days", "天数");
		reasonItem = new TextItem("reason", "申请缘由");
		remarkItem = new TextItem("remark", "备注");
		addressItem = new TextItem("address", "地址");
		planItem = new TextItem("plan", "计划安排");
		transportationItem = new TextItem("transportation", "交通工具");
		feeItem = new TextItem("fee", "预计费用");
		unitItem = new TextItem("unit", "外访单位");
		contactPersonItem = new TextItem("contactPerson", "联系人");
		createTimeItem = new DateTimeItem("createTime", "起草时间");
		createTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, createTimeItem);
			}
		});
		deleteFlagItem = new TextItem("deleteFlag", "删除状态  0未删除    1已删除");
		nextAuditorItem = new TextItem("nextAuditor", "自定义的审核人");
		subTypeItem = new TextItem("subType", "假期类型明细项");
		hoursItem = new TextItem("hours", "小时");
		companyProvinceItem = new TextItem("companyProvince", "公司所在省份");
		targetProvinceItem = new TextItem("targetProvince", "目标省份");
		numberOfBabyItem = new TextItem("numberOfBaby", "多胞胎假请填写婴儿数量");
		attachmentItem = new TextItem("attachment", "附件");
		isCompletedItem = new CheckboxItem("isCompleted", "是否审批通过");
		subTypeStrItem = new TextItem("subTypeStr", "假期类型明细项");
		projectTypeItem = new TextItem("projectType", "项目类型 1项目 2前期项目");
		projectIdItem = new TextItem("projectId", "项目主键");
		projectNameItem = new TextItem("projectName", "项目名称");
		projectCodeItem = new TextItem("projectCode", "项目编号");
		parentIdItem = new TextItem("parentId", "父级编码  用于记录是根据哪一条记录进行延期");
		isRemoteCityItem = new CheckboxItem("isRemoteCity", "是否为边远城市");
		provideAccommodationItem = new CheckboxItem("provideAccommodation", "是否提供住宿");
		livingExpensesItem = new TextItem("livingExpenses", "生活费用(元/月)");
		housingFinanceItem = new TextItem("housingFinance", "住房费用(元/月)");
		drafterItem = new TextItem("drafter", "起草人");
		cardItem = new TextItem("card", "身份证");
		dutyIdItem = new TextItem("dutyId", "职务");
		equivalentNumberItem = new TextItem("equivalentNumber", "对等号  与  冲账结合实现 借款与冲账与还款");
		linkIdItem = new TextItem("linkId", "关联表编码");
		severanceItem = new TextItem("severance", "离职补偿金");
		salary1Item = new TextItem("salary1", "薪资1");
		salary2Item = new TextItem("salary2", "薪资2");
		originalPayItem = new TextItem("originalPay", "现薪资");
		monthPayItem = new TextItem("monthPay", "月薪");
		basicProportionStrItem = new TextItem("basicProportionStr", "基本比例（显示用）");
		basicProportionItem = new TextItem("basicProportion", "基本比例（计算用）");
		monthBasicPayItem = new TextItem("monthBasicPay", "月基本工资");
		monthPerformancePayItem = new TextItem("monthPerformancePay", "月绩效工资");
		foremanPayItem = new TextItem("foremanPay", "工龄工资");
		otherSubsidyItem = new TextItem("otherSubsidy", "其他补贴");
		totalPayItem = new TextItem("totalPay", "全薪");
		annualPerformanceItem = new TextItem("annualPerformance", "年度绩效");
		costAttributionItem = new TextItem("costAttribution", "费用归属(1IT人员,2管理人员,3设计人员,4研发人员,5营销人员)");
		certificationTimeItem = new DateTimeItem("certificationTime", "领证时间");
		certificationTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, certificationTimeItem);
			}
		});
		projectIdsItem = new TextItem("projectIds", "项目编码");
		paymentSequenceIdItem = new TextItem("paymentSequenceId", "付款序列编码");
		budgetManagementIdItem = new TextItem("budgetManagementId", "预算管理编码");
		budgetAttachmentIdItem = new TextItem("budgetAttachmentId", "预算附件编码");
		stageIdItem = new TextItem("stageId", "阶段id");
		attachmentIdItem = new TextItem("attachmentId", "附件编码");
		attachmentNameItem = new TextItem("attachmentName", "附件名称");

		setItems(personnelBusinessIdItem, processTypeItem, employeeIdItem, employeeNoItem, departmentIdItem, companyIdItem, typeItem, startDateItem, startDateDetailItem, endDateItem, endDateDetailItem, daysItem, reasonItem, remarkItem, addressItem, planItem, transportationItem, feeItem, unitItem, contactPersonItem, createTimeItem, deleteFlagItem, nextAuditorItem, subTypeItem, hoursItem, companyProvinceItem, targetProvinceItem, numberOfBabyItem, attachmentItem, isCompletedItem, subTypeStrItem, projectTypeItem, projectIdItem, projectNameItem, projectCodeItem, parentIdItem, isRemoteCityItem, provideAccommodationItem, livingExpensesItem, housingFinanceItem, drafterItem, cardItem, dutyIdItem, equivalentNumberItem, linkIdItem, severanceItem, salary1Item, salary2Item, originalPayItem, monthPayItem, basicProportionStrItem, basicProportionItem, monthBasicPayItem, monthPerformancePayItem, foremanPayItem, otherSubsidyItem, totalPayItem, annualPerformanceItem, costAttributionItem, certificationTimeItem, projectIdsItem, paymentSequenceIdItem, budgetManagementIdItem, budgetAttachmentIdItem, stageIdItem, attachmentIdItem, attachmentNameItem);

		setNumCols(134);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
