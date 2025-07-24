package com.pomplatform.client.websitenews.datasource;

import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceLinkField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSSProjectExperience extends DBDataSource
{
	public static DSSProjectExperience instance = null;
	public static DSSProjectExperience getInstance() {
		if(instance == null) {
			instance = new DSSProjectExperience("DSSProjectExperience");
		}
		return instance;
	}

	private final DataSourceIntegerField jaidFunctionMaintenanceIdField;
	private final DataSourceTextField nameZhField;
	private final DataSourceTextField projectAddressZhField;
	private final DataSourceTextField designTimeZhField;
	private final DataSourceTextField finishTimeZhField;
	private final DataSourceTextField projectAreaField;
	private final DataSourceTextField mainThemeZhField;
	private final DataSourceIntegerField orderIdField;
	private final DataSourceDateTimeField publishTimeField;
	private final DataSourceBooleanField isAuditedField;
	private final DataSourceTextField auditTypeField;
	private final DataSourceLinkField operateAddressField;

	public DSSProjectExperience(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("JaidFunctionMaintenance");

		jaidFunctionMaintenanceIdField = new DataSourceIntegerField("jaidFunctionMaintenanceId", "主键");
		jaidFunctionMaintenanceIdField.setLength(11);
		jaidFunctionMaintenanceIdField.setPrimaryKey(true);
		jaidFunctionMaintenanceIdField.setRequired(true);
		jaidFunctionMaintenanceIdField.setHidden(true);

		nameZhField = new DataSourceTextField("nameZh", "名称");
		nameZhField.setLength(126);

		projectAddressZhField = new DataSourceTextField("projectAddressZh", "项目地址");
		projectAddressZhField.setLength(126);

		designTimeZhField = new DataSourceTextField("designTimeZh", "设计时间");
		designTimeZhField.setLength(64);
		
		finishTimeZhField = new DataSourceTextField("finishTimeZh", "竣工时间");
		finishTimeZhField.setLength(64);
		
		projectAreaField = new DataSourceTextField("projectArea", "项目面积");
		projectAreaField.setLength(64);
		
		mainThemeZhField = new DataSourceTextField("mainThemeZh", "主要题材");
		mainThemeZhField.setLength(128);
		
		orderIdField = new DataSourceIntegerField("orderId", "排序");
		orderIdField.setLength(64);

		publishTimeField = new DataSourceDateTimeField("publishTime", "发布时间");
		publishTimeField.setLength(64);

		isAuditedField = new DataSourceBooleanField("isAudited", "是否审核");
		isAuditedField.setLength(11);
		isAuditedField.setHidden(true);
		
		auditTypeField = new DataSourceTextField("auditType", "审核");
		auditTypeField.setLength(64);

		operateAddressField = new DataSourceLinkField("operateAddress", "操作");
		operateAddressField.setLength(128);
		operateAddressField.setHidden(false);
		
		setFields(jaidFunctionMaintenanceIdField, nameZhField, projectAddressZhField, designTimeZhField, finishTimeZhField
		, projectAreaField, mainThemeZhField, orderIdField,publishTimeField,isAuditedField,auditTypeField,operateAddressField);
	}


}

