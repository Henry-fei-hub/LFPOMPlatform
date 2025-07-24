package com.pomplatform.client.goodsreceive.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.goodsreceive.datasource.CDGoodsreceive;

public class GoodsreceiveSearchForm extends SearchForm
{


	private final TextItem goodsReceiveIdItem;
	private final TextItem subjectItem;
	private final DateTimeItem createTimeItem;
	private final DateTimeItem receiveDateItem;
	private final TextItem receiveCountItem;

	public GoodsreceiveSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDGoodsreceive.getInstance());
		goodsReceiveIdItem = new TextItem("goodsReceiveId", "主键编码");
		goodsReceiveIdItem.setWidth("*");
		subjectItem = new TextItem("subject", "主题");
		subjectItem.setWidth("*");
		createTimeItem = new DateTimeItem("createTime", "创建时间");
		createTimeItem.setWidth("*");
		createTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, createTimeItem);
			}
		});
		receiveDateItem = new DateTimeItem("receiveDate", "日期");
		receiveDateItem.setWidth("*");
		receiveDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, receiveDateItem);
			}
		});
		receiveCountItem = new TextItem("receiveCount", "领用数量");
		receiveCountItem.setWidth("*");
		setItems(goodsReceiveIdItem, subjectItem, createTimeItem, receiveDateItem, receiveCountItem);

		setNumCols(10);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
