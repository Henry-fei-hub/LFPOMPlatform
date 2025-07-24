package com.pomplatform.client.cwd.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.cwd.datasource.CDSoftwareUpdateVersionWithS;

public class SoftwareUpdateVersionWithSSearchForm extends SearchForm
{


	private final TextItem titleItem;
	private final TextItem remarkItem;
	private final TextItem sqlScriptItem;
	private final TextItem softwareUpdateVersionIdItem;
	private final TextItem versionNoItem;
	private final TextItem softwareTypeItem;
	private final SelectItem employeeIdItem;
	private final CheckboxItem isRebootItem;

	public SoftwareUpdateVersionWithSSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSoftwareUpdateVersionWithS.getInstance());
		titleItem = new TextItem("title", "更新主题");
		remarkItem = new TextItem("remark", "更新详情描述,说明更新了什么内容");
		sqlScriptItem = new TextItem("sqlScript", "sql脚本");
		softwareUpdateVersionIdItem = new TextItem("softwareUpdateVersionId", "主键");
		versionNoItem = new TextItem("versionNo", "版本号唯一 初始1.0 每次加0.1");
		softwareTypeItem = new TextItem("softwareType", "软件类型，1-本地文件服务器，2-本地存储服务器");
		employeeIdItem = new SelectItem("employeeId", "操作人");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		isRebootItem = new CheckboxItem("isReboot", "是否需要重启服务 true需要 false不需要");

		setItems(titleItem, remarkItem, sqlScriptItem, softwareUpdateVersionIdItem, versionNoItem, softwareTypeItem, employeeIdItem, isRebootItem);

		setNumCols(16);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
