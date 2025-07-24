package com.pomplatform.client.preprojects.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.preprojects.datasource.DSPreProjectReport;

public class PreProjectReportNewForm extends AbstractWizadPage
{


	private final TextItem infoCodeItem;
	private final TextItem projectNameItem;
	private final TextItem customerNameItem;
	private final TextItem provinceItem;
	private final TextItem cityItem;
	private final TextItem detailAddressItem;
	private final SelectItem projectTypeItem;
	private final TextItem totalBuildingAreasItem;
	private final TextItem projectOriginationItem;

	public PreProjectReportNewForm() {
		DSPreProjectReport ds = DSPreProjectReport.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		infoCodeItem = new TextItem("infoCode", "信息编号");
		__formItems.add(infoCodeItem);
		projectNameItem = new TextItem("projectName", "项目名称");
		__formItems.add(projectNameItem);
		customerNameItem = new TextItem("customerName", "客户名称");
		__formItems.add(customerNameItem);
		provinceItem = new TextItem("province", "省份");
		__formItems.add(provinceItem);
		cityItem = new TextItem("city", "城市");
		__formItems.add(cityItem);
		detailAddressItem = new TextItem("detailAddress", "详细地址");
		__formItems.add(detailAddressItem);
		projectTypeItem = new SelectItem("projectType", "项目类别");
		projectTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_32"));
		__formItems.add(projectTypeItem);
		totalBuildingAreasItem = new TextItem("totalBuildingAreas", "建筑总面积");
		__formItems.add(totalBuildingAreasItem);
		projectOriginationItem = new TextItem("projectOrigination", "项目来源渠道");
		__formItems.add(projectOriginationItem);

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
		manager.setDataSource(DSPreProjectReport.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
