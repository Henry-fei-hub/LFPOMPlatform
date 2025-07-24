package com.pomplatform.client.workflow.personnelbusiness.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.*;

public class DSpersonnelLinkReturn extends DBDataSource
{


	public static DSpersonnelLinkReturn instance = null;

	public static DSpersonnelLinkReturn getInstance() {
		if(instance == null) {
			instance = new DSpersonnelLinkReturn("DSPersonnelBusinessLinkEquipment");
		}
		return instance;
	}

	private final DataSourceIntegerField personnelBusinessLinkReturnIdField;
	private final DataSourceIntegerField personnelBusinessIdField;
	private final DataSourceIntegerField typeField;
	private final DataSourceIntegerField personnelBusinessLinkEquipmentIdField;
	private final DataSourceIntegerField returnAmountField;
	private final DataSourceDateField returnTimeField;
	private final DataSourceTextField remarkField;


	public DSpersonnelLinkReturn(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("PersonnelBusinessLinkReturn");


		personnelBusinessLinkReturnIdField = new DataSourceIntegerField("personnelBusinessLinkReturnId", "设备采购");
		personnelBusinessLinkReturnIdField.setLength(11);
		personnelBusinessLinkReturnIdField.setPrimaryKey(true);
		personnelBusinessLinkReturnIdField.setRequired(true);
		personnelBusinessLinkReturnIdField.setHidden(true);


		personnelBusinessIdField = new DataSourceIntegerField("personnelBusinessId", "流程表主键");
		personnelBusinessIdField.setLength(11);
		personnelBusinessIdField.setRequired(false);
		personnelBusinessIdField.setHidden(true);

		typeField = new DataSourceIntegerField("type", "类型");
		typeField.setLength(11);
		typeField.setRequired(false);
		typeField.setHidden(false);
		typeField.setValueMap(KeyValueManager.getValueMap("equipment_types_all"));

		personnelBusinessLinkEquipmentIdField = new DataSourceIntegerField("personnelBusinessLinkEquipmentId", "关联表主键");
		personnelBusinessLinkEquipmentIdField.setLength(11);
		personnelBusinessLinkEquipmentIdField.setRequired(false);
		personnelBusinessLinkEquipmentIdField.setHidden(true);

		returnAmountField = new DataSourceIntegerField("returnAmount", "归还数量");
		returnAmountField.setLength(11);
		returnAmountField.setRequired(false);
		returnAmountField.setHidden(false);

		returnTimeField = new DataSourceDateField("returnTime", "归还时间");
		returnTimeField.setLength(11);
		returnTimeField.setRequired(false);
		returnTimeField.setHidden(false);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		setFields(personnelBusinessLinkEquipmentIdField , typeField, returnAmountField,returnTimeField, remarkField);
	}


}

