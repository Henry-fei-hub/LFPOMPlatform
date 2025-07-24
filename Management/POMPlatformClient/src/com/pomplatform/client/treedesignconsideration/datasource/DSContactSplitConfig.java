package com.pomplatform.client.treedesignconsideration.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSContactSplitConfig extends DBDataSource
{


	public static DSContactSplitConfig instance = null;

	public static DSContactSplitConfig getInstance() {
		if(instance == null) {
			instance = new DSContactSplitConfig("DSContactSplitConfig");
		}
		return instance;
	}

	private final DataSourceIntegerField contactSplitConfigIdField;
	private final DataSourceTextField nameField;
	private final DataSourceFloatField programmeField;
	private final DataSourceFloatField deepenField;
	private final DataSourceFloatField electromechanicalField;
	private final DataSourceFloatField lightingField;
	private final DataSourceFloatField serviceField;
	private final DataSourceTextField remarkField;

	public DSContactSplitConfig(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("ContactSplitConfig");


		contactSplitConfigIdField = new DataSourceIntegerField("contactSplitConfigId", "主键");
		contactSplitConfigIdField.setLength(11);
		contactSplitConfigIdField.setPrimaryKey(true);
		contactSplitConfigIdField.setRequired(true);
		contactSplitConfigIdField.setHidden(true);


		nameField = new DataSourceTextField("name", "合同分类名称");
		nameField.setLength(128);
		nameField.setRequired(false);
		nameField.setHidden(false);


		programmeField = new DataSourceFloatField("programme", "方案(%)");
		programmeField.setLength(18);
		programmeField.setDecimalPad(5);
		programmeField.setFormat("#,###,###,###,##0.00");
		programmeField.setRequired(false);
		programmeField.setHidden(false);


		deepenField = new DataSourceFloatField("deepen", "深化(%)");
		deepenField.setLength(18);
		deepenField.setDecimalPad(5);
		deepenField.setFormat("#,###,###,###,##0.00");
		deepenField.setRequired(false);
		deepenField.setHidden(false);


		electromechanicalField = new DataSourceFloatField("electromechanical", "机电配合(%)");
		electromechanicalField.setLength(18);
		electromechanicalField.setDecimalPad(5);
		electromechanicalField.setFormat("#,###,###,###,##0.00");
		electromechanicalField.setRequired(false);
		electromechanicalField.setHidden(false);


		lightingField = new DataSourceFloatField("lighting", "灯光配合(%)");
		lightingField.setLength(18);
		lightingField.setDecimalPad(5);
		lightingField.setFormat("#,###,###,###,##0.00");
		lightingField.setRequired(false);
		lightingField.setHidden(false);


		serviceField = new DataSourceFloatField("service", "驻场服务(%)");
		serviceField.setLength(18);
		serviceField.setDecimalPad(5);
		serviceField.setFormat("#,###,###,###,##0.00");
		serviceField.setRequired(false);
		serviceField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(512);
		remarkField.setRequired(false);
		remarkField.setHidden(true);


		setFields(contactSplitConfigIdField, nameField, programmeField, deepenField, electromechanicalField, lightingField, serviceField, remarkField);
	}


}

