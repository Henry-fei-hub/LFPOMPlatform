package com.pomplatform.client.goodsreceive.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.goodsreceive.datasource.DSGoodsreceive;

public class GoodsreceiveNewForm extends AbstractWizadPage
{


	private final TextItem subjectItem;
	private final DateTimeItem receiveDateItem;
	private final TextItem countItem;
	private final SelectItem createPersonIdItem;
	private final TextItem goodsDetailItem;

	public GoodsreceiveNewForm() {
		DSGoodsreceive ds = DSGoodsreceive.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		subjectItem = new TextItem("subject", "主题");
		__formItems.add(subjectItem);
		subjectItem.setWidth("*");
		receiveDateItem = new DateTimeItem("receiveDate", "领用日期");
		__formItems.add(receiveDateItem);
		receiveDateItem.setWidth("*");
		countItem = new TextItem("count", "物品数量");
		__formItems.add(countItem);
		countItem.setWidth("*");
		createPersonIdItem = new SelectItem("createPersonId", "创建人");
		createPersonIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		__formItems.add(createPersonIdItem);
		createPersonIdItem.setWidth("*");
		goodsDetailItem = new TextItem("goodsDetail", "物品详情");
		__formItems.add(goodsDetailItem);
		goodsDetailItem.setWidth("*");
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
		manager.setDataSource(DSGoodsreceive.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
