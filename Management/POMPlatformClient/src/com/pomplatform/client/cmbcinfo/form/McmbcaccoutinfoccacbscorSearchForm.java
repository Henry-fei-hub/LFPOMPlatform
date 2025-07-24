package com.pomplatform.client.cmbcinfo.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.cmbcinfo.datasource.CDMcmbcaccoutinfoccacbscor;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class McmbcaccoutinfoccacbscorSearchForm extends SearchForm {

	private final SelectItem companyRecordIdItem;
	private final TextItem accnbrItem;
	private final TextItem cmbcAccoutInfoIdItem;
	private final TextItem bbknbrItem;
	private final TextItem stscodItem;
	private final TextItem ccynbrItem;

	public McmbcaccoutinfoccacbscorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMcmbcaccoutinfoccacbscor.getInstance());
		companyRecordIdItem = new SelectItem("companyRecordId", "户名");
		companyRecordIdItem.setWidth("*");
		companyRecordIdItem.setValueMap(KeyValueManager.getValueMap("company_records"));
		
		accnbrItem = new TextItem("accnbr", "账号");
		accnbrItem.setWidth("*");
		
		cmbcAccoutInfoIdItem = new TextItem("cmbcAccoutInfoId", "主键");
		cmbcAccoutInfoIdItem.hide();
		
		bbknbrItem = new TextItem("bbknbr", "分行号");
		bbknbrItem.hide();
		
		stscodItem = new TextItem("stscod", "状态 A活动 B冻结 C关户");
		stscodItem.hide();
		
		ccynbrItem = new TextItem("ccynbr", "币种(对应cmbc_codes的cmbc_curreny)");
		ccynbrItem.hide();

		setItems(companyRecordIdItem, accnbrItem, cmbcAccoutInfoIdItem, bbknbrItem, stscodItem, ccynbrItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
