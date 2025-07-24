package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseEmployeeCheckinoutUpdatetime;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class EmployeeCheckinoutUpdatetime extends AbstractTable<BaseEmployeeCheckinoutUpdatetime>
{

	public EmployeeCheckinoutUpdatetime() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 5;

		initTables();

		__tableName            = "employee_checkinout_updatetime";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseEmployeeCheckinoutUpdatetime.CS_EMPLOYEE_CHECKINOUT_UPDATETIME_ID;
		__column_names[1] = BaseEmployeeCheckinoutUpdatetime.CS_UPDATE_TIME;
		__column_names[2] = BaseEmployeeCheckinoutUpdatetime.CS_OPERATE_EMPLOYEE_ID;
		__column_names[3] = BaseEmployeeCheckinoutUpdatetime.CS_OPERATE_TIME;
		__column_names[4] = BaseEmployeeCheckinoutUpdatetime.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseEmployeeCheckinoutUpdatetime b) {
		clear();
		setEmployeeCheckinoutUpdatetimeIdClear(b.getEmployeeCheckinoutUpdatetimeId());
	}

	public boolean isPrimaryKeyNull() {
		return getEmployeeCheckinoutUpdatetimeId() == null;
	}

	@Override
	public BaseEmployeeCheckinoutUpdatetime generateBase(){
		BaseEmployeeCheckinoutUpdatetime b = new BaseEmployeeCheckinoutUpdatetime();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseEmployeeCheckinoutUpdatetime b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setEmployeeCheckinoutUpdatetimeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setUpdateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseEmployeeCheckinoutUpdatetime b, Object[] buff){
		int count = 0;
		buff[count++] = b.getEmployeeCheckinoutUpdatetimeId();
		buff[count++] = generateTimestampFromDate(b.getUpdateTime());
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseEmployeeCheckinoutUpdatetime b){
		if(b.getEmployeeCheckinoutUpdatetimeId() != null) setEmployeeCheckinoutUpdatetimeIdClear(b.getEmployeeCheckinoutUpdatetimeId());
		if(b.getUpdateTime() != null) setUpdateTime(b.getUpdateTime());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseEmployeeCheckinoutUpdatetime generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseEmployeeCheckinoutUpdatetime b = new BaseEmployeeCheckinoutUpdatetime();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseEmployeeCheckinoutUpdatetime __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeCheckinoutUpdatetimeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUpdateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setEmployeeCheckinoutUpdatetimeId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getEmployeeCheckinoutUpdatetimeId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setEmployeeCheckinoutUpdatetimeIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setUpdateTime(java.util.Date val) {
		setCurrentData(1, generateTimestampFromDate(val));
	}

	public java.util.Date getUpdateTime() {
		return GenericBase.__getDateFromSQL(__current_data[1]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(3, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[3]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setConditionEmployeeCheckinoutUpdatetimeId(String op, java.lang.Integer val) {
		setConditionEmployeeCheckinoutUpdatetimeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeCheckinoutUpdatetimeId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectEmployeeCheckinoutUpdatetimeId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionUpdateTime(String op, java.util.Date val) {
		setConditionUpdateTime(op, val, CONDITION_AND);
	}

	public void setConditionUpdateTime(String op, java.util.Date val, String relation) {
		addCondition(1, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectUpdateTime(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(3, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[4] = val;
	}


}

