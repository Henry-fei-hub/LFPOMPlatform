package com.pomplatform.client.k3code.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSAllCardManage extends DBDataSource
{


	public static DSAllCardManage instance = null;

	public static DSAllCardManage getInstance() {
		if(instance == null) {
			instance = new DSAllCardManage("DSAllCardManage");
		}
		return instance;
	}

	private final DataSourceIntegerField cardManageIdField;
	private final DataSourceIntegerField objectIdField;
	private final DataSourceIntegerField objectTypeField;
	private final DataSourceIntegerField bankIdField;
	private final DataSourceTextField bankAccountField;
	private final DataSourceTextField bankAddressField;
	private final DataSourceIntegerField cardTypeField;
	private final DataSourceBooleanField defaultCardField;
	private final DataSourceBooleanField enabledField;
	private final DataSourceIntegerField currencyTypeField;

	public DSAllCardManage(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("AllCardManage");


		cardManageIdField = new DataSourceIntegerField("cardManageId", "主键编码");
		cardManageIdField.setLength(11);
		cardManageIdField.setPrimaryKey(true);
		cardManageIdField.setRequired(true);
		cardManageIdField.setHidden(false);


		objectIdField = new DataSourceIntegerField("objectId", "对象编码");
		objectIdField.setLength(11);
		objectIdField.setRequired(false);
		objectIdField.setHidden(false);


		objectTypeField = new DataSourceIntegerField("objectType", "2单位)");
		objectTypeField.setLength(11);
		objectTypeField.setRequired(false);
		objectTypeField.setHidden(false);


		bankIdField = new DataSourceIntegerField("bankId", "开户行");
		bankIdField.setLength(11);
		bankIdField.setRequired(false);
		bankIdField.setHidden(false);


		bankAccountField = new DataSourceTextField("bankAccount", "银行账号");
		bankAccountField.setLength(64);
		bankAccountField.setRequired(false);
		bankAccountField.setHidden(false);


		bankAddressField = new DataSourceTextField("bankAddress", "开户行所在地");
		bankAddressField.setLength(128);
		bankAddressField.setRequired(false);
		bankAddressField.setHidden(false);


		cardTypeField = new DataSourceIntegerField("cardType", "2报销卡)");
		cardTypeField.setLength(11);
		cardTypeField.setRequired(false);
		cardTypeField.setHidden(false);


		defaultCardField = new DataSourceBooleanField("defaultCard", "是否为默认卡");
		defaultCardField.setRequired(false);
		defaultCardField.setHidden(false);


		enabledField = new DataSourceBooleanField("enabled", "是否启用");
		enabledField.setRequired(false);
		enabledField.setHidden(false);


		currencyTypeField = new DataSourceIntegerField("currencyType", "currency_type");
		currencyTypeField.setLength(11);
		currencyTypeField.setRequired(false);
		currencyTypeField.setHidden(false);


		setFields(cardManageIdField, objectIdField, objectTypeField, bankIdField, bankAccountField, bankAddressField, cardTypeField, defaultCardField, enabledField, currencyTypeField);
	}


}

