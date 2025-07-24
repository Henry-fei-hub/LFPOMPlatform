package com.pomplatform.client.trainingmanagement.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.trainingmanagement.datasource.CDtrainingManagementsApplyOfWorkflow;

public class trainingManagementsApplyOfWorkflowSearchForm extends SearchForm
{


	private final TextItem trainingManagementIdItem;
	private final TextItem subjectItem;
	private final SelectItem compereTypeItem;
	private final TextItem compereItem;
	private final ComboBoxItem employeeIdItem;
	private final PickTreeItem departmentIdItem;
	private final ComboBoxItem createPersonIdItem;
	private final TextItem siteItem;
	private final ComboBoxItem plateIdItem;
	private final SelectItem isSiteItem;
	private final SelectItem trainingTypeItem;
	private final SelectItem isSendItem;

	public trainingManagementsApplyOfWorkflowSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDtrainingManagementsApplyOfWorkflow.getInstance());
		trainingManagementIdItem = new TextItem("trainingManagementId", "主键编码");
		trainingManagementIdItem.hide();
		subjectItem = new TextItem("subject", "主题");
		subjectItem.setWidth("*");
		
		compereTypeItem = new SelectItem("compereType", "主持人类型");
		compereTypeItem.setWidth("*");
		compereTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_174"));
		
		compereItem = new TextItem("compere", "外部主持人");
		compereItem.setWidth("*");
		
		employeeIdItem = new ComboBoxItem("employeeId", "内部主持人");
		employeeIdItem.setWidth("*");
		employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		employeeIdItem.setChangeOnKeypress(false);
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		
		departmentIdItem = new PickTreeItem("departmentId", "部门");
		departmentIdItem.setWidth("*");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments", "0"));
		
		createPersonIdItem = new ComboBoxItem("createPersonId", "申请人");
		createPersonIdItem.setWidth("*");
		createPersonIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		createPersonIdItem.setChangeOnKeypress(false);
		createPersonIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		
		siteItem = new TextItem("site", "培训地点名称");
		siteItem.setWidth("*");
		
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setChangeOnKeypress(false);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));
		
		isSiteItem = new SelectItem("isSite", "培训地点");
		isSiteItem.setWidth("*");
		Map map =new HashMap<Integer, String>();
		map.put(0, "内部");
		map.put(1, "外部");
		isSiteItem.setValueMap(map);
		
		trainingTypeItem = new SelectItem("trainingType", "培训类型");
		trainingTypeItem.setWidth("*");
		trainingTypeItem.setValueMap(map);
		
		isSendItem = new SelectItem("isSend", "是否消息推送");
		isSendItem.setWidth("*");
		isSendItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_200"));

		setItems(trainingManagementIdItem, subjectItem, compereTypeItem, compereItem, employeeIdItem, departmentIdItem, createPersonIdItem,siteItem, plateIdItem, isSiteItem, trainingTypeItem, isSendItem);

		setNumCols(36);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
