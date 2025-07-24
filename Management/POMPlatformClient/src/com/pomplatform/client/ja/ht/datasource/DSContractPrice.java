package com.pomplatform.client.ja.ht.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;

public class DSContractPrice extends DBDataSource
{


	public static DSContractPrice instance = null;

	public static DSContractPrice getInstance() {
		if(instance == null) {
			instance = new DSContractPrice("DSContractPrice");
		}
		return instance;
	}

	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceIntegerField mainProjectStageIdField;
	private final DataSourceIntegerField customerIdField;
	private final DataSourceTextField parentNameField;
	private final DataSourceIntegerField clientIdField;
	private final DataSourceTextField customerNameField;
	private final DataSourceTextField mainDesignAreaNameField;
	private final DataSourceFloatField designAreaField;
	private final DataSourceFloatField designUnitPriceField;
	private final DataSourceFloatField moneySumField;

	public DSContractPrice(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ContractPrice");


		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(64);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(false);


		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setLength(512);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);


		mainProjectStageIdField = new DataSourceIntegerField("mainProjectStageId", "立项类型");
		mainProjectStageIdField.setLength(11);
		mainProjectStageIdField.setRequired(false);
		mainProjectStageIdField.setHidden(false);
		mainProjectStageIdField.setValueMap(KeyValueManager.getValueMap("main_project_stages"));

		customerIdField = new DataSourceIntegerField("customerId", "集团id");
		customerIdField.setLength(11);
		customerIdField.setPrimaryKey(true);
		customerIdField.setRequired(true);
		customerIdField.setHidden(true);
		customerIdField.setValueMap(KeyValueManager.getValueMap("customers_name"));


		parentNameField = new DataSourceTextField("parentName", "集团名称");
		parentNameField.setLength(128);
		parentNameField.setRequired(true);
		parentNameField.setHidden(false);

		customerNameField = new DataSourceTextField("customerName", "客户名称");
		customerNameField.setLength(50);
		customerNameField.setRequired(false);
		customerNameField.setHidden(false);
		customerNameField.setValueMap(KeyValueManager.getValueMap("customers_name"));
//		KeyValueManager.loadValueMap("customers_name",customerNameField);

		clientIdField = new DataSourceIntegerField("clientId", "客户id");
		clientIdField.setLength(11);
		clientIdField.setRequired(false);
		clientIdField.setHidden(false);


		mainDesignAreaNameField = new DataSourceTextField("mainDesignAreaName", "业务类型");
		mainDesignAreaNameField.setLength(64);
		mainDesignAreaNameField.setRequired(false);
		mainDesignAreaNameField.setHidden(false);
//		mainDesignAreaNameField.setValueMap(KeyValueManager.getValueMap("pre_business_type_detail"));

		designAreaField = new DataSourceFloatField("designArea", "面积");
		designAreaField.setLength(16);
		designAreaField.setDecimalPad(2);
		designAreaField.setFormat("##,###,###,###,##0.00");
		designAreaField.setRequired(false);
		designAreaField.setHidden(false);


		designUnitPriceField = new DataSourceFloatField("designUnitPrice", "单价");
		designUnitPriceField.setLength(16);
		designUnitPriceField.setDecimalPad(2);
		designUnitPriceField.setFormat("##,###,###,###,##0.00");
		designUnitPriceField.setRequired(false);
		designUnitPriceField.setHidden(false);


		moneySumField = new DataSourceFloatField("moneySum", "总价");
		moneySumField.setLength(16);
		moneySumField.setDecimalPad(4);
		moneySumField.setFormat("###,###,###,##0.0000");
		moneySumField.setRequired(false);
		moneySumField.setHidden(false);


		setFields(projectCodeField, projectNameField, mainProjectStageIdField,customerIdField,parentNameField, customerNameField, mainDesignAreaNameField, designAreaField, designUnitPriceField, moneySumField);
	}


}

