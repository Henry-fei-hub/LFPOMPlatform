package com.pomplatform.client.workflow.operation.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnLoadApplyListOfCostAllocation extends DataSource
{


	public static CDOnLoadApplyListOfCostAllocation instance = null;

	public static CDOnLoadApplyListOfCostAllocation getInstance() {
		if(instance == null) {
			instance = new CDOnLoadApplyListOfCostAllocation("CDOnLoadApplyListOfCostAllocation");
		}
		return instance;
	}

	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField drafterField;
	private final DataSourceTextField codeField;
	private final DataSourceTextField nameField;
	private final DataSourceFloatField costField;
	private final DataSourceIntegerField costTypeField;

	public CDOnLoadApplyListOfCostAllocation(String dataSourceID) {

		setID(dataSourceID);
		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setRequired(false);
		processTypeField.setLength(11);
		processTypeField.setHidden(false);
		processTypeField.setValueMap(KeyValueManager.getValueMap("system_process_types"));

		drafterField = new DataSourceIntegerField("drafter", "起草人");
		drafterField.setRequired(false);
		drafterField.setLength(11);
		drafterField.setHidden(false);
		drafterField.setValueMap(KeyValueManager.getValueMap("employees"));

		codeField = new DataSourceTextField("code", "编号");
		codeField.setRequired(false);
		codeField.setLength(256);
		codeField.setHidden(false);

		nameField = new DataSourceTextField("name", "名称");
		nameField.setRequired(false);
		nameField.setLength(256);
		nameField.setHidden(false);

		costField = new DataSourceFloatField("cost", "成本");
		costField.setRequired(true);
		costField.setLength(18);
		costField.setHidden(false);

		costTypeField = new DataSourceIntegerField("costType", "原成本类型");
		costTypeField.setRequired(false);
		costTypeField.setLength(11);
		costTypeField.setHidden(false);
		costTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

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


		setFields(processTypeField, drafterField, codeField, nameField, costField, costTypeField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

