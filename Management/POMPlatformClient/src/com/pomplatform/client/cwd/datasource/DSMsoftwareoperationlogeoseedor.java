package com.pomplatform.client.cwd.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSMsoftwareoperationlogeoseedor extends DBDataSource
{


	public static DSMsoftwareoperationlogeoseedor instance = null;

	public static DSMsoftwareoperationlogeoseedor getInstance() {
		if(instance == null) {
			instance = new DSMsoftwareoperationlogeoseedor("DSMsoftwareoperationlogeoseedor");
		}
		return instance;
	}

	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField softwareOperationLogIdField;
	private final DataSourceIntegerField operationTypeField;
	private final DataSourceTextField macAddressField;
	private final DataSourceTextField ipAddressField;
	private final DataSourceTextField machineNameField;
	private final DataSourceIntegerField softwareTypeField;
	private final DataSourceDateTimeField localOperationTimeField;
	private final DataSourceDateTimeField localRequestTimeField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceFloatField currentVersionNoField;
	private final DataSourceIntegerField operatorField;
	private final DataSourceFloatField oriVersionNoField;

	public DSMsoftwareoperationlogeoseedor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Msoftwareoperationlogeoseedor");


		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(true);
		employeeNoField.setHidden(false);


		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(true);
		employeeNameField.setHidden(false);


		departmentIdField = new DataSourceIntegerField("departmentId", "部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		softwareOperationLogIdField = new DataSourceIntegerField("softwareOperationLogId", "主键");
		softwareOperationLogIdField.setLength(11);
		softwareOperationLogIdField.setPrimaryKey(true);
		softwareOperationLogIdField.setRequired(true);
		softwareOperationLogIdField.setHidden(true);


		operationTypeField = new DataSourceIntegerField("operationType", "操作类型");
		operationTypeField.setLength(11);
		operationTypeField.setRequired(false);
		operationTypeField.setHidden(false);

		java.util.Map<String,String> operationTypeValues = new java.util.HashMap<String,String>();
		operationTypeValues.put("1", "安装");
		operationTypeValues.put("2", "卸载");
		operationTypeValues.put("3", "更新");
		operationTypeField.setValueMap(operationTypeValues);


		macAddressField = new DataSourceTextField("macAddress", "mac地址");
		macAddressField.setLength(255);
		macAddressField.setRequired(false);
		macAddressField.setHidden(false);


		ipAddressField = new DataSourceTextField("ipAddress", "ip地址");
		ipAddressField.setLength(255);
		ipAddressField.setRequired(false);
		ipAddressField.setHidden(false);


		machineNameField = new DataSourceTextField("machineName", "机器名称");
		machineNameField.setLength(255);
		machineNameField.setRequired(false);
		machineNameField.setHidden(false);


		softwareTypeField = new DataSourceIntegerField("softwareType", "软件类型");
		softwareTypeField.setLength(11);
		softwareTypeField.setRequired(false);
		softwareTypeField.setHidden(false);

		java.util.Map<String,String> softwareTypeValues = new java.util.HashMap<String,String>();
		softwareTypeValues.put("1", "本地文件服务");
		softwareTypeValues.put("2", "本地存储服务");
		softwareTypeField.setValueMap(softwareTypeValues);


		localOperationTimeField = new DataSourceDateTimeField("localOperationTime", "本地操作时间");
		localOperationTimeField.setRequired(false);
		localOperationTimeField.setHidden(false);


		localRequestTimeField = new DataSourceDateTimeField("localRequestTime", "本地请求时间");
		localRequestTimeField.setRequired(false);
		localRequestTimeField.setHidden(false);


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);


		currentVersionNoField = new DataSourceFloatField("currentVersionNo", "当前系统版本号");
		currentVersionNoField.setLength(8);
		currentVersionNoField.setDecimalPad(1);
		currentVersionNoField.setFormat("#,###,##0.0");
		currentVersionNoField.setRequired(false);
		currentVersionNoField.setHidden(false);


		operatorField = new DataSourceIntegerField("operator", "当前登录人主键");
		operatorField.setLength(11);
		operatorField.setRequired(false);
		operatorField.setHidden(true);


		oriVersionNoField = new DataSourceFloatField("oriVersionNo", "源版本");
		oriVersionNoField.setLength(8);
		oriVersionNoField.setDecimalPad(1);
		oriVersionNoField.setFormat("#,###,##0.0");
		oriVersionNoField.setRequired(false);
		oriVersionNoField.setHidden(false);


		setFields(softwareOperationLogIdField, employeeNoField, employeeNameField, departmentIdField, operationTypeField, macAddressField, ipAddressField, machineNameField, softwareTypeField, localOperationTimeField, localRequestTimeField, createTimeField, currentVersionNoField, operatorField, oriVersionNoField);
	}


}

