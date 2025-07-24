package com.pomplatform.client.projectappendintegralrecordpor.datasource;

import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSprojectappendintegralrecordpor extends DBDataSource {

    public static DSSprojectappendintegralrecordpor instance = null;

    public static DSSprojectappendintegralrecordpor getInstance() {
        if (instance == null) {
            instance = new DSSprojectappendintegralrecordpor("DSSprojectappendintegralrecordpor");
        }
        return instance;
    }

    private final DataSourceIntegerField projectAppendIntegralRecordIdField;
    private final DataSourceIntegerField projectIdField;
    private final DataSourceIntegerField appendIntegralField;
    private final DataSourceFloatField percentageField;
    private final DataSourceDateTimeField appendTimeField;
    private final DataSourceTextField remarkField;

    public DSSprojectappendintegralrecordpor(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_QUERY);
        setActionName("Sprojectappendintegralrecordpor");

        projectAppendIntegralRecordIdField = new DataSourceIntegerField("projectAppendIntegralRecordId", "主键编码");
        projectAppendIntegralRecordIdField.setLength(11);
        projectAppendIntegralRecordIdField.setPrimaryKey(true);
        projectAppendIntegralRecordIdField.setRequired(true);
        projectAppendIntegralRecordIdField.setHidden(true);

        projectIdField = new DataSourceIntegerField("projectId", "项目名称");
        projectIdField.setLength(11);
        projectIdField.setRequired(false);
        projectIdField.setHidden(false);
        KeyValueManager.loadValueMap("projects",projectIdField);

        appendIntegralField = new DataSourceIntegerField("appendIntegral", "追加积分");
        appendIntegralField.setLength(11);
        appendIntegralField.setRequired(false);
        appendIntegralField.setHidden(false);

        percentageField = new DataSourceFloatField("percentage", "核算比例");
        percentageField.setLength(10);
        percentageField.setDecimalPad(2);
        percentageField.setFormat("##,###,##0.00");
        percentageField.setRequired(false);
        percentageField.setHidden(false);

        appendTimeField = new DataSourceDateTimeField("appendTime", "追加时间");
        appendTimeField.setRequired(false);
        appendTimeField.setHidden(false);

        remarkField = new DataSourceTextField("remark", "备注");
        remarkField.setLength(512);
        remarkField.setRequired(false);
        remarkField.setHidden(false);

        setFields(projectAppendIntegralRecordIdField, projectIdField, appendIntegralField, percentageField, appendTimeField, remarkField);
    }

}
