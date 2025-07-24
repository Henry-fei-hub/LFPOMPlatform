package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCompanyRecord;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CompanyRecord extends AbstractTable<BaseCompanyRecord>
{

	public CompanyRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 7;

		initTables();

		__tableName            = "company_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCompanyRecord.CS_COMPANY_RECORD_ID;
		__column_names[1] = BaseCompanyRecord.CS_COMPANY_NAME;
		__column_names[2] = BaseCompanyRecord.CS_COMPANY_CODE;
		__column_names[3] = BaseCompanyRecord.CS_IS_ENABLED;
		__column_names[4] = BaseCompanyRecord.CS_COMPANY_NO;
		__column_names[5] = BaseCompanyRecord.CS_PARENT_ID;
		__column_names[6] = BaseCompanyRecord.CS_COMPANY_NAME_SIMPLE;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCompanyRecord b) {
		clear();
		setCompanyRecordIdClear(b.getCompanyRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getCompanyRecordId() == null;
	}

	@Override
	public BaseCompanyRecord generateBase(){
		BaseCompanyRecord b = new BaseCompanyRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCompanyRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCompanyRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCompanyName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCompanyCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIsEnabled(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setCompanyNo(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setParentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCompanyNameSimple(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseCompanyRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCompanyRecordId();
		buff[count++] = b.getCompanyName();
		buff[count++] = b.getCompanyCode();
		buff[count++] = b.getIsEnabled();
		buff[count++] = b.getCompanyNo();
		buff[count++] = b.getParentId();
		buff[count++] = b.getCompanyNameSimple();
	}

	@Override
	public void setDataFromBase(BaseCompanyRecord b){
		if(b.getCompanyRecordId() != null) setCompanyRecordIdClear(b.getCompanyRecordId());
		if(b.getCompanyName() != null) setCompanyName(b.getCompanyName());
		if(b.getCompanyCode() != null) setCompanyCode(b.getCompanyCode());
		if(b.getIsEnabled() != null) setIsEnabled(b.getIsEnabled());
		if(b.getCompanyNo() != null) setCompanyNo(b.getCompanyNo());
		if(b.getParentId() != null) setParentId(b.getParentId());
		if(b.getCompanyNameSimple() != null) setCompanyNameSimple(b.getCompanyNameSimple());
	}

	@Override
	public BaseCompanyRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCompanyRecord b = new BaseCompanyRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCompanyRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsEnabled(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyNo(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setParentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyNameSimple(GenericBase.__getString(val));
	}

	public void setCompanyRecordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCompanyRecordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCompanyRecordIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setCompanyName(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getCompanyName() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setCompanyCode(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getCompanyCode() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setIsEnabled(java.lang.Boolean val) {
		setCurrentData(3, val);
	}

	public java.lang.Boolean getIsEnabled() {
		return GenericBase.__getBoolean(__current_data[3]);
	}

	public void setCompanyNo(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getCompanyNo() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setParentId(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getParentId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setCompanyNameSimple(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getCompanyNameSimple() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setConditionCompanyRecordId(String op, java.lang.Integer val) {
		setConditionCompanyRecordId(op, val, CONDITION_AND);
	}

	public void setConditionCompanyRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCompanyRecordId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionCompanyName(String op, java.lang.String val) {
		setConditionCompanyName(op, val, CONDITION_AND);
	}

	public void setConditionCompanyName(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectCompanyName(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionCompanyCode(String op, java.lang.String val) {
		setConditionCompanyCode(op, val, CONDITION_AND);
	}

	public void setConditionCompanyCode(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectCompanyCode(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionIsEnabled(String op, java.lang.Boolean val) {
		setConditionIsEnabled(op, val, CONDITION_AND);
	}

	public void setConditionIsEnabled(String op, java.lang.Boolean val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectIsEnabled(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionCompanyNo(String op, java.lang.String val) {
		setConditionCompanyNo(op, val, CONDITION_AND);
	}

	public void setConditionCompanyNo(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectCompanyNo(boolean val) {
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

	public void setConditionCompanyNameSimple(String op, java.lang.String val) {
		setConditionCompanyNameSimple(op, val, CONDITION_AND);
	}

	public void setConditionCompanyNameSimple(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectCompanyNameSimple(boolean val) {
		__select_flags[6] = val;
	}


}

