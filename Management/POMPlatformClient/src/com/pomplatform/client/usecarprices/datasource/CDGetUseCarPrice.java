package com.pomplatform.client.usecarprices.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDGetUseCarPrice extends DataSource
{


	public static CDGetUseCarPrice instance = null;

	public static CDGetUseCarPrice getInstance() {
		if(instance == null) {
			instance = new CDGetUseCarPrice("CDGetUseCarPrice");
		}
		return instance;
	}

	private final DataSourceIntegerField useCarPriceIdField;
	private final DataSourceFloatField priceField;
	private final DataSourceIntegerField parentIdField;
	private final DataSourceTextField toAreaField;
	private final DataSourceTextField fromAreaField;

	public CDGetUseCarPrice(String dataSourceID) {

		setID(dataSourceID);
		useCarPriceIdField = new DataSourceIntegerField("useCarPriceId", "用车费用价格表编码");
		useCarPriceIdField.setRequired(true);
		useCarPriceIdField.setLength(11);
		useCarPriceIdField.setPrimaryKey(true);
		useCarPriceIdField.setHidden(true);

		priceField = new DataSourceFloatField("price", "价格");
		priceField.setRequired(true);
		priceField.setLength(18);
		priceField.setHidden(false);

		parentIdField = new DataSourceIntegerField("parentId", "父级编码");
		parentIdField.setRequired(false);
		parentIdField.setLength(11);
		parentIdField.setHidden(false);
//		parentIdField.setValueMap(KeyValueManager.getValueMap("contracts"));
		KeyValueManager.loadValueMap("contracts",parentIdField);

		toAreaField = new DataSourceTextField("toArea", "目的地");
		toAreaField.setRequired(false);
		toAreaField.setLength(256);
		toAreaField.setHidden(false);

		fromAreaField = new DataSourceTextField("fromArea", "出发地");
		fromAreaField.setRequired(false);
		fromAreaField.setLength(256);
		fromAreaField.setHidden(false);

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


		setFields(useCarPriceIdField, priceField, parentIdField, toAreaField, fromAreaField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

