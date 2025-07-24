package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseSubjectType;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class SubjectType extends AbstractTable<BaseSubjectType>
{

	public SubjectType() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 4;

		initTables();

		__tableName            = "subject_types";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseSubjectType.CS_SUBJECT_TYPE_ID;
		__column_names[1] = BaseSubjectType.CS_PARENT_ID;
		__column_names[2] = BaseSubjectType.CS_SUBJECT_NAME;
		__column_names[3] = BaseSubjectType.CS_IS_ENABLED;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseSubjectType b) {
		clear();
		setSubjectTypeIdClear(b.getSubjectTypeId());
	}

	public boolean isPrimaryKeyNull() {
		return getSubjectTypeId() == null;
	}

	@Override
	public BaseSubjectType generateBase(){
		BaseSubjectType b = new BaseSubjectType();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseSubjectType b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setSubjectTypeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setParentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSubjectName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIsEnabled(GenericBase.__getBoolean(val));
	}

	@Override
	public void setBaseToBuffer(BaseSubjectType b, Object[] buff){
		int count = 0;
		buff[count++] = b.getSubjectTypeId();
		buff[count++] = b.getParentId();
		buff[count++] = b.getSubjectName();
		buff[count++] = b.getIsEnabled();
	}

	@Override
	public void setDataFromBase(BaseSubjectType b){
		if(b.getSubjectTypeId() != null) setSubjectTypeIdClear(b.getSubjectTypeId());
		if(b.getParentId() != null) setParentId(b.getParentId());
		if(b.getSubjectName() != null) setSubjectName(b.getSubjectName());
		if(b.getIsEnabled() != null) setIsEnabled(b.getIsEnabled());
	}

	@Override
	public BaseSubjectType generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseSubjectType b = new BaseSubjectType();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseSubjectType __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSubjectTypeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setParentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSubjectName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsEnabled(GenericBase.__getBoolean(val));
	}

	public void setSubjectTypeId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getSubjectTypeId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setSubjectTypeIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setParentId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getParentId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setSubjectName(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getSubjectName() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setIsEnabled(java.lang.Boolean val) {
		setCurrentData(3, val);
	}

	public java.lang.Boolean getIsEnabled() {
		return GenericBase.__getBoolean(__current_data[3]);
	}

	public void setConditionSubjectTypeId(String op, java.lang.Integer val) {
		setConditionSubjectTypeId(op, val, CONDITION_AND);
	}

	public void setConditionSubjectTypeId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectSubjectTypeId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionParentId(String op, java.lang.Integer val) {
		setConditionParentId(op, val, CONDITION_AND);
	}

	public void setConditionParentId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectParentId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionSubjectName(String op, java.lang.String val) {
		setConditionSubjectName(op, val, CONDITION_AND);
	}

	public void setConditionSubjectName(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectSubjectName(boolean val) {
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


}

