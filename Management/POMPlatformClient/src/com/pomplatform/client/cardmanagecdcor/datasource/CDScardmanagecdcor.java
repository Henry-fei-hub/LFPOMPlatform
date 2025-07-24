package com.pomplatform.client.cardmanagecdcor.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDScardmanagecdcor extends DataSource
{


	public static CDScardmanagecdcor instance = null;

	public static CDScardmanagecdcor getInstance() {
		if(instance == null) {
			instance = new CDScardmanagecdcor("CDScardmanagecdcor");
		}
		return instance;
	}

	private final DataSourceIntegerField cardTypeField;
	private final DataSourceBooleanField defaultCardField;
	private final DataSourceIntegerField currencyTypeField;
	private final DataSourceIntegerField cmbcCodeIdField;
	private final DataSourceTextField bankAccountField;
	private final DataSourceTextField bankAddressField;
	private final DataSourceIntegerField cardManageIdField;
	private final DataSourceIntegerField objectIdField;
	private final DataSourceIntegerField objectTypeField;
	private final DataSourceIntegerField bankIdField;
	private final DataSourceBooleanField truePaymentField;

	public CDScardmanagecdcor(String dataSourceID) {

		setID(dataSourceID);
		cardTypeField = new DataSourceIntegerField("cardType", "2报销卡)");
		cardTypeField.setRequired(false);
		cardTypeField.setLength(11);
		cardTypeField.setHidden(false);

		defaultCardField = new DataSourceBooleanField("defaultCard", "是否为默认卡");
		defaultCardField.setRequired(false);
		defaultCardField.setHidden(false);

		currencyTypeField = new DataSourceIntegerField("currencyType", "currency_type");
		currencyTypeField.setRequired(false);
		currencyTypeField.setLength(11);
		currencyTypeField.setHidden(false);

		cmbcCodeIdField = new DataSourceIntegerField("cmbcCodeId", "招商银行分行代码");
		cmbcCodeIdField.setRequired(false);
		cmbcCodeIdField.setLength(11);
		cmbcCodeIdField.setHidden(false);

		bankAccountField = new DataSourceTextField("bankAccount", "银行账号");
		bankAccountField.setRequired(false);
		bankAccountField.setLength(64);
		bankAccountField.setHidden(false);

		bankAddressField = new DataSourceTextField("bankAddress", "开户行所在地");
		bankAddressField.setRequired(false);
		bankAddressField.setLength(128);
		bankAddressField.setHidden(false);

		cardManageIdField = new DataSourceIntegerField("cardManageId", "主键编码");
		cardManageIdField.setRequired(true);
		cardManageIdField.setLength(11);
		cardManageIdField.setPrimaryKey(true);
		cardManageIdField.setHidden(true);

		objectIdField = new DataSourceIntegerField("objectId", "对象编码");
		objectIdField.setRequired(false);
		objectIdField.setLength(11);
		objectIdField.setHidden(false);

		objectTypeField = new DataSourceIntegerField("objectType", "2单位)");
		objectTypeField.setRequired(false);
		objectTypeField.setLength(11);
		objectTypeField.setHidden(false);

		bankIdField = new DataSourceIntegerField("bankId", "开户行");
		bankIdField.setRequired(false);
		bankIdField.setLength(11);
		bankIdField.setHidden(false);

		truePaymentField = new DataSourceBooleanField("truePayment", "真实收付款");
		truePaymentField.setRequired(false);
		truePaymentField.setHidden(false);

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


		setFields(cardTypeField, defaultCardField, currencyTypeField, cmbcCodeIdField, bankAccountField, bankAddressField, cardManageIdField, objectIdField, objectTypeField, bankIdField, truePaymentField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

