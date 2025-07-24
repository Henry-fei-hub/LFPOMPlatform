package com.pomplatform.client.stagemodel.form;

import java.util.LinkedHashMap;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.stagemodel.datasource.CDContractStageAudit;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class ContractStageAuditSearchForm extends SearchForm
{


	private final SelectItem employeeIdItem;
	private final SelectItem contractIdItem;
	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;
	private final CheckboxItem lockedItem;
	private final SelectItem auditStatusItem;
	/**
	 * 未审批
	 */
	public static final String STATUS_1 = "1";
	/**
	 * 已审批
	 */
	public static final String STATUS_2 = "2";
	
	public ContractStageAuditSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDContractStageAudit.getInstance());
		
		employeeIdItem = new SelectItem("employeeId", "职员");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.hide();
		
		contractIdItem = new SelectItem("contractId", "合同");
		contractIdItem.setValueMap(KeyValueManager.getValueMap("contracts"));
		contractIdItem.hide();
		
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		
		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setWidth("*");
		
		auditStatusItem = new SelectItem("auditStatus", "审批状态");
		auditStatusItem.setWidth("*");
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		map.put(STATUS_1, "未审批");
		map.put(STATUS_2, "已审批");
		auditStatusItem.setValueMap(map);
		
		lockedItem = new CheckboxItem("locked", "是否锁定");

		setItems(employeeIdItem, contractIdItem, contractCodeItem, contractNameItem, auditStatusItem, lockedItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
