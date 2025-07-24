package com.pomplatform.client.project.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSTrackTalentsMinimumArrangement extends DBDataSource
{


	public static DSTrackTalentsMinimumArrangement instance = null;

	public static DSTrackTalentsMinimumArrangement getInstance() {
		if(instance == null) {
			instance = new DSTrackTalentsMinimumArrangement("DSTrackTalentsMinimumArrangement");
		}
		return instance;
	}

	private final DataSourceIntegerField trackTalentsMinimumArrangementIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField projectTypeField;
	private final DataSourceFloatField maxAmountField;
	private final DataSourceFloatField minAmountField;
	private final DataSourceIntegerField highDesignerField;
	private final DataSourceIntegerField middleDesignerField;
	private final DataSourceIntegerField initialDesignerField;
	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceDateTimeField operateTimeField;
	private final DataSourceTextField remarkField;

	public DSTrackTalentsMinimumArrangement(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("TrackTalentsMinimumArrangement");


		trackTalentsMinimumArrangementIdField = new DataSourceIntegerField("trackTalentsMinimumArrangementId", "主键编码");
		trackTalentsMinimumArrangementIdField.setLength(11);
		trackTalentsMinimumArrangementIdField.setPrimaryKey(true);
		trackTalentsMinimumArrangementIdField.setRequired(true);
		trackTalentsMinimumArrangementIdField.setHidden(true);


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		projectTypeField = new DataSourceIntegerField("projectType", "项目类别");
		projectTypeField.setLength(11);
		projectTypeField.setRequired(false);
		projectTypeField.setHidden(false);
		projectTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_32"));


		maxAmountField = new DataSourceFloatField("maxAmount", "最大金额");
		maxAmountField.setLength(18);
		maxAmountField.setDecimalPad(2);
		maxAmountField.setFormat("#,###,###,###,###,##0.00");
		maxAmountField.setRequired(false);
		maxAmountField.setHidden(false);


		minAmountField = new DataSourceFloatField("minAmount", "最小金额");
		minAmountField.setLength(18);
		minAmountField.setDecimalPad(2);
		minAmountField.setFormat("#,###,###,###,###,##0.00");
		minAmountField.setRequired(false);
		minAmountField.setHidden(false);


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


		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "操作人");
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setRequired(false);
		operateEmployeeIdField.setHidden(true);


		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(true);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		setFields(trackTalentsMinimumArrangementIdField, plateIdField, projectTypeField, maxAmountField, minAmountField, highDesignerField, middleDesignerField, initialDesignerField, operateEmployeeIdField, operateTimeField, remarkField);
	}


}

