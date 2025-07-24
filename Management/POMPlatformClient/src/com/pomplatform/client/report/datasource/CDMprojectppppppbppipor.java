package com.pomplatform.client.report.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMprojectppppppbppipor extends DataSource
{


	public static CDMprojectppppppbppipor instance = null;

	public static CDMprojectppppppbppipor getInstance() {
		if(instance == null) {
			instance = new CDMprojectppppppbppipor("CDMprojectppppppbppipor");
		}
		return instance;
	}

	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField projectTypeField;
	private final DataSourceIntegerField businessLineField;
	private final DataSourceIntegerField pricingTypeField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceBooleanField isHasPriceField;
	private final DataSourceIntegerField projectFlagField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField projectNameField;

	public CDMprojectppppppbppipor(String dataSourceID) {

		setID(dataSourceID);
		projectIdField = new DataSourceIntegerField("projectId", "项目id");
		projectIdField.setRequired(false);
		projectIdField.setLength(11);
		projectIdField.setHidden(false);

		projectTypeField = new DataSourceIntegerField("projectType", "项目类别");
		projectTypeField.setRequired(false);
		projectTypeField.setLength(11);
		projectTypeField.setHidden(false);

		businessLineField = new DataSourceIntegerField("businessLine", "业务条线");
		businessLineField.setRequired(false);
		businessLineField.setLength(11);
		businessLineField.setHidden(false);

		pricingTypeField = new DataSourceIntegerField("pricingType", "定价类型");
		pricingTypeField.setRequired(false);
		pricingTypeField.setLength(11);
		pricingTypeField.setHidden(false);

		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);

		isHasPriceField = new DataSourceBooleanField("isHasPrice", "是否有定价子项");
		isHasPriceField.setRequired(false);
		isHasPriceField.setHidden(false);

		projectFlagField = new DataSourceIntegerField("projectFlag", "项目类型标识");
		projectFlagField.setRequired(false);
		projectFlagField.setLength(11);
		projectFlagField.setHidden(false);

		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setRequired(true);
		contractCodeField.setLength(0);
		contractCodeField.setHidden(false);

		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setRequired(true);
		projectCodeField.setLength(11);
		projectCodeField.setHidden(false);

		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setRequired(true);
		projectNameField.setLength(11);
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


		setFields(projectIdField, projectTypeField, businessLineField, pricingTypeField, plateIdField, isHasPriceField, projectFlagField, contractCodeField, projectCodeField, projectNameField, currentPageField, pageLinesField);
		setClientOnly(true);
	}


}

