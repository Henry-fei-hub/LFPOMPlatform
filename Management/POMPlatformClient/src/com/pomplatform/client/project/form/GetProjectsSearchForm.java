package com.pomplatform.client.project.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.project.datasource.CDGetProjects;

public class GetProjectsSearchForm extends SearchForm
{


	private final SelectItem departmentManagerIdItem;
	private final TextItem plateManagerIdItem;
	private final SelectItem contractCodeItem;
	private final SelectItem projectCodeItem;
	private final TextItem projectNameItem;
	private final SelectItem projectIdItem;
	private final SelectItem plateIdItem;
	private final SelectItem designTypeItem;
	private final SelectItem departmentIdItem;
	private final SelectItem projectLevelItem;
	private final SelectItem statusItem;
	private final SelectItem projectManageIdItem;
	private final SelectItem businessTypeItem;
	private final SelectItem contractIdItem;
	private final SelectItem subContractIdItem;
	private final TextItem projectSetupFlagItem;
	private final CheckboxItem isLockItem;

	public GetProjectsSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDGetProjects.getInstance());
		departmentManagerIdItem = new SelectItem("departmentManagerId", "部门经理");
		departmentManagerIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		plateManagerIdItem = new TextItem("plateManagerId", "板块负责人");
		contractCodeItem = new SelectItem("contractCode", "合同编号");
//		contractCodeItem.setValueMap(KeyValueManager.getValueMap("contracts"));
		KeyValueManager.loadValueMap("contracts",contractCodeItem);

		projectCodeItem = new SelectItem("projectCode", "项目编号");
//		projectCodeItem.setValueMap(KeyValueManager.getValueMap("main_projects"));
		KeyValueManager.loadValueMap("main_projects",projectCodeItem);
		projectNameItem = new TextItem("projectName", "项目名称");
		projectIdItem = new SelectItem("projectId", "项目编码");
//		KeyValueManager.loadValueMap("projects",projectIdItem);
		KeyValueManager.loadValueMap("projects", projectIdItem);
		plateIdItem = new SelectItem("plateId", "板块");
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		plateIdItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				designTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_15", plateIdItem.getValue() == null ? "" : plateIdItem.getValue().toString()));
			}
		});
		designTypeItem = new SelectItem("designType", "设计类别");
		designTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_15"));
		departmentIdItem = new SelectItem("departmentId", "归属部门");
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		projectLevelItem = new SelectItem("projectLevel", "项目等级");
		projectLevelItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_2"));
		statusItem = new SelectItem("status", "项目状态");
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_16"));
		projectManageIdItem = new SelectItem("projectManageId", "专业负责人");
		projectManageIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		businessTypeItem = new SelectItem("businessType", "业务类别");
		businessTypeItem.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));
		contractIdItem = new SelectItem("contractId", "合同编码");
//		contractIdItem.setValueMap(KeyValueManager.getValueMap("contracts"));
		KeyValueManager.loadValueMap("contracts",contractIdItem);
		subContractIdItem = new SelectItem("subContractId", "子合同编码");
//		subContractIdItem.setValueMap(KeyValueManager.getValueMap("sub_contracts"));
		KeyValueManager.loadValueMap("sub_contracts",subContractIdItem);
		projectSetupFlagItem = new TextItem("projectSetupFlag", ")");
		isLockItem = new CheckboxItem("isLock", "是否加锁");

		setItems(departmentManagerIdItem, plateManagerIdItem, contractCodeItem, projectCodeItem, projectNameItem, projectIdItem, plateIdItem, designTypeItem, departmentIdItem, projectLevelItem, statusItem, projectManageIdItem, businessTypeItem, contractIdItem, subContractIdItem, projectSetupFlagItem, isLockItem);

		setNumCols(34);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
