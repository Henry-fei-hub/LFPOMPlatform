package com.pomplatform.client.contract.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.contract.datasource.CDShowContractDistribution;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class ShowContractDistributionSearchForm extends SearchForm
{


	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;
	private final TextItem orderIdItem;
	private final TextItem plateIdItem;
	private final TextItem operationManagerIdItem;
	private final SelectItem startYearItem;
	private final SelectItem startMonthItem;
	private final SelectItem endYearItem;
	private final SelectItem endMonyhItem;

	public ShowContractDistributionSearchForm() {
		setWidth100();
		setHeight("200");
		setDataSource(CDShowContractDistribution.getInstance());
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");

		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setWidth("*");

		orderIdItem = new TextItem("orderId", "订单号");
		orderIdItem.setWidth("*");
		orderIdItem.setHidden(true);

		plateIdItem = new TextItem("plateId", "业务部门");
		plateIdItem.setHidden(true);
		
		operationManagerIdItem = new TextItem("operationManagerId", "部门经理");
		operationManagerIdItem.setHidden(true);
		
		startYearItem = new SelectItem("startYearTime","开始年份");
		startYearItem.setHidden(false);
		startYearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
		startYearItem.setWidth("*");
		
		startMonthItem = new SelectItem("startMonthTime","开始月份");
		startMonthItem.setHidden(false);
		startMonthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));
		startMonthItem.setWidth("*");
		
		endYearItem = new SelectItem("endYearTime","结束年份");
		endYearItem.setHidden(false);
		endYearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
		endYearItem.setWidth("*");
		
		endMonyhItem = new SelectItem("endMonthTime","结束月份");
		endMonyhItem.setHidden(false);
		endMonyhItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));
		endMonyhItem.setWidth("*");

		setItems(contractCodeItem, contractNameItem, orderIdItem, plateIdItem, operationManagerIdItem,startYearItem,startMonthItem,endYearItem,endMonyhItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
