package com.pomplatform.client.workflow.form;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.workflow.datasource.DSEmployeeContractAttachment;
import com.smartgwt.client.types.DateItemSelectorFormat;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.validator.IsIntegerValidator;

public class EmployeeContractAttachmentUpdateForm extends AbstractWizadPage
{


	private final TextItem employeeContractAttachmentIdItem;
	private final TextItem employeeIdItem;
	private final TextItem attachmentNameItem;
	private final TextItem attachmentUrlItem;
	private final TextItem operateEmployeeIdItem;
	private final DateTimeItem operateTimeItem;
	private final SelectItem contractTypeItem;
	private final SelectItem signTypeItem;
	private final DateItem startDateItem;
	private final DateItem endDateItem;
	private final TextItem willEndItem;
	private final TextItem attachmentIdItem;
	private final TextItem employeeNoItem;
	private final SelectItem plateIdItem;
	private final IPickTreeItem departmentIdItem;
	private final DateItem onboardDateItem;
	private final TextItem employeeStatusItem;

	public EmployeeContractAttachmentUpdateForm() {
		DSEmployeeContractAttachment ds = DSEmployeeContractAttachment.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		employeeContractAttachmentIdItem = new TextItem("employeeContractAttachmentId", "主键编码");
		employeeContractAttachmentIdItem.setDisabled(true);
		employeeContractAttachmentIdItem.setRequired(true);
		employeeContractAttachmentIdItem.setHidden(true);
		IsIntegerValidator employeeContractAttachmentIdValidator = new IsIntegerValidator();
		employeeContractAttachmentIdItem.setValidators(employeeContractAttachmentIdValidator);
		__formItems.add(employeeContractAttachmentIdItem);

		employeeIdItem = new TextItem("employeeId", "员工姓名");
		KeyValueManager.loadValueMap("employees",employeeIdItem);
		employeeIdItem.setChangeOnKeypress(false);
		employeeIdItem.setRequired(true);
		employeeIdItem.setWidth("*");
		employeeIdItem.setRequired(true);
		__formItems.add(employeeIdItem);

		employeeNoItem = new TextItem("employeeNo", "员工编号");
		employeeNoItem.setCanEdit(false);
		employeeNoItem.setWidth("*");
		employeeNoItem.setRequired(true);
		__formItems.add(employeeNoItem);

		plateIdItem = new SelectItem("plateId", "业务部门");
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));
		plateIdItem.setWidth("*");
		plateIdItem.setCanEdit(false);
		plateIdItem.setRequired(true);
		__formItems.add(plateIdItem);

		departmentIdItem = new IPickTreeItem("departmentId", "所属部门");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));
		departmentIdItem.setWidth("*");
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setCanEdit(false);
		departmentIdItem.setRequired(true);
		__formItems.add(departmentIdItem);

		onboardDateItem = new DateItem("onboardDate", "入职日期");
		onboardDateItem.setWidth("*");
		onboardDateItem.setUseTextField(true);
		onboardDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
		onboardDateItem.setCanEdit(false);
		__formItems.add(onboardDateItem);

		employeeStatusItem = new TextItem("employeeStatus", "职员状态");
		employeeStatusItem.setWidth("*");
		employeeStatusItem.setCanEdit(false);
		employeeStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_11"));
		__formItems.add(employeeStatusItem);

		attachmentNameItem = new TextItem("attachmentName", "附件名称");
		attachmentNameItem.setWidth("*");
		attachmentNameItem.setHidden(false);

		attachmentUrlItem = new TextItem("attachmentUrl", "存放路径");
		attachmentUrlItem.setWidth("*");
		attachmentUrlItem.setHidden(true);
		__formItems.add(attachmentUrlItem);

		operateEmployeeIdItem = new TextItem("operateEmployeeId", "操作人");
		operateEmployeeIdItem.setHidden(true);
		__formItems.add(operateEmployeeIdItem);

		operateTimeItem = new DateTimeItem("operateTime", "操作时间");
		operateTimeItem.setHidden(true);
		__formItems.add(operateTimeItem);

		contractTypeItem = new SelectItem("contractType", "合同类型");
		contractTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_111"));
		contractTypeItem.setWidth("*");
		contractTypeItem.setRequired(true);
		contractTypeItem.setRequired(true);
		__formItems.add(contractTypeItem);

		signTypeItem = new SelectItem("signType", "签订类型");
		signTypeItem.setWidth("*");
		signTypeItem.setRequired(true);
		signTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_112"));
		signTypeItem.setRequired(true);
		__formItems.add(signTypeItem);

		startDateItem = new DateItem("startDate", "开始日期");
		startDateItem.setWidth("*");
		startDateItem.setUseTextField(true);
		startDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
		startDateItem.setRequired(true);
		__formItems.add(startDateItem);

		endDateItem = new DateItem("endDate", "结束日期");
		endDateItem.setWidth("*");
		endDateItem.setUseTextField(true);
		endDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
		endDateItem.setRequired(true);
		__formItems.add(endDateItem);

		willEndItem = new TextItem("willEnd", "一个月到期(0未到期；1即将到期；2已过期)");
		willEndItem.setHidden(true);
		__formItems.add(willEndItem);

		attachmentIdItem = new TextItem("attachmentId","附件ID");
		attachmentIdItem.setWidth("*");
		attachmentIdItem.setHidden(true);
		__formItems.add(attachmentIdItem);
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
		manager.setDataSource(DSEmployeeContractAttachment.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		if(!__form.validate()){
			SC.say("请按系统提示修改信息");
			return false;
		}
		if (null == contractTypeItem.getValue()) {
			SC.say("合同类型不能为空");
			return false;
		}
		if (null == signTypeItem.getValue()) {
			SC.say("签订类型不能为空");
			return false;
		}
		if (null == startDateItem.getValue()) {
			SC.say("开始日期不能为空");
			return false;
		}
		if (null == endDateItem.getValue()) {
			SC.say("结束日期不能为空");
			return false;
		}
		if(!BaseHelpUtils.isNullOrEmpty(startDateItem.getValue()) && !BaseHelpUtils.isNullOrEmpty(endDateItem.getValue())){
			if(startDateItem.getValueAsDate().after(endDateItem.getValueAsDate())){
				SC.say("结束日期不能小于开始日期");
				return false;
			}
		}
		return true;
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
