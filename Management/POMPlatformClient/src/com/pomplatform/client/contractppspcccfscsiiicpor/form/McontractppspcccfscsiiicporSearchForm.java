package com.pomplatform.client.contractppspcccfscsiiicpor.form;

import java.util.logging.Logger;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.contractppspcccfscsiiicpor.datasource.CDMcontractppspcccfscsiiicpor;
import com.pomplatform.client.data.RoleDefinition;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class McontractppspcccfscsiiicporSearchForm extends SearchForm
{

	private static final Logger __LOGGER = Logger.getLogger("");
	private final TextItem projectNameItem;
	private final TextItem subContractCodeItem;
	private final TextItem projectIdItem;
	private final TextItem contractIdItem;
	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;
	private final TextItem flowStatusItem;
	private final TextItem signingMoneySumItem;
	private final TextItem contractPriceItem;
	private final SelectItem statusItem;
	private final CheckboxItem isFinishItem;
	private final CheckboxItem isSystemAddItem;
	private final TextItem infoCodeItem;
	private final TextItem customerNameItem;
	private final TextItem projectCodeItem;
	private final SelectItem plateIdItem;
	private final SelectItem contractStatusItem;

	public McontractppspcccfscsiiicporSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMcontractppspcccfscsiiicpor.getInstance());
		projectNameItem = new TextItem("projectName", "订单名称");
		projectNameItem.setWidth("*");
		subContractCodeItem = new TextItem("subContractCode", "订单编号");
		subContractCodeItem.setWidth("*");
		projectIdItem = new TextItem("projectId", "订单编码");
		projectIdItem.hide();
		contractIdItem = new TextItem("contractId", "合同编码");
		contractIdItem.hide();
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setWidth("*");
		flowStatusItem = new TextItem("flowStatus", "流转状态，默认为0表示可以提交到运营管理修改承接部门1表示可以提交到运营管理运营价格2表示可以提交到运营管理运营价格审核3表示审核完成");
		flowStatusItem.hide();
		signingMoneySumItem = new TextItem("signingMoneySum", "签约总金额");
		signingMoneySumItem.setWidth("*");
		contractPriceItem = new TextItem("contractPrice", "合同单价");
		contractPriceItem.setWidth("*");
		statusItem = new SelectItem("status", "结算状态");
		statusItem.hide();
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_39"));
		isFinishItem = new CheckboxItem("isFinish", "合同是否完成");
		isFinishItem.hide();
		isSystemAddItem = new CheckboxItem("isSystemAdd", "是否为erp系统添加  true 为系统添加  false 为数据导入");
		isSystemAddItem.hide();
		infoCodeItem = new TextItem("infoCode", "信息编号");
		infoCodeItem.setWidth("*");
		customerNameItem = new TextItem("customerName", "客户名称");
		customerNameItem.hide();
		customerNameItem.setWidth("*");
		projectCodeItem = new TextItem("projectCode", "项目编号");
		projectCodeItem.setWidth("*");
		
		plateIdItem = new SelectItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		//如果拥有查查所有部门的权限
		if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.MANAGE_CONTRACT_SHOW_ALL)) {
			plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		}else if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.MANAGE_CONTRACT_SHOW_PLATE)){
			String plateIds = PomPlatformClientUtil.getRolePlateId();
			String[] arr = plateIds.split(",");
			if(arr.length > 0){
				plateIdItem.setDefaultValue(arr[0]);
			}
			RoleDefinition.setPlateItemValueMap(plateIdItem,plateIds);
		}

		contractStatusItem = new SelectItem("contractStatusM","合同状态");
		contractStatusItem.setMultiple(true);
		contractStatusItem.setWidth("*");
		contractStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_35"));
		
		setItems(contractCodeItem, contractNameItem, projectCodeItem, subContractCodeItem, projectNameItem, projectIdItem, plateIdItem, signingMoneySumItem, contractPriceItem, contractStatusItem, contractIdItem, flowStatusItem, statusItem, isFinishItem, isSystemAddItem, customerNameItem, projectCodeItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
