package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseThreadTaskManage;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ThreadTaskManage extends AbstractTable<BaseThreadTaskManage>
{

	public ThreadTaskManage() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 10;

		initTables();

		__tableName            = "thread_task_manages";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseThreadTaskManage.CS_THREAD_TASK_MANAGE_ID;
		__column_names[1] = BaseThreadTaskManage.CS_TASK_TYPE;
		__column_names[2] = BaseThreadTaskManage.CS_STATUS;
		__column_names[3] = BaseThreadTaskManage.CS_ERROR_MSG;
		__column_names[4] = BaseThreadTaskManage.CS_OPERATOR;
		__column_names[5] = BaseThreadTaskManage.CS_OPERATION_TYPE;
		__column_names[6] = BaseThreadTaskManage.CS_BEGIN_TIME;
		__column_names[7] = BaseThreadTaskManage.CS_END_TIME;
		__column_names[8] = BaseThreadTaskManage.CS_CREATE_TIME;
		__column_names[9] = BaseThreadTaskManage.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseThreadTaskManage b) {
		clear();
		setThreadTaskManageIdClear(b.getThreadTaskManageId());
	}

	public boolean isPrimaryKeyNull() {
		return getThreadTaskManageId() == null;
	}

	@Override
	public BaseThreadTaskManage generateBase(){
		BaseThreadTaskManage b = new BaseThreadTaskManage();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseThreadTaskManage b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setThreadTaskManageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTaskType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setErrorMsg(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOperator(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperationType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBeginTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setEndTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseThreadTaskManage b, Object[] buff){
		int count = 0;
		buff[count++] = b.getThreadTaskManageId();
		buff[count++] = b.getTaskType();
		buff[count++] = b.getStatus();
		buff[count++] = b.getErrorMsg();
		buff[count++] = b.getOperator();
		buff[count++] = b.getOperationType();
		buff[count++] = generateTimestampFromDate(b.getBeginTime());
		buff[count++] = generateTimestampFromDate(b.getEndTime());
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseThreadTaskManage b){
		if(b.getThreadTaskManageId() != null) setThreadTaskManageIdClear(b.getThreadTaskManageId());
		if(b.getTaskType() != null) setTaskType(b.getTaskType());
		if(b.getStatus() != null) setStatus(b.getStatus());
		if(b.getErrorMsg() != null) setErrorMsg(b.getErrorMsg());
		if(b.getOperator() != null) setOperator(b.getOperator());
		if(b.getOperationType() != null) setOperationType(b.getOperationType());
		if(b.getBeginTime() != null) setBeginTime(b.getBeginTime());
		if(b.getEndTime() != null) setEndTime(b.getEndTime());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseThreadTaskManage generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseThreadTaskManage b = new BaseThreadTaskManage();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseThreadTaskManage __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setThreadTaskManageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTaskType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setErrorMsg(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperator(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperationType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBeginTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEndTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setThreadTaskManageId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getThreadTaskManageId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setThreadTaskManageIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setTaskType(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getTaskType() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setStatus(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getStatus() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setErrorMsg(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getErrorMsg() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setOperator(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getOperator() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setOperationType(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getOperationType() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setBeginTime(java.util.Date val) {
		setCurrentData(6, generateTimestampFromDate(val));
	}

	public java.util.Date getBeginTime() {
		return GenericBase.__getDateFromSQL(__current_data[6]);
	}

	public void setEndTime(java.util.Date val) {
		setCurrentData(7, generateTimestampFromDate(val));
	}

	public java.util.Date getEndTime() {
		return GenericBase.__getDateFromSQL(__current_data[7]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(8, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[8]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(9, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setConditionThreadTaskManageId(String op, java.lang.Integer val) {
		setConditionThreadTaskManageId(op, val, CONDITION_AND);
	}

	public void setConditionThreadTaskManageId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectThreadTaskManageId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionTaskType(String op, java.lang.Integer val) {
		setConditionTaskType(op, val, CONDITION_AND);
	}

	public void setConditionTaskType(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectTaskType(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionStatus(String op, java.lang.Integer val) {
		setConditionStatus(op, val, CONDITION_AND);
	}

	public void setConditionStatus(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectStatus(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionErrorMsg(String op, java.lang.String val) {
		setConditionErrorMsg(op, val, CONDITION_AND);
	}

	public void setConditionErrorMsg(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectErrorMsg(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionOperator(String op, java.lang.Integer val) {
		setConditionOperator(op, val, CONDITION_AND);
	}

	public void setConditionOperator(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectOperator(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionOperationType(String op, java.lang.Integer val) {
		setConditionOperationType(op, val, CONDITION_AND);
	}

	public void setConditionOperationType(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectOperationType(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionBeginTime(String op, java.util.Date val) {
		setConditionBeginTime(op, val, CONDITION_AND);
	}

	public void setConditionBeginTime(String op, java.util.Date val, String relation) {
		addCondition(6, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectBeginTime(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionEndTime(String op, java.util.Date val) {
		setConditionEndTime(op, val, CONDITION_AND);
	}

	public void setConditionEndTime(String op, java.util.Date val, String relation) {
		addCondition(7, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectEndTime(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(8, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[9] = val;
	}


}

