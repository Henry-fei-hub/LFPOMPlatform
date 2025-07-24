package com.pomplatform.client.newcontract.form;

import java.util.Date;
import java.util.Map;

import com.delicacy.client.ValidateUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.newcontract.datasource.DSNewContract;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.validator.RegExpValidator;

public class NewContractGroupname1New extends AbstractWizadPage {

	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;
	private final TextItem customerNameItem;
	private final DateItem startDateItem;
	private final DateItem endDateItem;
	private final SelectItem statusItem;
	private final TextItem projectCodeItem;
	private final SelectItem contractTypeItem;
	private final SelectItem projectLevelItem;
	private final TextItem totalProjectTimeItem;
	private final TextItem signingMoneySumItem;
	private final TextItem designAreasItem;
	private final TextItem contractPriceItem;
	private final TextItem projectAddressItem;
	private final ComboBoxItem contractFollowerItem;
	private final TextItem remarkItem;
	private final DateItem contractDateItem;
	private final SelectItem signingCompanyNameItem;
	private final DateTimeItem createTimeItem;
	private final DateTimeItem updateTimeItem;
	private final TextItem businessTypeItem;
	private final SelectItem flowStatusItem;
	private final TextItem serialNumberItem;
	private final TextItem projectTypeItem;
	private final TextItem coveredAreaItem;
	private final TextItem professionalCooperationItem;
	private final TextItem provinceItem;
	private final TextItem cityItem;
	private final TextItem detailAddressItem;
	private final TextItem customerAddressItem;
	private final TextItem serviceSuggestBookItem;
	private final DateItem projectApprovalTimeItem;
	
	private final TextItem infoCodeItem;

