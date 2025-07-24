package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseSubjectProcessType;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class SubjectProcessType extends AbstractTable<BaseSubjectProcessType>
{

	public SubjectProcessType() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 3;

		initTables();

		__tableName            = "subject_process_types";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseSubjectProcessType.CS_SUBJECT_PROCESS_TYPE_ID;
		__column_names[1] = BaseSubjectProcessType.CS_SUBJECT_TYPE_ID;
		__column_names[2] = BaseSubjectProcessType.CS_PROCESS_TYPE_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseSubjectProcessType b) {
		clear();
		setSubjectProcessTypeIdClear(b.getSubjectProcessTypeId());
	}

	public boolean isPrimaryKeyNull() {
		return getSubjectProcessTypeId() == null;
	}

	@Override
	public BaseSubjectProcessType generateBase(){
		BaseSubjectProcessType b = new BaseSubjectProcessType();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseSubjectProcessType b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setSubjectProcessTypeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSubjectTypeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProcessTypeId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseSubjectProcessType b, Object[] buff){
		int count = 0;
		buff[count++] = b.getSubjectProcessTypeId();
		buff[count++] = b.getSubjectTypeId();
		buff[count++] = b.getProcessTypeId();
	}

	@Override
	public void setDataFromBase(BaseSubjectProcessType b){
		if(b.getSubjectProcessTypeId() != null) setSubjectProcessTypeIdClear(b.getSubjectProcessTypeId());
		if(b.getSubjectTypeId() != null) setSubjectTypeId(b.getSubjectTypeId());
		if(b.getProcessTypeId() != null) setProcessTypeId(b.getProcessTypeId());
	}

	@Override
	public BaseSubjectProcessType generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseSubjectProcessType b = new BaseSubjectProcessType();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseSubjectProcessType __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSubjectProcessTypeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSubjectTypeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProcessTypeId(GenericBase.__getInt(val));
	}

	public void setSubjectProcessTypeId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getSubjectProcessTypeId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setSubjectProcessTypeIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setSubjectTypeId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getSubjectTypeId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setProcessTypeId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getProcessTypeId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setConditionSubjectProcessTypeId(String op, java.lang.Integer val) {
		setConditionSubjectProcessTypeId(op, val, CONDITION_AND);
	}

	public void setConditionSubjectProcessTypeId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectSubjectProcessTypeId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionSubjectTypeId(String op, java.lang.Integer val) {
		setConditionSubjectTypeId(op, val, CONDITION_AND);
	}

	public void setConditionSubjectTypeId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectSubjectTypeId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionProcessTypeId(String op, java.lang.Integer val) {
		setConditionProcessTypeId(op, val, CONDITION_AND);
	}

	public void setConditionProcessTypeId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectProcessTypeId(boolean val) {
		__select_flags[2] = val;
	}


}

