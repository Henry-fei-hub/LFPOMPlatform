package com.pomplatform.client.trainingmanagement.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.trainingmanagement.datasource.CDtrainingManagementAuditOfWorkflow;

public class trainingManagementAuditOfWorkflowSearchForm extends SearchForm
{


	private final TextItem employeeIdItem;
	private final TextItem statusItem;
	private final TextItem trainingManagementIdItem;
	private final TextItem subjectItem;
	private final TextItem compereTypeItem;
	private final TextItem compereItem;
	private final PickTreeItem departmentIdItem;
	private final TextItem siteItem;
	private final ComboBoxItem plateIdItem;
	private final SelectItem isSiteItem;
	private final SelectItem trainingTypeItem;
	private final SelectItem isSendItem;

	public trainingManagementAuditOfWorkflowSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDtrainingManagementAuditOfWorkflow.getInstance());
		employeeIdItem = new TextItem("employeeId", "处理人");
		employeeIdItem.hide();
		
		statusItem = new TextItem("status", "状态");
		statusItem.hide();
		
		trainingManagementIdItem = new TextItem("trainingManagementId", "主键编码");
		trainingManagementIdItem.hide();
		
		subjectItem = new TextItem("subject", "主题");
		subjectItem.setWidth("*");
		
		compereTypeItem = new TextItem("compereType", "主持人类型");
		compereTypeItem.setWidth("*");
		compereTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_174"));
		
		compereItem = new TextItem("compere", "主持人");
		compereItem.setWidth("*");
		compereItem.hide();
		
		departmentIdItem = new PickTreeItem("departmentId", "部门");
		departmentIdItem.setWidth("*");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments", "0"));
		
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

		setItems(employeeIdItem, statusItem, trainingManagementIdItem, subjectItem, compereTypeItem, compereItem, departmentIdItem, siteItem, plateIdItem, isSiteItem, trainingTypeItem, isSendItem);

		setNumCols(24);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
