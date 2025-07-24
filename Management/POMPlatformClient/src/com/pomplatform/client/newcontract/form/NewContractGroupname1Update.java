package com.pomplatform.client.newcontract.form;

import java.util.Date;
import java.util.Map;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.newcontract.datasource.DSNewContract;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.validator.IsIntegerValidator;

public class NewContractGroupname1Update extends AbstractWizadPage {

	private final TextItem contractIdItem;
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

	public NewContractGroupname1Update() {
		DSNewContract ds = DSNewContract.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		contractIdItem = new TextItem("contractId", "主合同编码");
		contractIdItem.setDisabled(true);
		contractIdItem.setRequired(true);
		contractIdItem.hide();
		IsIntegerValidator contractIdValidator = new IsIntegerValidator();
		contractIdItem.setValidators(contractIdValidator);
		__formItems.add(contractIdItem);
		signingCompanyNameItem = new SelectItem("signingCompanyName", "我方签约公司名称");
		signingCompanyNameItem.setWidth("*");
		signingCompanyNameItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		__formItems.add(signingCompanyNameItem);
		projectApprovalTimeItem = new DateItem("projectApprovalTime", "立单时间");
		projectApprovalTimeItem.setDisabled(true);
		__formItems.add(projectApprovalTimeItem);
		serialNumberItem = new TextItem("serialNumber", "流水号");
		serialNumberItem.setWidth("*");
		serialNumberItem.setDisabled(true);
		__formItems.add(serialNumberItem);
		contractCodeItem = new TextItem("contractCode", "主合同编号");
		contractCodeItem.setWidth("*");
		contractCodeItem.hide();
		__formItems.add(contractCodeItem);
		contractNameItem = new TextItem("contractName", "主合同名称");
		contractNameItem.setWidth("*");
		__formItems.add(contractNameItem);
		customerNameItem = new TextItem("customerName", "客户名称");
		customerNameItem.setWidth("*");
		__formItems.add(customerNameItem);
		customerAddressItem = new TextItem("customerAddress", "客户地址");
		customerAddressItem.setWidth("*");
		__formItems.add(customerAddressItem);
		contractPriceItem = new TextItem("contractPrice", "合同单价（元/㎡）");
		contractPriceItem.setWidth("*");
		__formItems.add(contractPriceItem);
		signingMoneySumItem = new TextItem("signingMoneySum", "合同金额（元）");
		signingMoneySumItem.setWidth("*");
		__formItems.add(signingMoneySumItem);
		coveredAreaItem = new TextItem("coveredArea", "建筑面积（㎡）");
		coveredAreaItem.setWidth("*");
		__formItems.add(coveredAreaItem);
		designAreasItem = new TextItem("designAreas", "设计面积（㎡）");
		designAreasItem.setWidth("*");
		__formItems.add(designAreasItem);
		businessTypeItem = new TextItem("businessType", "业务类别");
		businessTypeItem.setWidth("*");
		businessTypeItem.setDisabled(true);
		__formItems.add(businessTypeItem);
		projectTypeItem = new TextItem("projectType", "项目类别");
		projectTypeItem.setWidth("*");
		projectTypeItem.setDisabled(true);
		__formItems.add(projectTypeItem);
		professionalCooperationItem = new TextItem("professionalCooperation", "配合专业");
		professionalCooperationItem.setWidth("*");
		professionalCooperationItem.setDisabled(true);
		__formItems.add(professionalCooperationItem);
		projectLevelItem = new SelectItem("projectLevel", "项目等级");
		projectLevelItem.setWidth("*");
		projectLevelItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_2"));
		__formItems.add(projectLevelItem);
		contractTypeItem = new SelectItem("contractType", "合同类别");
		contractTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_27"));
		contractTypeItem.setWidth("*");
		__formItems.add(contractTypeItem);
		totalProjectTimeItem = new TextItem("totalProjectTime", "项目总工期");
		totalProjectTimeItem.setWidth("*");
		__formItems.add(totalProjectTimeItem);
		projectAddressItem = new TextItem("projectAddress", "项目地点");
		projectAddressItem.setWidth("*");
		__formItems.add(projectAddressItem);
		contractFollowerItem = new ComboBoxItem("contractFollower", "合同跟进人");
		contractFollowerItem.setWidth("*");
		contractFollowerItem.setChangeOnKeypress(false);
		contractFollowerItem.setValueMap(KeyValueManager.getValueMap("employees"));
		__formItems.add(contractFollowerItem);
		statusItem = new SelectItem("status", "结算状态");
		statusItem.setWidth("*");
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_16"));
		__formItems.add(statusItem);
		serviceSuggestBookItem = new TextItem("serviceSuggestBook", "服务建议书");
		serviceSuggestBookItem.setWidth("*");
		serviceSuggestBookItem.setDisabled(true);
		__formItems.add(serviceSuggestBookItem);
		remarkItem = new TextItem("remark", "备注");
		remarkItem.setWidth("*");
		__formItems.add(remarkItem);
		startDateItem = new DateItem("startDate", "开始日期");
		__formItems.add(startDateItem);
		endDateItem = new DateItem("endDate", "结束日期");
		__formItems.add(endDateItem);
		contractDateItem = new DateItem("contractDate", "合同签订日期");
		__formItems.add(contractDateItem);

		projectCodeItem = new TextItem("projectCode", "项目编号");
		projectCodeItem.hide();
		__formItems.add(projectCodeItem);
		createTimeItem = new DateTimeItem("createTime", "创建时间");
		createTimeItem.hide();
		__formItems.add(createTimeItem);
		updateTimeItem = new DateTimeItem("updateTime", "修改时间");
		updateTimeItem.hide();
		__formItems.add(updateTimeItem);
		flowStatusItem = new SelectItem("flowStatus", "是否通过");
		flowStatusItem.hide();
		flowStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_33"));
		__formItems.add(flowStatusItem);
		provinceItem = new TextItem("province", "省份");
		provinceItem.hide();
		__formItems.add(provinceItem);
		cityItem = new TextItem("city", "城市");
		cityItem.hide();
		__formItems.add(cityItem);
		detailAddressItem = new TextItem("detailAddress", "详细地址");
		detailAddressItem.hide();
		__formItems.add(detailAddressItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(6);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		setPageMode(PAGE_MODE_UPDATE);
		setName("主合同信息");
		addMember(__form);
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSNewContract.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public void startEdit() {
		if (getRecord() != null)
			__form.editRecord(getRecord());
	}

	@Override
	public java.util.Map getValuesAsMap() {
		Map map = __form.getValues();
		map.put("updateTime", new Date());
		return map;
	}

}
