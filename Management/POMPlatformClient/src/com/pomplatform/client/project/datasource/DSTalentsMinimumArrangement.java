package com.pomplatform.client.project.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSTalentsMinimumArrangement extends DBDataSource
{


	public static DSTalentsMinimumArrangement instance = null;

	public static DSTalentsMinimumArrangement getInstance() {
		if(instance == null) {
			instance = new DSTalentsMinimumArrangement("DSTalentsMinimumArrangement");
		}
		return instance;
	}

	private final DataSourceIntegerField talentsMinimumArrangementIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField highDesignerField;
	private final DataSourceIntegerField middleDesignerField;
	private final DataSourceIntegerField initialDesignerField;
	private final DataSourceIntegerField projectLevelField;
	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceDateTimeField operateTimeField;
	private final DataSourceTextField remarkField;

	public DSTalentsMinimumArrangement(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("TalentsMinimumArrangement");


		talentsMinimumArrangementIdField = new DataSourceIntegerField("talentsMinimumArrangementId", "主键编码");
		talentsMinimumArrangementIdField.setLength(11);
		talentsMinimumArrangementIdField.setPrimaryKey(true);
		talentsMinimumArrangementIdField.setRequired(true);
		talentsMinimumArrangementIdField.setHidden(false);


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		highDesignerField = new DataSourceIntegerField("highDesigner", "高级设计师");
		highDesignerField.setLength(11);
		highDesignerField.setRequired(false);
		highDesignerField.setHidden(false);


		middleDesignerField = new DataSourceIntegerField("middleDesigner", "中级设计师");
		middleDesignerField.setLength(11);
		middleDesignerField.setRequired(false);
		middleDesignerField.setHidden(false);


		initialDesignerField = new DataSourceIntegerField("initialDesigner", "初级设计师");
		initialDesignerField.setLength(11);
		initialDesignerField.setRequired(false);
		initialDesignerField.setHidden(false);

		
		projectLevelField = new DataSourceIntegerField("projectLevel", "项目级别");
		projectLevelField.setLength(11);
		projectLevelField.setRequired(false);
		projectLevelField.setHidden(false);
		projectLevelField.setValueMap(KeyValueManager.getValueMap("system_dictionary_2"));
		

		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "操作人");
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setRequired(false);
		operateEmployeeIdField.setHidden(false);


		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		setFields(talentsMinimumArrangementIdField, plateIdField, highDesignerField, middleDesignerField, initialDesignerField,  operateEmployeeIdField, projectLevelField, operateTimeField, remarkField);
	}


}

