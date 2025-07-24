package com.pomplatform.client.websitenews.datasource;

import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceLinkField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSSNewsMedia extends DBDataSource
{
	public static DSSNewsMedia instance = null;
	public static DSSNewsMedia getInstance() {
		if(instance == null) {
			instance = new DSSNewsMedia("DSSNewsMedia");
		}
		return instance;
	}

	private final DataSourceIntegerField jaidFunctionMaintenanceIdField;
	private final DataSourceTextField nameZhField;
	private final DataSourceIntegerField orderIdField;
	private final DataSourceDateTimeField publishTimeField;
	private final DataSourceBooleanField isAuditedField;
	private final DataSourceTextField auditTypeField;
	private final DataSourceLinkField operateAddressField;

	public DSSNewsMedia(String dataSourceID) {

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
		
		setFields(jaidFunctionMaintenanceIdField, nameZhField
		, orderIdField,publishTimeField,isAuditedField,auditTypeField,operateAddressField);
	}


}

