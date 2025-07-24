package com.pomplatform.client.specialdeduction.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.specialdeduction.datasource.CDSpecialDeductionRecordsApplyOfWorkflow;

public class SpecialDeductionRecordsApplyOfWorkflowSearchForm extends SearchForm
{


	private final TextItem employeIdItem;
	private final TextItem companyIdItem;
	private final TextItem plateIdItem;
	private final TextItem documentTypeItem;
	private final TextItem spouseSituationItem;
	private final TextItem phoneItem;
	private final CheckboxItem isEnableItem;
	private final TextItem departmentIdItem;

	public SpecialDeductionRecordsApplyOfWorkflowSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSpecialDeductionRecordsApplyOfWorkflow.getInstance());
		employeIdItem = new TextItem("employeId", "纳税人id");
		employeIdItem.hide();
		companyIdItem = new TextItem("companyId", "归属公司");
		companyIdItem.hide();
		plateIdItem = new TextItem("plateId", "业务部门");
		plateIdItem.hide();
		documentTypeItem = new TextItem("documentType", "身份证件类型");
		spouseSituationItem = new TextItem("spouseSituation", "配偶情况 （0 无  1有）");
		phoneItem = new TextItem("phone", "手机号码");
		isEnableItem = new CheckboxItem("isEnable", "是否可用");
		departmentIdItem = new TextItem("departmentId", "组织部门");

		setItems(employeIdItem, companyIdItem, plateIdItem, documentTypeItem, spouseSituationItem, phoneItem, isEnableItem, departmentIdItem);

		setNumCols(16);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
