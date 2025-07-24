package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCapitalsToInvoice;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CapitalsToInvoice extends AbstractTable<BaseCapitalsToInvoice>
{

	public CapitalsToInvoice() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 7;

		initTables();

		__tableName            = "capitals_to_invoices";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCapitalsToInvoice.CS_CAPITALS_TO_INVOICE_ID;
		__column_names[1] = BaseCapitalsToInvoice.CS_INVOICE_ID;
		__column_names[2] = BaseCapitalsToInvoice.CS_CAPITAL_ID;
		__column_names[3] = BaseCapitalsToInvoice.CS_OPERATOR;
		__column_names[4] = BaseCapitalsToInvoice.CS_CREATE_DATE;
		__column_names[5] = BaseCapitalsToInvoice.CS_STAGE_PERCENTAGE;
		__column_names[6] = BaseCapitalsToInvoice.CS_STAGE_SUM_MONEY;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCapitalsToInvoice b) {
		clear();
		setCapitalsToInvoiceIdClear(b.getCapitalsToInvoiceId());
	}

	public boolean isPrimaryKeyNull() {
		return getCapitalsToInvoiceId() == null;
	}

	@Override
	public BaseCapitalsToInvoice generateBase(){
		BaseCapitalsToInvoice b = new BaseCapitalsToInvoice();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCapitalsToInvoice b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCapitalsToInvoiceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setInvoiceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCapitalId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperator(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setStagePercentage(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setStageSumMoney(GenericBase.__getDecimal(val));
	}

	@Override
	public void setBaseToBuffer(BaseCapitalsToInvoice b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCapitalsToInvoiceId();
		buff[count++] = b.getInvoiceId();
		buff[count++] = b.getCapitalId();
		buff[count++] = b.getOperator();
		buff[count++] = generateTimestampFromDate(b.getCreateDate());
		buff[count++] = b.getStagePercentage();
		buff[count++] = b.getStageSumMoney();
	}

	@Override
	public void setDataFromBase(BaseCapitalsToInvoice b){
		if(b.getCapitalsToInvoiceId() != null) setCapitalsToInvoiceIdClear(b.getCapitalsToInvoiceId());
		if(b.getInvoiceId() != null) setInvoiceId(b.getInvoiceId());
		if(b.getCapitalId() != null) setCapitalId(b.getCapitalId());
		if(b.getOperator() != null) setOperator(b.getOperator());
		if(b.getCreateDate() != null) setCreateDate(b.getCreateDate());
		if(b.getStagePercentage() != null) setStagePercentage(b.getStagePercentage());
		if(b.getStageSumMoney() != null) setStageSumMoney(b.getStageSumMoney());
	}

	@Override
	public BaseCapitalsToInvoice generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCapitalsToInvoice b = new BaseCapitalsToInvoice();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCapitalsToInvoice __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCapitalsToInvoiceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInvoiceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCapitalId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperator(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStagePercentage(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStageSumMoney(GenericBase.__getDecimal(val));
	}

	public void setCapitalsToInvoiceId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCapitalsToInvoiceId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCapitalsToInvoiceIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setInvoiceId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getInvoiceId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setCapitalId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getCapitalId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setOperator(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getOperator() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setCreateDate(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateDate() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setStagePercentage(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getStagePercentage() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setStageSumMoney(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getStageSumMoney() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setConditionCapitalsToInvoiceId(String op, java.lang.Integer val) {
		setConditionCapitalsToInvoiceId(op, val, CONDITION_AND);
	}

	public void setConditionCapitalsToInvoiceId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCapitalsToInvoiceId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionInvoiceId(String op, java.lang.Integer val) {
		setConditionInvoiceId(op, val, CONDITION_AND);
	}

	public void setConditionInvoiceId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectInvoiceId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionCapitalId(String op, java.lang.Integer val) {
		setConditionCapitalId(op, val, CONDITION_AND);
	}

	public void setConditionCapitalId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectCapitalId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionOperator(String op, java.lang.Integer val) {
		setConditionOperator(op, val, CONDITION_AND);
	}

	public void setConditionOperator(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectOperator(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionCreateDate(String op, java.util.Date val) {
		setConditionCreateDate(op, val, CONDITION_AND);
	}

	public void setConditionCreateDate(String op, java.util.Date val, String relation) {
		addCondition(4, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateDate(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionStagePercentage(String op, java.math.BigDecimal val) {
		setConditionStagePercentage(op, val, CONDITION_AND);
	}

	public void setConditionStagePercentage(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectStagePercentage(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionStageSumMoney(String op, java.math.BigDecimal val) {
		setConditionStageSumMoney(op, val, CONDITION_AND);
	}

	public void setConditionStageSumMoney(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectStageSumMoney(boolean val) {
		__select_flags[6] = val;
	}


}

