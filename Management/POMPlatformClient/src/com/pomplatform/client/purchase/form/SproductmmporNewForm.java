package com.pomplatform.client.purchase.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.purchase.datasource.DSSproductmmpor;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.IPickTreeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class SproductmmporNewForm extends AbstractWizadPage {

	private final IPickTreeItem categoryIdItem;
	private final TextItem productNameItem;
	private final TextItem productUnitItem;
	private final SelectItem productTypeItem;
	private final TextItem productModelItem;
	private final TextItem productSpecificationItem;
	private final TextItem productSkinsSizeItem;
	private final CheckboxItem isEnabledItem;
	private final TextItem createEmployeeIdItem;
	private final TextItem remarkItem;

	public SproductmmporNewForm() {
		DSSproductmmpor ds = DSSproductmmpor.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		
		categoryIdItem = new IPickTreeItem("categoryId", "产品类别");
		categoryIdItem.setWidth("*");
		categoryIdItem.setCanSelectParentItems(true);
		categoryIdItem.setValueTree(KeyValueManager.getTree("product_categories"));
		categoryIdItem.setValueField("treeId");
		categoryIdItem.setWidth("*");
		__formItems.add(categoryIdItem);
		
		productNameItem = new TextItem("productName", "产品名称");
		productNameItem.setRequired(true);
		productNameItem.setWidth("*");
		__formItems.add(productNameItem);
		
		productTypeItem = new SelectItem("productType", "产品类型");
		productTypeItem.setRequired(true);
		productTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_192"));
		productTypeItem.setWidth("*");
		__formItems.add(productTypeItem);
		
		productUnitItem = new TextItem("productUnit", "产品单位");
		productUnitItem.setWidth("*");
		__formItems.add(productUnitItem);
		
		productModelItem = new TextItem("productModel", "产品型号");
		productModelItem.setWidth("*");
		__formItems.add(productModelItem);
		
		productSpecificationItem = new TextItem("productSpecification", "产品规格");
		productSpecificationItem.setWidth("*");
		__formItems.add(productSpecificationItem);
		
		productSkinsSizeItem = new TextItem("productSkinsSize", "产品外观尺寸");
		productSkinsSizeItem.setWidth("*");
		__formItems.add(productSkinsSizeItem);
		
		isEnabledItem = new CheckboxItem("isEnabled", "是否可用");
		isEnabledItem.setWidth("*");
		isEnabledItem.setDefaultValue(true);
		__formItems.add(isEnabledItem);
		
		createEmployeeIdItem = new TextItem("createEmployeeId", "创建人");
		createEmployeeIdItem.hide();
		createEmployeeIdItem.setDefaultValue(ClientUtil.getEmployeeId());
		__formItems.add(createEmployeeIdItem);
		
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
		return __form.validate();
	}

	@Override
	public void startEdit() {
		if (getRecord() != null)
			__form.editRecord(getRecord());
		else
			__form.editNewRecord();
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSSproductmmpor.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}

}
