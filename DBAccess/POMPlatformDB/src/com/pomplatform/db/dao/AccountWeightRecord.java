package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseAccountWeightRecord;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class AccountWeightRecord extends AbstractTable<BaseAccountWeightRecord>
{

	public AccountWeightRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 10;

		initTables();

		__tableName            = "account_weight_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseAccountWeightRecord.CS_ACCOUNT_WEIGHT_RECORD_ID;
		__column_names[1] = BaseAccountWeightRecord.CS_TYPE_ID;
		__column_names[2] = BaseAccountWeightRecord.CS_TYPE_NAME;
		__column_names[3] = BaseAccountWeightRecord.CS_PERCENT;
		__column_names[4] = BaseAccountWeightRecord.CS_PERCENT_VIEW;
		__column_names[5] = BaseAccountWeightRecord.CS_PARENT_ID;
		__column_names[6] = BaseAccountWeightRecord.CS_LEVEL;
		__column_names[7] = BaseAccountWeightRecord.CS_SETTLEMENT_LEVEL;
		__column_names[8] = BaseAccountWeightRecord.CS_ORDER_FLAG;
		__column_names[9] = BaseAccountWeightRecord.CS_ENABLED;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
	}

	public void setPrimaryKeyFromBase(BaseAccountWeightRecord b) {
		clear();
		setAccountWeightRecordIdClear(b.getAccountWeightRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getAccountWeightRecordId() == null;
	}

	@Override
	public BaseAccountWeightRecord generateBase(){
		BaseAccountWeightRecord b = new BaseAccountWeightRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseAccountWeightRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setAccountWeightRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTypeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTypeName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPercent(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPercentView(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setParentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setLevel(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSettlementLevel(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOrderFlag(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEnabled(GenericBase.__getBoolean(val));
	}

	@Override
	public void setBaseToBuffer(BaseAccountWeightRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getAccountWeightRecordId();
		buff[count++] = b.getTypeId();
		buff[count++] = b.getTypeName();
		buff[count++] = b.getPercent();
		buff[count++] = b.getPercentView();
		buff[count++] = b.getParentId();
		buff[count++] = b.getLevel();
		buff[count++] = b.getSettlementLevel();
		buff[count++] = b.getOrderFlag();
		buff[count++] = b.getEnabled();
	}

	@Override
	public void setDataFromBase(BaseAccountWeightRecord b){
		if(b.getAccountWeightRecordId() != null) setAccountWeightRecordIdClear(b.getAccountWeightRecordId());
		if(b.getTypeId() != null) setTypeId(b.getTypeId());
		if(b.getTypeName() != null) setTypeName(b.getTypeName());
		if(b.getPercent() != null) setPercent(b.getPercent());
		if(b.getPercentView() != null) setPercentView(b.getPercentView());
		if(b.getParentId() != null) setParentId(b.getParentId());
		if(b.getLevel() != null) setLevel(b.getLevel());
		if(b.getSettlementLevel() != null) setSettlementLevel(b.getSettlementLevel());
		if(b.getOrderFlag() != null) setOrderFlag(b.getOrderFlag());
		if(b.getEnabled() != null) setEnabled(b.getEnabled());
	}

	@Override
	public BaseAccountWeightRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseAccountWeightRecord b = new BaseAccountWeightRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseAccountWeightRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAccountWeightRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTypeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTypeName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPercent(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPercentView(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setParentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLevel(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSettlementLevel(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOrderFlag(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEnabled(GenericBase.__getBoolean(val));
	}

	public void setAccountWeightRecordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getAccountWeightRecordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setAccountWeightRecordIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setTypeId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getTypeId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setTypeName(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getTypeName() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setPercent(java.math.BigDecimal val) {
		setCurrentData(3, val);
	}

	public java.math.BigDecimal getPercent() {
		return GenericBase.__getDecimal(__current_data[3]);
	}

	public void setPercentView(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getPercentView() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setParentId(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getParentId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setLevel(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getLevel() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setSettlementLevel(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getSettlementLevel() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setOrderFlag(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getOrderFlag() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setEnabled(java.lang.Boolean val) {
		setCurrentData(9, val);
	}

	public java.lang.Boolean getEnabled() {
		return GenericBase.__getBoolean(__current_data[9]);
	}

	public void setConditionAccountWeightRecordId(String op, java.lang.Integer val) {
		setConditionAccountWeightRecordId(op, val, CONDITION_AND);
	}

	public void setConditionAccountWeightRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectAccountWeightRecordId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionTypeId(String op, java.lang.Integer val) {
		setConditionTypeId(op, val, CONDITION_AND);
	}

	public void setConditionTypeId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectTypeId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionTypeName(String op, java.lang.String val) {
		setConditionTypeName(op, val, CONDITION_AND);
	}

	public void setConditionTypeName(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectTypeName(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionPercent(String op, java.math.BigDecimal val) {
		setConditionPercent(op, val, CONDITION_AND);
	}

	public void setConditionPercent(String op, java.math.BigDecimal val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectPercent(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionPercentView(String op, java.lang.String val) {
		setConditionPercentView(op, val, CONDITION_AND);
	}

	public void setConditionPercentView(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectPercentView(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionParentId(String op, java.lang.Integer val) {
		setConditionParentId(op, val, CONDITION_AND);
	}

	public void setConditionParentId(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectParentId(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionLevel(String op, java.lang.Integer val) {
		setConditionLevel(op, val, CONDITION_AND);
	}

	public void setConditionLevel(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectLevel(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionSettlementLevel(String op, java.lang.Integer val) {
		setConditionSettlementLevel(op, val, CONDITION_AND);
	}

	public void setConditionSettlementLevel(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectSettlementLevel(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionOrderFlag(String op, java.lang.Integer val) {
		setConditionOrderFlag(op, val, CONDITION_AND);
	}

	public void setConditionOrderFlag(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectOrderFlag(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionEnabled(String op, java.lang.Boolean val) {
		setConditionEnabled(op, val, CONDITION_AND);
	}

	public void setConditionEnabled(String op, java.lang.Boolean val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectEnabled(boolean val) {
		__select_flags[9] = val;
	}


}