	public NewContractGroupname1New() {
		DSNewContract ds = DSNewContract.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		contractCodeItem = new TextItem("contractCode", "主合同编号");
		__formItems.add(contractCodeItem);
		infoCodeItem = new TextItem("infoCode", "主合同编号");
		infoCodeItem.setHidden(Boolean.TRUE);
		__formItems.add(infoCodeItem);
		contractNameItem = new TextItem("contractName", "主合同名称");
		__formItems.add(contractNameItem);
		customerNameItem = new TextItem("customerName", "客户名称");
		__formItems.add(customerNameItem);
		startDateItem = new DateItem("startDate", "开始日期");
		__formItems.add(startDateItem);
		endDateItem = new DateItem("endDate", "结束日期");
		__formItems.add(endDateItem);
		statusItem = new SelectItem("status", "结算状态");
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_16"));
		__formItems.add(statusItem);
		projectCodeItem = new TextItem("projectCode", "项目编号");
		__formItems.add(projectCodeItem);
		contractTypeItem = new SelectItem("contractType", "合同类别");
		contractTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_27"));
		__formItems.add(contractTypeItem);
		projectLevelItem = new SelectItem("projectLevel", "项目等级");
		projectLevelItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_2"));
		__formItems.add(projectLevelItem);
		totalProjectTimeItem = new TextItem("totalProjectTime", "项目总工期");
		__formItems.add(totalProjectTimeItem);
		signingMoneySumItem = new TextItem("signingMoneySum", "签约总金额");
		__formItems.add(signingMoneySumItem);
		designAreasItem = new TextItem("designAreas", "总设计面积");
		designAreasItem.setValidators(ValidateUtils.isFloatValidator());
		__formItems.add(designAreasItem);
		contractPriceItem = new TextItem("contractPrice", "合同单价");
		__formItems.add(contractPriceItem);
		projectAddressItem = new TextItem("projectAddress", "项目地点");
		__formItems.add(projectAddressItem);
		contractFollowerItem = new ComboBoxItem("contractFollower", "合同跟进人");
		contractFollowerItem.setDefaultValue(155);
		__formItems.add(contractFollowerItem);
		remarkItem = new TextItem("remark", "备注");
		__formItems.add(remarkItem);
		contractDateItem = new DateItem("contractDate", "合同签订日期");
		__formItems.add(contractDateItem);
		signingCompanyNameItem = new SelectItem("signingCompanyName", "我方签约公司名称");
		signingCompanyNameItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		__formItems.add(signingCompanyNameItem);
		createTimeItem = new DateTimeItem("createTime", "创建时间");
		__formItems.add(createTimeItem);
		updateTimeItem = new DateTimeItem("updateTime", "修改时间");
		__formItems.add(updateTimeItem);
		businessTypeItem = new TextItem("businessType", "业务类别");
		__formItems.add(businessTypeItem);
		flowStatusItem = new SelectItem("flowStatus", "流转状态");
		flowStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_33"));
		__formItems.add(flowStatusItem);
		serialNumberItem = new TextItem("serialNumber", "流水号");
		__formItems.add(serialNumberItem);
		projectTypeItem = new TextItem("projectType", "项目类别");
		__formItems.add(projectTypeItem);
		coveredAreaItem = new TextItem("coveredArea", "建筑面积");
		coveredAreaItem.setValidators(ValidateUtils.isFloatValidator());
		__formItems.add(coveredAreaItem);
		professionalCooperationItem = new TextItem("professionalCooperation", "配合专业");
		__formItems.add(professionalCooperationItem);
		provinceItem = new TextItem("province", "省份");
		__formItems.add(provinceItem);
		cityItem = new TextItem("city", "城市");
		__formItems.add(cityItem);
		detailAddressItem = new TextItem("detailAddress", "详细地址");
		__formItems.add(detailAddressItem);
		customerAddressItem = new TextItem("customerAddress", "客户地址");
		__formItems.add(customerAddressItem);
		serviceSuggestBookItem = new TextItem("serviceSuggestBook", "服务建议书");
		__formItems.add(serviceSuggestBookItem);
		projectApprovalTimeItem = new DateItem("projectApprovalTime", "立单时间");
		__formItems.add(projectApprovalTimeItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(2);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		setName("主合同信息");
		addMember(__form);
		
	}

	public NewContractGroupname1New(Map<String, Object> map) {
		DSNewContract ds = DSNewContract.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		infoCodeItem = new TextItem("infoCode", "主合同编号");
		infoCodeItem.setHidden(Boolean.TRUE);
		infoCodeItem.setDefaultValue(map.get("infoCode"));
		__formItems.add(infoCodeItem);
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		contractCodeItem.setDefaultValue(map.get("contractCode"));
		__formItems.add(contractCodeItem);
		signingCompanyNameItem = new SelectItem("signingCompanyName", "我方签约公司名称");
		signingCompanyNameItem.setDefaultValue(map.get("signCompany"));
		signingCompanyNameItem.setWidth("*");
		signingCompanyNameItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		__formItems.add(signingCompanyNameItem);
		projectApprovalTimeItem = new DateItem("projectApprovalTime", "立单日期");
		projectApprovalTimeItem.setDisabled(true);
		__formItems.add(projectApprovalTimeItem);
		serialNumberItem = new TextItem("serialNumber", "流水号");
		serialNumberItem.setWidth("*");
		serialNumberItem.setDisabled(true);
		serialNumberItem.setHidden(true);
		__formItems.add(serialNumberItem);
		projectCodeItem = new TextItem("projectCode", "项目编号");
		projectCodeItem.setWidth("*");
		projectCodeItem.setDefaultValue(map.get("projectCode"));
		projectCodeItem.setDisabled(true);
		projectCodeItem.hide();
		__formItems.add(projectCodeItem);
		
		businessTypeItem = new TextItem("businessType", "业务类别");
		businessTypeItem.setWidth("*");
		businessTypeItem.setDefaultValue(map.get("businessType"));
		businessTypeItem.setDisabled(true);
		__formItems.add(businessTypeItem);
		
		projectTypeItem = new TextItem("projectType", "项目类别");
		projectTypeItem.setWidth("*");
		projectTypeItem.setDefaultValue(map.get("projectType"));
		projectTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_32"));
		projectTypeItem.setDisabled(true);
		__formItems.add(projectTypeItem);
		
		contractNameItem = new TextItem("contractName", "主合同名称");
		contractNameItem.setWidth("*");
		contractNameItem.setDefaultValue(map.get("projectName"));
		__formItems.add(contractNameItem);
		
		customerNameItem = new TextItem("customerName", "客户名称");
		customerNameItem.setWidth("*");
		customerNameItem.setDefaultValue(map.get("customerName"));
		__formItems.add(customerNameItem);
		
		customerAddressItem = new TextItem("customerAddress", "客户地址");
		customerAddressItem.setDefaultValue(map.get("customerAddress"));
		customerAddressItem.setWidth("*");
		__formItems.add(customerAddressItem);
		
		professionalCooperationItem = new TextItem("professionalCooperation", "配合专业");
		professionalCooperationItem.setWidth("*");
		__formItems.add(professionalCooperationItem);
		
		contractPriceItem = new TextItem("contractPrice", "合同单价（元/㎡）");
		contractPriceItem.setHidden(true);
		contractPriceItem.setWidth("*");
		__formItems.add(contractPriceItem);
		
		signingMoneySumItem = new TextItem("signingMoneySum", "合同金额（元）");
		signingMoneySumItem.setWidth("*");
		signingMoneySumItem.setDefaultValue(map.get("projectTotalInvestment"));
		__formItems.add(signingMoneySumItem);
		
		coveredAreaItem = new TextItem("coveredArea", "建筑面积（㎡）");
		coveredAreaItem.setWidth("*");
		coveredAreaItem.setDefaultValue(map.get("totalBuildingAreas"));
		coveredAreaItem.setValidators(ValidateUtils.isFloatValidator());
		__formItems.add(coveredAreaItem);
		
		designAreasItem = new TextItem("designAreas", "设计面积（㎡）");
		designAreasItem.setDefaultValue(map.get("actualDesignAreas"));
		designAreasItem.setValidators(ValidateUtils.isFloatValidator());
		designAreasItem.setWidth("*");
		__formItems.add(designAreasItem);
		
		projectLevelItem = new SelectItem("projectLevel", "项目等级");
		projectLevelItem.setWidth("*");
		projectLevelItem.setDefaultValue(map.get("projectLevel"));
		projectLevelItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_2"));
		__formItems.add(projectLevelItem);
		
		contractTypeItem = new SelectItem("contractType", "合同类别");
		contractTypeItem.setWidth("*");
		contractTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_27"));
		__formItems.add(contractTypeItem);
		
		totalProjectTimeItem = new TextItem("totalProjectTime", "项目总工期");
		totalProjectTimeItem.setWidth("*");
		__formItems.add(totalProjectTimeItem);
		projectAddressItem = new TextItem("projectAddress", "项目地点");
		projectAddressItem.setWidth("*");
		projectAddressItem.setDefaultValue(map.get("address"));
		__formItems.add(projectAddressItem);
		contractFollowerItem = new ComboBoxItem("contractFollower", "合同跟进人");
		contractFollowerItem.setWidth("*");
//		contractFollowerItem.setDefaultValue(155);
		contractFollowerItem.setChangeOnKeypress(false);
		contractFollowerItem.setValueMap(KeyValueManager.getValueMap("employees"));
		__formItems.add(contractFollowerItem);
		statusItem = new SelectItem("status", "结算状态");
		statusItem.setHidden(true);
		statusItem.setWidth("*");
		statusItem.setDefaultValue(0);
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_16"));
		__formItems.add(statusItem);
		flowStatusItem = new SelectItem("flowStatus", "是否通过");
		flowStatusItem.setWidth("*");
		flowStatusItem.hide();
		flowStatusItem.setDefaultValue(0);
		flowStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_33"));
		__formItems.add(flowStatusItem);
		serviceSuggestBookItem = new TextItem("serviceSuggestBook", "服务建议书");
		serviceSuggestBookItem.setWidth("*");
		serviceSuggestBookItem.setDisabled(true);
		serviceSuggestBookItem.setDefaultValue(map.get("serviceSuggestBook"));
		__formItems.add(serviceSuggestBookItem);
		remarkItem = new TextItem("remark", "备注");
		remarkItem.setWidth("*");
		__formItems.add(remarkItem);
		startDateItem = new DateItem("startDate", "开始日期");
		startDateItem.hide();
		startDateItem.setWidth("*");
		__formItems.add(startDateItem);
		endDateItem = new DateItem("endDate", "结束日期");
		endDateItem.hide();
		endDateItem.setWidth("*");
		__formItems.add(endDateItem);
		contractDateItem = new DateItem("contractDate", "合同签订日期");
		contractDateItem.hide();
		contractDateItem.setWidth("*");
		__formItems.add(contractDateItem);
		createTimeItem = new DateTimeItem("createTime", "创建时间");
		createTimeItem.hide();
		__formItems.add(createTimeItem);
		updateTimeItem = new DateTimeItem("updateTime", "修改时间");
		updateTimeItem.hide();
		__formItems.add(updateTimeItem);
		provinceItem = new TextItem("province", "省份");
		provinceItem.setWidth("*");
		provinceItem.hide();
		__formItems.add(provinceItem);
		cityItem = new TextItem("city", "城市");
		cityItem.setWidth("*");
		cityItem.hide();
		__formItems.add(cityItem);
		detailAddressItem = new TextItem("detailAddress", "详细地址");
		detailAddressItem.setWidth("*");
		detailAddressItem.hide();
		__formItems.add(detailAddressItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(6);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		setName("主合同信息");
		addMember(__form);
	}

	@Override
	public void startEdit() {
		if (getRecord() != null)
			__form.editRecord(getRecord());
		else
			__form.editNewRecord();
	}

	@Override
	public boolean checkData() {
		return __form.validate();
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSNewContract.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		Map values = __form.getValues();
		Date date = new Date();
		values.put("createTime", date);
		values.put("updateTime", date);
		values.put("flowStatus", 0);
		return values;
	}

}
