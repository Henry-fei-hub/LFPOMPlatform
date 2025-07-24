package com.pomplatform.client.reimbursementpackage.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.reimbursementpackage.datasource.CDTravelReimbursementStatus2;

public class TravelReimbursementStatus2SearchForm extends SearchForm
{


	private final TextItem processTypeItem;
	private final SelectItem employeeIdItem;
	private final SelectItem companyIdItem;
	private final SelectItem departmentItem;
	private final TextItem codeItem;

	public TravelReimbursementStatus2SearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDTravelReimbursementStatus2.getInstance());
		processTypeItem = new TextItem("processType", "流程类型");
		employeeIdItem = new SelectItem("employeeId", "处理人");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		companyIdItem = new SelectItem("companyId", "归属公司");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		departmentItem = new SelectItem("department", "归属部门");
		departmentItem.setValueMap(KeyValueManager.getValueMap("departments"));
		codeItem = new TextItem("code", "编号");

		setItems(processTypeItem, employeeIdItem, companyIdItem, departmentItem, codeItem);

		setNumCols(10);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
