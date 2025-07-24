package com.pomplatform.client.attachment.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSattachmentmanageCapital extends DataSource
{


	public static CDSattachmentmanageCapital instance = null;

	public static CDSattachmentmanageCapital getInstance() {
		if(instance == null) {
			instance = new CDSattachmentmanageCapital("CDSattachmentmanageCapital");
		}
		return instance;
	}

	private final DataSourceTextField attachmentCodeField;
	private final DataSourceTextField attachmentNameField;
	private final DataSourceTextField attachmentAddressField;
	private final DataSourceTextField perfessionRemarkField;
	private final DataSourceTextField remarkField;
	private final DataSourceBooleanField paymentSureField;
	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceIntegerField deleteFlagField;
	private final DataSourceIntegerField attachmentManageIdField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceIntegerField projectManageIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField superProjectManageIdField;

	public CDSattachmentmanageCapital(String dataSourceID) {

		setID(dataSourceID);
		attachmentCodeField = new DataSourceTextField("attachmentCode", "编号");
		attachmentCodeField.setRequired(false);
		attachmentCodeField.setLength(64);
		attachmentCodeField.setHidden(false);

		attachmentNameField = new DataSourceTextField("attachmentName", "附件名称");
		attachmentNameField.setRequired(false);
		attachmentNameField.setLength(128);
		attachmentNameField.setHidden(false);

		attachmentAddressField = new DataSourceTextField("attachmentAddress", "附件路径");
		attachmentAddressField.setRequired(false);
		attachmentAddressField.setLength(128);
		attachmentAddressField.setHidden(false);

		perfessionRemarkField = new DataSourceTextField("perfessionRemark", "专业备注");
		perfessionRemarkField.setRequired(false);
		perfessionRemarkField.setLength(1024);
		perfessionRemarkField.setHidden(false);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setRequired(false);
		remarkField.setLength(1024);
		remarkField.setHidden(false);

		paymentSureField = new DataSourceBooleanField("paymentSure", "收款确认");
		paymentSureField.setRequired(false);
		paymentSureField.setHidden(false);

		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "操作人");
		operateEmployeeIdField.setRequired(false);
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setHidden(false);

		deleteFlagField = new DataSourceIntegerField("deleteFlag", "0/1 是/否删除");
		deleteFlagField.setRequired(false);
		deleteFlagField.setLength(11);
		deleteFlagField.setHidden(false);

		attachmentManageIdField = new DataSourceIntegerField("attachmentManageId", "主键编码");
		attachmentManageIdField.setRequired(true);
		attachmentManageIdField.setLength(11);
		attachmentManageIdField.setPrimaryKey(true);
		attachmentManageIdField.setHidden(true);

		contractIdField = new DataSourceIntegerField("contractId", "合同编码");
		contractIdField.setRequired(false);
		contractIdField.setLength(11);
		contractIdField.setHidden(false);

		projectManageIdField = new DataSourceIntegerField("projectManageId", "项目负责人");
		projectManageIdField.setRequired(false);
		projectManageIdField.setLength(11);
		projectManageIdField.setHidden(false);

		departmentIdField = new DataSourceIntegerField("departmentId", "负责部门");
		departmentIdField.setRequired(false);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));

		superProjectManageIdField = new DataSourceIntegerField("superProjectManageId", "大项目负责人");
		superProjectManageIdField.setRequired(false);
		superProjectManageIdField.setLength(11);
		superProjectManageIdField.setHidden(false);

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


		setFields(attachmentCodeField, attachmentNameField, attachmentAddressField, perfessionRemarkField, remarkField, paymentSureField, operateEmployeeIdField, deleteFlagField, attachmentManageIdField, contractIdField, projectManageIdField, departmentIdField, superProjectManageIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

