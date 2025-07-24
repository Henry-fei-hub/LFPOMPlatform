package com.pomplatform.client.plateprojectaccountrecordbyproject.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDPlateProjectAccountRecordByProject extends DataSource
{


	public static CDPlateProjectAccountRecordByProject instance = null;

	public static CDPlateProjectAccountRecordByProject getInstance() {
		if(instance == null) {
			instance = new CDPlateProjectAccountRecordByProject("CDPlateProjectAccountRecordByProject");
		}
		return instance;
	}

	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField recordYearField;
	private final DataSourceIntegerField recordMonthField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField projectNameField;

	public CDPlateProjectAccountRecordByProject(String dataSourceID) {

		setID(dataSourceID);
		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		recordYearField = new DataSourceIntegerField("recordYear", "年份");
		recordYearField.setRequired(true);
		recordYearField.setLength(11);
		recordYearField.setHidden(false);

		recordMonthField = new DataSourceIntegerField("recordMonth", "月份");
		recordMonthField.setRequired(true);
		recordMonthField.setLength(11);
		recordMonthField.setHidden(false);

		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(64);
		contractCodeField.setHidden(false);
//		contractCodeField.setValueMap(KeyValueManager.getValueMap("contracts"));
		KeyValueManager.loadValueMap("contracts",contractCodeField);

		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setRequired(false);
		projectCodeField.setLength(64);
		projectCodeField.setHidden(false);

		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setRequired(false);
		projectNameField.setLength(512);
		projectNameField.setHidden(false);

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


		setFields(plateIdField, recordYearField, recordMonthField, contractCodeField, projectCodeField, projectNameField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

