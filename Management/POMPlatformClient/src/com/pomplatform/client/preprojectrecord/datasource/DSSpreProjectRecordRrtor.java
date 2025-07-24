package com.pomplatform.client.preprojectrecord.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceLinkField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSSpreProjectRecordRrtor extends DBDataSource
{


	public static DSSpreProjectRecordRrtor instance = null;

	public static DSSpreProjectRecordRrtor getInstance() {
		if(instance == null) {
			instance = new DSSpreProjectRecordRrtor("DSSpreProjectRecordRrtor");
		}
		return instance;
	}

	private final DataSourceIntegerField preProjectRecordIdField;
	private final DataSourceTextField relevantEmployeesField;
	private final DataSourceTextField relevantEmployeesDisplayValueField;
	private final DataSourceDateField trackDateField;
	private final DataSourceIntegerField informationTypeField;
	private final DataSourceTextField remarkField;
	private final DataSourceLinkField attachmentField;
	private final DataSourceIntegerField registerEmployeeField;
	private final DataSourceDateField registerDateField;
	private final DataSourceTextField trackCodeField;
	private final DataSourceIntegerField mainProjectIdField;
	private final DataSourceTextField contractAmountField;
	private final DataSourceTextField designPriceField;

	public DSSpreProjectRecordRrtor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("SpreProjectRecordRrtor");


		preProjectRecordIdField = new DataSourceIntegerField("preProjectRecordId", "主键id");
		preProjectRecordIdField.setLength(11);
		preProjectRecordIdField.setHidden(true);
		preProjectRecordIdField.setPrimaryKey(true);
		preProjectRecordIdField.setRequired(true);


		relevantEmployeesField = new DataSourceTextField("relevantEmployees", "相关人员");
		relevantEmployeesField.setLength(1024);
		relevantEmployeesField.setValueMap(KeyValueManager.getValueMap("employees"));
		relevantEmployeesField.setRequired(false);
		relevantEmployeesField.setHidden(true);
		
		relevantEmployeesDisplayValueField = new DataSourceTextField("relevantEmployeesDisplayValue", "相关人员");
		relevantEmployeesDisplayValueField.setLength(255);
		relevantEmployeesDisplayValueField.setRequired(false);
		relevantEmployeesDisplayValueField.setHidden(false);


		trackDateField = new DataSourceDateField("trackDate", "跟踪时间");
		trackDateField.setRequired(false);
		trackDateField.setHidden(false);


		informationTypeField = new DataSourceIntegerField("informationType", "信息类型");
		informationTypeField.setLength(11);
		informationTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_153"));
		informationTypeField.setRequired(false);
		informationTypeField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "情况描述");
		remarkField.setLength(512);
		remarkField.setRequired(true);
		remarkField.setHidden(false);


		attachmentField = new DataSourceLinkField("attachmentName", "附件");
		attachmentField.setLength(1024);
		attachmentField.setRequired(false);
		attachmentField.setHidden(false);


		registerEmployeeField = new DataSourceIntegerField("registerEmployee", "登记人");
		registerEmployeeField.setLength(11);
		registerEmployeeField.setValueMap(KeyValueManager.getValueMap("employees"));
		registerEmployeeField.setRequired(false);
		registerEmployeeField.setHidden(false);


		registerDateField = new DataSourceDateField("registerDate", "登记时间");
		registerDateField.setRequired(false);
		registerDateField.setHidden(false);


		trackCodeField = new DataSourceTextField("trackCode", "跟踪编号");
		trackCodeField.setLength(255);
		trackCodeField.setRequired(false);
		trackCodeField.setHidden(false);


		mainProjectIdField = new DataSourceIntegerField("mainProjectId", "项目id");
		mainProjectIdField.setLength(11);
		mainProjectIdField.setHidden(true);
		mainProjectIdField.setRequired(false);
		
		contractAmountField = new DataSourceTextField("contractAmount", "设计费总价(元)");
		contractAmountField.setLength(32);
		contractAmountField.setRequired(true);
		contractAmountField.setHidden(false);
		
		designPriceField = new DataSourceTextField("designPrice", "设计详细报价");
		designPriceField.setLength(512);
		designPriceField.setRequired(true);
		designPriceField.setHidden(false);

		setFields(preProjectRecordIdField,trackCodeField,trackDateField, relevantEmployeesDisplayValueField, relevantEmployeesField, remarkField, attachmentField, registerDateField,  registerEmployeeField,informationTypeField,  mainProjectIdField,contractAmountField,designPriceField);
	}


}

