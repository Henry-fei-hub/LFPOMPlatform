package com.pomplatform.client.plateintegralsend.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.plateintegralsend.datasource.DSPlateIntegralSend;

public class PlateIntegralSendUpdateForm extends AbstractWizadPage
{


	private final TextItem plateIntegralSendIdItem;
	private final SelectItem plateIdItem;
	private final TextItem sendIntegralItem;
	private final SelectItem employeeIdItem;
	private final DateItem sendDateItem;
	private final TextItem remarkItem;

	public PlateIntegralSendUpdateForm() {
		DSPlateIntegralSend ds = DSPlateIntegralSend.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		plateIntegralSendIdItem = new TextItem("plateIntegralSendId", "主键编码");
		plateIntegralSendIdItem.setWidth("*");
		plateIntegralSendIdItem.setDisabled(true);
		plateIntegralSendIdItem.setRequired(true);
		IsIntegerValidator plateIntegralSendIdValidator = new IsIntegerValidator();
		plateIntegralSendIdItem.setValidators(plateIntegralSendIdValidator);
		__formItems.add(plateIntegralSendIdItem);
		plateIdItem = new SelectItem("plateId", "业务部门");
		plateIdItem.setValueMap((LinkedHashMap)ds.getField("plateId").getValueMap());
		__formItems.add(plateIdItem);
		sendIntegralItem = new TextItem("sendIntegral", "补贴积分");
		sendIntegralItem.setWidth("*");
		__formItems.add(sendIntegralItem);
		employeeIdItem = new SelectItem("employeeId", "操作人");
		employeeIdItem.setValueMap((LinkedHashMap)ds.getField("employeeId").getValueMap());
		__formItems.add(employeeIdItem);
		sendDateItem = new DateItem("sendDate", "补贴日期");
		__formItems.add(sendDateItem);
		remarkItem = new TextItem("remark", "备注");
		remarkItem.setWidth("*");
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
		manager.setDataSource(DSPlateIntegralSend.getInstance());
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
