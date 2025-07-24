package com.pomplatform.client.financereceivebills.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMfinancereceivebillspor extends DataSource
{


	public static CDMfinancereceivebillspor instance = null;

	public static CDMfinancereceivebillspor getInstance() {
		if(instance == null) {
			instance = new CDMfinancereceivebillspor("CDMfinancereceivebillspor");
		}
		return instance;
	}

	private final DataSourceIntegerField financeReceiveBillIdField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField applicantField;
	private final DataSourceTextField codeField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField businessIdField;
	private final DataSourceFloatField amountField;
	private final DataSourceIntegerField sendeeField;
	private final DataSourceIntegerField handlePersonField;
	private final DataSourceTextField remarkField;
	private final DataSourceTextField detailRemarkField;
	private final DataSourceIntegerField receiveStatusField;
	private final DataSourceDateTimeField minCreateTimeField;
	private final DataSourceDateTimeField maxCreateTimeField;
	private final DataSourceDateTimeField minUpdateTimeField;
	private final DataSourceDateTimeField maxUpdateTimeField;
	private final DataSourceIntegerField processStatusField;

	public CDMfinancereceivebillspor(String dataSourceID) {

		setID(dataSourceID);
		financeReceiveBillIdField = new DataSourceIntegerField("financeReceiveBillId", "主键");
		financeReceiveBillIdField.setRequired(true);
		financeReceiveBillIdField.setLength(11);
		financeReceiveBillIdField.setPrimaryKey(true);
		financeReceiveBillIdField.setHidden(true);

		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setRequired(false);
		companyIdField.setLength(11);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		applicantField = new DataSourceIntegerField("applicant", "申请人");
		applicantField.setRequired(false);
		applicantField.setLength(11);
		applicantField.setHidden(false);

		codeField = new DataSourceTextField("code", "报销编号");
		codeField.setRequired(false);
		codeField.setLength(255);
		codeField.setHidden(false);

		processTypeField = new DataSourceIntegerField("processType", "报销类型");
		processTypeField.setRequired(false);
		processTypeField.setLength(11);
		processTypeField.setHidden(false);

		businessIdField = new DataSourceIntegerField("businessId", "业务主键");
		businessIdField.setRequired(false);
		businessIdField.setLength(11);
		businessIdField.setHidden(false);

		amountField = new DataSourceFloatField("amount", "金额");
		amountField.setRequired(true);
		amountField.setLength(16);
		amountField.setHidden(false);

		sendeeField = new DataSourceIntegerField("sendee", "接收人");
		sendeeField.setRequired(false);
		sendeeField.setLength(11);
		sendeeField.setHidden(false);

		handlePersonField = new DataSourceIntegerField("handlePerson", "处理人");
		handlePersonField.setRequired(false);
		handlePersonField.setLength(11);
		handlePersonField.setHidden(false);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setRequired(false);
		remarkField.setLength(1024);
		remarkField.setHidden(false);

		detailRemarkField = new DataSourceTextField("detailRemark", "流程明细");
		detailRemarkField.setRequired(false);
		detailRemarkField.setLength(1024);
		detailRemarkField.setHidden(false);

		receiveStatusField = new DataSourceIntegerField("receiveStatus", "收单状态 1已收 2 退回 3转交 4待补正资料");
		receiveStatusField.setRequired(false);
		receiveStatusField.setLength(11);
		receiveStatusField.setHidden(false);

		minCreateTimeField = new DataSourceDateTimeField("minCreateTime", "最早创建日期");
		minCreateTimeField.setRequired(false);
		minCreateTimeField.setHidden(false);

		maxCreateTimeField = new DataSourceDateTimeField("maxCreateTime", "最晚创建日期");
		maxCreateTimeField.setRequired(false);
		maxCreateTimeField.setHidden(false);

		minUpdateTimeField = new DataSourceDateTimeField("minUpdateTime", "最早修改日期");
		minUpdateTimeField.setRequired(false);
		minUpdateTimeField.setHidden(false);

		maxUpdateTimeField = new DataSourceDateTimeField("maxUpdateTime", "最晚修改日期");
		maxUpdateTimeField.setRequired(false);
		maxUpdateTimeField.setHidden(false);

		processStatusField = new DataSourceIntegerField("processStatus", "流程状态");
		processStatusField.setRequired(false);
		processStatusField.setLength(11);
		processStatusField.setHidden(false);

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


		setFields(financeReceiveBillIdField, companyIdField, applicantField, codeField, processTypeField, businessIdField, amountField, sendeeField, handlePersonField, remarkField, detailRemarkField, receiveStatusField, minCreateTimeField, maxCreateTimeField, minUpdateTimeField, maxUpdateTimeField, processStatusField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

