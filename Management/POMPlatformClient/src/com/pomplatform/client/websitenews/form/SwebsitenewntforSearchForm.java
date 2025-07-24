package com.pomplatform.client.websitenews.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.websitenews.datasource.CDSwebsitenewntfor;

public class SwebsitenewntforSearchForm extends SearchForm
{


	private final TextItem newTypeItem;
	private final TextItem titleItem;
	private final TextItem fileUrlItem;
	private final TextItem contentItem;
	private final TextItem websiteNewIdItem;
	private final SelectItem deleteFlagItem;

	public SwebsitenewntforSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSwebsitenewntfor.getInstance());
		newTypeItem = new TextItem("newType", "新闻类型  1公告");
		newTypeItem.hide();
		titleItem = new TextItem("title", "主题");
		titleItem.setWidth("*");
		fileUrlItem = new TextItem("fileUrl", "文件路径");
		fileUrlItem.hide();
		contentItem = new TextItem("content", "内容");
		contentItem.setWidth("*");
		websiteNewIdItem = new TextItem("websiteNewId", "主键");
		websiteNewIdItem.hide();
		deleteFlagItem = new SelectItem("deleteFlag", "是否删除");
		deleteFlagItem.setDefaultValue("1");
		deleteFlagItem.setWidth("*");
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		map.put("1", "未删除");
		map.put("2", "已删除");
		deleteFlagItem.setValueMap(map);
		setItems(newTypeItem, titleItem, fileUrlItem, contentItem, websiteNewIdItem, deleteFlagItem);

		setNumCols(12);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
