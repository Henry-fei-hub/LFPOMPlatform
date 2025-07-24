package com.pomplatform.client.projecttransitions.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.projecttransitions.datasource.CDOnLoadProjectTransitionRecord;

public class OnLoadProjectTransitionRecordSearchForm extends SearchForm
{


	private final TextItem projectCodeItem;
	private final TextItem contractCodeItem;
	private final TextItem projectNameItem;
	private final TextItem initiateDesignItem;
	private final TextItem operatorItem;
	private final SelectItem statusItem;

	public OnLoadProjectTransitionRecordSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLoadProjectTransitionRecord.getInstance());
		projectCodeItem = new TextItem("projectCode", "项目编号");
		projectCodeItem.setWidth("*");
		projectCodeItem.hide();
		contractCodeItem = new TextItem("projectCode", "项目编号");
		contractCodeItem.setWidth("*");
		projectNameItem = new TextItem("projectName", "项目名称");
		projectNameItem.setWidth("*");
		initiateDesignItem = new TextItem("initiateDesign", "方案主创");
		initiateDesignItem.hide();
		initiateDesignItem.setDefaultValue(ClientUtil.getUserId());
		operatorItem = new TextItem("operator", "操作人id");
		operatorItem.hide();
		//   0 操作记录 ，1 待审批   2 已驳回   3 已完成
		statusItem = new SelectItem("status", "状态");
		statusItem.setWidth("*");
		statusItem.setDefaultValue(1);
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_241"));
		setItems(projectCodeItem,contractCodeItem, projectNameItem, initiateDesignItem, operatorItem, statusItem);

		setNumCols(10);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
