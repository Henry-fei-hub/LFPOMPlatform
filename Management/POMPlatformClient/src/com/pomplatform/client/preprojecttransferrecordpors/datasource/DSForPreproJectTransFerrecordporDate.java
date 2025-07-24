package com.pomplatform.client.preprojecttransferrecordpors.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSForPreproJectTransFerrecordporDate extends DBDataSource
{


	public static DSForPreproJectTransFerrecordporDate instance = null;

	public static DSForPreproJectTransFerrecordporDate getInstance() {
		if(instance == null) {
			instance = new DSForPreproJectTransFerrecordporDate("DSForPreproJectTransFerrecordporDate");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField transferEmployeeIdField;
	private final DataSourceIntegerField preProjectIdField;
	private final DataSourceTextField customerNameField;
	private final DataSourceTextField projectNameField;
	private final DataSourceTextField cityField;
	private final DataSourceTextField detailAddressField;
	private final DataSourceTextField projectTypeField;
	private final DataSourceTextField projectOriginationField;
	private final DataSourceTextField contactNameField;
	private final DataSourceTextField contactPhoneField;
	private final DataSourceTextField provinceField;
	private final DataSourceFloatField totalBuildingAreasField;
	private final DataSourceIntegerField preProjectTransferRecordIdField;

	public DSForPreproJectTransFerrecordporDate(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ForPreproJectTransFerrecordporDate");

		
		preProjectTransferRecordIdField = new DataSourceIntegerField("preProjectTransferRecordId", "主键编码");
		preProjectTransferRecordIdField.setLength(11);
		preProjectTransferRecordIdField.setPrimaryKey(true);
		preProjectTransferRecordIdField.setRequired(true);
		preProjectTransferRecordIdField.setHidden(true);

		employeeIdField = new DataSourceIntegerField("employeeId", "原报备人");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		transferEmployeeIdField = new DataSourceIntegerField("transferEmployeeId", "转交人");
		transferEmployeeIdField.setLength(11);
		transferEmployeeIdField.setRequired(false);
		transferEmployeeIdField.setHidden(false);
		transferEmployeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		preProjectIdField = new DataSourceIntegerField("preProjectId", "项目id");
		preProjectIdField.setLength(11);
		preProjectIdField.setRequired(false);
		preProjectIdField.setHidden(true);


		customerNameField = new DataSourceTextField("customerName", "客户名称");
		customerNameField.setLength(512);
		customerNameField.setRequired(false);
		customerNameField.setHidden(false);


		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setLength(512);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);

		
		provinceField = new DataSourceTextField("province", "项目地址（省）");
		provinceField.setLength(32);
		provinceField.setRequired(false);
		provinceField.setHidden(false);

		

		cityField = new DataSourceTextField("city", "项目地址（市）");
		cityField.setLength(32);
		cityField.setRequired(false);
		cityField.setHidden(false);


		detailAddressField = new DataSourceTextField("detailAddress", "详细地址");
		detailAddressField.setLength(512);
		detailAddressField.setRequired(false);
		detailAddressField.setHidden(false);


		projectTypeField = new DataSourceTextField("businessType", "业务类别");
		projectTypeField.setLength(128);
		projectTypeField.setRequired(false);
		projectTypeField.setHidden(false);


		projectOriginationField = new DataSourceTextField("projectOrigination", "项目来源渠道");
		projectOriginationField.setLength(512);
		projectOriginationField.setRequired(false);
		projectOriginationField.setHidden(false);


		contactNameField = new DataSourceTextField("contactName", "联系人");
		contactNameField.setLength(64);
		contactNameField.setRequired(false);
		contactNameField.setHidden(false);


		contactPhoneField = new DataSourceTextField("contactPhone", "联系电话");
		contactPhoneField.setLength(128);
		contactPhoneField.setRequired(false);
		contactPhoneField.setHidden(false);
		
		totalBuildingAreasField = new DataSourceFloatField("totalBuildingAreas", "项目面积");
		totalBuildingAreasField.setLength(18);
		totalBuildingAreasField.setDecimalPad(2);
		totalBuildingAreasField.setFormat("#,###,###,###,###,##0.00");
		totalBuildingAreasField.setRequired(false);
		totalBuildingAreasField.setHidden(false);

		setFields(preProjectTransferRecordIdField, employeeIdField, transferEmployeeIdField, preProjectIdField, customerNameField, projectNameField, provinceField, cityField, detailAddressField, projectTypeField, projectOriginationField, contactNameField, contactPhoneField, totalBuildingAreasField);
	}


}

