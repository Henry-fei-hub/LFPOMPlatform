package com.pomplatform.client.purchase.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.purchase.datasource.CDSproductmmpor;

public class SproductmmporSearchForm extends SearchForm {

	private final DateTimeItem minCreateTimeItem;
	private final DateTimeItem maxCreateTimeItem;
	private final TextItem productModelItem;
	private final TextItem productSpecificationItem;
	private final TextItem remarkItem;
	private final TextItem productIdItem;
	private final IPickTreeItem categoryIdItem;
	private final TextItem productTypeItem;
	private final CheckboxItem isEnabledItem;
	private final TextItem createEmployeeIdItem;
	private final TextItem deleteFlagItem;

	public SproductmmporSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSproductmmpor.getInstance());
		minCreateTimeItem = new DateTimeItem("minCreateTime", "最早创建时间");
		minCreateTimeItem.hide();
		minCreateTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, minCreateTimeItem);
			}
		});
		maxCreateTimeItem = new DateTimeItem("maxCreateTime", "最晚创建时间");
		maxCreateTimeItem.hide();
		maxCreateTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, maxCreateTimeItem);
			}
		});
		productModelItem = new TextItem("productModel", "产品型号");
		productModelItem.setWidth("*");
		
		productSpecificationItem = new TextItem("productSpecification", "产品规格");
		productSpecificationItem.setWidth("*");
		
		remarkItem = new TextItem("remark", "备注");
		remarkItem.setWidth("*");
		
		productIdItem = new TextItem("productId", "主键编码");
		productIdItem.hide();
		
		categoryIdItem = new IPickTreeItem("categoryId", "产品类别");
		categoryIdItem.setWidth("*");
		categoryIdItem.setCanSelectParentItems(true);
		categoryIdItem.setValueTree(KeyValueManager.getTree("product_categories"));
		categoryIdItem.setValueField("treeId");
		
		productTypeItem = new TextItem("productType", "产品类型");
		productTypeItem.setWidth("*");
		
		isEnabledItem = new CheckboxItem("isEnabled", "是否可用");
		isEnabledItem.hide();
		
		createEmployeeIdItem = new TextItem("createEmployeeId", "创建人");
		createEmployeeIdItem.hide();
		
		deleteFlagItem = new TextItem("deleteFlag", "删除标志 0未删除  1已删除");
		deleteFlagItem.hide();

		setItems(minCreateTimeItem, maxCreateTimeItem, productModelItem, productSpecificationItem, remarkItem,
				productIdItem, categoryIdItem, productTypeItem, isEnabledItem, createEmployeeIdItem, deleteFlagItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
