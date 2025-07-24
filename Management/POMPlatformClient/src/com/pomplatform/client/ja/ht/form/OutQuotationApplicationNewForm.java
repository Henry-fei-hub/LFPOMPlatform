package com.pomplatform.client.ja.ht.form;

import java.util.*;

import com.delicacy.client.BaseHelpUtils;
import com.pomplatform.client.common.SyncDataUtil;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.BaseWidget;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.ja.ht.datasource.DSOutQuotationApplication;

public class OutQuotationApplicationNewForm extends AbstractWizadPage
{


	private final TextItem outQuotationIdItem;
	private final TextItem newCreateQuotationNameItem;
	private final TextItem quotationNumberItem;
	private final TextItem quotationNameItem;
	private final TextItem moneySumItem;
	private final DateTimeItem createTimeItem;
	private final TextItem infoCodeItem;
	private final TextItem projectCodeItem;
	private final TextItem businessTypeItem;
	private final TextItem projectTypeItem;
	private final TextItem quotationFilesItem;
	private final TextItem quotationStatusItem;
	private final TextItem disableTypeItem;
	private final TextItem employeeIdItem;
	private final TextItem contractIdItem;
	private final DateTimeItem updateTimeItem;
	private final TextItem contractNameItem;

	public OutQuotationApplicationNewForm() {
		DSOutQuotationApplication ds = DSOutQuotationApplication.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		outQuotationIdItem = new TextItem("outQuotationId", "报价单标题");
		outQuotationIdItem.setWidth("*");
		outQuotationIdItem.setCanEdit(false);
		outQuotationIdItem.setHidden(true);
		__formItems.add(outQuotationIdItem);
		newCreateQuotationNameItem = new TextItem("newCreateQuotationName", "报价单标题");
		newCreateQuotationNameItem.setWidth("*");
		newCreateQuotationNameItem.setCanEdit(true);
		__formItems.add(newCreateQuotationNameItem);
		infoCodeItem = new TextItem("infoCode", "信息编号");
		infoCodeItem.setCanEdit(false);
		infoCodeItem.setWidth("*");
		__formItems.add(infoCodeItem);
		projectCodeItem = new TextItem("projectCode", "项目编号");
		projectCodeItem.setCanEdit(false);
		projectCodeItem.setWidth("*");
		__formItems.add(projectCodeItem);
		contractNameItem = new TextItem("contractName", "项目名称");
		contractNameItem.setWidth("*");
		contractNameItem.setCanEdit(false);
		__formItems.add(contractNameItem);
		businessTypeItem = new TextItem("businessType", "业务类型");
		businessTypeItem.setCanEdit(false);
		businessTypeItem.setWidth("*");
		businessTypeItem.hide();
		KeyValueManager.loadValueMap("production_value_coefficient_type",businessTypeItem);
		__formItems.add(businessTypeItem);
		quotationNumberItem = new TextItem("quotationNumber", "报价单编号");
		quotationNumberItem.setCanEdit(false);
		quotationNumberItem.setWidth("*");
		__formItems.add(quotationNumberItem);
		quotationNameItem = new TextItem("quotationName", "报价单名称");
		quotationNameItem.setCanEdit(false);
		quotationNameItem.setWidth("*");
		__formItems.add(quotationNameItem);
		moneySumItem = new TextItem("moneySum", "报价单总金额");
		moneySumItem.setCanEdit(false);
		moneySumItem.hide();
		moneySumItem.setWidth("*");
		__formItems.add(moneySumItem);
		projectTypeItem = new TextItem("projectType", "项目类型 1项目 2前期项目");
		projectTypeItem.hide();
		__formItems.add(projectTypeItem);
		quotationFilesItem = new TextItem("quotationFiles", "报价单(原附件)");
		quotationFilesItem.hide();
		__formItems.add(quotationFilesItem);
		quotationStatusItem = new TextItem("quotationStatus", "报价单的状态");
		java.util.Map<String,String> quotationStatusValues = new java.util.HashMap<String,String>();
		quotationStatusValues.put("1", "成功");
		quotationStatusValues.put("2", "历史版本");
		quotationStatusValues.put("3", "报价中");
		quotationStatusItem.setCanEdit(false);
		quotationStatusItem.setWidth("*");
		quotationStatusItem.setValueMap(quotationStatusValues);
		__formItems.add(quotationStatusItem);
		disableTypeItem = new TextItem("disableType", "可操作状态 0可操作,1禁止操作");
		disableTypeItem.hide();
		__formItems.add(disableTypeItem);
		employeeIdItem = new TextItem("employeeId", "申请人");
		employeeIdItem.setCanEdit(false);
		employeeIdItem.setWidth("*");
		employeeIdItem.setDefaultValue(ClientUtil.getUserId());
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		__formItems.add(employeeIdItem);
		contractIdItem = new TextItem("contractId", "contract_id");
		contractIdItem.hide();
		__formItems.add(contractIdItem);
		createTimeItem = new DateTimeItem("createTime", "起草时间");
		createTimeItem.setCanEdit(false);
		createTimeItem.setWidth("*");
		__formItems.add(createTimeItem);
		updateTimeItem = new DateTimeItem("updateTime", "修改时间");
		updateTimeItem.setCanEdit(false);
		updateTimeItem.setWidth("*");
		__formItems.add(updateTimeItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public void startEdit() {
		Record record = getRecord();
		SC.debugger();
		if (null != record) {
				String value = KeyValueManager.getValue("contracts", BaseHelpUtils.getString(record.getAttribute("projectCode")));
				record.setAttribute("contractName", value);
				__form.editRecord(record);
		} else {
			__form.editNewRecord();
		}
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSOutQuotationApplication.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		Map values = __form.getValues();
//		values.put("newCreateQuotationName", newCreateQuotationNameItem.getValue());
		return values;
	}


}
