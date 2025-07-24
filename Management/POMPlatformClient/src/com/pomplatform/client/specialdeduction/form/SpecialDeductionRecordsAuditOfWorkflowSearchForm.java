package com.pomplatform.client.specialdeduction.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.specialdeduction.datasource.CDSpecialDeductionRecordsAuditOfWorkflow;

public class SpecialDeductionRecordsAuditOfWorkflowSearchForm extends SearchForm
{

	private final SelectItem companyIdItem;
	private final TextItem plateIdItem;
	private final CheckboxItem isEnableItem;

	public SpecialDeductionRecordsAuditOfWorkflowSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSpecialDeductionRecordsAuditOfWorkflow.getInstance());
		companyIdItem = new SelectItem("companyId", "归属公司");
		companyIdItem.setWidth("*");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("company_records"));
		
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));
		
		isEnableItem = new CheckboxItem("isEnable", "是否可用");
		isEnableItem.setWidth("*");

		setItems(companyIdItem, plateIdItem,isEnableItem);

		setNumCols(7);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
