package com.pomplatform.client.sreimbursementpackagesummaryrror.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSreimbursementpackagesummaryrror extends DataSource
{


	public static CDSreimbursementpackagesummaryrror instance = null;

	public static CDSreimbursementpackagesummaryrror getInstance() {
		if(instance == null) {
			instance = new CDSreimbursementpackagesummaryrror("CDSreimbursementpackagesummaryrror");
		}
		return instance;
	}

	private final DataSourceIntegerField reimbursementPackageSummaryIdField;
	private final DataSourceIntegerField reimbursementPackageIdField;

	public CDSreimbursementpackagesummaryrror(String dataSourceID) {

		setID(dataSourceID);
		reimbursementPackageSummaryIdField = new DataSourceIntegerField("reimbursementPackageSummaryId", "报销打包汇总表编码");
		reimbursementPackageSummaryIdField.setRequired(true);
		reimbursementPackageSummaryIdField.setLength(11);
		reimbursementPackageSummaryIdField.setPrimaryKey(true);
		reimbursementPackageSummaryIdField.setHidden(true);

		reimbursementPackageIdField = new DataSourceIntegerField("reimbursementPackageId", "报销打包表编码");
		reimbursementPackageIdField.setRequired(false);
		reimbursementPackageIdField.setLength(11);
		reimbursementPackageIdField.setHidden(false);

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


		setFields(reimbursementPackageSummaryIdField, reimbursementPackageIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

