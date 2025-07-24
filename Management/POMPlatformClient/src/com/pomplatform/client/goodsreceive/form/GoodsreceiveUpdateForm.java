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

public class GoodsreceiveUpdateForm extends AbstractWizadPage
{


	private final TextItem subjectItem;
	private final DateTimeItem createTimeItem;
	private final DateTimeItem receiveDateItem;
	private final TextItem countItem;
	private final SelectItem createPersonIdItem;
	private final TextItem goodsDetailItem;

	public GoodsreceiveUpdateForm() {
		DSGoodsreceive ds = DSGoodsreceive.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		subjectItem = new TextItem("subject", "主题");
		__formItems.add(subjectItem);
		subjectItem.setWidth("*");
		createTimeItem = new DateTimeItem("createTime", "创建时间");
		__formItems.add(createTimeItem);
		createTimeItem.setHidden(true);
		receiveDateItem = new DateTimeItem("receiveDate", "领取日期");
		__formItems.add(receiveDateItem);
		receiveDateItem.setWidth("*");
		countItem = new TextItem("count", "物品数量");
		__formItems.add(countItem);
		countItem.setWidth("*");
		createPersonIdItem = new SelectItem("createPersonId", "创建人");
		createPersonIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		createPersonIdItem.setWidth("*");
		__formItems.add(createPersonIdItem);
		goodsDetailItem = new TextItem("goodsDetail", "物品详情");
		goodsDetailItem.setWidth("*");
		__formItems.add(goodsDetailItem);

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
		manager.setDataSource(DSGoodsreceive.getInstance());
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
