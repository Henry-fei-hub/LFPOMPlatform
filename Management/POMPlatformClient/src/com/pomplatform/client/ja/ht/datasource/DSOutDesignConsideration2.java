package com.pomplatform.client.ja.ht.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSOutDesignConsideration2 extends DBDataSource
{


	public static DSOutDesignConsideration2 instance = null;

	public static DSOutDesignConsideration2 getInstance() {
		if(instance == null) {
			instance = new DSOutDesignConsideration2("DSOutDesignConsideration");
		}
		return instance;
	}

	private final DataSourceIntegerField outDesignConsiderationIdField;
	private final DataSourceFloatField designAreaField;
	private final DataSourceFloatField designUnitPriceField;
	private final DataSourceFloatField moneySumField;
	private final DataSourceTextField mainDesignAreaNameField;
	

	public DSOutDesignConsideration2(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("OutDesignConsideration");


		outDesignConsiderationIdField = new DataSourceIntegerField("outDesignConsiderationId", "报价单子项编码");
		outDesignConsiderationIdField.setLength(11);
		outDesignConsiderationIdField.setPrimaryKey(true);
		outDesignConsiderationIdField.setRequired(true);
		outDesignConsiderationIdField.setHidden(true);



		mainDesignAreaNameField = new DataSourceTextField("mainDesignAreaName", "业务类型");
		mainDesignAreaNameField.setLength(16);
		mainDesignAreaNameField.setRequired(false);
		mainDesignAreaNameField.setHidden(false);
		
		
		designAreaField = new DataSourceFloatField("designArea", "设计面积");
		designAreaField.setLength(16);
		designAreaField.setDecimalPad(2);
		designAreaField.setFormat("##,###,###,###,##0.00");
		designAreaField.setRequired(false);
		designAreaField.setHidden(false);


		designUnitPriceField = new DataSourceFloatField("designUnitPrice", "设计单价");
		designUnitPriceField.setLength(16);
		designUnitPriceField.setDecimalPad(2);
		designUnitPriceField.setFormat("##,###,###,###,##0.00");
		designUnitPriceField.setRequired(false);
		designUnitPriceField.setHidden(false);


		moneySumField = new DataSourceFloatField("moneySum", "总价");
		moneySumField.setLength(16);
		moneySumField.setDecimalPad(2);
		moneySumField.setFormat("###,###,###,##0.00");
		moneySumField.setRequired(false);
		moneySumField.setHidden(false);




		setFields(outDesignConsiderationIdField,designAreaField, designUnitPriceField, moneySumField,mainDesignAreaNameField);
	}


}

