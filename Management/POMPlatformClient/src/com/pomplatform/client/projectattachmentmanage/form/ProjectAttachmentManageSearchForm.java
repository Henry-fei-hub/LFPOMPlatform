package com.pomplatform.client.projectattachmentmanage.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.data.RoleDefinition;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class ProjectAttachmentManageSearchForm extends SearchForm
{


	private final ComboBoxItem plateIdItem;
	private final TextItem contractCodeItem;
	private final TextItem projectNameItem;
	private final CheckboxItem isQualifiedItem;

	public ProjectAttachmentManageSearchForm() {
		setWidth100();
		setHeight100();
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setWidth("*");
		//查看所有部门的数据
		if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.REVENUE_ATTACHMENT_CHECK_ALL)){
			plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		}else if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.REVENUE_ATTACHMENT_CHECK_MYSELF)){
			plateIdItem.setDefaultValue(ClientUtil.getPlateId());
			String plateIds = PomPlatformClientUtil.getRolePlateId();
			RoleDefinition.setPlateItemValueMap(plateIdItem,plateIds);
		}

		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		projectNameItem = new TextItem("projectName", "订单名称");
		projectNameItem.setWidth("*");
		isQualifiedItem = new CheckboxItem("isQualified", "是否合格");
		setItems(plateIdItem,contractCodeItem, projectNameItem, isQualifiedItem);
		setNumCols(9);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
