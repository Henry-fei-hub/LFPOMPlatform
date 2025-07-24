package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCwdTaskEvaluate;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CwdTaskEvaluate extends AbstractTable<BaseCwdTaskEvaluate>
{

	public CwdTaskEvaluate() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 7;

		initTables();

		__tableName            = "cwd_task_evaluates";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCwdTaskEvaluate.CS_CWD_TASK_EVALUATE_ID;
		__column_names[1] = BaseCwdTaskEvaluate.CS_CWD_TASK_PROCESS_ID;
		__column_names[2] = BaseCwdTaskEvaluate.CS_CWD_TASK_MANAGE_ID;
		__column_names[3] = BaseCwdTaskEvaluate.CS_EVALUATE_CONTENT;
		__column_names[4] = BaseCwdTaskEvaluate.CS_TASK_GRADE;
		__column_names[5] = BaseCwdTaskEvaluate.CS_OPERATOR_ID;
		__column_names[6] = BaseCwdTaskEvaluate.CS_CREATE_TIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCwdTaskEvaluate b) {
		clear();
		setCwdTaskEvaluateIdClear(b.getCwdTaskEvaluateId());
	}

	public boolean isPrimaryKeyNull() {
		return getCwdTaskEvaluateId() == null;
	}

	@Override
	public BaseCwdTaskEvaluate generateBase(){
		BaseCwdTaskEvaluate b = new BaseCwdTaskEvaluate();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCwdTaskEvaluate b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCwdTaskEvaluateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCwdTaskProcessId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCwdTaskManageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEvaluateContent(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTaskGrade(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperatorId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BaseCwdTaskEvaluate b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCwdTaskEvaluateId();
		buff[count++] = b.getCwdTaskProcessId();
		buff[count++] = b.getCwdTaskManageId();
		buff[count++] = b.getEvaluateContent();
		buff[count++] = b.getTaskGrade();
		buff[count++] = b.getOperatorId();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
	}

	@Override
	public void setDataFromBase(BaseCwdTaskEvaluate b){
		if(b.getCwdTaskEvaluateId() != null) setCwdTaskEvaluateIdClear(b.getCwdTaskEvaluateId());
		if(b.getCwdTaskProcessId() != null) setCwdTaskProcessId(b.getCwdTaskProcessId());
		if(b.getCwdTaskManageId() != null) setCwdTaskManageId(b.getCwdTaskManageId());
		if(b.getEvaluateContent() != null) setEvaluateContent(b.getEvaluateContent());
		if(b.getTaskGrade() != null) setTaskGrade(b.getTaskGrade());
		if(b.getOperatorId() != null) setOperatorId(b.getOperatorId());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
	}

	@Override
	public BaseCwdTaskEvaluate generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCwdTaskEvaluate b = new BaseCwdTaskEvaluate();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCwdTaskEvaluate __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCwdTaskEvaluateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCwdTaskProcessId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCwdTaskManageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEvaluateContent(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTaskGrade(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperatorId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	public void setCwdTaskEvaluateId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCwdTaskEvaluateId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCwdTaskEvaluateIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setCwdTaskProcessId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getCwdTaskProcessId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setCwdTaskManageId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getCwdTaskManageId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setEvaluateContent(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getEvaluateContent() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setTaskGrade(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getTaskGrade() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setOperatorId(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getOperatorId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(6, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[6]);
	}

	public void setConditionCwdTaskEvaluateId(String op, java.lang.Integer val) {
		setConditionCwdTaskEvaluateId(op, val, CONDITION_AND);
	}

	public void setConditionCwdTaskEvaluateId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCwdTaskEvaluateId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionCwdTaskProcessId(String op, java.lang.Integer val) {
		setConditionCwdTaskProcessId(op, val, CONDITION_AND);
	}

	public void setConditionCwdTaskProcessId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectCwdTaskProcessId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionCwdTaskManageId(String op, java.lang.Integer val) {
		setConditionCwdTaskManageId(op, val, CONDITION_AND);
	}

	public void setConditionCwdTaskManageId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectCwdTaskManageId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionEvaluateContent(String op, java.lang.String val) {
		setConditionEvaluateContent(op, val, CONDITION_AND);
	}

	public void setConditionEvaluateContent(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectEvaluateContent(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionTaskGrade(String op, java.lang.Integer val) {
		setConditionTaskGrade(op, val, CONDITION_AND);
	}

	public void setConditionTaskGrade(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectTaskGrade(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionOperatorId(String op, java.lang.Integer val) {
		setConditionOperatorId(op, val, CONDITION_AND);
	}

	public void setConditionOperatorId(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectOperatorId(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(6, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[6] = val;
	}


}

