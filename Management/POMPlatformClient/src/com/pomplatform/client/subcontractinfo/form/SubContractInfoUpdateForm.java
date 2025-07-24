package com.pomplatform.client.subcontractinfo.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.subcontractinfo.datasource.DSSubContractInfo;

public class SubContractInfoUpdateForm extends AbstractWizadPage
{


	private final TextItem subContractIdItem;
	private final SelectItem parentIdItem;
	private final SelectItem subContractCodeItem;
	private final SelectItem projectCodeItem;
	private final TextItem businessTypeItem;
	private final SelectItem projectTypeItem;
	private final SelectItem departmentIdItem;
	private final TextItem commonAreaItem;
	private final TextItem logisticsAreaItem;
	private final TextItem moneySumItem;
	private final DateTimeItem createTimeItem;

	public SubContractInfoUpdateForm() {
		DSSubContractInfo ds = DSSubContractInfo.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		subContractIdItem = new TextItem("subContractId", "子合同编码");
		subContractIdItem.setWidth("*");
		subContractIdItem.setDisabled(true);
		subContractIdItem.setRequired(true);
		IsIntegerValidator subContractIdValidator = new IsIntegerValidator();
		subContractIdItem.setValidators(subContractIdValidator);
		__formItems.add(subContractIdItem);
		parentIdItem = new SelectItem("parentId", "主合同");
		parentIdItem.setValueMap((LinkedHashMap)ds.getField("parentId").getValueMap());
		__formItems.add(parentIdItem);
		subContractCodeItem = new SelectItem("subContractCode", "子合同编号");
		subContractCodeItem.setValueMap((LinkedHashMap)ds.getField("subContractCode").getValueMap());
		__formItems.add(subContractCodeItem);
		projectCodeItem = new SelectItem("projectCode", "项目编号");
		projectCodeItem.setValueMap((LinkedHashMap)ds.getField("projectCode").getValueMap());
		__formItems.add(projectCodeItem);
		businessTypeItem = new TextItem("businessType", "业务类型");
		businessTypeItem.setWidth("*");
		__formItems.add(businessTypeItem);
		projectTypeItem = new SelectItem("projectType", "项目类型");
		projectTypeItem.setValueMap((LinkedHashMap)ds.getField("projectType").getValueMap());
		__formItems.add(projectTypeItem);
		departmentIdItem = new SelectItem("departmentId", "承接部门");
		departmentIdItem.setValueMap((LinkedHashMap)ds.getField("departmentId").getValueMap());
		__formItems.add(departmentIdItem);
		commonAreaItem = new TextItem("commonArea", "公区面积");
		commonAreaItem.setWidth("*");
		__formItems.add(commonAreaItem);
		logisticsAreaItem = new TextItem("logisticsArea", "后勤面积");
		logisticsAreaItem.setWidth("*");
		__formItems.add(logisticsAreaItem);
		moneySumItem = new TextItem("moneySum", "小计");
		moneySumItem.setWidth("*");
		__formItems.add(moneySumItem);
		createTimeItem = new DateTimeItem("createTime", "创建时间");
		__formItems.add(createTimeItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		setPageMode(PAGE_MODE_UPDATE);
		addMember(__form);
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSSubContractInfo.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
