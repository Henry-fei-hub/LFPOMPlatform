package com.pomplatform.client.revenuecapitalsinfo.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.common.SyncDataUtil;
import com.pomplatform.client.revenuecapitalsinfo.datasource.CDRevenueCapitalsInfo;

public class RevenueCapitalsInfoSearchForm extends SearchForm
{


	private final ComboBoxItem yearsItem;
	private final TextItem yearItem;
	private final TextItem contractIdItem;
	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;
	private final TextItem customerNameItem;

	public RevenueCapitalsInfoSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDRevenueCapitalsInfo.getInstance());
		yearsItem = new ComboBoxItem("years", "年份");
		Map<String,Object> map=new HashMap<>();
		Record[] records=SyncDataUtil.getValueByTableNames("ST_RevenueCapitals","find",map);
		if(!BaseHelpUtils.isNullOrEmpty(records)) {
		LinkedHashMap<Integer, Integer>  linkMap=new LinkedHashMap<>();
		for (Record record : records) {
			int year=BaseHelpUtils.getIntValue(record.getAttribute("year"));
			linkMap.put(year, year);
		}
		yearsItem.setValueMap(linkMap);
		}
		yearsItem.setWidth("*");
		
		yearItem = new TextItem("year", "年");
		yearItem.setHidden(true);
		
		contractIdItem = new TextItem("contractId", "contract_id");
		contractIdItem.setHidden(true);
		
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		
		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setWidth("*");
		
		customerNameItem = new TextItem("customerName", "客户名称");
		customerNameItem.setWidth("*");

		setItems(yearsItem, yearItem, contractIdItem, contractCodeItem, contractNameItem, customerNameItem);

		setNumCols(12);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
