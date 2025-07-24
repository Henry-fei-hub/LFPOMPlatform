package com.pomplatform.client.supplierworkflow.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.supplierworkflow.datasource.CDSupplierWorkflow;

public class SupplierWorkflowSearchForm extends SearchForm
{


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

	public SupplierWorkflowSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSupplierWorkflow.getInstance());
		receiveUnitItem = new TextItem("receiveUnit", "收款单位");
		bankAccountItem = new TextItem("bankAccount", "银行账号");
		bankNameItem = new TextItem("bankName", "开户行");
		receiveUnitAddressItem = new TextItem("receiveUnitAddress", "收款单位所在地");
		operateEmployeeIdItem = new TextItem("operateEmployeeId", "操作人");
		operateTimeItem = new DateTimeItem("operateTime", "操作时间");
		operateTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, operateTimeItem);
			}
		});
		originItem = new TextItem("origin", "来源");
		receiveUnitTypeItem = new TextItem("receiveUnitType", "收款单位类型 1 人资发起薪资流程报销使用");
		companyIdItem = new TextItem("companyId", "归属公司 逗号拼接");
		salaryTypeItem = new TextItem("salaryType", "薪资发放类型  1实付工资 2个人社保 3个人公积金 4个税");
		provinceItem = new TextItem("province", "省");
		cityItem = new TextItem("city", "市");
		bankAddressItem = new TextItem("bankAddress", "收款人开户行地址");
		receiveUnitPhoneItem = new TextItem("receiveUnitPhone", "收款单位电话");
		swiftCodeItem = new TextItem("swiftCode", "SWIFT CODE");
		countryIdItem = new TextItem("countryId", "收款人常驻国家（地区）");
		countryCodeItem = new TextItem("countryCode", "收款人常驻国家（地区）代码");
		passportItem = new TextItem("passport", "护照");
		bankIdItem = new TextItem("bankId", "银行");
		accountTypeItem = new TextItem("accountType", "收款方银行类型 1境内收款方 2境外收款方");
		isUseItem = new TextItem("isUse", "收款单位是否有效(0无效，1有效)");

		setItems(receiveUnitItem, bankAccountItem, bankNameItem, receiveUnitAddressItem, operateEmployeeIdItem, operateTimeItem, originItem, receiveUnitTypeItem, companyIdItem, salaryTypeItem, provinceItem, cityItem, bankAddressItem, receiveUnitPhoneItem, swiftCodeItem, countryIdItem, countryCodeItem, passportItem, bankIdItem, accountTypeItem, isUseItem);

		setNumCols(42);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
