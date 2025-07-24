package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCwdRecentWorkedProject;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CwdRecentWorkedProject extends AbstractTable<BaseCwdRecentWorkedProject>
{

	public CwdRecentWorkedProject() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 7;

		initTables();

		__tableName            = "cwd_recent_worked_projects";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCwdRecentWorkedProject.CS_CWD_RECENT_WORKED_PROJECT_ID;
		__column_names[1] = BaseCwdRecentWorkedProject.CS_EMPLOYEE_ID;
		__column_names[2] = BaseCwdRecentWorkedProject.CS_MAIN_PROJECT_ID;
		__column_names[3] = BaseCwdRecentWorkedProject.CS_COMPANY_ID;
		__column_names[4] = BaseCwdRecentWorkedProject.CS_COMPANY_NO;
		__column_names[5] = BaseCwdRecentWorkedProject.CS_WORK_TIME;
		__column_names[6] = BaseCwdRecentWorkedProject.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCwdRecentWorkedProject b) {
		clear();
		setCwdRecentWorkedProjectIdClear(b.getCwdRecentWorkedProjectId());
	}

	public boolean isPrimaryKeyNull() {
		return getCwdRecentWorkedProjectId() == null;
	}

	@Override
	public BaseCwdRecentWorkedProject generateBase(){
		BaseCwdRecentWorkedProject b = new BaseCwdRecentWorkedProject();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCwdRecentWorkedProject b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCwdRecentWorkedProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMainProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCompanyId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCompanyNo(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setWorkTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseCwdRecentWorkedProject b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCwdRecentWorkedProjectId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getMainProjectId();
		buff[count++] = b.getCompanyId();
		buff[count++] = b.getCompanyNo();
		buff[count++] = generateTimestampFromDate(b.getWorkTime());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseCwdRecentWorkedProject b){
		if(b.getCwdRecentWorkedProjectId() != null) setCwdRecentWorkedProjectIdClear(b.getCwdRecentWorkedProjectId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getMainProjectId() != null) setMainProjectId(b.getMainProjectId());
		if(b.getCompanyId() != null) setCompanyId(b.getCompanyId());
		if(b.getCompanyNo() != null) setCompanyNo(b.getCompanyNo());
		if(b.getWorkTime() != null) setWorkTime(b.getWorkTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseCwdRecentWorkedProject generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCwdRecentWorkedProject b = new BaseCwdRecentWorkedProject();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCwdRecentWorkedProject __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCwdRecentWorkedProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMainProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyNo(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWorkTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setCwdRecentWorkedProjectId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCwdRecentWorkedProjectId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCwdRecentWorkedProjectIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setMainProjectId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getMainProjectId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setCompanyId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getCompanyId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setCompanyNo(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getCompanyNo() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setWorkTime(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getWorkTime() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setConditionCwdRecentWorkedProjectId(String op, java.lang.Integer val) {
		setConditionCwdRecentWorkedProjectId(op, val, CONDITION_AND);
	}

	public void setConditionCwdRecentWorkedProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCwdRecentWorkedProjectId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val) {
		setConditionEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectEmployeeId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionMainProjectId(String op, java.lang.Integer val) {
		setConditionMainProjectId(op, val, CONDITION_AND);
	}

	public void setConditionMainProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectMainProjectId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionCompanyId(String op, java.lang.Integer val) {
		setConditionCompanyId(op, val, CONDITION_AND);
	}

	public void setConditionCompanyId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectCompanyId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionCompanyNo(String op, java.lang.String val) {
		setConditionCompanyNo(op, val, CONDITION_AND);
	}

	public void setConditionCompanyNo(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectCompanyNo(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionWorkTime(String op, java.util.Date val) {
		setConditionWorkTime(op, val, CONDITION_AND);
	}

	public void setConditionWorkTime(String op, java.util.Date val, String relation) {
		addCondition(5, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectWorkTime(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[6] = val;
	}


}

