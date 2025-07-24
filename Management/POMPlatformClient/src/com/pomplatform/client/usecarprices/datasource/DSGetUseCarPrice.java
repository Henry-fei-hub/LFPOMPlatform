package com.pomplatform.client.usecarprices.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSGetUseCarPrice extends DBDataSource
{


	public static DSGetUseCarPrice instance = null;

	public static DSGetUseCarPrice getInstance() {
		if(instance == null) {
			instance = new DSGetUseCarPrice("DSGetUseCarPrice");
		}
		return instance;
	}

	private final DataSourceIntegerField useCarPriceIdField;
	private final DataSourceTextField fromAreaField;
	private final DataSourceTextField toAreaField;
	private final DataSourceFloatField priceField;
	private final DataSourceIntegerField parentIdField;

	public DSGetUseCarPrice(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("GetUseCarPrice");


		useCarPriceIdField = new DataSourceIntegerField("useCarPriceId", "用车费用价格表编码");
		useCarPriceIdField.setLength(11);
		useCarPriceIdField.setPrimaryKey(true);
		useCarPriceIdField.setRequired(true);
		useCarPriceIdField.setHidden(false);


		fromAreaField = new DataSourceTextField("fromArea", "出发地");
		fromAreaField.setLength(256);
		fromAreaField.setRequired(false);
		fromAreaField.setHidden(false);


		toAreaField = new DataSourceTextField("toArea", "目的地");
		toAreaField.setLength(256);
		toAreaField.setRequired(false);
		toAreaField.setHidden(false);


		priceField = new DataSourceFloatField("price", "价格");
		priceField.setLength(18);
		priceField.setDecimalPad(2);
		priceField.setFormat("#,###,###,###,###,##0.00");
		priceField.setRequired(false);
		priceField.setHidden(false);


		parentIdField = new DataSourceIntegerField("parentId", "父级编码");
		parentIdField.setLength(11);
		parentIdField.setRequired(false);
		parentIdField.setHidden(false);
//		parentIdField.setValueMap(KeyValueManager.getValueMap("contracts_1"));
		KeyValueManager.loadValueMap("contracts_1", parentIdField);


		setFields(useCarPriceIdField, fromAreaField, toAreaField, priceField, parentIdField);
	}


}

