package com.pomplatform.client.productcategory.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.productcategory.datasource.DSProductCategory;

public class ProductCategoryUpdateForm extends AbstractWizadPage
{


	private final TextItem categoryNameItem;
	private final TextItem parentIdItem;
	private final CheckboxItem isEnabledItem;
	private final TextItem createEmployeeIdItem;
	private final DateTimeItem createTimeItem;
	private final TextItem deleteFlagItem;
	private final TextItem remarkItem;

	public ProductCategoryUpdateForm() {
		DSProductCategory ds = DSProductCategory.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		categoryNameItem = new TextItem("categoryName", "类别名称");
		__formItems.add(categoryNameItem);
		parentIdItem = new TextItem("parentId", "父级id");
		__formItems.add(parentIdItem);
		isEnabledItem = new CheckboxItem("isEnabled", "是否可用");
		__formItems.add(isEnabledItem);
		createEmployeeIdItem = new TextItem("createEmployeeId", "创建人");
		__formItems.add(createEmployeeIdItem);
		createTimeItem = new DateTimeItem("createTime", "创建时间");
		__formItems.add(createTimeItem);
		deleteFlagItem = new TextItem("deleteFlag", "删除标志 0未删除  1已删除");
		__formItems.add(deleteFlagItem);
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
		manager.setDataSource(DSProductCategory.getInstance());
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
