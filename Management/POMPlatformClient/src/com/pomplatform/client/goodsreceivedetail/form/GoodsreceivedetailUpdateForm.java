package com.pomplatform.client.goodsreceivedetail.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.goodsreceivedetail.datasource.DSGoodsreceivedetail;

public class GoodsreceivedetailUpdateForm extends AbstractWizadPage
{


	private final SelectItem employeeIdItem;
	private final TextItem employeeNumberItem;
	private final PickTreeItem departmentIdItem;
	private final DateTimeItem receiveTimeItem;
	private final TextItem employeeNameItem;
	private final TextItem isReceiveItem;

	public GoodsreceivedetailUpdateForm() {
		DSGoodsreceivedetail ds = DSGoodsreceivedetail.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		employeeIdItem = new SelectItem("employeeId", "领用人ID");
//		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		KeyValueManager.loadValueMap("employees",employeeIdItem);

		__formItems.add(employeeIdItem);
		employeeNumberItem = new TextItem("employeeNumber", "领用人的工号");
		__formItems.add(employeeNumberItem);
		departmentIdItem = new PickTreeItem("departmentId", "部门");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments", ""));
		__formItems.add(departmentIdItem);
		receiveTimeItem = new DateTimeItem("receiveTime", "领用的时间");
		__formItems.add(receiveTimeItem);
		employeeNameItem = new TextItem("employeeName", "领用人姓名");
		__formItems.add(employeeNameItem);
		isReceiveItem = new TextItem("isReceive", "是否已经领用");
		__formItems.add(isReceiveItem);

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
		manager.setDataSource(DSGoodsreceivedetail.getInstance());
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
