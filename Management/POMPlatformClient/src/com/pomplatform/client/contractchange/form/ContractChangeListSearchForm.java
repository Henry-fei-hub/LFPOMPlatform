package com.pomplatform.client.contractchange.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.contractchange.datasource.CDContractChangeList;

public class ContractChangeListSearchForm extends SearchForm
{


	private final SelectItem flagItem;
	private final ComboBoxItem contractIdItem;
	private final TextItem contractCodeItem;
	private final DateItem startTimeItem;
	private final DateItem endTimeItem;

	public ContractChangeListSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDContractChangeList.getInstance());
		
		flagItem = new SelectItem("flag", "状态");
		flagItem.setWidth("*");
		if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.CONTRACT_CHANGE_AUDITOR)) {
			flagItem.setDefaultValue("3");
		}else{
			flagItem.setDefaultValue("1");
		}
		flagItem.setValueMap((LinkedHashMap)getDataSource().getField("flag").getValueMap());
		
		contractIdItem = new ComboBoxItem("contractId", "合同名称");
		contractIdItem.setChangeOnKeypress(false);
		contractIdItem.setWidth("*");
		contractIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
//		contractIdItem.setValueMap(KeyValueManager.getValueMap("contracts_1"));
		KeyValueManager.loadValueMap("contracts_1", contractIdItem);
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		
		startTimeItem = new DateItem("startTime", "开始时间");
		startTimeItem.setUseTextField(true);
		startTimeItem.setWidth("*");
		
		endTimeItem = new DateItem("endTime", "结束时间");
		endTimeItem.setUseTextField(true);
		endTimeItem.setWidth("*");

		setItems(contractCodeItem, contractIdItem, flagItem, startTimeItem, endTimeItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
