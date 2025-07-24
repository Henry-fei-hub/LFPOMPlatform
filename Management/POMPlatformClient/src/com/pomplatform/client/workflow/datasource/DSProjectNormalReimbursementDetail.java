package com.pomplatform.client.workflow.datasource;

import java.util.LinkedHashMap;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.widgets.form.fields.PickTreeItem;

public class DSProjectNormalReimbursementDetail extends DBDataSource
{


	public static DSProjectNormalReimbursementDetail instance = null;

	public static DSProjectNormalReimbursementDetail getInstance() {
		if(instance == null) {
			instance = new DSProjectNormalReimbursementDetail("DSProjectNormalReimbursementDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField projectNormalReimbursementDetailIdField;
	private final DataSourceIntegerField projectNormalReimbursementIdField;
	private final DataSourceIntegerField mainItemIdField;
	private final DataSourceIntegerField subItemIdField;
	private final DataSourceFloatField amountField;
	private final DataSourceDateTimeField reimbursementTimeField;
	private final DataSourceIntegerField statusField;
	private final DataSourceTextField remarkField;

	public DSProjectNormalReimbursementDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("ProjectNormalReimbursementDetail");


		projectNormalReimbursementDetailIdField = new DataSourceIntegerField("projectNormalReimbursementDetailId", "主键编码");
		projectNormalReimbursementDetailIdField.setLength(11);
		projectNormalReimbursementDetailIdField.setPrimaryKey(true);
		projectNormalReimbursementDetailIdField.setRequired(true);
		projectNormalReimbursementDetailIdField.setHidden(true);


		projectNormalReimbursementIdField = new DataSourceIntegerField("projectNormalReimbursementId", "项目报销编码");
		projectNormalReimbursementIdField.setLength(11);
		projectNormalReimbursementIdField.setRequired(false);
		projectNormalReimbursementIdField.setHidden(true);


		mainItemIdField = new DataSourceIntegerField("mainItemId", "报销科目");
		mainItemIdField.setLength(11);
		mainItemIdField.setRequired(false);
		mainItemIdField.setHidden(false);
//		mainItemIdField.setValueMap(KeyValueManager.getValueMap("parent_subject_types"));
		KeyValueManager.loadValueMap("parent_subject_types",mainItemIdField);

		subItemIdField = new DataSourceIntegerField("subItemId", "报销选项");
		subItemIdField.setLength(11);
		subItemIdField.setRequired(false);
		subItemIdField.setHidden(false);
//		subItemIdField.setValueMap(KeyValueManager.getValueMap("subject_types"));
		KeyValueManager.loadValueMap("subject_types",subItemIdField );

		amountField = new DataSourceFloatField("amount", "报销金额");
		amountField.setLength(18);
		amountField.setDecimalPad(5);
		amountField.setFormat("#,###,###,###,##0.00");
		amountField.setRequired(false);
		amountField.setHidden(false);


		reimbursementTimeField = new DataSourceDateTimeField("reimbursementTime", "报销时间");
		reimbursementTimeField.setRequired(false);
		reimbursementTimeField.setHidden(true);


		statusField = new DataSourceIntegerField("status", "状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(true);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_16"));


		remarkField = new DataSourceTextField("remark", "摘要");
		remarkField.setLength(512);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		setFields(projectNormalReimbursementDetailIdField, projectNormalReimbursementIdField, mainItemIdField, subItemIdField, amountField, reimbursementTimeField, statusField, remarkField);
	}


}

