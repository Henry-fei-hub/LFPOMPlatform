package com.pomplatform.client.clientctractor.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.clientctractor.datasource.CDMclientctractor;

public class MclientctractorSearchForm extends SearchForm
{


	private final TextItem contractIdItem;
	private final TextItem clientNameItem;
	private final TextItem clientPhoneItem;
	private final TextItem clientCompanyItem;
	private final TextItem clientJobItem;
	private final TextItem clientWeixinItem;
	private final TextItem clientQqItem;
	private final TextItem clientEmailItem;
	private final TextItem clientRoleItem;

	public MclientctractorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMclientctractor.getInstance());
		contractIdItem = new TextItem("contractId", "合同编码");
		clientNameItem = new TextItem("clientName", "联系人姓名");
		clientPhoneItem = new TextItem("clientPhone", "联系人手机");
		clientCompanyItem = new TextItem("clientCompany", "单位名称");
		clientJobItem = new TextItem("clientJob", "职务");
		clientWeixinItem = new TextItem("clientWeixin", "微信");
		clientQqItem = new TextItem("clientQq", "QQ");
		clientEmailItem = new TextItem("clientEmail", "邮箱");
		clientRoleItem = new TextItem("clientRole", "0客户    1建筑设计单位联系人");

		setItems(contractIdItem, clientNameItem, clientPhoneItem, clientCompanyItem, clientJobItem, clientWeixinItem, clientQqItem, clientEmailItem, clientRoleItem);

		setNumCols(18);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
