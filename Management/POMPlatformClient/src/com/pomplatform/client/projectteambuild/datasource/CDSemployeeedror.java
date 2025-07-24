package com.pomplatform.client.projectteambuild.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;

public class CDSemployeeedror extends DataSource {

    public static CDSemployeeedror instance = null;

    public static CDSemployeeedror getInstance() {
        if (instance == null) {
            instance = new CDSemployeeedror("CDSemployeeedror");
        }
        return instance;
    }

    private final DataSourceTextField employeeNameField;
    private final DataSourceIntegerField departmentIdField;
    private final DataSourceIntegerField roleIdField;
    private final DataSourceIntegerField gradeIdField;

    public CDSemployeeedror(String dataSourceID) {

        setID(dataSourceID);
        employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
        employeeNameField.setRequired(true);
        employeeNameField.setLength(64);
        employeeNameField.setHidden(false);

        departmentIdField = new DataSourceIntegerField("departmentId", "角色编码");
        departmentIdField.setRequired(false);
        departmentIdField.setLength(11);
        departmentIdField.setHidden(false);

        roleIdField = new DataSourceIntegerField("roleId", "部门编码");
        roleIdField.setRequired(false);
        roleIdField.setLength(11);
        roleIdField.setHidden(false);

        gradeIdField = new DataSourceIntegerField("gradeId", "等级");
        gradeIdField.setRequired(false);
        gradeIdField.setLength(11);
        gradeIdField.setHidden(false);

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

        setFields(employeeNameField, departmentIdField, roleIdField, gradeIdField, currentPageField, pageLinesField);

        setClientOnly(true);
    }

}
