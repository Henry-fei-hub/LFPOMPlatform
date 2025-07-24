package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCmbcCode;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CmbcCode extends AbstractTable<BaseCmbcCode>
{

	public CmbcCode() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 5;

		initTables();

		__tableName            = "cmbc_codes";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCmbcCode.CS_CMBC_CODE_ID;
		__column_names[1] = BaseCmbcCode.CS_CODE_NAME;
		__column_names[2] = BaseCmbcCode.CS_CODE_ID;
		__column_names[3] = BaseCmbcCode.CS_CODE_VALUE;
		__column_names[4] = BaseCmbcCode.CS_CODE_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCmbcCode b) {
		clear();
		setCmbcCodeIdClear(b.getCmbcCodeId());
	}

	public boolean isPrimaryKeyNull() {
		return getCmbcCodeId() == null;
	}

	@Override
	public BaseCmbcCode generateBase(){
		BaseCmbcCode b = new BaseCmbcCode();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCmbcCode b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCmbcCodeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCodeName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCodeId(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCodeValue(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCodeRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseCmbcCode b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCmbcCodeId();
		buff[count++] = b.getCodeName();
		buff[count++] = b.getCodeId();
		buff[count++] = b.getCodeValue();
		buff[count++] = b.getCodeRemark();
	}

	@Override
	public void setDataFromBase(BaseCmbcCode b){
		if(b.getCmbcCodeId() != null) setCmbcCodeIdClear(b.getCmbcCodeId());
		if(b.getCodeName() != null) setCodeName(b.getCodeName());
		if(b.getCodeId() != null) setCodeId(b.getCodeId());
		if(b.getCodeValue() != null) setCodeValue(b.getCodeValue());
		if(b.getCodeRemark() != null) setCodeRemark(b.getCodeRemark());
	}

	@Override
	public BaseCmbcCode generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCmbcCode b = new BaseCmbcCode();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCmbcCode __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCmbcCodeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCodeName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCodeId(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCodeValue(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCodeRemark(GenericBase.__getString(val));
	}

	public void setCmbcCodeId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCmbcCodeId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCmbcCodeIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setCodeName(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getCodeName() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setCodeId(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getCodeId() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setCodeValue(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getCodeValue() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setCodeRemark(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getCodeRemark() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setConditionCmbcCodeId(String op, java.lang.Integer val) {
		setConditionCmbcCodeId(op, val, CONDITION_AND);
	}

	public void setConditionCmbcCodeId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCmbcCodeId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionCodeName(String op, java.lang.String val) {
		setConditionCodeName(op, val, CONDITION_AND);
	}

	public void setConditionCodeName(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectCodeName(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionCodeId(String op, java.lang.String val) {
		setConditionCodeId(op, val, CONDITION_AND);
	}

	public void setConditionCodeId(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectCodeId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionCodeValue(String op, java.lang.String val) {
		setConditionCodeValue(op, val, CONDITION_AND);
	}

	public void setConditionCodeValue(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectCodeValue(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionCodeRemark(String op, java.lang.String val) {
		setConditionCodeRemark(op, val, CONDITION_AND);
	}

	public void setConditionCodeRemark(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectCodeRemark(boolean val) {
		__select_flags[4] = val;
	}


}

