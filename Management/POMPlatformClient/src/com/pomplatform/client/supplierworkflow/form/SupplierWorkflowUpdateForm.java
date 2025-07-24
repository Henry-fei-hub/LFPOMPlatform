package com.pomplatform.client.supplierworkflow.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.supplierworkflow.datasource.DSSupplierWorkflow;

public class SupplierWorkflowUpdateForm extends AbstractWizadPage
{


	private final TextItem receiveUnitManageIdItem;
	private final TextItem receiveUnitItem;
	private final TextItem bankAccountItem;
	private final TextItem bankNameItem;
	private final TextItem receiveUnitAddressItem;
	private final TextItem operateEmployeeIdItem;
	private final DateTimeItem operateTimeItem;
	private final TextItem originItem;
	private final TextItem receiveUnitTypeItem;
	private final TextItem companyIdItem;
	private final TextItem salaryTypeItem;
	private final TextItem provinceItem;
	private final TextItem cityItem;
	private final TextItem bankAddressItem;
	private final TextItem receiveUnitPhoneItem;
	private final TextItem swiftCodeItem;
	private final TextItem countryIdItem;
	private final TextItem countryCodeItem;
	private final TextItem passportItem;
	private final TextItem bankIdItem;
	private final TextItem accountTypeItem;
	private final TextItem isUseItem;

	public SupplierWorkflowUpdateForm() {
		DSSupplierWorkflow ds = DSSupplierWorkflow.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		receiveUnitManageIdItem = new TextItem("receiveUnitManageId", "主键编码");
		receiveUnitManageIdItem.setDisabled(true);
		receiveUnitManageIdItem.setRequired(true);
		IsIntegerValidator receiveUnitManageIdValidator = new IsIntegerValidator();
		receiveUnitManageIdItem.setValidators(receiveUnitManageIdValidator);
		__formItems.add(receiveUnitManageIdItem);
		receiveUnitItem = new TextItem("receiveUnit", "收款单位");
		__formItems.add(receiveUnitItem);
		bankAccountItem = new TextItem("bankAccount", "银行账号");
		__formItems.add(bankAccountItem);
		bankNameItem = new TextItem("bankName", "开户行");
		__formItems.add(bankNameItem);
		receiveUnitAddressItem = new TextItem("receiveUnitAddress", "收款单位所在地");
		__formItems.add(receiveUnitAddressItem);
		operateEmployeeIdItem = new TextItem("operateEmployeeId", "操作人");
		__formItems.add(operateEmployeeIdItem);
		operateTimeItem = new DateTimeItem("operateTime", "操作时间");
		__formItems.add(operateTimeItem);
		originItem = new TextItem("origin", "来源");
		__formItems.add(originItem);
		receiveUnitTypeItem = new TextItem("receiveUnitType", "收款单位类型 1 人资发起薪资流程报销使用");
		__formItems.add(receiveUnitTypeItem);
		companyIdItem = new TextItem("companyId", "归属公司 逗号拼接");
		__formItems.add(companyIdItem);
		salaryTypeItem = new TextItem("salaryType", "薪资发放类型  1实付工资 2个人社保 3个人公积金 4个税");
		__formItems.add(salaryTypeItem);
		provinceItem = new TextItem("province", "省");
		__formItems.add(provinceItem);
		cityItem = new TextItem("city", "市");
		__formItems.add(cityItem);
		bankAddressItem = new TextItem("bankAddress", "收款人开户行地址");
		__formItems.add(bankAddressItem);
		receiveUnitPhoneItem = new TextItem("receiveUnitPhone", "收款单位电话");
		__formItems.add(receiveUnitPhoneItem);
		swiftCodeItem = new TextItem("swiftCode", "SWIFT CODE");
		__formItems.add(swiftCodeItem);
		countryIdItem = new TextItem("countryId", "收款人常驻国家（地区）");
		__formItems.add(countryIdItem);
		countryCodeItem = new TextItem("countryCode", "收款人常驻国家（地区）代码");
		__formItems.add(countryCodeItem);
		passportItem = new TextItem("passport", "护照");
		__formItems.add(passportItem);
		bankIdItem = new TextItem("bankId", "银行");
		__formItems.add(bankIdItem);
		accountTypeItem = new TextItem("accountType", "收款方银行类型 1境内收款方 2境外收款方");
		__formItems.add(accountTypeItem);
		isUseItem = new TextItem("isUse", "收款单位是否有效(0无效，1有效)");
		__formItems.add(isUseItem);

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
		manager.setDataSource(DSSupplierWorkflow.getInstance());
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
