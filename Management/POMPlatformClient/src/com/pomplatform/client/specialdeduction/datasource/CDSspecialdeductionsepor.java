package com.pomplatform.client.specialdeduction.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSspecialdeductionsepor extends DataSource
{


	public static CDSspecialdeductionsepor instance = null;

	public static CDSspecialdeductionsepor getInstance() {
		if(instance == null) {
			instance = new CDSspecialdeductionsepor("CDSspecialdeductionsepor");
		}
		return instance;
	}

	private final DataSourceIntegerField specialDeductionIdField;
	private final DataSourceIntegerField employeIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField documentTypeField;
	private final DataSourceIntegerField spouseDocumentTypeField;
	private final DataSourceBooleanField isEnableField;

	public CDSspecialdeductionsepor(String dataSourceID) {

		setID(dataSourceID);
		specialDeductionIdField = new DataSourceIntegerField("specialDeductionId", "id");
		specialDeductionIdField.setRequired(true);
		specialDeductionIdField.setLength(11);
		specialDeductionIdField.setPrimaryKey(true);
		specialDeductionIdField.setHidden(false);

		employeIdField = new DataSourceIntegerField("employeId", "纳税人id");
		employeIdField.setRequired(true);
		employeIdField.setLength(11);
		employeIdField.setHidden(false);

		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);

		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setRequired(false);
		companyIdField.setLength(11);
		companyIdField.setHidden(false);

		documentTypeField = new DataSourceIntegerField("documentType", "身份证件类型");
		documentTypeField.setRequired(true);
		documentTypeField.setLength(11);
		documentTypeField.setHidden(false);

		spouseDocumentTypeField = new DataSourceIntegerField("spouseDocumentType", "配偶身份证件类型");
		spouseDocumentTypeField.setRequired(false);
		spouseDocumentTypeField.setLength(11);
		spouseDocumentTypeField.setHidden(false);

		isEnableField = new DataSourceBooleanField("isEnable", "是否可用");
		isEnableField.setRequired(false);
		isEnableField.setHidden(false);

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


		setFields(specialDeductionIdField, employeIdField, plateIdField, companyIdField, documentTypeField, spouseDocumentTypeField, isEnableField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

