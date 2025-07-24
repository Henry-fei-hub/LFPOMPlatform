package com.pomplatform.client.contractchange.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.contractchange.datasource.DSChangeContractInfo;

public class ChangeContractInfoUpdateForm extends AbstractWizadPage
{


	private final TextItem contractChangeIdItem;
	private final TextItem contractIdItem;
	private final TextItem contractAmountItem;
	private final TextItem contractChangeAmountItem;
	private final TextItem contractFinalAmountItem;
	private final TextItem contractChangeViewItem;
	private final TextItem flagItem;
	private final TextItem operateEmployeeIdItem;
	private final DateTimeItem operateTimeItem;
	private final TextItem remarkItem;

	public ChangeContractInfoUpdateForm() {
		DSChangeContractInfo ds = DSChangeContractInfo.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		contractChangeIdItem = new TextItem("contractChangeId", "主键编码");
		contractChangeIdItem.setDisabled(true);
		contractChangeIdItem.setRequired(true);
		IsIntegerValidator contractChangeIdValidator = new IsIntegerValidator();
		contractChangeIdItem.setValidators(contractChangeIdValidator);
		__formItems.add(contractChangeIdItem);
		contractIdItem = new TextItem("contractId", "合同编码");
		__formItems.add(contractIdItem);
		contractAmountItem = new TextItem("contractAmount", "合同金额");
		__formItems.add(contractAmountItem);
		contractChangeAmountItem = new TextItem("contractChangeAmount", "合同变更金额");
		__formItems.add(contractChangeAmountItem);
		contractFinalAmountItem = new TextItem("contractFinalAmount", "合同变更后金额");
		__formItems.add(contractFinalAmountItem);
		contractChangeViewItem = new TextItem("contractChangeView", "金额变更显示");
		__formItems.add(contractChangeViewItem);
		flagItem = new TextItem("flag", "状态");
		__formItems.add(flagItem);
		operateEmployeeIdItem = new TextItem("operateEmployeeId", "操作人");
		__formItems.add(operateEmployeeIdItem);
		operateTimeItem = new DateTimeItem("operateTime", "操作时间");
		__formItems.add(operateTimeItem);
		remarkItem = new TextItem("remark", "备注");
		__formItems.add(remarkItem);

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
		manager.setDataSource(DSChangeContractInfo.getInstance());
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
