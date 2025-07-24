package com.pomplatform.client.contract.form;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.contract.datasource.CDContractDistributionNew;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;

import java.util.*;

public class ContractDistributionNewSearchForm extends SearchForm
{


	private final TextItem contractCodeItem;
	private final DateItem startDateItem;
	private final DateItem endDateItem;
	private final TextItem contractNameItem;
	private final SelectItem plateIdItem;
	private final SelectItem businessTypeItem;
	private final SelectItem orderStatusItem;

	public ContractDistributionNewSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDContractDistributionNew.getInstance());
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");

		startDateItem = new DateItem("startDate", "开始时间");
		startDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, startDateItem);
			}
		});
		startDateItem.setWidth("*");

		endDateItem = new DateItem("endDate", "结束时间");
		endDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, endDateItem);
			}
		});
		endDateItem.setWidth("*");

		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setWidth("*");

		plateIdItem = new SelectItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
		if(!ClientUtil.checkIsHavePermission(ERPPermissionStatic.SHOW_CONTRACT_DISTRIBUTION_ALL_DATA)) {
			String plateIds = PomPlatformClientUtil.getRolePlateId();
			if(BaseHelpUtils.isNullOrEmpty(plateIds)){
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
			}else{
				String[] split = plateIds.split(",");
				for (int i=0 ; i<=split.length ; i++){
					int temp = BaseHelpUtils.getIntValue(split[i]);
					switch (temp) {
						case 36:
							map.put(36, "营销一部");
							break;
						case 37:
							map.put(37, "营销八部");
							break;
						case 38:
							map.put(38, "营销五部");
							break;
						case 39:
							map.put(39, "营销二部");
							break;
						case 40:
							map.put(40, "营销三部");
							break;
						case 63:
							map.put(63, "营销六部");
							break;
						case 35:
							map.put(35, "轨交拓展一部");
							break;
						case 33:
							map.put(33, "营销四部");
							break;
						case 34:
							map.put(34, "营销七部");
							break;
						case 32:
							map.put(32, "轨交拓展二部");
							break;
						case 43:
							map.put(43, "投标组");
							break;
						default:
							break;
					}
				}
			}
		}
		plateIdItem.setValueMap(map);

		businessTypeItem = new SelectItem("businessType", "业态");
		businessTypeItem.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));
		businessTypeItem.setWidth("*");

		orderStatusItem = new SelectItem("orderStatus" , "是否组建团队");
		orderStatusItem.setWidth("*");
		LinkedHashMap<Integer, String> params = new LinkedHashMap<>();
		params.put(1, "已组建团队");
		params.put(0, "未组建团队");
		orderStatusItem.setValueMap(params);

		setItems(contractCodeItem,contractNameItem, businessTypeItem, startDateItem, endDateItem , orderStatusItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
