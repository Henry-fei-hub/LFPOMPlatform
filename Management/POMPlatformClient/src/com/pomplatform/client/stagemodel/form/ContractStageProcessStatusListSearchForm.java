package com.pomplatform.client.stagemodel.form;

import java.util.LinkedHashMap;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.stagemodel.datasource.CDContractStageProcessStatusList;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class ContractStageProcessStatusListSearchForm extends SearchForm
{


	private final SelectItem processStatusItem;
	private final SelectItem contractIdItem;
	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;
	private final ComboBoxItem managerIdItem;
	private final ComboBoxItem designDirectorIdItem;

	public ContractStageProcessStatusListSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDContractStageProcessStatusList.getInstance());
		processStatusItem = new SelectItem("processStatus", "流程状态");
		processStatusItem.setWidth("*");
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		map.put(ClientStaticUtils.CONTRACT_STAGE_PROCESS_STATUS_1, "运行中");
		map.put(ClientStaticUtils.CONTRACT_STAGE_PROCESS_STATUS_3, "已完成");
		processStatusItem.setValueMap(map);
		
		contractIdItem = new SelectItem("contractId", "合同");
		contractIdItem.hide();
		
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		
		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setWidth("*");
		
		managerIdItem = new ComboBoxItem("managerId", "项目经理");
		managerIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		managerIdItem.setChangeOnKeypress(false);
		managerIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		managerIdItem.setWidth("*");
		
		designDirectorIdItem = new ComboBoxItem("designDirectorId", "驻场人员/设计总监");
		designDirectorIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		designDirectorIdItem.setChangeOnKeypress(false);
		designDirectorIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		designDirectorIdItem.setWidth("*");

		setItems(contractIdItem, contractCodeItem, contractNameItem, processStatusItem, managerIdItem, designDirectorIdItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
