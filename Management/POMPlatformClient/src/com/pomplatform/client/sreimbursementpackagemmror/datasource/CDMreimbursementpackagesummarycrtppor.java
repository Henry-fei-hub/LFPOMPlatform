package com.pomplatform.client.sreimbursementpackagemmror.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMreimbursementpackagesummarycrtppor extends DataSource
{


	public static CDMreimbursementpackagesummarycrtppor instance = null;

	public static CDMreimbursementpackagesummarycrtppor getInstance() {
		if(instance == null) {
			instance = new CDMreimbursementpackagesummarycrtppor("CDMreimbursementpackagesummarycrtppor");
		}
		return instance;
	}

	private final DataSourceIntegerField reimbursementPackageIdField;
	private final DataSourceIntegerField typeField;
	private final DataSourceIntegerField payResultField;
	private final DataSourceIntegerField payStatusField;

	public CDMreimbursementpackagesummarycrtppor(String dataSourceID) {

		setID(dataSourceID);
		reimbursementPackageIdField = new DataSourceIntegerField("reimbursementPackageId", "报销打包表编码");
		reimbursementPackageIdField.setRequired(false);
		reimbursementPackageIdField.setLength(11);
		reimbursementPackageIdField.setHidden(false);

		typeField = new DataSourceIntegerField("type", "类型 1支付 2代发工资 3代发奖金 4代发其他 5 内部转账");
		typeField.setRequired(false);
		typeField.setLength(11);
		typeField.setHidden(false);

		payResultField = new DataSourceIntegerField("payResult", "4失败");
		payResultField.setRequired(false);
		payResultField.setLength(11);
		payResultField.setHidden(false);

		payStatusField = new DataSourceIntegerField("payStatus", "3支付完成(已返回处理结果)");
		payStatusField.setRequired(false);
		payStatusField.setLength(11);
		payStatusField.setHidden(false);

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


		setFields(reimbursementPackageIdField, typeField, payResultField, payStatusField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

