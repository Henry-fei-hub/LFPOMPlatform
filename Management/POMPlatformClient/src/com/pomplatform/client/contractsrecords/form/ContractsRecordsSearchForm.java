package com.pomplatform.client.contractsrecords.form;

import java.text.SimpleDateFormat;
import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TimeUnit;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.contractsrecords.datasource.CDContractsRecords;

public class ContractsRecordsSearchForm extends SearchForm
{


	private final TextItem contractIdItem;
	private final TextItem contractNameItem;
	private final TextItem contractAmountItem;
	private final SelectItem contractStatusItem;
	private final TextItem remarkItem;
	private final TextItem registerEmployeeItem;
	private final TextItem relevantEmployeesItem;
	private final TextItem relevantEmployeesNameItem;
	private final TextItem customerNameItem;
	private final TextItem contractCodeItem;
	private final DateTimeItem trackDateStartItem;
	private final DateTimeItem trackDateEndItem;
	private final SelectItem trackTypeItem;
	private final TextItem infoCodeItem;
	private final TextItem projectNameItem;

	public ContractsRecordsSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDContractsRecords.getInstance());
		contractIdItem = new TextItem("contractId", "合同编码");
		contractIdItem.setHidden(true);
		
		infoCodeItem = new TextItem("infoCode", "信息编号");
		infoCodeItem.setWidth("*");
		
		projectNameItem = new TextItem("projectName", "项目名称");
		projectNameItem.setWidth("*");
		
		
		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setWidth("*");
		
		contractAmountItem = new TextItem("contractAmount", "合同金额");
		contractAmountItem.setWidth("*");
		
		contractStatusItem = new SelectItem("contractStatus", "合同签订状态");
		contractStatusItem.setWidth("*");
		contractStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_139"));
		
		trackTypeItem=new SelectItem("trackType", "跟踪状态");
		trackTypeItem.setWidth("*");
		trackTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_209"));
		
		
		remarkItem = new TextItem("remark", "跟踪情况描述");
		remarkItem.setHidden(true);
		
		
		trackDateStartItem = new DateTimeItem("trackDateStart", "跟踪起始时间");
		trackDateStartItem.setWidth("*");
		
		
		trackDateEndItem = new DateTimeItem("trackDateEnd", "跟踪结束时间");
		trackDateEndItem.setWidth("*");
		
		registerEmployeeItem = new ComboBoxItem("registerEmployee", "登记人");
		registerEmployeeItem.setWidth("*");
		registerEmployeeItem.setValueMap(KeyValueManager.getValueMap("employees"));
		registerEmployeeItem.setChangeOnKeypress(false);
		
		
		
		relevantEmployeesItem = new ComboBoxItem("relevantEmployees", "相关人员");
		relevantEmployeesItem.setWidth("*");
		relevantEmployeesItem.setHidden(true);
		relevantEmployeesItem.setValueMap(KeyValueManager.getValueMap("employees"));
		relevantEmployeesItem.setChangeOnKeypress(false);
		
		relevantEmployeesNameItem = new TextItem("relevantEmployeesName", "相关人员名称");
		relevantEmployeesNameItem.setHidden(true);
		
		customerNameItem = new TextItem("customerName", "客户名称");
		customerNameItem.setWidth("*");
		
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		

		setItems(infoCodeItem,projectNameItem,contractNameItem,contractCodeItem,contractStatusItem,trackTypeItem,trackDateStartItem,trackDateEndItem,registerEmployeeItem,customerNameItem);

		setNumCols(10);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
