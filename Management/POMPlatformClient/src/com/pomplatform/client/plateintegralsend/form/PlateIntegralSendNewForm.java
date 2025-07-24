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

public class PlateIntegralSendNewForm extends AbstractWizadPage
{


	private final SelectItem plateIdItem;
	private final TextItem sendIntegralItem;
	private final SelectItem employeeIdItem;
	private final DateItem sendDateItem;
	private final TextItem remarkItem;

	public PlateIntegralSendNewForm() {
		DSPlateIntegralSend ds = DSPlateIntegralSend.getInstance();
		__form.setWidth100();
		__form.setHeight100();
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
		addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
		else __form.editNewRecord();
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSPlateIntegralSend.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
