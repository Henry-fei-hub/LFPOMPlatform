package com.pomplatform.client.newcontractppcor.form;

import java.util.Date;
import java.util.Map;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.newcontractppcor.datasource.DSScontractppcor;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.validator.IsIntegerValidator;

public class ScontractppcorUpdateForm extends AbstractWizadPage
{


	private final SelectItem contractIdItem;
	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;
	private final TextItem customerNameItem;
	private final DateItem startDateItem;
	private final DateItem endDateItem;
	private final TextItem statusItem;
	private final TextItem projectCodeItem;
	private final SelectItem contractTypeItem;
	private final SelectItem projectLevelItem;
	private final TextItem totalProjectTimeItem;
	private final TextItem signingMoneySumItem;
	private final TextItem designAreasItem;
	private final TextItem contractPriceItem;
	private final TextItem projectAddressItem;
	private final TextItem contractFollowerItem;
	private final TextItem remarkItem;
	private final DateItem contractDateItem;
	private final SelectItem signingCompanyNameItem;
	private final DateTimeItem createTimeItem;
	private final DateTimeItem updateTimeItem;
	private final SelectItem businessTypeItem;
	private final TextItem flowStatusItem;
	private final TextItem serialNumberItem;
	private final SelectItem projectTypeItem;
	private final TextItem coveredAreaItem;
	private final TextItem professionalCooperationItem;
	private final TextItem provinceItem;
	private final TextItem cityItem;
	private final TextItem detailAddressItem;
	private final TextItem customerAddressItem;
	private final TextItem serviceSuggestBookItem;
	private final DateItem projectApprovalTimeItem;
	private final TextItem orderNoItem;
	private final SelectItem parentIdItem;
	private final TextItem infoCodeItem;
	private final SelectItem contractStatusItem;
	private final TextItem clientContractIdItem;

