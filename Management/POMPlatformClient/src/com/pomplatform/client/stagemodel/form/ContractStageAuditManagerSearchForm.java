package com.pomplatform.client.stagemodel.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.stagemodel.datasource.CDContractStageAuditManager;

public class ContractStageAuditManagerSearchForm extends SearchForm
{


	private final SelectItem employeeIdItem;
	private final TextItem contractIdItem;
	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;
	private final CheckboxItem lockedItem;
	private final SelectItem auditStatusItem;

	public ContractStageAuditManagerSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDContractStageAuditManager.getInstance());
		
		employeeIdItem = new SelectItem("employeeId", "职员");
		employeeIdItem.hide();
		
		contractIdItem = new TextItem("contractId", "合同");
		contractIdItem.hide();
		
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		
		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setWidth("*");
		
		lockedItem = new CheckboxItem("locked", "是否锁定");
		
		auditStatusItem = new SelectItem("auditStatus", "审批状态");
		auditStatusItem.setWidth("*");
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		map.put(ClientStaticUtils.CONTRACT_STAGE_AUDIT_STATUS_1, "未审批");
		map.put(ClientStaticUtils.CONTRACT_STAGE_AUDIT_STATUS_2, "已审批");
		auditStatusItem.setValueMap(map);
		auditStatusItem.setDefaultValue(ClientStaticUtils.CONTRACT_STAGE_AUDIT_STATUS_1);

		setItems(employeeIdItem, contractIdItem, contractCodeItem, contractNameItem, auditStatusItem, lockedItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
