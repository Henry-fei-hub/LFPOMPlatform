package com.pomplatform.client.newcontractppcor.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.newcontractppcor.datasource.DSScontractppcor2;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class ScontractppcorUpdateForm2 extends AbstractWizadPage
{


	private final TextItem totalProjectTimeItem;
	private final TextItem designAreasItem;
	private final TextItem coveredAreaItem;
	private final TextItem professionalCooperationItem;
	private final TextItem provinceItem;
	private final TextItem cityItem;
	private final TextItem detailAddressItem;
	private final TextItem customerAddressItem;
	private final TextItem clientContractIdItem;

	public ScontractppcorUpdateForm2() {
		DSScontractppcor2 ds = DSScontractppcor2.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		
		clientContractIdItem = new TextItem("clientContractId", "客户合同编号");
		clientContractIdItem.setWidth("*");
		__formItems.add(clientContractIdItem);
		
		totalProjectTimeItem = new TextItem("totalProjectTime", "项目总工期");
		totalProjectTimeItem.setWidth("*");
		__formItems.add(totalProjectTimeItem);
		
		designAreasItem = new TextItem("designAreas", "总设计面积");
		designAreasItem.setWidth("*");
		__formItems.add(designAreasItem);
		
		coveredAreaItem = new TextItem("coveredArea", "建筑面积");
		coveredAreaItem.setWidth("*");
		__formItems.add(coveredAreaItem);
		
		professionalCooperationItem = new TextItem("professionalCooperation", "配合专业");
		professionalCooperationItem.setWidth("*");
		__formItems.add(professionalCooperationItem);
		
		customerAddressItem = new TextItem("customerAddress", "客户地址");
		customerAddressItem.setWidth("*");
		__formItems.add(customerAddressItem);
		
		provinceItem = new TextItem("province", "省份");
		provinceItem.setWidth("*");
		__formItems.add(provinceItem);
		
		cityItem = new TextItem("city", "城市");
		cityItem.setWidth("*");
		__formItems.add(cityItem);
		
		detailAddressItem = new TextItem("detailAddress", "详细地址");
		detailAddressItem.setWidth("*");
		__formItems.add(detailAddressItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		__form.setCellPadding(10);
		setPageMode(PAGE_MODE_UPDATE);
		addMember(__form);
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSScontractppcor2.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