	public ScontractppcorUpdateForm() {
		DSScontractppcor ds = DSScontractppcor.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		infoCodeItem = new TextItem("infoCode", "信息编号");
		infoCodeItem.setWidth("*");
		__formItems.add(infoCodeItem);
		contractStatusItem = new SelectItem("contractStatus", "合同状态");
		contractStatusItem.setWidth("*");
		contractStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_35"));
		__formItems.add(contractStatusItem);
		clientContractIdItem = new TextItem("clientContractId", "客户合同编号");
		clientContractIdItem.setWidth("*");
		__formItems.add(clientContractIdItem);
		contractIdItem = new SelectItem("contractId", "合同编码");
		contractIdItem.setWidth("*");
		contractIdItem.setHidden(true);
//		contractIdItem.setValueMap(KeyValueManager.getValueMap("contracts"));
		KeyValueManager.loadValueMap("contracts",contractIdItem);
		contractIdItem.setDisabled(true);
		contractIdItem.setRequired(true);
		IsIntegerValidator contractIdValidator = new IsIntegerValidator();
		contractIdItem.setValidators(contractIdValidator);
		__formItems.add(contractIdItem);
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		__formItems.add(contractCodeItem);
		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setWidth("*");
		__formItems.add(contractNameItem);
		customerNameItem = new TextItem("customerName", "客户名称");
		customerNameItem.setWidth("*");
		__formItems.add(customerNameItem);
		startDateItem = new DateItem("startDate", "开始日期");
		startDateItem.setWidth("*");
		startDateItem.setHidden(true);
		__formItems.add(startDateItem);
		endDateItem = new DateItem("endDate", "结束日期");
		endDateItem.setWidth("*");
		endDateItem.setHidden(true);
		__formItems.add(endDateItem);
		statusItem = new TextItem("status", "结算状态");
		statusItem.setWidth("*");
		statusItem.setHidden(true);
		__formItems.add(statusItem);
		projectCodeItem = new TextItem("projectCode", "项目编号");
		projectCodeItem.setWidth("*");
		__formItems.add(projectCodeItem);
		contractTypeItem = new SelectItem("contractType", "合同类别");
		contractTypeItem.setWidth("*");
		contractTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_27"));
		__formItems.add(contractTypeItem);
		projectLevelItem = new SelectItem("projectLevel", "项目等级");
		projectLevelItem.setWidth("*");
		projectLevelItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_2"));
		__formItems.add(projectLevelItem);
		totalProjectTimeItem = new TextItem("totalProjectTime", "项目总工期");
		totalProjectTimeItem.setWidth("*");
		__formItems.add(totalProjectTimeItem);
		signingMoneySumItem = new TextItem("signingMoneySum", "签约总金额");
		signingMoneySumItem.setWidth("*");
		__formItems.add(signingMoneySumItem);
		designAreasItem = new TextItem("designAreas", "总设计面积");
		designAreasItem.setWidth("*");
		__formItems.add(designAreasItem);
		contractPriceItem = new TextItem("contractPrice", "合同单价");
		contractPriceItem.setWidth("*");
		contractPriceItem.setHidden(true);
		__formItems.add(contractPriceItem);
		projectAddressItem = new TextItem("projectAddress", "项目地点");
		projectAddressItem.setWidth("*");
		__formItems.add(projectAddressItem);
		contractFollowerItem = new TextItem("contractFollower", "合同跟进人");
		contractFollowerItem.setWidth("*");
		__formItems.add(contractFollowerItem);
		contractDateItem = new DateItem("contractDate", "合同签订日期");
		infoCodeItem.setWidth("*");
		__formItems.add(contractDateItem);
		signingCompanyNameItem = new SelectItem("signingCompanyName", "我方签约公司名称");
		infoCodeItem.setWidth("*");
		signingCompanyNameItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		__formItems.add(signingCompanyNameItem);
		createTimeItem = new DateTimeItem("createTime", "创建时间");
		createTimeItem.setWidth("*");
		createTimeItem.setHidden(true);
		__formItems.add(createTimeItem);
		updateTimeItem = new DateTimeItem("updateTime", "修改时间");
		updateTimeItem.setWidth("*");
		updateTimeItem.setHidden(true);
		__formItems.add(updateTimeItem);
		businessTypeItem = new SelectItem("businessType", "业务类别");
		businessTypeItem.setWidth("*");
		businessTypeItem.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));
		__formItems.add(businessTypeItem);
		flowStatusItem = new TextItem("flowStatus", "流转状态，默认为0表示可以提交到运营管理修改承接部门1表示可以提交到运营管理运营价格2表示可以提交到运营管理运营价格审核3表示审核完成");
		flowStatusItem.setHidden(true);
		__formItems.add(flowStatusItem);
		serialNumberItem = new TextItem("serialNumber", "流水号");
		serialNumberItem.setHidden(true);
		__formItems.add(serialNumberItem);
		projectTypeItem = new SelectItem("projectType", "项目类别");
		projectTypeItem.setWidth("*");
		projectTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_32"));
		__formItems.add(projectTypeItem);
		coveredAreaItem = new TextItem("coveredArea", "建筑面积");
		coveredAreaItem.setWidth("*");
		__formItems.add(coveredAreaItem);
		professionalCooperationItem = new TextItem("professionalCooperation", "配合专业");
		professionalCooperationItem.setWidth("*");
		__formItems.add(professionalCooperationItem);
		provinceItem = new TextItem("province", "省份");
		provinceItem.setWidth("*");
		__formItems.add(provinceItem);
		cityItem = new TextItem("city", "城市");
		cityItem.setWidth("*");
		__formItems.add(cityItem);
		detailAddressItem = new TextItem("detailAddress", "详细地址");
		detailAddressItem.setWidth("*");
		__formItems.add(detailAddressItem);
		customerAddressItem = new TextItem("customerAddress", "客户地址");
		customerAddressItem.setWidth("*");
		__formItems.add(customerAddressItem);
		serviceSuggestBookItem = new TextItem("serviceSuggestBook", "合同附件");
		serviceSuggestBookItem.setWidth("*");
		__formItems.add(serviceSuggestBookItem);
		projectApprovalTimeItem = new DateItem("projectApprovalTime", "立单时间 提交了立单时间会将保存下来，只是点击保存不会将当前时间保存下来，单每次都会显示当前的时间，提交了下次显示的就是提交时的立单时间");
		projectApprovalTimeItem.setHidden(true);
		__formItems.add(projectApprovalTimeItem);
		orderNoItem = new TextItem("orderNo", "标记补充协议字段；除0之外，其他都表示第n个补充协议");
		orderNoItem.setHidden(true);
		__formItems.add(orderNoItem);
		parentIdItem = new SelectItem("parentId", "tree结构表示");
//		parentIdItem.setValueMap(KeyValueManager.getValueMap("project_types"));
		KeyValueManager.loadValueMap("project_types", parentIdItem);
		parentIdItem.setHidden(true);
		__formItems.add(parentIdItem);
		remarkItem = new TextItem("remark", "备注");
		remarkItem.setWidth("*");
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
		manager.setDataSource(DSScontractppcor.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public java.util.Map getValuesAsMap() {
		Map value = __form.getValues();
		value.put("updateTime", new Date());
		value.put("operator",ClientUtil.getEmployeeId());
		return value;
	}


}
