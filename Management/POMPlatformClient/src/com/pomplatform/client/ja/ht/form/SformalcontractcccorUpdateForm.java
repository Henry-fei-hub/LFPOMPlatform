package com.pomplatform.client.ja.ht.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.ja.ht.datasource.DSSformalcontractcccor;

public class SformalcontractcccorUpdateForm extends AbstractWizadPage
{


	private final TextItem formalContractIdItem;
	private final TextItem clientContractIdItem;
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
	private final TextItem jobMixItem;
	private final TextItem serviceAreaItem;
	private final TextItem withTheAmountItem;
	private final TextItem onSiteTimeItem;
	private final TextItem onSiteTotalMoneyItem;
	private final SelectItem contractStatusItem;

	public SformalcontractcccorUpdateForm() {
		DSSformalcontractcccor ds = DSSformalcontractcccor.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		formalContractIdItem = new TextItem("formalContractId", "正式合同编码");
		formalContractIdItem.setHidden(true);
		formalContractIdItem.setDisabled(true);
		formalContractIdItem.setRequired(true);
		IsIntegerValidator formalContractIdValidator = new IsIntegerValidator();
		formalContractIdItem.setValidators(formalContractIdValidator);
		__formItems.add(formalContractIdItem);
		clientContractIdItem = new TextItem("clientContractId", "客户合同编号");
		clientContractIdItem.setWidth("*");
		__formItems.add(clientContractIdItem);
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setDisabled(true);
		contractCodeItem.setWidth("*");
		__formItems.add(contractCodeItem);
		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setWidth("*");
		__formItems.add(contractNameItem);
		contractPriceItem = new TextItem("contractPrice", "合同金额");
		contractPriceItem.setHidden(true);
		__formItems.add(contractPriceItem);
		coveredAreaItem = new TextItem("coveredArea", "建筑面积(㎡)");
		coveredAreaItem.setWidth("*");
		__formItems.add(coveredAreaItem);
		designAreasItem = new TextItem("designAreas", "计容建筑面积(㎡)");
		designAreasItem.setWidth("*");
		__formItems.add(designAreasItem);
		businessTypeItem = new SelectItem("businessType", "业务类别");
		businessTypeItem.setDisabled(true);
		businessTypeItem.setWidth("*");
		businessTypeItem.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));
		__formItems.add(businessTypeItem);
		projectTypeItem = new SelectItem("projectType", "项目类别");
		projectTypeItem.setDisabled(true);
		projectTypeItem.setWidth("*");
		projectTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_32"));
		__formItems.add(projectTypeItem);
		projectCodeItem = new TextItem("projectCode", "项目编号");
		projectCodeItem.setDisabled(true);
		projectCodeItem.setWidth("*");
		__formItems.add(projectCodeItem);
		professionalCooperationItem = new TextItem("professionalCooperation", "配合专业");
		professionalCooperationItem.setWidth("*");
		__formItems.add(professionalCooperationItem);
		detailAddressItem = new TextItem("detailAddress", "甲方签署名称");
		detailAddressItem.setWidth("*");
		__formItems.add(detailAddressItem);
		customerNameItem = new TextItem("customerName", "客户名称");
		customerNameItem.setWidth("*");
		__formItems.add(customerNameItem);
		customerAddressItem = new TextItem("customerAddress", "客户地址");
		customerAddressItem.setWidth("*");
		__formItems.add(customerAddressItem);
		projectAddressItem = new TextItem("projectAddress", "项目地点");
		projectAddressItem.setWidth("*");
		__formItems.add(projectAddressItem);
		// 合同状态
		contractStatusItem = new SelectItem("contractStatus", "合同状态");
		contractStatusItem.setWidth("*");
		contractStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_35"));
		__formItems.add(contractStatusItem);
		contractDateItem = new DateItem("contractDate", "合同签署日期");
		contractDateItem.setWidth("*");
		__formItems.add(contractDateItem);
		totalProjectTimeItem = new TextItem("totalProjectTime", "项目总工期");
		totalProjectTimeItem.setWidth("*");
		__formItems.add(totalProjectTimeItem);
		projectLevelItem = new SelectItem("projectLevel", "项目等级");
		projectLevelItem.setWidth("*");
		projectLevelItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_2"));
		__formItems.add(projectLevelItem);
		contractTypeItem = new SelectItem("contractType", "合同类别");
		contractTypeItem.setWidth("*");
		contractTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_27"));
		__formItems.add(contractTypeItem);
		// 现场配合(次)
		jobMixItem = new TextItem("jobMix", "现场配合(次)");
		jobMixItem.setWidth("*");
		__formItems.add(jobMixItem);
		// 服务面积(㎡)
		serviceAreaItem = new TextItem("jobMix", "服务面积(㎡)");
		serviceAreaItem.setWidth("*");
		__formItems.add(serviceAreaItem);
		// 配合费用(元)
		withTheAmountItem = new TextItem("jobMix", "配合费用(元)");
		withTheAmountItem.setWidth("*");
		__formItems.add(withTheAmountItem);
		// 驻场时间(月)
		onSiteTimeItem = new TextItem("onSiteTime", "驻场时间(月)");
		onSiteTimeItem.setWidth("*");
		__formItems.add(onSiteTimeItem);
		onSiteTotalMoneyItem = new TextItem("onSiteTotalMoney", "驻场总金额(元)");
		onSiteTotalMoneyItem.setWidth("*");
		__formItems.add(onSiteTotalMoneyItem);
		contractFollowerItem = new TextItem("contractFollower", "合同跟进人");
		contractFollowerItem.setHidden(true);
		contractFollowerItem.setWidth("*");
		__formItems.add(contractFollowerItem);
		signingCompanyNameItem = new SelectItem("signingCompanyName", "我方签约公司名称");
		signingCompanyNameItem.setWidth("*");
		signingCompanyNameItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		__formItems.add(signingCompanyNameItem);
		remarkItem = new TextItem("remark", "备注");
		remarkItem.setWidth("*");
		__formItems.add(remarkItem);
		serviceSuggestBookItem = new TextItem("serviceSuggestBook", "服务建议书");
		serviceSuggestBookItem.setWidth("*");
		serviceSuggestBookItem.setHidden(true);
		__formItems.add(serviceSuggestBookItem);

		
		
		
		
		startDateItem = new DateItem("startDate", "开始日期");
		startDateItem.setHidden(true);
		__formItems.add(startDateItem);
		endDateItem = new DateItem("endDate", "结束日期");
		endDateItem.setHidden(true);
		__formItems.add(endDateItem);
		statusItem = new TextItem("status", "结算状态");
		statusItem.setHidden(true);
		__formItems.add(statusItem);
		signingMoneySumItem = new TextItem("signingMoneySum", "签约总金额");
		signingMoneySumItem.setHidden(true);
		signingMoneySumItem.setWidth("*");
		__formItems.add(signingMoneySumItem);
		createTimeItem = new DateTimeItem("createTime", "创建时间");
		createTimeItem.setHidden(true);
		__formItems.add(createTimeItem);
		updateTimeItem = new DateTimeItem("updateTime", "修改时间");
		updateTimeItem.setHidden(true);
		__formItems.add(updateTimeItem);
		flowStatusItem = new TextItem("flowStatus",
				"流转状态，默认为0表示可以提交到运营管理修改承接部门1表示可以提交到运营管理运营价格2表示可以提交到运营管理运营价格审核3表示审核完成");
		flowStatusItem.setHidden(true);
		__formItems.add(flowStatusItem);
		serialNumberItem = new TextItem("serialNumber", "流水号");
		serialNumberItem.setHidden(true);
		__formItems.add(serialNumberItem);

		provinceItem = new TextItem("province", "省份");
		provinceItem.setHidden(true);
		provinceItem.setWidth("*");
		__formItems.add(provinceItem);
		cityItem = new TextItem("city", "城市");
		cityItem.setHidden(true);
		cityItem.setWidth("*");
		__formItems.add(cityItem);
		projectApprovalTimeItem = new DateItem("projectApprovalTime", "立单时间");
		projectApprovalTimeItem.setHidden(true);
		projectApprovalTimeItem.setWidth("*");
		__formItems.add(projectApprovalTimeItem);
		orderNoItem = new TextItem("orderNo", "标记补充协议字段；除0之外，其他都表示第n个补充协议");
		orderNoItem.setHidden(true);
		__formItems.add(orderNoItem);
		
		

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(6);
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
		manager.setDataSource(DSSformalcontractcccor.getInstance());
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
