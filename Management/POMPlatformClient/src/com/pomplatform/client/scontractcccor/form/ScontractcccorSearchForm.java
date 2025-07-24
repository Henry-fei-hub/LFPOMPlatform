package com.pomplatform.client.scontractcccor.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.scontractcccor.datasource.CDScontractcccor;

public class ScontractcccorSearchForm extends SearchForm
{


	private final CheckboxItem isSystemAddItem;
	private final TextItem flowStatusItem;
	private final TextItem contractIdItem;
	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;
	private final TextItem statusItem;
	private final TextItem projectCodeItem;
	private final TextItem contractTypeItem;
	private final TextItem projectLevelItem;
	private final TextItem totalProjectTimeItem;
	private final TextItem contractFollowerItem;
	private final TextItem remarkItem;
	private final TextItem signingCompanyNameItem;
	private final TextItem serialNumberItem;
	private final TextItem infoCodeItem;
	private final TextItem contractStatusItem;
	private final TextItem clientContractIdItem;
	private final CheckboxItem isFinishItem;
	private final TextItem detailAddressItem;
	private final TextItem customerAddressItem;

	public ScontractcccorSearchForm() {		
	setHeight100();
	setDataSource(CDScontractcccor.getInstance());
	contractIdItem = new TextItem("contractId", "主订单编码");
	contractIdItem.setHidden(true);
	contractIdItem.setWidth("*");
	contractCodeItem = new TextItem("contractCode", "主订单编号");
	contractCodeItem.setWidth("*");
	contractNameItem = new TextItem("contractName", "主订单名称");
	contractNameItem.setWidth("*");
	statusItem = new TextItem("status", "结算状态");
	statusItem.setHidden(true);
	projectCodeItem = new TextItem("projectCode", "项目编号");
	projectCodeItem.setWidth("*");
	contractTypeItem = new TextItem("contractType", "合同类别");
	contractTypeItem.setHidden(true);
	projectLevelItem = new TextItem("projectLevel", "项目等级");
	projectLevelItem.setHidden(true);
	totalProjectTimeItem = new TextItem("totalProjectTime", "项目总工期");
	totalProjectTimeItem.setHidden(true);
	contractFollowerItem = new TextItem("contractFollower", "合同跟进人");
	contractFollowerItem.setHidden(true);
	remarkItem = new TextItem("remark", "备注");
	remarkItem.setHidden(true);
	signingCompanyNameItem = new TextItem("signingCompanyName", "我方签约公司名称");
	signingCompanyNameItem.setHidden(true);
	flowStatusItem = new TextItem("flowStatus", "流转状态，默认为0表示可以提交到运营管理修改承接部门1表示可以提交到运营管理运营价格2表示可以提交到运营管理运营价格审核3表示审核完成");
	flowStatusItem.setHidden(true);
	serialNumberItem = new TextItem("serialNumber", "流水号");
	serialNumberItem.setHidden(true);
	infoCodeItem = new TextItem("infoCode", "信息编号");
	infoCodeItem.setHidden(true);
	contractStatusItem = new TextItem("contractStatus", "合同状态  0未启动、1待签署、2已签署、3未签搁置、4解除");
	contractStatusItem.setHidden(true);
	clientContractIdItem = new TextItem("clientContractId", "客户合同编号");
	clientContractIdItem.setHidden(true);
	isFinishItem = new CheckboxItem("isFinish", "合同是否完成");
	isFinishItem.setHidden(true);
	isSystemAddItem = new CheckboxItem("isSystemAdd", "是否为erp系统添加  true 为系统添加  false 为数据导入");
	isSystemAddItem.setHidden(true);
	detailAddressItem = new TextItem("detailAddress", "详细地址");
	detailAddressItem.setHidden(true);
	customerAddressItem = new TextItem("customerAddress", "客户地址");
	customerAddressItem.setHidden(true);
	
	setItems(contractIdItem, contractCodeItem, contractNameItem, statusItem, projectCodeItem, contractTypeItem, projectLevelItem, totalProjectTimeItem, contractFollowerItem, remarkItem, signingCompanyNameItem, flowStatusItem, serialNumberItem, infoCodeItem, contractStatusItem, clientContractIdItem, isFinishItem, isSystemAddItem, detailAddressItem, customerAddressItem);

	setNumCols(7);
	ClientUtil.searchFormProcessAccordingToDevice(this);
}

}
