package com.pomplatform.client.clientctractor.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.clientctractor.datasource.DSMclientctractor;

public class MclientctractorNewForm extends AbstractWizadPage
{


	private final TextItem clientNameItem;
	private final TextItem clientPhoneItem;
	private final TextItem clientCompanyItem;
	private final TextItem clientAddressItem;
	private final TextItem clientJobItem;
	private final TextItem clientWeixinItem;
	private final TextItem clientQqItem;
	private final TextItem clientEmailItem;
	private final SelectItem clientRoleItem;
	
	public MclientctractorNewForm() {
		DSMclientctractor ds = DSMclientctractor.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		clientNameItem = new TextItem("clientName", "联系人姓名");
		clientNameItem.setRequired(true);
		clientNameItem.setWidth("*");
		__formItems.add(clientNameItem);
		clientPhoneItem = new TextItem("clientPhone", "联系人手机");
		clientPhoneItem.setRequired(true);
		clientPhoneItem.setWidth("*");
		__formItems.add(clientPhoneItem);
		clientCompanyItem = new TextItem("clientCompany", "单位名称");
		clientCompanyItem.setRequired(true);
		clientCompanyItem.setWidth("*");
		__formItems.add(clientCompanyItem);
		clientAddressItem = new TextItem("clientAddress", "单位地址");
		clientAddressItem.setRequired(true);
		clientAddressItem.setWidth("*");
		__formItems.add(clientAddressItem);
		clientJobItem = new TextItem("clientJob", "职务");
		clientJobItem.setWidth("*");
		__formItems.add(clientJobItem);
		clientWeixinItem = new TextItem("clientWeixin", "微信");
		clientWeixinItem.setWidth("*");
		__formItems.add(clientWeixinItem);
		clientQqItem = new TextItem("clientQq", "QQ");
		clientQqItem.setWidth("*");
		__formItems.add(clientQqItem);
		clientEmailItem = new TextItem("clientEmail", "邮箱");
		clientEmailItem.setWidth("*");
		__formItems.add(clientEmailItem);
		clientRoleItem = new SelectItem("clientRole", "联系人角色");
		clientRoleItem.setRequired(true);
		clientRoleItem.setWidth("300");
		__formItems.add(clientRoleItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(2);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		addMember(__form);
	}

	@Override
	public boolean checkData() {
		return __form.validate();
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
		else __form.editNewRecord();
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSMclientctractor.getInstance());
		manager.addMember(__form);
	}

	@Override
	public Map getValuesAsMap() {
		return __form.getValues();
	}


}
