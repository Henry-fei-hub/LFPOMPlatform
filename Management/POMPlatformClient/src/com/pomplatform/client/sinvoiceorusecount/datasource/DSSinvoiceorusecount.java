package com.pomplatform.client.sinvoiceorusecount.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSinvoiceorusecount extends DBDataSource
{


	public static DSSinvoiceorusecount instance = null;

	public static DSSinvoiceorusecount getInstance() {
		if(instance == null) {
			instance = new DSSinvoiceorusecount("DSSinvoiceorusecount");
		}
		return instance;
	}

	private final DataSourceTextField inNameField;
	private final DataSourceFloatField allSumField;
	private final DataSourceFloatField seventeenField;
	private final DataSourceFloatField sixField;
	private final DataSourceFloatField fiveField;
	private final DataSourceFloatField otherField;
	private final DataSourceFloatField reserveOneField;
	private final DataSourceFloatField reserveTwoField;
	private final DataSourceTextField reserveThreeField;

	public DSSinvoiceorusecount(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Sinvoiceorusecount");


		inNameField = new DataSourceTextField("inName", "类型名称");
		inNameField.setLength(-2);
		inNameField.setRequired(true);
		inNameField.setHidden(false);


		allSumField = new DataSourceFloatField("allSum", "合计");
		allSumField.setLength(16);
		allSumField.setDecimalPad(2);
		allSumField.setFormat("##,###,###,###,##0.00");
		allSumField.setRequired(true);
		allSumField.setHidden(false);


		seventeenField = new DataSourceFloatField("seventeen", "17%");
		seventeenField.setLength(16);
		seventeenField.setDecimalPad(2);
		seventeenField.setFormat("##,###,###,###,##0.00");
		seventeenField.setRequired(true);
		seventeenField.setHidden(false);


		sixField = new DataSourceFloatField("six", "6%");
		sixField.setLength(16);
		sixField.setDecimalPad(2);
		sixField.setFormat("##,###,###,###,##0.00");
		sixField.setRequired(true);
		sixField.setHidden(false);


		fiveField = new DataSourceFloatField("five", "5%");
		fiveField.setLength(16);
		fiveField.setDecimalPad(2);
		fiveField.setFormat("##,###,###,###,##0.00");
		fiveField.setRequired(true);
		fiveField.setHidden(false);


		otherField = new DataSourceFloatField("other", "其它");
		otherField.setLength(16);
		otherField.setDecimalPad(2);
		otherField.setFormat("##,###,###,###,##0.00");
		otherField.setRequired(true);
		otherField.setHidden(false);


		reserveOneField = new DataSourceFloatField("reserveOne", "备用");
		reserveOneField.setLength(16);
		reserveOneField.setDecimalPad(2);
		reserveOneField.setFormat("##,###,###,###,##0.00");
		reserveOneField.setRequired(true);
		reserveOneField.setHidden(true);


		reserveTwoField = new DataSourceFloatField("reserveTwo", "备用");
		reserveTwoField.setLength(16);
		reserveTwoField.setDecimalPad(2);
		reserveTwoField.setFormat("##,###,###,###,##0.00");
		reserveTwoField.setRequired(true);
		reserveTwoField.setHidden(true);


		reserveThreeField = new DataSourceTextField("reserveThree", "备用");
		reserveThreeField.setLength(-2);
		reserveThreeField.setRequired(true);
		reserveThreeField.setHidden(true);


		setFields(inNameField, allSumField, seventeenField, sixField, fiveField, otherField, reserveOneField, reserveTwoField, reserveThreeField);
	}


}

