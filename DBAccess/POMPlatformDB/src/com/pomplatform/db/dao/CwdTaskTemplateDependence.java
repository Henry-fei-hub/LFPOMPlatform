package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCwdTaskTemplateDependence;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CwdTaskTemplateDependence extends AbstractTable<BaseCwdTaskTemplateDependence>
{

	public CwdTaskTemplateDependence() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 4;

		initTables();

		__tableName            = "cwd_task_template_dependences";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCwdTaskTemplateDependence.CS_CWD_TASK_TEMPLATE_DEPENDENCE_ID;
		__column_names[1] = BaseCwdTaskTemplateDependence.CS_CWD_TASK_TEMPLATE_ID;
		__column_names[2] = BaseCwdTaskTemplateDependence.CS_PREDECESSOR_TASK_ID;
		__column_names[3] = BaseCwdTaskTemplateDependence.CS_SUCCESSOR_TASK_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCwdTaskTemplateDependence b) {
		clear();
		setCwdTaskTemplateDependenceIdClear(b.getCwdTaskTemplateDependenceId());
	}

	public boolean isPrimaryKeyNull() {
		return getCwdTaskTemplateDependenceId() == null;
	}

	@Override
	public BaseCwdTaskTemplateDependence generateBase(){
		BaseCwdTaskTemplateDependence b = new BaseCwdTaskTemplateDependence();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCwdTaskTemplateDependence b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCwdTaskTemplateDependenceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCwdTaskTemplateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPredecessorTaskId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSuccessorTaskId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseCwdTaskTemplateDependence b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCwdTaskTemplateDependenceId();
		buff[count++] = b.getCwdTaskTemplateId();
		buff[count++] = b.getPredecessorTaskId();
		buff[count++] = b.getSuccessorTaskId();
	}

	@Override
	public void setDataFromBase(BaseCwdTaskTemplateDependence b){
		if(b.getCwdTaskTemplateDependenceId() != null) setCwdTaskTemplateDependenceIdClear(b.getCwdTaskTemplateDependenceId());
		if(b.getCwdTaskTemplateId() != null) setCwdTaskTemplateId(b.getCwdTaskTemplateId());
		if(b.getPredecessorTaskId() != null) setPredecessorTaskId(b.getPredecessorTaskId());
		if(b.getSuccessorTaskId() != null) setSuccessorTaskId(b.getSuccessorTaskId());
	}

	@Override
	public BaseCwdTaskTemplateDependence generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCwdTaskTemplateDependence b = new BaseCwdTaskTemplateDependence();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCwdTaskTemplateDependence __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCwdTaskTemplateDependenceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCwdTaskTemplateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPredecessorTaskId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSuccessorTaskId(GenericBase.__getInt(val));
	}

	public void setCwdTaskTemplateDependenceId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCwdTaskTemplateDependenceId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCwdTaskTemplateDependenceIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setCwdTaskTemplateId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getCwdTaskTemplateId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setPredecessorTaskId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getPredecessorTaskId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setSuccessorTaskId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getSuccessorTaskId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setConditionCwdTaskTemplateDependenceId(String op, java.lang.Integer val) {
		setConditionCwdTaskTemplateDependenceId(op, val, CONDITION_AND);
	}

	public void setConditionCwdTaskTemplateDependenceId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCwdTaskTemplateDependenceId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionCwdTaskTemplateId(String op, java.lang.Integer val) {
		setConditionCwdTaskTemplateId(op, val, CONDITION_AND);
	}

	public void setConditionCwdTaskTemplateId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectCwdTaskTemplateId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionPredecessorTaskId(String op, java.lang.Integer val) {
		setConditionPredecessorTaskId(op, val, CONDITION_AND);
	}

	public void setConditionPredecessorTaskId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectPredecessorTaskId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionSuccessorTaskId(String op, java.lang.Integer val) {
		setConditionSuccessorTaskId(op, val, CONDITION_AND);
	}

	public void setConditionSuccessorTaskId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectSuccessorTaskId(boolean val) {
		__select_flags[3] = val;
	}


}

