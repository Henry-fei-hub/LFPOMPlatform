package com.pomplatform.client.contract.form;

import java.util.*;

import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.contract.datasource.CDContractCommissionDetail;

public class ContractCommissionDetailSearchForm extends SearchForm
{


	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;
	private final SelectItem plateIdItem;
	private final SelectItem yearItem;
	private final SelectItem monthItem;

	public ContractCommissionDetailSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDContractCommissionDetail.getInstance());
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setWidth("*");
		plateIdItem = new SelectItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
		if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.SHOW_CONTRACT_DISTRIBUTION_MAN_DATA)){
			String plateIds = PomPlatformClientUtil.getRolePlateId();
			String[] split = plateIds.split(",");
			for (int i=0 ; i<split.length ; i++){
				switch (split[i]){
					case "36":
						map.put(36 , "营销一部");
						break;
					case "37":
						map.put(37 , "营销八部");
						break;
					case "38":
						map.put(38 , "营销五部");
						break;
					case "39":
						map.put(39 , "营销二部");
						break;
					case "40":
						map.put(40 , "营销三部");
						break;
					case "63":
						map.put(63 , "营销六部");
						break;
					case "35":
						map.put(35 , "轨交拓展一部");
						break;
					case "33":
						map.put(33 , "营销四部");
						break;
					case "34":
						map.put(34 , "营销七部");
						break;
					case "32":
						map.put(32 , "轨交拓展二部");
						break;
					case "43":
						map.put(43 , "投标组");
						break;
				}
			}
		}
		else if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.SHOW_CONTRACT_DISTRIBUTION_ALL_DATA)){
			map.put(36, "营销一部");
			map.put(37, "营销八部");
			map.put(38, "营销五部");
			map.put(39, "营销二部");
			map.put(40, "营销三部");
			map.put(63, "营销六部");
			map.put(35, "轨交拓展一部");
			map.put(33, "营销四部");
			map.put(34, "营销七部");
			map.put(32, "轨交拓展二部");
			map.put(43, "投标组");
		}
		plateIdItem.setValueMap(map);
		yearItem = new SelectItem("year", "年份");
		KeyValueManager.loadValueMap("system_dictionary_18" , yearItem);
		yearItem.setWidth("*");
		monthItem = new SelectItem("month", "月份");
		KeyValueManager.loadValueMap("system_dictionary_19" , monthItem);
		monthItem.setWidth("*");

		setItems(contractCodeItem, contractNameItem, plateIdItem, yearItem, monthItem);

		setNumCols(10);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
