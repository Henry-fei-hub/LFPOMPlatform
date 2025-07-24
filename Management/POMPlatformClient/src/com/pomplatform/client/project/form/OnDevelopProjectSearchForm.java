package com.pomplatform.client.project.form;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.data.RoleDefinition;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class OnDevelopProjectSearchForm extends SearchForm
{


	private final SelectItem plateIdItem;
	private final TextItem sheetCodeItem;
	private final TextItem sheetNameItem;

	public OnDevelopProjectSearchForm() {
		setWidth100();
		setHeight100();
		plateIdItem = new SelectItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		//查看所有部门的数据
		if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.DEVELOP_PROJECT_CHECK_ALL)){
			plateIdItem.setDefaultValue(ClientUtil.getPlateId());
			plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		}else if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.DEVELOP_PROJECT_CHECK_MYSELF)){
			String plateIds = PomPlatformClientUtil.getRolePlateId();
			if(!BaseHelpUtils.isNullOrEmpty(plateIds)){
				String[] plateIdArr = plateIds.split(",");
				plateIdItem.setDefaultValue(plateIdArr[0]);
			}
			RoleDefinition.setPlateItemValueMap(plateIdItem,plateIds);
		}
		sheetCodeItem = new TextItem("sheetCode", "项目编号");
		sheetCodeItem.setWidth("*");
		sheetNameItem = new TextItem("sheetName", "项目名称");
		sheetNameItem.setWidth("*");

		setItems(plateIdItem, sheetCodeItem, sheetNameItem);

		setNumCols(7);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
