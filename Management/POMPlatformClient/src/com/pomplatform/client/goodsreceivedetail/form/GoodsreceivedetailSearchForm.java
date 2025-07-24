package com.pomplatform.client.goodsreceivedetail.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.goodsreceivedetail.datasource.CDGoodsreceivedetail;

public class GoodsreceivedetailSearchForm extends SearchForm
{


	private final TextItem goodsReceiveDetailIdItem;
	private final TextItem goodsReceiveIdItem;
	private final SelectItem employeeIdItem;
	private final PickTreeItem departmentIdItem;
	private final DateTimeItem receiveTimeItem;

	public GoodsreceivedetailSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDGoodsreceivedetail.getInstance());
		goodsReceiveDetailIdItem = new TextItem("goodsReceiveDetailId", "主键编码");
		goodsReceiveIdItem = new TextItem("goodsReceiveId", "主键编码");
		employeeIdItem = new SelectItem("employeeId", "领用人的编码");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		departmentIdItem = new PickTreeItem("departmentId", "部门编码");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments", ""));
		receiveTimeItem = new DateTimeItem("receiveTime", "领用的时间");
		receiveTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, receiveTimeItem);
			}
		});

		setItems(goodsReceiveDetailIdItem, goodsReceiveIdItem, employeeIdItem, departmentIdItem, receiveTimeItem);

		setNumCols(10);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
