package com.pomplatform.client.mcapitalsubcontractscoor.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSMcapitalsubcontractscoor extends DBDataSource
{


	public static DSMcapitalsubcontractscoor instance = null;

	public static DSMcapitalsubcontractscoor getInstance() {
		if(instance == null) {
			instance = new DSMcapitalsubcontractscoor("DSMcapitalsubcontractscoor");
		}
		return instance;
	}

	private final DataSourceIntegerField subContractIdField;
	private final DataSourceTextField subContractCodeField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField subContractNameField;
	private final DataSourceIntegerField capitalIdField;
	private final DataSourceIntegerField capitalSubContractIdField;
	private final DataSourceFloatField moneyField;
	private final DataSourceDateTimeField creatTimeField;
	private final DataSourceIntegerField operatorIdField;

	public DSMcapitalsubcontractscoor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Mcapitalsubcontractscoor");


		subContractIdField = new DataSourceIntegerField("subContractId", "子订单编码");
		subContractIdField.setLength(11);
		subContractIdField.setRequired(false);
		subContractIdField.setHidden(true);


		subContractCodeField = new DataSourceTextField("subContractCode", "订单编号");
		subContractCodeField.setLength(64);
		subContractCodeField.setRequired(false);
		subContractCodeField.setHidden(false);


		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(64);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(false);


		subContractNameField = new DataSourceTextField("subContractName", "子合同名称");
		subContractNameField.setLength(64);
		subContractNameField.setRequired(false);
		subContractNameField.setHidden(false);


		capitalIdField = new DataSourceIntegerField("capitalId", "回款编码");
		capitalIdField.setLength(11);
		capitalIdField.setRequired(false);
		capitalIdField.setHidden(true);


		capitalSubContractIdField = new DataSourceIntegerField("capitalSubContractId", "主键");
		capitalSubContractIdField.setLength(11);
		capitalSubContractIdField.setPrimaryKey(true);
		capitalSubContractIdField.setRequired(true);
		capitalSubContractIdField.setHidden(true);


		moneyField = new DataSourceFloatField("money", "金额");
		moneyField.setLength(16);
		moneyField.setDecimalPad(2);
		moneyField.setFormat("##,###,###,###,##0.00");
		moneyField.setRequired(false);
		moneyField.setHidden(false);


		creatTimeField = new DataSourceDateTimeField("creatTime", "创建时间");
		creatTimeField.setRequired(false);
		creatTimeField.setHidden(true);


		operatorIdField = new DataSourceIntegerField("operatorId", "操作人");
		operatorIdField.setLength(11);
		operatorIdField.setRequired(false);
		operatorIdField.setHidden(true);


		setFields(capitalSubContractIdField, subContractIdField, subContractCodeField, projectCodeField, subContractNameField, capitalIdField, moneyField, creatTimeField, operatorIdField);
	}


}

