package com.pomplatform.client.capitaldistribution.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDAllCapitalDistributionInfo extends DataSource
{


	public static CDAllCapitalDistributionInfo instance = null;

	public static CDAllCapitalDistributionInfo getInstance() {
		if(instance == null) {
			instance = new CDAllCapitalDistributionInfo("CDAllCapitalDistributionInfo");
		}
		return instance;
	}

	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceDateTimeField startHappenDateField;
	private final DataSourceDateTimeField endHappenDateField;
	private final DataSourceBooleanField lockedField;
	private final DataSourceDateTimeField startDistributeTimeField;
	private final DataSourceDateTimeField endDistributeTimeField;
	private final DataSourceIntegerField projectManageIdField;
	private final DataSourceIntegerField statusField;

	public CDAllCapitalDistributionInfo(String dataSourceID) {

		setID(dataSourceID);
		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(64);
		contractCodeField.setHidden(false);

		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setRequired(false);
		contractNameField.setLength(512);
		contractNameField.setHidden(false);

		startHappenDateField = new DataSourceDateTimeField("startHappenDate", "开始回款日期");
		startHappenDateField.setRequired(false);
		startHappenDateField.setHidden(false);

		endHappenDateField = new DataSourceDateTimeField("endHappenDate", "截止回款日期");
		endHappenDateField.setRequired(false);
		endHappenDateField.setHidden(false);

		lockedField = new DataSourceBooleanField("locked", "是否锁定");
		lockedField.setRequired(true);
		lockedField.setHidden(false);

		startDistributeTimeField = new DataSourceDateTimeField("startDistributeTime", "开始分配日期");
		startDistributeTimeField.setRequired(true);
		startDistributeTimeField.setHidden(false);

		endDistributeTimeField = new DataSourceDateTimeField("endDistributeTime", "截止分配日期");
		endDistributeTimeField.setRequired(true);
		endDistributeTimeField.setHidden(false);

		projectManageIdField = new DataSourceIntegerField("projectManageId", "大项目经理");
		projectManageIdField.setRequired(false);
		projectManageIdField.setLength(11);
		projectManageIdField.setHidden(false);
		projectManageIdField.setValueMap(KeyValueManager.getValueMap("employees"));
		
		statusField = new DataSourceIntegerField("status", "回款分配状态");
		statusField.setRequired(false);
		statusField.setLength(11);
		statusField.setHidden(false);

		DataSourceIntegerField currentPageField
			= new DataSourceIntegerField("currentPage", "当前页");
		currentPageField.setRequired(true);
		currentPageField.setLength(10);
		currentPageField.setHidden(true);

		DataSourceIntegerField pageLinesField
			= new DataSourceIntegerField("pageLines", "每页行数");
		pageLinesField.setRequired(true);
		pageLinesField.setLength(10);
		pageLinesField.setHidden(true);


		setFields(contractCodeField, contractNameField, startHappenDateField, endHappenDateField, lockedField, startDistributeTimeField, endDistributeTimeField, projectManageIdField, statusField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

