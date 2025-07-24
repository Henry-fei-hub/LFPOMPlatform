package com.pomplatform.client.workflow.form;

import java.util.*;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.DBDataSource;
import com.pomplatform.client.selectgridemployeevalue.datasource.DSSelectGridEmployeeValue;
import com.smartgwt.client.data.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.workflow.datasource.DSApplicationFiling;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.VLayout;

public class ApplicationFilingUpdateForm extends AbstractWizadPage
{

	private VLayout left;
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

	public ApplicationFilingUpdateForm() {
		DSApplicationFiling ds = DSApplicationFiling.getInstance();
		__form.setWidth100();
		__form.setHeight100();

		left = new VLayout();
		left.setWidth100();
		left.setHeight100();
		left.setLayoutTopMargin(10);

		employeeIdItem = new TextItem("employeeId", "申请人");
		employeeIdItem.setWidth("*");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.setTextBoxStyle("customInputTextStyle");
		employeeIdItem.setDisabled(true);
		__formItems.add(employeeIdItem);



		nextAuditorItem = new TextItem("nextAuditor",  "调档人员");
		nextAuditorItem.setWidth("*");
        nextAuditorItem.setDisabled(true);
		nextAuditorItem.setControlStyle("customInputTextStyle");
        nextAuditorItem.hide();
        __formItems.add(nextAuditorItem);


        attachmentItem = new TextItem("attachment", "调档人员");
        attachmentItem.setWidth("*");
        attachmentItem.setDisabled(true);
        attachmentItem.setControlStyle("customInputTextStyle");
        __formItems.add(attachmentItem);


		personnelBusinessIdItem = new TextItem("","");
		personnelBusinessIdItem.hide();
		__formItems.add(personnelBusinessIdItem);

		processTypeItem = new TextItem("processType", "类型 13请假  14出差  15打卡  16外出  17加班");
		processTypeItem.hide();
		__formItems.add(processTypeItem);


		employeeNoItem = new TextItem("employeeNo", "员工编号");
		employeeNoItem.setRequired(true);
		employeeNoItem.hide();
		__formItems.add(employeeNoItem);

		companyIdItem = new TextItem("companyId", "申请人归属公司");
		companyIdItem.setDefaultValue(ClientUtil.getCompanyId());
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		companyIdItem.setWidth("*");
		companyIdItem.setDisabled(true);
		__formItems.add(companyIdItem);


		salary1Item = new TextItem("salary1", "调档人归属公司");
		salary1Item.setWidth("*");
		salary1Item.setDisabled(true);
		__formItems.add(salary1Item);

		departmentIdItem = new TextItem("departmentId", "申请人部门");
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		departmentIdItem.setWidth("*");
		departmentIdItem.setDisabled(true);
		departmentIdItem.setDefaultValue(ClientUtil.getDepartmentId());
		__formItems.add(departmentIdItem);

		salary2Item = new TextItem("salary2", "调档人部门");
		salary2Item.setWidth("*");
		salary2Item.setDisabled(true);
		__formItems.add(salary2Item);






		reasonItem = new TextItem("reason", "申请缘由");
		reasonItem.setWidth("*");
		__formItems.add(reasonItem);

		typeItem = new TextItem("type", "假期类型");
		typeItem.hide();
		__formItems.add(typeItem);


		startDateItem = new DateTimeItem("startDate", "开始日期");
		startDateItem.hide();
		__formItems.add(startDateItem);

		startDateDetailItem = new TextItem("startDateDetail", "0上午   1下午");
		startDateDetailItem.hide();
		__formItems.add(startDateDetailItem);

		endDateItem = new DateTimeItem("endDate", "截止日期");
		endDateItem.hide();
		__formItems.add(endDateItem);

		endDateDetailItem = new TextItem("endDateDetail", "0上午   1下午");
		endDateDetailItem.hide();
		__formItems.add(endDateDetailItem);

		daysItem = new TextItem("days", "天数");
		daysItem.hide();
		__formItems.add(daysItem);




		remarkItem = new TextItem("remark", "备注");
		remarkItem.hide();
		__formItems.add(remarkItem);

		addressItem = new TextItem("address", "家庭地址");
		addressItem.hide();
		__formItems.add(addressItem);

		planItem = new TextItem("plan", "计划安排");
		planItem.hide();
		__formItems.add(planItem);

		transportationItem = new TextItem("transportation", "交通工具");
		transportationItem.hide();
		__formItems.add(transportationItem);

		feeItem = new TextItem("fee", "预计费用");
		feeItem.hide();
		__formItems.add(feeItem);

		unitItem = new TextItem("unit", "外访单位");
		unitItem.hide();
		__formItems.add(unitItem);

		contactPersonItem = new TextItem("contactPerson", "联系人");
		contactPersonItem.hide();
		__formItems.add(contactPersonItem);

		createTimeItem = new DateTimeItem("createTime", "起草时间");
		createTimeItem.hide();
		__formItems.add(createTimeItem);

		deleteFlagItem = new TextItem("deleteFlag", "删除状态  0未删除    1已删除");
		deleteFlagItem.hide();
		__formItems.add(deleteFlagItem);


		subTypeItem = new TextItem("subType", "假期类型明细项");
		subTypeItem.hide();
		__formItems.add(subTypeItem);

		hoursItem = new TextItem("hours", "小时");
		hoursItem.hide();
		__formItems.add(hoursItem);

		companyProvinceItem = new TextItem("companyProvince", "公司所在省份");
		companyProvinceItem.hide();
		__formItems.add(companyProvinceItem);

		targetProvinceItem = new TextItem("targetProvince", "目标省份");
		targetProvinceItem.hide();
		__formItems.add(targetProvinceItem);

		numberOfBabyItem = new TextItem("numberOfBaby", "多胞胎假请填写婴儿数量");
		numberOfBabyItem.hide();
		__formItems.add(numberOfBabyItem);



		isCompletedItem = new CheckboxItem("isCompleted", "是否审批通过");
		isCompletedItem.hide();
		__formItems.add(isCompletedItem);

		subTypeStrItem = new TextItem("subTypeStr", "假期类型明细项");
		subTypeStrItem.hide();
		__formItems.add(subTypeStrItem);

		projectTypeItem = new TextItem("projectType", "项目类型 1项目 2前期项目");
		projectTypeItem.hide();
		__formItems.add(projectTypeItem);

		projectIdItem = new TextItem("projectId", "项目主键");
		projectIdItem.hide();
		__formItems.add(projectIdItem);

		projectNameItem = new TextItem("projectName", "项目名称");
		projectNameItem.hide();
		__formItems.add(projectNameItem);

		projectCodeItem = new TextItem("projectCode", "项目编号");
		projectCodeItem.hide();
		__formItems.add(projectCodeItem);

		parentIdItem = new TextItem("parentId", "父级编码  用于记录是根据哪一条记录进行延期");
		parentIdItem.hide();
		__formItems.add(parentIdItem);

		isRemoteCityItem = new CheckboxItem("isRemoteCity", "是否为边远城市");
		isRemoteCityItem.hide();
		__formItems.add(isRemoteCityItem);
		provideAccommodationItem = new CheckboxItem("provideAccommodation", "是否提供住宿");
		provideAccommodationItem.hide();
		__formItems.add(provideAccommodationItem);

		livingExpensesItem = new TextItem("livingExpenses", "生活费用(元/月)");
		livingExpensesItem.hide();
		__formItems.add(livingExpensesItem);

		housingFinanceItem = new TextItem("housingFinance", "住房费用(元/月)");
		housingFinanceItem.hide();
		__formItems.add(housingFinanceItem);

		drafterItem = new TextItem("drafter", "起草人");
		drafterItem.setDefaultValue(ClientUtil.getEmployeeId());
		drafterItem.hide();
		__formItems.add(drafterItem);

		cardItem = new TextItem("card", "身份证号");
		cardItem.hide();
		__formItems.add(cardItem);

		dutyIdItem = new TextItem("dutyId", "职位名称");
		dutyIdItem.hide();
		__formItems.add(dutyIdItem);

		equivalentNumberItem = new TextItem("equivalentNumber", "对等号  与  冲账结合实现 借款与冲账与还款");
		equivalentNumberItem.hide();
		__formItems.add(equivalentNumberItem);

		linkIdItem = new TextItem("linkId", "关联表编码");
		linkIdItem.hide();
		__formItems.add(linkIdItem);

		severanceItem = new TextItem("severance", "离职补偿金");
		severanceItem.hide();
		__formItems.add(severanceItem);







		originalPayItem = new TextItem("originalPay", "现薪资");
		originalPayItem.hide();
		__formItems.add(originalPayItem);


		monthPayItem = new TextItem("monthPay", "月薪");
		monthPayItem.hide();
		__formItems.add(monthPayItem);


		basicProportionStrItem = new TextItem("basicProportionStr", "基本比例（显示用）");
		basicProportionStrItem.hide();
		__formItems.add(basicProportionStrItem);

		basicProportionItem = new TextItem("basicProportion", "基本比例（计算用）");
		basicProportionItem.hide();
		__formItems.add(basicProportionItem);

		monthBasicPayItem = new TextItem("monthBasicPay", "月基本工资");
		monthBasicPayItem.hide();
		__formItems.add(monthBasicPayItem);

		monthPerformancePayItem = new TextItem("monthPerformancePay", "月绩效工资");
		monthPerformancePayItem.hide();
		__formItems.add(monthPerformancePayItem);

		foremanPayItem = new TextItem("foremanPay", "工龄工资");
		foremanPayItem.hide();
		__formItems.add(foremanPayItem);

		otherSubsidyItem = new TextItem("otherSubsidy", "其他补贴");
		otherSubsidyItem.hide();
		__formItems.add(otherSubsidyItem);

		totalPayItem = new TextItem("totalPay", "全薪");
		totalPayItem.hide();
		__formItems.add(totalPayItem);

		annualPerformanceItem = new TextItem("annualPerformance", "年度绩效");
		annualPerformanceItem.hide();
		__formItems.add(annualPerformanceItem);

		costAttributionItem = new TextItem("costAttribution", "费用归属(1IT人员,2管理人员,3设计人员,4研发人员,5营销人员)");
		costAttributionItem.hide();
		__formItems.add(costAttributionItem);

		certificationTimeItem = new DateTimeItem("certificationTime", "领证时间");
		certificationTimeItem.hide();
		__formItems.add(certificationTimeItem);

		projectIdsItem = new TextItem("projectIds", "项目编码");
		projectIdsItem.hide();
		__formItems.add(projectIdsItem);

		paymentSequenceIdItem = new TextItem("paymentSequenceId", "付款序列编码");
		paymentSequenceIdItem.hide();
		__formItems.add(paymentSequenceIdItem);

		budgetManagementIdItem = new TextItem("budgetManagementId", "预算管理编码");
		budgetManagementIdItem.hide();
		__formItems.add(budgetManagementIdItem);

		budgetAttachmentIdItem = new TextItem("budgetAttachmentId", "预算附件编码");
		budgetAttachmentIdItem.hide();
		__formItems.add(budgetAttachmentIdItem);

		stageIdItem = new TextItem("stageId", "阶段id");
		stageIdItem.hide();
		__formItems.add(stageIdItem);

		attachmentIdItem = new TextItem("attachmentId", "附件编码");
		attachmentIdItem.hide();
		__formItems.add(attachmentIdItem);

		attachmentNameItem = new TextItem("attachmentName", "附件名称");
		attachmentNameItem.hide();
		__formItems.add(attachmentNameItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		setPageMode(PAGE_MODE_UPDATE);

        left.addMember(__form);
        addMember(left);

        Label label = new Label("<font style='color:#FF7F27; font-weight:bold;'>♥ 温馨提示：可查看调档人员的员工编号、姓名、入职时间、所属部门、出生日期、年龄、参加工作时间、毕业院校、所学专业、身份证附件、职称证附件、学历证附件，可点击调档申请页面右边的<查看员工档案>按钮</font>");
        label.setHeight(200);
        label.setLeft(200);
        left.addMember(label);
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
		HashMap<String, Integer> params = new HashMap<>();
		int employeeId =  BaseHelpUtils.getIntValue(nextAuditorItem.getValue());
		nextAuditorItem.setValue(employeeId);
		params.put("employeeId", employeeId);
		DBDataSource.callOperation("ST_Employee", "find", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
				int status = dsResponse.getStatus();
				if (status >= 0) {
					Record record = dsResponse.getData()[0];
					if (null != record) {
						String employeeName = record.getAttributeAsString("employeeName");
						nextAuditorItem.setDefaultValue(employeeName);
					}
				}
			}
		});

	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSApplicationFiling.getInstance());
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
