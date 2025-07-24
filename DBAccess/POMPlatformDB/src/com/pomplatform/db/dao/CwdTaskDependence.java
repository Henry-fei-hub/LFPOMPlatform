package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCwdTaskDependence;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CwdTaskDependence extends AbstractTable<BaseCwdTaskDependence>
{

	public CwdTaskDependence() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 5;

		initTables();

		__tableName            = "cwd_task_dependences";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCwdTaskDependence.CS_CWD_TASK_DEPENDENCE_ID;
		__column_names[1] = BaseCwdTaskDependence.CS_MAIN_PROJECT_ID;
		__column_names[2] = BaseCwdTaskDependence.CS_PREDECESSOR_TASK_MANAGE_ID;
		__column_names[3] = BaseCwdTaskDependence.CS_SUCCESSOR_TASK_MANAGE_ID;
		__column_names[4] = BaseCwdTaskDependence.CS_CREATE_TIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCwdTaskDependence b) {
		clear();
		setCwdTaskDependenceIdClear(b.getCwdTaskDependenceId());
	}

	public boolean isPrimaryKeyNull() {
		return getCwdTaskDependenceId() == null;
	}

	@Override
	public BaseCwdTaskDependence generateBase(){
		BaseCwdTaskDependence b = new BaseCwdTaskDependence();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCwdTaskDependence b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCwdTaskDependenceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMainProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPredecessorTaskManageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSuccessorTaskManageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BaseCwdTaskDependence b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCwdTaskDependenceId();
		buff[count++] = b.getMainProjectId();
		buff[count++] = b.getPredecessorTaskManageId();
		buff[count++] = b.getSuccessorTaskManageId();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
	}

	@Override
	public void setDataFromBase(BaseCwdTaskDependence b){
		if(b.getCwdTaskDependenceId() != null) setCwdTaskDependenceIdClear(b.getCwdTaskDependenceId());
		if(b.getMainProjectId() != null) setMainProjectId(b.getMainProjectId());
		if(b.getPredecessorTaskManageId() != null) setPredecessorTaskManageId(b.getPredecessorTaskManageId());
		if(b.getSuccessorTaskManageId() != null) setSuccessorTaskManageId(b.getSuccessorTaskManageId());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
	}

	@Override
	public BaseCwdTaskDependence generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCwdTaskDependence b = new BaseCwdTaskDependence();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCwdTaskDependence __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCwdTaskDependenceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMainProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPredecessorTaskManageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSuccessorTaskManageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	public void setCwdTaskDependenceId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCwdTaskDependenceId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCwdTaskDependenceIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setMainProjectId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getMainProjectId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setPredecessorTaskManageId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getPredecessorTaskManageId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setSuccessorTaskManageId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getSuccessorTaskManageId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setConditionCwdTaskDependenceId(String op, java.lang.Integer val) {
		setConditionCwdTaskDependenceId(op, val, CONDITION_AND);
	}

	public void setConditionCwdTaskDependenceId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCwdTaskDependenceId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionMainProjectId(String op, java.lang.Integer val) {
		setConditionMainProjectId(op, val, CONDITION_AND);
	}

	public void setConditionMainProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectMainProjectId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionPredecessorTaskManageId(String op, java.lang.Integer val) {
		setConditionPredecessorTaskManageId(op, val, CONDITION_AND);
	}

	public void setConditionPredecessorTaskManageId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectPredecessorTaskManageId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionSuccessorTaskManageId(String op, java.lang.Integer val) {
		setConditionSuccessorTaskManageId(op, val, CONDITION_AND);
	}

	public void setConditionSuccessorTaskManageId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectSuccessorTaskManageId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(4, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[4] = val;
	}


}

