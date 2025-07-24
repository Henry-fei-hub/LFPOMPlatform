package com.pomplatform.client.plateprojectintegraldetail.datasource;

import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSMplateProjectIntegralDetail extends DBDataSource {

    public static DSMplateProjectIntegralDetail instance = null;

    public static DSMplateProjectIntegralDetail getInstance() {
        if (instance == null) {
            instance = new DSMplateProjectIntegralDetail("DSMplateProjectIntegralDetail");
        }
        return instance;
    }

    private final DataSourceIntegerField projectIdField;
    private final DataSourceTextField projectCodeField;
    private final DataSourceTextField subContractCodeField;
    private final DataSourceTextField subContractNameField;
    private final DataSourceTextField projectNameField;
    private final DataSourceIntegerField achieveIntegralField;
    private final DataSourceIntegerField projectIntegralField;
    private final DataSourceIntegerField reserveIntegralField;
    private final DataSourceIntegerField sureIntegralField;
    private final DataSourceIntegerField costIntegralField;
    private final DataSourceIntegerField salaryIntegralField;

    public DSMplateProjectIntegralDetail(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_QUERY);
        setActionName("MplateProjectIntegralDetail");

        projectIdField = new DataSourceIntegerField("projectId", "项目代码");
        projectIdField.setLength(11);
        projectIdField.setRequired(true);
        projectIdField.setHidden(true);
        KeyValueManager.loadValueMap("projects",projectIdField);

        projectCodeField = new DataSourceTextField("projectCode", "项目编号");
        projectCodeField.setLength(64);
        projectCodeField.setRequired(false);
        projectCodeField.setHidden(false);

        subContractCodeField = new DataSourceTextField("subContractCode", "子合同编号");
        subContractCodeField.setLength(64);
        subContractCodeField.setRequired(false);
        subContractCodeField.setHidden(false);

        subContractNameField = new DataSourceTextField("subContractName", "子合同名称");
        subContractNameField.setLength(64);
        subContractNameField.setRequired(false);
        subContractNameField.setHidden(false);

        projectNameField = new DataSourceTextField("projectName", "项目名称");
        projectNameField.setLength(512);
        projectNameField.setRequired(false);
        projectNameField.setHidden(false);

        achieveIntegralField = new DataSourceIntegerField("achieveIntegral", "价值积分");
        achieveIntegralField.setLength(64);
        achieveIntegralField.setRequired(true);
        achieveIntegralField.setHidden(false);

        projectIntegralField = new DataSourceIntegerField("projectIntegral", "项目积分");
        projectIntegralField.setLength(18);
        projectIntegralField.setRequired(false);
        projectIntegralField.setHidden(false);

        reserveIntegralField = new DataSourceIntegerField("reserveIntegral", "预留积分");
        reserveIntegralField.setLength(18);
        reserveIntegralField.setRequired(false);
        reserveIntegralField.setHidden(false);

        sureIntegralField = new DataSourceIntegerField("sureIntegral", "确认积分");
        sureIntegralField.setLength(18);
        sureIntegralField.setRequired(true);
        sureIntegralField.setHidden(false);

        costIntegralField = new DataSourceIntegerField("costIntegral", "项目成本");
        costIntegralField.setLength(18);
        costIntegralField.setRequired(true);
        costIntegralField.setHidden(false);

        salaryIntegralField = new DataSourceIntegerField("salaryIntegral", "人工成本");
        salaryIntegralField.setLength(4);
        salaryIntegralField.setRequired(true);
        salaryIntegralField.setHidden(false);

        setFields(projectIdField, subContractCodeField, subContractNameField, achieveIntegralField, projectIntegralField, reserveIntegralField, sureIntegralField, costIntegralField, salaryIntegralField, projectCodeField, projectNameField);
    }

}
