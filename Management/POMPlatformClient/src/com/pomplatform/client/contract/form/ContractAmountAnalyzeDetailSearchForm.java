package com.pomplatform.client.contract.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.contract.datasource.CDContractAmountAnalyzeDetail;

public class ContractAmountAnalyzeDetailSearchForm extends SearchForm
{


	private final TextItem contractSigningStatusItem;
	private final TextItem yearItem;
	private final SelectItem monthItem;
	private final ComboBoxItem plateIdItem;

	public ContractAmountAnalyzeDetailSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDContractAmountAnalyzeDetail.getInstance());
		contractSigningStatusItem = new TextItem("contractSigningStatus", "合同签订状态");
		yearItem = new TextItem("year", "年份");
		monthItem = new SelectItem("month", "月份");
		monthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setChangeOnKeypress(false);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));	

		setItems(contractSigningStatusItem, yearItem, monthItem, plateIdItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
