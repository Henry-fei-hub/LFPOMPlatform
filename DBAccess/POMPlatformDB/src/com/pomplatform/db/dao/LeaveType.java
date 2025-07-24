package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseLeaveType;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class LeaveType extends AbstractTable<BaseLeaveType>
{

	public LeaveType() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 5;

		initTables();

		__tableName            = "leave_types";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseLeaveType.CS_LEAVE_TYPE_ID;
		__column_names[1] = BaseLeaveType.CS_LEAVE_TYPE_NAME;
		__column_names[2] = BaseLeaveType.CS_GENDER;
		__column_names[3] = BaseLeaveType.CS_PARENT_ID;
		__column_names[4] = BaseLeaveType.CS_IS_ENABLE;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseLeaveType b) {
		clear();
		setLeaveTypeIdClear(b.getLeaveTypeId());
	}

	public boolean isPrimaryKeyNull() {
		return getLeaveTypeId() == null;
	}

	@Override
	public BaseLeaveType generateBase(){
		BaseLeaveType b = new BaseLeaveType();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseLeaveType b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setLeaveTypeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setLeaveTypeName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setGender(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setParentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIsEnable(GenericBase.__getBoolean(val));
	}

	@Override
	public void setBaseToBuffer(BaseLeaveType b, Object[] buff){
		int count = 0;
		buff[count++] = b.getLeaveTypeId();
		buff[count++] = b.getLeaveTypeName();
		buff[count++] = b.getGender();
		buff[count++] = b.getParentId();
		buff[count++] = b.getIsEnable();
	}

	@Override
	public void setDataFromBase(BaseLeaveType b){
		if(b.getLeaveTypeId() != null) setLeaveTypeIdClear(b.getLeaveTypeId());
		if(b.getLeaveTypeName() != null) setLeaveTypeName(b.getLeaveTypeName());
		if(b.getGender() != null) setGender(b.getGender());
		if(b.getParentId() != null) setParentId(b.getParentId());
		if(b.getIsEnable() != null) setIsEnable(b.getIsEnable());
	}

	@Override
	public BaseLeaveType generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseLeaveType b = new BaseLeaveType();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseLeaveType __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLeaveTypeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLeaveTypeName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setGender(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setParentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsEnable(GenericBase.__getBoolean(val));
	}

	public void setLeaveTypeId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getLeaveTypeId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setLeaveTypeIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setLeaveTypeName(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getLeaveTypeName() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setGender(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getGender() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setParentId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getParentId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setIsEnable(java.lang.Boolean val) {
		setCurrentData(4, val);
	}

	public java.lang.Boolean getIsEnable() {
		return GenericBase.__getBoolean(__current_data[4]);
	}

	public void setConditionLeaveTypeId(String op, java.lang.Integer val) {
		setConditionLeaveTypeId(op, val, CONDITION_AND);
	}

	public void setConditionLeaveTypeId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectLeaveTypeId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionLeaveTypeName(String op, java.lang.String val) {
		setConditionLeaveTypeName(op, val, CONDITION_AND);
	}

	public void setConditionLeaveTypeName(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectLeaveTypeName(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionGender(String op, java.lang.Integer val) {
		setConditionGender(op, val, CONDITION_AND);
	}

	public void setConditionGender(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectGender(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionParentId(String op, java.lang.Integer val) {
		setConditionParentId(op, val, CONDITION_AND);
	}

	public void setConditionParentId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectParentId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionIsEnable(String op, java.lang.Boolean val) {
		setConditionIsEnable(op, val, CONDITION_AND);
	}

	public void setConditionIsEnable(String op, java.lang.Boolean val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectIsEnable(boolean val) {
		__select_flags[4] = val;
	}


}

