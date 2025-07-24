package com.pomplatform.client.mainprojectinfo.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMainProjectInfo extends DataSource {

    public static CDMainProjectInfo instance = null;

    public static CDMainProjectInfo getInstance() {
        if (instance == null) {
            instance = new CDMainProjectInfo("CDMainProjectInfo");
        }
        return instance;
    }

    private final DataSourceTextField projectCodeField;
    private final DataSourceIntegerField projectBaseOnField;
    private final DataSourceBooleanField hasContractField;

    public CDMainProjectInfo(String dataSourceID) {

        setID(dataSourceID);
        projectCodeField = new DataSourceTextField("projectCode", "项目名称");
        projectCodeField.setRequired(false);
        projectCodeField.setLength(64);
        projectCodeField.setHidden(false);
//        projectCodeField.setValueMap(KeyValueManager.getValueMap("main_projects"));
        KeyValueManager.loadValueMap("main_projects",projectCodeField);
        projectBaseOnField = new DataSourceIntegerField("projectBaseOn", "立项依据");
        projectBaseOnField.setRequired(false);
        projectBaseOnField.setLength(11);
        projectBaseOnField.setHidden(false);
        projectBaseOnField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

        hasContractField = new DataSourceBooleanField("hasContract", "是否有合同");
        hasContractField.setRequired(false);
        hasContractField.setHidden(false);

        DataSourceIntegerField currentPageField
                = new DataSourceIntegerField("currentPage", "当前页");
        currentPageField.setRequired(true);
        currentPageField.setLength(10);
        currentPageField.setHidden(true);

        DataSourceIntegerField pageLinesField
                = new DataSourceIntegerField("pageLines", "每页行数");
        pageLinesField.setRequired(true);
        pageLinesField.setLength(10);
        pageLinesField.setHidden(true);

        setFields(projectCodeField, projectBaseOnField, hasContractField, currentPageField, pageLinesField);

        setClientOnly(true);
    }

}
