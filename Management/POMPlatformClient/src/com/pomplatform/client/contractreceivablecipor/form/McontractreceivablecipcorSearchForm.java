package com.pomplatform.client.contractreceivablecipor.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.contractreceivablecipor.datasource.CDMcontractreceivablecipcor;

public class McontractreceivablecipcorSearchForm extends SearchForm
{


	private final TextItem contractIdItem;
	private final TextItem infoCodeItem;
	private final TextItem projectCodeItem;
	private final TextItem contractCodeItem;

	public McontractreceivablecipcorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMcontractreceivablecipcor.getInstance());
		contractIdItem = new TextItem("contractId", "合同id");
		infoCodeItem = new TextItem("infoCode", "信息编号");
		projectCodeItem = new TextItem("projectCode", "项目编号");
		contractCodeItem = new TextItem("contractCode", "合同主编号");

		setItems(contractIdItem, infoCodeItem, projectCodeItem, contractCodeItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
