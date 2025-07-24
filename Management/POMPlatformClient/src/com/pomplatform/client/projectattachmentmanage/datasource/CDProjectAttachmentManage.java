package com.pomplatform.client.projectattachmentmanage.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDProjectAttachmentManage extends DataSource
{


	public static CDProjectAttachmentManage instance = null;

	public static CDProjectAttachmentManage getInstance() {
		if(instance == null) {
			instance = new CDProjectAttachmentManage("CDProjectAttachmentManage");
		}
		return instance;
	}

	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceBooleanField isQualifiedField;

	public CDProjectAttachmentManage(String dataSourceID) {

		setID(dataSourceID);
		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(64);
		contractCodeField.setHidden(false);
//		contractCodeField.setValueMap(KeyValueManager.getValueMap("contracts"));
		KeyValueManager.loadValueMap("contracts",contractCodeField);

		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setRequired(false);
		projectNameField.setLength(512);
		projectNameField.setHidden(false);

		isQualifiedField = new DataSourceBooleanField("isQualified", "是否合格");
		isQualifiedField.setRequired(false);
		isQualifiedField.setHidden(false);

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


		setFields(contractCodeField, projectNameField, isQualifiedField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

