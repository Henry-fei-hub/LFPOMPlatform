package com.pomplatform.client.contract.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.pomplatform.client.projectteambuild.datasource.CDSemployeeedror;

import java.util.LinkedHashMap;

public class TeamBuildingSearchForm extends SearchForm {

    private final TextItem employeeNameItem;
    private final SelectItem departmentIdItem;

    public TeamBuildingSearchForm() {
        setWidth100();
        setHeight100();
        setDataSource(CDSemployeeedror.getInstance());
        employeeNameItem = new TextItem("employeeName", "职员");
        employeeNameItem.setWidth("*");

        departmentIdItem = new SelectItem("departmentId", "部门");
        departmentIdItem.setWidth("*");
        LinkedHashMap<Integer, Object> map = new LinkedHashMap<>();
        map.put(136, "营销一部");
        map.put(137, "营销八部");
        map.put(152, "营销五部");
        map.put(137, "营销二部");
        map.put(138, "营销三部");
        map.put(155, "营销六部");
        map.put(140, "轨交拓展一部");
        map.put(146, "营销四部");
        map.put(147, "营销七部");
        map.put(145, "轨交拓展二部");
        departmentIdItem.setValueMap(map);

        setItems(employeeNameItem,departmentIdItem);

        setNumCols(6);
    }

}
