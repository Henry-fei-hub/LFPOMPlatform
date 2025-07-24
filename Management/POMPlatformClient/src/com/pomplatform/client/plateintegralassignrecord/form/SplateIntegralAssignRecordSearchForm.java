package com.pomplatform.client.plateintegralassignrecord.form;

import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.plateintegralassignrecord.datasource.CDSplateIntegralAssignRecord;

public class SplateIntegralAssignRecordSearchForm extends SearchForm {

    private final SelectItem employeeIdItem;
    private final ComboBoxItem plateIdItem;

    public SplateIntegralAssignRecordSearchForm() {
        setWidth100();
        setHeight100();
        setDataSource(CDSplateIntegralAssignRecord.getInstance());
        employeeIdItem = new SelectItem("employeeId", "发放人员");
        employeeIdItem.setWidth("*");
//        employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
        KeyValueManager.loadValueMap("employees",employeeIdItem);
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));	

        setItems(plateIdItem,employeeIdItem);

        setNumCols(4);
        ClientUtil.searchFormProcessAccordingToDevice(this);
    }

}
