package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseProjectLog;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ProjectLog extends AbstractTable<BaseProjectLog>
{

	public ProjectLog() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 13;

		initTables();

		__tableName            = "project_logs";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseProjectLog.CS_PROJECT_LOG_ID;
		__column_names[1] = BaseProjectLog.CS_PROJECT_ID;
		__column_names[2] = BaseProjectLog.CS_OPERATE_ID;
		__column_names[3] = BaseProjectLog.CS_DEPARTMENT_ID;
		__column_names[4] = BaseProjectLog.CS_MANAGER_ID;
		__column_names[5] = BaseProjectLog.CS_DESIGN_PHASE;
		__column_names[6] = BaseProjectLog.CS_OPERATE_TIME;
		__column_names[7] = BaseProjectLog.CS_LOG_TYPE;
		__column_names[8] = BaseProjectLog.CS_LOG_CONTENT;
		__column_names[9] = BaseProjectLog.CS_ALTERNATE_FIELD1;
		__column_names[10] = BaseProjectLog.CS_ALTERNATE_FIELD2;
		__column_names[11] = BaseProjectLog.CS_ALTERNATE_FIELD3;
		__column_names[12] = BaseProjectLog.CS_STATUS;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseProjectLog b) {
		clear();
		setProjectLogIdClear(b.getProjectLogId());
	}

	public boolean isPrimaryKeyNull() {
		return getProjectLogId() == null;
	}

	@Override
	public BaseProjectLog generateBase(){
		BaseProjectLog b = new BaseProjectLog();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseProjectLog b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setProjectLogId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDepartmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setManagerId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDesignPhase(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setLogType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setLogContent(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAlternateField1(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAlternateField2(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAlternateField3(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setStatus(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseProjectLog b, Object[] buff){
		int count = 0;
		buff[count++] = b.getProjectLogId();
		buff[count++] = b.getProjectId();
		buff[count++] = b.getOperateId();
		buff[count++] = b.getDepartmentId();
		buff[count++] = b.getManagerId();
		buff[count++] = b.getDesignPhase();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getLogType();
		buff[count++] = b.getLogContent();
		buff[count++] = b.getAlternateField1();
		buff[count++] = b.getAlternateField2();
		buff[count++] = b.getAlternateField3();
		buff[count++] = b.getStatus();
	}

	@Override
	public void setDataFromBase(BaseProjectLog b){
		if(b.getProjectLogId() != null) setProjectLogIdClear(b.getProjectLogId());
		if(b.getProjectId() != null) setProjectId(b.getProjectId());
		if(b.getOperateId() != null) setOperateId(b.getOperateId());
		if(b.getDepartmentId() != null) setDepartmentId(b.getDepartmentId());
		if(b.getManagerId() != null) setManagerId(b.getManagerId());
		if(b.getDesignPhase() != null) setDesignPhase(b.getDesignPhase());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getLogType() != null) setLogType(b.getLogType());
		if(b.getLogContent() != null) setLogContent(b.getLogContent());
		if(b.getAlternateField1() != null) setAlternateField1(b.getAlternateField1());
		if(b.getAlternateField2() != null) setAlternateField2(b.getAlternateField2());
		if(b.getAlternateField3() != null) setAlternateField3(b.getAlternateField3());
		if(b.getStatus() != null) setStatus(b.getStatus());
	}

	@Override
	public BaseProjectLog generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseProjectLog b = new BaseProjectLog();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseProjectLog __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectLogId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setManagerId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDesignPhase(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLogType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLogContent(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAlternateField1(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAlternateField2(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAlternateField3(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStatus(GenericBase.__getInt(val));
	}

	public void setProjectLogId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getProjectLogId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setProjectLogIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setProjectId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getProjectId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setOperateId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getOperateId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setDepartmentId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getDepartmentId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setManagerId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getManagerId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setDesignPhase(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getDesignPhase() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(6, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[6]);
	}

	public void setLogType(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getLogType() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setLogContent(java.lang.String val) {
		setCurrentData(8, val);
	}

	public java.lang.String getLogContent() {
		return GenericBase.__getString(__current_data[8]);
	}

	public void setAlternateField1(java.lang.String val) {
		setCurrentData(9, val);
	}

	public java.lang.String getAlternateField1() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setAlternateField2(java.lang.String val) {
		setCurrentData(10, val);
	}

	public java.lang.String getAlternateField2() {
		return GenericBase.__getString(__current_data[10]);
	}

	public void setAlternateField3(java.lang.String val) {
		setCurrentData(11, val);
	}

	public java.lang.String getAlternateField3() {
		return GenericBase.__getString(__current_data[11]);
	}

	public void setStatus(java.lang.Integer val) {
		setCurrentData(12, val);
	}

	public java.lang.Integer getStatus() {
		return GenericBase.__getInt(__current_data[12]);
	}

	public void setConditionProjectLogId(String op, java.lang.Integer val) {
		setConditionProjectLogId(op, val, CONDITION_AND);
	}

	public void setConditionProjectLogId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectProjectLogId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionProjectId(String op, java.lang.Integer val) {
		setConditionProjectId(op, val, CONDITION_AND);
	}

	public void setConditionProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectProjectId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionOperateId(String op, java.lang.Integer val) {
		setConditionOperateId(op, val, CONDITION_AND);
	}

	public void setConditionOperateId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectOperateId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val) {
		setConditionDepartmentId(op, val, CONDITION_AND);
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectDepartmentId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionManagerId(String op, java.lang.Integer val) {
		setConditionManagerId(op, val, CONDITION_AND);
	}

	public void setConditionManagerId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectManagerId(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionDesignPhase(String op, java.lang.Integer val) {
		setConditionDesignPhase(op, val, CONDITION_AND);
	}

	public void setConditionDesignPhase(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectDesignPhase(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(6, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionLogType(String op, java.lang.Integer val) {
		setConditionLogType(op, val, CONDITION_AND);
	}

	public void setConditionLogType(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectLogType(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionLogContent(String op, java.lang.String val) {
		setConditionLogContent(op, val, CONDITION_AND);
	}

	public void setConditionLogContent(String op, java.lang.String val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectLogContent(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionAlternateField1(String op, java.lang.String val) {
		setConditionAlternateField1(op, val, CONDITION_AND);
	}

	public void setConditionAlternateField1(String op, java.lang.String val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectAlternateField1(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionAlternateField2(String op, java.lang.String val) {
		setConditionAlternateField2(op, val, CONDITION_AND);
	}

	public void setConditionAlternateField2(String op, java.lang.String val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectAlternateField2(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionAlternateField3(String op, java.lang.String val) {
		setConditionAlternateField3(op, val, CONDITION_AND);
	}

	public void setConditionAlternateField3(String op, java.lang.String val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectAlternateField3(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionStatus(String op, java.lang.Integer val) {
		setConditionStatus(op, val, CONDITION_AND);
	}

	public void setConditionStatus(String op, java.lang.Integer val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectStatus(boolean val) {
		__select_flags[12] = val;
	}


}

