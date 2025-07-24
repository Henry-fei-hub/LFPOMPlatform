package com.pomplatform.client.sreimbursementpackagedetailrror.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSreimbursementpackagedetailrror extends DataSource
{


	public static CDSreimbursementpackagedetailrror instance = null;

	public static CDSreimbursementpackagedetailrror getInstance() {
		if(instance == null) {
			instance = new CDSreimbursementpackagedetailrror("CDSreimbursementpackagedetailrror");
		}
		return instance;
	}

	private final DataSourceIntegerField reimbursementPackageDetailIdField;
	private final DataSourceIntegerField reimbursementPackageIdField;

	public CDSreimbursementpackagedetailrror(String dataSourceID) {

		setID(dataSourceID);
		reimbursementPackageDetailIdField = new DataSourceIntegerField("reimbursementPackageDetailId", "报销打包汇总详情表编码");
		reimbursementPackageDetailIdField.setRequired(true);
		reimbursementPackageDetailIdField.setLength(11);
		reimbursementPackageDetailIdField.setPrimaryKey(true);
		reimbursementPackageDetailIdField.setHidden(true);

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


		setFields(reimbursementPackageDetailIdField, reimbursementPackageIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

