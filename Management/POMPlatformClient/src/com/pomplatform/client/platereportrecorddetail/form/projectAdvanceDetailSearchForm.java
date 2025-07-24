package com.pomplatform.client.platereportrecorddetail.form;

import java.util.*;

import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.data.RoleDefinition;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.platereportrecorddetail.datasource.CDprojectAdvanceDetail;

public class projectAdvanceDetailSearchForm extends SearchForm
{


	private final TextItem projectIdItem;
	private final SelectItem plateIdItem;
	private final TextItem contractCodeItem;
	private final TextItem projectNameItem;
	private final SelectItem flagItem;

	public projectAdvanceDetailSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDprojectAdvanceDetail.getInstance());
		projectIdItem = new TextItem("projectId", "补贴项目");
		projectIdItem.setWidth("*");
		projectIdItem.setHidden(true);
		plateIdItem = new SelectItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		//如果拥有查看所有的权限
		SC.debugger();
		if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.PROJECT_ADVANCE_DETAIL_ALL)){
			plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
			//如果只拥有查看自己管理部门的权限
		}else if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.PROJECT_ADVANCE_DETAIL_OWNER)){
			String plateIds = PomPlatformClientUtil.getRolePlateId();
			RoleDefinition.setPlateItemValueMap(plateIdItem,plateIds);
		}
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		projectNameItem = new TextItem("projectName", "项目名称");
		projectNameItem.setWidth("*");
		flagItem = new SelectItem("flag", "补贴类型");
		flagItem.setWidth("*");
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		map.put("1", "部门补贴到项目");
		map.put("2", "公司补贴到项目");
		flagItem.setValueMap(map);
		setItems(projectIdItem, plateIdItem, contractCodeItem, projectNameItem, flagItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
