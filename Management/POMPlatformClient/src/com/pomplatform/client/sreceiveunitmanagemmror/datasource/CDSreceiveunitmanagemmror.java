package com.pomplatform.client.sreceiveunitmanagemmror.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSreceiveunitmanagemmror extends DataSource
{


	public static CDSreceiveunitmanagemmror instance = null;

	public static CDSreceiveunitmanagemmror getInstance() {
		if(instance == null) {
			instance = new CDSreceiveunitmanagemmror("CDSreceiveunitmanagemmror");
		}
		return instance;
	}

	private final DataSourceDateTimeField minOperateTimeField;
	private final DataSourceDateTimeField maxOperateTimeField;
	private final DataSourceTextField receiveUnitField;
	private final DataSourceTextField bankAccountField;
	private final DataSourceTextField bankNameField;
	private final DataSourceTextField receiveUnitAddressField;
	private final DataSourceIntegerField receiveUnitManageIdField;
	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceIntegerField originField;
	private final DataSourceIntegerField voucherTypeField;

	public CDSreceiveunitmanagemmror(String dataSourceID) {

		setID(dataSourceID);
		minOperateTimeField = new DataSourceDateTimeField("minOperateTime", "最早操作时间");
		minOperateTimeField.setRequired(false);
		minOperateTimeField.setHidden(false);

		maxOperateTimeField = new DataSourceDateTimeField("maxOperateTime", "最晚操作时间");
		maxOperateTimeField.setRequired(false);
		maxOperateTimeField.setHidden(false);

		receiveUnitField = new DataSourceTextField("receiveUnit", "收款单位");
		receiveUnitField.setRequired(false);
		receiveUnitField.setLength(128);
		receiveUnitField.setHidden(false);

		bankAccountField = new DataSourceTextField("bankAccount", "银行账号");
		bankAccountField.setRequired(false);
		bankAccountField.setLength(64);
		bankAccountField.setHidden(false);

		bankNameField = new DataSourceTextField("bankName", "开户行");
		bankNameField.setRequired(false);
		bankNameField.setLength(128);
		bankNameField.setHidden(false);

		receiveUnitAddressField = new DataSourceTextField("receiveUnitAddress", "收款单位所在地");
		receiveUnitAddressField.setRequired(false);
		receiveUnitAddressField.setLength(128);
		receiveUnitAddressField.setHidden(false);

		receiveUnitManageIdField = new DataSourceIntegerField("receiveUnitManageId", "主键编码");
		receiveUnitManageIdField.setRequired(true);
		receiveUnitManageIdField.setLength(11);
		receiveUnitManageIdField.setPrimaryKey(true);
		receiveUnitManageIdField.setHidden(true);

		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "操作人");
		operateEmployeeIdField.setRequired(false);
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setHidden(false);

		originField = new DataSourceIntegerField("origin", "来源");
		originField.setRequired(false);
		originField.setLength(11);
		originField.setHidden(false);
		
		voucherTypeField = new DataSourceIntegerField("voucherType", "凭证类型");
		voucherTypeField.setRequired(false);
		voucherTypeField.setLength(11);
		voucherTypeField.setHidden(false);
		voucherTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_227"));

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


		setFields(minOperateTimeField, maxOperateTimeField, receiveUnitField, bankAccountField, bankNameField, receiveUnitAddressField, receiveUnitManageIdField, operateEmployeeIdField, originField, voucherTypeField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

