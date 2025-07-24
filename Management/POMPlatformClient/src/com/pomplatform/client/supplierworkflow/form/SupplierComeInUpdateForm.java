package com.pomplatform.client.supplierworkflow.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.supplierworkflow.datasource.DSSupplierComeIn;

public class SupplierComeInUpdateForm extends AbstractWizadPage
{


	private final TextItem supplierIdItem;
	private final TextItem supplierNameItem;
	private final TextItem supplierContactItem;
	private final TextItem supplierPhoneItem;
	private final TextItem supplierEmailItem;
	private final TextItem supplierTypeItem;
	private final TextItem supplierMainBusinessTypeItem;
	private final TextItem supplierScopeSupplyItem;
	private final TextItem socialCreditCodeItem;
	private final TextItem supplier_provinceItem;
	private final TextItem supplier_cityItem;
	private final TextItem supplierBankAddressItem;
	private final TextItem supplierAddressItem;
	private final TextItem productionCycleItem;
	private final TextItem logisticsCycleItem;
	private final TextItem supplierBossItem;
	private final DateTimeItem contractSigningTimeItem;
	private final TextItem contractScopeTimeItem;
	private final DateTimeItem contractScopeTimeStartItem;
	private final DateTimeItem contractScopeTimeEndItem;
	private final TextItem operateEmployeeIdItem;
	private final DateTimeItem operateTimeItem;
	private final TextItem supplierOriginItem;
	private final TextItem supplierStatusItem;
	private final TextItem isUseItem;
	private final TextItem receiveUnitManageIdItem;
	private final TextItem agreementTypeItem;
	private final DateTimeItem agreementSignTimeItem;
	private final TextItem agreementSignAddressItem;
	private final TextItem fileIdItem;
	private final TextItem teamSizeItem;
	private final TextItem areasExpertiseItem;

	public SupplierComeInUpdateForm() {
		DSSupplierComeIn ds = DSSupplierComeIn.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		supplierIdItem = new TextItem("supplierId", "供应商编码");
		supplierIdItem.setDisabled(true);
		supplierIdItem.setRequired(true);
		IsIntegerValidator supplierIdValidator = new IsIntegerValidator();
		supplierIdItem.setValidators(supplierIdValidator);
		__formItems.add(supplierIdItem);
		supplierNameItem = new TextItem("supplierName", "供应商名称");
		__formItems.add(supplierNameItem);
		supplierContactItem = new TextItem("supplierContact", "供应商联系人");
		__formItems.add(supplierContactItem);
		supplierPhoneItem = new TextItem("supplierPhone", "供应商电话");
		__formItems.add(supplierPhoneItem);
		supplierEmailItem = new TextItem("supplierEmail", "供应商邮箱");
		__formItems.add(supplierEmailItem);
		supplierTypeItem = new TextItem("supplierType", "供应商类型");
		__formItems.add(supplierTypeItem);
		supplierMainBusinessTypeItem = new TextItem("supplierMainBusinessType", "供应商主营业务类型");
		__formItems.add(supplierMainBusinessTypeItem);
		supplierScopeSupplyItem = new TextItem("supplierScopeSupply", "供货范围");
		__formItems.add(supplierScopeSupplyItem);
		socialCreditCodeItem = new TextItem("socialCreditCode", "社会信用代码");
		__formItems.add(socialCreditCodeItem);
		supplier_provinceItem = new TextItem("supplier_province", "供应商所在(省)");
		__formItems.add(supplier_provinceItem);
		supplier_cityItem = new TextItem("supplier_city", "供应商所在(市)");
		__formItems.add(supplier_cityItem);
		supplierBankAddressItem = new TextItem("supplierBankAddress", "供应商开户行详细地址");
		__formItems.add(supplierBankAddressItem);
		supplierAddressItem = new TextItem("supplierAddress", "供应商税务登记地址");
		__formItems.add(supplierAddressItem);
		productionCycleItem = new TextItem("productionCycle", "生产周期");
		__formItems.add(productionCycleItem);
		logisticsCycleItem = new TextItem("logisticsCycle", "物流周期");
		__formItems.add(logisticsCycleItem);
		supplierBossItem = new TextItem("supplierBoss", "供应商法定代表人");
		__formItems.add(supplierBossItem);
		contractSigningTimeItem = new DateTimeItem("contractSigningTime", "合同签订日期");
		__formItems.add(contractSigningTimeItem);
		contractScopeTimeItem = new TextItem("contractScopeTime", "合同周期");
		__formItems.add(contractScopeTimeItem);
		contractScopeTimeStartItem = new DateTimeItem("contractScopeTimeStart", "合同周期开始时间");
		__formItems.add(contractScopeTimeStartItem);
		contractScopeTimeEndItem = new DateTimeItem("contractScopeTimeEnd", "合同周期结束时间");
		__formItems.add(contractScopeTimeEndItem);
		operateEmployeeIdItem = new TextItem("operateEmployeeId", "操作人");
		__formItems.add(operateEmployeeIdItem);
		operateTimeItem = new DateTimeItem("operateTime", "操作时间");
		__formItems.add(operateTimeItem);
		supplierOriginItem = new TextItem("supplierOrigin", "供应商来源");
		__formItems.add(supplierOriginItem);
		supplierStatusItem = new TextItem("supplierStatus", "供应商状态");
		__formItems.add(supplierStatusItem);
		isUseItem = new TextItem("isUse", "收款单位是否有效(0无效，1有效)");
		__formItems.add(isUseItem);
		receiveUnitManageIdItem = new TextItem("receiveUnitManageId", "主键编码");
		receiveUnitManageIdItem.setDisabled(true);
		receiveUnitManageIdItem.setRequired(true);
		IsIntegerValidator receiveUnitManageIdValidator = new IsIntegerValidator();
		receiveUnitManageIdItem.setValidators(receiveUnitManageIdValidator);
		__formItems.add(receiveUnitManageIdItem);
		agreementTypeItem = new TextItem("agreementType", "协议类别");
		__formItems.add(agreementTypeItem);
		agreementSignTimeItem = new DateTimeItem("agreementSignTime", "协议签订时间");
		__formItems.add(agreementSignTimeItem);
		agreementSignAddressItem = new TextItem("agreementSignAddress", "协议签订地点");
		__formItems.add(agreementSignAddressItem);
		fileIdItem = new TextItem("fileId", "附件编码");
		__formItems.add(fileIdItem);
		teamSizeItem = new TextItem("teamSize", "团队规模");
		__formItems.add(teamSizeItem);
		areasExpertiseItem = new TextItem("areasExpertise", "擅长领域");
		__formItems.add(areasExpertiseItem);

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
		manager.setDataSource(DSSupplierComeIn.getInstance());
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
